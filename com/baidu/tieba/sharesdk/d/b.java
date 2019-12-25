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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.e.c;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private View.OnClickListener jRA;
    private SparseArray<String> jRD;
    private SparseArray<w> jRE;
    private final TextView jRw;
    private ShareGridLayout jRy;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int fab = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fac = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jRt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jRu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jRv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dmj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jRB = new SparseArray<>(8);
    private boolean jRC = false;
    private boolean jRH = true;
    private int jRI = 0;
    private CustomMessageListener cRt = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.cEX();
                b.this.jRy.removeAllViews();
                b.this.cEW();
            }
        }
    };
    private final List<View> jRz = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView jRx = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jRx.setText(sharePanelText);
        }
        this.jRy = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jRy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.kpk;
            marginLayoutParams.rightMargin = ShareGridLayout.kpk;
            this.jRy.setLayoutParams(marginLayoutParams);
        }
        this.jRy.setItemParams(fab, fac);
        this.jRw = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jRw.setOnClickListener(this);
    }

    private void bdH() {
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

    private void cEY() {
        ArrayList arrayList = new ArrayList(this.jRz);
        this.jRz.clear();
        if (!BF(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!BG(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!BH(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!BJ(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!BI(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (BK(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.jRz.addAll(arrayList);
        }
        if (this.jRH) {
            a(R.string.share_copy, new c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.cSe));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof c) {
                com.baidu.tbadk.core.util.f.a.aEt().kk(1).kl(R.color.cp_bg_line_i).aM(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jRt, jRt);
            layoutParams.topMargin = jRu;
            layoutParams.bottomMargin = jRv;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dmj);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.jRz.add(linearLayout);
        }
    }

    public LinearLayout cF(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jRt, jRt);
        layoutParams.topMargin = jRu;
        layoutParams.bottomMargin = jRv;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dmj);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        c cVar = new c(i2, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.f.a.aEt().kk(1).kl(R.color.cp_bg_line_i).aM(imageView);
        imageView.setImageDrawable(cVar.getDrawable());
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int cEV() {
        if (this.jRz == null) {
            return 0;
        }
        return this.jRz.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jRz.size() && i >= 0) {
            this.jRz.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener jRG;

        public a(View.OnClickListener onClickListener) {
            this.jRG = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.jRG != null) {
                this.jRG.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.jRH = z;
    }

    public void setCustomCopyTitle(int i) {
        this.jRI = i;
    }

    public void e(SparseArray<String> sparseArray) {
        this.jRD = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location btK;
        if (z && (btK = btK()) != null) {
            shareItem.location = btK;
        }
        this.jRB.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.dlz)) {
            this.jRx.setText(shareItem.dlz);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location btK;
        if (z && (btK = btK()) != null) {
            shareItem.location = btK;
        }
        this.jRB.put(i, shareItem);
    }

    private Location btK() {
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
            this.jRA = onClickListener;
        }
    }

    public void cEW() {
        cEY();
        if (!e.aJF()) {
            this.jRy.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jRz.size()) {
                this.jRy.addView(this.jRz.get(i2), new ViewGroup.LayoutParams(fab, fac));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!e.aJF()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cEW();
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
                cEX();
                bdH();
                i.ab(this.mContext).registerListener(this.cRt);
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
            this.jRC = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.cRt);
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
        if (this.jRB.size() != 0) {
            if (id == R.id.btnShareCancel || !this.jRC) {
                this.jRC = true;
                ShareItem BD = BD(1);
                e eVar = new e(this.mContext, null);
                if (BD != null && BD.dlU) {
                    TiebaStatic.log(new an("c13531").cp("obj_id", BD.dlV).Z("obj_type", BD.dlW).cp("obj_source", BD.dlX));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (BD != null && BD.dlu) {
                        a(BD, 16);
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
                    BE(3);
                    ShareItem BD2 = BD(3);
                    a(BD2, 4);
                    if (BD2 != null) {
                        if (BD2.dlS == 1) {
                            o(BD2);
                        } else {
                            eVar.e(BD2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BE(2);
                    ShareItem BD3 = BD(2);
                    a(BD3, 3);
                    if (BD3 != null) {
                        if (BD3.dlS == 1) {
                            o(BD3);
                            return;
                        }
                        if (BD3.dlp) {
                            BD3.content = "【" + BD3.title + "】 " + BD3.content;
                        }
                        eVar.f(BD3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        BE(4);
                        ShareItem BD4 = BD(4);
                        a(BD4, 5);
                        if (BD4 != null) {
                            eVar.h(BD4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCb();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    BE(5);
                    ShareItem BD5 = BD(5);
                    a(BD5, 6);
                    if (BD5 != null) {
                        if (!BD5.dlo) {
                            BD5.content = m(BD5);
                        }
                        eVar.i(BD5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BE(6);
                    ShareItem BD6 = BD(6);
                    a(BD6, 7);
                    if (BD6 != null) {
                        if (!BD6.dlo) {
                            BD6.content = m(BD6);
                        }
                        eVar.j(BD6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    BE(7);
                    ShareItem BD7 = BD(7);
                    a(BD7, 8);
                    if (BD7 != null) {
                        if (!BD7.dlo) {
                            BD7.content = m(BD7);
                        }
                        eVar.k(BD7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        BE(8);
                        ShareItem BD8 = BD(8);
                        a(BD8, 9);
                        if (BD8 != null) {
                            eVar.g(BD8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCb();
                    }
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        a(BD, 17);
                        String uri = BD.imageUri.toString();
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
                    a(BD, 10);
                    if (this.jRA != null) {
                        this.jRA.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BD.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BD);
                    if (BD != null && BD.dlo) {
                        aT(8, BD.dlB);
                    }
                }
            }
        }
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.sy(shareItem.title);
            aVar.sz(shareItem.content);
            aVar.setAutoNight(false);
            aVar.fu(true);
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
            aVar.aBW();
        }
    }

    private void n(ShareItem shareItem) {
        an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 7);
        if (shareItem.dlF != 0) {
            Z.Z("obj_param1", shareItem.dlF);
            if (shareItem.dlF == 2) {
                Z.cp("fid", shareItem.fid);
            } else if (shareItem.dlF == 3) {
                if (shareItem.dlJ != 0) {
                    Z.Z("obj_type", shareItem.dlJ);
                }
                Z.cp("tid", shareItem.tid).cp("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(Z);
    }

    private ShareItem BD(int i) {
        ShareItem shareItem = this.jRB.get(i);
        if (shareItem == null) {
            return this.jRB.get(1);
        }
        return shareItem;
    }

    private void BE(int i) {
        if (i <= 8 && i > 0) {
            this.jRC = true;
            if (this.jRE != null) {
                w wVar = this.jRE.get(i);
                if (!StringUtils.isNull(wVar.aGN()) && wVar.aGO() != null && wVar.aGO().size() > 0) {
                    h(wVar.aGN(), wVar.aGO());
                    return;
                }
            }
            if (this.jRD != null) {
                String str = this.jRD.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aT(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dlp) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlq || shareItem.dlt) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).Z("obj_type", i).Z("obj_source", shareItem.dlE).Z("obj_param1", shareItem.dlF).cp("fid", shareItem.fid));
            } else if (shareItem.dlr) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cp("tid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlo) {
                aT(i, shareItem.dlB);
            } else if (shareItem.dls) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_param1", 7).Z("obj_type", i).cp("fid", shareItem.extData));
            } else if (shareItem.dlu) {
                an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        Z.Z("obj_param1", 9);
                    }
                    Z.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(Z);
            } else if (shareItem.dlw) {
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
    public void cEX() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.jRx, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jRw, R.color.cp_cont_j, 1);
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

    private boolean BF(int i) {
        return (i & 1) > 0;
    }

    private boolean BG(int i) {
        return (i & 2) > 0;
    }

    private boolean BJ(int i) {
        return (i & 4) > 0;
    }

    private boolean BH(int i) {
        return (i & 8) > 0;
    }

    private boolean BI(int i) {
        return (i & 16) > 0;
    }

    private boolean BK(int i) {
        return (i & 32) > 0;
    }
}
