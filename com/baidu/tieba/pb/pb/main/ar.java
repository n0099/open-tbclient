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
import com.baidu.tbadk.core.view.g;
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
    private com.baidu.tbadk.editortools.i IT;
    private View aJb;
    private com.baidu.tieba.pb.a.c aVF;
    private g.b amU;
    private TextView axT;
    private View.OnClickListener cIA;
    private View cIM;
    private PbListView cLS;
    private View cgT;
    private NoNetworkView csW;
    private RelativeLayout csY;
    private TextView cuS;
    private View.OnClickListener ePR;
    PbActivity.d eTr;
    private PbActivity eUm;
    private UserIconBox eVq;
    private UserIconBox eVr;
    private PbFakeFloorModel eWe;
    private com.baidu.tieba.pb.data.f eXh;
    private int esU;
    private com.baidu.tieba.pb.video.i faA;
    private long faB;
    private com.baidu.tieba.pb.video.h faC;
    private com.baidu.tieba.d.b faD;
    public final com.baidu.tieba.pb.pb.main.view.c faG;
    public com.baidu.tieba.pb.pb.main.view.b faH;
    private ViewStub faI;
    private ViewStub faJ;
    private PbLandscapeListView faK;
    private List<com.baidu.tieba.pb.pb.main.view.a> faL;
    private View faM;
    private LinearLayout faP;
    private f faQ;
    private ColumnLayout faR;
    private ThreadSkinView faS;
    private TextView faT;
    private TextView faU;
    private ImageView faV;
    private HeadPendantView faW;
    private FrameLayout faX;
    private HeadImageView faY;
    private View faZ;
    public int faz;
    private View fbA;
    private View fbV;
    private TextView fbW;
    private ImageView fbX;
    private ImageView fbY;
    private TextView fbZ;
    private FloatingLayout fba;
    private PbFirstFloorUserLikeButton fbf;
    private ap fbg;
    private ap fbh;
    private TextView fbi;
    private TextView fbj;
    private TextView fbk;
    private View fbl;
    private View fbm;
    private LinearLayout fbn;
    private TextView fbo;
    private TextView fbp;
    private View fbq;
    private View fbr;
    private ObservedChangeLinearLayout fbt;
    private h fbu;
    private int fcC;
    private Runnable fcD;
    private s fcE;
    private am fcF;
    private int fcL;
    private PopupWindow fcN;
    private PopupWindow fcO;
    private TextView fcP;
    private List<String> fcQ;
    private com.baidu.tieba.pb.pb.main.emotion.c fcR;
    private com.baidu.tieba.pb.pb.godreply.a fcS;
    private PbLandscapeListView.b fcT;
    private boolean fcW;
    private e fcX;
    private com.baidu.tbadk.core.view.userLike.c fcY;
    private com.baidu.tbadk.core.view.userLike.c fcZ;
    private boolean fcb;
    private int fcc;
    private int fcd;
    private PostData fce;
    private View fcg;
    private TextView fch;
    private ViewStub fci;
    private PbInterviewStatusView fcj;
    private ViewGroup fck;
    private TextView fcl;
    private FrameLayout fcm;
    private View fcn;
    private View fco;
    private ak fcp;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fcu;
    private Runnable fde;
    private PbActivity.b fdg;
    private boolean isLandscape;
    private int mType;
    private static final int fcq = UtilHelper.getLightStatusBarHeight();
    public static int fcw = 3;
    public static int fcx = 0;
    public static int fcy = 3;
    public static int fcz = 4;
    public static int fcA = 5;
    public static int fcB = 6;
    private boolean faE = false;
    private int faF = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout faN = null;
    private TextView faO = null;
    private TextView fbb = null;
    private TextView fbc = null;
    public FrsPraiseView fbd = null;
    private ClickableHeaderImageView fbe = null;
    private View fbs = null;
    private com.baidu.tbadk.core.dialog.a fbv = null;
    private com.baidu.tbadk.core.dialog.b cIz = null;
    private View fbw = null;
    private EditText fbx = null;
    private com.baidu.tieba.pb.view.i fby = null;
    private com.baidu.tieba.pb.view.b fbz = null;
    private com.baidu.tbadk.core.dialog.a fbB = null;
    private b.InterfaceC0047b dNs = null;
    private TbRichTextView.f aVE = null;
    private NoNetworkView.a cFo = null;
    private Dialog fbC = null;
    private View fbD = null;
    private com.baidu.tbadk.core.dialog.a fbE = null;
    private Dialog fbF = null;
    private Dialog fbG = null;
    private View fbH = null;
    private LinearLayout fbI = null;
    private CompoundButton.OnCheckedChangeListener fbJ = null;
    private TextView fbK = null;
    private TextView fbL = null;
    private View fbM = null;
    private String fbN = null;
    private com.baidu.tbadk.core.dialog.b fbO = null;
    private com.baidu.tbadk.core.dialog.b fbP = null;
    private boolean fbQ = false;
    private boolean fbR = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fbS = null;
    private boolean fbT = false;
    private Button fbU = null;
    private boolean fca = true;
    private com.baidu.tbadk.core.view.a cjW = null;
    private boolean ePN = false;
    private int mSkinType = 3;
    private boolean fcf = false;
    private int fcr = 0;
    private boolean fcs = true;
    private a fct = new a();
    private int fcv = 0;
    private boolean fcG = false;
    private int fcH = 0;
    private boolean fcI = false;
    private boolean fcJ = false;
    private boolean fcK = false;
    private int fcM = 0;
    private boolean fcU = false;
    private a.InterfaceC0126a fcV = new a.InterfaceC0126a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0126a
        public void kW() {
        }
    };
    private String fda = null;
    private CustomMessageListener fdb = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fda = null;
            }
        }
    };
    private CustomMessageListener cWV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fbu != null) {
                ar.this.fbu.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fdc = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.faO != null) {
                ar.this.faO.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fdd = new Handler();
    private CustomMessageListener fdf = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fca = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fdh = true;
    View.OnClickListener fdi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fcI) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == ar.this.faG.ffL) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (ar.this.eUm.eSr.feR != null) {
                if (!ar.this.fcI && ar.this.eXh != null && ar.this.eXh.aRh() != null && ar.this.eXh.aRh().rx() != null && ar.this.eXh.aRh().rx().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                ar.this.eUm.eSr.feR.onClick(view);
            }
        }
    };
    private boolean fdj = false;
    String userId = null;
    private final List<TbImageView> fdk = new ArrayList();
    private boolean fdl = false;

    public void jJ(boolean z) {
        this.fcG = z;
        if (this.faK != null) {
            this.fcH = this.faK.getHeaderViewsCount();
        }
    }

    public void aVz() {
        if (this.faK != null) {
            int headerViewsCount = this.faK.getHeaderViewsCount() - this.fcH;
            final int firstVisiblePosition = (this.faK.getFirstVisiblePosition() == 0 || this.faK.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.faK.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.faK.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fct.fdA = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fct));
            final ak akVar = this.fct.fdA;
            final int f = f(akVar);
            final int y = ((int) this.fbt.getY()) + this.fbt.getMeasuredHeight();
            final boolean z = this.fcn.getVisibility() == 0;
            boolean z2 = this.fbt.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fbu.aTL() + this.faK.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.eZX.getMeasuredHeight() : 0;
                if (z2) {
                    this.faK.setSelectionFromTop(this.fbu.aTL() + this.faK.getHeaderViewsCount(), fcq - measuredHeight);
                } else {
                    this.faK.setSelectionFromTop(this.fbu.aTL() + this.faK.getHeaderViewsCount(), this.faG.aXb().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.faK.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fcI) {
                this.faK.setSelectionFromTop(this.fbu.aTL() + this.faK.getHeaderViewsCount(), this.faA.aYs().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.faK.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aUa() {
                        if (f >= 0 && f <= ar.this.csY.getMeasuredHeight()) {
                            int f2 = ar.this.f(akVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.cgT.getLayoutParams();
                            if (i == 0 || i > ar.this.csY.getMeasuredHeight() || f2 >= ar.this.csY.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fcC;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.csY.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fcC;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.faK.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.cgT.setLayoutParams(layoutParams);
                        }
                        ar.this.faK.setOnLayoutListener(null);
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

    public e aVA() {
        return this.fcX;
    }

    public NoNetworkView aVB() {
        return this.csW;
    }

    public void aVC() {
        if (this.IT != null) {
            this.IT.hide();
            if (this.fcR != null) {
                this.fcR.Od();
            }
        }
    }

    public PbFakeFloorModel aVD() {
        return this.eWe;
    }

    public s aVE() {
        return this.fcE;
    }

    public void aVF() {
        reset();
        aVC();
        this.fcE.aTS();
        jV(false);
    }

    private void reset() {
        if (this.eUm != null && this.eUm.aSD() != null && this.IT != null) {
            com.baidu.tbadk.editortools.pb.a.Dy().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aSD = this.eUm.aSD();
            aSD.DR();
            aSD.Dn();
            if (aSD.getWriteImagesInfo() != null) {
                aSD.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aSD.eV(SendView.ALL);
            aSD.eW(SendView.ALL);
            com.baidu.tbadk.editortools.l eN = this.IT.eN(23);
            com.baidu.tbadk.editortools.l eN2 = this.IT.eN(2);
            com.baidu.tbadk.editortools.l eN3 = this.IT.eN(5);
            if (eN2 != null) {
                eN2.lE();
            }
            if (eN3 != null) {
                eN3.lE();
            }
            if (eN != null) {
                eN.hide();
            }
            this.IT.invalidate();
        }
    }

    public boolean aVG() {
        return this.fca;
    }

    public void jK(boolean z) {
        if (this.fbV != null && this.fbW != null) {
            this.fbW.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fbV.startAnimation(alphaAnimation);
            }
            this.fbV.setVisibility(0);
            this.fca = true;
            if (this.fcu != null && !this.fcS.isActive()) {
                this.fcu.setVisibility(0);
                jP(true);
            }
        }
    }

    public void jL(boolean z) {
        if (this.fbV != null && this.fbW != null) {
            this.fbW.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fbV.startAnimation(alphaAnimation);
            }
            this.fbV.setVisibility(0);
            this.fca = true;
            if (this.fcu != null && !this.fcS.isActive()) {
                this.fcu.setVisibility(0);
                jP(true);
            }
        }
    }

    public PostData aVH() {
        int i = 0;
        if (this.faK == null) {
            return null;
        }
        int aVI = aVI() - this.faK.getHeaderViewsCount();
        if (aVI < 0) {
            aVI = 0;
        }
        if (this.fbu.pO(aVI) != null && this.fbu.pO(aVI) != PostData.gze) {
            i = aVI + 1;
        }
        return this.fbu.getItem(i) instanceof PostData ? (PostData) this.fbu.getItem(i) : null;
    }

    public int aVI() {
        int i;
        View childAt;
        if (this.faK == null) {
            return 0;
        }
        int firstVisiblePosition = this.faK.getFirstVisiblePosition();
        int lastVisiblePosition = this.faK.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.faK.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.faK.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aVJ() {
        return this.faK.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.eXh != null && this.eXh.aRj() != null && !this.eXh.aRj().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.eXh.aRj().size() && (postData = this.eXh.aRj().get(i)) != null && postData.rx() != null && !StringUtils.isNull(postData.rx().getUserId()); i++) {
                if (this.eXh.aRj().get(i).rx().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fcS != null && this.fcS.isActive()) {
                        jV(false);
                    }
                    if (this.fcu != null) {
                        this.fcu.kc(true);
                    }
                    this.fda = postData.rx().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eUm = null;
        this.csY = null;
        this.cIM = null;
        this.faB = 0L;
        this.faK = null;
        this.faM = null;
        this.faP = null;
        this.faR = null;
        this.faT = null;
        this.faU = null;
        this.faX = null;
        this.faY = null;
        this.faZ = null;
        this.fbf = null;
        this.fbi = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = null;
        this.fbq = null;
        this.fbr = null;
        this.fbu = null;
        this.cLS = null;
        this.aJb = null;
        this.cIA = null;
        this.ePR = null;
        this.fbV = null;
        this.fbW = null;
        this.fbX = null;
        this.fbY = null;
        this.fbZ = null;
        this.fcg = null;
        this.fch = null;
        this.fci = null;
        this.fcL = 0;
        this.faB = System.currentTimeMillis();
        this.eUm = pbActivity;
        this.cIA = onClickListener;
        this.aVF = cVar;
        this.fcL = com.baidu.adp.lib.util.l.ac(this.eUm) / 2;
        this.csY = (RelativeLayout) LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.eUm.addContentView(this.csY, new FrameLayout.LayoutParams(-1, -1));
        this.cIM = this.eUm.findViewById(d.g.statebar_view);
        this.fbt = (ObservedChangeLinearLayout) this.eUm.findViewById(d.g.title_wrapper);
        this.csW = (NoNetworkView) this.eUm.findViewById(d.g.view_no_network);
        this.faK = (PbLandscapeListView) this.eUm.findViewById(d.g.new_pb_list);
        this.fcm = (FrameLayout) this.eUm.findViewById(d.g.root_float_header);
        this.axT = new TextView(this.eUm.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds88));
        this.faK.addHeaderView(this.axT, 0);
        this.fcC = this.eUm.getResources().getDimensionPixelSize(d.e.ds100);
        this.cgT = new View(this.eUm.getPageContext().getPageActivity());
        this.cgT.setLayoutParams(new AbsListView.LayoutParams(-1, this.fcC));
        this.cgT.setVisibility(4);
        this.faK.addFooterView(this.cgT);
        this.faK.setOnTouchListener(this.eUm.aNj);
        this.faG = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eUm.aTg()) {
            this.faI = (ViewStub) this.eUm.findViewById(d.g.manga_view_stub);
            this.faI.setVisibility(0);
            this.faH = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.faH.show();
            this.faG.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds120);
        }
        this.axT.setLayoutParams(layoutParams);
        this.faG.aXb().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0111a() { // from class: com.baidu.tieba.pb.pb.main.ar.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0111a
            public void amh() {
                if (ar.this.faK != null) {
                    if (ar.this.faA != null) {
                        ar.this.faA.aYt();
                    }
                    ar.this.faK.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0111a
            public void amg() {
                ar.this.eUm.alt();
            }
        }));
        this.fbV = this.eUm.findViewById(d.g.pb_editor_tool_comment);
        this.fcc = com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds90);
        this.fcd = com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds242);
        this.fbW = (TextView) this.eUm.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fbY = (ImageView) this.eUm.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fbX = (ImageView) this.eUm.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fbZ = (TextView) this.eUm.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fbZ.setVisibility(8);
        this.fbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWK();
                if (!ar.this.eUm.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, ar.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d aSD = ar.this.eUm.aSD();
                if (aSD == null || (!aSD.DO() && !aSD.DP())) {
                    if (ar.this.IT != null) {
                        ar.this.aVT();
                    }
                    if (ar.this.IT != null) {
                        ar.this.fca = false;
                        if (ar.this.IT.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eUm, (View) ar.this.IT.eP(2).aBO, false, ar.this.fcV);
                        }
                    }
                    ar.this.aWv();
                    return;
                }
                ar.this.eUm.aSD().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWK();
                if (ar.this.eUm.checkUpIsLogin()) {
                    if (ar.this.IT != null) {
                        ar.this.aVT();
                        ar.this.IT.L((View) ar.this.IT.eN(5));
                    }
                    if (ar.this.IT != null) {
                        ar.this.fca = false;
                        if (ar.this.IT.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eUm, (View) ar.this.IT.eP(2).aBO, false, ar.this.fcV);
                        }
                    }
                    ar.this.aWv();
                }
            }
        });
        this.fbY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWK();
                if (ar.this.eUm.checkUpIsLogin()) {
                    if (ar.this.IT != null) {
                        ar.this.aVT();
                        ar.this.IT.L((View) ar.this.IT.eN(2));
                    }
                    if (ar.this.IT != null) {
                        ar.this.fca = false;
                        if (ar.this.IT.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eUm, (View) ar.this.IT.eP(2).aBO, false, ar.this.fcV);
                        }
                    }
                    ar.this.aWv();
                }
            }
        });
        this.fbZ.setOnClickListener(this.cIA);
        this.fbZ.setOnTouchListener(this.eUm);
        this.faM = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.faP = (LinearLayout) LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.faQ = new f(this.eUm, this.faP);
        this.faQ.init();
        this.faQ.a(this.faQ.aSC(), this.cIA);
        this.faR = (ColumnLayout) this.faP.findViewById(d.g.pb_head_owner_root);
        this.faS = (ThreadSkinView) this.faP.findViewById(d.g.pb_thread_skin);
        this.faR.setOnLongClickListener(this.onLongClickListener);
        this.faR.setOnTouchListener(this.aVF);
        this.faR.setVisibility(8);
        this.faM.setOnTouchListener(this.aVF);
        this.fcg = this.faM.findViewById(d.g.pb_head_activity_join_number_container);
        this.fcg.setVisibility(8);
        this.fch = (TextView) this.faM.findViewById(d.g.pb_head_activity_join_number);
        this.faT = (TextView) this.faR.findViewById(d.g.pb_head_owner_info_user_name);
        this.faU = (TextView) this.faR.findViewById(d.g.floor_owner);
        this.faV = (ImageView) this.faR.findViewById(d.g.icon_forum_level);
        this.faX = (FrameLayout) this.faR.findViewById(d.g.pb_head_headImage_container);
        this.faY = (HeadImageView) this.faR.findViewById(d.g.pb_head_owner_photo);
        this.faW = (HeadPendantView) this.faR.findViewById(d.g.pb_pendant_head_owner_photo);
        this.faW.wk();
        if (this.faW.getHeadView() != null) {
            this.faW.getHeadView().setIsRound(true);
            this.faW.getHeadView().setDrawBorder(false);
        }
        this.eVq = (UserIconBox) this.faR.findViewById(d.g.show_icon_vip);
        this.eVr = (UserIconBox) this.faR.findViewById(d.g.show_icon_yinji);
        this.fba = (FloatingLayout) this.faP.findViewById(d.g.pb_head_owner_info_root);
        this.fbf = (PbFirstFloorUserLikeButton) this.faR.findViewById(d.g.pb_like_button);
        this.fbi = (TextView) this.faR.findViewById(d.g.pb_views);
        this.cuS = (TextView) this.faR.findViewById(d.g.view_forum_name);
        this.fbm = this.faR.findViewById(d.g.line_right_forum_name);
        this.fbj = (TextView) this.faR.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fbk = (TextView) this.faR.findViewById(d.g.pb_item_first_floor_location_address);
        this.fbl = this.faR.findViewById(d.g.line_between_time_and_locate);
        this.fcY = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fcZ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fbq = this.faM.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fbr = this.faM.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.faM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fci = (ViewStub) this.csY.findViewById(d.g.interview_status_stub);
        this.fbu = new h(this.eUm, this.faK);
        this.fbu.q(this.cIA);
        this.fbu.setTbGestureDetector(this.aVF);
        this.fbu.setOnImageClickListener(this.aVE);
        this.ePR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.abo() || !com.baidu.tieba.c.a.a(ar.this.eUm.getBaseContext(), ar.this.eUm.aSo().aUe(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ar.this.eUm.c(sparseArray);
                                return;
                            }
                            ar.this.bi(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ar.this.eUm.c(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fbu.D(this.ePR);
        aVO();
        this.faK.addHeaderView(this.faN);
        this.faK.addHeaderView(this.faP);
        this.faK.addHeaderView(this.faM);
        this.cLS = new PbListView(this.eUm.getPageContext().getPageActivity());
        this.aJb = this.cLS.getView().findViewById(d.g.pb_more_view);
        if (this.aJb != null) {
            this.aJb.setOnClickListener(this.cIA);
            com.baidu.tbadk.core.util.aj.j(this.aJb, d.f.pb_foot_more_trans_selector);
        }
        this.cLS.wt();
        this.cLS.dw(d.f.pb_foot_more_trans_selector);
        this.cLS.dy(d.f.pb_foot_more_trans_selector);
        this.fbA = this.eUm.findViewById(d.g.viewstub_progress);
        this.eUm.registerListener(this.fdf);
        this.faZ = com.baidu.tbadk.ala.b.ny().g(this.eUm.getActivity(), 2);
        if (this.faZ != null) {
            this.faZ.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.eUm.getResources().getDimensionPixelSize(d.e.ds10);
            this.fba.addView(this.faZ, aVar);
        }
        this.eWe = new PbFakeFloorModel(this.eUm.getPageContext());
        this.fcE = new s(this.eUm.getPageContext(), this.eWe, this.csY);
        this.fcE.a(this.eUm.eTn);
        this.eWe.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.eWe.m(postData);
                ar.this.fbu.notifyDataSetChanged();
                ar.this.fcE.aTS();
                ar.this.IT.Bm();
                ar.this.jV(false);
            }
        });
        if (this.eUm.aSo() != null && !StringUtils.isNull(this.eUm.aSo().aUK())) {
            this.eUm.showToast(this.eUm.aSo().aUK());
        }
        this.fcn = this.eUm.findViewById(d.g.pb_expand_blank_view);
        this.fco = this.eUm.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fco.getLayoutParams();
        if (this.eUm.aSo() != null && this.eUm.aSo().aUh()) {
            this.fcn.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fco.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fcq;
            this.fco.setLayoutParams(layoutParams2);
        }
        this.fcp = new ak(this.eUm.getPageContext(), this.eUm.findViewById(d.g.pb_reply_expand_view));
        this.fcp.eZX.setVisibility(8);
        this.fcp.F(this.cIA);
        this.eUm.registerListener(this.cWV);
        this.eUm.registerListener(this.fdb);
        this.eUm.registerListener(this.fdc);
        aVK();
        jP(false);
    }

    private void aVK() {
        this.fcS = new com.baidu.tieba.pb.pb.godreply.a(this.eUm, this, (ViewStub) this.csY.findViewById(d.g.more_god_reply_popup));
        this.fcS.setCommonClickListener(this.cIA);
        this.fcS.D(this.ePR);
        this.fcS.setOnImageClickListener(this.aVE);
        this.fcS.setCommonClickListener(this.cIA);
        this.fcS.setTbGestureDetector(this.aVF);
    }

    public com.baidu.tieba.pb.pb.godreply.a aVL() {
        return this.fcS;
    }

    public View aVM() {
        return this.fcn;
    }

    public void aVN() {
        if (this.faK != null) {
            this.faK.removeHeaderView(this.faN);
            this.faK.removeHeaderView(this.faP);
            this.faK.removeHeaderView(this.faM);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fcu == null) {
            this.fcu = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.eUm.getPageContext().getPageActivity());
            jP(true);
            this.fcu.a(this.csY, aVar, this.fbV.getVisibility() == 0);
            this.fcu.setOnEmotionClickListener(new a.InterfaceC0116a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0116a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ar.this.fda)) {
                        emotionImageData.setAuthorNameShow(ar.this.fda);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0116a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.eUm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(ar.this.eUm.getPageContext().getPageActivity(), 25016, str, list, ar.this.fda, list2)));
                }
            });
            this.fcu.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    ar.this.aWK();
                    if (ar.this.fbV != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fbV.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fcd - ar.this.fcc) * f) + ar.this.fcc);
                        ar.this.fbW.setAlpha(1.0f - f);
                        ar.this.fbY.setAlpha(1.0f - f);
                        ar.this.fbX.setAlpha(1.0f - f);
                        ar.this.fbV.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aVO() {
        if (this.faN == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.tbds44);
            this.faN = new LinearLayout(this.eUm.getPageContext().getPageActivity());
            this.faN.setOrientation(1);
            this.faN.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.faN.setPadding(f, com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.tbds30), f, com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.tbds40));
            this.faN.setGravity(17);
            this.faO = new TextView(this.eUm.getPageContext().getPageActivity());
            this.faO.setGravity(3);
            this.faO.setMaxLines(2);
            this.faO.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_link_tip_c));
            this.faO.setPadding(0, 0, 0, 0);
            this.faO.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.faO, d.C0082d.cp_cont_b);
            this.faO.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.faO.setVisibility(8);
            this.faN.addView(this.faO);
            this.faN.setOnTouchListener(this.aVF);
            this.faN.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVP() {
        if (this.eUm.aTg()) {
            this.faJ = (ViewStub) this.eUm.findViewById(d.g.manga_mention_controller_view_stub);
            this.faJ.setVisibility(0);
            if (this.fbn == null) {
                this.fbn = (LinearLayout) this.eUm.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.eUm.getPageContext(), this.fbn);
            }
            if (this.fbo == null) {
                this.fbo = (TextView) this.fbn.findViewById(d.g.manga_prev_btn);
            }
            if (this.fbp == null) {
                this.fbp = (TextView) this.fbn.findViewById(d.g.manga_next_btn);
            }
            this.fbo.setOnClickListener(this.cIA);
            this.fbp.setOnClickListener(this.cIA);
        }
    }

    private void aVQ() {
        if (this.eUm.aTg()) {
            if (this.eUm.aTj() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.fbo, d.C0082d.cp_cont_e, 1);
            }
            if (this.eUm.aTk() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.fbp, d.C0082d.cp_cont_e, 1);
            }
        }
    }

    public void aVR() {
        if (this.fbn == null) {
            aVP();
        }
        this.faJ.setVisibility(8);
        if (this.fdd != null && this.fde != null) {
            this.fdd.removeCallbacks(this.fde);
        }
    }

    public void aVS() {
        if (this.fdd != null) {
            if (this.fde != null) {
                this.fdd.removeCallbacks(this.fde);
            }
            this.fde = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fbn == null) {
                        ar.this.aVP();
                    }
                    ar.this.faJ.setVisibility(0);
                }
            };
            this.fdd.postDelayed(this.fde, 2000L);
        }
    }

    public void jM(boolean z) {
        this.faG.jM(z);
        if (z && this.fcf) {
            this.cLS.setText(this.eUm.getResources().getString(d.j.click_load_more));
            this.faK.setNextPage(this.cLS);
            this.faF = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.IT = iVar;
        this.IT.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.csY.addView(this.IT, layoutParams);
        this.IT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aVC();
        this.eUm.aSD().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.IT != null && ar.this.IT.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fcR == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.IT.getId());
                            ar.this.fcR = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.eUm.getPageContext(), ar.this.csY, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.w(ar.this.fcQ)) {
                                ar.this.fcR.setData(ar.this.fcQ);
                            }
                            ar.this.fcR.b(ar.this.IT);
                        }
                        ar.this.fcR.qa(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.eUm.eSv != null && ar.this.eUm.eSv.aWN() != null) {
                    if (!ar.this.eUm.eSv.aWN().bEV()) {
                        ar.this.eUm.eSv.jZ(false);
                    }
                    ar.this.eUm.eSv.aWN().nT(false);
                }
            }
        });
    }

    public void aVT() {
        if (this.eUm != null && this.IT != null) {
            this.IT.lE();
            aWv();
        }
    }

    public void Q(String str, boolean z) {
        this.fcb = z;
        jN(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void jN(boolean z) {
        if (this.fbZ != null) {
            if (this.fcb) {
                com.baidu.tbadk.core.util.aj.j(this.fbZ, d.f.pb_praise_already_click_selector);
                this.fbZ.setContentDescription(this.eUm.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.fbZ, d.f.pb_praise_normal_click_selector);
            this.fbZ.setContentDescription(this.eUm.getResources().getString(d.j.zan));
        }
    }

    public TextView aVU() {
        return this.fbZ;
    }

    public void jO(boolean z) {
        if (this.faK != null && this.axT != null && this.cIM != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cIM.setVisibility(0);
                } else {
                    this.cIM.setVisibility(8);
                    this.faK.removeHeaderView(this.axT);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axT.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fcq;
                    this.axT.setLayoutParams(layoutParams);
                }
                aWj();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axT.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jX(true);
                this.axT.setLayoutParams(layoutParams2);
            }
            aWj();
            aWF();
        }
    }

    public h aVV() {
        return this.fbu;
    }

    public void a(PbActivity.d dVar) {
        this.eTr = dVar;
    }

    public void bi(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fbD == null) {
            this.fbD = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eUm.getLayoutMode().t(this.fbD);
        if (this.fbC == null) {
            this.fbC = new Dialog(this.eUm.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fbC.setCanceledOnTouchOutside(true);
            this.fbC.setCancelable(true);
            this.fbC.setContentView(this.fbD);
            WindowManager.LayoutParams attributes = this.fbC.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ac(this.eUm.getPageContext().getPageActivity()) * 0.9d);
            this.fbC.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fbC.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fbC.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fbC.findViewById(d.g.disable_reply_btn);
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
                    if (ar.this.fbC != null && (ar.this.fbC instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fbC, ar.this.eUm.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || aWC()) {
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
                    if (ar.this.fbC != null && (ar.this.fbC instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fbC, ar.this.eUm.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fdg != null) {
                        ar.this.fdg.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (ar.this.fbC != null && (ar.this.fbC instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fbC, ar.this.eUm.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.eUm.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fbC, this.eUm.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fdg = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fcx, Integer.valueOf(fcy));
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
        this.fbE = new com.baidu.tbadk.core.dialog.a(this.eUm.getActivity());
        this.fbE.cd(i3);
        this.fbE.z(sparseArray);
        this.fbE.a(d.j.dialog_ok, this.eUm);
        this.fbE.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fbE.ao(true);
        this.fbE.b(this.eUm.getPageContext());
        this.fbE.tk();
    }

    public void ak(ArrayList<com.baidu.tbadk.core.data.z> arrayList) {
        if (this.fbH == null) {
            this.fbH = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.eUm.getLayoutMode().t(this.fbH);
        if (this.fbG == null) {
            this.fbG = new Dialog(this.eUm.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fbG.setCanceledOnTouchOutside(true);
            this.fbG.setCancelable(true);
            this.fbS = (ScrollView) this.fbH.findViewById(d.g.good_scroll);
            this.fbG.setContentView(this.fbH);
            WindowManager.LayoutParams attributes = this.fbG.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds540);
            this.fbG.getWindow().setAttributes(attributes);
            this.fbJ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fbN = (String) compoundButton.getTag();
                        if (ar.this.faL != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ar.this.faL) {
                                String str = (String) aVar.getTag();
                                if (str != null && ar.this.fbN != null && !str.equals(ar.this.fbN)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fbI = (LinearLayout) this.fbH.findViewById(d.g.good_class_group);
            this.fbL = (TextView) this.fbH.findViewById(d.g.dialog_button_cancel);
            this.fbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fbG instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fbG, ar.this.eUm.getPageContext());
                    }
                }
            });
            this.fbK = (TextView) this.fbH.findViewById(d.g.dialog_button_ok);
            this.fbK.setOnClickListener(this.cIA);
        }
        this.fbI.removeAllViews();
        this.faL = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.eUm.getPageContext().getString(d.j.def_good_class));
        this.faL.add(bI);
        bI.setChecked(true);
        this.fbI.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bI2 = bI(String.valueOf(arrayList.get(i2).pY()), arrayList.get(i2).pX());
                this.faL.add(bI2);
                View view = new View(this.eUm.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.C0082d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.fbI.addView(view);
                this.fbI.addView(bI2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fbS.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eUm.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eUm.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eUm.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fbS.setLayoutParams(layoutParams2);
            this.fbS.removeAllViews();
            this.fbS.addView(this.fbI);
        }
        com.baidu.adp.lib.g.g.a(this.fbG, this.eUm.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.eUm.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.fbJ);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aVW() {
        this.eUm.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eUm.hideProgressBar();
        if (z && z2) {
            this.eUm.showToast(this.eUm.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.eUm.showToast(str);
        }
    }

    public void aBn() {
        this.fbA.setVisibility(0);
    }

    public void aBm() {
        this.fbA.setVisibility(8);
    }

    public View aVX() {
        if (this.fbH != null) {
            return this.fbH.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String aVY() {
        return this.fbN;
    }

    public View getView() {
        return this.csY;
    }

    public void aVZ() {
        com.baidu.adp.lib.util.l.a(this.eUm.getPageContext().getPageActivity(), this.eUm.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.eUm.hideProgressBar();
        if (z) {
            aWo();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            aWp();
        } else {
            aWo();
        }
    }

    public void aWa() {
        this.cLS.wt();
        this.cLS.wx();
    }

    public void aWb() {
        this.eUm.hideProgressBar();
        wy();
        this.faK.completePullRefreshPostDelayed(2000L);
        aWl();
    }

    public void aWc() {
        this.faK.completePullRefreshPostDelayed(2000L);
        aWl();
    }

    private void jP(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fbW.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eUm.getResources().getDimensionPixelSize(d.e.ds130) : this.eUm.getResources().getDimensionPixelSize(d.e.ds34);
        this.fbW.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fbu.setOnLongClickListener(onLongClickListener);
        if (this.fcS != null) {
            this.fcS.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z, boolean z2) {
        if (this.fbO != null) {
            this.fbO.dismiss();
            this.fbO = null;
        }
        this.fbO = new com.baidu.tbadk.core.dialog.b(this.eUm.getPageContext().getPageActivity());
        this.fbO.cg(d.j.operation);
        if (z2) {
            this.fbO.a(new String[]{this.eUm.getPageContext().getString(d.j.copy)}, interfaceC0047b);
        } else if (!z) {
            this.fbO.a(new String[]{this.eUm.getPageContext().getString(d.j.copy), this.eUm.getPageContext().getString(d.j.mark)}, interfaceC0047b);
        } else {
            this.fbO.a(new String[]{this.eUm.getPageContext().getString(d.j.copy), this.eUm.getPageContext().getString(d.j.remove_mark)}, interfaceC0047b);
        }
        this.fbO.d(this.eUm.getPageContext());
        this.fbO.to();
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z) {
        if (this.fbP != null) {
            this.fbP.dismiss();
            this.fbP = null;
        }
        this.fbP = new com.baidu.tbadk.core.dialog.b(this.eUm.getPageContext().getPageActivity());
        this.fbP.cg(d.j.operation);
        if (z) {
            this.fbP.a(new String[]{this.eUm.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0047b);
        } else {
            this.fbP.a(new String[]{this.eUm.getPageContext().getString(d.j.save_to_emotion), this.eUm.getPageContext().getString(d.j.save_to_local)}, interfaceC0047b);
        }
        this.fbP.d(this.eUm.getPageContext());
        this.fbP.to();
    }

    public int aWd() {
        return qe(this.faK.getFirstVisiblePosition());
    }

    private int qe(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.faK.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.faK.getAdapter() == null || !(this.faK.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.faK.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aWe() {
        int lastVisiblePosition = this.faK.getLastVisiblePosition();
        if (this.faA != null) {
            if (lastVisiblePosition == this.faK.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qe(lastVisiblePosition);
    }

    public void qf(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.faK != null) {
            if (this.faG == null || this.faG.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.faG.mNavigationBar.getFixedNavHeight();
                if (this.eUm.aSS() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fco != null && (layoutParams = (LinearLayout.LayoutParams) this.fco.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fco.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.faK.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.faK.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fbx.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        this.fbu.a(fVar, false);
        this.fbu.notifyDataSetChanged();
        aWl();
        if (this.fcS != null) {
            this.fcS.aSk();
        }
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (this.fbd == null) {
            this.eUm.getLayoutMode().t(((ViewStub) this.faM.findViewById(d.g.praise_layout)).inflate());
            this.fbd = (FrsPraiseView) this.faM.findViewById(d.g.pb_head_praise_view);
            this.fbd.setIsFromPb(true);
            this.fbs = this.faM.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fbd.dE(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fbd != null) {
            boolean aWl = aWl();
            this.fbd.setVisibility(8);
            if (fVar != null && fVar.qA() != null && fVar.qA().qx() == 0 && this.ePN) {
                if (aWl) {
                    this.fbr.setVisibility(0);
                    return;
                } else {
                    this.fbr.setVisibility(8);
                    return;
                }
            }
            this.fbr.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aRq() != null) {
            return fVar.aRq();
        }
        if (!com.baidu.tbadk.core.util.v.w(fVar.aRj())) {
            Iterator<PostData> it = fVar.aRj().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwo() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aRo();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.rx() != null && postData.rx().getUserTbVipInfoData() != null && postData.rx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.rx().getGodUserData().setIntro(postData.rx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aRh() == null || fVar.aRh().rx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rx = fVar.aRh().rx();
        String userId = rx.getUserId();
        HashMap<String, MetaData> userMap = fVar.aRh().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rx;
        }
        postData.ul(1);
        postData.setId(fVar.aRh().rO());
        postData.setTitle(fVar.aRh().getTitle());
        postData.setTime(fVar.aRh().getCreateTime());
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
    /* JADX WARN: Removed duplicated region for block: B:182:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0769  */
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
        com.baidu.tbadk.data.i bws;
        String portrait;
        if (fVar != null && fVar.aRh() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aWD();
            this.faR.setVisibility(8);
            if (fVar.aRh() != null && fVar.aRh().sk() && fVar.aRh().rP() != null) {
                this.fcI = true;
                this.faG.kj(this.fcI);
                this.faG.mNavigationBar.hideBottomLine();
                if (this.faA == null) {
                    this.faA = new com.baidu.tieba.pb.video.i(this.eUm, this.faG, fVar.aRh().rP(), this.faB);
                    this.faA.a(fVar.aRh().rP(), fVar.aRh(), fVar.getForumId());
                    this.faA.startPlay();
                } else if (this.faE) {
                    this.faA.a(fVar.aRh().rP(), fVar.aRh(), fVar.getForumId());
                    this.faA.startPlay();
                } else {
                    this.faA.qm(fVar.getForumId());
                }
                if (fVar.aRi() != null && fVar.aRi().size() >= 1) {
                    bd bdVar = fVar.aRi().get(0);
                    this.faA.ad(bdVar);
                    this.faA.qn(bdVar.getTitle());
                }
                this.faA.b(b, fVar.aRh(), fVar.aRD());
                this.faE = false;
                this.faK.removeHeaderView(this.faA.aYu());
                this.faK.addHeaderView(this.faA.aYu(), 0);
                if (this.faA.aYs() != null && this.faA.aYs().getParent() == null) {
                    this.fcm.addView(this.faA.aYs());
                }
                if (this.faC == null) {
                    this.faC = new com.baidu.tieba.pb.video.h(this.eUm);
                }
                this.faC.a(fVar.aRh().sC(), fVar.aRh(), fVar.aRA());
                this.faK.removeHeaderView(this.faC.aYj());
                this.faK.addHeaderView(this.faC.aYj(), 1);
                if (fVar.aRh().sC() != null) {
                    this.faK.removeHeaderView(this.faC.aYk());
                    this.faK.removeHeaderView(this.faP);
                    this.faK.addHeaderView(this.faC.aYk(), 2);
                } else {
                    if (this.faC.aYk() != null) {
                        this.faK.removeHeaderView(this.faC.aYk());
                    }
                    this.faK.removeHeaderView(this.faP);
                    this.faP.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.eUm, d.e.tbds56));
                    this.faK.addHeaderView(this.faP, 2);
                }
                if (this.faA != null) {
                    this.faG.kf(false);
                    this.faG.kg(TbadkCoreApplication.isLogin());
                    this.faA.qm(TbadkCoreApplication.getInst().getSkinType());
                }
                aWj();
            } else {
                this.fcI = false;
                this.faG.kj(this.fcI);
                if (this.faA != null) {
                    this.faK.removeHeaderView(this.faA.aYu());
                }
                if (this.faC != null) {
                    this.faC.f(this.faK);
                }
                if (b == null || (b != null && (b.bwr() == null || com.baidu.tbadk.core.util.v.w(b.bwr().Jq())))) {
                    this.faP.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.eUm, d.e.tbds80));
                }
            }
            if (this.eUm.aSH() != null) {
                this.eUm.aSH().kd(this.fcI);
            }
            if (this.faA != null) {
                this.faA.H(this.fdi);
            }
            if (b != null) {
                this.fce = b;
                this.faR.setVisibility(0);
                if (this.eUm.aTu()) {
                    if (fVar.aRg() != null) {
                        this.mForumName = fVar.aRg().getForumName();
                        this.mForumId = fVar.aRg().getForumId();
                    }
                    if (this.mForumName == null && this.eUm.aSo() != null && this.eUm.aSo().aUd() != null) {
                        this.mForumName = this.eUm.aSo().aUd();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.faR.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.faR.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fcW) {
                    this.faN.setVisibility(0);
                }
                if (!fVar.aRh().sk() && this.faO.getText() != null && this.faO.getText().length() > 0) {
                    this.faO.setVisibility(0);
                } else {
                    this.faO.setVisibility(8);
                }
                q(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rJ = fVar.aRh().rJ();
                if (rJ != null && rJ.size() > 0 && !this.fcW) {
                    this.fch.setText(String.valueOf(rJ.get(0).pt()));
                    this.fcg.setVisibility(0);
                } else {
                    this.fcg.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.fcg, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.fch, d.C0082d.cp_link_tip_d, 1);
                if (b.rx() != null) {
                    String string = b.rx().getName_show() == null ? StringUtils.string(b.rx().getUserName()) : StringUtils.string(b.rx().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.rx().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aP(b.rx().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aP(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.rx().getIconInfo();
                            tShowInfoNew = b.rx().getTShowInfoNew();
                            if (this.eVr != null) {
                                this.eVr.setTag(d.g.tag_user_id, b.rx().getUserId());
                                this.eVr.setOnClickListener(this.eUm.eSr.cSI);
                                this.eVr.a(iconInfo, 4, this.eUm.getResources().getDimensionPixelSize(d.e.tbds36), this.eUm.getResources().getDimensionPixelSize(d.e.tbds36), this.eUm.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.eVq != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eVq.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eVq.setOnClickListener(this.eUm.eSr.feS);
                                this.eVq.a(tShowInfoNew, 3, this.eUm.getResources().getDimensionPixelSize(d.e.tbds36), this.eUm.getResources().getDimensionPixelSize(d.e.tbds36), this.eUm.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.faT.setText(ag(b.rx().getSealPrefix(), e));
                            this.faT.setTag(d.g.tag_user_id, b.rx().getUserId());
                            this.faT.setTag(d.g.tag_user_name, b.rx().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew) || b.rx().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_cont_f, 1);
                            }
                            this.faU.setVisibility(8);
                            if (fVar.aRh().rx() != null && fVar.aRh().rx().getAlaUserData() != null && this.faZ != null) {
                                if (fVar.aRh().rx().getAlaUserData().anchor_live != 0) {
                                    this.faZ.setVisibility(8);
                                } else {
                                    this.faZ.setVisibility(0);
                                    if (this.faD == null) {
                                        this.faD = new com.baidu.tieba.d.b(this.eUm.getPageContext(), this.faZ);
                                        this.faD.iU(1);
                                    }
                                    this.faD.aK(this.eUm.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Rd = fVar.aRh().rx().getAlaUserData();
                                    aVar.type = 2;
                                    this.faZ.setTag(aVar);
                                }
                            }
                            this.faY.setUserId(b.rx().getUserId());
                            this.faY.setUserName(b.rx().getUserName());
                            this.faY.setImageDrawable(null);
                            this.faY.setRadius(com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds40));
                            this.faY.setTag(b.rx().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fbj.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            } else {
                                this.fbj.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                            }
                            f = com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds16);
                            if (!this.eUm.aTu() && !StringUtils.isNull(this.mForumName)) {
                                this.cuS.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.cuS.setVisibility(0);
                                this.fbm.setVisibility(0);
                                this.fbj.setPadding(f, 0, f, 0);
                            } else {
                                this.cuS.setVisibility(8);
                                this.fbm.setVisibility(8);
                                this.fbj.setPadding(0, 0, f, 0);
                            }
                            bws = b.bws();
                            if (bws == null && !TextUtils.isEmpty(bws.getName()) && !TextUtils.isEmpty(bws.getName().trim())) {
                                final String name = bws.getName();
                                final String lat = bws.getLat();
                                final String lng = bws.getLng();
                                this.fbk.setVisibility(0);
                                this.fbl.setVisibility(0);
                                this.fbk.setText(bws.getName());
                                this.fbk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                ar.this.eUm.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.P(ar.this.eUm.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ar.this.eUm.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fbk.setVisibility(8);
                                this.fbl.setVisibility(8);
                            }
                            portrait = b.rx().getPortrait();
                            if (b.rx().getPendantData() == null && !StringUtils.isNull(b.rx().getPendantData().pT())) {
                                UtilHelper.showHeadImageViewBigV(this.faW.getHeadView(), b.rx());
                                this.faY.setVisibility(8);
                                this.faW.setVisibility(0);
                                if (this.fbe != null) {
                                    this.fbe.setVisibility(8);
                                }
                                this.faT.setOnClickListener(this.fdi);
                                this.faW.getHeadView().startLoad(portrait, 28, false);
                                this.faW.getHeadView().setUserId(b.rx().getUserId());
                                this.faW.getHeadView().setUserName(b.rx().getUserName());
                                this.faW.getHeadView().setOnClickListener(this.fdi);
                                this.faW.es(b.rx().getPendantData().pT());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.faY, b.rx());
                                this.faY.setVisibility(0);
                                this.faR.setOnClickListener(this.fdi);
                                this.faT.setOnClickListener(this.fdi);
                                this.faY.setOnClickListener(this.fdi);
                                this.faW.setVisibility(8);
                                this.faY.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rx().getName_show();
                            String userName = b.rx().getUserName();
                            if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.faT.setText(com.baidu.tieba.pb.c.ak(this.eUm.getPageContext().getPageActivity(), this.faT.getText().toString()));
                                this.faT.setGravity(16);
                                this.faT.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQJ());
                                com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.rx().getIconInfo();
                        tShowInfoNew = b.rx().getTShowInfoNew();
                        if (this.eVr != null) {
                        }
                        if (this.eVq != null) {
                        }
                        this.faT.setText(ag(b.rx().getSealPrefix(), e));
                        this.faT.setTag(d.g.tag_user_id, b.rx().getUserId());
                        this.faT.setTag(d.g.tag_user_name, b.rx().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_cont_h, 1);
                        this.faU.setVisibility(8);
                        if (fVar.aRh().rx() != null) {
                            if (fVar.aRh().rx().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.faY.setUserId(b.rx().getUserId());
                        this.faY.setUserName(b.rx().getUserName());
                        this.faY.setImageDrawable(null);
                        this.faY.setRadius(com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds40));
                        this.faY.setTag(b.rx().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds16);
                        if (!this.eUm.aTu()) {
                        }
                        this.cuS.setVisibility(8);
                        this.fbm.setVisibility(8);
                        this.fbj.setPadding(0, 0, f, 0);
                        bws = b.bws();
                        if (bws == null) {
                        }
                        this.fbk.setVisibility(8);
                        this.fbl.setVisibility(8);
                        portrait = b.rx().getPortrait();
                        if (b.rx().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.faY, b.rx());
                        this.faY.setVisibility(0);
                        this.faR.setOnClickListener(this.fdi);
                        this.faT.setOnClickListener(this.fdi);
                        this.faY.setOnClickListener(this.fdi);
                        this.faW.setVisibility(8);
                        this.faY.startLoad(portrait, 28, false);
                        String name_show2 = b.rx().getName_show();
                        String userName2 = b.rx().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                            this.faT.setText(com.baidu.tieba.pb.c.ak(this.eUm.getPageContext().getPageActivity(), this.faT.getText().toString()));
                            this.faT.setGravity(16);
                            this.faT.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQJ());
                            com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.rx().getIconInfo();
                            tShowInfoNew = b.rx().getTShowInfoNew();
                            if (this.eVr != null) {
                            }
                            if (this.eVq != null) {
                            }
                            this.faT.setText(ag(b.rx().getSealPrefix(), e));
                            this.faT.setTag(d.g.tag_user_id, b.rx().getUserId());
                            this.faT.setTag(d.g.tag_user_name, b.rx().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_cont_h, 1);
                            this.faU.setVisibility(8);
                            if (fVar.aRh().rx() != null) {
                            }
                            this.faY.setUserId(b.rx().getUserId());
                            this.faY.setUserName(b.rx().getUserName());
                            this.faY.setImageDrawable(null);
                            this.faY.setRadius(com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds40));
                            this.faY.setTag(b.rx().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            f = com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds16);
                            if (!this.eUm.aTu()) {
                            }
                            this.cuS.setVisibility(8);
                            this.fbm.setVisibility(8);
                            this.fbj.setPadding(0, 0, f, 0);
                            bws = b.bws();
                            if (bws == null) {
                            }
                            this.fbk.setVisibility(8);
                            this.fbl.setVisibility(8);
                            portrait = b.rx().getPortrait();
                            if (b.rx().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.faY, b.rx());
                            this.faY.setVisibility(0);
                            this.faR.setOnClickListener(this.fdi);
                            this.faT.setOnClickListener(this.fdi);
                            this.faY.setOnClickListener(this.fdi);
                            this.faW.setVisibility(8);
                            this.faY.startLoad(portrait, 28, false);
                            String name_show22 = b.rx().getName_show();
                            String userName22 = b.rx().getUserName();
                            if (com.baidu.tbadk.o.ac.fS()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.rx().getIconInfo();
                        tShowInfoNew = b.rx().getTShowInfoNew();
                        if (this.eVr != null) {
                        }
                        if (this.eVq != null) {
                        }
                        this.faT.setText(ag(b.rx().getSealPrefix(), e));
                        this.faT.setTag(d.g.tag_user_id, b.rx().getUserId());
                        this.faT.setTag(d.g.tag_user_name, b.rx().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.faT, d.C0082d.cp_cont_h, 1);
                        this.faU.setVisibility(8);
                        if (fVar.aRh().rx() != null) {
                        }
                        this.faY.setUserId(b.rx().getUserId());
                        this.faY.setUserName(b.rx().getUserName());
                        this.faY.setImageDrawable(null);
                        this.faY.setRadius(com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds40));
                        this.faY.setTag(b.rx().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.eUm.getActivity(), d.e.ds16);
                        if (!this.eUm.aTu()) {
                        }
                        this.cuS.setVisibility(8);
                        this.fbm.setVisibility(8);
                        this.fbj.setPadding(0, 0, f, 0);
                        bws = b.bws();
                        if (bws == null) {
                        }
                        this.fbk.setVisibility(8);
                        this.fbl.setVisibility(8);
                        portrait = b.rx().getPortrait();
                        if (b.rx().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.faY, b.rx());
                        this.faY.setVisibility(0);
                        this.faR.setOnClickListener(this.fdi);
                        this.faT.setOnClickListener(this.fdi);
                        this.faY.setOnClickListener(this.fdi);
                        this.faW.setVisibility(8);
                        this.faY.startLoad(portrait, 28, false);
                        String name_show222 = b.rx().getName_show();
                        String userName222 = b.rx().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.faQ.W(fVar.aRh());
                }
                if (this.fcp != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eOS);
                    if (fVar != null && fVar.aRh() != null) {
                        jVar.eOU = fVar.aRh().rp();
                    }
                    jVar.aFL = !this.ePN;
                    jVar.eOW = this.eUm.aTt();
                    this.fcp.a(jVar);
                }
            }
        }
    }

    public void jQ(boolean z) {
        if (z) {
            aWf();
        } else {
            aWg();
        }
        this.fct.fdA = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fct));
        a(this.fct.fdA, false);
    }

    public void aWf() {
        if (this.faG != null && !this.fcK) {
            this.faG.kk(!StringUtils.isNull(this.eUm.aSP()));
            this.fcK = true;
        }
    }

    public void aWg() {
        if (this.faG != null) {
            this.faG.aXh();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rT() != null) {
            this.faS.a(this.eUm.getPageContext(), fVar.aRj().get(0).rT(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aRf().getId(), fVar.aRf().getName(), fVar.aRh().getId(), this.eUm.aTq() ? "FRS" : null));
            this.faR.setPadding(this.faR.getPaddingLeft(), (int) this.eUm.getResources().getDimension(d.e.ds20), this.faR.getPaddingRight(), this.faR.getPaddingBottom());
            return;
        }
        this.faS.a(null, null, null);
    }

    public void aWh() {
        if (this.faA != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.faA.aYt();
            this.faK.smoothScrollToPosition(0);
        }
    }

    public boolean aWi() {
        return this.fdj;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean N(bd bdVar) {
        if (bdVar == null || bdVar.rx() == null || bdVar.rx().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rx().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.faG.aXf();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.faG.nG(eVar.forumName);
            }
            String string = this.eUm.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eUm.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.eUm.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.eUm.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eOh;
            this.eUm.showNetRefreshView(this.csY, format, null, this.eUm.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.core.util.av.vL().c(ar.this.eUm.getPageContext(), new String[]{str2});
                        ar.this.eUm.finish();
                        return;
                    }
                    ar.this.eUm.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aVo;
        Parcelable aVo2;
        String str;
        if (fVar != null) {
            this.eXh = fVar;
            this.mType = i;
            if (fVar.aRh() != null) {
                this.fcv = fVar.aRh().ri();
                if (fVar.aRh().getAnchorLevel() != 0) {
                    this.fdj = true;
                }
                this.fbR = N(fVar.aRh());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            t(fVar);
            this.fcf = false;
            this.ePN = z;
            aWb();
            b(fVar, z, i);
            PostData b = b(fVar, z);
            this.fbu.jo(this.faP.getPaddingBottom() > 0 || (b != null && b.getType() == PostData.gze));
            r(fVar);
            if (this.eUm.aTg()) {
                if (this.fby == null) {
                    this.fby = new com.baidu.tieba.pb.view.i(this.eUm.getPageContext());
                    this.fby.kX();
                    this.fby.a(this.amU);
                }
                this.faK.setPullRefresh(this.fby);
                aWj();
                if (this.fby != null) {
                    this.fby.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qA().qx() == 0 && z) {
                this.faK.setPullRefresh(null);
            } else {
                if (this.fby == null) {
                    this.fby = new com.baidu.tieba.pb.view.i(this.eUm.getPageContext());
                    this.fby.kX();
                    this.fby.a(this.amU);
                }
                this.faK.setPullRefresh(this.fby);
                aWj();
                if (this.fby != null) {
                    this.fby.dz(TbadkCoreApplication.getInst().getSkinType());
                }
                XB();
            }
            aWl();
            this.fbu.iY(this.ePN);
            this.fbu.iZ(false);
            this.fbu.jk(i == 5);
            this.fbu.jl(i == 6);
            this.fbu.jm(z2 && this.fdh);
            this.fbu.a(fVar, false);
            this.fbu.notifyDataSetChanged();
            if (this.eUm.aTu()) {
                this.fcM = 0;
                PostData b2 = b(fVar, z);
                if (b2 != null && b2.rx() != null) {
                    this.fcM = b2.rx().getLevel_id();
                }
                if (this.fcM > 0) {
                    this.faV.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.faV, BitmapHelper.getGradeResourceIdInEnterForum(this.fcM));
                } else {
                    this.faV.setVisibility(8);
                }
            } else {
                this.faV.setVisibility(8);
            }
            if (fVar.aRh() != null && fVar.aRh().rm() != null) {
                if (fVar.aRh().rm().getNum() < 1) {
                    str = this.eUm.getResources().getString(d.j.zan);
                } else {
                    str = fVar.aRh().rm().getNum() + "";
                }
                if (this.faz != -1) {
                    fVar.aRh().rm().setIsLike(this.faz);
                }
                Q(str, fVar.aRh().rm().getIsLike() == 1);
            }
            if (this.eUm.isLogin()) {
                this.faK.setNextPage(this.cLS);
                this.faF = 2;
                XB();
            } else {
                this.fcf = true;
                if (fVar.qA().qw() == 1) {
                    if (this.fbz == null) {
                        this.fbz = new com.baidu.tieba.pb.view.b(this.eUm.getPageContext());
                    }
                    this.faK.setNextPage(this.fbz);
                } else {
                    this.faK.setNextPage(this.cLS);
                }
                this.faF = 3;
            }
            ArrayList<PostData> aRj = fVar.aRj();
            if (fVar.qA().qw() == 0 || aRj == null || aRj.size() < fVar.qA().qv()) {
                if (com.baidu.tbadk.core.util.v.v(aRj) == 0 || (com.baidu.tbadk.core.util.v.v(aRj) == 1 && aRj.get(0) != null && aRj.get(0).bwo() == 1)) {
                    this.cLS.setText(this.eUm.getResources().getString(d.j.list_no_more_new));
                    if (this.eUm.aSH() != null && !this.eUm.aSH().aWX()) {
                        this.eUm.aSH().showFloatingView();
                    }
                } else {
                    this.cLS.setText(this.eUm.getResources().getString(d.j.list_has_no_more));
                }
                if (this.eUm.aTg() && this.faK != null && this.faK.getData() != null && this.faK.getData().size() == 1 && (this.faK.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cLS.setText("");
                }
                aWs();
            } else if (z2) {
                if (this.fdh) {
                    wy();
                    if (fVar.qA().qw() != 0) {
                        this.cLS.setText(this.eUm.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.cLS.wt();
                    this.cLS.showLoading();
                }
            } else {
                this.cLS.wt();
                this.cLS.showLoading();
            }
            switch (i) {
                case 2:
                    this.faK.setSelection(i2 > 1 ? (((this.faK.getData() == null && fVar.aRj() == null) ? 0 : (this.faK.getData().size() - fVar.aRj().size()) + this.faK.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aVo2 = ai.aVn().aVo()) != null) {
                        this.faK.onRestoreInstanceState(aVo2);
                        if (com.baidu.tbadk.core.util.v.v(aRj) > 1 && fVar.qA().qw() > 0) {
                            this.cLS.wy();
                            this.cLS.setText(this.eUm.getString(d.j.pb_load_more_without_point));
                            this.cLS.wu();
                            break;
                        }
                    } else {
                        this.faK.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fdh = false;
                    break;
                case 5:
                    this.faK.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aVo = ai.aVn().aVo()) != null) {
                        this.faK.onRestoreInstanceState(aVo);
                        break;
                    } else {
                        this.faK.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.faA != null && this.faA.aYs() != null) {
                            if (this.eUm.isUseStyleImmersiveSticky()) {
                                this.faK.setSelectionFromTop((this.fbu.aTK() + this.faK.getHeaderViewsCount()) - 1, this.faA.aYs().getHeight() - com.baidu.adp.lib.util.l.n(this.eUm.getPageContext().getPageActivity()));
                            } else {
                                this.faK.setSelectionFromTop((this.fbu.aTK() + this.faK.getHeaderViewsCount()) - 1, this.faA.aYs().getHeight());
                            }
                        } else {
                            this.faK.setSelection(this.fbu.aTK() + this.faK.getHeaderViewsCount());
                        }
                    } else {
                        this.faK.setSelection(i2 > 0 ? ((this.faK.getData() == null && fVar.aRj() == null) ? 0 : (this.faK.getData().size() - fVar.aRj().size()) + this.faK.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cLS.wy();
                    this.cLS.setText(this.eUm.getString(d.j.pb_load_more_without_point));
                    this.cLS.wu();
                    break;
            }
            if (this.fcv == fcw && isHost()) {
                aWy();
            }
            if (this.fcG) {
                aVz();
                this.fcG = false;
                if (i3 == 0) {
                    jJ(true);
                }
            }
            if (this.faC != null) {
                this.faC.ac(fVar.aRh());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aWj() {
        if (this.faA != null && this.faA.aYs() != null) {
            this.faK.removeHeaderView(this.axT);
            if (this.mType != 1) {
                this.faK.removeHeaderView(this.faA.aYu());
                this.faK.addHeaderView(this.faA.aYu(), 0);
                return;
            }
            return;
        }
        if (this.faA != null) {
            this.faK.removeHeaderView(this.faA.aYu());
        }
        this.faK.removeHeaderView(this.axT);
        this.faK.addHeaderView(this.axT, 0);
    }

    public void jR(boolean z) {
        this.fbQ = z;
    }

    public void wy() {
        if (this.cLS != null) {
            this.cLS.wu();
            this.cLS.wy();
        }
        XB();
    }

    public void PB() {
        this.faK.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.fce != null && this.fce.rx() != null && this.faG != null) {
            this.fcJ = !this.fcI;
            this.faG.kf(this.fcJ);
            if (this.eUm.aSH() != null) {
                this.eUm.aSH().ke(this.fcJ);
            }
            aWk();
            if (this.fcJ) {
                this.faG.ffJ.setVisibility(0);
                if (this.fbR) {
                    this.faG.ffK.setVisibility(8);
                    this.fbf.setVisibility(8);
                    this.fbi.setVisibility(0);
                    this.fbi.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aRC())));
                } else if (!PbNormalLikeButtonSwitchStatic.GU() || (this.fce.rx().hadConcerned() && this.fce.rx().getGodUserData() != null && this.fce.rx().getGodUserData().getIsFromNetWork())) {
                    this.faG.ffK.setVisibility(8);
                }
                if (this.fco != null) {
                    this.fco.setVisibility(8);
                }
                this.faG.a(this.fce.rx(), this.fdi);
                if (this.fcT == null) {
                    this.fcT = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fcL) {
                                ar.this.aWx();
                            }
                        }
                    };
                }
                this.faK.setListViewDragListener(this.fcT);
                return;
            }
            if (this.faG.ffJ != null) {
                this.faG.ffJ.setVisibility(8);
            }
            if (this.fco != null) {
                this.fco.setVisibility(0);
            }
            if (this.fbR) {
                this.fbf.setVisibility(8);
                this.fbi.setVisibility(0);
                this.fbi.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aRC())));
            } else if (!PbNormalLikeButtonSwitchStatic.GU() || (this.fce.rx().hadConcerned() && this.fce.rx().getGodUserData() != null && this.fce.rx().getGodUserData().getIsFromNetWork())) {
                this.fbf.setVisibility(8);
                this.fbi.setVisibility(8);
            } else {
                this.fbi.setVisibility(8);
            }
            this.fcT = null;
            this.faK.setListViewDragListener(null);
        }
    }

    private void aWk() {
        String threadId = this.eXh != null ? this.eXh.getThreadId() : "";
        if (this.fcJ) {
            if (this.fbh == null) {
                this.fbh = new ap(this.eUm.getPageContext(), this.faG.ffK, 3);
                this.fbh.h(this.eUm.getUniqueId());
            }
            if (this.fce != null && this.fce.rx() != null) {
                this.fce.rx().setIsLike(this.fce.rx().hadConcerned());
                this.fbh.a(this.fce.rx());
            }
            this.fbh.cD(threadId);
            this.fbh.faw = this.fcI;
        }
        if (this.fbg == null) {
            this.fbg = new ap(this.eUm.getPageContext(), this.fbf, 1);
            this.fbg.h(this.eUm.getUniqueId());
            this.fbg.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aN(boolean z) {
                    if (ar.this.eUm != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.eUm, d.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.eUm.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fce != null && this.fce.rx() != null) {
            this.fce.rx().setIsLike(this.fce.rx().hadConcerned());
            this.fbg.a(this.fce.rx());
            this.fbg.cD(threadId);
        }
        this.fbg.faw = this.fcI;
    }

    private boolean aWl() {
        boolean z;
        if (this.fbU != null && this.fbU.getVisibility() == 0) {
            if (this.fbq != null) {
                this.fbq.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fbq != null) {
                this.fbq.setVisibility(8);
            }
            z = false;
        }
        if ((this.fbs == null || this.fbs.getVisibility() == 8) && z && this.ePN) {
            this.fbr.setVisibility(0);
        } else {
            this.fbr.setVisibility(8);
        }
        return z;
    }

    private boolean s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aRh() == null) {
            return false;
        }
        if (fVar.aRh().ru() == 1 || fVar.aRh().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aRh().rw() == null || fVar.aRh().rw().sY() == 0) || fVar.aRh().rs() == 1 || fVar.aRh().rt() == 1 || fVar.aRh().sc() || fVar.aRh().sq() || fVar.aRh().sj() || fVar.aRh().rK() != null || fVar.aRh().sr() || fVar.aRh().sr() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aRh().getCategory()) || fVar.aRh().rB() || fVar.aRh().rA();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return com.baidu.tieba.card.k.a((Context) this.eUm.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.faN != null) {
                if (fVar.aRh() != null && fVar.aRh().rN() == 0 && !fVar.aRh().sk() && !this.fcW) {
                    this.faN.setVisibility(0);
                    if (fVar.aRh() != null) {
                        fVar.aRh().e(true, s(fVar));
                    }
                    SpannableStringBuilder rX = fVar.aRh().rX();
                    this.faO.setOnTouchListener(new com.baidu.tieba.view.l(rX));
                    if (this.fcU) {
                        this.faO.setText(fVar.aRh().getTitle());
                    } else {
                        this.faO.setText(rX);
                    }
                    this.faO.setVisibility(0);
                } else if (fVar.aRh().rN() == 1) {
                    if (fVar.aRh() != null) {
                        fVar.aRh().e(true, s(fVar));
                        SpannableStringBuilder rX2 = fVar.aRh().rX();
                        if (rX2 == null || rX2.length() == 0) {
                            this.faN.setVisibility(8);
                            this.faK.removeHeaderView(this.faN);
                            if (fVar.aRh() != null && !fVar.aRh().sk()) {
                                this.faR.setPadding(this.faR.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds48), this.faR.getPaddingRight(), this.faR.getPaddingBottom());
                            }
                        } else {
                            this.faN.setVisibility(0);
                            this.faO.setOnTouchListener(new com.baidu.tieba.view.l(rX2));
                            this.faO.setText(rX2);
                            this.faO.setVisibility(0);
                        }
                    }
                } else {
                    this.faN.setVisibility(8);
                    this.faK.removeHeaderView(this.faN);
                    if (fVar.aRh() != null && fVar.aRh().sk()) {
                        this.faR.setPadding(this.faR.getPaddingLeft(), 0, this.faR.getPaddingRight(), this.faR.getPaddingBottom());
                    } else {
                        this.faR.setPadding(this.faR.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds48), this.faR.getPaddingRight(), this.faR.getPaddingBottom());
                    }
                }
            }
            this.ePN = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aWl();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        if (fVar == null || (b = b(fVar, z)) == null) {
            return null;
        }
        String userId = b.rx().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aRs()));
            sparseArray.put(d.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.rx() != null) {
                sparseArray.put(d.g.tag_forbid_user_name, b.rx().getUserName());
                sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aRs()));
            sparseArray.put(d.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aJb;
    }

    public void pT(String str) {
        if (this.cLS != null) {
            this.cLS.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.faK;
    }

    public int aWm() {
        return d.g.richText;
    }

    public TextView aSC() {
        return this.faQ.aSC();
    }

    public void d(BdListView.e eVar) {
        this.faK.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.amU = bVar;
        if (this.fby != null) {
            this.fby.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int qu = alVar.qu();
            int qr = alVar.qr();
            if (this.fbv != null) {
                this.fbv.tk();
            } else {
                this.fbv = new com.baidu.tbadk.core.dialog.a(this.eUm.getPageContext().getPageActivity());
                this.fbw = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fbv.v(this.fbw);
                this.fbv.a(d.j.dialog_ok, bVar);
                this.fbv.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.aWo();
                        aVar.dismiss();
                    }
                });
                this.fbv.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fcD == null) {
                            ar.this.fcD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.eUm.HidenSoftKeyPad((InputMethodManager) ar.this.eUm.getSystemService("input_method"), ar.this.csY);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(ar.this.fcD, 150L);
                    }
                });
                this.fbv.b(this.eUm.getPageContext()).tk();
            }
            this.fbx = (EditText) this.fbw.findViewById(d.g.input_page_number);
            this.fbx.setText("");
            TextView textView = (TextView) this.fbw.findViewById(d.g.current_page_number);
            if (qu <= 0) {
                qu = 1;
            }
            if (qr <= 0) {
                qr = 1;
            }
            textView.setText(MessageFormat.format(this.eUm.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(qu), Integer.valueOf(qr)));
            this.eUm.ShowSoftKeyPadDelay(this.fbx, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.faK.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eUm.showToast(str);
    }

    public boolean jS(boolean z) {
        if (this.IT == null || !this.IT.Dg()) {
            return false;
        }
        this.IT.Bm();
        return true;
    }

    public void aWn() {
        if (this.fdk != null) {
            while (this.fdk.size() > 0) {
                TbImageView remove = this.fdk.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aWn();
        this.fbu.pP(1);
        if (this.faA != null) {
            this.faA.onPause();
        }
    }

    public void onResume() {
        this.fbu.pP(2);
        if (this.faA != null) {
            this.faA.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fcF != null) {
            this.fcF.destroy();
        }
        if (this.faD != null) {
            this.faD.adz();
        }
        if (this.faC != null) {
            this.faC.onDestroy();
        }
        this.eUm.hideProgressBar();
        if (this.csW != null && this.cFo != null) {
            this.csW.b(this.cFo);
        }
        aWo();
        wy();
        if (this.fcD != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fcD);
        }
        if (this.faR != null && this.fbe != null) {
            this.faR.removeView(this.faX);
            this.fbe = null;
        }
        if (this.fcj != null) {
            this.fcj.clearStatus();
        }
        this.fdd = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fbu.pP(3);
        if (this.cIM != null) {
            this.cIM.setBackgroundDrawable(null);
        }
        if (this.faA != null) {
            this.faA.destroy();
        }
        if (this.fbu != null) {
            this.fbu.onDestory();
        }
        this.faK.setOnLayoutListener(null);
        if (this.fcR != null) {
            this.fcR.amU();
        }
        if (this.fcu != null) {
            this.fcu.onDestroy();
        }
        aWK();
    }

    public boolean qg(int i) {
        if (this.faA != null) {
            return this.faA.jY(i);
        }
        return false;
    }

    public void aWo() {
        this.faG.ot();
        if (this.faD != null) {
            this.faD.adz();
        }
        com.baidu.adp.lib.util.l.a(this.eUm.getPageContext().getPageActivity(), this.fbx);
        aVC();
        if (this.fbO != null) {
            this.fbO.dismiss();
        }
        aWq();
        if (this.faC != null) {
            this.faC.aYl();
        }
        if (this.fbv != null) {
            this.fbv.dismiss();
        }
        if (this.cIz != null) {
            this.cIz.dismiss();
        }
    }

    public void aWp() {
        this.faG.ot();
        if (this.faD != null) {
            this.faD.adz();
        }
        if (this.fbO != null) {
            this.fbO.dismiss();
        }
        aWq();
        if (this.faC != null) {
            this.faC.aYl();
        }
        if (this.fbv != null) {
            this.fbv.dismiss();
        }
        if (this.cIz != null) {
            this.cIz.dismiss();
        }
    }

    public void cK(List<String> list) {
        this.fcQ = list;
        if (this.fcR != null) {
            this.fcR.setData(list);
        }
    }

    public void iX(boolean z) {
        this.fbu.iX(z);
    }

    public void jT(boolean z) {
        this.fbT = z;
    }

    public void aWq() {
        if (this.fbE != null) {
            this.fbE.dismiss();
        }
        if (this.fbF != null) {
            com.baidu.adp.lib.g.g.b(this.fbF, this.eUm.getPageContext());
        }
        if (this.fbG != null) {
            com.baidu.adp.lib.g.g.b(this.fbG, this.eUm.getPageContext());
        }
        if (this.fbC != null) {
            com.baidu.adp.lib.g.g.b(this.fbC, this.eUm.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eXh, this.ePN);
            d(this.eXh, this.ePN, this.mType);
            this.eUm.getLayoutMode().ag(i == 1);
            this.eUm.getLayoutMode().t(this.csY);
            this.eUm.getLayoutMode().t(this.faO);
            this.eUm.getLayoutMode().t(this.faP);
            this.eUm.getLayoutMode().t(this.faM);
            if (this.fbc != null) {
                com.baidu.tbadk.core.util.aj.c(this.fbc, d.C0082d.cp_cont_d, 1);
            }
            if (this.fbb != null) {
                com.baidu.tbadk.core.util.aj.c(this.fbb, d.C0082d.cp_cont_d, 1);
            }
            if (this.faC != null) {
                this.faC.onChangeSkinType(i);
            }
            this.eUm.getLayoutMode().t(this.faM);
            com.baidu.tbadk.core.util.aj.i(this.faO, d.C0082d.cp_cont_b);
            this.faO.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_link_tip_c));
            this.eUm.getLayoutMode().t(this.aJb);
            if (this.fbv != null) {
                this.fbv.c(this.eUm.getPageContext());
            }
            jR(this.fbQ);
            this.fbu.notifyDataSetChanged();
            if (this.fby != null) {
                this.fby.dz(i);
            }
            if (this.cLS != null) {
                this.cLS.dz(i);
                com.baidu.tbadk.core.util.aj.j(this.aJb, d.f.pb_foot_more_trans_selector);
                this.cLS.dw(d.f.pb_foot_more_trans_selector);
            }
            if (this.IT != null) {
                this.IT.onChangeSkinType(i);
            }
            if (this.fbd != null) {
                this.fbd.dE(i);
            }
            if (this.fbz != null) {
                this.fbz.dz(i);
            }
            if (this.faL != null && this.faL.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.faL) {
                    aVar.aWY();
                }
            }
            jN(i == 1);
            aVQ();
            UtilHelper.setStatusBarBackground(this.cIM, i);
            UtilHelper.setStatusBarBackground(this.fco, i);
            if (this.fbf != null) {
                this.fbf.onChangeSkinType(i);
            }
            if (this.fbk != null) {
                com.baidu.tbadk.core.util.aj.i(this.fbk, d.C0082d.cp_cont_d);
            }
            if (this.fbj != null) {
                com.baidu.tbadk.core.util.aj.i(this.fbj, d.C0082d.cp_cont_d);
            }
            if (this.fbl != null) {
                com.baidu.tbadk.core.util.aj.j(this.fbl, d.C0082d.cp_cont_e);
            }
            if (this.cuS != null) {
                com.baidu.tbadk.core.util.aj.i(this.cuS, d.C0082d.cp_cont_d);
            }
            if (this.fbm != null) {
                com.baidu.tbadk.core.util.aj.j(this.fbm, d.C0082d.cp_cont_e);
            }
            if (this.faU != null) {
                com.baidu.tbadk.core.util.aj.i(this.faU, d.C0082d.cp_link_tip_a);
            }
            if (this.fbi != null) {
                com.baidu.tbadk.core.util.aj.i(this.fbi, d.C0082d.cp_cont_d);
            }
            if (this.fbn != null) {
                com.baidu.tbadk.n.a.a(this.eUm.getPageContext(), this.fbn);
            }
            if (this.fbM != null) {
                com.baidu.tbadk.n.a.a(this.eUm.getPageContext(), this.fbM);
            }
            if (this.fcE != null) {
                this.fcE.onChangeSkinType(i);
            }
            if (this.faG != null) {
                if (this.faA != null) {
                    this.faA.qm(i);
                } else {
                    this.faG.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fbW != null) {
                com.baidu.tbadk.core.util.aj.i(this.fbW, d.C0082d.cp_cont_e);
            }
            if (this.faV != null) {
                com.baidu.tbadk.core.util.aj.c(this.faV, BitmapHelper.getGradeResourceIdInEnterForum(this.fcM));
            }
            this.fcS.onChangeSkinType(i);
            if (this.fcu != null) {
                this.fcu.onChangeSkinType();
            }
            if (this.fcP != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcP, d.C0082d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aVE = fVar;
        this.fbu.setOnImageClickListener(this.aVE);
        this.fcS.setOnImageClickListener(this.aVE);
    }

    public void h(NoNetworkView.a aVar) {
        this.cFo = aVar;
        if (this.csW != null) {
            this.csW.a(this.cFo);
        }
    }

    public void jU(boolean z) {
        this.fbu.setIsFromCDN(z);
    }

    public Button aWr() {
        return this.fbU;
    }

    public void aWs() {
        if (this.faF != 2) {
            this.faK.setNextPage(this.cLS);
            this.faF = 2;
        }
    }

    public void aWt() {
        if (com.baidu.tbadk.k.r.GA().GB()) {
            int lastVisiblePosition = this.faK.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faK.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.fr(1001);
                                perfLog.aKj = true;
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
                        perfLog2.aKj = true;
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

    public boolean aWu() {
        return this.IT != null && this.IT.getVisibility() == 0;
    }

    public void jV(boolean z) {
        if (this.fbV != null) {
            jT(this.eUm.aSD().DH());
            if (this.fbT) {
                jK(z);
            } else {
                jL(z);
            }
        }
    }

    public void aWv() {
        if (this.fbV != null) {
            this.fbV.setVisibility(8);
            this.fca = false;
            if (this.fcu != null) {
                this.fcu.setVisibility(8);
                jP(false);
            }
            aWK();
        }
    }

    public void showLoadingDialog() {
        if (this.cjW == null) {
            this.cjW = new com.baidu.tbadk.core.view.a(this.eUm.getPageContext());
        }
        this.cjW.aE(true);
    }

    public void XB() {
        if (this.cjW != null) {
            this.cjW.aE(false);
        }
    }

    private int getScrollY() {
        View childAt = this.faK.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.faK.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.faA != null) {
            this.faA.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.esU = getScrollY();
            this.fct.fdA = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fct));
            a(this.fct.fdA, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.faA != null) {
            this.faA.b(absListView, i);
        }
        int headerViewsCount = (i - this.faK.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fbu.pO(headerViewsCount) == com.baidu.tieba.pb.data.l.eOZ) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.faK.getHeaderViewsCount();
        if (this.faP != null && this.faG != null) {
            this.faG.f(this.faP.getBottom(), this.faP.getMeasuredHeight(), z2);
        }
        this.fbu.aTO().j(z, this.fcm != null ? this.fcm.getMeasuredHeight() : 0);
        this.fct.eJR = i;
        this.fct.fdz = this.faK.getHeaderViewsCount();
        this.fct.fdA = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fct));
        a(this.fct.fdA, false);
    }

    public void aWw() {
        if (this.eUm.isLogin() && this.eXh != null && this.fcJ && !this.fcI && !this.fbR && this.fce != null && this.fce.rx() != null && !this.fce.rx().getIsLike() && !this.fce.rx().hadConcerned()) {
            if (this.fcF == null) {
                this.fcF = new am(this.eUm);
            }
            this.fcF.a(this.faG.ffJ, this.eXh.aRF(), this.fce.rx().getUserId(), this.eXh.getThreadId());
        }
    }

    public void aWx() {
        if (this.fcJ && !this.fcI && this.fce != null && this.fce.rx() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").r("obj_locate", this.eUm.aTu() ? 2 : 1).r("obj_type", this.fcI ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eUm.getPageContext().getPageActivity(), this.fce.rx().getUserId(), this.fce.rx().getUserName(), this.eUm.aSo().aUd(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fcI && this.fcn != null && this.faG.aXb() != null) {
            int aTL = this.fbu.aTL();
            if (aTL > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (aTL > this.faK.getFirstVisiblePosition() - this.faK.getHeaderViewsCount()) {
                    this.fcn.setVisibility(8);
                    return;
                }
                this.fcn.setVisibility(0);
                this.faG.mNavigationBar.hideBottomLine();
            } else if (akVar != null && akVar.getView() != null && akVar.eZX != null) {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fcs) {
                        this.fcr = top;
                        this.fcs = false;
                    }
                    this.fcr = top < this.fcr ? top : this.fcr;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fbt.getY() < 0.0f) {
                        measuredHeight = fcq - akVar.eZX.getMeasuredHeight();
                    } else {
                        measuredHeight = this.faG.aXb().getMeasuredHeight() - akVar.eZX.getMeasuredHeight();
                        this.faG.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fcr) {
                        this.fcn.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fcn.setVisibility(0);
                    } else {
                        this.fcn.setVisibility(8);
                        this.faG.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fcs = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eJR;
        public ak fdA;
        public int fdz;

        public a() {
        }
    }

    public void aWy() {
        if (!this.fdl) {
            TiebaStatic.log("c10490");
            this.fdl = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUm.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fcx, Integer.valueOf(fcz));
            aVar.cc(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.eUm);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eUm.getPageContext()).tk();
        }
    }

    public void pU(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUm.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fcx, Integer.valueOf(fcA));
        aVar.z(sparseArray);
        aVar.a(d.j.view, this.eUm);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eUm.getPageContext()).tk();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.rx() != null) {
            MetaData rx = b.rx();
            rx.setGiftNum(rx.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        r(fVar);
    }

    public PbInterviewStatusView aWz() {
        return this.fcj;
    }

    private void t(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRh() != null && fVar.aRh().sq() && this.fcj == null) {
            this.fcj = (PbInterviewStatusView) this.fci.inflate();
            this.fcj.setOnClickListener(this.cIA);
            this.fcj.setCallback(this.eUm.aTp());
            this.fcj.c(this.eUm, fVar);
        }
    }

    public LinearLayout aWA() {
        return this.fbt;
    }

    public View aWB() {
        return this.cIM;
    }

    public boolean aWC() {
        return this.fcW;
    }

    public void jc(boolean z) {
        this.faQ.jc(z);
    }

    private void aWD() {
        if (this.fcW) {
            if (this.fcX == null) {
                e.a aVar = e.eRH.get();
                if (aVar != null) {
                    this.fcX = aVar.a(this.eUm);
                    ListAdapter adapter = this.faK.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axT) {
                            this.faK.addHeaderView(this.fcX.aSA(), 1);
                        } else {
                            this.faK.addHeaderView(this.fcX.aSA(), 0);
                        }
                    }
                } else {
                    this.faP.setVisibility(0);
                    return;
                }
            }
            this.faP.setVisibility(8);
            this.faK.removeHeaderView(this.faP);
            return;
        }
        this.faP.setVisibility(0);
    }

    public void jW(boolean z) {
        this.fcW = z;
    }

    public void aWE() {
        this.eUm.showNetRefreshView(getView(), "");
        View ET = this.eUm.getRefreshView().ET();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ET.getLayoutParams();
        layoutParams.addRule(3, aWA().getId());
        ET.setLayoutParams(layoutParams);
        this.eUm.hideLoadingView(getView());
        if (this.fcX != null) {
            this.faK.removeHeaderView(this.fcX.aSA());
            this.fcX = null;
        }
    }

    public void pV(String str) {
        if (this.faH != null) {
            this.faH.setTitle(str);
        }
    }

    private int jX(boolean z) {
        if (this.fcj == null || this.fcj.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void aWF() {
        if (this.fcj != null && this.fcj.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcj.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fcj.setLayoutParams(layoutParams);
        }
    }

    public boolean aSJ() {
        return false;
    }

    public TextView aWG() {
        return this.fbc;
    }

    public void pW(String str) {
        this.fbW.performClick();
        if (!StringUtils.isNull(str) && this.eUm.aSD() != null && this.eUm.aSD().DB() != null && this.eUm.aSD().DB().getInputView() != null) {
            EditText inputView = this.eUm.aSD().DB().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aWo();
            if (configuration.orientation == 2) {
                aWv();
                aVC();
            } else {
                aVF();
            }
            if (this.fcE != null) {
                this.fcE.aTS();
            }
            this.eUm.alt();
            this.fbt.setVisibility(8);
            this.faG.setTitleVisibility(false);
            this.eUm.ji(false);
            if (this.faA != null) {
                if (configuration.orientation == 1) {
                    aWA().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.faK.setIsLandscape(true);
                    this.faK.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.faK.setIsLandscape(false);
                    if (this.esU > 0) {
                        this.faK.smoothScrollBy(this.esU, 0);
                    }
                }
                this.faA.onConfigurationChanged(configuration);
            }
        }
    }

    public void jY(boolean z) {
        this.faE = z;
    }

    public boolean aWH() {
        return this.faA != null && this.faA.aWH();
    }

    public void aWI() {
        if (this.faA != null) {
            this.faA.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.faC != null) {
            this.faC.y(j, i);
        }
        if (this.faA != null) {
            this.faA.y(j, i);
        }
    }

    public void jn(boolean z) {
        this.fbu.jn(z);
    }

    public void aWJ() {
        if (this.fck == null) {
            LayoutInflater.from(this.eUm.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.csY, true);
            this.fck = (ViewGroup) this.csY.findViewById(d.g.add_experienced_layout);
            this.fcl = (TextView) this.csY.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.fcl, d.C0082d.cp_cont_i);
            String string = this.eUm.getResources().getString(d.j.experienced_add_success);
            String string2 = this.eUm.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_cont_h)));
            this.fcl.setText(spannableString);
        }
        this.fck.setVisibility(0);
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
                        ar.this.fck.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fcl.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fcl.startAnimation(scaleAnimation);
    }

    public void bj(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fbV.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eUm);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fcP = new TextView(this.eUm);
            this.fcP.setText(d.j.connection_tips);
            this.fcP.setGravity(17);
            this.fcP.setPadding(com.baidu.adp.lib.util.l.f(this.eUm, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.eUm, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eUm, d.e.ds60);
            frameLayout.addView(this.fcP, layoutParams);
            this.fcO = new PopupWindow(this.eUm);
            this.fcO.setContentView(frameLayout);
            this.fcO.setHeight(-2);
            this.fcO.setWidth(-2);
            this.fcO.setFocusable(true);
            this.fcO.setOutsideTouchable(false);
            this.fcO.setBackgroundDrawable(new ColorDrawable(this.eUm.getResources().getColor(d.C0082d.transparent)));
            this.faK.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fcO.showAsDropDown(ar.this.fbV, view.getLeft(), -ar.this.fbV.getHeight());
                    } else {
                        ar.this.fcO.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aWT() != null && !StringUtils.isNull(aVar.aWT().pkg_id) && !StringUtils.isNull(aVar.aWT().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fbX != null && this.fbX.getVisibility() == 0) {
            if (this.fcN == null) {
                View inflate = LayoutInflater.from(this.eUm.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.cIA);
                this.fcN = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fbX.getLocationInWindow(iArr);
            this.fcN.showAtLocation(this.fbX, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fbX.getHeight()) - com.baidu.adp.lib.util.l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aWK() {
        com.baidu.adp.lib.g.g.a(this.fcN);
    }

    public void setIsInterviewLive(boolean z) {
        this.fcU = z;
    }

    public boolean getIsInterviewLive() {
        return this.fcU;
    }

    public void bk(View view) {
        this.fbM = view;
    }
}
