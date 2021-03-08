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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private static final int hKB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hKC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    protected final View bWp;
    private float eXb;
    private boolean eXd;
    private CustomMessageListener eXe;
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    protected final View mRootView;
    private final EMTextView nnM;
    private boolean nnN;
    private int nnO;
    private int nnP;
    private final TextView nnc;
    private ShareGridLayout nnd;
    protected final List<View> nne;
    private View.OnClickListener nnf;
    protected final SparseArray<ShareItem> nng;
    private boolean nnh;
    private SparseArray<String> nni;
    private SparseArray<af> nnj;
    private DialogInterface.OnCancelListener onCancelListener;

    public d(Context context, boolean z, int i) {
        this.eXb = 0.33f;
        this.nng = new SparseArray<>(8);
        this.nnh = false;
        this.nnN = true;
        this.nnO = 0;
        this.mIsLandscape = false;
        this.nnP = 1;
        this.eXd = true;
        this.eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.view.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    d.this.dJJ();
                    d.this.nnd.removeAllViews();
                    d.this.dJI();
                }
            }
        };
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.nne = new ArrayList();
        this.mRootView = cGg();
        this.bWp = this.mRootView.findViewById(R.id.share_dialog_main_view);
        this.nnc = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nnc.setText(sharePanelText);
        }
        this.nnd = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nLB;
            marginLayoutParams.rightMargin = ShareGridLayout.nLB;
            this.nnd.setLayoutParams(marginLayoutParams);
        }
        this.nnd.setItemParams(hKB, hKC);
        this.nnM = (EMTextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.nnM.setOnClickListener(this);
    }

    protected View cGg() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    public d(Context context) {
        this(context, false, 0);
    }

    private void bXf() {
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

    private void dJP() {
        ArrayList arrayList = new ArrayList(this.nne);
        this.nne.clear();
        if (!IY(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!IZ(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Ja(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Jd(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Jb(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Je(this.hideMode)) {
            dq(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.nne.addAll(arrayList);
        }
        if (this.nnN) {
            dq(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nne.add(shareDialogItemView.dJM());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dq(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nne.add(shareDialogItemView.dJM());
    }

    public LinearLayout dp(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        return shareDialogItemView.dJM();
    }

    public int dJH() {
        if (this.nne == null) {
            return 0;
        }
        return this.nne.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nne.size() && i >= 0) {
            this.nne.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener nnl;

        public a(View.OnClickListener onClickListener) {
            this.nnl = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.nnl != null) {
                this.nnl.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.nnN = z;
    }

    public void setCustomCopyTitle(int i) {
        this.nnO = i;
    }

    public void h(SparseArray<String> sparseArray) {
        this.nni = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location ctS;
        if (z && (ctS = ctS()) != null) {
            shareItem.location = ctS;
        }
        this.nng.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fwr)) {
            this.nnc.setText(shareItem.fwr);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location ctS;
        if (z && (ctS = ctS()) != null) {
            shareItem.location = ctS;
        }
        this.nng.put(i, shareItem);
    }

    private Location ctS() {
        if (ae.checkLocationForGoogle(this.mContext)) {
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
            this.nnf = onClickListener;
        }
    }

    public void dJI() {
        if (!dJL()) {
            dJP();
            if (!g.bzm()) {
                this.nnd.setVisibility(8);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nne.size()) {
                    this.nnd.addView(this.nne.get(i2), new ViewGroup.LayoutParams(hKB, hKC));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dJL() {
        return false;
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bzm()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dJI();
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
            com.baidu.tbadk.core.elementsMaven.c.br(this.bWp).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                if (this.eXd) {
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
                window.setDimAmount(this.eXb);
                dJJ();
                bXf();
                com.baidu.adp.base.j.J(this.mContext).registerListener(this.eXe);
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
            this.nnh = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.eXe);
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
        if (id != R.id.btnShareCancel && i != R.drawable.icon_pure_share_copy40 && dJQ()) {
            this.nnh = false;
            return;
        }
        if (i != R.drawable.icon_pure_share_download40) {
            dismiss();
        }
        if (this.nng.size() != 0) {
            if (id == R.id.btnShareCancel || !this.nnh) {
                this.nnh = true;
                ShareItem IW = IW(1);
                g gVar = new g(this.mContext, null);
                if (IW != null && IW.fwM) {
                    TiebaStatic.log(new ar("c13531").dR("obj_id", IW.fwN).aq("obj_type", IW.fwO).dR("obj_source", IW.fwP));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (IW != null && IW.fwk) {
                        a(IW, 16);
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
                    IX(3);
                    ShareItem IW2 = IW(3);
                    a(IW2, 4);
                    if (IW2 != null) {
                        if (l(IW2) && IW2.getCommandChannelArray() != null && IW2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IW2, this.mContext, 3, this.onCancelListener);
                        } else if (IW2.fwK == 1) {
                            o(IW2);
                        } else {
                            gVar.e(IW2);
                        }
                    }
                    arVar.aq("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IX(2);
                    ShareItem IW3 = IW(2);
                    a(IW3, 3);
                    if (IW3 != null) {
                        if (l(IW3) && IW3.getCommandChannelArray() != null && IW3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IW3, this.mContext, 2, this.onCancelListener);
                        } else if (IW3.fwK == 1) {
                            o(IW3);
                        } else {
                            if (IW3.fwf) {
                                IW3.content = "【" + IW3.title + "】 " + IW3.content;
                            }
                            gVar.f(IW3);
                        }
                    }
                    arVar.aq("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IX(4);
                        ShareItem IW4 = IW(4);
                        a(IW4, 5);
                        if (IW4 != null) {
                            if (l(IW4) && IW4.getCommandChannelArray() != null && IW4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IW4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.h(IW4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqF();
                    }
                    arVar.aq("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IX(5);
                    ShareItem IW5 = IW(5);
                    if (IW5 != null) {
                        if (!IW5.fwe) {
                            IW5.content = m(IW5);
                        }
                        gVar.i(IW5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    IX(6);
                    ShareItem IW6 = IW(6);
                    a(IW6, 7);
                    if (IW6 != null) {
                        if (!IW6.fwe) {
                            IW6.content = m(IW6);
                        }
                        if (l(IW6) && IW6.getCommandChannelArray() != null && IW6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IW6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.j(IW6);
                        }
                    }
                    arVar.aq("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IX(7);
                    ShareItem IW7 = IW(7);
                    if (IW7 != null) {
                        if (!IW7.fwe) {
                            IW7.content = m(IW7);
                        }
                        gVar.k(IW7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IX(8);
                        ShareItem IW8 = IW(8);
                        a(IW8, 9);
                        if (IW8 != null) {
                            if (l(IW8) && IW8.getCommandChannelArray() != null && IW8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IW8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.g(IW8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqF();
                    }
                    arVar.aq("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.nnh = false;
                        return;
                    }
                    dismiss();
                    a(IW, 17);
                    if (o.z(IW.imageUri)) {
                        if (o.copyImageFile(o.getImageRealPathFromUri(this.mContext, IW.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = IW.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new p(currentActivity, uri, new p.a() { // from class: com.baidu.tieba.sharesdk.view.d.5
                                @Override // com.baidu.tbadk.util.p.a
                                public void onError(int i2, String str) {
                                    l.showToast(d.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.p.a
                                public void onSuccess(String str) {
                                    l.showToast(d.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        } else {
                            return;
                        }
                    }
                    arVar.aq("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40) {
                    a(IW, 10);
                    if (this.nnf != null) {
                        this.nnf.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(IW.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(IW);
                    if (IW != null && IW.fwe) {
                        bV(8, IW.fwt);
                    }
                }
                arVar.aq("obj_source", 6);
                TiebaStatic.log(arVar);
            }
        }
    }

    private boolean l(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fwR) || TextUtils.isEmpty(shareItem.fwS)) ? false : true;
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.AA(shareItem.title);
            aVar.AB(shareItem.content);
            aVar.setAutoNight(false);
            aVar.jF(true);
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
            }).b(com.baidu.adp.base.j.J(activity));
            aVar.bqz();
        }
    }

    private void n(ShareItem shareItem) {
        ar aq = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aq("obj_source", 7);
        if (shareItem.fwx != 0) {
            aq.aq("obj_param1", shareItem.fwx);
            if (shareItem.fwx == 2) {
                aq.dR("fid", shareItem.fid);
            } else if (shareItem.fwx == 3) {
                if (shareItem.fwB != 0) {
                    aq.aq("obj_type", shareItem.fwB);
                }
                aq.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        aq.aq("obj_locate", 9);
        TiebaStatic.log(aq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem IW(int i) {
        ShareItem shareItem = this.nng.get(i);
        if (shareItem == null) {
            return this.nng.get(1);
        }
        return shareItem;
    }

    private void IX(int i) {
        if (i <= 8 && i > 0) {
            this.nnh = true;
            if (this.nnj != null) {
                af afVar = this.nnj.get(i);
                if (!StringUtils.isNull(afVar.bwE()) && afVar.bwF() != null && afVar.bwF().size() > 0) {
                    f(afVar.bwE(), afVar.bwF());
                    return;
                }
            }
            if (this.nni != null) {
                String str = this.nni.get(i);
                if (!au.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bV(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aq("obj_type", i).aq("obj_source", shareItem.fww));
                }
            } else if (shareItem.fwf) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).aq("obj_type", i).aq("obj_source", shareItem.fww));
            } else if (shareItem.fwg || shareItem.fwj) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).aq("obj_type", i).aq("obj_source", shareItem.fww).aq("obj_param1", shareItem.fwx).dR("fid", shareItem.fid).aq(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fwy));
            } else if (shareItem.fwh) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).aq("obj_type", i));
            } else if (shareItem.fwe) {
                bV(i, shareItem.fwt);
            } else if (shareItem.fwi) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aq("obj_param1", 7).aq("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fwk) {
                ar aq = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aq("obj_type", i);
                aq.aq("obj_source", shareItem.fww);
                if (!au.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        aq.aq("obj_param1", 9);
                    }
                    aq.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(aq);
            } else if (shareItem.fwm) {
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
            } else if (shareItem.fwn) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                arVar.dR("tid", shareItem.extData);
                arVar.dR("post_id", shareItem.pid);
                arVar.aq("obj_source", 18);
                TiebaStatic.log(arVar);
            } else if (shareItem.fwo) {
                ar arVar2 = new ar("c13953");
                arVar2.aq("obj_type", i);
                arVar2.dR("obj_name", shareItem.title);
                TiebaStatic.log(arVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dJJ() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.bWp).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.nnc, R.color.CAM_X0108, 1);
        ap.n(this.nnM, R.color.CAM_X0107);
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

    private boolean IY(int i) {
        return (i & 1) > 0;
    }

    private boolean IZ(int i) {
        return (i & 2) > 0;
    }

    private boolean Jd(int i) {
        return (i & 4) > 0;
    }

    private boolean Ja(int i) {
        return (i & 8) > 0;
    }

    private boolean Jb(int i) {
        return (i & 16) > 0;
    }

    private boolean Je(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bwC() && !au.isEmpty(sharePanelConfData.getText())) {
            this.nnc.setText(sharePanelConfData.getText());
        }
    }

    public boolean dJQ() {
        return this.nnP == 2 && bkP();
    }

    private boolean bkP() {
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

    public void Jf(int i) {
        this.nnP = i;
    }

    public void xY(boolean z) {
        this.eXd = z;
    }
}
