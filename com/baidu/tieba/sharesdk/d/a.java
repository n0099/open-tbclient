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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog akG;
    private SparseArray<String> gxA;
    private SparseArray<r> gxB;
    private TextView gxt;
    private final LinearLayout gxu;
    private final LinearLayout gxv;
    private View.OnClickListener gxx;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gxy = new SparseArray<>(8);
    private boolean gxz = false;
    private boolean gxC = true;
    private final List<View> gxw = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_dialog_content, (ViewGroup) null);
    private final TextView gxq = (TextView) this.mRootView.findViewById(d.g.share_dialog_title);
    private final View gxr = this.mRootView.findViewById(d.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(d.g.line);
    private final View mLine2 = this.mRootView.findViewById(d.g.line_2);
    private final TextView gxs = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gxs.setOnClickListener(this);
        if (!sO(i)) {
            bE(d.k.share_weixin, d.f.icon_weixin);
        }
        if (!sP(i)) {
            bE(d.k.share_weixin_timeline, d.f.icon_weixin_q);
        }
        if (!sQ(i)) {
            bE(d.k.share_qzone, d.f.icon_qq_zone);
        }
        if (!sR(i)) {
            bE(d.k.share_qq_friends, d.f.icon_qq_share);
        }
        if (!sS(i)) {
            bE(d.k.share_sina_weibo, d.f.icon_sina);
        }
        this.gxu = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_1);
        this.gxv = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_2);
        if (!e.Fp()) {
            this.gxu.setVisibility(8);
            this.gxv.setVisibility(8);
        }
    }

    private void UR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.akG != null && a.this.akG.isShowing()) {
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
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bsx());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gxw.add(textView);
        return textView;
    }

    public TextView bF(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bsx());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bsx() {
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

    public int bsy() {
        if (this.gxw == null) {
            return 0;
        }
        return this.gxw.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gxw.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0230a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gxw.size() && i >= 0) {
            this.gxw.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0230a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0230a implements View.OnClickListener {
        private View.OnClickListener gxE;

        public View$OnClickListenerC0230a(View.OnClickListener onClickListener) {
            this.gxE = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gxE != null) {
                this.gxE.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gxC = z;
    }

    public void d(SparseArray<String> sparseArray) {
        this.gxA = sparseArray;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location ala;
        if (z && (ala = ala()) != null) {
            dVar.aFk = ala;
        }
        this.gxy.put(1, dVar);
        this.gxq.setVisibility(dVar.aFf ? 0 : 8);
        if (!StringUtils.isNull(dVar.aFg)) {
            this.gxq.setText(dVar.aFg);
        }
    }

    private Location ala() {
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
            this.gxx = onClickListener;
        }
    }

    public void bsz() {
        if (this.gxC) {
            this.gxt = bE(d.k.share_copy, d.f.icon_copy_link);
        }
        int size = this.gxw.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bF = bF(d.k.share_weixin_timeline, d.f.icon_weixin_q);
                bF.setVisibility(4);
                this.gxw.add(bF);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gxu.addView(this.gxw.get(i2));
                } else {
                    this.gxv.addView(this.gxw.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gxu.addView(this.gxw.get(i3));
            }
        }
    }

    public void show() {
        if (!j.jD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
        } else if (!e.Fp()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.plugin_share_install_failure);
        } else {
            bsz();
            this.akG = new AlertDialog.Builder(this.mContext, d.l.DialogTheme).create();
            this.akG.setCanceledOnTouchOutside(true);
            this.akG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.akG, (Activity) this.mContext);
            }
            Window window = this.akG.getWindow();
            window.setWindowAnimations(d.l.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bsA();
            UR();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.akG != null) {
            this.gxz = false;
            if (this.mContext instanceof Activity) {
                g.b(this.akG, (Activity) this.mContext);
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
        if (this.gxy.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.gxz) {
                this.gxz = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d sM = sM(1);
                if (id == d.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_weixin) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    sN(3);
                    com.baidu.tbadk.coreExtra.c.d sM2 = sM(3);
                    a(sM2, 4);
                    if (sM2 != null) {
                        eVar.b(sM2);
                    }
                } else if (i == d.f.icon_weixin_q) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    sN(2);
                    com.baidu.tbadk.coreExtra.c.d sM3 = sM(2);
                    a(sM3, 3);
                    if (sM3 != null) {
                        if (sM3.aEZ) {
                            sM3.content = "【" + sM3.title + "】 " + sM3.content;
                        }
                        eVar.c(sM3);
                    }
                } else if (i == d.f.icon_qq_zone) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        sN(4);
                        com.baidu.tbadk.coreExtra.c.d sM4 = sM(4);
                        a(sM4, 5);
                        if (sM4 != null) {
                            eVar.e(sM4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xi();
                    }
                } else if (i == d.f.icon_qq_weibo) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    sN(5);
                    com.baidu.tbadk.coreExtra.c.d sM5 = sM(5);
                    a(sM5, 6);
                    if (sM5 != null) {
                        if (!sM5.aEY) {
                            sM5.content = j(sM5);
                        }
                        eVar.f(sM5);
                    }
                } else if (i == d.f.icon_sina) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    sN(6);
                    com.baidu.tbadk.coreExtra.c.d sM6 = sM(6);
                    a(sM6, 7);
                    if (sM6 != null) {
                        if (!sM6.aEY) {
                            sM6.content = j(sM6);
                        }
                        eVar.g(sM6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    sN(7);
                    com.baidu.tbadk.coreExtra.c.d sM7 = sM(7);
                    a(sM7, 8);
                    if (sM7 != null) {
                        if (!sM7.aEY) {
                            sM7.content = j(sM7);
                        }
                        eVar.h(sM7);
                    }
                } else if (i == d.f.icon_qq_share) {
                    if (!j.jD()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        sN(8);
                        com.baidu.tbadk.coreExtra.c.d sM8 = sM(8);
                        a(sM8, 9);
                        if (sM8 != null) {
                            eVar.d(sM8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xi();
                    }
                } else if (i == d.f.icon_copy_link) {
                    a(sM, 10);
                    if (this.gxx != null) {
                        this.gxx.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aN(sM.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.k.copy_pb_url_success));
                    }
                    k(sM);
                    if (sM != null && sM.aEY) {
                        aj(8, sM.aFl);
                    }
                }
            }
        }
    }

    private void k(com.baidu.tbadk.coreExtra.c.d dVar) {
        am r = new am("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aFp != 0) {
            r.r("obj_param1", dVar.aFp);
            if (dVar.aFp == 2) {
                r.ah(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aFp == 3) {
                if (dVar.aFq != 0) {
                    r.r("obj_type", dVar.aFq);
                }
                r.ah("tid", dVar.tid).ah(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(r);
    }

    private com.baidu.tbadk.coreExtra.c.d sM(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.gxy.get(i);
        if (dVar == null) {
            return this.gxy.get(1);
        }
        return dVar;
    }

    private void sN(int i) {
        if (i <= 8 && i > 0) {
            this.gxz = true;
            if (this.gxB != null) {
                r rVar = this.gxB.get(i);
                if (!StringUtils.isNull(rVar.Cg()) && rVar.Ch() != null && rVar.Ch().size() > 0) {
                    l(rVar.Cg(), rVar.Ch());
                    return;
                }
            }
            if (this.gxA != null) {
                String str = this.gxA.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aj(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aEZ) {
                TiebaStatic.log(new am("c10125").ah(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.aFa || dVar.aFd) {
                TiebaStatic.log(new am("c10125").ah("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aFo).r("obj_param1", dVar.aFp).ah(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aFb) {
                TiebaStatic.log(new am("c10427").ah("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.aEY) {
                aj(i, dVar.aFl);
            } else if (dVar.aFc) {
                TiebaStatic.log(new am("c10125").r("obj_param1", 7).r("obj_type", i).ah(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aFe) {
                am r = new am("c10125").r("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    r.r("obj_param1", 9);
                }
                TiebaStatic.log(r);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bsA() {
        int size = this.gxw.size();
        for (int i = 0; i < size; i++) {
            View view = this.gxw.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), d.C0141d.cp_cont_j);
            }
        }
        al.i(this.mRootView, d.C0141d.cp_bg_line_e);
        al.c(this.gxq, d.C0141d.cp_cont_j, 1);
        com.baidu.tbadk.coreExtra.c.d sM = sM(1);
        if (sM != null && StringUtils.isNull(sM.aFg)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gxq.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gxq.setText(spannableStringBuilder);
        }
        al.c(this.gxs, d.C0141d.cp_cont_b, 1);
        al.i(this.gxs, d.f.dialog_share_cancel_button_bg_selector);
        al.i(this.mLine, d.C0141d.cp_bg_line_a);
        al.i(this.mLine2, d.C0141d.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = al.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        al.c(textView, i2, 1);
    }

    private String j(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean sO(int i) {
        return (i & 1) > 0;
    }

    private boolean sP(int i) {
        return (i & 2) > 0;
    }

    private boolean sQ(int i) {
        return (i & 4) > 0;
    }

    private boolean sR(int i) {
        return (i & 8) > 0;
    }

    private boolean sS(int i) {
        return (i & 16) > 0;
    }
}
