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
import com.baidu.tbadk.core.util.d.c;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private final TextView kHi;
    private ShareGridLayout kHk;
    private View.OnClickListener kHm;
    private SparseArray<String> kHp;
    private SparseArray<y> kHq;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int fLc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fLd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int kHf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int kHg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int kHh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dRj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> kHn = new SparseArray<>(8);
    private boolean kHo = false;
    private boolean kHt = true;
    private int kHu = 0;
    private CustomMessageListener dvj = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.cSA();
                b.this.kHk.removeAllViews();
                b.this.cSz();
            }
        }
    };
    private final List<View> kHl = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView kHj = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.kHj.setText(sharePanelText);
        }
        this.kHk = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.kHk.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lfT;
            marginLayoutParams.rightMargin = ShareGridLayout.lfT;
            this.kHk.setLayoutParams(marginLayoutParams);
        }
        this.kHk.setItemParams(fLc, fLd);
        this.kHi = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.kHi.setOnClickListener(this);
    }

    private void bpJ() {
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

    private void cSB() {
        ArrayList arrayList = new ArrayList(this.kHl);
        this.kHl.clear();
        if (!Cz(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!CA(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!CB(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!CD(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!CC(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (CE(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.kHl.addAll(arrayList);
        }
        if (this.kHt) {
            a(R.string.share_copy, new c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.dvU));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof c) {
                com.baidu.tbadk.core.util.e.a.aPr().kL(1).kM(R.color.cp_bg_line_i).aR(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kHf, kHf);
            layoutParams.topMargin = kHg;
            layoutParams.bottomMargin = kHh;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dRj);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.kHl.add(linearLayout);
        }
    }

    public LinearLayout cN(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kHf, kHf);
        layoutParams.topMargin = kHg;
        layoutParams.bottomMargin = kHh;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dRj);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        c cVar = new c(i2, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.aPr().kL(1).kM(R.color.cp_bg_line_i).aR(imageView);
        imageView.setImageDrawable(cVar.getDrawable());
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int cSy() {
        if (this.kHl == null) {
            return 0;
        }
        return this.kHl.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.kHl.size() && i >= 0) {
            this.kHl.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener kHs;

        public a(View.OnClickListener onClickListener) {
            this.kHs = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.kHs != null) {
                this.kHs.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.kHt = z;
    }

    public void setCustomCopyTitle(int i) {
        this.kHu = i;
    }

    public void e(SparseArray<String> sparseArray) {
        this.kHp = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bGj;
        if (z && (bGj = bGj()) != null) {
            shareItem.location = bGj;
        }
        this.kHn.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.dQx)) {
            this.kHj.setText(shareItem.dQx);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location bGj;
        if (z && (bGj = bGj()) != null) {
            shareItem.location = bGj;
        }
        this.kHn.put(i, shareItem);
    }

    private Location bGj() {
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
            this.kHm = onClickListener;
        }
    }

    public void cSz() {
        cSB();
        if (!f.aUX()) {
            this.kHk.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kHl.size()) {
                this.kHk.addView(this.kHl.get(i2), new ViewGroup.LayoutParams(fLc, fLd));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aUX()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cSz();
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
                cSA();
                bpJ();
                i.G(this.mContext).registerListener(this.dvj);
            }
        }
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
            this.kHo = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.dvj);
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
        if (this.kHn.size() != 0) {
            if (id == R.id.btnShareCancel || !this.kHo) {
                this.kHo = true;
                ShareItem Cx = Cx(1);
                f fVar = new f(this.mContext, null);
                if (Cx != null && Cx.dQS) {
                    TiebaStatic.log(new an("c13531").cI("obj_id", Cx.dQT).af("obj_type", Cx.dQU).cI("obj_source", Cx.dQV));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (Cx != null && Cx.dQr) {
                        a(Cx, 16);
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
                    Cy(3);
                    ShareItem Cx2 = Cx(3);
                    a(Cx2, 4);
                    if (Cx2 != null) {
                        if (Cx2.dQQ == 1) {
                            o(Cx2);
                        } else {
                            fVar.e(Cx2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Cy(2);
                    ShareItem Cx3 = Cx(2);
                    a(Cx3, 3);
                    if (Cx3 != null) {
                        if (Cx3.dQQ == 1) {
                            o(Cx3);
                            return;
                        }
                        if (Cx3.dQm) {
                            Cx3.content = "【" + Cx3.title + "】 " + Cx3.content;
                        }
                        fVar.f(Cx3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Cy(4);
                        ShareItem Cx4 = Cx(4);
                        a(Cx4, 5);
                        if (Cx4 != null) {
                            fVar.h(Cx4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMX();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Cy(5);
                    ShareItem Cx5 = Cx(5);
                    if (Cx5 != null) {
                        if (!Cx5.dQl) {
                            Cx5.content = m(Cx5);
                        }
                        fVar.i(Cx5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Cy(6);
                    ShareItem Cx6 = Cx(6);
                    a(Cx6, 7);
                    if (Cx6 != null) {
                        if (!Cx6.dQl) {
                            Cx6.content = m(Cx6);
                        }
                        fVar.j(Cx6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Cy(7);
                    ShareItem Cx7 = Cx(7);
                    if (Cx7 != null) {
                        if (!Cx7.dQl) {
                            Cx7.content = m(Cx7);
                        }
                        fVar.k(Cx7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Cy(8);
                        ShareItem Cx8 = Cx(8);
                        a(Cx8, 9);
                        if (Cx8 != null) {
                            fVar.g(Cx8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMX();
                    }
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        a(Cx, 17);
                        String uri = Cx.imageUri.toString();
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
                    a(Cx, 10);
                    if (this.kHm != null) {
                        this.kHm.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Cx.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Cx);
                    if (Cx != null && Cx.dQl) {
                        bo(8, Cx.dQz);
                    }
                }
            }
        }
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.uh(shareItem.title);
            aVar.ui(shareItem.content);
            aVar.setAutoNight(false);
            aVar.gE(true);
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
            }).b(i.G(activity));
            aVar.aMS();
        }
    }

    private void n(ShareItem shareItem) {
        an af = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).af("obj_source", 7);
        if (shareItem.dQD != 0) {
            af.af("obj_param1", shareItem.dQD);
            if (shareItem.dQD == 2) {
                af.cI("fid", shareItem.fid);
            } else if (shareItem.dQD == 3) {
                if (shareItem.dQH != 0) {
                    af.af("obj_type", shareItem.dQH);
                }
                af.cI("tid", shareItem.tid).cI("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(af);
    }

    private ShareItem Cx(int i) {
        ShareItem shareItem = this.kHn.get(i);
        if (shareItem == null) {
            return this.kHn.get(1);
        }
        return shareItem;
    }

    private void Cy(int i) {
        if (i <= 8 && i > 0) {
            this.kHo = true;
            if (this.kHq != null) {
                y yVar = this.kHq.get(i);
                if (!StringUtils.isNull(yVar.aSb()) && yVar.aSc() != null && yVar.aSc().size() > 0) {
                    h(yVar.aSb(), yVar.aSc());
                    return;
                }
            }
            if (this.kHp != null) {
                String str = this.kHp.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bo(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.dQu) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_type", i).af("obj_source", shareItem.dQC));
                }
            } else if (shareItem.dQm) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("fid", shareItem.extData).af("obj_type", i).af("obj_source", shareItem.dQC));
            } else if (shareItem.dQn || shareItem.dQq) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("tid", shareItem.extData).af("obj_type", i).af("obj_source", shareItem.dQC).af("obj_param1", shareItem.dQD).cI("fid", shareItem.fid).af(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dQE));
            } else if (shareItem.dQo) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cI("tid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQl) {
                bo(i, shareItem.dQz);
            } else if (shareItem.dQp) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_param1", 7).af("obj_type", i).cI("fid", shareItem.extData));
            } else if (shareItem.dQr) {
                an af = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_type", i);
                af.af("obj_source", shareItem.dQC);
                if (!aq.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        af.af("obj_param1", 9);
                    }
                    af.cI(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(af);
            } else if (shareItem.dQt) {
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
                TiebaStatic.log(new an("c13365").cI("obj_locate", str).cI("topic_id", shareItem.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void cSA() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.kHj, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.kHi, R.color.cp_cont_j, 1);
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

    private boolean Cz(int i) {
        return (i & 1) > 0;
    }

    private boolean CA(int i) {
        return (i & 2) > 0;
    }

    private boolean CD(int i) {
        return (i & 4) > 0;
    }

    private boolean CB(int i) {
        return (i & 8) > 0;
    }

    private boolean CC(int i) {
        return (i & 16) > 0;
    }

    private boolean CE(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.x sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aRZ() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.kHj.setText(sharePanelConfData.getText());
        }
    }
}
