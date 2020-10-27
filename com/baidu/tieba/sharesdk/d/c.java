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
/* loaded from: classes24.dex */
public class c implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private final TextView mFl;
    private ShareGridLayout mFn;
    private View.OnClickListener mFp;
    private SparseArray<String> mFs;
    private SparseArray<af> mFt;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int hhS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int hhT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mFi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mFj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mFk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fbQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> mFq = new SparseArray<>(8);
    private boolean mFr = false;
    private boolean mFN = true;
    private int mFO = 0;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dDF();
                c.this.mFn.removeAllViews();
                c.this.dDE();
            }
        }
    };
    private final List<View> mFo = new ArrayList();
    protected final View mRootView = czg();
    protected final View kAe = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView mFm = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mFm.setText(sharePanelText);
        }
        this.mFn = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.mFn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.neG;
            marginLayoutParams.rightMargin = ShareGridLayout.neG;
            this.mFn.setLayoutParams(marginLayoutParams);
        }
        this.mFn.setItemParams(hhS, hhT);
        this.mFl = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mFl.setOnClickListener(this);
    }

    protected View czg() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bRY() {
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

    private void dDI() {
        ArrayList arrayList = new ArrayList(this.mFo);
        this.mFo.clear();
        if (!II(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!IJ(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!IK(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!IM(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!IL(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (IN(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.mFo.addAll(arrayList);
        }
        if (this.mFN) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.eDM));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bpo().oZ(1).pa(R.color.cp_bg_line_i).bg(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mFi, mFi);
            layoutParams.topMargin = mFj;
            layoutParams.bottomMargin = mFk;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fbQ);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.mFo.add(linearLayout);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public LinearLayout m43do(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mFi, mFi);
        layoutParams.topMargin = mFj;
        layoutParams.bottomMargin = mFk;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fbQ);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        if (ap.getDrawable(i2) instanceof BitmapDrawable) {
            ap.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(1).pa(R.color.cp_bg_line_i).bg(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        ap.setViewTextColor(textView, R.color.cp_cont_f);
        return linearLayout;
    }

    public int dDD() {
        if (this.mFo == null) {
            return 0;
        }
        return this.mFo.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.mFo.size() && i >= 0) {
            this.mFo.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes24.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener mFv;

        public a(View.OnClickListener onClickListener) {
            this.mFv = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.mFv != null) {
                this.mFv.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.mFN = z;
    }

    public void setCustomCopyTitle(int i) {
        this.mFO = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.mFs = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cna;
        if (z && (cna = cna()) != null) {
            shareItem.location = cna;
        }
        this.mFq.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fba)) {
            this.mFm.setText(shareItem.fba);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cna;
        if (z && (cna = cna()) != null) {
            shareItem.location = cna;
        }
        this.mFq.put(i, shareItem);
    }

    private Location cna() {
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
            this.mFp = onClickListener;
        }
    }

    public void dDE() {
        dDI();
        if (!g.bvb()) {
            this.mFn.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mFo.size()) {
                this.mFn.addView(this.mFo.get(i2), new ViewGroup.LayoutParams(hhS, hhT));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bvb()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dDE();
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
            ap.setBackgroundResource(this.kAe, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                dDF();
                bRY();
                i.I(this.mContext).registerListener(this.skinChangeListener);
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
            this.mFr = false;
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
        if (this.mFq.size() != 0) {
            if (id == R.id.btnShareCancel || !this.mFr) {
                this.mFr = true;
                ShareItem IG = IG(1);
                g gVar = new g(this.mContext, null);
                if (IG != null && IG.fbv) {
                    TiebaStatic.log(new aq("c13531").dR("obj_id", IG.fbw).aj("obj_type", IG.fbx).dR("obj_source", IG.fby));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (IG != null && IG.faT) {
                        a(IG, 16);
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
                    IH(3);
                    ShareItem IG2 = IG(3);
                    a(IG2, 4);
                    if (IG2 != null) {
                        if (o(IG2) && IG2.getCommandChannelArray() != null && IG2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IG2, this.mContext, 3, this.onCancelListener);
                        } else if (IG2.fbt == 1) {
                            p(IG2);
                        } else {
                            gVar.f(IG2);
                        }
                    }
                    aqVar.aj("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IH(2);
                    ShareItem IG3 = IG(2);
                    a(IG3, 3);
                    if (IG3 != null) {
                        if (o(IG3) && IG3.getCommandChannelArray() != null && IG3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IG3, this.mContext, 2, this.onCancelListener);
                        } else if (IG3.fbt == 1) {
                            p(IG3);
                        } else {
                            if (IG3.faO) {
                                IG3.content = "【" + IG3.title + "】 " + IG3.content;
                            }
                            gVar.g(IG3);
                        }
                    }
                    aqVar.aj("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IH(4);
                        ShareItem IG4 = IG(4);
                        a(IG4, 5);
                        if (IG4 != null) {
                            if (o(IG4) && IG4.getCommandChannelArray() != null && IG4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IG4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.i(IG4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bmI();
                    }
                    aqVar.aj("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IH(5);
                    ShareItem IG5 = IG(5);
                    if (IG5 != null) {
                        if (!IG5.faN) {
                            IG5.content = m(IG5);
                        }
                        gVar.j(IG5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    IH(6);
                    ShareItem IG6 = IG(6);
                    a(IG6, 7);
                    if (IG6 != null) {
                        if (!IG6.faN) {
                            IG6.content = m(IG6);
                        }
                        if (o(IG6) && IG6.getCommandChannelArray() != null && IG6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IG6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.k(IG6);
                        }
                    }
                    aqVar.aj("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IH(7);
                    ShareItem IG7 = IG(7);
                    if (IG7 != null) {
                        if (!IG7.faN) {
                            IG7.content = m(IG7);
                        }
                        gVar.l(IG7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IH(8);
                        ShareItem IG8 = IG(8);
                        a(IG8, 9);
                        if (IG8 != null) {
                            if (o(IG8) && IG8.getCommandChannelArray() != null && IG8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IG8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.h(IG8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bmI();
                    }
                    aqVar.aj("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.mFr = false;
                        return;
                    }
                    dismiss();
                    a(IG, 17);
                    if (n.u(IG.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, IG.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = IG.imageUri.toString();
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
                    aqVar.aj("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(IG, 10);
                    if (this.mFp != null) {
                        this.mFp.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(IG.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(IG);
                    if (IG != null && IG.faN) {
                        bL(8, IG.fbc);
                    }
                }
                aqVar.aj("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean o(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fbA) || TextUtils.isEmpty(shareItem.fbB)) ? false : true;
    }

    private void p(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.AZ(shareItem.title);
            aVar.Ba(shareItem.content);
            aVar.setAutoNight(false);
            aVar.iM(true);
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
            aVar.bmC();
        }
    }

    private void n(ShareItem shareItem) {
        aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aj("obj_source", 7);
        if (shareItem.fbg != 0) {
            aj.aj("obj_param1", shareItem.fbg);
            if (shareItem.fbg == 2) {
                aj.dR("fid", shareItem.fid);
            } else if (shareItem.fbg == 3) {
                if (shareItem.fbk != 0) {
                    aj.aj("obj_type", shareItem.fbk);
                }
                aj.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        aj.aj("obj_locate", 9);
        TiebaStatic.log(aj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem IG(int i) {
        ShareItem shareItem = this.mFq.get(i);
        if (shareItem == null) {
            return this.mFq.get(1);
        }
        return shareItem;
    }

    private void IH(int i) {
        if (i <= 8 && i > 0) {
            this.mFr = true;
            if (this.mFt != null) {
                af afVar = this.mFt.get(i);
                if (!StringUtils.isNull(afVar.bss()) && afVar.bst() != null && afVar.bst().size() > 0) {
                    f(afVar.bss(), afVar.bst());
                    return;
                }
            }
            if (this.mFs != null) {
                String str = this.mFs.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bL(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_type", i).aj("obj_source", shareItem.fbf));
                }
            } else if (shareItem.faO) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).aj("obj_type", i).aj("obj_source", shareItem.fbf));
            } else if (shareItem.faP || shareItem.faS) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).aj("obj_type", i).aj("obj_source", shareItem.fbf).aj("obj_param1", shareItem.fbg).dR("fid", shareItem.fid).aj(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fbh));
            } else if (shareItem.faQ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).aj("obj_type", i));
            } else if (shareItem.faN) {
                bL(i, shareItem.fbc);
            } else if (shareItem.faR) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_param1", 7).aj("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.faT) {
                aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_type", i);
                aj.aj("obj_source", shareItem.fbf);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        aj.aj("obj_param1", 9);
                    }
                    aj.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(aj);
            } else if (shareItem.faV) {
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
                TiebaStatic.log(new aq("c13365").dR("obj_locate", str).dR("topic_id", shareItem.extData));
            } else if (shareItem.faW) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dR("tid", shareItem.extData);
                aqVar.dR("post_id", shareItem.pid);
                aqVar.aj("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.faX) {
                aq aqVar2 = new aq("c13953");
                aqVar2.aj("obj_type", i);
                aqVar2.dR("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dDF() {
        ap.setBackgroundResource(this.kAe, R.drawable.transmit_share_dialog_background);
        ap.setViewTextColor(this.mFm, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.mFl, R.color.cp_cont_j, 1);
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

    private boolean II(int i) {
        return (i & 1) > 0;
    }

    private boolean IJ(int i) {
        return (i & 2) > 0;
    }

    private boolean IM(int i) {
        return (i & 4) > 0;
    }

    private boolean IK(int i) {
        return (i & 8) > 0;
    }

    private boolean IL(int i) {
        return (i & 16) > 0;
    }

    private boolean IN(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bsq() && !at.isEmpty(sharePanelConfData.getText())) {
            this.mFm.setText(sharePanelConfData.getText());
        }
    }
}
