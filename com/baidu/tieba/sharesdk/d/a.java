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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView lBK;
    private ShareGridLayout lBM;
    private View.OnClickListener lBO;
    private SparseArray<String> lBR;
    private SparseArray<ab> lBS;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int gri = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int grj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lBH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lBI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lBJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int euD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> lBP = new SparseArray<>(8);
    private boolean lBQ = false;
    private final List<View> lBN = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView lBL = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lBL.setText(sharePanelText);
        }
        this.lBM = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lBM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.maN;
            marginLayoutParams.rightMargin = ShareGridLayout.maN;
            this.lBM.setLayoutParams(marginLayoutParams);
        }
        this.lBM.setItemParams(gri, grj);
        this.lBK = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lBK.setOnClickListener(this);
        if (!EJ(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!EK(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!EL(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!EM(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bgR()) {
            this.lBM.setVisibility(8);
        }
    }

    private void bBM() {
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
                com.baidu.tbadk.core.util.e.a.bbr().ma(1).mb(R.color.cp_bg_line_i).aX(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lBH, lBH);
            layoutParams.topMargin = lBI;
            layoutParams.bottomMargin = lBJ;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, euD);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.lBN.add(linearLayout);
        }
    }

    public LinearLayout da(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.bbr().ma(1).mb(R.color.cp_bg_line_i).aX(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lBH, lBH);
        layoutParams.topMargin = lBI;
        layoutParams.bottomMargin = lBJ;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, euD);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dhr() {
        if (this.lBN == null) {
            return 0;
        }
        return this.lBN.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.lBN.size() && i >= 0) {
            this.lBN.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0746a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class View$OnClickListenerC0746a implements View.OnClickListener {
        private View.OnClickListener lBU;

        public View$OnClickListenerC0746a(View.OnClickListener onClickListener) {
            this.lBU = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.lBU != null) {
                this.lBU.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bSV;
        if (z && (bSV = bSV()) != null) {
            shareItem.location = bSV;
        }
        this.lBP.put(1, shareItem);
    }

    private Location bSV() {
        if (ad.checkLocationForGoogle(this.mContext)) {
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
            this.lBO = onClickListener;
        }
    }

    public void dhs() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lBN.size()) {
                this.lBM.addView(this.lBN.get(i2), new ViewGroup.LayoutParams(gri, grj));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bgR()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dhs();
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
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            dht();
            bBM();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.lBQ = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
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
        if (this.lBP.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.lBQ) {
                this.lBQ = true;
                g gVar = new g(this.mContext, null);
                ShareItem EH = EH(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    EI(3);
                    ShareItem EH2 = EH(3);
                    a(EH2, 4);
                    if (EH2 != null) {
                        gVar.f(EH2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    EI(2);
                    ShareItem EH3 = EH(2);
                    a(EH3, 3);
                    if (EH3 != null) {
                        if (EH3.etD) {
                            EH3.content = "【" + EH3.title + "】 " + EH3.content;
                        }
                        gVar.g(EH3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        EI(4);
                        ShareItem EH4 = EH(4);
                        a(EH4, 5);
                        if (EH4 != null) {
                            gVar.i(EH4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    EI(5);
                    ShareItem EH5 = EH(5);
                    a(EH5, 6);
                    if (EH5 != null) {
                        if (!EH5.etC) {
                            EH5.content = m(EH5);
                        }
                        gVar.j(EH5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    EI(6);
                    ShareItem EH6 = EH(6);
                    a(EH6, 7);
                    if (EH6 != null) {
                        if (!EH6.etC) {
                            EH6.content = m(EH6);
                        }
                        gVar.k(EH6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    EI(7);
                    ShareItem EH7 = EH(7);
                    a(EH7, 8);
                    if (EH7 != null) {
                        if (!EH7.etC) {
                            EH7.content = m(EH7);
                        }
                        gVar.l(EH7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        EI(8);
                        ShareItem EH8 = EH(8);
                        a(EH8, 9);
                        if (EH8 != null) {
                            gVar.h(EH8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
                    }
                } else if (i == 10) {
                    a(EH, 10);
                    if (this.lBO != null) {
                        this.lBO.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(EH.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(EH);
                    if (EH != null && EH.etC) {
                        bz(8, EH.etP);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        ap ah = new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ah("obj_source", 7);
        if (shareItem.etT != 0) {
            ah.ah("obj_param1", shareItem.etT);
            if (shareItem.etT == 2) {
                ah.dn("fid", shareItem.fid);
            } else if (shareItem.etT == 3) {
                if (shareItem.etX != 0) {
                    ah.ah("obj_type", shareItem.etX);
                }
                ah.dn("tid", shareItem.tid).dn("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ah);
    }

    private ShareItem EH(int i) {
        ShareItem shareItem = this.lBP.get(i);
        if (shareItem == null) {
            return this.lBP.get(1);
        }
        return shareItem;
    }

    private void EI(int i) {
        if (i <= 8 && i > 0) {
            this.lBQ = true;
            if (this.lBS != null) {
                ab abVar = this.lBS.get(i);
                if (!StringUtils.isNull(abVar.bel()) && abVar.bem() != null && abVar.bem().size() > 0) {
                    h(abVar.bel(), abVar.bem());
                    return;
                }
            }
            if (this.lBR != null) {
                String str = this.lBR.get(i);
                if (!as.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bz(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.etD) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("fid", shareItem.extData).ah("obj_type", i));
            } else if (shareItem.etE || shareItem.etH) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("tid", shareItem.extData).ah("obj_type", i).ah("obj_source", shareItem.etS).ah("obj_param1", shareItem.etT).dn("fid", shareItem.fid));
            } else if (shareItem.etF) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dn("tid", shareItem.extData).ah("obj_type", i));
            } else if (shareItem.etC) {
                bz(i, shareItem.etP);
            } else if (shareItem.etG) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_param1", 7).ah("obj_type", i).dn("fid", shareItem.extData));
            } else if (shareItem.etI) {
                ap ah = new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_type", i);
                if (!as.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ah.ah("obj_param1", 9);
                }
                TiebaStatic.log(ah);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dht() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean EJ(int i) {
        return (i & 1) > 0;
    }

    private boolean EK(int i) {
        return (i & 2) > 0;
    }

    private boolean EL(int i) {
        return (i & 8) > 0;
    }

    private boolean EM(int i) {
        return (i & 16) > 0;
    }
}
