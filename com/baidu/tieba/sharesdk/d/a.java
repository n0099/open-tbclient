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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final TextView mdb;
    private ShareGridLayout mdd;
    private View.OnClickListener mdf;
    private SparseArray<String> mdi;
    private SparseArray<af> mdj;
    private static final int gHD = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int gHE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mcY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mcZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mda = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eHn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> mdg = new SparseArray<>(8);
    private boolean mdh = false;
    private final List<View> mde = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView mdc = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mdc.setText(sharePanelText);
        }
        this.mdd = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.mdd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.mCo;
            marginLayoutParams.rightMargin = ShareGridLayout.mCo;
            this.mdd.setLayoutParams(marginLayoutParams);
        }
        this.mdd.setItemParams(gHD, gHE);
        this.mdb = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mdb.setOnClickListener(this);
        if (!HJ(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!HK(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!HL(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!HM(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bqy()) {
            this.mdd.setVisibility(8);
        }
    }

    private void bMr() {
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
                com.baidu.tbadk.core.util.e.a.bkL().oq(1).or(R.color.cp_bg_line_i).bb(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mcY, mcY);
            layoutParams.topMargin = mcZ;
            layoutParams.bottomMargin = mda;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eHn);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.mde.add(linearLayout);
        }
    }

    public LinearLayout dm(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.bkL().oq(1).or(R.color.cp_bg_line_i).bb(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mcY, mcY);
        layoutParams.topMargin = mcZ;
        layoutParams.bottomMargin = mda;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eHn);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dwK() {
        if (this.mde == null) {
            return 0;
        }
        return this.mde.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.mde.size() && i >= 0) {
            this.mde.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0796a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    class View$OnClickListenerC0796a implements View.OnClickListener {
        private View.OnClickListener mdl;

        public View$OnClickListenerC0796a(View.OnClickListener onClickListener) {
            this.mdl = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.mdl != null) {
                this.mdl.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cgx;
        if (z && (cgx = cgx()) != null) {
            shareItem.location = cgx;
        }
        this.mdg.put(1, shareItem);
    }

    private Location cgx() {
        if (ae.checkLocationForGoogle(this.mContext)) {
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
            this.mdf = onClickListener;
        }
    }

    public void dwL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mde.size()) {
                this.mdd.addView(this.mde.get(i2), new ViewGroup.LayoutParams(gHD, gHE));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bqy()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dwL();
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
            dwM();
            bMr();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.mdh = false;
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
        if (this.mdg.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.mdh) {
                this.mdh = true;
                g gVar = new g(this.mContext, null);
                ShareItem HH = HH(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    HI(3);
                    ShareItem HH2 = HH(3);
                    a(HH2, 4);
                    if (HH2 != null) {
                        gVar.f(HH2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    HI(2);
                    ShareItem HH3 = HH(2);
                    a(HH3, 3);
                    if (HH3 != null) {
                        if (HH3.eGl) {
                            HH3.content = "【" + HH3.title + "】 " + HH3.content;
                        }
                        gVar.g(HH3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        HI(4);
                        ShareItem HH4 = HH(4);
                        a(HH4, 5);
                        if (HH4 != null) {
                            gVar.i(HH4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).big();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    HI(5);
                    ShareItem HH5 = HH(5);
                    a(HH5, 6);
                    if (HH5 != null) {
                        if (!HH5.eGk) {
                            HH5.content = m(HH5);
                        }
                        gVar.j(HH5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    HI(6);
                    ShareItem HH6 = HH(6);
                    a(HH6, 7);
                    if (HH6 != null) {
                        if (!HH6.eGk) {
                            HH6.content = m(HH6);
                        }
                        gVar.k(HH6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    HI(7);
                    ShareItem HH7 = HH(7);
                    a(HH7, 8);
                    if (HH7 != null) {
                        if (!HH7.eGk) {
                            HH7.content = m(HH7);
                        }
                        gVar.l(HH7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        HI(8);
                        ShareItem HH8 = HH(8);
                        a(HH8, 9);
                        if (HH8 != null) {
                            gVar.h(HH8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).big();
                    }
                } else if (i == 10) {
                    a(HH, 10);
                    if (this.mdf != null) {
                        this.mdf.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(HH.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(HH);
                    if (HH != null && HH.eGk) {
                        bA(8, HH.eGz);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 9);
        if (shareItem.eGD != 0) {
            ai.ai("obj_param1", shareItem.eGD);
            if (shareItem.eGD == 2) {
                ai.dF("fid", shareItem.fid);
            } else if (shareItem.eGD == 3) {
                if (shareItem.eGH != 0) {
                    ai.ai("obj_type", shareItem.eGH);
                }
                ai.dF("tid", shareItem.tid).dF("fid", shareItem.fid);
            }
        }
        ai.ai("obj_locate", 7);
        TiebaStatic.log(ai);
    }

    private ShareItem HH(int i) {
        ShareItem shareItem = this.mdg.get(i);
        if (shareItem == null) {
            return this.mdg.get(1);
        }
        return shareItem;
    }

    private void HI(int i) {
        if (i <= 8 && i > 0) {
            this.mdh = true;
            if (this.mdj != null) {
                af afVar = this.mdj.get(i);
                if (!StringUtils.isNull(afVar.bnP()) && afVar.bnQ() != null && afVar.bnQ().size() > 0) {
                    f(afVar.bnP(), afVar.bnQ());
                    return;
                }
            }
            if (this.mdi != null) {
                String str = this.mdi.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bA(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eGl) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dF("fid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eGm || shareItem.eGp) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dF("tid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eGC).ai("obj_param1", shareItem.eGD).dF("fid", shareItem.fid));
            } else if (shareItem.eGn) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dF("tid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eGk) {
                bA(i, shareItem.eGz);
            } else if (shareItem.eGo) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_param1", 7).ai("obj_type", i).dF("fid", shareItem.extData));
            } else if (shareItem.eGq) {
                aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ai.ai("obj_param1", 9);
                }
                TiebaStatic.log(ai);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dwM() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean HJ(int i) {
        return (i & 1) > 0;
    }

    private boolean HK(int i) {
        return (i & 2) > 0;
    }

    private boolean HL(int i) {
        return (i & 8) > 0;
    }

    private boolean HM(int i) {
        return (i & 16) > 0;
    }
}
