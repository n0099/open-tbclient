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
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final TextView mZY;
    private ShareGridLayout naa;
    private View.OnClickListener nac;
    private SparseArray<String> naf;
    private SparseArray<af> nag;
    private static final int hwY = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hwZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mZV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mZW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mZX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fop = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> nad = new SparseArray<>(8);
    private boolean nae = false;
    private final List<View> nab = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView mZZ = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.mZZ.setText(sharePanelText);
        }
        this.naa = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.naa.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nzH;
            marginLayoutParams.rightMargin = ShareGridLayout.nzH;
            this.naa.setLayoutParams(marginLayoutParams);
        }
        this.naa.setItemParams(hwY, hwZ);
        this.mZY = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.mZY.setOnClickListener(this);
        if (!Kn(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Ko(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Kp(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Kq(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bAq()) {
            this.naa.setVisibility(8);
        }
    }

    private void bXz() {
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
                com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0213).bq(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mZV, mZV);
            layoutParams.topMargin = mZW;
            layoutParams.bottomMargin = mZX;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fop);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.nab.add(linearLayout);
        }
    }

    public LinearLayout dv(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0213).bq(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mZV, mZV);
        layoutParams.topMargin = mZW;
        layoutParams.bottomMargin = mZX;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fop);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dLh() {
        if (this.nab == null) {
            return 0;
        }
        return this.nab.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nab.size() && i >= 0) {
            this.nab.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0862a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class View$OnClickListenerC0862a implements View.OnClickListener {
        private View.OnClickListener nai;

        public View$OnClickListenerC0862a(View.OnClickListener onClickListener) {
            this.nai = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.nai != null) {
                this.nai.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location ctq;
        if (z && (ctq = ctq()) != null) {
            shareItem.location = ctq;
        }
        this.nad.put(1, shareItem);
    }

    private Location ctq() {
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
            this.nac = onClickListener;
        }
    }

    public void dLi() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nab.size()) {
                this.naa.addView(this.nab.get(i2), new ViewGroup.LayoutParams(hwY, hwZ));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!g.bAq()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            dLi();
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
            dLj();
            bXz();
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.nae = false;
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
        if (this.nad.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.nae) {
                this.nae = true;
                g gVar = new g(this.mContext, null);
                ShareItem Kl = Kl(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Km(3);
                    ShareItem Kl2 = Kl(3);
                    a(Kl2, 4);
                    if (Kl2 != null) {
                        gVar.e(Kl2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Km(2);
                    ShareItem Kl3 = Kl(2);
                    a(Kl3, 3);
                    if (Kl3 != null) {
                        if (Kl3.fnn) {
                            Kl3.content = "【" + Kl3.title + "】 " + Kl3.content;
                        }
                        gVar.f(Kl3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Km(4);
                        ShareItem Kl4 = Kl(4);
                        a(Kl4, 5);
                        if (Kl4 != null) {
                            gVar.h(Kl4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Km(5);
                    ShareItem Kl5 = Kl(5);
                    a(Kl5, 6);
                    if (Kl5 != null) {
                        if (!Kl5.fnm) {
                            Kl5.content = l(Kl5);
                        }
                        gVar.i(Kl5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Km(6);
                    ShareItem Kl6 = Kl(6);
                    a(Kl6, 7);
                    if (Kl6 != null) {
                        if (!Kl6.fnm) {
                            Kl6.content = l(Kl6);
                        }
                        gVar.j(Kl6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Km(7);
                    ShareItem Kl7 = Kl(7);
                    a(Kl7, 8);
                    if (Kl7 != null) {
                        if (!Kl7.fnm) {
                            Kl7.content = l(Kl7);
                        }
                        gVar.k(Kl7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Km(8);
                        ShareItem Kl8 = Kl(8);
                        a(Kl8, 9);
                        if (Kl8 != null) {
                            gVar.g(Kl8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
                    }
                } else if (i == 10) {
                    a(Kl, 10);
                    if (this.nac != null) {
                        this.nac.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Kl.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    m(Kl);
                    if (Kl != null && Kl.fnm) {
                        bN(8, Kl.fnB);
                    }
                }
            }
        }
    }

    private void m(ShareItem shareItem) {
        ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 9);
        if (shareItem.fnF != 0) {
            al.al("obj_param1", shareItem.fnF);
            if (shareItem.fnF == 2) {
                al.dY("fid", shareItem.fid);
            } else if (shareItem.fnF == 3) {
                if (shareItem.fnJ != 0) {
                    al.al("obj_type", shareItem.fnJ);
                }
                al.dY("tid", shareItem.tid).dY("fid", shareItem.fid);
            }
        }
        al.al("obj_locate", 7);
        TiebaStatic.log(al);
    }

    private ShareItem Kl(int i) {
        ShareItem shareItem = this.nad.get(i);
        if (shareItem == null) {
            return this.nad.get(1);
        }
        return shareItem;
    }

    private void Km(int i) {
        if (i <= 8 && i > 0) {
            this.nae = true;
            if (this.nag != null) {
                af afVar = this.nag.get(i);
                if (!StringUtils.isNull(afVar.bxI()) && afVar.bxJ() != null && afVar.bxJ().size() > 0) {
                    f(afVar.bxI(), afVar.bxJ());
                    return;
                }
            }
            if (this.naf != null) {
                String str = this.naf.get(i);
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
            if (shareItem.fnn) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("fid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fno || shareItem.fnr) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("tid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fnE).al("obj_param1", shareItem.fnF).dY("fid", shareItem.fid));
            } else if (shareItem.fnp) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dY("tid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fnm) {
                bN(i, shareItem.fnB);
            } else if (shareItem.fnq) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_param1", 7).al("obj_type", i).dY("fid", shareItem.extData));
            } else if (shareItem.fns) {
                ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    al.al("obj_param1", 9);
                }
                TiebaStatic.log(al);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dLj() {
    }

    private String l(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Kn(int i) {
        return (i & 1) > 0;
    }

    private boolean Ko(int i) {
        return (i & 2) > 0;
    }

    private boolean Kp(int i) {
        return (i & 8) > 0;
    }

    private boolean Kq(int i) {
        return (i & 16) > 0;
    }
}
