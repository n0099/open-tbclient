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
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final LinearLayout iOf;
    private View.OnClickListener iOh;
    private SparseArray<String> iOk;
    private SparseArray<v> iOl;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<e> iOi = new SparseArray<>(8);
    private boolean iOj = false;
    private final List<View> iOg = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView iOe = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.iOe.setOnClickListener(this);
        if (!zS(i)) {
            cn(R.string.share_weixin_timeline, R.drawable.icon_live_pengyouquan);
        }
        if (!zR(i)) {
            cn(R.string.share_weixin_friend, R.drawable.icon_live_weixin);
        }
        if (!zT(i)) {
            cn(R.string.share_qq, R.drawable.icon_live_qq);
        }
        if (!zU(i)) {
            cn(R.string.share_sina_weibo, R.drawable.icon_live_weibo);
        }
        this.iOf = (LinearLayout) this.mRootView.findViewById(R.id.share_content);
        if (!f.aoU()) {
            this.iOf.setVisibility(8);
        }
    }

    private void aJN() {
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

    private View cn(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_item_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.share_item_text)).setText(i);
        ((ImageView) inflate.findViewById(R.id.share_icon)).setImageResource(i2);
        inflate.setTag(Integer.valueOf(i2));
        inflate.setOnClickListener(this);
        this.iOg.add(inflate);
        return inflate;
    }

    public View co(int i, int i2) {
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_item_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.share_icon)).setImageResource(i2);
        ((TextView) inflate.findViewById(R.id.share_item_text)).setText(i);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    public int cjc() {
        if (this.iOg == null) {
            return 0;
        }
        return this.iOg.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.iOg.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0402a(onClickListener));
        }
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iOg.size() && i >= 0) {
            this.iOg.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0402a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0402a implements View.OnClickListener {
        private View.OnClickListener iOn;

        public View$OnClickListenerC0402a(View.OnClickListener onClickListener) {
            this.iOn = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.iOn != null) {
                this.iOn.onClick(view);
            }
        }
    }

    public void a(e eVar, boolean z) {
        Location aZF;
        if (z && (aZF = aZF()) != null) {
            eVar.cjA = aZF;
        }
        this.iOi.put(1, eVar);
    }

    private Location aZF() {
        if (ab.cw(this.mContext)) {
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
            this.iOh = onClickListener;
        }
    }

    public void cjd() {
        int size = this.iOg.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            this.iOf.addView(this.iOg.get(i), layoutParams);
        }
    }

    public void show() {
        if (!j.jS()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aoU()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cjd();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
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
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            cje();
            aJN();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iOj = false;
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
        if (this.iOi.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.iOj) {
                this.iOj = true;
                f fVar = new f(this.mContext, null);
                e zP = zP(1);
                if (id == R.id.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_live_weixin) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    zQ(3);
                    e zP2 = zP(3);
                    a(zP2, 4);
                    if (zP2 != null) {
                        fVar.e(zP2);
                    }
                } else if (i == R.drawable.icon_live_pengyouquan) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    zQ(2);
                    e zP3 = zP(2);
                    a(zP3, 3);
                    if (zP3 != null) {
                        if (zP3.cjl) {
                            zP3.content = "【" + zP3.title + "】 " + zP3.content;
                        }
                        fVar.f(zP3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        zQ(4);
                        e zP4 = zP(4);
                        a(zP4, 5);
                        if (zP4 != null) {
                            fVar.h(zP4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).afO();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    zQ(5);
                    e zP5 = zP(5);
                    a(zP5, 6);
                    if (zP5 != null) {
                        if (!zP5.cjk) {
                            zP5.content = p(zP5);
                        }
                        fVar.i(zP5);
                    }
                } else if (i == R.drawable.icon_live_weibo) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    zQ(6);
                    e zP6 = zP(6);
                    a(zP6, 7);
                    if (zP6 != null) {
                        if (!zP6.cjk) {
                            zP6.content = p(zP6);
                        }
                        fVar.j(zP6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    zQ(7);
                    e zP7 = zP(7);
                    a(zP7, 8);
                    if (zP7 != null) {
                        if (!zP7.cjk) {
                            zP7.content = p(zP7);
                        }
                        fVar.k(zP7);
                    }
                } else if (i == R.drawable.icon_live_qq) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        zQ(8);
                        e zP8 = zP(8);
                        a(zP8, 9);
                        if (zP8 != null) {
                            fVar.g(zP8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).afO();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(zP, 10);
                    if (this.iOh != null) {
                        this.iOh.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aR(zP.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    q(zP);
                    if (zP != null && zP.cjk) {
                        aD(8, zP.cjB);
                    }
                }
            }
        }
    }

    private void q(e eVar) {
        am P = new am("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.cjF != 0) {
            P.P("obj_param1", eVar.cjF);
            if (eVar.cjF == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.cjF == 3) {
                if (eVar.cjJ != 0) {
                    P.P("obj_type", eVar.cjJ);
                }
                P.bT("tid", eVar.tid).bT("fid", eVar.fid);
            }
        }
        TiebaStatic.log(P);
    }

    private e zP(int i) {
        e eVar = this.iOi.get(i);
        if (eVar == null) {
            return this.iOi.get(1);
        }
        return eVar;
    }

    private void zQ(int i) {
        if (i <= 8 && i > 0) {
            this.iOj = true;
            if (this.iOl != null) {
                v vVar = this.iOl.get(i);
                if (!StringUtils.isNull(vVar.alw()) && vVar.alx() != null && vVar.alx().size() > 0) {
                    k(vVar.alw(), vVar.alx());
                    return;
                }
            }
            if (this.iOk != null) {
                String str = this.iOk.get(i);
                if (!ap.isEmpty(str)) {
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
        if (eVar != null && eVar.extData != null) {
            if (eVar.cjl) {
                TiebaStatic.log(new am("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.cjm || eVar.cjp) {
                TiebaStatic.log(new am("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cjE).P("obj_param1", eVar.cjF).bT("fid", eVar.fid));
            } else if (eVar.cjn) {
                TiebaStatic.log(new am("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.cjk) {
                aD(i, eVar.cjB);
            } else if (eVar.cjo) {
                TiebaStatic.log(new am("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            } else if (eVar.cjq) {
                am P = new am("c10125").P("obj_type", i);
                if (!ap.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    P.P("obj_param1", 9);
                }
                TiebaStatic.log(P);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cje() {
    }

    private String p(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private boolean zR(int i) {
        return (i & 1) > 0;
    }

    private boolean zS(int i) {
        return (i & 2) > 0;
    }

    private boolean zT(int i) {
        return (i & 8) > 0;
    }

    private boolean zU(int i) {
        return (i & 16) > 0;
    }
}
