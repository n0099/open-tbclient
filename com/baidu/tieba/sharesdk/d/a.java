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
    private final TextView iXT;
    private ShareGridLayout iXV;
    private View.OnClickListener iXX;
    private SparseArray<String> iYa;
    private SparseArray<w> iYb;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int ekE = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int ekF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iXQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iXR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iXS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int czs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iXY = new SparseArray<>(8);
    private boolean iXZ = false;
    private final List<View> iXW = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView iXU = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
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
        if (!zk(i)) {
            cm(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!zl(i)) {
            cm(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!zm(i)) {
            cm(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!zn(i)) {
            cm(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!f.asi()) {
            this.iXV.setVisibility(8);
        }
    }

    private void aMl() {
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

    private void cm(int i, int i2) {
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
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.iXW.add(linearLayout);
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
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
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
                view.setOnClickListener(new View$OnClickListenerC0513a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0513a implements View.OnClickListener {
        private View.OnClickListener iYd;

        public View$OnClickListenerC0513a(View.OnClickListener onClickListener) {
            this.iYd = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.iYd != null) {
                this.iYd.onClick(view);
            }
        }
    }

    public void a(e eVar, boolean z) {
        Location bcp;
        if (z && (bcp = bcp()) != null) {
            eVar.cyI = bcp;
        }
        this.iXY.put(1, eVar);
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
            ckR();
            aMl();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iXZ = false;
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
        if (this.iXY.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.iXZ) {
                this.iXZ = true;
                f fVar = new f(this.mContext, null);
                e zi = zi(1);
                if (id == R.id.btnShareCancel) {
                    j("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_weixin", new Object[0]);
                    zj(3);
                    e zi2 = zi(3);
                    a(zi2, 4);
                    if (zi2 != null) {
                        fVar.e(zi2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    j("share_to_pyq", new Object[0]);
                    zj(2);
                    e zi3 = zi(2);
                    a(zi3, 3);
                    if (zi3 != null) {
                        if (zi3.cyt) {
                            zi3.content = "【" + zi3.title + "】 " + zi3.content;
                        }
                        fVar.f(zi3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
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
                } else if (i == R.drawable.icon_share_weibo_selector) {
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
                } else if (i == R.drawable.icon_share_qq_selector) {
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
                } else if (i == R.drawable.icon_copy_link) {
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
                if (!aq.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    O.O("obj_param1", 9);
                }
                TiebaStatic.log(O);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void ckR() {
    }

    private String m(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private boolean zk(int i) {
        return (i & 1) > 0;
    }

    private boolean zl(int i) {
        return (i & 2) > 0;
    }

    private boolean zm(int i) {
        return (i & 8) > 0;
    }

    private boolean zn(int i) {
        return (i & 16) > 0;
    }
}
