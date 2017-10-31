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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.pb.pb.main.e;
import com.baidu.tieba.pb.pb.main.emotion.view.c;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class ap {
    private static final int eTk = UtilHelper.getLightStatusBarHeight();
    public static int eTq = 3;
    public static int eTr = 0;
    public static int eTs = 3;
    public static int eTt = 4;
    public static int eTu = 5;
    public static int eTv = 6;
    private com.baidu.tbadk.editortools.i Jb;
    private View aIs;
    private com.baidu.tieba.pb.a.c aSw;
    private g.b amz;
    private TextView axk;
    private View bYj;
    private PbListView cCw;
    private NoNetworkView ckb;
    private RelativeLayout ckd;
    private View.OnClickListener czc;
    private View czo;
    private View.OnClickListener eHU;
    PbActivity.d eLr;
    private PbActivity eMh;
    private PbFakeFloorModel eNI;
    private UserIconBox eNl;
    private UserIconBox eNm;
    private com.baidu.tieba.pb.data.f eOk;
    public final com.baidu.tieba.pb.pb.main.view.c eRA;
    public com.baidu.tieba.pb.pb.main.view.b eRB;
    private ViewStub eRC;
    private ViewStub eRD;
    private PbLandscapeListView eRE;
    private List<com.baidu.tieba.pb.pb.main.view.a> eRF;
    private View eRG;
    private LinearLayout eRJ;
    private f eRK;
    private ColumnLayout eRL;
    private ThreadSkinView eRM;
    private TextView eRN;
    private TextView eRO;
    private View eRP;
    private TextView eRQ;
    private ImageView eRR;
    private HeadPendantView eRS;
    private FrameLayout eRT;
    private HeadImageView eRU;
    private View eRV;
    private FloatingLayout eRW;
    public int eRu;
    private com.baidu.tieba.pb.video.i eRv;
    private com.baidu.tieba.pb.video.h eRw;
    private com.baidu.tieba.d.a eRx;
    private View eSP;
    private TextView eSQ;
    private ImageView eSR;
    private ImageView eSS;
    private TextView eST;
    private boolean eSV;
    private int eSW;
    private int eSX;
    private PostData eSY;
    private PbFirstFloorUserLikeButton eSb;
    private an eSc;
    private an eSd;
    private TextView eSe;
    private TextView eSf;
    private TextView eSg;
    private View eSh;
    private LinearLayout eSi;
    private TextView eSj;
    private TextView eSk;
    private View eSl;
    private View eSm;
    private ObservedChangeLinearLayout eSo;
    private h eSp;
    private View eSv;
    private int eTF;
    private PopupWindow eTH;
    private PopupWindow eTI;
    private List<String> eTJ;
    private com.baidu.tieba.pb.pb.main.emotion.c eTK;
    private com.baidu.tieba.pb.pb.godreply.a eTL;
    private PbLandscapeListView.b eTM;
    private boolean eTP;
    private e eTQ;
    private com.baidu.tbadk.core.view.userLike.c eTR;
    private com.baidu.tbadk.core.view.userLike.c eTS;
    private Runnable eTX;
    private PbActivity.b eTZ;
    private View eTa;
    private TextView eTb;
    private ViewStub eTc;
    private PbInterviewStatusView eTd;
    private ViewGroup eTe;
    private TextView eTf;
    private FrameLayout eTg;
    private View eTh;
    private View eTi;
    private ai eTj;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eTo;
    private int eTw;
    private Runnable eTx;
    private s eTy;
    private ak eTz;
    private int emZ;
    private boolean isLandscape;
    private int mType;
    private boolean eRy = false;
    private int eRz = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout eRH = null;
    private TextView eRI = null;
    private TextView eRX = null;
    private TextView eRY = null;
    public FrsPraiseView eRZ = null;
    private ClickableHeaderImageView eSa = null;
    private View eSn = null;
    private com.baidu.tbadk.core.dialog.a eSq = null;
    private com.baidu.tbadk.core.dialog.b czb = null;
    private View eSr = null;
    private EditText eSs = null;
    private com.baidu.tieba.pb.view.i eSt = null;
    private com.baidu.tieba.pb.view.b eSu = null;
    private com.baidu.tbadk.core.dialog.a eSw = null;
    private b.InterfaceC0047b dFi = null;
    private TbRichTextView.f aSv = null;
    private NoNetworkView.a cvR = null;
    private Dialog eSx = null;
    private View eSy = null;
    private com.baidu.tbadk.core.dialog.a eSz = null;
    private Dialog eSA = null;
    private Dialog eSB = null;
    private View eSC = null;
    private LinearLayout eSD = null;
    private CompoundButton.OnCheckedChangeListener eSE = null;
    private TextView eSF = null;
    private TextView eSG = null;
    private View eSH = null;
    private String eSI = null;
    private com.baidu.tbadk.core.dialog.b eSJ = null;
    private com.baidu.tbadk.core.dialog.b eSK = null;
    private boolean eSL = false;
    private boolean eSM = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eSN = null;
    private boolean dWE = false;
    private Button eSO = null;
    private boolean eSU = true;
    private com.baidu.tbadk.core.view.a cbh = null;
    private boolean eHQ = false;
    private int mSkinType = 3;
    private boolean eSZ = false;
    private int eTl = 0;
    private boolean eTm = true;
    private a eTn = new a();
    private int eTp = 0;
    private boolean eTA = false;
    private int eTB = 0;
    private boolean eTC = false;
    private boolean eTD = false;
    private boolean eTE = false;
    private int eTG = 0;
    private boolean eTN = false;
    private a.InterfaceC0124a eTO = new a.InterfaceC0124a() { // from class: com.baidu.tieba.pb.pb.main.ap.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0124a
        public void kW() {
        }
    };
    private final CustomMessageListener eTT = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_IMG_TO_EMOTION_CONNECTION_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.ap.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921305) {
                ap.this.aUb();
            }
        }
    };
    private String eTU = null;
    private CustomMessageListener eTV = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.eTU = null;
            }
        }
    };
    private CustomMessageListener dRz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.eSp != null) {
                ap.this.eSp.notifyDataSetChanged();
            }
        }
    };
    private Handler eTW = new Handler();
    private CustomMessageListener eTY = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.eSU = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eUa = true;
    View.OnClickListener eUb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ap.this.eTC) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == ap.this.eRA.eYz) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (ap.this.eMh.eKt.eXH != null) {
                if (!ap.this.eTC && ap.this.eOk != null && ap.this.eOk.aPO() != null && ap.this.eOk.aPO().rt() != null && ap.this.eOk.aPO().rt().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                ap.this.eMh.eKt.eXH.onClick(view);
            }
        }
    };
    private boolean eUc = false;
    String userId = null;
    private final List<TbImageView> eUd = new ArrayList();
    private boolean eUe = false;

    public void ji(boolean z) {
        this.eTA = z;
        if (this.eRE != null) {
            this.eTB = this.eRE.getHeaderViewsCount();
        }
    }

    public void aTQ() {
        if (this.eRE != null) {
            int headerViewsCount = this.eRE.getHeaderViewsCount() - this.eTB;
            final int firstVisiblePosition = (this.eRE.getFirstVisiblePosition() == 0 || this.eRE.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.eRE.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.eRE.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.eTn.eUu = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTn));
            final ai aiVar = this.eTn.eUu;
            final int d = d(aiVar);
            final int y = ((int) this.eSo.getY()) + this.eSo.getMeasuredHeight();
            final boolean z = this.eTh.getVisibility() == 0;
            boolean z2 = this.eSo.getY() < 0.0f;
            if ((z && aiVar != null) || firstVisiblePosition >= this.eSp.aSj() + this.eRE.getHeaderViewsCount()) {
                int measuredHeight = aiVar != null ? aiVar.eQX.getMeasuredHeight() : 0;
                if (z2) {
                    this.eRE.setSelectionFromTop(this.eSp.aSj() + this.eRE.getHeaderViewsCount(), eTk - measuredHeight);
                } else {
                    this.eRE.setSelectionFromTop(this.eSp.aSj() + this.eRE.getHeaderViewsCount(), this.eRA.aVU().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.eRE.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.eTC) {
                this.eRE.setSelectionFromTop(this.eSp.aSj() + this.eRE.getHeaderViewsCount(), this.eRv.aXl().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.eRE.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aSv() {
                        if (d >= 0 && d <= ap.this.ckd.getMeasuredHeight()) {
                            int d2 = ap.this.d(aiVar);
                            int i = d2 - d;
                            if (z && i != 0 && d <= y) {
                                i = d2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ap.this.bYj.getLayoutParams();
                            if (i == 0 || i > ap.this.ckd.getMeasuredHeight() || d2 >= ap.this.ckd.getMeasuredHeight()) {
                                layoutParams.height = ap.this.eTw;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.ckd.getMeasuredHeight()) {
                                layoutParams.height = ap.this.eTw;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ap.this.eRE.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ap.this.bYj.setLayoutParams(layoutParams);
                        }
                        ap.this.eRE.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(ai aiVar) {
        if (aiVar == null || aiVar.getView() == null) {
            return 0;
        }
        if (aiVar.getView().getTop() != 0 || aiVar.getView().isShown()) {
            return aiVar.getView().getBottom();
        }
        return 0;
    }

    public e aTR() {
        return this.eTQ;
    }

    public NoNetworkView aTS() {
        return this.ckb;
    }

    public void aTT() {
        if (this.Jb != null) {
            this.Jb.hide();
            if (this.eTK != null) {
                this.eTK.aft();
            }
        }
    }

    public PbFakeFloorModel aTU() {
        return this.eNI;
    }

    public s aTV() {
        return this.eTy;
    }

    public void aTW() {
        reset();
        aTT();
        this.eTy.aSr();
        hc(false);
    }

    private void reset() {
        if (this.eMh != null && this.eMh.aRf() != null && this.Jb != null) {
            com.baidu.tbadk.editortools.pb.a.Dd().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aRf = this.eMh.aRf();
            aRf.Dy();
            if (aRf.getWriteImagesInfo() != null) {
                aRf.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aRf.eY(10);
            aRf.eW(SendView.ALL);
            aRf.eX(SendView.ALL);
            com.baidu.tbadk.editortools.l eN = this.Jb.eN(23);
            com.baidu.tbadk.editortools.l eN2 = this.Jb.eN(2);
            com.baidu.tbadk.editortools.l eN3 = this.Jb.eN(5);
            if (eN2 != null) {
                eN2.lG();
            }
            if (eN3 != null) {
                eN3.lG();
            }
            if (eN != null) {
                eN.hide();
            }
            this.Jb.invalidate();
        }
    }

    public boolean aTX() {
        return this.eSU;
    }

    public void hd(boolean z) {
        if (this.eSP != null && this.eSQ != null) {
            this.eSQ.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eSP.startAnimation(alphaAnimation);
            }
            this.eSP.setVisibility(0);
            this.eSU = true;
            if (this.eTo != null && !this.eTL.isActive()) {
                this.eTo.setVisibility(0);
                jm(true);
            }
        }
    }

    public void he(boolean z) {
        if (this.eSP != null && this.eSQ != null) {
            this.eSQ.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eSP.startAnimation(alphaAnimation);
            }
            this.eSP.setVisibility(0);
            this.eSU = true;
            if (this.eTo != null && !this.eTL.isActive()) {
                this.eTo.setVisibility(0);
                jm(true);
            }
        }
    }

    public PostData aTY() {
        int i = 0;
        if (this.eRE == null) {
            return null;
        }
        int aTZ = aTZ() - this.eRE.getHeaderViewsCount();
        if (aTZ < 0) {
            aTZ = 0;
        }
        if (this.eSp.pA(aTZ) != null && this.eSp.pA(aTZ) != PostData.gpj) {
            i = aTZ + 1;
        }
        return this.eSp.getItem(i) instanceof PostData ? (PostData) this.eSp.getItem(i) : null;
    }

    public int aTZ() {
        int i;
        View childAt;
        if (this.eRE == null) {
            return 0;
        }
        int firstVisiblePosition = this.eRE.getFirstVisiblePosition();
        int lastVisiblePosition = this.eRE.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eRE.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.eRE.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aUa() {
        return this.eRE.getHeaderViewsCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUb() {
        if (this.eSw == null) {
            this.eSw = new com.baidu.tbadk.core.dialog.a(this.eMh);
            this.eSw.cc(d.j.img_to_emotion_tip);
            this.eSw.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.33
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.editortools.pb.d aRf = ap.this.eMh.aRf();
                    if (aRf.getWriteImagesInfo() != null) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) ap.this.eMh, aRf.getWriteImagesInfo().toJsonString(), true, true);
                        albumActivityConfig.getIntent().putExtra("from", "pb");
                        if (!StringUtils.isNull(ap.this.mForumId, true)) {
                            albumActivityConfig.getIntent().putExtra("forum_id", ap.this.mForumId);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        aVar.dismiss();
                    }
                }
            });
            this.eSw.a(d.j.go_to_add, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.34
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ap.this.eMh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(ap.this.eMh.getPageContext().getPageActivity())));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL));
                    if (ap.this.eMh.checkUpIsLogin()) {
                        if (ap.this.Jb != null) {
                            ap.this.aUl();
                            ap.this.Jb.L((View) ap.this.Jb.eN(5));
                        }
                        if (ap.this.Jb != null) {
                            ap.this.eSU = false;
                            com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMh, (View) ap.this.Jb.eP(2).aBf, false, ap.this.eTO);
                        }
                        ap.this.aUM();
                        aVar.dismiss();
                    }
                }
            });
            this.eSw.b(this.eMh.getPageContext());
        }
        this.eSw.th();
    }

    public void e(TbRichText tbRichText) {
        PostData postData;
        if (this.eOk != null && this.eOk.aPQ() != null && !this.eOk.aPQ().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.eOk.aPQ().size() && (postData = this.eOk.aPQ().get(i)) != null && postData.rt() != null && !StringUtils.isNull(postData.rt().getUserId()); i++) {
                if (this.eOk.aPQ().get(i).rt().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.eTL != null && this.eTL.isActive()) {
                        hc(false);
                    }
                    if (this.eTo != null) {
                        this.eTo.jy(true);
                    }
                    this.eTU = postData.rt().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eMh = null;
        this.ckd = null;
        this.czo = null;
        this.eRE = null;
        this.eRG = null;
        this.eRJ = null;
        this.eRL = null;
        this.eRN = null;
        this.eRP = null;
        this.eRQ = null;
        this.eRT = null;
        this.eRU = null;
        this.eRV = null;
        this.eSb = null;
        this.eSe = null;
        this.eSf = null;
        this.eSg = null;
        this.eSh = null;
        this.eSl = null;
        this.eSm = null;
        this.eSp = null;
        this.cCw = null;
        this.aIs = null;
        this.czc = null;
        this.eHU = null;
        this.eSP = null;
        this.eSQ = null;
        this.eSR = null;
        this.eSS = null;
        this.eST = null;
        this.eTa = null;
        this.eTb = null;
        this.eTc = null;
        this.eTF = 0;
        this.eMh = pbActivity;
        this.czc = onClickListener;
        this.aSw = cVar;
        this.eTF = com.baidu.adp.lib.util.l.ac(this.eMh) - com.baidu.adp.lib.util.l.f(this.eMh, d.e.ds200);
        this.ckd = (RelativeLayout) LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.eMh.addContentView(this.ckd, new FrameLayout.LayoutParams(-1, -1));
        this.czo = this.eMh.findViewById(d.g.statebar_view);
        this.eSo = (ObservedChangeLinearLayout) this.eMh.findViewById(d.g.title_wrapper);
        this.ckb = (NoNetworkView) this.eMh.findViewById(d.g.view_no_network);
        this.eRE = (PbLandscapeListView) this.eMh.findViewById(d.g.new_pb_list);
        this.eTg = (FrameLayout) this.eMh.findViewById(d.g.root_float_header);
        this.axk = new TextView(this.eMh.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds88));
        this.eRE.addHeaderView(this.axk, 0);
        this.eTw = this.eMh.getResources().getDimensionPixelSize(d.e.ds100);
        this.bYj = new View(this.eMh.getPageContext().getPageActivity());
        this.bYj.setLayoutParams(new AbsListView.LayoutParams(-1, this.eTw));
        this.bYj.setVisibility(4);
        this.eRE.addFooterView(this.bYj);
        this.eRE.setOnTouchListener(this.eMh.aMA);
        this.eRA = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eMh.aRH()) {
            this.eRC = (ViewStub) this.eMh.findViewById(d.g.manga_view_stub);
            this.eRC.setVisibility(0);
            this.eRB = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.eRB.show();
            this.eRA.mNavigationBar.setVisibility(8);
            layoutParams.height -= eTk;
        }
        this.axk.setLayoutParams(layoutParams);
        this.eRA.aVU().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.main.ap.36
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0109a
            public void ajX() {
                if (ap.this.eRE != null) {
                    if (ap.this.eRv != null) {
                        ap.this.eRv.aXm();
                    }
                    ap.this.eRE.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0109a
            public void ajW() {
                ap.this.eMh.ajl();
            }
        }));
        this.eSP = this.eMh.findViewById(d.g.pb_editor_tool_comment);
        this.eSW = com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds90);
        this.eSX = com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds242);
        this.eSQ = (TextView) this.eMh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.eSS = (ImageView) this.eMh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.eSR = (ImageView) this.eMh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.eST = (TextView) this.eMh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.eST.setVisibility(8);
        this.eSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.aVb();
                if (!ap.this.eMh.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, ap.this.mForumId));
                    return;
                }
                if (ap.this.Jb != null) {
                    ap.this.aUl();
                }
                if (ap.this.Jb != null) {
                    ap.this.eSU = false;
                    com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMh, (View) ap.this.Jb.eP(2).aBf, false, ap.this.eTO);
                }
                ap.this.aUM();
            }
        });
        this.eSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.aVb();
                if (ap.this.eMh.checkUpIsLogin()) {
                    if (ap.this.Jb != null) {
                        ap.this.aUl();
                        ap.this.Jb.L((View) ap.this.Jb.eN(5));
                    }
                    if (ap.this.Jb != null) {
                        ap.this.eSU = false;
                        com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMh, (View) ap.this.Jb.eP(2).aBf, false, ap.this.eTO);
                    }
                    ap.this.aUM();
                }
            }
        });
        this.eSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.aVb();
                if (ap.this.eMh.checkUpIsLogin()) {
                    if (ap.this.Jb != null) {
                        ap.this.aUl();
                        ap.this.Jb.L((View) ap.this.Jb.eN(2));
                    }
                    if (ap.this.Jb != null) {
                        ap.this.eSU = false;
                        com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMh, (View) ap.this.Jb.eP(2).aBf, false, ap.this.eTO);
                    }
                    ap.this.aUM();
                }
            }
        });
        this.eST.setOnClickListener(this.czc);
        this.eST.setOnTouchListener(this.eMh);
        this.eRG = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.eRJ = (LinearLayout) LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.eRK = new f(this.eMh, this.eRJ);
        this.eRK.init();
        this.eRK.a(this.eRK.aRe(), this.czc);
        this.eRL = (ColumnLayout) this.eRJ.findViewById(d.g.pb_head_owner_root);
        this.eRM = (ThreadSkinView) this.eRJ.findViewById(d.g.pb_thread_skin);
        this.eRL.setOnLongClickListener(this.onLongClickListener);
        this.eRL.setOnTouchListener(this.aSw);
        this.eRL.setVisibility(8);
        this.eRG.setOnTouchListener(this.aSw);
        this.eTa = this.eRG.findViewById(d.g.pb_head_activity_join_number_container);
        this.eTa.setVisibility(8);
        this.eTb = (TextView) this.eRG.findViewById(d.g.pb_head_activity_join_number);
        this.eRN = (TextView) this.eRL.findViewById(d.g.pb_head_owner_info_user_name);
        this.eRO = (TextView) this.eRJ.findViewById(d.g.pb_head_owner_info_user_intro);
        this.eRP = this.eRJ.findViewById(d.g.line_right_user_intro);
        this.eRQ = (TextView) this.eRL.findViewById(d.g.floor_owner);
        this.eRR = (ImageView) this.eRL.findViewById(d.g.icon_forum_level);
        this.eRT = (FrameLayout) this.eRL.findViewById(d.g.pb_head_headImage_container);
        this.eRU = (HeadImageView) this.eRL.findViewById(d.g.pb_head_owner_photo);
        this.eRS = (HeadPendantView) this.eRL.findViewById(d.g.pb_pendant_head_owner_photo);
        this.eRS.wg();
        if (this.eRS.getHeadView() != null) {
            this.eRS.getHeadView().setIsRound(true);
            this.eRS.getHeadView().setDrawBorder(false);
        }
        if (this.eRS.getPendantView() != null) {
            this.eRS.getPendantView().setIsRound(true);
            this.eRS.getPendantView().setDrawBorder(false);
        }
        this.eNl = (UserIconBox) this.eRL.findViewById(d.g.show_icon_vip);
        this.eNm = (UserIconBox) this.eRL.findViewById(d.g.show_icon_yinji);
        this.eRW = (FloatingLayout) this.eRJ.findViewById(d.g.pb_head_owner_info_root);
        this.eSb = (PbFirstFloorUserLikeButton) this.eRL.findViewById(d.g.pb_like_button);
        this.eSe = (TextView) this.eRL.findViewById(d.g.pb_views);
        this.eSf = (TextView) this.eRL.findViewById(d.g.pb_item_first_floor_reply_time);
        this.eSg = (TextView) this.eRL.findViewById(d.g.pb_item_first_floor_location_address);
        this.eSh = this.eRL.findViewById(d.g.line_between_time_and_locate);
        this.eTR = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eTS = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eSl = this.eRG.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.eSm = this.eRG.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.eRG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.eTc = (ViewStub) this.ckd.findViewById(d.g.interview_status_stub);
        this.eSp = new h(this.eMh, this.eRE);
        this.eSp.q(this.czc);
        this.eSp.setTbGestureDetector(this.aSw);
        this.eSp.setOnImageClickListener(this.aSv);
        this.eHU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.Zt() || !com.baidu.tieba.c.a.a(ap.this.eMh.getBaseContext(), ap.this.eMh.aQS().aSz(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ap.this.eMh.c(sparseArray);
                                return;
                            }
                            ap.this.bn(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ap.this.eMh.c(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eSp.D(this.eHU);
        aUg();
        this.eRE.addHeaderView(this.eRH);
        this.eRE.addHeaderView(this.eRJ);
        this.eRE.addHeaderView(this.eRG);
        this.cCw = new PbListView(this.eMh.getPageContext().getPageActivity());
        this.aIs = this.cCw.getView().findViewById(d.g.pb_more_view);
        if (this.aIs != null) {
            this.aIs.setOnClickListener(this.czc);
            com.baidu.tbadk.core.util.aj.j(this.aIs, d.f.pb_foot_more_trans_selector);
        }
        this.cCw.wp();
        this.cCw.dw(d.f.pb_foot_more_trans_selector);
        this.cCw.dy(d.f.pb_foot_more_trans_selector);
        this.eSv = this.eMh.findViewById(d.g.viewstub_progress);
        this.eMh.registerListener(this.eTY);
        this.eRV = com.baidu.tbadk.ala.b.nu().g(this.eMh.getActivity(), 2);
        if (this.eRV != null) {
            this.eRV.setVisibility(8);
            this.eRW.addView(this.eRV);
        }
        this.eNI = new PbFakeFloorModel(this.eMh.getPageContext());
        this.eTy = new s(this.eMh.getPageContext(), this.eNI, this.ckd);
        this.eTy.a(this.eMh.eLm);
        this.eNI.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ap.this.eNI.m(postData);
                ap.this.eSp.notifyDataSetChanged();
                ap.this.eTy.aSr();
                ap.this.Jb.AQ();
                ap.this.hc(false);
            }
        });
        if (this.eMh.aQS() != null && !StringUtils.isNull(this.eMh.aQS().aTe())) {
            this.eMh.showToast(this.eMh.aQS().aTe());
        }
        this.eTh = this.eMh.findViewById(d.g.pb_expand_blank_view);
        this.eTi = this.eMh.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eTi.getLayoutParams();
        if (this.eMh.aQS() != null && this.eMh.aQS().aSC()) {
            this.eTh.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.eTi.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = eTk;
            this.eTi.setLayoutParams(layoutParams2);
        }
        this.eTj = new ai(this.eMh.getPageContext(), this.eMh.findViewById(d.g.pb_reply_expand_view));
        this.eTj.eQX.setVisibility(8);
        this.eTj.E(this.czc);
        this.eMh.registerListener(this.dRz);
        this.eMh.registerListener(this.eTT);
        this.eMh.registerListener(this.eTV);
        aUc();
        jm(false);
    }

    private void aUc() {
        this.eTL = new com.baidu.tieba.pb.pb.godreply.a(this.eMh, this, (ViewStub) this.ckd.findViewById(d.g.more_god_reply_popup));
        this.eTL.setCommonClickListener(this.czc);
        this.eTL.D(this.eHU);
        this.eTL.setOnImageClickListener(this.aSv);
        this.eTL.setCommonClickListener(this.czc);
        this.eTL.setTbGestureDetector(this.aSw);
    }

    public com.baidu.tieba.pb.pb.godreply.a aUd() {
        return this.eTL;
    }

    public View aUe() {
        return this.eTh;
    }

    public void aUf() {
        if (this.eRE != null) {
            this.eRE.removeHeaderView(this.eRH);
            this.eRE.removeHeaderView(this.eRJ);
            this.eRE.removeHeaderView(this.eRG);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eTo == null) {
            this.eTo = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eMh.getPageContext().getPageActivity());
            jm(true);
            this.eTo.a(this.ckd, aVar, this.eSP.getVisibility() == 0);
            this.eTo.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ap.6
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ap.this.eTU)) {
                        emotionImageData.setAuthorNameShow(ap.this.eTU);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    ap.this.eMh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(ap.this.eMh.getPageContext().getPageActivity(), 25016, str, list, ap.this.eTU, list2)));
                }
            });
            this.eTo.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.ap.7
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void onMove(float f) {
                    ap.this.aVb();
                    if (ap.this.eSP != null) {
                        ViewGroup.LayoutParams layoutParams = ap.this.eSP.getLayoutParams();
                        layoutParams.height = (int) (((ap.this.eSX - ap.this.eSW) * f) + ap.this.eSW);
                        ap.this.eSQ.setAlpha(1.0f - f);
                        ap.this.eSS.setAlpha(1.0f - f);
                        ap.this.eSR.setAlpha(1.0f - f);
                        ap.this.eSP.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aUg() {
        if (this.eRH == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds34);
            this.eRH = new LinearLayout(this.eMh.getPageContext().getPageActivity());
            this.eRH.setOrientation(1);
            this.eRH.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eRH.setPadding(f, com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds40), f, com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds46));
            this.eRH.setGravity(17);
            this.eRI = new TextView(this.eMh.getPageContext().getPageActivity());
            this.eRI.setGravity(3);
            this.eRI.setMaxLines(2);
            this.eRI.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            this.eRI.setPadding(0, 0, 0, 0);
            this.eRI.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds12), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.eRI, d.C0080d.cp_cont_b);
            this.eRI.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds48));
            this.eRI.setVisibility(8);
            this.eRH.addView(this.eRI);
            this.eRH.setOnTouchListener(this.aSw);
            this.eRH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        if (this.eMh.aRH()) {
            this.eRD = (ViewStub) this.eMh.findViewById(d.g.manga_mention_controller_view_stub);
            this.eRD.setVisibility(0);
            if (this.eSi == null) {
                this.eSi = (LinearLayout) this.eMh.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eMh.getPageContext(), this.eSi);
            }
            if (this.eSj == null) {
                this.eSj = (TextView) this.eSi.findViewById(d.g.manga_prev_btn);
            }
            if (this.eSk == null) {
                this.eSk = (TextView) this.eSi.findViewById(d.g.manga_next_btn);
            }
            this.eSj.setOnClickListener(this.czc);
            this.eSk.setOnClickListener(this.czc);
        }
    }

    private void aUi() {
        if (this.eMh.aRH()) {
            if (this.eMh.aRK() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eSj, d.C0080d.cp_cont_e, 1);
            }
            if (this.eMh.aRL() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eSk, d.C0080d.cp_cont_e, 1);
            }
        }
    }

    public void aUj() {
        if (this.eSi == null) {
            aUh();
        }
        this.eRD.setVisibility(8);
        if (this.eTW != null && this.eTX != null) {
            this.eTW.removeCallbacks(this.eTX);
        }
    }

    public void aUk() {
        if (this.eTW != null) {
            if (this.eTX != null) {
                this.eTW.removeCallbacks(this.eTX);
            }
            this.eTX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.eSi == null) {
                        ap.this.aUh();
                    }
                    ap.this.eRD.setVisibility(0);
                }
            };
            this.eTW.postDelayed(this.eTX, 2000L);
        }
    }

    public void jj(boolean z) {
        this.eRA.jj(z);
        if (z && this.eSZ) {
            this.cCw.setText(this.eMh.getResources().getString(d.j.click_load_more));
            this.eRE.setNextPage(this.cCw);
            this.eRz = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Jb = iVar;
        this.Jb.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ckd.addView(this.Jb, layoutParams);
        this.Jb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aTT();
        this.eMh.aRf().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.Jb != null && ap.this.Jb.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.eTK == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.Jb.getId());
                            ap.this.eTK = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.eMh.getPageContext(), ap.this.ckd, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.v(ap.this.eTJ)) {
                                ap.this.eTK.setData(ap.this.eTJ);
                            }
                            ap.this.eTK.b(ap.this.Jb);
                        }
                        ap.this.eTK.pI(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.eMh.eKx != null && ap.this.eMh.eKx.aVe() != null) {
                    if (!ap.this.eMh.eKx.aVe().bCg()) {
                        ap.this.eMh.eKx.ju(false);
                    }
                    ap.this.eMh.eKx.aVe().nj(false);
                }
            }
        });
    }

    public void aUl() {
        if (this.eMh != null && this.Jb != null) {
            this.Jb.lG();
            aUM();
        }
    }

    public void P(String str, boolean z) {
        this.eSV = z;
        jk(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void jk(boolean z) {
        if (this.eST != null) {
            if (this.eSV) {
                com.baidu.tbadk.core.util.aj.j(this.eST, d.f.pb_praise_already_click_selector);
                this.eST.setContentDescription(this.eMh.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.eST, d.f.pb_praise_normal_click_selector);
            this.eST.setContentDescription(this.eMh.getResources().getString(d.j.zan));
        }
    }

    public TextView aUm() {
        return this.eST;
    }

    public void jl(boolean z) {
        if (this.eRE != null && this.axk != null && this.czo != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.czo.setVisibility(0);
                } else {
                    this.czo.setVisibility(8);
                    this.eRE.removeHeaderView(this.axk);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = eTk;
                    this.axk.setLayoutParams(layoutParams);
                }
                aUB();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axk.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + js(true);
                this.axk.setLayoutParams(layoutParams2);
            }
            aUB();
            aUW();
        }
    }

    public h aUn() {
        return this.eSp;
    }

    public void a(PbActivity.d dVar) {
        this.eLr = dVar;
    }

    public void bn(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eSy == null) {
            this.eSy = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eMh.getLayoutMode().t(this.eSy);
        if (this.eSx == null) {
            this.eSx = new Dialog(this.eMh.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.eSx.setCanceledOnTouchOutside(true);
            this.eSx.setCancelable(true);
            this.eSx.setContentView(this.eSy);
            WindowManager.LayoutParams attributes = this.eSx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ac(this.eMh.getPageContext().getPageActivity()) * 0.9d);
            this.eSx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eSx.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.eSx.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.eSx.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.eSx != null && (ap.this.eSx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSx, ap.this.eMh.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ap.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || aUT()) {
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.eSx != null && (ap.this.eSx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSx, ap.this.eMh.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ap.this.eTZ != null) {
                        ap.this.eTZ.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.eSx != null && (ap.this.eSx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSx, ap.this.eMh.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ap.this.eMh.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eSx, this.eMh.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.eTZ = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eTr, Integer.valueOf(eTs));
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
        this.eSz = new com.baidu.tbadk.core.dialog.a(this.eMh.getActivity());
        this.eSz.cc(i3);
        this.eSz.z(sparseArray);
        this.eSz.a(d.j.dialog_ok, this.eMh);
        this.eSz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eSz.ao(true);
        this.eSz.b(this.eMh.getPageContext());
        this.eSz.th();
    }

    public void aj(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eSC == null) {
            this.eSC = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.eMh.getLayoutMode().t(this.eSC);
        if (this.eSB == null) {
            this.eSB = new Dialog(this.eMh.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.eSB.setCanceledOnTouchOutside(true);
            this.eSB.setCancelable(true);
            this.eSN = (ScrollView) this.eSC.findViewById(d.g.good_scroll);
            this.eSB.setContentView(this.eSC);
            WindowManager.LayoutParams attributes = this.eSB.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds540);
            this.eSB.getWindow().setAttributes(attributes);
            this.eSE = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.eSI = (String) compoundButton.getTag();
                        if (ap.this.eRF != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ap.this.eRF) {
                                String str = (String) aVar.getTag();
                                if (str != null && ap.this.eSI != null && !str.equals(ap.this.eSI)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eSD = (LinearLayout) this.eSC.findViewById(d.g.good_class_group);
            this.eSG = (TextView) this.eSC.findViewById(d.g.dialog_button_cancel);
            this.eSG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.eSB instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSB, ap.this.eMh.getPageContext());
                    }
                }
            });
            this.eSF = (TextView) this.eSC.findViewById(d.g.dialog_button_ok);
            this.eSF.setOnClickListener(this.czc);
        }
        this.eSD.removeAllViews();
        this.eRF = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bD = bD("0", this.eMh.getPageContext().getString(d.j.def_good_class));
        this.eRF.add(bD);
        bD.setChecked(true);
        this.eSD.addView(bD);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bD2 = bD(String.valueOf(arrayList.get(i2).pV()), arrayList.get(i2).pU());
                this.eRF.add(bD2);
                View view = new View(this.eMh.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.C0080d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eSD.addView(view);
                this.eSD.addView(bD2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eSN.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eMh.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eMh.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eMh.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eSN.setLayoutParams(layoutParams2);
            this.eSN.removeAllViews();
            this.eSN.addView(this.eSD);
        }
        com.baidu.adp.lib.g.g.a(this.eSB, this.eMh.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bD(String str, String str2) {
        Activity pageActivity = this.eMh.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.eSE);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aUo() {
        this.eMh.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eMh.hideProgressBar();
        if (z && z2) {
            this.eMh.showToast(this.eMh.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.eMh.showToast(str);
        }
    }

    public void azr() {
        this.eSv.setVisibility(0);
    }

    public void azq() {
        this.eSv.setVisibility(8);
    }

    public View aUp() {
        if (this.eSC != null) {
            return this.eSC.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String aUq() {
        return this.eSI;
    }

    public View getView() {
        return this.ckd;
    }

    public void aUr() {
        com.baidu.adp.lib.util.l.a(this.eMh.getPageContext().getPageActivity(), this.eMh.getCurrentFocus());
    }

    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.eMh.hideProgressBar();
        if (z) {
            aEQ();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            aUG();
        } else {
            aEQ();
        }
    }

    public void aUs() {
        this.cCw.wp();
        this.cCw.wt();
    }

    public void aUt() {
        this.eMh.hideProgressBar();
        wu();
        this.eRE.completePullRefreshPostDelayed(2000L);
        aUD();
    }

    public void aUu() {
        this.eRE.completePullRefreshPostDelayed(2000L);
        aUD();
    }

    private void jm(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eSQ.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eMh.getResources().getDimensionPixelSize(d.e.ds130) : this.eMh.getResources().getDimensionPixelSize(d.e.ds34);
        this.eSQ.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eSp.setOnLongClickListener(onLongClickListener);
        if (this.eTL != null) {
            this.eTL.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z, boolean z2) {
        if (this.eSJ != null) {
            this.eSJ.dismiss();
            this.eSJ = null;
        }
        this.eSJ = new com.baidu.tbadk.core.dialog.b(this.eMh.getPageContext().getPageActivity());
        this.eSJ.cf(d.j.operation);
        if (z2) {
            this.eSJ.a(new String[]{this.eMh.getPageContext().getString(d.j.copy)}, interfaceC0047b);
        } else if (!z) {
            this.eSJ.a(new String[]{this.eMh.getPageContext().getString(d.j.copy), this.eMh.getPageContext().getString(d.j.mark)}, interfaceC0047b);
        } else {
            this.eSJ.a(new String[]{this.eMh.getPageContext().getString(d.j.copy), this.eMh.getPageContext().getString(d.j.remove_mark)}, interfaceC0047b);
        }
        this.eSJ.d(this.eMh.getPageContext());
        this.eSJ.tl();
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z) {
        if (this.eSK != null) {
            this.eSK.dismiss();
            this.eSK = null;
        }
        this.eSK = new com.baidu.tbadk.core.dialog.b(this.eMh.getPageContext().getPageActivity());
        this.eSK.cf(d.j.operation);
        if (z) {
            this.eSK.a(new String[]{this.eMh.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0047b);
        } else {
            this.eSK.a(new String[]{this.eMh.getPageContext().getString(d.j.save_to_emotion), this.eMh.getPageContext().getString(d.j.save_to_local)}, interfaceC0047b);
        }
        this.eSK.d(this.eMh.getPageContext());
        this.eSK.tl();
    }

    public int aUv() {
        return pN(this.eRE.getFirstVisiblePosition());
    }

    private int pN(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eRE.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eRE.getAdapter() == null || !(this.eRE.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eRE.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aUw() {
        int lastVisiblePosition = this.eRE.getLastVisiblePosition();
        if (this.eRv != null) {
            if (lastVisiblePosition == this.eRE.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pN(lastVisiblePosition);
    }

    public void pO(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.eRE != null) {
            if (this.eRA == null || this.eRA.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.eRA.mNavigationBar.getFixedNavHeight();
                boolean isUseStyleImmersiveSticky = this.eMh.isUseStyleImmersiveSticky();
                boolean z = this.eMh.aRu() != -1;
                if (isUseStyleImmersiveSticky) {
                    fixedNavHeight -= eTk;
                }
                if (z) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.eTi != null && (layoutParams = (LinearLayout.LayoutParams) this.eTi.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.eTi.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.eRE.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.eRE.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eSs.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        this.eSp.a(fVar, false);
        this.eSp.notifyDataSetChanged();
        aUD();
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (this.eRZ == null) {
            this.eMh.getLayoutMode().t(((ViewStub) this.eRG.findViewById(d.g.praise_layout)).inflate());
            this.eRZ = (FrsPraiseView) this.eRG.findViewById(d.g.pb_head_praise_view);
            this.eRZ.setIsFromPb(true);
            this.eSn = this.eRG.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.eRZ.dE(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eRZ != null) {
            boolean aUD = aUD();
            this.eRZ.setVisibility(8);
            if (fVar != null && fVar.qv() != null && fVar.qv().qs() == 0 && this.eHQ) {
                if (aUD) {
                    this.eSm.setVisibility(0);
                    return;
                } else {
                    this.eSm.setVisibility(8);
                    return;
                }
            }
            this.eSm.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPX() != null) {
            return fVar.aPX();
        }
        if (!com.baidu.tbadk.core.util.v.v(fVar.aPQ())) {
            Iterator<PostData> it = fVar.aPQ().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.buu() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aPV();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.rt() != null && postData.rt().getUserTbVipInfoData() != null && postData.rt().getUserTbVipInfoData().getvipIntro() != null) {
            postData.rt().getGodUserData().setIntro(postData.rt().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPO() == null || fVar.aPO().rt() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rt = fVar.aPO().rt();
        String userId = rt.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rt;
        }
        postData.tR(1);
        postData.setId(fVar.aPO().rK());
        postData.setTitle(fVar.aPO().getTitle());
        postData.setTime(fVar.aPO().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0553 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0384  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String e;
        ArrayList<IconData> tShowInfoNew;
        int f;
        com.baidu.tbadk.data.i bux;
        String portrait;
        if (fVar != null && fVar.aPO() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aUU();
            this.eRL.setVisibility(8);
            if (fVar.aPO() != null && fVar.aPO().sh() && fVar.aPO().rL() != null) {
                this.eTC = true;
                this.eRA.jF(this.eTC);
                this.eRA.mNavigationBar.hideBottomLine();
                if (this.eRv == null) {
                    this.eRv = new com.baidu.tieba.pb.video.i(this.eMh, this.eRA, fVar.aPO().rL());
                    this.eRv.a(fVar.aPO().rL(), fVar.aPO(), fVar.getForumId());
                    this.eRv.startPlay();
                } else if (this.eRy) {
                    this.eRv.a(fVar.aPO().rL(), fVar.aPO(), fVar.getForumId());
                    this.eRv.startPlay();
                } else {
                    this.eRv.pV(fVar.getForumId());
                }
                if (fVar.aPP() != null && fVar.aPP().size() >= 1) {
                    bh bhVar = fVar.aPP().get(0);
                    this.eRv.ac(bhVar);
                    this.eRv.pW(bhVar.getTitle());
                }
                this.eRv.b(b, fVar.aPO(), fVar.aQk());
                this.eRy = false;
                this.eRE.removeHeaderView(this.eRv.aXn());
                this.eRE.addHeaderView(this.eRv.aXn(), 0);
                if (this.eRv.aXl() != null && this.eRv.aXl().getParent() == null) {
                    this.eTg.addView(this.eRv.aXl());
                }
                if (this.eRw == null) {
                    this.eRw = new com.baidu.tieba.pb.video.h(this.eMh);
                }
                this.eRw.a(fVar.aPO().sz(), fVar.aPO(), fVar.aQh());
                this.eRE.removeHeaderView(this.eRw.aXc());
                this.eRE.addHeaderView(this.eRw.aXc(), 1);
                if (fVar.aPO().sz() != null) {
                    this.eRE.removeHeaderView(this.eRw.aXd());
                    this.eRE.removeHeaderView(this.eRJ);
                    this.eRE.addHeaderView(this.eRw.aXd(), 2);
                } else {
                    if (this.eRw.aXd() != null) {
                        this.eRE.removeHeaderView(this.eRw.aXd());
                    }
                    this.eRE.removeHeaderView(this.eRJ);
                    this.eRE.addHeaderView(this.eRJ, 2);
                }
                if (this.eRv != null) {
                    this.eRA.jB(false);
                    this.eRA.jC(TbadkCoreApplication.isLogin());
                    this.eRv.qa(0);
                }
                aUB();
            } else {
                this.eTC = false;
                this.eRA.jF(this.eTC);
                if (this.eRv != null) {
                    this.eRE.removeHeaderView(this.eRv.aXn());
                }
                if (this.eRw != null) {
                    this.eRw.f(this.eRE);
                }
            }
            if (this.eMh.aRj() != null) {
                this.eMh.aRj().jz(this.eTC);
            }
            if (this.eRv != null) {
                this.eRv.G(this.eUb);
            }
            if (b != null) {
                this.eSY = b;
                this.eRL.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eRL.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eRL.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.eTP) {
                    this.eRH.setVisibility(0);
                }
                if (!fVar.aPO().sh() && this.eRI.getText() != null && this.eRI.getText().length() > 0) {
                    this.eRI.setVisibility(0);
                } else {
                    this.eRI.setVisibility(8);
                }
                p(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rF = fVar.aPO().rF();
                if (rF != null && rF.size() > 0 && !this.eTP) {
                    this.eTb.setText(String.valueOf(rF.get(0).pm()));
                    this.eTa.setVisibility(0);
                } else {
                    this.eTa.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.eTa, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.eTb, d.C0080d.cp_link_tip_d, 1);
                if (b.rt() != null) {
                    String string = b.rt().getName_show() == null ? StringUtils.string(b.rt().getUserName()) : StringUtils.string(b.rt().getName_show());
                    if (StringUtils.isNull(b.rt().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.k.aP(b.rt().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aP(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aP = com.baidu.adp.lib.util.k.aP(b.rt().getName_show());
                                if (aP + i2 > 14) {
                                    i3 = 0;
                                } else if (aP + i2 >= 12) {
                                    i3 = 1;
                                } else if (aP + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = b.rt().getIconInfo();
                            tShowInfoNew = b.rt().getTShowInfoNew();
                            if (this.eNm != null) {
                                this.eNm.setTag(d.g.tag_user_id, b.rt().getUserId());
                                this.eNm.setOnClickListener(this.eMh.eKt.cIR);
                                this.eNm.a(iconInfo, i3, this.eMh.getResources().getDimensionPixelSize(d.e.ds26), this.eMh.getResources().getDimensionPixelSize(d.e.ds26), this.eMh.getResources().getDimensionPixelSize(d.e.ds8));
                            }
                            if (this.eNl != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eNl.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eNl.setOnClickListener(this.eMh.eKt.eXI);
                                this.eNl.a(tShowInfoNew, 3, this.eMh.getResources().getDimensionPixelSize(d.e.ds36), this.eMh.getResources().getDimensionPixelSize(d.e.ds36), this.eMh.getResources().getDimensionPixelSize(d.e.ds8), true);
                            }
                            this.eRN.setText(ag(b.rt().getSealPrefix(), e));
                            this.eRN.setTag(d.g.tag_user_id, b.rt().getUserId());
                            this.eRN.setTag(d.g.tag_user_name, b.rt().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew) || b.rt().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_cont_f, 1);
                            }
                            if (b == null && !TextUtils.isEmpty(b.rt().getGodIntro())) {
                                this.eRO.setVisibility(0);
                                this.eRO.setText(ao.c(b.rt()));
                                this.eRP.setVisibility(0);
                            } else {
                                this.eRO.setVisibility(8);
                                this.eRP.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eRQ, d.C0080d.cp_link_tip_a, 1);
                            this.eRQ.setVisibility(0);
                            if (fVar.aPO().rt() != null && fVar.aPO().rt().getAlaUserData() != null && this.eRV != null) {
                                if (fVar.aPO().rt().getAlaUserData().anchor_live != 0) {
                                    this.eRV.setVisibility(8);
                                } else {
                                    this.eRV.setVisibility(0);
                                    if (this.eRx == null) {
                                        this.eRx = new com.baidu.tieba.d.a(this.eMh.getPageContext(), this.eRV);
                                        this.eRx.iy(1);
                                    }
                                    this.eRx.aH(this.eMh.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.QK = fVar.aPO().rt().getAlaUserData();
                                    aVar.type = 2;
                                    this.eRV.setTag(aVar);
                                }
                            }
                            this.eRU.setUserId(b.rt().getUserId());
                            this.eRU.setUserName(b.rt().getUserName());
                            this.eRU.setImageDrawable(null);
                            this.eRU.setRadius(com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds40));
                            this.eRU.setTag(b.rt().getUserId());
                            this.eSf.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds8);
                            if (this.eRO == null && this.eRO.getVisibility() == 0) {
                                this.eSf.setPadding(f, 0, f, 0);
                            } else {
                                this.eSf.setPadding(0, 0, f, 0);
                            }
                            bux = b.bux();
                            if (bux == null && !TextUtils.isEmpty(bux.getName()) && !TextUtils.isEmpty(bux.getName().trim())) {
                                final String name = bux.getName();
                                final String lat = bux.getLat();
                                final String lng = bux.getLng();
                                this.eSg.setVisibility(0);
                                this.eSh.setVisibility(0);
                                this.eSg.setText(bux.getName());
                                this.eSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                ap.this.eMh.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(ap.this.eMh.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ap.this.eMh.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.eSg.setVisibility(8);
                                this.eSh.setVisibility(8);
                            }
                            portrait = b.rt().getPortrait();
                            if (b.rt().getPendantData() == null && !StringUtils.isNull(b.rt().getPendantData().pQ())) {
                                UtilHelper.showHeadImageViewBigV(this.eRS.getHeadView(), b.rt());
                                this.eRU.setVisibility(8);
                                this.eRS.setVisibility(0);
                                if (this.eSa != null) {
                                    this.eSa.setVisibility(8);
                                }
                                this.eRN.setOnClickListener(this.eUb);
                                this.eRS.getHeadView().startLoad(portrait, 28, false);
                                this.eRS.getHeadView().setUserId(b.rt().getUserId());
                                this.eRS.getHeadView().setUserName(b.rt().getUserName());
                                this.eRS.getHeadView().setOnClickListener(this.eUb);
                                this.eRS.en(b.rt().getPendantData().pQ());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eRU, b.rt());
                                this.eRU.setVisibility(0);
                                this.eRL.setOnClickListener(this.eUb);
                                this.eRN.setOnClickListener(this.eUb);
                                this.eRU.setOnClickListener(this.eUb);
                                this.eRS.setVisibility(8);
                                this.eRU.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rt().getName_show();
                            String userName = b.rt().getUserName();
                            if (com.baidu.tbadk.p.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.eRN.setText(com.baidu.tieba.pb.c.al(this.eMh.getPageContext().getPageActivity(), this.eRN.getText().toString()));
                                this.eRN.setGravity(16);
                                this.eRN.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPq());
                                com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = b.rt().getIconInfo();
                        tShowInfoNew = b.rt().getTShowInfoNew();
                        if (this.eNm != null) {
                        }
                        if (this.eNl != null) {
                        }
                        this.eRN.setText(ag(b.rt().getSealPrefix(), e));
                        this.eRN.setTag(d.g.tag_user_id, b.rt().getUserId());
                        this.eRN.setTag(d.g.tag_user_name, b.rt().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eRO.setVisibility(8);
                        this.eRP.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eRQ, d.C0080d.cp_link_tip_a, 1);
                        this.eRQ.setVisibility(0);
                        if (fVar.aPO().rt() != null) {
                            if (fVar.aPO().rt().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eRU.setUserId(b.rt().getUserId());
                        this.eRU.setUserName(b.rt().getUserName());
                        this.eRU.setImageDrawable(null);
                        this.eRU.setRadius(com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds40));
                        this.eRU.setTag(b.rt().getUserId());
                        this.eSf.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds8);
                        if (this.eRO == null) {
                        }
                        this.eSf.setPadding(0, 0, f, 0);
                        bux = b.bux();
                        if (bux == null) {
                        }
                        this.eSg.setVisibility(8);
                        this.eSh.setVisibility(8);
                        portrait = b.rt().getPortrait();
                        if (b.rt().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eRU, b.rt());
                        this.eRU.setVisibility(0);
                        this.eRL.setOnClickListener(this.eUb);
                        this.eRN.setOnClickListener(this.eUb);
                        this.eRU.setOnClickListener(this.eUb);
                        this.eRS.setVisibility(8);
                        this.eRU.startLoad(portrait, 28, false);
                        String name_show2 = b.rt().getName_show();
                        String userName2 = b.rt().getUserName();
                        if (com.baidu.tbadk.p.ac.fS()) {
                            this.eRN.setText(com.baidu.tieba.pb.c.al(this.eMh.getPageContext().getPageActivity(), this.eRN.getText().toString()));
                            this.eRN.setGravity(16);
                            this.eRN.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPq());
                            com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = b.rt().getIconInfo();
                            tShowInfoNew = b.rt().getTShowInfoNew();
                            if (this.eNm != null) {
                            }
                            if (this.eNl != null) {
                            }
                            this.eRN.setText(ag(b.rt().getSealPrefix(), e));
                            this.eRN.setTag(d.g.tag_user_id, b.rt().getUserId());
                            this.eRN.setTag(d.g.tag_user_name, b.rt().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_cont_h, 1);
                            if (b == null) {
                            }
                            this.eRO.setVisibility(8);
                            this.eRP.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.c(this.eRQ, d.C0080d.cp_link_tip_a, 1);
                            this.eRQ.setVisibility(0);
                            if (fVar.aPO().rt() != null) {
                            }
                            this.eRU.setUserId(b.rt().getUserId());
                            this.eRU.setUserName(b.rt().getUserName());
                            this.eRU.setImageDrawable(null);
                            this.eRU.setRadius(com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds40));
                            this.eRU.setTag(b.rt().getUserId());
                            this.eSf.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds8);
                            if (this.eRO == null) {
                            }
                            this.eSf.setPadding(0, 0, f, 0);
                            bux = b.bux();
                            if (bux == null) {
                            }
                            this.eSg.setVisibility(8);
                            this.eSh.setVisibility(8);
                            portrait = b.rt().getPortrait();
                            if (b.rt().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eRU, b.rt());
                            this.eRU.setVisibility(0);
                            this.eRL.setOnClickListener(this.eUb);
                            this.eRN.setOnClickListener(this.eUb);
                            this.eRU.setOnClickListener(this.eUb);
                            this.eRS.setVisibility(8);
                            this.eRU.startLoad(portrait, 28, false);
                            String name_show22 = b.rt().getName_show();
                            String userName22 = b.rt().getUserName();
                            if (com.baidu.tbadk.p.ac.fS()) {
                            }
                        }
                        e = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = b.rt().getIconInfo();
                        tShowInfoNew = b.rt().getTShowInfoNew();
                        if (this.eNm != null) {
                        }
                        if (this.eNl != null) {
                        }
                        this.eRN.setText(ag(b.rt().getSealPrefix(), e));
                        this.eRN.setTag(d.g.tag_user_id, b.rt().getUserId());
                        this.eRN.setTag(d.g.tag_user_name, b.rt().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eRN, d.C0080d.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eRO.setVisibility(8);
                        this.eRP.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eRQ, d.C0080d.cp_link_tip_a, 1);
                        this.eRQ.setVisibility(0);
                        if (fVar.aPO().rt() != null) {
                        }
                        this.eRU.setUserId(b.rt().getUserId());
                        this.eRU.setUserName(b.rt().getUserName());
                        this.eRU.setImageDrawable(null);
                        this.eRU.setRadius(com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds40));
                        this.eRU.setTag(b.rt().getUserId());
                        this.eSf.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.ds8);
                        if (this.eRO == null) {
                        }
                        this.eSf.setPadding(0, 0, f, 0);
                        bux = b.bux();
                        if (bux == null) {
                        }
                        this.eSg.setVisibility(8);
                        this.eSh.setVisibility(8);
                        portrait = b.rt().getPortrait();
                        if (b.rt().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eRU, b.rt());
                        this.eRU.setVisibility(0);
                        this.eRL.setOnClickListener(this.eUb);
                        this.eRN.setOnClickListener(this.eUb);
                        this.eRU.setOnClickListener(this.eUb);
                        this.eRS.setVisibility(8);
                        this.eRU.startLoad(portrait, 28, false);
                        String name_show222 = b.rt().getName_show();
                        String userName222 = b.rt().getUserName();
                        if (com.baidu.tbadk.p.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eRK.V(fVar.aPO());
                }
                if (this.eTj != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eGO);
                    if (fVar != null && fVar.aPO() != null) {
                        jVar.eGQ = fVar.aPO().rl();
                    }
                    jVar.aFc = !this.eHQ;
                    jVar.eGS = this.eMh.aRU();
                    this.eTj.a(jVar);
                }
            }
        }
    }

    public void jn(boolean z) {
        if (z) {
            aUx();
        } else {
            aUy();
        }
        this.eTn.eUu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTn));
        a(this.eTn.eUu, false);
    }

    public void aUx() {
        if (this.eRA != null && !this.eTE) {
            this.eRA.jG(!StringUtils.isNull(this.eMh.aRr()));
            this.eTE = true;
        }
    }

    public void aUy() {
        if (this.eRA != null) {
            this.eRA.aWa();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rP() != null) {
            this.eRM.a(this.eMh.getPageContext(), fVar.aPQ().get(0).rP(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aPM().getId(), fVar.aPM().getName(), fVar.aPO().getId(), this.eMh.aRR() ? "FRS" : null));
            this.eRL.setPadding(this.eRL.getPaddingLeft(), (int) this.eMh.getResources().getDimension(d.e.ds20), this.eRL.getPaddingRight(), this.eRL.getPaddingBottom());
            return;
        }
        this.eRM.a(null, null, null);
    }

    public void aUz() {
        if (this.eRv != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.eRv.aXm();
            this.eRE.smoothScrollToPosition(0);
        }
    }

    public boolean aUA() {
        return this.eUc;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean P(bh bhVar) {
        if (bhVar == null || bhVar.rt() == null || bhVar.rt().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.rt().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eRA.aVY();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eRA.nv(eVar.forumName);
            }
            String string = this.eMh.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eMh.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.eMh.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.eMh.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eGe;
            this.eMh.showNetRefreshView(this.ckd, format, null, this.eMh.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.22
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        av.vI().c(ap.this.eMh.getPageContext(), new String[]{str2});
                        ap.this.eMh.finish();
                        return;
                    }
                    ap.this.eMh.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aTH;
        Parcelable aTH2;
        String str;
        if (fVar != null) {
            this.eOk = fVar;
            this.mType = i;
            if (fVar.aPO() != null) {
                this.eTp = fVar.aPO().re();
                if (fVar.aPO().getAnchorLevel() != 0) {
                    this.eUc = true;
                }
                this.eSM = P(fVar.aPO());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            s(fVar);
            this.eSZ = false;
            this.eHQ = z;
            aUt();
            b(fVar, z, i);
            q(fVar);
            if (this.eMh.aRH()) {
                if (this.eSt == null) {
                    this.eSt = new com.baidu.tieba.pb.view.i(this.eMh.getPageContext());
                    this.eSt.kX();
                    this.eSt.a(this.amz);
                }
                this.eRE.setPullRefresh(this.eSt);
                aUB();
                if (this.eSt != null) {
                    this.eSt.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qv().qs() == 0 && z) {
                this.eRE.setPullRefresh(null);
            } else {
                if (this.eSt == null) {
                    this.eSt = new com.baidu.tieba.pb.view.i(this.eMh.getPageContext());
                    this.eSt.kX();
                    this.eSt.a(this.amz);
                }
                this.eRE.setPullRefresh(this.eSt);
                aUB();
                if (this.eSt != null) {
                    this.eSt.dz(TbadkCoreApplication.getInst().getSkinType());
                }
                VG();
            }
            aUD();
            this.eSp.iz(this.eHQ);
            this.eSp.iA(false);
            this.eSp.iN(i == 5);
            this.eSp.iO(i == 6);
            this.eSp.iP(z2 && this.eUa);
            this.eSp.a(fVar, false);
            this.eSp.notifyDataSetChanged();
            if (this.eMh.aRV()) {
                if (fVar.aPN() != null) {
                    this.mForumName = fVar.aPN().getForumName();
                    this.mForumId = fVar.aPN().getForumId();
                }
                if (this.mForumName == null && this.eMh.aQS() != null && this.eMh.aQS().aSy() != null) {
                    this.mForumName = this.eMh.aQS().aSy();
                }
                this.eRA.nv(this.mForumName);
            } else {
                this.eRA.nv(null);
            }
            if (this.eMh.aRV()) {
                this.eTG = 0;
                PostData b = b(fVar, z);
                if (b != null && b.rt() != null) {
                    this.eTG = b.rt().getLevel_id();
                }
                if (this.eTG > 0) {
                    this.eRR.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.eRR, BitmapHelper.getGradeResourceIdInEnterForum(this.eTG));
                } else {
                    this.eRR.setVisibility(8);
                }
            } else {
                this.eRR.setVisibility(8);
            }
            if (fVar.aPO() != null && fVar.aPO().ri() != null) {
                if (fVar.aPO().ri().getNum() < 1) {
                    str = this.eMh.getResources().getString(d.j.zan);
                } else {
                    str = fVar.aPO().ri().getNum() + "";
                }
                if (this.eRu != -1) {
                    fVar.aPO().ri().setIsLike(this.eRu);
                }
                P(str, fVar.aPO().ri().getIsLike() == 1);
            }
            if (this.eMh.isLogin()) {
                this.eRE.setNextPage(this.cCw);
                this.eRz = 2;
                VG();
            } else {
                this.eSZ = true;
                if (fVar.qv().qr() == 1) {
                    if (this.eSu == null) {
                        this.eSu = new com.baidu.tieba.pb.view.b(this.eMh.getPageContext());
                    }
                    this.eRE.setNextPage(this.eSu);
                } else {
                    this.eRE.setNextPage(this.cCw);
                }
                this.eRz = 3;
            }
            ArrayList<PostData> aPQ = fVar.aPQ();
            if (fVar.qv().qr() == 0 || aPQ == null || aPQ.size() < fVar.qv().qq()) {
                if (com.baidu.tbadk.core.util.v.u(aPQ) == 0 || (com.baidu.tbadk.core.util.v.u(aPQ) == 1 && aPQ.get(0) != null && aPQ.get(0).buu() == 1)) {
                    this.cCw.setText(this.eMh.getResources().getString(d.j.list_no_more_new));
                    if (this.eMh.aRj() != null && !this.eMh.aRj().aVQ()) {
                        this.eMh.aRj().showFloatingView();
                    }
                } else {
                    this.cCw.setText(this.eMh.getResources().getString(d.j.list_has_no_more));
                }
                if (this.eMh.aRH() && this.eRE != null && this.eRE.getData() != null && this.eRE.getData().size() == 1 && (this.eRE.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cCw.setText("");
                }
                aUJ();
            } else if (z2) {
                if (this.eUa) {
                    wu();
                    if (fVar.qv().qr() != 0) {
                        this.cCw.setText(this.eMh.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.cCw.wp();
                    this.cCw.showLoading();
                }
            } else {
                this.cCw.wp();
                this.cCw.showLoading();
            }
            switch (i) {
                case 2:
                    this.eRE.setSelection(i2 > 1 ? (((this.eRE.getData() == null && fVar.aPQ() == null) ? 0 : (this.eRE.getData().size() - fVar.aPQ().size()) + this.eRE.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aTH2 = ag.aTG().aTH()) != null) {
                        this.eRE.onRestoreInstanceState(aTH2);
                        if (com.baidu.tbadk.core.util.v.u(aPQ) > 1 && fVar.qv().qr() > 0) {
                            this.cCw.wu();
                            this.cCw.setText(this.eMh.getString(d.j.pb_load_more_without_point));
                            this.cCw.wq();
                            break;
                        }
                    } else {
                        this.eRE.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eUa = false;
                    break;
                case 5:
                    this.eRE.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aTH = ag.aTG().aTH()) != null) {
                        this.eRE.onRestoreInstanceState(aTH);
                        break;
                    } else {
                        this.eRE.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.eRv != null && this.eRv.aXl() != null) {
                            if (this.eMh.isUseStyleImmersiveSticky()) {
                                this.eRE.setSelectionFromTop((this.eSp.aSi() + this.eRE.getHeaderViewsCount()) - 1, this.eRv.aXl().getHeight() - com.baidu.adp.lib.util.l.n(this.eMh.getPageContext().getPageActivity()));
                            } else {
                                this.eRE.setSelectionFromTop((this.eSp.aSi() + this.eRE.getHeaderViewsCount()) - 1, this.eRv.aXl().getHeight());
                            }
                        } else {
                            this.eRE.setSelection(this.eSp.aSi() + this.eRE.getHeaderViewsCount());
                        }
                    } else {
                        this.eRE.setSelection(i2 > 0 ? ((this.eRE.getData() == null && fVar.aPQ() == null) ? 0 : (this.eRE.getData().size() - fVar.aPQ().size()) + this.eRE.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cCw.wu();
                    this.cCw.setText(this.eMh.getString(d.j.pb_load_more_without_point));
                    this.cCw.wq();
                    break;
            }
            if (this.eTp == eTq && isHost()) {
                aUP();
            }
            if (this.eTA) {
                aTQ();
                this.eTA = false;
                if (i3 == 0) {
                    ji(true);
                }
            }
            if (this.eRw != null) {
                this.eRw.ab(fVar.aPO());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aUB() {
        if (this.eRv != null && this.eRv.aXl() != null) {
            this.eRE.removeHeaderView(this.axk);
            if (this.mType != 1) {
                this.eRE.removeHeaderView(this.eRv.aXn());
                this.eRE.addHeaderView(this.eRv.aXn(), 0);
                return;
            }
            return;
        }
        if (this.eRv != null) {
            this.eRE.removeHeaderView(this.eRv.aXn());
        }
        this.eRE.removeHeaderView(this.axk);
        this.eRE.addHeaderView(this.axk, 0);
    }

    public void jo(boolean z) {
        this.eSL = z;
    }

    public void wu() {
        if (this.cCw != null) {
            this.cCw.wq();
            this.cCw.wu();
        }
        VG();
    }

    public void Od() {
        this.eRE.setVisibility(0);
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.eSY != null && this.eSY.rt() != null && this.eRA != null) {
            this.eTD = com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !this.eTC;
            this.eRA.jB(this.eTD);
            if (this.eMh.aRj() != null) {
                this.eMh.aRj().jA(this.eTD);
            }
            aUC();
            if (this.eTD) {
                this.eRA.eYx.setVisibility(0);
                this.eSb.setVisibility(8);
                if (this.eSM) {
                    this.eRA.eYy.setVisibility(8);
                } else if (!PbNormalLikeButtonSwitchStatic.GC() || (this.eSY.rt().hadConcerned() && this.eSY.rt().getGodUserData() != null && this.eSY.rt().getGodUserData().getIsFromNetWork())) {
                    this.eRA.eYy.setVisibility(8);
                }
                if (this.eTi != null) {
                    this.eTi.setVisibility(8);
                }
                if (this.eRT != null) {
                    this.eRT.setVisibility(8);
                }
                if (this.eSa != null) {
                    this.eSa.setVisibility(8);
                }
                this.eRA.eYz.setUserId(this.eSY.rt().getUserId());
                this.eRA.eYz.setUserName(this.eSY.rt().getUserName());
                this.eRA.eYz.setImageDrawable(null);
                this.eRA.eYz.setTag(this.eSY.rt().getUserId());
                UtilHelper.showHeadImageViewBigV(this.eRA.eYz, this.eSY.rt());
                this.eRA.eYz.setVisibility(0);
                this.eRA.eYz.setOnClickListener(this.eUb);
                this.eRA.eYz.startLoad(this.eSY.rt().getPortrait(), 28, false);
                if (this.eTM == null) {
                    this.eTM = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ap.this.eTF) {
                                ap.this.aUO();
                            }
                        }
                    };
                }
                this.eRE.setListViewDragListener(this.eTM);
                return;
            }
            if (this.eRA.eYx != null) {
                this.eRA.eYx.setVisibility(8);
            }
            if (this.eTi != null) {
                this.eTi.setVisibility(0);
            }
            if (this.eSM) {
                this.eSb.setVisibility(8);
                this.eSe.setVisibility(0);
                this.eSe.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aQj())));
            } else if (!PbNormalLikeButtonSwitchStatic.GC() || (this.eSY.rt().hadConcerned() && this.eSY.rt().getGodUserData() != null && this.eSY.rt().getGodUserData().getIsFromNetWork())) {
                this.eSb.setVisibility(8);
                this.eSe.setVisibility(8);
            } else {
                this.eSb.setVisibility(0);
                this.eSb.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eMh.getActivity(), d.e.fontsize26));
                this.eSe.setVisibility(8);
            }
            this.eTM = null;
            this.eRE.setListViewDragListener(null);
        }
    }

    private void aUC() {
        String threadId = this.eOk != null ? this.eOk.getThreadId() : "";
        if (this.eTD) {
            if (this.eSd == null) {
                this.eSd = new an(this.eMh.getPageContext(), this.eRA.eYy, 3);
                this.eSd.h(this.eMh.getUniqueId());
                this.eSd.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ap.25
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void aN(boolean z) {
                        if (ap.this.eMh != null && z) {
                            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                            if (i >= 2) {
                                com.baidu.adp.lib.util.l.showToast(ap.this.eMh, d.j.attention_success);
                                return;
                            }
                            ao.w(ap.this.eMh.getPageContext());
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                        }
                    }
                });
            }
            if (this.eSY != null && this.eSY.rt() != null) {
                this.eSY.rt().setIsLike(this.eSY.rt().hadConcerned());
                this.eSd.a(this.eSY.rt());
            }
            this.eSd.cD(threadId);
            this.eSd.eRr = this.eTC;
            if (this.eSc != null) {
                this.eSc.unRegisterListener(this.eMh.getUniqueId());
                return;
            }
            return;
        }
        if (this.eSc == null) {
            this.eSc = new an(this.eMh.getPageContext(), this.eSb, 1);
            this.eSc.h(this.eMh.getUniqueId());
            this.eSc.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aN(boolean z) {
                    if (ap.this.eMh != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ap.this.eMh, d.j.attention_success);
                            return;
                        }
                        ao.w(ap.this.eMh.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.eSY != null && this.eSY.rt() != null) {
            this.eSY.rt().setIsLike(this.eSY.rt().hadConcerned());
            this.eSc.a(this.eSY.rt());
            this.eSc.cD(threadId);
        }
        this.eSc.eRr = this.eTC;
        if (this.eSd != null) {
            this.eSd.unRegisterListener(this.eMh.getUniqueId());
        }
    }

    private boolean aUD() {
        boolean z;
        if (this.eSO != null && this.eSO.getVisibility() == 0) {
            if (this.eSl != null) {
                this.eSl.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eSl != null) {
                this.eSl.setVisibility(8);
            }
            z = false;
        }
        if ((this.eSn == null || this.eSn.getVisibility() == 8) && z && this.eHQ) {
            this.eSm.setVisibility(0);
        } else {
            this.eSm.setVisibility(8);
        }
        return z;
    }

    private boolean r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPO() == null) {
            return false;
        }
        if (fVar.aPO().rq() == 1 || fVar.aPO().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aPO().rs() == null || fVar.aPO().rs().sV() == 0) || fVar.aPO().ro() == 1 || fVar.aPO().rp() == 1 || fVar.aPO().rZ() || fVar.aPO().sn() || fVar.aPO().sg() || fVar.aPO().rG() != null || fVar.aPO().so() || fVar.aPO().so() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aPO().getCategory()) || fVar.aPO().rx() || fVar.aPO().rw();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eMh.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eRH != null) {
                if (fVar.aPO() != null && fVar.aPO().rJ() == 0 && !fVar.aPO().sh() && !this.eTP) {
                    this.eRH.setVisibility(0);
                    if (fVar.aPO() != null) {
                        fVar.aPO().e(true, r(fVar));
                    }
                    SpannableStringBuilder rU = fVar.aPO().rU();
                    this.eRI.setOnTouchListener(new com.baidu.tieba.view.l(rU));
                    if (this.eTN) {
                        this.eRI.setText(fVar.aPO().getTitle());
                    } else {
                        this.eRI.setText(rU);
                    }
                    this.eRI.setVisibility(0);
                } else if (fVar.aPO().rJ() == 1) {
                    if (fVar.aPO() != null) {
                        fVar.aPO().e(true, r(fVar));
                        SpannableStringBuilder rU2 = fVar.aPO().rU();
                        if (rU2 == null || rU2.length() == 0) {
                            this.eRH.setVisibility(8);
                            this.eRE.removeHeaderView(this.eRH);
                            if (fVar.aPO() != null && !fVar.aPO().sh()) {
                                this.eRL.setPadding(this.eRL.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds48), this.eRL.getPaddingRight(), this.eRL.getPaddingBottom());
                            }
                        } else {
                            this.eRH.setVisibility(0);
                            this.eRI.setOnTouchListener(new com.baidu.tieba.view.l(rU2));
                            this.eRI.setText(rU2);
                            this.eRI.setVisibility(0);
                        }
                    }
                } else {
                    this.eRH.setVisibility(8);
                    this.eRE.removeHeaderView(this.eRH);
                    if (fVar.aPO() != null && fVar.aPO().sh()) {
                        this.eRL.setPadding(this.eRL.getPaddingLeft(), 0, this.eRL.getPaddingRight(), this.eRL.getPaddingBottom());
                    } else {
                        this.eRL.setPadding(this.eRL.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds48), this.eRL.getPaddingRight(), this.eRL.getPaddingBottom());
                    }
                }
            }
            this.eHQ = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aUD();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        if (fVar == null || (b = b(fVar, z)) == null) {
            return null;
        }
        String userId = b.rt().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aPZ()));
            sparseArray.put(d.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.rt() != null) {
                sparseArray.put(d.g.tag_forbid_user_name, b.rt().getUserName());
                sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aPZ()));
            sparseArray.put(d.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIs;
    }

    public void pz(String str) {
        if (this.cCw != null) {
            this.cCw.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eRE;
    }

    public int aUE() {
        return d.g.richText;
    }

    public TextView aRe() {
        return this.eRK.aRe();
    }

    public void d(BdListView.e eVar) {
        this.eRE.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.amz = bVar;
        if (this.eSt != null) {
            this.eSt.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int qp = apVar.qp();
            int qm = apVar.qm();
            if (this.eSq != null) {
                this.eSq.th();
            } else {
                this.eSq = new com.baidu.tbadk.core.dialog.a(this.eMh.getPageContext().getPageActivity());
                this.eSr = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.eSq.v(this.eSr);
                this.eSq.a(d.j.dialog_ok, bVar);
                this.eSq.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.27
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.aEQ();
                        aVar.dismiss();
                    }
                });
                this.eSq.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.eTx == null) {
                            ap.this.eTx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.eMh.HidenSoftKeyPad((InputMethodManager) ap.this.eMh.getSystemService("input_method"), ap.this.ckd);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(ap.this.eTx, 150L);
                    }
                });
                this.eSq.b(this.eMh.getPageContext()).th();
            }
            this.eSs = (EditText) this.eSr.findViewById(d.g.input_page_number);
            this.eSs.setText("");
            TextView textView = (TextView) this.eSr.findViewById(d.g.current_page_number);
            if (qp <= 0) {
                qp = 1;
            }
            if (qm <= 0) {
                qm = 1;
            }
            textView.setText(MessageFormat.format(this.eMh.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(qp), Integer.valueOf(qm)));
            this.eMh.ShowSoftKeyPadDelay(this.eSs, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eRE.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eMh.showToast(str);
    }

    public boolean jp(boolean z) {
        if (this.Jb == null || !this.Jb.CL()) {
            return false;
        }
        this.Jb.AQ();
        return true;
    }

    public void aUF() {
        if (this.eUd != null) {
            while (this.eUd.size() > 0) {
                TbImageView remove = this.eUd.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aUF();
        this.eSp.pB(1);
        if (this.eRv != null) {
            this.eRv.onPause();
        }
    }

    public void onResume() {
        this.eSp.pB(2);
        if (this.eRv != null) {
            this.eRv.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.eTz != null) {
            this.eTz.destroy();
        }
        if (this.eRx != null) {
            this.eRx.abE();
        }
        if (this.eRw != null) {
            this.eRw.onDestroy();
        }
        this.eMh.hideProgressBar();
        if (this.ckb != null && this.cvR != null) {
            this.ckb.b(this.cvR);
        }
        aEQ();
        wu();
        if (this.eTx != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eTx);
        }
        if (this.eRL != null && this.eSa != null) {
            this.eRL.removeView(this.eRT);
            this.eSa = null;
        }
        if (this.eTd != null) {
            this.eTd.clearStatus();
        }
        this.eTW = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eSp.pB(3);
        if (this.czo != null) {
            this.czo.setBackgroundDrawable(null);
        }
        if (this.eRv != null) {
            this.eRv.destroy();
        }
        if (this.eSp != null) {
            this.eSp.onDestory();
        }
        this.eRE.setOnLayoutListener(null);
        if (this.eTK != null) {
            this.eTK.akK();
        }
        if (this.eTo != null) {
            this.eTo.onDestroy();
        }
        aVb();
    }

    public boolean pP(int i) {
        if (this.eRv != null) {
            return this.eRv.jB(i);
        }
        return false;
    }

    public void aEQ() {
        this.eRA.om();
        if (this.eRx != null) {
            this.eRx.abE();
        }
        com.baidu.adp.lib.util.l.a(this.eMh.getPageContext().getPageActivity(), this.eSs);
        aTT();
        if (this.eSJ != null) {
            this.eSJ.dismiss();
        }
        aUH();
        if (this.eRw != null) {
            this.eRw.aXe();
        }
        if (this.eSq != null) {
            this.eSq.dismiss();
        }
        if (this.czb != null) {
            this.czb.dismiss();
        }
    }

    public void aUG() {
        this.eRA.om();
        if (this.eRx != null) {
            this.eRx.abE();
        }
        if (this.eSJ != null) {
            this.eSJ.dismiss();
        }
        aUH();
        if (this.eRw != null) {
            this.eRw.aXe();
        }
        if (this.eSq != null) {
            this.eSq.dismiss();
        }
        if (this.czb != null) {
            this.czb.dismiss();
        }
    }

    public void cw(List<String> list) {
        this.eTJ = list;
        if (this.eTK != null) {
            this.eTK.setData(list);
        }
    }

    public void iy(boolean z) {
        this.eSp.iy(z);
    }

    public void hb(boolean z) {
        this.dWE = z;
    }

    public void aUH() {
        if (this.eSz != null) {
            this.eSz.dismiss();
        }
        if (this.eSA != null) {
            com.baidu.adp.lib.g.g.b(this.eSA, this.eMh.getPageContext());
        }
        if (this.eSB != null) {
            com.baidu.adp.lib.g.g.b(this.eSB, this.eMh.getPageContext());
        }
        if (this.eSx != null) {
            com.baidu.adp.lib.g.g.b(this.eSx, this.eMh.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eOk, this.eHQ);
            d(this.eOk, this.eHQ, this.mType);
            this.eMh.getLayoutMode().ag(i == 1);
            this.eMh.getLayoutMode().t(this.ckd);
            this.eMh.getLayoutMode().t(this.eRI);
            this.eMh.getLayoutMode().t(this.eRJ);
            this.eMh.getLayoutMode().t(this.eRG);
            if (this.eRY != null) {
                com.baidu.tbadk.core.util.aj.c(this.eRY, d.C0080d.cp_cont_d, 1);
            }
            if (this.eRX != null) {
                com.baidu.tbadk.core.util.aj.c(this.eRX, d.C0080d.cp_cont_d, 1);
            }
            if (this.eRw != null) {
                this.eRw.onChangeSkinType(i);
            }
            this.eMh.getLayoutMode().t(this.eRG);
            com.baidu.tbadk.core.util.aj.i(this.eRI, d.C0080d.cp_cont_b);
            this.eRI.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            this.eMh.getLayoutMode().t(this.aIs);
            if (this.eSq != null) {
                this.eSq.c(this.eMh.getPageContext());
            }
            jo(this.eSL);
            this.eSp.notifyDataSetChanged();
            if (this.eSt != null) {
                this.eSt.dz(i);
            }
            if (this.cCw != null) {
                this.cCw.dz(i);
                com.baidu.tbadk.core.util.aj.j(this.aIs, d.f.pb_foot_more_trans_selector);
                this.cCw.dw(d.f.pb_foot_more_trans_selector);
            }
            if (this.Jb != null) {
                this.Jb.onChangeSkinType(i);
            }
            if (this.eRZ != null) {
                this.eRZ.dE(i);
            }
            if (this.eSu != null) {
                this.eSu.dz(i);
            }
            if (this.eRF != null && this.eRF.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eRF) {
                    aVar.aVR();
                }
            }
            jk(i == 1);
            aUi();
            UtilHelper.setStatusBarBackground(this.czo, i);
            UtilHelper.setStatusBarBackground(this.eTi, i);
            if (this.eSb != null) {
                this.eSb.onChangeSkinType(i);
            }
            if (this.eSg != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSg, d.C0080d.cp_cont_j);
            }
            if (this.eSf != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSf, d.C0080d.cp_cont_j);
            }
            if (this.eSh != null) {
                com.baidu.tbadk.core.util.aj.j(this.eSh, d.C0080d.cp_cont_e);
            }
            if (this.eRQ != null) {
                com.baidu.tbadk.core.util.aj.i(this.eRQ, d.C0080d.cp_link_tip_a);
            }
            if (this.eSe != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSe, d.C0080d.cp_cont_j);
            }
            if (this.eSi != null) {
                com.baidu.tbadk.o.a.a(this.eMh.getPageContext(), this.eSi);
            }
            if (this.eSH != null) {
                com.baidu.tbadk.o.a.a(this.eMh.getPageContext(), this.eSH);
            }
            if (this.eTy != null) {
                this.eTy.onChangeSkinType(i);
            }
            if (this.eRA != null) {
                if (this.eRv != null) {
                    this.eRv.qa(i);
                } else {
                    this.eRA.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aj.i(this.eRO, d.C0080d.cp_cont_j);
            if (this.eRP != null) {
                com.baidu.tbadk.core.util.aj.j(this.eRP, d.C0080d.cp_cont_e);
            }
            this.mSkinType = i;
            if (this.eSQ != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSQ, d.C0080d.cp_cont_e);
            }
            if (this.eRR != null) {
                com.baidu.tbadk.core.util.aj.c(this.eRR, BitmapHelper.getGradeResourceIdInEnterForum(this.eTG));
            }
            this.eTL.onChangeSkinType(i);
            if (this.eTo != null) {
                this.eTo.onChangeSkinType();
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSv = fVar;
        this.eSp.setOnImageClickListener(this.aSv);
        this.eTL.setOnImageClickListener(this.aSv);
    }

    public void h(NoNetworkView.a aVar) {
        this.cvR = aVar;
        if (this.ckb != null) {
            this.ckb.a(this.cvR);
        }
    }

    public void jq(boolean z) {
        this.eSp.setIsFromCDN(z);
    }

    public Button aUI() {
        return this.eSO;
    }

    public void aUJ() {
        if (this.eRz != 2) {
            this.eRE.setNextPage(this.cCw);
            this.eRz = 2;
        }
    }

    public void aUK() {
        if (com.baidu.tbadk.l.r.Gi().Gj()) {
            int lastVisiblePosition = this.eRE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eRE.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.ft(1001);
                                perfLog.aJA = true;
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
                        com.baidu.tbadk.l.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.ft(1001);
                        perfLog2.aJA = true;
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

    public boolean aUL() {
        return this.Jb != null && this.Jb.getVisibility() == 0;
    }

    public void hc(boolean z) {
        if (this.eSP != null) {
            if (this.dWE) {
                hd(z);
            } else {
                he(z);
            }
        }
    }

    public void aUM() {
        if (this.eSP != null) {
            this.eSP.setVisibility(8);
            this.eSU = false;
            if (this.eTo != null) {
                this.eTo.setVisibility(8);
                jm(false);
            }
            aVb();
        }
    }

    public void showLoadingDialog() {
        if (this.cbh == null) {
            this.cbh = new com.baidu.tbadk.core.view.a(this.eMh.getPageContext());
        }
        this.cbh.aE(true);
    }

    public void VG() {
        if (this.cbh != null) {
            this.cbh.aE(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eRE.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eRE.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eRv != null) {
            this.eRv.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.emZ = getScrollY();
            this.eTn.eUu = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTn));
            a(this.eTn.eUu, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.eRv != null) {
            this.eRv.b(absListView, i);
        }
        int headerViewsCount = (i - this.eRE.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.eSp.pA(headerViewsCount) != com.baidu.tieba.pb.data.l.eGV) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eSp.aSm().j(z, this.eTg != null ? this.eTg.getMeasuredHeight() : 0);
        this.eTn.eUs = i;
        this.eTn.eUt = this.eRE.getHeaderViewsCount();
        this.eTn.eUu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTn));
        a(this.eTn.eUu, false);
    }

    public void aUN() {
        if (this.eMh.isLogin()) {
            if ((this.eTz == null || !this.eTz.aTO()) && this.eOk != null && this.eTD && !this.eTC && !this.eSM && this.eSY != null && this.eSY.rt() != null && !this.eSY.rt().getIsLike() && !this.eSY.rt().hadConcerned()) {
                if (this.eTz == null) {
                    this.eTz = new ak(this.eMh);
                }
                this.eTz.a(this.eRA.eYz, this.eOk.aQm(), this.eSY.rt().getUserId(), this.eOk.getThreadId());
            }
        }
    }

    public void aUO() {
        if (this.eTD && !this.eTC && this.eSY != null && this.eSY.rt() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eMh.getPageContext().getPageActivity(), this.eSY.rt().getUserId(), this.eSY.rt().getUserName(), this.eMh.aQS().aSy(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ai aiVar, boolean z) {
        int measuredHeight;
        if (!this.eTC && this.eTh != null && this.eRA.aVU() != null) {
            int aSj = this.eSp.aSj();
            if (aSj > 0 && (aiVar == null || aiVar.getView().getParent() == null)) {
                if (aSj > this.eRE.getFirstVisiblePosition() - this.eRE.getHeaderViewsCount()) {
                    this.eTh.setVisibility(8);
                    return;
                }
                this.eTh.setVisibility(0);
                this.eRA.mNavigationBar.hideBottomLine();
            } else if (aiVar != null && aiVar.getView() != null && aiVar.eQX != null) {
                int top = aiVar.getView().getTop();
                if (aiVar.getView().getParent() != null) {
                    if (this.eTm) {
                        this.eTl = top;
                        this.eTm = false;
                    }
                    this.eTl = top < this.eTl ? top : this.eTl;
                }
                if (top != 0 || aiVar.getView().isShown()) {
                    if (this.eSo.getY() < 0.0f) {
                        measuredHeight = eTk - aiVar.eQX.getMeasuredHeight();
                    } else {
                        measuredHeight = this.eRA.aVU().getMeasuredHeight() - aiVar.eQX.getMeasuredHeight();
                        this.eRA.mNavigationBar.hideBottomLine();
                    }
                    if (aiVar.getView().getParent() == null && top <= this.eTl) {
                        this.eTh.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.eTh.setVisibility(0);
                    } else {
                        this.eTh.setVisibility(8);
                        this.eRA.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.eTm = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eUs;
        public int eUt;
        public ai eUu;

        public a() {
        }
    }

    public void aUP() {
        if (!this.eUe) {
            TiebaStatic.log("c10490");
            this.eUe = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eMh.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eTr, Integer.valueOf(eTt));
            aVar.cb(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.eMh);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eMh.getPageContext()).th();
        }
    }

    public void pA(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eMh.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eTr, Integer.valueOf(eTu));
        aVar.z(sparseArray);
        aVar.a(d.j.view, this.eMh);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eMh.getPageContext()).th();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.rt() != null) {
            MetaData rt = b.rt();
            rt.setGiftNum(rt.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        q(fVar);
    }

    public PbInterviewStatusView aUQ() {
        return this.eTd;
    }

    private void s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPO() != null && fVar.aPO().sn() && this.eTd == null) {
            this.eTd = (PbInterviewStatusView) this.eTc.inflate();
            this.eTd.setOnClickListener(this.czc);
            this.eTd.setCallback(this.eMh.aRQ());
            this.eTd.c(this.eMh, fVar);
        }
    }

    public LinearLayout aUR() {
        return this.eSo;
    }

    public View aUS() {
        return this.czo;
    }

    public boolean aUT() {
        return this.eTP;
    }

    public void iF(boolean z) {
        this.eRK.iF(z);
    }

    private void aUU() {
        if (this.eTP) {
            if (this.eTQ == null) {
                e.a aVar = e.eJI.get();
                if (aVar != null) {
                    this.eTQ = aVar.a(this.eMh);
                    ListAdapter adapter = this.eRE.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axk) {
                            this.eRE.addHeaderView(this.eTQ.aRc(), 1);
                        } else {
                            this.eRE.addHeaderView(this.eTQ.aRc(), 0);
                        }
                    }
                } else {
                    this.eRJ.setVisibility(0);
                    return;
                }
            }
            this.eRJ.setVisibility(8);
            this.eRE.removeHeaderView(this.eRJ);
            return;
        }
        this.eRJ.setVisibility(0);
    }

    public void jr(boolean z) {
        this.eTP = z;
    }

    public void aUV() {
        this.eMh.showNetRefreshView(getView(), "");
        View EA = this.eMh.getRefreshView().EA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EA.getLayoutParams();
        layoutParams.addRule(3, aUR().getId());
        EA.setLayoutParams(layoutParams);
        this.eMh.hideLoadingView(getView());
        if (this.eTQ != null) {
            this.eRE.removeHeaderView(this.eTQ.aRc());
            this.eTQ = null;
        }
    }

    public void pB(String str) {
        if (this.eRB != null) {
            this.eRB.setTitle(str);
        }
    }

    private int js(boolean z) {
        if (this.eTd == null || this.eTd.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void aUW() {
        if (this.eTd != null && this.eTd.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTd.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eTd.setLayoutParams(layoutParams);
        }
    }

    public boolean aRl() {
        return false;
    }

    public TextView aUX() {
        return this.eRY;
    }

    public void pC(String str) {
        this.eSQ.performClick();
        if (!StringUtils.isNull(str) && this.eMh.aRf() != null && this.eMh.aRf().Di() != null && this.eMh.aRf().Di().Da() != null) {
            EditText Da = this.eMh.aRf().Di().Da();
            Da.setText(str);
            Da.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aEQ();
            aUM();
            aTT();
            if (this.eTy != null) {
                this.eTy.aSr();
            }
            this.eMh.ajl();
            this.eSo.setVisibility(8);
            this.eRA.setTitleVisibility(false);
            this.eMh.iL(false);
            if (this.eRv != null) {
                if (configuration.orientation == 1) {
                    aUR().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eRE.setIsLandscape(true);
                    this.eRE.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eRE.setIsLandscape(false);
                    if (this.emZ > 0) {
                        this.eRE.smoothScrollBy(this.emZ, 0);
                    }
                }
                this.eRv.onConfigurationChanged(configuration);
            }
        }
    }

    public void jt(boolean z) {
        this.eRy = z;
    }

    public boolean aUY() {
        return this.eRv != null && this.eRv.aUY();
    }

    public void aUZ() {
        if (this.eRv != null) {
            this.eRv.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.eRw != null) {
            this.eRw.y(j, i);
        }
        if (this.eRv != null) {
            this.eRv.y(j, i);
        }
    }

    public void iQ(boolean z) {
        this.eSp.iQ(z);
    }

    public void aVa() {
        if (this.eTe == null) {
            LayoutInflater.from(this.eMh.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.ckd, true);
            this.eTe = (ViewGroup) this.ckd.findViewById(d.g.add_experienced_layout);
            this.eTf = (TextView) this.ckd.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.eTf, d.C0080d.cp_cont_i);
            String string = this.eMh.getResources().getString(d.j.experienced_add_success);
            String string2 = this.eMh.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_h)));
            this.eTf.setText(spannableString);
        }
        this.eTe.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ap.31.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ap.this.eTe.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ap.this.eTf.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eTf.startAnimation(scaleAnimation);
    }

    public void bo(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.eSP.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eMh);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            TextView textView = new TextView(this.eMh);
            textView.setText(d.j.connection_tips);
            textView.setGravity(17);
            textView.setPadding(com.baidu.adp.lib.util.l.f(this.eMh, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.eMh, d.e.ds24), 0);
            com.baidu.tbadk.core.util.aj.i(textView, d.C0080d.cp_cont_n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eMh, d.e.ds60);
            frameLayout.addView(textView, layoutParams);
            this.eTI = new PopupWindow(this.eMh);
            this.eTI.setContentView(frameLayout);
            this.eTI.setHeight(-2);
            this.eTI.setWidth(-2);
            this.eTI.setFocusable(true);
            this.eTI.setOutsideTouchable(false);
            this.eTI.setBackgroundDrawable(new ColorDrawable(this.eMh.getResources().getColor(d.C0080d.transparent)));
            this.eRE.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.32
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.eTI.showAsDropDown(ap.this.eSP, view.getLeft(), -ap.this.eSP.getHeight());
                    } else {
                        ap.this.eTI.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aVr() != null && !StringUtils.isNull(aVar.aVr().pkg_id) && !StringUtils.isNull(aVar.aVr().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.eSR != null && this.eSR.getVisibility() == 0) {
            if (this.eTH == null) {
                View inflate = LayoutInflater.from(this.eMh.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.czc);
                this.eTH = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.eSR.getLocationInWindow(iArr);
            this.eTH.showAtLocation(this.eSR, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.eSR.getHeight()) - com.baidu.adp.lib.util.l.f(this.eMh.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aVb() {
        com.baidu.adp.lib.g.g.a(this.eTH);
    }

    public void setIsInterviewLive(boolean z) {
        this.eTN = z;
    }

    public boolean getIsInterviewLive() {
        return this.eTN;
    }

    public void bp(View view) {
        this.eSH = view;
    }
}
