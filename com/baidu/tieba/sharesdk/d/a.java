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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog asf;
    private final LinearLayout gRA;
    private final LinearLayout gRB;
    private View.OnClickListener gRD;
    private SparseArray<String> gRG;
    private SparseArray<t> gRH;
    private TextView gRz;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnCancelListener onCancelListener;
    private final SparseArray<d> gRE = new SparseArray<>(8);
    private boolean gRF = false;
    private boolean gRI = true;
    private final List<View> gRC = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_dialog_content, (ViewGroup) null);
    private final TextView gRw = (TextView) this.mRootView.findViewById(e.g.share_dialog_title);
    private final View gRx = this.mRootView.findViewById(e.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(e.g.line);
    private final View dpC = this.mRootView.findViewById(e.g.line_2);
    private final TextView gRy = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gRy.setOnClickListener(this);
        if (!tT(i)) {
            bJ(e.j.share_weixin, e.f.icon_weixin);
        }
        if (!tU(i)) {
            bJ(e.j.share_weixin_timeline, e.f.icon_weixin_q);
        }
        if (!tV(i)) {
            bJ(e.j.share_qzone, e.f.icon_qq_zone);
        }
        if (!tW(i)) {
            bJ(e.j.share_qq_friends, e.f.icon_qq_share);
        }
        if (!tX(i)) {
            bJ(e.j.share_sina_weibo, e.f.icon_sina);
        }
        this.gRA = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_1);
        this.gRB = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_2);
        if (!com.baidu.tbadk.coreExtra.c.e.IU()) {
            this.gRA.setVisibility(8);
            this.gRB.setVisibility(8);
        }
    }

    private void aaT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.asf != null && a.this.asf.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView bJ(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bxv());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gRC.add(textView);
        return textView;
    }

    public TextView bK(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bxv());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bxv() {
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

    public int bxw() {
        if (this.gRC == null) {
            return 0;
        }
        return this.gRC.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gRC.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0273a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gRC.size() && i >= 0) {
            this.gRC.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0273a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0273a implements View.OnClickListener {
        private View.OnClickListener gRK;

        public View$OnClickListenerC0273a(View.OnClickListener onClickListener) {
            this.gRK = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gRK != null) {
                this.gRK.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gRI = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gRG = sparseArray;
    }

    public void a(d dVar, boolean z) {
        Location aqh;
        if (z && (aqh = aqh()) != null) {
            dVar.aNS = aqh;
        }
        this.gRE.put(1, dVar);
        this.gRw.setVisibility(dVar.aNO ? 0 : 8);
        if (!StringUtils.isNull(dVar.aNP)) {
            this.gRw.setText(dVar.aNP);
        }
    }

    private Location aqh() {
        if (ab.bB(this.mContext)) {
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
            this.gRD = onClickListener;
        }
    }

    public void bxx() {
        if (this.gRI) {
            this.gRz = bJ(e.j.share_copy, e.f.icon_copy_link);
        }
        int size = this.gRC.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bK = bK(e.j.share_weixin_timeline, e.f.icon_weixin_q);
                bK.setVisibility(4);
                this.gRC.add(bK);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gRA.addView(this.gRC.get(i2));
                } else {
                    this.gRB.addView(this.gRC.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gRA.addView(this.gRC.get(i3));
            }
        }
    }

    public void show() {
        if (!j.kX()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.IU()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bxx();
            this.asf = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.asf.setCanceledOnTouchOutside(true);
            this.asf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            this.asf.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.a.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (a.this.onCancelListener != null) {
                        a.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.asf, (Activity) this.mContext);
            }
            Window window = this.asf.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bxy();
            aaT();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.asf != null) {
            this.gRF = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.asf);
                }
                g.b(this.asf, (Activity) this.mContext);
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
        if (this.gRE.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.gRF) {
                this.gRF = true;
                d tR = tR(1);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == e.f.icon_weixin) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    tS(3);
                    d tR2 = tR(3);
                    a(tR2, 4);
                    if (tR2 != null) {
                        eVar.b(tR2);
                    }
                } else if (i == e.f.icon_weixin_q) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    tS(2);
                    d tR3 = tR(2);
                    a(tR3, 3);
                    if (tR3 != null) {
                        if (tR3.aNI) {
                            tR3.content = "【" + tR3.title + "】 " + tR3.content;
                        }
                        eVar.c(tR3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        tS(4);
                        d tR4 = tR(4);
                        a(tR4, 5);
                        if (tR4 != null) {
                            eVar.e(tR4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).AC();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    tS(5);
                    d tR5 = tR(5);
                    a(tR5, 6);
                    if (tR5 != null) {
                        if (!tR5.aNH) {
                            tR5.content = m(tR5);
                        }
                        eVar.f(tR5);
                    }
                } else if (i == e.f.icon_sina) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    tS(6);
                    d tR6 = tR(6);
                    a(tR6, 7);
                    if (tR6 != null) {
                        if (!tR6.aNH) {
                            tR6.content = m(tR6);
                        }
                        eVar.g(tR6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    tS(7);
                    d tR7 = tR(7);
                    a(tR7, 8);
                    if (tR7 != null) {
                        if (!tR7.aNH) {
                            tR7.content = m(tR7);
                        }
                        eVar.h(tR7);
                    }
                } else if (i == e.f.icon_qq_share) {
                    if (!j.kX()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        tS(8);
                        d tR8 = tR(8);
                        a(tR8, 9);
                        if (tR8 != null) {
                            eVar.d(tR8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).AC();
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(tR, 10);
                    if (this.gRD != null) {
                        this.gRD.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(tR.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(tR);
                    if (tR != null && tR.aNH) {
                        aj(8, tR.aNT);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am x = new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aNX != 0) {
            x.x("obj_param1", dVar.aNX);
            if (dVar.aNX == 2) {
                x.ax(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aNX == 3) {
                if (dVar.aNY != 0) {
                    x.x("obj_type", dVar.aNY);
                }
                x.ax("tid", dVar.tid).ax(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(x);
    }

    private d tR(int i) {
        d dVar = this.gRE.get(i);
        if (dVar == null) {
            return this.gRE.get(1);
        }
        return dVar;
    }

    private void tS(int i) {
        if (i <= 8 && i > 0) {
            this.gRF = true;
            if (this.gRH != null) {
                t tVar = this.gRH.get(i);
                if (!StringUtils.isNull(tVar.FC()) && tVar.FD() != null && tVar.FD().size() > 0) {
                    l(tVar.FC(), tVar.FD());
                    return;
                }
            }
            if (this.gRG != null) {
                String str = this.gRG.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void aj(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aNI) {
                TiebaStatic.log(new am("c10125").ax(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aNJ || dVar.aNM) {
                TiebaStatic.log(new am("c10125").ax("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aNW).x("obj_param1", dVar.aNX).ax(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aNK) {
                TiebaStatic.log(new am("c10427").ax("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aNH) {
                aj(i, dVar.aNT);
            } else if (dVar.aNL) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).ax(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aNN) {
                am x = new am("c10125").x("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    x.x("obj_param1", 9);
                }
                TiebaStatic.log(x);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bxy() {
        int size = this.gRC.size();
        for (int i = 0; i < size; i++) {
            View view = this.gRC.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), e.d.cp_cont_j);
            }
        }
        al.i(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.gRw, e.d.cp_cont_j, 1);
        d tR = tR(1);
        if (tR != null && StringUtils.isNull(tR.aNP)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gRw.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gRw.setText(spannableStringBuilder);
        }
        al.c(this.gRy, e.d.cp_cont_b, 1);
        al.i(this.gRy, e.f.dialog_share_cancel_button_bg_selector);
        al.i(this.mLine, e.d.cp_bg_line_a);
        al.i(this.dpC, e.d.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = al.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        al.c(textView, i2, 1);
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean tT(int i) {
        return (i & 1) > 0;
    }

    private boolean tU(int i) {
        return (i & 2) > 0;
    }

    private boolean tV(int i) {
        return (i & 4) > 0;
    }

    private boolean tW(int i) {
        return (i & 8) > 0;
    }

    private boolean tX(int i) {
        return (i & 16) > 0;
    }
}
