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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog akE;
    private View.OnClickListener gCB;
    private SparseArray<String> gCE;
    private SparseArray<s> gCF;
    private TextView gCx;
    private final LinearLayout gCy;
    private final LinearLayout gCz;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gCC = new SparseArray<>(8);
    private boolean gCD = false;
    private boolean gCG = true;
    private final List<View> gCA = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(f.h.share_dialog_content, (ViewGroup) null);
    private final TextView gCu = (TextView) this.mRootView.findViewById(f.g.share_dialog_title);
    private final View gCv = this.mRootView.findViewById(f.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(f.g.line);
    private final View dbD = this.mRootView.findViewById(f.g.line_2);
    private final TextView gCw = (TextView) this.mRootView.findViewById(f.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gCw.setOnClickListener(this);
        if (!sW(i)) {
            bE(f.j.share_weixin, f.C0146f.icon_weixin);
        }
        if (!sX(i)) {
            bE(f.j.share_weixin_timeline, f.C0146f.icon_weixin_q);
        }
        if (!sY(i)) {
            bE(f.j.share_qzone, f.C0146f.icon_qq_zone);
        }
        if (!sZ(i)) {
            bE(f.j.share_qq_friends, f.C0146f.icon_qq_share);
        }
        if (!ta(i)) {
            bE(f.j.share_sina_weibo, f.C0146f.icon_sina);
        }
        this.gCy = (LinearLayout) this.mRootView.findViewById(f.g.share_dialog_line_1);
        this.gCz = (LinearLayout) this.mRootView.findViewById(f.g.share_dialog_line_2);
        if (!e.FD()) {
            this.gCy.setVisibility(8);
            this.gCz.setVisibility(8);
        }
    }

    private void Vy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.akE != null && a.this.akE.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView bE(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(f.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(brB());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gCA.add(textView);
        return textView;
    }

    public TextView bF(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(f.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(brB());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams brB() {
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

    public int brC() {
        if (this.gCA == null) {
            return 0;
        }
        return this.gCA.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gCA.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0232a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gCA.size() && i >= 0) {
            this.gCA.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0232a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0232a implements View.OnClickListener {
        private View.OnClickListener gCI;

        public View$OnClickListenerC0232a(View.OnClickListener onClickListener) {
            this.gCI = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gCI != null) {
                this.gCI.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gCG = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gCE = sparseArray;
    }

    public void a(d dVar, boolean z) {
        Location akV;
        if (z && (akV = akV()) != null) {
            dVar.aGc = akV;
        }
        this.gCC.put(1, dVar);
        this.gCu.setVisibility(dVar.aFY ? 0 : 8);
        if (!StringUtils.isNull(dVar.aFZ)) {
            this.gCu.setText(dVar.aFZ);
        }
    }

    private Location akV() {
        if (ac.aM(this.mContext)) {
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
            this.gCB = onClickListener;
        }
    }

    public void brD() {
        if (this.gCG) {
            this.gCx = bE(f.j.share_copy, f.C0146f.icon_copy_link);
        }
        int size = this.gCA.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bF = bF(f.j.share_weixin_timeline, f.C0146f.icon_weixin_q);
                bF.setVisibility(4);
                this.gCA.add(bF);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gCy.addView(this.gCA.get(i2));
                } else {
                    this.gCz.addView(this.gCA.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gCy.addView(this.gCA.get(i3));
            }
        }
    }

    public void show() {
        if (!j.jE()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
        } else if (!e.FD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.plugin_share_install_failure);
        } else {
            brD();
            this.akE = new AlertDialog.Builder(this.mContext, f.k.DialogTheme).create();
            this.akE.setCanceledOnTouchOutside(true);
            this.akE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.akE, (Activity) this.mContext);
            }
            Window window = this.akE.getWindow();
            window.setWindowAnimations(f.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            brE();
            Vy();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.akE != null) {
            this.gCD = false;
            if (this.mContext instanceof Activity) {
                g.b(this.akE, (Activity) this.mContext);
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
        if (this.gCC.size() != 0) {
            if (view.getId() == f.g.btnShareCancel || !this.gCD) {
                this.gCD = true;
                e eVar = new e(this.mContext, null);
                d sU = sU(1);
                if (id == f.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == f.C0146f.icon_weixin) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    sV(3);
                    d sU2 = sU(3);
                    a(sU2, 4);
                    if (sU2 != null) {
                        eVar.b(sU2);
                    }
                } else if (i == f.C0146f.icon_weixin_q) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    sV(2);
                    d sU3 = sU(2);
                    a(sU3, 3);
                    if (sU3 != null) {
                        if (sU3.aFS) {
                            sU3.content = "【" + sU3.title + "】 " + sU3.content;
                        }
                        eVar.c(sU3);
                    }
                } else if (i == f.C0146f.icon_qq_zone) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        sV(4);
                        d sU4 = sU(4);
                        a(sU4, 5);
                        if (sU4 != null) {
                            eVar.e(sU4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(f.j.share_qq_not_install)).xm();
                    }
                } else if (i == f.C0146f.icon_qq_weibo) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    sV(5);
                    d sU5 = sU(5);
                    a(sU5, 6);
                    if (sU5 != null) {
                        if (!sU5.aFR) {
                            sU5.content = m(sU5);
                        }
                        eVar.f(sU5);
                    }
                } else if (i == f.C0146f.icon_sina) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    sV(6);
                    d sU6 = sU(6);
                    a(sU6, 7);
                    if (sU6 != null) {
                        if (!sU6.aFR) {
                            sU6.content = m(sU6);
                        }
                        eVar.g(sU6);
                    }
                } else if (i == f.C0146f.icon_renren) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    sV(7);
                    d sU7 = sU(7);
                    a(sU7, 8);
                    if (sU7 != null) {
                        if (!sU7.aFR) {
                            sU7.content = m(sU7);
                        }
                        eVar.h(sU7);
                    }
                } else if (i == f.C0146f.icon_qq_share) {
                    if (!j.jE()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), f.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        sV(8);
                        d sU8 = sU(8);
                        a(sU8, 9);
                        if (sU8 != null) {
                            eVar.d(sU8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(f.j.share_qq_not_install)).xm();
                    }
                } else if (i == f.C0146f.icon_copy_link) {
                    a(sU, 10);
                    if (this.gCB != null) {
                        this.gCB.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aQ(sU.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(f.j.copy_pb_url_success));
                    }
                    n(sU);
                    if (sU != null && sU.aFR) {
                        ai(8, sU.aGd);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        an r = new an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aGh != 0) {
            r.r("obj_param1", dVar.aGh);
            if (dVar.aGh == 2) {
                r.ae(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aGh == 3) {
                if (dVar.aGi != 0) {
                    r.r("obj_type", dVar.aGi);
                }
                r.ae("tid", dVar.tid).ae(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(r);
    }

    private d sU(int i) {
        d dVar = this.gCC.get(i);
        if (dVar == null) {
            return this.gCC.get(1);
        }
        return dVar;
    }

    private void sV(int i) {
        if (i <= 8 && i > 0) {
            this.gCD = true;
            if (this.gCF != null) {
                s sVar = this.gCF.get(i);
                if (!StringUtils.isNull(sVar.Co()) && sVar.Cp() != null && sVar.Cp().size() > 0) {
                    l(sVar.Co(), sVar.Cp());
                    return;
                }
            }
            if (this.gCE != null) {
                String str = this.gCE.get(i);
                if (!ap.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void ai(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aFS) {
                TiebaStatic.log(new an("c10125").ae(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.aFT || dVar.aFW) {
                TiebaStatic.log(new an("c10125").ae("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aGg).r("obj_param1", dVar.aGh).ae(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aFU) {
                TiebaStatic.log(new an("c10427").ae("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.aFR) {
                ai(i, dVar.aGd);
            } else if (dVar.aFV) {
                TiebaStatic.log(new an("c10125").r("obj_param1", 7).r("obj_type", i).ae(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aFX) {
                an r = new an("c10125").r("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    r.r("obj_param1", 9);
                }
                TiebaStatic.log(r);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void brE() {
        int size = this.gCA.size();
        for (int i = 0; i < size; i++) {
            View view = this.gCA.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), f.d.cp_cont_j);
            }
        }
        am.i(this.mRootView, f.d.cp_bg_line_e);
        am.c(this.gCu, f.d.cp_cont_j, 1);
        d sU = sU(1);
        if (sU != null && StringUtils.isNull(sU.aFZ)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gCu.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(f.d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(f.d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gCu.setText(spannableStringBuilder);
        }
        am.c(this.gCw, f.d.cp_cont_b, 1);
        am.i(this.gCw, f.C0146f.dialog_share_cancel_button_bg_selector);
        am.i(this.mLine, f.d.cp_bg_line_a);
        am.i(this.dbD, f.d.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = am.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        am.c(textView, i2, 1);
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean sW(int i) {
        return (i & 1) > 0;
    }

    private boolean sX(int i) {
        return (i & 2) > 0;
    }

    private boolean sY(int i) {
        return (i & 4) > 0;
    }

    private boolean sZ(int i) {
        return (i & 8) > 0;
    }

    private boolean ta(int i) {
        return (i & 16) > 0;
    }
}
