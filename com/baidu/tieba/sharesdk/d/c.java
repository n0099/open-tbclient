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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes23.dex */
public class c implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private final TextView mdb;
    private ShareGridLayout mdd;
    private View.OnClickListener mdf;
    private SparseArray<String> mdi;
    private SparseArray<af> mdj;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int gHD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int gHE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mcY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mcZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mda = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eHn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> mdg = new SparseArray<>(8);
    private boolean mdh = false;
    private boolean mdD = true;
    private int mdE = 0;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dwM();
                c.this.mdd.removeAllViews();
                c.this.dwL();
            }
        }
    };
    private final List<View> mde = new ArrayList();
    protected final View mRootView = csC();
    protected final View jYr = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView mdc = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mdc.setText(sharePanelText);
        }
        this.mdd = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.mdd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.mCo;
            marginLayoutParams.rightMargin = ShareGridLayout.mCo;
            this.mdd.setLayoutParams(marginLayoutParams);
        }
        this.mdd.setItemParams(gHD, gHE);
        this.mdb = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mdb.setOnClickListener(this);
    }

    protected View csC() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bMr() {
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

    private void dwP() {
        ArrayList arrayList = new ArrayList(this.mde);
        this.mde.clear();
        if (!HJ(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!HK(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!HL(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!HN(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!HM(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (HO(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.mde.addAll(arrayList);
        }
        if (this.mdD) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.ejf));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bkL().oq(1).or(R.color.cp_bg_line_i).bb(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mcY, mcY);
            layoutParams.topMargin = mcZ;
            layoutParams.bottomMargin = mda;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eHn);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.mde.add(linearLayout);
        }
    }

    public LinearLayout dm(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mcY, mcY);
        layoutParams.topMargin = mcZ;
        layoutParams.bottomMargin = mda;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eHn);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (ap.getDrawable(i2) instanceof BitmapDrawable) {
            ap.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bkL().oq(1).or(R.color.cp_bg_line_i).bb(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        ap.setViewTextColor(textView, R.color.cp_cont_f);
        return linearLayout;
    }

    public int dwK() {
        if (this.mde == null) {
            return 0;
        }
        return this.mde.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.mde.size() && i >= 0) {
            this.mde.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes23.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener mdl;

        public a(View.OnClickListener onClickListener) {
            this.mdl = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.mdl != null) {
                this.mdl.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.mdD = z;
    }

    public void setCustomCopyTitle(int i) {
        this.mdE = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.mdi = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cgx;
        if (z && (cgx = cgx()) != null) {
            shareItem.location = cgx;
        }
        this.mdg.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.eGx)) {
            this.mdc.setText(shareItem.eGx);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cgx;
        if (z && (cgx = cgx()) != null) {
            shareItem.location = cgx;
        }
        this.mdg.put(i, shareItem);
    }

    private Location cgx() {
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
            this.mdf = onClickListener;
        }
    }

    public void dwL() {
        dwP();
        if (!g.bqy()) {
            this.mdd.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mde.size()) {
                this.mdd.addView(this.mde.get(i2), new ViewGroup.LayoutParams(gHD, gHE));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bqy()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dwL();
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
            ap.setBackgroundResource(this.jYr, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                dwM();
                bMr();
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
            this.mdh = false;
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
        if (this.mdg.size() != 0) {
            if (id == R.id.btnShareCancel || !this.mdh) {
                this.mdh = true;
                ShareItem HH = HH(1);
                g gVar = new g(this.mContext, null);
                if (HH != null && HH.eGS) {
                    TiebaStatic.log(new aq("c13531").dF("obj_id", HH.eGT).ai("obj_type", HH.eGU).dF("obj_source", HH.eGV));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (HH != null && HH.eGq) {
                        a(HH, 16);
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
                    HI(3);
                    ShareItem HH2 = HH(3);
                    a(HH2, 4);
                    if (HH2 != null) {
                        if (o(HH2) && HH2.getCommandChannelArray() != null && HH2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(HH2, this.mContext, 3, this.onCancelListener);
                        } else if (HH2.eGQ == 1) {
                            p(HH2);
                        } else {
                            gVar.f(HH2);
                        }
                    }
                    aqVar.ai("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    HI(2);
                    ShareItem HH3 = HH(2);
                    a(HH3, 3);
                    if (HH3 != null) {
                        if (o(HH3) && HH3.getCommandChannelArray() != null && HH3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(HH3, this.mContext, 2, this.onCancelListener);
                        } else if (HH3.eGQ == 1) {
                            p(HH3);
                        } else {
                            if (HH3.eGl) {
                                HH3.content = "【" + HH3.title + "】 " + HH3.content;
                            }
                            gVar.g(HH3);
                        }
                    }
                    aqVar.ai("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        HI(4);
                        ShareItem HH4 = HH(4);
                        a(HH4, 5);
                        if (HH4 != null) {
                            if (o(HH4) && HH4.getCommandChannelArray() != null && HH4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(HH4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.i(HH4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).big();
                    }
                    aqVar.ai("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    HI(5);
                    ShareItem HH5 = HH(5);
                    if (HH5 != null) {
                        if (!HH5.eGk) {
                            HH5.content = m(HH5);
                        }
                        gVar.j(HH5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    HI(6);
                    ShareItem HH6 = HH(6);
                    a(HH6, 7);
                    if (HH6 != null) {
                        if (!HH6.eGk) {
                            HH6.content = m(HH6);
                        }
                        if (o(HH6) && HH6.getCommandChannelArray() != null && HH6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(HH6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.k(HH6);
                        }
                    }
                    aqVar.ai("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    HI(7);
                    ShareItem HH7 = HH(7);
                    if (HH7 != null) {
                        if (!HH7.eGk) {
                            HH7.content = m(HH7);
                        }
                        gVar.l(HH7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        HI(8);
                        ShareItem HH8 = HH(8);
                        a(HH8, 9);
                        if (HH8 != null) {
                            if (o(HH8) && HH8.getCommandChannelArray() != null && HH8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(HH8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.h(HH8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).big();
                    }
                    aqVar.ai("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.mdh = false;
                        return;
                    }
                    dismiss();
                    a(HH, 17);
                    if (n.u(HH.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, HH.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = HH.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new p(currentActivity, uri, new p.a() { // from class: com.baidu.tieba.sharesdk.d.c.5
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
                    aqVar.ai("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(HH, 10);
                    if (this.mdf != null) {
                        this.mdf.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(HH.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(HH);
                    if (HH != null && HH.eGk) {
                        bA(8, HH.eGz);
                    }
                }
                aqVar.ai("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean o(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.eGX) || TextUtils.isEmpty(shareItem.eGY)) ? false : true;
    }

    private void p(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.zU(shareItem.title);
            aVar.zV(shareItem.content);
            aVar.setAutoNight(false);
            aVar.id(true);
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
            }).b(i.I(activity));
            aVar.bia();
        }
    }

    private void n(ShareItem shareItem) {
        aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 7);
        if (shareItem.eGD != 0) {
            ai.ai("obj_param1", shareItem.eGD);
            if (shareItem.eGD == 2) {
                ai.dF("fid", shareItem.fid);
            } else if (shareItem.eGD == 3) {
                if (shareItem.eGH != 0) {
                    ai.ai("obj_type", shareItem.eGH);
                }
                ai.dF("tid", shareItem.tid).dF("fid", shareItem.fid);
            }
        }
        ai.ai("obj_locate", 9);
        TiebaStatic.log(ai);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem HH(int i) {
        ShareItem shareItem = this.mdg.get(i);
        if (shareItem == null) {
            return this.mdg.get(1);
        }
        return shareItem;
    }

    private void HI(int i) {
        if (i <= 8 && i > 0) {
            this.mdh = true;
            if (this.mdj != null) {
                af afVar = this.mdj.get(i);
                if (!StringUtils.isNull(afVar.bnP()) && afVar.bnQ() != null && afVar.bnQ().size() > 0) {
                    f(afVar.bnP(), afVar.bnQ());
                    return;
                }
            }
            if (this.mdi != null) {
                String str = this.mdi.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bA(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i).ai("obj_source", shareItem.eGC));
                }
            } else if (shareItem.eGl) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dF("fid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eGC));
            } else if (shareItem.eGm || shareItem.eGp) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dF("tid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eGC).ai("obj_param1", shareItem.eGD).dF("fid", shareItem.fid).ai(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eGE));
            } else if (shareItem.eGn) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dF("tid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eGk) {
                bA(i, shareItem.eGz);
            } else if (shareItem.eGo) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_param1", 7).ai("obj_type", i).dF("fid", shareItem.extData));
            } else if (shareItem.eGq) {
                aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i);
                ai.ai("obj_source", shareItem.eGC);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ai.ai("obj_param1", 9);
                    }
                    ai.dF(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ai);
            } else if (shareItem.eGs) {
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
                TiebaStatic.log(new aq("c13365").dF("obj_locate", str).dF("topic_id", shareItem.extData));
            } else if (shareItem.eGt) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dF("tid", shareItem.extData);
                aqVar.dF("pid", shareItem.pid);
                aqVar.ai("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.eGu) {
                aq aqVar2 = new aq("c13953");
                aqVar2.ai("obj_type", i);
                aqVar2.dF("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dwM() {
        ap.setBackgroundResource(this.jYr, R.drawable.transmit_share_dialog_background);
        ap.setViewTextColor(this.mdc, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.mdb, R.color.cp_cont_j, 1);
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

    private boolean HJ(int i) {
        return (i & 1) > 0;
    }

    private boolean HK(int i) {
        return (i & 2) > 0;
    }

    private boolean HN(int i) {
        return (i & 4) > 0;
    }

    private boolean HL(int i) {
        return (i & 8) > 0;
    }

    private boolean HM(int i) {
        return (i & 16) > 0;
    }

    private boolean HO(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bnN() && !at.isEmpty(sharePanelConfData.getText())) {
            this.mdc.setText(sharePanelConfData.getText());
        }
    }
}
