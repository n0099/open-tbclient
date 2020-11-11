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
/* loaded from: classes24.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private final TextView mLm;
    private ShareGridLayout mLo;
    private View.OnClickListener mLq;
    private SparseArray<String> mLt;
    private SparseArray<af> mLu;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int hnK = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hnL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mLj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mLk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mLl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fhH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> mLr = new SparseArray<>(8);
    private boolean mLs = false;
    private final List<View> mLp = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView mLn = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mLn.setText(sharePanelText);
        }
        this.mLo = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.mLo.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nkC;
            marginLayoutParams.rightMargin = ShareGridLayout.nkC;
            this.mLo.setLayoutParams(marginLayoutParams);
        }
        this.mLo.setItemParams(hnK, hnL);
        this.mLm = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mLm.setOnClickListener(this);
        if (!IV(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!IW(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!IX(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!IY(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bxA()) {
            this.mLo.setVisibility(8);
        }
    }

    private void bUx() {
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
                com.baidu.tbadk.core.util.e.a.brO().pj(1).pk(R.color.cp_bg_line_i).bk(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mLj, mLj);
            layoutParams.topMargin = mLk;
            layoutParams.bottomMargin = mLl;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fhH);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.mLp.add(linearLayout);
        }
    }

    public LinearLayout dq(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.brO().pj(1).pk(R.color.cp_bg_line_i).bk(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mLj, mLj);
        layoutParams.topMargin = mLk;
        layoutParams.bottomMargin = mLl;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fhH);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dGf() {
        if (this.mLp == null) {
            return 0;
        }
        return this.mLp.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.mLp.size() && i >= 0) {
            this.mLp.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0844a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class View$OnClickListenerC0844a implements View.OnClickListener {
        private View.OnClickListener mLw;

        public View$OnClickListenerC0844a(View.OnClickListener onClickListener) {
            this.mLw = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.mLw != null) {
                this.mLw.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cpB;
        if (z && (cpB = cpB()) != null) {
            shareItem.location = cpB;
        }
        this.mLr.put(1, shareItem);
    }

    private Location cpB() {
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
            this.mLq = onClickListener;
        }
    }

    public void dGg() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLp.size()) {
                this.mLo.addView(this.mLp.get(i2), new ViewGroup.LayoutParams(hnK, hnL));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!g.bxA()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dGg();
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
            dGh();
            bUx();
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.mLs = false;
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
        if (this.mLr.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.mLs) {
                this.mLs = true;
                g gVar = new g(this.mContext, null);
                ShareItem IT = IT(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    IU(3);
                    ShareItem IT2 = IT(3);
                    a(IT2, 4);
                    if (IT2 != null) {
                        gVar.f(IT2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IU(2);
                    ShareItem IT3 = IT(2);
                    a(IT3, 3);
                    if (IT3 != null) {
                        if (IT3.fgF) {
                            IT3.content = "【" + IT3.title + "】 " + IT3.content;
                        }
                        gVar.g(IT3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IU(4);
                        ShareItem IT4 = IT(4);
                        a(IT4, 5);
                        if (IT4 != null) {
                            gVar.i(IT4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bpi();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IU(5);
                    ShareItem IT5 = IT(5);
                    a(IT5, 6);
                    if (IT5 != null) {
                        if (!IT5.fgE) {
                            IT5.content = m(IT5);
                        }
                        gVar.j(IT5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    IU(6);
                    ShareItem IT6 = IT(6);
                    a(IT6, 7);
                    if (IT6 != null) {
                        if (!IT6.fgE) {
                            IT6.content = m(IT6);
                        }
                        gVar.k(IT6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IU(7);
                    ShareItem IT7 = IT(7);
                    a(IT7, 8);
                    if (IT7 != null) {
                        if (!IT7.fgE) {
                            IT7.content = m(IT7);
                        }
                        gVar.l(IT7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IU(8);
                        ShareItem IT8 = IT(8);
                        a(IT8, 9);
                        if (IT8 != null) {
                            gVar.h(IT8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bpi();
                    }
                } else if (i == 10) {
                    a(IT, 10);
                    if (this.mLq != null) {
                        this.mLq.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(IT.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(IT);
                    if (IT != null && IT.fgE) {
                        bP(8, IT.fgT);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq al = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 9);
        if (shareItem.fgX != 0) {
            al.al("obj_param1", shareItem.fgX);
            if (shareItem.fgX == 2) {
                al.dR("fid", shareItem.fid);
            } else if (shareItem.fgX == 3) {
                if (shareItem.fhb != 0) {
                    al.al("obj_type", shareItem.fhb);
                }
                al.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        al.al("obj_locate", 7);
        TiebaStatic.log(al);
    }

    private ShareItem IT(int i) {
        ShareItem shareItem = this.mLr.get(i);
        if (shareItem == null) {
            return this.mLr.get(1);
        }
        return shareItem;
    }

    private void IU(int i) {
        if (i <= 8 && i > 0) {
            this.mLs = true;
            if (this.mLu != null) {
                af afVar = this.mLu.get(i);
                if (!StringUtils.isNull(afVar.buS()) && afVar.buT() != null && afVar.buT().size() > 0) {
                    f(afVar.buS(), afVar.buT());
                    return;
                }
            }
            if (this.mLt != null) {
                String str = this.mLt.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bP(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fgF) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fgG || shareItem.fgJ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fgW).al("obj_param1", shareItem.fgX).dR("fid", shareItem.fid));
            } else if (shareItem.fgH) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fgE) {
                bP(i, shareItem.fgT);
            } else if (shareItem.fgI) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_param1", 7).al("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fgK) {
                aq al = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    al.al("obj_param1", 9);
                }
                TiebaStatic.log(al);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dGh() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean IV(int i) {
        return (i & 1) > 0;
    }

    private boolean IW(int i) {
        return (i & 2) > 0;
    }

    private boolean IX(int i) {
        return (i & 8) > 0;
    }

    private boolean IY(int i) {
        return (i & 16) > 0;
    }
}
