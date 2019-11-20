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
    private final TextView iXc;
    private ShareGridLayout iXe;
    private View.OnClickListener iXg;
    private SparseArray<String> iXj;
    private SparseArray<w> iXk;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int ejN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int ejO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iWZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iXa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iXb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int cyB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iXh = new SparseArray<>(8);
    private boolean iXi = false;
    private boolean iXn = true;
    private CustomMessageListener ceW = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.ckP();
                b.this.iXe.removeAllViews();
                b.this.ckO();
            }
        }
    };
    private final List<View> iXf = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView iXd = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.iXd.setText(sharePanelText);
        }
        this.iXe = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.iXe.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.jvc;
            marginLayoutParams.rightMargin = ShareGridLayout.jvc;
            this.iXe.setLayoutParams(marginLayoutParams);
        }
        this.iXe.setItemParams(ejN, ejO);
        this.iXc = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.iXc.setOnClickListener(this);
    }

    private void aMj() {
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

    private void ckQ() {
        this.iXf.clear();
        if (!zj(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg));
        }
        if (!zk(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg));
        }
        if (!zl(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg));
        }
        if (!zn(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg));
        }
        if (!zm(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg));
        }
        if (zo(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_share_download_n_svg));
        }
        if (this.iXn) {
            a(R.string.share_copy, new c(R.drawable.icon_share_copy_n_svg));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.f.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.cfF));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iWZ, iWZ);
            layoutParams.topMargin = iXa;
            layoutParams.bottomMargin = iXb;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, cyB);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.iXf.add(linearLayout);
        }
    }

    public LinearLayout cl(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iWZ, iWZ);
        layoutParams.topMargin = iXa;
        layoutParams.bottomMargin = iXb;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cyB);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        am.setImageResource(imageView, i2);
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int ckN() {
        if (this.iXf == null) {
            return 0;
        }
        return this.iXf.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iXf.size() && i >= 0) {
            this.iXf.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener iXm;

        public a(View.OnClickListener onClickListener) {
            this.iXm = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.iXm != null) {
                this.iXm.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.iXn = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.iXj = sparseArray;
    }

    public void a(e eVar, boolean z) {
        Location bcn;
        if (z && (bcn = bcn()) != null) {
            eVar.cxR = bcn;
        }
        this.iXh.put(1, eVar);
        if (!StringUtils.isNull(eVar.cxM)) {
            this.iXd.setText(eVar.cxM);
        }
    }

    private Location bcn() {
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
            this.iXg = onClickListener;
        }
    }

    public void ckO() {
        ckQ();
        if (!f.asg()) {
            this.iXe.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iXf.size()) {
                this.iXe.addView(this.iXf.get(i2), new ViewGroup.LayoutParams(ejN, ejO));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.asg()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            ckO();
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
                ckP();
                aMj();
                i.ab(this.mContext).registerListener(this.ceW);
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
            this.iXi = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.ceW);
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
        if (this.iXh.size() != 0) {
            if (id == R.id.btnShareCancel || !this.iXi) {
                this.iXi = true;
                e zh = zh(1);
                f fVar = new f(this.mContext, null);
                if (zh != null && zh.cym) {
                    TiebaStatic.log(new an("c13531").bS("obj_id", zh.cyn).O("obj_type", zh.cyo).bS("obj_source", zh.cyp));
                }
                if (id == R.id.btnShareCancel) {
                    j("share_cancel", new Object[0]);
                    if (zh != null && zh.cxH) {
                        a(zh, 16);
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
                    zi(3);
                    e zh2 = zh(3);
                    a(zh2, 4);
                    if (zh2 != null) {
                        if (zh2.cyj == 1) {
                            o(zh2);
                        } else {
                            fVar.e(zh2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_pyq", new Object[0]);
                    zi(2);
                    e zh3 = zh(2);
                    a(zh3, 3);
                    if (zh3 != null) {
                        if (zh3.cyj == 1) {
                            o(zh3);
                            return;
                        }
                        if (zh3.cxC) {
                            zh3.content = "【" + zh3.title + "】 " + zh3.content;
                        }
                        fVar.f(zh3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        j("share_to_qzone", new Object[0]);
                        zi(4);
                        e zh4 = zh(4);
                        a(zh4, 5);
                        if (zh4 != null) {
                            fVar.h(zh4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akR();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_qweibo", new Object[0]);
                    zi(5);
                    e zh5 = zh(5);
                    a(zh5, 6);
                    if (zh5 != null) {
                        if (!zh5.cxB) {
                            zh5.content = m(zh5);
                        }
                        fVar.i(zh5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_sweibo", new Object[0]);
                    zi(6);
                    e zh6 = zh(6);
                    a(zh6, 7);
                    if (zh6 != null) {
                        if (!zh6.cxB) {
                            zh6.content = m(zh6);
                        }
                        fVar.j(zh6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_renren", new Object[0]);
                    zi(7);
                    e zh7 = zh(7);
                    a(zh7, 8);
                    if (zh7 != null) {
                        if (!zh7.cxB) {
                            zh7.content = m(zh7);
                        }
                        fVar.k(zh7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq_n_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        j("share_to_qq_friend", new Object[0]);
                        zi(8);
                        e zh8 = zh(8);
                        a(zh8, 9);
                        if (zh8 != null) {
                            fVar.g(zh8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akR();
                    }
                } else if (i == R.drawable.icon_share_download_n_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        a(zh, 17);
                        String uri = zh.imageUri.toString();
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
                    a(zh, 10);
                    if (this.iXg != null) {
                        this.iXg.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(zh.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(zh);
                    if (zh != null && zh.cxB) {
                        aD(8, zh.cxS);
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
            aVar.akM();
        }
    }

    private void n(e eVar) {
        an O = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).O("obj_source", 7);
        if (eVar.cxW != 0) {
            O.O("obj_param1", eVar.cxW);
            if (eVar.cxW == 2) {
                O.bS("fid", eVar.fid);
            } else if (eVar.cxW == 3) {
                if (eVar.cya != 0) {
                    O.O("obj_type", eVar.cya);
                }
                O.bS("tid", eVar.tid).bS("fid", eVar.fid);
            }
        }
        TiebaStatic.log(O);
    }

    private e zh(int i) {
        e eVar = this.iXh.get(i);
        if (eVar == null) {
            return this.iXh.get(1);
        }
        return eVar;
    }

    private void zi(int i) {
        if (i <= 8 && i > 0) {
            this.iXi = true;
            if (this.iXk != null) {
                w wVar = this.iXk.get(i);
                if (!StringUtils.isNull(wVar.apo()) && wVar.app() != null && wVar.app().size() > 0) {
                    j(wVar.apo(), wVar.app());
                    return;
                }
            }
            if (this.iXj != null) {
                String str = this.iXj.get(i);
                if (!aq.isEmpty(str)) {
                    j(str, new Object[0]);
                }
            }
        }
    }

    private void j(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aD(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(e eVar, int i) {
        String str;
        if (eVar != null && eVar.extData != null) {
            if (eVar.cxC) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("fid", eVar.extData).O("obj_type", i));
            } else if (eVar.cxD || eVar.cxG) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("tid", eVar.extData).O("obj_type", i).O("obj_source", eVar.cxV).O("obj_param1", eVar.cxW).bS("fid", eVar.fid));
            } else if (eVar.cxE) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).bS("tid", eVar.extData).O("obj_type", i));
            } else if (eVar.cxB) {
                aD(i, eVar.cxS);
            } else if (eVar.cxF) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_param1", 7).O("obj_type", i).bS("fid", eVar.extData));
            } else if (eVar.cxH) {
                an O = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_type", i);
                if (!aq.isEmpty(eVar.linkUrl)) {
                    if (eVar.linkUrl.contains("worldcup")) {
                        O.O("obj_param1", 9);
                    }
                    O.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
                }
                TiebaStatic.log(O);
            } else if (eVar.cxJ) {
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
    public void ckP() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.iXd, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.iXc, R.color.cp_cont_j, 1);
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

    private boolean zj(int i) {
        return (i & 1) > 0;
    }

    private boolean zk(int i) {
        return (i & 2) > 0;
    }

    private boolean zn(int i) {
        return (i & 4) > 0;
    }

    private boolean zl(int i) {
        return (i & 8) > 0;
    }

    private boolean zm(int i) {
        return (i & 16) > 0;
    }

    private boolean zo(int i) {
        return (i & 32) > 0;
    }
}
