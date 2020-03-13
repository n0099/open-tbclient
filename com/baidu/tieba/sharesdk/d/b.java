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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.d.c;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private SparseArray<y> jWA;
    private final TextView jWs;
    private ShareGridLayout jWu;
    private View.OnClickListener jWw;
    private SparseArray<String> jWz;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int fgm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fgn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jWp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jWq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jWr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dqU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> jWx = new SparseArray<>(8);
    private boolean jWy = false;
    private boolean jWD = true;
    private int jWE = 0;
    private CustomMessageListener cVH = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.cHK();
                b.this.jWu.removeAllViews();
                b.this.cHJ();
            }
        }
    };
    private final List<View> jWv = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView jWt = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.jWt.setText(sharePanelText);
        }
        this.jWu = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.jWu.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.kud;
            marginLayoutParams.rightMargin = ShareGridLayout.kud;
            this.jWu.setLayoutParams(marginLayoutParams);
        }
        this.jWu.setItemParams(fgm, fgn);
        this.jWs = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.jWs.setOnClickListener(this);
    }

    private void bgp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (b.this.mDialog != null && b.this.mDialog.isShowing()) {
                    b.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void cHL() {
        ArrayList arrayList = new ArrayList(this.jWv);
        this.jWv.clear();
        if (!BR(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!BS(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!BT(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!BV(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!BU(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (BW(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.jWv.addAll(arrayList);
        }
        if (this.jWD) {
            a(R.string.share_copy, new c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.cWs));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof c) {
                com.baidu.tbadk.core.util.e.a.aHb().kB(1).kC(R.color.cp_bg_line_i).aQ(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWp, jWp);
            layoutParams.topMargin = jWq;
            layoutParams.bottomMargin = jWr;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dqU);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.jWv.add(linearLayout);
        }
    }

    public LinearLayout cH(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWp, jWp);
        layoutParams.topMargin = jWq;
        layoutParams.bottomMargin = jWr;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dqU);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        c cVar = new c(i2, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.aHb().kB(1).kC(R.color.cp_bg_line_i).aQ(imageView);
        imageView.setImageDrawable(cVar.getDrawable());
        am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        return linearLayout;
    }

    public int cHI() {
        if (this.jWv == null) {
            return 0;
        }
        return this.jWv.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.jWv.size() && i >= 0) {
            this.jWv.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener jWC;

        public a(View.OnClickListener onClickListener) {
            this.jWC = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.jWC != null) {
                this.jWC.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.jWD = z;
    }

    public void setCustomCopyTitle(int i) {
        this.jWE = i;
    }

    public void e(SparseArray<String> sparseArray) {
        this.jWz = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location bwt;
        if (z && (bwt = bwt()) != null) {
            shareItem.location = bwt;
        }
        this.jWx.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.dqm)) {
            this.jWt.setText(shareItem.dqm);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location bwt;
        if (z && (bwt = bwt()) != null) {
            shareItem.location = bwt;
        }
        this.jWx.put(i, shareItem);
    }

    private Location bwt() {
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
            this.jWw = onClickListener;
        }
    }

    public void cHJ() {
        cHL();
        if (!f.aMy()) {
            this.jWu.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jWv.size()) {
                this.jWu.addView(this.jWv.get(i2), new ViewGroup.LayoutParams(fgm, fgn));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aMy()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cHJ();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (b.this.onCancelListener != null) {
                        b.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.mRootView);
                cHK();
                bgp();
                i.ab(this.mContext).registerListener(this.cVH);
            }
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void g(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.jWy = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.cVH);
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
        if (this.jWx.size() != 0) {
            if (id == R.id.btnShareCancel || !this.jWy) {
                this.jWy = true;
                ShareItem BP = BP(1);
                f fVar = new f(this.mContext, null);
                if (BP != null && BP.dqH) {
                    TiebaStatic.log(new an("c13531").cy("obj_id", BP.dqI).X("obj_type", BP.dqJ).cy("obj_source", BP.dqK));
                }
                if (id == R.id.btnShareCancel) {
                    h("share_cancel", new Object[0]);
                    if (BP != null && BP.dqg) {
                        a(BP, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                    }
                } else if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_weixin", new Object[0]);
                    BQ(3);
                    ShareItem BP2 = BP(3);
                    a(BP2, 4);
                    if (BP2 != null) {
                        if (BP2.dqF == 1) {
                            o(BP2);
                        } else {
                            fVar.e(BP2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_pyq", new Object[0]);
                    BQ(2);
                    ShareItem BP3 = BP(2);
                    a(BP3, 3);
                    if (BP3 != null) {
                        if (BP3.dqF == 1) {
                            o(BP3);
                            return;
                        }
                        if (BP3.dqb) {
                            BP3.content = "【" + BP3.title + "】 " + BP3.content;
                        }
                        fVar.f(BP3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
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
                    if (BP5 != null) {
                        if (!BP5.dqa) {
                            BP5.content = m(BP5);
                        }
                        fVar.i(BP5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    h("share_to_sweibo", new Object[0]);
                    BQ(6);
                    ShareItem BP6 = BP(6);
                    a(BP6, 7);
                    if (BP6 != null) {
                        if (!BP6.dqa) {
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
                    if (BP7 != null) {
                        if (!BP7.dqa) {
                            BP7.content = m(BP7);
                        }
                        fVar.k(BP7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
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
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        a(BP, 17);
                        String uri = BP.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new o(currentActivity, uri, new o.a() { // from class: com.baidu.tieba.sharesdk.d.b.5
                                @Override // com.baidu.tbadk.util.o.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.o.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
                    a(BP, 10);
                    if (this.jWw != null) {
                        this.jWw.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(BP.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(BP);
                    if (BP != null && BP.dqa) {
                        aZ(8, BP.dqo);
                    }
                }
            }
        }
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.sR(shareItem.title);
            aVar.sS(shareItem.content);
            aVar.setAutoNight(false);
            aVar.fG(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(b.this.mContext.getApplicationContext(), (int) R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.ab(activity));
            aVar.aEC();
        }
    }

    private void n(ShareItem shareItem) {
        an X = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 7);
        if (shareItem.dqs != 0) {
            X.X("obj_param1", shareItem.dqs);
            if (shareItem.dqs == 2) {
                X.cy("fid", shareItem.fid);
            } else if (shareItem.dqs == 3) {
                if (shareItem.dqw != 0) {
                    X.X("obj_type", shareItem.dqw);
                }
                X.cy("tid", shareItem.tid).cy("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(X);
    }

    private ShareItem BP(int i) {
        ShareItem shareItem = this.jWx.get(i);
        if (shareItem == null) {
            return this.jWx.get(1);
        }
        return shareItem;
    }

    private void BQ(int i) {
        if (i <= 8 && i > 0) {
            this.jWy = true;
            if (this.jWA != null) {
                y yVar = this.jWA.get(i);
                if (!StringUtils.isNull(yVar.aJD()) && yVar.aJE() != null && yVar.aJE().size() > 0) {
                    h(yVar.aJD(), yVar.aJE());
                    return;
                }
            }
            if (this.jWz != null) {
                String str = this.jWz.get(i);
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
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.dqj) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i).X("obj_source", shareItem.dqr));
                }
            } else if (shareItem.dqb) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("fid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqr));
            } else if (shareItem.dqc || shareItem.dqf) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("tid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqr).X("obj_param1", shareItem.dqs).cy("fid", shareItem.fid).X(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dqt));
            } else if (shareItem.dqd) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cy("tid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dqa) {
                aZ(i, shareItem.dqo);
            } else if (shareItem.dqe) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_param1", 7).X("obj_type", i).cy("fid", shareItem.extData));
            } else if (shareItem.dqg) {
                an X = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i);
                X.X("obj_source", shareItem.dqr);
                if (!aq.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        X.X("obj_param1", 9);
                    }
                    X.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(X);
            } else if (shareItem.dqi) {
                if (i == 3) {
                    str = "1";
                } else if (i == 4) {
                    str = "2";
                } else if (i == 9) {
                    str = "4";
                } else if (i == 5) {
                    str = "3";
                } else if (i == 7) {
                    str = "5";
                } else {
                    str = "6";
                }
                TiebaStatic.log(new an("c13365").cy("obj_locate", str).cy("topic_id", shareItem.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void cHK() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.jWt, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jWs, R.color.cp_cont_j, 1);
    }

    private String m(ShareItem shareItem) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(shareItem.title)) {
            sb.append("【");
            sb.append(shareItem.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(shareItem.title)) {
            sb.append(shareItem.content);
        }
        return sb.toString();
    }

    private boolean BR(int i) {
        return (i & 1) > 0;
    }

    private boolean BS(int i) {
        return (i & 2) > 0;
    }

    private boolean BV(int i) {
        return (i & 4) > 0;
    }

    private boolean BT(int i) {
        return (i & 8) > 0;
    }

    private boolean BU(int i) {
        return (i & 16) > 0;
    }

    private boolean BW(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        x sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aJB() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.jWt.setText(sharePanelConfData.getText());
        }
    }
}
