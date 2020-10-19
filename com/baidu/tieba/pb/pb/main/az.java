package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.support.media.ExifInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class az {
    private static final int ljE = UtilHelper.getLightStatusBarHeight();
    public static int ljK = 3;
    public static int ljL = 0;
    public static int ljM = 3;
    public static int ljN = 4;
    public static int ljO = 5;
    public static int ljP = 6;
    private static a.InterfaceC0821a lkm = new a.InterfaceC0821a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0821a
        public void onRefresh() {
        }
    };
    private EditorTools abj;
    private View bvC;
    private RelativeLayout bwu;
    private View bxe;
    private f.c eHp;
    private com.baidu.tieba.pb.a.c eTx;
    private NoNetworkView fRL;
    private View fgc;
    private List<CustomBlueCheckRadioButton> hIb;
    private NavigationBarCoverTip iSa;
    private com.baidu.tieba.NEGFeedBack.e iVq;
    private boolean ioK;
    private View.OnClickListener irI;
    private boolean isLandscape;
    private PbListView iwT;
    private TextView jrF;
    private PbFragment kXi;
    private View.OnClickListener kYf;
    private com.baidu.tieba.pb.data.f kYp;
    private PbFakeFloorModel laH;
    PbFragment.c lcw;
    private ViewStub liA;
    private PbLandscapeListView liB;
    private PbThreadPostView liC;
    private com.baidu.tieba.pb.pb.main.a.e liD;
    private com.baidu.tieba.pb.pb.main.a.a liE;
    private com.baidu.tieba.pb.pb.main.a.c liF;
    private com.baidu.tieba.pb.pb.main.a.d liG;
    private com.baidu.tieba.pb.pb.main.a.b liH;
    private LinearLayout liI;
    private TextView liJ;
    private TextView liK;
    private ObservedChangeRelativeLayout liL;
    private g liM;
    private View liS;
    public int liv;
    public final com.baidu.tieba.pb.pb.main.view.c lix;
    public com.baidu.tieba.pb.pb.main.view.b liy;
    private ViewStub liz;
    private FrameLayout ljA;
    private View ljB;
    private View ljC;
    private au ljD;
    private PbEmotionBar ljI;
    private int ljQ;
    private Runnable ljR;
    private v ljS;
    private av ljT;
    private int ljZ;
    private View ljh;
    private View ljj;
    private View ljk;
    private LinearLayout ljl;
    private HeadImageView ljm;
    private ImageView ljn;
    private ImageView ljo;
    private ImageView ljp;
    private com.baidu.tieba.pb.view.c ljq;
    private TextView ljr;
    private TextView ljs;
    private int lju;
    private int ljv;
    private PostData ljw;
    private ViewStub ljy;
    private PbInterviewStatusView ljz;
    private PbTopTipView lka;
    private PopupWindow lkb;
    private TextView lkc;
    private List<String> lkd;
    private com.baidu.tieba.pb.pb.main.emotion.c lke;
    private com.baidu.tieba.pb.pb.godreply.a lkf;
    private PbLandscapeListView.b lkg;
    private al lki;
    private String lkj;
    private long lkk;
    private int lkl;
    private boolean lkn;
    private Runnable lkr;
    private PbFragment.b lkt;
    public int lkx;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int liw = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a liN = null;
    private com.baidu.tbadk.core.dialog.b irH = null;
    private View liO = null;
    private EditText liP = null;
    private com.baidu.tieba.pb.view.d liQ = null;
    private com.baidu.tieba.pb.view.a liR = null;
    private b.InterfaceC0550b jQq = null;
    private TbRichTextView.i frJ = null;
    private NoNetworkView.a ime = null;
    private com.baidu.tbadk.core.dialog.i liT = null;
    private com.baidu.tbadk.core.dialog.a liU = null;
    private Dialog liV = null;
    private Dialog liW = null;
    private View liX = null;
    private LinearLayout liY = null;
    private CompoundButton.OnCheckedChangeListener hIc = null;
    private TextView liZ = null;
    private TextView lja = null;
    private String ljb = null;
    private com.baidu.tbadk.core.dialog.i lbv = null;
    private com.baidu.tbadk.core.dialog.i ljc = null;
    private boolean ljd = false;
    private boolean lje = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ljf = null;
    private boolean ljg = false;
    private Button lji = null;
    private boolean ljt = true;
    private com.baidu.tbadk.core.view.a hMa = null;
    private boolean kXX = false;
    private int mSkinType = 3;
    private boolean ljx = false;
    private int ljF = 0;
    private boolean ljG = true;
    public a ljH = new a();
    private int ljJ = 0;
    private boolean ljU = false;
    private int ljV = 0;
    private boolean ljW = false;
    private boolean ljX = false;
    private boolean ljY = false;
    private boolean lkh = false;
    private String lko = null;
    private CustomMessageListener lkp = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.lko = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.liM != null) {
                az.this.liM.notifyDataSetChanged();
            }
        }
    };
    private Handler lkq = new Handler();
    private CustomMessageListener lks = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.ljt = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lku = true;
    View.OnClickListener lkv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.kYp == null || az.this.kYp.dcA() == null || az.this.kYp.dcA().bih() == null || az.this.kYp.dcA().bih().getAlaInfo() == null || az.this.kYp.dcA().bih().getAlaInfo().live_status != 1) {
                if (az.this.ljW) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").aj("obj_id", 2));
                }
                if (!az.this.ljW && az.this.kYp != null && az.this.kYp.dcA() != null && az.this.kYp.dcA().bih() != null && az.this.kYp.dcA().bih().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").aj("obj_locate", 1));
                }
                if (az.this.kXi.dfv() != null) {
                    az.this.kXi.dfv().kXu.hYm.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (az.this.kYp.dcA().bih().getAlaInfo() == null || !az.this.kYp.dcA().bih().getAlaInfo().isChushou) {
                if (az.this.kYp.dcA().bih().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.kYp.dcA().bih().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.kXi.dfv(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.be.bmY().b(az.this.kXi.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.kYp.dcA().bih().getAlaInfo().thirdRoomId + "&livetype=" + az.this.kYp.dcA().bih().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bdR = false;
    String userId = null;
    private final List<TbImageView> lkw = new ArrayList();
    private boolean lky = false;

    /* loaded from: classes22.dex */
    public static class a {
        public int headerCount;
        public int kOg;
        public au lkM;
    }

    public void ug(boolean z) {
        this.ljU = z;
        if (this.liB != null) {
            this.ljV = this.liB.getHeaderViewsCount();
        }
    }

    public void dhx() {
        if (this.liB != null) {
            int headerViewsCount = this.liB.getHeaderViewsCount() - this.ljV;
            final int firstVisiblePosition = (this.liB.getFirstVisiblePosition() == 0 || this.liB.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.liB.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.liB.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.ljH.lkM = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.ljH));
            final au auVar = this.ljH.lkM;
            final int g = g(auVar);
            final int y = ((int) this.liL.getY()) + this.liL.getMeasuredHeight();
            final boolean z = this.ljB.getVisibility() == 0;
            boolean z2 = this.liL.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.liM.deo() + this.liB.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.lhW.getMeasuredHeight() : 0;
                if (z2) {
                    this.liB.setSelectionFromTop(this.liM.deo() + this.liB.getHeaderViewsCount(), ljE - measuredHeight);
                } else {
                    this.liB.setSelectionFromTop(this.liM.deo() + this.liB.getHeaderViewsCount(), this.lix.djv().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.liB.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.ljW && this.liD != null) {
                this.liB.setSelectionFromTop(this.liM.deo() + this.liB.getHeaderViewsCount(), this.liD.djh());
            } else if (this.mType == 6) {
                this.liB.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bwu.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bxe != null && (layoutParams = az.this.bxe.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bwu.getMeasuredHeight() || g2 >= az.this.bwu.getMeasuredHeight()) {
                                    layoutParams.height = az.this.ljQ;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bwu.getMeasuredHeight()) {
                                    layoutParams.height = az.this.ljQ;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.liB.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bxe.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bxe != null && az.this.bxe.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bxe.getLayoutParams();
                                            layoutParams2.height = az.this.ljQ;
                                            az.this.bxe.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.liB.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(au auVar) {
        if (auVar == null || auVar.getView() == null) {
            return 0;
        }
        if (auVar.getView().getTop() != 0 || auVar.getView().isShown()) {
            return auVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView dhy() {
        return this.fRL;
    }

    public void dhz() {
        if (this.abj != null) {
            this.abj.hide();
            if (this.lke != null) {
                this.lke.djj();
            }
        }
    }

    public PbFakeFloorModel dhA() {
        return this.laH;
    }

    public v dhB() {
        return this.ljS;
    }

    public com.baidu.tieba.pb.pb.main.a.e dhC() {
        return this.liD;
    }

    public void dhD() {
        reset();
        dhz();
        this.ljS.dew();
        us(false);
    }

    private void reset() {
        if (this.kXi != null && this.kXi.deB() != null && this.abj != null) {
            com.baidu.tbadk.editortools.pb.a.bvI().setStatus(0);
            com.baidu.tbadk.editortools.pb.e deB = this.kXi.deB();
            deB.bwd();
            deB.bvs();
            if (deB.getWriteImagesInfo() != null) {
                deB.getWriteImagesInfo().setMaxImagesAllowed(deB.isBJH ? 1 : 9);
            }
            deB.qZ(SendView.ALL);
            deB.ra(SendView.ALL);
            com.baidu.tbadk.editortools.h qM = this.abj.qM(23);
            com.baidu.tbadk.editortools.h qM2 = this.abj.qM(2);
            com.baidu.tbadk.editortools.h qM3 = this.abj.qM(5);
            if (qM2 != null) {
                qM2.display();
            }
            if (qM3 != null) {
                qM3.display();
            }
            if (qM != null) {
                qM.hide();
            }
            this.abj.invalidate();
        }
    }

    public boolean dhE() {
        return this.ljt;
    }

    public void uh(boolean z) {
        if (this.ljk != null && this.jrF != null) {
            this.jrF.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ljk.startAnimation(alphaAnimation);
            }
            this.ljj.setVisibility(0);
            this.ljk.setVisibility(0);
            this.ljt = true;
            if (this.ljI != null && !this.lkf.isActive()) {
                this.ljI.setVisibility(0);
                um(true);
            }
        }
    }

    public void ui(boolean z) {
        if (this.ljk != null && this.jrF != null) {
            this.jrF.setText(dhF());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ljk.startAnimation(alphaAnimation);
            }
            this.ljj.setVisibility(0);
            this.ljk.setVisibility(0);
            this.ljt = true;
            if (this.ljI != null && !this.lkf.isActive()) {
                this.ljI.setVisibility(0);
                um(true);
            }
        }
    }

    public String dhF() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lkj)) {
            return this.lkj;
        }
        if (this.kXi != null) {
            this.lkj = TbadkCoreApplication.getInst().getResources().getString(ay.dhu());
        }
        return this.lkj;
    }

    public PostData dhG() {
        int i = 0;
        if (this.liB == null) {
            return null;
        }
        int dhH = dhH() - this.liB.getHeaderViewsCount();
        if (dhH < 0) {
            dhH = 0;
        }
        if (this.liM.Fc(dhH) != null && this.liM.Fc(dhH) != PostData.mEg) {
            i = dhH + 1;
        }
        return this.liM.getItem(i) instanceof PostData ? (PostData) this.liM.getItem(i) : null;
    }

    public int dhH() {
        int i;
        View childAt;
        if (this.liB == null) {
            return 0;
        }
        int firstVisiblePosition = this.liB.getFirstVisiblePosition();
        int lastVisiblePosition = this.liB.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.liB.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.liB.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dhI() {
        return this.liB.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.kYp != null && this.kYp.dcC() != null && !this.kYp.dcC().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.kYp.dcC().size() && (postData = this.kYp.dcC().get(i)) != null && postData.bih() != null && !StringUtils.isNull(postData.bih().getUserId()); i++) {
                if (this.kYp.dcC().get(i).bih().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lkf != null && this.lkf.isActive()) {
                        us(false);
                    }
                    if (this.ljI != null) {
                        this.ljI.uC(true);
                    }
                    this.lko = postData.bih().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kXi = null;
        this.bwu = null;
        this.bvC = null;
        this.liB = null;
        this.liM = null;
        this.iwT = null;
        this.fgc = null;
        this.irI = null;
        this.kYf = null;
        this.ljk = null;
        this.jrF = null;
        this.ljy = null;
        this.ljZ = 0;
        this.lkk = 0L;
        this.lkk = System.currentTimeMillis();
        this.kXi = pbFragment;
        this.irI = onClickListener;
        this.eTx = cVar;
        this.ljZ = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kXi.getContext()) / 8;
        this.bwu = (RelativeLayout) LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bwu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ljh = this.bwu.findViewById(R.id.bottom_shadow);
        this.iSa = (NavigationBarCoverTip) this.bwu.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bvC = this.bwu.findViewById(R.id.statebar_view);
        this.liL = (ObservedChangeRelativeLayout) this.bwu.findViewById(R.id.title_wrapper);
        this.fRL = (NoNetworkView) this.bwu.findViewById(R.id.view_no_network);
        this.liB = (PbLandscapeListView) this.bwu.findViewById(R.id.new_pb_list);
        this.ljA = (FrameLayout) this.bwu.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kXi.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kXi.getActivity(), R.dimen.ds88));
        this.liB.addHeaderView(this.textView, 0);
        this.liB.setTextViewAdded(true);
        this.ljQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bxe = new View(this.kXi.getPageContext().getPageActivity());
        this.bxe.setLayoutParams(new AbsListView.LayoutParams(-1, this.ljQ));
        this.bxe.setVisibility(4);
        this.liB.addFooterView(this.bxe);
        this.liB.setOnTouchListener(this.kXi.fkK);
        this.lix = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bwu);
        if (this.kXi.dfe()) {
            this.liz = (ViewStub) this.bwu.findViewById(R.id.manga_view_stub);
            this.liz.setVisibility(0);
            this.liy = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.liy.show();
            this.lix.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kXi.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lix.djv().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0776a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0776a
            public void ddA() {
                if (az.this.liB != null) {
                    if (az.this.liD != null) {
                        az.this.liD.djg();
                    }
                    az.this.liB.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0776a
            public void ddB() {
                az.this.kXi.ctd();
            }
        }));
        this.ljj = this.bwu.findViewById(R.id.view_comment_top_line);
        this.ljk = this.bwu.findViewById(R.id.pb_editor_tool_comment);
        this.lju = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.ljv = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.ljm = (HeadImageView) this.bwu.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.ljm.setVisibility(0);
        this.ljm.setIsRound(true);
        this.ljm.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kXi.getContext(), R.dimen.tbds1));
        this.ljm.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
        this.ljm.setPlaceHolder(1);
        this.ljm.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.ljm.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jrF = (TextView) this.bwu.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.ljl = (LinearLayout) this.bwu.findViewById(R.id.pb_editer_tool_comment_layout);
        this.ljl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.kXi.deM();
                if (az.this.kXi != null && az.this.kXi.ddQ() != null && az.this.kXi.ddQ().getPbData() != null && az.this.kXi.ddQ().getPbData().dcA() != null && az.this.kXi.ddQ().getPbData().dcA().bih() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dK("tid", az.this.kXi.ddQ().dfP()).dK("fid", az.this.kXi.ddQ().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dK("tid", az.this.kXi.ddQ().leE).dK("fid", az.this.kXi.ddQ().getPbData().getForumId()).aj("obj_locate", 1).dK("uid", az.this.kXi.ddQ().getPbData().dcA().bih().getUserId()));
                }
            }
        });
        this.ljn = (ImageView) this.bwu.findViewById(R.id.pb_editor_tool_comment_icon);
        this.ljn.setOnClickListener(this.irI);
        boolean booleanExtra = this.kXi.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.ljo = (ImageView) this.bwu.findViewById(R.id.pb_editor_tool_collection);
        this.ljo.setOnClickListener(this.irI);
        if (booleanExtra) {
            this.ljo.setVisibility(8);
        } else {
            this.ljo.setVisibility(0);
        }
        this.ljp = (ImageView) this.bwu.findViewById(R.id.pb_editor_tool_share);
        this.ljp.setOnClickListener(this.irI);
        this.ljq = new com.baidu.tieba.pb.view.c(this.ljp);
        this.ljq.dmN();
        this.ljr = (TextView) this.bwu.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.ljr.setVisibility(0);
        this.ljy = (ViewStub) this.bwu.findViewById(R.id.interview_status_stub);
        this.liE = new com.baidu.tieba.pb.pb.main.a.a(this.kXi, cVar);
        this.liG = new com.baidu.tieba.pb.pb.main.a.d(this.kXi, cVar, this.irI);
        this.liM = new g(this.kXi, this.liB);
        this.liM.F(this.irI);
        this.liM.setTbGestureDetector(this.eTx);
        this.liM.setOnImageClickListener(this.frJ);
        this.liM.setOnSwitchChangeListener(this.kXi.lcp);
        this.kYf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            az.this.kXi.c(sparseArray);
                            return;
                        }
                        az.this.dg(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.kXi.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.liM.S(this.kYf);
        dhN();
        dhO();
        this.liG.b(this.liB);
        this.liF.b(this.liB);
        this.liE.b(this.liB);
        this.iwT = new PbListView(this.kXi.getPageContext().getPageActivity());
        this.fgc = this.iwT.getView().findViewById(R.id.pb_more_view);
        if (this.fgc != null) {
            this.fgc.setOnClickListener(this.irI);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fgc, R.drawable.pb_foot_more_trans_selector);
        }
        this.iwT.setLineVisible();
        this.iwT.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iwT.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.liS = this.bwu.findViewById(R.id.viewstub_progress);
        this.kXi.registerListener(this.lks);
        this.laH = new PbFakeFloorModel(this.kXi.getPageContext());
        this.ljS = new v(this.kXi.getPageContext(), this.laH, this.bwu);
        this.ljS.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dhD();
            }
        });
        this.ljS.a(this.kXi.lcr);
        this.laH.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.laH.t(postData);
                az.this.liM.notifyDataSetChanged();
                az.this.ljS.dew();
                az.this.abj.btC();
                az.this.us(false);
            }
        });
        if (this.kXi.ddQ() != null && !StringUtils.isNull(this.kXi.ddQ().dgx())) {
            this.kXi.showToast(this.kXi.ddQ().dgx());
        }
        this.ljB = this.bwu.findViewById(R.id.pb_expand_blank_view);
        this.ljC = this.bwu.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ljC.getLayoutParams();
        if (this.kXi.ddQ() != null && this.kXi.ddQ().dfS()) {
            this.ljB.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.ljC.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = ljE;
            this.ljC.setLayoutParams(layoutParams2);
        }
        this.ljD = new au(this.kXi.getPageContext(), this.bwu.findViewById(R.id.pb_reply_expand_view));
        this.ljD.v(pbFragment.lbl);
        this.ljD.lhW.setVisibility(8);
        this.ljD.U(this.irI);
        this.ljD.setOnSwitchChangeListener(this.kXi.lcp);
        this.kXi.registerListener(this.mAccountChangedListener);
        this.kXi.registerListener(this.lkp);
        dhJ();
        um(false);
    }

    public void uj(boolean z) {
        this.ljh.setVisibility(z ? 0 : 8);
    }

    public void cGu() {
        if (!this.kXi.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").aj("obj_locate", 2).dK("fid", this.mForumId));
        } else if (this.kXi.deO()) {
            com.baidu.tbadk.editortools.pb.e deB = this.kXi.deB();
            if (deB != null && (deB.bwa() || deB.bwb())) {
                this.kXi.deB().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abj != null) {
                dhT();
            }
            if (this.abj != null) {
                this.ljt = false;
                if (this.abj.qP(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kXi.getPageContext(), (View) this.abj.qP(2).eYZ, false, lkm);
                }
            }
            diB();
        }
    }

    private void dhJ() {
        this.lkf = new com.baidu.tieba.pb.pb.godreply.a(this.kXi, this, (ViewStub) this.bwu.findViewById(R.id.more_god_reply_popup));
        this.lkf.A(this.irI);
        this.lkf.S(this.kYf);
        this.lkf.setOnImageClickListener(this.frJ);
        this.lkf.A(this.irI);
        this.lkf.setTbGestureDetector(this.eTx);
    }

    public com.baidu.tieba.pb.pb.godreply.a dhK() {
        return this.lkf;
    }

    public View dhL() {
        return this.ljB;
    }

    public void dhM() {
        if (this.liB != null) {
            this.liF.c(this.liB);
            this.liG.c(this.liB);
            this.liH.c(this.liB);
            this.liE.c(this.liB);
        }
    }

    private void dhN() {
        if (this.liH == null) {
            this.liH = new com.baidu.tieba.pb.pb.main.a.b(this.kXi, this.irI);
        }
    }

    private void dhO() {
        if (this.liF == null) {
            this.liF = new com.baidu.tieba.pb.pb.main.a.c(this.kXi, this.eTx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhP() {
        if (this.kXi.dfe()) {
            this.liA = (ViewStub) this.bwu.findViewById(R.id.manga_mention_controller_view_stub);
            this.liA.setVisibility(0);
            if (this.liI == null) {
                this.liI = (LinearLayout) this.bwu.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kXi.getPageContext(), this.liI);
            }
            if (this.liJ == null) {
                this.liJ = (TextView) this.liI.findViewById(R.id.manga_prev_btn);
            }
            if (this.liK == null) {
                this.liK = (TextView) this.liI.findViewById(R.id.manga_next_btn);
            }
            this.liJ.setOnClickListener(this.irI);
            this.liK.setOnClickListener(this.irI);
        }
    }

    private void dhQ() {
        if (this.kXi.dfe()) {
            if (this.kXi.dfh() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.liJ, R.color.cp_cont_e, 1);
            }
            if (this.kXi.dfi() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.liK, R.color.cp_cont_e, 1);
            }
        }
    }

    public void dhR() {
        if (this.liI == null) {
            dhP();
        }
        this.liA.setVisibility(8);
        if (this.lkq != null && this.lkr != null) {
            this.lkq.removeCallbacks(this.lkr);
        }
    }

    public void dhS() {
        if (this.lkq != null) {
            if (this.lkr != null) {
                this.lkq.removeCallbacks(this.lkr);
            }
            this.lkr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.liI == null) {
                        az.this.dhP();
                    }
                    az.this.liA.setVisibility(0);
                }
            };
            this.lkq.postDelayed(this.lkr, 2000L);
        }
    }

    public void uk(boolean z) {
        this.lix.uk(z);
        if (z && this.ljx) {
            this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.liB.setNextPage(this.iwT);
            this.liw = 2;
        }
        if (this.ljm != null) {
            this.ljm.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
        this.abj.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dhD();
            }
        });
        this.abj.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abj.getParent() == null) {
            this.bwu.addView(this.abj, layoutParams);
        }
        this.abj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abj.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bqt() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bqt() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.kXi.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.kXi.getBaseFragmentActivity())) {
                            az.this.kXi.deB().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.kXi.deB().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dhz();
        this.kXi.deB().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.abj != null && az.this.abj.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.lke == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.abj.getId());
                            az.this.lke = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.kXi.getPageContext(), az.this.bwu, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.lkd)) {
                                az.this.lke.setData(az.this.lkd);
                            }
                            az.this.lke.c(az.this.abj);
                        }
                        az.this.lke.Pg(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.kXi.khj != null && az.this.kXi.khj.diS() != null) {
                    if (!az.this.kXi.khj.diS().dNm()) {
                        az.this.kXi.khj.uy(false);
                    }
                    az.this.kXi.khj.diS().xQ(false);
                }
            }
        });
    }

    public void dhT() {
        if (this.kXi != null && this.abj != null) {
            this.abj.display();
            if (this.kXi.deB() != null) {
                this.kXi.deB().bvQ();
            }
            diB();
        }
    }

    public void ul(boolean z) {
        if (this.liB != null && this.textView != null && this.bvC != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bvC.setVisibility(0);
                } else {
                    this.bvC.setVisibility(8);
                    this.liB.removeHeaderView(this.textView);
                    this.liB.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ljE;
                    this.textView.setLayoutParams(layoutParams);
                }
                dih();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + uu(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dih();
            diJ();
        }
    }

    public g dhU() {
        return this.liM;
    }

    public void a(PbFragment.c cVar) {
        this.lcw = cVar;
    }

    public void dg(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kXi.getContext());
        kVar.setTitleText(this.kXi.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.liT.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.lkt != null) {
                                az.this.lkt.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.kXi.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kXi.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kXi.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !diI()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kXi.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kXi.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kXi.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.ba(arrayList);
        this.liT = new com.baidu.tbadk.core.dialog.i(this.kXi.getPageContext(), kVar);
        this.liT.Pd();
    }

    public void a(PbFragment.b bVar) {
        this.lkt = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kXi != null && aVar != null) {
            if (this.iVq == null && this.liE != null) {
                this.iVq = new com.baidu.tieba.NEGFeedBack.e(this.kXi.getPageContext(), this.liE.djc());
            }
            AntiData crF = this.kXi.crF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (crF != null && crF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = crF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.iVq.setDefaultReasonArray(new String[]{this.kXi.getString(R.string.delete_thread_reason_1), this.kXi.getString(R.string.delete_thread_reason_2), this.kXi.getString(R.string.delete_thread_reason_3), this.kXi.getString(R.string.delete_thread_reason_4), this.kXi.getString(R.string.delete_thread_reason_5)});
            this.iVq.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.iVq.En(str);
            this.iVq.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.kXi.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(ljL, Integer.valueOf(ljM));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.liU = new com.baidu.tbadk.core.dialog.a(this.kXi.getActivity());
        if (StringUtils.isNull(str2)) {
            this.liU.ob(i3);
        } else {
            this.liU.setOnlyMessageShowCenter(false);
            this.liU.AH(str2);
        }
        this.liU.setYesButtonTag(sparseArray);
        this.liU.a(R.string.dialog_ok, this.kXi);
        this.liU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.liU.iz(true);
        this.liU.b(this.kXi.getPageContext());
        if (z) {
            this.liU.bkJ();
        } else {
            a(this.liU, i);
        }
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.liX == null) {
            this.liX = LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kXi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.liX);
        if (this.liW == null) {
            this.liW = new Dialog(this.kXi.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.liW.setCanceledOnTouchOutside(true);
            this.liW.setCancelable(true);
            this.ljf = (ScrollView) this.liX.findViewById(R.id.good_scroll);
            this.liW.setContentView(this.liX);
            WindowManager.LayoutParams attributes = this.liW.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.liW.getWindow().setAttributes(attributes);
            this.hIc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.ljb = (String) compoundButton.getTag();
                        if (az.this.hIb != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.hIb) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.ljb != null && !str.equals(az.this.ljb)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.liY = (LinearLayout) this.liX.findViewById(R.id.good_class_group);
            this.lja = (TextView) this.liX.findViewById(R.id.dialog_button_cancel);
            this.lja.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.liW instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.liW, az.this.kXi.getPageContext());
                    }
                }
            });
            this.liZ = (TextView) this.liX.findViewById(R.id.dialog_button_ok);
            this.liZ.setOnClickListener(this.irI);
        }
        this.liY.removeAllViews();
        this.hIb = new ArrayList();
        CustomBlueCheckRadioButton fO = fO("0", this.kXi.getPageContext().getString(R.string.thread_good_class));
        this.hIb.add(fO);
        fO.setChecked(true);
        this.liY.addView(fO);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bgv()) && ajVar.bgw() > 0) {
                    CustomBlueCheckRadioButton fO2 = fO(String.valueOf(ajVar.bgw()), ajVar.bgv());
                    this.hIb.add(fO2);
                    View view = new View(this.kXi.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.liY.addView(view);
                    this.liY.addView(fO2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ljf.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kXi.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kXi.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kXi.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ljf.setLayoutParams(layoutParams2);
            this.ljf.removeAllViews();
            if (this.liY != null && this.liY.getParent() == null) {
                this.ljf.addView(this.liY);
            }
        }
        com.baidu.adp.lib.f.g.a(this.liW, this.kXi.getPageContext());
    }

    private CustomBlueCheckRadioButton fO(String str, String str2) {
        Activity pageActivity = this.kXi.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hIc);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dhV() {
        this.kXi.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kXi.hideProgressBar();
        if (z && z2) {
            this.kXi.showToast(this.kXi.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kXi.showToast(str);
        }
    }

    public void cNM() {
        this.liS.setVisibility(0);
    }

    public void cNL() {
        this.liS.setVisibility(8);
    }

    public View dhW() {
        if (this.liX != null) {
            return this.liX.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dhX() {
        return this.ljb;
    }

    public View getView() {
        return this.bwu;
    }

    public void dhY() {
        if (this.kXi != null && this.kXi.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kXi.getPageContext().getPageActivity(), this.kXi.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kXi.hideProgressBar();
        if (z) {
            dir();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dis();
        } else {
            dir();
        }
    }

    public void dhZ() {
        this.iwT.setLineVisible();
        this.iwT.startLoadData();
    }

    public void dia() {
        this.kXi.hideProgressBar();
        endLoadData();
        this.liB.completePullRefreshPostDelayed(0L);
        dim();
    }

    public void dib() {
        this.liB.completePullRefreshPostDelayed(0L);
        dim();
    }

    private void um(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.liG.b(onLongClickListener);
        this.liM.setOnLongClickListener(onLongClickListener);
        if (this.lkf != null) {
            this.lkf.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0550b interfaceC0550b, boolean z, boolean z2) {
        if (this.lbv != null) {
            this.lbv.dismiss();
            this.lbv = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kXi.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kXi.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kXi.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kXi.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kXi.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.ba(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.ljc.dismiss();
                interfaceC0550b.a(null, i, view);
            }
        });
        this.ljc = new com.baidu.tbadk.core.dialog.i(this.kXi.getPageContext(), kVar);
        this.ljc.Pd();
    }

    public void a(final b.InterfaceC0550b interfaceC0550b, boolean z) {
        if (this.ljc != null) {
            this.ljc.dismiss();
            this.ljc = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kXi.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kYp != null && this.kYp.dcA() != null && !this.kYp.dcA().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kXi.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kXi.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.ba(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.ljc.dismiss();
                interfaceC0550b.a(null, i, view);
            }
        });
        this.ljc = new com.baidu.tbadk.core.dialog.i(this.kXi.getPageContext(), kVar);
        this.ljc.Pd();
    }

    public int dic() {
        return FB(this.liB.getFirstVisiblePosition());
    }

    private int FB(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.liB.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.liB.getAdapter() == null || !(this.liB.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.liB.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int did() {
        int lastVisiblePosition = this.liB.getLastVisiblePosition();
        if (this.liD != null) {
            if (lastVisiblePosition == this.liB.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return FB(lastVisiblePosition);
    }

    public void FC(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.liB != null) {
            if (this.lix == null || this.lix.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lix.mNavigationBar.getFixedNavHeight();
                if (this.kXi.deU() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.ljC != null && (layoutParams = (LinearLayout.LayoutParams) this.ljC.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.ljC.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.liB.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.liB.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.liB.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.liP.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.liM.a(fVar, false);
        this.liM.notifyDataSetChanged();
        dim();
        if (this.lkf != null) {
            this.lkf.ddM();
        }
        ArrayList<PostData> dcC = fVar.dcC();
        if (fVar.getPage().bgX() == 0 || dcC == null || dcC.size() < fVar.getPage().bgW()) {
            if (com.baidu.tbadk.core.util.y.getCount(dcC) == 0 || (com.baidu.tbadk.core.util.y.getCount(dcC) == 1 && dcC.get(0) != null && dcC.get(0).dEp() == 1)) {
                if (this.ljH == null || this.ljH.lkM == null || this.ljH.lkM.getView() == null) {
                    i = 0;
                } else {
                    i = this.ljH.lkM.getView().getTop() < 0 ? this.ljH.lkM.getView().getHeight() : this.ljH.lkM.getView().getBottom();
                }
                if (this.kXi.dfo()) {
                    this.iwT.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.iwT.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bgX() == 0) {
                    this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iwT.bob();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.liE != null) {
            this.liE.e(fVar, this.kXX);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dcN() != null) {
            return fVar.dcN();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dcC())) {
            Iterator<PostData> it = fVar.dcC().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dEp() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dcJ();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bih() != null && postData.bih().getUserTbVipInfoData() != null && postData.bih().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bih().getGodUserData().setIntro(postData.bih().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bih() == null) {
            return false;
        }
        MetaData bih = postData.bih();
        return (TextUtils.isEmpty(bih.getUserId()) && TextUtils.isEmpty(bih.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dcA() == null || fVar.dcA().bih() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bih = fVar.dcA().bih();
        String userId = bih.getUserId();
        HashMap<String, MetaData> userMap = fVar.dcA().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bih;
        }
        postData.IY(1);
        postData.setId(fVar.dcA().biy());
        postData.setTitle(fVar.dcA().getTitle());
        postData.setTime(fVar.dcA().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dcA() != null) {
            if (this.kXi.ddG()) {
                if (fVar.dcz() != null) {
                    this.mForumName = fVar.dcz().getForumName();
                    this.mForumId = fVar.dcz().getForumId();
                }
                if (this.mForumName == null && this.kXi.ddQ() != null && this.kXi.ddQ().ddH() != null) {
                    this.mForumName = this.kXi.ddQ().ddH();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.liG.setVisibility(8);
            if (fVar.dda()) {
                this.ljW = true;
                this.lix.uJ(true);
                this.lix.mNavigationBar.hideBottomLine();
                if (this.liD == null) {
                    this.liD = new com.baidu.tieba.pb.pb.main.a.e(this.kXi);
                }
                this.liD.a(fVar, b, this.liB, this.liG, this.ljA, this.lix, this.mForumName, this.lkk);
                this.liD.V(this.lkv);
                dih();
            } else {
                this.ljW = false;
                this.lix.uJ(this.ljW);
                if (this.liD != null) {
                    this.liD.c(this.liB);
                }
            }
            if (this.kXi.deE() != null) {
                this.kXi.deE().uD(this.ljW);
            }
            if (b != null) {
                this.ljw = b;
                this.liG.setVisibility(0);
                SparseArray<Object> djf = this.liG.djf();
                djf.put(R.id.tag_clip_board, b);
                djf.put(R.id.tag_is_subpb, false);
                this.liH.a(fVar, this.liB);
                this.liF.A(fVar);
                this.liE.e(fVar, this.kXX);
                this.liE.z(fVar);
                this.liG.a(this.mSkinType, this.kYp, b, this.lkv);
                if (this.ljD != null) {
                    if (fVar.ddd()) {
                        this.ljD.getView().setVisibility(8);
                    } else {
                        this.ljD.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kVN);
                        if (fVar.dcA() != null) {
                            nVar.kVP = fVar.dcA().bhY();
                        }
                        nVar.isNew = !this.kXX;
                        nVar.sortType = fVar.kUz;
                        nVar.kVR = fVar.dde();
                        nVar.kVS = this.kXi.dfo();
                        nVar.kVT = fVar.kUy;
                        this.ljD.a(nVar);
                    }
                }
                if (fVar != null && fVar.dcA() != null) {
                    aq(fVar.dcA().bid() == 1, fVar.dcA().bic() == 1);
                }
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.liM != null && az.this.lix != null && az.this.lix.loU != null && az.this.kYp != null && az.this.kYp.dcA() != null && !az.this.kYp.dcA().bgN() && !az.this.dil() && az.this.kYp.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(az.this.kYp.getForum().getName())) {
                            if ((az.this.liM.des() == null || !az.this.liM.des().isShown()) && az.this.lix.loU != null) {
                                az.this.lix.loU.setVisibility(0);
                                if (az.this.kXi != null && az.this.kXi.ddQ() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dK("tid", az.this.kXi.ddQ().dfO());
                                    aqVar.dK("fid", az.this.kXi.ddQ().getForumId());
                                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void un(boolean z) {
        if (z) {
            die();
        } else {
            cmD();
        }
        this.ljH.lkM = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.ljH));
        a(this.ljH.lkM, false);
    }

    public void die() {
        if (this.lix != null && !this.ljY) {
            this.lix.die();
            this.ljY = true;
        }
    }

    public void cmD() {
        if (this.lix != null) {
            this.lix.djD();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.liG.a(postData, fVar);
    }

    public void dif() {
        if (this.liD != null) {
            this.liD.d(this.liB);
        }
    }

    public boolean dig() {
        return this.bdR;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bih() == null) {
            return false;
        }
        PostData b = b(this.kYp, false);
        String str = "";
        if (b != null && b.bih() != null) {
            str = b.bih().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lix.djB();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lix.MQ(dVar.forumName);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.f.b.toInt(dVar.source, 0)) {
                case 100:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
                    break;
                case 300:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = dVar.kUq;
            this.kXi.showNetRefreshView(this.bwu, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.be.bmY().b(az.this.kXi.getPageContext(), new String[]{str2});
                        az.this.kXi.finish();
                        return;
                    }
                    az.this.kXi.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dhk;
        Parcelable dhk2;
        if (fVar != null && this.liB != null) {
            this.kYp = fVar;
            this.mType = i;
            if (fVar.dcA() != null) {
                this.ljJ = fVar.dcA().bhO();
                if (fVar.dcA().getAnchorLevel() != 0) {
                    this.bdR = true;
                }
                this.lje = aK(fVar.dcA());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.ljx = false;
            this.kXX = z;
            dia();
            if (fVar.kUA != null && fVar.kUA.ddj()) {
                if (this.liC == null) {
                    this.liC = new PbThreadPostView(this.kXi.getContext());
                    this.liB.addHeaderView(this.liC, 1);
                    this.liC.setData(fVar);
                    this.liC.setChildOnClickLinstener(this.irI);
                }
            } else if (this.liC != null && this.liB != null) {
                this.liB.removeHeaderView(this.liC);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lki == null) {
                this.lki = new al(this.kXi.getPageContext(), this.iSa);
            }
            this.lki.OW(fVar.dcH());
            if (this.kXi.dfe()) {
                if (this.liQ == null) {
                    this.liQ = new com.baidu.tieba.pb.view.d(this.kXi.getPageContext());
                    this.liQ.createView();
                    this.liQ.setListPullRefreshListener(this.eHp);
                }
                this.liB.setPullRefresh(this.liQ);
                dih();
                if (this.liQ != null) {
                    this.liQ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bgY() == 0 && z) {
                this.liB.setPullRefresh(null);
            } else {
                if (this.liQ == null) {
                    this.liQ = new com.baidu.tieba.pb.view.d(this.kXi.getPageContext());
                    this.liQ.createView();
                    this.liQ.setListPullRefreshListener(this.eHp);
                }
                this.liB.setPullRefresh(this.liQ);
                dih();
                if (this.liQ != null) {
                    this.liQ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                cbz();
            }
            dim();
            this.liM.tu(this.kXX);
            this.liM.tv(false);
            this.liM.tz(i == 5);
            this.liM.tA(i == 6);
            this.liM.tB(z2 && this.lku && i != 2);
            this.liM.a(fVar, false);
            this.liM.notifyDataSetChanged();
            this.liG.b(b(fVar, z), fVar.ddd());
            if (fVar.dcA() != null && fVar.dcA().bhS() != null && this.liv != -1) {
                fVar.dcA().bhS().setIsLike(this.liv);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.liB.setNextPage(this.iwT);
                this.liw = 2;
                cbz();
            } else {
                this.ljx = true;
                if (fVar.getPage().bgX() == 1) {
                    if (this.liR == null) {
                        this.liR = new com.baidu.tieba.pb.view.a(this.kXi, this.kXi);
                    }
                    this.liB.setNextPage(this.liR);
                } else {
                    this.liB.setNextPage(this.iwT);
                }
                this.liw = 3;
            }
            ArrayList<PostData> dcC = fVar.dcC();
            if (fVar.getPage().bgX() == 0 || dcC == null || dcC.size() < fVar.getPage().bgW()) {
                if (com.baidu.tbadk.core.util.y.getCount(dcC) == 0 || (com.baidu.tbadk.core.util.y.getCount(dcC) == 1 && dcC.get(0) != null && dcC.get(0).dEp() == 1)) {
                    if (this.ljH == null || this.ljH.lkM == null || this.ljH.lkM.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.ljH.lkM.getView().getTop() < 0 ? this.ljH.lkM.getView().getHeight() : this.ljH.lkM.getView().getBottom();
                    }
                    if (this.kXi.dfo()) {
                        this.iwT.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.iwT.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kXi.deE() != null && !this.kXi.deE().djp()) {
                        this.kXi.deE().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bgX() == 0) {
                        this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iwT.bob();
                }
                if (fVar.getPage().bgX() == 0 || dcC == null) {
                    diw();
                }
            } else {
                if (z2) {
                    if (this.lku) {
                        endLoadData();
                        if (fVar.getPage().bgX() != 0) {
                            this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iwT.setLineVisible();
                        this.iwT.showLoading();
                    }
                } else {
                    this.iwT.setLineVisible();
                    this.iwT.showLoading();
                }
                this.iwT.bob();
            }
            switch (i) {
                case 2:
                    this.liB.setSelection(i2 > 1 ? (((this.liB.getData() == null && fVar.dcC() == null) ? 0 : (this.liB.getData().size() - fVar.dcC().size()) + this.liB.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dhk2 = as.dhj().dhk()) != null && !(dhk2 instanceof RecyclerView.SavedState)) {
                        this.liB.onRestoreInstanceState(dhk2);
                        if (com.baidu.tbadk.core.util.y.getCount(dcC) > 1 && fVar.getPage().bgX() > 0) {
                            this.iwT.endLoadData();
                            this.iwT.setText(this.kXi.getString(R.string.pb_load_more_without_point));
                            this.iwT.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lku = false;
                    break;
                case 5:
                    this.liB.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dhk = as.dhj().dhk()) != null && !(dhk instanceof RecyclerView.SavedState)) {
                        this.liB.onRestoreInstanceState(dhk);
                        break;
                    } else {
                        this.liB.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.liD != null && this.liD.bKm() != null) {
                            if (this.kXi.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.liB.setSelectionFromTop((this.liM.den() + this.liB.getHeaderViewsCount()) - 1, this.liD.djh() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kXi.getPageContext().getPageActivity()));
                            } else {
                                this.liB.setSelectionFromTop((this.liM.den() + this.liB.getHeaderViewsCount()) - 1, this.liD.djh());
                            }
                        } else {
                            this.liB.setSelection(this.liM.den() + this.liB.getHeaderViewsCount());
                        }
                    } else {
                        this.liB.setSelection(i2 > 0 ? ((this.liB.getData() == null && fVar.dcC() == null) ? 0 : (this.liB.getData().size() - fVar.dcC().size()) + this.liB.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.iwT.endLoadData();
                    this.iwT.setText(this.kXi.getString(R.string.pb_load_more_without_point));
                    this.iwT.setLineGone();
                    break;
            }
            if (this.ljJ == ljK && isHost()) {
                diE();
            }
            if (this.ljU) {
                dhx();
                this.ljU = false;
                if (i3 == 0) {
                    ug(true);
                }
            }
            if (fVar.kUw == 1 || fVar.kUx == 1) {
                if (this.lka == null) {
                    this.lka = new PbTopTipView(this.kXi.getContext());
                }
                if (fVar.kUx == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kXi.getStType())) {
                    this.lka.setText(this.kXi.getString(R.string.pb_read_strategy_add_experience));
                    this.lka.a(this.bwu, this.mSkinType);
                } else if (fVar.kUw == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kXi.getStType())) {
                    this.lka.setText(this.kXi.getString(R.string.pb_read_news_add_experience));
                    this.lka.a(this.bwu, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            x(fVar);
            if (fVar.bec()) {
                SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String FD = FD(fVar.dcA().bhY());
            if (this.ljr != null) {
                this.ljr.setText(FD);
            }
            if (this.ljs != null) {
                this.ljs.setText(FD);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dcA()));
        }
    }

    private String FD(int i) {
        if (i == 0) {
            return this.kXi.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    private void dih() {
        if (this.liD != null) {
            this.liD.a(this.liB, this.textView, this.mType);
        }
    }

    public void uo(boolean z) {
        this.ljd = z;
    }

    public void endLoadData() {
        if (this.iwT != null) {
            this.iwT.setLineGone();
            this.iwT.endLoadData();
        }
        cbz();
    }

    public void bPU() {
        this.liB.setVisibility(0);
    }

    public void dii() {
        if (this.liB != null) {
            this.liB.setVisibility(8);
        }
        if (this.liB != null) {
            this.ljA.setVisibility(8);
        }
        if (this.lix != null && this.lix.loT != null) {
            this.lix.loT.setVisibility(8);
        }
    }

    public void dij() {
        if (this.liB != null) {
            this.liB.setVisibility(0);
        }
        if (this.ljA != null) {
            this.ljA.setVisibility(0);
        }
        if (this.lix != null && this.lix.loT != null) {
            this.lix.loT.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.ljw != null && this.ljw.bih() != null && this.lix != null) {
            this.ljX = !this.ljW;
            this.lix.uF(this.ljX);
            if (this.kXi.deE() != null) {
                this.kXi.deE().uE(this.ljX);
            }
            dik();
            if (this.kXi != null && !this.kXi.ddG() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dcX())) {
                bs bsVar = fVar.dcX().get(0);
                if (bsVar != null) {
                    this.lix.fP(bsVar.getForumName(), bsVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lix.fP(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.ljX) {
                this.liG.a(fVar, this.ljw, this.lje);
                if (this.ljC != null) {
                    this.ljC.setVisibility(8);
                }
                if (this.lkg == null) {
                    this.lkg = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.kXi != null && az.this.kXi.isAdded()) {
                                if (i < 0 && f > az.this.ljZ) {
                                    az.this.dir();
                                    az.this.diD();
                                }
                                az.this.dib();
                            }
                        }
                    };
                }
                this.liB.setListViewDragListener(this.lkg);
                return;
            }
            if (this.ljC != null) {
                this.ljC.setVisibility(0);
            }
            this.liG.a(fVar, this.ljw, this.lje);
            this.lkg = null;
            this.liB.setListViewDragListener(null);
        }
    }

    private void dik() {
        this.liG.a(this.kYp, this.ljw, this.ljX, this.ljW);
    }

    public boolean dil() {
        return this.kYp == null || this.kYp.getForum() == null || "0".equals(this.kYp.getForum().getId()) || "me0407".equals(this.kYp.getForum().getName());
    }

    private boolean dim() {
        return this.liE.uA(this.kXX);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dcA() == null) {
            return false;
        }
        if (fVar.dcA().bie() == 1 || fVar.dcA().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dcA().big() == null || fVar.dcA().big().bkw() == 0) || fVar.dcA().bic() == 1 || fVar.dcA().bid() == 1 || fVar.dcA().biV() || fVar.dcA().bjp() || fVar.dcA().bji() || fVar.dcA().bis() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.dcA().getCategory()) || fVar.dcA().bik() || fVar.dcA().bij();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.liF != null) {
                if (fVar.dcA() != null && fVar.dcA().biv() == 0 && !fVar.dcA().bgN() && !this.lkn) {
                    if (fVar.dcA() != null) {
                        bw dcA = fVar.dcA();
                        dcA.z(true, w(fVar));
                        dcA.nN(3);
                        dcA.Au("2");
                    }
                    if (fVar.dcA().bgP()) {
                        this.liG.c(this.liB);
                        this.liF.c(this.liB);
                        this.liF.b(this.liB);
                        this.liG.b(this.liB);
                        this.liG.E(this.kYp);
                        this.liF.B(fVar);
                    } else {
                        this.liG.E(this.kYp);
                        this.liF.D(fVar);
                    }
                } else if (fVar.dcA().biv() == 1) {
                    if (fVar.dcA() != null) {
                        this.liF.c(this.liB);
                        this.liG.E(this.kYp);
                    }
                } else {
                    this.liF.c(this.liB);
                    this.liG.E(this.kYp);
                }
            }
            if (fVar.dcA() != null) {
                ap(fVar.dcA().bid() == 1, fVar.dcA().bic() == 1);
            }
            this.kXX = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dim();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.bih().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dcP()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.bih() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.bih().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.bih().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.bih().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dcP()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> dcX = fVar.dcX();
                if (com.baidu.tbadk.core.util.y.getCount(dcX) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : dcX) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eoN) != null && abVar.emw && !abVar.emx && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(this.kXi.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kXi.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View din() {
        return this.fgc;
    }

    public boolean dio() {
        if (this.bxe == null || this.bxe.getParent() == null || this.iwT.isLoading()) {
            return false;
        }
        int bottom = this.bxe.getBottom();
        Rect rect = new Rect();
        this.bxe.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void OY(String str) {
        if (this.iwT != null) {
            this.iwT.setText(str);
        }
    }

    public void OZ(String str) {
        if (this.iwT != null) {
            int i = 0;
            if (this.ljH != null && this.ljH.lkM != null && this.ljH.lkM.getView() != null) {
                i = this.ljH.lkM.getView().getTop() < 0 ? this.ljH.lkM.getView().getHeight() : this.ljH.lkM.getView().getBottom();
            }
            this.iwT.an(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.liB;
    }

    public int dip() {
        return R.id.richText;
    }

    public TextView dea() {
        return this.liG.dea();
    }

    public void d(BdListView.e eVar) {
        this.liB.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eHp = cVar;
        if (this.liQ != null) {
            this.liQ.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.av avVar, a.b bVar) {
        if (avVar != null) {
            int bgV = avVar.bgV();
            int bgS = avVar.bgS();
            if (this.liN != null) {
                this.liN.bkJ();
            } else {
                this.liN = new com.baidu.tbadk.core.dialog.a(this.kXi.getPageContext().getPageActivity());
                this.liO = LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.liN.ba(this.liO);
                this.liN.a(R.string.dialog_ok, bVar);
                this.liN.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dir();
                        aVar.dismiss();
                    }
                });
                this.liN.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.ljR == null) {
                            az.this.ljR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.kXi.HidenSoftKeyPad((InputMethodManager) az.this.kXi.getBaseFragmentActivity().getSystemService("input_method"), az.this.bwu);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(az.this.ljR, 150L);
                    }
                });
                this.liN.b(this.kXi.getPageContext()).bkJ();
            }
            this.liP = (EditText) this.liO.findViewById(R.id.input_page_number);
            this.liP.setText("");
            TextView textView = (TextView) this.liO.findViewById(R.id.current_page_number);
            if (bgV <= 0) {
                bgV = 1;
            }
            if (bgS <= 0) {
                bgS = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bgV), Integer.valueOf(bgS)));
            this.kXi.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.liP, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.liB.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kXi.showToast(str);
    }

    public boolean up(boolean z) {
        if (this.abj == null || !this.abj.bvj()) {
            return false;
        }
        this.abj.btC();
        return true;
    }

    public void diq() {
        if (this.lkw != null) {
            while (this.lkw.size() > 0) {
                TbImageView remove = this.lkw.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        diq();
        this.liM.Fd(1);
        if (this.liD != null) {
            this.liD.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.liM.Fd(2);
        if (this.liD != null) {
            this.liD.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kXi.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kXi.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.ljq != null) {
            this.ljq.onDestroy();
        }
        if (this.ljT != null) {
            this.ljT.destroy();
        }
        if (this.lki != null) {
            this.lki.onDestory();
        }
        if (this.lka != null) {
            this.lka.hide();
        }
        this.kXi.hideProgressBar();
        if (this.fRL != null && this.ime != null) {
            this.fRL.b(this.ime);
        }
        dir();
        endLoadData();
        if (this.ljR != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ljR);
        }
        if (this.ljz != null) {
            this.ljz.clearStatus();
        }
        this.lkq = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.liM.Fd(3);
        if (this.bvC != null) {
            this.bvC.setBackgroundDrawable(null);
        }
        if (this.liD != null) {
            this.liD.destroy();
        }
        if (this.liM != null) {
            this.liM.onDestroy();
        }
        this.liB.setOnLayoutListener(null);
        if (this.lke != null) {
            this.lke.cvF();
        }
        if (this.ljI != null) {
            this.ljI.onDestroy();
        }
        if (this.liG != null) {
            this.liG.onDestroy();
        }
    }

    public boolean FE(int i) {
        if (this.liD != null) {
            return this.liD.FE(i);
        }
        return false;
    }

    public void dir() {
        this.lix.aVi();
        if (this.liG != null) {
            this.liG.dir();
        }
        if (this.kXi != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kXi.getContext(), this.liP);
        }
        dhz();
        if (this.lbv != null) {
            this.lbv.dismiss();
        }
        dit();
        if (this.liN != null) {
            this.liN.dismiss();
        }
        if (this.irH != null) {
            this.irH.dismiss();
        }
    }

    public void dis() {
        this.lix.aVi();
        if (this.liG != null) {
            this.liG.dir();
        }
        if (this.lbv != null) {
            this.lbv.dismiss();
        }
        dit();
        if (this.liN != null) {
            this.liN.dismiss();
        }
        if (this.irH != null) {
            this.irH.dismiss();
        }
    }

    public void eN(List<String> list) {
        this.lkd = list;
        if (this.lke != null) {
            this.lke.setData(list);
        }
    }

    public void tt(boolean z) {
        this.liM.tt(z);
    }

    public void uq(boolean z) {
        this.ljg = z;
    }

    public void dit() {
        if (this.liU != null) {
            this.liU.dismiss();
        }
        if (this.liV != null) {
            com.baidu.adp.lib.f.g.b(this.liV, this.kXi.getPageContext());
        }
        if (this.liW != null) {
            com.baidu.adp.lib.f.g.b(this.liW, this.kXi.getPageContext());
        }
        if (this.liT != null) {
            this.liT.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.kYp, this.kXX);
            b(this.kYp, this.kXX, this.mType, i);
            this.kXi.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kXi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bwu);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bwu, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ljh, R.drawable.personalize_tab_shadow);
            if (this.liD != null) {
                this.liD.onChangeSkinType(i);
            }
            if (this.liH != null) {
                this.liH.onChangeSkinType(i);
            }
            if (this.liE != null) {
                this.liE.onChangeSkinType(i);
            }
            if (this.liF != null) {
                this.liF.onChangeSkinType(i);
            }
            if (this.liG != null) {
                this.liG.onChangeSkinType(i);
            }
            if (this.iwT != null) {
                this.iwT.changeSkin(i);
                if (this.fgc != null) {
                    this.kXi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fgc);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fgc, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.liN != null) {
                this.liN.c(this.kXi.getPageContext());
            }
            uo(this.ljd);
            this.liM.notifyDataSetChanged();
            if (this.liQ != null) {
                this.liQ.changeSkin(i);
            }
            if (this.abj != null) {
                this.abj.onChangeSkinType(i);
            }
            if (this.liR != null) {
                this.liR.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hIb)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.hIb) {
                    customBlueCheckRadioButton.bnO();
                }
            }
            dhQ();
            UtilHelper.setStatusBarBackground(this.bvC, i);
            UtilHelper.setStatusBarBackground(this.ljC, i);
            if (this.liI != null) {
                com.baidu.tbadk.r.a.a(this.kXi.getPageContext(), this.liI);
            }
            if (this.ljS != null) {
                this.ljS.onChangeSkinType(i);
            }
            if (this.lix != null) {
                if (this.liD != null) {
                    this.liD.FF(i);
                } else {
                    this.lix.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.jrF != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.jrF, R.color.cp_cont_d);
            }
            if (this.ljm != null) {
                this.ljm.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
            }
            if (this.ljl != null) {
                this.ljl.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aN(com.baidu.adp.lib.util.l.getDimens(this.kXi.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j)));
            }
            if (this.ljo != null && this.kYp != null) {
                if (this.kYp.bec()) {
                    SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.kYp);
            if (this.ljn != null) {
                SvgManager.bmU().a(this.ljn, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.ljj != null) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ljj, R.drawable.bottom_shadow);
            }
            if (this.ljr != null) {
                com.baidu.tbadk.core.util.ap.c(this.ljr, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ljr, R.color.cp_cont_j);
            }
            if (this.ljs != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ljs, R.color.cp_cont_b);
            }
            if (this.lkf != null) {
                this.lkf.onChangeSkinType(i);
            }
            if (this.ljI != null) {
                this.ljI.onChangeSkinType();
            }
            if (this.lkc != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lkc, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ljk, R.color.cp_bg_line_h);
            if (this.liC != null) {
                this.liC.uc(i);
            }
            if (this.ljq != null) {
                this.ljq.onChangeSkinType();
            }
        }
    }

    public void diu() {
        if (this.ljq != null) {
            this.ljq.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.dcA())) {
            if (this.ljq != null) {
                this.ljq.setEnable(false);
                this.ljq.onDestroy();
            }
            SvgManager.bmU().a(this.ljp, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.ljq == null || !this.ljq.isEnable()) {
            SvgManager.bmU().a(this.ljp, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
        this.liM.setOnImageClickListener(this.frJ);
        this.lkf.setOnImageClickListener(this.frJ);
    }

    public void g(NoNetworkView.a aVar) {
        this.ime = aVar;
        if (this.fRL != null) {
            this.fRL.a(this.ime);
        }
    }

    public void ur(boolean z) {
        this.liM.setIsFromCDN(z);
    }

    public Button div() {
        return this.lji;
    }

    public void diw() {
        if (this.liw != 2) {
            this.liB.setNextPage(this.iwT);
            this.liw = 2;
        }
    }

    public void dix() {
        if (com.baidu.tbadk.n.m.byc().byd()) {
            int lastVisiblePosition = this.liB.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.liB.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.fgL = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(R.id.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.n.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.setSubType(1001);
                        perfLog2.fgL = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean diy() {
        return this.abj != null && this.abj.getVisibility() == 0;
    }

    public boolean diz() {
        return this.abj != null && this.abj.bvj();
    }

    public void diA() {
        if (this.abj != null) {
            this.abj.btC();
        }
    }

    public void us(boolean z) {
        if (this.ljk != null) {
            uq(this.kXi.deB().bvT());
            if (this.ljg) {
                uh(z);
            } else {
                ui(z);
            }
        }
    }

    public void diB() {
        if (this.ljk != null) {
            this.ljj.setVisibility(8);
            this.ljk.setVisibility(8);
            this.ljt = false;
            if (this.ljI != null) {
                this.ljI.setVisibility(8);
                um(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hMa == null) {
            this.hMa = new com.baidu.tbadk.core.view.a(this.kXi.getPageContext());
        }
        this.hMa.setDialogVisiable(true);
    }

    public void cbz() {
        if (this.hMa != null) {
            this.hMa.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.liB.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.liB.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.liD != null) {
            this.liD.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.lkx = getScrollY();
            this.ljH.lkM = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.ljH));
            a(this.ljH.lkM, true);
        }
    }

    public void ut(boolean z) {
        if (this.liD != null) {
            this.liD.ut(z);
        }
    }

    private boolean b(AbsListView absListView, int i) {
        boolean z = true;
        if (absListView == null) {
            return false;
        }
        boolean z2 = i > 0;
        if (z2 || absListView.getChildCount() <= 0) {
            z = z2;
        } else if (absListView.getChildAt(0).getTop() >= absListView.getListPaddingTop()) {
            z = false;
        }
        return z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.liD != null) {
            this.liD.onScroll(absListView, i, i2, i3);
        }
        if (this.lix != null && this.liG != null) {
            this.lix.di(this.liG.djd());
        }
        this.ljH.kOg = i;
        this.ljH.headerCount = this.liB.getHeaderViewsCount();
        this.ljH.lkM = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.ljH));
        uj(b(absListView, i));
        a(this.ljH.lkM, false);
        if (this.iwT.boc() && !this.iwT.eGw) {
            if (this.ljH != null && this.ljH.lkM != null && this.ljH.lkM.getView() != null) {
                i4 = this.ljH.lkM.getView().getTop() < 0 ? this.ljH.lkM.getView().getHeight() : this.ljH.lkM.getView().getBottom();
            }
            this.iwT.pz(i4);
            this.iwT.eGw = true;
        }
    }

    public void diC() {
        if (TbadkCoreApplication.isLogin() && this.kYp != null && this.ljX && !this.ljW && !this.lje && this.ljw != null && this.ljw.bih() != null && !this.ljw.bih().getIsLike() && !this.ljw.bih().hadConcerned() && this.ljT == null) {
            this.ljT = new av(this.kXi);
        }
    }

    public void diD() {
        if (this.kXi != null) {
            if ((this.ioK || this.lkl == 17) && com.baidu.tbadk.a.d.bdF()) {
                if (this.kYp != null && this.kYp.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kYp.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.kXi.getContext()).createNormalCfg(this.kYp.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dK("post_id", this.kYp.getThreadId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("fid", this.kYp.getForum().getId()));
                }
            } else if (this.ljX && !this.ljW && this.ljw != null && this.ljw.bih() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").aj("obj_locate", this.kXi.ddG() ? 2 : 1).aj("obj_type", this.ljW ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kXi.getPageContext().getPageActivity(), this.ljw.bih().getUserId(), this.ljw.bih().getUserName(), this.kXi.ddQ().ddH(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.ljW && this.ljB != null && this.lix.djv() != null) {
            int deo = this.liM.deo();
            if (deo > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (deo > this.liB.getFirstVisiblePosition() - this.liB.getHeaderViewsCount()) {
                    this.ljB.setVisibility(4);
                    return;
                }
                this.ljB.setVisibility(0);
                uj(false);
                this.lix.mNavigationBar.hideBottomLine();
                if (this.ljB.getParent() != null && ((ViewGroup) this.ljB.getParent()).getHeight() <= this.ljB.getTop()) {
                    this.ljB.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.lhW == null) {
                if (this.liB.getFirstVisiblePosition() == 0) {
                    this.ljB.setVisibility(4);
                    this.lix.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.ljG) {
                        this.ljF = top;
                        this.ljG = false;
                    }
                    this.ljF = top < this.ljF ? top : this.ljF;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.liL.getY() < 0.0f) {
                        measuredHeight = ljE - auVar.lhW.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lix.djv().getMeasuredHeight() - auVar.lhW.getMeasuredHeight();
                        this.lix.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.ljF) {
                        this.ljB.setVisibility(0);
                        uj(false);
                    } else if (top < measuredHeight) {
                        this.ljB.setVisibility(0);
                        uj(false);
                    } else {
                        this.ljB.setVisibility(4);
                        this.lix.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.ljG = true;
                    }
                }
            }
        }
    }

    public void diE() {
        if (!this.lky) {
            TiebaStatic.log("c10490");
            this.lky = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXi.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ljL, Integer.valueOf(ljN));
            aVar.oa(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.ba(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kXi);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kXi.getPageContext()).bkJ();
        }
    }

    public void Pa(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXi.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.ba(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(ljL, Integer.valueOf(ljO));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kXi);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kXi.getPageContext()).bkJ();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.bih() != null) {
            MetaData bih = b.bih();
            bih.setGiftNum(bih.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.liG.onChangeSkinType(i2);
    }

    public PbInterviewStatusView diF() {
        return this.ljz;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dcA() != null && fVar.dcA().bjp() && this.ljz == null) {
            this.ljz = (PbInterviewStatusView) this.ljy.inflate();
            this.ljz.setOnClickListener(this.irI);
            this.ljz.setCallback(this.kXi.dfm());
            this.ljz.setData(this.kXi, fVar);
        }
    }

    public RelativeLayout diG() {
        return this.liL;
    }

    public View diH() {
        return this.bvC;
    }

    public boolean diI() {
        return this.lkn;
    }

    public void ty(boolean z) {
        this.liG.ty(z);
    }

    public void Pb(String str) {
        if (this.liy != null) {
            this.liy.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int uu(boolean z) {
        if (this.ljz == null || this.ljz.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void diJ() {
        if (this.ljz != null && this.ljz.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ljz.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.ljz.setLayoutParams(layoutParams);
        }
    }

    public boolean deH() {
        return false;
    }

    public void Pc(String str) {
        this.jrF.performClick();
        if (!StringUtils.isNull(str) && this.kXi.deB() != null && this.kXi.deB().bvL() != null && this.kXi.deB().bvL().getInputView() != null) {
            EditText inputView = this.kXi.deB().bvL().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dir();
            if (configuration.orientation == 2) {
                diB();
                dhz();
            } else {
                dhD();
            }
            if (this.ljS != null) {
                this.ljS.dew();
            }
            this.kXi.ctd();
            this.liL.setVisibility(8);
            this.lix.uG(false);
            this.kXi.tN(false);
            if (this.liD != null) {
                if (configuration.orientation == 1) {
                    diG().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.liB.setIsLandscape(true);
                    this.liB.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.liB.setIsLandscape(false);
                    if (this.lkx > 0) {
                        this.liB.smoothScrollBy(this.lkx, 0);
                    }
                }
                this.liD.onConfigurationChanged(configuration);
                this.ljA.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void uv(boolean z) {
        if (this.liD != null) {
            this.liD.uv(z);
        }
    }

    public boolean diK() {
        return this.liD != null && this.liD.diK();
    }

    public void diL() {
        if (this.liD != null) {
            this.liD.diL();
        }
    }

    public void tC(boolean z) {
        this.liM.tC(z);
    }

    public void dh(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.ljk.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kXi.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lkc = new TextView(this.kXi.getContext());
            this.lkc.setText(R.string.connection_tips);
            this.lkc.setGravity(17);
            this.lkc.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kXi.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kXi.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kXi.getContext(), R.dimen.ds60);
            if (this.lkc.getParent() == null) {
                frameLayout.addView(this.lkc, layoutParams);
            }
            this.lkb = new PopupWindow(this.kXi.getContext());
            this.lkb.setContentView(frameLayout);
            this.lkb.setHeight(-2);
            this.lkb.setWidth(-2);
            this.lkb.setFocusable(true);
            this.lkb.setOutsideTouchable(false);
            this.lkb.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.liB.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.lkb.showAsDropDown(az.this.ljk, view.getLeft(), -az.this.ljk.getHeight());
                    } else {
                        az.this.lkb.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void uw(boolean z) {
        this.lkh = z;
    }

    public boolean diM() {
        return this.lkh;
    }

    public PbThreadPostView diN() {
        return this.liC;
    }

    private void ap(boolean z, boolean z2) {
        aq(z, z2);
        if (this.kYp != null && this.kYp.dcA() != null && this.kYp.dcA().biv() == 0 && !this.kYp.dcA().bgN()) {
            ar(z, z2);
        } else if (this.liM != null && this.liM.det() != null) {
            this.liM.det().b(this.kYp, z, z2);
        }
    }

    private void aq(boolean z, boolean z2) {
        this.liG.d(this.kYp, z, z2);
    }

    private void ar(boolean z, boolean z2) {
        this.liF.c(this.kYp, z, z2);
    }

    public void ux(boolean z) {
        this.ioK = z;
    }

    public void Fw(int i) {
        this.lkl = i;
    }

    public void diO() {
        if (this.liB != null) {
            this.liB.setForbidDragListener(true);
        }
    }

    public boolean dfG() {
        if (this.liB == null) {
            return false;
        }
        return this.liB.dfG();
    }

    public boolean diP() {
        if (this.iwT == null || TextUtils.isEmpty(this.iwT.getEndText())) {
            return false;
        }
        return this.iwT.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
