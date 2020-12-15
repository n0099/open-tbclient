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
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes24.dex */
public class c implements View.OnClickListener {
    private static final int hxa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hxb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private final EMTextView naC;
    private ShareGridLayout nac;
    private View.OnClickListener nae;
    private SparseArray<String> nah;
    private SparseArray<af> nai;
    private DialogInterface.OnCancelListener onCancelListener;
    private float eOa = 0.33f;
    protected final SparseArray<ShareItem> naf = new SparseArray<>(8);
    private boolean nag = false;
    private boolean naD = true;
    private int naE = 0;
    private int naF = 1;
    private boolean eOc = true;
    private CustomMessageListener eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.view.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dLk();
                c.this.nac.removeAllViews();
                c.this.dLj();
            }
        }
    };
    private final List<View> nad = new ArrayList();
    protected final View mRootView = cFB();
    protected final View kTH = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView nab = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nab.setText(sharePanelText);
        }
        this.nac = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nac.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nzJ;
            marginLayoutParams.rightMargin = ShareGridLayout.nzJ;
            this.nac.setLayoutParams(marginLayoutParams);
        }
        this.nac.setItemParams(hxa, hxb);
        this.naC = (EMTextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.naC.setOnClickListener(this);
    }

    protected View cFB() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bXA() {
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

    private void dLn() {
        ArrayList arrayList = new ArrayList(this.nad);
        this.nad.clear();
        if (!Kn(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Ko(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Kp(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Kr(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Kq(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Ks(this.hideMode)) {
            dw(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.nad.addAll(arrayList);
        }
        if (this.naD) {
            dw(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nad.add(shareDialogItemView.dLq());
        }
    }

    private void dw(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nad.add(shareDialogItemView.dLq());
    }

    public LinearLayout dv(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        return shareDialogItemView.dLq();
    }

    public int dLi() {
        if (this.nad == null) {
            return 0;
        }
        return this.nad.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nad.size() && i >= 0) {
            this.nad.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes24.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener nak;

        public a(View.OnClickListener onClickListener) {
            this.nak = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.nak != null) {
                this.nak.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.naD = z;
    }

    public void setCustomCopyTitle(int i) {
        this.naE = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.nah = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location ctr;
        if (z && (ctr = ctr()) != null) {
            shareItem.location = ctr;
        }
        this.naf.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fnz)) {
            this.nab.setText(shareItem.fnz);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location ctr;
        if (z && (ctr = ctr()) != null) {
            shareItem.location = ctr;
        }
        this.naf.put(i, shareItem);
    }

    private Location ctr() {
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
            this.nae = onClickListener;
        }
    }

    public void dLj() {
        dLn();
        if (!g.bAq()) {
            this.nac.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nad.size()) {
                this.nac.addView(this.nad.get(i2), new ViewGroup.LayoutParams(hxa, hxb));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!g.bAq()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dLj();
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
            com.baidu.tbadk.core.elementsMaven.c.bm(this.kTH).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                if (this.eOc) {
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
                window.setDimAmount(this.eOa);
                dLk();
                bXA();
                i.J(this.mContext).registerListener(this.eOd);
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
            this.nag = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.eOd);
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
        if (id != R.id.btnShareCancel && i != R.drawable.icon_pure_share_copy40 && dLo()) {
            this.nag = false;
            return;
        }
        if (i != R.drawable.icon_pure_share_download40) {
            dismiss();
        }
        if (this.naf.size() != 0) {
            if (id == R.id.btnShareCancel || !this.nag) {
                this.nag = true;
                ShareItem Kl = Kl(1);
                g gVar = new g(this.mContext, null);
                if (Kl != null && Kl.fnU) {
                    TiebaStatic.log(new ar("c13531").dY("obj_id", Kl.fnV).al("obj_type", Kl.fnW).dY("obj_source", Kl.fnX));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (Kl != null && Kl.fns) {
                        a(Kl, 16);
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
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Km(3);
                    ShareItem Kl2 = Kl(3);
                    a(Kl2, 4);
                    if (Kl2 != null) {
                        if (n(Kl2) && Kl2.getCommandChannelArray() != null && Kl2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Kl2, this.mContext, 3, this.onCancelListener);
                        } else if (Kl2.fnS == 1) {
                            o(Kl2);
                        } else {
                            gVar.e(Kl2);
                        }
                    }
                    arVar.al("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Km(2);
                    ShareItem Kl3 = Kl(2);
                    a(Kl3, 3);
                    if (Kl3 != null) {
                        if (n(Kl3) && Kl3.getCommandChannelArray() != null && Kl3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Kl3, this.mContext, 2, this.onCancelListener);
                        } else if (Kl3.fnS == 1) {
                            o(Kl3);
                        } else {
                            if (Kl3.fnn) {
                                Kl3.content = "【" + Kl3.title + "】 " + Kl3.content;
                            }
                            gVar.f(Kl3);
                        }
                    }
                    arVar.al("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Km(4);
                        ShareItem Kl4 = Kl(4);
                        a(Kl4, 5);
                        if (Kl4 != null) {
                            if (n(Kl4) && Kl4.getCommandChannelArray() != null && Kl4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Kl4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.h(Kl4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
                    }
                    arVar.al("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Km(5);
                    ShareItem Kl5 = Kl(5);
                    if (Kl5 != null) {
                        if (!Kl5.fnm) {
                            Kl5.content = l(Kl5);
                        }
                        gVar.i(Kl5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Km(6);
                    ShareItem Kl6 = Kl(6);
                    a(Kl6, 7);
                    if (Kl6 != null) {
                        if (!Kl6.fnm) {
                            Kl6.content = l(Kl6);
                        }
                        if (n(Kl6) && Kl6.getCommandChannelArray() != null && Kl6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(Kl6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.j(Kl6);
                        }
                    }
                    arVar.al("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Km(7);
                    ShareItem Kl7 = Kl(7);
                    if (Kl7 != null) {
                        if (!Kl7.fnm) {
                            Kl7.content = l(Kl7);
                        }
                        gVar.k(Kl7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Km(8);
                        ShareItem Kl8 = Kl(8);
                        a(Kl8, 9);
                        if (Kl8 != null) {
                            if (n(Kl8) && Kl8.getCommandChannelArray() != null && Kl8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(Kl8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.g(Kl8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
                    }
                    arVar.al("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.nag = false;
                        return;
                    }
                    dismiss();
                    a(Kl, 17);
                    if (n.u(Kl.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, Kl.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = Kl.imageUri.toString();
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
                    arVar.al("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40) {
                    a(Kl, 10);
                    if (this.nae != null) {
                        this.nae.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Kl.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    m(Kl);
                    if (Kl != null && Kl.fnm) {
                        bN(8, Kl.fnB);
                    }
                }
                arVar.al("obj_source", 6);
                TiebaStatic.log(arVar);
            }
        }
    }

    private boolean n(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fnZ) || TextUtils.isEmpty(shareItem.foa)) ? false : true;
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.Bp(shareItem.title);
            aVar.Bq(shareItem.content);
            aVar.setAutoNight(false);
            aVar.jl(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.view.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(c.this.mContext.getApplicationContext(), (int) R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.view.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.J(activity));
            aVar.brv();
        }
    }

    private void m(ShareItem shareItem) {
        ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 7);
        if (shareItem.fnF != 0) {
            al.al("obj_param1", shareItem.fnF);
            if (shareItem.fnF == 2) {
                al.dY("fid", shareItem.fid);
            } else if (shareItem.fnF == 3) {
                if (shareItem.fnJ != 0) {
                    al.al("obj_type", shareItem.fnJ);
                }
                al.dY("tid", shareItem.tid).dY("fid", shareItem.fid);
            }
        }
        al.al("obj_locate", 9);
        TiebaStatic.log(al);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem Kl(int i) {
        ShareItem shareItem = this.naf.get(i);
        if (shareItem == null) {
            return this.naf.get(1);
        }
        return shareItem;
    }

    private void Km(int i) {
        if (i <= 8 && i > 0) {
            this.nag = true;
            if (this.nai != null) {
                af afVar = this.nai.get(i);
                if (!StringUtils.isNull(afVar.bxI()) && afVar.bxJ() != null && afVar.bxJ().size() > 0) {
                    f(afVar.bxI(), afVar.bxJ());
                    return;
                }
            }
            if (this.nah != null) {
                String str = this.nah.get(i);
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
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i).al("obj_source", shareItem.fnE));
                }
            } else if (shareItem.fnn) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("fid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fnE));
            } else if (shareItem.fno || shareItem.fnr) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("tid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fnE).al("obj_param1", shareItem.fnF).dY("fid", shareItem.fid).al(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fnG));
            } else if (shareItem.fnp) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dY("tid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fnm) {
                bN(i, shareItem.fnB);
            } else if (shareItem.fnq) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_param1", 7).al("obj_type", i).dY("fid", shareItem.extData));
            } else if (shareItem.fns) {
                ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i);
                al.al("obj_source", shareItem.fnE);
                if (!au.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        al.al("obj_param1", 9);
                    }
                    al.dY(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(al);
            } else if (shareItem.fnu) {
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
                TiebaStatic.log(new ar("c13365").dY("obj_locate", str).dY("topic_id", shareItem.extData));
            } else if (shareItem.fnv) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                arVar.dY("tid", shareItem.extData);
                arVar.dY("post_id", shareItem.pid);
                arVar.al("obj_source", 18);
                TiebaStatic.log(arVar);
            } else if (shareItem.fnw) {
                ar arVar2 = new ar("c13953");
                arVar2.al("obj_type", i);
                arVar2.dY("obj_name", shareItem.title);
                TiebaStatic.log(arVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dLk() {
        com.baidu.tbadk.core.elementsMaven.c.bm(this.kTH).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.nab, R.color.CAM_X0108, 1);
        ap.k(this.naC, R.color.CAM_X0107);
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

    private boolean Kn(int i) {
        return (i & 1) > 0;
    }

    private boolean Ko(int i) {
        return (i & 2) > 0;
    }

    private boolean Kr(int i) {
        return (i & 4) > 0;
    }

    private boolean Kp(int i) {
        return (i & 8) > 0;
    }

    private boolean Kq(int i) {
        return (i & 16) > 0;
    }

    private boolean Ks(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bxG() && !au.isEmpty(sharePanelConfData.getText())) {
            this.nab.setText(sharePanelConfData.getText());
        }
    }

    public boolean dLo() {
        return this.naF == 2 && blP();
    }

    private boolean blP() {
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

    public void Kt(int i) {
        this.naF = i;
    }

    public void xH(boolean z) {
        this.eOc = z;
    }
}
