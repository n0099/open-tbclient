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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes23.dex */
public class c implements View.OnClickListener {
    private static final int hnr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hns = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private ShareGridLayout mLX;
    private View.OnClickListener mLZ;
    private SparseArray<String> mMc;
    private SparseArray<af> mMd;
    private final EMTextView mMx;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private float eGU = 0.33f;
    protected final SparseArray<ShareItem> mMa = new SparseArray<>(8);
    private boolean mMb = false;
    private boolean mMy = true;
    private int mMz = 0;
    private int mMA = 1;
    private boolean eGW = true;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.view.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dFV();
                c.this.mLX.removeAllViews();
                c.this.dFU();
            }
        }
    };
    private final List<View> mLY = new ArrayList();
    protected final View mRootView = cBk();
    protected final View kGn = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView mLW = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mLW.setText(sharePanelText);
        }
        this.mLX = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.mLX.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nlD;
            marginLayoutParams.rightMargin = ShareGridLayout.nlD;
            this.mLX.setLayoutParams(marginLayoutParams);
        }
        this.mLX.setItemParams(hnr, hns);
        this.mMx = (EMTextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mMx.setOnClickListener(this);
    }

    protected View cBk() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bTQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.view.c.2
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

    private void dFY() {
        ArrayList arrayList = new ArrayList(this.mLY);
        this.mLY.clear();
        if (!Jw(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Jx(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Jy(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!JA(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Jz(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (JB(this.hideMode)) {
            dr(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.mLY.addAll(arrayList);
        }
        if (this.mMy) {
            dr(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.mLY.add(shareDialogItemView.dGb());
        }
    }

    private void dr(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.mLY.add(shareDialogItemView.dGb());
    }

    public LinearLayout dq(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        return shareDialogItemView.dGb();
    }

    public int dFT() {
        if (this.mLY == null) {
            return 0;
        }
        return this.mLY.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.mLY.size() && i >= 0) {
            this.mLY.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes23.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener mMf;

        public a(View.OnClickListener onClickListener) {
            this.mMf = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.mMf != null) {
                this.mMf.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.mMy = z;
    }

    public void setCustomCopyTitle(int i) {
        this.mMz = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.mMc = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cpc;
        if (z && (cpc = cpc()) != null) {
            shareItem.location = cpc;
        }
        this.mMa.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.ffZ)) {
            this.mLW.setText(shareItem.ffZ);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cpc;
        if (z && (cpc = cpc()) != null) {
            shareItem.location = cpc;
        }
        this.mMa.put(i, shareItem);
    }

    private Location cpc() {
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
            this.mLZ = onClickListener;
        }
    }

    public void dFU() {
        dFY();
        if (!g.bwQ()) {
            this.mLX.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLY.size()) {
                this.mLX.addView(this.mLY.get(i2), new ViewGroup.LayoutParams(hnr, hns));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bwQ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dFU();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.view.c.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (c.this.mOnDismissListener != null) {
                        c.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.view.c.4
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
            com.baidu.tbadk.core.elementsMaven.c.bj(this.kGn).pb(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                if (this.eGW) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                } else {
                    window.setWindowAnimations(R.style.normal_dialog_style);
                }
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                window.setDimAmount(this.eGU);
                dFV();
                bTQ();
                i.I(this.mContext).registerListener(this.skinChangeListener);
            }
        }
    }

    protected void b(Window window) {
        window.setLayout(-1, -2);
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void f(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.mMb = false;
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
        if (id != R.id.btnShareCancel && i != R.drawable.icon_pure_share_copy40 && dFZ()) {
            this.mMb = false;
            return;
        }
        if (i != R.drawable.icon_pure_share_download40) {
            dismiss();
        }
        if (this.mMa.size() != 0) {
            if (id == R.id.btnShareCancel || !this.mMb) {
                this.mMb = true;
                ShareItem Ju = Ju(1);
                g gVar = new g(this.mContext, null);
                if (Ju != null && Ju.fgu) {
                    TiebaStatic.log(new ar("c13531").dR("obj_id", Ju.fgv).ak("obj_type", Ju.fgw).dR("obj_source", Ju.fgx));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (Ju != null && Ju.ffS) {
                        a(Ju, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                        return;
                    }
                    return;
                }
                ar arVar = new ar("c13724");
                if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Jv(3);
                    ShareItem Ju2 = Ju(3);
                    a(Ju2, 4);
                    if (Ju2 != null) {
                        if (n(Ju2) && Ju2.getCommandChannelArray() != null && Ju2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Ju2, this.mContext, 3, this.onCancelListener);
                        } else if (Ju2.fgs == 1) {
                            o(Ju2);
                        } else {
                            gVar.e(Ju2);
                        }
                    }
                    arVar.ak("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Jv(2);
                    ShareItem Ju3 = Ju(2);
                    a(Ju3, 3);
                    if (Ju3 != null) {
                        if (n(Ju3) && Ju3.getCommandChannelArray() != null && Ju3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Ju3, this.mContext, 2, this.onCancelListener);
                        } else if (Ju3.fgs == 1) {
                            o(Ju3);
                        } else {
                            if (Ju3.ffN) {
                                Ju3.content = "【" + Ju3.title + "】 " + Ju3.content;
                            }
                            gVar.f(Ju3);
                        }
                    }
                    arVar.ak("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Jv(4);
                        ShareItem Ju4 = Ju(4);
                        a(Ju4, 5);
                        if (Ju4 != null) {
                            if (n(Ju4) && Ju4.getCommandChannelArray() != null && Ju4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Ju4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.h(Ju4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
                    }
                    arVar.ak("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Jv(5);
                    ShareItem Ju5 = Ju(5);
                    if (Ju5 != null) {
                        if (!Ju5.ffM) {
                            Ju5.content = l(Ju5);
                        }
                        gVar.i(Ju5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Jv(6);
                    ShareItem Ju6 = Ju(6);
                    a(Ju6, 7);
                    if (Ju6 != null) {
                        if (!Ju6.ffM) {
                            Ju6.content = l(Ju6);
                        }
                        if (n(Ju6) && Ju6.getCommandChannelArray() != null && Ju6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Ju6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.j(Ju6);
                        }
                    }
                    arVar.ak("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Jv(7);
                    ShareItem Ju7 = Ju(7);
                    if (Ju7 != null) {
                        if (!Ju7.ffM) {
                            Ju7.content = l(Ju7);
                        }
                        gVar.k(Ju7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Jv(8);
                        ShareItem Ju8 = Ju(8);
                        a(Ju8, 9);
                        if (Ju8 != null) {
                            if (n(Ju8) && Ju8.getCommandChannelArray() != null && Ju8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Ju8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.g(Ju8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
                    }
                    arVar.ak("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.mMb = false;
                        return;
                    }
                    dismiss();
                    a(Ju, 17);
                    if (n.u(Ju.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, Ju.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = Ju.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new p(currentActivity, uri, new p.a() { // from class: com.baidu.tieba.sharesdk.view.c.5
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
                    arVar.ak("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40) {
                    a(Ju, 10);
                    if (this.mLZ != null) {
                        this.mLZ.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Ju.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    m(Ju);
                    if (Ju != null && Ju.ffM) {
                        bN(8, Ju.fgb);
                    }
                }
                arVar.ak("obj_source", 6);
                TiebaStatic.log(arVar);
            }
        }
    }

    private boolean n(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fgz) || TextUtils.isEmpty(shareItem.fgA)) ? false : true;
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.AI(shareItem.title);
            aVar.AJ(shareItem.content);
            aVar.setAutoNight(false);
            aVar.iW(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.view.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(c.this.mContext.getApplicationContext(), R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.view.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.I(activity));
            aVar.bog();
        }
    }

    private void m(ShareItem shareItem) {
        ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ak("obj_source", 7);
        if (shareItem.fgf != 0) {
            ak.ak("obj_param1", shareItem.fgf);
            if (shareItem.fgf == 2) {
                ak.dR("fid", shareItem.fid);
            } else if (shareItem.fgf == 3) {
                if (shareItem.fgj != 0) {
                    ak.ak("obj_type", shareItem.fgj);
                }
                ak.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        ak.ak("obj_locate", 9);
        TiebaStatic.log(ak);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem Ju(int i) {
        ShareItem shareItem = this.mMa.get(i);
        if (shareItem == null) {
            return this.mMa.get(1);
        }
        return shareItem;
    }

    private void Jv(int i) {
        if (i <= 8 && i > 0) {
            this.mMb = true;
            if (this.mMd != null) {
                af afVar = this.mMd.get(i);
                if (!StringUtils.isNull(afVar.bui()) && afVar.buj() != null && afVar.buj().size() > 0) {
                    f(afVar.bui(), afVar.buj());
                    return;
                }
            }
            if (this.mMc != null) {
                String str = this.mMc.get(i);
                if (!au.isEmpty(str)) {
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
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_type", i).ak("obj_source", shareItem.fge));
                }
            } else if (shareItem.ffN) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).ak("obj_type", i).ak("obj_source", shareItem.fge));
            } else if (shareItem.ffO || shareItem.ffR) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).ak("obj_type", i).ak("obj_source", shareItem.fge).ak("obj_param1", shareItem.fgf).dR("fid", shareItem.fid).ak(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgg));
            } else if (shareItem.ffP) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).ak("obj_type", i));
            } else if (shareItem.ffM) {
                bN(i, shareItem.fgb);
            } else if (shareItem.ffQ) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_param1", 7).ak("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.ffS) {
                ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_type", i);
                ak.ak("obj_source", shareItem.fge);
                if (!au.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ak.ak("obj_param1", 9);
                    }
                    ak.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ak);
            } else if (shareItem.ffU) {
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
                TiebaStatic.log(new ar("c13365").dR("obj_locate", str).dR("topic_id", shareItem.extData));
            } else if (shareItem.ffV) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                arVar.dR("tid", shareItem.extData);
                arVar.dR("post_id", shareItem.pid);
                arVar.ak("obj_source", 18);
                TiebaStatic.log(arVar);
            } else if (shareItem.ffW) {
                ar arVar2 = new ar("c13953");
                arVar2.ak("obj_type", i);
                arVar2.dR("obj_name", shareItem.title);
                TiebaStatic.log(arVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dFV() {
        com.baidu.tbadk.core.elementsMaven.c.bj(this.kGn).pb(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.mLW, R.color.CAM_X0108, 1);
        ap.k(this.mMx, R.color.CAM_X0107);
    }

    private String l(ShareItem shareItem) {
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

    private boolean Jw(int i) {
        return (i & 1) > 0;
    }

    private boolean Jx(int i) {
        return (i & 2) > 0;
    }

    private boolean JA(int i) {
        return (i & 4) > 0;
    }

    private boolean Jy(int i) {
        return (i & 8) > 0;
    }

    private boolean Jz(int i) {
        return (i & 16) > 0;
    }

    private boolean JB(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bug() && !au.isEmpty(sharePanelConfData.getText())) {
            this.mLW.setText(sharePanelConfData.getText());
        }
    }

    public boolean dFZ() {
        return this.mMA == 2 && biF();
    }

    private boolean biF() {
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

    public void JC(int i) {
        this.mMA = i;
    }

    public void xd(boolean z) {
        this.eGW = z;
    }
}
