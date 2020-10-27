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
    private EditorTools abk;
    private View bxQ;
    private RelativeLayout byI;
    private View bzs;
    private f.c ePL;
    private com.baidu.tieba.pb.a.c fbT;
    private View foB;
    private NoNetworkView gbO;
    private List<CustomBlueCheckRadioButton> hUy;
    private boolean iBg;
    private View.OnClickListener iEe;
    private PbListView iJp;
    private boolean isLandscape;
    private TextView jEf;
    private NavigationBarCoverTip jew;
    private com.baidu.tieba.NEGFeedBack.e jhM;
    private PbFragment ljH;
    private View.OnClickListener lkE;
    private com.baidu.tieba.pb.data.f lkO;
    private PbFakeFloorModel lnf;
    PbFragment.c loZ;
    public int luY;
    private View lvK;
    private View lvM;
    private View lvN;
    private LinearLayout lvO;
    private HeadImageView lvP;
    private ImageView lvQ;
    private ImageView lvR;
    private ImageView lvS;
    private com.baidu.tieba.pb.view.c lvT;
    private TextView lvU;
    private TextView lvV;
    private int lvX;
    private int lvY;
    private PostData lvZ;
    public final com.baidu.tieba.pb.pb.main.view.c lva;
    public com.baidu.tieba.pb.pb.main.view.b lvb;
    private ViewStub lvc;
    private ViewStub lvd;
    private PbLandscapeListView lve;
    private PbThreadPostView lvf;
    private com.baidu.tieba.pb.pb.main.a.e lvg;
    private com.baidu.tieba.pb.pb.main.a.a lvh;
    private com.baidu.tieba.pb.pb.main.a.c lvi;
    private com.baidu.tieba.pb.pb.main.a.d lvj;
    private com.baidu.tieba.pb.pb.main.a.b lvk;
    private LinearLayout lvl;
    private TextView lvm;
    private TextView lvn;
    private ObservedChangeRelativeLayout lvo;
    private g lvp;
    private View lvv;
    private int lwC;
    private PbTopTipView lwD;
    private PopupWindow lwE;
    private TextView lwF;
    private List<String> lwG;
    private com.baidu.tieba.pb.pb.main.emotion.c lwH;
    private com.baidu.tieba.pb.pb.godreply.a lwI;
    private PbLandscapeListView.b lwJ;
    private al lwL;
    private String lwM;
    private long lwN;
    private int lwO;
    private boolean lwQ;
    private Runnable lwU;
    private PbFragment.b lwW;
    private ViewStub lwb;
    private PbInterviewStatusView lwc;
    private FrameLayout lwd;
    private View lwe;
    private View lwf;
    private au lwg;
    private PbEmotionBar lwl;
    private int lwt;
    private Runnable lwu;
    private v lwv;
    private av lww;
    public int lxa;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lwh = UtilHelper.getLightStatusBarHeight();
    public static int lwn = 3;
    public static int lwo = 0;
    public static int lwp = 3;
    public static int lwq = 4;
    public static int lwr = 5;
    public static int lws = 6;
    private static a.InterfaceC0836a lwP = new a.InterfaceC0836a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0836a
        public void onRefresh() {
        }
    };
    private int luZ = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lvq = null;
    private com.baidu.tbadk.core.dialog.b iEd = null;
    private View lvr = null;
    private EditText lvs = null;
    private com.baidu.tieba.pb.view.d lvt = null;
    private com.baidu.tieba.pb.view.a lvu = null;
    private b.InterfaceC0564b kcP = null;
    private TbRichTextView.i fAg = null;
    private NoNetworkView.a iyC = null;
    private com.baidu.tbadk.core.dialog.i lvw = null;
    private com.baidu.tbadk.core.dialog.a lvx = null;
    private Dialog lvy = null;
    private Dialog lvz = null;
    private View lvA = null;
    private LinearLayout lvB = null;
    private CompoundButton.OnCheckedChangeListener hUz = null;
    private TextView lvC = null;
    private TextView lvD = null;
    private String lvE = null;
    private com.baidu.tbadk.core.dialog.i lnU = null;
    private com.baidu.tbadk.core.dialog.i lvF = null;
    private boolean lvG = false;
    private boolean lvH = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lvI = null;
    private boolean lvJ = false;
    private Button lvL = null;
    private boolean lvW = true;
    private com.baidu.tbadk.core.view.a hYx = null;
    private boolean lkw = false;
    private int mSkinType = 3;
    private boolean lwa = false;
    private int lwi = 0;
    private boolean lwj = true;
    public a lwk = new a();
    private int lwm = 0;
    private boolean lwx = false;
    private int lwy = 0;
    private boolean lwz = false;
    private boolean lwA = false;
    private boolean lwB = false;
    private boolean lwK = false;
    private String lwR = null;
    private CustomMessageListener lwS = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.lwR = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.lvp != null) {
                az.this.lvp.notifyDataSetChanged();
            }
        }
    };
    private Handler lwT = new Handler();
    private CustomMessageListener lwV = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.lvW = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lwX = true;
    View.OnClickListener lwY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.lkO == null || az.this.lkO.dfI() == null || az.this.lkO.dfI().bka() == null || az.this.lkO.dfI().bka().getAlaInfo() == null || az.this.lkO.dfI().bka().getAlaInfo().live_status != 1) {
                if (az.this.lwz) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").aj("obj_id", 2));
                }
                if (!az.this.lwz && az.this.lkO != null && az.this.lkO.dfI() != null && az.this.lkO.dfI().bka() != null && az.this.lkO.dfI().bka().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").aj("obj_locate", 1));
                }
                if (az.this.ljH.diC() != null) {
                    az.this.ljH.diC().ljT.ikM.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (az.this.lkO.dfI().bka().getAlaInfo() == null || !az.this.lkO.dfI().bka().getAlaInfo().isChushou) {
                if (az.this.lkO.dfI().bka().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.lkO.dfI().bka().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.ljH.diC(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.be.boR().b(az.this.ljH.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.lkO.dfI().bka().getAlaInfo().thirdRoomId + "&livetype=" + az.this.lkO.dfI().bka().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bfi = false;
    String userId = null;
    private final List<TbImageView> lwZ = new ArrayList();
    private boolean lxb = false;

    /* loaded from: classes22.dex */
    public static class a {
        public int headerCount;
        public int laE;
        public au lxp;
    }

    public void ux(boolean z) {
        this.lwx = z;
        if (this.lve != null) {
            this.lwy = this.lve.getHeaderViewsCount();
        }
    }

    public void dkE() {
        if (this.lve != null) {
            int headerViewsCount = this.lve.getHeaderViewsCount() - this.lwy;
            final int firstVisiblePosition = (this.lve.getFirstVisiblePosition() == 0 || this.lve.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lve.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lve.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lwk.lxp = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lwk));
            final au auVar = this.lwk.lxp;
            final int g = g(auVar);
            final int y = ((int) this.lvo.getY()) + this.lvo.getMeasuredHeight();
            final boolean z = this.lwe.getVisibility() == 0;
            boolean z2 = this.lvo.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.lvp.dhv() + this.lve.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.luz.getMeasuredHeight() : 0;
                if (z2) {
                    this.lve.setSelectionFromTop(this.lvp.dhv() + this.lve.getHeaderViewsCount(), lwh - measuredHeight);
                } else {
                    this.lve.setSelectionFromTop(this.lvp.dhv() + this.lve.getHeaderViewsCount(), this.lva.dmC().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lve.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lwz && this.lvg != null) {
                this.lve.setSelectionFromTop(this.lvp.dhv() + this.lve.getHeaderViewsCount(), this.lvg.dmo());
            } else if (this.mType == 6) {
                this.lve.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.byI.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bzs != null && (layoutParams = az.this.bzs.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.byI.getMeasuredHeight() || g2 >= az.this.byI.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lwt;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.byI.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lwt;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.lve.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bzs.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bzs != null && az.this.bzs.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bzs.getLayoutParams();
                                            layoutParams2.height = az.this.lwt;
                                            az.this.bzs.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.lve.setOnLayoutListener(null);
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

    public NoNetworkView dkF() {
        return this.gbO;
    }

    public void dkG() {
        if (this.abk != null) {
            this.abk.hide();
            if (this.lwH != null) {
                this.lwH.dmq();
            }
        }
    }

    public PbFakeFloorModel dkH() {
        return this.lnf;
    }

    public v dkI() {
        return this.lwv;
    }

    public com.baidu.tieba.pb.pb.main.a.e dkJ() {
        return this.lvg;
    }

    public void dkK() {
        reset();
        dkG();
        this.lwv.dhD();
        uJ(false);
    }

    private void reset() {
        if (this.ljH != null && this.ljH.dhI() != null && this.abk != null) {
            com.baidu.tbadk.editortools.pb.a.bxB().setStatus(0);
            com.baidu.tbadk.editortools.pb.e dhI = this.ljH.dhI();
            dhI.bxW();
            dhI.bxl();
            if (dhI.getWriteImagesInfo() != null) {
                dhI.getWriteImagesInfo().setMaxImagesAllowed(dhI.isBJH ? 1 : 9);
            }
            dhI.rk(SendView.ALL);
            dhI.rl(SendView.ALL);
            com.baidu.tbadk.editortools.h qX = this.abk.qX(23);
            com.baidu.tbadk.editortools.h qX2 = this.abk.qX(2);
            com.baidu.tbadk.editortools.h qX3 = this.abk.qX(5);
            if (qX2 != null) {
                qX2.display();
            }
            if (qX3 != null) {
                qX3.display();
            }
            if (qX != null) {
                qX.hide();
            }
            this.abk.invalidate();
        }
    }

    public boolean dkL() {
        return this.lvW;
    }

    public void uy(boolean z) {
        if (this.lvN != null && this.jEf != null) {
            this.jEf.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lvN.startAnimation(alphaAnimation);
            }
            this.lvM.setVisibility(0);
            this.lvN.setVisibility(0);
            this.lvW = true;
            if (this.lwl != null && !this.lwI.isActive()) {
                this.lwl.setVisibility(0);
                uD(true);
            }
        }
    }

    public void uz(boolean z) {
        if (this.lvN != null && this.jEf != null) {
            this.jEf.setText(dkM());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lvN.startAnimation(alphaAnimation);
            }
            this.lvM.setVisibility(0);
            this.lvN.setVisibility(0);
            this.lvW = true;
            if (this.lwl != null && !this.lwI.isActive()) {
                this.lwl.setVisibility(0);
                uD(true);
            }
        }
    }

    public String dkM() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lwM)) {
            return this.lwM;
        }
        if (this.ljH != null) {
            this.lwM = TbadkCoreApplication.getInst().getResources().getString(ay.dkB());
        }
        return this.lwM;
    }

    public PostData dkN() {
        int i = 0;
        if (this.lve == null) {
            return null;
        }
        int dkO = dkO() - this.lve.getHeaderViewsCount();
        if (dkO < 0) {
            dkO = 0;
        }
        if (this.lvp.Fv(dkO) != null && this.lvp.Fv(dkO) != PostData.mQM) {
            i = dkO + 1;
        }
        return this.lvp.getItem(i) instanceof PostData ? (PostData) this.lvp.getItem(i) : null;
    }

    public int dkO() {
        int i;
        View childAt;
        if (this.lve == null) {
            return 0;
        }
        int firstVisiblePosition = this.lve.getFirstVisiblePosition();
        int lastVisiblePosition = this.lve.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lve.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lve.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dkP() {
        return this.lve.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lkO != null && this.lkO.dfK() != null && !this.lkO.dfK().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lkO.dfK().size() && (postData = this.lkO.dfK().get(i)) != null && postData.bka() != null && !StringUtils.isNull(postData.bka().getUserId()); i++) {
                if (this.lkO.dfK().get(i).bka().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lwI != null && this.lwI.isActive()) {
                        uJ(false);
                    }
                    if (this.lwl != null) {
                        this.lwl.uT(true);
                    }
                    this.lwR = postData.bka().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.ljH = null;
        this.byI = null;
        this.bxQ = null;
        this.lve = null;
        this.lvp = null;
        this.iJp = null;
        this.foB = null;
        this.iEe = null;
        this.lkE = null;
        this.lvN = null;
        this.jEf = null;
        this.lwb = null;
        this.lwC = 0;
        this.lwN = 0L;
        this.lwN = System.currentTimeMillis();
        this.ljH = pbFragment;
        this.iEe = onClickListener;
        this.fbT = cVar;
        this.lwC = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ljH.getContext()) / 8;
        this.byI = (RelativeLayout) LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.byI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lvK = this.byI.findViewById(R.id.bottom_shadow);
        this.jew = (NavigationBarCoverTip) this.byI.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bxQ = this.byI.findViewById(R.id.statebar_view);
        this.lvo = (ObservedChangeRelativeLayout) this.byI.findViewById(R.id.title_wrapper);
        this.gbO = (NoNetworkView) this.byI.findViewById(R.id.view_no_network);
        this.lve = (PbLandscapeListView) this.byI.findViewById(R.id.new_pb_list);
        this.lwd = (FrameLayout) this.byI.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.ljH.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.ljH.getActivity(), R.dimen.ds88));
        this.lve.addHeaderView(this.textView, 0);
        this.lve.setTextViewAdded(true);
        this.lwt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bzs = new View(this.ljH.getPageContext().getPageActivity());
        this.bzs.setLayoutParams(new AbsListView.LayoutParams(-1, this.lwt));
        this.bzs.setVisibility(4);
        this.lve.addFooterView(this.bzs);
        this.lve.setOnTouchListener(this.ljH.ftj);
        this.lva = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.byI);
        if (this.ljH.dil()) {
            this.lvc = (ViewStub) this.byI.findViewById(R.id.manga_view_stub);
            this.lvc.setVisibility(0);
            this.lvb = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lvb.show();
            this.lva.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.ljH.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lva.dmC().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0791a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0791a
            public void dgI() {
                if (az.this.lve != null) {
                    if (az.this.lvg != null) {
                        az.this.lvg.dmn();
                    }
                    az.this.lve.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0791a
            public void dgJ() {
                az.this.ljH.cwk();
            }
        }));
        this.lvM = this.byI.findViewById(R.id.view_comment_top_line);
        this.lvN = this.byI.findViewById(R.id.pb_editor_tool_comment);
        this.lvX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lvY = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lvP = (HeadImageView) this.byI.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lvP.setVisibility(0);
        this.lvP.setIsRound(true);
        this.lvP.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.ljH.getContext(), R.dimen.tbds1));
        this.lvP.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
        this.lvP.setPlaceHolder(1);
        this.lvP.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lvP.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jEf = (TextView) this.byI.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lvO = (LinearLayout) this.byI.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lvO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.ljH.dhT();
                if (az.this.ljH != null && az.this.ljH.dgX() != null && az.this.ljH.dgX().getPbData() != null && az.this.ljH.dgX().getPbData().dfI() != null && az.this.ljH.dgX().getPbData().dfI().bka() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dR("tid", az.this.ljH.dgX().diW()).dR("fid", az.this.ljH.dgX().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", az.this.ljH.dgX().lrg).dR("fid", az.this.ljH.dgX().getPbData().getForumId()).aj("obj_locate", 1).dR("uid", az.this.ljH.dgX().getPbData().dfI().bka().getUserId()));
                }
            }
        });
        this.lvQ = (ImageView) this.byI.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lvQ.setOnClickListener(this.iEe);
        boolean booleanExtra = this.ljH.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lvR = (ImageView) this.byI.findViewById(R.id.pb_editor_tool_collection);
        this.lvR.setOnClickListener(this.iEe);
        if (booleanExtra) {
            this.lvR.setVisibility(8);
        } else {
            this.lvR.setVisibility(0);
        }
        this.lvS = (ImageView) this.byI.findViewById(R.id.pb_editor_tool_share);
        this.lvS.setOnClickListener(this.iEe);
        this.lvT = new com.baidu.tieba.pb.view.c(this.lvS);
        this.lvT.dpV();
        this.lvU = (TextView) this.byI.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lvU.setVisibility(0);
        this.lwb = (ViewStub) this.byI.findViewById(R.id.interview_status_stub);
        this.lvh = new com.baidu.tieba.pb.pb.main.a.a(this.ljH, cVar);
        this.lvj = new com.baidu.tieba.pb.pb.main.a.d(this.ljH, cVar, this.iEe);
        this.lvp = new g(this.ljH, this.lve);
        this.lvp.F(this.iEe);
        this.lvp.setTbGestureDetector(this.fbT);
        this.lvp.setOnImageClickListener(this.fAg);
        this.lvp.setOnSwitchChangeListener(this.ljH.loS);
        this.lkE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.ljH.c(sparseArray);
                            return;
                        }
                        az.this.dk(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.ljH.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lvp.S(this.lkE);
        dkU();
        dkV();
        this.lvj.b(this.lve);
        this.lvi.b(this.lve);
        this.lvh.b(this.lve);
        this.iJp = new PbListView(this.ljH.getPageContext().getPageActivity());
        this.foB = this.iJp.getView().findViewById(R.id.pb_more_view);
        if (this.foB != null) {
            this.foB.setOnClickListener(this.iEe);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.foB, R.drawable.pb_foot_more_trans_selector);
        }
        this.iJp.setLineVisible();
        this.iJp.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iJp.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lvv = this.byI.findViewById(R.id.viewstub_progress);
        this.ljH.registerListener(this.lwV);
        this.lnf = new PbFakeFloorModel(this.ljH.getPageContext());
        this.lwv = new v(this.ljH.getPageContext(), this.lnf, this.byI);
        this.lwv.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dkK();
            }
        });
        this.lwv.a(this.ljH.loU);
        this.lnf.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.lnf.t(postData);
                az.this.lvp.notifyDataSetChanged();
                az.this.lwv.dhD();
                az.this.abk.bvv();
                az.this.uJ(false);
            }
        });
        if (this.ljH.dgX() != null && !StringUtils.isNull(this.ljH.dgX().djE())) {
            this.ljH.showToast(this.ljH.dgX().djE());
        }
        this.lwe = this.byI.findViewById(R.id.pb_expand_blank_view);
        this.lwf = this.byI.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lwf.getLayoutParams();
        if (this.ljH.dgX() != null && this.ljH.dgX().diZ()) {
            this.lwe.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lwf.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lwh;
            this.lwf.setLayoutParams(layoutParams2);
        }
        this.lwg = new au(this.ljH.getPageContext(), this.byI.findViewById(R.id.pb_reply_expand_view));
        this.lwg.v(pbFragment.lnK);
        this.lwg.luz.setVisibility(8);
        this.lwg.U(this.iEe);
        this.lwg.setOnSwitchChangeListener(this.ljH.loS);
        this.ljH.registerListener(this.mAccountChangedListener);
        this.ljH.registerListener(this.lwS);
        dkQ();
        uD(false);
    }

    public void uA(boolean z) {
        this.lvK.setVisibility(z ? 0 : 8);
    }

    public void cJB() {
        if (!this.ljH.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").aj("obj_locate", 2).dR("fid", this.mForumId));
        } else if (this.ljH.dhV()) {
            com.baidu.tbadk.editortools.pb.e dhI = this.ljH.dhI();
            if (dhI != null && (dhI.bxT() || dhI.bxU())) {
                this.ljH.dhI().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abk != null) {
                dla();
            }
            if (this.abk != null) {
                this.lvW = false;
                if (this.abk.ra(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.ljH.getPageContext(), (View) this.abk.ra(2).fhv, false, lwP);
                }
            }
            dlI();
        }
    }

    private void dkQ() {
        this.lwI = new com.baidu.tieba.pb.pb.godreply.a(this.ljH, this, (ViewStub) this.byI.findViewById(R.id.more_god_reply_popup));
        this.lwI.A(this.iEe);
        this.lwI.S(this.lkE);
        this.lwI.setOnImageClickListener(this.fAg);
        this.lwI.A(this.iEe);
        this.lwI.setTbGestureDetector(this.fbT);
    }

    public com.baidu.tieba.pb.pb.godreply.a dkR() {
        return this.lwI;
    }

    public View dkS() {
        return this.lwe;
    }

    public void dkT() {
        if (this.lve != null) {
            this.lvi.c(this.lve);
            this.lvj.c(this.lve);
            this.lvk.c(this.lve);
            this.lvh.c(this.lve);
        }
    }

    private void dkU() {
        if (this.lvk == null) {
            this.lvk = new com.baidu.tieba.pb.pb.main.a.b(this.ljH, this.iEe);
        }
    }

    private void dkV() {
        if (this.lvi == null) {
            this.lvi = new com.baidu.tieba.pb.pb.main.a.c(this.ljH, this.fbT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkW() {
        if (this.ljH.dil()) {
            this.lvd = (ViewStub) this.byI.findViewById(R.id.manga_mention_controller_view_stub);
            this.lvd.setVisibility(0);
            if (this.lvl == null) {
                this.lvl = (LinearLayout) this.byI.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.ljH.getPageContext(), this.lvl);
            }
            if (this.lvm == null) {
                this.lvm = (TextView) this.lvl.findViewById(R.id.manga_prev_btn);
            }
            if (this.lvn == null) {
                this.lvn = (TextView) this.lvl.findViewById(R.id.manga_next_btn);
            }
            this.lvm.setOnClickListener(this.iEe);
            this.lvn.setOnClickListener(this.iEe);
        }
    }

    private void dkX() {
        if (this.ljH.dil()) {
            if (this.ljH.dio() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvm, R.color.cp_cont_e, 1);
            }
            if (this.ljH.dip() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvn, R.color.cp_cont_e, 1);
            }
        }
    }

    public void dkY() {
        if (this.lvl == null) {
            dkW();
        }
        this.lvd.setVisibility(8);
        if (this.lwT != null && this.lwU != null) {
            this.lwT.removeCallbacks(this.lwU);
        }
    }

    public void dkZ() {
        if (this.lwT != null) {
            if (this.lwU != null) {
                this.lwT.removeCallbacks(this.lwU);
            }
            this.lwU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.lvl == null) {
                        az.this.dkW();
                    }
                    az.this.lvd.setVisibility(0);
                }
            };
            this.lwT.postDelayed(this.lwU, 2000L);
        }
    }

    public void uB(boolean z) {
        this.lva.uB(z);
        if (z && this.lwa) {
            this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lve.setNextPage(this.iJp);
            this.luZ = 2;
        }
        if (this.lvP != null) {
            this.lvP.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
        this.abk.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dkK();
            }
        });
        this.abk.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abk.getParent() == null) {
            this.byI.addView(this.abk, layoutParams);
        }
        this.abk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abk.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bsm() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bsm() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.ljH.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.ljH.getBaseFragmentActivity())) {
                            az.this.ljH.dhI().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.ljH.dhI().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dkG();
        this.ljH.dhI().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.abk != null && az.this.abk.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.lwH == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.abk.getId());
                            az.this.lwH = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.ljH.getPageContext(), az.this.byI, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.lwG)) {
                                az.this.lwH.setData(az.this.lwG);
                            }
                            az.this.lwH.c(az.this.abk);
                        }
                        az.this.lwH.PE(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.ljH.ktH != null && az.this.ljH.ktH.dlZ() != null) {
                    if (!az.this.ljH.ktH.dlZ().dQu()) {
                        az.this.ljH.ktH.uP(false);
                    }
                    az.this.ljH.ktH.dlZ().yh(false);
                }
            }
        });
    }

    public void dla() {
        if (this.ljH != null && this.abk != null) {
            this.abk.display();
            if (this.ljH.dhI() != null) {
                this.ljH.dhI().bxJ();
            }
            dlI();
        }
    }

    public void uC(boolean z) {
        if (this.lve != null && this.textView != null && this.bxQ != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bxQ.setVisibility(0);
                } else {
                    this.bxQ.setVisibility(8);
                    this.lve.removeHeaderView(this.textView);
                    this.lve.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lwh;
                    this.textView.setLayoutParams(layoutParams);
                }
                dlo();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + uL(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dlo();
            dlQ();
        }
    }

    public g dlb() {
        return this.lvp;
    }

    public void a(PbFragment.c cVar) {
        this.loZ = cVar;
    }

    public void dk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.ljH.getContext());
        kVar.setTitleText(this.ljH.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lvw.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.lwW != null) {
                                az.this.lwW.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.ljH.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.ljH.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.ljH.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dlP()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.ljH.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.ljH.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.ljH.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bk(arrayList);
        this.lvw = new com.baidu.tbadk.core.dialog.i(this.ljH.getPageContext(), kVar);
        this.lvw.PJ();
    }

    public void a(PbFragment.b bVar) {
        this.lwW = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.ljH != null && aVar != null) {
            if (this.jhM == null && this.lvh != null) {
                this.jhM = new com.baidu.tieba.NEGFeedBack.e(this.ljH.getPageContext(), this.lvh.dmj());
            }
            AntiData cuM = this.ljH.cuM();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cuM != null && cuM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cuM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.jhM.setDefaultReasonArray(new String[]{this.ljH.getString(R.string.delete_thread_reason_1), this.ljH.getString(R.string.delete_thread_reason_2), this.ljH.getString(R.string.delete_thread_reason_3), this.ljH.getString(R.string.delete_thread_reason_4), this.ljH.getString(R.string.delete_thread_reason_5)});
            this.jhM.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jhM.EG(str);
            this.jhM.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.ljH.a(aVar, jSONArray);
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
        sparseArray.put(lwo, Integer.valueOf(lwp));
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
        this.lvx = new com.baidu.tbadk.core.dialog.a(this.ljH.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lvx.om(i3);
        } else {
            this.lvx.setOnlyMessageShowCenter(false);
            this.lvx.Ba(str2);
        }
        this.lvx.setYesButtonTag(sparseArray);
        this.lvx.a(R.string.dialog_ok, this.ljH);
        this.lvx.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lvx.iM(true);
        this.lvx.b(this.ljH.getPageContext());
        if (z) {
            this.lvx.bmC();
        } else {
            a(this.lvx, i);
        }
    }

    public void bc(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.lvA == null) {
            this.lvA = LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.ljH.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lvA);
        if (this.lvz == null) {
            this.lvz = new Dialog(this.ljH.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lvz.setCanceledOnTouchOutside(true);
            this.lvz.setCancelable(true);
            this.lvI = (ScrollView) this.lvA.findViewById(R.id.good_scroll);
            this.lvz.setContentView(this.lvA);
            WindowManager.LayoutParams attributes = this.lvz.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lvz.getWindow().setAttributes(attributes);
            this.hUz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.lvE = (String) compoundButton.getTag();
                        if (az.this.hUy != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.hUy) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.lvE != null && !str.equals(az.this.lvE)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lvB = (LinearLayout) this.lvA.findViewById(R.id.good_class_group);
            this.lvD = (TextView) this.lvA.findViewById(R.id.dialog_button_cancel);
            this.lvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.lvz instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.lvz, az.this.ljH.getPageContext());
                    }
                }
            });
            this.lvC = (TextView) this.lvA.findViewById(R.id.dialog_button_ok);
            this.lvC.setOnClickListener(this.iEe);
        }
        this.lvB.removeAllViews();
        this.hUy = new ArrayList();
        CustomBlueCheckRadioButton fT = fT("0", this.ljH.getPageContext().getString(R.string.thread_good_class));
        this.hUy.add(fT);
        fT.setChecked(true);
        this.lvB.addView(fT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bio()) && ajVar.bip() > 0) {
                    CustomBlueCheckRadioButton fT2 = fT(String.valueOf(ajVar.bip()), ajVar.bio());
                    this.hUy.add(fT2);
                    View view = new View(this.ljH.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.lvB.addView(view);
                    this.lvB.addView(fT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lvI.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.ljH.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.ljH.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.ljH.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lvI.setLayoutParams(layoutParams2);
            this.lvI.removeAllViews();
            if (this.lvB != null && this.lvB.getParent() == null) {
                this.lvI.addView(this.lvB);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lvz, this.ljH.getPageContext());
    }

    private CustomBlueCheckRadioButton fT(String str, String str2) {
        Activity pageActivity = this.ljH.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hUz);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dlc() {
        this.ljH.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ljH.hideProgressBar();
        if (z && z2) {
            this.ljH.showToast(this.ljH.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.ljH.showToast(str);
        }
    }

    public void cQT() {
        this.lvv.setVisibility(0);
    }

    public void cQS() {
        this.lvv.setVisibility(8);
    }

    public View dld() {
        if (this.lvA != null) {
            return this.lvA.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dle() {
        return this.lvE;
    }

    public View getView() {
        return this.byI;
    }

    public void dlf() {
        if (this.ljH != null && this.ljH.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.ljH.getPageContext().getPageActivity(), this.ljH.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.ljH.hideProgressBar();
        if (z) {
            dly();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dlz();
        } else {
            dly();
        }
    }

    public void dlg() {
        this.iJp.setLineVisible();
        this.iJp.startLoadData();
    }

    public void dlh() {
        this.ljH.hideProgressBar();
        endLoadData();
        this.lve.completePullRefreshPostDelayed(0L);
        dlt();
    }

    public void dli() {
        this.lve.completePullRefreshPostDelayed(0L);
        dlt();
    }

    private void uD(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lvj.b(onLongClickListener);
        this.lvp.setOnLongClickListener(onLongClickListener);
        if (this.lwI != null) {
            this.lwI.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0564b interfaceC0564b, boolean z, boolean z2) {
        if (this.lnU != null) {
            this.lnU.dismiss();
            this.lnU = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.ljH.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.ljH.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.ljH.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.ljH.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.ljH.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bk(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lvF.dismiss();
                interfaceC0564b.a(null, i, view);
            }
        });
        this.lvF = new com.baidu.tbadk.core.dialog.i(this.ljH.getPageContext(), kVar);
        this.lvF.PJ();
    }

    public void a(final b.InterfaceC0564b interfaceC0564b, boolean z) {
        if (this.lvF != null) {
            this.lvF.dismiss();
            this.lvF = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.ljH.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lkO != null && this.lkO.dfI() != null && !this.lkO.dfI().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.ljH.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.ljH.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bk(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lvF.dismiss();
                interfaceC0564b.a(null, i, view);
            }
        });
        this.lvF = new com.baidu.tbadk.core.dialog.i(this.ljH.getPageContext(), kVar);
        this.lvF.PJ();
    }

    public int dlj() {
        return FU(this.lve.getFirstVisiblePosition());
    }

    private int FU(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.lve.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lve.getAdapter() == null || !(this.lve.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.lve.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dlk() {
        int lastVisiblePosition = this.lve.getLastVisiblePosition();
        if (this.lvg != null) {
            if (lastVisiblePosition == this.lve.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return FU(lastVisiblePosition);
    }

    public void FV(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lve != null) {
            if (this.lva == null || this.lva.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lva.mNavigationBar.getFixedNavHeight();
                if (this.ljH.dib() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lwf != null && (layoutParams = (LinearLayout.LayoutParams) this.lwf.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lwf.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lve.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lve.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lve.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lvs.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lvp.a(fVar, false);
        this.lvp.notifyDataSetChanged();
        dlt();
        if (this.lwI != null) {
            this.lwI.bKe();
        }
        ArrayList<PostData> dfK = fVar.dfK();
        if (fVar.getPage().biQ() == 0 || dfK == null || dfK.size() < fVar.getPage().biP()) {
            if (com.baidu.tbadk.core.util.y.getCount(dfK) == 0 || (com.baidu.tbadk.core.util.y.getCount(dfK) == 1 && dfK.get(0) != null && dfK.get(0).dHx() == 1)) {
                if (this.lwk == null || this.lwk.lxp == null || this.lwk.lxp.getView() == null) {
                    i = 0;
                } else {
                    i = this.lwk.lxp.getView().getTop() < 0 ? this.lwk.lxp.getView().getHeight() : this.lwk.lxp.getView().getBottom();
                }
                if (this.ljH.div()) {
                    this.iJp.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.iJp.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().biQ() == 0) {
                    this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iJp.bpU();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lvh != null) {
            this.lvh.e(fVar, this.lkw);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dfV() != null) {
            return fVar.dfV();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dfK())) {
            Iterator<PostData> it = fVar.dfK().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dHx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dfR();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bka() != null && postData.bka().getUserTbVipInfoData() != null && postData.bka().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bka().getGodUserData().setIntro(postData.bka().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bka() == null) {
            return false;
        }
        MetaData bka = postData.bka();
        return (TextUtils.isEmpty(bka.getUserId()) && TextUtils.isEmpty(bka.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dfI() == null || fVar.dfI().bka() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bka = fVar.dfI().bka();
        String userId = bka.getUserId();
        HashMap<String, MetaData> userMap = fVar.dfI().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bka;
        }
        postData.Jq(1);
        postData.setId(fVar.dfI().bkr());
        postData.setTitle(fVar.dfI().getTitle());
        postData.setTime(fVar.dfI().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dfI() != null) {
            if (this.ljH.dgO()) {
                if (fVar.dfH() != null) {
                    this.mForumName = fVar.dfH().getForumName();
                    this.mForumId = fVar.dfH().getForumId();
                }
                if (this.mForumName == null && this.ljH.dgX() != null && this.ljH.dgX().dgP() != null) {
                    this.mForumName = this.ljH.dgX().dgP();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.lvj.setVisibility(8);
            if (fVar.dgi()) {
                this.lwz = true;
                this.lva.va(true);
                this.lva.mNavigationBar.hideBottomLine();
                if (this.lvg == null) {
                    this.lvg = new com.baidu.tieba.pb.pb.main.a.e(this.ljH);
                }
                this.lvg.a(fVar, b, this.lve, this.lvj, this.lwd, this.lva, this.mForumName, this.lwN);
                this.lvg.V(this.lwY);
                dlo();
            } else {
                this.lwz = false;
                this.lva.va(this.lwz);
                if (this.lvg != null) {
                    this.lvg.c(this.lve);
                }
            }
            if (this.ljH.dhL() != null) {
                this.ljH.dhL().uU(this.lwz);
            }
            if (b != null) {
                this.lvZ = b;
                this.lvj.setVisibility(0);
                SparseArray<Object> dmm = this.lvj.dmm();
                dmm.put(R.id.tag_clip_board, b);
                dmm.put(R.id.tag_is_subpb, false);
                this.lvk.a(fVar, this.lve);
                this.lvi.A(fVar);
                this.lvh.e(fVar, this.lkw);
                this.lvh.z(fVar);
                this.lvj.a(this.mSkinType, this.lkO, b, this.lwY);
                if (this.lwg != null) {
                    if (fVar.dgl()) {
                        this.lwg.getView().setVisibility(8);
                    } else {
                        this.lwg.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lim);
                        if (fVar.dfI() != null) {
                            nVar.lio = fVar.dfI().bjR();
                        }
                        nVar.isNew = !this.lkw;
                        nVar.sortType = fVar.lgY;
                        nVar.liq = fVar.dgm();
                        nVar.lir = this.ljH.div();
                        nVar.lis = fVar.lgX;
                        this.lwg.a(nVar);
                    }
                }
                if (fVar != null && fVar.dfI() != null) {
                    at(fVar.dfI().bjW() == 1, fVar.dfI().bjV() == 1);
                }
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.lvp != null && az.this.lva != null && az.this.lva.lBt != null && az.this.lkO != null && az.this.lkO.dfI() != null && !az.this.lkO.dfI().biG() && !az.this.dls() && az.this.lkO.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(az.this.lkO.getForum().getName())) {
                            if ((az.this.lvp.dhz() == null || !az.this.lvp.dhz().isShown()) && az.this.lva.lBt != null) {
                                az.this.lva.lBt.setVisibility(0);
                                if (az.this.ljH != null && az.this.ljH.dgX() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dR("tid", az.this.ljH.dgX().diV());
                                    aqVar.dR("fid", az.this.ljH.dgX().getForumId());
                                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void uE(boolean z) {
        if (z) {
            dll();
        } else {
            cpK();
        }
        this.lwk.lxp = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lwk));
        a(this.lwk.lxp, false);
    }

    public void dll() {
        if (this.lva != null && !this.lwB) {
            this.lva.dll();
            this.lwB = true;
        }
    }

    public void cpK() {
        if (this.lva != null) {
            this.lva.dmK();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lvj.a(postData, fVar);
    }

    public void dlm() {
        if (this.lvg != null) {
            this.lvg.d(this.lve);
        }
    }

    public boolean dln() {
        return this.bfi;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bka() == null) {
            return false;
        }
        PostData b = b(this.lkO, false);
        String str = "";
        if (b != null && b.bka() != null) {
            str = b.bka().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lva.dmI();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lva.No(dVar.forumName);
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
            final String str2 = dVar.lgP;
            this.ljH.showNetRefreshView(this.byI, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.be.boR().b(az.this.ljH.getPageContext(), new String[]{str2});
                        az.this.ljH.finish();
                        return;
                    }
                    az.this.ljH.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dkr;
        Parcelable dkr2;
        if (fVar != null && this.lve != null) {
            this.lkO = fVar;
            this.mType = i;
            if (fVar.dfI() != null) {
                this.lwm = fVar.dfI().bjH();
                if (fVar.dfI().getAnchorLevel() != 0) {
                    this.bfi = true;
                }
                this.lvH = aK(fVar.dfI());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lwa = false;
            this.lkw = z;
            dlh();
            if (fVar.lgZ != null && fVar.lgZ.dgr()) {
                if (this.lvf == null) {
                    this.lvf = new PbThreadPostView(this.ljH.getContext());
                    this.lve.addHeaderView(this.lvf, 1);
                    this.lvf.setData(fVar);
                    this.lvf.setChildOnClickLinstener(this.iEe);
                }
            } else if (this.lvf != null && this.lve != null) {
                this.lve.removeHeaderView(this.lvf);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lwL == null) {
                this.lwL = new al(this.ljH.getPageContext(), this.jew);
            }
            this.lwL.Pu(fVar.dfP());
            if (this.ljH.dil()) {
                if (this.lvt == null) {
                    this.lvt = new com.baidu.tieba.pb.view.d(this.ljH.getPageContext());
                    this.lvt.createView();
                    this.lvt.setListPullRefreshListener(this.ePL);
                }
                this.lve.setPullRefresh(this.lvt);
                dlo();
                if (this.lvt != null) {
                    this.lvt.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().biR() == 0 && z) {
                this.lve.setPullRefresh(null);
            } else {
                if (this.lvt == null) {
                    this.lvt = new com.baidu.tieba.pb.view.d(this.ljH.getPageContext());
                    this.lvt.createView();
                    this.lvt.setListPullRefreshListener(this.ePL);
                }
                this.lve.setPullRefresh(this.lvt);
                dlo();
                if (this.lvt != null) {
                    this.lvt.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                ceD();
            }
            dlt();
            this.lvp.tL(this.lkw);
            this.lvp.tM(false);
            this.lvp.tQ(i == 5);
            this.lvp.tR(i == 6);
            this.lvp.tS(z2 && this.lwX && i != 2);
            this.lvp.a(fVar, false);
            this.lvp.notifyDataSetChanged();
            this.lvj.b(b(fVar, z), fVar.dgl());
            if (fVar.dfI() != null && fVar.dfI().bjL() != null && this.luY != -1) {
                fVar.dfI().bjL().setIsLike(this.luY);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.lve.setNextPage(this.iJp);
                this.luZ = 2;
                ceD();
            } else {
                this.lwa = true;
                if (fVar.getPage().biQ() == 1) {
                    if (this.lvu == null) {
                        this.lvu = new com.baidu.tieba.pb.view.a(this.ljH, this.ljH);
                    }
                    this.lve.setNextPage(this.lvu);
                } else {
                    this.lve.setNextPage(this.iJp);
                }
                this.luZ = 3;
            }
            ArrayList<PostData> dfK = fVar.dfK();
            if (fVar.getPage().biQ() == 0 || dfK == null || dfK.size() < fVar.getPage().biP()) {
                if (com.baidu.tbadk.core.util.y.getCount(dfK) == 0 || (com.baidu.tbadk.core.util.y.getCount(dfK) == 1 && dfK.get(0) != null && dfK.get(0).dHx() == 1)) {
                    if (this.lwk == null || this.lwk.lxp == null || this.lwk.lxp.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lwk.lxp.getView().getTop() < 0 ? this.lwk.lxp.getView().getHeight() : this.lwk.lxp.getView().getBottom();
                    }
                    if (this.ljH.div()) {
                        this.iJp.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.iJp.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.ljH.dhL() != null && !this.ljH.dhL().dmw()) {
                        this.ljH.dhL().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().biQ() == 0) {
                        this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iJp.bpU();
                }
                if (fVar.getPage().biQ() == 0 || dfK == null) {
                    dlD();
                }
            } else {
                if (z2) {
                    if (this.lwX) {
                        endLoadData();
                        if (fVar.getPage().biQ() != 0) {
                            this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iJp.setLineVisible();
                        this.iJp.showLoading();
                    }
                } else {
                    this.iJp.setLineVisible();
                    this.iJp.showLoading();
                }
                this.iJp.bpU();
            }
            switch (i) {
                case 2:
                    this.lve.setSelection(i2 > 1 ? (((this.lve.getData() == null && fVar.dfK() == null) ? 0 : (this.lve.getData().size() - fVar.dfK().size()) + this.lve.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dkr2 = as.dkq().dkr()) != null && !(dkr2 instanceof RecyclerView.SavedState)) {
                        this.lve.onRestoreInstanceState(dkr2);
                        if (com.baidu.tbadk.core.util.y.getCount(dfK) > 1 && fVar.getPage().biQ() > 0) {
                            this.iJp.endLoadData();
                            this.iJp.setText(this.ljH.getString(R.string.pb_load_more_without_point));
                            this.iJp.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lwX = false;
                    break;
                case 5:
                    this.lve.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dkr = as.dkq().dkr()) != null && !(dkr instanceof RecyclerView.SavedState)) {
                        this.lve.onRestoreInstanceState(dkr);
                        break;
                    } else {
                        this.lve.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lvg != null && this.lvg.bMO() != null) {
                            if (this.ljH.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lve.setSelectionFromTop((this.lvp.dhu() + this.lve.getHeaderViewsCount()) - 1, this.lvg.dmo() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.ljH.getPageContext().getPageActivity()));
                            } else {
                                this.lve.setSelectionFromTop((this.lvp.dhu() + this.lve.getHeaderViewsCount()) - 1, this.lvg.dmo());
                            }
                        } else {
                            this.lve.setSelection(this.lvp.dhu() + this.lve.getHeaderViewsCount());
                        }
                    } else {
                        this.lve.setSelection(i2 > 0 ? ((this.lve.getData() == null && fVar.dfK() == null) ? 0 : (this.lve.getData().size() - fVar.dfK().size()) + this.lve.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.iJp.endLoadData();
                    this.iJp.setText(this.ljH.getString(R.string.pb_load_more_without_point));
                    this.iJp.setLineGone();
                    break;
            }
            if (this.lwm == lwn && isHost()) {
                dlL();
            }
            if (this.lwx) {
                dkE();
                this.lwx = false;
                if (i3 == 0) {
                    ux(true);
                }
            }
            if (fVar.lgV == 1 || fVar.lgW == 1) {
                if (this.lwD == null) {
                    this.lwD = new PbTopTipView(this.ljH.getContext());
                }
                if (fVar.lgW == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.ljH.getStType())) {
                    this.lwD.setText(this.ljH.getString(R.string.pb_read_strategy_add_experience));
                    this.lwD.a(this.byI, this.mSkinType);
                } else if (fVar.lgV == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.ljH.getStType())) {
                    this.lwD.setText(this.ljH.getString(R.string.pb_read_news_add_experience));
                    this.lwD.a(this.byI, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            x(fVar);
            if (fVar.bfV()) {
                SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String FW = FW(fVar.dfI().bjR());
            if (this.lvU != null) {
                this.lvU.setText(FW);
            }
            if (this.lvV != null) {
                this.lvV.setText(FW);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dfI()));
        }
    }

    private String FW(int i) {
        if (i == 0) {
            return this.ljH.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dlo() {
        if (this.lvg != null) {
            this.lvg.a(this.lve, this.textView, this.mType);
        }
    }

    public void uF(boolean z) {
        this.lvG = z;
    }

    public void endLoadData() {
        if (this.iJp != null) {
            this.iJp.setLineGone();
            this.iJp.endLoadData();
        }
        ceD();
    }

    public void bSR() {
        this.lve.setVisibility(0);
    }

    public void dlp() {
        if (this.lve != null) {
            this.lve.setVisibility(8);
        }
        if (this.lve != null) {
            this.lwd.setVisibility(8);
        }
        if (this.lva != null && this.lva.lBs != null) {
            this.lva.lBs.setVisibility(8);
        }
    }

    public void dlq() {
        if (this.lve != null) {
            this.lve.setVisibility(0);
        }
        if (this.lwd != null) {
            this.lwd.setVisibility(0);
        }
        if (this.lva != null && this.lva.lBs != null) {
            this.lva.lBs.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lvZ != null && this.lvZ.bka() != null && this.lva != null) {
            this.lwA = !this.lwz;
            this.lva.uW(this.lwA);
            if (this.ljH.dhL() != null) {
                this.ljH.dhL().uV(this.lwA);
            }
            dlr();
            if (this.ljH != null && !this.ljH.dgO() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dgf())) {
                bs bsVar = fVar.dgf().get(0);
                if (bsVar != null) {
                    this.lva.fU(bsVar.getForumName(), bsVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lva.fU(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lwA) {
                this.lvj.a(fVar, this.lvZ, this.lvH);
                if (this.lwf != null) {
                    this.lwf.setVisibility(8);
                }
                if (this.lwJ == null) {
                    this.lwJ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.ljH != null && az.this.ljH.isAdded()) {
                                if (i < 0 && f > az.this.lwC) {
                                    az.this.dly();
                                    az.this.dlK();
                                }
                                az.this.dli();
                            }
                        }
                    };
                }
                this.lve.setListViewDragListener(this.lwJ);
                return;
            }
            if (this.lwf != null) {
                this.lwf.setVisibility(0);
            }
            this.lvj.a(fVar, this.lvZ, this.lvH);
            this.lwJ = null;
            this.lve.setListViewDragListener(null);
        }
    }

    private void dlr() {
        this.lvj.a(this.lkO, this.lvZ, this.lwA, this.lwz);
    }

    public boolean dls() {
        return this.lkO == null || this.lkO.getForum() == null || "0".equals(this.lkO.getForum().getId()) || "me0407".equals(this.lkO.getForum().getName());
    }

    private boolean dlt() {
        return this.lvh.uR(this.lkw);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dfI() == null) {
            return false;
        }
        if (fVar.dfI().bjX() == 1 || fVar.dfI().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dfI().bjZ() == null || fVar.dfI().bjZ().bmp() == 0) || fVar.dfI().bjV() == 1 || fVar.dfI().bjW() == 1 || fVar.dfI().bkO() || fVar.dfI().bli() || fVar.dfI().blb() || fVar.dfI().bkl() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.dfI().getCategory()) || fVar.dfI().bkd() || fVar.dfI().bkc();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lvi != null) {
                if (fVar.dfI() != null && fVar.dfI().bko() == 0 && !fVar.dfI().biG() && !this.lwQ) {
                    if (fVar.dfI() != null) {
                        bw dfI = fVar.dfI();
                        dfI.z(true, w(fVar));
                        dfI.nY(3);
                        dfI.AN("2");
                    }
                    if (fVar.dfI().biI()) {
                        this.lvj.c(this.lve);
                        this.lvi.c(this.lve);
                        this.lvi.b(this.lve);
                        this.lvj.b(this.lve);
                        this.lvj.E(this.lkO);
                        this.lvi.B(fVar);
                    } else {
                        this.lvj.E(this.lkO);
                        this.lvi.D(fVar);
                    }
                } else if (fVar.dfI().bko() == 1) {
                    if (fVar.dfI() != null) {
                        this.lvi.c(this.lve);
                        this.lvj.E(this.lkO);
                    }
                } else {
                    this.lvi.c(this.lve);
                    this.lvj.E(this.lkO);
                }
            }
            if (fVar.dfI() != null) {
                as(fVar.dfI().bjW() == 1, fVar.dfI().bjV() == 1);
            }
            this.lkw = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dlt();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.bka().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dfX()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.bka() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.bka().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.bka().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.bka().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dfX()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> dgf = fVar.dgf();
                if (com.baidu.tbadk.core.util.y.getCount(dgf) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : dgf) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.exk) != null && abVar.euW && !abVar.euX && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(this.ljH.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.ljH.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dlu() {
        return this.foB;
    }

    public boolean dlv() {
        if (this.bzs == null || this.bzs.getParent() == null || this.iJp.isLoading()) {
            return false;
        }
        int bottom = this.bzs.getBottom();
        Rect rect = new Rect();
        this.bzs.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Pw(String str) {
        if (this.iJp != null) {
            this.iJp.setText(str);
        }
    }

    public void Px(String str) {
        if (this.iJp != null) {
            int i = 0;
            if (this.lwk != null && this.lwk.lxp != null && this.lwk.lxp.getView() != null) {
                i = this.lwk.lxp.getView().getTop() < 0 ? this.lwk.lxp.getView().getHeight() : this.lwk.lxp.getView().getBottom();
            }
            this.iJp.an(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lve;
    }

    public int dlw() {
        return R.id.richText;
    }

    public TextView dhh() {
        return this.lvj.dhh();
    }

    public void d(BdListView.e eVar) {
        this.lve.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ePL = cVar;
        if (this.lvt != null) {
            this.lvt.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.av avVar, a.b bVar) {
        if (avVar != null) {
            int biO = avVar.biO();
            int biL = avVar.biL();
            if (this.lvq != null) {
                this.lvq.bmC();
            } else {
                this.lvq = new com.baidu.tbadk.core.dialog.a(this.ljH.getPageContext().getPageActivity());
                this.lvr = LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lvq.bb(this.lvr);
                this.lvq.a(R.string.dialog_ok, bVar);
                this.lvq.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dly();
                        aVar.dismiss();
                    }
                });
                this.lvq.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.lwu == null) {
                            az.this.lwu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.ljH.HidenSoftKeyPad((InputMethodManager) az.this.ljH.getBaseFragmentActivity().getSystemService("input_method"), az.this.byI);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(az.this.lwu, 150L);
                    }
                });
                this.lvq.b(this.ljH.getPageContext()).bmC();
            }
            this.lvs = (EditText) this.lvr.findViewById(R.id.input_page_number);
            this.lvs.setText("");
            TextView textView = (TextView) this.lvr.findViewById(R.id.current_page_number);
            if (biO <= 0) {
                biO = 1;
            }
            if (biL <= 0) {
                biL = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(biO), Integer.valueOf(biL)));
            this.ljH.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lvs, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lve.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ljH.showToast(str);
    }

    public boolean uG(boolean z) {
        if (this.abk == null || !this.abk.bxc()) {
            return false;
        }
        this.abk.bvv();
        return true;
    }

    public void dlx() {
        if (this.lwZ != null) {
            while (this.lwZ.size() > 0) {
                TbImageView remove = this.lwZ.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dlx();
        this.lvp.Fw(1);
        if (this.lvg != null) {
            this.lvg.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lvp.Fw(2);
        if (this.lvg != null) {
            this.lvg.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.ljH.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.ljH.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lvT != null) {
            this.lvT.onDestroy();
        }
        if (this.lww != null) {
            this.lww.destroy();
        }
        if (this.lwL != null) {
            this.lwL.onDestory();
        }
        if (this.lwD != null) {
            this.lwD.hide();
        }
        this.ljH.hideProgressBar();
        if (this.gbO != null && this.iyC != null) {
            this.gbO.b(this.iyC);
        }
        dly();
        endLoadData();
        if (this.lwu != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lwu);
        }
        if (this.lwc != null) {
            this.lwc.clearStatus();
        }
        this.lwT = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lvp.Fw(3);
        if (this.bxQ != null) {
            this.bxQ.setBackgroundDrawable(null);
        }
        if (this.lvg != null) {
            this.lvg.destroy();
        }
        if (this.lvp != null) {
            this.lvp.onDestroy();
        }
        this.lve.setOnLayoutListener(null);
        if (this.lwH != null) {
            this.lwH.cyM();
        }
        if (this.lwl != null) {
            this.lwl.onDestroy();
        }
        if (this.lvj != null) {
            this.lvj.onDestroy();
        }
    }

    public boolean FX(int i) {
        if (this.lvg != null) {
            return this.lvg.FX(i);
        }
        return false;
    }

    public void dly() {
        this.lva.aXc();
        if (this.lvj != null) {
            this.lvj.dly();
        }
        if (this.ljH != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.ljH.getContext(), this.lvs);
        }
        dkG();
        if (this.lnU != null) {
            this.lnU.dismiss();
        }
        dlA();
        if (this.lvq != null) {
            this.lvq.dismiss();
        }
        if (this.iEd != null) {
            this.iEd.dismiss();
        }
    }

    public void dlz() {
        this.lva.aXc();
        if (this.lvj != null) {
            this.lvj.dly();
        }
        if (this.lnU != null) {
            this.lnU.dismiss();
        }
        dlA();
        if (this.lvq != null) {
            this.lvq.dismiss();
        }
        if (this.iEd != null) {
            this.iEd.dismiss();
        }
    }

    public void eW(List<String> list) {
        this.lwG = list;
        if (this.lwH != null) {
            this.lwH.setData(list);
        }
    }

    public void tK(boolean z) {
        this.lvp.tK(z);
    }

    public void uH(boolean z) {
        this.lvJ = z;
    }

    public void dlA() {
        if (this.lvx != null) {
            this.lvx.dismiss();
        }
        if (this.lvy != null) {
            com.baidu.adp.lib.f.g.b(this.lvy, this.ljH.getPageContext());
        }
        if (this.lvz != null) {
            com.baidu.adp.lib.f.g.b(this.lvz, this.ljH.getPageContext());
        }
        if (this.lvw != null) {
            this.lvw.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.lkO, this.lkw);
            b(this.lkO, this.lkw, this.mType, i);
            this.ljH.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.ljH.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.byI);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.byI, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lvK, R.drawable.personalize_tab_shadow);
            if (this.lvg != null) {
                this.lvg.onChangeSkinType(i);
            }
            if (this.lvk != null) {
                this.lvk.onChangeSkinType(i);
            }
            if (this.lvh != null) {
                this.lvh.onChangeSkinType(i);
            }
            if (this.lvi != null) {
                this.lvi.onChangeSkinType(i);
            }
            if (this.lvj != null) {
                this.lvj.onChangeSkinType(i);
            }
            if (this.iJp != null) {
                this.iJp.changeSkin(i);
                if (this.foB != null) {
                    this.ljH.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.foB);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(this.foB, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.lvq != null) {
                this.lvq.c(this.ljH.getPageContext());
            }
            uF(this.lvG);
            this.lvp.notifyDataSetChanged();
            if (this.lvt != null) {
                this.lvt.changeSkin(i);
            }
            if (this.abk != null) {
                this.abk.onChangeSkinType(i);
            }
            if (this.lvu != null) {
                this.lvu.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hUy)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.hUy) {
                    customBlueCheckRadioButton.bpH();
                }
            }
            dkX();
            UtilHelper.setStatusBarBackground(this.bxQ, i);
            UtilHelper.setStatusBarBackground(this.lwf, i);
            if (this.lvl != null) {
                com.baidu.tbadk.r.a.a(this.ljH.getPageContext(), this.lvl);
            }
            if (this.lwv != null) {
                this.lwv.onChangeSkinType(i);
            }
            if (this.lva != null) {
                if (this.lvg != null) {
                    this.lvg.FY(i);
                } else {
                    this.lva.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.jEf != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.jEf, R.color.cp_cont_d);
            }
            if (this.lvP != null) {
                this.lvP.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
            }
            if (this.lvO != null) {
                this.lvO.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.ljH.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j)));
            }
            if (this.lvR != null && this.lkO != null) {
                if (this.lkO.bfV()) {
                    SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.lkO);
            if (this.lvQ != null) {
                SvgManager.boN().a(this.lvQ, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.lvM != null) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lvM, R.drawable.bottom_shadow);
            }
            if (this.lvU != null) {
                com.baidu.tbadk.core.util.ap.c(this.lvU, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvU, R.color.cp_cont_j);
            }
            if (this.lvV != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvV, R.color.cp_cont_b);
            }
            if (this.lwI != null) {
                this.lwI.onChangeSkinType(i);
            }
            if (this.lwl != null) {
                this.lwl.onChangeSkinType();
            }
            if (this.lwF != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwF, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lvN, R.color.cp_bg_line_h);
            if (this.lvf != null) {
                this.lvf.uu(i);
            }
            if (this.lvT != null) {
                this.lvT.onChangeSkinType();
            }
        }
    }

    public void dlB() {
        if (this.lvT != null) {
            this.lvT.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.dfI())) {
            if (this.lvT != null) {
                this.lvT.setEnable(false);
                this.lvT.onDestroy();
            }
            SvgManager.boN().a(this.lvS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.lvT == null || !this.lvT.isEnable()) {
            SvgManager.boN().a(this.lvS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
        this.lvp.setOnImageClickListener(this.fAg);
        this.lwI.setOnImageClickListener(this.fAg);
    }

    public void g(NoNetworkView.a aVar) {
        this.iyC = aVar;
        if (this.gbO != null) {
            this.gbO.a(this.iyC);
        }
    }

    public void uI(boolean z) {
        this.lvp.setIsFromCDN(z);
    }

    public Button dlC() {
        return this.lvL;
    }

    public void dlD() {
        if (this.luZ != 2) {
            this.lve.setNextPage(this.iJp);
            this.luZ = 2;
        }
    }

    public void dlE() {
        if (com.baidu.tbadk.n.m.bzV().bzW()) {
            int lastVisiblePosition = this.lve.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.lve.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.fpk = true;
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
                        perfLog2.fpk = true;
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

    public boolean dlF() {
        return this.abk != null && this.abk.getVisibility() == 0;
    }

    public boolean dlG() {
        return this.abk != null && this.abk.bxc();
    }

    public void dlH() {
        if (this.abk != null) {
            this.abk.bvv();
        }
    }

    public void uJ(boolean z) {
        if (this.lvN != null) {
            uH(this.ljH.dhI().bxM());
            if (this.lvJ) {
                uy(z);
            } else {
                uz(z);
            }
        }
    }

    public void dlI() {
        if (this.lvN != null) {
            this.lvM.setVisibility(8);
            this.lvN.setVisibility(8);
            this.lvW = false;
            if (this.lwl != null) {
                this.lwl.setVisibility(8);
                uD(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hYx == null) {
            this.hYx = new com.baidu.tbadk.core.view.a(this.ljH.getPageContext());
        }
        this.hYx.setDialogVisiable(true);
    }

    public void ceD() {
        if (this.hYx != null) {
            this.hYx.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lve.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lve.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lvg != null) {
            this.lvg.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.lxa = getScrollY();
            this.lwk.lxp = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lwk));
            a(this.lwk.lxp, true);
        }
    }

    public void uK(boolean z) {
        if (this.lvg != null) {
            this.lvg.uK(z);
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
        if (this.lvg != null) {
            this.lvg.onScroll(absListView, i, i2, i3);
        }
        if (this.lva != null && this.lvj != null) {
            this.lva.dm(this.lvj.dmk());
        }
        this.lwk.laE = i;
        this.lwk.headerCount = this.lve.getHeaderViewsCount();
        this.lwk.lxp = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lwk));
        uA(b(absListView, i));
        a(this.lwk.lxp, false);
        if (this.iJp.bpV() && !this.iJp.eOS) {
            if (this.lwk != null && this.lwk.lxp != null && this.lwk.lxp.getView() != null) {
                i4 = this.lwk.lxp.getView().getTop() < 0 ? this.lwk.lxp.getView().getHeight() : this.lwk.lxp.getView().getBottom();
            }
            this.iJp.pK(i4);
            this.iJp.eOS = true;
        }
    }

    public void dlJ() {
        if (TbadkCoreApplication.isLogin() && this.lkO != null && this.lwA && !this.lwz && !this.lvH && this.lvZ != null && this.lvZ.bka() != null && !this.lvZ.bka().getIsLike() && !this.lvZ.bka().hadConcerned() && this.lww == null) {
            this.lww = new av(this.ljH);
        }
    }

    public void dlK() {
        if (this.ljH != null) {
            if ((this.iBg || this.lwO == 17) && com.baidu.tbadk.a.d.bfy()) {
                if (this.lkO != null && this.lkO.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lkO.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ljH.getContext()).createNormalCfg(this.lkO.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dR("post_id", this.lkO.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", this.lkO.getForum().getId()));
                }
            } else if (this.lwA && !this.lwz && this.lvZ != null && this.lvZ.bka() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").aj("obj_locate", this.ljH.dgO() ? 2 : 1).aj("obj_type", this.lwz ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ljH.getPageContext().getPageActivity(), this.lvZ.bka().getUserId(), this.lvZ.bka().getUserName(), this.ljH.dgX().dgP(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.lwz && this.lwe != null && this.lva.dmC() != null) {
            int dhv = this.lvp.dhv();
            if (dhv > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (dhv > this.lve.getFirstVisiblePosition() - this.lve.getHeaderViewsCount()) {
                    this.lwe.setVisibility(4);
                    return;
                }
                this.lwe.setVisibility(0);
                uA(false);
                this.lva.mNavigationBar.hideBottomLine();
                if (this.lwe.getParent() != null && ((ViewGroup) this.lwe.getParent()).getHeight() <= this.lwe.getTop()) {
                    this.lwe.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.luz == null) {
                if (this.lve.getFirstVisiblePosition() == 0) {
                    this.lwe.setVisibility(4);
                    this.lva.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.lwj) {
                        this.lwi = top;
                        this.lwj = false;
                    }
                    this.lwi = top < this.lwi ? top : this.lwi;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.lvo.getY() < 0.0f) {
                        measuredHeight = lwh - auVar.luz.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lva.dmC().getMeasuredHeight() - auVar.luz.getMeasuredHeight();
                        this.lva.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.lwi) {
                        this.lwe.setVisibility(0);
                        uA(false);
                    } else if (top < measuredHeight) {
                        this.lwe.setVisibility(0);
                        uA(false);
                    } else {
                        this.lwe.setVisibility(4);
                        this.lva.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lwj = true;
                    }
                }
            }
        }
    }

    public void dlL() {
        if (!this.lxb) {
            TiebaStatic.log("c10490");
            this.lxb = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ljH.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lwo, Integer.valueOf(lwq));
            aVar.ol(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bb(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.ljH);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.ljH.getPageContext()).bmC();
        }
    }

    public void Py(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ljH.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bb(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lwo, Integer.valueOf(lwr));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.ljH);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ljH.getPageContext()).bmC();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.bka() != null) {
            MetaData bka = b.bka();
            bka.setGiftNum(bka.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lvj.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dlM() {
        return this.lwc;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dfI() != null && fVar.dfI().bli() && this.lwc == null) {
            this.lwc = (PbInterviewStatusView) this.lwb.inflate();
            this.lwc.setOnClickListener(this.iEe);
            this.lwc.setCallback(this.ljH.dit());
            this.lwc.setData(this.ljH, fVar);
        }
    }

    public RelativeLayout dlN() {
        return this.lvo;
    }

    public View dlO() {
        return this.bxQ;
    }

    public boolean dlP() {
        return this.lwQ;
    }

    public void tP(boolean z) {
        this.lvj.tP(z);
    }

    public void Pz(String str) {
        if (this.lvb != null) {
            this.lvb.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int uL(boolean z) {
        if (this.lwc == null || this.lwc.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dlQ() {
        if (this.lwc != null && this.lwc.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lwc.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lwc.setLayoutParams(layoutParams);
        }
    }

    public boolean dhO() {
        return false;
    }

    public void PA(String str) {
        this.jEf.performClick();
        if (!StringUtils.isNull(str) && this.ljH.dhI() != null && this.ljH.dhI().bxE() != null && this.ljH.dhI().bxE().getInputView() != null) {
            EditText inputView = this.ljH.dhI().bxE().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dly();
            if (configuration.orientation == 2) {
                dlI();
                dkG();
            } else {
                dkK();
            }
            if (this.lwv != null) {
                this.lwv.dhD();
            }
            this.ljH.cwk();
            this.lvo.setVisibility(8);
            this.lva.uX(false);
            this.ljH.ue(false);
            if (this.lvg != null) {
                if (configuration.orientation == 1) {
                    dlN().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lve.setIsLandscape(true);
                    this.lve.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lve.setIsLandscape(false);
                    if (this.lxa > 0) {
                        this.lve.smoothScrollBy(this.lxa, 0);
                    }
                }
                this.lvg.onConfigurationChanged(configuration);
                this.lwd.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void uM(boolean z) {
        if (this.lvg != null) {
            this.lvg.uM(z);
        }
    }

    public boolean dlR() {
        return this.lvg != null && this.lvg.dlR();
    }

    public void dlS() {
        if (this.lvg != null) {
            this.lvg.dlS();
        }
    }

    public void tT(boolean z) {
        this.lvp.tT(z);
    }

    public void dl(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lvN.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.ljH.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lwF = new TextView(this.ljH.getContext());
            this.lwF.setText(R.string.connection_tips);
            this.lwF.setGravity(17);
            this.lwF.setPadding(com.baidu.adp.lib.util.l.getDimens(this.ljH.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.ljH.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.ljH.getContext(), R.dimen.ds60);
            if (this.lwF.getParent() == null) {
                frameLayout.addView(this.lwF, layoutParams);
            }
            this.lwE = new PopupWindow(this.ljH.getContext());
            this.lwE.setContentView(frameLayout);
            this.lwE.setHeight(-2);
            this.lwE.setWidth(-2);
            this.lwE.setFocusable(true);
            this.lwE.setOutsideTouchable(false);
            this.lwE.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lve.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.lwE.showAsDropDown(az.this.lvN, view.getLeft(), -az.this.lvN.getHeight());
                    } else {
                        az.this.lwE.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void uN(boolean z) {
        this.lwK = z;
    }

    public boolean dlT() {
        return this.lwK;
    }

    public PbThreadPostView dlU() {
        return this.lvf;
    }

    private void as(boolean z, boolean z2) {
        at(z, z2);
        if (this.lkO != null && this.lkO.dfI() != null && this.lkO.dfI().bko() == 0 && !this.lkO.dfI().biG()) {
            au(z, z2);
        } else if (this.lvp != null && this.lvp.dhA() != null) {
            this.lvp.dhA().b(this.lkO, z, z2);
        }
    }

    private void at(boolean z, boolean z2) {
        this.lvj.d(this.lkO, z, z2);
    }

    private void au(boolean z, boolean z2) {
        this.lvi.c(this.lkO, z, z2);
    }

    public void uO(boolean z) {
        this.iBg = z;
    }

    public void FP(int i) {
        this.lwO = i;
    }

    public void dlV() {
        if (this.lve != null) {
            this.lve.setForbidDragListener(true);
        }
    }

    public boolean diN() {
        if (this.lve == null) {
            return false;
        }
        return this.lve.diN();
    }

    public boolean dlW() {
        if (this.iJp == null || TextUtils.isEmpty(this.iJp.getEndText())) {
            return false;
        }
        return this.iJp.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
