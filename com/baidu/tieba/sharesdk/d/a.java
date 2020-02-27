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
    private final TextView jWe;
    private ShareGridLayout jWg;
    private View.OnClickListener jWi;
    private SparseArray<String> jWl;
    private SparseArray<y> jWm;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int ffY = (int) (0.25d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int ffZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jWb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jWc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jWd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dqG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jWj = new SparseArray<>(8);
    private boolean jWk = false;
    private final List<View> jWh = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView jWf = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jWf.setText(sharePanelText);
        }
        this.jWg = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jWg.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.ktP;
            marginLayoutParams.rightMargin = ShareGridLayout.ktP;
            this.jWg.setLayoutParams(marginLayoutParams);
        }
        this.jWg.setItemParams(ffY, ffZ);
        this.jWe = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jWe.setOnClickListener(this);
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
        if (!f.aMv()) {
            this.jWg.setVisibility(8);
        }
    }

    private void bgm() {
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWb, jWb);
        layoutParams.topMargin = jWc;
        layoutParams.bottomMargin = jWd;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dqG);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.jWh.add(linearLayout);
    }

    public LinearLayout cH(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWb, jWb);
        layoutParams.topMargin = jWc;
        layoutParams.bottomMargin = jWd;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dqG);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cHF() {
        if (this.jWh == null) {
            return 0;
        }
        return this.jWh.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jWh.size() && i >= 0) {
            this.jWh.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0604a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC0604a implements View.OnClickListener {
        private View.OnClickListener jWo;

        public View$OnClickListenerC0604a(View.OnClickListener onClickListener) {
            this.jWo = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.jWo != null) {
                this.jWo.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bwq;
        if (z && (bwq = bwq()) != null) {
            shareItem.location = bwq;
        }
        this.jWj.put(1, shareItem);
    }

    private Location bwq() {
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
            this.jWi = onClickListener;
        }
    }

    public void cHG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jWh.size()) {
                this.jWg.addView(this.jWh.get(i2), new ViewGroup.LayoutParams(ffY, ffZ));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aMv()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cHG();
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
            cHH();
            bgm();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jWk = false;
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
        if (this.jWj.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.jWk) {
                this.jWk = true;
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
                        if (BP3.dpN) {
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
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEF();
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
                        if (!BP5.dpM) {
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
                        if (!BP6.dpM) {
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
                        if (!BP7.dpM) {
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
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEF();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(BP, 10);
                    if (this.jWi != null) {
                        this.jWi.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BP.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BP);
                    if (BP != null && BP.dpM) {
                        aZ(8, BP.dqa);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        an X = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 7);
        if (shareItem.dqe != 0) {
            X.X("obj_param1", shareItem.dqe);
            if (shareItem.dqe == 2) {
                X.cy("fid", shareItem.fid);
            } else if (shareItem.dqe == 3) {
                if (shareItem.dqi != 0) {
                    X.X("obj_type", shareItem.dqi);
                }
                X.cy("tid", shareItem.tid).cy("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(X);
    }

    private ShareItem BP(int i) {
        ShareItem shareItem = this.jWj.get(i);
        if (shareItem == null) {
            return this.jWj.get(1);
        }
        return shareItem;
    }

    private void BQ(int i) {
        if (i <= 8 && i > 0) {
            this.jWk = true;
            if (this.jWm != null) {
                y yVar = this.jWm.get(i);
                if (!StringUtils.isNull(yVar.aJA()) && yVar.aJB() != null && yVar.aJB().size() > 0) {
                    h(yVar.aJA(), yVar.aJB());
                    return;
                }
            }
            if (this.jWl != null) {
                String str = this.jWl.get(i);
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
            if (shareItem.dpN) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("fid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dpO || shareItem.dpR) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("tid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqd).X("obj_param1", shareItem.dqe).cy("fid", shareItem.fid));
            } else if (shareItem.dpP) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cy("tid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dpM) {
                aZ(i, shareItem.dqa);
            } else if (shareItem.dpQ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_param1", 7).X("obj_type", i).cy("fid", shareItem.extData));
            } else if (shareItem.dpS) {
                an X = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    X.X("obj_param1", 9);
                }
                TiebaStatic.log(X);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cHH() {
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
