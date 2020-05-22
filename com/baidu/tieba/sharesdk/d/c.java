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
    private final TextView kZk;
    private ShareGridLayout kZm;
    private View.OnClickListener kZo;
    private SparseArray<String> kZr;
    private SparseArray<y> kZs;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int fZa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fZb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int kZh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int kZi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int kZj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int efC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> kZp = new SparseArray<>(8);
    private boolean kZq = false;
    private boolean kZI = true;
    private int kZJ = 0;
    private CustomMessageListener dJe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.cZD();
                c.this.kZm.removeAllViews();
                c.this.cZC();
            }
        }
    };
    private final List<View> kZn = new ArrayList();
    protected final View mRootView = bXU();
    protected final View iZM = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView kZl = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.kZl.setText(sharePanelText);
        }
        this.kZm = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.kZm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lyE;
            marginLayoutParams.rightMargin = ShareGridLayout.lyE;
            this.kZm.setLayoutParams(marginLayoutParams);
        }
        this.kZm.setItemParams(fZa, fZb);
        this.kZk = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.kZk.setOnClickListener(this);
    }

    protected View bXU() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bvA() {
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

    private void cZF() {
        ArrayList arrayList = new ArrayList(this.kZn);
        this.kZn.clear();
        if (!Dj(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!Dk(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!Dl(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!Dn(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!Dm(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Do(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.kZn.addAll(arrayList);
        }
        if (this.kZI) {
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
                com.baidu.tbadk.core.util.e.a.aVv().ln(1).lo(R.color.cp_bg_line_i).aR(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kZh, kZh);
            layoutParams.topMargin = kZi;
            layoutParams.bottomMargin = kZj;
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
            this.kZn.add(linearLayout);
        }
    }

    public LinearLayout cS(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kZh, kZh);
        layoutParams.topMargin = kZi;
        layoutParams.bottomMargin = kZj;
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
            com.baidu.tbadk.core.util.e.a.aVv().ln(1).lo(R.color.cp_bg_line_i).aR(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int cZB() {
        if (this.kZn == null) {
            return 0;
        }
        return this.kZn.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.kZn.size() && i >= 0) {
            this.kZn.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener kZu;

        public a(View.OnClickListener onClickListener) {
            this.kZu = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.kZu != null) {
                this.kZu.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.kZI = z;
    }

    public void setCustomCopyTitle(int i) {
        this.kZJ = i;
    }

    public void f(SparseArray<String> sparseArray) {
        this.kZr = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bMC;
        if (z && (bMC = bMC()) != null) {
            shareItem.location = bMC;
        }
        this.kZp.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.eeQ)) {
            this.kZl.setText(shareItem.eeQ);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location bMC;
        if (z && (bMC = bMC()) != null) {
            shareItem.location = bMC;
        }
        this.kZp.put(i, shareItem);
    }

    private Location bMC() {
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
            this.kZo = onClickListener;
        }
    }

    public void cZC() {
        cZF();
        if (!f.bbh()) {
            this.kZm.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kZn.size()) {
                this.kZm.addView(this.kZn.get(i2), new ViewGroup.LayoutParams(fZa, fZb));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.bbh()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cZC();
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
            am.setBackgroundResource(this.iZM, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                a(window);
                window.setContentView(this.mRootView);
                cZD();
                bvA();
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
            this.kZq = false;
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
        if (this.kZp.size() != 0) {
            if (id == R.id.btnShareCancel || !this.kZq) {
                this.kZq = true;
                ShareItem Dh = Dh(1);
                f fVar = new f(this.mContext, null);
                if (Dh != null && Dh.efl) {
                    TiebaStatic.log(new an("c13531").dh("obj_id", Dh.efm).ag("obj_type", Dh.efn).dh("obj_source", Dh.efo));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (Dh != null && Dh.eeL) {
                        a(Dh, 16);
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
                    Di(3);
                    ShareItem Dh2 = Dh(3);
                    a(Dh2, 4);
                    if (Dh2 != null) {
                        if (Dh2.efj == 1) {
                            o(Dh2);
                        } else {
                            fVar.e(Dh2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Di(2);
                    ShareItem Dh3 = Dh(2);
                    a(Dh3, 3);
                    if (Dh3 != null) {
                        if (Dh3.efj == 1) {
                            o(Dh3);
                            return;
                        }
                        if (Dh3.eeG) {
                            Dh3.content = "【" + Dh3.title + "】 " + Dh3.content;
                        }
                        fVar.f(Dh3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Di(4);
                        ShareItem Dh4 = Dh(4);
                        a(Dh4, 5);
                        if (Dh4 != null) {
                            fVar.h(Dh4);
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
                    Di(5);
                    ShareItem Dh5 = Dh(5);
                    if (Dh5 != null) {
                        if (!Dh5.eeF) {
                            Dh5.content = m(Dh5);
                        }
                        fVar.i(Dh5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Di(6);
                    ShareItem Dh6 = Dh(6);
                    a(Dh6, 7);
                    if (Dh6 != null) {
                        if (!Dh6.eeF) {
                            Dh6.content = m(Dh6);
                        }
                        fVar.j(Dh6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Di(7);
                    ShareItem Dh7 = Dh(7);
                    if (Dh7 != null) {
                        if (!Dh7.eeF) {
                            Dh7.content = m(Dh7);
                        }
                        fVar.k(Dh7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Di(8);
                        ShareItem Dh8 = Dh(8);
                        a(Dh8, 9);
                        if (Dh8 != null) {
                            fVar.g(Dh8);
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
                        this.kZq = false;
                        return;
                    }
                    dismiss();
                    a(Dh, 17);
                    if (m.t(Dh.imageUri)) {
                        if (m.copyImageFile(m.getImageRealPathFromUri(this.mContext, Dh.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                            return;
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                            return;
                        }
                    }
                    String uri = Dh.imageUri.toString();
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
                    a(Dh, 10);
                    if (this.kZo != null) {
                        this.kZo.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Dh.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Dh);
                    if (Dh != null && Dh.eeF) {
                        bt(8, Dh.eeS);
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
    public ShareItem Dh(int i) {
        ShareItem shareItem = this.kZp.get(i);
        if (shareItem == null) {
            return this.kZp.get(1);
        }
        return shareItem;
    }

    private void Di(int i) {
        if (i <= 8 && i > 0) {
            this.kZq = true;
            if (this.kZs != null) {
                y yVar = this.kZs.get(i);
                if (!StringUtils.isNull(yVar.aYi()) && yVar.aYj() != null && yVar.aYj().size() > 0) {
                    h(yVar.aYi(), yVar.aYj());
                    return;
                }
            }
            if (this.kZr != null) {
                String str = this.kZr.get(i);
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
    public void cZD() {
        am.setBackgroundResource(this.iZM, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.kZl, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.kZk, R.color.cp_cont_j, 1);
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

    private boolean Dj(int i) {
        return (i & 1) > 0;
    }

    private boolean Dk(int i) {
        return (i & 2) > 0;
    }

    private boolean Dn(int i) {
        return (i & 4) > 0;
    }

    private boolean Dl(int i) {
        return (i & 8) > 0;
    }

    private boolean Dm(int i) {
        return (i & 16) > 0;
    }

    private boolean Do(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.x sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aYg() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.kZl.setText(sharePanelConfData.getText());
        }
    }
}
