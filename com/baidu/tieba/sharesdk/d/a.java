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
    private AlertDialog ank;
    private TextView gKa;
    private final LinearLayout gKb;
    private final LinearLayout gKc;
    private View.OnClickListener gKe;
    private SparseArray<String> gKh;
    private SparseArray<t> gKi;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gKf = new SparseArray<>(8);
    private boolean gKg = false;
    private boolean gKj = true;
    private final List<View> gKd = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_dialog_content, (ViewGroup) null);
    private final TextView gJX = (TextView) this.mRootView.findViewById(e.g.share_dialog_title);
    private final View gJY = this.mRootView.findViewById(e.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(e.g.line);
    private final View dhy = this.mRootView.findViewById(e.g.line_2);
    private final TextView gJZ = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gJZ.setOnClickListener(this);
        if (!tw(i)) {
            bG(e.j.share_weixin, e.f.icon_weixin);
        }
        if (!tx(i)) {
            bG(e.j.share_weixin_timeline, e.f.icon_weixin_q);
        }
        if (!ty(i)) {
            bG(e.j.share_qzone, e.f.icon_qq_zone);
        }
        if (!tz(i)) {
            bG(e.j.share_qq_friends, e.f.icon_qq_share);
        }
        if (!tA(i)) {
            bG(e.j.share_sina_weibo, e.f.icon_sina);
        }
        this.gKb = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_1);
        this.gKc = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_2);
        if (!com.baidu.tbadk.coreExtra.c.e.GT()) {
            this.gKb.setVisibility(8);
            this.gKc.setVisibility(8);
        }
    }

    private void Xl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.ank != null && a.this.ank.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView bG(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bug());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gKd.add(textView);
        return textView;
    }

    public TextView bH(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bug());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bug() {
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

    public int buh() {
        if (this.gKd == null) {
            return 0;
        }
        return this.gKd.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gKd.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0238a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gKd.size() && i >= 0) {
            this.gKd.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0238a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0238a implements View.OnClickListener {
        private View.OnClickListener gKl;

        public View$OnClickListenerC0238a(View.OnClickListener onClickListener) {
            this.gKl = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gKl != null) {
                this.gKl.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gKj = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gKh = sparseArray;
    }

    public void a(d dVar, boolean z) {
        Location amH;
        if (z && (amH = amH()) != null) {
            dVar.aJq = amH;
        }
        this.gKf.put(1, dVar);
        this.gJX.setVisibility(dVar.aJm ? 0 : 8);
        if (!StringUtils.isNull(dVar.aJn)) {
            this.gJX.setText(dVar.aJn);
        }
    }

    private Location amH() {
        if (ab.bs(this.mContext)) {
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
            this.gKe = onClickListener;
        }
    }

    public void bui() {
        if (this.gKj) {
            this.gKa = bG(e.j.share_copy, e.f.icon_copy_link);
        }
        int size = this.gKd.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bH = bH(e.j.share_weixin_timeline, e.f.icon_weixin_q);
                bH.setVisibility(4);
                this.gKd.add(bH);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gKb.addView(this.gKd.get(i2));
                } else {
                    this.gKc.addView(this.gKd.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gKb.addView(this.gKd.get(i3));
            }
        }
    }

    public void show() {
        if (!j.kK()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.GT()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bui();
            this.ank = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.ank.setCanceledOnTouchOutside(true);
            this.ank.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.ank, (Activity) this.mContext);
            }
            Window window = this.ank.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            buj();
            Xl();
        }
    }

    public void b(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.ank != null) {
            this.gKg = false;
            if (this.mContext instanceof Activity) {
                g.b(this.ank, (Activity) this.mContext);
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
        if (this.gKf.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.gKg) {
                this.gKg = true;
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                d tu = tu(1);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == e.f.icon_weixin) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    tv(3);
                    d tu2 = tu(3);
                    a(tu2, 4);
                    if (tu2 != null) {
                        eVar.b(tu2);
                    }
                } else if (i == e.f.icon_weixin_q) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    tv(2);
                    d tu3 = tu(2);
                    a(tu3, 3);
                    if (tu3 != null) {
                        if (tu3.aJg) {
                            tu3.content = "【" + tu3.title + "】 " + tu3.content;
                        }
                        eVar.c(tu3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        tv(4);
                        d tu4 = tu(4);
                        a(tu4, 5);
                        if (tu4 != null) {
                            eVar.e(tu4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).yt();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    tv(5);
                    d tu5 = tu(5);
                    a(tu5, 6);
                    if (tu5 != null) {
                        if (!tu5.aJf) {
                            tu5.content = m(tu5);
                        }
                        eVar.f(tu5);
                    }
                } else if (i == e.f.icon_sina) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    tv(6);
                    d tu6 = tu(6);
                    a(tu6, 7);
                    if (tu6 != null) {
                        if (!tu6.aJf) {
                            tu6.content = m(tu6);
                        }
                        eVar.g(tu6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    tv(7);
                    d tu7 = tu(7);
                    a(tu7, 8);
                    if (tu7 != null) {
                        if (!tu7.aJf) {
                            tu7.content = m(tu7);
                        }
                        eVar.h(tu7);
                    }
                } else if (i == e.f.icon_qq_share) {
                    if (!j.kK()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        tv(8);
                        d tu8 = tu(8);
                        a(tu8, 9);
                        if (tu8 != null) {
                            eVar.d(tu8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).yt();
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(tu, 10);
                    if (this.gKe != null) {
                        this.gKe.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bh(tu.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(tu);
                    if (tu != null && tu.aJf) {
                        aj(8, tu.aJr);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am w = new am("share_success").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aJv != 0) {
            w.w("obj_param1", dVar.aJv);
            if (dVar.aJv == 2) {
                w.al(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aJv == 3) {
                if (dVar.aJw != 0) {
                    w.w("obj_type", dVar.aJw);
                }
                w.al("tid", dVar.tid).al(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(w);
    }

    private d tu(int i) {
        d dVar = this.gKf.get(i);
        if (dVar == null) {
            return this.gKf.get(1);
        }
        return dVar;
    }

    private void tv(int i) {
        if (i <= 8 && i > 0) {
            this.gKg = true;
            if (this.gKi != null) {
                t tVar = this.gKi.get(i);
                if (!StringUtils.isNull(tVar.DB()) && tVar.DC() != null && tVar.DC().size() > 0) {
                    l(tVar.DB(), tVar.DC());
                    return;
                }
            }
            if (this.gKh != null) {
                String str = this.gKh.get(i);
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

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aJg) {
                TiebaStatic.log(new am("c10125").al(ImageViewerConfig.FORUM_ID, dVar.extData).w("obj_type", i));
            } else if (dVar.aJh || dVar.aJk) {
                TiebaStatic.log(new am("c10125").al("tid", dVar.extData).w("obj_type", i).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aJu).w("obj_param1", dVar.aJv).al(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aJi) {
                TiebaStatic.log(new am("c10427").al("tid", dVar.extData).w("obj_type", i));
            } else if (dVar.aJf) {
                aj(i, dVar.aJr);
            } else if (dVar.aJj) {
                TiebaStatic.log(new am("c10125").w("obj_param1", 7).w("obj_type", i).al(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aJl) {
                am w = new am("c10125").w("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    w.w("obj_param1", 9);
                }
                TiebaStatic.log(w);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void buj() {
        int size = this.gKd.size();
        for (int i = 0; i < size; i++) {
            View view = this.gKd.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), e.d.cp_cont_j);
            }
        }
        al.i(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.gJX, e.d.cp_cont_j, 1);
        d tu = tu(1);
        if (tu != null && StringUtils.isNull(tu.aJn)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gJX.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gJX.setText(spannableStringBuilder);
        }
        al.c(this.gJZ, e.d.cp_cont_b, 1);
        al.i(this.gJZ, e.f.dialog_share_cancel_button_bg_selector);
        al.i(this.mLine, e.d.cp_bg_line_a);
        al.i(this.dhy, e.d.cp_bg_line_a);
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

    private boolean tw(int i) {
        return (i & 1) > 0;
    }

    private boolean tx(int i) {
        return (i & 2) > 0;
    }

    private boolean ty(int i) {
        return (i & 4) > 0;
    }

    private boolean tz(int i) {
        return (i & 8) > 0;
    }

    private boolean tA(int i) {
        return (i & 16) > 0;
    }
}
