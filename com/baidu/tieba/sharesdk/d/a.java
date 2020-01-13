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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView jUZ;
    private ShareGridLayout jVb;
    private View.OnClickListener jVd;
    private SparseArray<String> jVg;
    private SparseArray<x> jVh;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int fcP = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int fcQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jUW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jUX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jUY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dmx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jVe = new SparseArray<>(8);
    private boolean jVf = false;
    private final List<View> jVc = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView jVa = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jVa.setText(sharePanelText);
        }
        this.jVb = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jVb.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.ksN;
            marginLayoutParams.rightMargin = ShareGridLayout.ksN;
            this.jVb.setLayoutParams(marginLayoutParams);
        }
        this.jVb.setItemParams(fcP, fcQ);
        this.jUZ = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jUZ.setOnClickListener(this);
        if (!BK(i)) {
            cD(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!BL(i)) {
            cD(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!BM(i)) {
            cD(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!BN(i)) {
            cD(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!e.aJZ()) {
            this.jVb.setVisibility(8);
        }
    }

    private void bec() {
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

    private void cD(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jUW, jUW);
        layoutParams.topMargin = jUX;
        layoutParams.bottomMargin = jUY;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dmx);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.jVc.add(linearLayout);
    }

    public LinearLayout cE(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jUW, jUW);
        layoutParams.topMargin = jUX;
        layoutParams.bottomMargin = jUY;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dmx);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cFZ() {
        if (this.jVc == null) {
            return 0;
        }
        return this.jVc.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jVc.size() && i >= 0) {
            this.jVc.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0597a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class View$OnClickListenerC0597a implements View.OnClickListener {
        private View.OnClickListener jVj;

        public View$OnClickListenerC0597a(View.OnClickListener onClickListener) {
            this.jVj = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.jVj != null) {
                this.jVj.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location buM;
        if (z && (buM = buM()) != null) {
            shareItem.location = buM;
        }
        this.jVe.put(1, shareItem);
    }

    private Location buM() {
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
            this.jVd = onClickListener;
        }
    }

    public void cGa() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jVc.size()) {
                this.jVb.addView(this.jVc.get(i2), new ViewGroup.LayoutParams(fcP, fcQ));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!e.aJZ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cGa();
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
            cGb();
            bec();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jVf = false;
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
        if (this.jVe.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.jVf) {
                this.jVf = true;
                e eVar = new e(this.mContext, null);
                ShareItem BI = BI(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    BJ(3);
                    ShareItem BI2 = BI(3);
                    a(BI2, 4);
                    if (BI2 != null) {
                        eVar.e(BI2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BJ(2);
                    ShareItem BI3 = BI(2);
                    a(BI3, 3);
                    if (BI3 != null) {
                        if (BI3.dlF) {
                            BI3.content = "【" + BI3.title + "】 " + BI3.content;
                        }
                        eVar.f(BI3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        BJ(4);
                        ShareItem BI4 = BI(4);
                        a(BI4, 5);
                        if (BI4 != null) {
                            eVar.h(BI4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCu();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    BJ(5);
                    ShareItem BI5 = BI(5);
                    a(BI5, 6);
                    if (BI5 != null) {
                        if (!BI5.dlE) {
                            BI5.content = m(BI5);
                        }
                        eVar.i(BI5);
                    }
                } else if (i == R.drawable.icon_share_weibo_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BJ(6);
                    ShareItem BI6 = BI(6);
                    a(BI6, 7);
                    if (BI6 != null) {
                        if (!BI6.dlE) {
                            BI6.content = m(BI6);
                        }
                        eVar.j(BI6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    BJ(7);
                    ShareItem BI7 = BI(7);
                    a(BI7, 8);
                    if (BI7 != null) {
                        if (!BI7.dlE) {
                            BI7.content = m(BI7);
                        }
                        eVar.k(BI7);
                    }
                } else if (i == R.drawable.icon_share_qq_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        BJ(8);
                        ShareItem BI8 = BI(8);
                        a(BI8, 9);
                        if (BI8 != null) {
                            eVar.g(BI8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCu();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(BI, 10);
                    if (this.jVd != null) {
                        this.jVd.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BI.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BI);
                    if (BI != null && BI.dlE) {
                        aZ(8, BI.dlR);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 7);
        if (shareItem.dlV != 0) {
            Z.Z("obj_param1", shareItem.dlV);
            if (shareItem.dlV == 2) {
                Z.cp("fid", shareItem.fid);
            } else if (shareItem.dlV == 3) {
                if (shareItem.dlZ != 0) {
                    Z.Z("obj_type", shareItem.dlZ);
                }
                Z.cp("tid", shareItem.tid).cp("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(Z);
    }

    private ShareItem BI(int i) {
        ShareItem shareItem = this.jVe.get(i);
        if (shareItem == null) {
            return this.jVe.get(1);
        }
        return shareItem;
    }

    private void BJ(int i) {
        if (i <= 8 && i > 0) {
            this.jVf = true;
            if (this.jVh != null) {
                x xVar = this.jVh.get(i);
                if (!StringUtils.isNull(xVar.aHh()) && xVar.aHi() != null && xVar.aHi().size() > 0) {
                    h(xVar.aHh(), xVar.aHi());
                    return;
                }
            }
            if (this.jVg != null) {
                String str = this.jVg.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aZ(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dlF) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlG || shareItem.dlJ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).Z("obj_type", i).Z("obj_source", shareItem.dlU).Z("obj_param1", shareItem.dlV).cp("fid", shareItem.fid));
            } else if (shareItem.dlH) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cp("tid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlE) {
                aZ(i, shareItem.dlR);
            } else if (shareItem.dlI) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_param1", 7).Z("obj_type", i).cp("fid", shareItem.extData));
            } else if (shareItem.dlK) {
                an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    Z.Z("obj_param1", 9);
                }
                TiebaStatic.log(Z);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cGb() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean BK(int i) {
        return (i & 1) > 0;
    }

    private boolean BL(int i) {
        return (i & 2) > 0;
    }

    private boolean BM(int i) {
        return (i & 8) > 0;
    }

    private boolean BN(int i) {
        return (i & 16) > 0;
    }
}
