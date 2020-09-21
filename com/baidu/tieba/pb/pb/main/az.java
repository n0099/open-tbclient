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
/* loaded from: classes21.dex */
public class az {
    private EditorTools aaS;
    private View brO;
    private RelativeLayout bsG;
    private View btr;
    private com.baidu.tieba.pb.a.c eHq;
    private View eTU;
    private f.c evf;
    private NoNetworkView fFC;
    private boolean hZJ;
    private List<CustomBlueCheckRadioButton> hth;
    private NavigationBarCoverTip iDk;
    private com.baidu.tieba.NEGFeedBack.e iGA;
    private View.OnClickListener icH;
    private PbListView ihW;
    private boolean isLandscape;
    private TextView jcG;
    private PbFragment kHX;
    private View.OnClickListener kIU;
    private com.baidu.tieba.pb.data.f kJe;
    private PbFakeFloorModel kLv;
    PbFragment.c kNk;
    private View kTF;
    private View kTU;
    private View kTW;
    private View kTX;
    private LinearLayout kTY;
    private HeadImageView kTZ;
    public int kTi;
    public final com.baidu.tieba.pb.pb.main.view.c kTk;
    public com.baidu.tieba.pb.pb.main.view.b kTl;
    private ViewStub kTm;
    private ViewStub kTn;
    private PbLandscapeListView kTo;
    private PbThreadPostView kTp;
    private com.baidu.tieba.pb.pb.main.a.e kTq;
    private com.baidu.tieba.pb.pb.main.a.a kTr;
    private com.baidu.tieba.pb.pb.main.a.c kTs;
    private com.baidu.tieba.pb.pb.main.a.d kTt;
    private com.baidu.tieba.pb.pb.main.a.b kTu;
    private LinearLayout kTv;
    private TextView kTw;
    private TextView kTx;
    private ObservedChangeRelativeLayout kTy;
    private g kTz;
    private int kUD;
    private Runnable kUE;
    private v kUF;
    private av kUG;
    private int kUM;
    private PbTopTipView kUN;
    private PopupWindow kUO;
    private TextView kUP;
    private List<String> kUQ;
    private com.baidu.tieba.pb.pb.main.emotion.c kUR;
    private com.baidu.tieba.pb.pb.godreply.a kUS;
    private PbLandscapeListView.b kUT;
    private al kUV;
    private String kUW;
    private long kUX;
    private int kUY;
    private ImageView kUa;
    private ImageView kUb;
    private ImageView kUc;
    private com.baidu.tieba.pb.view.c kUd;
    private TextView kUe;
    private TextView kUf;
    private int kUh;
    private int kUi;
    private PostData kUj;
    private ViewStub kUl;
    private PbInterviewStatusView kUm;
    private FrameLayout kUn;
    private View kUo;
    private View kUp;
    private au kUq;
    private PbEmotionBar kUv;
    private boolean kVa;
    private Runnable kVe;
    private PbFragment.b kVg;
    public int kVk;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int kUr = UtilHelper.getLightStatusBarHeight();
    public static int kUx = 3;
    public static int kUy = 0;
    public static int kUz = 3;
    public static int kUA = 4;
    public static int kUB = 5;
    public static int kUC = 6;
    private static a.InterfaceC0803a kUZ = new a.InterfaceC0803a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0803a
        public void onRefresh() {
        }
    };
    private int kTj = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a kTA = null;
    private com.baidu.tbadk.core.dialog.b icG = null;
    private View kTB = null;
    private EditText kTC = null;
    private com.baidu.tieba.pb.view.d kTD = null;
    private com.baidu.tieba.pb.view.a kTE = null;
    private b.InterfaceC0533b jBt = null;
    private TbRichTextView.i ffu = null;
    private NoNetworkView.a hXf = null;
    private com.baidu.tbadk.core.dialog.i kTG = null;
    private com.baidu.tbadk.core.dialog.a kTH = null;
    private Dialog kTI = null;
    private Dialog kTJ = null;
    private View kTK = null;
    private LinearLayout kTL = null;
    private CompoundButton.OnCheckedChangeListener hti = null;
    private TextView kTM = null;
    private TextView kTN = null;
    private String kTO = null;
    private com.baidu.tbadk.core.dialog.i kMj = null;
    private com.baidu.tbadk.core.dialog.i kTP = null;
    private boolean kTQ = false;
    private boolean kTR = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView kTS = null;
    private boolean kTT = false;
    private Button kTV = null;
    private boolean kUg = true;
    private com.baidu.tbadk.core.view.a hxf = null;
    private boolean kIM = false;
    private int mSkinType = 3;
    private boolean kUk = false;
    private int kUs = 0;
    private boolean kUt = true;
    public a kUu = new a();
    private int kUw = 0;
    private boolean kUH = false;
    private int kUI = 0;
    private boolean kUJ = false;
    private boolean kUK = false;
    private boolean kUL = false;
    private boolean kUU = false;
    private String kVb = null;
    private CustomMessageListener kVc = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.kVb = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.kTz != null) {
                az.this.kTz.notifyDataSetChanged();
            }
        }
    };
    private Handler kVd = new Handler();
    private CustomMessageListener kVf = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.kUg = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean kVh = true;
    View.OnClickListener kVi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.kJe == null || az.this.kJe.cYR() == null || az.this.kJe.cYR().bfy() == null || az.this.kJe.cYR().bfy().getAlaInfo() == null || az.this.kJe.cYR().bfy().getAlaInfo().live_status != 1) {
                if (az.this.kUJ) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").ai("obj_id", 2));
                }
                if (!az.this.kUJ && az.this.kJe != null && az.this.kJe.cYR() != null && az.this.kJe.cYR().bfy() != null && az.this.kJe.cYR().bfy().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").ai("obj_locate", 1));
                }
                if (az.this.kHX.dbM() != null) {
                    az.this.kHX.dbM().kIj.hJr.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (az.this.kJe.cYR().bfy().getAlaInfo() == null || !az.this.kJe.cYR().bfy().getAlaInfo().isChushou) {
                if (az.this.kJe.cYR().bfy().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.kJe.cYR().bfy().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.kHX.dbM(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.be.bkp().b(az.this.kHX.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.kJe.cYR().bfy().getAlaInfo().thirdRoomId + "&livetype=" + az.this.kJe.cYR().bfy().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bax = false;
    String userId = null;
    private final List<TbImageView> kVj = new ArrayList();
    private boolean kVl = false;

    /* loaded from: classes21.dex */
    public static class a {
        public int headerCount;
        public au kVz;
        public int kyU;
    }

    public void tz(boolean z) {
        this.kUH = z;
        if (this.kTo != null) {
            this.kUI = this.kTo.getHeaderViewsCount();
        }
    }

    public void ddO() {
        if (this.kTo != null) {
            int headerViewsCount = this.kTo.getHeaderViewsCount() - this.kUI;
            final int firstVisiblePosition = (this.kTo.getFirstVisiblePosition() == 0 || this.kTo.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.kTo.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.kTo.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.kUu.kVz = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kUu));
            final au auVar = this.kUu.kVz;
            final int g = g(auVar);
            final int y = ((int) this.kTy.getY()) + this.kTy.getMeasuredHeight();
            final boolean z = this.kUo.getVisibility() == 0;
            boolean z2 = this.kTy.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.kTz.daF() + this.kTo.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.kSJ.getMeasuredHeight() : 0;
                if (z2) {
                    this.kTo.setSelectionFromTop(this.kTz.daF() + this.kTo.getHeaderViewsCount(), kUr - measuredHeight);
                } else {
                    this.kTo.setSelectionFromTop(this.kTz.daF() + this.kTo.getHeaderViewsCount(), this.kTk.dfM().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.kTo.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.kUJ && this.kTq != null) {
                this.kTo.setSelectionFromTop(this.kTz.daF() + this.kTo.getHeaderViewsCount(), this.kTq.dfy());
            } else if (this.mType == 6) {
                this.kTo.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bsG.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.btr != null && (layoutParams = az.this.btr.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bsG.getMeasuredHeight() || g2 >= az.this.bsG.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kUD;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bsG.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kUD;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.kTo.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.btr.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.btr != null && az.this.btr.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.btr.getLayoutParams();
                                            layoutParams2.height = az.this.kUD;
                                            az.this.btr.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.kTo.setOnLayoutListener(null);
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

    public NoNetworkView ddP() {
        return this.fFC;
    }

    public void ddQ() {
        if (this.aaS != null) {
            this.aaS.hide();
            if (this.kUR != null) {
                this.kUR.dfA();
            }
        }
    }

    public PbFakeFloorModel ddR() {
        return this.kLv;
    }

    public v ddS() {
        return this.kUF;
    }

    public com.baidu.tieba.pb.pb.main.a.e ddT() {
        return this.kTq;
    }

    public void ddU() {
        reset();
        ddQ();
        this.kUF.daN();
        tL(false);
    }

    private void reset() {
        if (this.kHX != null && this.kHX.daS() != null && this.aaS != null) {
            com.baidu.tbadk.editortools.pb.a.bsY().setStatus(0);
            com.baidu.tbadk.editortools.pb.e daS = this.kHX.daS();
            daS.btt();
            daS.bsI();
            if (daS.getWriteImagesInfo() != null) {
                daS.getWriteImagesInfo().setMaxImagesAllowed(daS.isBJH ? 1 : 9);
            }
            daS.qB(SendView.ALL);
            daS.qC(SendView.ALL);
            com.baidu.tbadk.editortools.h qo = this.aaS.qo(23);
            com.baidu.tbadk.editortools.h qo2 = this.aaS.qo(2);
            com.baidu.tbadk.editortools.h qo3 = this.aaS.qo(5);
            if (qo2 != null) {
                qo2.display();
            }
            if (qo3 != null) {
                qo3.display();
            }
            if (qo != null) {
                qo.hide();
            }
            this.aaS.invalidate();
        }
    }

    public boolean ddV() {
        return this.kUg;
    }

    public void tA(boolean z) {
        if (this.kTX != null && this.jcG != null) {
            this.jcG.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kTX.startAnimation(alphaAnimation);
            }
            this.kTW.setVisibility(0);
            this.kTX.setVisibility(0);
            this.kUg = true;
            if (this.kUv != null && !this.kUS.isActive()) {
                this.kUv.setVisibility(0);
                tF(true);
            }
        }
    }

    public void tB(boolean z) {
        if (this.kTX != null && this.jcG != null) {
            this.jcG.setText(ddW());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kTX.startAnimation(alphaAnimation);
            }
            this.kTW.setVisibility(0);
            this.kTX.setVisibility(0);
            this.kUg = true;
            if (this.kUv != null && !this.kUS.isActive()) {
                this.kUv.setVisibility(0);
                tF(true);
            }
        }
    }

    public String ddW() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.kUW)) {
            return this.kUW;
        }
        if (this.kHX != null) {
            this.kUW = TbadkCoreApplication.getInst().getResources().getString(ay.ddL());
        }
        return this.kUW;
    }

    public PostData ddX() {
        int i = 0;
        if (this.kTo == null) {
            return null;
        }
        int ddY = ddY() - this.kTo.getHeaderViewsCount();
        if (ddY < 0) {
            ddY = 0;
        }
        if (this.kTz.Ew(ddY) != null && this.kTz.Ew(ddY) != PostData.moA) {
            i = ddY + 1;
        }
        return this.kTz.getItem(i) instanceof PostData ? (PostData) this.kTz.getItem(i) : null;
    }

    public int ddY() {
        int i;
        View childAt;
        if (this.kTo == null) {
            return 0;
        }
        int firstVisiblePosition = this.kTo.getFirstVisiblePosition();
        int lastVisiblePosition = this.kTo.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.kTo.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.kTo.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int ddZ() {
        return this.kTo.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.kJe != null && this.kJe.cYT() != null && !this.kJe.cYT().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.kJe.cYT().size() && (postData = this.kJe.cYT().get(i)) != null && postData.bfy() != null && !StringUtils.isNull(postData.bfy().getUserId()); i++) {
                if (this.kJe.cYT().get(i).bfy().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.kUS != null && this.kUS.isActive()) {
                        tL(false);
                    }
                    if (this.kUv != null) {
                        this.kUv.tV(true);
                    }
                    this.kVb = postData.bfy().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kHX = null;
        this.bsG = null;
        this.brO = null;
        this.kTo = null;
        this.kTz = null;
        this.ihW = null;
        this.eTU = null;
        this.icH = null;
        this.kIU = null;
        this.kTX = null;
        this.jcG = null;
        this.kUl = null;
        this.kUM = 0;
        this.kUX = 0L;
        this.kUX = System.currentTimeMillis();
        this.kHX = pbFragment;
        this.icH = onClickListener;
        this.eHq = cVar;
        this.kUM = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kHX.getContext()) / 8;
        this.bsG = (RelativeLayout) LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bsG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.kTU = this.bsG.findViewById(R.id.bottom_shadow);
        this.iDk = (NavigationBarCoverTip) this.bsG.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.brO = this.bsG.findViewById(R.id.statebar_view);
        this.kTy = (ObservedChangeRelativeLayout) this.bsG.findViewById(R.id.title_wrapper);
        this.fFC = (NoNetworkView) this.bsG.findViewById(R.id.view_no_network);
        this.kTo = (PbLandscapeListView) this.bsG.findViewById(R.id.new_pb_list);
        this.kUn = (FrameLayout) this.bsG.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kHX.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kHX.getActivity(), R.dimen.ds88));
        this.kTo.addHeaderView(this.textView, 0);
        this.kTo.setTextViewAdded(true);
        this.kUD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.btr = new View(this.kHX.getPageContext().getPageActivity());
        this.btr.setLayoutParams(new AbsListView.LayoutParams(-1, this.kUD));
        this.btr.setVisibility(4);
        this.kTo.addFooterView(this.btr);
        this.kTo.setOnTouchListener(this.kHX.eYy);
        this.kTk = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bsG);
        if (this.kHX.dbv()) {
            this.kTm = (ViewStub) this.bsG.findViewById(R.id.manga_view_stub);
            this.kTm.setVisibility(0);
            this.kTl = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.kTl.show();
            this.kTk.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kHX.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.kTk.dfM().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0758a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0758a
            public void cZR() {
                if (az.this.kTo != null) {
                    if (az.this.kTq != null) {
                        az.this.kTq.dfx();
                    }
                    az.this.kTo.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0758a
            public void cZS() {
                az.this.kHX.cpF();
            }
        }));
        this.kTW = this.bsG.findViewById(R.id.view_comment_top_line);
        this.kTX = this.bsG.findViewById(R.id.pb_editor_tool_comment);
        this.kUh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kUi = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kTZ = (HeadImageView) this.bsG.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kTZ.setVisibility(0);
        this.kTZ.setIsRound(true);
        this.kTZ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kHX.getContext(), R.dimen.tbds1));
        this.kTZ.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
        this.kTZ.setPlaceHolder(1);
        this.kTZ.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kTZ.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jcG = (TextView) this.bsG.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kTY = (LinearLayout) this.bsG.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.kHX.dbd();
                if (az.this.kHX != null && az.this.kHX.dah() != null && az.this.kHX.dah().getPbData() != null && az.this.kHX.dah().getPbData().cYR() != null && az.this.kHX.dah().getPbData().cYR().bfy() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dF("tid", az.this.kHX.dah().dcg()).dF("fid", az.this.kHX.dah().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dF("tid", az.this.kHX.dah().kPr).dF("fid", az.this.kHX.dah().getPbData().getForumId()).ai("obj_locate", 1).dF("uid", az.this.kHX.dah().getPbData().cYR().bfy().getUserId()));
                }
            }
        });
        this.kUa = (ImageView) this.bsG.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kUa.setOnClickListener(this.icH);
        boolean booleanExtra = this.kHX.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kUb = (ImageView) this.bsG.findViewById(R.id.pb_editor_tool_collection);
        this.kUb.setOnClickListener(this.icH);
        if (booleanExtra) {
            this.kUb.setVisibility(8);
        } else {
            this.kUb.setVisibility(0);
        }
        this.kUc = (ImageView) this.bsG.findViewById(R.id.pb_editor_tool_share);
        this.kUc.setOnClickListener(this.icH);
        this.kUd = new com.baidu.tieba.pb.view.c(this.kUc);
        this.kUd.dje();
        this.kUe = (TextView) this.bsG.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kUe.setVisibility(0);
        this.kUl = (ViewStub) this.bsG.findViewById(R.id.interview_status_stub);
        this.kTr = new com.baidu.tieba.pb.pb.main.a.a(this.kHX, cVar);
        this.kTt = new com.baidu.tieba.pb.pb.main.a.d(this.kHX, cVar, this.icH);
        this.kTz = new g(this.kHX, this.kTo);
        this.kTz.F(this.icH);
        this.kTz.setTbGestureDetector(this.eHq);
        this.kTz.setOnImageClickListener(this.ffu);
        this.kTz.setOnSwitchChangeListener(this.kHX.kNd);
        this.kIU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.kHX.c(sparseArray);
                            return;
                        }
                        az.this.dc(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.kHX.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.kTz.S(this.kIU);
        dee();
        def();
        this.kTt.b(this.kTo);
        this.kTs.b(this.kTo);
        this.kTr.b(this.kTo);
        this.ihW = new PbListView(this.kHX.getPageContext().getPageActivity());
        this.eTU = this.ihW.getView().findViewById(R.id.pb_more_view);
        if (this.eTU != null) {
            this.eTU.setOnClickListener(this.icH);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.eTU, R.drawable.pb_foot_more_trans_selector);
        }
        this.ihW.setLineVisible();
        this.ihW.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.ihW.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.kTF = this.bsG.findViewById(R.id.viewstub_progress);
        this.kHX.registerListener(this.kVf);
        this.kLv = new PbFakeFloorModel(this.kHX.getPageContext());
        this.kUF = new v(this.kHX.getPageContext(), this.kLv, this.bsG);
        this.kUF.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.ddU();
            }
        });
        this.kUF.a(this.kHX.kNf);
        this.kLv.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.kLv.t(postData);
                az.this.kTz.notifyDataSetChanged();
                az.this.kUF.daN();
                az.this.aaS.bqS();
                az.this.tL(false);
            }
        });
        if (this.kHX.dah() != null && !StringUtils.isNull(this.kHX.dah().dcO())) {
            this.kHX.showToast(this.kHX.dah().dcO());
        }
        this.kUo = this.bsG.findViewById(R.id.pb_expand_blank_view);
        this.kUp = this.bsG.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kUp.getLayoutParams();
        if (this.kHX.dah() != null && this.kHX.dah().dcj()) {
            this.kUo.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.kUp.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = kUr;
            this.kUp.setLayoutParams(layoutParams2);
        }
        this.kUq = new au(this.kHX.getPageContext(), this.bsG.findViewById(R.id.pb_reply_expand_view));
        this.kUq.v(pbFragment.kLZ);
        this.kUq.kSJ.setVisibility(8);
        this.kUq.U(this.icH);
        this.kUq.setOnSwitchChangeListener(this.kHX.kNd);
        this.kHX.registerListener(this.mAccountChangedListener);
        this.kHX.registerListener(this.kVc);
        dea();
        tF(false);
    }

    public void tC(boolean z) {
        this.kTU.setVisibility(z ? 0 : 8);
    }

    public void cCL() {
        if (!this.kHX.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").ai("obj_locate", 2).dF("fid", this.mForumId));
        } else if (this.kHX.dbf()) {
            com.baidu.tbadk.editortools.pb.e daS = this.kHX.daS();
            if (daS != null && (daS.btq() || daS.btr())) {
                this.kHX.daS().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.aaS != null) {
                dek();
            }
            if (this.aaS != null) {
                this.kUg = false;
                if (this.aaS.qr(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kHX.getPageContext(), (View) this.aaS.qr(2).eMS, false, kUZ);
                }
            }
            deS();
        }
    }

    private void dea() {
        this.kUS = new com.baidu.tieba.pb.pb.godreply.a(this.kHX, this, (ViewStub) this.bsG.findViewById(R.id.more_god_reply_popup));
        this.kUS.A(this.icH);
        this.kUS.S(this.kIU);
        this.kUS.setOnImageClickListener(this.ffu);
        this.kUS.A(this.icH);
        this.kUS.setTbGestureDetector(this.eHq);
    }

    public com.baidu.tieba.pb.pb.godreply.a deb() {
        return this.kUS;
    }

    public View dec() {
        return this.kUo;
    }

    public void ded() {
        if (this.kTo != null) {
            this.kTs.c(this.kTo);
            this.kTt.c(this.kTo);
            this.kTu.c(this.kTo);
            this.kTr.c(this.kTo);
        }
    }

    private void dee() {
        if (this.kTu == null) {
            this.kTu = new com.baidu.tieba.pb.pb.main.a.b(this.kHX, this.icH);
        }
    }

    private void def() {
        if (this.kTs == null) {
            this.kTs = new com.baidu.tieba.pb.pb.main.a.c(this.kHX, this.eHq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deg() {
        if (this.kHX.dbv()) {
            this.kTn = (ViewStub) this.bsG.findViewById(R.id.manga_mention_controller_view_stub);
            this.kTn.setVisibility(0);
            if (this.kTv == null) {
                this.kTv = (LinearLayout) this.bsG.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kHX.getPageContext(), this.kTv);
            }
            if (this.kTw == null) {
                this.kTw = (TextView) this.kTv.findViewById(R.id.manga_prev_btn);
            }
            if (this.kTx == null) {
                this.kTx = (TextView) this.kTv.findViewById(R.id.manga_next_btn);
            }
            this.kTw.setOnClickListener(this.icH);
            this.kTx.setOnClickListener(this.icH);
        }
    }

    private void deh() {
        if (this.kHX.dbv()) {
            if (this.kHX.dby() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kTw, R.color.cp_cont_e, 1);
            }
            if (this.kHX.dbz() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kTx, R.color.cp_cont_e, 1);
            }
        }
    }

    public void dei() {
        if (this.kTv == null) {
            deg();
        }
        this.kTn.setVisibility(8);
        if (this.kVd != null && this.kVe != null) {
            this.kVd.removeCallbacks(this.kVe);
        }
    }

    public void dej() {
        if (this.kVd != null) {
            if (this.kVe != null) {
                this.kVd.removeCallbacks(this.kVe);
            }
            this.kVe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.kTv == null) {
                        az.this.deg();
                    }
                    az.this.kTn.setVisibility(0);
                }
            };
            this.kVd.postDelayed(this.kVe, 2000L);
        }
    }

    public void tD(boolean z) {
        this.kTk.tD(z);
        if (z && this.kUk) {
            this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.kTo.setNextPage(this.ihW);
            this.kTj = 2;
        }
        if (this.kTZ != null) {
            this.kTZ.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
        this.aaS.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.ddU();
            }
        });
        this.aaS.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.aaS.getParent() == null) {
            this.bsG.addView(this.aaS, layoutParams);
        }
        this.aaS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aaS.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bnJ() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bnJ() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.kHX.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.kHX.getBaseFragmentActivity())) {
                            az.this.kHX.daS().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.kHX.daS().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        ddQ();
        this.kHX.daS().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.aaS != null && az.this.aaS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.kUR == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.aaS.getId());
                            az.this.kUR = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.kHX.getPageContext(), az.this.bsG, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.kUQ)) {
                                az.this.kUR.setData(az.this.kUQ);
                            }
                            az.this.kUR.c(az.this.aaS);
                        }
                        az.this.kUR.Or(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.kHX.jSk != null && az.this.kHX.jSk.dfj() != null) {
                    if (!az.this.kHX.jSk.dfj().dJA()) {
                        az.this.kHX.jSk.tR(false);
                    }
                    az.this.kHX.jSk.dfj().xj(false);
                }
            }
        });
    }

    public void dek() {
        if (this.kHX != null && this.aaS != null) {
            this.aaS.display();
            if (this.kHX.daS() != null) {
                this.kHX.daS().btg();
            }
            deS();
        }
    }

    public void tE(boolean z) {
        if (this.kTo != null && this.textView != null && this.brO != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.brO.setVisibility(0);
                } else {
                    this.brO.setVisibility(8);
                    this.kTo.removeHeaderView(this.textView);
                    this.kTo.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = kUr;
                    this.textView.setLayoutParams(layoutParams);
                }
                dey();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + tN(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dey();
            dfa();
        }
    }

    public g del() {
        return this.kTz;
    }

    public void a(PbFragment.c cVar) {
        this.kNk = cVar;
    }

    public void dc(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kHX.getContext());
        kVar.setTitleText(this.kHX.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kTG.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.kVg != null) {
                                az.this.kVg.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.kHX.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kHX.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kHX.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !deZ()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kHX.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kHX.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kHX.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aX(arrayList);
        this.kTG = new com.baidu.tbadk.core.dialog.i(this.kHX.getPageContext(), kVar);
        this.kTG.NY();
    }

    public void a(PbFragment.b bVar) {
        this.kVg = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kHX != null && aVar != null) {
            if (this.iGA == null && this.kTr != null) {
                this.iGA = new com.baidu.tieba.NEGFeedBack.e(this.kHX.getPageContext(), this.kTr.dft());
            }
            AntiData coh = this.kHX.coh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (coh != null && coh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = coh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.iGA.setDefaultReasonArray(new String[]{this.kHX.getString(R.string.delete_thread_reason_1), this.kHX.getString(R.string.delete_thread_reason_2), this.kHX.getString(R.string.delete_thread_reason_3), this.kHX.getString(R.string.delete_thread_reason_4), this.kHX.getString(R.string.delete_thread_reason_5)});
            this.iGA.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.iGA.DC(str);
            this.iGA.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.kHX.a(aVar, jSONArray);
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
        sparseArray.put(kUy, Integer.valueOf(kUz));
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
        this.kTH = new com.baidu.tbadk.core.dialog.a(this.kHX.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kTH.nE(i3);
        } else {
            this.kTH.setOnlyMessageShowCenter(false);
            this.kTH.zV(str2);
        }
        this.kTH.setYesButtonTag(sparseArray);
        this.kTH.a(R.string.dialog_ok, this.kHX);
        this.kTH.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kTH.id(true);
        this.kTH.b(this.kHX.getPageContext());
        if (z) {
            this.kTH.bia();
        } else {
            a(this.kTH, i);
        }
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.kTK == null) {
            this.kTK = LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kHX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kTK);
        if (this.kTJ == null) {
            this.kTJ = new Dialog(this.kHX.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kTJ.setCanceledOnTouchOutside(true);
            this.kTJ.setCancelable(true);
            this.kTS = (ScrollView) this.kTK.findViewById(R.id.good_scroll);
            this.kTJ.setContentView(this.kTK);
            WindowManager.LayoutParams attributes = this.kTJ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kTJ.getWindow().setAttributes(attributes);
            this.hti = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.kTO = (String) compoundButton.getTag();
                        if (az.this.hth != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.hth) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.kTO != null && !str.equals(az.this.kTO)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kTL = (LinearLayout) this.kTK.findViewById(R.id.good_class_group);
            this.kTN = (TextView) this.kTK.findViewById(R.id.dialog_button_cancel);
            this.kTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.kTJ instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.kTJ, az.this.kHX.getPageContext());
                    }
                }
            });
            this.kTM = (TextView) this.kTK.findViewById(R.id.dialog_button_ok);
            this.kTM.setOnClickListener(this.icH);
        }
        this.kTL.removeAllViews();
        this.hth = new ArrayList();
        CustomBlueCheckRadioButton fH = fH("0", this.kHX.getPageContext().getString(R.string.thread_good_class));
        this.hth.add(fH);
        fH.setChecked(true);
        this.kTL.addView(fH);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bdM()) && ajVar.bdN() > 0) {
                    CustomBlueCheckRadioButton fH2 = fH(String.valueOf(ajVar.bdN()), ajVar.bdM());
                    this.hth.add(fH2);
                    View view = new View(this.kHX.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kTL.addView(view);
                    this.kTL.addView(fH2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kTS.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kHX.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kHX.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kHX.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kTS.setLayoutParams(layoutParams2);
            this.kTS.removeAllViews();
            if (this.kTL != null && this.kTL.getParent() == null) {
                this.kTS.addView(this.kTL);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kTJ, this.kHX.getPageContext());
    }

    private CustomBlueCheckRadioButton fH(String str, String str2) {
        Activity pageActivity = this.kHX.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hti);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dem() {
        this.kHX.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kHX.hideProgressBar();
        if (z && z2) {
            this.kHX.showToast(this.kHX.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kHX.showToast(str);
        }
    }

    public void cKd() {
        this.kTF.setVisibility(0);
    }

    public void cKc() {
        this.kTF.setVisibility(8);
    }

    public View den() {
        if (this.kTK != null) {
            return this.kTK.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String deo() {
        return this.kTO;
    }

    public View getView() {
        return this.bsG;
    }

    public void dep() {
        if (this.kHX != null && this.kHX.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kHX.getPageContext().getPageActivity(), this.kHX.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kHX.hideProgressBar();
        if (z) {
            deI();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            deJ();
        } else {
            deI();
        }
    }

    public void deq() {
        this.ihW.setLineVisible();
        this.ihW.startLoadData();
    }

    public void der() {
        this.kHX.hideProgressBar();
        endLoadData();
        this.kTo.completePullRefreshPostDelayed(0L);
        deD();
    }

    public void des() {
        this.kTo.completePullRefreshPostDelayed(0L);
        deD();
    }

    private void tF(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.kTt.b(onLongClickListener);
        this.kTz.setOnLongClickListener(onLongClickListener);
        if (this.kUS != null) {
            this.kUS.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0533b interfaceC0533b, boolean z, boolean z2) {
        if (this.kMj != null) {
            this.kMj.dismiss();
            this.kMj = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kHX.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kHX.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kHX.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kHX.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kHX.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aX(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kTP.dismiss();
                interfaceC0533b.a(null, i, view);
            }
        });
        this.kTP = new com.baidu.tbadk.core.dialog.i(this.kHX.getPageContext(), kVar);
        this.kTP.NY();
    }

    public void a(final b.InterfaceC0533b interfaceC0533b, boolean z) {
        if (this.kTP != null) {
            this.kTP.dismiss();
            this.kTP = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kHX.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kJe != null && this.kJe.cYR() != null && !this.kJe.cYR().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kHX.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kHX.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aX(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kTP.dismiss();
                interfaceC0533b.a(null, i, view);
            }
        });
        this.kTP = new com.baidu.tbadk.core.dialog.i(this.kHX.getPageContext(), kVar);
        this.kTP.NY();
    }

    public int det() {
        return EV(this.kTo.getFirstVisiblePosition());
    }

    private int EV(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.kTo.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.kTo.getAdapter() == null || !(this.kTo.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.kTo.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int deu() {
        int lastVisiblePosition = this.kTo.getLastVisiblePosition();
        if (this.kTq != null) {
            if (lastVisiblePosition == this.kTo.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return EV(lastVisiblePosition);
    }

    public void EW(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.kTo != null) {
            if (this.kTk == null || this.kTk.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.kTk.mNavigationBar.getFixedNavHeight();
                if (this.kHX.dbl() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.kUp != null && (layoutParams = (LinearLayout.LayoutParams) this.kUp.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.kUp.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.kTo.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.kTo.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.kTo.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.kTC.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.kTz.a(fVar, false);
        this.kTz.notifyDataSetChanged();
        deD();
        if (this.kUS != null) {
            this.kUS.dad();
        }
        ArrayList<PostData> cYT = fVar.cYT();
        if (fVar.getPage().beo() == 0 || cYT == null || cYT.size() < fVar.getPage().ben()) {
            if (com.baidu.tbadk.core.util.y.getCount(cYT) == 0 || (com.baidu.tbadk.core.util.y.getCount(cYT) == 1 && cYT.get(0) != null && cYT.get(0).dAD() == 1)) {
                if (this.kUu == null || this.kUu.kVz == null || this.kUu.kVz.getView() == null) {
                    i = 0;
                } else {
                    i = this.kUu.kVz.getView().getTop() < 0 ? this.kUu.kVz.getView().getHeight() : this.kUu.kVz.getView().getBottom();
                }
                if (this.kHX.dbF()) {
                    this.ihW.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.ihW.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().beo() == 0) {
                    this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.ihW.blr();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.kTr != null) {
            this.kTr.e(fVar, this.kIM);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cZe() != null) {
            return fVar.cZe();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cYT())) {
            Iterator<PostData> it = fVar.cYT().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dAD() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cZa();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bfy() != null && postData.bfy().getUserTbVipInfoData() != null && postData.bfy().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bfy().getGodUserData().setIntro(postData.bfy().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bfy() == null) {
            return false;
        }
        MetaData bfy = postData.bfy();
        return (TextUtils.isEmpty(bfy.getUserId()) && TextUtils.isEmpty(bfy.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cYR() == null || fVar.cYR().bfy() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bfy = fVar.cYR().bfy();
        String userId = bfy.getUserId();
        HashMap<String, MetaData> userMap = fVar.cYR().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bfy;
        }
        postData.Is(1);
        postData.setId(fVar.cYR().bfP());
        postData.setTitle(fVar.cYR().getTitle());
        postData.setTime(fVar.cYR().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.cYR() != null) {
            if (this.kHX.cZX()) {
                if (fVar.cYQ() != null) {
                    this.mForumName = fVar.cYQ().getForumName();
                    this.mForumId = fVar.cYQ().getForumId();
                }
                if (this.mForumName == null && this.kHX.dah() != null && this.kHX.dah().cZY() != null) {
                    this.mForumName = this.kHX.dah().cZY();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.kTt.setVisibility(8);
            if (fVar.cZr()) {
                this.kUJ = true;
                this.kTk.uc(true);
                this.kTk.mNavigationBar.hideBottomLine();
                if (this.kTq == null) {
                    this.kTq = new com.baidu.tieba.pb.pb.main.a.e(this.kHX);
                }
                this.kTq.a(fVar, b, this.kTo, this.kTt, this.kUn, this.kTk, this.mForumName, this.kUX);
                this.kTq.V(this.kVi);
                dey();
            } else {
                this.kUJ = false;
                this.kTk.uc(this.kUJ);
                if (this.kTq != null) {
                    this.kTq.c(this.kTo);
                }
            }
            if (this.kHX.daV() != null) {
                this.kHX.daV().tW(this.kUJ);
            }
            if (b != null) {
                this.kUj = b;
                this.kTt.setVisibility(0);
                SparseArray<Object> dfw = this.kTt.dfw();
                dfw.put(R.id.tag_clip_board, b);
                dfw.put(R.id.tag_is_subpb, false);
                this.kTu.a(fVar, this.kTo);
                this.kTs.A(fVar);
                this.kTr.e(fVar, this.kIM);
                this.kTr.z(fVar);
                this.kTt.a(this.mSkinType, this.kJe, b, this.kVi);
                if (this.kUq != null) {
                    if (fVar.cZu()) {
                        this.kUq.getView().setVisibility(8);
                    } else {
                        this.kUq.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kGC);
                        if (fVar.cYR() != null) {
                            nVar.kGE = fVar.cYR().bfp();
                        }
                        nVar.isNew = !this.kIM;
                        nVar.sortType = fVar.kFo;
                        nVar.kGG = fVar.cZv();
                        nVar.kGH = this.kHX.dbF();
                        nVar.kGI = fVar.kFn;
                        this.kUq.a(nVar);
                    }
                }
                if (fVar != null && fVar.cYR() != null) {
                    ar(fVar.cYR().bfu() == 1, fVar.cYR().bft() == 1);
                }
                com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.kTz != null && az.this.kTk != null && az.this.kTk.kZC != null && az.this.kJe != null && az.this.kJe.cYR() != null && !az.this.kJe.cYR().bee() && !az.this.deC() && az.this.kJe.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(az.this.kJe.getForum().getName())) {
                            if ((az.this.kTz.daJ() == null || !az.this.kTz.daJ().isShown()) && az.this.kTk.kZC != null) {
                                az.this.kTk.kZC.setVisibility(0);
                                if (az.this.kHX != null && az.this.kHX.dah() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dF("tid", az.this.kHX.dah().dcf());
                                    aqVar.dF("fid", az.this.kHX.dah().getForumId());
                                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void tG(boolean z) {
        if (z) {
            dev();
        } else {
            cjh();
        }
        this.kUu.kVz = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kUu));
        a(this.kUu.kVz, false);
    }

    public void dev() {
        if (this.kTk != null && !this.kUL) {
            this.kTk.dev();
            this.kUL = true;
        }
    }

    public void cjh() {
        if (this.kTk != null) {
            this.kTk.dfU();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.kTt.a(postData, fVar);
    }

    public void dew() {
        if (this.kTq != null) {
            this.kTq.d(this.kTo);
        }
    }

    public boolean dex() {
        return this.bax;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bfy() == null) {
            return false;
        }
        PostData b = b(this.kJe, false);
        String str = "";
        if (b != null && b.bfy() != null) {
            str = b.bfy().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.kTk.dfS();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.kTk.Mb(dVar.forumName);
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
            final String str2 = dVar.kFf;
            this.kHX.showNetRefreshView(this.bsG, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.be.bkp().b(az.this.kHX.getPageContext(), new String[]{str2});
                        az.this.kHX.finish();
                        return;
                    }
                    az.this.kHX.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable ddB;
        Parcelable ddB2;
        if (fVar != null && this.kTo != null) {
            this.kJe = fVar;
            this.mType = i;
            if (fVar.cYR() != null) {
                this.kUw = fVar.cYR().bff();
                if (fVar.cYR().getAnchorLevel() != 0) {
                    this.bax = true;
                }
                this.kTR = aK(fVar.cYR());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.kUk = false;
            this.kIM = z;
            der();
            if (fVar.kFp != null && fVar.kFp.cZA()) {
                if (this.kTp == null) {
                    this.kTp = new PbThreadPostView(this.kHX.getContext());
                    this.kTo.addHeaderView(this.kTp, 1);
                    this.kTp.setData(fVar);
                    this.kTp.setChildOnClickLinstener(this.icH);
                }
            } else if (this.kTp != null && this.kTo != null) {
                this.kTo.removeHeaderView(this.kTp);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.kUV == null) {
                this.kUV = new al(this.kHX.getPageContext(), this.iDk);
            }
            this.kUV.Oh(fVar.cYY());
            if (this.kHX.dbv()) {
                if (this.kTD == null) {
                    this.kTD = new com.baidu.tieba.pb.view.d(this.kHX.getPageContext());
                    this.kTD.createView();
                    this.kTD.setListPullRefreshListener(this.evf);
                }
                this.kTo.setPullRefresh(this.kTD);
                dey();
                if (this.kTD != null) {
                    this.kTD.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bep() == 0 && z) {
                this.kTo.setPullRefresh(null);
            } else {
                if (this.kTD == null) {
                    this.kTD = new com.baidu.tieba.pb.view.d(this.kHX.getPageContext());
                    this.kTD.createView();
                    this.kTD.setListPullRefreshListener(this.evf);
                }
                this.kTo.setPullRefresh(this.kTD);
                dey();
                if (this.kTD != null) {
                    this.kTD.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bXZ();
            }
            deD();
            this.kTz.sN(this.kIM);
            this.kTz.sO(false);
            this.kTz.sS(i == 5);
            this.kTz.sT(i == 6);
            this.kTz.sU(z2 && this.kVh && i != 2);
            this.kTz.a(fVar, false);
            this.kTz.notifyDataSetChanged();
            this.kTt.b(b(fVar, z), fVar.cZu());
            if (fVar.cYR() != null && fVar.cYR().bfj() != null && this.kTi != -1) {
                fVar.cYR().bfj().setIsLike(this.kTi);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.kTo.setNextPage(this.ihW);
                this.kTj = 2;
                bXZ();
            } else {
                this.kUk = true;
                if (fVar.getPage().beo() == 1) {
                    if (this.kTE == null) {
                        this.kTE = new com.baidu.tieba.pb.view.a(this.kHX, this.kHX);
                    }
                    this.kTo.setNextPage(this.kTE);
                } else {
                    this.kTo.setNextPage(this.ihW);
                }
                this.kTj = 3;
            }
            ArrayList<PostData> cYT = fVar.cYT();
            if (fVar.getPage().beo() == 0 || cYT == null || cYT.size() < fVar.getPage().ben()) {
                if (com.baidu.tbadk.core.util.y.getCount(cYT) == 0 || (com.baidu.tbadk.core.util.y.getCount(cYT) == 1 && cYT.get(0) != null && cYT.get(0).dAD() == 1)) {
                    if (this.kUu == null || this.kUu.kVz == null || this.kUu.kVz.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kUu.kVz.getView().getTop() < 0 ? this.kUu.kVz.getView().getHeight() : this.kUu.kVz.getView().getBottom();
                    }
                    if (this.kHX.dbF()) {
                        this.ihW.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.ihW.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kHX.daV() != null && !this.kHX.daV().dfG()) {
                        this.kHX.daV().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().beo() == 0) {
                        this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.ihW.blr();
                }
                if (fVar.getPage().beo() == 0 || cYT == null) {
                    deN();
                }
            } else {
                if (z2) {
                    if (this.kVh) {
                        endLoadData();
                        if (fVar.getPage().beo() != 0) {
                            this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.ihW.setLineVisible();
                        this.ihW.showLoading();
                    }
                } else {
                    this.ihW.setLineVisible();
                    this.ihW.showLoading();
                }
                this.ihW.blr();
            }
            switch (i) {
                case 2:
                    this.kTo.setSelection(i2 > 1 ? (((this.kTo.getData() == null && fVar.cYT() == null) ? 0 : (this.kTo.getData().size() - fVar.cYT().size()) + this.kTo.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (ddB2 = as.ddA().ddB()) != null && !(ddB2 instanceof RecyclerView.SavedState)) {
                        this.kTo.onRestoreInstanceState(ddB2);
                        if (com.baidu.tbadk.core.util.y.getCount(cYT) > 1 && fVar.getPage().beo() > 0) {
                            this.ihW.endLoadData();
                            this.ihW.setText(this.kHX.getString(R.string.pb_load_more_without_point));
                            this.ihW.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.kVh = false;
                    break;
                case 5:
                    this.kTo.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (ddB = as.ddA().ddB()) != null && !(ddB instanceof RecyclerView.SavedState)) {
                        this.kTo.onRestoreInstanceState(ddB);
                        break;
                    } else {
                        this.kTo.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.kTq != null && this.kTq.bHA() != null) {
                            if (this.kHX.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.kTo.setSelectionFromTop((this.kTz.daE() + this.kTo.getHeaderViewsCount()) - 1, this.kTq.dfy() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kHX.getPageContext().getPageActivity()));
                            } else {
                                this.kTo.setSelectionFromTop((this.kTz.daE() + this.kTo.getHeaderViewsCount()) - 1, this.kTq.dfy());
                            }
                        } else {
                            this.kTo.setSelection(this.kTz.daE() + this.kTo.getHeaderViewsCount());
                        }
                    } else {
                        this.kTo.setSelection(i2 > 0 ? ((this.kTo.getData() == null && fVar.cYT() == null) ? 0 : (this.kTo.getData().size() - fVar.cYT().size()) + this.kTo.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.ihW.endLoadData();
                    this.ihW.setText(this.kHX.getString(R.string.pb_load_more_without_point));
                    this.ihW.setLineGone();
                    break;
            }
            if (this.kUw == kUx && isHost()) {
                deV();
            }
            if (this.kUH) {
                ddO();
                this.kUH = false;
                if (i3 == 0) {
                    tz(true);
                }
            }
            if (fVar.kFl == 1 || fVar.kFm == 1) {
                if (this.kUN == null) {
                    this.kUN = new PbTopTipView(this.kHX.getContext());
                }
                if (fVar.kFm == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kHX.getStType())) {
                    this.kUN.setText(this.kHX.getString(R.string.pb_read_strategy_add_experience));
                    this.kUN.a(this.bsG, this.mSkinType);
                } else if (fVar.kFl == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kHX.getStType())) {
                    this.kUN.setText(this.kHX.getString(R.string.pb_read_news_add_experience));
                    this.kUN.a(this.bsG, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            x(fVar);
            if (fVar.bbu()) {
                SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String EX = EX(fVar.cYR().bfp());
            if (this.kUe != null) {
                this.kUe.setText(EX);
            }
            if (this.kUf != null) {
                this.kUf.setText(EX);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cYR()));
        }
    }

    private String EX(int i) {
        if (i == 0) {
            return this.kHX.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dey() {
        if (this.kTq != null) {
            this.kTq.a(this.kTo, this.textView, this.mType);
        }
    }

    public void tH(boolean z) {
        this.kTQ = z;
    }

    public void endLoadData() {
        if (this.ihW != null) {
            this.ihW.setLineGone();
            this.ihW.endLoadData();
        }
        bXZ();
    }

    public void bMD() {
        this.kTo.setVisibility(0);
    }

    public void dez() {
        if (this.kTo != null) {
            this.kTo.setVisibility(8);
        }
        if (this.kTo != null) {
            this.kUn.setVisibility(8);
        }
        if (this.kTk != null && this.kTk.kZB != null) {
            this.kTk.kZB.setVisibility(8);
        }
    }

    public void deA() {
        if (this.kTo != null) {
            this.kTo.setVisibility(0);
        }
        if (this.kUn != null) {
            this.kUn.setVisibility(0);
        }
        if (this.kTk != null && this.kTk.kZB != null) {
            this.kTk.kZB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.kUj != null && this.kUj.bfy() != null && this.kTk != null) {
            this.kUK = !this.kUJ;
            this.kTk.tY(this.kUK);
            if (this.kHX.daV() != null) {
                this.kHX.daV().tX(this.kUK);
            }
            deB();
            if (this.kHX != null && !this.kHX.cZX() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cZo())) {
                bs bsVar = fVar.cZo().get(0);
                if (bsVar != null) {
                    this.kTk.fI(bsVar.getForumName(), bsVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.kTk.fI(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.kUK) {
                this.kTt.a(fVar, this.kUj, this.kTR);
                if (this.kUp != null) {
                    this.kUp.setVisibility(8);
                }
                if (this.kUT == null) {
                    this.kUT = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.kHX != null && az.this.kHX.isAdded()) {
                                if (i < 0 && f > az.this.kUM) {
                                    az.this.deI();
                                    az.this.deU();
                                }
                                az.this.des();
                            }
                        }
                    };
                }
                this.kTo.setListViewDragListener(this.kUT);
                return;
            }
            if (this.kUp != null) {
                this.kUp.setVisibility(0);
            }
            this.kTt.a(fVar, this.kUj, this.kTR);
            this.kUT = null;
            this.kTo.setListViewDragListener(null);
        }
    }

    private void deB() {
        this.kTt.a(this.kJe, this.kUj, this.kUK, this.kUJ);
    }

    public boolean deC() {
        return this.kJe == null || this.kJe.getForum() == null || "0".equals(this.kJe.getForum().getId()) || "me0407".equals(this.kJe.getForum().getName());
    }

    private boolean deD() {
        return this.kTr.tT(this.kIM);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cYR() == null) {
            return false;
        }
        if (fVar.cYR().bfv() == 1 || fVar.cYR().getThreadType() == 33) {
            return true;
        }
        return !(fVar.cYR().bfx() == null || fVar.cYR().bfx().bhN() == 0) || fVar.cYR().bft() == 1 || fVar.cYR().bfu() == 1 || fVar.cYR().bgm() || fVar.cYR().bgG() || fVar.cYR().bgz() || fVar.cYR().bfJ() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.cYR().getCategory()) || fVar.cYR().bfB() || fVar.cYR().bfA();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.kTs != null) {
                if (fVar.cYR() != null && fVar.cYR().bfM() == 0 && !fVar.cYR().bee() && !this.kVa) {
                    if (fVar.cYR() != null) {
                        bw cYR = fVar.cYR();
                        cYR.z(true, w(fVar));
                        cYR.nq(3);
                        cYR.zI("2");
                    }
                    if (fVar.cYR().beg()) {
                        this.kTt.c(this.kTo);
                        this.kTs.c(this.kTo);
                        this.kTs.b(this.kTo);
                        this.kTt.b(this.kTo);
                        this.kTt.E(this.kJe);
                        this.kTs.B(fVar);
                    } else {
                        this.kTt.E(this.kJe);
                        this.kTs.D(fVar);
                    }
                } else if (fVar.cYR().bfM() == 1) {
                    if (fVar.cYR() != null) {
                        this.kTs.c(this.kTo);
                        this.kTt.E(this.kJe);
                    }
                } else {
                    this.kTs.c(this.kTo);
                    this.kTt.E(this.kJe);
                }
            }
            if (fVar.cYR() != null) {
                aq(fVar.cYR().bfu() == 1, fVar.cYR().bft() == 1);
            }
            this.kIM = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            deD();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.bfy().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cZg()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.bfy() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.bfy().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.bfy().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.bfy().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cZg()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> cZo = fVar.cZo();
                if (com.baidu.tbadk.core.util.y.getCount(cZo) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : cZo) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.ecI) != null && abVar.eau && !abVar.eav && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(this.kHX.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kHX.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View deE() {
        return this.eTU;
    }

    public boolean deF() {
        if (this.btr == null || this.btr.getParent() == null || this.ihW.isLoading()) {
            return false;
        }
        int bottom = this.btr.getBottom();
        Rect rect = new Rect();
        this.btr.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Oj(String str) {
        if (this.ihW != null) {
            this.ihW.setText(str);
        }
    }

    public void Ok(String str) {
        if (this.ihW != null) {
            int i = 0;
            if (this.kUu != null && this.kUu.kVz != null && this.kUu.kVz.getView() != null) {
                i = this.kUu.kVz.getView().getTop() < 0 ? this.kUu.kVz.getView().getHeight() : this.kUu.kVz.getView().getBottom();
            }
            this.ihW.am(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.kTo;
    }

    public int deG() {
        return R.id.richText;
    }

    public TextView dar() {
        return this.kTt.dar();
    }

    public void d(BdListView.e eVar) {
        this.kTo.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.evf = cVar;
        if (this.kTD != null) {
            this.kTD.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.av avVar, a.b bVar) {
        if (avVar != null) {
            int bem = avVar.bem();
            int bej = avVar.bej();
            if (this.kTA != null) {
                this.kTA.bia();
            } else {
                this.kTA = new com.baidu.tbadk.core.dialog.a(this.kHX.getPageContext().getPageActivity());
                this.kTB = LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.kTA.aZ(this.kTB);
                this.kTA.a(R.string.dialog_ok, bVar);
                this.kTA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.deI();
                        aVar.dismiss();
                    }
                });
                this.kTA.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.kUE == null) {
                            az.this.kUE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.kHX.HidenSoftKeyPad((InputMethodManager) az.this.kHX.getBaseFragmentActivity().getSystemService("input_method"), az.this.bsG);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mX().postDelayed(az.this.kUE, 150L);
                    }
                });
                this.kTA.b(this.kHX.getPageContext()).bia();
            }
            this.kTC = (EditText) this.kTB.findViewById(R.id.input_page_number);
            this.kTC.setText("");
            TextView textView = (TextView) this.kTB.findViewById(R.id.current_page_number);
            if (bem <= 0) {
                bem = 1;
            }
            if (bej <= 0) {
                bej = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bem), Integer.valueOf(bej)));
            this.kHX.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.kTC, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.kTo.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kHX.showToast(str);
    }

    public boolean tI(boolean z) {
        if (this.aaS == null || !this.aaS.bsz()) {
            return false;
        }
        this.aaS.bqS();
        return true;
    }

    public void deH() {
        if (this.kVj != null) {
            while (this.kVj.size() > 0) {
                TbImageView remove = this.kVj.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        deH();
        this.kTz.Ex(1);
        if (this.kTq != null) {
            this.kTq.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.kTz.Ex(2);
        if (this.kTq != null) {
            this.kTq.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kHX.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kHX.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.kUd != null) {
            this.kUd.onDestroy();
        }
        if (this.kUG != null) {
            this.kUG.destroy();
        }
        if (this.kUV != null) {
            this.kUV.onDestory();
        }
        if (this.kUN != null) {
            this.kUN.hide();
        }
        this.kHX.hideProgressBar();
        if (this.fFC != null && this.hXf != null) {
            this.fFC.b(this.hXf);
        }
        deI();
        endLoadData();
        if (this.kUE != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.kUE);
        }
        if (this.kUm != null) {
            this.kUm.clearStatus();
        }
        this.kVd = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.kTz.Ex(3);
        if (this.brO != null) {
            this.brO.setBackgroundDrawable(null);
        }
        if (this.kTq != null) {
            this.kTq.destroy();
        }
        if (this.kTz != null) {
            this.kTz.onDestroy();
        }
        this.kTo.setOnLayoutListener(null);
        if (this.kUR != null) {
            this.kUR.csi();
        }
        if (this.kUv != null) {
            this.kUv.onDestroy();
        }
        if (this.kTt != null) {
            this.kTt.onDestroy();
        }
    }

    public boolean EY(int i) {
        if (this.kTq != null) {
            return this.kTq.EY(i);
        }
        return false;
    }

    public void deI() {
        this.kTk.aSz();
        if (this.kTt != null) {
            this.kTt.deI();
        }
        if (this.kHX != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kHX.getContext(), this.kTC);
        }
        ddQ();
        if (this.kMj != null) {
            this.kMj.dismiss();
        }
        deK();
        if (this.kTA != null) {
            this.kTA.dismiss();
        }
        if (this.icG != null) {
            this.icG.dismiss();
        }
    }

    public void deJ() {
        this.kTk.aSz();
        if (this.kTt != null) {
            this.kTt.deI();
        }
        if (this.kMj != null) {
            this.kMj.dismiss();
        }
        deK();
        if (this.kTA != null) {
            this.kTA.dismiss();
        }
        if (this.icG != null) {
            this.icG.dismiss();
        }
    }

    public void eK(List<String> list) {
        this.kUQ = list;
        if (this.kUR != null) {
            this.kUR.setData(list);
        }
    }

    public void sM(boolean z) {
        this.kTz.sM(z);
    }

    public void tJ(boolean z) {
        this.kTT = z;
    }

    public void deK() {
        if (this.kTH != null) {
            this.kTH.dismiss();
        }
        if (this.kTI != null) {
            com.baidu.adp.lib.f.g.b(this.kTI, this.kHX.getPageContext());
        }
        if (this.kTJ != null) {
            com.baidu.adp.lib.f.g.b(this.kTJ, this.kHX.getPageContext());
        }
        if (this.kTG != null) {
            this.kTG.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.kJe, this.kIM);
            b(this.kJe, this.kIM, this.mType, i);
            this.kHX.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kHX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bsG);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bsG, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kTU, R.drawable.personalize_tab_shadow);
            if (this.kTq != null) {
                this.kTq.onChangeSkinType(i);
            }
            if (this.kTu != null) {
                this.kTu.onChangeSkinType(i);
            }
            if (this.kTr != null) {
                this.kTr.onChangeSkinType(i);
            }
            if (this.kTs != null) {
                this.kTs.onChangeSkinType(i);
            }
            if (this.kTt != null) {
                this.kTt.onChangeSkinType(i);
            }
            if (this.ihW != null) {
                this.ihW.changeSkin(i);
                if (this.eTU != null) {
                    this.kHX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eTU);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(this.eTU, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.kTA != null) {
                this.kTA.c(this.kHX.getPageContext());
            }
            tH(this.kTQ);
            this.kTz.notifyDataSetChanged();
            if (this.kTD != null) {
                this.kTD.changeSkin(i);
            }
            if (this.aaS != null) {
                this.aaS.onChangeSkinType(i);
            }
            if (this.kTE != null) {
                this.kTE.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hth)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.hth) {
                    customBlueCheckRadioButton.ble();
                }
            }
            deh();
            UtilHelper.setStatusBarBackground(this.brO, i);
            UtilHelper.setStatusBarBackground(this.kUp, i);
            if (this.kTv != null) {
                com.baidu.tbadk.r.a.a(this.kHX.getPageContext(), this.kTv);
            }
            if (this.kUF != null) {
                this.kUF.onChangeSkinType(i);
            }
            if (this.kTk != null) {
                if (this.kTq != null) {
                    this.kTq.EZ(i);
                } else {
                    this.kTk.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.jcG != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.jcG, R.color.cp_cont_d);
            }
            if (this.kTZ != null) {
                this.kTZ.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
            }
            if (this.kTY != null) {
                this.kTY.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.kHX.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j)));
            }
            if (this.kUb != null && this.kJe != null) {
                if (this.kJe.bbu()) {
                    SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.kJe);
            if (this.kUa != null) {
                SvgManager.bkl().a(this.kUa, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kTW != null) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kTW, R.drawable.bottom_shadow);
            }
            if (this.kUe != null) {
                com.baidu.tbadk.core.util.ap.c(this.kUe, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kUe, R.color.cp_cont_j);
            }
            if (this.kUf != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kUf, R.color.cp_cont_b);
            }
            if (this.kUS != null) {
                this.kUS.onChangeSkinType(i);
            }
            if (this.kUv != null) {
                this.kUv.onChangeSkinType();
            }
            if (this.kUP != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kUP, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kTX, R.color.cp_bg_line_h);
            if (this.kTp != null) {
                this.kTp.tE(i);
            }
            if (this.kUd != null) {
                this.kUd.onChangeSkinType();
            }
        }
    }

    public void deL() {
        if (this.kUd != null) {
            this.kUd.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.cYR())) {
            if (this.kUd != null) {
                this.kUd.setEnable(false);
                this.kUd.onDestroy();
            }
            SvgManager.bkl().a(this.kUc, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kUd == null || !this.kUd.isEnable()) {
            SvgManager.bkl().a(this.kUc, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
        this.kTz.setOnImageClickListener(this.ffu);
        this.kUS.setOnImageClickListener(this.ffu);
    }

    public void g(NoNetworkView.a aVar) {
        this.hXf = aVar;
        if (this.fFC != null) {
            this.fFC.a(this.hXf);
        }
    }

    public void tK(boolean z) {
        this.kTz.setIsFromCDN(z);
    }

    public Button deM() {
        return this.kTV;
    }

    public void deN() {
        if (this.kTj != 2) {
            this.kTo.setNextPage(this.ihW);
            this.kTj = 2;
        }
    }

    public void deO() {
        if (com.baidu.tbadk.n.m.bvs().bvt()) {
            int lastVisiblePosition = this.kTo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.kTo.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.eUD = true;
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
                        perfLog2.eUD = true;
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

    public boolean deP() {
        return this.aaS != null && this.aaS.getVisibility() == 0;
    }

    public boolean deQ() {
        return this.aaS != null && this.aaS.bsz();
    }

    public void deR() {
        if (this.aaS != null) {
            this.aaS.bqS();
        }
    }

    public void tL(boolean z) {
        if (this.kTX != null) {
            tJ(this.kHX.daS().btj());
            if (this.kTT) {
                tA(z);
            } else {
                tB(z);
            }
        }
    }

    public void deS() {
        if (this.kTX != null) {
            this.kTW.setVisibility(8);
            this.kTX.setVisibility(8);
            this.kUg = false;
            if (this.kUv != null) {
                this.kUv.setVisibility(8);
                tF(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hxf == null) {
            this.hxf = new com.baidu.tbadk.core.view.a(this.kHX.getPageContext());
        }
        this.hxf.setDialogVisiable(true);
    }

    public void bXZ() {
        if (this.hxf != null) {
            this.hxf.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.kTo.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.kTo.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kTq != null) {
            this.kTq.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.kVk = getScrollY();
            this.kUu.kVz = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kUu));
            a(this.kUu.kVz, true);
        }
    }

    public void tM(boolean z) {
        if (this.kTq != null) {
            this.kTq.tM(z);
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
        if (this.kTq != null) {
            this.kTq.onScroll(absListView, i, i2, i3);
        }
        if (this.kTk != null && this.kTt != null) {
            this.kTk.de(this.kTt.dfu());
        }
        this.kUu.kyU = i;
        this.kUu.headerCount = this.kTo.getHeaderViewsCount();
        this.kUu.kVz = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kUu));
        tC(b(absListView, i));
        a(this.kUu.kVz, false);
        if (this.ihW.bls() && !this.ihW.eum) {
            if (this.kUu != null && this.kUu.kVz != null && this.kUu.kVz.getView() != null) {
                i4 = this.kUu.kVz.getView().getTop() < 0 ? this.kUu.kVz.getView().getHeight() : this.kUu.kVz.getView().getBottom();
            }
            this.ihW.pa(i4);
            this.ihW.eum = true;
        }
    }

    public void deT() {
        if (TbadkCoreApplication.isLogin() && this.kJe != null && this.kUK && !this.kUJ && !this.kTR && this.kUj != null && this.kUj.bfy() != null && !this.kUj.bfy().getIsLike() && !this.kUj.bfy().hadConcerned() && this.kUG == null) {
            this.kUG = new av(this.kHX);
        }
    }

    public void deU() {
        if (this.kHX != null) {
            if ((this.hZJ || this.kUY == 17) && com.baidu.tbadk.a.d.baX()) {
                if (this.kJe != null && this.kJe.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kJe.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.kHX.getContext()).createNormalCfg(this.kJe.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dF("post_id", this.kJe.getThreadId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("fid", this.kJe.getForum().getId()));
                }
            } else if (this.kUK && !this.kUJ && this.kUj != null && this.kUj.bfy() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").ai("obj_locate", this.kHX.cZX() ? 2 : 1).ai("obj_type", this.kUJ ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kHX.getPageContext().getPageActivity(), this.kUj.bfy().getUserId(), this.kUj.bfy().getUserName(), this.kHX.dah().cZY(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.kUJ && this.kUo != null && this.kTk.dfM() != null) {
            int daF = this.kTz.daF();
            if (daF > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (daF > this.kTo.getFirstVisiblePosition() - this.kTo.getHeaderViewsCount()) {
                    this.kUo.setVisibility(4);
                    return;
                }
                this.kUo.setVisibility(0);
                tC(false);
                this.kTk.mNavigationBar.hideBottomLine();
                if (this.kUo.getParent() != null && ((ViewGroup) this.kUo.getParent()).getHeight() <= this.kUo.getTop()) {
                    this.kUo.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.kSJ == null) {
                if (this.kTo.getFirstVisiblePosition() == 0) {
                    this.kUo.setVisibility(4);
                    this.kTk.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.kUt) {
                        this.kUs = top;
                        this.kUt = false;
                    }
                    this.kUs = top < this.kUs ? top : this.kUs;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.kTy.getY() < 0.0f) {
                        measuredHeight = kUr - auVar.kSJ.getMeasuredHeight();
                    } else {
                        measuredHeight = this.kTk.dfM().getMeasuredHeight() - auVar.kSJ.getMeasuredHeight();
                        this.kTk.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.kUs) {
                        this.kUo.setVisibility(0);
                        tC(false);
                    } else if (top < measuredHeight) {
                        this.kUo.setVisibility(0);
                        tC(false);
                    } else {
                        this.kUo.setVisibility(4);
                        this.kTk.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.kUt = true;
                    }
                }
            }
        }
    }

    public void deV() {
        if (!this.kVl) {
            TiebaStatic.log("c10490");
            this.kVl = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHX.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(kUy, Integer.valueOf(kUA));
            aVar.nD(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aZ(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kHX);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kHX.getPageContext()).bia();
        }
    }

    public void Ol(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHX.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aZ(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(kUy, Integer.valueOf(kUB));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kHX);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kHX.getPageContext()).bia();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.bfy() != null) {
            MetaData bfy = b.bfy();
            bfy.setGiftNum(bfy.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.kTt.onChangeSkinType(i2);
    }

    public PbInterviewStatusView deW() {
        return this.kUm;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cYR() != null && fVar.cYR().bgG() && this.kUm == null) {
            this.kUm = (PbInterviewStatusView) this.kUl.inflate();
            this.kUm.setOnClickListener(this.icH);
            this.kUm.setCallback(this.kHX.dbD());
            this.kUm.setData(this.kHX, fVar);
        }
    }

    public RelativeLayout deX() {
        return this.kTy;
    }

    public View deY() {
        return this.brO;
    }

    public boolean deZ() {
        return this.kVa;
    }

    public void sR(boolean z) {
        this.kTt.sR(z);
    }

    public void Om(String str) {
        if (this.kTl != null) {
            this.kTl.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int tN(boolean z) {
        if (this.kUm == null || this.kUm.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dfa() {
        if (this.kUm != null && this.kUm.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kUm.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.kUm.setLayoutParams(layoutParams);
        }
    }

    public boolean daY() {
        return false;
    }

    public void On(String str) {
        this.jcG.performClick();
        if (!StringUtils.isNull(str) && this.kHX.daS() != null && this.kHX.daS().btb() != null && this.kHX.daS().btb().getInputView() != null) {
            EditText inputView = this.kHX.daS().btb().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            deI();
            if (configuration.orientation == 2) {
                deS();
                ddQ();
            } else {
                ddU();
            }
            if (this.kUF != null) {
                this.kUF.daN();
            }
            this.kHX.cpF();
            this.kTy.setVisibility(8);
            this.kTk.tZ(false);
            this.kHX.tg(false);
            if (this.kTq != null) {
                if (configuration.orientation == 1) {
                    deX().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.kTo.setIsLandscape(true);
                    this.kTo.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.kTo.setIsLandscape(false);
                    if (this.kVk > 0) {
                        this.kTo.smoothScrollBy(this.kVk, 0);
                    }
                }
                this.kTq.onConfigurationChanged(configuration);
                this.kUn.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void tO(boolean z) {
        if (this.kTq != null) {
            this.kTq.tO(z);
        }
    }

    public boolean dfb() {
        return this.kTq != null && this.kTq.dfb();
    }

    public void dfc() {
        if (this.kTq != null) {
            this.kTq.dfc();
        }
    }

    public void sV(boolean z) {
        this.kTz.sV(z);
    }

    public void dd(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.kTX.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kHX.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.kUP = new TextView(this.kHX.getContext());
            this.kUP.setText(R.string.connection_tips);
            this.kUP.setGravity(17);
            this.kUP.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kHX.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kHX.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kHX.getContext(), R.dimen.ds60);
            if (this.kUP.getParent() == null) {
                frameLayout.addView(this.kUP, layoutParams);
            }
            this.kUO = new PopupWindow(this.kHX.getContext());
            this.kUO.setContentView(frameLayout);
            this.kUO.setHeight(-2);
            this.kUO.setWidth(-2);
            this.kUO.setFocusable(true);
            this.kUO.setOutsideTouchable(false);
            this.kUO.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.kTo.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.kUO.showAsDropDown(az.this.kTX, view.getLeft(), -az.this.kTX.getHeight());
                    } else {
                        az.this.kUO.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void tP(boolean z) {
        this.kUU = z;
    }

    public boolean dfd() {
        return this.kUU;
    }

    public PbThreadPostView dfe() {
        return this.kTp;
    }

    private void aq(boolean z, boolean z2) {
        ar(z, z2);
        if (this.kJe != null && this.kJe.cYR() != null && this.kJe.cYR().bfM() == 0 && !this.kJe.cYR().bee()) {
            as(z, z2);
        } else if (this.kTz != null && this.kTz.daK() != null) {
            this.kTz.daK().b(this.kJe, z, z2);
        }
    }

    private void ar(boolean z, boolean z2) {
        this.kTt.d(this.kJe, z, z2);
    }

    private void as(boolean z, boolean z2) {
        this.kTs.c(this.kJe, z, z2);
    }

    public void tQ(boolean z) {
        this.hZJ = z;
    }

    public void EQ(int i) {
        this.kUY = i;
    }

    public void dff() {
        if (this.kTo != null) {
            this.kTo.setForbidDragListener(true);
        }
    }

    public boolean dbX() {
        if (this.kTo == null) {
            return false;
        }
        return this.kTo.dbX();
    }

    public boolean dfg() {
        if (this.ihW == null || TextUtils.isEmpty(this.ihW.getEndText())) {
            return false;
        }
        return this.ihW.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
