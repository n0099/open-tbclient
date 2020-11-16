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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private final TextView mLV;
    private ShareGridLayout mLX;
    private View.OnClickListener mLZ;
    private SparseArray<String> mMc;
    private SparseArray<af> mMd;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int hnr = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hns = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mLS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mLT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mLU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fgP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> mMa = new SparseArray<>(8);
    private boolean mMb = false;
    private final List<View> mLY = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView mLW = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mLW.setText(sharePanelText);
        }
        this.mLX = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.mLX.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nlD;
            marginLayoutParams.rightMargin = ShareGridLayout.nlD;
            this.mLX.setLayoutParams(marginLayoutParams);
        }
        this.mLX.setItemParams(hnr, hns);
        this.mLV = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mLV.setOnClickListener(this);
        if (!Jw(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Jx(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Jy(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Jz(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bwQ()) {
            this.mLX.setVisibility(8);
        }
    }

    private void bTQ() {
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

    private void a(com.baidu.tbadk.core.util.d.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.brc().pF(1).pG(R.color.CAM_X0213).bn(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mLS, mLS);
            layoutParams.topMargin = mLT;
            layoutParams.bottomMargin = mLU;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fgP);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.mLY.add(linearLayout);
        }
    }

    public LinearLayout dq(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.brc().pF(1).pG(R.color.CAM_X0213).bn(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mLS, mLS);
        layoutParams.topMargin = mLT;
        layoutParams.bottomMargin = mLU;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fgP);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dFT() {
        if (this.mLY == null) {
            return 0;
        }
        return this.mLY.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.mLY.size() && i >= 0) {
            this.mLY.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0847a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    class View$OnClickListenerC0847a implements View.OnClickListener {
        private View.OnClickListener mMf;

        public View$OnClickListenerC0847a(View.OnClickListener onClickListener) {
            this.mMf = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.mMf != null) {
                this.mMf.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cpc;
        if (z && (cpc = cpc()) != null) {
            shareItem.location = cpc;
        }
        this.mMa.put(1, shareItem);
    }

    private Location cpc() {
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
            this.mLZ = onClickListener;
        }
    }

    public void dFU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLY.size()) {
                this.mLX.addView(this.mLY.get(i2), new ViewGroup.LayoutParams(hnr, hns));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bwQ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dFU();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.view.a.2
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
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            dFV();
            bTQ();
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.mMb = false;
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
        if (this.mMa.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.mMb) {
                this.mMb = true;
                g gVar = new g(this.mContext, null);
                ShareItem Ju = Ju(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Jv(3);
                    ShareItem Ju2 = Ju(3);
                    a(Ju2, 4);
                    if (Ju2 != null) {
                        gVar.e(Ju2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Jv(2);
                    ShareItem Ju3 = Ju(2);
                    a(Ju3, 3);
                    if (Ju3 != null) {
                        if (Ju3.ffN) {
                            Ju3.content = "【" + Ju3.title + "】 " + Ju3.content;
                        }
                        gVar.f(Ju3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Jv(4);
                        ShareItem Ju4 = Ju(4);
                        a(Ju4, 5);
                        if (Ju4 != null) {
                            gVar.h(Ju4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Jv(5);
                    ShareItem Ju5 = Ju(5);
                    a(Ju5, 6);
                    if (Ju5 != null) {
                        if (!Ju5.ffM) {
                            Ju5.content = l(Ju5);
                        }
                        gVar.i(Ju5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Jv(6);
                    ShareItem Ju6 = Ju(6);
                    a(Ju6, 7);
                    if (Ju6 != null) {
                        if (!Ju6.ffM) {
                            Ju6.content = l(Ju6);
                        }
                        gVar.j(Ju6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Jv(7);
                    ShareItem Ju7 = Ju(7);
                    a(Ju7, 8);
                    if (Ju7 != null) {
                        if (!Ju7.ffM) {
                            Ju7.content = l(Ju7);
                        }
                        gVar.k(Ju7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Jv(8);
                        ShareItem Ju8 = Ju(8);
                        a(Ju8, 9);
                        if (Ju8 != null) {
                            gVar.g(Ju8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
                    }
                } else if (i == 10) {
                    a(Ju, 10);
                    if (this.mLZ != null) {
                        this.mLZ.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Ju.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    m(Ju);
                    if (Ju != null && Ju.ffM) {
                        bN(8, Ju.fgb);
                    }
                }
            }
        }
    }

    private void m(ShareItem shareItem) {
        ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ak("obj_source", 9);
        if (shareItem.fgf != 0) {
            ak.ak("obj_param1", shareItem.fgf);
            if (shareItem.fgf == 2) {
                ak.dR("fid", shareItem.fid);
            } else if (shareItem.fgf == 3) {
                if (shareItem.fgj != 0) {
                    ak.ak("obj_type", shareItem.fgj);
                }
                ak.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        ak.ak("obj_locate", 7);
        TiebaStatic.log(ak);
    }

    private ShareItem Ju(int i) {
        ShareItem shareItem = this.mMa.get(i);
        if (shareItem == null) {
            return this.mMa.get(1);
        }
        return shareItem;
    }

    private void Jv(int i) {
        if (i <= 8 && i > 0) {
            this.mMb = true;
            if (this.mMd != null) {
                af afVar = this.mMd.get(i);
                if (!StringUtils.isNull(afVar.bui()) && afVar.buj() != null && afVar.buj().size() > 0) {
                    f(afVar.bui(), afVar.buj());
                    return;
                }
            }
            if (this.mMc != null) {
                String str = this.mMc.get(i);
                if (!au.isEmpty(str)) {
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
            if (shareItem.ffN) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).ak("obj_type", i));
            } else if (shareItem.ffO || shareItem.ffR) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).ak("obj_type", i).ak("obj_source", shareItem.fge).ak("obj_param1", shareItem.fgf).dR("fid", shareItem.fid));
            } else if (shareItem.ffP) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).ak("obj_type", i));
            } else if (shareItem.ffM) {
                bN(i, shareItem.fgb);
            } else if (shareItem.ffQ) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_param1", 7).ak("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.ffS) {
                ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_type", i);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ak.ak("obj_param1", 9);
                }
                TiebaStatic.log(ak);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dFV() {
    }

    private String l(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Jw(int i) {
        return (i & 1) > 0;
    }

    private boolean Jx(int i) {
        return (i & 2) > 0;
    }

    private boolean Jy(int i) {
        return (i & 8) > 0;
    }

    private boolean Jz(int i) {
        return (i & 16) > 0;
    }
}
