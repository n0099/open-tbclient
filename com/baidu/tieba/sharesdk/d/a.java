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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final LinearLayout ivr;
    private View.OnClickListener ivt;
    private SparseArray<String> ivw;
    private SparseArray<v> ivx;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> ivu = new SparseArray<>(8);
    private boolean ivv = false;
    private final List<View> ivs = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.ala_share_dialog_content, (ViewGroup) null);
    private final TextView ivq = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.ivq.setOnClickListener(this);
        if (!yK(i)) {
            cg(d.j.share_weixin_timeline, d.f.icon_live_pengyouquan);
        }
        if (!yJ(i)) {
            cg(d.j.share_weixin_friend, d.f.icon_live_weixin);
        }
        if (!yL(i)) {
            cg(d.j.share_qq, d.f.icon_live_qq);
        }
        if (!yM(i)) {
            cg(d.j.share_sina_weibo, d.f.icon_live_weibo);
        }
        this.ivr = (LinearLayout) this.mRootView.findViewById(d.g.share_content);
        if (!e.ajT()) {
            this.ivr.setVisibility(8);
        }
    }

    private void aDA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
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

    private View cg(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.ala_share_item_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(d.g.share_item_text)).setText(i);
        ((ImageView) inflate.findViewById(d.g.share_icon)).setImageResource(i2);
        inflate.setTag(Integer.valueOf(i2));
        inflate.setOnClickListener(this);
        this.ivs.add(inflate);
        return inflate;
    }

    public View ch(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.ala_share_item_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(d.g.share_icon)).setImageResource(i2);
        ((TextView) inflate.findViewById(d.g.share_item_text)).setText(i);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    public int caX() {
        if (this.ivs == null) {
            return 0;
        }
        return this.ivs.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.ivs.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0383a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.ivs.size() && i >= 0) {
            this.ivs.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0383a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0383a implements View.OnClickListener {
        private View.OnClickListener ivz;

        public View$OnClickListenerC0383a(View.OnClickListener onClickListener) {
            this.ivz = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.ivz != null) {
                this.ivz.onClick(view);
            }
        }
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location aSx;
        if (z && (aSx = aSx()) != null) {
            dVar.cbz = aSx;
        }
        this.ivu.put(1, dVar);
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
            this.ivt = onClickListener;
        }
    }

    public void caY() {
        int size = this.ivs.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.ivr.addView(this.ivs.get(i), layoutParams);
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
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.mDialog, (Activity) this.mContext);
            }
            Window window = this.mDialog.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            caZ();
            aDA();
        }
    }

    public void c(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.ivv = false;
            if (this.mContext instanceof Activity) {
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
        if (this.ivu.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.ivv) {
                this.ivv = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d yH = yH(1);
                if (id == d.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_live_weixin) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    yI(3);
                    com.baidu.tbadk.coreExtra.c.d yH2 = yH(3);
                    a(yH2, 4);
                    if (yH2 != null) {
                        eVar.b(yH2);
                    }
                } else if (i == d.f.icon_live_pengyouquan) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    yI(2);
                    com.baidu.tbadk.coreExtra.c.d yH3 = yH(2);
                    a(yH3, 3);
                    if (yH3 != null) {
                        if (yH3.cbl) {
                            yH3.content = "【" + yH3.title + "】 " + yH3.content;
                        }
                        eVar.c(yH3);
                    }
                } else if (i == d.f.icon_qq_zone) {
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
                        if (!yH5.cbk) {
                            yH5.content = m(yH5);
                        }
                        eVar.f(yH5);
                    }
                } else if (i == d.f.icon_live_weibo) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    yI(6);
                    com.baidu.tbadk.coreExtra.c.d yH6 = yH(6);
                    a(yH6, 7);
                    if (yH6 != null) {
                        if (!yH6.cbk) {
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
                        if (!yH7.cbk) {
                            yH7.content = m(yH7);
                        }
                        eVar.h(yH7);
                    }
                } else if (i == d.f.icon_live_qq) {
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
                } else if (i == d.f.icon_copy_link) {
                    a(yH, 10);
                    if (this.ivt != null) {
                        this.ivt.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bh(yH.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
                    }
                    n(yH);
                    if (yH != null && yH.cbk) {
                        aA(8, yH.cbA);
                    }
                }
            }
        }
    }

    private void n(com.baidu.tbadk.coreExtra.c.d dVar) {
        am T = new am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.cbE != 0) {
            T.T("obj_param1", dVar.cbE);
            if (dVar.cbE == 2) {
                T.bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.cbE == 3) {
                if (dVar.cbI != 0) {
                    T.T("obj_type", dVar.cbI);
                }
                T.bJ("tid", dVar.tid).bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(T);
    }

    private com.baidu.tbadk.coreExtra.c.d yH(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.ivu.get(i);
        if (dVar == null) {
            return this.ivu.get(1);
        }
        return dVar;
    }

    private void yI(int i) {
        if (i <= 8 && i > 0) {
            this.ivv = true;
            if (this.ivx != null) {
                v vVar = this.ivx.get(i);
                if (!StringUtils.isNull(vVar.agx()) && vVar.agy() != null && vVar.agy().size() > 0) {
                    k(vVar.agx(), vVar.agy());
                    return;
                }
            }
            if (this.ivw != null) {
                String str = this.ivw.get(i);
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
        if (dVar != null && dVar.extData != null) {
            if (dVar.cbl) {
                TiebaStatic.log(new am("c10125").bJ(ImageViewerConfig.FORUM_ID, dVar.extData).T("obj_type", i));
            } else if (dVar.cbm || dVar.cbp) {
                TiebaStatic.log(new am("c10125").bJ("tid", dVar.extData).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.cbD).T("obj_param1", dVar.cbE).bJ(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.cbn) {
                TiebaStatic.log(new am("c10427").bJ("tid", dVar.extData).T("obj_type", i));
            } else if (dVar.cbk) {
                aA(i, dVar.cbA);
            } else if (dVar.cbo) {
                TiebaStatic.log(new am("c10125").T("obj_param1", 7).T("obj_type", i).bJ(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.cbq) {
                am T = new am("c10125").T("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    T.T("obj_param1", 9);
                }
                TiebaStatic.log(T);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void caZ() {
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean yJ(int i) {
        return (i & 1) > 0;
    }

    private boolean yK(int i) {
        return (i & 2) > 0;
    }

    private boolean yL(int i) {
        return (i & 8) > 0;
    }

    private boolean yM(int i) {
        return (i & 16) > 0;
    }
}
