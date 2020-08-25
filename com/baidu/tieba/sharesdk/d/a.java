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
    private final TextView lTp;
    private ShareGridLayout lTr;
    private View.OnClickListener lTt;
    private SparseArray<String> lTw;
    private SparseArray<ae> lTx;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int gEc = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int gEd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lTm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lTn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lTo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eFc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> lTu = new SparseArray<>(8);
    private boolean lTv = false;
    private final List<View> lTs = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView lTq = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.lTq.setText(sharePanelText);
        }
        this.lTr = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.lTr.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.msy;
            marginLayoutParams.rightMargin = ShareGridLayout.msy;
            this.lTr.setLayoutParams(marginLayoutParams);
        }
        this.lTr.setItemParams(gEc, gEd);
        this.lTp = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.lTp.setOnClickListener(this);
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
        if (!g.bpD()) {
            this.lTr.setVisibility(8);
        }
    }

    private void bLg() {
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTm, lTm);
            layoutParams.topMargin = lTn;
            layoutParams.bottomMargin = lTo;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eFc);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.lTs.add(linearLayout);
        }
    }

    public LinearLayout di(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(1).of(R.color.cp_bg_line_i).aZ(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTm, lTm);
        layoutParams.topMargin = lTn;
        layoutParams.bottomMargin = lTo;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eFc);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dsN() {
        if (this.lTs == null) {
            return 0;
        }
        return this.lTs.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.lTs.size() && i >= 0) {
            this.lTs.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0799a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class View$OnClickListenerC0799a implements View.OnClickListener {
        private View.OnClickListener lTz;

        public View$OnClickListenerC0799a(View.OnClickListener onClickListener) {
            this.lTz = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.lTz != null) {
                this.lTz.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cdh;
        if (z && (cdh = cdh()) != null) {
            shareItem.location = cdh;
        }
        this.lTu.put(1, shareItem);
    }

    private Location cdh() {
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
            this.lTt = onClickListener;
        }
    }

    public void dsO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lTs.size()) {
                this.lTr.addView(this.lTs.get(i2), new ViewGroup.LayoutParams(gEc, gEd));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bpD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dsO();
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
            dsP();
            bLg();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.lTv = false;
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
        if (this.lTu.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.lTv) {
                this.lTv = true;
                g gVar = new g(this.mContext, null);
                ShareItem He = He(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
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
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Hf(2);
                    ShareItem He3 = He(2);
                    a(He3, 3);
                    if (He3 != null) {
                        if (He3.eEb) {
                            He3.content = "【" + He3.title + "】 " + He3.content;
                        }
                        gVar.g(He3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
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
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Hf(5);
                    ShareItem He5 = He(5);
                    a(He5, 6);
                    if (He5 != null) {
                        if (!He5.eEa) {
                            He5.content = m(He5);
                        }
                        gVar.j(He5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Hf(6);
                    ShareItem He6 = He(6);
                    a(He6, 7);
                    if (He6 != null) {
                        if (!He6.eEa) {
                            He6.content = m(He6);
                        }
                        gVar.k(He6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Hf(7);
                    ShareItem He7 = He(7);
                    a(He7, 8);
                    if (He7 != null) {
                        if (!He7.eEa) {
                            He7.content = m(He7);
                        }
                        gVar.l(He7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
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
                    if (this.lTt != null) {
                        this.lTt.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(He.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(He);
                    if (He != null && He.eEa) {
                        bx(8, He.eEp);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 9);
        if (shareItem.eEt != 0) {
            ai.ai("obj_param1", shareItem.eEt);
            if (shareItem.eEt == 2) {
                ai.dD("fid", shareItem.fid);
            } else if (shareItem.eEt == 3) {
                if (shareItem.eEx != 0) {
                    ai.ai("obj_type", shareItem.eEx);
                }
                ai.dD("tid", shareItem.tid).dD("fid", shareItem.fid);
            }
        }
        ai.ai("obj_locate", 7);
        TiebaStatic.log(ai);
    }

    private ShareItem He(int i) {
        ShareItem shareItem = this.lTu.get(i);
        if (shareItem == null) {
            return this.lTu.get(1);
        }
        return shareItem;
    }

    private void Hf(int i) {
        if (i <= 8 && i > 0) {
            this.lTv = true;
            if (this.lTx != null) {
                ae aeVar = this.lTx.get(i);
                if (!StringUtils.isNull(aeVar.bmV()) && aeVar.bmW() != null && aeVar.bmW().size() > 0) {
                    h(aeVar.bmV(), aeVar.bmW());
                    return;
                }
            }
            if (this.lTw != null) {
                String str = this.lTw.get(i);
                if (!at.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bx(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eEb) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("fid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEc || shareItem.eEf) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("tid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eEs).ai("obj_param1", shareItem.eEt).dD("fid", shareItem.fid));
            } else if (shareItem.eEd) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dD("tid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEa) {
                bx(i, shareItem.eEp);
            } else if (shareItem.eEe) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_param1", 7).ai("obj_type", i).dD("fid", shareItem.extData));
            } else if (shareItem.eEg) {
                aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ai.ai("obj_param1", 9);
                }
                TiebaStatic.log(ai);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dsP() {
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
