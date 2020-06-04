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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.coreExtra.data.z;
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
    private SparseArray<String> laB;
    private SparseArray<z> laC;
    private final TextView lau;
    private ShareGridLayout law;
    private View.OnClickListener lay;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int fZl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fZm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int laq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lar = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int las = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int efC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> laz = new SparseArray<>(8);
    private boolean laA = false;
    private boolean laS = true;
    private int laT = 0;
    private CustomMessageListener dJe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.cZT();
                c.this.law.removeAllViews();
                c.this.cZS();
            }
        }
    };
    private final List<View> lax = new ArrayList();
    protected final View mRootView = bXX();
    protected final View jaz = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView lav = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lav.setText(sharePanelText);
        }
        this.law = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.law.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lzN;
            marginLayoutParams.rightMargin = ShareGridLayout.lzN;
            this.law.setLayoutParams(marginLayoutParams);
        }
        this.law.setItemParams(fZl, fZm);
        this.lau = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lau.setOnClickListener(this);
    }

    protected View bXX() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bvC() {
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

    private void cZV() {
        ArrayList arrayList = new ArrayList(this.lax);
        this.lax.clear();
        if (!Dl(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Dm(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Dn(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Dp(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Do(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Dq(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.lax.addAll(arrayList);
        }
        if (this.laS) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.dJY));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.aVw().lp(1).lq(R.color.cp_bg_line_i).aR(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(laq, laq);
            layoutParams.topMargin = lar;
            layoutParams.bottomMargin = las;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, efC);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.lax.add(linearLayout);
        }
    }

    public LinearLayout cS(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(laq, laq);
        layoutParams.topMargin = lar;
        layoutParams.bottomMargin = las;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, efC);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (am.getDrawable(i2) instanceof BitmapDrawable) {
            am.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aVw().lp(1).lq(R.color.cp_bg_line_i).aR(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int cZR() {
        if (this.lax == null) {
            return 0;
        }
        return this.lax.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.lax.size() && i >= 0) {
            this.lax.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener laE;

        public a(View.OnClickListener onClickListener) {
            this.laE = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.laE != null) {
                this.laE.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.laS = z;
    }

    public void setCustomCopyTitle(int i) {
        this.laT = i;
    }

    public void f(SparseArray<String> sparseArray) {
        this.laB = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bME;
        if (z && (bME = bME()) != null) {
            shareItem.location = bME;
        }
        this.laz.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.eeQ)) {
            this.lav.setText(shareItem.eeQ);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location bME;
        if (z && (bME = bME()) != null) {
            shareItem.location = bME;
        }
        this.laz.put(i, shareItem);
    }

    private Location bME() {
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
            this.lay = onClickListener;
        }
    }

    public void cZS() {
        cZV();
        if (!f.bbi()) {
            this.law.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lax.size()) {
                this.law.addView(this.lax.get(i2), new ViewGroup.LayoutParams(fZl, fZm));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.bbi()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cZS();
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
            am.setBackgroundResource(this.jaz, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                a(window);
                window.setContentView(this.mRootView);
                cZT();
                bvC();
                i.G(this.mContext).registerListener(this.dJe);
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
            this.laA = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.dJe);
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
        if (this.laz.size() != 0) {
            if (id == R.id.btnShareCancel || !this.laA) {
                this.laA = true;
                ShareItem Dj = Dj(1);
                f fVar = new f(this.mContext, null);
                if (Dj != null && Dj.efl) {
                    TiebaStatic.log(new an("c13531").dh("obj_id", Dj.efm).ag("obj_type", Dj.efn).dh("obj_source", Dj.efo));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (Dj != null && Dj.eeL) {
                        a(Dj, 16);
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
                    Dk(3);
                    ShareItem Dj2 = Dj(3);
                    a(Dj2, 4);
                    if (Dj2 != null) {
                        if (Dj2.efj == 1) {
                            o(Dj2);
                        } else {
                            fVar.e(Dj2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Dk(2);
                    ShareItem Dj3 = Dj(2);
                    a(Dj3, 3);
                    if (Dj3 != null) {
                        if (Dj3.efj == 1) {
                            o(Dj3);
                            return;
                        }
                        if (Dj3.eeG) {
                            Dj3.content = "【" + Dj3.title + "】 " + Dj3.content;
                        }
                        fVar.f(Dj3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Dk(4);
                        ShareItem Dj4 = Dj(4);
                        a(Dj4, 5);
                        if (Dj4 != null) {
                            fVar.h(Dj4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aSY();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Dk(5);
                    ShareItem Dj5 = Dj(5);
                    if (Dj5 != null) {
                        if (!Dj5.eeF) {
                            Dj5.content = m(Dj5);
                        }
                        fVar.i(Dj5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Dk(6);
                    ShareItem Dj6 = Dj(6);
                    a(Dj6, 7);
                    if (Dj6 != null) {
                        if (!Dj6.eeF) {
                            Dj6.content = m(Dj6);
                        }
                        fVar.j(Dj6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Dk(7);
                    ShareItem Dj7 = Dj(7);
                    if (Dj7 != null) {
                        if (!Dj7.eeF) {
                            Dj7.content = m(Dj7);
                        }
                        fVar.k(Dj7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Dk(8);
                        ShareItem Dj8 = Dj(8);
                        a(Dj8, 9);
                        if (Dj8 != null) {
                            fVar.g(Dj8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aSY();
                    }
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.laA = false;
                        return;
                    }
                    dismiss();
                    a(Dj, 17);
                    if (m.t(Dj.imageUri)) {
                        if (m.copyImageFile(m.getImageRealPathFromUri(this.mContext, Dj.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                            return;
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                            return;
                        }
                    }
                    String uri = Dj.imageUri.toString();
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
                    }
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(Dj, 10);
                    if (this.lay != null) {
                        this.lay.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Dj.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Dj);
                    if (Dj != null && Dj.eeF) {
                        bt(8, Dj.eeS);
                    }
                }
            }
        }
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.vN(shareItem.title);
            aVar.vO(shareItem.content);
            aVar.setAutoNight(false);
            aVar.gW(true);
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
            aVar.aST();
        }
    }

    private void n(ShareItem shareItem) {
        an ag = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 7);
        if (shareItem.eeW != 0) {
            ag.ag("obj_param1", shareItem.eeW);
            if (shareItem.eeW == 2) {
                ag.dh("fid", shareItem.fid);
            } else if (shareItem.eeW == 3) {
                if (shareItem.efa != 0) {
                    ag.ag("obj_type", shareItem.efa);
                }
                ag.dh("tid", shareItem.tid).dh("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem Dj(int i) {
        ShareItem shareItem = this.laz.get(i);
        if (shareItem == null) {
            return this.laz.get(1);
        }
        return shareItem;
    }

    private void Dk(int i) {
        if (i <= 8 && i > 0) {
            this.laA = true;
            if (this.laC != null) {
                z zVar = this.laC.get(i);
                if (!StringUtils.isNull(zVar.aYj()) && zVar.aYk() != null && zVar.aYk().size() > 0) {
                    h(zVar.aYj(), zVar.aYk());
                    return;
                }
            }
            if (this.laB != null) {
                String str = this.laB.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bt(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i).ag("obj_source", shareItem.eeV));
                }
            } else if (shareItem.eeG) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("fid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.eeV));
            } else if (shareItem.eeH || shareItem.eeK) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("tid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.eeV).ag("obj_param1", shareItem.eeW).dh("fid", shareItem.fid).ag(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eeX));
            } else if (shareItem.eeI) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dh("tid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.eeF) {
                bt(i, shareItem.eeS);
            } else if (shareItem.eeJ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_param1", 7).ag("obj_type", i).dh("fid", shareItem.extData));
            } else if (shareItem.eeL) {
                an ag = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i);
                ag.ag("obj_source", shareItem.eeV);
                if (!aq.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ag.ag("obj_param1", 9);
                    }
                    ag.dh(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ag);
            } else if (shareItem.eeN) {
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
                TiebaStatic.log(new an("c13365").dh("obj_locate", str).dh("topic_id", shareItem.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void cZT() {
        am.setBackgroundResource(this.jaz, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.lav, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.lau, R.color.cp_cont_j, 1);
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

    private boolean Dl(int i) {
        return (i & 1) > 0;
    }

    private boolean Dm(int i) {
        return (i & 2) > 0;
    }

    private boolean Dp(int i) {
        return (i & 4) > 0;
    }

    private boolean Dn(int i) {
        return (i & 8) > 0;
    }

    private boolean Do(int i) {
        return (i & 16) > 0;
    }

    private boolean Dq(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        y sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aYh() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.lav.setText(sharePanelConfData.getText());
        }
    }
}
