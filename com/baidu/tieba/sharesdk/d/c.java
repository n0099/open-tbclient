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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes18.dex */
public class c implements View.OnClickListener {
    private int hideMode;
    private final TextView lTE;
    private ShareGridLayout lTG;
    private View.OnClickListener lTI;
    private SparseArray<String> lTL;
    private SparseArray<ae> lTM;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int gEg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int gEh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lTB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lTC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lTD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eFg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> lTJ = new SparseArray<>(8);
    private boolean lTK = false;
    private boolean lUc = true;
    private int lUd = 0;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dsU();
                c.this.lTG.removeAllViews();
                c.this.dsT();
            }
        }
    };
    private final List<View> lTH = new ArrayList();
    protected final View mRootView = cpp();
    protected final View jPO = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView lTF = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lTF.setText(sharePanelText);
        }
        this.lTG = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lTG.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.msQ;
            marginLayoutParams.rightMargin = ShareGridLayout.msQ;
            this.lTG.setLayoutParams(marginLayoutParams);
        }
        this.lTG.setItemParams(gEg, gEh);
        this.lTE = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lTE.setOnClickListener(this);
    }

    protected View cpp() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bLh() {
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

    private void dsW() {
        ArrayList arrayList = new ArrayList(this.lTH);
        this.lTH.clear();
        if (!Hg(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Hh(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Hi(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Hk(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Hj(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Hl(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.lTH.addAll(arrayList);
        }
        if (this.lUc) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.egQ));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bjQ().oe(1).of(R.color.cp_bg_line_i).aZ(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTB, lTB);
            layoutParams.topMargin = lTC;
            layoutParams.bottomMargin = lTD;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eFg);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.lTH.add(linearLayout);
        }
    }

    public LinearLayout di(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTB, lTB);
        layoutParams.topMargin = lTC;
        layoutParams.bottomMargin = lTD;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eFg);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (ap.getDrawable(i2) instanceof BitmapDrawable) {
            ap.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(1).of(R.color.cp_bg_line_i).aZ(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int dsS() {
        if (this.lTH == null) {
            return 0;
        }
        return this.lTH.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.lTH.size() && i >= 0) {
            this.lTH.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener lTO;

        public a(View.OnClickListener onClickListener) {
            this.lTO = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.lTO != null) {
                this.lTO.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.lUc = z;
    }

    public void setCustomCopyTitle(int i) {
        this.lUd = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.lTL = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cdi;
        if (z && (cdi = cdi()) != null) {
            shareItem.location = cdi;
        }
        this.lTJ.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.eEr)) {
            this.lTF.setText(shareItem.eEr);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cdi;
        if (z && (cdi = cdi()) != null) {
            shareItem.location = cdi;
        }
        this.lTJ.put(i, shareItem);
    }

    private Location cdi() {
        if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(this.mContext)) {
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
            this.lTI = onClickListener;
        }
    }

    public void dsT() {
        dsW();
        if (!g.bpE()) {
            this.lTG.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lTH.size()) {
                this.lTG.addView(this.lTH.get(i2), new ViewGroup.LayoutParams(gEg, gEh));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!g.bpE()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dsT();
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
            ap.setBackgroundResource(this.jPO, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                dsU();
                bLh();
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
            this.lTK = false;
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
        if (this.lTJ.size() != 0) {
            if (id == R.id.btnShareCancel || !this.lTK) {
                this.lTK = true;
                ShareItem He = He(1);
                g gVar = new g(this.mContext, null);
                if (He != null && He.eEM) {
                    TiebaStatic.log(new aq("c13531").dD("obj_id", He.eEN).ai("obj_type", He.eEO).dD("obj_source", He.eEP));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (He != null && He.eEk) {
                        a(He, 16);
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
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    Hf(3);
                    ShareItem He2 = He(3);
                    a(He2, 4);
                    if (He2 != null) {
                        if (o(He2) && He2.getCommandChannelArray() != null && He2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(He2, this.mContext, 3, this.onCancelListener);
                        } else if (He2.eEK == 1) {
                            p(He2);
                        } else {
                            gVar.f(He2);
                        }
                    }
                    aqVar.ai("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Hf(2);
                    ShareItem He3 = He(2);
                    a(He3, 3);
                    if (He3 != null) {
                        if (o(He3) && He3.getCommandChannelArray() != null && He3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(He3, this.mContext, 2, this.onCancelListener);
                        } else if (He3.eEK == 1) {
                            p(He3);
                        } else {
                            if (He3.eEf) {
                                He3.content = "【" + He3.title + "】 " + He3.content;
                            }
                            gVar.g(He3);
                        }
                    }
                    aqVar.ai("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Hf(4);
                        ShareItem He4 = He(4);
                        a(He4, 5);
                        if (He4 != null) {
                            if (o(He4) && He4.getCommandChannelArray() != null && He4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(He4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.i(He4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bhm();
                    }
                    aqVar.ai("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Hf(5);
                    ShareItem He5 = He(5);
                    if (He5 != null) {
                        if (!He5.eEe) {
                            He5.content = m(He5);
                        }
                        gVar.j(He5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Hf(6);
                    ShareItem He6 = He(6);
                    a(He6, 7);
                    if (He6 != null) {
                        if (!He6.eEe) {
                            He6.content = m(He6);
                        }
                        if (o(He6) && He6.getCommandChannelArray() != null && He6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(He6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.k(He6);
                        }
                    }
                    aqVar.ai("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Hf(7);
                    ShareItem He7 = He(7);
                    if (He7 != null) {
                        if (!He7.eEe) {
                            He7.content = m(He7);
                        }
                        gVar.l(He7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Hf(8);
                        ShareItem He8 = He(8);
                        a(He8, 9);
                        if (He8 != null) {
                            if (o(He8) && He8.getCommandChannelArray() != null && He8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(He8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.h(He8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bhm();
                    }
                    aqVar.ai("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.lTK = false;
                        return;
                    }
                    dismiss();
                    a(He, 17);
                    if (n.t(He.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, He.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = He.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new o(currentActivity, uri, new o.a() { // from class: com.baidu.tieba.sharesdk.d.c.5
                                @Override // com.baidu.tbadk.util.o.a
                                public void onError(int i2, String str) {
                                    l.showToast(c.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.o.a
                                public void onSuccess(String str) {
                                    l.showToast(c.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        } else {
                            return;
                        }
                    }
                    aqVar.ai("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(He, 10);
                    if (this.lTI != null) {
                        this.lTI.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(He.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(He);
                    if (He != null && He.eEe) {
                        bw(8, He.eEt);
                    }
                }
                aqVar.ai("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean o(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.eER) || TextUtils.isEmpty(shareItem.eES)) ? false : true;
    }

    private void p(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.zz(shareItem.title);
            aVar.zA(shareItem.content);
            aVar.setAutoNight(false);
            aVar.ig(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(c.this.mContext.getApplicationContext(), (int) R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.I(activity));
            aVar.bhg();
        }
    }

    private void n(ShareItem shareItem) {
        aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 7);
        if (shareItem.eEx != 0) {
            ai.ai("obj_param1", shareItem.eEx);
            if (shareItem.eEx == 2) {
                ai.dD("fid", shareItem.fid);
            } else if (shareItem.eEx == 3) {
                if (shareItem.eEB != 0) {
                    ai.ai("obj_type", shareItem.eEB);
                }
                ai.dD("tid", shareItem.tid).dD("fid", shareItem.fid);
            }
        }
        ai.ai("obj_locate", 9);
        TiebaStatic.log(ai);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem He(int i) {
        ShareItem shareItem = this.lTJ.get(i);
        if (shareItem == null) {
            return this.lTJ.get(1);
        }
        return shareItem;
    }

    private void Hf(int i) {
        if (i <= 8 && i > 0) {
            this.lTK = true;
            if (this.lTM != null) {
                ae aeVar = this.lTM.get(i);
                if (!StringUtils.isNull(aeVar.bmV()) && aeVar.bmW() != null && aeVar.bmW().size() > 0) {
                    h(aeVar.bmV(), aeVar.bmW());
                    return;
                }
            }
            if (this.lTL != null) {
                String str = this.lTL.get(i);
                if (!at.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bw(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i).ai("obj_source", shareItem.eEw));
                }
            } else if (shareItem.eEf) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("fid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eEw));
            } else if (shareItem.eEg || shareItem.eEj) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("tid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eEw).ai("obj_param1", shareItem.eEx).dD("fid", shareItem.fid).ai(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eEy));
            } else if (shareItem.eEh) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dD("tid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEe) {
                bw(i, shareItem.eEt);
            } else if (shareItem.eEi) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_param1", 7).ai("obj_type", i).dD("fid", shareItem.extData));
            } else if (shareItem.eEk) {
                aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i);
                ai.ai("obj_source", shareItem.eEw);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ai.ai("obj_param1", 9);
                    }
                    ai.dD(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ai);
            } else if (shareItem.eEm) {
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
                TiebaStatic.log(new aq("c13365").dD("obj_locate", str).dD("topic_id", shareItem.extData));
            } else if (shareItem.eEn) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dD("tid", shareItem.extData);
                aqVar.dD("pid", shareItem.pid);
                aqVar.ai("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.eEo) {
                aq aqVar2 = new aq("c13953");
                aqVar2.ai("obj_type", i);
                aqVar2.dD("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dsU() {
        ap.setBackgroundResource(this.jPO, R.drawable.transmit_share_dialog_background);
        ap.setViewTextColor(this.lTF, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lTE, R.color.cp_cont_j, 1);
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

    private boolean Hg(int i) {
        return (i & 1) > 0;
    }

    private boolean Hh(int i) {
        return (i & 2) > 0;
    }

    private boolean Hk(int i) {
        return (i & 4) > 0;
    }

    private boolean Hi(int i) {
        return (i & 8) > 0;
    }

    private boolean Hj(int i) {
        return (i & 16) > 0;
    }

    private boolean Hl(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        ad sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bmT() && !at.isEmpty(sharePanelConfData.getText())) {
            this.lTF.setText(sharePanelConfData.getText());
        }
    }
}
