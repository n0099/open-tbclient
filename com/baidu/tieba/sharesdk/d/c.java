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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes11.dex */
public class c implements View.OnClickListener {
    private int hideMode;
    private final TextView lur;
    private ShareGridLayout lut;
    private View.OnClickListener luv;
    private SparseArray<String> luy;
    private SparseArray<ab> luz;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int gmk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int gml = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int luo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lup = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int luq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eoo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> luw = new SparseArray<>(8);
    private boolean lux = false;
    private boolean luP = true;
    private int luQ = 0;
    private CustomMessageListener dPU = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dek();
                c.this.lut.removeAllViews();
                c.this.dej();
            }
        }
    };
    private final List<View> luu = new ArrayList();
    protected final View mRootView = cbm();
    protected final View jrJ = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView lus = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lus.setText(sharePanelText);
        }
        this.lut = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lut.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lTv;
            marginLayoutParams.rightMargin = ShareGridLayout.lTv;
            this.lut.setLayoutParams(marginLayoutParams);
        }
        this.lut.setItemParams(gmk, gml);
        this.lur = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lur.setOnClickListener(this);
    }

    protected View cbm() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void byy() {
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

    private void dem() {
        ArrayList arrayList = new ArrayList(this.luu);
        this.luu.clear();
        if (!En(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Eo(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Ep(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Er(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Eq(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Es(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.luu.addAll(arrayList);
        }
        if (this.luP) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.dQO));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.aXq().lG(1).lH(R.color.cp_bg_line_i).aR(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(luo, luo);
            layoutParams.topMargin = lup;
            layoutParams.bottomMargin = luq;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eoo);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            an.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.luu.add(linearLayout);
        }
    }

    public LinearLayout cY(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(luo, luo);
        layoutParams.topMargin = lup;
        layoutParams.bottomMargin = luq;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eoo);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (an.getDrawable(i2) instanceof BitmapDrawable) {
            an.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aXq().lG(1).lH(R.color.cp_bg_line_i).aR(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        an.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int dei() {
        if (this.luu == null) {
            return 0;
        }
        return this.luu.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.luu.size() && i >= 0) {
            this.luu.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener luB;

        public a(View.OnClickListener onClickListener) {
            this.luB = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.luB != null) {
                this.luB.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.luP = z;
    }

    public void setCustomCopyTitle(int i) {
        this.luQ = i;
    }

    public void f(SparseArray<String> sparseArray) {
        this.luy = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bPK;
        if (z && (bPK = bPK()) != null) {
            shareItem.location = bPK;
        }
        this.luw.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.enB)) {
            this.lus.setText(shareItem.enB);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location bPK;
        if (z && (bPK = bPK()) != null) {
            shareItem.location = bPK;
        }
        this.luw.put(i, shareItem);
    }

    private Location bPK() {
        if (ac.checkLocationForGoogle(this.mContext)) {
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
            this.luv = onClickListener;
        }
    }

    public void dej() {
        dem();
        if (!f.bdk()) {
            this.lut.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.luu.size()) {
                this.lut.addView(this.luu.get(i2), new ViewGroup.LayoutParams(gmk, gml));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.bdk()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dej();
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
                g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            an.setBackgroundResource(this.jrJ, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                a(window);
                window.setContentView(this.mRootView);
                dek();
                byy();
                i.G(this.mContext).registerListener(this.dPU);
            }
        }
    }

    protected void a(Window window) {
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
            this.lux = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.dPU);
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
        if (this.luw.size() != 0) {
            if (id == R.id.btnShareCancel || !this.lux) {
                this.lux = true;
                ShareItem El = El(1);
                f fVar = new f(this.mContext, null);
                if (El != null && El.enW) {
                    TiebaStatic.log(new ao("c13531").dk("obj_id", El.enX).ag("obj_type", El.enY).dk("obj_source", El.enZ));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (El != null && El.enw) {
                        a(El, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                        return;
                    }
                    return;
                }
                ao aoVar = new ao("c13724");
                if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    Em(3);
                    ShareItem El2 = El(3);
                    a(El2, 4);
                    if (El2 != null) {
                        if (El2.enU == 1) {
                            o(El2);
                        } else {
                            fVar.f(El2);
                        }
                    }
                    aoVar.ag("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Em(2);
                    ShareItem El3 = El(2);
                    a(El3, 3);
                    if (El3 != null) {
                        if (El3.enU == 1) {
                            o(El3);
                        } else {
                            if (El3.enq) {
                                El3.content = "【" + El3.title + "】 " + El3.content;
                            }
                            fVar.g(El3);
                        }
                    }
                    aoVar.ag("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Em(4);
                        ShareItem El4 = El(4);
                        a(El4, 5);
                        if (El4 != null) {
                            fVar.i(El4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aUS();
                    }
                    aoVar.ag("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Em(5);
                    ShareItem El5 = El(5);
                    if (El5 != null) {
                        if (!El5.enp) {
                            El5.content = m(El5);
                        }
                        fVar.j(El5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Em(6);
                    ShareItem El6 = El(6);
                    a(El6, 7);
                    if (El6 != null) {
                        if (!El6.enp) {
                            El6.content = m(El6);
                        }
                        fVar.k(El6);
                    }
                    aoVar.ag("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Em(7);
                    ShareItem El7 = El(7);
                    if (El7 != null) {
                        if (!El7.enp) {
                            El7.content = m(El7);
                        }
                        fVar.l(El7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Em(8);
                        ShareItem El8 = El(8);
                        a(El8, 9);
                        if (El8 != null) {
                            fVar.h(El8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aUS();
                    }
                    aoVar.ag("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.lux = false;
                        return;
                    }
                    dismiss();
                    a(El, 17);
                    if (n.t(El.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, El.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = El.imageUri.toString();
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
                    aoVar.ag("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(El, 10);
                    if (this.luv != null) {
                        this.luv.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(El.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(El);
                    if (El != null && El.enp) {
                        by(8, El.enD);
                    }
                }
                aoVar.ag("obj_source", 6);
                TiebaStatic.log(aoVar);
            }
        }
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.wd(shareItem.title);
            aVar.we(shareItem.content);
            aVar.setAutoNight(false);
            aVar.hf(true);
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
            }).b(i.G(activity));
            aVar.aUN();
        }
    }

    private void n(ShareItem shareItem) {
        ao ag = new ao(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 7);
        if (shareItem.enH != 0) {
            ag.ag("obj_param1", shareItem.enH);
            if (shareItem.enH == 2) {
                ag.dk("fid", shareItem.fid);
            } else if (shareItem.enH == 3) {
                if (shareItem.enL != 0) {
                    ag.ag("obj_type", shareItem.enL);
                }
                ag.dk("tid", shareItem.tid).dk("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem El(int i) {
        ShareItem shareItem = this.luw.get(i);
        if (shareItem == null) {
            return this.luw.get(1);
        }
        return shareItem;
    }

    private void Em(int i) {
        if (i <= 8 && i > 0) {
            this.lux = true;
            if (this.luz != null) {
                ab abVar = this.luz.get(i);
                if (!StringUtils.isNull(abVar.bao()) && abVar.bap() != null && abVar.bap().size() > 0) {
                    h(abVar.bao(), abVar.bap());
                    return;
                }
            }
            if (this.luy != null) {
                String str = this.luy.get(i);
                if (!ar.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void by(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i).ag("obj_source", shareItem.enG));
                }
            } else if (shareItem.enq) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("fid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.enG));
            } else if (shareItem.enr || shareItem.enu) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("tid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.enG).ag("obj_param1", shareItem.enH).dk("fid", shareItem.fid).ag(TiebaInitialize.Params.OBJ_PARAM2, shareItem.enI));
            } else if (shareItem.ens) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dk("tid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.enp) {
                by(i, shareItem.enD);
            } else if (shareItem.ent) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_param1", 7).ag("obj_type", i).dk("fid", shareItem.extData));
            } else if (shareItem.enw) {
                ao ag = new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i);
                ag.ag("obj_source", shareItem.enG);
                if (!ar.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ag.ag("obj_param1", 9);
                    }
                    ag.dk(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ag);
            } else if (shareItem.eny) {
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
                TiebaStatic.log(new ao("c13365").dk("obj_locate", str).dk("topic_id", shareItem.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dek() {
        an.setBackgroundResource(this.jrJ, R.drawable.transmit_share_dialog_background);
        an.setViewTextColor(this.lus, R.color.cp_cont_c, 1);
        an.setViewTextColor(this.lur, R.color.cp_cont_j, 1);
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

    private boolean En(int i) {
        return (i & 1) > 0;
    }

    private boolean Eo(int i) {
        return (i & 2) > 0;
    }

    private boolean Er(int i) {
        return (i & 4) > 0;
    }

    private boolean Ep(int i) {
        return (i & 8) > 0;
    }

    private boolean Eq(int i) {
        return (i & 16) > 0;
    }

    private boolean Es(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        aa sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bam() && !ar.isEmpty(sharePanelConfData.getText())) {
            this.lus.setText(sharePanelConfData.getText());
        }
    }
}
