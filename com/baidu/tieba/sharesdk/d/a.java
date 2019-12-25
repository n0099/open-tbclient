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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private View.OnClickListener jRA;
    private SparseArray<String> jRD;
    private SparseArray<w> jRE;
    private final TextView jRw;
    private ShareGridLayout jRy;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int fab = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int fac = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jRt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jRu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jRv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dmj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jRB = new SparseArray<>(8);
    private boolean jRC = false;
    private final List<View> jRz = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView jRx = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jRx.setText(sharePanelText);
        }
        this.jRy = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jRy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.kpk;
            marginLayoutParams.rightMargin = ShareGridLayout.kpk;
            this.jRy.setLayoutParams(marginLayoutParams);
        }
        this.jRy.setItemParams(fab, fac);
        this.jRw = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jRw.setOnClickListener(this);
        if (!BF(i)) {
            cE(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!BG(i)) {
            cE(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!BH(i)) {
            cE(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!BI(i)) {
            cE(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!e.aJF()) {
            this.jRy.setVisibility(8);
        }
    }

    private void bdH() {
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

    private void cE(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jRt, jRt);
        layoutParams.topMargin = jRu;
        layoutParams.bottomMargin = jRv;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dmj);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.jRz.add(linearLayout);
    }

    public LinearLayout cF(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jRt, jRt);
        layoutParams.topMargin = jRu;
        layoutParams.bottomMargin = jRv;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dmj);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cEV() {
        if (this.jRz == null) {
            return 0;
        }
        return this.jRz.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jRz.size() && i >= 0) {
            this.jRz.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0592a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class View$OnClickListenerC0592a implements View.OnClickListener {
        private View.OnClickListener jRG;

        public View$OnClickListenerC0592a(View.OnClickListener onClickListener) {
            this.jRG = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.jRG != null) {
                this.jRG.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location btK;
        if (z && (btK = btK()) != null) {
            shareItem.location = btK;
        }
        this.jRB.put(1, shareItem);
    }

    private Location btK() {
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
            this.jRA = onClickListener;
        }
    }

    public void cEW() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jRz.size()) {
                this.jRy.addView(this.jRz.get(i2), new ViewGroup.LayoutParams(fab, fac));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!e.aJF()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cEW();
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
            cEX();
            bdH();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jRC = false;
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
        if (this.jRB.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.jRC) {
                this.jRC = true;
                e eVar = new e(this.mContext, null);
                ShareItem BD = BD(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    BE(3);
                    ShareItem BD2 = BD(3);
                    a(BD2, 4);
                    if (BD2 != null) {
                        eVar.e(BD2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BE(2);
                    ShareItem BD3 = BD(2);
                    a(BD3, 3);
                    if (BD3 != null) {
                        if (BD3.dlp) {
                            BD3.content = "【" + BD3.title + "】 " + BD3.content;
                        }
                        eVar.f(BD3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        BE(4);
                        ShareItem BD4 = BD(4);
                        a(BD4, 5);
                        if (BD4 != null) {
                            eVar.h(BD4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCb();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    BE(5);
                    ShareItem BD5 = BD(5);
                    a(BD5, 6);
                    if (BD5 != null) {
                        if (!BD5.dlo) {
                            BD5.content = m(BD5);
                        }
                        eVar.i(BD5);
                    }
                } else if (i == R.drawable.icon_share_weibo_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BE(6);
                    ShareItem BD6 = BD(6);
                    a(BD6, 7);
                    if (BD6 != null) {
                        if (!BD6.dlo) {
                            BD6.content = m(BD6);
                        }
                        eVar.j(BD6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    BE(7);
                    ShareItem BD7 = BD(7);
                    a(BD7, 8);
                    if (BD7 != null) {
                        if (!BD7.dlo) {
                            BD7.content = m(BD7);
                        }
                        eVar.k(BD7);
                    }
                } else if (i == R.drawable.icon_share_qq_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        BE(8);
                        ShareItem BD8 = BD(8);
                        a(BD8, 9);
                        if (BD8 != null) {
                            eVar.g(BD8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCb();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(BD, 10);
                    if (this.jRA != null) {
                        this.jRA.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BD.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BD);
                    if (BD != null && BD.dlo) {
                        aT(8, BD.dlB);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 7);
        if (shareItem.dlF != 0) {
            Z.Z("obj_param1", shareItem.dlF);
            if (shareItem.dlF == 2) {
                Z.cp("fid", shareItem.fid);
            } else if (shareItem.dlF == 3) {
                if (shareItem.dlJ != 0) {
                    Z.Z("obj_type", shareItem.dlJ);
                }
                Z.cp("tid", shareItem.tid).cp("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(Z);
    }

    private ShareItem BD(int i) {
        ShareItem shareItem = this.jRB.get(i);
        if (shareItem == null) {
            return this.jRB.get(1);
        }
        return shareItem;
    }

    private void BE(int i) {
        if (i <= 8 && i > 0) {
            this.jRC = true;
            if (this.jRE != null) {
                w wVar = this.jRE.get(i);
                if (!StringUtils.isNull(wVar.aGN()) && wVar.aGO() != null && wVar.aGO().size() > 0) {
                    h(wVar.aGN(), wVar.aGO());
                    return;
                }
            }
            if (this.jRD != null) {
                String str = this.jRD.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aT(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dlp) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlq || shareItem.dlt) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).Z("obj_type", i).Z("obj_source", shareItem.dlE).Z("obj_param1", shareItem.dlF).cp("fid", shareItem.fid));
            } else if (shareItem.dlr) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cp("tid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlo) {
                aT(i, shareItem.dlB);
            } else if (shareItem.dls) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_param1", 7).Z("obj_type", i).cp("fid", shareItem.extData));
            } else if (shareItem.dlu) {
                an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    Z.Z("obj_param1", 9);
                }
                TiebaStatic.log(Z);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cEX() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean BF(int i) {
        return (i & 1) > 0;
    }

    private boolean BG(int i) {
        return (i & 2) > 0;
    }

    private boolean BH(int i) {
        return (i & 8) > 0;
    }

    private boolean BI(int i) {
        return (i & 16) > 0;
    }
}
