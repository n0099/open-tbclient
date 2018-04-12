package com.baidu.tieba.sharesdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog acB;
    private TextView gkS;
    private final LinearLayout gkT;
    private final LinearLayout gkU;
    private View.OnClickListener gkW;
    private SparseArray<String> gkZ;
    private SparseArray<r> gla;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gkX = new SparseArray<>(8);
    private boolean gkY = false;
    private boolean glb = true;
    private final List<View> gkV = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_dialog_content, (ViewGroup) null);
    private final TextView gkP = (TextView) this.mRootView.findViewById(d.g.share_dialog_title);
    private final View gkQ = this.mRootView.findViewById(d.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(d.g.line);
    private final View mLine2 = this.mRootView.findViewById(d.g.line_2);
    private final TextView gkR = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gkR.setOnClickListener(this);
        if (!sE(i)) {
            bD(d.k.share_weixin, d.f.icon_weixin);
        }
        if (!sF(i)) {
            bD(d.k.share_weixin_timeline, d.f.icon_weixin_q);
        }
        if (!sG(i)) {
            bD(d.k.share_qzone, d.f.icon_qq_zone);
        }
        if (!sH(i)) {
            bD(d.k.share_qq_friends, d.f.icon_qq_share);
        }
        if (!sI(i)) {
            bD(d.k.share_sina_weibo, d.f.icon_sina);
        }
        this.gkT = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_1);
        this.gkU = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_2);
        if (!e.BP()) {
            this.gkT.setVisibility(8);
            this.gkU.setVisibility(8);
        }
    }

    private void Rw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.acB != null && a.this.acB.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView bD(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bnz());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gkV.add(textView);
        return textView;
    }

    public TextView bE(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bnz());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bnz() {
        if (!this.mIsLandscape) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 17;
        return layoutParams2;
    }

    public int bnA() {
        if (this.gkV == null) {
            return 0;
        }
        return this.gkV.size();
    }

    public void b(View view2, View.OnClickListener onClickListener) {
        this.gkV.add(0, view2);
        if (onClickListener != null) {
            view2.setOnClickListener(new View$OnClickListenerC0213a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gkV.size() && i >= 0) {
            this.gkV.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0213a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0213a implements View.OnClickListener {
        private View.OnClickListener gld;

        public View$OnClickListenerC0213a(View.OnClickListener onClickListener) {
            this.gld = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            a.this.dismiss();
            if (this.gld != null) {
                this.gld.onClick(view2);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.glb = z;
    }

    public void d(SparseArray<String> sparseArray) {
        this.gkZ = sparseArray;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location ahm;
        if (z && (ahm = ahm()) != null) {
            dVar.awW = ahm;
        }
        this.gkX.put(1, dVar);
        this.gkP.setVisibility(dVar.awR ? 0 : 8);
        if (!StringUtils.isNull(dVar.awS)) {
            this.gkP.setText(dVar.awS);
        }
    }

    private Location ahm() {
        if (ab.aC(this.mContext)) {
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
            this.gkW = onClickListener;
        }
    }

    public void bnB() {
        if (this.glb) {
            this.gkS = bD(d.k.share_copy, d.f.icon_copy_link);
        }
        int size = this.gkV.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bE = bE(d.k.share_weixin_timeline, d.f.icon_weixin_q);
                bE.setVisibility(4);
                this.gkV.add(bE);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gkT.addView(this.gkV.get(i2));
                } else {
                    this.gkU.addView(this.gkV.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gkT.addView(this.gkV.get(i3));
            }
        }
    }

    public void show() {
        if (!j.gP()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
        } else if (!e.BP()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.plugin_share_install_failure);
        } else {
            bnB();
            this.acB = new AlertDialog.Builder(this.mContext).create();
            this.acB.setCanceledOnTouchOutside(true);
            this.acB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.acB, (Activity) this.mContext);
            }
            Window window = this.acB.getWindow();
            window.setWindowAnimations(d.l.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bnC();
            Rw();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.acB != null) {
            this.gkY = false;
            if (this.mContext instanceof Activity) {
                g.b(this.acB, (Activity) this.mContext);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        int i = -1;
        if (view2.getTag() != null) {
            i = ((Integer) view2.getTag()).intValue();
        }
        dismiss();
        if (this.gkX.size() != 0) {
            if (view2.getId() == d.g.btnShareCancel || !this.gkY) {
                this.gkY = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d sC = sC(1);
                if (id == d.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_weixin) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    sD(3);
                    com.baidu.tbadk.coreExtra.c.d sC2 = sC(3);
                    b(sC2, 4);
                    if (sC2 != null) {
                        eVar.b(sC2);
                    }
                } else if (i == d.f.icon_weixin_q) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    sD(2);
                    com.baidu.tbadk.coreExtra.c.d sC3 = sC(2);
                    b(sC3, 3);
                    if (sC3 != null) {
                        if (sC3.awM) {
                            sC3.content = "【" + sC3.title + "】 " + sC3.content;
                        }
                        eVar.c(sC3);
                    }
                } else if (i == d.f.icon_qq_zone) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        sD(4);
                        com.baidu.tbadk.coreExtra.c.d sC4 = sC(4);
                        b(sC4, 5);
                        if (sC4 != null) {
                            eVar.e(sC4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).tL();
                    }
                } else if (i == d.f.icon_qq_weibo) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    sD(5);
                    com.baidu.tbadk.coreExtra.c.d sC5 = sC(5);
                    b(sC5, 6);
                    if (sC5 != null) {
                        if (!sC5.awL) {
                            sC5.content = k(sC5);
                        }
                        eVar.f(sC5);
                    }
                } else if (i == d.f.icon_sina) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    sD(6);
                    com.baidu.tbadk.coreExtra.c.d sC6 = sC(6);
                    b(sC6, 7);
                    if (sC6 != null) {
                        if (!sC6.awL) {
                            sC6.content = k(sC6);
                        }
                        eVar.g(sC6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    sD(7);
                    com.baidu.tbadk.coreExtra.c.d sC7 = sC(7);
                    b(sC7, 8);
                    if (sC7 != null) {
                        if (!sC7.awL) {
                            sC7.content = k(sC7);
                        }
                        eVar.h(sC7);
                    }
                } else if (i == d.f.icon_qq_share) {
                    if (!j.gP()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        sD(8);
                        com.baidu.tbadk.coreExtra.c.d sC8 = sC(8);
                        b(sC8, 9);
                        if (sC8 != null) {
                            eVar.d(sC8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).tL();
                    }
                } else if (i == d.f.icon_copy_link) {
                    b(sC, 10);
                    if (this.gkW != null) {
                        this.gkW.onClick(view2);
                    } else {
                        com.baidu.adp.lib.util.a.aB(sC.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.k.copy_pb_url_success));
                    }
                    j(sC);
                    if (sC != null && sC.awL) {
                        al(8, sC.awX);
                    }
                }
            }
        }
    }

    private void j(com.baidu.tbadk.coreExtra.c.d dVar) {
        al r = new al("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.axb != 0) {
            r.r("obj_param1", dVar.axb);
            if (dVar.axb == 2) {
                r.ac(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.axb == 3) {
                if (dVar.axc != 0) {
                    r.r("obj_type", dVar.axc);
                }
                r.ac("tid", dVar.tid).ac(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(r);
    }

    private com.baidu.tbadk.coreExtra.c.d sC(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.gkX.get(i);
        if (dVar == null) {
            return this.gkX.get(1);
        }
        return dVar;
    }

    private void sD(int i) {
        if (i <= 8 && i > 0) {
            this.gkY = true;
            if (this.gla != null) {
                r rVar = this.gla.get(i);
                if (!StringUtils.isNull(rVar.yH()) && rVar.yI() != null && rVar.yI().size() > 0) {
                    l(rVar.yH(), rVar.yI());
                    return;
                }
            }
            if (this.gkZ != null) {
                String str = this.gkZ.get(i);
                if (!an.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void al(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void b(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.awM) {
                TiebaStatic.log(new al("c10125").ac(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.awN || dVar.awQ) {
                TiebaStatic.log(new al("c10125").ac("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.axa).r("obj_param1", dVar.axb).ac(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.awO) {
                TiebaStatic.log(new al("c10427").ac("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.awL) {
                al(i, dVar.awX);
            } else if (dVar.awP) {
                TiebaStatic.log(new al("c10125").r("obj_param1", 7).r("obj_type", i).ac(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bnC() {
        int size = this.gkV.size();
        for (int i = 0; i < size; i++) {
            View view2 = this.gkV.get(i);
            if (view2 instanceof TextView) {
                a((TextView) view2, ((Integer) view2.getTag()).intValue(), d.C0126d.cp_cont_j);
            }
        }
        ak.i(this.mRootView, d.C0126d.cp_bg_line_e);
        ak.c(this.gkP, d.C0126d.cp_cont_j, 1);
        com.baidu.tbadk.coreExtra.c.d sC = sC(1);
        if (sC != null && StringUtils.isNull(sC.awS)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gkP.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0126d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0126d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gkP.setText(spannableStringBuilder);
        }
        ak.c(this.gkR, d.C0126d.cp_cont_b, 1);
        ak.i(this.gkR, d.f.dialog_share_cancel_button_bg_selector);
        ak.i(this.mLine, d.C0126d.cp_bg_line_a);
        ak.i(this.mLine2, d.C0126d.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = ak.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        ak.c(textView, i2, 1);
    }

    private String k(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean sE(int i) {
        return (i & 1) > 0;
    }

    private boolean sF(int i) {
        return (i & 2) > 0;
    }

    private boolean sG(int i) {
        return (i & 4) > 0;
    }

    private boolean sH(int i) {
        return (i & 8) > 0;
    }

    private boolean sI(int i) {
        return (i & 16) > 0;
    }
}
