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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog awt;
    private final LinearLayout hcP;
    private View.OnClickListener hcR;
    private SparseArray<String> hcU;
    private SparseArray<u> hcV;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> hcS = new SparseArray<>(8);
    private boolean hcT = false;
    private final List<View> hcQ = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_dialog_content, (ViewGroup) null);
    private final TextView hcO = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.hcO.setOnClickListener(this);
        if (!uV(i)) {
            bK(e.j.share_weixin_timeline, e.f.icon_live_pengyouquan);
        }
        if (!uU(i)) {
            bK(e.j.share_weixin_friend, e.f.icon_live_weixin);
        }
        if (!uW(i)) {
            bK(e.j.share_qq, e.f.icon_live_qq);
        }
        if (!uX(i)) {
            bK(e.j.share_sina_weibo, e.f.icon_live_weibo);
        }
        this.hcP = (LinearLayout) this.mRootView.findViewById(e.g.share_content);
        if (!com.baidu.tbadk.coreExtra.c.e.Kl()) {
            this.hcP.setVisibility(8);
        }
    }

    private void acl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.awt != null && a.this.awt.isShowing()) {
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
        this.hcQ.add(inflate);
        return inflate;
    }

    public View bL(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_item_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(e.g.share_icon)).setImageResource(i2);
        ((TextView) inflate.findViewById(e.g.share_item_text)).setText(i);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    public int bzA() {
        if (this.hcQ == null) {
            return 0;
        }
        return this.hcQ.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.hcQ.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.hcQ.size() && i >= 0) {
            this.hcQ.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0312a implements View.OnClickListener {
        private View.OnClickListener hcX;

        public View$OnClickListenerC0312a(View.OnClickListener onClickListener) {
            this.hcX = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.hcX != null) {
                this.hcX.onClick(view);
            }
        }
    }

    public void a(d dVar, boolean z) {
        Location asj;
        if (z && (asj = asj()) != null) {
            dVar.aSj = asj;
        }
        this.hcS.put(1, dVar);
    }

    private Location asj() {
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
            this.hcR = onClickListener;
        }
    }

    public void bzB() {
        int size = this.hcQ.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.hcP.addView(this.hcQ.get(i), layoutParams);
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.Kl()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bzB();
            this.awt = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.awt.setCanceledOnTouchOutside(true);
            this.awt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.awt, (Activity) this.mContext);
            }
            Window window = this.awt.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bzC();
            acl();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.awt != null) {
            this.hcT = false;
            if (this.mContext instanceof Activity) {
                g.b(this.awt, (Activity) this.mContext);
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
        if (this.hcS.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.hcT) {
                this.hcT = true;
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                d uS = uS(1);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == e.f.icon_live_weixin) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    uT(3);
                    d uS2 = uS(3);
                    a(uS2, 4);
                    if (uS2 != null) {
                        eVar.b(uS2);
                    }
                } else if (i == e.f.icon_live_pengyouquan) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    uT(2);
                    d uS3 = uS(2);
                    a(uS3, 3);
                    if (uS3 != null) {
                        if (uS3.aRZ) {
                            uS3.content = "【" + uS3.title + "】 " + uS3.content;
                        }
                        eVar.c(uS3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        uT(4);
                        d uS4 = uS(4);
                        a(uS4, 5);
                        if (uS4 != null) {
                            eVar.e(uS4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    uT(5);
                    d uS5 = uS(5);
                    a(uS5, 6);
                    if (uS5 != null) {
                        if (!uS5.aRY) {
                            uS5.content = m(uS5);
                        }
                        eVar.f(uS5);
                    }
                } else if (i == e.f.icon_live_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    uT(6);
                    d uS6 = uS(6);
                    a(uS6, 7);
                    if (uS6 != null) {
                        if (!uS6.aRY) {
                            uS6.content = m(uS6);
                        }
                        eVar.g(uS6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    uT(7);
                    d uS7 = uS(7);
                    a(uS7, 8);
                    if (uS7 != null) {
                        if (!uS7.aRY) {
                            uS7.content = m(uS7);
                        }
                        eVar.h(uS7);
                    }
                } else if (i == e.f.icon_live_qq) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        uT(8);
                        d uS8 = uS(8);
                        a(uS8, 9);
                        if (uS8 != null) {
                            eVar.d(uS8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(uS, 10);
                    if (this.hcR != null) {
                        this.hcR.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uS.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uS);
                    if (uS != null && uS.aRY) {
                        ag(8, uS.aSk);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am x = new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aSo != 0) {
            x.x("obj_param1", dVar.aSo);
            if (dVar.aSo == 2) {
                x.aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aSo == 3) {
                if (dVar.aSp != 0) {
                    x.x("obj_type", dVar.aSp);
                }
                x.aA("tid", dVar.tid).aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(x);
    }

    private d uS(int i) {
        d dVar = this.hcS.get(i);
        if (dVar == null) {
            return this.hcS.get(1);
        }
        return dVar;
    }

    private void uT(int i) {
        if (i <= 8 && i > 0) {
            this.hcT = true;
            if (this.hcV != null) {
                u uVar = this.hcV.get(i);
                if (!StringUtils.isNull(uVar.GT()) && uVar.GU() != null && uVar.GU().size() > 0) {
                    l(uVar.GT(), uVar.GU());
                    return;
                }
            }
            if (this.hcU != null) {
                String str = this.hcU.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void ag(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aRZ) {
                TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aSa || dVar.aSd) {
                TiebaStatic.log(new am("c10125").aA("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSn).x("obj_param1", dVar.aSo).aA(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSb) {
                TiebaStatic.log(new am("c10427").aA("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aRY) {
                ag(i, dVar.aSk);
            } else if (dVar.aSc) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).aA(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSe) {
                am x = new am("c10125").x("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    x.x("obj_param1", 9);
                }
                TiebaStatic.log(x);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bzC() {
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean uU(int i) {
        return (i & 1) > 0;
    }

    private boolean uV(int i) {
        return (i & 2) > 0;
    }

    private boolean uW(int i) {
        return (i & 8) > 0;
    }

    private boolean uX(int i) {
        return (i & 16) > 0;
    }
}
