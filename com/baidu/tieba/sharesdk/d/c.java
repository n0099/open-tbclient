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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes18.dex */
public class c implements View.OnClickListener {
    private int hideMode;
    private final TextView lBK;
    private ShareGridLayout lBM;
    private View.OnClickListener lBO;
    private SparseArray<String> lBR;
    private SparseArray<ab> lBS;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int gri = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int grj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lBH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lBI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lBJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int euD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> lBP = new SparseArray<>(8);
    private boolean lBQ = false;
    private boolean lCi = true;
    private int lCj = 0;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dht();
                c.this.lBM.removeAllViews();
                c.this.dhs();
            }
        }
    };
    private final List<View> lBN = new ArrayList();
    protected final View mRootView = ceK();
    protected final View jAo = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView lBL = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lBL.setText(sharePanelText);
        }
        this.lBM = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lBM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.maN;
            marginLayoutParams.rightMargin = ShareGridLayout.maN;
            this.lBM.setLayoutParams(marginLayoutParams);
        }
        this.lBM.setItemParams(gri, grj);
        this.lBK = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lBK.setOnClickListener(this);
    }

    protected View ceK() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bBM() {
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

    private void dhv() {
        ArrayList arrayList = new ArrayList(this.lBN);
        this.lBN.clear();
        if (!EJ(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!EK(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!EL(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!EN(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!EM(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (EO(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.lBN.addAll(arrayList);
        }
        if (this.lCi) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.dXg));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bbr().ma(1).mb(R.color.cp_bg_line_i).aX(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lBH, lBH);
            layoutParams.topMargin = lBI;
            layoutParams.bottomMargin = lBJ;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, euD);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ao.setViewTextColor(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.lBN.add(linearLayout);
        }
    }

    public LinearLayout da(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lBH, lBH);
        layoutParams.topMargin = lBI;
        layoutParams.bottomMargin = lBJ;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, euD);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (ao.getDrawable(i2) instanceof BitmapDrawable) {
            ao.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bbr().ma(1).mb(R.color.cp_bg_line_i).aX(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        ao.setViewTextColor(textView, R.color.cp_cont_f);
        return linearLayout;
    }

    public int dhr() {
        if (this.lBN == null) {
            return 0;
        }
        return this.lBN.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.lBN.size() && i >= 0) {
            this.lBN.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener lBU;

        public a(View.OnClickListener onClickListener) {
            this.lBU = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.lBU != null) {
                this.lBU.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.lCi = z;
    }

    public void setCustomCopyTitle(int i) {
        this.lCj = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.lBR = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bSV;
        if (z && (bSV = bSV()) != null) {
            shareItem.location = bSV;
        }
        this.lBP.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.etN)) {
            this.lBL.setText(shareItem.etN);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location bSV;
        if (z && (bSV = bSV()) != null) {
            shareItem.location = bSV;
        }
        this.lBP.put(i, shareItem);
    }

    private Location bSV() {
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
            this.lBO = onClickListener;
        }
    }

    public void dhs() {
        dhv();
        if (!g.bgR()) {
            this.lBM.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lBN.size()) {
                this.lBM.addView(this.lBN.get(i2), new ViewGroup.LayoutParams(gri, grj));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bgR()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dhs();
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
            ao.setBackgroundResource(this.jAo, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                dht();
                bBM();
                i.G(this.mContext).registerListener(this.skinChangeListener);
            }
        }
    }

    protected void b(Window window) {
        window.setLayout(-1, -2);
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void f(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.lBQ = false;
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
        if (this.lBP.size() != 0) {
            if (id == R.id.btnShareCancel || !this.lBQ) {
                this.lBQ = true;
                ShareItem EH = EH(1);
                g gVar = new g(this.mContext, null);
                if (EH != null && EH.eui) {
                    TiebaStatic.log(new ap("c13531").dn("obj_id", EH.euj).ah("obj_type", EH.euk).dn("obj_source", EH.eul));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (EH != null && EH.etI) {
                        a(EH, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                        return;
                    }
                    return;
                }
                ap apVar = new ap("c13724");
                if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    EI(3);
                    ShareItem EH2 = EH(3);
                    a(EH2, 4);
                    if (EH2 != null) {
                        if (o(EH2) && EH2.getCommandChannelArray() != null && EH2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(EH2, this.mContext, 3);
                        } else if (EH2.eug == 1) {
                            p(EH2);
                        } else {
                            gVar.f(EH2);
                        }
                    }
                    apVar.ah("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    EI(2);
                    ShareItem EH3 = EH(2);
                    a(EH3, 3);
                    if (EH3 != null) {
                        if (o(EH3) && EH3.getCommandChannelArray() != null && EH3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(EH3, this.mContext, 2);
                        } else if (EH3.eug == 1) {
                            p(EH3);
                        } else {
                            if (EH3.etD) {
                                EH3.content = "【" + EH3.title + "】 " + EH3.content;
                            }
                            gVar.g(EH3);
                        }
                    }
                    apVar.ah("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        EI(4);
                        ShareItem EH4 = EH(4);
                        a(EH4, 5);
                        if (EH4 != null) {
                            if (o(EH4) && EH4.getCommandChannelArray() != null && EH4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(EH4, this.mContext, 4);
                            } else {
                                gVar.i(EH4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
                    }
                    apVar.ah("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    EI(5);
                    ShareItem EH5 = EH(5);
                    if (EH5 != null) {
                        if (!EH5.etC) {
                            EH5.content = m(EH5);
                        }
                        gVar.j(EH5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    EI(6);
                    ShareItem EH6 = EH(6);
                    a(EH6, 7);
                    if (EH6 != null) {
                        if (!EH6.etC) {
                            EH6.content = m(EH6);
                        }
                        if (o(EH6) && EH6.getCommandChannelArray() != null && EH6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(EH6, this.mContext, 6);
                        } else {
                            gVar.k(EH6);
                        }
                    }
                    apVar.ah("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    EI(7);
                    ShareItem EH7 = EH(7);
                    if (EH7 != null) {
                        if (!EH7.etC) {
                            EH7.content = m(EH7);
                        }
                        gVar.l(EH7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        EI(8);
                        ShareItem EH8 = EH(8);
                        a(EH8, 9);
                        if (EH8 != null) {
                            if (o(EH8) && EH8.getCommandChannelArray() != null && EH8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(EH8, this.mContext, 8);
                            } else {
                                gVar.h(EH8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
                    }
                    apVar.ah("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.lBQ = false;
                        return;
                    }
                    dismiss();
                    a(EH, 17);
                    if (n.t(EH.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, EH.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = EH.imageUri.toString();
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
                    apVar.ah("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(EH, 10);
                    if (this.lBO != null) {
                        this.lBO.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(EH.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(EH);
                    if (EH != null && EH.etC) {
                        bz(8, EH.etP);
                    }
                }
                apVar.ah("obj_source", 6);
                TiebaStatic.log(apVar);
            }
        }
    }

    private boolean o(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.eun) || TextUtils.isEmpty(shareItem.euo)) ? false : true;
    }

    private void p(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.xk(shareItem.title);
            aVar.xl(shareItem.content);
            aVar.setAutoNight(false);
            aVar.hJ(true);
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
            }).b(i.G(activity));
            aVar.aYL();
        }
    }

    private void n(ShareItem shareItem) {
        ap ah = new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ah("obj_source", 7);
        if (shareItem.etT != 0) {
            ah.ah("obj_param1", shareItem.etT);
            if (shareItem.etT == 2) {
                ah.dn("fid", shareItem.fid);
            } else if (shareItem.etT == 3) {
                if (shareItem.etX != 0) {
                    ah.ah("obj_type", shareItem.etX);
                }
                ah.dn("tid", shareItem.tid).dn("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ah);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem EH(int i) {
        ShareItem shareItem = this.lBP.get(i);
        if (shareItem == null) {
            return this.lBP.get(1);
        }
        return shareItem;
    }

    private void EI(int i) {
        if (i <= 8 && i > 0) {
            this.lBQ = true;
            if (this.lBS != null) {
                ab abVar = this.lBS.get(i);
                if (!StringUtils.isNull(abVar.bel()) && abVar.bem() != null && abVar.bem().size() > 0) {
                    h(abVar.bel(), abVar.bem());
                    return;
                }
            }
            if (this.lBR != null) {
                String str = this.lBR.get(i);
                if (!as.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bz(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_type", i).ah("obj_source", shareItem.etS));
                }
            } else if (shareItem.etD) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("fid", shareItem.extData).ah("obj_type", i).ah("obj_source", shareItem.etS));
            } else if (shareItem.etE || shareItem.etH) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("tid", shareItem.extData).ah("obj_type", i).ah("obj_source", shareItem.etS).ah("obj_param1", shareItem.etT).dn("fid", shareItem.fid).ah(TiebaInitialize.Params.OBJ_PARAM2, shareItem.etU));
            } else if (shareItem.etF) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dn("tid", shareItem.extData).ah("obj_type", i));
            } else if (shareItem.etC) {
                bz(i, shareItem.etP);
            } else if (shareItem.etG) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_param1", 7).ah("obj_type", i).dn("fid", shareItem.extData));
            } else if (shareItem.etI) {
                ap ah = new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_type", i);
                ah.ah("obj_source", shareItem.etS);
                if (!as.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ah.ah("obj_param1", 9);
                    }
                    ah.dn(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ah);
            } else if (shareItem.etK) {
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
                TiebaStatic.log(new ap("c13365").dn("obj_locate", str).dn("topic_id", shareItem.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dht() {
        ao.setBackgroundResource(this.jAo, R.drawable.transmit_share_dialog_background);
        ao.setViewTextColor(this.lBL, R.color.cp_cont_c, 1);
        ao.setViewTextColor(this.lBK, R.color.cp_cont_j, 1);
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

    private boolean EJ(int i) {
        return (i & 1) > 0;
    }

    private boolean EK(int i) {
        return (i & 2) > 0;
    }

    private boolean EN(int i) {
        return (i & 4) > 0;
    }

    private boolean EL(int i) {
        return (i & 8) > 0;
    }

    private boolean EM(int i) {
        return (i & 16) > 0;
    }

    private boolean EO(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        aa sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bej() && !as.isEmpty(sharePanelConfData.getText())) {
            this.lBL.setText(sharePanelConfData.getText());
        }
    }
}
