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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.userLike.PbFirstFloorUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.pb.pb.main.emotion.view.c;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class an {
    private com.baidu.tbadk.editortools.i JH;
    private View aHI;
    private com.baidu.tieba.pb.a.c aSk;
    private g.b amd;
    private TextView awN;
    private View bQE;
    private NoNetworkView ccF;
    private RelativeLayout ccH;
    private View.OnClickListener crI;
    private View crU;
    private PbListView cuQ;
    PbActivity.c eCz;
    private PbActivity eDo;
    private UserIconBox eEA;
    private UserIconBox eEB;
    private PbFakeFloorModel eEZ;
    private com.baidu.tieba.pb.data.f eFA;
    public int eIH;
    private com.baidu.tieba.pb.video.i eII;
    private com.baidu.tieba.pb.video.h eIJ;
    private com.baidu.tieba.d.a eIK;
    public final com.baidu.tieba.pb.pb.main.view.c eIN;
    public com.baidu.tieba.pb.pb.main.view.b eIO;
    private ViewStub eIP;
    private ViewStub eIQ;
    private PbLandscapeListView eIR;
    private List<com.baidu.tieba.pb.pb.main.view.a> eIS;
    private View eIT;
    private LinearLayout eIW;
    private d eIX;
    private ColumnLayout eIY;
    private ThreadSkinView eIZ;
    private ObservedChangeLinearLayout eJB;
    private f eJC;
    private View eJI;
    private TextView eJa;
    private TextView eJb;
    private View eJc;
    private TextView eJd;
    private ImageView eJe;
    private HeadPendantView eJf;
    private FrameLayout eJg;
    private HeadImageView eJh;
    private View eJi;
    private FloatingLayout eJj;
    private PbFirstFloorUserLikeButton eJo;
    private al eJp;
    private al eJq;
    private TextView eJr;
    private TextView eJs;
    private TextView eJt;
    private View eJu;
    private LinearLayout eJv;
    private TextView eJw;
    private TextView eJx;
    private View eJy;
    private View eJz;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eKA;
    private int eKI;
    private Runnable eKJ;
    private q eKK;
    private ai eKL;
    private int eKR;
    private PopupWindow eKT;
    private PopupWindow eKU;
    private List<String> eKW;
    private com.baidu.tieba.pb.pb.main.emotion.c eKX;
    private PbLandscapeListView.b eKY;
    private View eKb;
    private TextView eKc;
    private ImageView eKd;
    private ImageView eKe;
    private TextView eKf;
    private boolean eKh;
    private int eKi;
    private int eKj;
    private PostData eKk;
    private View eKm;
    private TextView eKn;
    private ViewStub eKo;
    private PbInterviewStatusView eKp;
    private ViewGroup eKq;
    private TextView eKr;
    private FrameLayout eKs;
    private View eKt;
    private View eKu;
    private ag eKv;
    private boolean eLa;
    private c eLb;
    private com.baidu.tbadk.core.view.userLike.c eLc;
    private com.baidu.tbadk.core.view.userLike.c eLd;
    private Runnable eLi;
    private PbActivity.a eLk;
    private int efs;
    private View.OnClickListener ezR;
    private boolean isLandscape;
    private int mType;
    private static final int eKw = UtilHelper.getLightStatusBarHeight();
    public static int eKC = 3;
    public static int eKD = 0;
    public static int eKE = 3;
    public static int eKF = 4;
    public static int eKG = 5;
    public static int eKH = 6;
    private boolean eIL = false;
    private int eIM = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout eIU = null;
    private TextView eIV = null;
    private TextView eJk = null;
    private TextView eJl = null;
    public FrsPraiseView eJm = null;
    private ClickableHeaderImageView eJn = null;
    private View eJA = null;
    private com.baidu.tbadk.core.dialog.a eJD = null;
    private com.baidu.tbadk.core.dialog.b crH = null;
    private View eJE = null;
    private EditText eJF = null;
    private com.baidu.tieba.pb.view.i eJG = null;
    private com.baidu.tieba.pb.view.b eJH = null;
    private com.baidu.tbadk.core.dialog.a eJJ = null;
    private b.InterfaceC0047b dxt = null;
    private TbRichTextView.f aSj = null;
    private NoNetworkView.a cow = null;
    private Dialog eJK = null;
    private View eJL = null;
    private com.baidu.tbadk.core.dialog.a eJM = null;
    private Dialog eJN = null;
    private Dialog eJO = null;
    private View eJP = null;
    private LinearLayout eJQ = null;
    private CompoundButton.OnCheckedChangeListener eJR = null;
    private TextView eJS = null;
    private TextView eJT = null;
    private String eJU = null;
    private com.baidu.tbadk.core.dialog.b eJV = null;
    private com.baidu.tbadk.core.dialog.b eJW = null;
    private boolean eJX = false;
    private boolean eJY = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eJZ = null;
    private boolean dOR = false;
    private Button eKa = null;
    private boolean eKg = true;
    private com.baidu.tbadk.core.view.a bqO = null;
    private boolean ezN = false;
    private int mSkinType = 3;
    private boolean eKl = false;
    private int eKx = 0;
    private boolean eKy = true;
    private a eKz = new a();
    private int eKB = 0;
    private boolean eKM = false;
    private int eKN = 0;
    private boolean eKO = false;
    private boolean eKP = false;
    private boolean eKQ = false;
    private int eKS = 0;
    private boolean eKV = false;
    private a.InterfaceC0124a eKZ = new a.InterfaceC0124a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0124a
        public void lc() {
        }
    };
    private final CustomMessageListener eLe = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_IMG_TO_EMOTION_CONNECTION_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921305) {
                an.this.aQU();
            }
        }
    };
    private String eLf = null;
    private CustomMessageListener eLg = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.eLf = null;
            }
        }
    };
    private CustomMessageListener dJM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.eJC != null) {
                an.this.eJC.notifyDataSetChanged();
            }
        }
    };
    private Handler eLh = new Handler();
    private CustomMessageListener eLj = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.eKg = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eLl = true;
    View.OnClickListener eLm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (an.this.eKO) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == an.this.eIN.ePJ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (an.this.eDo.eBF.eOP != null) {
                if (!an.this.eKO && an.this.eFA != null && an.this.eFA.aMW() != null && an.this.eFA.aMW().getAuthor() != null && an.this.eFA.aMW().getAuthor().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                an.this.eDo.eBF.eOP.onClick(view);
            }
        }
    };
    private boolean eLn = false;
    private boolean Ze = false;
    String userId = null;
    private final List<TbImageView> eLo = new ArrayList();
    private boolean eLp = false;

    public void jp(boolean z) {
        this.eKM = z;
        if (this.eIR != null) {
            this.eKN = this.eIR.getHeaderViewsCount();
        }
    }

    public void aQJ() {
        if (this.eIR != null) {
            int headerViewsCount = this.eIR.getHeaderViewsCount() - this.eKN;
            final int firstVisiblePosition = (this.eIR.getFirstVisiblePosition() == 0 || this.eIR.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.eIR.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.eIR.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.eKz.eLF = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKz));
            final ag agVar = this.eKz.eLF;
            final int d = d(agVar);
            final int y = ((int) this.eJB.getY()) + this.eJB.getMeasuredHeight();
            final boolean z = this.eKt.getVisibility() == 0;
            boolean z2 = this.eJB.getY() < 0.0f;
            if ((z && agVar != null) || firstVisiblePosition >= this.eJC.aPe() + this.eIR.getHeaderViewsCount()) {
                int measuredHeight = agVar != null ? agVar.eIm.getMeasuredHeight() : 0;
                if (z2) {
                    this.eIR.setSelectionFromTop(this.eJC.aPe() + this.eIR.getHeaderViewsCount(), eKw - measuredHeight);
                } else {
                    this.eIR.setSelectionFromTop(this.eJC.aPe() + this.eIR.getHeaderViewsCount(), this.eIN.aSG().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.eIR.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.eKO) {
                this.eIR.setSelectionFromTop(this.eJC.aPe() + this.eIR.getHeaderViewsCount(), this.eII.aUj().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.eIR.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aPo() {
                        if (d >= 0 && d <= an.this.ccH.getMeasuredHeight()) {
                            int d2 = an.this.d(agVar);
                            int i = d2 - d;
                            if (z && i != 0 && d <= y) {
                                i = d2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = an.this.bQE.getLayoutParams();
                            if (i == 0 || i > an.this.ccH.getMeasuredHeight() || d2 >= an.this.ccH.getMeasuredHeight()) {
                                layoutParams.height = an.this.eKI;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.ccH.getMeasuredHeight()) {
                                layoutParams.height = an.this.eKI;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                an.this.eIR.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            an.this.bQE.setLayoutParams(layoutParams);
                        }
                        an.this.eIR.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(ag agVar) {
        if (agVar == null || agVar.getView() == null) {
            return 0;
        }
        if (agVar.getView().getTop() != 0 || agVar.getView().isShown()) {
            return agVar.getView().getBottom();
        }
        return 0;
    }

    public c aQK() {
        return this.eLb;
    }

    public NoNetworkView aQL() {
        return this.ccF;
    }

    public void aQM() {
        if (this.JH != null) {
            this.JH.hide();
            if (this.eKX != null) {
                this.eKX.adm();
            }
        }
    }

    public PbFakeFloorModel aQN() {
        return this.eEZ;
    }

    public q aQO() {
        return this.eKK;
    }

    public void aQP() {
        reset();
        aQM();
        this.eKK.aPl();
        hg(false);
    }

    private void reset() {
        if (this.eDo != null && this.eDo.aNX() != null && this.JH != null) {
            com.baidu.tbadk.editortools.pb.a.CP().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aNX = this.eDo.aNX();
            aNX.Dj();
            if (aNX.getWriteImagesInfo() != null) {
                aNX.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aNX.eX(10);
            aNX.eV(SendView.ALL);
            aNX.eW(SendView.ALL);
            com.baidu.tbadk.editortools.l eM = this.JH.eM(23);
            com.baidu.tbadk.editortools.l eM2 = this.JH.eM(2);
            com.baidu.tbadk.editortools.l eM3 = this.JH.eM(5);
            if (eM2 != null) {
                eM2.lM();
            }
            if (eM3 != null) {
                eM3.lM();
            }
            if (eM != null) {
                eM.hide();
            }
            this.JH.invalidate();
        }
    }

    public boolean aQQ() {
        return this.eKg;
    }

    public void hh(boolean z) {
        if (this.eKb != null && this.eKc != null) {
            this.eKc.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eKb.startAnimation(alphaAnimation);
            }
            this.eKb.setVisibility(0);
            this.eKg = true;
            if (this.eKA != null) {
                this.eKA.setVisibility(0);
                ju(true);
            }
        }
    }

    public void hi(boolean z) {
        if (this.eKb != null && this.eKc != null) {
            this.eKc.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eKb.startAnimation(alphaAnimation);
            }
            this.eKb.setVisibility(0);
            this.eKg = true;
            if (this.eKA != null) {
                this.eKA.setVisibility(0);
                ju(true);
            }
        }
    }

    public PostData aQR() {
        int i = 0;
        if (this.eIR == null) {
            return null;
        }
        int aQS = aQS() - this.eIR.getHeaderViewsCount();
        if (aQS < 0) {
            aQS = 0;
        }
        if (this.eJC.pf(aQS) != null && this.eJC.pf(aQS) != PostData.ggt) {
            i = aQS + 1;
        }
        return this.eJC.getItem(i) instanceof PostData ? (PostData) this.eJC.getItem(i) : null;
    }

    public int aQS() {
        int i;
        View childAt;
        if (this.eIR == null) {
            return 0;
        }
        int firstVisiblePosition = this.eIR.getFirstVisiblePosition();
        int lastVisiblePosition = this.eIR.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eIR.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.eIR.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aQT() {
        return this.eIR.getHeaderViewsCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQU() {
        if (this.eJJ == null) {
            this.eJJ = new com.baidu.tbadk.core.dialog.a(this.eDo);
            this.eJJ.cc(d.l.img_to_emotion_tip);
            this.eJJ.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.33
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.editortools.pb.c aNX = an.this.eDo.aNX();
                    if (aNX.getWriteImagesInfo() != null) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) an.this.eDo, aNX.getWriteImagesInfo().toJsonString(), true, true);
                        albumActivityConfig.getIntent().putExtra("from", "pb");
                        if (!StringUtils.isNull(an.this.mForumId, true)) {
                            albumActivityConfig.getIntent().putExtra("forum_id", an.this.mForumId);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        aVar.dismiss();
                    }
                }
            });
            this.eJJ.a(d.l.go_to_add, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.34
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    an.this.eDo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(an.this.eDo.getPageContext().getPageActivity())));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL));
                    if (an.this.eDo.checkUpIsLogin()) {
                        if (an.this.JH != null) {
                            an.this.aRc();
                            an.this.JH.L((View) an.this.JH.eM(5));
                        }
                        if (an.this.JH != null) {
                            an.this.eKg = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eDo, (View) an.this.JH.eO(2).aAv, false, an.this.eKZ);
                        }
                        an.this.aRD();
                        aVar.dismiss();
                    }
                }
            });
            this.eJJ.b(this.eDo.getPageContext());
        }
        this.eJJ.tb();
    }

    public void e(TbRichText tbRichText) {
        PostData postData;
        if (this.eFA != null && this.eFA.aMY() != null && !this.eFA.aMY().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eFA.aMY().size() && (postData = this.eFA.aMY().get(i2)) != null && postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getUserId())) {
                    if (!this.eFA.aMY().get(i2).getAuthor().getUserId().equals(tbRichText.getAuthorId())) {
                        i = i2 + 1;
                    } else {
                        if (this.eKA != null) {
                            this.eKA.jE(true);
                        }
                        this.eLf = postData.getAuthor().getName_show();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public an(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eDo = null;
        this.ccH = null;
        this.crU = null;
        this.eIR = null;
        this.eIT = null;
        this.eIW = null;
        this.eIY = null;
        this.eJa = null;
        this.eJc = null;
        this.eJd = null;
        this.eJg = null;
        this.eJh = null;
        this.eJi = null;
        this.eJo = null;
        this.eJr = null;
        this.eJs = null;
        this.eJt = null;
        this.eJu = null;
        this.eJy = null;
        this.eJz = null;
        this.eJC = null;
        this.cuQ = null;
        this.aHI = null;
        this.crI = null;
        this.ezR = null;
        this.eKb = null;
        this.eKc = null;
        this.eKd = null;
        this.eKe = null;
        this.eKf = null;
        this.eKm = null;
        this.eKn = null;
        this.eKo = null;
        this.eKR = 0;
        this.eDo = pbActivity;
        this.crI = onClickListener;
        this.aSk = cVar;
        this.eKR = com.baidu.adp.lib.util.l.ad(this.eDo) - com.baidu.adp.lib.util.l.f(this.eDo, d.f.ds200);
        this.ccH = (RelativeLayout) LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.eDo.addContentView(this.ccH, new FrameLayout.LayoutParams(-1, -1));
        this.crU = this.eDo.findViewById(d.h.statebar_view);
        this.eJB = (ObservedChangeLinearLayout) this.eDo.findViewById(d.h.title_wrapper);
        this.ccF = (NoNetworkView) this.eDo.findViewById(d.h.view_no_network);
        this.eIR = (PbLandscapeListView) this.eDo.findViewById(d.h.new_pb_list);
        this.eKs = (FrameLayout) this.eDo.findViewById(d.h.root_float_header);
        this.awN = new TextView(this.eDo.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds98));
        this.eIR.addHeaderView(this.awN, 0);
        this.eKI = this.eDo.getResources().getDimensionPixelSize(d.f.ds100);
        this.bQE = new View(this.eDo.getPageContext().getPageActivity());
        this.bQE.setLayoutParams(new AbsListView.LayoutParams(-1, this.eKI));
        this.bQE.setVisibility(4);
        this.eIR.addFooterView(this.bQE);
        this.eIR.setOnTouchListener(this.eDo.aLM);
        this.eIN = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eDo.aOA()) {
            this.eIP = (ViewStub) this.eDo.findViewById(d.h.manga_view_stub);
            this.eIP.setVisibility(0);
            this.eIO = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.eIO.show();
            this.eIN.mNavigationBar.setVisibility(8);
            layoutParams.height -= eKw;
        }
        this.awN.setLayoutParams(layoutParams);
        this.eIN.aSG().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0110a() { // from class: com.baidu.tieba.pb.pb.main.an.36
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0110a
            public void ahP() {
                if (an.this.eIR != null) {
                    if (an.this.eII != null) {
                        an.this.eII.aUk();
                    }
                    an.this.eIR.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0110a
            public void ahO() {
                an.this.eDo.ahd();
            }
        }));
        this.eKb = this.eDo.findViewById(d.h.pb_editor_tool_comment);
        this.eKi = com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds90);
        this.eKj = com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds242);
        this.eKc = (TextView) this.eDo.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.eKe = (ImageView) this.eDo.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_more_img);
        this.eKd = (ImageView) this.eDo.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_emotion_img);
        this.eKf = (TextView) this.eDo.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.eKf.setVisibility(8);
        this.eKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.aRS();
                if (!an.this.eDo.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac("fid", an.this.mForumId));
                } else if (an.this.eFA == null || !com.baidu.tieba.pb.f.T(an.this.eFA.aMW())) {
                    if (an.this.JH != null) {
                        an.this.aRc();
                    }
                    if (an.this.JH != null) {
                        an.this.eKg = false;
                        com.baidu.tieba.tbadkCore.b.a.a(an.this.eDo, (View) an.this.JH.eO(2).aAv, false, an.this.eKZ);
                    }
                    an.this.aRD();
                }
            }
        });
        this.eKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.aRS();
                if (an.this.eDo.checkUpIsLogin()) {
                    if (an.this.eFA == null || !com.baidu.tieba.pb.f.T(an.this.eFA.aMW())) {
                        if (an.this.JH != null) {
                            an.this.aRc();
                            an.this.JH.L((View) an.this.JH.eM(5));
                        }
                        if (an.this.JH != null) {
                            an.this.eKg = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eDo, (View) an.this.JH.eO(2).aAv, false, an.this.eKZ);
                        }
                        an.this.aRD();
                    }
                }
            }
        });
        this.eKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.aRS();
                if (an.this.eDo.checkUpIsLogin()) {
                    if (an.this.eFA == null || !com.baidu.tieba.pb.f.T(an.this.eFA.aMW())) {
                        if (an.this.JH != null) {
                            an.this.aRc();
                            an.this.JH.L((View) an.this.JH.eM(2));
                        }
                        if (an.this.JH != null) {
                            an.this.eKg = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eDo, (View) an.this.JH.eO(2).aAv, false, an.this.eKZ);
                        }
                        an.this.aRD();
                    }
                }
            }
        });
        this.eKf.setOnClickListener(this.crI);
        this.eKf.setOnTouchListener(this.eDo);
        this.eIT = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eIW = (LinearLayout) LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eIX = new d(this.eDo, this.eIW);
        this.eIX.init();
        this.eIX.a(this.eIX.aNW(), this.crI);
        this.eIY = (ColumnLayout) this.eIW.findViewById(d.h.pb_head_owner_root);
        this.eIZ = (ThreadSkinView) this.eIW.findViewById(d.h.pb_thread_skin);
        this.eIY.setOnLongClickListener(this.onLongClickListener);
        this.eIY.setOnTouchListener(this.aSk);
        this.eIY.setVisibility(8);
        this.eIT.setOnTouchListener(this.aSk);
        this.eKm = this.eIT.findViewById(d.h.pb_head_activity_join_number_container);
        this.eKm.setVisibility(8);
        this.eKn = (TextView) this.eIT.findViewById(d.h.pb_head_activity_join_number);
        this.eJa = (TextView) this.eIY.findViewById(d.h.pb_head_owner_info_user_name);
        this.eJb = (TextView) this.eIW.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eJc = this.eIW.findViewById(d.h.line_right_user_intro);
        this.eJd = (TextView) this.eIY.findViewById(d.h.floor_owner);
        this.eJe = (ImageView) this.eIY.findViewById(d.h.icon_forum_level);
        this.eJg = (FrameLayout) this.eIY.findViewById(d.h.pb_head_headImage_container);
        this.eJh = (HeadImageView) this.eIY.findViewById(d.h.pb_head_owner_photo);
        this.eJf = (HeadPendantView) this.eIY.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eJf.vZ();
        if (this.eJf.getHeadView() != null) {
            this.eJf.getHeadView().setIsRound(true);
            this.eJf.getHeadView().setDrawBorder(false);
        }
        if (this.eJf.getPendantView() != null) {
            this.eJf.getPendantView().setIsRound(true);
            this.eJf.getPendantView().setDrawBorder(false);
        }
        this.eEA = (UserIconBox) this.eIY.findViewById(d.h.show_icon_vip);
        this.eEB = (UserIconBox) this.eIY.findViewById(d.h.show_icon_yinji);
        this.eJj = (FloatingLayout) this.eIW.findViewById(d.h.pb_head_owner_info_root);
        this.eJo = (PbFirstFloorUserLikeButton) this.eIY.findViewById(d.h.pb_like_button);
        this.eJr = (TextView) this.eIY.findViewById(d.h.pb_views);
        this.eJs = (TextView) this.eIY.findViewById(d.h.pb_item_first_floor_reply_time);
        this.eJt = (TextView) this.eIY.findViewById(d.h.pb_item_first_floor_location_address);
        this.eJu = this.eIY.findViewById(d.h.line_between_time_and_locate);
        this.eLc = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eLd = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eJy = this.eIT.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.eJz = this.eIT.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eIT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.eKo = (ViewStub) this.ccH.findViewById(d.h.interview_status_stub);
        this.eJC = new f(this.eDo, this.eIR);
        this.eJC.p(this.crI);
        this.eJC.setTbGestureDetector(this.aSk);
        this.eJC.setOnImageClickListener(this.aSj);
        this.ezR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.Xj() || !com.baidu.tieba.c.a.a(an.this.eDo.getBaseContext(), an.this.eDo.aOd().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                an.this.eDo.c(sparseArray);
                                return;
                            }
                            an.this.bk(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        an.this.eDo.c(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eJC.C(this.ezR);
        aQX();
        this.eIR.addHeaderView(this.eIU);
        this.eIR.addHeaderView(this.eIW);
        this.eIR.addHeaderView(this.eIT);
        this.cuQ = new PbListView(this.eDo.getPageContext().getPageActivity());
        this.aHI = this.cuQ.getView().findViewById(d.h.pb_more_view);
        if (this.aHI != null) {
            this.aHI.setOnClickListener(this.crI);
            com.baidu.tbadk.core.util.aj.j(this.aHI, d.g.pb_foot_more_trans_selector);
        }
        this.cuQ.wi();
        this.cuQ.dv(d.g.pb_foot_more_trans_selector);
        this.cuQ.dx(d.g.pb_foot_more_trans_selector);
        this.eJI = this.eDo.findViewById(d.h.viewstub_progress);
        this.eDo.registerListener(this.eLj);
        this.eJi = com.baidu.tbadk.ala.b.nr().g(this.eDo.getActivity(), 2);
        if (this.eJi != null) {
            this.eJi.setVisibility(8);
            this.eJj.addView(this.eJi);
        }
        this.eEZ = new PbFakeFloorModel(this.eDo.getPageContext());
        this.eKK = new q(this.eDo.getPageContext(), this.eEZ, this.ccH);
        this.eEZ.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void m(PostData postData) {
                an.this.eEZ.n(postData);
                an.this.eJC.notifyDataSetChanged();
                an.this.eKK.aPl();
                an.this.JH.AH();
                an.this.hg(false);
            }
        });
        if (this.eDo.aOd() != null && !StringUtils.isNull(this.eDo.aOd().aPW())) {
            this.eDo.showToast(this.eDo.aOd().aPW());
        }
        this.eKt = this.eDo.findViewById(d.h.pb_expand_blank_view);
        this.eKu = this.eDo.findViewById(d.h.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKu.getLayoutParams();
        if (this.eDo.aOd() != null && this.eDo.aOd().aPu()) {
            this.eKt.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.eKu.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = eKw;
            this.eKu.setLayoutParams(layoutParams2);
        }
        this.eKv = new ag(this.eDo.getPageContext(), this.eDo.findViewById(d.h.pb_reply_expand_view));
        this.eKv.eIm.setVisibility(8);
        this.eKv.D(this.crI);
        this.eDo.registerListener(this.dJM);
        this.eDo.registerListener(this.eLe);
        this.eDo.registerListener(this.eLg);
        ju(false);
    }

    public View aQV() {
        return this.eKt;
    }

    public void aQW() {
        if (this.eIR != null) {
            this.eIR.removeHeaderView(this.eIU);
            this.eIR.removeHeaderView(this.eIW);
            this.eIR.removeHeaderView(this.eIT);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eKA == null) {
            this.eKA = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eDo.getPageContext().getPageActivity());
            ju(true);
            this.eKA.a(this.ccH, aVar, this.eKb.getVisibility() == 0);
            this.eKA.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.6
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(an.this.eLf)) {
                        emotionImageData.setAuthorNameShow(an.this.eLf);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    an.this.eDo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(an.this.eDo.getPageContext().getPageActivity(), 25016, str, list, an.this.eLf, list2)));
                }
            });
            this.eKA.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.an.7
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void X(float f) {
                    an.this.aRS();
                    if (an.this.eKb != null) {
                        ViewGroup.LayoutParams layoutParams = an.this.eKb.getLayoutParams();
                        layoutParams.height = (int) (((an.this.eKj - an.this.eKi) * f) + an.this.eKi);
                        an.this.eKc.setAlpha(1.0f - f);
                        an.this.eKe.setAlpha(1.0f - f);
                        an.this.eKd.setAlpha(1.0f - f);
                        an.this.eKb.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aQX() {
        if (this.eIU == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds34);
            this.eIU = new LinearLayout(this.eDo.getPageContext().getPageActivity());
            this.eIU.setOrientation(1);
            this.eIU.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eIU.setPadding(f, com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds40), f, com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds46));
            this.eIU.setGravity(17);
            this.eIV = new TextView(this.eDo.getPageContext().getPageActivity());
            this.eIV.setGravity(3);
            this.eIV.setMaxLines(2);
            this.eIV.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eIV.setPadding(0, 0, 0, 0);
            this.eIV.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.eIV, d.e.cp_cont_b);
            this.eIV.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds48));
            this.eIV.setVisibility(8);
            this.eIU.addView(this.eIV);
            this.eIU.setOnTouchListener(this.aSk);
            this.eIU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQY() {
        if (this.eDo.aOA()) {
            this.eIQ = (ViewStub) this.eDo.findViewById(d.h.manga_mention_controller_view_stub);
            this.eIQ.setVisibility(0);
            if (this.eJv == null) {
                this.eJv = (LinearLayout) this.eDo.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.eDo.getPageContext(), this.eJv);
            }
            if (this.eJw == null) {
                this.eJw = (TextView) this.eJv.findViewById(d.h.manga_prev_btn);
            }
            if (this.eJx == null) {
                this.eJx = (TextView) this.eJv.findViewById(d.h.manga_next_btn);
            }
            this.eJw.setOnClickListener(this.crI);
            this.eJx.setOnClickListener(this.crI);
        }
    }

    private void aQZ() {
        if (this.eDo.aOA()) {
            if (this.eDo.aOD() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eJw, d.e.cp_cont_e, 1);
            }
            if (this.eDo.aOE() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eJx, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aRa() {
        if (this.eJv == null) {
            aQY();
        }
        this.eIQ.setVisibility(8);
        if (this.eLh != null && this.eLi != null) {
            this.eLh.removeCallbacks(this.eLi);
        }
    }

    public void aRb() {
        if (this.eLh != null) {
            if (this.eLi != null) {
                this.eLh.removeCallbacks(this.eLi);
            }
            this.eLi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.eJv == null) {
                        an.this.aQY();
                    }
                    an.this.eIQ.setVisibility(0);
                }
            };
            this.eLh.postDelayed(this.eLi, 2000L);
        }
    }

    public void jq(boolean z) {
        this.eIN.jq(z);
        if (z && this.eKl) {
            this.cuQ.setText(this.eDo.getResources().getString(d.l.click_load_more));
            this.eIR.setNextPage(this.cuQ);
            this.eIM = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.JH = iVar;
        this.JH.setId(d.h.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ccH.addView(this.JH, layoutParams);
        this.JH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQM();
        this.eDo.aNX().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.JH != null && an.this.JH.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.eKX == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.JH.getId());
                            an.this.eKX = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.eDo.getPageContext(), an.this.ccH, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.u(an.this.eKW)) {
                                an.this.eKX.setData(an.this.eKW);
                            }
                            an.this.eKX.b(an.this.JH);
                        }
                        an.this.eKX.pd(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void aRc() {
        if (this.eDo != null && this.JH != null) {
            this.JH.lM();
            aRD();
        }
    }

    public void R(String str, boolean z) {
        this.eKh = z;
        jr(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void jr(boolean z) {
        if (this.eKf != null) {
            if (this.eKh) {
                com.baidu.tbadk.core.util.aj.j(this.eKf, d.g.pb_praise_already_click_selector);
                this.eKf.setContentDescription(this.eDo.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.eKf, d.g.pb_praise_normal_click_selector);
            this.eKf.setContentDescription(this.eDo.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aRd() {
        return this.eKf;
    }

    public void js(boolean z) {
        if (this.eIR != null && this.awN != null && this.crU != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.crU.setVisibility(0);
                } else {
                    this.crU.setVisibility(8);
                    this.eIR.removeHeaderView(this.awN);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.awN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = eKw;
                    this.awN.setLayoutParams(layoutParams);
                }
                aRt();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.awN.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jA(true);
                this.awN.setLayoutParams(layoutParams2);
            }
            aRt();
            aRN();
        }
    }

    public f aRe() {
        return this.eJC;
    }

    public void aRf() {
        if (this.eJC != null) {
            this.eJC.aOZ();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eCz = cVar;
    }

    private void a(bk bkVar) {
        if (bkVar == null || bkVar.sO() == 0) {
            if (this.eKa != null) {
                this.eKa.setVisibility(8);
            }
            if (this.eJy != null) {
                this.eJy.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eKa == null) {
            this.eDo.getLayoutMode().t(((ViewStub) this.eIT.findViewById(d.h.live_talk_layout)).inflate());
            this.eKa = (Button) this.eIT.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.eJy = this.eIT.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int sP = bkVar.sP();
        String string = this.eDo.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (sP == 0) {
            string = string + this.eDo.getPageContext().getString(d.l.go_to_interview_post);
        } else if (sP == 1) {
            string = string + this.eDo.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.eKa.setText(string);
        this.eKa.setVisibility(0);
        this.eKa.setOnClickListener(this.crI);
        aRv();
    }

    public void bk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eJL == null) {
            this.eJL = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eDo.getLayoutMode().t(this.eJL);
        if (this.eJK == null) {
            this.eJK = new Dialog(this.eDo.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eJK.setCanceledOnTouchOutside(true);
            this.eJK.setCancelable(true);
            this.eJK.setContentView(this.eJL);
            WindowManager.LayoutParams attributes = this.eJK.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ad(this.eDo.getPageContext().getPageActivity()) * 0.9d);
            this.eJK.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eJK.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eJK.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eJK.findViewById(d.h.disable_reply_btn);
        int intValue = sparseArray.get(d.h.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(d.h.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(d.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(d.l.delete);
            } else {
                textView.setText(d.l.delete_post);
            }
            sparseArray2.put(d.h.tag_del_post_id, sparseArray.get(d.h.tag_del_post_id));
            sparseArray2.put(d.h.tag_del_post_type, sparseArray.get(d.h.tag_del_post_type));
            sparseArray2.put(d.h.tag_del_post_is_self, sparseArray.get(d.h.tag_del_post_is_self));
            sparseArray2.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eJK != null && (an.this.eJK instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eJK, an.this.eDo.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        an.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aRK()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(d.h.tag_forbid_user_name, sparseArray.get(d.h.tag_forbid_user_name));
            sparseArray5.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            sparseArray5.put(d.h.tag_forbid_user_post_id, sparseArray.get(d.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eJK != null && (an.this.eJK instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eJK, an.this.eDo.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && an.this.eLk != null) {
                        an.this.eLk.f(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.l.un_mute);
            } else {
                textView3.setText(d.l.mute);
            }
            sparseArray6.put(d.h.tag_is_mem, sparseArray.get(d.h.tag_is_mem));
            sparseArray6.put(d.h.tag_user_mute_mute_userid, sparseArray.get(d.h.tag_user_mute_mute_userid));
            sparseArray6.put(d.h.tag_user_mute_mute_username, sparseArray.get(d.h.tag_user_mute_mute_username));
            sparseArray6.put(d.h.tag_user_mute_post_id, sparseArray.get(d.h.tag_user_mute_post_id));
            sparseArray6.put(d.h.tag_user_mute_thread_id, sparseArray.get(d.h.tag_user_mute_thread_id));
            sparseArray6.put(d.h.tag_user_mute_msg, sparseArray.get(d.h.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eJK != null && (an.this.eJK instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eJK, an.this.eDo.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        an.this.eDo.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eJK, this.eDo.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eLk = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eKD, Integer.valueOf(eKE));
        int i3 = d.l.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.l.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.l.report_thread_confirm;
            } else {
                i3 = d.l.del_thread_confirm;
            }
        }
        this.eJM = new com.baidu.tbadk.core.dialog.a(this.eDo.getActivity());
        this.eJM.cc(i3);
        this.eJM.z(sparseArray);
        this.eJM.a(d.l.dialog_ok, this.eDo);
        this.eJM.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eJM.aq(true);
        this.eJM.b(this.eDo.getPageContext());
        this.eJM.tb();
    }

    public void aj(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eJP == null) {
            this.eJP = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eDo.getLayoutMode().t(this.eJP);
        if (this.eJO == null) {
            this.eJO = new Dialog(this.eDo.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eJO.setCanceledOnTouchOutside(true);
            this.eJO.setCancelable(true);
            this.eJZ = (ScrollView) this.eJP.findViewById(d.h.good_scroll);
            this.eJO.setContentView(this.eJP);
            WindowManager.LayoutParams attributes = this.eJO.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds540);
            this.eJO.getWindow().setAttributes(attributes);
            this.eJR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.18
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.eJU = (String) compoundButton.getTag();
                        if (an.this.eIS != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : an.this.eIS) {
                                String str = (String) aVar.getTag();
                                if (str != null && an.this.eJU != null && !str.equals(an.this.eJU)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eJQ = (LinearLayout) this.eJP.findViewById(d.h.good_class_group);
            this.eJT = (TextView) this.eJP.findViewById(d.h.dialog_button_cancel);
            this.eJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eJO instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(an.this.eJO, an.this.eDo.getPageContext());
                    }
                }
            });
            this.eJS = (TextView) this.eJP.findViewById(d.h.dialog_button_ok);
            this.eJS.setOnClickListener(this.crI);
        }
        this.eJQ.removeAllViews();
        this.eIS = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bH = bH("0", this.eDo.getPageContext().getString(d.l.def_good_class));
        this.eIS.add(bH);
        bH.setChecked(true);
        this.eJQ.addView(bH);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bH2 = bH(String.valueOf(arrayList.get(i2).pQ()), arrayList.get(i2).pP());
                this.eIS.add(bH2);
                View view = new View(this.eDo.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eJQ.addView(view);
                this.eJQ.addView(bH2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eJZ.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eDo.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eDo.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eDo.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eJZ.setLayoutParams(layoutParams2);
            this.eJZ.removeAllViews();
            this.eJZ.addView(this.eJQ);
        }
        com.baidu.adp.lib.g.g.a(this.eJO, this.eDo.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bH(String str, String str2) {
        Activity pageActivity = this.eDo.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.eJR);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aRg() {
        this.eDo.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eDo.hideProgressBar();
        if (z && z2) {
            this.eDo.showToast(this.eDo.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eDo.showToast(str);
        }
    }

    public void awW() {
        this.eJI.setVisibility(0);
    }

    public void awV() {
        this.eJI.setVisibility(8);
    }

    public View aRh() {
        if (this.eJP != null) {
            return this.eJP.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aRi() {
        return this.eJU;
    }

    public View getView() {
        return this.ccH;
    }

    public void aRj() {
        com.baidu.adp.lib.util.l.a(this.eDo.getPageContext().getPageActivity(), this.eDo.getCurrentFocus());
    }

    public void jt(boolean z) {
        this.eDo.hideProgressBar();
        aCv();
    }

    public void aRk() {
        this.cuQ.wi();
        this.cuQ.wm();
    }

    public void aRl() {
        this.eDo.hideProgressBar();
        wn();
        this.eIR.completePullRefreshPostDelayed(2000L);
        aRv();
    }

    public void aRm() {
        this.eIR.completePullRefreshPostDelayed(2000L);
        aRv();
    }

    private void ju(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eKc.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eDo.getResources().getDimensionPixelSize(d.f.ds130) : this.eDo.getResources().getDimensionPixelSize(d.f.ds34);
        this.eKc.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eJC.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z, boolean z2) {
        if (this.eJV != null) {
            this.eJV.dismiss();
            this.eJV = null;
        }
        this.eJV = new com.baidu.tbadk.core.dialog.b(this.eDo.getPageContext().getPageActivity());
        this.eJV.cf(d.l.operation);
        if (z2) {
            this.eJV.a(new String[]{this.eDo.getPageContext().getString(d.l.copy)}, interfaceC0047b);
        } else if (!z) {
            this.eJV.a(new String[]{this.eDo.getPageContext().getString(d.l.copy), this.eDo.getPageContext().getString(d.l.mark)}, interfaceC0047b);
        } else {
            this.eJV.a(new String[]{this.eDo.getPageContext().getString(d.l.copy), this.eDo.getPageContext().getString(d.l.remove_mark)}, interfaceC0047b);
        }
        this.eJV.d(this.eDo.getPageContext());
        this.eJV.te();
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z) {
        if (this.eJW != null) {
            this.eJW.dismiss();
            this.eJW = null;
        }
        this.eJW = new com.baidu.tbadk.core.dialog.b(this.eDo.getPageContext().getPageActivity());
        this.eJW.cf(d.l.operation);
        if (z) {
            this.eJW.a(new String[]{this.eDo.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0047b);
        } else {
            this.eJW.a(new String[]{this.eDo.getPageContext().getString(d.l.save_to_emotion), this.eDo.getPageContext().getString(d.l.save_to_local)}, interfaceC0047b);
        }
        this.eJW.d(this.eDo.getPageContext());
        this.eJW.te();
    }

    public int aRn() {
        return pt(this.eIR.getFirstVisiblePosition());
    }

    private int pt(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eIR.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eIR.getAdapter() == null || !(this.eIR.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eIR.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aRo() {
        int lastVisiblePosition = this.eIR.getLastVisiblePosition();
        if (this.eII != null) {
            if (lastVisiblePosition == this.eIR.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.eJC.aPa();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pt(lastVisiblePosition);
    }

    public void pu(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.eIR != null) {
            if (this.eIN == null || this.eIN.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.eIN.mNavigationBar.getFixedNavHeight();
                boolean isUseStyleImmersiveSticky = this.eDo.isUseStyleImmersiveSticky();
                boolean z = this.eDo.aOn() != -1;
                if (isUseStyleImmersiveSticky) {
                    fixedNavHeight -= eKw;
                }
                if (z) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.eKu != null && (layoutParams = (LinearLayout.LayoutParams) this.eKu.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.eKu.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.eIR.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.eIR.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eJF.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        this.eJC.a(fVar, false);
        this.eJC.notifyDataSetChanged();
        aRv();
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        if (this.eJm == null) {
            this.eDo.getLayoutMode().t(((ViewStub) this.eIT.findViewById(d.h.praise_layout)).inflate());
            this.eJm = (FrsPraiseView) this.eIT.findViewById(d.h.pb_head_praise_view);
            this.eJm.setIsFromPb(true);
            this.eJA = this.eIT.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eJm.dD(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eJm != null) {
            boolean aRv = aRv();
            this.eJm.setVisibility(8);
            if (fVar != null && fVar.qq() != null && fVar.qq().qn() == 0 && this.ezN) {
                if (aRv) {
                    this.eJz.setVisibility(0);
                    return;
                } else {
                    this.eJz.setVisibility(8);
                    return;
                }
            }
            this.eJz.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aNf() != null) {
            return fVar.aNf();
        }
        if (!com.baidu.tbadk.core.util.v.u(fVar.aMY())) {
            Iterator<PostData> it = fVar.aMY().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.brq() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aNd();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
            postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aMW() == null || fVar.aMW().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aMW().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aMW().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tA(1);
        postData.setId(fVar.aMW().rE());
        postData.setTitle(fVar.aMW().getTitle());
        postData.setTime(fVar.aMW().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x054c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x037d  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String e;
        ArrayList<IconData> tShowInfoNew;
        int f;
        com.baidu.tbadk.data.g brt;
        String portrait;
        if (fVar != null && fVar.aMW() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aRL();
            this.eIY.setVisibility(8);
            if (fVar.aMW() != null && fVar.aMW().sb() && fVar.aMW().rF() != null) {
                this.eKO = true;
                this.eIN.jL(this.eKO);
                if (this.eII == null) {
                    this.eII = new com.baidu.tieba.pb.video.i(this.eDo, this.eIN, fVar.aMW().rF());
                    this.eII.a(fVar.aMW().rF(), fVar.aMW(), fVar.getForumId());
                    this.eII.startPlay();
                } else if (this.eIL) {
                    this.eII.a(fVar.aMW().rF(), fVar.aMW(), fVar.getForumId());
                    this.eII.startPlay();
                } else {
                    this.eII.pq(fVar.getForumId());
                }
                if (fVar.aMX() != null && fVar.aMX().size() >= 1) {
                    bh bhVar = fVar.aMX().get(0);
                    this.eII.ac(bhVar);
                    this.eII.pr(bhVar.getTitle());
                }
                this.eII.b(b, fVar.aMW(), fVar.aNs());
                this.eIL = false;
                this.eIR.removeHeaderView(this.eII.aUl());
                this.eIR.addHeaderView(this.eII.aUl(), 0);
                if (this.eII.aUj() != null && this.eII.aUj().getParent() == null) {
                    this.eKs.addView(this.eII.aUj());
                }
                if (this.eIJ == null) {
                    this.eIJ = new com.baidu.tieba.pb.video.h(this.eDo);
                }
                this.eIJ.a(fVar.aMW().ss(), fVar.aMW(), fVar.aNp());
                this.eIR.removeHeaderView(this.eIJ.aUa());
                this.eIR.addHeaderView(this.eIJ.aUa(), 1);
                if (fVar.aMW().ss() != null) {
                    this.eIR.removeHeaderView(this.eIJ.aUb());
                    this.eIR.removeHeaderView(this.eIW);
                    this.eIR.addHeaderView(this.eIJ.aUb(), 2);
                } else {
                    if (this.eIJ.aUb() != null) {
                        this.eIR.removeHeaderView(this.eIJ.aUb());
                    }
                    this.eIR.removeHeaderView(this.eIW);
                    this.eIR.addHeaderView(this.eIW, 2);
                }
                if (this.eII != null) {
                    this.eIN.jH(false);
                    this.eIN.jI(TbadkCoreApplication.isLogin());
                    this.eII.pG(0);
                }
                aRt();
            } else {
                this.eKO = false;
                this.eIN.jL(this.eKO);
                if (this.eII != null) {
                    this.eIR.removeHeaderView(this.eII.aUl());
                }
                if (this.eIJ != null) {
                    this.eIJ.e(this.eIR);
                }
            }
            if (this.eDo.aOb() != null) {
                this.eDo.aOb().jF(this.eKO);
            }
            if (this.eII != null) {
                this.eII.F(this.eLm);
            }
            if (b != null) {
                this.eKk = b;
                this.eIY.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eIY.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eIY.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, b);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eLa) {
                    this.eIU.setVisibility(0);
                }
                if (!fVar.aMW().sb() && this.eIV.getText() != null && this.eIV.getText().length() > 0) {
                    this.eIV.setVisibility(0);
                } else {
                    this.eIV.setVisibility(8);
                }
                o(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rz = fVar.aMW().rz();
                if (rz != null && rz.size() > 0 && !this.eLa) {
                    this.eKn.setText(String.valueOf(rz.get(0).pg()));
                    this.eKm.setVisibility(0);
                } else {
                    this.eKm.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.eKm, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.eKn, d.e.cp_link_tip_d, 1);
                if (b.getAuthor() != null) {
                    String string = b.getAuthor().getName_show() == null ? StringUtils.string(b.getAuthor().getUserName()) : StringUtils.string(b.getAuthor().getName_show());
                    if (StringUtils.isNull(b.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.k.aP(b.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aP(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aP = com.baidu.adp.lib.util.k.aP(b.getAuthor().getName_show());
                                if (aP + i2 > 14) {
                                    i3 = 0;
                                } else if (aP + i2 >= 12) {
                                    i3 = 1;
                                } else if (aP + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = b.getAuthor().getIconInfo();
                            tShowInfoNew = b.getAuthor().getTShowInfoNew();
                            if (this.eEB != null) {
                                this.eEB.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                                this.eEB.setOnClickListener(this.eDo.eBF.cBc);
                                this.eEB.a(iconInfo, i3, this.eDo.getResources().getDimensionPixelSize(d.f.ds26), this.eDo.getResources().getDimensionPixelSize(d.f.ds26), this.eDo.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eEA != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eEA.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eEA.setOnClickListener(this.eDo.eBF.eOQ);
                                this.eEA.a(tShowInfoNew, 3, this.eDo.getResources().getDimensionPixelSize(d.f.ds36), this.eDo.getResources().getDimensionPixelSize(d.f.ds36), this.eDo.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eJa.setText(ag(b.getAuthor().getSealPrefix(), e));
                            this.eJa.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.eJa.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.u(tShowInfoNew) || b.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_cont_f, 1);
                            }
                            if (b == null && !TextUtils.isEmpty(b.getAuthor().getGodIntro())) {
                                this.eJb.setVisibility(0);
                                this.eJb.setText(am.b(b.getAuthor()));
                                this.eJc.setVisibility(0);
                            } else {
                                this.eJb.setVisibility(8);
                                this.eJc.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eJd, d.e.cp_link_tip_a, 1);
                            this.eJd.setVisibility(0);
                            if (fVar.aMW().getAuthor() != null && fVar.aMW().getAuthor().getAlaUserData() != null && this.eJi != null) {
                                if (fVar.aMW().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eJi.setVisibility(8);
                                } else {
                                    this.eJi.setVisibility(0);
                                    if (this.eIK == null) {
                                        this.eIK = new com.baidu.tieba.d.a(this.eDo.getPageContext(), this.eJi);
                                        this.eIK.m11if(1);
                                    }
                                    this.eIK.aL(this.eDo.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Qv = fVar.aMW().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eJi.setTag(aVar);
                                }
                            }
                            this.eJh.setUserId(b.getAuthor().getUserId());
                            this.eJh.setUserName(b.getAuthor().getUserName());
                            this.eJh.setImageDrawable(null);
                            this.eJh.setRadius(com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds40));
                            this.eJh.setTag(b.getAuthor().getUserId());
                            this.eJs.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds8);
                            if (this.eJb == null && this.eJb.getVisibility() == 0) {
                                this.eJs.setPadding(f, 0, f, 0);
                            } else {
                                this.eJs.setPadding(0, 0, f, 0);
                            }
                            brt = b.brt();
                            if (brt == null && !TextUtils.isEmpty(brt.getName()) && !TextUtils.isEmpty(brt.getName().trim())) {
                                final String name = brt.getName();
                                final String lat = brt.getLat();
                                final String lng = brt.getLng();
                                this.eJt.setVisibility(0);
                                this.eJu.setVisibility(0);
                                this.eJt.setText(brt.getName());
                                this.eJt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.21
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                an.this.eDo.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(an.this.eDo.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, an.this.eDo.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.eJt.setVisibility(8);
                                this.eJu.setVisibility(8);
                            }
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null && !StringUtils.isNull(b.getAuthor().getPendantData().pL())) {
                                UtilHelper.showHeadImageViewBigV(this.eJf.getHeadView(), b.getAuthor());
                                this.eJh.setVisibility(8);
                                this.eJf.setVisibility(0);
                                if (this.eJn != null) {
                                    this.eJn.setVisibility(8);
                                }
                                this.eJa.setOnClickListener(this.eLm);
                                this.eJf.getHeadView().c(portrait, 28, false);
                                this.eJf.getHeadView().setUserId(b.getAuthor().getUserId());
                                this.eJf.getHeadView().setUserName(b.getAuthor().getUserName());
                                this.eJf.getHeadView().setOnClickListener(this.eLm);
                                this.eJf.eh(b.getAuthor().getPendantData().pL());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eJh, b.getAuthor());
                                this.eJh.setVisibility(0);
                                this.eIY.setOnClickListener(this.eLm);
                                this.eJa.setOnClickListener(this.eLm);
                                this.eJh.setOnClickListener(this.eLm);
                                this.eJf.setVisibility(8);
                                this.eJh.c(portrait, 28, false);
                            }
                            String name_show = b.getAuthor().getName_show();
                            String userName = b.getAuthor().getUserName();
                            if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.eJa.setText(com.baidu.tieba.pb.c.al(this.eDo.getPageContext().getPageActivity(), this.eJa.getText().toString()));
                                this.eJa.setGravity(16);
                                this.eJa.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMy());
                                com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = b.getAuthor().getIconInfo();
                        tShowInfoNew = b.getAuthor().getTShowInfoNew();
                        if (this.eEB != null) {
                        }
                        if (this.eEA != null) {
                        }
                        this.eJa.setText(ag(b.getAuthor().getSealPrefix(), e));
                        this.eJa.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.eJa.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.u(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eJb.setVisibility(8);
                        this.eJc.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eJd, d.e.cp_link_tip_a, 1);
                        this.eJd.setVisibility(0);
                        if (fVar.aMW().getAuthor() != null) {
                            if (fVar.aMW().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eJh.setUserId(b.getAuthor().getUserId());
                        this.eJh.setUserName(b.getAuthor().getUserName());
                        this.eJh.setImageDrawable(null);
                        this.eJh.setRadius(com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds40));
                        this.eJh.setTag(b.getAuthor().getUserId());
                        this.eJs.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds8);
                        if (this.eJb == null) {
                        }
                        this.eJs.setPadding(0, 0, f, 0);
                        brt = b.brt();
                        if (brt == null) {
                        }
                        this.eJt.setVisibility(8);
                        this.eJu.setVisibility(8);
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eJh, b.getAuthor());
                        this.eJh.setVisibility(0);
                        this.eIY.setOnClickListener(this.eLm);
                        this.eJa.setOnClickListener(this.eLm);
                        this.eJh.setOnClickListener(this.eLm);
                        this.eJf.setVisibility(8);
                        this.eJh.c(portrait, 28, false);
                        String name_show2 = b.getAuthor().getName_show();
                        String userName2 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                            this.eJa.setText(com.baidu.tieba.pb.c.al(this.eDo.getPageContext().getPageActivity(), this.eJa.getText().toString()));
                            this.eJa.setGravity(16);
                            this.eJa.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMy());
                            com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = b.getAuthor().getIconInfo();
                            tShowInfoNew = b.getAuthor().getTShowInfoNew();
                            if (this.eEB != null) {
                            }
                            if (this.eEA != null) {
                            }
                            this.eJa.setText(ag(b.getAuthor().getSealPrefix(), e));
                            this.eJa.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.eJa.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.u(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_cont_h, 1);
                            if (b == null) {
                            }
                            this.eJb.setVisibility(8);
                            this.eJc.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.c(this.eJd, d.e.cp_link_tip_a, 1);
                            this.eJd.setVisibility(0);
                            if (fVar.aMW().getAuthor() != null) {
                            }
                            this.eJh.setUserId(b.getAuthor().getUserId());
                            this.eJh.setUserName(b.getAuthor().getUserName());
                            this.eJh.setImageDrawable(null);
                            this.eJh.setRadius(com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds40));
                            this.eJh.setTag(b.getAuthor().getUserId());
                            this.eJs.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds8);
                            if (this.eJb == null) {
                            }
                            this.eJs.setPadding(0, 0, f, 0);
                            brt = b.brt();
                            if (brt == null) {
                            }
                            this.eJt.setVisibility(8);
                            this.eJu.setVisibility(8);
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eJh, b.getAuthor());
                            this.eJh.setVisibility(0);
                            this.eIY.setOnClickListener(this.eLm);
                            this.eJa.setOnClickListener(this.eLm);
                            this.eJh.setOnClickListener(this.eLm);
                            this.eJf.setVisibility(8);
                            this.eJh.c(portrait, 28, false);
                            String name_show22 = b.getAuthor().getName_show();
                            String userName22 = b.getAuthor().getUserName();
                            if (com.baidu.tbadk.o.ac.fS()) {
                            }
                        }
                        e = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = b.getAuthor().getIconInfo();
                        tShowInfoNew = b.getAuthor().getTShowInfoNew();
                        if (this.eEB != null) {
                        }
                        if (this.eEA != null) {
                        }
                        this.eJa.setText(ag(b.getAuthor().getSealPrefix(), e));
                        this.eJa.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.eJa.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.u(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eJa, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eJb.setVisibility(8);
                        this.eJc.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eJd, d.e.cp_link_tip_a, 1);
                        this.eJd.setVisibility(0);
                        if (fVar.aMW().getAuthor() != null) {
                        }
                        this.eJh.setUserId(b.getAuthor().getUserId());
                        this.eJh.setUserName(b.getAuthor().getUserName());
                        this.eJh.setImageDrawable(null);
                        this.eJh.setRadius(com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds40));
                        this.eJh.setTag(b.getAuthor().getUserId());
                        this.eJs.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.ds8);
                        if (this.eJb == null) {
                        }
                        this.eJs.setPadding(0, 0, f, 0);
                        brt = b.brt();
                        if (brt == null) {
                        }
                        this.eJt.setVisibility(8);
                        this.eJu.setVisibility(8);
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eJh, b.getAuthor());
                        this.eJh.setVisibility(0);
                        this.eIY.setOnClickListener(this.eLm);
                        this.eJa.setOnClickListener(this.eLm);
                        this.eJh.setOnClickListener(this.eLm);
                        this.eJf.setVisibility(8);
                        this.eJh.c(portrait, 28, false);
                        String name_show222 = b.getAuthor().getName_show();
                        String userName222 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eIX.V(fVar.aMW());
                }
                if (this.eKv != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eyN);
                    if (fVar != null && fVar.aMW() != null) {
                        jVar.eyP = fVar.aMW().rg();
                    }
                    jVar.aEt = !this.ezN;
                    jVar.eyQ = this.eDo.aON();
                    this.eKv.a(jVar);
                }
            }
        }
    }

    public void jv(boolean z) {
        if (z) {
            aRp();
        } else {
            aRq();
        }
        this.eKz.eLF = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKz));
        a(this.eKz.eLF, false);
    }

    public void aRp() {
        if (this.eIN != null && !this.eKQ) {
            this.eIN.jM(!StringUtils.isNull(this.eDo.aOk()));
            this.eKQ = true;
        }
    }

    public void aRq() {
        if (this.eIN != null) {
            this.eIN.aSM();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rJ() != null) {
            this.eIZ.a(this.eDo.getPageContext(), fVar.aMY().get(0).rJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aMU().getId(), fVar.aMU().getName(), fVar.aMW().getId(), this.eDo.aOK() ? "FRS" : null));
            this.eIY.setPadding(this.eIY.getPaddingLeft(), (int) this.eDo.getResources().getDimension(d.f.ds20), this.eIY.getPaddingRight(), this.eIY.getPaddingBottom());
            return;
        }
        this.eIZ.a(null, null, null);
    }

    public void aRr() {
        if (this.eII != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.eII.aUk();
            this.eIR.smoothScrollToPosition(0);
        }
    }

    public boolean aRs() {
        return this.eLn;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean N(bh bhVar) {
        if (bhVar == null || bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eIN.aSK();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eIN.na(eVar.forumName);
            }
            String string = this.eDo.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eDo.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eDo.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eDo.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eya;
            this.eDo.showNetRefreshView(this.ccH, format, null, this.eDo.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.22
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        av.vA().c(an.this.eDo.getPageContext(), new String[]{str2});
                        an.this.eDo.finish();
                        return;
                    }
                    an.this.eDo.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aQA;
        Parcelable aQA2;
        String str;
        if (fVar != null) {
            this.eFA = fVar;
            this.mType = i;
            if (fVar.aMW() != null) {
                this.eKB = fVar.aMW().rb();
                this.Ze = fVar.aMW().qX();
                if (fVar.aMW().getAnchorLevel() != 0) {
                    this.eLn = true;
                }
                this.eJY = N(fVar.aMW());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            r(fVar);
            this.eKl = false;
            this.ezN = z;
            aRl();
            b(fVar, z, i);
            p(fVar);
            if (this.eDo.aOA()) {
                if (this.eJG == null) {
                    this.eJG = new com.baidu.tieba.pb.view.i(this.eDo.getPageContext());
                    this.eJG.ld();
                    this.eJG.a(this.amd);
                }
                this.eIR.setPullRefresh(this.eJG);
                aRt();
                if (this.eJG != null) {
                    this.eJG.dy(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qq().qn() == 0 && z) {
                this.eIR.setPullRefresh(null);
            } else {
                if (this.eJG == null) {
                    this.eJG = new com.baidu.tieba.pb.view.i(this.eDo.getPageContext());
                    this.eJG.ld();
                    this.eJG.a(this.amd);
                }
                this.eIR.setPullRefresh(this.eJG);
                aRt();
                if (this.eJG != null) {
                    this.eJG.dy(TbadkCoreApplication.getInst().getSkinType());
                }
                Sr();
            }
            aRv();
            this.eJC.iE(this.ezN);
            this.eJC.iF(false);
            this.eJC.iR(i == 5);
            this.eJC.iS(i == 6);
            this.eJC.iT(z2 && this.eLl);
            this.eJC.a(fVar, false);
            this.eJC.notifyDataSetChanged();
            if (this.eDo.aOO()) {
                if (fVar.aMV() != null) {
                    this.mForumName = fVar.aMV().getForumName();
                    this.mForumId = fVar.aMV().getForumId();
                }
                if (this.mForumName == null && this.eDo.aOd() != null && this.eDo.aOd().aPr() != null) {
                    this.mForumName = this.eDo.aOd().aPr();
                }
                this.eIN.na(this.mForumName);
            } else {
                this.eIN.na(null);
            }
            if (this.eDo.aOO()) {
                this.eKS = 0;
                PostData b = b(fVar, z);
                if (b != null && b.getAuthor() != null) {
                    this.eKS = b.getAuthor().getLevel_id();
                }
                if (this.eKS > 0) {
                    this.eJe.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.eJe, BitmapHelper.getGradeResourceIdInEnterForum(this.eKS));
                } else {
                    this.eJe.setVisibility(8);
                }
            } else {
                this.eJe.setVisibility(8);
            }
            if (fVar.aMW() != null && fVar.aMW().re() != null) {
                if (fVar.aMW().re().getNum() < 1) {
                    str = this.eDo.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aMW().re().getNum() + "";
                }
                if (this.eIH != -1) {
                    fVar.aMW().re().setIsLike(this.eIH);
                }
                R(str, fVar.aMW().re().getIsLike() == 1);
            }
            if (this.eDo.isLogin()) {
                this.eIR.setNextPage(this.cuQ);
                this.eIM = 2;
                Sr();
            } else {
                this.eKl = true;
                if (fVar.qq().qm() == 1) {
                    if (this.eJH == null) {
                        this.eJH = new com.baidu.tieba.pb.view.b(this.eDo.getPageContext());
                    }
                    this.eIR.setNextPage(this.eJH);
                } else {
                    this.eIR.setNextPage(this.cuQ);
                }
                this.eIM = 3;
            }
            ArrayList<PostData> aMY = fVar.aMY();
            if (fVar.qq().qm() == 0 || aMY == null || aMY.size() < fVar.qq().ql()) {
                if (com.baidu.tbadk.core.util.v.t(aMY) == 0 || (com.baidu.tbadk.core.util.v.t(aMY) == 1 && aMY.get(0) != null && aMY.get(0).brq() == 1)) {
                    this.cuQ.setText(this.eDo.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.cuQ.setText(this.eDo.getResources().getString(d.l.list_has_no_more));
                }
                if (this.eDo.aOA() && this.eIR != null && this.eIR.getData() != null && this.eIR.getData().size() == 1 && (this.eIR.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cuQ.setText("");
                }
                aRA();
            } else if (z2) {
                if (this.eLl) {
                    wn();
                    if (fVar.qq().qm() != 0) {
                        this.cuQ.setText(this.eDo.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.cuQ.wi();
                    this.cuQ.showLoading();
                }
            } else {
                this.cuQ.wi();
                this.cuQ.showLoading();
            }
            switch (i) {
                case 2:
                    this.eIR.setSelection(i2 > 1 ? (((this.eIR.getData() == null && fVar.aMY() == null) ? 0 : (this.eIR.getData().size() - fVar.aMY().size()) + this.eIR.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aQA2 = ae.aQz().aQA()) != null) {
                        this.eIR.onRestoreInstanceState(aQA2);
                        if (com.baidu.tbadk.core.util.v.t(aMY) > 1 && fVar.qq().qm() > 0) {
                            this.cuQ.wn();
                            this.cuQ.setText(this.eDo.getString(d.l.pb_load_more_without_point));
                            this.cuQ.wj();
                            break;
                        }
                    } else {
                        this.eIR.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eLl = false;
                    break;
                case 5:
                    this.eIR.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aQA = ae.aQz().aQA()) != null) {
                        this.eIR.onRestoreInstanceState(aQA);
                        break;
                    } else {
                        this.eIR.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.eII != null && this.eII.aUj() != null) {
                            if (this.eDo.isUseStyleImmersiveSticky()) {
                                this.eIR.setSelectionFromTop((this.eJC.aPd() + this.eIR.getHeaderViewsCount()) - 1, this.eII.aUj().getHeight() - com.baidu.adp.lib.util.l.n(this.eDo.getPageContext().getPageActivity()));
                            } else {
                                this.eIR.setSelectionFromTop((this.eJC.aPd() + this.eIR.getHeaderViewsCount()) - 1, this.eII.aUj().getHeight());
                            }
                        } else {
                            this.eIR.setSelection(this.eJC.aPd() + this.eIR.getHeaderViewsCount());
                        }
                    } else {
                        this.eIR.setSelection(i2 > 0 ? ((this.eIR.getData() == null && fVar.aMY() == null) ? 0 : (this.eIR.getData().size() - fVar.aMY().size()) + this.eIR.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cuQ.wn();
                    this.cuQ.setText(this.eDo.getString(d.l.pb_load_more_without_point));
                    this.cuQ.wj();
                    break;
            }
            if (this.eKB == eKC && isHost()) {
                aRG();
            }
            if (this.eKM) {
                aQJ();
                this.eKM = false;
                if (i3 == 0) {
                    jp(true);
                }
            }
            if (this.eIJ != null) {
                this.eIJ.ab(fVar.aMW());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aRt() {
        if (this.eII != null && this.eII.aUj() != null) {
            this.eIR.removeHeaderView(this.awN);
            if (this.mType != 1) {
                this.eIR.removeHeaderView(this.eII.aUl());
                this.eIR.addHeaderView(this.eII.aUl(), 0);
                return;
            }
            return;
        }
        if (this.eII != null) {
            this.eIR.removeHeaderView(this.eII.aUl());
        }
        this.eIR.removeHeaderView(this.awN);
        this.eIR.addHeaderView(this.awN, 0);
    }

    public void jw(boolean z) {
        this.eJX = z;
    }

    public void wn() {
        if (this.cuQ != null) {
            this.cuQ.wj();
            this.cuQ.wn();
        }
        Sr();
    }

    public void NX() {
        this.eIR.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.eKk != null && this.eKk.getAuthor() != null && this.eIN != null) {
            this.eKP = com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !this.eKO;
            this.eIN.jH(this.eKP);
            if (this.eDo.aOb() != null) {
                this.eDo.aOb().jG(this.eKP);
            }
            aRu();
            if (this.eKP) {
                this.eIN.ePH.setVisibility(0);
                this.eJo.setVisibility(8);
                if (this.eJY) {
                    this.eIN.ePI.setVisibility(8);
                } else if (!PbNormalLikeButtonSwitchStatic.Gq() || (this.eKk.getAuthor().hadConcerned() && this.eKk.getAuthor().getGodUserData() != null && this.eKk.getAuthor().getGodUserData().getIsFromNetWork())) {
                    this.eIN.ePI.setVisibility(8);
                }
                if (this.eKu != null) {
                    this.eKu.setVisibility(8);
                }
                if (this.eJg != null) {
                    this.eJg.setVisibility(8);
                }
                if (this.eJn != null) {
                    this.eJn.setVisibility(8);
                }
                this.eIN.ePJ.setUserId(this.eKk.getAuthor().getUserId());
                this.eIN.ePJ.setUserName(this.eKk.getAuthor().getUserName());
                this.eIN.ePJ.setImageDrawable(null);
                this.eIN.ePJ.setTag(this.eKk.getAuthor().getUserId());
                UtilHelper.showHeadImageViewBigV(this.eIN.ePJ, this.eKk.getAuthor());
                this.eIN.ePJ.setVisibility(0);
                this.eIN.ePJ.setOnClickListener(this.eLm);
                this.eIN.ePJ.c(this.eKk.getAuthor().getPortrait(), 28, false);
                if (this.eKY == null) {
                    this.eKY = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.24
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > an.this.eKR) {
                                an.this.aRF();
                            }
                        }
                    };
                }
                this.eIR.setListViewDragListener(this.eKY);
                return;
            }
            if (this.eIN.ePH != null) {
                this.eIN.ePH.setVisibility(8);
            }
            if (this.eKu != null) {
                this.eKu.setVisibility(0);
            }
            if (this.eJY) {
                this.eJo.setVisibility(8);
                this.eJr.setVisibility(0);
                this.eJr.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aNr())));
            } else if (!PbNormalLikeButtonSwitchStatic.Gq() || (this.eKk.getAuthor().hadConcerned() && this.eKk.getAuthor().getGodUserData() != null && this.eKk.getAuthor().getGodUserData().getIsFromNetWork())) {
                this.eJo.setVisibility(8);
                this.eJr.setVisibility(8);
            } else {
                this.eJo.setVisibility(0);
                this.eJo.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eDo.getActivity(), d.f.fontsize26));
                this.eJr.setVisibility(8);
            }
            this.eKY = null;
            this.eIR.setListViewDragListener(null);
        }
    }

    private void aRu() {
        String threadId = this.eFA != null ? this.eFA.getThreadId() : "";
        if (this.eKP) {
            if (this.eJq == null) {
                this.eJq = new al(this.eDo.getPageContext(), this.eIN.ePI, 3);
                this.eJq.h(this.eDo.getUniqueId());
                this.eJq.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.25
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void aP(boolean z) {
                        if (an.this.eDo != null && z) {
                            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                            if (i >= 2) {
                                com.baidu.adp.lib.util.l.showToast(an.this.eDo, d.l.attention_success);
                                return;
                            }
                            am.w(an.this.eDo.getPageContext());
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                        }
                    }
                });
            }
            if (this.eKk != null && this.eKk.getAuthor() != null) {
                this.eKk.getAuthor().setIsLike(this.eKk.getAuthor().hadConcerned());
                this.eJq.a(this.eKk.getAuthor());
            }
            this.eJq.cx(threadId);
            this.eJq.eIE = this.eKO;
            if (this.eJp != null) {
                this.eJp.unRegisterListener(this.eDo.getUniqueId());
                return;
            }
            return;
        }
        if (this.eJp == null) {
            this.eJp = new al(this.eDo.getPageContext(), this.eJo, 1);
            this.eJp.h(this.eDo.getUniqueId());
            this.eJp.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.26
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aP(boolean z) {
                    if (an.this.eDo != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(an.this.eDo, d.l.attention_success);
                            return;
                        }
                        am.w(an.this.eDo.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.eKk != null && this.eKk.getAuthor() != null) {
            this.eKk.getAuthor().setIsLike(this.eKk.getAuthor().hadConcerned());
            this.eJp.a(this.eKk.getAuthor());
            this.eJp.cx(threadId);
        }
        this.eJp.eIE = this.eKO;
        if (this.eJq != null) {
            this.eJq.unRegisterListener(this.eDo.getUniqueId());
        }
    }

    private boolean aRv() {
        boolean z;
        if (this.eKa != null && this.eKa.getVisibility() == 0) {
            if (this.eJy != null) {
                this.eJy.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eJy != null) {
                this.eJy.setVisibility(8);
            }
            z = false;
        }
        if ((this.eJA == null || this.eJA.getVisibility() == 8) && z && this.ezN) {
            this.eJz.setVisibility(0);
        } else {
            this.eJz.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aMW() == null) {
            return false;
        }
        if (fVar.aMW().rl() == 1 || fVar.aMW().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aMW().rn() == null || fVar.aMW().rn().sO() == 0) || fVar.aMW().rj() == 1 || fVar.aMW().rk() == 1 || fVar.aMW().rT() || fVar.aMW().sg() || fVar.aMW().sa() || fVar.aMW().rA() != null || fVar.aMW().sh() || fVar.aMW().sh() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aMW().getCategory()) || fVar.aMW().rr() || fVar.aMW().rq();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eDo.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eIU != null) {
                if (fVar.aMW() != null && fVar.aMW().rD() == 0 && !fVar.aMW().sb() && !this.eLa) {
                    this.eIU.setVisibility(0);
                    if (fVar.aMW() != null) {
                        fVar.aMW().e(true, q(fVar));
                    }
                    SpannableStringBuilder rO = fVar.aMW().rO();
                    this.eIV.setOnTouchListener(new com.baidu.tieba.view.k(rO));
                    this.eIV.setText(rO);
                    this.eIV.setVisibility(0);
                } else if (fVar.aMW().rD() == 1) {
                    if (fVar.aMW() != null) {
                        fVar.aMW().e(true, q(fVar));
                        SpannableStringBuilder rO2 = fVar.aMW().rO();
                        if (rO2 == null || rO2.length() == 0) {
                            this.eIU.setVisibility(8);
                            this.eIR.removeHeaderView(this.eIU);
                            if (fVar.aMW() != null && !fVar.aMW().sb()) {
                                this.eIY.setPadding(this.eIY.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds48), this.eIY.getPaddingRight(), this.eIY.getPaddingBottom());
                            }
                        } else {
                            this.eIU.setVisibility(0);
                            this.eIV.setOnTouchListener(new com.baidu.tieba.view.k(rO2));
                            this.eIV.setText(rO2);
                            this.eIV.setVisibility(0);
                        }
                    }
                } else {
                    this.eIU.setVisibility(8);
                    this.eIR.removeHeaderView(this.eIU);
                    if (fVar.aMW() != null && fVar.aMW().sb()) {
                        this.eIY.setPadding(this.eIY.getPaddingLeft(), 0, this.eIY.getPaddingRight(), this.eIY.getPaddingBottom());
                    } else {
                        this.eIY.setPadding(this.eIY.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds48), this.eIY.getPaddingRight(), this.eIY.getPaddingBottom());
                    }
                }
            }
            this.ezN = z;
            bh aMW = fVar.aMW();
            if (aMW != null) {
                a(aMW.rn());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aRv();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        if (fVar == null || (b = b(fVar, z)) == null) {
            return null;
        }
        String userId = b.getAuthor().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(d.h.tag_del_post_id, b.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aNh()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, b.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, b.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aNh()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aHI;
    }

    public void oU(String str) {
        if (this.cuQ != null) {
            this.cuQ.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eIR;
    }

    public int aRw() {
        return d.h.richText;
    }

    public TextView aNW() {
        return this.eIX.aNW();
    }

    public void d(BdListView.e eVar) {
        this.eIR.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.amd = bVar;
        if (this.eJG != null) {
            this.eJG.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int qk = apVar.qk();
            int qh = apVar.qh();
            if (this.eJD != null) {
                this.eJD.tb();
            } else {
                this.eJD = new com.baidu.tbadk.core.dialog.a(this.eDo.getPageContext().getPageActivity());
                this.eJE = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.eJD.v(this.eJE);
                this.eJD.a(d.l.dialog_ok, bVar);
                this.eJD.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.27
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.aCv();
                        aVar.dismiss();
                    }
                });
                this.eJD.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.28
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.eKJ == null) {
                            an.this.eKJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.eDo.HidenSoftKeyPad((InputMethodManager) an.this.eDo.getSystemService("input_method"), an.this.ccH);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(an.this.eKJ, 150L);
                    }
                });
                this.eJD.b(this.eDo.getPageContext()).tb();
            }
            this.eJF = (EditText) this.eJE.findViewById(d.h.input_page_number);
            this.eJF.setText("");
            TextView textView = (TextView) this.eJE.findViewById(d.h.current_page_number);
            if (qk <= 0) {
                qk = 1;
            }
            if (qh <= 0) {
                qh = 1;
            }
            textView.setText(MessageFormat.format(this.eDo.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qk), Integer.valueOf(qh)));
            this.eDo.ShowSoftKeyPadDelay(this.eJF, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eIR.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eDo.showToast(str);
    }

    public boolean jx(boolean z) {
        if (this.JH == null || !this.JH.Cw()) {
            return false;
        }
        this.JH.AH();
        return true;
    }

    public void aRx() {
        if (this.eLo != null) {
            while (this.eLo.size() > 0) {
                TbImageView remove = this.eLo.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aRx();
        this.eJC.pg(1);
        if (this.eII != null) {
            this.eII.onPause();
        }
    }

    public void onResume() {
        this.eJC.pg(2);
        if (this.eII != null) {
            this.eII.onResume();
        }
    }

    public void onDestroy() {
        if (this.eKL != null) {
            this.eKL.destroy();
        }
        if (this.eIK != null) {
            this.eIK.Zv();
        }
        if (this.eIJ != null) {
            this.eIJ.onDestroy();
        }
        this.eDo.hideProgressBar();
        if (this.ccF != null && this.cow != null) {
            this.ccF.b(this.cow);
        }
        aCv();
        wn();
        if (this.eKJ != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eKJ);
        }
        if (this.eIY != null && this.eJn != null) {
            this.eIY.removeView(this.eJg);
            this.eJn = null;
        }
        if (this.eKp != null) {
            this.eKp.clearStatus();
        }
        this.eLh = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eJC.pg(3);
        if (this.crU != null) {
            this.crU.setBackgroundDrawable(null);
        }
        if (this.eII != null) {
            this.eII.destroy();
        }
        if (this.eJC != null) {
            this.eJC.onDestory();
        }
        this.eIR.setOnLayoutListener(null);
        if (this.eKX != null) {
            this.eKX.aiy();
        }
        if (this.eKA != null) {
            this.eKA.onDestroy();
        }
        aRS();
    }

    public boolean pv(int i) {
        if (this.eII != null) {
            return this.eII.jl(i);
        }
        return false;
    }

    public void aCv() {
        this.eIN.of();
        if (this.eIK != null) {
            this.eIK.Zv();
        }
        com.baidu.adp.lib.util.l.a(this.eDo.getPageContext().getPageActivity(), this.eJF);
        aQM();
        if (this.eJV != null) {
            this.eJV.dismiss();
        }
        aRy();
        if (this.eIJ != null) {
            this.eIJ.aUc();
        }
        if (this.eJD != null) {
            this.eJD.dismiss();
        }
        if (this.crH != null) {
            this.crH.dismiss();
        }
    }

    public void cv(List<String> list) {
        this.eKW = list;
        if (this.eKX != null) {
            this.eKX.setData(list);
        }
    }

    public void iD(boolean z) {
        this.eJC.iD(z);
    }

    public void hf(boolean z) {
        this.dOR = z;
    }

    public void aRy() {
        if (this.eJM != null) {
            this.eJM.dismiss();
        }
        if (this.eJN != null) {
            com.baidu.adp.lib.g.g.b(this.eJN, this.eDo.getPageContext());
        }
        if (this.eJO != null) {
            com.baidu.adp.lib.g.g.b(this.eJO, this.eDo.getPageContext());
        }
        if (this.eJK != null) {
            com.baidu.adp.lib.g.g.b(this.eJK, this.eDo.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eFA, this.ezN);
            d(this.eFA, this.ezN, this.mType);
            this.eDo.getLayoutMode().ah(i == 1);
            this.eDo.getLayoutMode().t(this.ccH);
            this.eDo.getLayoutMode().t(this.eIV);
            this.eDo.getLayoutMode().t(this.eIW);
            this.eDo.getLayoutMode().t(this.eIT);
            if (this.eJl != null) {
                com.baidu.tbadk.core.util.aj.c(this.eJl, d.e.cp_cont_d, 1);
            }
            if (this.eJk != null) {
                com.baidu.tbadk.core.util.aj.c(this.eJk, d.e.cp_cont_d, 1);
            }
            if (this.eIJ != null) {
                this.eIJ.onChangeSkinType(i);
            }
            this.eDo.getLayoutMode().t(this.eIT);
            com.baidu.tbadk.core.util.aj.i(this.eIV, d.e.cp_cont_b);
            this.eIV.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eDo.getLayoutMode().t(this.aHI);
            if (this.eJE != null) {
                this.eDo.getLayoutMode().t(this.eJE);
            }
            jw(this.eJX);
            this.eJC.notifyDataSetChanged();
            if (this.eJG != null) {
                this.eJG.dy(i);
            }
            if (this.cuQ != null) {
                this.cuQ.dy(i);
                com.baidu.tbadk.core.util.aj.j(this.aHI, d.g.pb_foot_more_trans_selector);
                this.cuQ.dv(d.g.pb_foot_more_trans_selector);
            }
            if (this.JH != null) {
                this.JH.onChangeSkinType(i);
            }
            if (this.eJm != null) {
                this.eJm.dD(i);
            }
            if (this.eJH != null) {
                this.eJH.dy(i);
            }
            if (this.eIS != null && this.eIS.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eIS) {
                    aVar.aSD();
                }
            }
            jr(i == 1);
            aQZ();
            UtilHelper.setStatusBarBackground(this.crU, i);
            UtilHelper.setStatusBarBackground(this.eKu, i);
            if (this.eJo != null) {
                this.eJo.onChangeSkinType(i);
            }
            if (this.eJt != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJt, d.e.cp_cont_j);
            }
            if (this.eJs != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJs, d.e.cp_cont_j);
            }
            if (this.eJu != null) {
                com.baidu.tbadk.core.util.aj.j(this.eJu, d.e.cp_cont_e);
            }
            if (this.eJd != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJd, d.e.cp_link_tip_a);
            }
            if (this.eJr != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJr, d.e.cp_cont_j);
            }
            if (this.eJv != null) {
                com.baidu.tbadk.n.a.a(this.eDo.getPageContext(), this.eJv);
            }
            if (this.eKK != null) {
                this.eKK.onChangeSkinType(i);
            }
            if (this.eIN != null) {
                if (this.eII != null) {
                    this.eII.pG(i);
                } else {
                    this.eIN.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aj.i(this.eJb, d.e.cp_cont_j);
            if (this.eJc != null) {
                com.baidu.tbadk.core.util.aj.j(this.eJc, d.e.cp_cont_e);
            }
            this.mSkinType = i;
            if (this.eKc != null) {
                com.baidu.tbadk.core.util.aj.i(this.eKc, d.e.cp_cont_e);
            }
            if (this.eJe != null) {
                com.baidu.tbadk.core.util.aj.c(this.eJe, BitmapHelper.getGradeResourceIdInEnterForum(this.eKS));
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSj = fVar;
        this.eJC.setOnImageClickListener(this.aSj);
    }

    public void h(NoNetworkView.a aVar) {
        this.cow = aVar;
        if (this.ccF != null) {
            this.ccF.a(this.cow);
        }
    }

    public void jy(boolean z) {
        this.eJC.setIsFromCDN(z);
    }

    public Button aRz() {
        return this.eKa;
    }

    public void aRA() {
        if (this.eIM != 2) {
            this.eIR.setNextPage(this.cuQ);
            this.eIM = 2;
        }
    }

    public void aRB() {
        if (com.baidu.tbadk.k.r.FW().FX()) {
            int lastVisiblePosition = this.eIR.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eIR.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.fs(1001);
                                perfLog.aIQ = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.vW();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fs(1001);
                        perfLog2.aIQ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.vW();
                    }
                }
            }
        }
    }

    public boolean aRC() {
        return this.JH != null && this.JH.getVisibility() == 0;
    }

    public void hg(boolean z) {
        if (this.eKb != null) {
            if (this.dOR) {
                hh(z);
            } else {
                hi(z);
            }
        }
    }

    public void aRD() {
        if (this.eKb != null) {
            this.eKb.setVisibility(8);
            this.eKg = false;
            if (this.eKA != null) {
                this.eKA.setVisibility(8);
                ju(false);
            }
            aRS();
        }
    }

    public void showLoadingDialog() {
        if (this.bqO == null) {
            this.bqO = new com.baidu.tbadk.core.view.a(this.eDo.getPageContext());
        }
        this.bqO.aG(true);
    }

    public void Sr() {
        if (this.bqO != null) {
            this.bqO.aG(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eIR.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eIR.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eII != null) {
            this.eII.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.efs = getScrollY();
            this.eKz.eLF = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKz));
            a(this.eKz.eLF, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.eII != null) {
            this.eII.b(absListView, i);
        }
        int headerViewsCount = (i - this.eIR.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.eJC.pf(headerViewsCount) != com.baidu.tieba.pb.data.l.eyT) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eJC.aPg().jo(z);
        this.eKz.eLD = i;
        this.eKz.eLE = this.eIR.getHeaderViewsCount();
        this.eKz.eLF = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKz));
        a(this.eKz.eLF, false);
    }

    public void aRE() {
        if (this.eDo.isLogin()) {
            if ((this.eKL == null || !this.eKL.aQH()) && this.eFA != null && this.eKP && !this.eKO && !this.eJY && this.eKk != null && this.eKk.getAuthor() != null && !this.eKk.getAuthor().getIsLike() && !this.eKk.getAuthor().hadConcerned()) {
                if (this.eKL == null) {
                    this.eKL = new ai(this.eDo);
                }
                this.eKL.a(this.eIN.ePJ, this.eFA.aNu(), this.eKk.getAuthor().getUserId(), this.eFA.getThreadId());
            }
        }
    }

    public void aRF() {
        if (this.eKP && !this.eKO && this.eKk != null && this.eKk.getAuthor() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eDo.getPageContext().getPageActivity(), this.eKk.getAuthor().getUserId(), this.eKk.getAuthor().getUserName(), this.eDo.aOd().aPr(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ag agVar, boolean z) {
        int measuredHeight;
        if (!this.eKO && this.eKt != null && this.eIN.aSG() != null) {
            int aPe = this.eJC.aPe();
            if (aPe > 0 && (agVar == null || agVar.getView().getParent() == null)) {
                if (aPe > this.eIR.getFirstVisiblePosition() - this.eIR.getHeaderViewsCount()) {
                    this.eKt.setVisibility(8);
                } else {
                    this.eKt.setVisibility(0);
                }
            } else if (agVar != null && agVar.getView() != null && agVar.eIm != null) {
                int top = agVar.getView().getTop();
                if (agVar.getView().getParent() != null) {
                    if (this.eKy) {
                        this.eKx = top;
                        this.eKy = false;
                    }
                    this.eKx = top < this.eKx ? top : this.eKx;
                }
                if (top != 0 || agVar.getView().isShown()) {
                    if (this.eJB.getY() < 0.0f) {
                        measuredHeight = eKw - agVar.eIm.getMeasuredHeight();
                    } else {
                        measuredHeight = this.eIN.aSG().getMeasuredHeight() - agVar.eIm.getMeasuredHeight();
                    }
                    if (agVar.getView().getParent() == null && top <= this.eKx) {
                        this.eKt.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.eKt.setVisibility(0);
                    } else {
                        this.eKt.setVisibility(8);
                    }
                    if (z) {
                        this.eKy = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eLD;
        public int eLE;
        public ag eLF;

        public a() {
        }
    }

    public void aRG() {
        if (!this.eLp) {
            TiebaStatic.log("c10490");
            this.eLp = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eDo.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eKD, Integer.valueOf(eKF));
            aVar.cb(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eDo);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eDo.getPageContext()).tb();
        }
    }

    public void oV(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eDo.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eKD, Integer.valueOf(eKG));
        aVar.z(sparseArray);
        aVar.a(d.l.view, this.eDo);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eDo.getPageContext()).tb();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.getAuthor() != null) {
            MetaData author = b.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        p(fVar);
    }

    public PbInterviewStatusView aRH() {
        return this.eKp;
    }

    private void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aMW() != null && fVar.aMW().sg() && this.eKp == null) {
            this.eKp = (PbInterviewStatusView) this.eKo.inflate();
            this.eKp.setOnClickListener(this.crI);
            this.eKp.setCallback(this.eDo.aOJ());
            this.eKp.c(this.eDo, fVar);
        }
    }

    public LinearLayout aRI() {
        return this.eJB;
    }

    public View aRJ() {
        return this.crU;
    }

    public boolean aRK() {
        return this.eLa;
    }

    public void iI(boolean z) {
        this.eIX.iI(z);
    }

    private void aRL() {
        if (this.eLa) {
            if (this.eLb == null) {
                c.a aVar = c.eAT.get();
                if (aVar != null) {
                    this.eLb = aVar.a(this.eDo);
                    ListAdapter adapter = this.eIR.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.awN) {
                            this.eIR.addHeaderView(this.eLb.aNU(), 1);
                        } else {
                            this.eIR.addHeaderView(this.eLb.aNU(), 0);
                        }
                    }
                } else {
                    this.eIW.setVisibility(0);
                    return;
                }
            }
            this.eIW.setVisibility(8);
            this.eIR.removeHeaderView(this.eIW);
            return;
        }
        this.eIW.setVisibility(0);
    }

    public void jz(boolean z) {
        this.eLa = z;
    }

    public void aRM() {
        this.eDo.showNetRefreshView(getView(), "");
        View En = this.eDo.getRefreshView().En();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) En.getLayoutParams();
        layoutParams.addRule(3, aRI().getId());
        En.setLayoutParams(layoutParams);
        this.eDo.hideLoadingView(getView());
        if (this.eLb != null) {
            this.eIR.removeHeaderView(this.eLb.aNU());
            this.eLb = null;
        }
    }

    public void oW(String str) {
        if (this.eIO != null) {
            this.eIO.setTitle(str);
        }
    }

    private int jA(boolean z) {
        if (this.eKp == null || this.eKp.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aRN() {
        if (this.eKp != null && this.eKp.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKp.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eKp.setLayoutParams(layoutParams);
        }
    }

    public boolean aOe() {
        return false;
    }

    public TextView aRO() {
        return this.eJl;
    }

    public void oX(String str) {
        this.eKc.performClick();
        if (!StringUtils.isNull(str) && this.eDo.aNX() != null && this.eDo.aNX().CT() != null && this.eDo.aNX().CT().CM() != null) {
            EditText CM = this.eDo.aNX().CT().CM();
            CM.setText(str);
            CM.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aCv();
            aRD();
            aQM();
            if (this.eKK != null) {
                this.eKK.aPl();
            }
            this.eDo.ahd();
            this.eJB.setVisibility(8);
            this.eIN.setTitleVisibility(false);
            this.eDo.iO(false);
            if (this.eII != null) {
                if (configuration.orientation == 1) {
                    aRI().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eIR.setIsLandscape(true);
                    this.eIR.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eIR.setIsLandscape(false);
                    if (this.efs > 0) {
                        this.eIR.smoothScrollBy(this.efs, 0);
                    }
                }
                this.eII.onConfigurationChanged(configuration);
            }
        }
    }

    public void jB(boolean z) {
        this.eIL = z;
    }

    public boolean aRP() {
        return this.eII != null && this.eII.aRP();
    }

    public void aRQ() {
        if (this.eII != null) {
            this.eII.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eIJ != null) {
            this.eIJ.w(j, i);
        }
        if (this.eII != null) {
            this.eII.w(j, i);
        }
    }

    public void iU(boolean z) {
        this.eJC.iU(z);
    }

    public void aRR() {
        if (this.eKq == null) {
            LayoutInflater.from(this.eDo.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.ccH, true);
            this.eKq = (ViewGroup) this.ccH.findViewById(d.h.add_experienced_layout);
            this.eKr = (TextView) this.ccH.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.eKr, d.e.cp_cont_i);
            String string = this.eDo.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eDo.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_h)));
            this.eKr.setText(spannableString);
        }
        this.eKq.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.an.31
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.an.31.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        an.this.eKq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                an.this.eKr.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eKr.startAnimation(scaleAnimation);
    }

    public void bl(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.eKb.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eDo);
            frameLayout.setBackgroundResource(d.g.pic_sign_tip);
            TextView textView = new TextView(this.eDo);
            textView.setText(d.l.connection_tips);
            textView.setGravity(17);
            textView.setPadding(com.baidu.adp.lib.util.l.f(this.eDo, d.f.ds24), 0, com.baidu.adp.lib.util.l.f(this.eDo, d.f.ds24), 0);
            com.baidu.tbadk.core.util.aj.i(textView, d.e.cp_cont_n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eDo, d.f.ds60);
            frameLayout.addView(textView, layoutParams);
            this.eKU = new PopupWindow(this.eDo);
            this.eKU.setContentView(frameLayout);
            this.eKU.setHeight(-2);
            this.eKU.setWidth(-2);
            this.eKU.setFocusable(true);
            this.eKU.setOutsideTouchable(false);
            this.eKU.setBackgroundDrawable(new ColorDrawable(this.eDo.getResources().getColor(d.e.transparent)));
            this.eIR.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.32
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.eKV = true;
                        an.this.eKU.showAsDropDown(an.this.eKb, view.getLeft(), -an.this.eKb.getHeight());
                        return;
                    }
                    an.this.eKU.showAsDropDown(view);
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aSd() != null && !StringUtils.isNull(aVar.aSd().pkg_id) && !StringUtils.isNull(aVar.aSd().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.eKd != null && this.eKd.getVisibility() == 0) {
            if (this.eKT == null) {
                View inflate = LayoutInflater.from(this.eDo.getPageContext().getPageActivity()).inflate(d.j.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.h.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.h.single_bar_tips);
                textView.setText(d.l.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.crI);
                this.eKT = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.eKd.getLocationInWindow(iArr);
            this.eKT.showAtLocation(this.eKd, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds54), (iArr[1] - this.eKd.getHeight()) - com.baidu.adp.lib.util.l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aRS() {
        com.baidu.adp.lib.g.g.a(this.eKT);
    }
}
