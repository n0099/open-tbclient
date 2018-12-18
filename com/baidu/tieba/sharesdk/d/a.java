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
    private AlertDialog aws;
    private final LinearLayout gZL;
    private View.OnClickListener gZN;
    private SparseArray<String> gZQ;
    private SparseArray<u> gZR;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gZO = new SparseArray<>(8);
    private boolean gZP = false;
    private final List<View> gZM = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_dialog_content, (ViewGroup) null);
    private final TextView gZK = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gZK.setOnClickListener(this);
        if (!uI(i)) {
            bJ(e.j.share_weixin_timeline, e.f.icon_live_pengyouquan);
        }
        if (!uH(i)) {
            bJ(e.j.share_weixin_friend, e.f.icon_live_weixin);
        }
        if (!uJ(i)) {
            bJ(e.j.share_qq, e.f.icon_live_qq);
        }
        if (!uK(i)) {
            bJ(e.j.share_sina_weibo, e.f.icon_live_weibo);
        }
        this.gZL = (LinearLayout) this.mRootView.findViewById(e.g.share_content);
        if (!com.baidu.tbadk.coreExtra.c.e.Kk()) {
            this.gZL.setVisibility(8);
        }
    }

    private void acj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.aws != null && a.this.aws.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private View bJ(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_item_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(e.g.share_item_text)).setText(i);
        ((ImageView) inflate.findViewById(e.g.share_icon)).setImageResource(i2);
        inflate.setTag(Integer.valueOf(i2));
        inflate.setOnClickListener(this);
        this.gZM.add(inflate);
        return inflate;
    }

    public View bK(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.ala_share_item_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(e.g.share_icon)).setImageResource(i2);
        ((TextView) inflate.findViewById(e.g.share_item_text)).setText(i);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    public int byK() {
        if (this.gZM == null) {
            return 0;
        }
        return this.gZM.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gZM.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.gZM.size() && i >= 0) {
            this.gZM.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0312a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0312a implements View.OnClickListener {
        private View.OnClickListener gZT;

        public View$OnClickListenerC0312a(View.OnClickListener onClickListener) {
            this.gZT = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gZT != null) {
                this.gZT.onClick(view);
            }
        }
    }

    public void a(d dVar, boolean z) {
        Location aru;
        if (z && (aru = aru()) != null) {
            dVar.aSh = aru;
        }
        this.gZO.put(1, dVar);
    }

    private Location aru() {
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
            this.gZN = onClickListener;
        }
    }

    public void byL() {
        int size = this.gZM.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.gZL.addView(this.gZM.get(i), layoutParams);
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.Kk()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            byL();
            this.aws = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.aws.setCanceledOnTouchOutside(true);
            this.aws.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.aws, (Activity) this.mContext);
            }
            Window window = this.aws.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            byM();
            acj();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.aws != null) {
            this.gZP = false;
            if (this.mContext instanceof Activity) {
                g.b(this.aws, (Activity) this.mContext);
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
        if (this.gZO.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.gZP) {
                this.gZP = true;
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                d uF = uF(1);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == e.f.icon_live_weixin) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    uG(3);
                    d uF2 = uF(3);
                    a(uF2, 4);
                    if (uF2 != null) {
                        eVar.b(uF2);
                    }
                } else if (i == e.f.icon_live_pengyouquan) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    uG(2);
                    d uF3 = uF(2);
                    a(uF3, 3);
                    if (uF3 != null) {
                        if (uF3.aRX) {
                            uF3.content = "【" + uF3.title + "】 " + uF3.content;
                        }
                        eVar.c(uF3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        uG(4);
                        d uF4 = uF(4);
                        a(uF4, 5);
                        if (uF4 != null) {
                            eVar.e(uF4);
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
                    uG(5);
                    d uF5 = uF(5);
                    a(uF5, 6);
                    if (uF5 != null) {
                        if (!uF5.aRW) {
                            uF5.content = m(uF5);
                        }
                        eVar.f(uF5);
                    }
                } else if (i == e.f.icon_live_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    uG(6);
                    d uF6 = uF(6);
                    a(uF6, 7);
                    if (uF6 != null) {
                        if (!uF6.aRW) {
                            uF6.content = m(uF6);
                        }
                        eVar.g(uF6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    uG(7);
                    d uF7 = uF(7);
                    a(uF7, 8);
                    if (uF7 != null) {
                        if (!uF7.aRW) {
                            uF7.content = m(uF7);
                        }
                        eVar.h(uF7);
                    }
                } else if (i == e.f.icon_live_qq) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        uG(8);
                        d uF8 = uF(8);
                        a(uF8, 9);
                        if (uF8 != null) {
                            eVar.d(uF8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(uF, 10);
                    if (this.gZN != null) {
                        this.gZN.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uF.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uF);
                    if (uF != null && uF.aRW) {
                        af(8, uF.aSi);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am x = new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aSm != 0) {
            x.x("obj_param1", dVar.aSm);
            if (dVar.aSm == 2) {
                x.aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aSm == 3) {
                if (dVar.aSn != 0) {
                    x.x("obj_type", dVar.aSn);
                }
                x.aA("tid", dVar.tid).aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(x);
    }

    private d uF(int i) {
        d dVar = this.gZO.get(i);
        if (dVar == null) {
            return this.gZO.get(1);
        }
        return dVar;
    }

    private void uG(int i) {
        if (i <= 8 && i > 0) {
            this.gZP = true;
            if (this.gZR != null) {
                u uVar = this.gZR.get(i);
                if (!StringUtils.isNull(uVar.GS()) && uVar.GT() != null && uVar.GT().size() > 0) {
                    l(uVar.GS(), uVar.GT());
                    return;
                }
            }
            if (this.gZQ != null) {
                String str = this.gZQ.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void af(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aRX) {
                TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aRY || dVar.aSb) {
                TiebaStatic.log(new am("c10125").aA("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSl).x("obj_param1", dVar.aSm).aA(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aRZ) {
                TiebaStatic.log(new am("c10427").aA("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aRW) {
                af(i, dVar.aSi);
            } else if (dVar.aSa) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).aA(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSc) {
                am x = new am("c10125").x("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    x.x("obj_param1", 9);
                }
                TiebaStatic.log(x);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void byM() {
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean uH(int i) {
        return (i & 1) > 0;
    }

    private boolean uI(int i) {
        return (i & 2) > 0;
    }

    private boolean uJ(int i) {
        return (i & 8) > 0;
    }

    private boolean uK(int i) {
        return (i & 16) > 0;
    }
}
