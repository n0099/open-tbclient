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
    private AlertDialog bED;
    private int hideMode;
    private final LinearLayout ivG;
    private View.OnClickListener ivI;
    private SparseArray<String> ivL;
    private SparseArray<v> ivM;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> ivJ = new SparseArray<>(8);
    private boolean ivK = false;
    private final List<View> ivH = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.ala_share_dialog_content, (ViewGroup) null);
    private final TextView ivF = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.ivF.setOnClickListener(this);
        if (!yO(i)) {
            cg(d.j.share_weixin_timeline, d.f.icon_live_pengyouquan);
        }
        if (!yN(i)) {
            cg(d.j.share_weixin_friend, d.f.icon_live_weixin);
        }
        if (!yP(i)) {
            cg(d.j.share_qq, d.f.icon_live_qq);
        }
        if (!yQ(i)) {
            cg(d.j.share_sina_weibo, d.f.icon_live_weibo);
        }
        this.ivG = (LinearLayout) this.mRootView.findViewById(d.g.share_content);
        if (!e.ajW()) {
            this.ivG.setVisibility(8);
        }
    }

    private void aDD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.bED != null && a.this.bED.isShowing()) {
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
        this.ivH.add(inflate);
        return inflate;
    }

    public View ch(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.ala_share_item_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(d.g.share_icon)).setImageResource(i2);
        ((TextView) inflate.findViewById(d.g.share_item_text)).setText(i);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    public int cbb() {
        if (this.ivH == null) {
            return 0;
        }
        return this.ivH.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.ivH.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0383a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.ivH.size() && i >= 0) {
            this.ivH.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0383a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0383a implements View.OnClickListener {
        private View.OnClickListener ivO;

        public View$OnClickListenerC0383a(View.OnClickListener onClickListener) {
            this.ivO = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.ivO != null) {
                this.ivO.onClick(view);
            }
        }
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location aSz;
        if (z && (aSz = aSz()) != null) {
            dVar.cbw = aSz;
        }
        this.ivJ.put(1, dVar);
    }

    private Location aSz() {
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
            this.ivI = onClickListener;
        }
    }

    public void cbc() {
        int size = this.ivH.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.ivG.addView(this.ivH.get(i), layoutParams);
        }
    }

    public void show() {
        if (!j.kY()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
        } else if (!e.ajW()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_share_install_failure);
        } else {
            cbc();
            this.bED = new AlertDialog.Builder(this.mContext, d.k.DialogTheme).create();
            this.bED.setCanceledOnTouchOutside(true);
            this.bED.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.bED, (Activity) this.mContext);
            }
            Window window = this.bED.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            cbd();
            aDD();
        }
    }

    public void c(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.bED != null) {
            this.ivK = false;
            if (this.mContext instanceof Activity) {
                g.b(this.bED, (Activity) this.mContext);
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
        if (this.ivJ.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.ivK) {
                this.ivK = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d yL = yL(1);
                if (id == d.g.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_live_weixin) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    yM(3);
                    com.baidu.tbadk.coreExtra.c.d yL2 = yL(3);
                    a(yL2, 4);
                    if (yL2 != null) {
                        eVar.b(yL2);
                    }
                } else if (i == d.f.icon_live_pengyouquan) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    yM(2);
                    com.baidu.tbadk.coreExtra.c.d yL3 = yL(2);
                    a(yL3, 3);
                    if (yL3 != null) {
                        if (yL3.cbi) {
                            yL3.content = "【" + yL3.title + "】 " + yL3.content;
                        }
                        eVar.c(yL3);
                    }
                } else if (i == d.f.icon_qq_zone) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        yM(4);
                        com.baidu.tbadk.coreExtra.c.d yL4 = yL(4);
                        a(yL4, 5);
                        if (yL4 != null) {
                            eVar.e(yL4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abh();
                    }
                } else if (i == d.f.icon_qq_weibo) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    yM(5);
                    com.baidu.tbadk.coreExtra.c.d yL5 = yL(5);
                    a(yL5, 6);
                    if (yL5 != null) {
                        if (!yL5.cbh) {
                            yL5.content = m(yL5);
                        }
                        eVar.f(yL5);
                    }
                } else if (i == d.f.icon_live_weibo) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    yM(6);
                    com.baidu.tbadk.coreExtra.c.d yL6 = yL(6);
                    a(yL6, 7);
                    if (yL6 != null) {
                        if (!yL6.cbh) {
                            yL6.content = m(yL6);
                        }
                        eVar.g(yL6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    yM(7);
                    com.baidu.tbadk.coreExtra.c.d yL7 = yL(7);
                    a(yL7, 8);
                    if (yL7 != null) {
                        if (!yL7.cbh) {
                            yL7.content = m(yL7);
                        }
                        eVar.h(yL7);
                    }
                } else if (i == d.f.icon_live_qq) {
                    if (!j.kY()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        yM(8);
                        com.baidu.tbadk.coreExtra.c.d yL8 = yL(8);
                        a(yL8, 9);
                        if (yL8 != null) {
                            eVar.d(yL8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abh();
                    }
                } else if (i == d.f.icon_copy_link) {
                    a(yL, 10);
                    if (this.ivI != null) {
                        this.ivI.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bh(yL.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
                    }
                    n(yL);
                    if (yL != null && yL.cbh) {
                        ay(8, yL.cbx);
                    }
                }
            }
        }
    }

    private void n(com.baidu.tbadk.coreExtra.c.d dVar) {
        am T = new am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.cbB != 0) {
            T.T("obj_param1", dVar.cbB);
            if (dVar.cbB == 2) {
                T.bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.cbB == 3) {
                if (dVar.cbF != 0) {
                    T.T("obj_type", dVar.cbF);
                }
                T.bJ("tid", dVar.tid).bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(T);
    }

    private com.baidu.tbadk.coreExtra.c.d yL(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.ivJ.get(i);
        if (dVar == null) {
            return this.ivJ.get(1);
        }
        return dVar;
    }

    private void yM(int i) {
        if (i <= 8 && i > 0) {
            this.ivK = true;
            if (this.ivM != null) {
                v vVar = this.ivM.get(i);
                if (!StringUtils.isNull(vVar.agA()) && vVar.agB() != null && vVar.agB().size() > 0) {
                    k(vVar.agA(), vVar.agB());
                    return;
                }
            }
            if (this.ivL != null) {
                String str = this.ivL.get(i);
                if (!ap.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void ay(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.cbi) {
                TiebaStatic.log(new am("c10125").bJ(ImageViewerConfig.FORUM_ID, dVar.extData).T("obj_type", i));
            } else if (dVar.cbj || dVar.cbm) {
                TiebaStatic.log(new am("c10125").bJ("tid", dVar.extData).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.cbA).T("obj_param1", dVar.cbB).bJ(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.cbk) {
                TiebaStatic.log(new am("c10427").bJ("tid", dVar.extData).T("obj_type", i));
            } else if (dVar.cbh) {
                ay(i, dVar.cbx);
            } else if (dVar.cbl) {
                TiebaStatic.log(new am("c10125").T("obj_param1", 7).T("obj_type", i).bJ(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.cbn) {
                am T = new am("c10125").T("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    T.T("obj_param1", 9);
                }
                TiebaStatic.log(T);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cbd() {
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean yN(int i) {
        return (i & 1) > 0;
    }

    private boolean yO(int i) {
        return (i & 2) > 0;
    }

    private boolean yP(int i) {
        return (i & 8) > 0;
    }

    private boolean yQ(int i) {
        return (i & 16) > 0;
    }
}
