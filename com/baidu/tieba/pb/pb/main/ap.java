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
    private static final int eTF = UtilHelper.getLightStatusBarHeight();
    public static int eTL = 3;
    public static int eTM = 0;
    public static int eTN = 3;
    public static int eTO = 4;
    public static int eTP = 5;
    public static int eTQ = 6;
    private com.baidu.tbadk.editortools.i Jb;
    private View aIA;
    private com.baidu.tieba.pb.a.c aSE;
    private g.b amy;
    private TextView axs;
    private View bYw;
    private PbListView cCP;
    private NoNetworkView cks;
    private RelativeLayout cku;
    private View czH;
    private View.OnClickListener czv;
    private View.OnClickListener eIo;
    PbActivity.d eLL;
    private PbActivity eMB;
    private UserIconBox eNF;
    private UserIconBox eNG;
    private com.baidu.tieba.pb.data.f eOE;
    private PbFakeFloorModel eOc;
    public int eRO;
    private com.baidu.tieba.pb.video.i eRP;
    private long eRQ;
    private com.baidu.tieba.pb.video.h eRR;
    private com.baidu.tieba.d.a eRS;
    public final com.baidu.tieba.pb.pb.main.view.c eRV;
    public com.baidu.tieba.pb.pb.main.view.b eRW;
    private ViewStub eRX;
    private ViewStub eRY;
    private PbLandscapeListView eRZ;
    private TextView eSA;
    private TextView eSB;
    private View eSC;
    private LinearLayout eSD;
    private TextView eSE;
    private TextView eSF;
    private View eSG;
    private View eSH;
    private ObservedChangeLinearLayout eSJ;
    private h eSK;
    private View eSQ;
    private List<com.baidu.tieba.pb.pb.main.view.a> eSa;
    private View eSb;
    private LinearLayout eSe;
    private f eSf;
    private ColumnLayout eSg;
    private ThreadSkinView eSh;
    private TextView eSi;
    private TextView eSj;
    private View eSk;
    private TextView eSl;
    private ImageView eSm;
    private HeadPendantView eSn;
    private FrameLayout eSo;
    private HeadImageView eSp;
    private View eSq;
    private FloatingLayout eSr;
    private PbFirstFloorUserLikeButton eSw;
    private an eSx;
    private an eSy;
    private TextView eSz;
    private TextView eTA;
    private FrameLayout eTB;
    private View eTC;
    private View eTD;
    private ai eTE;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eTJ;
    private int eTR;
    private Runnable eTS;
    private s eTT;
    private ak eTU;
    private View eTk;
    private TextView eTl;
    private ImageView eTm;
    private ImageView eTn;
    private TextView eTo;
    private boolean eTq;
    private int eTr;
    private int eTs;
    private PostData eTt;
    private View eTv;
    private TextView eTw;
    private ViewStub eTx;
    private PbInterviewStatusView eTy;
    private ViewGroup eTz;
    private int eUa;
    private PopupWindow eUc;
    private PopupWindow eUd;
    private List<String> eUe;
    private com.baidu.tieba.pb.pb.main.emotion.c eUf;
    private com.baidu.tieba.pb.pb.godreply.a eUg;
    private PbLandscapeListView.b eUh;
    private boolean eUk;
    private e eUl;
    private com.baidu.tbadk.core.view.userLike.c eUm;
    private com.baidu.tbadk.core.view.userLike.c eUn;
    private Runnable eUs;
    private PbActivity.b eUu;
    private int ene;
    private boolean isLandscape;
    private int mType;
    private boolean eRT = false;
    private int eRU = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout eSc = null;
    private TextView eSd = null;
    private TextView eSs = null;
    private TextView eSt = null;
    public FrsPraiseView eSu = null;
    private ClickableHeaderImageView eSv = null;
    private View eSI = null;
    private com.baidu.tbadk.core.dialog.a eSL = null;
    private com.baidu.tbadk.core.dialog.b czu = null;
    private View eSM = null;
    private EditText eSN = null;
    private com.baidu.tieba.pb.view.i eSO = null;
    private com.baidu.tieba.pb.view.b eSP = null;
    private com.baidu.tbadk.core.dialog.a eSR = null;
    private b.InterfaceC0047b dFE = null;
    private TbRichTextView.f aSD = null;
    private NoNetworkView.a cwk = null;
    private Dialog eSS = null;
    private View eST = null;
    private com.baidu.tbadk.core.dialog.a eSU = null;
    private Dialog eSV = null;
    private Dialog eSW = null;
    private View eSX = null;
    private LinearLayout eSY = null;
    private CompoundButton.OnCheckedChangeListener eSZ = null;
    private TextView eTa = null;
    private TextView eTb = null;
    private View eTc = null;
    private String eTd = null;
    private com.baidu.tbadk.core.dialog.b eTe = null;
    private com.baidu.tbadk.core.dialog.b eTf = null;
    private boolean eTg = false;
    private boolean eTh = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eTi = null;
    private boolean dWI = false;
    private Button eTj = null;
    private boolean eTp = true;
    private com.baidu.tbadk.core.view.a cbu = null;
    private boolean eIk = false;
    private int mSkinType = 3;
    private boolean eTu = false;
    private int eTG = 0;
    private boolean eTH = true;
    private a eTI = new a();
    private int eTK = 0;
    private boolean eTV = false;
    private int eTW = 0;
    private boolean eTX = false;
    private boolean eTY = false;
    private boolean eTZ = false;
    private int eUb = 0;
    private boolean eUi = false;
    private a.InterfaceC0127a eUj = new a.InterfaceC0127a() { // from class: com.baidu.tieba.pb.pb.main.ap.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0127a
        public void kW() {
        }
    };
    private final CustomMessageListener eUo = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_IMG_TO_EMOTION_CONNECTION_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.ap.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921305) {
                ap.this.aUj();
            }
        }
    };
    private String eUp = null;
    private CustomMessageListener eUq = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.eUp = null;
            }
        }
    };
    private CustomMessageListener cNG = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.eSK != null) {
                ap.this.eSK.notifyDataSetChanged();
            }
        }
    };
    private Handler eUr = new Handler();
    private CustomMessageListener eUt = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.eTp = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eUv = true;
    View.OnClickListener eUw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ap.this.eTX) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == ap.this.eRV.eYU) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (ap.this.eMB.eKN.eYc != null) {
                if (!ap.this.eTX && ap.this.eOE != null && ap.this.eOE.aPW() != null && ap.this.eOE.aPW().rt() != null && ap.this.eOE.aPW().rt().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                ap.this.eMB.eKN.eYc.onClick(view);
            }
        }
    };
    private boolean eUx = false;
    String userId = null;
    private final List<TbImageView> eUy = new ArrayList();
    private boolean eUz = false;

    public void jo(boolean z) {
        this.eTV = z;
        if (this.eRZ != null) {
            this.eTW = this.eRZ.getHeaderViewsCount();
        }
    }

    public void aTY() {
        if (this.eRZ != null) {
            int headerViewsCount = this.eRZ.getHeaderViewsCount() - this.eTW;
            final int firstVisiblePosition = (this.eRZ.getFirstVisiblePosition() == 0 || this.eRZ.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.eRZ.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.eRZ.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.eTI.eUP = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTI));
            final ai aiVar = this.eTI.eUP;
            final int d = d(aiVar);
            final int y = ((int) this.eSJ.getY()) + this.eSJ.getMeasuredHeight();
            final boolean z = this.eTC.getVisibility() == 0;
            boolean z2 = this.eSJ.getY() < 0.0f;
            if ((z && aiVar != null) || firstVisiblePosition >= this.eSK.aSr() + this.eRZ.getHeaderViewsCount()) {
                int measuredHeight = aiVar != null ? aiVar.eRr.getMeasuredHeight() : 0;
                if (z2) {
                    this.eRZ.setSelectionFromTop(this.eSK.aSr() + this.eRZ.getHeaderViewsCount(), eTF - measuredHeight);
                } else {
                    this.eRZ.setSelectionFromTop(this.eSK.aSr() + this.eRZ.getHeaderViewsCount(), this.eRV.aWc().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.eRZ.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.eTX) {
                this.eRZ.setSelectionFromTop(this.eSK.aSr() + this.eRZ.getHeaderViewsCount(), this.eRP.aXt().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.eRZ.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aSD() {
                        if (d >= 0 && d <= ap.this.cku.getMeasuredHeight()) {
                            int d2 = ap.this.d(aiVar);
                            int i = d2 - d;
                            if (z && i != 0 && d <= y) {
                                i = d2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ap.this.bYw.getLayoutParams();
                            if (i == 0 || i > ap.this.cku.getMeasuredHeight() || d2 >= ap.this.cku.getMeasuredHeight()) {
                                layoutParams.height = ap.this.eTR;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.cku.getMeasuredHeight()) {
                                layoutParams.height = ap.this.eTR;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ap.this.eRZ.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ap.this.bYw.setLayoutParams(layoutParams);
                        }
                        ap.this.eRZ.setOnLayoutListener(null);
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

    public e aTZ() {
        return this.eUl;
    }

    public NoNetworkView aUa() {
        return this.cks;
    }

    public void aUb() {
        if (this.Jb != null) {
            this.Jb.hide();
            if (this.eUf != null) {
                this.eUf.afH();
            }
        }
    }

    public PbFakeFloorModel aUc() {
        return this.eOc;
    }

    public s aUd() {
        return this.eTT;
    }

    public void aUe() {
        reset();
        aUb();
        this.eTT.aSz();
        hi(false);
    }

    private void reset() {
        if (this.eMB != null && this.eMB.aRn() != null && this.Jb != null) {
            com.baidu.tbadk.editortools.pb.a.Dp().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aRn = this.eMB.aRn();
            aRn.DK();
            if (aRn.getWriteImagesInfo() != null) {
                aRn.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aRn.eX(10);
            aRn.eV(SendView.ALL);
            aRn.eW(SendView.ALL);
            com.baidu.tbadk.editortools.l eM = this.Jb.eM(23);
            com.baidu.tbadk.editortools.l eM2 = this.Jb.eM(2);
            com.baidu.tbadk.editortools.l eM3 = this.Jb.eM(5);
            if (eM2 != null) {
                eM2.lG();
            }
            if (eM3 != null) {
                eM3.lG();
            }
            if (eM != null) {
                eM.hide();
            }
            this.Jb.invalidate();
        }
    }

    public boolean aUf() {
        return this.eTp;
    }

    public void hj(boolean z) {
        if (this.eTk != null && this.eTl != null) {
            this.eTl.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eTk.startAnimation(alphaAnimation);
            }
            this.eTk.setVisibility(0);
            this.eTp = true;
            if (this.eTJ != null && !this.eUg.isActive()) {
                this.eTJ.setVisibility(0);
                js(true);
            }
        }
    }

    public void hk(boolean z) {
        if (this.eTk != null && this.eTl != null) {
            this.eTl.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eTk.startAnimation(alphaAnimation);
            }
            this.eTk.setVisibility(0);
            this.eTp = true;
            if (this.eTJ != null && !this.eUg.isActive()) {
                this.eTJ.setVisibility(0);
                js(true);
            }
        }
    }

    public PostData aUg() {
        int i = 0;
        if (this.eRZ == null) {
            return null;
        }
        int aUh = aUh() - this.eRZ.getHeaderViewsCount();
        if (aUh < 0) {
            aUh = 0;
        }
        if (this.eSK.pB(aUh) != null && this.eSK.pB(aUh) != PostData.gqm) {
            i = aUh + 1;
        }
        return this.eSK.getItem(i) instanceof PostData ? (PostData) this.eSK.getItem(i) : null;
    }

    public int aUh() {
        int i;
        View childAt;
        if (this.eRZ == null) {
            return 0;
        }
        int firstVisiblePosition = this.eRZ.getFirstVisiblePosition();
        int lastVisiblePosition = this.eRZ.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eRZ.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.eRZ.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aUi() {
        return this.eRZ.getHeaderViewsCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUj() {
        if (this.eSR == null) {
            this.eSR = new com.baidu.tbadk.core.dialog.a(this.eMB);
            this.eSR.cc(d.j.img_to_emotion_tip);
            this.eSR.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.33
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.editortools.pb.d aRn = ap.this.eMB.aRn();
                    if (aRn.getWriteImagesInfo() != null) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) ap.this.eMB, aRn.getWriteImagesInfo().toJsonString(), true, true);
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
            this.eSR.a(d.j.go_to_add, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.34
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ap.this.eMB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(ap.this.eMB.getPageContext().getPageActivity())));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL));
                    if (ap.this.eMB.checkUpIsLogin()) {
                        if (ap.this.Jb != null) {
                            ap.this.aUt();
                            ap.this.Jb.L((View) ap.this.Jb.eM(5));
                        }
                        if (ap.this.Jb != null) {
                            ap.this.eTp = false;
                            com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMB, (View) ap.this.Jb.eO(2).aBn, false, ap.this.eUj);
                        }
                        ap.this.aUU();
                        aVar.dismiss();
                    }
                }
            });
            this.eSR.b(this.eMB.getPageContext());
        }
        this.eSR.th();
    }

    public void e(TbRichText tbRichText) {
        PostData postData;
        if (this.eOE != null && this.eOE.aPY() != null && !this.eOE.aPY().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.eOE.aPY().size() && (postData = this.eOE.aPY().get(i)) != null && postData.rt() != null && !StringUtils.isNull(postData.rt().getUserId()); i++) {
                if (this.eOE.aPY().get(i).rt().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.eUg != null && this.eUg.isActive()) {
                        hi(false);
                    }
                    if (this.eTJ != null) {
                        this.eTJ.jE(true);
                    }
                    this.eUp = postData.rt().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eMB = null;
        this.cku = null;
        this.czH = null;
        this.eRQ = 0L;
        this.eRZ = null;
        this.eSb = null;
        this.eSe = null;
        this.eSg = null;
        this.eSi = null;
        this.eSk = null;
        this.eSl = null;
        this.eSo = null;
        this.eSp = null;
        this.eSq = null;
        this.eSw = null;
        this.eSz = null;
        this.eSA = null;
        this.eSB = null;
        this.eSC = null;
        this.eSG = null;
        this.eSH = null;
        this.eSK = null;
        this.cCP = null;
        this.aIA = null;
        this.czv = null;
        this.eIo = null;
        this.eTk = null;
        this.eTl = null;
        this.eTm = null;
        this.eTn = null;
        this.eTo = null;
        this.eTv = null;
        this.eTw = null;
        this.eTx = null;
        this.eUa = 0;
        this.eRQ = System.currentTimeMillis();
        this.eMB = pbActivity;
        this.czv = onClickListener;
        this.aSE = cVar;
        this.eUa = com.baidu.adp.lib.util.l.ac(this.eMB) - com.baidu.adp.lib.util.l.f(this.eMB, d.e.ds200);
        this.cku = (RelativeLayout) LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.eMB.addContentView(this.cku, new FrameLayout.LayoutParams(-1, -1));
        this.czH = this.eMB.findViewById(d.g.statebar_view);
        this.eSJ = (ObservedChangeLinearLayout) this.eMB.findViewById(d.g.title_wrapper);
        this.cks = (NoNetworkView) this.eMB.findViewById(d.g.view_no_network);
        this.eRZ = (PbLandscapeListView) this.eMB.findViewById(d.g.new_pb_list);
        this.eTB = (FrameLayout) this.eMB.findViewById(d.g.root_float_header);
        this.axs = new TextView(this.eMB.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds88));
        this.eRZ.addHeaderView(this.axs, 0);
        this.eTR = this.eMB.getResources().getDimensionPixelSize(d.e.ds100);
        this.bYw = new View(this.eMB.getPageContext().getPageActivity());
        this.bYw.setLayoutParams(new AbsListView.LayoutParams(-1, this.eTR));
        this.bYw.setVisibility(4);
        this.eRZ.addFooterView(this.bYw);
        this.eRZ.setOnTouchListener(this.eMB.aMI);
        this.eRV = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eMB.aRP()) {
            this.eRX = (ViewStub) this.eMB.findViewById(d.g.manga_view_stub);
            this.eRX.setVisibility(0);
            this.eRW = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.eRW.show();
            this.eRV.mNavigationBar.setVisibility(8);
            layoutParams.height -= eTF;
        }
        this.axs.setLayoutParams(layoutParams);
        this.eRV.aWc().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.main.ap.36
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0109a
            public void akl() {
                if (ap.this.eRZ != null) {
                    if (ap.this.eRP != null) {
                        ap.this.eRP.aXu();
                    }
                    ap.this.eRZ.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0109a
            public void akk() {
                ap.this.eMB.ajz();
            }
        }));
        this.eTk = this.eMB.findViewById(d.g.pb_editor_tool_comment);
        this.eTr = com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds90);
        this.eTs = com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds242);
        this.eTl = (TextView) this.eMB.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.eTn = (ImageView) this.eMB.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.eTm = (ImageView) this.eMB.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.eTo = (TextView) this.eMB.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.eTo.setVisibility(8);
        this.eTl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.aVj();
                if (!ap.this.eMB.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, ap.this.mForumId));
                    return;
                }
                if (ap.this.Jb != null) {
                    ap.this.aUt();
                }
                if (ap.this.Jb != null) {
                    ap.this.eTp = false;
                    com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMB, (View) ap.this.Jb.eO(2).aBn, false, ap.this.eUj);
                }
                ap.this.aUU();
            }
        });
        this.eTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.aVj();
                if (ap.this.eMB.checkUpIsLogin()) {
                    if (ap.this.Jb != null) {
                        ap.this.aUt();
                        ap.this.Jb.L((View) ap.this.Jb.eM(5));
                    }
                    if (ap.this.Jb != null) {
                        ap.this.eTp = false;
                        com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMB, (View) ap.this.Jb.eO(2).aBn, false, ap.this.eUj);
                    }
                    ap.this.aUU();
                }
            }
        });
        this.eTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.aVj();
                if (ap.this.eMB.checkUpIsLogin()) {
                    if (ap.this.Jb != null) {
                        ap.this.aUt();
                        ap.this.Jb.L((View) ap.this.Jb.eM(2));
                    }
                    if (ap.this.Jb != null) {
                        ap.this.eTp = false;
                        com.baidu.tieba.tbadkCore.b.a.a(ap.this.eMB, (View) ap.this.Jb.eO(2).aBn, false, ap.this.eUj);
                    }
                    ap.this.aUU();
                }
            }
        });
        this.eTo.setOnClickListener(this.czv);
        this.eTo.setOnTouchListener(this.eMB);
        this.eSb = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.eSe = (LinearLayout) LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.eSf = new f(this.eMB, this.eSe);
        this.eSf.init();
        this.eSf.a(this.eSf.aRm(), this.czv);
        this.eSg = (ColumnLayout) this.eSe.findViewById(d.g.pb_head_owner_root);
        this.eSh = (ThreadSkinView) this.eSe.findViewById(d.g.pb_thread_skin);
        this.eSg.setOnLongClickListener(this.onLongClickListener);
        this.eSg.setOnTouchListener(this.aSE);
        this.eSg.setVisibility(8);
        this.eSb.setOnTouchListener(this.aSE);
        this.eTv = this.eSb.findViewById(d.g.pb_head_activity_join_number_container);
        this.eTv.setVisibility(8);
        this.eTw = (TextView) this.eSb.findViewById(d.g.pb_head_activity_join_number);
        this.eSi = (TextView) this.eSg.findViewById(d.g.pb_head_owner_info_user_name);
        this.eSj = (TextView) this.eSe.findViewById(d.g.pb_head_owner_info_user_intro);
        this.eSk = this.eSe.findViewById(d.g.line_right_user_intro);
        this.eSl = (TextView) this.eSg.findViewById(d.g.floor_owner);
        this.eSm = (ImageView) this.eSg.findViewById(d.g.icon_forum_level);
        this.eSo = (FrameLayout) this.eSg.findViewById(d.g.pb_head_headImage_container);
        this.eSp = (HeadImageView) this.eSg.findViewById(d.g.pb_head_owner_photo);
        this.eSn = (HeadPendantView) this.eSg.findViewById(d.g.pb_pendant_head_owner_photo);
        this.eSn.wg();
        if (this.eSn.getHeadView() != null) {
            this.eSn.getHeadView().setIsRound(true);
            this.eSn.getHeadView().setDrawBorder(false);
        }
        if (this.eSn.getPendantView() != null) {
            this.eSn.getPendantView().setIsRound(true);
            this.eSn.getPendantView().setDrawBorder(false);
        }
        this.eNF = (UserIconBox) this.eSg.findViewById(d.g.show_icon_vip);
        this.eNG = (UserIconBox) this.eSg.findViewById(d.g.show_icon_yinji);
        this.eSr = (FloatingLayout) this.eSe.findViewById(d.g.pb_head_owner_info_root);
        this.eSw = (PbFirstFloorUserLikeButton) this.eSg.findViewById(d.g.pb_like_button);
        this.eSz = (TextView) this.eSg.findViewById(d.g.pb_views);
        this.eSA = (TextView) this.eSg.findViewById(d.g.pb_item_first_floor_reply_time);
        this.eSB = (TextView) this.eSg.findViewById(d.g.pb_item_first_floor_location_address);
        this.eSC = this.eSg.findViewById(d.g.line_between_time_and_locate);
        this.eUm = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eUn = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eSG = this.eSb.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.eSH = this.eSb.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.eSb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.eTx = (ViewStub) this.cku.findViewById(d.g.interview_status_stub);
        this.eSK = new h(this.eMB, this.eRZ);
        this.eSK.q(this.czv);
        this.eSK.setTbGestureDetector(this.aSE);
        this.eSK.setOnImageClickListener(this.aSD);
        this.eIo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.ZF() || !com.baidu.tieba.c.a.a(ap.this.eMB.getBaseContext(), ap.this.eMB.aRa().aSH(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ap.this.eMB.c(sparseArray);
                                return;
                            }
                            ap.this.bo(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ap.this.eMB.c(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eSK.D(this.eIo);
        aUo();
        this.eRZ.addHeaderView(this.eSc);
        this.eRZ.addHeaderView(this.eSe);
        this.eRZ.addHeaderView(this.eSb);
        this.cCP = new PbListView(this.eMB.getPageContext().getPageActivity());
        this.aIA = this.cCP.getView().findViewById(d.g.pb_more_view);
        if (this.aIA != null) {
            this.aIA.setOnClickListener(this.czv);
            com.baidu.tbadk.core.util.aj.j(this.aIA, d.f.pb_foot_more_trans_selector);
        }
        this.cCP.wp();
        this.cCP.dv(d.f.pb_foot_more_trans_selector);
        this.cCP.dx(d.f.pb_foot_more_trans_selector);
        this.eSQ = this.eMB.findViewById(d.g.viewstub_progress);
        this.eMB.registerListener(this.eUt);
        this.eSq = com.baidu.tbadk.ala.b.nu().g(this.eMB.getActivity(), 2);
        if (this.eSq != null) {
            this.eSq.setVisibility(8);
            this.eSr.addView(this.eSq);
        }
        this.eOc = new PbFakeFloorModel(this.eMB.getPageContext());
        this.eTT = new s(this.eMB.getPageContext(), this.eOc, this.cku);
        this.eTT.a(this.eMB.eLG);
        this.eOc.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ap.this.eOc.m(postData);
                ap.this.eSK.notifyDataSetChanged();
                ap.this.eTT.aSz();
                ap.this.Jb.Bc();
                ap.this.hi(false);
            }
        });
        if (this.eMB.aRa() != null && !StringUtils.isNull(this.eMB.aRa().aTm())) {
            this.eMB.showToast(this.eMB.aRa().aTm());
        }
        this.eTC = this.eMB.findViewById(d.g.pb_expand_blank_view);
        this.eTD = this.eMB.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eTD.getLayoutParams();
        if (this.eMB.aRa() != null && this.eMB.aRa().aSK()) {
            this.eTC.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.eTD.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = eTF;
            this.eTD.setLayoutParams(layoutParams2);
        }
        this.eTE = new ai(this.eMB.getPageContext(), this.eMB.findViewById(d.g.pb_reply_expand_view));
        this.eTE.eRr.setVisibility(8);
        this.eTE.E(this.czv);
        this.eMB.registerListener(this.cNG);
        this.eMB.registerListener(this.eUo);
        this.eMB.registerListener(this.eUq);
        aUk();
        js(false);
    }

    private void aUk() {
        this.eUg = new com.baidu.tieba.pb.pb.godreply.a(this.eMB, this, (ViewStub) this.cku.findViewById(d.g.more_god_reply_popup));
        this.eUg.setCommonClickListener(this.czv);
        this.eUg.D(this.eIo);
        this.eUg.setOnImageClickListener(this.aSD);
        this.eUg.setCommonClickListener(this.czv);
        this.eUg.setTbGestureDetector(this.aSE);
    }

    public com.baidu.tieba.pb.pb.godreply.a aUl() {
        return this.eUg;
    }

    public View aUm() {
        return this.eTC;
    }

    public void aUn() {
        if (this.eRZ != null) {
            this.eRZ.removeHeaderView(this.eSc);
            this.eRZ.removeHeaderView(this.eSe);
            this.eRZ.removeHeaderView(this.eSb);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eTJ == null) {
            this.eTJ = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eMB.getPageContext().getPageActivity());
            js(true);
            this.eTJ.a(this.cku, aVar, this.eTk.getVisibility() == 0);
            this.eTJ.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ap.6
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ap.this.eUp)) {
                        emotionImageData.setAuthorNameShow(ap.this.eUp);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    ap.this.eMB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(ap.this.eMB.getPageContext().getPageActivity(), 25016, str, list, ap.this.eUp, list2)));
                }
            });
            this.eTJ.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.ap.7
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void onMove(float f) {
                    ap.this.aVj();
                    if (ap.this.eTk != null) {
                        ViewGroup.LayoutParams layoutParams = ap.this.eTk.getLayoutParams();
                        layoutParams.height = (int) (((ap.this.eTs - ap.this.eTr) * f) + ap.this.eTr);
                        ap.this.eTl.setAlpha(1.0f - f);
                        ap.this.eTn.setAlpha(1.0f - f);
                        ap.this.eTm.setAlpha(1.0f - f);
                        ap.this.eTk.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aUo() {
        if (this.eSc == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds34);
            this.eSc = new LinearLayout(this.eMB.getPageContext().getPageActivity());
            this.eSc.setOrientation(1);
            this.eSc.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eSc.setPadding(f, com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds40), f, com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds46));
            this.eSc.setGravity(17);
            this.eSd = new TextView(this.eMB.getPageContext().getPageActivity());
            this.eSd.setGravity(3);
            this.eSd.setMaxLines(2);
            this.eSd.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            this.eSd.setPadding(0, 0, 0, 0);
            this.eSd.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds12), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.eSd, d.C0080d.cp_cont_b);
            this.eSd.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds48));
            this.eSd.setVisibility(8);
            this.eSc.addView(this.eSd);
            this.eSc.setOnTouchListener(this.aSE);
            this.eSc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUp() {
        if (this.eMB.aRP()) {
            this.eRY = (ViewStub) this.eMB.findViewById(d.g.manga_mention_controller_view_stub);
            this.eRY.setVisibility(0);
            if (this.eSD == null) {
                this.eSD = (LinearLayout) this.eMB.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eMB.getPageContext(), this.eSD);
            }
            if (this.eSE == null) {
                this.eSE = (TextView) this.eSD.findViewById(d.g.manga_prev_btn);
            }
            if (this.eSF == null) {
                this.eSF = (TextView) this.eSD.findViewById(d.g.manga_next_btn);
            }
            this.eSE.setOnClickListener(this.czv);
            this.eSF.setOnClickListener(this.czv);
        }
    }

    private void aUq() {
        if (this.eMB.aRP()) {
            if (this.eMB.aRS() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eSE, d.C0080d.cp_cont_e, 1);
            }
            if (this.eMB.aRT() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eSF, d.C0080d.cp_cont_e, 1);
            }
        }
    }

    public void aUr() {
        if (this.eSD == null) {
            aUp();
        }
        this.eRY.setVisibility(8);
        if (this.eUr != null && this.eUs != null) {
            this.eUr.removeCallbacks(this.eUs);
        }
    }

    public void aUs() {
        if (this.eUr != null) {
            if (this.eUs != null) {
                this.eUr.removeCallbacks(this.eUs);
            }
            this.eUs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.eSD == null) {
                        ap.this.aUp();
                    }
                    ap.this.eRY.setVisibility(0);
                }
            };
            this.eUr.postDelayed(this.eUs, 2000L);
        }
    }

    public void jp(boolean z) {
        this.eRV.jp(z);
        if (z && this.eTu) {
            this.cCP.setText(this.eMB.getResources().getString(d.j.click_load_more));
            this.eRZ.setNextPage(this.cCP);
            this.eRU = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Jb = iVar;
        this.Jb.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cku.addView(this.Jb, layoutParams);
        this.Jb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aUb();
        this.eMB.aRn().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.Jb != null && ap.this.Jb.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.eUf == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.Jb.getId());
                            ap.this.eUf = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.eMB.getPageContext(), ap.this.cku, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.v(ap.this.eUe)) {
                                ap.this.eUf.setData(ap.this.eUe);
                            }
                            ap.this.eUf.b(ap.this.Jb);
                        }
                        ap.this.eUf.pM(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.eMB.eKR != null && ap.this.eMB.eKR.aVm() != null) {
                    if (!ap.this.eMB.eKR.aVm().bCs()) {
                        ap.this.eMB.eKR.jA(false);
                    }
                    ap.this.eMB.eKR.aVm().nr(false);
                }
            }
        });
    }

    public void aUt() {
        if (this.eMB != null && this.Jb != null) {
            this.Jb.lG();
            aUU();
        }
    }

    public void P(String str, boolean z) {
        this.eTq = z;
        jq(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void jq(boolean z) {
        if (this.eTo != null) {
            if (this.eTq) {
                com.baidu.tbadk.core.util.aj.j(this.eTo, d.f.pb_praise_already_click_selector);
                this.eTo.setContentDescription(this.eMB.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.eTo, d.f.pb_praise_normal_click_selector);
            this.eTo.setContentDescription(this.eMB.getResources().getString(d.j.zan));
        }
    }

    public TextView aUu() {
        return this.eTo;
    }

    public void jr(boolean z) {
        if (this.eRZ != null && this.axs != null && this.czH != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.czH.setVisibility(0);
                } else {
                    this.czH.setVisibility(8);
                    this.eRZ.removeHeaderView(this.axs);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = eTF;
                    this.axs.setLayoutParams(layoutParams);
                }
                aUJ();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axs.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jy(true);
                this.axs.setLayoutParams(layoutParams2);
            }
            aUJ();
            aVe();
        }
    }

    public h aUv() {
        return this.eSK;
    }

    public void a(PbActivity.d dVar) {
        this.eLL = dVar;
    }

    public void bo(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eST == null) {
            this.eST = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eMB.getLayoutMode().t(this.eST);
        if (this.eSS == null) {
            this.eSS = new Dialog(this.eMB.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.eSS.setCanceledOnTouchOutside(true);
            this.eSS.setCancelable(true);
            this.eSS.setContentView(this.eST);
            WindowManager.LayoutParams attributes = this.eSS.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ac(this.eMB.getPageContext().getPageActivity()) * 0.9d);
            this.eSS.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eSS.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.eSS.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.eSS.findViewById(d.g.disable_reply_btn);
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
                    if (ap.this.eSS != null && (ap.this.eSS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSS, ap.this.eMB.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ap.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || aVb()) {
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
                    if (ap.this.eSS != null && (ap.this.eSS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSS, ap.this.eMB.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ap.this.eUu != null) {
                        ap.this.eUu.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (ap.this.eSS != null && (ap.this.eSS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSS, ap.this.eMB.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ap.this.eMB.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eSS, this.eMB.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.eUu = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eTM, Integer.valueOf(eTN));
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
        this.eSU = new com.baidu.tbadk.core.dialog.a(this.eMB.getActivity());
        this.eSU.cc(i3);
        this.eSU.z(sparseArray);
        this.eSU.a(d.j.dialog_ok, this.eMB);
        this.eSU.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eSU.ao(true);
        this.eSU.b(this.eMB.getPageContext());
        this.eSU.th();
    }

    public void aj(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eSX == null) {
            this.eSX = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.eMB.getLayoutMode().t(this.eSX);
        if (this.eSW == null) {
            this.eSW = new Dialog(this.eMB.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.eSW.setCanceledOnTouchOutside(true);
            this.eSW.setCancelable(true);
            this.eTi = (ScrollView) this.eSX.findViewById(d.g.good_scroll);
            this.eSW.setContentView(this.eSX);
            WindowManager.LayoutParams attributes = this.eSW.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds540);
            this.eSW.getWindow().setAttributes(attributes);
            this.eSZ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.eTd = (String) compoundButton.getTag();
                        if (ap.this.eSa != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ap.this.eSa) {
                                String str = (String) aVar.getTag();
                                if (str != null && ap.this.eTd != null && !str.equals(ap.this.eTd)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eSY = (LinearLayout) this.eSX.findViewById(d.g.good_class_group);
            this.eTb = (TextView) this.eSX.findViewById(d.g.dialog_button_cancel);
            this.eTb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.eSW instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ap.this.eSW, ap.this.eMB.getPageContext());
                    }
                }
            });
            this.eTa = (TextView) this.eSX.findViewById(d.g.dialog_button_ok);
            this.eTa.setOnClickListener(this.czv);
        }
        this.eSY.removeAllViews();
        this.eSa = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bE = bE("0", this.eMB.getPageContext().getString(d.j.def_good_class));
        this.eSa.add(bE);
        bE.setChecked(true);
        this.eSY.addView(bE);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bE2 = bE(String.valueOf(arrayList.get(i2).pV()), arrayList.get(i2).pU());
                this.eSa.add(bE2);
                View view = new View(this.eMB.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.C0080d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eSY.addView(view);
                this.eSY.addView(bE2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eTi.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eMB.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eMB.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eMB.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eTi.setLayoutParams(layoutParams2);
            this.eTi.removeAllViews();
            this.eTi.addView(this.eSY);
        }
        com.baidu.adp.lib.g.g.a(this.eSW, this.eMB.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bE(String str, String str2) {
        Activity pageActivity = this.eMB.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.eSZ);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aUw() {
        this.eMB.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eMB.hideProgressBar();
        if (z && z2) {
            this.eMB.showToast(this.eMB.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.eMB.showToast(str);
        }
    }

    public void azN() {
        this.eSQ.setVisibility(0);
    }

    public void azM() {
        this.eSQ.setVisibility(8);
    }

    public View aUx() {
        if (this.eSX != null) {
            return this.eSX.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String aUy() {
        return this.eTd;
    }

    public View getView() {
        return this.cku;
    }

    public void aUz() {
        com.baidu.adp.lib.util.l.a(this.eMB.getPageContext().getPageActivity(), this.eMB.getCurrentFocus());
    }

    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.eMB.hideProgressBar();
        if (z) {
            aEU();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            aUO();
        } else {
            aEU();
        }
    }

    public void aUA() {
        this.cCP.wp();
        this.cCP.wt();
    }

    public void aUB() {
        this.eMB.hideProgressBar();
        wu();
        this.eRZ.completePullRefreshPostDelayed(2000L);
        aUL();
    }

    public void aUC() {
        this.eRZ.completePullRefreshPostDelayed(2000L);
        aUL();
    }

    private void js(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eTl.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eMB.getResources().getDimensionPixelSize(d.e.ds130) : this.eMB.getResources().getDimensionPixelSize(d.e.ds34);
        this.eTl.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eSK.setOnLongClickListener(onLongClickListener);
        if (this.eUg != null) {
            this.eUg.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z, boolean z2) {
        if (this.eTe != null) {
            this.eTe.dismiss();
            this.eTe = null;
        }
        this.eTe = new com.baidu.tbadk.core.dialog.b(this.eMB.getPageContext().getPageActivity());
        this.eTe.cf(d.j.operation);
        if (z2) {
            this.eTe.a(new String[]{this.eMB.getPageContext().getString(d.j.copy)}, interfaceC0047b);
        } else if (!z) {
            this.eTe.a(new String[]{this.eMB.getPageContext().getString(d.j.copy), this.eMB.getPageContext().getString(d.j.mark)}, interfaceC0047b);
        } else {
            this.eTe.a(new String[]{this.eMB.getPageContext().getString(d.j.copy), this.eMB.getPageContext().getString(d.j.remove_mark)}, interfaceC0047b);
        }
        this.eTe.d(this.eMB.getPageContext());
        this.eTe.tl();
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z) {
        if (this.eTf != null) {
            this.eTf.dismiss();
            this.eTf = null;
        }
        this.eTf = new com.baidu.tbadk.core.dialog.b(this.eMB.getPageContext().getPageActivity());
        this.eTf.cf(d.j.operation);
        if (z) {
            this.eTf.a(new String[]{this.eMB.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0047b);
        } else {
            this.eTf.a(new String[]{this.eMB.getPageContext().getString(d.j.save_to_emotion), this.eMB.getPageContext().getString(d.j.save_to_local)}, interfaceC0047b);
        }
        this.eTf.d(this.eMB.getPageContext());
        this.eTf.tl();
    }

    public int aUD() {
        return pO(this.eRZ.getFirstVisiblePosition());
    }

    private int pO(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eRZ.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eRZ.getAdapter() == null || !(this.eRZ.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eRZ.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aUE() {
        int lastVisiblePosition = this.eRZ.getLastVisiblePosition();
        if (this.eRP != null) {
            if (lastVisiblePosition == this.eRZ.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pO(lastVisiblePosition);
    }

    public void pP(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.eRZ != null) {
            if (this.eRV == null || this.eRV.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.eRV.mNavigationBar.getFixedNavHeight();
                boolean isUseStyleImmersiveSticky = this.eMB.isUseStyleImmersiveSticky();
                boolean z = this.eMB.aRC() != -1;
                if (isUseStyleImmersiveSticky) {
                    fixedNavHeight -= eTF;
                }
                if (z) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.eTD != null && (layoutParams = (LinearLayout.LayoutParams) this.eTD.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.eTD.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.eRZ.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.eRZ.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eSN.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        this.eSK.a(fVar, false);
        this.eSK.notifyDataSetChanged();
        aUL();
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (this.eSu == null) {
            this.eMB.getLayoutMode().t(((ViewStub) this.eSb.findViewById(d.g.praise_layout)).inflate());
            this.eSu = (FrsPraiseView) this.eSb.findViewById(d.g.pb_head_praise_view);
            this.eSu.setIsFromPb(true);
            this.eSI = this.eSb.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.eSu.dD(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eSu != null) {
            boolean aUL = aUL();
            this.eSu.setVisibility(8);
            if (fVar != null && fVar.qv() != null && fVar.qv().qs() == 0 && this.eIk) {
                if (aUL) {
                    this.eSH.setVisibility(0);
                    return;
                } else {
                    this.eSH.setVisibility(8);
                    return;
                }
            }
            this.eSH.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aQf() != null) {
            return fVar.aQf();
        }
        if (!com.baidu.tbadk.core.util.v.v(fVar.aPY())) {
            Iterator<PostData> it = fVar.aPY().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.buG() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aQd();
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
        if (fVar == null || fVar.aPW() == null || fVar.aPW().rt() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rt = fVar.aPW().rt();
        String userId = rt.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPW().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rt;
        }
        postData.tV(1);
        postData.setId(fVar.aPW().rK());
        postData.setTitle(fVar.aPW().getTitle());
        postData.setTime(fVar.aPW().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0555 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0386  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String e;
        ArrayList<IconData> tShowInfoNew;
        int f;
        com.baidu.tbadk.data.i buJ;
        String portrait;
        if (fVar != null && fVar.aPW() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aVc();
            this.eSg.setVisibility(8);
            if (fVar.aPW() != null && fVar.aPW().sh() && fVar.aPW().rL() != null) {
                this.eTX = true;
                this.eRV.jL(this.eTX);
                this.eRV.mNavigationBar.hideBottomLine();
                if (this.eRP == null) {
                    this.eRP = new com.baidu.tieba.pb.video.i(this.eMB, this.eRV, fVar.aPW().rL(), this.eRQ);
                    this.eRP.a(fVar.aPW().rL(), fVar.aPW(), fVar.getForumId());
                    this.eRP.startPlay();
                } else if (this.eRT) {
                    this.eRP.a(fVar.aPW().rL(), fVar.aPW(), fVar.getForumId());
                    this.eRP.startPlay();
                } else {
                    this.eRP.pZ(fVar.getForumId());
                }
                if (fVar.aPX() != null && fVar.aPX().size() >= 1) {
                    bh bhVar = fVar.aPX().get(0);
                    this.eRP.ac(bhVar);
                    this.eRP.qa(bhVar.getTitle());
                }
                this.eRP.b(b, fVar.aPW(), fVar.aQs());
                this.eRT = false;
                this.eRZ.removeHeaderView(this.eRP.aXv());
                this.eRZ.addHeaderView(this.eRP.aXv(), 0);
                if (this.eRP.aXt() != null && this.eRP.aXt().getParent() == null) {
                    this.eTB.addView(this.eRP.aXt());
                }
                if (this.eRR == null) {
                    this.eRR = new com.baidu.tieba.pb.video.h(this.eMB);
                }
                this.eRR.a(fVar.aPW().sz(), fVar.aPW(), fVar.aQp());
                this.eRZ.removeHeaderView(this.eRR.aXk());
                this.eRZ.addHeaderView(this.eRR.aXk(), 1);
                if (fVar.aPW().sz() != null) {
                    this.eRZ.removeHeaderView(this.eRR.aXl());
                    this.eRZ.removeHeaderView(this.eSe);
                    this.eRZ.addHeaderView(this.eRR.aXl(), 2);
                } else {
                    if (this.eRR.aXl() != null) {
                        this.eRZ.removeHeaderView(this.eRR.aXl());
                    }
                    this.eRZ.removeHeaderView(this.eSe);
                    this.eRZ.addHeaderView(this.eSe, 2);
                }
                if (this.eRP != null) {
                    this.eRV.jH(false);
                    this.eRV.jI(TbadkCoreApplication.isLogin());
                    this.eRP.qb(0);
                }
                aUJ();
            } else {
                this.eTX = false;
                this.eRV.jL(this.eTX);
                if (this.eRP != null) {
                    this.eRZ.removeHeaderView(this.eRP.aXv());
                }
                if (this.eRR != null) {
                    this.eRR.f(this.eRZ);
                }
            }
            if (this.eMB.aRr() != null) {
                this.eMB.aRr().jF(this.eTX);
            }
            if (this.eRP != null) {
                this.eRP.G(this.eUw);
            }
            if (b != null) {
                this.eTt = b;
                this.eSg.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eSg.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eSg.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.eUk) {
                    this.eSc.setVisibility(0);
                }
                if (!fVar.aPW().sh() && this.eSd.getText() != null && this.eSd.getText().length() > 0) {
                    this.eSd.setVisibility(0);
                } else {
                    this.eSd.setVisibility(8);
                }
                p(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rF = fVar.aPW().rF();
                if (rF != null && rF.size() > 0 && !this.eUk) {
                    this.eTw.setText(String.valueOf(rF.get(0).pm()));
                    this.eTv.setVisibility(0);
                } else {
                    this.eTv.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.eTv, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.eTw, d.C0080d.cp_link_tip_d, 1);
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
                            if (this.eNG != null) {
                                this.eNG.setTag(d.g.tag_user_id, b.rt().getUserId());
                                this.eNG.setOnClickListener(this.eMB.eKN.cJk);
                                this.eNG.a(iconInfo, i3, this.eMB.getResources().getDimensionPixelSize(d.e.ds26), this.eMB.getResources().getDimensionPixelSize(d.e.ds26), this.eMB.getResources().getDimensionPixelSize(d.e.ds8));
                            }
                            if (this.eNF != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eNF.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eNF.setOnClickListener(this.eMB.eKN.eYd);
                                this.eNF.a(tShowInfoNew, 3, this.eMB.getResources().getDimensionPixelSize(d.e.ds36), this.eMB.getResources().getDimensionPixelSize(d.e.ds36), this.eMB.getResources().getDimensionPixelSize(d.e.ds8), true);
                            }
                            this.eSi.setText(ag(b.rt().getSealPrefix(), e));
                            this.eSi.setTag(d.g.tag_user_id, b.rt().getUserId());
                            this.eSi.setTag(d.g.tag_user_name, b.rt().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew) || b.rt().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_cont_f, 1);
                            }
                            if (b == null && !TextUtils.isEmpty(b.rt().getGodIntro())) {
                                this.eSj.setVisibility(0);
                                this.eSj.setText(ao.c(b.rt()));
                                this.eSk.setVisibility(0);
                            } else {
                                this.eSj.setVisibility(8);
                                this.eSk.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eSl, d.C0080d.cp_link_tip_a, 1);
                            this.eSl.setVisibility(0);
                            if (fVar.aPW().rt() != null && fVar.aPW().rt().getAlaUserData() != null && this.eSq != null) {
                                if (fVar.aPW().rt().getAlaUserData().anchor_live != 0) {
                                    this.eSq.setVisibility(8);
                                } else {
                                    this.eSq.setVisibility(0);
                                    if (this.eRS == null) {
                                        this.eRS = new com.baidu.tieba.d.a(this.eMB.getPageContext(), this.eSq);
                                        this.eRS.iw(1);
                                    }
                                    this.eRS.aI(this.eMB.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.QK = fVar.aPW().rt().getAlaUserData();
                                    aVar.type = 2;
                                    this.eSq.setTag(aVar);
                                }
                            }
                            this.eSp.setUserId(b.rt().getUserId());
                            this.eSp.setUserName(b.rt().getUserName());
                            this.eSp.setImageDrawable(null);
                            this.eSp.setRadius(com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds40));
                            this.eSp.setTag(b.rt().getUserId());
                            this.eSA.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds8);
                            if (this.eSj == null && this.eSj.getVisibility() == 0) {
                                this.eSA.setPadding(f, 0, f, 0);
                            } else {
                                this.eSA.setPadding(0, 0, f, 0);
                            }
                            buJ = b.buJ();
                            if (buJ == null && !TextUtils.isEmpty(buJ.getName()) && !TextUtils.isEmpty(buJ.getName().trim())) {
                                final String name = buJ.getName();
                                final String lat = buJ.getLat();
                                final String lng = buJ.getLng();
                                this.eSB.setVisibility(0);
                                this.eSC.setVisibility(0);
                                this.eSB.setText(buJ.getName());
                                this.eSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                ap.this.eMB.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(ap.this.eMB.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ap.this.eMB.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.eSB.setVisibility(8);
                                this.eSC.setVisibility(8);
                            }
                            portrait = b.rt().getPortrait();
                            if (b.rt().getPendantData() == null && !StringUtils.isNull(b.rt().getPendantData().pQ())) {
                                UtilHelper.showHeadImageViewBigV(this.eSn.getHeadView(), b.rt());
                                this.eSp.setVisibility(8);
                                this.eSn.setVisibility(0);
                                if (this.eSv != null) {
                                    this.eSv.setVisibility(8);
                                }
                                this.eSi.setOnClickListener(this.eUw);
                                this.eSn.getHeadView().startLoad(portrait, 28, false);
                                this.eSn.getHeadView().setUserId(b.rt().getUserId());
                                this.eSn.getHeadView().setUserName(b.rt().getUserName());
                                this.eSn.getHeadView().setOnClickListener(this.eUw);
                                this.eSn.en(b.rt().getPendantData().pQ());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eSp, b.rt());
                                this.eSp.setVisibility(0);
                                this.eSg.setOnClickListener(this.eUw);
                                this.eSi.setOnClickListener(this.eUw);
                                this.eSp.setOnClickListener(this.eUw);
                                this.eSn.setVisibility(8);
                                this.eSp.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rt().getName_show();
                            String userName = b.rt().getUserName();
                            if (com.baidu.tbadk.p.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.eSi.setText(com.baidu.tieba.pb.c.al(this.eMB.getPageContext().getPageActivity(), this.eSi.getText().toString()));
                                this.eSi.setGravity(16);
                                this.eSi.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPy());
                                com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = b.rt().getIconInfo();
                        tShowInfoNew = b.rt().getTShowInfoNew();
                        if (this.eNG != null) {
                        }
                        if (this.eNF != null) {
                        }
                        this.eSi.setText(ag(b.rt().getSealPrefix(), e));
                        this.eSi.setTag(d.g.tag_user_id, b.rt().getUserId());
                        this.eSi.setTag(d.g.tag_user_name, b.rt().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eSj.setVisibility(8);
                        this.eSk.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eSl, d.C0080d.cp_link_tip_a, 1);
                        this.eSl.setVisibility(0);
                        if (fVar.aPW().rt() != null) {
                            if (fVar.aPW().rt().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eSp.setUserId(b.rt().getUserId());
                        this.eSp.setUserName(b.rt().getUserName());
                        this.eSp.setImageDrawable(null);
                        this.eSp.setRadius(com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds40));
                        this.eSp.setTag(b.rt().getUserId());
                        this.eSA.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds8);
                        if (this.eSj == null) {
                        }
                        this.eSA.setPadding(0, 0, f, 0);
                        buJ = b.buJ();
                        if (buJ == null) {
                        }
                        this.eSB.setVisibility(8);
                        this.eSC.setVisibility(8);
                        portrait = b.rt().getPortrait();
                        if (b.rt().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eSp, b.rt());
                        this.eSp.setVisibility(0);
                        this.eSg.setOnClickListener(this.eUw);
                        this.eSi.setOnClickListener(this.eUw);
                        this.eSp.setOnClickListener(this.eUw);
                        this.eSn.setVisibility(8);
                        this.eSp.startLoad(portrait, 28, false);
                        String name_show2 = b.rt().getName_show();
                        String userName2 = b.rt().getUserName();
                        if (com.baidu.tbadk.p.ac.fS()) {
                            this.eSi.setText(com.baidu.tieba.pb.c.al(this.eMB.getPageContext().getPageActivity(), this.eSi.getText().toString()));
                            this.eSi.setGravity(16);
                            this.eSi.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPy());
                            com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = b.rt().getIconInfo();
                            tShowInfoNew = b.rt().getTShowInfoNew();
                            if (this.eNG != null) {
                            }
                            if (this.eNF != null) {
                            }
                            this.eSi.setText(ag(b.rt().getSealPrefix(), e));
                            this.eSi.setTag(d.g.tag_user_id, b.rt().getUserId());
                            this.eSi.setTag(d.g.tag_user_name, b.rt().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_cont_h, 1);
                            if (b == null) {
                            }
                            this.eSj.setVisibility(8);
                            this.eSk.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.c(this.eSl, d.C0080d.cp_link_tip_a, 1);
                            this.eSl.setVisibility(0);
                            if (fVar.aPW().rt() != null) {
                            }
                            this.eSp.setUserId(b.rt().getUserId());
                            this.eSp.setUserName(b.rt().getUserName());
                            this.eSp.setImageDrawable(null);
                            this.eSp.setRadius(com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds40));
                            this.eSp.setTag(b.rt().getUserId());
                            this.eSA.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            f = com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds8);
                            if (this.eSj == null) {
                            }
                            this.eSA.setPadding(0, 0, f, 0);
                            buJ = b.buJ();
                            if (buJ == null) {
                            }
                            this.eSB.setVisibility(8);
                            this.eSC.setVisibility(8);
                            portrait = b.rt().getPortrait();
                            if (b.rt().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eSp, b.rt());
                            this.eSp.setVisibility(0);
                            this.eSg.setOnClickListener(this.eUw);
                            this.eSi.setOnClickListener(this.eUw);
                            this.eSp.setOnClickListener(this.eUw);
                            this.eSn.setVisibility(8);
                            this.eSp.startLoad(portrait, 28, false);
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
                        if (this.eNG != null) {
                        }
                        if (this.eNF != null) {
                        }
                        this.eSi.setText(ag(b.rt().getSealPrefix(), e));
                        this.eSi.setTag(d.g.tag_user_id, b.rt().getUserId());
                        this.eSi.setTag(d.g.tag_user_name, b.rt().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eSi, d.C0080d.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eSj.setVisibility(8);
                        this.eSk.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eSl, d.C0080d.cp_link_tip_a, 1);
                        this.eSl.setVisibility(0);
                        if (fVar.aPW().rt() != null) {
                        }
                        this.eSp.setUserId(b.rt().getUserId());
                        this.eSp.setUserName(b.rt().getUserName());
                        this.eSp.setImageDrawable(null);
                        this.eSp.setRadius(com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds40));
                        this.eSp.setTag(b.rt().getUserId());
                        this.eSA.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                        f = com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.ds8);
                        if (this.eSj == null) {
                        }
                        this.eSA.setPadding(0, 0, f, 0);
                        buJ = b.buJ();
                        if (buJ == null) {
                        }
                        this.eSB.setVisibility(8);
                        this.eSC.setVisibility(8);
                        portrait = b.rt().getPortrait();
                        if (b.rt().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eSp, b.rt());
                        this.eSp.setVisibility(0);
                        this.eSg.setOnClickListener(this.eUw);
                        this.eSi.setOnClickListener(this.eUw);
                        this.eSp.setOnClickListener(this.eUw);
                        this.eSn.setVisibility(8);
                        this.eSp.startLoad(portrait, 28, false);
                        String name_show222 = b.rt().getName_show();
                        String userName222 = b.rt().getUserName();
                        if (com.baidu.tbadk.p.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eSf.V(fVar.aPW());
                }
                if (this.eTE != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eHi);
                    if (fVar != null && fVar.aPW() != null) {
                        jVar.eHk = fVar.aPW().rl();
                    }
                    jVar.aFk = !this.eIk;
                    jVar.eHm = this.eMB.aSc();
                    this.eTE.a(jVar);
                }
            }
        }
    }

    public void jt(boolean z) {
        if (z) {
            aUF();
        } else {
            aUG();
        }
        this.eTI.eUP = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTI));
        a(this.eTI.eUP, false);
    }

    public void aUF() {
        if (this.eRV != null && !this.eTZ) {
            this.eRV.jM(!StringUtils.isNull(this.eMB.aRz()));
            this.eTZ = true;
        }
    }

    public void aUG() {
        if (this.eRV != null) {
            this.eRV.aWi();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rP() != null) {
            this.eSh.a(this.eMB.getPageContext(), fVar.aPY().get(0).rP(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aPU().getId(), fVar.aPU().getName(), fVar.aPW().getId(), this.eMB.aRZ() ? "FRS" : null));
            this.eSg.setPadding(this.eSg.getPaddingLeft(), (int) this.eMB.getResources().getDimension(d.e.ds20), this.eSg.getPaddingRight(), this.eSg.getPaddingBottom());
            return;
        }
        this.eSh.a(null, null, null);
    }

    public void aUH() {
        if (this.eRP != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.eRP.aXu();
            this.eRZ.smoothScrollToPosition(0);
        }
    }

    public boolean aUI() {
        return this.eUx;
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
            this.eRV.aWg();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eRV.nx(eVar.forumName);
            }
            String string = this.eMB.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eMB.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.eMB.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.eMB.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eGy;
            this.eMB.showNetRefreshView(this.cku, format, null, this.eMB.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.22
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        av.vI().c(ap.this.eMB.getPageContext(), new String[]{str2});
                        ap.this.eMB.finish();
                        return;
                    }
                    ap.this.eMB.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aTP;
        Parcelable aTP2;
        String str;
        if (fVar != null) {
            this.eOE = fVar;
            this.mType = i;
            if (fVar.aPW() != null) {
                this.eTK = fVar.aPW().re();
                if (fVar.aPW().getAnchorLevel() != 0) {
                    this.eUx = true;
                }
                this.eTh = P(fVar.aPW());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            s(fVar);
            this.eTu = false;
            this.eIk = z;
            aUB();
            b(fVar, z, i);
            q(fVar);
            if (this.eMB.aRP()) {
                if (this.eSO == null) {
                    this.eSO = new com.baidu.tieba.pb.view.i(this.eMB.getPageContext());
                    this.eSO.kX();
                    this.eSO.a(this.amy);
                }
                this.eRZ.setPullRefresh(this.eSO);
                aUJ();
                if (this.eSO != null) {
                    this.eSO.dy(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qv().qs() == 0 && z) {
                this.eRZ.setPullRefresh(null);
            } else {
                if (this.eSO == null) {
                    this.eSO = new com.baidu.tieba.pb.view.i(this.eMB.getPageContext());
                    this.eSO.kX();
                    this.eSO.a(this.amy);
                }
                this.eRZ.setPullRefresh(this.eSO);
                aUJ();
                if (this.eSO != null) {
                    this.eSO.dy(TbadkCoreApplication.getInst().getSkinType());
                }
                VR();
            }
            aUL();
            this.eSK.iF(this.eIk);
            this.eSK.iG(false);
            this.eSK.iT(i == 5);
            this.eSK.iU(i == 6);
            this.eSK.iV(z2 && this.eUv);
            this.eSK.a(fVar, false);
            this.eSK.notifyDataSetChanged();
            if (this.eMB.aSd()) {
                if (fVar.aPV() != null) {
                    this.mForumName = fVar.aPV().getForumName();
                    this.mForumId = fVar.aPV().getForumId();
                }
                if (this.mForumName == null && this.eMB.aRa() != null && this.eMB.aRa().aSG() != null) {
                    this.mForumName = this.eMB.aRa().aSG();
                }
                this.eRV.nx(this.mForumName);
            } else {
                this.eRV.nx(null);
            }
            if (this.eMB.aSd()) {
                this.eUb = 0;
                PostData b = b(fVar, z);
                if (b != null && b.rt() != null) {
                    this.eUb = b.rt().getLevel_id();
                }
                if (this.eUb > 0) {
                    this.eSm.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.eSm, BitmapHelper.getGradeResourceIdInEnterForum(this.eUb));
                } else {
                    this.eSm.setVisibility(8);
                }
            } else {
                this.eSm.setVisibility(8);
            }
            if (fVar.aPW() != null && fVar.aPW().ri() != null) {
                if (fVar.aPW().ri().getNum() < 1) {
                    str = this.eMB.getResources().getString(d.j.zan);
                } else {
                    str = fVar.aPW().ri().getNum() + "";
                }
                if (this.eRO != -1) {
                    fVar.aPW().ri().setIsLike(this.eRO);
                }
                P(str, fVar.aPW().ri().getIsLike() == 1);
            }
            if (this.eMB.isLogin()) {
                this.eRZ.setNextPage(this.cCP);
                this.eRU = 2;
                VR();
            } else {
                this.eTu = true;
                if (fVar.qv().qr() == 1) {
                    if (this.eSP == null) {
                        this.eSP = new com.baidu.tieba.pb.view.b(this.eMB.getPageContext());
                    }
                    this.eRZ.setNextPage(this.eSP);
                } else {
                    this.eRZ.setNextPage(this.cCP);
                }
                this.eRU = 3;
            }
            ArrayList<PostData> aPY = fVar.aPY();
            if (fVar.qv().qr() == 0 || aPY == null || aPY.size() < fVar.qv().qq()) {
                if (com.baidu.tbadk.core.util.v.u(aPY) == 0 || (com.baidu.tbadk.core.util.v.u(aPY) == 1 && aPY.get(0) != null && aPY.get(0).buG() == 1)) {
                    this.cCP.setText(this.eMB.getResources().getString(d.j.list_no_more_new));
                    if (this.eMB.aRr() != null && !this.eMB.aRr().aVY()) {
                        this.eMB.aRr().showFloatingView();
                    }
                } else {
                    this.cCP.setText(this.eMB.getResources().getString(d.j.list_has_no_more));
                }
                if (this.eMB.aRP() && this.eRZ != null && this.eRZ.getData() != null && this.eRZ.getData().size() == 1 && (this.eRZ.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cCP.setText("");
                }
                aUR();
            } else if (z2) {
                if (this.eUv) {
                    wu();
                    if (fVar.qv().qr() != 0) {
                        this.cCP.setText(this.eMB.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.cCP.wp();
                    this.cCP.showLoading();
                }
            } else {
                this.cCP.wp();
                this.cCP.showLoading();
            }
            switch (i) {
                case 2:
                    this.eRZ.setSelection(i2 > 1 ? (((this.eRZ.getData() == null && fVar.aPY() == null) ? 0 : (this.eRZ.getData().size() - fVar.aPY().size()) + this.eRZ.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aTP2 = ag.aTO().aTP()) != null) {
                        this.eRZ.onRestoreInstanceState(aTP2);
                        if (com.baidu.tbadk.core.util.v.u(aPY) > 1 && fVar.qv().qr() > 0) {
                            this.cCP.wu();
                            this.cCP.setText(this.eMB.getString(d.j.pb_load_more_without_point));
                            this.cCP.wq();
                            break;
                        }
                    } else {
                        this.eRZ.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eUv = false;
                    break;
                case 5:
                    this.eRZ.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aTP = ag.aTO().aTP()) != null) {
                        this.eRZ.onRestoreInstanceState(aTP);
                        break;
                    } else {
                        this.eRZ.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.eRP != null && this.eRP.aXt() != null) {
                            if (this.eMB.isUseStyleImmersiveSticky()) {
                                this.eRZ.setSelectionFromTop((this.eSK.aSq() + this.eRZ.getHeaderViewsCount()) - 1, this.eRP.aXt().getHeight() - com.baidu.adp.lib.util.l.n(this.eMB.getPageContext().getPageActivity()));
                            } else {
                                this.eRZ.setSelectionFromTop((this.eSK.aSq() + this.eRZ.getHeaderViewsCount()) - 1, this.eRP.aXt().getHeight());
                            }
                        } else {
                            this.eRZ.setSelection(this.eSK.aSq() + this.eRZ.getHeaderViewsCount());
                        }
                    } else {
                        this.eRZ.setSelection(i2 > 0 ? ((this.eRZ.getData() == null && fVar.aPY() == null) ? 0 : (this.eRZ.getData().size() - fVar.aPY().size()) + this.eRZ.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cCP.wu();
                    this.cCP.setText(this.eMB.getString(d.j.pb_load_more_without_point));
                    this.cCP.wq();
                    break;
            }
            if (this.eTK == eTL && isHost()) {
                aUX();
            }
            if (this.eTV) {
                aTY();
                this.eTV = false;
                if (i3 == 0) {
                    jo(true);
                }
            }
            if (this.eRR != null) {
                this.eRR.ab(fVar.aPW());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aUJ() {
        if (this.eRP != null && this.eRP.aXt() != null) {
            this.eRZ.removeHeaderView(this.axs);
            if (this.mType != 1) {
                this.eRZ.removeHeaderView(this.eRP.aXv());
                this.eRZ.addHeaderView(this.eRP.aXv(), 0);
                return;
            }
            return;
        }
        if (this.eRP != null) {
            this.eRZ.removeHeaderView(this.eRP.aXv());
        }
        this.eRZ.removeHeaderView(this.axs);
        this.eRZ.addHeaderView(this.axs, 0);
    }

    public void ju(boolean z) {
        this.eTg = z;
    }

    public void wu() {
        if (this.cCP != null) {
            this.cCP.wq();
            this.cCP.wu();
        }
        VR();
    }

    public void Oo() {
        this.eRZ.setVisibility(0);
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.eTt != null && this.eTt.rt() != null && this.eRV != null) {
            this.eTY = com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !this.eTX;
            this.eRV.jH(this.eTY);
            if (this.eMB.aRr() != null) {
                this.eMB.aRr().jG(this.eTY);
            }
            aUK();
            if (this.eTY) {
                this.eRV.eYS.setVisibility(0);
                this.eSw.setVisibility(8);
                if (this.eTh) {
                    this.eRV.eYT.setVisibility(8);
                } else if (!PbNormalLikeButtonSwitchStatic.GN() || (this.eTt.rt().hadConcerned() && this.eTt.rt().getGodUserData() != null && this.eTt.rt().getGodUserData().getIsFromNetWork())) {
                    this.eRV.eYT.setVisibility(8);
                }
                if (this.eTD != null) {
                    this.eTD.setVisibility(8);
                }
                if (this.eSo != null) {
                    this.eSo.setVisibility(8);
                }
                if (this.eSv != null) {
                    this.eSv.setVisibility(8);
                }
                this.eRV.eYU.setUserId(this.eTt.rt().getUserId());
                this.eRV.eYU.setUserName(this.eTt.rt().getUserName());
                this.eRV.eYU.setImageDrawable(null);
                this.eRV.eYU.setTag(this.eTt.rt().getUserId());
                UtilHelper.showHeadImageViewBigV(this.eRV.eYU, this.eTt.rt());
                this.eRV.eYU.setVisibility(0);
                this.eRV.eYU.setOnClickListener(this.eUw);
                this.eRV.eYU.startLoad(this.eTt.rt().getPortrait(), 28, false);
                if (this.eUh == null) {
                    this.eUh = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ap.this.eUa) {
                                ap.this.aUW();
                            }
                        }
                    };
                }
                this.eRZ.setListViewDragListener(this.eUh);
                return;
            }
            if (this.eRV.eYS != null) {
                this.eRV.eYS.setVisibility(8);
            }
            if (this.eTD != null) {
                this.eTD.setVisibility(0);
            }
            if (this.eTh) {
                this.eSw.setVisibility(8);
                this.eSz.setVisibility(0);
                this.eSz.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aQr())));
            } else if (!PbNormalLikeButtonSwitchStatic.GN() || (this.eTt.rt().hadConcerned() && this.eTt.rt().getGodUserData() != null && this.eTt.rt().getGodUserData().getIsFromNetWork())) {
                this.eSw.setVisibility(8);
                this.eSz.setVisibility(8);
            } else {
                this.eSw.setVisibility(0);
                this.eSw.setTextSize(0, com.baidu.adp.lib.util.l.f(this.eMB.getActivity(), d.e.fontsize26));
                this.eSz.setVisibility(8);
            }
            this.eUh = null;
            this.eRZ.setListViewDragListener(null);
        }
    }

    private void aUK() {
        String threadId = this.eOE != null ? this.eOE.getThreadId() : "";
        if (this.eTY) {
            if (this.eSy == null) {
                this.eSy = new an(this.eMB.getPageContext(), this.eRV.eYT, 3);
                this.eSy.h(this.eMB.getUniqueId());
                this.eSy.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ap.25
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void aN(boolean z) {
                        if (ap.this.eMB != null && z) {
                            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                            if (i >= 2) {
                                com.baidu.adp.lib.util.l.showToast(ap.this.eMB, d.j.attention_success);
                                return;
                            }
                            ao.w(ap.this.eMB.getPageContext());
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                        }
                    }
                });
            }
            if (this.eTt != null && this.eTt.rt() != null) {
                this.eTt.rt().setIsLike(this.eTt.rt().hadConcerned());
                this.eSy.a(this.eTt.rt());
            }
            this.eSy.cD(threadId);
            this.eSy.eRL = this.eTX;
            if (this.eSx != null) {
                this.eSx.unRegisterListener(this.eMB.getUniqueId());
                return;
            }
            return;
        }
        if (this.eSx == null) {
            this.eSx = new an(this.eMB.getPageContext(), this.eSw, 1);
            this.eSx.h(this.eMB.getUniqueId());
            this.eSx.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aN(boolean z) {
                    if (ap.this.eMB != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ap.this.eMB, d.j.attention_success);
                            return;
                        }
                        ao.w(ap.this.eMB.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.eTt != null && this.eTt.rt() != null) {
            this.eTt.rt().setIsLike(this.eTt.rt().hadConcerned());
            this.eSx.a(this.eTt.rt());
            this.eSx.cD(threadId);
        }
        this.eSx.eRL = this.eTX;
        if (this.eSy != null) {
            this.eSy.unRegisterListener(this.eMB.getUniqueId());
        }
    }

    private boolean aUL() {
        boolean z;
        if (this.eTj != null && this.eTj.getVisibility() == 0) {
            if (this.eSG != null) {
                this.eSG.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eSG != null) {
                this.eSG.setVisibility(8);
            }
            z = false;
        }
        if ((this.eSI == null || this.eSI.getVisibility() == 8) && z && this.eIk) {
            this.eSH.setVisibility(0);
        } else {
            this.eSH.setVisibility(8);
        }
        return z;
    }

    private boolean r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPW() == null) {
            return false;
        }
        if (fVar.aPW().rq() == 1 || fVar.aPW().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aPW().rs() == null || fVar.aPW().rs().sV() == 0) || fVar.aPW().ro() == 1 || fVar.aPW().rp() == 1 || fVar.aPW().rZ() || fVar.aPW().sn() || fVar.aPW().sg() || fVar.aPW().rG() != null || fVar.aPW().so() || fVar.aPW().so() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aPW().getCategory()) || fVar.aPW().rx() || fVar.aPW().rw();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eMB.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eSc != null) {
                if (fVar.aPW() != null && fVar.aPW().rJ() == 0 && !fVar.aPW().sh() && !this.eUk) {
                    this.eSc.setVisibility(0);
                    if (fVar.aPW() != null) {
                        fVar.aPW().e(true, r(fVar));
                    }
                    SpannableStringBuilder rU = fVar.aPW().rU();
                    this.eSd.setOnTouchListener(new com.baidu.tieba.view.l(rU));
                    if (this.eUi) {
                        this.eSd.setText(fVar.aPW().getTitle());
                    } else {
                        this.eSd.setText(rU);
                    }
                    this.eSd.setVisibility(0);
                } else if (fVar.aPW().rJ() == 1) {
                    if (fVar.aPW() != null) {
                        fVar.aPW().e(true, r(fVar));
                        SpannableStringBuilder rU2 = fVar.aPW().rU();
                        if (rU2 == null || rU2.length() == 0) {
                            this.eSc.setVisibility(8);
                            this.eRZ.removeHeaderView(this.eSc);
                            if (fVar.aPW() != null && !fVar.aPW().sh()) {
                                this.eSg.setPadding(this.eSg.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds48), this.eSg.getPaddingRight(), this.eSg.getPaddingBottom());
                            }
                        } else {
                            this.eSc.setVisibility(0);
                            this.eSd.setOnTouchListener(new com.baidu.tieba.view.l(rU2));
                            this.eSd.setText(rU2);
                            this.eSd.setVisibility(0);
                        }
                    }
                } else {
                    this.eSc.setVisibility(8);
                    this.eRZ.removeHeaderView(this.eSc);
                    if (fVar.aPW() != null && fVar.aPW().sh()) {
                        this.eSg.setPadding(this.eSg.getPaddingLeft(), 0, this.eSg.getPaddingRight(), this.eSg.getPaddingBottom());
                    } else {
                        this.eSg.setPadding(this.eSg.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds48), this.eSg.getPaddingRight(), this.eSg.getPaddingBottom());
                    }
                }
            }
            this.eIk = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aUL();
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
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aQh()));
            sparseArray.put(d.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.rt() != null) {
                sparseArray.put(d.g.tag_forbid_user_name, b.rt().getUserName());
                sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aQh()));
            sparseArray.put(d.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIA;
    }

    public void pD(String str) {
        if (this.cCP != null) {
            this.cCP.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eRZ;
    }

    public int aUM() {
        return d.g.richText;
    }

    public TextView aRm() {
        return this.eSf.aRm();
    }

    public void d(BdListView.e eVar) {
        this.eRZ.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.amy = bVar;
        if (this.eSO != null) {
            this.eSO.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int qp = apVar.qp();
            int qm = apVar.qm();
            if (this.eSL != null) {
                this.eSL.th();
            } else {
                this.eSL = new com.baidu.tbadk.core.dialog.a(this.eMB.getPageContext().getPageActivity());
                this.eSM = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.eSL.v(this.eSM);
                this.eSL.a(d.j.dialog_ok, bVar);
                this.eSL.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.27
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.aEU();
                        aVar.dismiss();
                    }
                });
                this.eSL.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.eTS == null) {
                            ap.this.eTS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.eMB.HidenSoftKeyPad((InputMethodManager) ap.this.eMB.getSystemService("input_method"), ap.this.cku);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(ap.this.eTS, 150L);
                    }
                });
                this.eSL.b(this.eMB.getPageContext()).th();
            }
            this.eSN = (EditText) this.eSM.findViewById(d.g.input_page_number);
            this.eSN.setText("");
            TextView textView = (TextView) this.eSM.findViewById(d.g.current_page_number);
            if (qp <= 0) {
                qp = 1;
            }
            if (qm <= 0) {
                qm = 1;
            }
            textView.setText(MessageFormat.format(this.eMB.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(qp), Integer.valueOf(qm)));
            this.eMB.ShowSoftKeyPadDelay(this.eSN, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eRZ.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eMB.showToast(str);
    }

    public boolean jv(boolean z) {
        if (this.Jb == null || !this.Jb.CX()) {
            return false;
        }
        this.Jb.Bc();
        return true;
    }

    public void aUN() {
        if (this.eUy != null) {
            while (this.eUy.size() > 0) {
                TbImageView remove = this.eUy.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aUN();
        this.eSK.pC(1);
        if (this.eRP != null) {
            this.eRP.onPause();
        }
    }

    public void onResume() {
        this.eSK.pC(2);
        if (this.eRP != null) {
            this.eRP.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.eTU != null) {
            this.eTU.destroy();
        }
        if (this.eRS != null) {
            this.eRS.abQ();
        }
        if (this.eRR != null) {
            this.eRR.onDestroy();
        }
        this.eMB.hideProgressBar();
        if (this.cks != null && this.cwk != null) {
            this.cks.b(this.cwk);
        }
        aEU();
        wu();
        if (this.eTS != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eTS);
        }
        if (this.eSg != null && this.eSv != null) {
            this.eSg.removeView(this.eSo);
            this.eSv = null;
        }
        if (this.eTy != null) {
            this.eTy.clearStatus();
        }
        this.eUr = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eSK.pC(3);
        if (this.czH != null) {
            this.czH.setBackgroundDrawable(null);
        }
        if (this.eRP != null) {
            this.eRP.destroy();
        }
        if (this.eSK != null) {
            this.eSK.onDestory();
        }
        this.eRZ.setOnLayoutListener(null);
        if (this.eUf != null) {
            this.eUf.akY();
        }
        if (this.eTJ != null) {
            this.eTJ.onDestroy();
        }
        aVj();
    }

    public boolean pQ(int i) {
        if (this.eRP != null) {
            return this.eRP.jA(i);
        }
        return false;
    }

    public void aEU() {
        this.eRV.om();
        if (this.eRS != null) {
            this.eRS.abQ();
        }
        com.baidu.adp.lib.util.l.a(this.eMB.getPageContext().getPageActivity(), this.eSN);
        aUb();
        if (this.eTe != null) {
            this.eTe.dismiss();
        }
        aUP();
        if (this.eRR != null) {
            this.eRR.aXm();
        }
        if (this.eSL != null) {
            this.eSL.dismiss();
        }
        if (this.czu != null) {
            this.czu.dismiss();
        }
    }

    public void aUO() {
        this.eRV.om();
        if (this.eRS != null) {
            this.eRS.abQ();
        }
        if (this.eTe != null) {
            this.eTe.dismiss();
        }
        aUP();
        if (this.eRR != null) {
            this.eRR.aXm();
        }
        if (this.eSL != null) {
            this.eSL.dismiss();
        }
        if (this.czu != null) {
            this.czu.dismiss();
        }
    }

    public void cx(List<String> list) {
        this.eUe = list;
        if (this.eUf != null) {
            this.eUf.setData(list);
        }
    }

    public void iE(boolean z) {
        this.eSK.iE(z);
    }

    public void hh(boolean z) {
        this.dWI = z;
    }

    public void aUP() {
        if (this.eSU != null) {
            this.eSU.dismiss();
        }
        if (this.eSV != null) {
            com.baidu.adp.lib.g.g.b(this.eSV, this.eMB.getPageContext());
        }
        if (this.eSW != null) {
            com.baidu.adp.lib.g.g.b(this.eSW, this.eMB.getPageContext());
        }
        if (this.eSS != null) {
            com.baidu.adp.lib.g.g.b(this.eSS, this.eMB.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eOE, this.eIk);
            d(this.eOE, this.eIk, this.mType);
            this.eMB.getLayoutMode().ag(i == 1);
            this.eMB.getLayoutMode().t(this.cku);
            this.eMB.getLayoutMode().t(this.eSd);
            this.eMB.getLayoutMode().t(this.eSe);
            this.eMB.getLayoutMode().t(this.eSb);
            if (this.eSt != null) {
                com.baidu.tbadk.core.util.aj.c(this.eSt, d.C0080d.cp_cont_d, 1);
            }
            if (this.eSs != null) {
                com.baidu.tbadk.core.util.aj.c(this.eSs, d.C0080d.cp_cont_d, 1);
            }
            if (this.eRR != null) {
                this.eRR.onChangeSkinType(i);
            }
            this.eMB.getLayoutMode().t(this.eSb);
            com.baidu.tbadk.core.util.aj.i(this.eSd, d.C0080d.cp_cont_b);
            this.eSd.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            this.eMB.getLayoutMode().t(this.aIA);
            if (this.eSL != null) {
                this.eSL.c(this.eMB.getPageContext());
            }
            ju(this.eTg);
            this.eSK.notifyDataSetChanged();
            if (this.eSO != null) {
                this.eSO.dy(i);
            }
            if (this.cCP != null) {
                this.cCP.dy(i);
                com.baidu.tbadk.core.util.aj.j(this.aIA, d.f.pb_foot_more_trans_selector);
                this.cCP.dv(d.f.pb_foot_more_trans_selector);
            }
            if (this.Jb != null) {
                this.Jb.onChangeSkinType(i);
            }
            if (this.eSu != null) {
                this.eSu.dD(i);
            }
            if (this.eSP != null) {
                this.eSP.dy(i);
            }
            if (this.eSa != null && this.eSa.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eSa) {
                    aVar.aVZ();
                }
            }
            jq(i == 1);
            aUq();
            UtilHelper.setStatusBarBackground(this.czH, i);
            UtilHelper.setStatusBarBackground(this.eTD, i);
            if (this.eSw != null) {
                this.eSw.onChangeSkinType(i);
            }
            if (this.eSB != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSB, d.C0080d.cp_cont_j);
            }
            if (this.eSA != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSA, d.C0080d.cp_cont_j);
            }
            if (this.eSC != null) {
                com.baidu.tbadk.core.util.aj.j(this.eSC, d.C0080d.cp_cont_e);
            }
            if (this.eSl != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSl, d.C0080d.cp_link_tip_a);
            }
            if (this.eSz != null) {
                com.baidu.tbadk.core.util.aj.i(this.eSz, d.C0080d.cp_cont_j);
            }
            if (this.eSD != null) {
                com.baidu.tbadk.o.a.a(this.eMB.getPageContext(), this.eSD);
            }
            if (this.eTc != null) {
                com.baidu.tbadk.o.a.a(this.eMB.getPageContext(), this.eTc);
            }
            if (this.eTT != null) {
                this.eTT.onChangeSkinType(i);
            }
            if (this.eRV != null) {
                if (this.eRP != null) {
                    this.eRP.qb(i);
                } else {
                    this.eRV.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aj.i(this.eSj, d.C0080d.cp_cont_j);
            if (this.eSk != null) {
                com.baidu.tbadk.core.util.aj.j(this.eSk, d.C0080d.cp_cont_e);
            }
            this.mSkinType = i;
            if (this.eTl != null) {
                com.baidu.tbadk.core.util.aj.i(this.eTl, d.C0080d.cp_cont_e);
            }
            if (this.eSm != null) {
                com.baidu.tbadk.core.util.aj.c(this.eSm, BitmapHelper.getGradeResourceIdInEnterForum(this.eUb));
            }
            this.eUg.onChangeSkinType(i);
            if (this.eTJ != null) {
                this.eTJ.onChangeSkinType();
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSD = fVar;
        this.eSK.setOnImageClickListener(this.aSD);
        this.eUg.setOnImageClickListener(this.aSD);
    }

    public void h(NoNetworkView.a aVar) {
        this.cwk = aVar;
        if (this.cks != null) {
            this.cks.a(this.cwk);
        }
    }

    public void jw(boolean z) {
        this.eSK.setIsFromCDN(z);
    }

    public Button aUQ() {
        return this.eTj;
    }

    public void aUR() {
        if (this.eRU != 2) {
            this.eRZ.setNextPage(this.cCP);
            this.eRU = 2;
        }
    }

    public void aUS() {
        if (com.baidu.tbadk.l.r.Gt().Gu()) {
            int lastVisiblePosition = this.eRZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eRZ.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fs(1001);
                                perfLog.aJI = true;
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
                        perfLog2.fs(1001);
                        perfLog2.aJI = true;
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

    public boolean aUT() {
        return this.Jb != null && this.Jb.getVisibility() == 0;
    }

    public void hi(boolean z) {
        if (this.eTk != null) {
            if (this.dWI) {
                hj(z);
            } else {
                hk(z);
            }
        }
    }

    public void aUU() {
        if (this.eTk != null) {
            this.eTk.setVisibility(8);
            this.eTp = false;
            if (this.eTJ != null) {
                this.eTJ.setVisibility(8);
                js(false);
            }
            aVj();
        }
    }

    public void showLoadingDialog() {
        if (this.cbu == null) {
            this.cbu = new com.baidu.tbadk.core.view.a(this.eMB.getPageContext());
        }
        this.cbu.aE(true);
    }

    public void VR() {
        if (this.cbu != null) {
            this.cbu.aE(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eRZ.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eRZ.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eRP != null) {
            this.eRP.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.ene = getScrollY();
            this.eTI.eUP = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTI));
            a(this.eTI.eUP, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.eRP != null) {
            this.eRP.b(absListView, i);
        }
        int headerViewsCount = (i - this.eRZ.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.eSK.pB(headerViewsCount) != com.baidu.tieba.pb.data.l.eHp) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eSK.aSu().j(z, this.eTB != null ? this.eTB.getMeasuredHeight() : 0);
        this.eTI.eUN = i;
        this.eTI.eUO = this.eRZ.getHeaderViewsCount();
        this.eTI.eUP = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eTI));
        a(this.eTI.eUP, false);
    }

    public void aUV() {
        if (this.eMB.isLogin()) {
            if ((this.eTU == null || !this.eTU.aTW()) && this.eOE != null && this.eTY && !this.eTX && !this.eTh && this.eTt != null && this.eTt.rt() != null && !this.eTt.rt().getIsLike() && !this.eTt.rt().hadConcerned()) {
                if (this.eTU == null) {
                    this.eTU = new ak(this.eMB);
                }
                this.eTU.a(this.eRV.eYU, this.eOE.aQu(), this.eTt.rt().getUserId(), this.eOE.getThreadId());
            }
        }
    }

    public void aUW() {
        if (this.eTY && !this.eTX && this.eTt != null && this.eTt.rt() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eMB.getPageContext().getPageActivity(), this.eTt.rt().getUserId(), this.eTt.rt().getUserName(), this.eMB.aRa().aSG(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ai aiVar, boolean z) {
        int measuredHeight;
        if (!this.eTX && this.eTC != null && this.eRV.aWc() != null) {
            int aSr = this.eSK.aSr();
            if (aSr > 0 && (aiVar == null || aiVar.getView().getParent() == null)) {
                if (aSr > this.eRZ.getFirstVisiblePosition() - this.eRZ.getHeaderViewsCount()) {
                    this.eTC.setVisibility(8);
                    return;
                }
                this.eTC.setVisibility(0);
                this.eRV.mNavigationBar.hideBottomLine();
            } else if (aiVar != null && aiVar.getView() != null && aiVar.eRr != null) {
                int top = aiVar.getView().getTop();
                if (aiVar.getView().getParent() != null) {
                    if (this.eTH) {
                        this.eTG = top;
                        this.eTH = false;
                    }
                    this.eTG = top < this.eTG ? top : this.eTG;
                }
                if (top != 0 || aiVar.getView().isShown()) {
                    if (this.eSJ.getY() < 0.0f) {
                        measuredHeight = eTF - aiVar.eRr.getMeasuredHeight();
                    } else {
                        measuredHeight = this.eRV.aWc().getMeasuredHeight() - aiVar.eRr.getMeasuredHeight();
                        this.eRV.mNavigationBar.hideBottomLine();
                    }
                    if (aiVar.getView().getParent() == null && top <= this.eTG) {
                        this.eTC.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.eTC.setVisibility(0);
                    } else {
                        this.eTC.setVisibility(8);
                        this.eRV.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.eTH = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eUN;
        public int eUO;
        public ai eUP;

        public a() {
        }
    }

    public void aUX() {
        if (!this.eUz) {
            TiebaStatic.log("c10490");
            this.eUz = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eMB.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eTM, Integer.valueOf(eTO));
            aVar.cb(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.eMB);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eMB.getPageContext()).th();
        }
    }

    public void pE(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eMB.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eTM, Integer.valueOf(eTP));
        aVar.z(sparseArray);
        aVar.a(d.j.view, this.eMB);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eMB.getPageContext()).th();
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

    public PbInterviewStatusView aUY() {
        return this.eTy;
    }

    private void s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPW() != null && fVar.aPW().sn() && this.eTy == null) {
            this.eTy = (PbInterviewStatusView) this.eTx.inflate();
            this.eTy.setOnClickListener(this.czv);
            this.eTy.setCallback(this.eMB.aRY());
            this.eTy.c(this.eMB, fVar);
        }
    }

    public LinearLayout aUZ() {
        return this.eSJ;
    }

    public View aVa() {
        return this.czH;
    }

    public boolean aVb() {
        return this.eUk;
    }

    public void iL(boolean z) {
        this.eSf.iL(z);
    }

    private void aVc() {
        if (this.eUk) {
            if (this.eUl == null) {
                e.a aVar = e.eKc.get();
                if (aVar != null) {
                    this.eUl = aVar.a(this.eMB);
                    ListAdapter adapter = this.eRZ.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axs) {
                            this.eRZ.addHeaderView(this.eUl.aRk(), 1);
                        } else {
                            this.eRZ.addHeaderView(this.eUl.aRk(), 0);
                        }
                    }
                } else {
                    this.eSe.setVisibility(0);
                    return;
                }
            }
            this.eSe.setVisibility(8);
            this.eRZ.removeHeaderView(this.eSe);
            return;
        }
        this.eSe.setVisibility(0);
    }

    public void jx(boolean z) {
        this.eUk = z;
    }

    public void aVd() {
        this.eMB.showNetRefreshView(getView(), "");
        View EM = this.eMB.getRefreshView().EM();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EM.getLayoutParams();
        layoutParams.addRule(3, aUZ().getId());
        EM.setLayoutParams(layoutParams);
        this.eMB.hideLoadingView(getView());
        if (this.eUl != null) {
            this.eRZ.removeHeaderView(this.eUl.aRk());
            this.eUl = null;
        }
    }

    public void pF(String str) {
        if (this.eRW != null) {
            this.eRW.setTitle(str);
        }
    }

    private int jy(boolean z) {
        if (this.eTy == null || this.eTy.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void aVe() {
        if (this.eTy != null && this.eTy.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTy.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eTy.setLayoutParams(layoutParams);
        }
    }

    public boolean aRt() {
        return false;
    }

    public TextView aVf() {
        return this.eSt;
    }

    public void pG(String str) {
        this.eTl.performClick();
        if (!StringUtils.isNull(str) && this.eMB.aRn() != null && this.eMB.aRn().Du() != null && this.eMB.aRn().Du().Dm() != null) {
            EditText Dm = this.eMB.aRn().Du().Dm();
            Dm.setText(str);
            Dm.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aEU();
            aUU();
            aUb();
            if (this.eTT != null) {
                this.eTT.aSz();
            }
            this.eMB.ajz();
            this.eSJ.setVisibility(8);
            this.eRV.setTitleVisibility(false);
            this.eMB.iR(false);
            if (this.eRP != null) {
                if (configuration.orientation == 1) {
                    aUZ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eRZ.setIsLandscape(true);
                    this.eRZ.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eRZ.setIsLandscape(false);
                    if (this.ene > 0) {
                        this.eRZ.smoothScrollBy(this.ene, 0);
                    }
                }
                this.eRP.onConfigurationChanged(configuration);
            }
        }
    }

    public void jz(boolean z) {
        this.eRT = z;
    }

    public boolean aVg() {
        return this.eRP != null && this.eRP.aVg();
    }

    public void aVh() {
        if (this.eRP != null) {
            this.eRP.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.eRR != null) {
            this.eRR.y(j, i);
        }
        if (this.eRP != null) {
            this.eRP.y(j, i);
        }
    }

    public void iW(boolean z) {
        this.eSK.iW(z);
    }

    public void aVi() {
        if (this.eTz == null) {
            LayoutInflater.from(this.eMB.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.cku, true);
            this.eTz = (ViewGroup) this.cku.findViewById(d.g.add_experienced_layout);
            this.eTA = (TextView) this.cku.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.eTA, d.C0080d.cp_cont_i);
            String string = this.eMB.getResources().getString(d.j.experienced_add_success);
            String string2 = this.eMB.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_h)));
            this.eTA.setText(spannableString);
        }
        this.eTz.setVisibility(0);
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
                        ap.this.eTz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ap.this.eTA.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eTA.startAnimation(scaleAnimation);
    }

    public void bp(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.eTk.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eMB);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            TextView textView = new TextView(this.eMB);
            textView.setText(d.j.connection_tips);
            textView.setGravity(17);
            textView.setPadding(com.baidu.adp.lib.util.l.f(this.eMB, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.eMB, d.e.ds24), 0);
            com.baidu.tbadk.core.util.aj.i(textView, d.C0080d.cp_cont_n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eMB, d.e.ds60);
            frameLayout.addView(textView, layoutParams);
            this.eUd = new PopupWindow(this.eMB);
            this.eUd.setContentView(frameLayout);
            this.eUd.setHeight(-2);
            this.eUd.setWidth(-2);
            this.eUd.setFocusable(true);
            this.eUd.setOutsideTouchable(false);
            this.eUd.setBackgroundDrawable(new ColorDrawable(this.eMB.getResources().getColor(d.C0080d.transparent)));
            this.eRZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.32
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.eUd.showAsDropDown(ap.this.eTk, view.getLeft(), -ap.this.eTk.getHeight());
                    } else {
                        ap.this.eUd.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aVz() != null && !StringUtils.isNull(aVar.aVz().pkg_id) && !StringUtils.isNull(aVar.aVz().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.eTm != null && this.eTm.getVisibility() == 0) {
            if (this.eUc == null) {
                View inflate = LayoutInflater.from(this.eMB.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.czv);
                this.eUc = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.eTm.getLocationInWindow(iArr);
            this.eUc.showAtLocation(this.eTm, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.eTm.getHeight()) - com.baidu.adp.lib.util.l.f(this.eMB.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aVj() {
        com.baidu.adp.lib.g.g.a(this.eUc);
    }

    public void setIsInterviewLive(boolean z) {
        this.eUi = z;
    }

    public boolean getIsInterviewLive() {
        return this.eUi;
    }

    public void bq(View view) {
        this.eTc = view;
    }
}
