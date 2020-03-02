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
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView jWg;
    private ShareGridLayout jWi;
    private View.OnClickListener jWk;
    private SparseArray<String> jWn;
    private SparseArray<y> jWo;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int ffZ = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int fga = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jWd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jWe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jWf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dqH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jWl = new SparseArray<>(8);
    private boolean jWm = false;
    private final List<View> jWj = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView jWh = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jWh.setText(sharePanelText);
        }
        this.jWi = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jWi.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.ktR;
            marginLayoutParams.rightMargin = ShareGridLayout.ktR;
            this.jWi.setLayoutParams(marginLayoutParams);
        }
        this.jWi.setItemParams(ffZ, fga);
        this.jWg = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jWg.setOnClickListener(this);
        if (!BR(i)) {
            cG(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!BS(i)) {
            cG(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!BT(i)) {
            cG(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!BU(i)) {
            cG(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!f.aMx()) {
            this.jWi.setVisibility(8);
        }
    }

    private void bgo() {
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

    private void cG(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWd, jWd);
        layoutParams.topMargin = jWe;
        layoutParams.bottomMargin = jWf;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dqH);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.jWj.add(linearLayout);
    }

    public LinearLayout cH(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWd, jWd);
        layoutParams.topMargin = jWe;
        layoutParams.bottomMargin = jWf;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dqH);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cHH() {
        if (this.jWj == null) {
            return 0;
        }
        return this.jWj.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jWj.size() && i >= 0) {
            this.jWj.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0604a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC0604a implements View.OnClickListener {
        private View.OnClickListener jWq;

        public View$OnClickListenerC0604a(View.OnClickListener onClickListener) {
            this.jWq = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.jWq != null) {
                this.jWq.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bws;
        if (z && (bws = bws()) != null) {
            shareItem.location = bws;
        }
        this.jWl.put(1, shareItem);
    }

    private Location bws() {
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
            this.jWk = onClickListener;
        }
    }

    public void cHI() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jWj.size()) {
                this.jWi.addView(this.jWj.get(i2), new ViewGroup.LayoutParams(ffZ, fga));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aMx()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cHI();
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
            cHJ();
            bgo();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jWm = false;
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
        if (this.jWl.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.jWm) {
                this.jWm = true;
                f fVar = new f(this.mContext, null);
                ShareItem BP = BP(1);
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    BQ(3);
                    ShareItem BP2 = BP(3);
                    a(BP2, 4);
                    if (BP2 != null) {
                        fVar.e(BP2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BQ(2);
                    ShareItem BP3 = BP(2);
                    a(BP3, 3);
                    if (BP3 != null) {
                        if (BP3.dpO) {
                            BP3.content = "【" + BP3.title + "】 " + BP3.content;
                        }
                        fVar.f(BP3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qzone", new Object[0]);
                        BQ(4);
                        ShareItem BP4 = BP(4);
                        a(BP4, 5);
                        if (BP4 != null) {
                            fVar.h(BP4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEH();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_qweibo", new Object[0]);
                    BQ(5);
                    ShareItem BP5 = BP(5);
                    a(BP5, 6);
                    if (BP5 != null) {
                        if (!BP5.dpN) {
                            BP5.content = m(BP5);
                        }
                        fVar.i(BP5);
                    }
                } else if (i == R.drawable.icon_share_weibo_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BQ(6);
                    ShareItem BP6 = BP(6);
                    a(BP6, 7);
                    if (BP6 != null) {
                        if (!BP6.dpN) {
                            BP6.content = m(BP6);
                        }
                        fVar.j(BP6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_renren", new Object[0]);
                    BQ(7);
                    ShareItem BP7 = BP(7);
                    a(BP7, 8);
                    if (BP7 != null) {
                        if (!BP7.dpN) {
                            BP7.content = m(BP7);
                        }
                        fVar.k(BP7);
                    }
                } else if (i == R.drawable.icon_share_qq_selector) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        h("share_to_qq_friend", new Object[0]);
                        BQ(8);
                        ShareItem BP8 = BP(8);
                        a(BP8, 9);
                        if (BP8 != null) {
                            fVar.g(BP8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEH();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(BP, 10);
                    if (this.jWk != null) {
                        this.jWk.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BP.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BP);
                    if (BP != null && BP.dpN) {
                        aZ(8, BP.dqb);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an X = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 7);
        if (shareItem.dqf != 0) {
            X.X("obj_param1", shareItem.dqf);
            if (shareItem.dqf == 2) {
                X.cy("fid", shareItem.fid);
            } else if (shareItem.dqf == 3) {
                if (shareItem.dqj != 0) {
                    X.X("obj_type", shareItem.dqj);
                }
                X.cy("tid", shareItem.tid).cy("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(X);
    }

    private ShareItem BP(int i) {
        ShareItem shareItem = this.jWl.get(i);
        if (shareItem == null) {
            return this.jWl.get(1);
        }
        return shareItem;
    }

    private void BQ(int i) {
        if (i <= 8 && i > 0) {
            this.jWm = true;
            if (this.jWo != null) {
                y yVar = this.jWo.get(i);
                if (!StringUtils.isNull(yVar.aJC()) && yVar.aJD() != null && yVar.aJD().size() > 0) {
                    h(yVar.aJC(), yVar.aJD());
                    return;
                }
            }
            if (this.jWn != null) {
                String str = this.jWn.get(i);
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
            if (shareItem.dpO) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("fid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dpP || shareItem.dpS) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("tid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqe).X("obj_param1", shareItem.dqf).cy("fid", shareItem.fid));
            } else if (shareItem.dpQ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cy("tid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dpN) {
                aZ(i, shareItem.dqb);
            } else if (shareItem.dpR) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_param1", 7).X("obj_type", i).cy("fid", shareItem.extData));
            } else if (shareItem.dpT) {
                an X = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    X.X("obj_param1", 9);
                }
                TiebaStatic.log(X);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cHJ() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean BR(int i) {
        return (i & 1) > 0;
    }

    private boolean BS(int i) {
        return (i & 2) > 0;
    }

    private boolean BT(int i) {
        return (i & 8) > 0;
    }

    private boolean BU(int i) {
        return (i & 16) > 0;
    }
}
