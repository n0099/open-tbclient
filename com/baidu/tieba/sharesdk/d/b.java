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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private ShareGridLayout ivD;
    private final TextView ivp;
    private View.OnClickListener ivs;
    private SparseArray<String> ivv;
    private SparseArray<v> ivw;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int dGy = l.h(TbadkCoreApplication.getInst(), d.e.tbds156);
    private static final int dDT = l.h(TbadkCoreApplication.getInst(), d.e.tbds234);
    private static final int ivz = l.h(TbadkCoreApplication.getInst(), d.e.tbds104);
    private static final int ivA = l.h(TbadkCoreApplication.getInst(), d.e.tbds36);
    private static final int ivB = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int cbX = l.h(TbadkCoreApplication.getInst(), d.e.tbds30);
    private final SparseArray<com.baidu.tbadk.coreExtra.c.d> ivt = new SparseArray<>(8);
    private boolean ivu = false;
    private boolean ivE = true;
    private final List<View> ivr = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.default_share_dialog_layout, (ViewGroup) null);
    private final TextView ivC = (TextView) this.mRootView.findViewById(d.g.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.ivC.setText(sharePanelText);
        }
        this.ivD = (ShareGridLayout) this.mRootView.findViewById(d.g.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.ivD.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.iTs;
            marginLayoutParams.rightMargin = ShareGridLayout.iTs;
            this.ivD.setLayoutParams(marginLayoutParams);
        }
        this.ivD.setItemParams(dGy, dDT);
        this.ivp = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);
        this.ivp.setOnClickListener(this);
        if (!yJ(i)) {
            ci(d.j.share_weixin, d.f.icon_share_wechat_n);
        }
        if (!yK(i)) {
            ci(d.j.share_weixin_timeline, d.f.icon_share_circle_n);
        }
        if (!yL(i)) {
            ci(d.j.share_qq_friends, d.f.icon_share_qq_n);
        }
        if (!yN(i)) {
            ci(d.j.share_qzone, d.f.icon_share_qqzone_n);
        }
        if (!yM(i)) {
            ci(d.j.share_sina_weibo, d.f.icon_share_weibo_n);
        }
        if (yO(i)) {
            ci(d.j.share_save_pic, d.f.icon_share_photo_album);
        }
        if (!e.ajT()) {
            this.ivD.setVisibility(8);
        }
    }

    private void aDA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.1
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

    private void ci(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ivz, ivz);
        layoutParams.topMargin = ivA;
        layoutParams.bottomMargin = ivB;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cbX);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        al.d(imageView, i2);
        al.j(textView, d.C0277d.cp_cont_f);
        linearLayout.setOnClickListener(this);
        this.ivr.add(linearLayout);
    }

    public LinearLayout cj(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ivz, ivz);
        layoutParams.topMargin = ivA;
        layoutParams.bottomMargin = ivB;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cbX);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        al.c(imageView, i2);
        al.j(textView, d.C0277d.cp_cont_f);
        return linearLayout;
    }

    public int caX() {
        if (this.ivr == null) {
            return 0;
        }
        return this.ivr.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.ivr.size() && i >= 0) {
            this.ivr.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener ivy;

        public a(View.OnClickListener onClickListener) {
            this.ivy = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.ivy != null) {
                this.ivy.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.ivE = z;
    }

    public void f(SparseArray<String> sparseArray) {
        this.ivv = sparseArray;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location aSx;
        if (z && (aSx = aSx()) != null) {
            dVar.cby = aSx;
        }
        this.ivt.put(1, dVar);
        if (!StringUtils.isNull(dVar.cbt)) {
            this.ivC.setText(dVar.cbt);
        }
    }

    private Location aSx() {
        if (ab.cR(this.mContext)) {
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
            this.ivs = onClickListener;
        }
    }

    public void caY() {
        if (this.ivE) {
            ci(d.j.share_copy, d.f.icon_share_copy_n);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ivr.size()) {
                this.ivD.addView(this.ivr.get(i2), new ViewGroup.LayoutParams(dGy, dDT));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.kY()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
        } else if (!e.ajT()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_share_install_failure);
        } else {
            caY();
            this.mDialog = new AlertDialog.Builder(this.mContext, d.k.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
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
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mRootView.setBackgroundResource(d.f.transmit_share_dialog_background_1);
            } else {
                this.mRootView.setBackgroundResource(d.f.transmit_share_dialog_background);
            }
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(d.k.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.mRootView);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    window.setBackgroundDrawableResource(d.f.transmit_share_dialog_background_1);
                } else {
                    window.setBackgroundDrawableResource(d.f.transmit_share_dialog_background);
                }
                caZ();
                aDA();
            }
        }
    }

    public void c(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.ivu = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.b(this.mDialog, (Activity) this.mContext);
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
        if (this.ivt.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.ivu) {
                this.ivu = true;
                com.baidu.tbadk.coreExtra.c.d yH = yH(1);
                e eVar = new e(this.mContext, null);
                if (id == d.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    if (yH != null && yH.cbp) {
                        a(yH, 16);
                    }
                    dismiss();
                } else if (i == d.f.icon_share_wechat_n) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    yI(3);
                    com.baidu.tbadk.coreExtra.c.d yH2 = yH(3);
                    a(yH2, 4);
                    if (yH2 != null) {
                        if (yH2.cbQ == 1) {
                            o(yH2);
                        } else {
                            eVar.b(yH2);
                        }
                    }
                } else if (i == d.f.icon_share_circle_n) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    yI(2);
                    com.baidu.tbadk.coreExtra.c.d yH3 = yH(2);
                    a(yH3, 3);
                    if (yH3 != null) {
                        if (yH3.cbQ == 1) {
                            o(yH3);
                            return;
                        }
                        if (yH3.cbk) {
                            yH3.content = "【" + yH3.title + "】 " + yH3.content;
                        }
                        eVar.c(yH3);
                    }
                } else if (i == d.f.icon_share_qqzone_n) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        yI(4);
                        com.baidu.tbadk.coreExtra.c.d yH4 = yH(4);
                        a(yH4, 5);
                        if (yH4 != null) {
                            eVar.e(yH4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abe();
                    }
                } else if (i == d.f.icon_qq_weibo) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    yI(5);
                    com.baidu.tbadk.coreExtra.c.d yH5 = yH(5);
                    a(yH5, 6);
                    if (yH5 != null) {
                        if (!yH5.cbj) {
                            yH5.content = m(yH5);
                        }
                        eVar.f(yH5);
                    }
                } else if (i == d.f.icon_share_weibo_n) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    yI(6);
                    com.baidu.tbadk.coreExtra.c.d yH6 = yH(6);
                    a(yH6, 7);
                    if (yH6 != null) {
                        if (!yH6.cbj) {
                            yH6.content = m(yH6);
                        }
                        eVar.g(yH6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    yI(7);
                    com.baidu.tbadk.coreExtra.c.d yH7 = yH(7);
                    a(yH7, 8);
                    if (yH7 != null) {
                        if (!yH7.cbj) {
                            yH7.content = m(yH7);
                        }
                        eVar.h(yH7);
                    }
                } else if (i == d.f.icon_share_qq_n) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        yI(8);
                        com.baidu.tbadk.coreExtra.c.d yH8 = yH(8);
                        a(yH8, 9);
                        if (yH8 != null) {
                            eVar.d(yH8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abe();
                    }
                } else if (i == d.f.icon_share_photo_album) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    this.mPermissionJudgement.adN();
                    this.mPermissionJudgement.e((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.Y((Activity) this.mContext)) {
                        a(yH, 17);
                        String uri = yH.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new n(currentActivity, uri, new n.a() { // from class: com.baidu.tieba.sharesdk.d.b.4
                                @Override // com.baidu.tbadk.util.n.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.n.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == d.f.icon_share_copy_n) {
                    a(yH, 10);
                    if (this.ivs != null) {
                        this.ivs.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bh(yH.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
                    }
                    n(yH);
                    if (yH != null && yH.cbj) {
                        aA(8, yH.cbz);
                    }
                }
            }
        }
    }

    private void o(final com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null && !TextUtils.isEmpty(dVar.content) && !TextUtils.isEmpty(dVar.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.ly(dVar.title);
            aVar.lz(dVar.content);
            aVar.setAutoNight(false);
            aVar.dq(true);
            aVar.dx(true);
            aVar.a(d.j.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.bh(dVar.content);
                    l.showToast(b.this.mContext.getApplicationContext(), d.j.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.aK(activity));
            aVar.aaW();
        }
    }

    private void n(com.baidu.tbadk.coreExtra.c.d dVar) {
        am T = new am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.cbD != 0) {
            T.T("obj_param1", dVar.cbD);
            if (dVar.cbD == 2) {
                T.bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.cbD == 3) {
                if (dVar.cbH != 0) {
                    T.T("obj_type", dVar.cbH);
                }
                T.bJ("tid", dVar.tid).bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(T);
    }

    private com.baidu.tbadk.coreExtra.c.d yH(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.ivt.get(i);
        if (dVar == null) {
            return this.ivt.get(1);
        }
        return dVar;
    }

    private void yI(int i) {
        if (i <= 8 && i > 0) {
            this.ivu = true;
            if (this.ivw != null) {
                v vVar = this.ivw.get(i);
                if (!StringUtils.isNull(vVar.agx()) && vVar.agy() != null && vVar.agy().size() > 0) {
                    k(vVar.agx(), vVar.agy());
                    return;
                }
            }
            if (this.ivv != null) {
                String str = this.ivv.get(i);
                if (!ap.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aA(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        String str;
        if (dVar != null && dVar.extData != null) {
            if (dVar.cbk) {
                TiebaStatic.log(new am("c10125").bJ(ImageViewerConfig.FORUM_ID, dVar.extData).T("obj_type", i));
            } else if (dVar.cbl || dVar.cbo) {
                TiebaStatic.log(new am("c10125").bJ("tid", dVar.extData).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.cbC).T("obj_param1", dVar.cbD).bJ(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.cbm) {
                TiebaStatic.log(new am("c10427").bJ("tid", dVar.extData).T("obj_type", i));
            } else if (dVar.cbj) {
                aA(i, dVar.cbz);
            } else if (dVar.cbn) {
                TiebaStatic.log(new am("c10125").T("obj_param1", 7).T("obj_type", i).bJ(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.cbp) {
                am T = new am("c10125").T("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl)) {
                    if (dVar.linkUrl.contains("worldcup")) {
                        T.T("obj_param1", 9);
                    }
                    T.bJ("obj_url", dVar.linkUrl);
                }
                TiebaStatic.log(T);
            } else if (dVar.cbr) {
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
                TiebaStatic.log(new am("c13365").bJ("obj_locate", str).bJ("topic_id", dVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void caZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            al.k(this.mRootView, d.f.transmit_share_dialog_background_1);
        } else {
            al.k(this.mRootView, d.f.transmit_share_dialog_background);
        }
        al.d(this.ivC, d.C0277d.cp_cont_c, 1);
        al.d(this.ivp, d.C0277d.cp_cont_j, 1);
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(dVar.title)) {
            sb.append("【");
            sb.append(dVar.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(dVar.title)) {
            sb.append(dVar.content);
        }
        return sb.toString();
    }

    private boolean yJ(int i) {
        return (i & 1) > 0;
    }

    private boolean yK(int i) {
        return (i & 2) > 0;
    }

    private boolean yN(int i) {
        return (i & 4) > 0;
    }

    private boolean yL(int i) {
        return (i & 8) > 0;
    }

    private boolean yM(int i) {
        return (i & 16) > 0;
    }

    private boolean yO(int i) {
        return (i & 32) > 0;
    }
}
