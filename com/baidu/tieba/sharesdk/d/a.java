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
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog alf;
    private TextView gBm;
    private final LinearLayout gBn;
    private final LinearLayout gBo;
    private View.OnClickListener gBq;
    private SparseArray<String> gBt;
    private SparseArray<r> gBu;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gBr = new SparseArray<>(8);
    private boolean gBs = false;
    private boolean gBv = true;
    private final List<View> gBp = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_dialog_content, (ViewGroup) null);
    private final TextView gBj = (TextView) this.mRootView.findViewById(d.g.share_dialog_title);
    private final View gBk = this.mRootView.findViewById(d.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(d.g.line);
    private final View mLine2 = this.mRootView.findViewById(d.g.line_2);
    private final TextView gBl = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gBl.setOnClickListener(this);
        if (!sY(i)) {
            bD(d.k.share_weixin, d.f.icon_weixin);
        }
        if (!sZ(i)) {
            bD(d.k.share_weixin_timeline, d.f.icon_weixin_q);
        }
        if (!ta(i)) {
            bD(d.k.share_qzone, d.f.icon_qq_zone);
        }
        if (!tb(i)) {
            bD(d.k.share_qq_friends, d.f.icon_qq_share);
        }
        if (!tc(i)) {
            bD(d.k.share_sina_weibo, d.f.icon_sina);
        }
        this.gBn = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_1);
        this.gBo = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_2);
        if (!e.FH()) {
            this.gBn.setVisibility(8);
            this.gBo.setVisibility(8);
        }
    }

    private void Vm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.alf != null && a.this.alf.isShowing()) {
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
        textView.setLayoutParams(bsX());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gBp.add(textView);
        return textView;
    }

    public TextView bE(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bsX());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bsX() {
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

    public int bsY() {
        if (this.gBp == null) {
            return 0;
        }
        return this.gBp.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gBp.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0232a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gBp.size() && i >= 0) {
            this.gBp.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0232a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0232a implements View.OnClickListener {
        private View.OnClickListener gBx;

        public View$OnClickListenerC0232a(View.OnClickListener onClickListener) {
            this.gBx = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gBx != null) {
                this.gBx.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gBv = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gBt = sparseArray;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location aku;
        if (z && (aku = aku()) != null) {
            dVar.aGd = aku;
        }
        this.gBr.put(1, dVar);
        this.gBj.setVisibility(dVar.aFZ ? 0 : 8);
        if (!StringUtils.isNull(dVar.aGa)) {
            this.gBj.setText(dVar.aGa);
        }
    }

    private Location aku() {
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
            this.gBq = onClickListener;
        }
    }

    public void bsZ() {
        if (this.gBv) {
            this.gBm = bD(d.k.share_copy, d.f.icon_copy_link);
        }
        int size = this.gBp.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bE = bE(d.k.share_weixin_timeline, d.f.icon_weixin_q);
                bE.setVisibility(4);
                this.gBp.add(bE);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gBn.addView(this.gBp.get(i2));
                } else {
                    this.gBo.addView(this.gBp.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gBn.addView(this.gBp.get(i3));
            }
        }
    }

    public void show() {
        if (!j.jD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
        } else if (!e.FH()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.plugin_share_install_failure);
        } else {
            bsZ();
            this.alf = new AlertDialog.Builder(this.mContext, d.l.DialogTheme).create();
            this.alf.setCanceledOnTouchOutside(true);
            this.alf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.alf, (Activity) this.mContext);
            }
            Window window = this.alf.getWindow();
            window.setWindowAnimations(d.l.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bta();
            Vm();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.alf != null) {
            this.gBs = false;
            if (this.mContext instanceof Activity) {
                g.b(this.alf, (Activity) this.mContext);
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
        if (this.gBr.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.gBs) {
                this.gBs = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d sW = sW(1);
                if (id == d.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_weixin) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    sX(3);
                    com.baidu.tbadk.coreExtra.c.d sW2 = sW(3);
                    a(sW2, 4);
                    if (sW2 != null) {
                        eVar.b(sW2);
                    }
                } else if (i == d.f.icon_weixin_q) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    sX(2);
                    com.baidu.tbadk.coreExtra.c.d sW3 = sW(2);
                    a(sW3, 3);
                    if (sW3 != null) {
                        if (sW3.aFT) {
                            sW3.content = "【" + sW3.title + "】 " + sW3.content;
                        }
                        eVar.c(sW3);
                    }
                } else if (i == d.f.icon_qq_zone) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        sX(4);
                        com.baidu.tbadk.coreExtra.c.d sW4 = sW(4);
                        a(sW4, 5);
                        if (sW4 != null) {
                            eVar.e(sW4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xv();
                    }
                } else if (i == d.f.icon_qq_weibo) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    sX(5);
                    com.baidu.tbadk.coreExtra.c.d sW5 = sW(5);
                    a(sW5, 6);
                    if (sW5 != null) {
                        if (!sW5.aFS) {
                            sW5.content = j(sW5);
                        }
                        eVar.f(sW5);
                    }
                } else if (i == d.f.icon_sina) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    sX(6);
                    com.baidu.tbadk.coreExtra.c.d sW6 = sW(6);
                    a(sW6, 7);
                    if (sW6 != null) {
                        if (!sW6.aFS) {
                            sW6.content = j(sW6);
                        }
                        eVar.g(sW6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    sX(7);
                    com.baidu.tbadk.coreExtra.c.d sW7 = sW(7);
                    a(sW7, 8);
                    if (sW7 != null) {
                        if (!sW7.aFS) {
                            sW7.content = j(sW7);
                        }
                        eVar.h(sW7);
                    }
                } else if (i == d.f.icon_qq_share) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        sX(8);
                        com.baidu.tbadk.coreExtra.c.d sW8 = sW(8);
                        a(sW8, 9);
                        if (sW8 != null) {
                            eVar.d(sW8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xv();
                    }
                } else if (i == d.f.icon_copy_link) {
                    a(sW, 10);
                    if (this.gBq != null) {
                        this.gBq.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aP(sW.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.k.copy_pb_url_success));
                    }
                    k(sW);
                    if (sW != null && sW.aFS) {
                        ag(8, sW.aGe);
                    }
                }
            }
        }
    }

    private void k(com.baidu.tbadk.coreExtra.c.d dVar) {
        an r = new an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aGi != 0) {
            r.r("obj_param1", dVar.aGi);
            if (dVar.aGi == 2) {
                r.ah(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aGi == 3) {
                if (dVar.aGj != 0) {
                    r.r("obj_type", dVar.aGj);
                }
                r.ah("tid", dVar.tid).ah(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(r);
    }

    private com.baidu.tbadk.coreExtra.c.d sW(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.gBr.get(i);
        if (dVar == null) {
            return this.gBr.get(1);
        }
        return dVar;
    }

    private void sX(int i) {
        if (i <= 8 && i > 0) {
            this.gBs = true;
            if (this.gBu != null) {
                r rVar = this.gBu.get(i);
                if (!StringUtils.isNull(rVar.Cy()) && rVar.Cz() != null && rVar.Cz().size() > 0) {
                    l(rVar.Cy(), rVar.Cz());
                    return;
                }
            }
            if (this.gBt != null) {
                String str = this.gBt.get(i);
                if (!ap.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void ag(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aFT) {
                TiebaStatic.log(new an("c10125").ah(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.aFU || dVar.aFX) {
                TiebaStatic.log(new an("c10125").ah("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aGh).r("obj_param1", dVar.aGi).ah(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aFV) {
                TiebaStatic.log(new an("c10427").ah("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.aFS) {
                ag(i, dVar.aGe);
            } else if (dVar.aFW) {
                TiebaStatic.log(new an("c10125").r("obj_param1", 7).r("obj_type", i).ah(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aFY) {
                an r = new an("c10125").r("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    r.r("obj_param1", 9);
                }
                TiebaStatic.log(r);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bta() {
        int size = this.gBp.size();
        for (int i = 0; i < size; i++) {
            View view = this.gBp.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), d.C0142d.cp_cont_j);
            }
        }
        am.i(this.mRootView, d.C0142d.cp_bg_line_e);
        am.c(this.gBj, d.C0142d.cp_cont_j, 1);
        com.baidu.tbadk.coreExtra.c.d sW = sW(1);
        if (sW != null && StringUtils.isNull(sW.aGa)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gBj.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0142d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0142d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gBj.setText(spannableStringBuilder);
        }
        am.c(this.gBl, d.C0142d.cp_cont_b, 1);
        am.i(this.gBl, d.f.dialog_share_cancel_button_bg_selector);
        am.i(this.mLine, d.C0142d.cp_bg_line_a);
        am.i(this.mLine2, d.C0142d.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = am.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        am.c(textView, i2, 1);
    }

    private String j(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean sY(int i) {
        return (i & 1) > 0;
    }

    private boolean sZ(int i) {
        return (i & 2) > 0;
    }

    private boolean ta(int i) {
        return (i & 4) > 0;
    }

    private boolean tb(int i) {
        return (i & 8) > 0;
    }

    private boolean tc(int i) {
        return (i & 16) > 0;
    }
}
