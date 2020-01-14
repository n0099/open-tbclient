package com.baidu.tieba.sharesdk.d;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.e.c;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private final TextView jVe;
    private ShareGridLayout jVg;
    private View.OnClickListener jVi;
    private SparseArray<String> jVl;
    private SparseArray<x> jVm;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int fcP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fcQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jVb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jVc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jVd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dmx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jVj = new SparseArray<>(8);
    private boolean jVk = false;
    private boolean jVp = true;
    private int jVq = 0;
    private CustomMessageListener cRD = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.cGd();
                b.this.jVg.removeAllViews();
                b.this.cGc();
            }
        }
    };
    private final List<View> jVh = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView jVf = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jVf.setText(sharePanelText);
        }
        this.jVg = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jVg.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.ksS;
            marginLayoutParams.rightMargin = ShareGridLayout.ksS;
            this.jVg.setLayoutParams(marginLayoutParams);
        }
        this.jVg.setItemParams(fcP, fcQ);
        this.jVe = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jVe.setOnClickListener(this);
    }

    private void bec() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (b.this.mDialog != null && b.this.mDialog.isShowing()) {
                    b.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void cGe() {
        ArrayList arrayList = new ArrayList(this.jVh);
        this.jVh.clear();
        if (!BK(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!BL(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!BM(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!BO(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!BN(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (BP(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.jVh.addAll(arrayList);
        }
        if (this.jVp) {
            a(R.string.share_copy, new c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.cSo));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof c) {
                com.baidu.tbadk.core.util.f.a.aEM().kk(1).kl(R.color.cp_bg_line_i).aQ(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jVb, jVb);
            layoutParams.topMargin = jVc;
            layoutParams.bottomMargin = jVd;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dmx);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.jVh.add(linearLayout);
        }
    }

    public LinearLayout cE(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jVb, jVb);
        layoutParams.topMargin = jVc;
        layoutParams.bottomMargin = jVd;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dmx);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        c cVar = new c(i2, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.f.a.aEM().kk(1).kl(R.color.cp_bg_line_i).aQ(imageView);
        imageView.setImageDrawable(cVar.getDrawable());
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int cGb() {
        if (this.jVh == null) {
            return 0;
        }
        return this.jVh.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jVh.size() && i >= 0) {
            this.jVh.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener jVo;

        public a(View.OnClickListener onClickListener) {
            this.jVo = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.jVo != null) {
                this.jVo.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.jVp = z;
    }

    public void setCustomCopyTitle(int i) {
        this.jVq = i;
    }

    public void e(SparseArray<String> sparseArray) {
        this.jVl = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location buM;
        if (z && (buM = buM()) != null) {
            shareItem.location = buM;
        }
        this.jVj.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.dlP)) {
            this.jVf.setText(shareItem.dlP);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location buM;
        if (z && (buM = buM()) != null) {
            shareItem.location = buM;
        }
        this.jVj.put(i, shareItem);
    }

    private Location buM() {
        if (ab.checkLocationForGoogle(this.mContext)) {
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
            this.jVi = onClickListener;
        }
    }

    public void cGc() {
        cGe();
        if (!e.aJZ()) {
            this.jVg.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jVh.size()) {
                this.jVg.addView(this.jVh.get(i2), new ViewGroup.LayoutParams(fcP, fcQ));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!e.aJZ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cGc();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (b.this.onCancelListener != null) {
                        b.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.mRootView);
                cGd();
                bec();
                i.ab(this.mContext).registerListener(this.cRD);
            }
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void g(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jVk = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.cRD);
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
        dismiss();
        if (this.jVj.size() != 0) {
            if (id == R.id.btnShareCancel || !this.jVk) {
                this.jVk = true;
                ShareItem BI = BI(1);
                e eVar = new e(this.mContext, null);
                if (BI != null && BI.dmk) {
                    TiebaStatic.log(new an("c13531").cp("obj_id", BI.dml).Z("obj_type", BI.dmm).cp("obj_source", BI.dmn));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (BI != null && BI.dlK) {
                        a(BI, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                    }
                } else if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    BJ(3);
                    ShareItem BI2 = BI(3);
                    a(BI2, 4);
                    if (BI2 != null) {
                        if (BI2.dmi == 1) {
                            o(BI2);
                        } else {
                            eVar.e(BI2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BJ(2);
                    ShareItem BI3 = BI(2);
                    a(BI3, 3);
                    if (BI3 != null) {
                        if (BI3.dmi == 1) {
                            o(BI3);
                            return;
                        }
                        if (BI3.dlF) {
                            BI3.content = "【" + BI3.title + "】 " + BI3.content;
                        }
                        eVar.f(BI3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        BJ(4);
                        ShareItem BI4 = BI(4);
                        a(BI4, 5);
                        if (BI4 != null) {
                            eVar.h(BI4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCu();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    BJ(5);
                    ShareItem BI5 = BI(5);
                    a(BI5, 6);
                    if (BI5 != null) {
                        if (!BI5.dlE) {
                            BI5.content = m(BI5);
                        }
                        eVar.i(BI5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BJ(6);
                    ShareItem BI6 = BI(6);
                    a(BI6, 7);
                    if (BI6 != null) {
                        if (!BI6.dlE) {
                            BI6.content = m(BI6);
                        }
                        eVar.j(BI6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    BJ(7);
                    ShareItem BI7 = BI(7);
                    a(BI7, 8);
                    if (BI7 != null) {
                        if (!BI7.dlE) {
                            BI7.content = m(BI7);
                        }
                        eVar.k(BI7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        BJ(8);
                        ShareItem BI8 = BI(8);
                        a(BI8, 9);
                        if (BI8 != null) {
                            eVar.g(BI8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCu();
                    }
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        a(BI, 17);
                        String uri = BI.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new o(currentActivity, uri, new o.a() { // from class: com.baidu.tieba.sharesdk.d.b.5
                                @Override // com.baidu.tbadk.util.o.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.o.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(BI, 10);
                    if (this.jVi != null) {
                        this.jVi.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BI.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BI);
                    if (BI != null && BI.dlE) {
                        aZ(8, BI.dlR);
                    }
                }
            }
        }
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.sB(shareItem.title);
            aVar.sC(shareItem.content);
            aVar.setAutoNight(false);
            aVar.fz(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(b.this.mContext.getApplicationContext(), (int) R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.ab(activity));
            aVar.aCp();
        }
    }

    private void n(ShareItem shareItem) {
        an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 7);
        if (shareItem.dlV != 0) {
            Z.Z("obj_param1", shareItem.dlV);
            if (shareItem.dlV == 2) {
                Z.cp("fid", shareItem.fid);
            } else if (shareItem.dlV == 3) {
                if (shareItem.dlZ != 0) {
                    Z.Z("obj_type", shareItem.dlZ);
                }
                Z.cp("tid", shareItem.tid).cp("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(Z);
    }

    private ShareItem BI(int i) {
        ShareItem shareItem = this.jVj.get(i);
        if (shareItem == null) {
            return this.jVj.get(1);
        }
        return shareItem;
    }

    private void BJ(int i) {
        if (i <= 8 && i > 0) {
            this.jVk = true;
            if (this.jVm != null) {
                x xVar = this.jVm.get(i);
                if (!StringUtils.isNull(xVar.aHh()) && xVar.aHi() != null && xVar.aHi().size() > 0) {
                    h(xVar.aHh(), xVar.aHi());
                    return;
                }
            }
            if (this.jVl != null) {
                String str = this.jVl.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aZ(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dlF) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlG || shareItem.dlJ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).Z("obj_type", i).Z("obj_source", shareItem.dlU).Z("obj_param1", shareItem.dlV).cp("fid", shareItem.fid));
            } else if (shareItem.dlH) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cp("tid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlE) {
                aZ(i, shareItem.dlR);
            } else if (shareItem.dlI) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_param1", 7).Z("obj_type", i).cp("fid", shareItem.extData));
            } else if (shareItem.dlK) {
                an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        Z.Z("obj_param1", 9);
                    }
                    Z.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(Z);
            } else if (shareItem.dlM) {
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
                TiebaStatic.log(new an("c13365").cp("obj_locate", str).cp("topic_id", shareItem.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void cGd() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.jVf, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jVe, R.color.cp_cont_j, 1);
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

    private boolean BK(int i) {
        return (i & 1) > 0;
    }

    private boolean BL(int i) {
        return (i & 2) > 0;
    }

    private boolean BO(int i) {
        return (i & 4) > 0;
    }

    private boolean BM(int i) {
        return (i & 8) > 0;
    }

    private boolean BN(int i) {
        return (i & 16) > 0;
    }

    private boolean BP(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.w sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aHg() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.jVf.setText(sharePanelConfData.getText());
        }
    }
}
