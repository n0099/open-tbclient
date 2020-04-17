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
import com.baidu.tbadk.core.util.d.c;
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
    private final TextView kHe;
    private ShareGridLayout kHg;
    private View.OnClickListener kHi;
    private SparseArray<String> kHl;
    private SparseArray<y> kHm;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int fKX = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int fKY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int kHb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int kHc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int kHd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dRe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> kHj = new SparseArray<>(8);
    private boolean kHk = false;
    private final List<View> kHh = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView kHf = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.kHf.setText(sharePanelText);
        }
        this.kHg = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.kHg.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.lfP;
            marginLayoutParams.rightMargin = ShareGridLayout.lfP;
            this.kHg.setLayoutParams(marginLayoutParams);
        }
        this.kHg.setItemParams(fKX, fKY);
        this.kHe = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.kHe.setOnClickListener(this);
        if (!Cz(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!CA(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!CB(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!CC(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!f.aUZ()) {
            this.kHg.setVisibility(8);
        }
    }

    private void bpL() {
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
            if (aVar instanceof c) {
                com.baidu.tbadk.core.util.e.a.aPu().kL(1).kM(R.color.cp_bg_line_i).aR(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kHb, kHb);
            layoutParams.topMargin = kHc;
            layoutParams.bottomMargin = kHd;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dRe);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.kHh.add(linearLayout);
        }
    }

    public LinearLayout cN(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.aPu().kL(1).kM(R.color.cp_bg_line_i).aR(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kHb, kHb);
        layoutParams.topMargin = kHc;
        layoutParams.bottomMargin = kHd;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dRe);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cSA() {
        if (this.kHh == null) {
            return 0;
        }
        return this.kHh.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.kHh.size() && i >= 0) {
            this.kHh.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0645a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC0645a implements View.OnClickListener {
        private View.OnClickListener kHo;

        public View$OnClickListenerC0645a(View.OnClickListener onClickListener) {
            this.kHo = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.kHo != null) {
                this.kHo.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bGk;
        if (z && (bGk = bGk()) != null) {
            shareItem.location = bGk;
        }
        this.kHj.put(1, shareItem);
    }

    private Location bGk() {
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
            this.kHi = onClickListener;
        }
    }

    public void cSB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kHh.size()) {
                this.kHg.addView(this.kHh.get(i2), new ViewGroup.LayoutParams(fKX, fKY));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aUZ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cSB();
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
            cSC();
            bpL();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.kHk = false;
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
        if (this.kHj.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.kHk) {
                this.kHk = true;
                f fVar = new f(this.mContext, null);
                ShareItem Cx = Cx(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    Cy(3);
                    ShareItem Cx2 = Cx(3);
                    a(Cx2, 4);
                    if (Cx2 != null) {
                        fVar.e(Cx2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    Cy(2);
                    ShareItem Cx3 = Cx(2);
                    a(Cx3, 3);
                    if (Cx3 != null) {
                        if (Cx3.dQh) {
                            Cx3.content = "【" + Cx3.title + "】 " + Cx3.content;
                        }
                        fVar.f(Cx3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        Cy(4);
                        ShareItem Cx4 = Cx(4);
                        a(Cx4, 5);
                        if (Cx4 != null) {
                            fVar.h(Cx4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMZ();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    Cy(5);
                    ShareItem Cx5 = Cx(5);
                    a(Cx5, 6);
                    if (Cx5 != null) {
                        if (!Cx5.dQg) {
                            Cx5.content = m(Cx5);
                        }
                        fVar.i(Cx5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    Cy(6);
                    ShareItem Cx6 = Cx(6);
                    a(Cx6, 7);
                    if (Cx6 != null) {
                        if (!Cx6.dQg) {
                            Cx6.content = m(Cx6);
                        }
                        fVar.j(Cx6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    Cy(7);
                    ShareItem Cx7 = Cx(7);
                    a(Cx7, 8);
                    if (Cx7 != null) {
                        if (!Cx7.dQg) {
                            Cx7.content = m(Cx7);
                        }
                        fVar.k(Cx7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        Cy(8);
                        ShareItem Cx8 = Cx(8);
                        a(Cx8, 9);
                        if (Cx8 != null) {
                            fVar.g(Cx8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMZ();
                    }
                } else if (i == 10) {
                    a(Cx, 10);
                    if (this.kHi != null) {
                        this.kHi.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Cx.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Cx);
                    if (Cx != null && Cx.dQg) {
                        bo(8, Cx.dQu);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an af = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).af("obj_source", 7);
        if (shareItem.dQy != 0) {
            af.af("obj_param1", shareItem.dQy);
            if (shareItem.dQy == 2) {
                af.cI("fid", shareItem.fid);
            } else if (shareItem.dQy == 3) {
                if (shareItem.dQC != 0) {
                    af.af("obj_type", shareItem.dQC);
                }
                af.cI("tid", shareItem.tid).cI("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(af);
    }

    private ShareItem Cx(int i) {
        ShareItem shareItem = this.kHj.get(i);
        if (shareItem == null) {
            return this.kHj.get(1);
        }
        return shareItem;
    }

    private void Cy(int i) {
        if (i <= 8 && i > 0) {
            this.kHk = true;
            if (this.kHm != null) {
                y yVar = this.kHm.get(i);
                if (!StringUtils.isNull(yVar.aSe()) && yVar.aSf() != null && yVar.aSf().size() > 0) {
                    h(yVar.aSe(), yVar.aSf());
                    return;
                }
            }
            if (this.kHl != null) {
                String str = this.kHl.get(i);
                if (!aq.isEmpty(str)) {
                    h(str, new Object[0]);
                }
            }
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bo(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dQh) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("fid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQi || shareItem.dQl) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("tid", shareItem.extData).af("obj_type", i).af("obj_source", shareItem.dQx).af("obj_param1", shareItem.dQy).cI("fid", shareItem.fid));
            } else if (shareItem.dQj) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cI("tid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQg) {
                bo(i, shareItem.dQu);
            } else if (shareItem.dQk) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_param1", 7).af("obj_type", i).cI("fid", shareItem.extData));
            } else if (shareItem.dQm) {
                an af = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    af.af("obj_param1", 9);
                }
                TiebaStatic.log(af);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cSC() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Cz(int i) {
        return (i & 1) > 0;
    }

    private boolean CA(int i) {
        return (i & 2) > 0;
    }

    private boolean CB(int i) {
        return (i & 8) > 0;
    }

    private boolean CC(int i) {
        return (i & 16) > 0;
    }
}
