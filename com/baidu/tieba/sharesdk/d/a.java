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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog awV;
    private final LinearLayout hdU;
    private View.OnClickListener hdW;
    private SparseArray<String> hdZ;
    private SparseArray<v> hea;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> hdX = new SparseArray<>(8);
    private boolean hdY = false;
    private final List<View> hdV = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_dialog_content, (ViewGroup) null);
    private final TextView hdT = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.hdT.setOnClickListener(this);
        if (!uY(i)) {
            bK(e.j.share_weixin_timeline, e.f.icon_live_pengyouquan);
        }
        if (!uX(i)) {
            bK(e.j.share_weixin_friend, e.f.icon_live_weixin);
        }
        if (!uZ(i)) {
            bK(e.j.share_qq, e.f.icon_live_qq);
        }
        if (!va(i)) {
            bK(e.j.share_sina_weibo, e.f.icon_live_weibo);
        }
        this.hdU = (LinearLayout) this.mRootView.findViewById(e.g.share_content);
        if (!com.baidu.tbadk.coreExtra.c.e.KA()) {
            this.hdU.setVisibility(8);
        }
    }

    private void acI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.awV != null && a.this.awV.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private View bK(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_item_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(e.g.share_item_text)).setText(i);
        ((ImageView) inflate.findViewById(e.g.share_icon)).setImageResource(i2);
        inflate.setTag(Integer.valueOf(i2));
        inflate.setOnClickListener(this);
        this.hdV.add(inflate);
        return inflate;
    }

    public View bL(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_item_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(e.g.share_icon)).setImageResource(i2);
        ((TextView) inflate.findViewById(e.g.share_item_text)).setText(i);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    public int bAj() {
        if (this.hdV == null) {
            return 0;
        }
        return this.hdV.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.hdV.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.hdV.size() && i >= 0) {
            this.hdV.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0312a implements View.OnClickListener {
        private View.OnClickListener hec;

        public View$OnClickListenerC0312a(View.OnClickListener onClickListener) {
            this.hec = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.hec != null) {
                this.hec.onClick(view);
            }
        }
    }

    public void a(d dVar, boolean z) {
        Location asH;
        if (z && (asH = asH()) != null) {
            dVar.aSO = asH;
        }
        this.hdX.put(1, dVar);
    }

    private Location asH() {
        if (ab.bC(this.mContext)) {
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
            this.hdW = onClickListener;
        }
    }

    public void bAk() {
        int size = this.hdV.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.hdU.addView(this.hdV.get(i), layoutParams);
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.KA()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bAk();
            this.awV = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.awV.setCanceledOnTouchOutside(true);
            this.awV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.awV, (Activity) this.mContext);
            }
            Window window = this.awV.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bAl();
            acI();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.awV != null) {
            this.hdY = false;
            if (this.mContext instanceof Activity) {
                g.b(this.awV, (Activity) this.mContext);
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
        if (this.hdX.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.hdY) {
                this.hdY = true;
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                d uV = uV(1);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == e.f.icon_live_weixin) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    uW(3);
                    d uV2 = uV(3);
                    a(uV2, 4);
                    if (uV2 != null) {
                        eVar.b(uV2);
                    }
                } else if (i == e.f.icon_live_pengyouquan) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    uW(2);
                    d uV3 = uV(2);
                    a(uV3, 3);
                    if (uV3 != null) {
                        if (uV3.aSD) {
                            uV3.content = "【" + uV3.title + "】 " + uV3.content;
                        }
                        eVar.c(uV3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        uW(4);
                        d uV4 = uV(4);
                        a(uV4, 5);
                        if (uV4 != null) {
                            eVar.e(uV4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    uW(5);
                    d uV5 = uV(5);
                    a(uV5, 6);
                    if (uV5 != null) {
                        if (!uV5.aSC) {
                            uV5.content = m(uV5);
                        }
                        eVar.f(uV5);
                    }
                } else if (i == e.f.icon_live_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    uW(6);
                    d uV6 = uV(6);
                    a(uV6, 7);
                    if (uV6 != null) {
                        if (!uV6.aSC) {
                            uV6.content = m(uV6);
                        }
                        eVar.g(uV6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    uW(7);
                    d uV7 = uV(7);
                    a(uV7, 8);
                    if (uV7 != null) {
                        if (!uV7.aSC) {
                            uV7.content = m(uV7);
                        }
                        eVar.h(uV7);
                    }
                } else if (i == e.f.icon_live_qq) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        uW(8);
                        d uV8 = uV(8);
                        a(uV8, 9);
                        if (uV8 != null) {
                            eVar.d(uV8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(uV, 10);
                    if (this.hdW != null) {
                        this.hdW.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uV.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uV);
                    if (uV != null && uV.aSC) {
                        ai(8, uV.aSP);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am y = new am("share_success").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aST != 0) {
            y.y("obj_param1", dVar.aST);
            if (dVar.aST == 2) {
                y.aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aST == 3) {
                if (dVar.aSU != 0) {
                    y.y("obj_type", dVar.aSU);
                }
                y.aB("tid", dVar.tid).aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(y);
    }

    private d uV(int i) {
        d dVar = this.hdX.get(i);
        if (dVar == null) {
            return this.hdX.get(1);
        }
        return dVar;
    }

    private void uW(int i) {
        if (i <= 8 && i > 0) {
            this.hdY = true;
            if (this.hea != null) {
                v vVar = this.hea.get(i);
                if (!StringUtils.isNull(vVar.Hh()) && vVar.Hi() != null && vVar.Hi().size() > 0) {
                    l(vVar.Hh(), vVar.Hi());
                    return;
                }
            }
            if (this.hdZ != null) {
                String str = this.hdZ.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void ai(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aSD) {
                TiebaStatic.log(new am("c10125").aB(ImageViewerConfig.FORUM_ID, dVar.extData).y("obj_type", i));
            } else if (dVar.aSE || dVar.aSH) {
                TiebaStatic.log(new am("c10125").aB("tid", dVar.extData).y("obj_type", i).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSS).y("obj_param1", dVar.aST).aB(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSF) {
                TiebaStatic.log(new am("c10427").aB("tid", dVar.extData).y("obj_type", i));
            } else if (dVar.aSC) {
                ai(i, dVar.aSP);
            } else if (dVar.aSG) {
                TiebaStatic.log(new am("c10125").y("obj_param1", 7).y("obj_type", i).aB(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSI) {
                am y = new am("c10125").y("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    y.y("obj_param1", 9);
                }
                TiebaStatic.log(y);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bAl() {
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean uX(int i) {
        return (i & 1) > 0;
    }

    private boolean uY(int i) {
        return (i & 2) > 0;
    }

    private boolean uZ(int i) {
        return (i & 8) > 0;
    }

    private boolean va(int i) {
        return (i & 16) > 0;
    }
}
