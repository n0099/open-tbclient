package com.baidu.tieba.sharesdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
import com.baidu.adp.lib.g.g;
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
import com.baidu.tbadk.core.util.f.c;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private final TextView iXT;
    private ShareGridLayout iXV;
    private View.OnClickListener iXX;
    private SparseArray<String> iYa;
    private SparseArray<w> iYb;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int ekE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int ekF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iXQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iXR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iXS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int czs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iXY = new SparseArray<>(8);
    private boolean iXZ = false;
    private boolean iYe = true;
    private CustomMessageListener cfN = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.ckR();
                b.this.iXV.removeAllViews();
                b.this.ckQ();
            }
        }
    };
    private final List<View> iXW = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView iXU = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.iXU.setText(sharePanelText);
        }
        this.iXV = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.iXV.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.jvT;
            marginLayoutParams.rightMargin = ShareGridLayout.jvT;
            this.iXV.setLayoutParams(marginLayoutParams);
        }
        this.iXV.setItemParams(ekE, ekF);
        this.iXT = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.iXT.setOnClickListener(this);
    }

    private void aMl() {
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

    private void ckS() {
        this.iXW.clear();
        if (!zk(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg));
        }
        if (!zl(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg));
        }
        if (!zm(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg));
        }
        if (!zo(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg));
        }
        if (!zn(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg));
        }
        if (zp(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_share_download_n_svg));
        }
        if (this.iYe) {
            a(R.string.share_copy, new c(R.drawable.icon_share_copy_n_svg));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.f.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.cgw));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iXQ, iXQ);
            layoutParams.topMargin = iXR;
            layoutParams.bottomMargin = iXS;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, czs);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.iXW.add(linearLayout);
        }
    }

    public LinearLayout cn(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iXQ, iXQ);
        layoutParams.topMargin = iXR;
        layoutParams.bottomMargin = iXS;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, czs);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        am.setImageResource(imageView, i2);
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int ckP() {
        if (this.iXW == null) {
            return 0;
        }
        return this.iXW.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iXW.size() && i >= 0) {
            this.iXW.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener iYd;

        public a(View.OnClickListener onClickListener) {
            this.iYd = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.iYd != null) {
                this.iYd.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.iYe = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.iYa = sparseArray;
    }

    public void a(e eVar, boolean z) {
        Location bcp;
        if (z && (bcp = bcp()) != null) {
            eVar.cyI = bcp;
        }
        this.iXY.put(1, eVar);
        if (!StringUtils.isNull(eVar.cyD)) {
            this.iXU.setText(eVar.cyD);
        }
    }

    private Location bcp() {
        if (ab.checkLocationForGoogle(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
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
            this.iXX = onClickListener;
        }
    }

    public void ckQ() {
        ckS();
        if (!f.asi()) {
            this.iXV.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iXW.size()) {
                this.iXV.addView(this.iXW.get(i2), new ViewGroup.LayoutParams(ekE, ekF));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.asi()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            ckQ();
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
                window.setBackgroundDrawable(am.getDrawable(R.drawable.transmit_share_dialog_background));
                ckR();
                aMl();
                i.ab(this.mContext).registerListener(this.cfN);
            }
        }
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
            this.iXZ = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.cfN);
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
        if (this.iXY.size() != 0) {
            if (id == R.id.btnShareCancel || !this.iXZ) {
                this.iXZ = true;
                e zi = zi(1);
                f fVar = new f(this.mContext, null);
                if (zi != null && zi.czd) {
                    TiebaStatic.log(new an("c13531").bS("obj_id", zi.cze).O("obj_type", zi.czf).bS("obj_source", zi.czg));
                }
                if (id == R.id.btnShareCancel) {
                    j("share_cancel", new Object[0]);
                    if (zi != null && zi.cyy) {
                        a(zi, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                    }
                } else if (i == R.drawable.icon_mask_share_wechat_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_weixin", new Object[0]);
                    zj(3);
                    e zi2 = zi(3);
                    a(zi2, 4);
                    if (zi2 != null) {
                        if (zi2.cza == 1) {
                            o(zi2);
                        } else {
                            fVar.e(zi2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_pyq", new Object[0]);
                    zj(2);
                    e zi3 = zi(2);
                    a(zi3, 3);
                    if (zi3 != null) {
                        if (zi3.cza == 1) {
                            o(zi3);
                            return;
                        }
                        if (zi3.cyt) {
                            zi3.content = "【" + zi3.title + "】 " + zi3.content;
                        }
                        fVar.f(zi3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        j("share_to_qzone", new Object[0]);
                        zj(4);
                        e zi4 = zi(4);
                        a(zi4, 5);
                        if (zi4 != null) {
                            fVar.h(zi4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akT();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_qweibo", new Object[0]);
                    zj(5);
                    e zi5 = zi(5);
                    a(zi5, 6);
                    if (zi5 != null) {
                        if (!zi5.cys) {
                            zi5.content = m(zi5);
                        }
                        fVar.i(zi5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_sweibo", new Object[0]);
                    zj(6);
                    e zi6 = zi(6);
                    a(zi6, 7);
                    if (zi6 != null) {
                        if (!zi6.cys) {
                            zi6.content = m(zi6);
                        }
                        fVar.j(zi6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_renren", new Object[0]);
                    zj(7);
                    e zi7 = zi(7);
                    a(zi7, 8);
                    if (zi7 != null) {
                        if (!zi7.cys) {
                            zi7.content = m(zi7);
                        }
                        fVar.k(zi7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        j("share_to_qq_friend", new Object[0]);
                        zj(8);
                        e zi8 = zi(8);
                        a(zi8, 9);
                        if (zi8 != null) {
                            fVar.g(zi8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akT();
                    }
                } else if (i == R.drawable.icon_share_download_n_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        a(zi, 17);
                        String uri = zi.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new m(currentActivity, uri, new m.a() { // from class: com.baidu.tieba.sharesdk.d.b.5
                                @Override // com.baidu.tbadk.util.m.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.m.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == R.drawable.icon_share_copy_n_svg) {
                    a(zi, 10);
                    if (this.iXX != null) {
                        this.iXX.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(zi.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(zi);
                    if (zi != null && zi.cys) {
                        aE(8, zi.cyJ);
                    }
                }
            }
        }
    }

    private void o(final e eVar) {
        if (eVar != null && !TextUtils.isEmpty(eVar.content) && !TextUtils.isEmpty(eVar.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.nm(eVar.title);
            aVar.nn(eVar.content);
            aVar.setAutoNight(false);
            aVar.eg(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(eVar.content);
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
            aVar.akO();
        }
    }

    private void n(e eVar) {
        an O = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).O("obj_source", 7);
        if (eVar.cyN != 0) {
            O.O("obj_param1", eVar.cyN);
            if (eVar.cyN == 2) {
                O.bS("fid", eVar.fid);
            } else if (eVar.cyN == 3) {
                if (eVar.cyR != 0) {
                    O.O("obj_type", eVar.cyR);
                }
                O.bS("tid", eVar.tid).bS("fid", eVar.fid);
            }
        }
        TiebaStatic.log(O);
    }

    private e zi(int i) {
        e eVar = this.iXY.get(i);
        if (eVar == null) {
            return this.iXY.get(1);
        }
        return eVar;
    }

    private void zj(int i) {
        if (i <= 8 && i > 0) {
            this.iXZ = true;
            if (this.iYb != null) {
                w wVar = this.iYb.get(i);
                if (!StringUtils.isNull(wVar.apq()) && wVar.apr() != null && wVar.apr().size() > 0) {
                    j(wVar.apq(), wVar.apr());
                    return;
                }
            }
            if (this.iYa != null) {
                String str = this.iYa.get(i);
                if (!aq.isEmpty(str)) {
                    j(str, new Object[0]);
                }
            }
        }
    }

    private void j(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aE(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(e eVar, int i) {
        String str;
        if (eVar != null && eVar.extData != null) {
            if (eVar.cyt) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("fid", eVar.extData).O("obj_type", i));
            } else if (eVar.cyu || eVar.cyx) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("tid", eVar.extData).O("obj_type", i).O("obj_source", eVar.cyM).O("obj_param1", eVar.cyN).bS("fid", eVar.fid));
            } else if (eVar.cyv) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).bS("tid", eVar.extData).O("obj_type", i));
            } else if (eVar.cys) {
                aE(i, eVar.cyJ);
            } else if (eVar.cyw) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_param1", 7).O("obj_type", i).bS("fid", eVar.extData));
            } else if (eVar.cyy) {
                an O = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_type", i);
                if (!aq.isEmpty(eVar.linkUrl)) {
                    if (eVar.linkUrl.contains("worldcup")) {
                        O.O("obj_param1", 9);
                    }
                    O.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
                }
                TiebaStatic.log(O);
            } else if (eVar.cyA) {
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
                TiebaStatic.log(new an("c13365").bS("obj_locate", str).bS("topic_id", eVar.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void ckR() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.iXU, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.iXT, R.color.cp_cont_j, 1);
    }

    private String m(e eVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(eVar.title)) {
            sb.append("【");
            sb.append(eVar.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(eVar.title)) {
            sb.append(eVar.content);
        }
        return sb.toString();
    }

    private boolean zk(int i) {
        return (i & 1) > 0;
    }

    private boolean zl(int i) {
        return (i & 2) > 0;
    }

    private boolean zo(int i) {
        return (i & 4) > 0;
    }

    private boolean zm(int i) {
        return (i & 8) > 0;
    }

    private boolean zn(int i) {
        return (i & 16) > 0;
    }

    private boolean zp(int i) {
        return (i & 32) > 0;
    }
}
