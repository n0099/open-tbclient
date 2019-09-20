package com.baidu.tieba.sharesdk.d;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.f.c;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private final TextView iYe;
    private ShareGridLayout iYg;
    private View.OnClickListener iYi;
    private SparseArray<String> iYl;
    private SparseArray<w> iYm;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int dWF = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int dTX = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iYb = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iYc = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iYd = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int cmt = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iYj = new SparseArray<>(8);
    private boolean iYk = false;
    private boolean iYp = true;
    private CustomMessageListener bOJ = new CustomMessageListener(2001304) { // from class: com.baidu.tieba.sharesdk.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                b.this.cnc();
                b.this.iYg.removeAllViews();
                b.this.cnb();
            }
        }
    };
    private final List<View> iYh = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView iYf = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.iYf.setText(sharePanelText);
        }
        this.iYg = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.iYg.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.jwb;
            marginLayoutParams.rightMargin = ShareGridLayout.jwb;
            this.iYg.setLayoutParams(marginLayoutParams);
        }
        this.iYg.setItemParams(dWF, dTX);
        this.iYe = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.iYe.setOnClickListener(this);
    }

    private void aMb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.2
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

    private void cnd() {
        this.iYh.clear();
        if (!AC(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg));
        }
        if (!AD(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg));
        }
        if (!AE(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg));
        }
        if (!AG(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg));
        }
        if (!AF(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg));
        }
        if (AH(this.hideMode)) {
            a(R.string.share_save_pic, new c(R.drawable.icon_share_download_n_svg));
        }
        if (this.iYp) {
            a(R.string.share_copy, new c(R.drawable.icon_share_copy_n_svg));
        }
    }

    private void a(int i, com.baidu.tbadk.core.util.f.a aVar) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(aVar.bPt));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iYb, iYb);
            layoutParams.topMargin = iYc;
            layoutParams.bottomMargin = iYd;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, cmt);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.j(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.iYh.add(linearLayout);
        }
    }

    public LinearLayout cu(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iYb, iYb);
        layoutParams.topMargin = iYc;
        layoutParams.bottomMargin = iYd;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cmt);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        am.c(imageView, i2);
        am.j(textView, R.color.cp_cont_f);
        return linearLayout;
    }

    public int cna() {
        if (this.iYh == null) {
            return 0;
        }
        return this.iYh.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iYh.size() && i >= 0) {
            this.iYh.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener iYo;

        public a(View.OnClickListener onClickListener) {
            this.iYo = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.iYo != null) {
                this.iYo.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.iYp = z;
    }

    public void f(SparseArray<String> sparseArray) {
        this.iYl = sparseArray;
    }

    public void a(e eVar, boolean z) {
        Location bcn;
        if (z && (bcn = bcn()) != null) {
            eVar.clI = bcn;
        }
        this.iYj.put(1, eVar);
        if (!StringUtils.isNull(eVar.clD)) {
            this.iYf.setText(eVar.clD);
        }
    }

    private Location bcn() {
        if (ab.cx(this.mContext)) {
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
            this.iYi = onClickListener;
        }
    }

    public void cnb() {
        cnd();
        if (!f.aqo()) {
            this.iYg.setVisibility(8);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iYh.size()) {
                this.iYg.addView(this.iYh.get(i2), new ViewGroup.LayoutParams(dWF, dTX));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.kc()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aqo()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cnb();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
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
                g.a(this.mDialog, (Activity) this.mContext);
            }
            am.k(this.mRootView, R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.mRootView);
                window.setBackgroundDrawable(am.getDrawable(R.drawable.transmit_share_dialog_background));
                cnc();
                aMb();
                i.ab(this.mContext).registerListener(this.bOJ);
            }
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void f(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iYk = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.b(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.bOJ);
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
        if (this.iYj.size() != 0) {
            if (id == R.id.btnShareCancel || !this.iYk) {
                this.iYk = true;
                e AA = AA(1);
                f fVar = new f(this.mContext, null);
                if (AA != null && AA.cme) {
                    TiebaStatic.log(new an("c13531").bT(VideoPlayActivityConfig.OBJ_ID, AA.cmf).P("obj_type", AA.cmg).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, AA.cmh));
                }
                if (id == R.id.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    if (AA != null && AA.cly) {
                        a(AA, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                    }
                } else if (i == R.drawable.icon_mask_share_wechat_n_svg) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    AB(3);
                    e AA2 = AA(3);
                    a(AA2, 4);
                    if (AA2 != null) {
                        if (AA2.cma == 1) {
                            r(AA2);
                        } else {
                            fVar.e(AA2);
                        }
                    }
                } else if (i == R.drawable.icon_mask_share_circle_n_svg) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    AB(2);
                    e AA3 = AA(2);
                    a(AA3, 3);
                    if (AA3 != null) {
                        if (AA3.cma == 1) {
                            r(AA3);
                            return;
                        }
                        if (AA3.clt) {
                            AA3.content = "【" + AA3.title + "】 " + AA3.content;
                        }
                        fVar.f(AA3);
                    }
                } else if (i == R.drawable.icon_mask_share_qqzone_n_svg) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        AB(4);
                        e AA4 = AA(4);
                        a(AA4, 5);
                        if (AA4 != null) {
                            fVar.h(AA4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agW();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    AB(5);
                    e AA5 = AA(5);
                    a(AA5, 6);
                    if (AA5 != null) {
                        if (!AA5.cls) {
                            AA5.content = p(AA5);
                        }
                        fVar.i(AA5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo_n_svg) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    AB(6);
                    e AA6 = AA(6);
                    a(AA6, 7);
                    if (AA6 != null) {
                        if (!AA6.cls) {
                            AA6.content = p(AA6);
                        }
                        fVar.j(AA6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    AB(7);
                    e AA7 = AA(7);
                    a(AA7, 8);
                    if (AA7 != null) {
                        if (!AA7.cls) {
                            AA7.content = p(AA7);
                        }
                        fVar.k(AA7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq_n_svg) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        AB(8);
                        e AA8 = AA(8);
                        a(AA8, 9);
                        if (AA8 != null) {
                            fVar.g(AA8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agW();
                    }
                } else if (i == R.drawable.icon_share_download_n_svg) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    this.mPermissionJudgement.ake();
                    this.mPermissionJudgement.e((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.ad((Activity) this.mContext)) {
                        a(AA, 17);
                        String uri = AA.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new m(currentActivity, uri, new m.a() { // from class: com.baidu.tieba.sharesdk.d.b.5
                                @Override // com.baidu.tbadk.util.m.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.m.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == R.drawable.icon_share_copy_n_svg) {
                    a(AA, 10);
                    if (this.iYi != null) {
                        this.iYi.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aS(AA.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    q(AA);
                    if (AA != null && AA.cls) {
                        aD(8, AA.clJ);
                    }
                }
            }
        }
    }

    private void r(final e eVar) {
        if (eVar != null && !TextUtils.isEmpty(eVar.content) && !TextUtils.isEmpty(eVar.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.mP(eVar.title);
            aVar.mQ(eVar.content);
            aVar.setAutoNight(false);
            aVar.dQ(true);
            aVar.dX(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.aS(eVar.content);
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
            aVar.agO();
        }
    }

    private void q(e eVar) {
        an P = new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.clN != 0) {
            P.P("obj_param1", eVar.clN);
            if (eVar.clN == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.clN == 3) {
                if (eVar.clR != 0) {
                    P.P("obj_type", eVar.clR);
                }
                P.bT("tid", eVar.tid).bT("fid", eVar.fid);
            }
        }
        TiebaStatic.log(P);
    }

    private e AA(int i) {
        e eVar = this.iYj.get(i);
        if (eVar == null) {
            return this.iYj.get(1);
        }
        return eVar;
    }

    private void AB(int i) {
        if (i <= 8 && i > 0) {
            this.iYk = true;
            if (this.iYm != null) {
                w wVar = this.iYm.get(i);
                if (!StringUtils.isNull(wVar.amP()) && wVar.amQ() != null && wVar.amQ().size() > 0) {
                    k(wVar.amP(), wVar.amQ());
                    return;
                }
            }
            if (this.iYl != null) {
                String str = this.iYl.get(i);
                if (!aq.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aD(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(e eVar, int i) {
        String str;
        if (eVar != null && eVar.extData != null) {
            if (eVar.clt) {
                TiebaStatic.log(new an("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.clu || eVar.clx) {
                TiebaStatic.log(new an("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.clM).P("obj_param1", eVar.clN).bT("fid", eVar.fid));
            } else if (eVar.clv) {
                TiebaStatic.log(new an("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.cls) {
                aD(i, eVar.clJ);
            } else if (eVar.clw) {
                TiebaStatic.log(new an("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            } else if (eVar.cly) {
                an P = new an("c10125").P("obj_type", i);
                if (!aq.isEmpty(eVar.linkUrl)) {
                    if (eVar.linkUrl.contains("worldcup")) {
                        P.P("obj_param1", 9);
                    }
                    P.bT("obj_url", eVar.linkUrl);
                }
                TiebaStatic.log(P);
            } else if (eVar.clA) {
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
                    str = Constants.VIA_SHARE_TYPE_INFO;
                }
                TiebaStatic.log(new an("c13365").bT("obj_locate", str).bT("topic_id", eVar.extData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void cnc() {
        am.k(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.f(this.iYf, R.color.cp_cont_c, 1);
        am.f(this.iYe, R.color.cp_cont_j, 1);
    }

    private String p(e eVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(eVar.title)) {
            sb.append("【");
            sb.append(eVar.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(eVar.title)) {
            sb.append(eVar.content);
        }
        return sb.toString();
    }

    private boolean AC(int i) {
        return (i & 1) > 0;
    }

    private boolean AD(int i) {
        return (i & 2) > 0;
    }

    private boolean AG(int i) {
        return (i & 4) > 0;
    }

    private boolean AE(int i) {
        return (i & 8) > 0;
    }

    private boolean AF(int i) {
        return (i & 16) > 0;
    }

    private boolean AH(int i) {
        return (i & 32) > 0;
    }
}
