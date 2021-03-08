package com.baidu.tieba.sharesdk.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final TextView nnb;
    private ShareGridLayout nnd;
    private View.OnClickListener nnf;
    private SparseArray<String> nni;
    private SparseArray<af> nnj;
    private static final int hKB = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hKC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int nmY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nmZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int nna = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fxg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> nng = new SparseArray<>(8);
    private boolean nnh = false;
    private final List<View> nne = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView nnc = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nnc.setText(sharePanelText);
        }
        this.nnd = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nLB;
            marginLayoutParams.rightMargin = ShareGridLayout.nLB;
            this.nnd.setLayoutParams(marginLayoutParams);
        }
        this.nnd.setItemParams(hKB, hKC);
        this.nnb = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.nnb.setOnClickListener(this);
        if (!IY(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!IZ(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Ja(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Jb(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bzm()) {
            this.nnd.setVisibility(8);
        }
    }

    private void bXf() {
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
                com.baidu.tbadk.core.util.f.a.bty().oP(1).oQ(R.color.CAM_X0213).bv(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nmY, nmY);
            layoutParams.topMargin = nmZ;
            layoutParams.bottomMargin = nna;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fxg);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.nne.add(linearLayout);
        }
    }

    public LinearLayout dp(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bty().oP(1).oQ(R.color.CAM_X0213).bv(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nmY, nmY);
        layoutParams.topMargin = nmZ;
        layoutParams.bottomMargin = nna;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fxg);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dJH() {
        if (this.nne == null) {
            return 0;
        }
        return this.nne.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nne.size() && i >= 0) {
            this.nne.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0872a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class View$OnClickListenerC0872a implements View.OnClickListener {
        private View.OnClickListener nnl;

        public View$OnClickListenerC0872a(View.OnClickListener onClickListener) {
            this.nnl = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.nnl != null) {
                this.nnl.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location ctS;
        if (z && (ctS = ctS()) != null) {
            shareItem.location = ctS;
        }
        this.nng.put(1, shareItem);
    }

    private Location ctS() {
        if (ae.checkLocationForGoogle(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
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
            this.nnf = onClickListener;
        }
    }

    public void dJI() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nne.size()) {
                this.nnd.addView(this.nne.get(i2), new ViewGroup.LayoutParams(hKB, hKC));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bzm()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dJI();
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
            dJJ();
            bXf();
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
            this.nnh = false;
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
        if (this.nng.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.nnh) {
                this.nnh = true;
                g gVar = new g(this.mContext, null);
                ShareItem IW = IW(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    IX(3);
                    ShareItem IW2 = IW(3);
                    a(IW2, 4);
                    if (IW2 != null) {
                        gVar.e(IW2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IX(2);
                    ShareItem IW3 = IW(2);
                    a(IW3, 3);
                    if (IW3 != null) {
                        if (IW3.fwf) {
                            IW3.content = "【" + IW3.title + "】 " + IW3.content;
                        }
                        gVar.f(IW3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IX(4);
                        ShareItem IW4 = IW(4);
                        a(IW4, 5);
                        if (IW4 != null) {
                            gVar.h(IW4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqF();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IX(5);
                    ShareItem IW5 = IW(5);
                    a(IW5, 6);
                    if (IW5 != null) {
                        if (!IW5.fwe) {
                            IW5.content = m(IW5);
                        }
                        gVar.i(IW5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    IX(6);
                    ShareItem IW6 = IW(6);
                    a(IW6, 7);
                    if (IW6 != null) {
                        if (!IW6.fwe) {
                            IW6.content = m(IW6);
                        }
                        gVar.j(IW6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IX(7);
                    ShareItem IW7 = IW(7);
                    a(IW7, 8);
                    if (IW7 != null) {
                        if (!IW7.fwe) {
                            IW7.content = m(IW7);
                        }
                        gVar.k(IW7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IX(8);
                        ShareItem IW8 = IW(8);
                        a(IW8, 9);
                        if (IW8 != null) {
                            gVar.g(IW8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqF();
                    }
                } else if (i == 10) {
                    a(IW, 10);
                    if (this.nnf != null) {
                        this.nnf.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(IW.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(IW);
                    if (IW != null && IW.fwe) {
                        bV(8, IW.fwt);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        ar aq = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aq("obj_source", 9);
        if (shareItem.fwx != 0) {
            aq.aq("obj_param1", shareItem.fwx);
            if (shareItem.fwx == 2) {
                aq.dR("fid", shareItem.fid);
            } else if (shareItem.fwx == 3) {
                if (shareItem.fwB != 0) {
                    aq.aq("obj_type", shareItem.fwB);
                }
                aq.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        aq.aq("obj_locate", 7);
        TiebaStatic.log(aq);
    }

    private ShareItem IW(int i) {
        ShareItem shareItem = this.nng.get(i);
        if (shareItem == null) {
            return this.nng.get(1);
        }
        return shareItem;
    }

    private void IX(int i) {
        if (i <= 8 && i > 0) {
            this.nnh = true;
            if (this.nnj != null) {
                af afVar = this.nnj.get(i);
                if (!StringUtils.isNull(afVar.bwE()) && afVar.bwF() != null && afVar.bwF().size() > 0) {
                    f(afVar.bwE(), afVar.bwF());
                    return;
                }
            }
            if (this.nni != null) {
                String str = this.nni.get(i);
                if (!au.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bV(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fwf) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).aq("obj_type", i));
            } else if (shareItem.fwg || shareItem.fwj) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).aq("obj_type", i).aq("obj_source", shareItem.fww).aq("obj_param1", shareItem.fwx).dR("fid", shareItem.fid));
            } else if (shareItem.fwh) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).aq("obj_type", i));
            } else if (shareItem.fwe) {
                bV(i, shareItem.fwt);
            } else if (shareItem.fwi) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aq("obj_param1", 7).aq("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fwk) {
                ar aq = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aq("obj_type", i);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    aq.aq("obj_param1", 9);
                }
                TiebaStatic.log(aq);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dJJ() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean IY(int i) {
        return (i & 1) > 0;
    }

    private boolean IZ(int i) {
        return (i & 2) > 0;
    }

    private boolean Ja(int i) {
        return (i & 8) > 0;
    }

    private boolean Jb(int i) {
        return (i & 16) > 0;
    }
}
