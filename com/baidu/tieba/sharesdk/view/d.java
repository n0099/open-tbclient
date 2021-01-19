package com.baidu.tieba.sharesdk.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private static final int hEs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hEt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    protected final View bRa;
    private float eTm;
    private boolean eTo;
    private CustomMessageListener eTp;
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    protected final View mRootView;
    private final TextView naQ;
    private ShareGridLayout naR;
    protected final List<View> naS;
    private View.OnClickListener naT;
    protected final SparseArray<ShareItem> naU;
    private boolean naV;
    private SparseArray<String> naW;
    private SparseArray<af> naX;
    private final EMTextView nbA;
    private boolean nbB;
    private int nbC;
    private int nbD;
    private DialogInterface.OnCancelListener onCancelListener;

    public d(Context context, boolean z, int i) {
        this.eTm = 0.33f;
        this.naU = new SparseArray<>(8);
        this.naV = false;
        this.nbB = true;
        this.nbC = 0;
        this.mIsLandscape = false;
        this.nbD = 1;
        this.eTo = true;
        this.eTp = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.view.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    d.this.dHi();
                    d.this.naR.removeAllViews();
                    d.this.dHh();
                }
            }
        };
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.naS = new ArrayList();
        this.mRootView = cEG();
        this.bRa = this.mRootView.findViewById(R.id.share_dialog_main_view);
        this.naQ = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.naQ.setText(sharePanelText);
        }
        this.naR = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.naR.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nzm;
            marginLayoutParams.rightMargin = ShareGridLayout.nzm;
            this.naR.setLayoutParams(marginLayoutParams);
        }
        this.naR.setItemParams(hEs, hEt);
        this.nbA = (EMTextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.nbA.setOnClickListener(this);
    }

    protected View cEG() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    public d(Context context) {
        this(context, false, 0);
    }

    private void bWo() {
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

    private void dHo() {
        ArrayList arrayList = new ArrayList(this.naS);
        this.naS.clear();
        if (!IA(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!IB(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!IC(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!IF(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!ID(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (IG(this.hideMode)) {
            ds(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.naS.addAll(arrayList);
        }
        if (this.nbB) {
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
            this.naS.add(shareDialogItemView.dHl());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ds(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ao.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.naS.add(shareDialogItemView.dHl());
    }

    public LinearLayout dr(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ao.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        return shareDialogItemView.dHl();
    }

    public int dHg() {
        if (this.naS == null) {
            return 0;
        }
        return this.naS.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.naS.size() && i >= 0) {
            this.naS.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener naZ;

        public a(View.OnClickListener onClickListener) {
            this.naZ = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.naZ != null) {
                this.naZ.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.nbB = z;
    }

    public void setCustomCopyTitle(int i) {
        this.nbC = i;
    }

    public void j(SparseArray<String> sparseArray) {
        this.naW = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cst;
        if (z && (cst = cst()) != null) {
            shareItem.location = cst;
        }
        this.naU.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fsA)) {
            this.naQ.setText(shareItem.fsA);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cst;
        if (z && (cst = cst()) != null) {
            shareItem.location = cst;
        }
        this.naU.put(i, shareItem);
    }

    private Location cst() {
        if (ad.checkLocationForGoogle(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
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
            this.naT = onClickListener;
        }
    }

    public void dHh() {
        if (!dHk()) {
            dHo();
            if (!g.byR()) {
                this.naR.setVisibility(8);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.naS.size()) {
                    this.naR.addView(this.naS.get(i2), new ViewGroup.LayoutParams(hEs, hEt));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dHk() {
        return false;
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.byR()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dHh();
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
            com.baidu.tbadk.core.elementsMaven.c.bv(this.bRa).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                if (this.eTo) {
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
                window.setDimAmount(this.eTm);
                dHi();
                bWo();
                com.baidu.adp.base.j.K(this.mContext).registerListener(this.eTp);
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
            this.naV = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.eTp);
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
        if (id != R.id.btnShareCancel && i != R.drawable.icon_pure_share_copy40 && dHp()) {
            this.naV = false;
            return;
        }
        if (i != R.drawable.icon_pure_share_download40) {
            dismiss();
        }
        if (this.naU.size() != 0) {
            if (id == R.id.btnShareCancel || !this.naV) {
                this.naV = true;
                ShareItem Iy = Iy(1);
                g gVar = new g(this.mContext, null);
                if (Iy != null && Iy.fsV) {
                    TiebaStatic.log(new aq("c13531").dW("obj_id", Iy.fsW).an("obj_type", Iy.fsX).dW("obj_source", Iy.fsY));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (Iy != null && Iy.fst) {
                        a(Iy, 16);
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
                    Iz(3);
                    ShareItem Iy2 = Iy(3);
                    a(Iy2, 4);
                    if (Iy2 != null) {
                        if (l(Iy2) && Iy2.getCommandChannelArray() != null && Iy2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Iy2, this.mContext, 3, this.onCancelListener);
                        } else if (Iy2.fsT == 1) {
                            o(Iy2);
                        } else {
                            gVar.e(Iy2);
                        }
                    }
                    aqVar.an("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Iz(2);
                    ShareItem Iy3 = Iy(2);
                    a(Iy3, 3);
                    if (Iy3 != null) {
                        if (l(Iy3) && Iy3.getCommandChannelArray() != null && Iy3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Iy3, this.mContext, 2, this.onCancelListener);
                        } else if (Iy3.fsT == 1) {
                            o(Iy3);
                        } else {
                            if (Iy3.fso) {
                                Iy3.content = "【" + Iy3.title + "】 " + Iy3.content;
                            }
                            gVar.f(Iy3);
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
                        Iz(4);
                        ShareItem Iy4 = Iy(4);
                        a(Iy4, 5);
                        if (Iy4 != null) {
                            if (l(Iy4) && Iy4.getCommandChannelArray() != null && Iy4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Iy4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.h(Iy4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqk();
                    }
                    aqVar.an("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Iz(5);
                    ShareItem Iy5 = Iy(5);
                    if (Iy5 != null) {
                        if (!Iy5.fsn) {
                            Iy5.content = m(Iy5);
                        }
                        gVar.i(Iy5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Iz(6);
                    ShareItem Iy6 = Iy(6);
                    a(Iy6, 7);
                    if (Iy6 != null) {
                        if (!Iy6.fsn) {
                            Iy6.content = m(Iy6);
                        }
                        if (l(Iy6) && Iy6.getCommandChannelArray() != null && Iy6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Iy6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.j(Iy6);
                        }
                    }
                    aqVar.an("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Iz(7);
                    ShareItem Iy7 = Iy(7);
                    if (Iy7 != null) {
                        if (!Iy7.fsn) {
                            Iy7.content = m(Iy7);
                        }
                        gVar.k(Iy7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Iz(8);
                        ShareItem Iy8 = Iy(8);
                        a(Iy8, 9);
                        if (Iy8 != null) {
                            if (l(Iy8) && Iy8.getCommandChannelArray() != null && Iy8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Iy8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.g(Iy8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqk();
                    }
                    aqVar.an("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.naV = false;
                        return;
                    }
                    dismiss();
                    a(Iy, 17);
                    if (n.z(Iy.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, Iy.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = Iy.imageUri.toString();
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
                    a(Iy, 10);
                    if (this.naT != null) {
                        this.naT.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Iy.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Iy);
                    if (Iy != null && Iy.fsn) {
                        bO(8, Iy.fsC);
                    }
                }
                aqVar.an("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean l(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fta) || TextUtils.isEmpty(shareItem.ftb)) ? false : true;
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.Ac(shareItem.title);
            aVar.Ad(shareItem.content);
            aVar.setAutoNight(false);
            aVar.jD(true);
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
            aVar.bqe();
        }
    }

    private void n(ShareItem shareItem) {
        aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 7);
        if (shareItem.fsG != 0) {
            an.an("obj_param1", shareItem.fsG);
            if (shareItem.fsG == 2) {
                an.dW("fid", shareItem.fid);
            } else if (shareItem.fsG == 3) {
                if (shareItem.fsK != 0) {
                    an.an("obj_type", shareItem.fsK);
                }
                an.dW("tid", shareItem.tid).dW("fid", shareItem.fid);
            }
        }
        an.an("obj_locate", 9);
        TiebaStatic.log(an);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem Iy(int i) {
        ShareItem shareItem = this.naU.get(i);
        if (shareItem == null) {
            return this.naU.get(1);
        }
        return shareItem;
    }

    private void Iz(int i) {
        if (i <= 8 && i > 0) {
            this.naV = true;
            if (this.naX != null) {
                af afVar = this.naX.get(i);
                if (!StringUtils.isNull(afVar.bwj()) && afVar.bwk() != null && afVar.bwk().size() > 0) {
                    f(afVar.bwj(), afVar.bwk());
                    return;
                }
            }
            if (this.naW != null) {
                String str = this.naW.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bO(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_type", i).an("obj_source", shareItem.fsF));
                }
            } else if (shareItem.fso) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dW("fid", shareItem.extData).an("obj_type", i).an("obj_source", shareItem.fsF));
            } else if (shareItem.fsp || shareItem.fss) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dW("tid", shareItem.extData).an("obj_type", i).an("obj_source", shareItem.fsF).an("obj_param1", shareItem.fsG).dW("fid", shareItem.fid).an(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fsH));
            } else if (shareItem.fsq) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dW("tid", shareItem.extData).an("obj_type", i));
            } else if (shareItem.fsn) {
                bO(i, shareItem.fsC);
            } else if (shareItem.fsr) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_param1", 7).an("obj_type", i).dW("fid", shareItem.extData));
            } else if (shareItem.fst) {
                aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_type", i);
                an.an("obj_source", shareItem.fsF);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        an.an("obj_param1", 9);
                    }
                    an.dW(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(an);
            } else if (shareItem.fsv) {
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
                TiebaStatic.log(new aq("c13365").dW("obj_locate", str).dW("topic_id", shareItem.extData));
            } else if (shareItem.fsw) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dW("tid", shareItem.extData);
                aqVar.dW("post_id", shareItem.pid);
                aqVar.an("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.fsx) {
                aq aqVar2 = new aq("c13953");
                aqVar2.an("obj_type", i);
                aqVar2.dW("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dHi() {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.bRa).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ao.setViewTextColor(this.naQ, R.color.CAM_X0108, 1);
        ao.n(this.nbA, R.color.CAM_X0107);
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

    private boolean IA(int i) {
        return (i & 1) > 0;
    }

    private boolean IB(int i) {
        return (i & 2) > 0;
    }

    private boolean IF(int i) {
        return (i & 4) > 0;
    }

    private boolean IC(int i) {
        return (i & 8) > 0;
    }

    private boolean ID(int i) {
        return (i & 16) > 0;
    }

    private boolean IG(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bwh() && !at.isEmpty(sharePanelConfData.getText())) {
            this.naQ.setText(sharePanelConfData.getText());
        }
    }

    public boolean dHp() {
        return this.nbD == 2 && bkv();
    }

    private boolean bkv() {
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

    public void IH(int i) {
        this.nbD = i;
    }

    public void xF(boolean z) {
        this.eTo = z;
    }
}
