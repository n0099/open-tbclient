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
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
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
/* loaded from: classes2.dex */
public class ap {
    private EditorTools ael;
    private View bMJ;
    private RelativeLayout bND;
    private View bOm;
    private View fKb;
    private f.c fkY;
    private com.baidu.tieba.pb.a.c fxj;
    private NoNetworkView gzT;
    private List<CustomBlueCheckRadioButton> iBq;
    private boolean isLandscape;
    private NavigationBarCoverTip jOd;
    private com.baidu.tieba.NEGFeedBack.f jSR;
    private boolean jhS;
    private View.OnClickListener jkS;
    private PbListView jqc;
    private TextView krw;
    private PbFragment lPo;
    private com.baidu.tieba.pb.data.f lQH;
    private View.OnClickListener lQu;
    private MaskView lSi;
    private com.baidu.tieba.pb.pb.main.a.d lSj;
    private PbFakeFloorModel lTf;
    PbFragment.c lUZ;
    public int mLastScrollY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    public int maZ;
    private View mbM;
    private View mbO;
    private View mbP;
    private LinearLayout mbQ;
    private HeadImageView mbR;
    private ImageView mbS;
    private ImageView mbT;
    private ImageView mbU;
    private com.baidu.tieba.pb.view.d mbV;
    private TextView mbW;
    private TextView mbX;
    private int mbZ;
    public final com.baidu.tieba.pb.pb.main.view.c mbb;
    public com.baidu.tieba.pb.pb.main.view.b mbc;
    private ViewStub mbd;
    private ViewStub mbe;
    private PbLandscapeListView mbf;
    private PbThreadPostView mbg;
    private com.baidu.tieba.pb.pb.main.a.f mbh;
    private com.baidu.tieba.pb.pb.main.a.a mbi;
    private com.baidu.tieba.pb.pb.main.a.c mbj;
    private com.baidu.tieba.pb.pb.main.a.e mbk;
    private com.baidu.tieba.pb.pb.main.a.b mbl;
    private LinearLayout mbm;
    private TextView mbn;
    private TextView mbo;
    private ObservedChangeRelativeLayout mbp;
    private g mbq;
    private View mbw;
    private int mcE;
    private PbTopTipView mcF;
    private PopupWindow mcG;
    private TextView mcH;
    private List<String> mcI;
    private com.baidu.tieba.pb.pb.main.emotion.c mcJ;
    private com.baidu.tieba.pb.pb.godreply.a mcK;
    private PbLandscapeListView.b mcL;
    private ae mcN;
    private com.baidu.tieba.NEGFeedBack.i mcO;
    private String mcP;
    private long mcQ;
    private int mcR;
    private com.baidu.tieba.pb.view.c mcU;
    private boolean mcW;
    private int mca;
    private PostData mcb;
    private ViewStub mcd;
    private PbInterviewStatusView mce;
    private FrameLayout mcf;
    private View mcg;
    private View mch;
    private PbReplyTitleViewHolder mci;
    private PbEmotionBar mcn;
    private int mcv;
    private Runnable mcw;
    private r mcx;
    private al mcy;
    private Runnable mda;
    private PbFragment.b mdc;
    private TextView textView;
    private static final int mcj = UtilHelper.getLightStatusBarHeight();
    public static int mcp = 3;
    public static int mcq = 0;
    public static int mcr = 3;
    public static int mcs = 4;
    public static int mct = 5;
    public static int mcu = 6;
    private static final int mcS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0878a mcV = new a.InterfaceC0878a() { // from class: com.baidu.tieba.pb.pb.main.ap.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0878a
        public void onRefresh() {
        }
    };
    private int mba = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a mbr = null;
    private com.baidu.tbadk.core.dialog.b jkR = null;
    private View mbs = null;
    private EditText mbt = null;
    private com.baidu.tieba.pb.view.e mbu = null;
    private com.baidu.tieba.pb.view.a mbv = null;
    private b.InterfaceC0564b mbx = null;
    private TbRichTextView.i fVW = null;
    private NoNetworkView.a jfq = null;
    private com.baidu.tbadk.core.dialog.i mby = null;
    private com.baidu.tbadk.core.dialog.a mbz = null;
    private Dialog mbA = null;
    private Dialog mbB = null;
    private View mbC = null;
    private LinearLayout mbD = null;
    private CompoundButton.OnCheckedChangeListener iBr = null;
    private TextView mbE = null;
    private TextView mbF = null;
    private String mbG = null;
    private com.baidu.tbadk.core.dialog.i lTY = null;
    private com.baidu.tbadk.core.dialog.i mbH = null;
    private boolean mbI = false;
    private boolean mbJ = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView mbK = null;
    private boolean mbL = false;
    private Button mbN = null;
    private boolean mbY = true;
    private com.baidu.tbadk.core.view.a iFD = null;
    private boolean lQm = false;
    private int mSkinType = 3;
    private boolean mcc = false;
    private int mck = 0;
    private boolean mcl = true;
    public a mcm = new a();
    private int mco = 0;
    private boolean mcz = false;
    private int mcA = 0;
    private boolean mcB = false;
    private boolean mcC = false;
    private boolean mcD = false;
    private boolean mcM = false;
    private int mcT = 0;
    private String mcX = null;
    private CustomMessageListener mcY = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.mcX = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.mbq != null) {
                ap.this.mbq.notifyDataSetChanged();
            }
        }
    };
    private Handler mcZ = new Handler();
    private CustomMessageListener mdb = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.mbY = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean mdd = true;
    View.OnClickListener mde = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || ap.this.lQH == null || ap.this.lQH.dlp() == null || ap.this.lQH.dlp().bnS() == null || ap.this.lQH.dlp().bnS().getAlaInfo() == null || ap.this.lQH.dlp().bnS().getAlaInfo().live_status != 1) {
                if (ap.this.mcB) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").aq("obj_id", 2));
                }
                if (!ap.this.mcB && ap.this.lQH != null && ap.this.lQH.dlp() != null && ap.this.lQH.dlp().bnS() != null && ap.this.lQH.dlp().bnS().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12151").aq("obj_locate", 1));
                }
                if (ap.this.lPo.doq() != null) {
                    ap.this.lPo.doq().lPA.iRC.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11851");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
            if (ap.this.lQH.dlp().bnS().getAlaInfo() == null || !ap.this.lQH.dlp().bnS().getAlaInfo().isChushou) {
                if (ap.this.lQH.dlp().bnS().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = ap.this.lQH.dlp().bnS().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ap.this.lPo.doq(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bf.bsY().b(ap.this.lPo.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + ap.this.lQH.dlp().bnS().getAlaInfo().thirdRoomId + "&livetype=" + ap.this.lQH.dlp().bnS().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bkE = false;
    String userId = null;
    private final List<TbImageView> mdf = new ArrayList();
    private boolean mdg = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int headerCount;
        public int lFq;
        public PbReplyTitleViewHolder mdu;
    }

    public void vy(boolean z) {
        this.mcz = z;
        if (this.mbf != null) {
            this.mcA = this.mbf.getHeaderViewsCount();
        }
    }

    public void dqv() {
        if (this.mbf != null) {
            int headerViewsCount = this.mbf.getHeaderViewsCount() - this.mcA;
            final int firstVisiblePosition = (this.mbf.getFirstVisiblePosition() == 0 || this.mbf.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.mbf.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.mbf.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.mcm.mdu = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mcm));
            final PbReplyTitleViewHolder pbReplyTitleViewHolder = this.mcm.mdu;
            final int g = g(pbReplyTitleViewHolder);
            final int y = ((int) this.mbp.getY()) + this.mbp.getMeasuredHeight();
            final boolean z = this.mcg.getVisibility() == 0;
            boolean z2 = this.mbp.getY() < 0.0f;
            if ((z && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.mbq.dng() + this.mbf.getHeaderViewsCount()) {
                int measuredHeight = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.maB.getMeasuredHeight() : 0;
                if (z2) {
                    this.mbf.setSelectionFromTop(this.mbq.dng() + this.mbf.getHeaderViewsCount(), mcj - measuredHeight);
                } else {
                    this.mbf.setSelectionFromTop(this.mbq.dng() + this.mbf.getHeaderViewsCount(), this.mbb.dsy().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.mbf.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.mcB && this.mbh != null) {
                this.mbf.setSelectionFromTop(this.mbq.dng() + this.mbf.getHeaderViewsCount(), this.mbh.dsk());
            } else if (this.mType == 6) {
                this.mbf.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= ap.this.bND.getMeasuredHeight()) {
                            int g2 = ap.this.g(pbReplyTitleViewHolder);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (ap.this.bOm != null && (layoutParams = ap.this.bOm.getLayoutParams()) != null) {
                                if (i == 0 || i > ap.this.bND.getMeasuredHeight() || g2 >= ap.this.bND.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.mcv;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.bND.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.mcv;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    ap.this.mbf.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                ap.this.bOm.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ap.this.bOm != null && ap.this.bOm.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = ap.this.bOm.getLayoutParams();
                                            layoutParams2.height = ap.this.mcv;
                                            ap.this.bOm.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        ap.this.mbf.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
            return 0;
        }
        if (pbReplyTitleViewHolder.getView().getTop() != 0 || pbReplyTitleViewHolder.getView().isShown()) {
            return pbReplyTitleViewHolder.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView dqw() {
        return this.gzT;
    }

    public void dqx() {
        if (this.ael != null) {
            this.ael.hide();
            if (this.mcJ != null) {
                this.mcJ.dsm();
            }
        }
    }

    public PbFakeFloorModel dqy() {
        return this.lTf;
    }

    public r dqz() {
        return this.mcx;
    }

    public com.baidu.tieba.pb.pb.main.a.f dqA() {
        return this.mbh;
    }

    public void dqB() {
        reset();
        dqx();
        this.mcx.dnq();
        vK(false);
    }

    private void reset() {
        if (this.lPo != null && this.lPo.dnw() != null && this.ael != null) {
            com.baidu.tbadk.editortools.pb.a.bBN().setStatus(0);
            com.baidu.tbadk.editortools.pb.e dnw = this.lPo.dnw();
            dnw.bCi();
            dnw.bBx();
            if (dnw.getWriteImagesInfo() != null) {
                dnw.getWriteImagesInfo().setMaxImagesAllowed(dnw.isBJH ? 1 : 9);
            }
            dnw.rf(SendView.ALL);
            dnw.rg(SendView.ALL);
            com.baidu.tbadk.editortools.h qS = this.ael.qS(23);
            com.baidu.tbadk.editortools.h qS2 = this.ael.qS(2);
            com.baidu.tbadk.editortools.h qS3 = this.ael.qS(5);
            if (qS2 != null) {
                qS2.display();
            }
            if (qS3 != null) {
                qS3.display();
            }
            if (qS != null) {
                qS.hide();
            }
            this.ael.invalidate();
        }
    }

    public boolean dqC() {
        return this.mbY;
    }

    public void vz(boolean z) {
        if (this.mbP != null && this.krw != null) {
            this.krw.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.mbP.startAnimation(alphaAnimation);
            }
            this.mbO.setVisibility(0);
            this.mbP.setVisibility(0);
            this.mbY = true;
            if (this.mcn != null && !this.mcK.isActive()) {
                this.mcn.setVisibility(0);
                vE(true);
            }
        }
    }

    public void vA(boolean z) {
        if (this.mbP != null && this.krw != null) {
            this.krw.setText(dqD());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.mbP.startAnimation(alphaAnimation);
            }
            this.mbO.setVisibility(0);
            this.mbP.setVisibility(0);
            this.mbY = true;
            if (this.mcn != null && !this.mcK.isActive()) {
                this.mcn.setVisibility(0);
                vE(true);
            }
        }
    }

    public String dqD() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.mcP)) {
            return this.mcP;
        }
        if (this.lPo != null) {
            this.mcP = TbadkCoreApplication.getInst().getResources().getString(ao.dqt());
        }
        return this.mcP;
    }

    public PostData dqE() {
        int i = 0;
        if (this.mbf == null) {
            return null;
        }
        int dqF = dqF() - this.mbf.getHeaderViewsCount();
        if (dqF < 0) {
            dqF = 0;
        }
        if (this.mbq.FD(dqF) != null && this.mbq.FD(dqF) != PostData.nzc) {
            i = dqF + 1;
        }
        return this.mbq.getItem(i) instanceof PostData ? (PostData) this.mbq.getItem(i) : null;
    }

    public int dqF() {
        int i;
        View childAt;
        if (this.mbf == null) {
            return 0;
        }
        int firstVisiblePosition = this.mbf.getFirstVisiblePosition();
        int lastVisiblePosition = this.mbf.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.mbf.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.mbf.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dqG() {
        return this.mbf.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lQH != null && this.lQH.dlr() != null && !this.lQH.dlr().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lQH.dlr().size() && (postData = this.lQH.dlr().get(i)) != null && postData.bnS() != null && !StringUtils.isNull(postData.bnS().getUserId()); i++) {
                if (this.lQH.dlr().get(i).bnS().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.mcK != null && this.mcK.isActive()) {
                        vK(false);
                    }
                    if (this.mcn != null) {
                        this.mcn.vV(true);
                    }
                    this.mcX = postData.bnS().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lPo = null;
        this.bND = null;
        this.bMJ = null;
        this.mbf = null;
        this.mbq = null;
        this.jqc = null;
        this.fKb = null;
        this.jkS = null;
        this.lQu = null;
        this.mbP = null;
        this.krw = null;
        this.mcd = null;
        this.mcE = 0;
        this.mcQ = 0L;
        this.mcQ = System.currentTimeMillis();
        this.lPo = pbFragment;
        this.jkS = onClickListener;
        this.fxj = cVar;
        this.mcE = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lPo.getContext()) / 8;
        this.bND = (RelativeLayout) LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bND.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mbM = this.bND.findViewById(R.id.bottom_shadow);
        this.jOd = (NavigationBarCoverTip) this.bND.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bMJ = this.bND.findViewById(R.id.statebar_view);
        this.mbp = (ObservedChangeRelativeLayout) this.bND.findViewById(R.id.title_wrapper);
        this.gzT = (NoNetworkView) this.bND.findViewById(R.id.view_no_network);
        this.mbf = (PbLandscapeListView) this.bND.findViewById(R.id.new_pb_list);
        this.mcf = (FrameLayout) this.bND.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lPo.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lPo.getActivity(), R.dimen.ds88));
        this.mbf.addHeaderView(this.textView, 0);
        this.mbf.setTextViewAdded(true);
        this.mcv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bOm = new View(this.lPo.getPageContext().getPageActivity());
        this.bOm.setLayoutParams(new AbsListView.LayoutParams(-1, this.mcv));
        this.bOm.setVisibility(4);
        this.mbf.addFooterView(this.bOm);
        this.mbf.setOnTouchListener(this.lPo.bUt);
        this.mbb = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bND);
        if (this.lPo.dnZ()) {
            this.mbd = (ViewStub) this.bND.findViewById(R.id.manga_view_stub);
            this.mbd.setVisibility(0);
            this.mbc = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.mbc.show();
            this.mbb.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lPo.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.mbb.dsy().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0833a() { // from class: com.baidu.tieba.pb.pb.main.ap.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0833a
            public void dms() {
                if (ap.this.mbf != null) {
                    if (ap.this.mbh != null) {
                        ap.this.mbh.dsj();
                    }
                    ap.this.mbf.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0833a
            public void dmt() {
                ap.this.lPo.cDi();
            }
        }));
        this.mbO = this.bND.findViewById(R.id.view_comment_top_line);
        this.mbP = this.bND.findViewById(R.id.pb_editor_tool_comment);
        this.mbZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mca = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.mbR = (HeadImageView) this.bND.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.mbR.setVisibility(0);
        this.mbR.setIsRound(true);
        this.mbR.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lPo.getContext(), R.dimen.L_X01));
        this.mbR.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
        this.mbR.setPlaceHolder(0);
        dqH();
        this.krw = (TextView) this.bND.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.mbQ = (LinearLayout) this.bND.findViewById(R.id.pb_editer_tool_comment_layout);
        this.mbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(ap.this.lPo.getActivity(), "pb_huitie"))) {
                    ap.this.lPo.dnH();
                    if (ap.this.lPo != null && ap.this.lPo.dmG() != null && ap.this.lPo.dmG().getPbData() != null && ap.this.lPo.dmG().getPbData().dlp() != null && ap.this.lPo.dmG().getPbData().dlp().bnS() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", ap.this.lPo.dmG().doK()).dR("fid", ap.this.lPo.dmG().getPbData().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", ap.this.lPo.dmG().lXe).dR("fid", ap.this.lPo.dmG().getPbData().getForumId()).aq("obj_locate", 1).dR("uid", ap.this.lPo.dmG().getPbData().dlp().bnS().getUserId()));
                    }
                }
            }
        });
        this.mbS = (ImageView) this.bND.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lSi = (MaskView) this.bND.findViewById(R.id.mask_view);
        this.mbS.setOnClickListener(this.jkS);
        boolean booleanExtra = this.lPo.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.mbT = (ImageView) this.bND.findViewById(R.id.pb_editor_tool_collection);
        this.mbT.setOnClickListener(this.jkS);
        if (booleanExtra) {
            this.mbT.setVisibility(8);
        } else {
            this.mbT.setVisibility(0);
        }
        this.mbU = (ImageView) this.bND.findViewById(R.id.pb_editor_tool_share);
        this.mbU.setOnClickListener(this.jkS);
        this.mbV = new com.baidu.tieba.pb.view.d(this.mbU);
        this.mbV.dvN();
        this.mbW = (TextView) this.bND.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.mbW.setVisibility(0);
        this.mcd = (ViewStub) this.bND.findViewById(R.id.interview_status_stub);
        this.mbi = new com.baidu.tieba.pb.pb.main.a.a(this.lPo, cVar);
        this.mbk = new com.baidu.tieba.pb.pb.main.a.e(this.lPo, cVar, this.jkS);
        this.mbq = new g(this.lPo, this.mbf);
        this.mbq.I(this.jkS);
        this.mbq.setTbGestureDetector(this.fxj);
        this.mbq.setOnImageClickListener(this.fVW);
        this.mbq.setOnSwitchChangeListener(this.lPo.lUS);
        this.lQu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.29
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
                            ap.this.lPo.d(sparseArray);
                            return;
                        }
                        ap.this.dL(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        ap.this.lPo.d(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.mbq.V(this.lQu);
        dqM();
        dqN();
        this.lSj = new com.baidu.tieba.pb.pb.main.a.d(this.lPo);
        this.lSj.fwA = 2;
        this.mbj.b(this.mbf);
        this.mbk.b(this.mbf);
        this.mbi.b(this.mbf);
        this.jqc = new PbListView(this.lPo.getPageContext().getPageActivity());
        this.fKb = this.jqc.getView().findViewById(R.id.pb_more_view);
        if (this.fKb != null) {
            this.fKb.setOnClickListener(this.jkS);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fKb, R.drawable.pb_foot_more_trans_selector);
        }
        this.jqc.setLineVisible();
        this.jqc.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jqc.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.mbw = this.bND.findViewById(R.id.viewstub_progress);
        this.lPo.registerListener(this.mdb);
        this.lTf = new PbFakeFloorModel(this.lPo.getPageContext());
        this.mcx = new r(this.lPo.getPageContext(), this.lTf, this.bND);
        this.mcx.W(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dqB();
            }
        });
        this.mcx.a(this.lPo.lUU);
        this.lTf.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                ap.this.lTf.u(postData);
                ap.this.mbq.notifyDataSetChanged();
                ap.this.mcx.dnq();
                ap.this.ael.bzG();
                ap.this.vK(false);
            }
        });
        if (this.lPo.dmG() != null && !StringUtils.isNull(this.lPo.dmG().dpt())) {
            this.lPo.showToast(this.lPo.dmG().dpt());
        }
        this.mcg = this.bND.findViewById(R.id.pb_expand_blank_view);
        this.mch = this.bND.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mch.getLayoutParams();
        if (this.lPo.dmG() != null && this.lPo.dmG().doN()) {
            this.mcg.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.mch.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = mcj;
            this.mch.setLayoutParams(layoutParams2);
        }
        this.mci = new PbReplyTitleViewHolder(this.lPo.getPageContext(), this.bND.findViewById(R.id.pb_reply_expand_view));
        this.mci.x(pbFragment.lTN);
        this.mci.maB.setVisibility(8);
        this.mci.X(this.jkS);
        this.mci.setOnSwitchChangeListener(this.lPo.lUS);
        this.lPo.registerListener(this.mAccountChangedListener);
        this.lPo.registerListener(this.mcY);
        dqI();
        vE(false);
        this.mcU = new com.baidu.tieba.pb.view.c(this.lPo.getPageContext());
    }

    private void dqH() {
        if (this.mbR != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.mbR.setImageResource(0);
            this.mbR.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.mbR.setImageResource(R.drawable.transparent_bg);
    }

    public void vB(boolean z) {
        this.mbM.setVisibility(z ? 0 : 8);
    }

    public void cSA() {
        if (!this.lPo.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").aq("obj_locate", 2).dR("fid", this.mForumId));
        } else if (this.lPo.dnJ()) {
            com.baidu.tbadk.editortools.pb.e dnw = this.lPo.dnw();
            if (dnw != null && (dnw.bCf() || dnw.bCg())) {
                this.lPo.dnw().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ael != null) {
                dqS();
            }
            if (this.ael != null) {
                this.mbY = false;
                if (this.ael.qV(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lPo.getPageContext(), (View) this.ael.qV(2).fCN, false, mcV);
                }
            }
            drC();
        }
    }

    private void dqI() {
        this.mcK = new com.baidu.tieba.pb.pb.godreply.a(this.lPo, this, (ViewStub) this.bND.findViewById(R.id.more_god_reply_popup));
        this.mcK.C(this.jkS);
        this.mcK.V(this.lQu);
        this.mcK.setOnImageClickListener(this.fVW);
        this.mcK.C(this.jkS);
        this.mcK.setTbGestureDetector(this.fxj);
    }

    public com.baidu.tieba.pb.pb.godreply.a dqJ() {
        return this.mcK;
    }

    public View dqK() {
        return this.mcg;
    }

    public void dqL() {
        if (this.mbf != null) {
            this.mbj.c(this.mbf);
            this.mbk.c(this.mbf);
            this.mbl.c(this.mbf);
            this.mbi.c(this.mbf);
        }
    }

    private void dqM() {
        if (this.mbl == null) {
            this.mbl = new com.baidu.tieba.pb.pb.main.a.b(this.lPo, this.jkS);
        }
    }

    private void dqN() {
        if (this.mbj == null) {
            this.mbj = new com.baidu.tieba.pb.pb.main.a.c(this.lPo, this.fxj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqO() {
        if (this.lPo.dnZ()) {
            this.mbe = (ViewStub) this.bND.findViewById(R.id.manga_mention_controller_view_stub);
            this.mbe.setVisibility(0);
            if (this.mbm == null) {
                this.mbm = (LinearLayout) this.bND.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lPo.getPageContext(), this.mbm);
            }
            if (this.mbn == null) {
                this.mbn = (TextView) this.mbm.findViewById(R.id.manga_prev_btn);
            }
            if (this.mbo == null) {
                this.mbo = (TextView) this.mbm.findViewById(R.id.manga_next_btn);
            }
            this.mbn.setOnClickListener(this.jkS);
            this.mbo.setOnClickListener(this.jkS);
        }
    }

    private void dqP() {
        if (this.lPo.dnZ()) {
            if (this.lPo.doc() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.mbn, R.color.CAM_X0110, 1);
            }
            if (this.lPo.dod() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.mbo, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dqQ() {
        if (this.mbm == null) {
            dqO();
        }
        this.mbe.setVisibility(8);
        if (this.mcZ != null && this.mda != null) {
            this.mcZ.removeCallbacks(this.mda);
        }
    }

    public void dqR() {
        if (this.mcZ != null) {
            if (this.mda != null) {
                this.mcZ.removeCallbacks(this.mda);
            }
            this.mda = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.mbm == null) {
                        ap.this.dqO();
                    }
                    ap.this.mbe.setVisibility(0);
                }
            };
            this.mcZ.postDelayed(this.mda, 2000L);
        }
    }

    public void vC(boolean z) {
        this.mbb.vC(z);
        if (z && this.mcc) {
            this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.mbf.setNextPage(this.jqc);
            this.mba = 2;
        }
        dqH();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
        this.ael.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dqB();
            }
        });
        this.ael.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.ael.getParent() == null) {
            this.bND.addView(this.ael, layoutParams);
        }
        this.ael.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ael.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.ap.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bwy() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bwy() == EmotionGroupType.USER_COLLECT) {
                        if (ap.this.mPermissionJudgePolicy == null) {
                            ap.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        ap.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        ap.this.mPermissionJudgePolicy.appendRequestPermission(ap.this.lPo.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ap.this.mPermissionJudgePolicy.startRequestPermission(ap.this.lPo.getBaseFragmentActivity())) {
                            ap.this.lPo.dnw().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            ap.this.lPo.dnw().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dqx();
        this.lPo.dnw().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.ael != null && ap.this.ael.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.mcJ == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.ael.getId());
                            ap.this.mcJ = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.lPo.getPageContext(), ap.this.bND, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(ap.this.mcI)) {
                                ap.this.mcJ.setData(ap.this.mcI);
                            }
                            ap.this.mcJ.c(ap.this.ael);
                        }
                        ap.this.mcJ.PV(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.lPo.kYE != null && ap.this.lPo.kYE.drV() != null) {
                    if (!ap.this.lPo.kYE.drV().dWG()) {
                        ap.this.lPo.kYE.vQ(false);
                    }
                    ap.this.lPo.kYE.drV().zt(false);
                }
            }
        });
    }

    public void dqS() {
        if (this.lPo != null && this.ael != null) {
            this.ael.display();
            if (this.lPo.dnw() != null) {
                this.lPo.dnw().bBV();
            }
            drC();
        }
    }

    public void vD(boolean z) {
        if (this.mbf != null && this.textView != null && this.bMJ != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bMJ.setVisibility(0);
                } else {
                    this.bMJ.setVisibility(8);
                    this.mbf.removeHeaderView(this.textView);
                    this.mbf.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = mcj;
                    this.textView.setLayoutParams(layoutParams);
                }
                drj();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vM(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            drj();
            drK();
        }
    }

    public g dqT() {
        return this.mbq;
    }

    public void a(PbFragment.c cVar) {
        this.lUZ = cVar;
    }

    public void dL(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lPo.getContext());
        kVar.setTitleText(this.lPo.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.mby.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            ap.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (ap.this.mdc != null) {
                                ap.this.mdc.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            ap.this.lPo.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lPo.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lPo.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eWK.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !drJ()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lPo.getString(R.string.forbidden_person), kVar);
            gVar3.eWK.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lPo.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lPo.getString(R.string.mute), kVar);
            }
            gVar.eWK.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fq(arrayList), true);
        this.mby = new com.baidu.tbadk.core.dialog.i(this.lPo.getPageContext(), kVar);
        this.mby.QH();
    }

    public void a(PbFragment.b bVar) {
        this.mdc = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lPo != null && aVar != null) {
            if (this.jSR == null && this.mbi != null) {
                this.jSR = new com.baidu.tieba.NEGFeedBack.f(this.lPo.getPageContext(), this.mbi.dsf());
            }
            AntiData cBF = this.lPo.cBF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.jSR.setDefaultReasonArray(new String[]{this.lPo.getString(R.string.delete_thread_reason_1), this.lPo.getString(R.string.delete_thread_reason_2), this.lPo.getString(R.string.delete_thread_reason_3), this.lPo.getString(R.string.delete_thread_reason_4), this.lPo.getString(R.string.delete_thread_reason_5)});
            this.jSR.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jSR.Ey(str);
            this.jSR.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    ap.this.lPo.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dqU() {
        if (this.lPo == null || this.lPo.dmG().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lPo.dmG().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lPo != null && aVar != null) {
            if (this.mcO == null && this.mbi != null) {
                this.mcO = new com.baidu.tieba.NEGFeedBack.i(this.lPo.getPageContext(), this.mbi.dsf(), hVar, userData);
            }
            AntiData cBF = this.lPo.cBF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.mcO.setDefaultReasonArray(new String[]{this.lPo.getString(R.string.delete_thread_reason_1), this.lPo.getString(R.string.delete_thread_reason_2), this.lPo.getString(R.string.delete_thread_reason_3), this.lPo.getString(R.string.delete_thread_reason_4), this.lPo.getString(R.string.delete_thread_reason_5)});
            this.mcO.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.mcO.Ey(str);
            this.mcO.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    ap.this.lPo.a(aVar, jSONArray);
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
        sparseArray.put(mcq, Integer.valueOf(mcr));
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
        this.mbz = new com.baidu.tbadk.core.dialog.a(this.lPo.getActivity());
        if (StringUtils.isNull(str2)) {
            this.mbz.ny(i3);
        } else {
            this.mbz.setOnlyMessageShowCenter(false);
            this.mbz.AB(str2);
        }
        this.mbz.setYesButtonTag(sparseArray);
        this.mbz.a(R.string.dialog_ok, this.lPo);
        this.mbz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.mbz.jF(true);
        this.mbz.b(this.lPo.getPageContext());
        if (z) {
            this.mbz.bqz();
        } else if (dqU()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lPo.dmG().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lPo.dmG().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lPo.dmG().getPbData().dlY().has_forum_rule.intValue());
            hVar.eg(this.lPo.dmG().getPbData().getForum().getId(), this.lPo.dmG().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lPo.dmG().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lPo.dmG().getPbData().getForum().getUser_level());
            a(this.mbz, i, hVar, this.lPo.dmG().getPbData().getUserData());
        } else {
            a(this.mbz, i);
        }
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.al> arrayList) {
        if (this.mbC == null) {
            this.mbC = LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lPo.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mbC);
        if (this.mbB == null) {
            this.mbB = new Dialog(this.lPo.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mbB.setCanceledOnTouchOutside(true);
            this.mbB.setCancelable(true);
            this.mbK = (ScrollView) this.mbC.findViewById(R.id.good_scroll);
            this.mbB.setContentView(this.mbC);
            WindowManager.LayoutParams attributes = this.mbB.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.mbB.getWindow().setAttributes(attributes);
            this.iBr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.mbG = (String) compoundButton.getTag();
                        if (ap.this.iBq != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ap.this.iBq) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ap.this.mbG != null && !str.equals(ap.this.mbG)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.mbD = (LinearLayout) this.mbC.findViewById(R.id.good_class_group);
            this.mbF = (TextView) this.mbC.findViewById(R.id.dialog_button_cancel);
            this.mbF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.mbB instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(ap.this.mbB, ap.this.lPo.getPageContext());
                    }
                }
            });
            this.mbE = (TextView) this.mbC.findViewById(R.id.dialog_button_ok);
            this.mbE.setOnClickListener(this.jkS);
        }
        this.mbD.removeAllViews();
        this.iBq = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.lPo.getPageContext().getString(R.string.thread_good_class));
        this.iBq.add(fU);
        fU.setChecked(true);
        this.mbD.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.al alVar = arrayList.get(i2);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmd()) && alVar.bme() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(alVar.bme()), alVar.bmd());
                    this.iBq.add(fU2);
                    View view = new View(this.lPo.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.mbD.addView(view);
                    this.mbD.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.mbK.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lPo.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lPo.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lPo.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.mbK.setLayoutParams(layoutParams2);
            this.mbK.removeAllViews();
            if (this.mbD != null && this.mbD.getParent() == null) {
                this.mbK.addView(this.mbD);
            }
        }
        com.baidu.adp.lib.f.g.a(this.mbB, this.lPo.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.lPo.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iBr);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dqV() {
        this.lPo.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lPo.hideProgressBar();
        if (z && z2) {
            this.lPo.showToast(this.lPo.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lPo.showToast(str);
        }
    }

    public void dqW() {
        this.mbw.setVisibility(0);
    }

    public void dqX() {
        this.mbw.setVisibility(8);
    }

    public View dqY() {
        if (this.mbC != null) {
            return this.mbC.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dqZ() {
        return this.mbG;
    }

    public View getView() {
        return this.bND;
    }

    public void dra() {
        if (this.lPo != null && this.lPo.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lPo.getPageContext().getPageActivity(), this.lPo.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lPo.hideProgressBar();
        if (z) {
            drt();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dru();
        } else {
            drt();
        }
    }

    public void drb() {
        this.jqc.setLineVisible();
        this.jqc.startLoadData();
    }

    public void drc() {
        this.lPo.hideProgressBar();
        endLoadData();
        this.mbf.completePullRefreshPostDelayed(0L);
        dro();
    }

    public void drd() {
        this.mbf.completePullRefreshPostDelayed(0L);
        dro();
    }

    private void vE(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.mbk.b(onLongClickListener);
        this.mbq.setOnLongClickListener(onLongClickListener);
        if (this.mcK != null) {
            this.mcK.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0564b interfaceC0564b, boolean z, boolean z2) {
        if (this.lTY != null) {
            this.lTY.dismiss();
            this.lTY = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lPo.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lPo.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lPo.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lPo.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lPo.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.mbH.dismiss();
                interfaceC0564b.a(null, i, view);
            }
        });
        this.mbH = new com.baidu.tbadk.core.dialog.i(this.lPo.getPageContext(), kVar);
        this.mbH.QH();
    }

    public void a(final b.InterfaceC0564b interfaceC0564b, boolean z) {
        if (this.mbH != null) {
            this.mbH.dismiss();
            this.mbH = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lPo.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lQH != null && this.lQH.dlp() != null && !this.lQH.dlp().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lPo.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lPo.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.mbH.dismiss();
                interfaceC0564b.a(null, i, view);
            }
        });
        this.mbH = new com.baidu.tbadk.core.dialog.i(this.lPo.getPageContext(), kVar);
        this.mbH.QH();
    }

    public int dre() {
        return Ge(this.mbf.getFirstVisiblePosition());
    }

    private int Ge(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.mbf.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.mbf.getAdapter() == null || !(this.mbf.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.mbf.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int drf() {
        int lastVisiblePosition = this.mbf.getLastVisiblePosition();
        if (this.mbh != null) {
            if (lastVisiblePosition == this.mbf.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Ge(lastVisiblePosition);
    }

    public void Gf(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.mbf != null) {
            if (this.mbb == null || this.mbb.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.mbb.mNavigationBar.getFixedNavHeight();
                if (this.lPo.dnP() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.mch != null && (layoutParams = (LinearLayout.LayoutParams) this.mch.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.mch.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.mbf.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.mbf.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.mbf.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.mbt.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.mbq.a(fVar, false);
        this.mbq.notifyDataSetChanged();
        dro();
        if (this.mcK != null) {
            this.mcK.bPg();
        }
        ArrayList<PostData> dlr = fVar.dlr();
        if (fVar.getPage().bmH() == 0 || dlr == null || dlr.size() < fVar.getPage().bmG()) {
            if (com.baidu.tbadk.core.util.y.getCount(dlr) == 0 || (com.baidu.tbadk.core.util.y.getCount(dlr) == 1 && dlr.get(0) != null && dlr.get(0).dNO() == 1)) {
                if (this.mcm == null || this.mcm.mdu == null || this.mcm.mdu.getView() == null) {
                    i = 0;
                } else {
                    i = this.mcm.mdu.getView().getTop() < 0 ? this.mcm.mdu.getView().getHeight() : this.mcm.mdu.getView().getBottom();
                }
                if (this.lPo.doj()) {
                    this.jqc.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jqc.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bmH() == 0) {
                    this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jqc.buh();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.mbi != null) {
            this.mbi.e(fVar, this.lQm);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlC() != null) {
            return fVar.dlC();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlr())) {
            Iterator<PostData> it = fVar.dlr().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNO() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dly();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnS() != null && postData.bnS().getUserTbVipInfoData() != null && postData.bnS().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnS().getGodUserData().setIntro(postData.bnS().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bnS() == null) {
            return false;
        }
        MetaData bnS = postData.bnS();
        return (TextUtils.isEmpty(bnS.getUserId()) && TextUtils.isEmpty(bnS.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlp() == null || fVar.dlp().bnS() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnS = fVar.dlp().bnS();
        String userId = bnS.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlp().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnS;
        }
        postData.JJ(1);
        postData.setId(fVar.dlp().boi());
        postData.setTitle(fVar.dlp().getTitle());
        postData.setTime(fVar.dlp().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dlp() != null) {
            if (this.lPo.dmy()) {
                if (fVar.dlo() != null) {
                    this.mForumName = fVar.dlo().getForumName();
                    this.mForumId = fVar.dlo().getForumId();
                }
                if (this.mForumName == null && this.lPo.dmG() != null && this.lPo.dmG().dmz() != null) {
                    this.mForumName = this.lPo.dmG().dmz();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.mbk.setVisibility(8);
            if (fVar.dlP()) {
                this.mcB = true;
                this.mbb.wc(true);
                this.mbb.mNavigationBar.hideBottomLine();
                if (this.mbh == null) {
                    this.mbh = new com.baidu.tieba.pb.pb.main.a.f(this.lPo);
                }
                this.mbh.a(fVar, b, this.mbf, this.mbk, this.mcf, this.mbb, this.mForumName, this.mcQ);
                this.mbh.Y(this.mde);
                drj();
            } else {
                this.mcB = false;
                this.mbb.wc(this.mcB);
                if (this.mbh != null) {
                    this.mbh.c(this.mbf);
                }
            }
            if (this.lPo.dnz() != null) {
                this.lPo.dnz().vW(this.mcB);
            }
            if (b != null) {
                this.mcb = b;
                this.mbk.setVisibility(0);
                SparseArray<Object> dsi = this.mbk.dsi();
                dsi.put(R.id.tag_clip_board, b);
                dsi.put(R.id.tag_is_subpb, false);
                this.mbl.a(fVar, this.mbf);
                this.mbj.C(fVar);
                this.mbi.e(fVar, this.lQm);
                this.mbi.B(fVar);
                this.mbk.a(this.mSkinType, this.lQH, b, this.mde);
                if (this.mci != null) {
                    if (fVar.dlS()) {
                        this.mci.getView().setVisibility(8);
                    } else {
                        this.mci.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lNH);
                        if (fVar.dlp() != null) {
                            oVar.lNJ = fVar.dlp().bnJ();
                        }
                        oVar.isNew = !this.lQm;
                        oVar.sortType = fVar.lMp;
                        oVar.lNL = fVar.dlT();
                        oVar.lNM = this.lPo.doj();
                        oVar.lNN = fVar.lMo;
                        this.mci.a(oVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ap.this.mbq != null && ap.this.mbb != null && ap.this.mbb.mhG != null && ap.this.lQH != null && ap.this.lQH.dlp() != null && !ap.this.lQH.dlp().bmx() && !ap.this.drn() && ap.this.lQH.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(ap.this.lQH.getForum().getName())) {
                            if ((ap.this.mbq.dnk() == null || !ap.this.mbq.dnk().isShown()) && ap.this.mbb.mhG != null) {
                                ap.this.mbb.mhG.setVisibility(0);
                                if (ap.this.lPo != null && ap.this.lPo.dmG() != null) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13400");
                                    arVar.dR("tid", ap.this.lPo.dmG().doJ());
                                    arVar.dR("fid", ap.this.lPo.dmG().getForumId());
                                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    }
                });
                this.lSj.c(this.mbf);
                if (b.nzP) {
                    this.lSj.setPostId(b.getId());
                    this.lSj.a(this.mbf, this.mbf.getHeaderViewsCount() > 1 ? 1 : 0);
                }
                if (this.mbq != null && this.mbq.dnj() != null) {
                    this.mbq.dnj().vS(b.nzP);
                }
                if (this.mbq != null) {
                    this.mbq.uT(b.nzP);
                }
                this.lSi.setVisibility(b.nzP ? 0 : 8);
            }
        }
    }

    public void vF(boolean z) {
        if (z) {
            drg();
        } else {
            cwF();
        }
        this.mcm.mdu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mcm));
        a(this.mcm.mdu, false);
    }

    public void drg() {
        if (this.mbb != null && !this.mcD) {
            this.mbb.drg();
            this.mcD = true;
        }
    }

    public void cwF() {
        if (this.mbb != null) {
            this.mbb.dsH();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.mbk.a(postData, fVar);
    }

    public void drh() {
        if (this.mbh != null) {
            this.mbh.d(this.mbf);
        }
    }

    public boolean dri() {
        return this.bkE;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aO(cb cbVar) {
        if (cbVar == null || cbVar.bnS() == null) {
            return false;
        }
        PostData b = b(this.lQH, false);
        String str = "";
        if (b != null && b.bnS() != null) {
            str = b.bnS().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.mbb.dsE();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.mbb.KP(dVar.forumName);
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
            final String str2 = dVar.lMg;
            this.lPo.showNetRefreshView(this.bND, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bf.bsY().b(ap.this.lPo.getPageContext(), new String[]{str2});
                        ap.this.lPo.finish();
                        return;
                    }
                    ap.this.lPo.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dqj;
        Parcelable dqj2;
        if (fVar != null && this.mbf != null) {
            this.lQH = fVar;
            this.mType = i;
            if (fVar.dlp() != null) {
                this.mco = fVar.dlp().bnz();
                if (fVar.dlp().getAnchorLevel() != 0) {
                    this.bkE = true;
                }
                this.mbJ = aO(fVar.dlp());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.mcc = false;
            this.lQm = z;
            drc();
            if (fVar.lMq != null && fVar.lMq.dma()) {
                if (this.mbg == null) {
                    this.mbg = new PbThreadPostView(this.lPo.getContext());
                    this.mbf.addHeaderView(this.mbg, 1);
                    this.mbg.setData(fVar);
                    this.mbg.setChildOnClickLinstener(this.jkS);
                }
            } else if (this.mbg != null && this.mbf != null) {
                this.mbf.removeHeaderView(this.mbg);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.mcN == null) {
                this.mcN = new ae(this.lPo.getPageContext(), this.jOd);
            }
            this.mcN.PL(fVar.dlw());
            if (this.lPo.dnZ()) {
                if (this.mbu == null) {
                    this.mbu = new com.baidu.tieba.pb.view.e(this.lPo.getPageContext());
                    this.mbu.createView();
                    this.mbu.setListPullRefreshListener(this.fkY);
                }
                this.mbf.setPullRefresh(this.mbu);
                drj();
                if (this.mbu != null) {
                    this.mbu.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bmI() == 0 && z) {
                this.mbf.setPullRefresh(null);
            } else {
                if (this.mbu == null) {
                    this.mbu = new com.baidu.tieba.pb.view.e(this.lPo.getPageContext());
                    this.mbu.createView();
                    this.mbu.setListPullRefreshListener(this.fkY);
                }
                this.mbf.setPullRefresh(this.mbu);
                drj();
                if (this.mbu != null) {
                    this.mbu.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                ckD();
            }
            dro();
            this.mbq.uK(this.lQm);
            this.mbq.uL(false);
            this.mbq.uP(i == 5);
            this.mbq.uQ(i == 6);
            this.mbq.uR(z2 && this.mdd && i != 2);
            this.mbq.a(fVar, false);
            this.mbq.notifyDataSetChanged();
            this.mbk.b(b(fVar, z), fVar.dlS());
            if (fVar.dlp() != null && fVar.dlp().bnD() != null && this.maZ != -1) {
                fVar.dlp().bnD().setIsLike(this.maZ);
            }
            this.mbf.removeFooterView(this.bOm);
            this.mbf.addFooterView(this.bOm);
            if (TbadkCoreApplication.isLogin()) {
                this.mbf.setNextPage(this.jqc);
                this.mba = 2;
                ckD();
            } else {
                this.mcc = true;
                if (fVar.getPage().bmH() == 1) {
                    if (this.mbv == null) {
                        this.mbv = new com.baidu.tieba.pb.view.a(this.lPo, this.lPo);
                    }
                    this.mbf.setNextPage(this.mbv);
                } else {
                    this.mbf.setNextPage(this.jqc);
                }
                this.mba = 3;
            }
            ArrayList<PostData> dlr = fVar.dlr();
            if (fVar.getPage().bmH() == 0 || dlr == null || dlr.size() < fVar.getPage().bmG()) {
                if (com.baidu.tbadk.core.util.y.getCount(dlr) == 0 || (com.baidu.tbadk.core.util.y.getCount(dlr) == 1 && dlr.get(0) != null && dlr.get(0).dNO() == 1)) {
                    if (this.mcm == null || this.mcm.mdu == null || this.mcm.mdu.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.mcm.mdu.getView().getTop() < 0 ? this.mcm.mdu.getView().getHeight() : this.mcm.mdu.getView().getBottom();
                    }
                    if (this.lPo.doj()) {
                        this.jqc.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jqc.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lPo.dnz() != null && !this.lPo.dnz().dss()) {
                        this.lPo.dnz().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bmH() == 0) {
                        this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jqc.buh();
                }
                if (fVar.getPage().bmH() == 0 || dlr == null) {
                    dry();
                }
            } else {
                if (z2) {
                    if (this.mdd) {
                        endLoadData();
                        if (fVar.getPage().bmH() != 0) {
                            this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jqc.setLineVisible();
                        this.jqc.showLoading();
                    }
                } else {
                    this.jqc.setLineVisible();
                    this.jqc.showLoading();
                }
                this.jqc.buh();
            }
            switch (i) {
                case 2:
                    this.mbf.setSelection(i2 > 1 ? (((this.mbf.getData() == null && fVar.dlr() == null) ? 0 : (this.mbf.getData().size() - fVar.dlr().size()) + this.mbf.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dqj2 = aj.dqi().dqj()) != null && !(dqj2 instanceof RecyclerView.SavedState)) {
                        this.mbf.onRestoreInstanceState(dqj2);
                        if (com.baidu.tbadk.core.util.y.getCount(dlr) > 1 && fVar.getPage().bmH() > 0) {
                            this.jqc.endLoadData();
                            this.jqc.setText(this.lPo.getString(R.string.pb_load_more_without_point));
                            this.jqc.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.mdd = false;
                    break;
                case 5:
                    this.mbf.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dqj = aj.dqi().dqj()) != null && !(dqj instanceof RecyclerView.SavedState)) {
                        this.mbf.onRestoreInstanceState(dqj);
                        break;
                    } else {
                        this.mbf.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.mbh != null && this.mbh.getContainerView() != null) {
                            if (this.lPo.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.mbf.setSelectionFromTop((this.mbq.dnf() + this.mbf.getHeaderViewsCount()) - 1, this.mbh.dsk() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lPo.getPageContext().getPageActivity()));
                            } else {
                                this.mbf.setSelectionFromTop((this.mbq.dnf() + this.mbf.getHeaderViewsCount()) - 1, this.mbh.dsk());
                            }
                        } else {
                            this.mbf.setSelection(this.mbq.dnf() + this.mbf.getHeaderViewsCount());
                        }
                    } else {
                        this.mbf.setSelection(i2 > 0 ? ((this.mbf.getData() == null && fVar.dlr() == null) ? 0 : (this.mbf.getData().size() - fVar.dlr().size()) + this.mbf.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jqc.endLoadData();
                    this.jqc.setText(this.lPo.getString(R.string.pb_load_more_without_point));
                    this.jqc.setLineGone();
                    break;
            }
            if (this.mco == mcp && isHost()) {
                drF();
            }
            if (this.mcz) {
                dqv();
                this.mcz = false;
                if (i3 == 0) {
                    vy(true);
                }
            }
            if (fVar.lMm == 1 || fVar.lMn == 1) {
                if (this.mcF == null) {
                    this.mcF = new PbTopTipView(this.lPo.getContext());
                }
                if (fVar.lMn == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lPo.getStType())) {
                    this.mcF.setText(this.lPo.getString(R.string.pb_read_strategy_add_experience));
                    this.mcF.a(this.bND, this.mSkinType);
                } else if (fVar.lMm == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lPo.getStType())) {
                    this.mcF.setText(this.lPo.getString(R.string.pb_read_news_add_experience));
                    this.mcF.a(this.bND, this.mSkinType);
                }
            }
            this.mbf.removeFooterView(this.mcU.getView());
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlX()) && fVar.getPage().bmH() == 0) {
                this.mbf.removeFooterView(this.bOm);
                this.mcU.GE(Math.max(this.mbP.getMeasuredHeight(), this.mca / 2));
                this.mbf.addFooterView(this.mcU.getView());
                this.mcU.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            x(fVar);
            if (fVar.bkb()) {
                WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Gg = Gg(fVar.dlp().bnJ());
            if (this.mbW != null) {
                this.mbW.setText(Gg);
            }
            if (this.mbX != null) {
                this.mbX.setText(Gg);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dlp()));
        }
    }

    private String Gg(int i) {
        if (i == 0) {
            return this.lPo.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void drj() {
        if (this.mbh != null) {
            this.mbh.a(this.mbf, this.textView, this.mType);
        }
    }

    public void vG(boolean z) {
        this.mbI = z;
    }

    public void endLoadData() {
        if (this.jqc != null) {
            this.jqc.setLineGone();
            this.jqc.endLoadData();
        }
        ckD();
    }

    public void bYu() {
        this.mbf.setVisibility(0);
    }

    public void drk() {
        if (this.mbf != null) {
            this.mbf.setVisibility(8);
        }
        if (this.mbf != null) {
            this.mcf.setVisibility(8);
        }
        if (this.mbb != null && this.mbb.jyL != null) {
            this.mbb.jyL.setVisibility(8);
        }
    }

    public void drl() {
        if (this.mbf != null) {
            this.mbf.setVisibility(0);
        }
        if (this.mcf != null) {
            this.mcf.setVisibility(0);
        }
        if (this.mbb != null && this.mbb.jyL != null) {
            this.mbb.jyL.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.mcb != null && this.mcb.bnS() != null && this.mbb != null) {
            this.mcC = !this.mcB;
            this.mbb.vY(this.mcC);
            if (this.lPo.dnz() != null) {
                this.lPo.dnz().vX(this.mcC);
            }
            drm();
            if (this.lPo != null && !this.lPo.dmy() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlM())) {
                bx bxVar = fVar.dlM().get(0);
                if (bxVar != null) {
                    this.mbb.fV(bxVar.getForumName(), bxVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.mbb.fV(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.mcC) {
                this.mbk.a(fVar, this.mcb, this.mbJ);
                if (this.mch != null) {
                    this.mch.setVisibility(8);
                }
                if (this.mcL == null) {
                    this.mcL = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (ap.this.lPo != null && ap.this.lPo.isAdded()) {
                                if (i < 0 && f > ap.this.mcE) {
                                    ap.this.drt();
                                    ap.this.drE();
                                }
                                ap.this.drd();
                            }
                        }
                    };
                }
                this.mbf.setListViewDragListener(this.mcL);
                return;
            }
            if (this.mch != null) {
                this.mch.setVisibility(0);
            }
            this.mbk.a(fVar, this.mcb, this.mbJ);
            this.mcL = null;
            this.mbf.setListViewDragListener(null);
        }
    }

    private void drm() {
        this.mbk.a(this.lQH, this.mcb, this.mcC, this.mcB);
    }

    public boolean drn() {
        return this.lQH == null || this.lQH.getForum() == null || "0".equals(this.lQH.getForum().getId()) || "me0407".equals(this.lQH.getForum().getName());
    }

    private boolean dro() {
        return this.mbi.vT(this.lQm);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlp() == null) {
            return false;
        }
        if (fVar.dlp().bnP() == 1 || fVar.dlp().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dlp().bnR() == null || fVar.dlp().bnR().bql() == 0) || fVar.dlp().bnN() == 1 || fVar.dlp().bnO() == 1 || fVar.dlp().boF() || fVar.dlp().bpb() || fVar.dlp().boU() || fVar.dlp().bod() != null || !com.baidu.tbadk.core.util.au.isEmpty(fVar.dlp().getCategory()) || fVar.dlp().bnV() || fVar.dlp().bnU();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.mbj != null) {
                if (fVar.dlp() != null && fVar.dlp().bog() == 0 && !fVar.dlp().bmx() && !this.mcW) {
                    if (fVar.dlp() != null) {
                        cb dlp = fVar.dlp();
                        dlp.y(true, w(fVar));
                        dlp.nk(3);
                        dlp.Ao("2");
                    }
                    if (fVar.dlp().bmz()) {
                        this.mbk.c(this.mbf);
                        this.mbj.c(this.mbf);
                        this.mbj.b(this.mbf);
                        this.mbk.b(this.mbf);
                        this.mbk.G(this.lQH);
                        if (A(fVar)) {
                            this.mbj.c(this.mbf);
                        } else {
                            this.mbj.D(fVar);
                        }
                    } else {
                        this.mbk.G(this.lQH);
                        if (A(fVar)) {
                            this.mbj.c(this.mbf);
                        } else {
                            this.mbj.F(fVar);
                        }
                    }
                } else if (fVar.dlp().bog() == 1) {
                    if (fVar.dlp() != null) {
                        this.mbj.c(this.mbf);
                        this.mbk.G(this.lQH);
                    }
                } else {
                    this.mbj.c(this.mbf);
                    this.mbk.G(this.lQH);
                }
            }
            z(fVar);
            this.lQm = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dro();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ad adVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.bnS().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlE()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.bnS() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.bnS().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.bnS().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.bnS().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlE()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bx> dlM = fVar.dlM();
                if (com.baidu.tbadk.core.util.y.getCount(dlM) > 0) {
                    sb = new StringBuilder();
                    for (bx bxVar : dlM) {
                        if (bxVar != null && !StringUtils.isNull(bxVar.getForumName()) && (adVar = bxVar.eRn) != null && adVar.eOX && !adVar.eOY && (adVar.type == 1 || adVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bxVar.getForumName(), 12)).append(this.lPo.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lPo.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View drp() {
        return this.fKb;
    }

    public boolean drq() {
        if (this.bOm == null || this.bOm.getParent() == null || this.jqc.isLoading()) {
            return false;
        }
        int bottom = this.bOm.getBottom();
        Rect rect = new Rect();
        this.bOm.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void PN(String str) {
        if (this.jqc != null) {
            this.jqc.setText(str);
        }
    }

    public void PO(String str) {
        if (this.jqc != null) {
            int i = 0;
            if (this.mcm != null && this.mcm.mdu != null && this.mcm.mdu.getView() != null) {
                i = this.mcm.mdu.getView().getTop() < 0 ? this.mcm.mdu.getView().getHeight() : this.mcm.mdu.getView().getBottom();
            }
            this.jqc.au(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.mbf;
    }

    public int drr() {
        return R.id.richText;
    }

    public TextView dmQ() {
        return this.mbk.dmQ();
    }

    public void d(BdListView.e eVar) {
        this.mbf.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fkY = cVar;
        if (this.mbu != null) {
            this.mbu.setListPullRefreshListener(cVar);
        }
    }

    public void a(az azVar, a.b bVar) {
        if (azVar != null) {
            int bmF = azVar.bmF();
            int bmC = azVar.bmC();
            if (this.mbr != null) {
                this.mbr.bqz();
            } else {
                this.mbr = new com.baidu.tbadk.core.dialog.a(this.lPo.getPageContext().getPageActivity());
                this.mbs = LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.mbr.bn(this.mbs);
                this.mbr.a(R.string.dialog_ok, bVar);
                this.mbr.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.drt();
                        aVar.dismiss();
                    }
                });
                this.mbr.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.mcw == null) {
                            ap.this.mcw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.lPo.HidenSoftKeyPad((InputMethodManager) ap.this.lPo.getBaseFragmentActivity().getSystemService("input_method"), ap.this.bND);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mA().postDelayed(ap.this.mcw, 150L);
                    }
                });
                this.mbr.b(this.lPo.getPageContext()).bqz();
            }
            this.mbt = (EditText) this.mbs.findViewById(R.id.input_page_number);
            this.mbt.setText("");
            TextView textView = (TextView) this.mbs.findViewById(R.id.current_page_number);
            if (bmF <= 0) {
                bmF = 1;
            }
            if (bmC <= 0) {
                bmC = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bmF), Integer.valueOf(bmC)));
            this.lPo.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.mbt, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mbf.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lPo.showToast(str);
    }

    public boolean vH(boolean z) {
        if (this.ael == null || !this.ael.bBo()) {
            return false;
        }
        this.ael.bzG();
        return true;
    }

    public void drs() {
        if (this.mdf != null) {
            while (this.mdf.size() > 0) {
                TbImageView remove = this.mdf.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        drs();
        this.mbq.FE(1);
        if (this.mbh != null) {
            this.mbh.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.mbq.FE(2);
        if (this.mbh != null) {
            this.mbh.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lPo.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lPo.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.mbV != null) {
            this.mbV.onDestroy();
        }
        if (this.mcy != null) {
            this.mcy.destroy();
        }
        if (this.mcN != null) {
            this.mcN.onDestory();
        }
        if (this.mcF != null) {
            this.mcF.hide();
        }
        this.lPo.hideProgressBar();
        if (this.gzT != null && this.jfq != null) {
            this.gzT.b(this.jfq);
        }
        drt();
        endLoadData();
        if (this.mcw != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mcw);
        }
        if (this.mce != null) {
            this.mce.clearStatus();
        }
        this.mcZ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mbq.FE(3);
        if (this.bMJ != null) {
            this.bMJ.setBackgroundDrawable(null);
        }
        if (this.mbh != null) {
            this.mbh.destroy();
        }
        if (this.mbq != null) {
            this.mbq.onDestroy();
        }
        this.mbf.setOnLayoutListener(null);
        if (this.mcJ != null) {
            this.mcJ.cFK();
        }
        if (this.mcn != null) {
            this.mcn.onDestroy();
        }
        if (this.mbk != null) {
            this.mbk.onDestroy();
        }
    }

    public boolean Gh(int i) {
        if (this.mbh != null) {
            return this.mbh.Gh(i);
        }
        return false;
    }

    public void drt() {
        this.mbb.baP();
        if (this.mbk != null) {
            this.mbk.drt();
        }
        if (this.lPo != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lPo.getContext(), this.mbt);
        }
        dqx();
        if (this.lTY != null) {
            this.lTY.dismiss();
        }
        drv();
        if (this.mbr != null) {
            this.mbr.dismiss();
        }
        if (this.jkR != null) {
            this.jkR.dismiss();
        }
    }

    public void dru() {
        this.mbb.baP();
        if (this.mbk != null) {
            this.mbk.drt();
        }
        if (this.lTY != null) {
            this.lTY.dismiss();
        }
        drv();
        if (this.mbr != null) {
            this.mbr.dismiss();
        }
        if (this.jkR != null) {
            this.jkR.dismiss();
        }
    }

    public void fn(List<String> list) {
        this.mcI = list;
        if (this.mcJ != null) {
            this.mcJ.setData(list);
        }
    }

    public void uJ(boolean z) {
        this.mbq.uJ(z);
    }

    public void vI(boolean z) {
        this.mbL = z;
    }

    public void drv() {
        if (this.mbz != null) {
            this.mbz.dismiss();
        }
        if (this.mbA != null) {
            com.baidu.adp.lib.f.g.b(this.mbA, this.lPo.getPageContext());
        }
        if (this.mbB != null) {
            com.baidu.adp.lib.f.g.b(this.mbB, this.lPo.getPageContext());
        }
        if (this.mby != null) {
            this.mby.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lQH, this.lQm);
            b(this.lQH, this.lQm, this.mType, i);
            this.lPo.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lPo.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bND);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bND, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mbM, R.color.CAM_X0203);
            if (this.mbh != null) {
                this.mbh.onChangeSkinType(i);
            }
            if (this.mbl != null) {
                this.mbl.onChangeSkinType(i);
            }
            if (this.mbi != null) {
                this.mbi.onChangeSkinType(i);
            }
            if (this.mbj != null) {
                this.mbj.onChangeSkinType(i);
            }
            if (this.mbk != null) {
                this.mbk.onChangeSkinType(i);
            }
            if (this.lSj != null) {
                this.lSj.onChangeSkinType();
            }
            if (this.lSi != null) {
                this.lSi.bzq();
            }
            if (this.jqc != null) {
                this.jqc.changeSkin(i);
            }
            if (this.fKb != null) {
                this.lPo.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fKb);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fKb, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.mbr != null) {
                this.mbr.c(this.lPo.getPageContext());
            }
            vG(this.mbI);
            this.mbq.notifyDataSetChanged();
            if (this.mbu != null) {
                this.mbu.changeSkin(i);
            }
            if (this.ael != null) {
                this.ael.onChangeSkinType(i);
            }
            if (this.mbv != null) {
                this.mbv.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.iBq)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.iBq) {
                    customBlueCheckRadioButton.btR();
                }
            }
            dqP();
            UtilHelper.setStatusBarBackground(this.bMJ, i);
            UtilHelper.setStatusBarBackground(this.mch, i);
            if (this.mbm != null) {
                com.baidu.tbadk.r.a.a(this.lPo.getPageContext(), this.mbm);
            }
            if (this.mcx != null) {
                this.mcx.onChangeSkinType(i);
            }
            if (this.mbb != null) {
                if (this.mbh != null) {
                    this.mbh.Gi(i);
                } else {
                    this.mbb.onChangeSkinType(i);
                }
            }
            if (this.mbR != null) {
                this.mbR.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
            }
            if (this.mbQ != null) {
                this.mbQ.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aL(com.baidu.adp.lib.util.l.getDimens(this.lPo.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209)));
            }
            if (this.lQH != null && this.lQH.bkb()) {
                WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.mbS, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lQH);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mbP, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mbO, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mcH, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.krw, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mbX, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mbW, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.d(this.mbW, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.mcK != null) {
                this.mcK.onChangeSkinType(i);
            }
            if (this.mcn != null) {
                this.mcn.onChangeSkinType();
            }
            if (this.mbg != null) {
                this.mbg.uw(i);
            }
            if (this.mbV != null) {
                this.mbV.onChangeSkinType();
            }
            if (this.mcU != null) {
                this.mcU.onChangeSkinType();
            }
        }
    }

    public void drw() {
        if (this.mbV != null) {
            this.mbV.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bd(fVar.dlp())) {
            if (this.mbV != null) {
                this.mbV.setEnable(false);
                this.mbV.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.mbU.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.mbU.setLayoutParams(layoutParams);
            WebPManager.a(this.mbU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.mbV == null || !this.mbV.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.mbU.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.mbU.setLayoutParams(layoutParams2);
            WebPManager.a(this.mbU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
        this.mbq.setOnImageClickListener(this.fVW);
        this.mcK.setOnImageClickListener(this.fVW);
    }

    public void g(NoNetworkView.a aVar) {
        this.jfq = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jfq);
        }
    }

    public void vJ(boolean z) {
        this.mbq.setIsFromCDN(z);
    }

    public Button drx() {
        return this.mbN;
    }

    public void dry() {
        if (this.mba != 2) {
            this.mbf.setNextPage(this.jqc);
            this.mba = 2;
        }
    }

    public boolean drz() {
        return this.ael != null && this.ael.getVisibility() == 0;
    }

    public boolean drA() {
        return this.ael != null && this.ael.bBo();
    }

    public void drB() {
        if (this.ael != null) {
            this.ael.bzG();
        }
    }

    public void vK(boolean z) {
        if (this.mbP != null) {
            vI(this.lPo.dnw().bBY());
            if (this.mbL) {
                vz(z);
            } else {
                vA(z);
            }
        }
    }

    public void drC() {
        if (this.mbP != null) {
            this.mbO.setVisibility(8);
            this.mbP.setVisibility(8);
            this.mbY = false;
            if (this.mcn != null) {
                this.mcn.setVisibility(8);
                vE(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iFD == null) {
            this.iFD = new com.baidu.tbadk.core.view.a(this.lPo.getPageContext());
        }
        this.iFD.setDialogVisiable(true);
    }

    public void ckD() {
        if (this.iFD != null) {
            this.iFD.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.mbf.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.mbf.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.mbh != null) {
            this.mbh.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.mLastScrollY = getScrollY();
            this.mcm.mdu = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mcm));
            a(this.mcm.mdu, true);
            drR();
        }
    }

    public void vL(boolean z) {
        if (this.mbh != null) {
            this.mbh.vL(z);
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
        if (this.mbh != null) {
            this.mbh.onScroll(absListView, i, i2, i3);
        }
        if (this.mbb != null && this.mbk != null) {
            this.mbb.dN(this.mbk.dsg());
        }
        this.mcm.lFq = i;
        this.mcm.headerCount = this.mbf.getHeaderViewsCount();
        this.mcm.mdu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mcm));
        vB(b(absListView, i));
        a(this.mcm.mdu, false);
        drR();
        if (this.jqc.bui() && !this.jqc.fjX) {
            if (this.mcm != null && this.mcm.mdu != null && this.mcm.mdu.getView() != null) {
                i4 = this.mcm.mdu.getView().getTop() < 0 ? this.mcm.mdu.getView().getHeight() : this.mcm.mdu.getView().getBottom();
            }
            this.jqc.pE(i4);
            this.jqc.fjX = true;
        }
    }

    public void drD() {
        if (TbadkCoreApplication.isLogin() && this.lQH != null && this.mcC && !this.mcB && !this.mbJ && this.mcb != null && this.mcb.bnS() != null && !this.mcb.bnS().getIsLike() && !this.mcb.bnS().hadConcerned() && this.mcy == null) {
            this.mcy = new al(this.lPo);
        }
    }

    public void drE() {
        if (this.lPo != null) {
            if ((this.jhS || this.mcR == 17) && com.baidu.tbadk.a.d.bjd()) {
                if (this.lQH != null && this.lQH.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lQH.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lPo.getContext()).createNormalCfg(this.lQH.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13853").dR("post_id", this.lQH.getThreadId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", this.lQH.getForum().getId()));
                }
            } else if (this.mcC && !this.mcB && this.mcb != null && this.mcb.bnS() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12601").aq("obj_locate", this.lPo.dmy() ? 2 : 1).aq("obj_type", this.mcB ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lPo.getPageContext().getPageActivity(), this.mcb.bnS().getUserId(), this.mcb.bnS().getUserName(), this.lPo.dmG().dmz(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z) {
        int measuredHeight;
        if (!this.mcB && this.mcg != null && this.mbb.dsy() != null) {
            int dng = this.mbq.dng();
            if (dng > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (dng > this.mbf.getFirstVisiblePosition() - this.mbf.getHeaderViewsCount()) {
                    this.mcg.setVisibility(4);
                    return;
                }
                this.mcg.setVisibility(0);
                vB(false);
                this.mbb.mNavigationBar.hideBottomLine();
                if (this.mcg.getParent() != null && ((ViewGroup) this.mcg.getParent()).getHeight() <= this.mcg.getTop()) {
                    this.mcg.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null || pbReplyTitleViewHolder.maB == null) {
                if (this.mbf.getFirstVisiblePosition() == 0) {
                    this.mcg.setVisibility(4);
                    this.mbb.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.mcl) {
                        this.mck = top;
                        this.mcl = false;
                    }
                    this.mck = top < this.mck ? top : this.mck;
                }
                if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                    if (this.mbp.getY() < 0.0f) {
                        measuredHeight = mcj - pbReplyTitleViewHolder.maB.getMeasuredHeight();
                    } else {
                        measuredHeight = this.mbb.dsy().getMeasuredHeight() - pbReplyTitleViewHolder.maB.getMeasuredHeight();
                        this.mbb.mNavigationBar.hideBottomLine();
                    }
                    if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.mck) {
                        this.mcg.setVisibility(0);
                        vB(false);
                    } else if (top < measuredHeight) {
                        this.mcg.setVisibility(0);
                        vB(false);
                    } else {
                        this.mcg.setVisibility(4);
                        this.mbb.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.mcl = true;
                    }
                }
            }
        }
    }

    public void drF() {
        if (!this.mdg) {
            TiebaStatic.log("c10490");
            this.mdg = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lPo.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(mcq, Integer.valueOf(mcs));
            aVar.nx(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bn(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lPo);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lPo.getPageContext()).bqz();
        }
    }

    public void PP(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lPo.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bn(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(mcq, Integer.valueOf(mct));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lPo);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lPo.getPageContext()).bqz();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.bnS() != null) {
            MetaData bnS = b.bnS();
            bnS.setGiftNum(bnS.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.mbk.onChangeSkinType(i2);
    }

    public PbInterviewStatusView drG() {
        return this.mce;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null && fVar.dlp().bpb() && this.mce == null) {
            this.mce = (PbInterviewStatusView) this.mcd.inflate();
            this.mce.setOnClickListener(this.jkS);
            this.mce.setCallback(this.lPo.doh());
            this.mce.setData(this.lPo, fVar);
        }
    }

    public RelativeLayout drH() {
        return this.mbp;
    }

    public View drI() {
        return this.bMJ;
    }

    public boolean drJ() {
        return this.mcW;
    }

    public void uO(boolean z) {
        this.mbk.uO(z);
    }

    public void PQ(String str) {
        if (this.mbc != null) {
            this.mbc.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vM(boolean z) {
        if (this.mce == null || this.mce.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void drK() {
        if (this.mce != null && this.mce.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mce.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.mce.setLayoutParams(layoutParams);
        }
    }

    public boolean dnC() {
        return false;
    }

    public void PR(String str) {
        this.krw.performClick();
        if (!StringUtils.isNull(str) && this.lPo.dnw() != null && this.lPo.dnw().bBQ() != null && this.lPo.dnw().bBQ().getInputView() != null) {
            EditText inputView = this.lPo.dnw().bBQ().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            drt();
            if (configuration.orientation == 2) {
                drC();
                dqx();
            } else {
                dqB();
            }
            if (this.mcx != null) {
                this.mcx.dnq();
            }
            this.lPo.cDi();
            this.mbp.setVisibility(8);
            this.mbb.vZ(false);
            this.lPo.ve(false);
            if (this.mbh != null) {
                if (configuration.orientation == 1) {
                    drH().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.mbf.setIsLandscape(true);
                    this.mbf.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.mbf.setIsLandscape(false);
                    if (this.mLastScrollY > 0) {
                        this.mbf.smoothScrollBy(this.mLastScrollY, 0);
                    }
                }
                this.mbh.onConfigurationChanged(configuration);
                this.mcf.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vN(boolean z) {
        if (this.mbh != null) {
            this.mbh.vN(z);
        }
    }

    public boolean drL() {
        return this.mbh != null && this.mbh.drL();
    }

    public void drM() {
        if (this.mbh != null) {
            this.mbh.drM();
        }
    }

    public void uS(boolean z) {
        this.mbq.uS(z);
    }

    public void dM(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.mbP.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lPo.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.mcH = new TextView(this.lPo.getContext());
            this.mcH.setText(R.string.connection_tips);
            this.mcH.setGravity(17);
            this.mcH.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lPo.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lPo.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lPo.getContext(), R.dimen.ds60);
            if (this.mcH.getParent() == null) {
                frameLayout.addView(this.mcH, layoutParams);
            }
            this.mcG = new PopupWindow(this.lPo.getContext());
            this.mcG.setContentView(frameLayout);
            this.mcG.setHeight(-2);
            this.mcG.setWidth(-2);
            this.mcG.setFocusable(true);
            this.mcG.setOutsideTouchable(false);
            this.mcG.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.mbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.mcG.showAsDropDown(ap.this.mbP, view.getLeft(), -ap.this.mbP.getHeight());
                    } else {
                        ap.this.mcG.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vO(boolean z) {
        this.mcM = z;
    }

    public boolean drN() {
        return this.mcM;
    }

    public PbThreadPostView drO() {
        return this.mbg;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null && !fVar.dlp().bmx()) {
            boolean z = fVar.dlp().bnO() == 1;
            boolean z2 = fVar.dlp().bnN() == 1;
            if (this.mbk != null) {
                this.mbk.c(fVar, z, z2);
            }
            if (this.mbq != null && this.mbq.dnl() != null) {
                this.mbq.dnl().b(fVar, z, z2);
            }
        }
    }

    public void vP(boolean z) {
        this.jhS = z;
    }

    public void FZ(int i) {
        this.mcR = i;
    }

    public void drP() {
        if (this.mbf != null) {
            this.mbf.setForbidDragListener(true);
        }
    }

    public boolean doB() {
        if (this.mbf == null) {
            return false;
        }
        return this.mbf.doB();
    }

    public boolean drQ() {
        if (this.jqc == null || TextUtils.isEmpty(this.jqc.getEndText())) {
            return false;
        }
        return this.jqc.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlp() == null) {
            return false;
        }
        SpannableStringBuilder boB = fVar.dlp().boB();
        if (boB != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(boB.toString());
        }
        return true;
    }

    public void drR() {
        boolean z;
        if (this.mcU != null) {
            if (((this.mcU.getView() == null || this.mcU.getView().getParent() == null) ? -1 : this.mbf.getPositionForView(this.mcU.getView())) != -1) {
                if (this.mcU.getView().getTop() + mcS <= this.mcg.getBottom()) {
                    this.mcT = 1;
                    z = true;
                } else {
                    this.mcT = 0;
                    z = false;
                }
            } else {
                z = this.mcT == 1;
            }
            this.mci.vx(this.mcT == 1);
            this.mcU.setScrollable(z);
        }
    }

    public LinearLayout drS() {
        return this.mbQ;
    }
}
