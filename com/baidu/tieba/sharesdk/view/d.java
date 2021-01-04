package com.baidu.tieba.sharesdk.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public class d implements View.OnClickListener {
    private static final int hIY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hIZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    protected final View bVM;
    private float eXX;
    private boolean eXZ;
    private CustomMessageListener eYa;
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    protected final View mRootView;
    protected final SparseArray<ShareItem> nfA;
    private boolean nfB;
    private SparseArray<String> nfC;
    private SparseArray<af> nfD;
    private final TextView nfw;
    private ShareGridLayout nfx;
    protected final List<View> nfy;
    private View.OnClickListener nfz;
    private final EMTextView ngg;
    private boolean ngh;
    private int ngi;
    private int ngj;
    private DialogInterface.OnCancelListener onCancelListener;

    public d(Context context, boolean z, int i) {
        this.eXX = 0.33f;
        this.nfA = new SparseArray<>(8);
        this.nfB = false;
        this.ngh = true;
        this.ngi = 0;
        this.mIsLandscape = false;
        this.ngj = 1;
        this.eXZ = true;
        this.eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.view.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    d.this.dKZ();
                    d.this.nfx.removeAllViews();
                    d.this.dKY();
                }
            }
        };
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.nfy = new ArrayList();
        this.mRootView = cIx();
        this.bVM = this.mRootView.findViewById(R.id.share_dialog_main_view);
        this.nfw = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nfw.setText(sharePanelText);
        }
        this.nfx = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nfx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nDR;
            marginLayoutParams.rightMargin = ShareGridLayout.nDR;
            this.nfx.setLayoutParams(marginLayoutParams);
        }
        this.nfx.setItemParams(hIY, hIZ);
        this.ngg = (EMTextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.ngg.setOnClickListener(this);
    }

    protected View cIx() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    public d(Context context) {
        this(context, false, 0);
    }

    private void caf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.view.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.mDialog != null && d.this.mDialog.isShowing()) {
                    d.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dLf() {
        ArrayList arrayList = new ArrayList(this.nfy);
        this.nfy.clear();
        if (!Kh(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Ki(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Kj(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Km(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Kk(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Kn(this.hideMode)) {
            ds(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.nfy.addAll(arrayList);
        }
        if (this.ngh) {
            ds(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nfy.add(shareDialogItemView.dLc());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ds(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ao.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nfy.add(shareDialogItemView.dLc());
    }

    public LinearLayout dr(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ao.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        return shareDialogItemView.dLc();
    }

    public int dKX() {
        if (this.nfy == null) {
            return 0;
        }
        return this.nfy.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nfy.size() && i >= 0) {
            this.nfy.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener nfF;

        public a(View.OnClickListener onClickListener) {
            this.nfF = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.nfF != null) {
                this.nfF.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.ngh = z;
    }

    public void setCustomCopyTitle(int i) {
        this.ngi = i;
    }

    public void j(SparseArray<String> sparseArray) {
        this.nfC = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cwk;
        if (z && (cwk = cwk()) != null) {
            shareItem.location = cwk;
        }
        this.nfA.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fxj)) {
            this.nfw.setText(shareItem.fxj);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cwk;
        if (z && (cwk = cwk()) != null) {
            shareItem.location = cwk;
        }
        this.nfA.put(i, shareItem);
    }

    private Location cwk() {
        if (ad.checkLocationForGoogle(this.mContext)) {
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
            this.nfz = onClickListener;
        }
    }

    public void dKY() {
        if (!dLb()) {
            dLf();
            if (!g.bCK()) {
                this.nfx.setVisibility(8);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nfy.size()) {
                    this.nfx.addView(this.nfy.get(i2), new ViewGroup.LayoutParams(hIY, hIZ));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dLb() {
        return false;
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bCK()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dKY();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.view.d.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (d.this.mOnDismissListener != null) {
                        d.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.view.d.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (d.this.onCancelListener != null) {
                        d.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            com.baidu.tbadk.core.elementsMaven.c.bv(this.bVM).pK(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                if (this.eXZ) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                } else {
                    window.setWindowAnimations(R.style.normal_dialog_style);
                }
                window.setGravity(80);
                d(window);
                window.setContentView(this.mRootView);
                window.setDimAmount(this.eXX);
                dKZ();
                caf();
                com.baidu.adp.base.j.K(this.mContext).registerListener(this.eYa);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
            }
        }
    }

    protected void d(Window window) {
        window.setLayout(-1, -2);
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void g(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.nfB = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.eYa);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
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
        if (id != R.id.btnShareCancel && i != R.drawable.icon_pure_share_copy40 && dLg()) {
            this.nfB = false;
            return;
        }
        if (i != R.drawable.icon_pure_share_download40) {
            dismiss();
        }
        if (this.nfA.size() != 0) {
            if (id == R.id.btnShareCancel || !this.nfB) {
                this.nfB = true;
                ShareItem Kf = Kf(1);
                g gVar = new g(this.mContext, null);
                if (Kf != null && Kf.fxE) {
                    TiebaStatic.log(new aq("c13531").dX("obj_id", Kf.fxF).an("obj_type", Kf.fxG).dX("obj_source", Kf.fxH));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (Kf != null && Kf.fxc) {
                        a(Kf, 16);
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
                    Kg(3);
                    ShareItem Kf2 = Kf(3);
                    a(Kf2, 4);
                    if (Kf2 != null) {
                        if (l(Kf2) && Kf2.getCommandChannelArray() != null && Kf2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Kf2, this.mContext, 3, this.onCancelListener);
                        } else if (Kf2.fxC == 1) {
                            o(Kf2);
                        } else {
                            gVar.e(Kf2);
                        }
                    }
                    aqVar.an("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Kg(2);
                    ShareItem Kf3 = Kf(2);
                    a(Kf3, 3);
                    if (Kf3 != null) {
                        if (l(Kf3) && Kf3.getCommandChannelArray() != null && Kf3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Kf3, this.mContext, 2, this.onCancelListener);
                        } else if (Kf3.fxC == 1) {
                            o(Kf3);
                        } else {
                            if (Kf3.fwX) {
                                Kf3.content = "【" + Kf3.title + "】 " + Kf3.content;
                            }
                            gVar.f(Kf3);
                        }
                    }
                    aqVar.an("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Kg(4);
                        ShareItem Kf4 = Kf(4);
                        a(Kf4, 5);
                        if (Kf4 != null) {
                            if (l(Kf4) && Kf4.getCommandChannelArray() != null && Kf4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Kf4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.h(Kf4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bud();
                    }
                    aqVar.an("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Kg(5);
                    ShareItem Kf5 = Kf(5);
                    if (Kf5 != null) {
                        if (!Kf5.fwW) {
                            Kf5.content = m(Kf5);
                        }
                        gVar.i(Kf5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Kg(6);
                    ShareItem Kf6 = Kf(6);
                    a(Kf6, 7);
                    if (Kf6 != null) {
                        if (!Kf6.fwW) {
                            Kf6.content = m(Kf6);
                        }
                        if (l(Kf6) && Kf6.getCommandChannelArray() != null && Kf6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Kf6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.j(Kf6);
                        }
                    }
                    aqVar.an("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Kg(7);
                    ShareItem Kf7 = Kf(7);
                    if (Kf7 != null) {
                        if (!Kf7.fwW) {
                            Kf7.content = m(Kf7);
                        }
                        gVar.k(Kf7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Kg(8);
                        ShareItem Kf8 = Kf(8);
                        a(Kf8, 9);
                        if (Kf8 != null) {
                            if (l(Kf8) && Kf8.getCommandChannelArray() != null && Kf8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Kf8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.g(Kf8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bud();
                    }
                    aqVar.an("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.nfB = false;
                        return;
                    }
                    dismiss();
                    a(Kf, 17);
                    if (n.w(Kf.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, Kf.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = Kf.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new o(currentActivity, uri, new o.a() { // from class: com.baidu.tieba.sharesdk.view.d.5
                                @Override // com.baidu.tbadk.util.o.a
                                public void onError(int i2, String str) {
                                    l.showToast(d.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.o.a
                                public void onSuccess(String str) {
                                    l.showToast(d.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        } else {
                            return;
                        }
                    }
                    aqVar.an("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40) {
                    a(Kf, 10);
                    if (this.nfz != null) {
                        this.nfz.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Kf.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Kf);
                    if (Kf != null && Kf.fwW) {
                        bN(8, Kf.fxl);
                    }
                }
                aqVar.an("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean l(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fxJ) || TextUtils.isEmpty(shareItem.fxK)) ? false : true;
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.Bo(shareItem.title);
            aVar.Bp(shareItem.content);
            aVar.setAutoNight(false);
            aVar.jH(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.view.d.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(d.this.mContext.getApplicationContext(), R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.view.d.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(com.baidu.adp.base.j.K(activity));
            aVar.btX();
        }
    }

    private void n(ShareItem shareItem) {
        aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 7);
        if (shareItem.fxp != 0) {
            an.an("obj_param1", shareItem.fxp);
            if (shareItem.fxp == 2) {
                an.dX("fid", shareItem.fid);
            } else if (shareItem.fxp == 3) {
                if (shareItem.fxt != 0) {
                    an.an("obj_type", shareItem.fxt);
                }
                an.dX("tid", shareItem.tid).dX("fid", shareItem.fid);
            }
        }
        an.an("obj_locate", 9);
        TiebaStatic.log(an);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem Kf(int i) {
        ShareItem shareItem = this.nfA.get(i);
        if (shareItem == null) {
            return this.nfA.get(1);
        }
        return shareItem;
    }

    private void Kg(int i) {
        if (i <= 8 && i > 0) {
            this.nfB = true;
            if (this.nfD != null) {
                af afVar = this.nfD.get(i);
                if (!StringUtils.isNull(afVar.bAc()) && afVar.bAd() != null && afVar.bAd().size() > 0) {
                    f(afVar.bAc(), afVar.bAd());
                    return;
                }
            }
            if (this.nfC != null) {
                String str = this.nfC.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bN(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_type", i).an("obj_source", shareItem.fxo));
                }
            } else if (shareItem.fwX) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("fid", shareItem.extData).an("obj_type", i).an("obj_source", shareItem.fxo));
            } else if (shareItem.fwY || shareItem.fxb) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("tid", shareItem.extData).an("obj_type", i).an("obj_source", shareItem.fxo).an("obj_param1", shareItem.fxp).dX("fid", shareItem.fid).an(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fxq));
            } else if (shareItem.fwZ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dX("tid", shareItem.extData).an("obj_type", i));
            } else if (shareItem.fwW) {
                bN(i, shareItem.fxl);
            } else if (shareItem.fxa) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_param1", 7).an("obj_type", i).dX("fid", shareItem.extData));
            } else if (shareItem.fxc) {
                aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_type", i);
                an.an("obj_source", shareItem.fxo);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        an.an("obj_param1", 9);
                    }
                    an.dX(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(an);
            } else if (shareItem.fxe) {
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
                TiebaStatic.log(new aq("c13365").dX("obj_locate", str).dX("topic_id", shareItem.extData));
            } else if (shareItem.fxf) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dX("tid", shareItem.extData);
                aqVar.dX("post_id", shareItem.pid);
                aqVar.an("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.fxg) {
                aq aqVar2 = new aq("c13953");
                aqVar2.an("obj_type", i);
                aqVar2.dX("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dKZ() {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.bVM).pK(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ao.setViewTextColor(this.nfw, R.color.CAM_X0108, 1);
        ao.n(this.ngg, R.color.CAM_X0107);
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

    private boolean Kh(int i) {
        return (i & 1) > 0;
    }

    private boolean Ki(int i) {
        return (i & 2) > 0;
    }

    private boolean Km(int i) {
        return (i & 4) > 0;
    }

    private boolean Kj(int i) {
        return (i & 8) > 0;
    }

    private boolean Kk(int i) {
        return (i & 16) > 0;
    }

    private boolean Kn(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bAa() && !at.isEmpty(sharePanelConfData.getText())) {
            this.nfw.setText(sharePanelConfData.getText());
        }
    }

    public boolean dLg() {
        return this.ngj == 2 && boo();
    }

    private boolean boo() {
        if (!(this.mContext instanceof Activity)) {
            return false;
        }
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission((Activity) this.mContext);
    }

    public void Ko(int i) {
        this.ngj = i;
    }

    public void xJ(boolean z) {
        this.eXZ = z;
    }
}
