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
import com.baidu.tbadk.coreExtra.data.y;
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
    private final TextView kZk;
    private ShareGridLayout kZm;
    private View.OnClickListener kZo;
    private SparseArray<String> kZr;
    private SparseArray<y> kZs;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int fZa = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int fZb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int kZh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int kZi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int kZj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int efC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> kZp = new SparseArray<>(8);
    private boolean kZq = false;
    private final List<View> kZn = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView kZl = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.kZl.setText(sharePanelText);
        }
        this.kZm = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.kZm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lyE;
            marginLayoutParams.rightMargin = ShareGridLayout.lyE;
            this.kZm.setLayoutParams(marginLayoutParams);
        }
        this.kZm.setItemParams(fZa, fZb);
        this.kZk = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.kZk.setOnClickListener(this);
        if (!Dj(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Dk(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Dl(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Dm(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!f.bbh()) {
            this.kZm.setVisibility(8);
        }
    }

    private void bvA() {
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
                com.baidu.tbadk.core.util.e.a.aVv().ln(1).lo(R.color.cp_bg_line_i).aR(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kZh, kZh);
            layoutParams.topMargin = kZi;
            layoutParams.bottomMargin = kZj;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, efC);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.kZn.add(linearLayout);
        }
    }

    public LinearLayout cS(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.aVv().ln(1).lo(R.color.cp_bg_line_i).aR(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kZh, kZh);
        layoutParams.topMargin = kZi;
        layoutParams.bottomMargin = kZj;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, efC);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cZB() {
        if (this.kZn == null) {
            return 0;
        }
        return this.kZn.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.kZn.size() && i >= 0) {
            this.kZn.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0719a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC0719a implements View.OnClickListener {
        private View.OnClickListener kZu;

        public View$OnClickListenerC0719a(View.OnClickListener onClickListener) {
            this.kZu = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.kZu != null) {
                this.kZu.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bMC;
        if (z && (bMC = bMC()) != null) {
            shareItem.location = bMC;
        }
        this.kZp.put(1, shareItem);
    }

    private Location bMC() {
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
            this.kZo = onClickListener;
        }
    }

    public void cZC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kZn.size()) {
                this.kZm.addView(this.kZn.get(i2), new ViewGroup.LayoutParams(fZa, fZb));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.bbh()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cZC();
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
            cZD();
            bvA();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.kZq = false;
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
        if (this.kZp.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.kZq) {
                this.kZq = true;
                f fVar = new f(this.mContext, null);
                ShareItem Dh = Dh(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    Di(3);
                    ShareItem Dh2 = Dh(3);
                    a(Dh2, 4);
                    if (Dh2 != null) {
                        fVar.e(Dh2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Di(2);
                    ShareItem Dh3 = Dh(2);
                    a(Dh3, 3);
                    if (Dh3 != null) {
                        if (Dh3.eeG) {
                            Dh3.content = "【" + Dh3.title + "】 " + Dh3.content;
                        }
                        fVar.f(Dh3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Di(4);
                        ShareItem Dh4 = Dh(4);
                        a(Dh4, 5);
                        if (Dh4 != null) {
                            fVar.h(Dh4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aSY();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Di(5);
                    ShareItem Dh5 = Dh(5);
                    a(Dh5, 6);
                    if (Dh5 != null) {
                        if (!Dh5.eeF) {
                            Dh5.content = m(Dh5);
                        }
                        fVar.i(Dh5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Di(6);
                    ShareItem Dh6 = Dh(6);
                    a(Dh6, 7);
                    if (Dh6 != null) {
                        if (!Dh6.eeF) {
                            Dh6.content = m(Dh6);
                        }
                        fVar.j(Dh6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Di(7);
                    ShareItem Dh7 = Dh(7);
                    a(Dh7, 8);
                    if (Dh7 != null) {
                        if (!Dh7.eeF) {
                            Dh7.content = m(Dh7);
                        }
                        fVar.k(Dh7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Di(8);
                        ShareItem Dh8 = Dh(8);
                        a(Dh8, 9);
                        if (Dh8 != null) {
                            fVar.g(Dh8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aSY();
                    }
                } else if (i == 10) {
                    a(Dh, 10);
                    if (this.kZo != null) {
                        this.kZo.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Dh.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Dh);
                    if (Dh != null && Dh.eeF) {
                        bt(8, Dh.eeS);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an ag = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 7);
        if (shareItem.eeW != 0) {
            ag.ag("obj_param1", shareItem.eeW);
            if (shareItem.eeW == 2) {
                ag.dh("fid", shareItem.fid);
            } else if (shareItem.eeW == 3) {
                if (shareItem.efa != 0) {
                    ag.ag("obj_type", shareItem.efa);
                }
                ag.dh("tid", shareItem.tid).dh("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ag);
    }

    private ShareItem Dh(int i) {
        ShareItem shareItem = this.kZp.get(i);
        if (shareItem == null) {
            return this.kZp.get(1);
        }
        return shareItem;
    }

    private void Di(int i) {
        if (i <= 8 && i > 0) {
            this.kZq = true;
            if (this.kZs != null) {
                y yVar = this.kZs.get(i);
                if (!StringUtils.isNull(yVar.aYi()) && yVar.aYj() != null && yVar.aYj().size() > 0) {
                    h(yVar.aYi(), yVar.aYj());
                    return;
                }
            }
            if (this.kZr != null) {
                String str = this.kZr.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bt(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eeG) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("fid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.eeH || shareItem.eeK) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("tid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.eeV).ag("obj_param1", shareItem.eeW).dh("fid", shareItem.fid));
            } else if (shareItem.eeI) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dh("tid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.eeF) {
                bt(i, shareItem.eeS);
            } else if (shareItem.eeJ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_param1", 7).ag("obj_type", i).dh("fid", shareItem.extData));
            } else if (shareItem.eeL) {
                an ag = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ag.ag("obj_param1", 9);
                }
                TiebaStatic.log(ag);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cZD() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Dj(int i) {
        return (i & 1) > 0;
    }

    private boolean Dk(int i) {
        return (i & 2) > 0;
    }

    private boolean Dl(int i) {
        return (i & 8) > 0;
    }

    private boolean Dm(int i) {
        return (i & 16) > 0;
    }
}
