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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView lur;
    private ShareGridLayout lut;
    private View.OnClickListener luv;
    private SparseArray<String> luy;
    private SparseArray<ab> luz;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int gmk = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int gml = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int luo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lup = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int luq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eoo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> luw = new SparseArray<>(8);
    private boolean lux = false;
    private final List<View> luu = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView lus = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lus.setText(sharePanelText);
        }
        this.lut = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lut.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lTv;
            marginLayoutParams.rightMargin = ShareGridLayout.lTv;
            this.lut.setLayoutParams(marginLayoutParams);
        }
        this.lut.setItemParams(gmk, gml);
        this.lur = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lur.setOnClickListener(this);
        if (!En(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Eo(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Ep(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Eq(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!f.bdk()) {
            this.lut.setVisibility(8);
        }
    }

    private void byy() {
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

    private void a(com.baidu.tbadk.core.util.d.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.aXq().lG(1).lH(R.color.cp_bg_line_i).aR(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(luo, luo);
            layoutParams.topMargin = lup;
            layoutParams.bottomMargin = luq;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eoo);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.luu.add(linearLayout);
        }
    }

    public LinearLayout cY(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.aXq().lG(1).lH(R.color.cp_bg_line_i).aR(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(luo, luo);
        layoutParams.topMargin = lup;
        layoutParams.bottomMargin = luq;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eoo);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dei() {
        if (this.luu == null) {
            return 0;
        }
        return this.luu.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.luu.size() && i >= 0) {
            this.luu.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0736a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC0736a implements View.OnClickListener {
        private View.OnClickListener luB;

        public View$OnClickListenerC0736a(View.OnClickListener onClickListener) {
            this.luB = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.luB != null) {
                this.luB.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bPK;
        if (z && (bPK = bPK()) != null) {
            shareItem.location = bPK;
        }
        this.luw.put(1, shareItem);
    }

    private Location bPK() {
        if (ac.checkLocationForGoogle(this.mContext)) {
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
            this.luv = onClickListener;
        }
    }

    public void dej() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.luu.size()) {
                this.lut.addView(this.luu.get(i2), new ViewGroup.LayoutParams(gmk, gml));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.bdk()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dej();
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
            dek();
            byy();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.lux = false;
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
        if (this.luw.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.lux) {
                this.lux = true;
                f fVar = new f(this.mContext, null);
                ShareItem El = El(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    Em(3);
                    ShareItem El2 = El(3);
                    a(El2, 4);
                    if (El2 != null) {
                        fVar.f(El2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Em(2);
                    ShareItem El3 = El(2);
                    a(El3, 3);
                    if (El3 != null) {
                        if (El3.enq) {
                            El3.content = "【" + El3.title + "】 " + El3.content;
                        }
                        fVar.g(El3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Em(4);
                        ShareItem El4 = El(4);
                        a(El4, 5);
                        if (El4 != null) {
                            fVar.i(El4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aUS();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Em(5);
                    ShareItem El5 = El(5);
                    a(El5, 6);
                    if (El5 != null) {
                        if (!El5.enp) {
                            El5.content = m(El5);
                        }
                        fVar.j(El5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Em(6);
                    ShareItem El6 = El(6);
                    a(El6, 7);
                    if (El6 != null) {
                        if (!El6.enp) {
                            El6.content = m(El6);
                        }
                        fVar.k(El6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Em(7);
                    ShareItem El7 = El(7);
                    a(El7, 8);
                    if (El7 != null) {
                        if (!El7.enp) {
                            El7.content = m(El7);
                        }
                        fVar.l(El7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Em(8);
                        ShareItem El8 = El(8);
                        a(El8, 9);
                        if (El8 != null) {
                            fVar.h(El8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aUS();
                    }
                } else if (i == 10) {
                    a(El, 10);
                    if (this.luv != null) {
                        this.luv.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(El.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(El);
                    if (El != null && El.enp) {
                        by(8, El.enD);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        ao ag = new ao(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 7);
        if (shareItem.enH != 0) {
            ag.ag("obj_param1", shareItem.enH);
            if (shareItem.enH == 2) {
                ag.dk("fid", shareItem.fid);
            } else if (shareItem.enH == 3) {
                if (shareItem.enL != 0) {
                    ag.ag("obj_type", shareItem.enL);
                }
                ag.dk("tid", shareItem.tid).dk("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ag);
    }

    private ShareItem El(int i) {
        ShareItem shareItem = this.luw.get(i);
        if (shareItem == null) {
            return this.luw.get(1);
        }
        return shareItem;
    }

    private void Em(int i) {
        if (i <= 8 && i > 0) {
            this.lux = true;
            if (this.luz != null) {
                ab abVar = this.luz.get(i);
                if (!StringUtils.isNull(abVar.bao()) && abVar.bap() != null && abVar.bap().size() > 0) {
                    h(abVar.bao(), abVar.bap());
                    return;
                }
            }
            if (this.luy != null) {
                String str = this.luy.get(i);
                if (!ar.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void by(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.enq) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("fid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.enr || shareItem.enu) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("tid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.enG).ag("obj_param1", shareItem.enH).dk("fid", shareItem.fid));
            } else if (shareItem.ens) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dk("tid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.enp) {
                by(i, shareItem.enD);
            } else if (shareItem.ent) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_param1", 7).ag("obj_type", i).dk("fid", shareItem.extData));
            } else if (shareItem.enw) {
                ao ag = new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i);
                if (!ar.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ag.ag("obj_param1", 9);
                }
                TiebaStatic.log(ag);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dek() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean En(int i) {
        return (i & 1) > 0;
    }

    private boolean Eo(int i) {
        return (i & 2) > 0;
    }

    private boolean Ep(int i) {
        return (i & 8) > 0;
    }

    private boolean Eq(int i) {
        return (i & 16) > 0;
    }
}
