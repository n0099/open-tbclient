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
    private AlertDialog awW;
    private final LinearLayout hdV;
    private View.OnClickListener hdX;
    private SparseArray<String> hea;
    private SparseArray<v> heb;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> hdY = new SparseArray<>(8);
    private boolean hdZ = false;
    private final List<View> hdW = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_dialog_content, (ViewGroup) null);
    private final TextView hdU = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.hdU.setOnClickListener(this);
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
        this.hdV = (LinearLayout) this.mRootView.findViewById(e.g.share_content);
        if (!com.baidu.tbadk.coreExtra.c.e.KA()) {
            this.hdV.setVisibility(8);
        }
    }

    private void acI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.awW != null && a.this.awW.isShowing()) {
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
        this.hdW.add(inflate);
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
        if (this.hdW == null) {
            return 0;
        }
        return this.hdW.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.hdW.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.hdW.size() && i >= 0) {
            this.hdW.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0312a implements View.OnClickListener {
        private View.OnClickListener hed;

        public View$OnClickListenerC0312a(View.OnClickListener onClickListener) {
            this.hed = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.hed != null) {
                this.hed.onClick(view);
            }
        }
    }

    public void a(d dVar, boolean z) {
        Location asH;
        if (z && (asH = asH()) != null) {
            dVar.aSP = asH;
        }
        this.hdY.put(1, dVar);
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
            this.hdX = onClickListener;
        }
    }

    public void bAk() {
        int size = this.hdW.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.hdV.addView(this.hdW.get(i), layoutParams);
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.KA()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bAk();
            this.awW = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.awW.setCanceledOnTouchOutside(true);
            this.awW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.awW, (Activity) this.mContext);
            }
            Window window = this.awW.getWindow();
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
        if (this.awW != null) {
            this.hdZ = false;
            if (this.mContext instanceof Activity) {
                g.b(this.awW, (Activity) this.mContext);
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
        if (this.hdY.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.hdZ) {
                this.hdZ = true;
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
                        if (uV3.aSE) {
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
                        if (!uV5.aSD) {
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
                        if (!uV6.aSD) {
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
                        if (!uV7.aSD) {
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
                    if (this.hdX != null) {
                        this.hdX.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uV.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uV);
                    if (uV != null && uV.aSD) {
                        ai(8, uV.aSQ);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am y = new am("share_success").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aSU != 0) {
            y.y("obj_param1", dVar.aSU);
            if (dVar.aSU == 2) {
                y.aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aSU == 3) {
                if (dVar.aSV != 0) {
                    y.y("obj_type", dVar.aSV);
                }
                y.aB("tid", dVar.tid).aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(y);
    }

    private d uV(int i) {
        d dVar = this.hdY.get(i);
        if (dVar == null) {
            return this.hdY.get(1);
        }
        return dVar;
    }

    private void uW(int i) {
        if (i <= 8 && i > 0) {
            this.hdZ = true;
            if (this.heb != null) {
                v vVar = this.heb.get(i);
                if (!StringUtils.isNull(vVar.Hh()) && vVar.Hi() != null && vVar.Hi().size() > 0) {
                    l(vVar.Hh(), vVar.Hi());
                    return;
                }
            }
            if (this.hea != null) {
                String str = this.hea.get(i);
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
            if (dVar.aSE) {
                TiebaStatic.log(new am("c10125").aB(ImageViewerConfig.FORUM_ID, dVar.extData).y("obj_type", i));
            } else if (dVar.aSF || dVar.aSI) {
                TiebaStatic.log(new am("c10125").aB("tid", dVar.extData).y("obj_type", i).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aST).y("obj_param1", dVar.aSU).aB(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSG) {
                TiebaStatic.log(new am("c10427").aB("tid", dVar.extData).y("obj_type", i));
            } else if (dVar.aSD) {
                ai(i, dVar.aSQ);
            } else if (dVar.aSH) {
                TiebaStatic.log(new am("c10125").y("obj_param1", 7).y("obj_type", i).aB(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSJ) {
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
