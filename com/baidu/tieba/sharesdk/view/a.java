package com.baidu.tieba.sharesdk.view;

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
import android.view.WindowManager;
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
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private SparseArray<String> nfC;
    private SparseArray<af> nfD;
    private final TextView nfv;
    private ShareGridLayout nfx;
    private View.OnClickListener nfz;
    private static final int hIY = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hIZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int nfs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nft = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int nfu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fxY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> nfA = new SparseArray<>(8);
    private boolean nfB = false;
    private final List<View> nfy = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView nfw = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nfw.setText(sharePanelText);
        }
        this.nfx = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nfx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nDR;
            marginLayoutParams.rightMargin = ShareGridLayout.nDR;
            this.nfx.setLayoutParams(marginLayoutParams);
        }
        this.nfx.setItemParams(hIY, hIZ);
        this.nfv = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.nfv.setOnClickListener(this);
        if (!Kh(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Ki(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Kj(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Kk(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bCK()) {
            this.nfx.setVisibility(8);
        }
    }

    private void caf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.view.a.1
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

    private void a(com.baidu.tbadk.core.util.e.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
                com.baidu.tbadk.core.util.f.a.bwU().qq(1).qr(R.color.CAM_X0213).bz(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nfs, nfs);
            layoutParams.topMargin = nft;
            layoutParams.bottomMargin = nfu;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fxY);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.nfy.add(linearLayout);
        }
    }

    public LinearLayout dr(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bwU().qq(1).qr(R.color.CAM_X0213).bz(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nfs, nfs);
        layoutParams.topMargin = nft;
        layoutParams.bottomMargin = nfu;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fxY);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dKX() {
        if (this.nfy == null) {
            return 0;
        }
        return this.nfy.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nfy.size() && i >= 0) {
            this.nfy.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0845a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class View$OnClickListenerC0845a implements View.OnClickListener {
        private View.OnClickListener nfF;

        public View$OnClickListenerC0845a(View.OnClickListener onClickListener) {
            this.nfF = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.nfF != null) {
                this.nfF.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cwk;
        if (z && (cwk = cwk()) != null) {
            shareItem.location = cwk;
        }
        this.nfA.put(1, shareItem);
    }

    private Location cwk() {
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
            this.nfz = onClickListener;
        }
    }

    public void dKY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nfy.size()) {
                this.nfx.addView(this.nfy.get(i2), new ViewGroup.LayoutParams(hIY, hIZ));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bCK()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dKY();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.view.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            dKZ();
            caf();
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.nfB = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
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
        if (this.nfA.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.nfB) {
                this.nfB = true;
                g gVar = new g(this.mContext, null);
                ShareItem Kf = Kf(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Kg(3);
                    ShareItem Kf2 = Kf(3);
                    a(Kf2, 4);
                    if (Kf2 != null) {
                        gVar.e(Kf2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Kg(2);
                    ShareItem Kf3 = Kf(2);
                    a(Kf3, 3);
                    if (Kf3 != null) {
                        if (Kf3.fwX) {
                            Kf3.content = "【" + Kf3.title + "】 " + Kf3.content;
                        }
                        gVar.f(Kf3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Kg(4);
                        ShareItem Kf4 = Kf(4);
                        a(Kf4, 5);
                        if (Kf4 != null) {
                            gVar.h(Kf4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bud();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Kg(5);
                    ShareItem Kf5 = Kf(5);
                    a(Kf5, 6);
                    if (Kf5 != null) {
                        if (!Kf5.fwW) {
                            Kf5.content = m(Kf5);
                        }
                        gVar.i(Kf5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Kg(6);
                    ShareItem Kf6 = Kf(6);
                    a(Kf6, 7);
                    if (Kf6 != null) {
                        if (!Kf6.fwW) {
                            Kf6.content = m(Kf6);
                        }
                        gVar.j(Kf6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Kg(7);
                    ShareItem Kf7 = Kf(7);
                    a(Kf7, 8);
                    if (Kf7 != null) {
                        if (!Kf7.fwW) {
                            Kf7.content = m(Kf7);
                        }
                        gVar.k(Kf7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Kg(8);
                        ShareItem Kf8 = Kf(8);
                        a(Kf8, 9);
                        if (Kf8 != null) {
                            gVar.g(Kf8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bud();
                    }
                } else if (i == 10) {
                    a(Kf, 10);
                    if (this.nfz != null) {
                        this.nfz.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Kf.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Kf);
                    if (Kf != null && Kf.fwW) {
                        bN(8, Kf.fxl);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 9);
        if (shareItem.fxp != 0) {
            an.an("obj_param1", shareItem.fxp);
            if (shareItem.fxp == 2) {
                an.dX("fid", shareItem.fid);
            } else if (shareItem.fxp == 3) {
                if (shareItem.fxt != 0) {
                    an.an("obj_type", shareItem.fxt);
                }
                an.dX("tid", shareItem.tid).dX("fid", shareItem.fid);
            }
        }
        an.an("obj_locate", 7);
        TiebaStatic.log(an);
    }

    private ShareItem Kf(int i) {
        ShareItem shareItem = this.nfA.get(i);
        if (shareItem == null) {
            return this.nfA.get(1);
        }
        return shareItem;
    }

    private void Kg(int i) {
        if (i <= 8 && i > 0) {
            this.nfB = true;
            if (this.nfD != null) {
                af afVar = this.nfD.get(i);
                if (!StringUtils.isNull(afVar.bAc()) && afVar.bAd() != null && afVar.bAd().size() > 0) {
                    f(afVar.bAc(), afVar.bAd());
                    return;
                }
            }
            if (this.nfC != null) {
                String str = this.nfC.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bN(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fwX) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("fid", shareItem.extData).an("obj_type", i));
            } else if (shareItem.fwY || shareItem.fxb) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("tid", shareItem.extData).an("obj_type", i).an("obj_source", shareItem.fxo).an("obj_param1", shareItem.fxp).dX("fid", shareItem.fid));
            } else if (shareItem.fwZ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dX("tid", shareItem.extData).an("obj_type", i));
            } else if (shareItem.fwW) {
                bN(i, shareItem.fxl);
            } else if (shareItem.fxa) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_param1", 7).an("obj_type", i).dX("fid", shareItem.extData));
            } else if (shareItem.fxc) {
                aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    an.an("obj_param1", 9);
                }
                TiebaStatic.log(an);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dKZ() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Kh(int i) {
        return (i & 1) > 0;
    }

    private boolean Ki(int i) {
        return (i & 2) > 0;
    }

    private boolean Kj(int i) {
        return (i & 8) > 0;
    }

    private boolean Kk(int i) {
        return (i & 16) > 0;
    }
}
