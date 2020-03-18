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
    private final TextView jXU;
    private ShareGridLayout jXW;
    private View.OnClickListener jXY;
    private SparseArray<String> jYb;
    private SparseArray<y> jYc;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int fgL = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int fgM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jXR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jXS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jXT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int drh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jXZ = new SparseArray<>(8);
    private boolean jYa = false;
    private final List<View> jXX = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView jXV = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jXV.setText(sharePanelText);
        }
        this.jXW = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jXW.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.kvH;
            marginLayoutParams.rightMargin = ShareGridLayout.kvH;
            this.jXW.setLayoutParams(marginLayoutParams);
        }
        this.jXW.setItemParams(fgL, fgM);
        this.jXU = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jXU.setOnClickListener(this);
        if (!BZ(i)) {
            cH(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!Ca(i)) {
            cH(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!Cb(i)) {
            cH(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!Cc(i)) {
            cH(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!f.aMC()) {
            this.jXW.setVisibility(8);
        }
    }

    private void bgu() {
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

    private void cH(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jXR, jXR);
        layoutParams.topMargin = jXS;
        layoutParams.bottomMargin = jXT;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, drh);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.jXX.add(linearLayout);
    }

    public LinearLayout cI(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jXR, jXR);
        layoutParams.topMargin = jXS;
        layoutParams.bottomMargin = jXT;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, drh);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cIc() {
        if (this.jXX == null) {
            return 0;
        }
        return this.jXX.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jXX.size() && i >= 0) {
            this.jXX.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0605a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC0605a implements View.OnClickListener {
        private View.OnClickListener jYe;

        public View$OnClickListenerC0605a(View.OnClickListener onClickListener) {
            this.jYe = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.jYe != null) {
                this.jYe.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bwy;
        if (z && (bwy = bwy()) != null) {
            shareItem.location = bwy;
        }
        this.jXZ.put(1, shareItem);
    }

    private Location bwy() {
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
            this.jXY = onClickListener;
        }
    }

    public void cId() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jXX.size()) {
                this.jXW.addView(this.jXX.get(i2), new ViewGroup.LayoutParams(fgL, fgM));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aMC()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cId();
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
            cIe();
            bgu();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jYa = false;
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
        if (this.jXZ.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.jYa) {
                this.jYa = true;
                f fVar = new f(this.mContext, null);
                ShareItem BX = BX(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    BY(3);
                    ShareItem BX2 = BX(3);
                    a(BX2, 4);
                    if (BX2 != null) {
                        fVar.e(BX2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BY(2);
                    ShareItem BX3 = BX(2);
                    a(BX3, 3);
                    if (BX3 != null) {
                        if (BX3.dqo) {
                            BX3.content = "【" + BX3.title + "】 " + BX3.content;
                        }
                        fVar.f(BX3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        BY(4);
                        ShareItem BX4 = BX(4);
                        a(BX4, 5);
                        if (BX4 != null) {
                            fVar.h(BX4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEL();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    BY(5);
                    ShareItem BX5 = BX(5);
                    a(BX5, 6);
                    if (BX5 != null) {
                        if (!BX5.dqn) {
                            BX5.content = m(BX5);
                        }
                        fVar.i(BX5);
                    }
                } else if (i == R.drawable.icon_share_weibo_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BY(6);
                    ShareItem BX6 = BX(6);
                    a(BX6, 7);
                    if (BX6 != null) {
                        if (!BX6.dqn) {
                            BX6.content = m(BX6);
                        }
                        fVar.j(BX6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    BY(7);
                    ShareItem BX7 = BX(7);
                    a(BX7, 8);
                    if (BX7 != null) {
                        if (!BX7.dqn) {
                            BX7.content = m(BX7);
                        }
                        fVar.k(BX7);
                    }
                } else if (i == R.drawable.icon_share_qq_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        BY(8);
                        ShareItem BX8 = BX(8);
                        a(BX8, 9);
                        if (BX8 != null) {
                            fVar.g(BX8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEL();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(BX, 10);
                    if (this.jXY != null) {
                        this.jXY.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BX.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BX);
                    if (BX != null && BX.dqn) {
                        aZ(8, BX.dqB);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an X = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 7);
        if (shareItem.dqF != 0) {
            X.X("obj_param1", shareItem.dqF);
            if (shareItem.dqF == 2) {
                X.cx("fid", shareItem.fid);
            } else if (shareItem.dqF == 3) {
                if (shareItem.dqJ != 0) {
                    X.X("obj_type", shareItem.dqJ);
                }
                X.cx("tid", shareItem.tid).cx("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(X);
    }

    private ShareItem BX(int i) {
        ShareItem shareItem = this.jXZ.get(i);
        if (shareItem == null) {
            return this.jXZ.get(1);
        }
        return shareItem;
    }

    private void BY(int i) {
        if (i <= 8 && i > 0) {
            this.jYa = true;
            if (this.jYc != null) {
                y yVar = this.jYc.get(i);
                if (!StringUtils.isNull(yVar.aJH()) && yVar.aJI() != null && yVar.aJI().size() > 0) {
                    h(yVar.aJH(), yVar.aJI());
                    return;
                }
            }
            if (this.jYb != null) {
                String str = this.jYb.get(i);
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
            if (shareItem.dqo) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cx("fid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dqp || shareItem.dqs) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cx("tid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqE).X("obj_param1", shareItem.dqF).cx("fid", shareItem.fid));
            } else if (shareItem.dqq) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cx("tid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dqn) {
                aZ(i, shareItem.dqB);
            } else if (shareItem.dqr) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_param1", 7).X("obj_type", i).cx("fid", shareItem.extData));
            } else if (shareItem.dqt) {
                an X = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    X.X("obj_param1", 9);
                }
                TiebaStatic.log(X);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cIe() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean BZ(int i) {
        return (i & 1) > 0;
    }

    private boolean Ca(int i) {
        return (i & 2) > 0;
    }

    private boolean Cb(int i) {
        return (i & 8) > 0;
    }

    private boolean Cc(int i) {
        return (i & 16) > 0;
    }
}
