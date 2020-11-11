package com.baidu.tieba.sharesdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes24.dex */
public class c implements View.OnClickListener {
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
    private PermissionJudgePolicy mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int hnK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int hnL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int mLj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mLk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int mLl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fhH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    protected final SparseArray<ShareItem> mLr = new SparseArray<>(8);
    private boolean mLs = false;
    private boolean mLO = true;
    private int mLP = 0;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dGh();
                c.this.mLo.removeAllViews();
                c.this.dGg();
            }
        }
    };
    private final List<View> mLp = new ArrayList();
    protected final View mRootView = cBH();
    protected final View kFY = this.mRootView.findViewById(R.id.share_dialog_main_view);
    private final TextView mLn = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public c(Context context, boolean z, int i) {
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
    }

    protected View cBH() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    private void bUx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.c.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (c.this.mDialog != null && c.this.mDialog.isShowing()) {
                    c.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dGk() {
        ArrayList arrayList = new ArrayList(this.mLp);
        this.mLp.clear();
        if (!IV(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!IW(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!IX(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!IZ(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!IY(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Ja(this.hideMode)) {
            a(R.string.share_save_pic, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_download40_svg, R.color.cp_cont_b));
        }
        if (arrayList.size() > 0) {
            this.mLp.addAll(arrayList);
        }
        if (this.mLO) {
            a(R.string.share_copy, new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.eJB));
            ImageView imageView = new ImageView(this.mContext);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.brO().pj(1).pk(R.color.cp_bg_line_i).bk(imageView);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
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
            ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
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
        if (ap.getDrawable(i2) instanceof BitmapDrawable) {
            ap.setImageResource(imageView, i2);
        } else {
            com.baidu.tbadk.core.util.d.c cVar = new com.baidu.tbadk.core.util.d.c(i2, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.brO().pj(1).pk(R.color.cp_bg_line_i).bk(imageView);
            imageView.setImageDrawable(cVar.getDrawable());
        }
        ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
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
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes24.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener mLw;

        public a(View.OnClickListener onClickListener) {
            this.mLw = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            if (this.mLw != null) {
                this.mLw.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.mLO = z;
    }

    public void setCustomCopyTitle(int i) {
        this.mLP = i;
    }

    public void g(SparseArray<String> sparseArray) {
        this.mLt = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cpB;
        if (z && (cpB = cpB()) != null) {
            shareItem.location = cpB;
        }
        this.mLr.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fgR)) {
            this.mLn.setText(shareItem.fgR);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location cpB;
        if (z && (cpB = cpB()) != null) {
            shareItem.location = cpB;
        }
        this.mLr.put(i, shareItem);
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
        dGk();
        if (!g.bxA()) {
            this.mLo.setVisibility(8);
        }
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
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.c.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (c.this.mOnDismissListener != null) {
                        c.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.c.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (c.this.onCancelListener != null) {
                        c.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            ap.setBackgroundResource(this.kFY, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                b(window);
                window.setContentView(this.mRootView);
                dGh();
                bUx();
                i.I(this.mContext).registerListener(this.skinChangeListener);
            }
        }
    }

    protected void b(Window window) {
        window.setLayout(-1, -2);
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void f(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.mLs = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.skinChangeListener);
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
        if (i != R.drawable.icon_pure_share_download40_svg) {
            dismiss();
        }
        if (this.mLr.size() != 0) {
            if (id == R.id.btnShareCancel || !this.mLs) {
                this.mLs = true;
                ShareItem IT = IT(1);
                g gVar = new g(this.mContext, null);
                if (IT != null && IT.fhm) {
                    TiebaStatic.log(new aq("c13531").dR("obj_id", IT.fhn).al("obj_type", IT.fho).dR("obj_source", IT.fhp));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (IT != null && IT.fgK) {
                        a(IT, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                        return;
                    }
                    return;
                }
                aq aqVar = new aq("c13724");
                if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    IU(3);
                    ShareItem IT2 = IT(3);
                    a(IT2, 4);
                    if (IT2 != null) {
                        if (o(IT2) && IT2.getCommandChannelArray() != null && IT2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IT2, this.mContext, 3, this.onCancelListener);
                        } else if (IT2.fhk == 1) {
                            p(IT2);
                        } else {
                            gVar.f(IT2);
                        }
                    }
                    aqVar.al("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IU(2);
                    ShareItem IT3 = IT(2);
                    a(IT3, 3);
                    if (IT3 != null) {
                        if (o(IT3) && IT3.getCommandChannelArray() != null && IT3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IT3, this.mContext, 2, this.onCancelListener);
                        } else if (IT3.fhk == 1) {
                            p(IT3);
                        } else {
                            if (IT3.fgF) {
                                IT3.content = "【" + IT3.title + "】 " + IT3.content;
                            }
                            gVar.g(IT3);
                        }
                    }
                    aqVar.al("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IU(4);
                        ShareItem IT4 = IT(4);
                        a(IT4, 5);
                        if (IT4 != null) {
                            if (o(IT4) && IT4.getCommandChannelArray() != null && IT4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IT4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.i(IT4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bpi();
                    }
                    aqVar.al("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IU(5);
                    ShareItem IT5 = IT(5);
                    if (IT5 != null) {
                        if (!IT5.fgE) {
                            IT5.content = m(IT5);
                        }
                        gVar.j(IT5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
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
                        if (o(IT6) && IT6.getCommandChannelArray() != null && IT6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IT6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.k(IT6);
                        }
                    }
                    aqVar.al("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IU(7);
                    ShareItem IT7 = IT(7);
                    if (IT7 != null) {
                        if (!IT7.fgE) {
                            IT7.content = m(IT7);
                        }
                        gVar.l(IT7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IU(8);
                        ShareItem IT8 = IT(8);
                        a(IT8, 9);
                        if (IT8 != null) {
                            if (o(IT8) && IT8.getCommandChannelArray() != null && IT8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IT8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.h(IT8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bpi();
                    }
                    aqVar.al("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.mLs = false;
                        return;
                    }
                    dismiss();
                    a(IT, 17);
                    if (n.u(IT.imageUri)) {
                        if (n.copyImageFile(n.getImageRealPathFromUri(this.mContext, IT.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = IT.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new p(currentActivity, uri, new p.a() { // from class: com.baidu.tieba.sharesdk.d.c.5
                                @Override // com.baidu.tbadk.util.p.a
                                public void onError(int i2, String str) {
                                    l.showToast(c.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.p.a
                                public void onSuccess(String str) {
                                    l.showToast(c.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        } else {
                            return;
                        }
                    }
                    aqVar.al("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40_svg) {
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
                aqVar.al("obj_source", 6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private boolean o(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fhr) || TextUtils.isEmpty(shareItem.fhs)) ? false : true;
    }

    private void p(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.Bn(shareItem.title);
            aVar.Bo(shareItem.content);
            aVar.setAutoNight(false);
            aVar.iV(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(c.this.mContext.getApplicationContext(), (int) R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.I(activity));
            aVar.bpc();
        }
    }

    private void n(ShareItem shareItem) {
        aq al = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 7);
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
        al.al("obj_locate", 9);
        TiebaStatic.log(al);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem IT(int i) {
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
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i).al("obj_source", shareItem.fgW));
                }
            } else if (shareItem.fgF) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fgW));
            } else if (shareItem.fgG || shareItem.fgJ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fgW).al("obj_param1", shareItem.fgX).dR("fid", shareItem.fid).al(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgY));
            } else if (shareItem.fgH) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fgE) {
                bP(i, shareItem.fgT);
            } else if (shareItem.fgI) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_param1", 7).al("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fgK) {
                aq al = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i);
                al.al("obj_source", shareItem.fgW);
                if (!at.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        al.al("obj_param1", 9);
                    }
                    al.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(al);
            } else if (shareItem.fgM) {
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
                TiebaStatic.log(new aq("c13365").dR("obj_locate", str).dR("topic_id", shareItem.extData));
            } else if (shareItem.fgN) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                aqVar.dR("tid", shareItem.extData);
                aqVar.dR("post_id", shareItem.pid);
                aqVar.al("obj_source", 18);
                TiebaStatic.log(aqVar);
            } else if (shareItem.fgO) {
                aq aqVar2 = new aq("c13953");
                aqVar2.al("obj_type", i);
                aqVar2.dR("obj_name", shareItem.title);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dGh() {
        ap.setBackgroundResource(this.kFY, R.drawable.transmit_share_dialog_background);
        ap.setViewTextColor(this.mLn, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.mLm, R.color.cp_cont_j, 1);
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

    private boolean IV(int i) {
        return (i & 1) > 0;
    }

    private boolean IW(int i) {
        return (i & 2) > 0;
    }

    private boolean IZ(int i) {
        return (i & 4) > 0;
    }

    private boolean IX(int i) {
        return (i & 8) > 0;
    }

    private boolean IY(int i) {
        return (i & 16) > 0;
    }

    private boolean Ja(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.buQ() && !at.isEmpty(sharePanelConfData.getText())) {
            this.mLn.setText(sharePanelConfData.getText());
        }
    }
}
