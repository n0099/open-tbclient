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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private AlertDialog aRc;
    private View.OnClickListener gPA;
    private SparseArray<String> gPD;
    private SparseArray<r> gPE;
    private TextView gPw;
    private final LinearLayout gPx;
    private final LinearLayout gPy;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gPB = new SparseArray<>(8);
    private boolean gPC = false;
    private boolean gPF = true;
    private final List<View> gPz = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.share_dialog_content, (ViewGroup) null);
    private final TextView gPt = (TextView) this.mRootView.findViewById(d.g.share_dialog_title);
    private final View gPu = this.mRootView.findViewById(d.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(d.g.line);
    private final View mLine2 = this.mRootView.findViewById(d.g.line_2);
    private final TextView gPv = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gPv.setOnClickListener(this);
        if (!vb(i)) {
            cB(d.j.share_weixin, d.f.icon_weixin);
        }
        if (!vc(i)) {
            cB(d.j.share_weixin_timeline, d.f.icon_weixin_q);
        }
        if (!vd(i)) {
            cB(d.j.share_qzone, d.f.icon_qq_zone);
        }
        if (!ve(i)) {
            cB(d.j.share_qq_friends, d.f.icon_qq_share);
        }
        if (!vf(i)) {
            cB(d.j.share_sina_weibo, d.f.icon_sina);
        }
        this.gPx = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_1);
        this.gPy = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_2);
        if (!e.IY()) {
            this.gPx.setVisibility(8);
            this.gPy.setVisibility(8);
        }
    }

    private void YX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.aRc != null && a.this.aRc.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView cB(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bsp());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gPz.add(textView);
        return textView;
    }

    public TextView cC(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bsp());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bsp() {
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

    public int bsq() {
        if (this.gPz == null) {
            return 0;
        }
        return this.gPz.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gPz.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0232a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gPz.size() && i >= 0) {
            this.gPz.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0232a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0232a implements View.OnClickListener {
        private View.OnClickListener gPH;

        public View$OnClickListenerC0232a(View.OnClickListener onClickListener) {
            this.gPH = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gPH != null) {
                this.gPH.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gPF = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gPD = sparseArray;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location ann;
        if (z && (ann = ann()) != null) {
            dVar.blp = ann;
        }
        this.gPB.put(1, dVar);
        this.gPt.setVisibility(dVar.blk ? 0 : 8);
        if (!StringUtils.isNull(dVar.bll)) {
            this.gPt.setText(dVar.bll);
        }
    }

    private Location ann() {
        if (ab.aS(this.mContext)) {
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
            this.gPA = onClickListener;
        }
    }

    public void bsr() {
        if (this.gPF) {
            this.gPw = cB(d.j.share_copy, d.f.icon_copy_link);
        }
        int size = this.gPz.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView cC = cC(d.j.share_weixin_timeline, d.f.icon_weixin_q);
                cC.setVisibility(4);
                this.gPz.add(cC);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gPx.addView(this.gPz.get(i2));
                } else {
                    this.gPy.addView(this.gPz.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gPx.addView(this.gPz.get(i3));
            }
        }
    }

    public void show() {
        if (!j.oJ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
        } else if (!e.IY()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_share_install_failure);
        } else {
            bsr();
            this.aRc = new AlertDialog.Builder(this.mContext).create();
            this.aRc.setCanceledOnTouchOutside(true);
            this.aRc.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.aRc, (Activity) this.mContext);
            }
            Window window = this.aRc.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bss();
            YX();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.aRc != null) {
            this.gPC = false;
            if (this.mContext instanceof Activity) {
                g.b(this.aRc, (Activity) this.mContext);
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
        if (this.gPB.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.gPC) {
                this.gPC = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d uZ = uZ(1);
                if (id == d.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_weixin) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    va(3);
                    com.baidu.tbadk.coreExtra.c.d uZ2 = uZ(3);
                    b(uZ2, 4);
                    if (uZ2 != null) {
                        eVar.b(uZ2);
                    }
                } else if (i == d.f.icon_weixin_q) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    va(2);
                    com.baidu.tbadk.coreExtra.c.d uZ3 = uZ(2);
                    b(uZ3, 3);
                    if (uZ3 != null) {
                        if (uZ3.blf) {
                            uZ3.content = "【" + uZ3.title + "】 " + uZ3.content;
                        }
                        eVar.c(uZ3);
                    }
                } else if (i == d.f.icon_qq_zone) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        va(4);
                        com.baidu.tbadk.coreExtra.c.d uZ4 = uZ(4);
                        b(uZ4, 5);
                        if (uZ4 != null) {
                            eVar.e(uZ4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bc();
                    }
                } else if (i == d.f.icon_qq_weibo) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    va(5);
                    com.baidu.tbadk.coreExtra.c.d uZ5 = uZ(5);
                    b(uZ5, 6);
                    if (uZ5 != null) {
                        if (!uZ5.ble) {
                            uZ5.content = j(uZ5);
                        }
                        eVar.f(uZ5);
                    }
                } else if (i == d.f.icon_sina) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    va(6);
                    com.baidu.tbadk.coreExtra.c.d uZ6 = uZ(6);
                    b(uZ6, 7);
                    if (uZ6 != null) {
                        if (!uZ6.ble) {
                            uZ6.content = j(uZ6);
                        }
                        eVar.g(uZ6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    va(7);
                    com.baidu.tbadk.coreExtra.c.d uZ7 = uZ(7);
                    b(uZ7, 8);
                    if (uZ7 != null) {
                        if (!uZ7.ble) {
                            uZ7.content = j(uZ7);
                        }
                        eVar.h(uZ7);
                    }
                } else if (i == d.f.icon_qq_share) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        va(8);
                        com.baidu.tbadk.coreExtra.c.d uZ8 = uZ(8);
                        b(uZ8, 9);
                        if (uZ8 != null) {
                            eVar.d(uZ8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bc();
                    }
                } else if (i == d.f.icon_copy_link) {
                    b(uZ, 10);
                    if (this.gPA != null) {
                        this.gPA.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aE(uZ.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
                    }
                    i(uZ);
                    if (uZ != null && uZ.ble) {
                        af(8, uZ.blq);
                    }
                }
            }
        }
    }

    private void i(com.baidu.tbadk.coreExtra.c.d dVar) {
        ak s = new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.blu != 0) {
            s.s("obj_param1", dVar.blu);
            if (dVar.blu == 2) {
                s.ab(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.blu == 3) {
                if (dVar.blv != 0) {
                    s.s("obj_type", dVar.blv);
                }
                s.ab("tid", dVar.tid).ab(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(s);
    }

    private com.baidu.tbadk.coreExtra.c.d uZ(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.gPB.get(i);
        if (dVar == null) {
            return this.gPB.get(1);
        }
        return dVar;
    }

    private void va(int i) {
        if (i <= 8 && i > 0) {
            this.gPC = true;
            if (this.gPE != null) {
                r rVar = this.gPE.get(i);
                if (!StringUtils.isNull(rVar.FT()) && rVar.FU() != null && rVar.FU().size() > 0) {
                    l(rVar.FT(), rVar.FU());
                    return;
                }
            }
            if (this.gPD != null) {
                String str = this.gPD.get(i);
                if (!am.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void af(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void b(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.blf) {
                TiebaStatic.log(new ak("c10125").ab(ImageViewerConfig.FORUM_ID, dVar.extData).s("obj_type", i));
            } else if (dVar.blg || dVar.blj) {
                TiebaStatic.log(new ak("c10125").ab("tid", dVar.extData).s("obj_type", i).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.blt).s("obj_param1", dVar.blu).ab(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.blh) {
                TiebaStatic.log(new ak("c10427").ab("tid", dVar.extData).s("obj_type", i));
            } else if (dVar.ble) {
                af(i, dVar.blq);
            } else if (dVar.bli) {
                TiebaStatic.log(new ak("c10125").s("obj_param1", 7).s("obj_type", i).ab(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bss() {
        int size = this.gPz.size();
        for (int i = 0; i < size; i++) {
            View view = this.gPz.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), d.C0141d.cp_cont_j);
            }
        }
        aj.s(this.mRootView, d.C0141d.cp_bg_line_e);
        aj.e(this.gPt, d.C0141d.cp_cont_j, 1);
        com.baidu.tbadk.coreExtra.c.d uZ = uZ(1);
        if (uZ != null && StringUtils.isNull(uZ.bll)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gPt.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gPt.setText(spannableStringBuilder);
        }
        aj.e(this.gPv, d.C0141d.cp_cont_b, 1);
        aj.s(this.gPv, d.f.dialog_share_cancel_button_bg_selector);
        aj.s(this.mLine, d.C0141d.cp_bg_line_a);
        aj.s(this.mLine2, d.C0141d.cp_bg_line_a);
    }

    private void a(TextView textView, int i, int i2) {
        Drawable drawable = aj.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        aj.e(textView, i2, 1);
    }

    private String j(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private boolean vb(int i) {
        return (i & 1) > 0;
    }

    private boolean vc(int i) {
        return (i & 2) > 0;
    }

    private boolean vd(int i) {
        return (i & 4) > 0;
    }

    private boolean ve(int i) {
        return (i & 8) > 0;
    }

    private boolean vf(int i) {
        return (i & 16) > 0;
    }
}
