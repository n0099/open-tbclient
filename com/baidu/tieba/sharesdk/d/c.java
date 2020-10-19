package com.baidu.tieba.sharesdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes24.dex */
public class c implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private final TextView msG;
    private ShareGridLayout msI;
    private View.OnClickListener msK;
    private SparseArray<String> msN;
    private SparseArray<af> msO;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int gWd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int gWe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int msD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int msE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int msF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eTu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> msL = new SparseArray<>(8);
    private boolean msM = false;
    private boolean mti = true;
    private int mtj = 0;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dAx();
                c.this.msI.removeAllViews();
                c.this.dAw();
            }
        }
    };
    private final List<View> msJ = new ArrayList();
    protected final View mRootView = cvZ();
    protected final View knH = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView msH = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.msH.setText(sharePanelText);
        }
        this.msI = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.msI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.mSa;
            marginLayoutParams.rightMargin = ShareGridLayout.mSa;
            this.msI.setLayoutParams(marginLayoutParams);
        }
        this.msI.setItemParams(gWd, gWe);
        this.msG = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.msG.setOnClickListener(this);
    }

    protected View cvZ() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bPb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.c.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (c.this.mDialog != null && c.this.mDialog.isShowing()) {
                    c.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dAA() {
        ArrayList arrayList = new ArrayList(this.msJ);
        this.msJ.clear();
        if (!Ip(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Iq(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Ir(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!It(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Is(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Iu(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.msJ.addAll(arrayList);
        }
        if (this.mti) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.evn));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bnv().oO(1).oP(R.color.cp_bg_line_i).bf(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(msD, msD);
            layoutParams.topMargin = msE;
            layoutParams.bottomMargin = msF;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eTu);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.msJ.add(linearLayout);
        }
    }

    public LinearLayout dm(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(msD, msD);
        layoutParams.topMargin = msE;
        layoutParams.bottomMargin = msF;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eTu);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (ap.getDrawable(i2) instanceof BitmapDrawable) {
            ap.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bnv().oO(1).oP(R.color.cp_bg_line_i).bf(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        ap.setViewTextColor(textView, R.color.cp_cont_f);
        return linearLayout;
    }

    public int dAv() {
        if (this.msJ == null) {
            return 0;
        }
        return this.msJ.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.msJ.size() && i >= 0) {
            this.msJ.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes24.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener msQ;

        public a(View.OnClickListener onClickListener) {
            this.msQ = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.msQ != null) {
                this.msQ.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.mti = z;
    }

    public void setCustomCopyTitle(int i) {
        this.mtj = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.msN = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cjT;
        if (z && (cjT = cjT()) != null) {
            shareItem.location = cjT;
        }
        this.msL.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.eSE)) {
            this.msH.setText(shareItem.eSE);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cjT;
        if (z && (cjT = cjT()) != null) {
            shareItem.location = cjT;
        }
        this.msL.put(i, shareItem);
    }

    private Location cjT() {
        if (ae.checkLocationForGoogle(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.msK = onClickListener;
        }
    }

    public void dAw() {
        dAA();
        if (!g.bti()) {
            this.msI.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.msJ.size()) {
                this.msI.addView(this.msJ.get(i2), new ViewGroup.LayoutParams(gWd, gWe));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bti()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dAw();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.c.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (c.this.mOnDismissListener != null) {
                        c.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.c.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (c.this.onCancelListener != null) {
                        c.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            ap.setBackgroundResource(this.knH, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                dAx();
                bPb();
                i.I(this.mContext).registerListener(this.skinChangeListener);
            }
        }
    }

    protected void b(Window window) {
        window.setLayout(-1, -2);
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void f(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.msM = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.skinChangeListener);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int i = -1;
        if (view.getTag() != null) {
            i = ((Integer) view.getTag()).intValue();
        }
        if (i != R.drawable.icon_pure_share_download40_svg) {
            dismiss();
        }
        if (this.msL.size() != 0) {
            if (id == R.id.btnShareCancel || !this.msM) {
                this.msM = true;
                ShareItem In = In(1);
                g gVar = new g(this.mContext, null);
                if (In != null && In.eSZ) {
                    TiebaStatic.log(new aq("c13531").dK("obj_id", In.eTa).aj("obj_type", In.eTb).dK("obj_source", In.eTc));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (In != null && In.eSx) {
                        a(In, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                        return;
                    }
                    return;
                }
                aq aqVar = new aq("c13724");
                if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Io(3);
                    ShareItem In2 = In(3);
                    a(In2, 4);
                    if (In2 != null) {
                        if (o(In2) && In2.getCommandChannelArray() != null && In2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(In2, this.mContext, 3, this.onCancelListener);
                        } else if (In2.eSX == 1) {
                            p(In2);
                        } else {
                            gVar.f(In2);
                        }
                    }
                    aqVar.aj("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Io(2);
                    ShareItem In3 = In(2);
                    a(In3, 3);
                    if (In3 != null) {
                        if (o(In3) && In3.getCommandChannelArray() != null && In3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(In3, this.mContext, 2, this.onCancelListener);
                        } else if (In3.eSX == 1) {
                            p(In3);
                        } else {
                            if (In3.eSs) {
                                In3.content = "【" + In3.title + "】 " + In3.content;
                            }
                            gVar.g(In3);
                        }
                    }
                    aqVar.aj("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Io(4);
                        ShareItem In4 = In(4);
                        a(In4, 5);
                        if (In4 != null) {
                            if (o(In4) && In4.getCommandChannelArray() != null && In4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(In4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.i(In4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bkP();
                    }
                    aqVar.aj("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Io(5);
                    ShareItem In5 = In(5);
                    if (In5 != null) {
                        if (!In5.eSr) {
                            In5.content = m(In5);
                        }
                        gVar.j(In5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Io(6);
                    ShareItem In6 = In(6);
                    a(In6, 7);
                    if (In6 != null) {
                        if (!In6.eSr) {
                            In6.content = m(In6);
                        }
                        if (o(In6) && In6.getCommandChannelArray() != null && In6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(In6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.k(In6);
                        }
                    }
                    aqVar.aj("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Io(7);
                    ShareItem In7 = In(7);
                    if (In7 != null) {
                        if (!In7.eSr) {
                            In7.content = m(In7);
                        }
                        gVar.l(In7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Io(8);
                        ShareItem In8 = In(8);
                        a(In8, 9);
                        if (In8 != null) {
                            if (o(In8) && In8.getCommandChannelArray() != null && In8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(In8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.h(In8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bkP();
                    }
                    aqVar.aj("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.msM = false;
                        return;
                    }
                    dismiss();
                    a(In, 17);
                    if (n.u(In.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, In.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = In.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new p(currentActivity, uri, new p.a() { // from class: com.baidu.tieba.sharesdk.d.c.5
                                @Override // com.baidu.tbadk.util.p.a
                                public void onError(int i2, String str) {
                                    l.showToast(c.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.p.a
                                public void onSuccess(String str) {
                                    l.showToast(c.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        } else {
                            return;
                        }
                    }
                    aqVar.aj("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(In, 10);
                    if (this.msK != null) {
                        this.msK.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(In.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(In);
                    if (In != null && In.eSr) {
                        bK(8, In.eSG);
                    }
                }
                aqVar.aj("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean o(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.eTe) || TextUtils.isEmpty(shareItem.eTf)) ? false : true;
    }

    private void p(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.AG(shareItem.title);
            aVar.AH(shareItem.content);
            aVar.setAutoNight(false);
            aVar.iz(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(c.this.mContext.getApplicationContext(), R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.I(activity));
            aVar.bkJ();
        }
    }

    private void n(ShareItem shareItem) {
        aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aj("obj_source", 7);
        if (shareItem.eSK != 0) {
            aj.aj("obj_param1", shareItem.eSK);
            if (shareItem.eSK == 2) {
                aj.dK("fid", shareItem.fid);
            } else if (shareItem.eSK == 3) {
                if (shareItem.eSO != 0) {
                    aj.aj("obj_type", shareItem.eSO);
                }
                aj.dK("tid", shareItem.tid).dK("fid", shareItem.fid);
            }
        }
        aj.aj("obj_locate", 9);
        TiebaStatic.log(aj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem In(int i) {
        ShareItem shareItem = this.msL.get(i);
        if (shareItem == null) {
            return this.msL.get(1);
        }
        return shareItem;
    }

    private void Io(int i) {
        if (i <= 8 && i > 0) {
            this.msM = true;
            if (this.msO != null) {
                af afVar = this.msO.get(i);
                if (!StringUtils.isNull(afVar.bqz()) && afVar.bqA() != null && afVar.bqA().size() > 0) {
                    f(afVar.bqz(), afVar.bqA());
                    return;
                }
            }
            if (this.msN != null) {
                String str = this.msN.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bK(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_type", i).aj("obj_source", shareItem.eSJ));
                }
            } else if (shareItem.eSs) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dK("fid", shareItem.extData).aj("obj_type", i).aj("obj_source", shareItem.eSJ));
            } else if (shareItem.eSt || shareItem.eSw) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dK("tid", shareItem.extData).aj("obj_type", i).aj("obj_source", shareItem.eSJ).aj("obj_param1", shareItem.eSK).dK("fid", shareItem.fid).aj(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eSL));
            } else if (shareItem.eSu) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dK("tid", shareItem.extData).aj("obj_type", i));
            } else if (shareItem.eSr) {
                bK(i, shareItem.eSG);
            } else if (shareItem.eSv) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_param1", 7).aj("obj_type", i).dK("fid", shareItem.extData));
            } else if (shareItem.eSx) {
                aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_type", i);
                aj.aj("obj_source", shareItem.eSJ);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        aj.aj("obj_param1", 9);
                    }
                    aj.dK(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(aj);
            } else if (shareItem.eSz) {
                if (i == 3) {
                    str = "1";
                } else if (i == 4) {
                    str = "2";
                } else if (i == 9) {
                    str = "4";
                } else if (i == 5) {
                    str = "3";
                } else if (i == 7) {
                    str = "5";
                } else {
                    str = "6";
                }
                TiebaStatic.log(new aq("c13365").dK("obj_locate", str).dK("topic_id", shareItem.extData));
            } else if (shareItem.eSA) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dK("tid", shareItem.extData);
                aqVar.dK("post_id", shareItem.pid);
                aqVar.aj("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.eSB) {
                aq aqVar2 = new aq("c13953");
                aqVar2.aj("obj_type", i);
                aqVar2.dK("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dAx() {
        ap.setBackgroundResource(this.knH, R.drawable.transmit_share_dialog_background);
        ap.setViewTextColor(this.msH, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.msG, R.color.cp_cont_j, 1);
    }

    private String m(ShareItem shareItem) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(shareItem.title)) {
            sb.append("【");
            sb.append(shareItem.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(shareItem.title)) {
            sb.append(shareItem.content);
        }
        return sb.toString();
    }

    private boolean Ip(int i) {
        return (i & 1) > 0;
    }

    private boolean Iq(int i) {
        return (i & 2) > 0;
    }

    private boolean It(int i) {
        return (i & 4) > 0;
    }

    private boolean Ir(int i) {
        return (i & 8) > 0;
    }

    private boolean Is(int i) {
        return (i & 16) > 0;
    }

    private boolean Iu(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bqx() && !at.isEmpty(sharePanelConfData.getText())) {
            this.msH.setText(sharePanelConfData.getText());
        }
    }
}
