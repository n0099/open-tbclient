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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private AlertDialog asS;
    private View.OnClickListener gSX;
    private SparseArray<String> gTa;
    private SparseArray<u> gTb;
    private TextView gTg;
    private final LinearLayout gTh;
    private final LinearLayout gTi;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnCancelListener onCancelListener;
    private final SparseArray<d> gSY = new SparseArray<>(8);
    private boolean gSZ = false;
    private boolean gTj = true;
    private final List<View> gSW = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_dialog_content, (ViewGroup) null);
    private final TextView gTe = (TextView) this.mRootView.findViewById(e.g.share_dialog_title);
    private final View gTf = this.mRootView.findViewById(e.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(e.g.line);
    private final View dqG = this.mRootView.findViewById(e.g.line_2);
    private final TextView gSU = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gSU.setOnClickListener(this);
        if (!um(i)) {
            bN(e.j.share_weixin, e.f.icon_weixin);
        }
        if (!un(i)) {
            bN(e.j.share_weixin_timeline, e.f.icon_weixin_q);
        }
        if (!uq(i)) {
            bN(e.j.share_qzone, e.f.icon_qq_zone);
        }
        if (!uo(i)) {
            bN(e.j.share_qq_friends, e.f.icon_qq_share);
        }
        if (!up(i)) {
            bN(e.j.share_sina_weibo, e.f.icon_sina);
        }
        this.gTh = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_1);
        this.gTi = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_2);
        if (!com.baidu.tbadk.coreExtra.c.e.Jg()) {
            this.gTh.setVisibility(8);
            this.gTi.setVisibility(8);
        }
    }

    private void abd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (b.this.asS != null && b.this.asS.isShowing()) {
                    b.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView bN(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bwU());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gSW.add(textView);
        return textView;
    }

    public TextView bO(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bwU());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bwU() {
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

    public int bwR() {
        if (this.gSW == null) {
            return 0;
        }
        return this.gSW.size();
    }

    public void c(View view, View.OnClickListener onClickListener) {
        this.gSW.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gSW.size() && i >= 0) {
            this.gSW.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener gTd;

        public a(View.OnClickListener onClickListener) {
            this.gTd = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.gTd != null) {
                this.gTd.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gTj = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gTa = sparseArray;
    }

    public void a(d dVar, boolean z) {
        Location apI;
        if (z && (apI = apI()) != null) {
            dVar.aOI = apI;
        }
        this.gSY.put(1, dVar);
        this.gTe.setVisibility(dVar.aOE ? 0 : 8);
        if (!StringUtils.isNull(dVar.aOF)) {
            this.gTe.setText(dVar.aOF);
        }
    }

    private Location apI() {
        if (ab.bz(this.mContext)) {
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
            this.gSX = onClickListener;
        }
    }

    public void bwS() {
        if (this.gTj) {
            this.gTg = bN(e.j.share_copy, e.f.icon_copy_link);
        }
        int size = this.gSW.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bO = bO(e.j.share_weixin_timeline, e.f.icon_weixin_q);
                bO.setVisibility(4);
                this.gSW.add(bO);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gTh.addView(this.gSW.get(i2));
                } else {
                    this.gTi.addView(this.gSW.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gTh.addView(this.gSW.get(i3));
            }
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.Jg()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bwS();
            this.asS = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.asS.setCanceledOnTouchOutside(true);
            this.asS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            this.asS.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (b.this.onCancelListener != null) {
                        b.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.asS, (Activity) this.mContext);
            }
            Window window = this.asS.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bwT();
            abd();
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
        if (this.asS != null) {
            this.gSZ = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.asS);
                }
                g.b(this.asS, (Activity) this.mContext);
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
        if (this.gSY.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.gSZ) {
                this.gSZ = true;
                d uk = uk(1);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == e.f.icon_weixin) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    ul(3);
                    d uk2 = uk(3);
                    a(uk2, 4);
                    if (uk2 != null) {
                        eVar.b(uk2);
                    }
                } else if (i == e.f.icon_weixin_q) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    ul(2);
                    d uk3 = uk(2);
                    a(uk3, 3);
                    if (uk3 != null) {
                        if (uk3.aOy) {
                            uk3.content = "【" + uk3.title + "】 " + uk3.content;
                        }
                        eVar.c(uk3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        ul(4);
                        d uk4 = uk(4);
                        a(uk4, 5);
                        if (uk4 != null) {
                            eVar.e(uk4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).AJ();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    ul(5);
                    d uk5 = uk(5);
                    a(uk5, 6);
                    if (uk5 != null) {
                        if (!uk5.aOx) {
                            uk5.content = m(uk5);
                        }
                        eVar.f(uk5);
                    }
                } else if (i == e.f.icon_sina) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    ul(6);
                    d uk6 = uk(6);
                    a(uk6, 7);
                    if (uk6 != null) {
                        if (!uk6.aOx) {
                            uk6.content = m(uk6);
                        }
                        eVar.g(uk6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    ul(7);
                    d uk7 = uk(7);
                    a(uk7, 8);
                    if (uk7 != null) {
                        if (!uk7.aOx) {
                            uk7.content = m(uk7);
                        }
                        eVar.h(uk7);
                    }
                } else if (i == e.f.icon_qq_share) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        ul(8);
                        d uk8 = uk(8);
                        a(uk8, 9);
                        if (uk8 != null) {
                            eVar.d(uk8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).AJ();
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(uk, 10);
                    if (this.gSX != null) {
                        this.gSX.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uk.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uk);
                    if (uk != null && uk.aOx) {
                        af(8, uk.aOJ);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am x = new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aON != 0) {
            x.x("obj_param1", dVar.aON);
            if (dVar.aON == 2) {
                x.ax(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aON == 3) {
                if (dVar.aOO != 0) {
                    x.x("obj_type", dVar.aOO);
                }
                x.ax("tid", dVar.tid).ax(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(x);
    }

    private d uk(int i) {
        d dVar = this.gSY.get(i);
        if (dVar == null) {
            return this.gSY.get(1);
        }
        return dVar;
    }

    private void ul(int i) {
        if (i <= 8 && i > 0) {
            this.gSZ = true;
            if (this.gTb != null) {
                u uVar = this.gTb.get(i);
                if (!StringUtils.isNull(uVar.FO()) && uVar.FP() != null && uVar.FP().size() > 0) {
                    l(uVar.FO(), uVar.FP());
                    return;
                }
            }
            if (this.gTa != null) {
                String str = this.gTa.get(i);
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
            if (dVar.aOy) {
                TiebaStatic.log(new am("c10125").ax(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aOz || dVar.aOC) {
                TiebaStatic.log(new am("c10125").ax("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aOM).x("obj_param1", dVar.aON).ax(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aOA) {
                TiebaStatic.log(new am("c10427").ax("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aOx) {
                af(i, dVar.aOJ);
            } else if (dVar.aOB) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).ax(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aOD) {
                am x = new am("c10125").x("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    x.x("obj_param1", 9);
                }
                TiebaStatic.log(x);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bwT() {
        int size = this.gSW.size();
        for (int i = 0; i < size; i++) {
            View view = this.gSW.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), e.d.cp_cont_j);
            }
        }
        al.i(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.gTe, e.d.cp_cont_j, 1);
        d uk = uk(1);
        if (uk != null && StringUtils.isNull(uk.aOF)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gTe.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gTe.setText(spannableStringBuilder);
        }
        al.c(this.gSU, e.d.cp_cont_b, 1);
        al.i(this.gSU, e.f.dialog_share_cancel_button_bg_selector);
        al.i(this.mLine, e.d.cp_bg_line_a);
        al.i(this.dqG, e.d.cp_bg_line_a);
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

    private boolean um(int i) {
        return (i & 1) > 0;
    }

    private boolean un(int i) {
        return (i & 2) > 0;
    }

    private boolean uq(int i) {
        return (i & 4) > 0;
    }

    private boolean uo(int i) {
        return (i & 8) > 0;
    }

    private boolean up(int i) {
        return (i & 16) > 0;
    }
}
