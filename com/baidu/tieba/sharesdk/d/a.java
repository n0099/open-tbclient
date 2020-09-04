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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView lTE;
    private ShareGridLayout lTG;
    private View.OnClickListener lTI;
    private SparseArray<String> lTL;
    private SparseArray<ae> lTM;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int gEg = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int gEh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lTB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lTC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lTD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eFg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> lTJ = new SparseArray<>(8);
    private boolean lTK = false;
    private final List<View> lTH = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView lTF = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lTF.setText(sharePanelText);
        }
        this.lTG = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lTG.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.msQ;
            marginLayoutParams.rightMargin = ShareGridLayout.msQ;
            this.lTG.setLayoutParams(marginLayoutParams);
        }
        this.lTG.setItemParams(gEg, gEh);
        this.lTE = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lTE.setOnClickListener(this);
        if (!Hg(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Hh(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Hi(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Hj(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bpE()) {
            this.lTG.setVisibility(8);
        }
    }

    private void bLh() {
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
                com.baidu.tbadk.core.util.e.a.bjQ().oe(1).of(R.color.cp_bg_line_i).aZ(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTB, lTB);
            layoutParams.topMargin = lTC;
            layoutParams.bottomMargin = lTD;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eFg);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.lTH.add(linearLayout);
        }
    }

    public LinearLayout di(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(1).of(R.color.cp_bg_line_i).aZ(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTB, lTB);
        layoutParams.topMargin = lTC;
        layoutParams.bottomMargin = lTD;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eFg);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dsS() {
        if (this.lTH == null) {
            return 0;
        }
        return this.lTH.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.lTH.size() && i >= 0) {
            this.lTH.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0799a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class View$OnClickListenerC0799a implements View.OnClickListener {
        private View.OnClickListener lTO;

        public View$OnClickListenerC0799a(View.OnClickListener onClickListener) {
            this.lTO = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.lTO != null) {
                this.lTO.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cdi;
        if (z && (cdi = cdi()) != null) {
            shareItem.location = cdi;
        }
        this.lTJ.put(1, shareItem);
    }

    private Location cdi() {
        if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(this.mContext)) {
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
            this.lTI = onClickListener;
        }
    }

    public void dsT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lTH.size()) {
                this.lTG.addView(this.lTH.get(i2), new ViewGroup.LayoutParams(gEg, gEh));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!g.bpE()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dsT();
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
            dsU();
            bLh();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.lTK = false;
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
        if (this.lTJ.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.lTK) {
                this.lTK = true;
                g gVar = new g(this.mContext, null);
                ShareItem He = He(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    Hf(3);
                    ShareItem He2 = He(3);
                    a(He2, 4);
                    if (He2 != null) {
                        gVar.f(He2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Hf(2);
                    ShareItem He3 = He(2);
                    a(He3, 3);
                    if (He3 != null) {
                        if (He3.eEf) {
                            He3.content = "【" + He3.title + "】 " + He3.content;
                        }
                        gVar.g(He3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Hf(4);
                        ShareItem He4 = He(4);
                        a(He4, 5);
                        if (He4 != null) {
                            gVar.i(He4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bhm();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Hf(5);
                    ShareItem He5 = He(5);
                    a(He5, 6);
                    if (He5 != null) {
                        if (!He5.eEe) {
                            He5.content = m(He5);
                        }
                        gVar.j(He5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Hf(6);
                    ShareItem He6 = He(6);
                    a(He6, 7);
                    if (He6 != null) {
                        if (!He6.eEe) {
                            He6.content = m(He6);
                        }
                        gVar.k(He6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Hf(7);
                    ShareItem He7 = He(7);
                    a(He7, 8);
                    if (He7 != null) {
                        if (!He7.eEe) {
                            He7.content = m(He7);
                        }
                        gVar.l(He7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Hf(8);
                        ShareItem He8 = He(8);
                        a(He8, 9);
                        if (He8 != null) {
                            gVar.h(He8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bhm();
                    }
                } else if (i == 10) {
                    a(He, 10);
                    if (this.lTI != null) {
                        this.lTI.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(He.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(He);
                    if (He != null && He.eEe) {
                        bw(8, He.eEt);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 9);
        if (shareItem.eEx != 0) {
            ai.ai("obj_param1", shareItem.eEx);
            if (shareItem.eEx == 2) {
                ai.dD("fid", shareItem.fid);
            } else if (shareItem.eEx == 3) {
                if (shareItem.eEB != 0) {
                    ai.ai("obj_type", shareItem.eEB);
                }
                ai.dD("tid", shareItem.tid).dD("fid", shareItem.fid);
            }
        }
        ai.ai("obj_locate", 7);
        TiebaStatic.log(ai);
    }

    private ShareItem He(int i) {
        ShareItem shareItem = this.lTJ.get(i);
        if (shareItem == null) {
            return this.lTJ.get(1);
        }
        return shareItem;
    }

    private void Hf(int i) {
        if (i <= 8 && i > 0) {
            this.lTK = true;
            if (this.lTM != null) {
                ae aeVar = this.lTM.get(i);
                if (!StringUtils.isNull(aeVar.bmV()) && aeVar.bmW() != null && aeVar.bmW().size() > 0) {
                    h(aeVar.bmV(), aeVar.bmW());
                    return;
                }
            }
            if (this.lTL != null) {
                String str = this.lTL.get(i);
                if (!at.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bw(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eEf) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("fid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEg || shareItem.eEj) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("tid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eEw).ai("obj_param1", shareItem.eEx).dD("fid", shareItem.fid));
            } else if (shareItem.eEh) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dD("tid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEe) {
                bw(i, shareItem.eEt);
            } else if (shareItem.eEi) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_param1", 7).ai("obj_type", i).dD("fid", shareItem.extData));
            } else if (shareItem.eEk) {
                aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ai.ai("obj_param1", 9);
                }
                TiebaStatic.log(ai);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dsU() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Hg(int i) {
        return (i & 1) > 0;
    }

    private boolean Hh(int i) {
        return (i & 2) > 0;
    }

    private boolean Hi(int i) {
        return (i & 8) > 0;
    }

    private boolean Hj(int i) {
        return (i & 16) > 0;
    }
}
