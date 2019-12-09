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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
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
    private static final int ejN = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int ejO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iWZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iXa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iXb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int cyB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iXh = new SparseArray<>(8);
    private boolean iXi = false;
    private final List<View> iXf = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView iXd = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
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
        if (!zj(i)) {
            ck(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!zk(i)) {
            ck(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!zl(i)) {
            ck(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!zm(i)) {
            ck(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!f.asg()) {
            this.iXe.setVisibility(8);
        }
    }

    private void aMj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.mDialog != null && a.this.mDialog.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void ck(int i, int i2) {
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
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.iXf.add(linearLayout);
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
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
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
                view.setOnClickListener(new View$OnClickListenerC0508a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0508a implements View.OnClickListener {
        private View.OnClickListener iXm;

        public View$OnClickListenerC0508a(View.OnClickListener onClickListener) {
            this.iXm = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.iXm != null) {
                this.iXm.onClick(view);
            }
        }
    }

    public void a(e eVar, boolean z) {
        Location bcn;
        if (z && (bcn = bcn()) != null) {
            eVar.cxR = bcn;
        }
        this.iXh.put(1, eVar);
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
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            if (this.mContext instanceof Activity) {
                g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background);
            ckP();
            aMj();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iXi = false;
            if (this.mContext instanceof Activity) {
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
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
            if (view.getId() == R.id.btnShareCancel || !this.iXi) {
                this.iXi = true;
                f fVar = new f(this.mContext, null);
                e zh = zh(1);
                if (id == R.id.btnShareCancel) {
                    j("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_weixin", new Object[0]);
                    zi(3);
                    e zh2 = zh(3);
                    a(zh2, 4);
                    if (zh2 != null) {
                        fVar.e(zh2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_pyq", new Object[0]);
                    zi(2);
                    e zh3 = zh(2);
                    a(zh3, 3);
                    if (zh3 != null) {
                        if (zh3.cxC) {
                            zh3.content = "【" + zh3.title + "】 " + zh3.content;
                        }
                        fVar.f(zh3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
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
                } else if (i == R.drawable.icon_share_weibo_selector) {
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
                } else if (i == R.drawable.icon_share_qq_selector) {
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
                } else if (i == R.drawable.icon_copy_link) {
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
                if (!aq.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    O.O("obj_param1", 9);
                }
                TiebaStatic.log(O);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void ckP() {
    }

    private String m(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private boolean zj(int i) {
        return (i & 1) > 0;
    }

    private boolean zk(int i) {
        return (i & 2) > 0;
    }

    private boolean zl(int i) {
        return (i & 8) > 0;
    }

    private boolean zm(int i) {
        return (i & 16) > 0;
    }
}
