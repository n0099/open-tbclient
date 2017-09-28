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
    private static final int eKK = UtilHelper.getLightStatusBarHeight();
    public static int eKQ = 3;
    public static int eKR = 0;
    public static int eKS = 3;
    public static int eKT = 4;
    public static int eKU = 5;
    public static int eKV = 6;
    private com.baidu.tbadk.editortools.i JG;
    private View aHV;
    private com.baidu.tieba.pb.a.c aSx;
    private g.b amp;
    private TextView awZ;
    private View bQQ;
    private NoNetworkView ccR;
    private RelativeLayout ccT;
    private View.OnClickListener crU;
    private View csg;
    private PbListView cvc;
    private View.OnClickListener eAf;
    PbActivity.c eCN;
    private PbActivity eDC;
    private UserIconBox eEO;
    private UserIconBox eEP;
    private com.baidu.tieba.pb.data.f eFO;
    private PbFakeFloorModel eFn;
    public int eIV;
    private com.baidu.tieba.pb.video.i eIW;
    private com.baidu.tieba.pb.video.h eIX;
    private com.baidu.tieba.d.a eIY;
    private PbFirstFloorUserLikeButton eJC;
    private al eJD;
    private al eJE;
    private TextView eJF;
    private TextView eJG;
    private TextView eJH;
    private View eJI;
    private LinearLayout eJJ;
    private TextView eJK;
    private TextView eJL;
    private View eJM;
    private View eJN;
    private ObservedChangeLinearLayout eJP;
    private f eJQ;
    private View eJW;
    public final com.baidu.tieba.pb.pb.main.view.c eJb;
    public com.baidu.tieba.pb.pb.main.view.b eJc;
    private ViewStub eJd;
    private ViewStub eJe;
    private PbLandscapeListView eJf;
    private List<com.baidu.tieba.pb.pb.main.view.a> eJg;
    private View eJh;
    private LinearLayout eJk;
    private d eJl;
    private ColumnLayout eJm;
    private ThreadSkinView eJn;
    private TextView eJo;
    private TextView eJp;
    private View eJq;
    private TextView eJr;
    private ImageView eJs;
    private HeadPendantView eJt;
    private FrameLayout eJu;
    private HeadImageView eJv;
    private View eJw;
    private FloatingLayout eJx;
    private View eKA;
    private TextView eKB;
    private ViewStub eKC;
    private PbInterviewStatusView eKD;
    private ViewGroup eKE;
    private TextView eKF;
    private FrameLayout eKG;
    private View eKH;
    private View eKI;
    private ag eKJ;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eKO;
    private int eKW;
    private Runnable eKX;
    private q eKY;
    private ai eKZ;
    private View eKp;
    private TextView eKq;
    private ImageView eKr;
    private ImageView eKs;
    private TextView eKt;
    private boolean eKv;
    private int eKw;
    private int eKx;
    private PostData eKy;
    private int eLf;
    private PopupWindow eLh;
    private PopupWindow eLi;
    private List<String> eLk;
    private com.baidu.tieba.pb.pb.main.emotion.c eLl;
    private PbLandscapeListView.b eLm;
    private boolean eLo;
    private c eLp;
    private com.baidu.tbadk.core.view.userLike.c eLq;
    private com.baidu.tbadk.core.view.userLike.c eLr;
    private Runnable eLw;
    private PbActivity.a eLy;
    private int efG;
    private boolean isLandscape;
    private int mType;
    private boolean eIZ = false;
    private int eJa = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout eJi = null;
    private TextView eJj = null;
    private TextView eJy = null;
    private TextView eJz = null;
    public FrsPraiseView eJA = null;
    private ClickableHeaderImageView eJB = null;
    private View eJO = null;
    private com.baidu.tbadk.core.dialog.a eJR = null;
    private com.baidu.tbadk.core.dialog.b crT = null;
    private View eJS = null;
    private EditText eJT = null;
    private com.baidu.tieba.pb.view.i eJU = null;
    private com.baidu.tieba.pb.view.b eJV = null;
    private com.baidu.tbadk.core.dialog.a eJX = null;
    private b.InterfaceC0047b dxH = null;
    private TbRichTextView.f aSw = null;
    private NoNetworkView.a coJ = null;
    private Dialog eJY = null;
    private View eJZ = null;
    private com.baidu.tbadk.core.dialog.a eKa = null;
    private Dialog eKb = null;
    private Dialog eKc = null;
    private View eKd = null;
    private LinearLayout eKe = null;
    private CompoundButton.OnCheckedChangeListener eKf = null;
    private TextView eKg = null;
    private TextView eKh = null;
    private String eKi = null;
    private com.baidu.tbadk.core.dialog.b eKj = null;
    private com.baidu.tbadk.core.dialog.b eKk = null;
    private boolean eKl = false;
    private boolean eKm = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eKn = null;
    private boolean dPf = false;
    private Button eKo = null;
    private boolean eKu = true;
    private com.baidu.tbadk.core.view.a bra = null;
    private boolean eAb = false;
    private int mSkinType = 3;
    private boolean eKz = false;
    private int eKL = 0;
    private boolean eKM = true;
    private a eKN = new a();
    private int eKP = 0;
    private boolean eLa = false;
    private int eLb = 0;
    private boolean eLc = false;
    private boolean eLd = false;
    private boolean eLe = false;
    private int eLg = 0;
    private boolean eLj = false;
    private a.InterfaceC0124a eLn = new a.InterfaceC0124a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0124a
        public void lc() {
        }
    };
    private final CustomMessageListener eLs = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_IMG_TO_EMOTION_CONNECTION_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921305) {
                an.this.aQZ();
            }
        }
    };
    private String eLt = null;
    private CustomMessageListener eLu = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.eLt = null;
            }
        }
    };
    private CustomMessageListener dKa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.eJQ != null) {
                an.this.eJQ.notifyDataSetChanged();
            }
        }
    };
    private Handler eLv = new Handler();
    private CustomMessageListener eLx = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.eKu = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eLz = true;
    View.OnClickListener eLA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (an.this.eLc) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == an.this.eJb.ePX) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (an.this.eDC.eBT.ePd != null) {
                if (!an.this.eLc && an.this.eFO != null && an.this.eFO.aNb() != null && an.this.eFO.aNb().getAuthor() != null && an.this.eFO.aNb().getAuthor().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                an.this.eDC.eBT.ePd.onClick(view);
            }
        }
    };
    private boolean eLB = false;
    private boolean Zq = false;
    String userId = null;
    private final List<TbImageView> eLC = new ArrayList();
    private boolean eLD = false;

    public void jq(boolean z) {
        this.eLa = z;
        if (this.eJf != null) {
            this.eLb = this.eJf.getHeaderViewsCount();
        }
    }

    public void aQO() {
        if (this.eJf != null) {
            int headerViewsCount = this.eJf.getHeaderViewsCount() - this.eLb;
            final int firstVisiblePosition = (this.eJf.getFirstVisiblePosition() == 0 || this.eJf.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.eJf.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.eJf.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.eKN.eLT = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKN));
            final ag agVar = this.eKN.eLT;
            final int d = d(agVar);
            final int y = ((int) this.eJP.getY()) + this.eJP.getMeasuredHeight();
            final boolean z = this.eKH.getVisibility() == 0;
            boolean z2 = this.eJP.getY() < 0.0f;
            if ((z && agVar != null) || firstVisiblePosition >= this.eJQ.aPj() + this.eJf.getHeaderViewsCount()) {
                int measuredHeight = agVar != null ? agVar.eIA.getMeasuredHeight() : 0;
                if (z2) {
                    this.eJf.setSelectionFromTop(this.eJQ.aPj() + this.eJf.getHeaderViewsCount(), eKK - measuredHeight);
                } else {
                    this.eJf.setSelectionFromTop(this.eJQ.aPj() + this.eJf.getHeaderViewsCount(), this.eJb.aSL().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.eJf.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.eLc) {
                this.eJf.setSelectionFromTop(this.eJQ.aPj() + this.eJf.getHeaderViewsCount(), this.eIW.aUo().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.eJf.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aPt() {
                        if (d >= 0 && d <= an.this.ccT.getMeasuredHeight()) {
                            int d2 = an.this.d(agVar);
                            int i = d2 - d;
                            if (z && i != 0 && d <= y) {
                                i = d2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = an.this.bQQ.getLayoutParams();
                            if (i == 0 || i > an.this.ccT.getMeasuredHeight() || d2 >= an.this.ccT.getMeasuredHeight()) {
                                layoutParams.height = an.this.eKW;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.ccT.getMeasuredHeight()) {
                                layoutParams.height = an.this.eKW;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                an.this.eJf.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            an.this.bQQ.setLayoutParams(layoutParams);
                        }
                        an.this.eJf.setOnLayoutListener(null);
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

    public c aQP() {
        return this.eLp;
    }

    public NoNetworkView aQQ() {
        return this.ccR;
    }

    public void aQR() {
        if (this.JG != null) {
            this.JG.hide();
            if (this.eLl != null) {
                this.eLl.adq();
            }
        }
    }

    public PbFakeFloorModel aQS() {
        return this.eFn;
    }

    public q aQT() {
        return this.eKY;
    }

    public void aQU() {
        reset();
        aQR();
        this.eKY.aPq();
        hh(false);
    }

    private void reset() {
        if (this.eDC != null && this.eDC.aOc() != null && this.JG != null) {
            com.baidu.tbadk.editortools.pb.a.CV().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aOc = this.eDC.aOc();
            aOc.Dp();
            if (aOc.getWriteImagesInfo() != null) {
                aOc.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aOc.eY(10);
            aOc.eW(SendView.ALL);
            aOc.eX(SendView.ALL);
            com.baidu.tbadk.editortools.l eN = this.JG.eN(23);
            com.baidu.tbadk.editortools.l eN2 = this.JG.eN(2);
            com.baidu.tbadk.editortools.l eN3 = this.JG.eN(5);
            if (eN2 != null) {
                eN2.lM();
            }
            if (eN3 != null) {
                eN3.lM();
            }
            if (eN != null) {
                eN.hide();
            }
            this.JG.invalidate();
        }
    }

    public boolean aQV() {
        return this.eKu;
    }

    public void hi(boolean z) {
        if (this.eKp != null && this.eKq != null) {
            this.eKq.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eKp.startAnimation(alphaAnimation);
            }
            this.eKp.setVisibility(0);
            this.eKu = true;
            if (this.eKO != null) {
                this.eKO.setVisibility(0);
                jv(true);
            }
        }
    }

    public void hj(boolean z) {
        if (this.eKp != null && this.eKq != null) {
            this.eKq.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eKp.startAnimation(alphaAnimation);
            }
            this.eKp.setVisibility(0);
            this.eKu = true;
            if (this.eKO != null) {
                this.eKO.setVisibility(0);
                jv(true);
            }
        }
    }

    public PostData aQW() {
        int i = 0;
        if (this.eJf == null) {
            return null;
        }
        int aQX = aQX() - this.eJf.getHeaderViewsCount();
        if (aQX < 0) {
            aQX = 0;
        }
        if (this.eJQ.pg(aQX) != null && this.eJQ.pg(aQX) != PostData.ggI) {
            i = aQX + 1;
        }
        return this.eJQ.getItem(i) instanceof PostData ? (PostData) this.eJQ.getItem(i) : null;
    }

    public int aQX() {
        int i;
        View childAt;
        if (this.eJf == null) {
            return 0;
        }
        int firstVisiblePosition = this.eJf.getFirstVisiblePosition();
        int lastVisiblePosition = this.eJf.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eJf.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.eJf.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aQY() {
        return this.eJf.getHeaderViewsCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQZ() {
        if (this.eJX == null) {
            this.eJX = new com.baidu.tbadk.core.dialog.a(this.eDC);
            this.eJX.cd(d.l.img_to_emotion_tip);
            this.eJX.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.33
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.editortools.pb.c aOc = an.this.eDC.aOc();
                    if (aOc.getWriteImagesInfo() != null) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) an.this.eDC, aOc.getWriteImagesInfo().toJsonString(), true, true);
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
            this.eJX.a(d.l.go_to_add, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.34
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    an.this.eDC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(an.this.eDC.getPageContext().getPageActivity())));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL));
                    if (an.this.eDC.checkUpIsLogin()) {
                        if (an.this.JG != null) {
                            an.this.aRh();
                            an.this.JG.L((View) an.this.JG.eN(5));
                        }
                        if (an.this.JG != null) {
                            an.this.eKu = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eDC, (View) an.this.JG.eP(2).aAH, false, an.this.eLn);
                        }
                        an.this.aRI();
                        aVar.dismiss();
                    }
                }
            });
            this.eJX.b(this.eDC.getPageContext());
        }
        this.eJX.ti();
    }

    public void e(TbRichText tbRichText) {
        PostData postData;
        if (this.eFO != null && this.eFO.aNd() != null && !this.eFO.aNd().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eFO.aNd().size() && (postData = this.eFO.aNd().get(i2)) != null && postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getUserId())) {
                    if (!this.eFO.aNd().get(i2).getAuthor().getUserId().equals(tbRichText.getAuthorId())) {
                        i = i2 + 1;
                    } else {
                        if (this.eKO != null) {
                            this.eKO.jF(true);
                        }
                        this.eLt = postData.getAuthor().getName_show();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public an(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eDC = null;
        this.ccT = null;
        this.csg = null;
        this.eJf = null;
        this.eJh = null;
        this.eJk = null;
        this.eJm = null;
        this.eJo = null;
        this.eJq = null;
        this.eJr = null;
        this.eJu = null;
        this.eJv = null;
        this.eJw = null;
        this.eJC = null;
        this.eJF = null;
        this.eJG = null;
        this.eJH = null;
        this.eJI = null;
        this.eJM = null;
        this.eJN = null;
        this.eJQ = null;
        this.cvc = null;
        this.aHV = null;
        this.crU = null;
        this.eAf = null;
        this.eKp = null;
        this.eKq = null;
        this.eKr = null;
        this.eKs = null;
        this.eKt = null;
        this.eKA = null;
        this.eKB = null;
        this.eKC = null;
        this.eLf = 0;
        this.eDC = pbActivity;
        this.crU = onClickListener;
        this.aSx = cVar;
        this.eLf = com.baidu.adp.lib.util.l.ad(this.eDC) - com.baidu.adp.lib.util.l.f(this.eDC, d.f.ds200);
        this.ccT = (RelativeLayout) LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.eDC.addContentView(this.ccT, new FrameLayout.LayoutParams(-1, -1));
        this.csg = this.eDC.findViewById(d.h.statebar_view);
        this.eJP = (ObservedChangeLinearLayout) this.eDC.findViewById(d.h.title_wrapper);
        this.ccR = (NoNetworkView) this.eDC.findViewById(d.h.view_no_network);
        this.eJf = (PbLandscapeListView) this.eDC.findViewById(d.h.new_pb_list);
        this.eKG = (FrameLayout) this.eDC.findViewById(d.h.root_float_header);
        this.awZ = new TextView(this.eDC.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds98));
        this.eJf.addHeaderView(this.awZ, 0);
        this.eKW = this.eDC.getResources().getDimensionPixelSize(d.f.ds100);
        this.bQQ = new View(this.eDC.getPageContext().getPageActivity());
        this.bQQ.setLayoutParams(new AbsListView.LayoutParams(-1, this.eKW));
        this.bQQ.setVisibility(4);
        this.eJf.addFooterView(this.bQQ);
        this.eJf.setOnTouchListener(this.eDC.aLZ);
        this.eJb = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eDC.aOF()) {
            this.eJd = (ViewStub) this.eDC.findViewById(d.h.manga_view_stub);
            this.eJd.setVisibility(0);
            this.eJc = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.eJc.show();
            this.eJb.mNavigationBar.setVisibility(8);
            layoutParams.height -= eKK;
        }
        this.awZ.setLayoutParams(layoutParams);
        this.eJb.aSL().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0110a() { // from class: com.baidu.tieba.pb.pb.main.an.36
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0110a
            public void ahU() {
                if (an.this.eJf != null) {
                    if (an.this.eIW != null) {
                        an.this.eIW.aUp();
                    }
                    an.this.eJf.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0110a
            public void ahT() {
                an.this.eDC.ahi();
            }
        }));
        this.eKp = this.eDC.findViewById(d.h.pb_editor_tool_comment);
        this.eKw = com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds90);
        this.eKx = com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds242);
        this.eKq = (TextView) this.eDC.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.eKs = (ImageView) this.eDC.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_more_img);
        this.eKr = (ImageView) this.eDC.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_emotion_img);
        this.eKt = (TextView) this.eDC.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.eKt.setVisibility(8);
        this.eKq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.aRX();
                if (!an.this.eDC.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", an.this.mForumId));
                } else if (an.this.eFO == null || !com.baidu.tieba.pb.f.T(an.this.eFO.aNb())) {
                    if (an.this.JG != null) {
                        an.this.aRh();
                    }
                    if (an.this.JG != null) {
                        an.this.eKu = false;
                        com.baidu.tieba.tbadkCore.b.a.a(an.this.eDC, (View) an.this.JG.eP(2).aAH, false, an.this.eLn);
                    }
                    an.this.aRI();
                }
            }
        });
        this.eKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.aRX();
                if (an.this.eDC.checkUpIsLogin()) {
                    if (an.this.eFO == null || !com.baidu.tieba.pb.f.T(an.this.eFO.aNb())) {
                        if (an.this.JG != null) {
                            an.this.aRh();
                            an.this.JG.L((View) an.this.JG.eN(5));
                        }
                        if (an.this.JG != null) {
                            an.this.eKu = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eDC, (View) an.this.JG.eP(2).aAH, false, an.this.eLn);
                        }
                        an.this.aRI();
                    }
                }
            }
        });
        this.eKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.aRX();
                if (an.this.eDC.checkUpIsLogin()) {
                    if (an.this.eFO == null || !com.baidu.tieba.pb.f.T(an.this.eFO.aNb())) {
                        if (an.this.JG != null) {
                            an.this.aRh();
                            an.this.JG.L((View) an.this.JG.eN(2));
                        }
                        if (an.this.JG != null) {
                            an.this.eKu = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eDC, (View) an.this.JG.eP(2).aAH, false, an.this.eLn);
                        }
                        an.this.aRI();
                    }
                }
            }
        });
        this.eKt.setOnClickListener(this.crU);
        this.eKt.setOnTouchListener(this.eDC);
        this.eJh = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eJk = (LinearLayout) LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eJl = new d(this.eDC, this.eJk);
        this.eJl.init();
        this.eJl.a(this.eJl.aOb(), this.crU);
        this.eJm = (ColumnLayout) this.eJk.findViewById(d.h.pb_head_owner_root);
        this.eJn = (ThreadSkinView) this.eJk.findViewById(d.h.pb_thread_skin);
        this.eJm.setOnLongClickListener(this.onLongClickListener);
        this.eJm.setOnTouchListener(this.aSx);
        this.eJm.setVisibility(8);
        this.eJh.setOnTouchListener(this.aSx);
        this.eKA = this.eJh.findViewById(d.h.pb_head_activity_join_number_container);
        this.eKA.setVisibility(8);
        this.eKB = (TextView) this.eJh.findViewById(d.h.pb_head_activity_join_number);
        this.eJo = (TextView) this.eJm.findViewById(d.h.pb_head_owner_info_user_name);
        this.eJp = (TextView) this.eJk.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eJq = this.eJk.findViewById(d.h.line_right_user_intro);
        this.eJr = (TextView) this.eJm.findViewById(d.h.floor_owner);
        this.eJs = (ImageView) this.eJm.findViewById(d.h.icon_forum_level);
        this.eJu = (FrameLayout) this.eJm.findViewById(d.h.pb_head_headImage_container);
        this.eJv = (HeadImageView) this.eJm.findViewById(d.h.pb_head_owner_photo);
        this.eJt = (HeadPendantView) this.eJm.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eJt.wg();
        if (this.eJt.getHeadView() != null) {
            this.eJt.getHeadView().setIsRound(true);
            this.eJt.getHeadView().setDrawBorder(false);
        }
        if (this.eJt.getPendantView() != null) {
            this.eJt.getPendantView().setIsRound(true);
            this.eJt.getPendantView().setDrawBorder(false);
        }
        this.eEO = (UserIconBox) this.eJm.findViewById(d.h.show_icon_vip);
        this.eEP = (UserIconBox) this.eJm.findViewById(d.h.show_icon_yinji);
        this.eJx = (FloatingLayout) this.eJk.findViewById(d.h.pb_head_owner_info_root);
        this.eJC = (PbFirstFloorUserLikeButton) this.eJm.findViewById(d.h.pb_like_button);
        this.eJF = (TextView) this.eJm.findViewById(d.h.pb_views);
        this.eJG = (TextView) this.eJm.findViewById(d.h.pb_item_first_floor_reply_time);
        this.eJH = (TextView) this.eJm.findViewById(d.h.pb_item_first_floor_location_address);
        this.eJI = this.eJm.findViewById(d.h.line_between_time_and_locate);
        this.eLq = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eLr = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eJM = this.eJh.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.eJN = this.eJh.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eJh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.eKC = (ViewStub) this.ccT.findViewById(d.h.interview_status_stub);
        this.eJQ = new f(this.eDC, this.eJf);
        this.eJQ.p(this.crU);
        this.eJQ.setTbGestureDetector(this.aSx);
        this.eJQ.setOnImageClickListener(this.aSw);
        this.eAf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.Xn() || !com.baidu.tieba.c.a.a(an.this.eDC.getBaseContext(), an.this.eDC.aOi().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                an.this.eDC.c(sparseArray);
                                return;
                            }
                            an.this.bk(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        an.this.eDC.c(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eJQ.C(this.eAf);
        aRc();
        this.eJf.addHeaderView(this.eJi);
        this.eJf.addHeaderView(this.eJk);
        this.eJf.addHeaderView(this.eJh);
        this.cvc = new PbListView(this.eDC.getPageContext().getPageActivity());
        this.aHV = this.cvc.getView().findViewById(d.h.pb_more_view);
        if (this.aHV != null) {
            this.aHV.setOnClickListener(this.crU);
            com.baidu.tbadk.core.util.aj.j(this.aHV, d.g.pb_foot_more_trans_selector);
        }
        this.cvc.wp();
        this.cvc.dw(d.g.pb_foot_more_trans_selector);
        this.cvc.dy(d.g.pb_foot_more_trans_selector);
        this.eJW = this.eDC.findViewById(d.h.viewstub_progress);
        this.eDC.registerListener(this.eLx);
        this.eJw = com.baidu.tbadk.ala.b.nz().h(this.eDC.getActivity(), 2);
        if (this.eJw != null) {
            this.eJw.setVisibility(8);
            this.eJx.addView(this.eJw);
        }
        this.eFn = new PbFakeFloorModel(this.eDC.getPageContext());
        this.eKY = new q(this.eDC.getPageContext(), this.eFn, this.ccT);
        this.eFn.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void m(PostData postData) {
                an.this.eFn.n(postData);
                an.this.eJQ.notifyDataSetChanged();
                an.this.eKY.aPq();
                an.this.JG.AN();
                an.this.hh(false);
            }
        });
        if (this.eDC.aOi() != null && !StringUtils.isNull(this.eDC.aOi().aQb())) {
            this.eDC.showToast(this.eDC.aOi().aQb());
        }
        this.eKH = this.eDC.findViewById(d.h.pb_expand_blank_view);
        this.eKI = this.eDC.findViewById(d.h.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKI.getLayoutParams();
        if (this.eDC.aOi() != null && this.eDC.aOi().aPz()) {
            this.eKH.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.eKI.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = eKK;
            this.eKI.setLayoutParams(layoutParams2);
        }
        this.eKJ = new ag(this.eDC.getPageContext(), this.eDC.findViewById(d.h.pb_reply_expand_view));
        this.eKJ.eIA.setVisibility(8);
        this.eKJ.D(this.crU);
        this.eDC.registerListener(this.dKa);
        this.eDC.registerListener(this.eLs);
        this.eDC.registerListener(this.eLu);
        jv(false);
    }

    public View aRa() {
        return this.eKH;
    }

    public void aRb() {
        if (this.eJf != null) {
            this.eJf.removeHeaderView(this.eJi);
            this.eJf.removeHeaderView(this.eJk);
            this.eJf.removeHeaderView(this.eJh);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eKO == null) {
            this.eKO = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eDC.getPageContext().getPageActivity());
            jv(true);
            this.eKO.a(this.ccT, aVar, this.eKp.getVisibility() == 0);
            this.eKO.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.6
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(an.this.eLt)) {
                        emotionImageData.setAuthorNameShow(an.this.eLt);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    an.this.eDC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(an.this.eDC.getPageContext().getPageActivity(), 25016, str, list, an.this.eLt, list2)));
                }
            });
            this.eKO.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.an.7
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void X(float f) {
                    an.this.aRX();
                    if (an.this.eKp != null) {
                        ViewGroup.LayoutParams layoutParams = an.this.eKp.getLayoutParams();
                        layoutParams.height = (int) (((an.this.eKx - an.this.eKw) * f) + an.this.eKw);
                        an.this.eKq.setAlpha(1.0f - f);
                        an.this.eKs.setAlpha(1.0f - f);
                        an.this.eKr.setAlpha(1.0f - f);
                        an.this.eKp.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aRc() {
        if (this.eJi == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds34);
            this.eJi = new LinearLayout(this.eDC.getPageContext().getPageActivity());
            this.eJi.setOrientation(1);
            this.eJi.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eJi.setPadding(f, com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds40), f, com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds46));
            this.eJi.setGravity(17);
            this.eJj = new TextView(this.eDC.getPageContext().getPageActivity());
            this.eJj.setGravity(3);
            this.eJj.setMaxLines(2);
            this.eJj.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eJj.setPadding(0, 0, 0, 0);
            this.eJj.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.eJj, d.e.cp_cont_b);
            this.eJj.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds48));
            this.eJj.setVisibility(8);
            this.eJi.addView(this.eJj);
            this.eJi.setOnTouchListener(this.aSx);
            this.eJi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRd() {
        if (this.eDC.aOF()) {
            this.eJe = (ViewStub) this.eDC.findViewById(d.h.manga_mention_controller_view_stub);
            this.eJe.setVisibility(0);
            if (this.eJJ == null) {
                this.eJJ = (LinearLayout) this.eDC.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.eDC.getPageContext(), this.eJJ);
            }
            if (this.eJK == null) {
                this.eJK = (TextView) this.eJJ.findViewById(d.h.manga_prev_btn);
            }
            if (this.eJL == null) {
                this.eJL = (TextView) this.eJJ.findViewById(d.h.manga_next_btn);
            }
            this.eJK.setOnClickListener(this.crU);
            this.eJL.setOnClickListener(this.crU);
        }
    }

    private void aRe() {
        if (this.eDC.aOF()) {
            if (this.eDC.aOI() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eJK, d.e.cp_cont_e, 1);
            }
            if (this.eDC.aOJ() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eJL, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aRf() {
        if (this.eJJ == null) {
            aRd();
        }
        this.eJe.setVisibility(8);
        if (this.eLv != null && this.eLw != null) {
            this.eLv.removeCallbacks(this.eLw);
        }
    }

    public void aRg() {
        if (this.eLv != null) {
            if (this.eLw != null) {
                this.eLv.removeCallbacks(this.eLw);
            }
            this.eLw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.eJJ == null) {
                        an.this.aRd();
                    }
                    an.this.eJe.setVisibility(0);
                }
            };
            this.eLv.postDelayed(this.eLw, 2000L);
        }
    }

    public void jr(boolean z) {
        this.eJb.jr(z);
        if (z && this.eKz) {
            this.cvc.setText(this.eDC.getResources().getString(d.l.click_load_more));
            this.eJf.setNextPage(this.cvc);
            this.eJa = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.JG = iVar;
        this.JG.setId(d.h.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ccT.addView(this.JG, layoutParams);
        this.JG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQR();
        this.eDC.aOc().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.JG != null && an.this.JG.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.eLl == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.JG.getId());
                            an.this.eLl = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.eDC.getPageContext(), an.this.ccT, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.u(an.this.eLk)) {
                                an.this.eLl.setData(an.this.eLk);
                            }
                            an.this.eLl.b(an.this.JG);
                        }
                        an.this.eLl.pe(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void aRh() {
        if (this.eDC != null && this.JG != null) {
            this.JG.lM();
            aRI();
        }
    }

    public void R(String str, boolean z) {
        this.eKv = z;
        js(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void js(boolean z) {
        if (this.eKt != null) {
            if (this.eKv) {
                com.baidu.tbadk.core.util.aj.j(this.eKt, d.g.pb_praise_already_click_selector);
                this.eKt.setContentDescription(this.eDC.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.eKt, d.g.pb_praise_normal_click_selector);
            this.eKt.setContentDescription(this.eDC.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aRi() {
        return this.eKt;
    }

    public void jt(boolean z) {
        if (this.eJf != null && this.awZ != null && this.csg != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.csg.setVisibility(0);
                } else {
                    this.csg.setVisibility(8);
                    this.eJf.removeHeaderView(this.awZ);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.awZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = eKK;
                    this.awZ.setLayoutParams(layoutParams);
                }
                aRy();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.awZ.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jB(true);
                this.awZ.setLayoutParams(layoutParams2);
            }
            aRy();
            aRS();
        }
    }

    public f aRj() {
        return this.eJQ;
    }

    public void aRk() {
        if (this.eJQ != null) {
            this.eJQ.aPe();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eCN = cVar;
    }

    private void a(bk bkVar) {
        if (bkVar == null || bkVar.sV() == 0) {
            if (this.eKo != null) {
                this.eKo.setVisibility(8);
            }
            if (this.eJM != null) {
                this.eJM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eKo == null) {
            this.eDC.getLayoutMode().t(((ViewStub) this.eJh.findViewById(d.h.live_talk_layout)).inflate());
            this.eKo = (Button) this.eJh.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.eJM = this.eJh.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int sW = bkVar.sW();
        String string = this.eDC.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (sW == 0) {
            string = string + this.eDC.getPageContext().getString(d.l.go_to_interview_post);
        } else if (sW == 1) {
            string = string + this.eDC.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.eKo.setText(string);
        this.eKo.setVisibility(0);
        this.eKo.setOnClickListener(this.crU);
        aRA();
    }

    public void bk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eJZ == null) {
            this.eJZ = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eDC.getLayoutMode().t(this.eJZ);
        if (this.eJY == null) {
            this.eJY = new Dialog(this.eDC.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eJY.setCanceledOnTouchOutside(true);
            this.eJY.setCancelable(true);
            this.eJY.setContentView(this.eJZ);
            WindowManager.LayoutParams attributes = this.eJY.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ad(this.eDC.getPageContext().getPageActivity()) * 0.9d);
            this.eJY.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eJY.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eJY.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eJY.findViewById(d.h.disable_reply_btn);
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
                    if (an.this.eJY != null && (an.this.eJY instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eJY, an.this.eDC.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        an.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aRP()) {
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
                    if (an.this.eJY != null && (an.this.eJY instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eJY, an.this.eDC.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && an.this.eLy != null) {
                        an.this.eLy.f(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
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
                    if (an.this.eJY != null && (an.this.eJY instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eJY, an.this.eDC.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        an.this.eDC.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eJY, this.eDC.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eLy = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eKR, Integer.valueOf(eKS));
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
        this.eKa = new com.baidu.tbadk.core.dialog.a(this.eDC.getActivity());
        this.eKa.cd(i3);
        this.eKa.z(sparseArray);
        this.eKa.a(d.l.dialog_ok, this.eDC);
        this.eKa.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eKa.ar(true);
        this.eKa.b(this.eDC.getPageContext());
        this.eKa.ti();
    }

    public void aj(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eKd == null) {
            this.eKd = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eDC.getLayoutMode().t(this.eKd);
        if (this.eKc == null) {
            this.eKc = new Dialog(this.eDC.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eKc.setCanceledOnTouchOutside(true);
            this.eKc.setCancelable(true);
            this.eKn = (ScrollView) this.eKd.findViewById(d.h.good_scroll);
            this.eKc.setContentView(this.eKd);
            WindowManager.LayoutParams attributes = this.eKc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds540);
            this.eKc.getWindow().setAttributes(attributes);
            this.eKf = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.18
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.eKi = (String) compoundButton.getTag();
                        if (an.this.eJg != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : an.this.eJg) {
                                String str = (String) aVar.getTag();
                                if (str != null && an.this.eKi != null && !str.equals(an.this.eKi)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eKe = (LinearLayout) this.eKd.findViewById(d.h.good_class_group);
            this.eKh = (TextView) this.eKd.findViewById(d.h.dialog_button_cancel);
            this.eKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eKc instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(an.this.eKc, an.this.eDC.getPageContext());
                    }
                }
            });
            this.eKg = (TextView) this.eKd.findViewById(d.h.dialog_button_ok);
            this.eKg.setOnClickListener(this.crU);
        }
        this.eKe.removeAllViews();
        this.eJg = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.eDC.getPageContext().getString(d.l.def_good_class));
        this.eJg.add(bI);
        bI.setChecked(true);
        this.eKe.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bI2 = bI(String.valueOf(arrayList.get(i2).pX()), arrayList.get(i2).pW());
                this.eJg.add(bI2);
                View view = new View(this.eDC.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eKe.addView(view);
                this.eKe.addView(bI2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eKn.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eDC.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eDC.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eDC.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eKn.setLayoutParams(layoutParams2);
            this.eKn.removeAllViews();
            this.eKn.addView(this.eKe);
        }
        com.baidu.adp.lib.g.g.a(this.eKc, this.eDC.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.eDC.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.eKf);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aRl() {
        this.eDC.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eDC.hideProgressBar();
        if (z && z2) {
            this.eDC.showToast(this.eDC.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eDC.showToast(str);
        }
    }

    public void axb() {
        this.eJW.setVisibility(0);
    }

    public void axa() {
        this.eJW.setVisibility(8);
    }

    public View aRm() {
        if (this.eKd != null) {
            return this.eKd.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aRn() {
        return this.eKi;
    }

    public View getView() {
        return this.ccT;
    }

    public void aRo() {
        com.baidu.adp.lib.util.l.a(this.eDC.getPageContext().getPageActivity(), this.eDC.getCurrentFocus());
    }

    public void ju(boolean z) {
        this.eDC.hideProgressBar();
        aCA();
    }

    public void aRp() {
        this.cvc.wp();
        this.cvc.wt();
    }

    public void aRq() {
        this.eDC.hideProgressBar();
        wu();
        this.eJf.completePullRefreshPostDelayed(2000L);
        aRA();
    }

    public void aRr() {
        this.eJf.completePullRefreshPostDelayed(2000L);
        aRA();
    }

    private void jv(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eKq.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eDC.getResources().getDimensionPixelSize(d.f.ds130) : this.eDC.getResources().getDimensionPixelSize(d.f.ds34);
        this.eKq.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eJQ.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z, boolean z2) {
        if (this.eKj != null) {
            this.eKj.dismiss();
            this.eKj = null;
        }
        this.eKj = new com.baidu.tbadk.core.dialog.b(this.eDC.getPageContext().getPageActivity());
        this.eKj.cg(d.l.operation);
        if (z2) {
            this.eKj.a(new String[]{this.eDC.getPageContext().getString(d.l.copy)}, interfaceC0047b);
        } else if (!z) {
            this.eKj.a(new String[]{this.eDC.getPageContext().getString(d.l.copy), this.eDC.getPageContext().getString(d.l.mark)}, interfaceC0047b);
        } else {
            this.eKj.a(new String[]{this.eDC.getPageContext().getString(d.l.copy), this.eDC.getPageContext().getString(d.l.remove_mark)}, interfaceC0047b);
        }
        this.eKj.d(this.eDC.getPageContext());
        this.eKj.tl();
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z) {
        if (this.eKk != null) {
            this.eKk.dismiss();
            this.eKk = null;
        }
        this.eKk = new com.baidu.tbadk.core.dialog.b(this.eDC.getPageContext().getPageActivity());
        this.eKk.cg(d.l.operation);
        if (z) {
            this.eKk.a(new String[]{this.eDC.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0047b);
        } else {
            this.eKk.a(new String[]{this.eDC.getPageContext().getString(d.l.save_to_emotion), this.eDC.getPageContext().getString(d.l.save_to_local)}, interfaceC0047b);
        }
        this.eKk.d(this.eDC.getPageContext());
        this.eKk.tl();
    }

    public int aRs() {
        return pu(this.eJf.getFirstVisiblePosition());
    }

    private int pu(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eJf.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eJf.getAdapter() == null || !(this.eJf.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eJf.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aRt() {
        int lastVisiblePosition = this.eJf.getLastVisiblePosition();
        if (this.eIW != null) {
            if (lastVisiblePosition == this.eJf.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.eJQ.aPf();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pu(lastVisiblePosition);
    }

    public void pv(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.eJf != null) {
            if (this.eJb == null || this.eJb.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.eJb.mNavigationBar.getFixedNavHeight();
                boolean isUseStyleImmersiveSticky = this.eDC.isUseStyleImmersiveSticky();
                boolean z = this.eDC.aOs() != -1;
                if (isUseStyleImmersiveSticky) {
                    fixedNavHeight -= eKK;
                }
                if (z) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.eKI != null && (layoutParams = (LinearLayout.LayoutParams) this.eKI.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.eKI.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.eJf.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.eJf.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eJT.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        this.eJQ.a(fVar, false);
        this.eJQ.notifyDataSetChanged();
        aRA();
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        if (this.eJA == null) {
            this.eDC.getLayoutMode().t(((ViewStub) this.eJh.findViewById(d.h.praise_layout)).inflate());
            this.eJA = (FrsPraiseView) this.eJh.findViewById(d.h.pb_head_praise_view);
            this.eJA.setIsFromPb(true);
            this.eJO = this.eJh.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eJA.dE(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eJA != null) {
            boolean aRA = aRA();
            this.eJA.setVisibility(8);
            if (fVar != null && fVar.qx() != null && fVar.qx().qu() == 0 && this.eAb) {
                if (aRA) {
                    this.eJN.setVisibility(0);
                    return;
                } else {
                    this.eJN.setVisibility(8);
                    return;
                }
            }
            this.eJN.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aNk() != null) {
            return fVar.aNk();
        }
        if (!com.baidu.tbadk.core.util.v.u(fVar.aNd())) {
            Iterator<PostData> it = fVar.aNd().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bry() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aNi();
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
        if (fVar == null || fVar.aNb() == null || fVar.aNb().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aNb().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aNb().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tB(1);
        postData.setId(fVar.aNb().rL());
        postData.setTitle(fVar.aNb().getTitle());
        postData.setTime(fVar.aNb().getCreateTime());
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
        com.baidu.tbadk.data.g brB;
        String portrait;
        if (fVar != null && fVar.aNb() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aRQ();
            this.eJm.setVisibility(8);
            if (fVar.aNb() != null && fVar.aNb().si() && fVar.aNb().rM() != null) {
                this.eLc = true;
                this.eJb.jM(this.eLc);
                if (this.eIW == null) {
                    this.eIW = new com.baidu.tieba.pb.video.i(this.eDC, this.eJb, fVar.aNb().rM());
                    this.eIW.a(fVar.aNb().rM(), fVar.aNb(), fVar.getForumId());
                    this.eIW.startPlay();
                } else if (this.eIZ) {
                    this.eIW.a(fVar.aNb().rM(), fVar.aNb(), fVar.getForumId());
                    this.eIW.startPlay();
                } else {
                    this.eIW.pr(fVar.getForumId());
                }
                if (fVar.aNc() != null && fVar.aNc().size() >= 1) {
                    bh bhVar = fVar.aNc().get(0);
                    this.eIW.ac(bhVar);
                    this.eIW.ps(bhVar.getTitle());
                }
                this.eIW.b(b, fVar.aNb(), fVar.aNx());
                this.eIZ = false;
                this.eJf.removeHeaderView(this.eIW.aUq());
                this.eJf.addHeaderView(this.eIW.aUq(), 0);
                if (this.eIW.aUo() != null && this.eIW.aUo().getParent() == null) {
                    this.eKG.addView(this.eIW.aUo());
                }
                if (this.eIX == null) {
                    this.eIX = new com.baidu.tieba.pb.video.h(this.eDC);
                }
                this.eIX.a(fVar.aNb().sz(), fVar.aNb(), fVar.aNu());
                this.eJf.removeHeaderView(this.eIX.aUf());
                this.eJf.addHeaderView(this.eIX.aUf(), 1);
                if (fVar.aNb().sz() != null) {
                    this.eJf.removeHeaderView(this.eIX.aUg());
                    this.eJf.removeHeaderView(this.eJk);
                    this.eJf.addHeaderView(this.eIX.aUg(), 2);
                } else {
                    if (this.eIX.aUg() != null) {
                        this.eJf.removeHeaderView(this.eIX.aUg());
                    }
                    this.eJf.removeHeaderView(this.eJk);
                    this.eJf.addHeaderView(this.eJk, 2);
                }
                if (this.eIW != null) {
                    this.eJb.jI(false);
                    this.eJb.jJ(TbadkCoreApplication.isLogin());
                    this.eIW.pH(0);
                }
                aRy();
            } else {
                this.eLc = false;
                this.eJb.jM(this.eLc);
                if (this.eIW != null) {
                    this.eJf.removeHeaderView(this.eIW.aUq());
                }
                if (this.eIX != null) {
                    this.eIX.e(this.eJf);
                }
            }
            if (this.eDC.aOg() != null) {
                this.eDC.aOg().jG(this.eLc);
            }
            if (this.eIW != null) {
                this.eIW.F(this.eLA);
            }
            if (b != null) {
                this.eKy = b;
                this.eJm.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eJm.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eJm.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, b);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eLo) {
                    this.eJi.setVisibility(0);
                }
                if (!fVar.aNb().si() && this.eJj.getText() != null && this.eJj.getText().length() > 0) {
                    this.eJj.setVisibility(0);
                } else {
                    this.eJj.setVisibility(8);
                }
                o(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rG = fVar.aNb().rG();
                if (rG != null && rG.size() > 0 && !this.eLo) {
                    this.eKB.setText(String.valueOf(rG.get(0).pn()));
                    this.eKA.setVisibility(0);
                } else {
                    this.eKA.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.eKA, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.eKB, d.e.cp_link_tip_d, 1);
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
                            if (this.eEP != null) {
                                this.eEP.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                                this.eEP.setOnClickListener(this.eDC.eBT.cBo);
                                this.eEP.a(iconInfo, i3, this.eDC.getResources().getDimensionPixelSize(d.f.ds26), this.eDC.getResources().getDimensionPixelSize(d.f.ds26), this.eDC.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eEO != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eEO.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eEO.setOnClickListener(this.eDC.eBT.ePe);
                                this.eEO.a(tShowInfoNew, 3, this.eDC.getResources().getDimensionPixelSize(d.f.ds36), this.eDC.getResources().getDimensionPixelSize(d.f.ds36), this.eDC.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eJo.setText(ah(b.getAuthor().getSealPrefix(), e));
                            this.eJo.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.eJo.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.u(tShowInfoNew) || b.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_cont_f, 1);
                            }
                            if (b == null && !TextUtils.isEmpty(b.getAuthor().getGodIntro())) {
                                this.eJp.setVisibility(0);
                                this.eJp.setText(am.b(b.getAuthor()));
                                this.eJq.setVisibility(0);
                            } else {
                                this.eJp.setVisibility(8);
                                this.eJq.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eJr, d.e.cp_link_tip_a, 1);
                            this.eJr.setVisibility(0);
                            if (fVar.aNb().getAuthor() != null && fVar.aNb().getAuthor().getAlaUserData() != null && this.eJw != null) {
                                if (fVar.aNb().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eJw.setVisibility(8);
                                } else {
                                    this.eJw.setVisibility(0);
                                    if (this.eIY == null) {
                                        this.eIY = new com.baidu.tieba.d.a(this.eDC.getPageContext(), this.eJw);
                                        this.eIY.ig(1);
                                    }
                                    this.eIY.aM(this.eDC.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.QH = fVar.aNb().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eJw.setTag(aVar);
                                }
                            }
                            this.eJv.setUserId(b.getAuthor().getUserId());
                            this.eJv.setUserName(b.getAuthor().getUserName());
                            this.eJv.setImageDrawable(null);
                            this.eJv.setRadius(com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds40));
                            this.eJv.setTag(b.getAuthor().getUserId());
                            this.eJG.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds8);
                            if (this.eJp == null && this.eJp.getVisibility() == 0) {
                                this.eJG.setPadding(f, 0, f, 0);
                            } else {
                                this.eJG.setPadding(0, 0, f, 0);
                            }
                            brB = b.brB();
                            if (brB == null && !TextUtils.isEmpty(brB.getName()) && !TextUtils.isEmpty(brB.getName().trim())) {
                                final String name = brB.getName();
                                final String lat = brB.getLat();
                                final String lng = brB.getLng();
                                this.eJH.setVisibility(0);
                                this.eJI.setVisibility(0);
                                this.eJH.setText(brB.getName());
                                this.eJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.21
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                an.this.eDC.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(an.this.eDC.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, an.this.eDC.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.eJH.setVisibility(8);
                                this.eJI.setVisibility(8);
                            }
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null && !StringUtils.isNull(b.getAuthor().getPendantData().pS())) {
                                UtilHelper.showHeadImageViewBigV(this.eJt.getHeadView(), b.getAuthor());
                                this.eJv.setVisibility(8);
                                this.eJt.setVisibility(0);
                                if (this.eJB != null) {
                                    this.eJB.setVisibility(8);
                                }
                                this.eJo.setOnClickListener(this.eLA);
                                this.eJt.getHeadView().c(portrait, 28, false);
                                this.eJt.getHeadView().setUserId(b.getAuthor().getUserId());
                                this.eJt.getHeadView().setUserName(b.getAuthor().getUserName());
                                this.eJt.getHeadView().setOnClickListener(this.eLA);
                                this.eJt.ei(b.getAuthor().getPendantData().pS());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eJv, b.getAuthor());
                                this.eJv.setVisibility(0);
                                this.eJm.setOnClickListener(this.eLA);
                                this.eJo.setOnClickListener(this.eLA);
                                this.eJv.setOnClickListener(this.eLA);
                                this.eJt.setVisibility(8);
                                this.eJv.c(portrait, 28, false);
                            }
                            String name_show = b.getAuthor().getName_show();
                            String userName = b.getAuthor().getUserName();
                            if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.eJo.setText(com.baidu.tieba.pb.c.aq(this.eDC.getPageContext().getPageActivity(), this.eJo.getText().toString()));
                                this.eJo.setGravity(16);
                                this.eJo.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMD());
                                com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = b.getAuthor().getIconInfo();
                        tShowInfoNew = b.getAuthor().getTShowInfoNew();
                        if (this.eEP != null) {
                        }
                        if (this.eEO != null) {
                        }
                        this.eJo.setText(ah(b.getAuthor().getSealPrefix(), e));
                        this.eJo.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.eJo.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.u(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eJp.setVisibility(8);
                        this.eJq.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eJr, d.e.cp_link_tip_a, 1);
                        this.eJr.setVisibility(0);
                        if (fVar.aNb().getAuthor() != null) {
                            if (fVar.aNb().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eJv.setUserId(b.getAuthor().getUserId());
                        this.eJv.setUserName(b.getAuthor().getUserName());
                        this.eJv.setImageDrawable(null);
                        this.eJv.setRadius(com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds40));
                        this.eJv.setTag(b.getAuthor().getUserId());
                        this.eJG.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds8);
                        if (this.eJp == null) {
                        }
                        this.eJG.setPadding(0, 0, f, 0);
                        brB = b.brB();
                        if (brB == null) {
                        }
                        this.eJH.setVisibility(8);
                        this.eJI.setVisibility(8);
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eJv, b.getAuthor());
                        this.eJv.setVisibility(0);
                        this.eJm.setOnClickListener(this.eLA);
                        this.eJo.setOnClickListener(this.eLA);
                        this.eJv.setOnClickListener(this.eLA);
                        this.eJt.setVisibility(8);
                        this.eJv.c(portrait, 28, false);
                        String name_show2 = b.getAuthor().getName_show();
                        String userName2 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                            this.eJo.setText(com.baidu.tieba.pb.c.aq(this.eDC.getPageContext().getPageActivity(), this.eJo.getText().toString()));
                            this.eJo.setGravity(16);
                            this.eJo.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMD());
                            com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = b.getAuthor().getIconInfo();
                            tShowInfoNew = b.getAuthor().getTShowInfoNew();
                            if (this.eEP != null) {
                            }
                            if (this.eEO != null) {
                            }
                            this.eJo.setText(ah(b.getAuthor().getSealPrefix(), e));
                            this.eJo.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.eJo.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.u(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_cont_h, 1);
                            if (b == null) {
                            }
                            this.eJp.setVisibility(8);
                            this.eJq.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.c(this.eJr, d.e.cp_link_tip_a, 1);
                            this.eJr.setVisibility(0);
                            if (fVar.aNb().getAuthor() != null) {
                            }
                            this.eJv.setUserId(b.getAuthor().getUserId());
                            this.eJv.setUserName(b.getAuthor().getUserName());
                            this.eJv.setImageDrawable(null);
                            this.eJv.setRadius(com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds40));
                            this.eJv.setTag(b.getAuthor().getUserId());
                            this.eJG.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds8);
                            if (this.eJp == null) {
                            }
                            this.eJG.setPadding(0, 0, f, 0);
                            brB = b.brB();
                            if (brB == null) {
                            }
                            this.eJH.setVisibility(8);
                            this.eJI.setVisibility(8);
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eJv, b.getAuthor());
                            this.eJv.setVisibility(0);
                            this.eJm.setOnClickListener(this.eLA);
                            this.eJo.setOnClickListener(this.eLA);
                            this.eJv.setOnClickListener(this.eLA);
                            this.eJt.setVisibility(8);
                            this.eJv.c(portrait, 28, false);
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
                        if (this.eEP != null) {
                        }
                        if (this.eEO != null) {
                        }
                        this.eJo.setText(ah(b.getAuthor().getSealPrefix(), e));
                        this.eJo.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.eJo.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.u(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eJo, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eJp.setVisibility(8);
                        this.eJq.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eJr, d.e.cp_link_tip_a, 1);
                        this.eJr.setVisibility(0);
                        if (fVar.aNb().getAuthor() != null) {
                        }
                        this.eJv.setUserId(b.getAuthor().getUserId());
                        this.eJv.setUserName(b.getAuthor().getUserName());
                        this.eJv.setImageDrawable(null);
                        this.eJv.setRadius(com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds40));
                        this.eJv.setTag(b.getAuthor().getUserId());
                        this.eJG.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.ds8);
                        if (this.eJp == null) {
                        }
                        this.eJG.setPadding(0, 0, f, 0);
                        brB = b.brB();
                        if (brB == null) {
                        }
                        this.eJH.setVisibility(8);
                        this.eJI.setVisibility(8);
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eJv, b.getAuthor());
                        this.eJv.setVisibility(0);
                        this.eJm.setOnClickListener(this.eLA);
                        this.eJo.setOnClickListener(this.eLA);
                        this.eJv.setOnClickListener(this.eLA);
                        this.eJt.setVisibility(8);
                        this.eJv.c(portrait, 28, false);
                        String name_show222 = b.getAuthor().getName_show();
                        String userName222 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eJl.V(fVar.aNb());
                }
                if (this.eKJ != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.ezb);
                    if (fVar != null && fVar.aNb() != null) {
                        jVar.ezd = fVar.aNb().rn();
                    }
                    jVar.aEG = !this.eAb;
                    jVar.eze = this.eDC.aOS();
                    this.eKJ.a(jVar);
                }
            }
        }
    }

    public void jw(boolean z) {
        if (z) {
            aRu();
        } else {
            aRv();
        }
        this.eKN.eLT = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKN));
        a(this.eKN.eLT, false);
    }

    public void aRu() {
        if (this.eJb != null && !this.eLe) {
            this.eJb.jN(!StringUtils.isNull(this.eDC.aOp()));
            this.eLe = true;
        }
    }

    public void aRv() {
        if (this.eJb != null) {
            this.eJb.aSR();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rQ() != null) {
            this.eJn.a(this.eDC.getPageContext(), fVar.aNd().get(0).rQ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aMZ().getId(), fVar.aMZ().getName(), fVar.aNb().getId(), this.eDC.aOP() ? "FRS" : null));
            this.eJm.setPadding(this.eJm.getPaddingLeft(), (int) this.eDC.getResources().getDimension(d.f.ds20), this.eJm.getPaddingRight(), this.eJm.getPaddingBottom());
            return;
        }
        this.eJn.a(null, null, null);
    }

    public void aRw() {
        if (this.eIW != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.eIW.aUp();
            this.eJf.smoothScrollToPosition(0);
        }
    }

    public boolean aRx() {
        return this.eLB;
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
            this.eJb.aSP();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eJb.nb(eVar.forumName);
            }
            String string = this.eDC.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eDC.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eDC.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eDC.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eyp;
            this.eDC.showNetRefreshView(this.ccT, format, null, this.eDC.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.22
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        av.vH().c(an.this.eDC.getPageContext(), new String[]{str2});
                        an.this.eDC.finish();
                        return;
                    }
                    an.this.eDC.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aQF;
        Parcelable aQF2;
        String str;
        if (fVar != null) {
            this.eFO = fVar;
            this.mType = i;
            if (fVar.aNb() != null) {
                this.eKP = fVar.aNb().ri();
                this.Zq = fVar.aNb().re();
                if (fVar.aNb().getAnchorLevel() != 0) {
                    this.eLB = true;
                }
                this.eKm = N(fVar.aNb());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            r(fVar);
            this.eKz = false;
            this.eAb = z;
            aRq();
            b(fVar, z, i);
            p(fVar);
            if (this.eDC.aOF()) {
                if (this.eJU == null) {
                    this.eJU = new com.baidu.tieba.pb.view.i(this.eDC.getPageContext());
                    this.eJU.ld();
                    this.eJU.a(this.amp);
                }
                this.eJf.setPullRefresh(this.eJU);
                aRy();
                if (this.eJU != null) {
                    this.eJU.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qx().qu() == 0 && z) {
                this.eJf.setPullRefresh(null);
            } else {
                if (this.eJU == null) {
                    this.eJU = new com.baidu.tieba.pb.view.i(this.eDC.getPageContext());
                    this.eJU.ld();
                    this.eJU.a(this.amp);
                }
                this.eJf.setPullRefresh(this.eJU);
                aRy();
                if (this.eJU != null) {
                    this.eJU.dz(TbadkCoreApplication.getInst().getSkinType());
                }
                Sv();
            }
            aRA();
            this.eJQ.iF(this.eAb);
            this.eJQ.iG(false);
            this.eJQ.iS(i == 5);
            this.eJQ.iT(i == 6);
            this.eJQ.iU(z2 && this.eLz);
            this.eJQ.a(fVar, false);
            this.eJQ.notifyDataSetChanged();
            if (this.eDC.aOT()) {
                if (fVar.aNa() != null) {
                    this.mForumName = fVar.aNa().getForumName();
                    this.mForumId = fVar.aNa().getForumId();
                }
                if (this.mForumName == null && this.eDC.aOi() != null && this.eDC.aOi().aPw() != null) {
                    this.mForumName = this.eDC.aOi().aPw();
                }
                this.eJb.nb(this.mForumName);
            } else {
                this.eJb.nb(null);
            }
            if (this.eDC.aOT()) {
                this.eLg = 0;
                PostData b = b(fVar, z);
                if (b != null && b.getAuthor() != null) {
                    this.eLg = b.getAuthor().getLevel_id();
                }
                if (this.eLg > 0) {
                    this.eJs.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.eJs, BitmapHelper.getGradeResourceIdInEnterForum(this.eLg));
                } else {
                    this.eJs.setVisibility(8);
                }
            } else {
                this.eJs.setVisibility(8);
            }
            if (fVar.aNb() != null && fVar.aNb().rl() != null) {
                if (fVar.aNb().rl().getNum() < 1) {
                    str = this.eDC.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aNb().rl().getNum() + "";
                }
                if (this.eIV != -1) {
                    fVar.aNb().rl().setIsLike(this.eIV);
                }
                R(str, fVar.aNb().rl().getIsLike() == 1);
            }
            if (this.eDC.isLogin()) {
                this.eJf.setNextPage(this.cvc);
                this.eJa = 2;
                Sv();
            } else {
                this.eKz = true;
                if (fVar.qx().qt() == 1) {
                    if (this.eJV == null) {
                        this.eJV = new com.baidu.tieba.pb.view.b(this.eDC.getPageContext());
                    }
                    this.eJf.setNextPage(this.eJV);
                } else {
                    this.eJf.setNextPage(this.cvc);
                }
                this.eJa = 3;
            }
            ArrayList<PostData> aNd = fVar.aNd();
            if (fVar.qx().qt() == 0 || aNd == null || aNd.size() < fVar.qx().qs()) {
                if (com.baidu.tbadk.core.util.v.t(aNd) == 0 || (com.baidu.tbadk.core.util.v.t(aNd) == 1 && aNd.get(0) != null && aNd.get(0).bry() == 1)) {
                    this.cvc.setText(this.eDC.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.cvc.setText(this.eDC.getResources().getString(d.l.list_has_no_more));
                }
                if (this.eDC.aOF() && this.eJf != null && this.eJf.getData() != null && this.eJf.getData().size() == 1 && (this.eJf.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cvc.setText("");
                }
                aRF();
            } else if (z2) {
                if (this.eLz) {
                    wu();
                    if (fVar.qx().qt() != 0) {
                        this.cvc.setText(this.eDC.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.cvc.wp();
                    this.cvc.showLoading();
                }
            } else {
                this.cvc.wp();
                this.cvc.showLoading();
            }
            switch (i) {
                case 2:
                    this.eJf.setSelection(i2 > 1 ? (((this.eJf.getData() == null && fVar.aNd() == null) ? 0 : (this.eJf.getData().size() - fVar.aNd().size()) + this.eJf.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aQF2 = ae.aQE().aQF()) != null) {
                        this.eJf.onRestoreInstanceState(aQF2);
                        if (com.baidu.tbadk.core.util.v.t(aNd) > 1 && fVar.qx().qt() > 0) {
                            this.cvc.wu();
                            this.cvc.setText(this.eDC.getString(d.l.pb_load_more_without_point));
                            this.cvc.wq();
                            break;
                        }
                    } else {
                        this.eJf.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eLz = false;
                    break;
                case 5:
                    this.eJf.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aQF = ae.aQE().aQF()) != null) {
                        this.eJf.onRestoreInstanceState(aQF);
                        break;
                    } else {
                        this.eJf.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.eIW != null && this.eIW.aUo() != null) {
                            if (this.eDC.isUseStyleImmersiveSticky()) {
                                this.eJf.setSelectionFromTop((this.eJQ.aPi() + this.eJf.getHeaderViewsCount()) - 1, this.eIW.aUo().getHeight() - com.baidu.adp.lib.util.l.n(this.eDC.getPageContext().getPageActivity()));
                            } else {
                                this.eJf.setSelectionFromTop((this.eJQ.aPi() + this.eJf.getHeaderViewsCount()) - 1, this.eIW.aUo().getHeight());
                            }
                        } else {
                            this.eJf.setSelection(this.eJQ.aPi() + this.eJf.getHeaderViewsCount());
                        }
                    } else {
                        this.eJf.setSelection(i2 > 0 ? ((this.eJf.getData() == null && fVar.aNd() == null) ? 0 : (this.eJf.getData().size() - fVar.aNd().size()) + this.eJf.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cvc.wu();
                    this.cvc.setText(this.eDC.getString(d.l.pb_load_more_without_point));
                    this.cvc.wq();
                    break;
            }
            if (this.eKP == eKQ && isHost()) {
                aRL();
            }
            if (this.eLa) {
                aQO();
                this.eLa = false;
                if (i3 == 0) {
                    jq(true);
                }
            }
            if (this.eIX != null) {
                this.eIX.ab(fVar.aNb());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aRy() {
        if (this.eIW != null && this.eIW.aUo() != null) {
            this.eJf.removeHeaderView(this.awZ);
            if (this.mType != 1) {
                this.eJf.removeHeaderView(this.eIW.aUq());
                this.eJf.addHeaderView(this.eIW.aUq(), 0);
                return;
            }
            return;
        }
        if (this.eIW != null) {
            this.eJf.removeHeaderView(this.eIW.aUq());
        }
        this.eJf.removeHeaderView(this.awZ);
        this.eJf.addHeaderView(this.awZ, 0);
    }

    public void jx(boolean z) {
        this.eKl = z;
    }

    public void wu() {
        if (this.cvc != null) {
            this.cvc.wq();
            this.cvc.wu();
        }
        Sv();
    }

    public void Od() {
        this.eJf.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.eKy != null && this.eKy.getAuthor() != null && this.eJb != null) {
            this.eLd = com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !this.eLc;
            this.eJb.jI(this.eLd);
            if (this.eDC.aOg() != null) {
                this.eDC.aOg().jH(this.eLd);
            }
            aRz();
            if (this.eLd) {
                this.eJb.ePV.setVisibility(0);
                this.eJC.setVisibility(8);
                if (this.eKm) {
                    this.eJb.ePW.setVisibility(8);
                } else if (!PbNormalLikeButtonSwitchStatic.Gw() || (this.eKy.getAuthor().hadConcerned() && this.eKy.getAuthor().getGodUserData() != null && this.eKy.getAuthor().getGodUserData().getIsFromNetWork())) {
                    this.eJb.ePW.setVisibility(8);
                }
                if (this.eKI != null) {
                    this.eKI.setVisibility(8);
                }
                if (this.eJu != null) {
                    this.eJu.setVisibility(8);
                }
                if (this.eJB != null) {
                    this.eJB.setVisibility(8);
                }
                this.eJb.ePX.setUserId(this.eKy.getAuthor().getUserId());
                this.eJb.ePX.setUserName(this.eKy.getAuthor().getUserName());
                this.eJb.ePX.setImageDrawable(null);
                this.eJb.ePX.setTag(this.eKy.getAuthor().getUserId());
                UtilHelper.showHeadImageViewBigV(this.eJb.ePX, this.eKy.getAuthor());
                this.eJb.ePX.setVisibility(0);
                this.eJb.ePX.setOnClickListener(this.eLA);
                this.eJb.ePX.c(this.eKy.getAuthor().getPortrait(), 28, false);
                if (this.eLm == null) {
                    this.eLm = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.24
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > an.this.eLf) {
                                an.this.aRK();
                            }
                        }
                    };
                }
                this.eJf.setListViewDragListener(this.eLm);
                return;
            }
            if (this.eJb.ePV != null) {
                this.eJb.ePV.setVisibility(8);
            }
            if (this.eKI != null) {
                this.eKI.setVisibility(0);
            }
            if (this.eKm) {
                this.eJC.setVisibility(8);
                this.eJF.setVisibility(0);
                this.eJF.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.person_view_num), com.baidu.tbadk.core.util.am.v(fVar.aNw())));
            } else if (!PbNormalLikeButtonSwitchStatic.Gw() || (this.eKy.getAuthor().hadConcerned() && this.eKy.getAuthor().getGodUserData() != null && this.eKy.getAuthor().getGodUserData().getIsFromNetWork())) {
                this.eJC.setVisibility(8);
                this.eJF.setVisibility(8);
            } else {
                this.eJC.setVisibility(0);
                this.eJC.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eDC.getActivity(), d.f.fontsize26));
                this.eJF.setVisibility(8);
            }
            this.eLm = null;
            this.eJf.setListViewDragListener(null);
        }
    }

    private void aRz() {
        String threadId = this.eFO != null ? this.eFO.getThreadId() : "";
        if (this.eLd) {
            if (this.eJE == null) {
                this.eJE = new al(this.eDC.getPageContext(), this.eJb.ePW, 3);
                this.eJE.h(this.eDC.getUniqueId());
                this.eJE.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.25
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void aQ(boolean z) {
                        if (an.this.eDC != null && z) {
                            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                            if (i >= 2) {
                                com.baidu.adp.lib.util.l.showToast(an.this.eDC, d.l.attention_success);
                                return;
                            }
                            am.w(an.this.eDC.getPageContext());
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                        }
                    }
                });
            }
            if (this.eKy != null && this.eKy.getAuthor() != null) {
                this.eKy.getAuthor().setIsLike(this.eKy.getAuthor().hadConcerned());
                this.eJE.a(this.eKy.getAuthor());
            }
            this.eJE.cy(threadId);
            this.eJE.eIS = this.eLc;
            if (this.eJD != null) {
                this.eJD.unRegisterListener(this.eDC.getUniqueId());
                return;
            }
            return;
        }
        if (this.eJD == null) {
            this.eJD = new al(this.eDC.getPageContext(), this.eJC, 1);
            this.eJD.h(this.eDC.getUniqueId());
            this.eJD.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.26
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aQ(boolean z) {
                    if (an.this.eDC != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(an.this.eDC, d.l.attention_success);
                            return;
                        }
                        am.w(an.this.eDC.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.eKy != null && this.eKy.getAuthor() != null) {
            this.eKy.getAuthor().setIsLike(this.eKy.getAuthor().hadConcerned());
            this.eJD.a(this.eKy.getAuthor());
            this.eJD.cy(threadId);
        }
        this.eJD.eIS = this.eLc;
        if (this.eJE != null) {
            this.eJE.unRegisterListener(this.eDC.getUniqueId());
        }
    }

    private boolean aRA() {
        boolean z;
        if (this.eKo != null && this.eKo.getVisibility() == 0) {
            if (this.eJM != null) {
                this.eJM.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eJM != null) {
                this.eJM.setVisibility(8);
            }
            z = false;
        }
        if ((this.eJO == null || this.eJO.getVisibility() == 8) && z && this.eAb) {
            this.eJN.setVisibility(0);
        } else {
            this.eJN.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aNb() == null) {
            return false;
        }
        if (fVar.aNb().rs() == 1 || fVar.aNb().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aNb().ru() == null || fVar.aNb().ru().sV() == 0) || fVar.aNb().rq() == 1 || fVar.aNb().rr() == 1 || fVar.aNb().sa() || fVar.aNb().sn() || fVar.aNb().sh() || fVar.aNb().rH() != null || fVar.aNb().so() || fVar.aNb().so() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aNb().getCategory()) || fVar.aNb().ry() || fVar.aNb().rx();
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eDC.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eJi != null) {
                if (fVar.aNb() != null && fVar.aNb().rK() == 0 && !fVar.aNb().si() && !this.eLo) {
                    this.eJi.setVisibility(0);
                    if (fVar.aNb() != null) {
                        fVar.aNb().e(true, q(fVar));
                    }
                    SpannableStringBuilder rV = fVar.aNb().rV();
                    this.eJj.setOnTouchListener(new com.baidu.tieba.view.k(rV));
                    this.eJj.setText(rV);
                    this.eJj.setVisibility(0);
                } else if (fVar.aNb().rK() == 1) {
                    if (fVar.aNb() != null) {
                        fVar.aNb().e(true, q(fVar));
                        SpannableStringBuilder rV2 = fVar.aNb().rV();
                        if (rV2 == null || rV2.length() == 0) {
                            this.eJi.setVisibility(8);
                            this.eJf.removeHeaderView(this.eJi);
                            if (fVar.aNb() != null && !fVar.aNb().si()) {
                                this.eJm.setPadding(this.eJm.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds48), this.eJm.getPaddingRight(), this.eJm.getPaddingBottom());
                            }
                        } else {
                            this.eJi.setVisibility(0);
                            this.eJj.setOnTouchListener(new com.baidu.tieba.view.k(rV2));
                            this.eJj.setText(rV2);
                            this.eJj.setVisibility(0);
                        }
                    }
                } else {
                    this.eJi.setVisibility(8);
                    this.eJf.removeHeaderView(this.eJi);
                    if (fVar.aNb() != null && fVar.aNb().si()) {
                        this.eJm.setPadding(this.eJm.getPaddingLeft(), 0, this.eJm.getPaddingRight(), this.eJm.getPaddingBottom());
                    } else {
                        this.eJm.setPadding(this.eJm.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds48), this.eJm.getPaddingRight(), this.eJm.getPaddingBottom());
                    }
                }
            }
            this.eAb = z;
            bh aNb = fVar.aNb();
            if (aNb != null) {
                a(aNb.ru());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aRA();
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
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aNm()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, b.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, b.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aNm()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aHV;
    }

    public void oV(String str) {
        if (this.cvc != null) {
            this.cvc.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eJf;
    }

    public int aRB() {
        return d.h.richText;
    }

    public TextView aOb() {
        return this.eJl.aOb();
    }

    public void d(BdListView.e eVar) {
        this.eJf.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.amp = bVar;
        if (this.eJU != null) {
            this.eJU.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int qr = apVar.qr();
            int qo = apVar.qo();
            if (this.eJR != null) {
                this.eJR.ti();
            } else {
                this.eJR = new com.baidu.tbadk.core.dialog.a(this.eDC.getPageContext().getPageActivity());
                this.eJS = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.eJR.v(this.eJS);
                this.eJR.a(d.l.dialog_ok, bVar);
                this.eJR.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.27
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.aCA();
                        aVar.dismiss();
                    }
                });
                this.eJR.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.28
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.eKX == null) {
                            an.this.eKX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.eDC.HidenSoftKeyPad((InputMethodManager) an.this.eDC.getSystemService("input_method"), an.this.ccT);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(an.this.eKX, 150L);
                    }
                });
                this.eJR.b(this.eDC.getPageContext()).ti();
            }
            this.eJT = (EditText) this.eJS.findViewById(d.h.input_page_number);
            this.eJT.setText("");
            TextView textView = (TextView) this.eJS.findViewById(d.h.current_page_number);
            if (qr <= 0) {
                qr = 1;
            }
            if (qo <= 0) {
                qo = 1;
            }
            textView.setText(MessageFormat.format(this.eDC.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qr), Integer.valueOf(qo)));
            this.eDC.ShowSoftKeyPadDelay(this.eJT, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eJf.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eDC.showToast(str);
    }

    public boolean jy(boolean z) {
        if (this.JG == null || !this.JG.CC()) {
            return false;
        }
        this.JG.AN();
        return true;
    }

    public void aRC() {
        if (this.eLC != null) {
            while (this.eLC.size() > 0) {
                TbImageView remove = this.eLC.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aRC();
        this.eJQ.ph(1);
        if (this.eIW != null) {
            this.eIW.onPause();
        }
    }

    public void onResume() {
        this.eJQ.ph(2);
        if (this.eIW != null) {
            this.eIW.onResume();
        }
    }

    public void onDestroy() {
        if (this.eKZ != null) {
            this.eKZ.destroy();
        }
        if (this.eIY != null) {
            this.eIY.Zz();
        }
        if (this.eIX != null) {
            this.eIX.onDestroy();
        }
        this.eDC.hideProgressBar();
        if (this.ccR != null && this.coJ != null) {
            this.ccR.b(this.coJ);
        }
        aCA();
        wu();
        if (this.eKX != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eKX);
        }
        if (this.eJm != null && this.eJB != null) {
            this.eJm.removeView(this.eJu);
            this.eJB = null;
        }
        if (this.eKD != null) {
            this.eKD.clearStatus();
        }
        this.eLv = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eJQ.ph(3);
        if (this.csg != null) {
            this.csg.setBackgroundDrawable(null);
        }
        if (this.eIW != null) {
            this.eIW.destroy();
        }
        if (this.eJQ != null) {
            this.eJQ.onDestory();
        }
        this.eJf.setOnLayoutListener(null);
        if (this.eLl != null) {
            this.eLl.aiD();
        }
        if (this.eKO != null) {
            this.eKO.onDestroy();
        }
        aRX();
    }

    public boolean pw(int i) {
        if (this.eIW != null) {
            return this.eIW.jm(i);
        }
        return false;
    }

    public void aCA() {
        this.eJb.om();
        if (this.eIY != null) {
            this.eIY.Zz();
        }
        com.baidu.adp.lib.util.l.a(this.eDC.getPageContext().getPageActivity(), this.eJT);
        aQR();
        if (this.eKj != null) {
            this.eKj.dismiss();
        }
        aRD();
        if (this.eIX != null) {
            this.eIX.aUh();
        }
        if (this.eJR != null) {
            this.eJR.dismiss();
        }
        if (this.crT != null) {
            this.crT.dismiss();
        }
    }

    public void cv(List<String> list) {
        this.eLk = list;
        if (this.eLl != null) {
            this.eLl.setData(list);
        }
    }

    public void iE(boolean z) {
        this.eJQ.iE(z);
    }

    public void hg(boolean z) {
        this.dPf = z;
    }

    public void aRD() {
        if (this.eKa != null) {
            this.eKa.dismiss();
        }
        if (this.eKb != null) {
            com.baidu.adp.lib.g.g.b(this.eKb, this.eDC.getPageContext());
        }
        if (this.eKc != null) {
            com.baidu.adp.lib.g.g.b(this.eKc, this.eDC.getPageContext());
        }
        if (this.eJY != null) {
            com.baidu.adp.lib.g.g.b(this.eJY, this.eDC.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eFO, this.eAb);
            d(this.eFO, this.eAb, this.mType);
            this.eDC.getLayoutMode().ai(i == 1);
            this.eDC.getLayoutMode().t(this.ccT);
            this.eDC.getLayoutMode().t(this.eJj);
            this.eDC.getLayoutMode().t(this.eJk);
            this.eDC.getLayoutMode().t(this.eJh);
            if (this.eJz != null) {
                com.baidu.tbadk.core.util.aj.c(this.eJz, d.e.cp_cont_d, 1);
            }
            if (this.eJy != null) {
                com.baidu.tbadk.core.util.aj.c(this.eJy, d.e.cp_cont_d, 1);
            }
            if (this.eIX != null) {
                this.eIX.onChangeSkinType(i);
            }
            this.eDC.getLayoutMode().t(this.eJh);
            com.baidu.tbadk.core.util.aj.i(this.eJj, d.e.cp_cont_b);
            this.eJj.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eDC.getLayoutMode().t(this.aHV);
            if (this.eJS != null) {
                this.eDC.getLayoutMode().t(this.eJS);
            }
            jx(this.eKl);
            this.eJQ.notifyDataSetChanged();
            if (this.eJU != null) {
                this.eJU.dz(i);
            }
            if (this.cvc != null) {
                this.cvc.dz(i);
                com.baidu.tbadk.core.util.aj.j(this.aHV, d.g.pb_foot_more_trans_selector);
                this.cvc.dw(d.g.pb_foot_more_trans_selector);
            }
            if (this.JG != null) {
                this.JG.onChangeSkinType(i);
            }
            if (this.eJA != null) {
                this.eJA.dE(i);
            }
            if (this.eJV != null) {
                this.eJV.dz(i);
            }
            if (this.eJg != null && this.eJg.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eJg) {
                    aVar.aSI();
                }
            }
            js(i == 1);
            aRe();
            UtilHelper.setStatusBarBackground(this.csg, i);
            UtilHelper.setStatusBarBackground(this.eKI, i);
            if (this.eJC != null) {
                this.eJC.onChangeSkinType(i);
            }
            if (this.eJH != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJH, d.e.cp_cont_j);
            }
            if (this.eJG != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJG, d.e.cp_cont_j);
            }
            if (this.eJI != null) {
                com.baidu.tbadk.core.util.aj.j(this.eJI, d.e.cp_cont_e);
            }
            if (this.eJr != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJr, d.e.cp_link_tip_a);
            }
            if (this.eJF != null) {
                com.baidu.tbadk.core.util.aj.i(this.eJF, d.e.cp_cont_j);
            }
            if (this.eJJ != null) {
                com.baidu.tbadk.n.a.a(this.eDC.getPageContext(), this.eJJ);
            }
            if (this.eKY != null) {
                this.eKY.onChangeSkinType(i);
            }
            if (this.eJb != null) {
                if (this.eIW != null) {
                    this.eIW.pH(i);
                } else {
                    this.eJb.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aj.i(this.eJp, d.e.cp_cont_j);
            if (this.eJq != null) {
                com.baidu.tbadk.core.util.aj.j(this.eJq, d.e.cp_cont_e);
            }
            this.mSkinType = i;
            if (this.eKq != null) {
                com.baidu.tbadk.core.util.aj.i(this.eKq, d.e.cp_cont_e);
            }
            if (this.eJs != null) {
                com.baidu.tbadk.core.util.aj.c(this.eJs, BitmapHelper.getGradeResourceIdInEnterForum(this.eLg));
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSw = fVar;
        this.eJQ.setOnImageClickListener(this.aSw);
    }

    public void h(NoNetworkView.a aVar) {
        this.coJ = aVar;
        if (this.ccR != null) {
            this.ccR.a(this.coJ);
        }
    }

    public void jz(boolean z) {
        this.eJQ.setIsFromCDN(z);
    }

    public Button aRE() {
        return this.eKo;
    }

    public void aRF() {
        if (this.eJa != 2) {
            this.eJf.setNextPage(this.cvc);
            this.eJa = 2;
        }
    }

    public void aRG() {
        if (com.baidu.tbadk.k.r.Gc().Gd()) {
            int lastVisiblePosition = this.eJf.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eJf.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.ft(1001);
                                perfLog.aJd = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wd();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.ft(1001);
                        perfLog2.aJd = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wd();
                    }
                }
            }
        }
    }

    public boolean aRH() {
        return this.JG != null && this.JG.getVisibility() == 0;
    }

    public void hh(boolean z) {
        if (this.eKp != null) {
            if (this.dPf) {
                hi(z);
            } else {
                hj(z);
            }
        }
    }

    public void aRI() {
        if (this.eKp != null) {
            this.eKp.setVisibility(8);
            this.eKu = false;
            if (this.eKO != null) {
                this.eKO.setVisibility(8);
                jv(false);
            }
            aRX();
        }
    }

    public void showLoadingDialog() {
        if (this.bra == null) {
            this.bra = new com.baidu.tbadk.core.view.a(this.eDC.getPageContext());
        }
        this.bra.aH(true);
    }

    public void Sv() {
        if (this.bra != null) {
            this.bra.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eJf.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eJf.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eIW != null) {
            this.eIW.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.efG = getScrollY();
            this.eKN.eLT = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKN));
            a(this.eKN.eLT, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.eIW != null) {
            this.eIW.b(absListView, i);
        }
        int headerViewsCount = (i - this.eJf.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.eJQ.pg(headerViewsCount) != com.baidu.tieba.pb.data.l.ezh) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eJQ.aPl().jp(z);
        this.eKN.eLR = i;
        this.eKN.eLS = this.eJf.getHeaderViewsCount();
        this.eKN.eLT = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eKN));
        a(this.eKN.eLT, false);
    }

    public void aRJ() {
        if (this.eDC.isLogin()) {
            if ((this.eKZ == null || !this.eKZ.aQM()) && this.eFO != null && this.eLd && !this.eLc && !this.eKm && this.eKy != null && this.eKy.getAuthor() != null && !this.eKy.getAuthor().getIsLike() && !this.eKy.getAuthor().hadConcerned()) {
                if (this.eKZ == null) {
                    this.eKZ = new ai(this.eDC);
                }
                this.eKZ.a(this.eJb.ePX, this.eFO.aNz(), this.eKy.getAuthor().getUserId(), this.eFO.getThreadId());
            }
        }
    }

    public void aRK() {
        if (this.eLd && !this.eLc && this.eKy != null && this.eKy.getAuthor() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eDC.getPageContext().getPageActivity(), this.eKy.getAuthor().getUserId(), this.eKy.getAuthor().getUserName(), this.eDC.aOi().aPw(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ag agVar, boolean z) {
        int measuredHeight;
        if (!this.eLc && this.eKH != null && this.eJb.aSL() != null) {
            int aPj = this.eJQ.aPj();
            if (aPj > 0 && (agVar == null || agVar.getView().getParent() == null)) {
                if (aPj > this.eJf.getFirstVisiblePosition() - this.eJf.getHeaderViewsCount()) {
                    this.eKH.setVisibility(8);
                } else {
                    this.eKH.setVisibility(0);
                }
            } else if (agVar != null && agVar.getView() != null && agVar.eIA != null) {
                int top = agVar.getView().getTop();
                if (agVar.getView().getParent() != null) {
                    if (this.eKM) {
                        this.eKL = top;
                        this.eKM = false;
                    }
                    this.eKL = top < this.eKL ? top : this.eKL;
                }
                if (top != 0 || agVar.getView().isShown()) {
                    if (this.eJP.getY() < 0.0f) {
                        measuredHeight = eKK - agVar.eIA.getMeasuredHeight();
                    } else {
                        measuredHeight = this.eJb.aSL().getMeasuredHeight() - agVar.eIA.getMeasuredHeight();
                    }
                    if (agVar.getView().getParent() == null && top <= this.eKL) {
                        this.eKH.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.eKH.setVisibility(0);
                    } else {
                        this.eKH.setVisibility(8);
                    }
                    if (z) {
                        this.eKM = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eLR;
        public int eLS;
        public ag eLT;

        public a() {
        }
    }

    public void aRL() {
        if (!this.eLD) {
            TiebaStatic.log("c10490");
            this.eLD = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eDC.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eKR, Integer.valueOf(eKT));
            aVar.cc(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eDC);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eDC.getPageContext()).ti();
        }
    }

    public void oW(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eDC.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eKR, Integer.valueOf(eKU));
        aVar.z(sparseArray);
        aVar.a(d.l.view, this.eDC);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eDC.getPageContext()).ti();
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

    public PbInterviewStatusView aRM() {
        return this.eKD;
    }

    private void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aNb() != null && fVar.aNb().sn() && this.eKD == null) {
            this.eKD = (PbInterviewStatusView) this.eKC.inflate();
            this.eKD.setOnClickListener(this.crU);
            this.eKD.setCallback(this.eDC.aOO());
            this.eKD.c(this.eDC, fVar);
        }
    }

    public LinearLayout aRN() {
        return this.eJP;
    }

    public View aRO() {
        return this.csg;
    }

    public boolean aRP() {
        return this.eLo;
    }

    public void iJ(boolean z) {
        this.eJl.iJ(z);
    }

    private void aRQ() {
        if (this.eLo) {
            if (this.eLp == null) {
                c.a aVar = c.eBh.get();
                if (aVar != null) {
                    this.eLp = aVar.a(this.eDC);
                    ListAdapter adapter = this.eJf.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.awZ) {
                            this.eJf.addHeaderView(this.eLp.aNZ(), 1);
                        } else {
                            this.eJf.addHeaderView(this.eLp.aNZ(), 0);
                        }
                    }
                } else {
                    this.eJk.setVisibility(0);
                    return;
                }
            }
            this.eJk.setVisibility(8);
            this.eJf.removeHeaderView(this.eJk);
            return;
        }
        this.eJk.setVisibility(0);
    }

    public void jA(boolean z) {
        this.eLo = z;
    }

    public void aRR() {
        this.eDC.showNetRefreshView(getView(), "");
        View Et = this.eDC.getRefreshView().Et();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Et.getLayoutParams();
        layoutParams.addRule(3, aRN().getId());
        Et.setLayoutParams(layoutParams);
        this.eDC.hideLoadingView(getView());
        if (this.eLp != null) {
            this.eJf.removeHeaderView(this.eLp.aNZ());
            this.eLp = null;
        }
    }

    public void oX(String str) {
        if (this.eJc != null) {
            this.eJc.setTitle(str);
        }
    }

    private int jB(boolean z) {
        if (this.eKD == null || this.eKD.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aRS() {
        if (this.eKD != null && this.eKD.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKD.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eKD.setLayoutParams(layoutParams);
        }
    }

    public boolean aOj() {
        return false;
    }

    public TextView aRT() {
        return this.eJz;
    }

    public void oY(String str) {
        this.eKq.performClick();
        if (!StringUtils.isNull(str) && this.eDC.aOc() != null && this.eDC.aOc().CZ() != null && this.eDC.aOc().CZ().CS() != null) {
            EditText CS = this.eDC.aOc().CZ().CS();
            CS.setText(str);
            CS.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aCA();
            aRI();
            aQR();
            if (this.eKY != null) {
                this.eKY.aPq();
            }
            this.eDC.ahi();
            this.eJP.setVisibility(8);
            this.eJb.setTitleVisibility(false);
            this.eDC.iP(false);
            if (this.eIW != null) {
                if (configuration.orientation == 1) {
                    aRN().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eJf.setIsLandscape(true);
                    this.eJf.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eJf.setIsLandscape(false);
                    if (this.efG > 0) {
                        this.eJf.smoothScrollBy(this.efG, 0);
                    }
                }
                this.eIW.onConfigurationChanged(configuration);
            }
        }
    }

    public void jC(boolean z) {
        this.eIZ = z;
    }

    public boolean aRU() {
        return this.eIW != null && this.eIW.aRU();
    }

    public void aRV() {
        if (this.eIW != null) {
            this.eIW.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eIX != null) {
            this.eIX.w(j, i);
        }
        if (this.eIW != null) {
            this.eIW.w(j, i);
        }
    }

    public void iV(boolean z) {
        this.eJQ.iV(z);
    }

    public void aRW() {
        if (this.eKE == null) {
            LayoutInflater.from(this.eDC.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.ccT, true);
            this.eKE = (ViewGroup) this.ccT.findViewById(d.h.add_experienced_layout);
            this.eKF = (TextView) this.ccT.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.eKF, d.e.cp_cont_i);
            String string = this.eDC.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eDC.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_h)));
            this.eKF.setText(spannableString);
        }
        this.eKE.setVisibility(0);
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
                        an.this.eKE.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                an.this.eKF.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eKF.startAnimation(scaleAnimation);
    }

    public void bl(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.eKp.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eDC);
            frameLayout.setBackgroundResource(d.g.pic_sign_tip);
            TextView textView = new TextView(this.eDC);
            textView.setText(d.l.connection_tips);
            textView.setGravity(17);
            textView.setPadding(com.baidu.adp.lib.util.l.f(this.eDC, d.f.ds24), 0, com.baidu.adp.lib.util.l.f(this.eDC, d.f.ds24), 0);
            com.baidu.tbadk.core.util.aj.i(textView, d.e.cp_cont_n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eDC, d.f.ds60);
            frameLayout.addView(textView, layoutParams);
            this.eLi = new PopupWindow(this.eDC);
            this.eLi.setContentView(frameLayout);
            this.eLi.setHeight(-2);
            this.eLi.setWidth(-2);
            this.eLi.setFocusable(true);
            this.eLi.setOutsideTouchable(false);
            this.eLi.setBackgroundDrawable(new ColorDrawable(this.eDC.getResources().getColor(d.e.transparent)));
            this.eJf.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.32
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.eLj = true;
                        an.this.eLi.showAsDropDown(an.this.eKp, view.getLeft(), -an.this.eKp.getHeight());
                        return;
                    }
                    an.this.eLi.showAsDropDown(view);
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aSi() != null && !StringUtils.isNull(aVar.aSi().pkg_id) && !StringUtils.isNull(aVar.aSi().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.eKr != null && this.eKr.getVisibility() == 0) {
            if (this.eLh == null) {
                View inflate = LayoutInflater.from(this.eDC.getPageContext().getPageActivity()).inflate(d.j.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.h.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.h.single_bar_tips);
                textView.setText(d.l.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.crU);
                this.eLh = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.eKr.getLocationInWindow(iArr);
            this.eLh.showAtLocation(this.eKr, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds54), (iArr[1] - this.eKr.getHeight()) - com.baidu.adp.lib.util.l.f(this.eDC.getPageContext().getPageActivity(), d.f.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aRX() {
        com.baidu.adp.lib.g.g.a(this.eLh);
    }
}
