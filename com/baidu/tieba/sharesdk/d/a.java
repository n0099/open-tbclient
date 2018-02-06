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
    private AlertDialog aRn;
    private TextView gPL;
    private final LinearLayout gPM;
    private final LinearLayout gPN;
    private View.OnClickListener gPP;
    private SparseArray<String> gPS;
    private SparseArray<r> gPT;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final SparseArray<d> gPQ = new SparseArray<>(8);
    private boolean gPR = false;
    private boolean gPU = true;
    private final List<View> gPO = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.share_dialog_content, (ViewGroup) null);
    private final TextView gPI = (TextView) this.mRootView.findViewById(d.g.share_dialog_title);
    private final View gPJ = this.mRootView.findViewById(d.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(d.g.line);
    private final View mLine2 = this.mRootView.findViewById(d.g.line_2);
    private final TextView gPK = (TextView) this.mRootView.findViewById(d.g.btnShareCancel);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.gPK.setOnClickListener(this);
        if (!va(i)) {
            cB(d.j.share_weixin, d.f.icon_weixin);
        }
        if (!vb(i)) {
            cB(d.j.share_weixin_timeline, d.f.icon_weixin_q);
        }
        if (!vc(i)) {
            cB(d.j.share_qzone, d.f.icon_qq_zone);
        }
        if (!vd(i)) {
            cB(d.j.share_qq_friends, d.f.icon_qq_share);
        }
        if (!ve(i)) {
            cB(d.j.share_sina_weibo, d.f.icon_sina);
        }
        this.gPM = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_1);
        this.gPN = (LinearLayout) this.mRootView.findViewById(d.g.share_dialog_line_2);
        if (!e.IZ()) {
            this.gPM.setVisibility(8);
            this.gPN.setVisibility(8);
        }
    }

    private void YY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.aRn != null && a.this.aRn.isShowing()) {
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
        textView.setLayoutParams(bsq());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.gPO.add(textView);
        return textView;
    }

    public TextView cC(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bsq());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bsq() {
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

    public int bsr() {
        if (this.gPO == null) {
            return 0;
        }
        return this.gPO.size();
    }

    public void b(View view, View.OnClickListener onClickListener) {
        this.gPO.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new View$OnClickListenerC0231a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.gPO.size() && i >= 0) {
            this.gPO.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new View$OnClickListenerC0231a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class View$OnClickListenerC0231a implements View.OnClickListener {
        private View.OnClickListener gPW;

        public View$OnClickListenerC0231a(View.OnClickListener onClickListener) {
            this.gPW = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.gPW != null) {
                this.gPW.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.gPU = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.gPS = sparseArray;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, boolean z) {
        Location ano;
        if (z && (ano = ano()) != null) {
            dVar.blC = ano;
        }
        this.gPQ.put(1, dVar);
        this.gPI.setVisibility(dVar.blx ? 0 : 8);
        if (!StringUtils.isNull(dVar.bly)) {
            this.gPI.setText(dVar.bly);
        }
    }

    private Location ano() {
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
            this.gPP = onClickListener;
        }
    }

    public void bss() {
        if (this.gPU) {
            this.gPL = cB(d.j.share_copy, d.f.icon_copy_link);
        }
        int size = this.gPO.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView cC = cC(d.j.share_weixin_timeline, d.f.icon_weixin_q);
                cC.setVisibility(4);
                this.gPO.add(cC);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.gPM.addView(this.gPO.get(i2));
                } else {
                    this.gPN.addView(this.gPO.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.gPM.addView(this.gPO.get(i3));
            }
        }
    }

    public void show() {
        if (!j.oJ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
        } else if (!e.IZ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_share_install_failure);
        } else {
            bss();
            this.aRn = new AlertDialog.Builder(this.mContext).create();
            this.aRn.setCanceledOnTouchOutside(true);
            this.aRn.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.aRn, (Activity) this.mContext);
            }
            Window window = this.aRn.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bst();
            YY();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.aRn != null) {
            this.gPR = false;
            if (this.mContext instanceof Activity) {
                g.b(this.aRn, (Activity) this.mContext);
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
        if (this.gPQ.size() != 0) {
            if (view.getId() == d.g.btnShareCancel || !this.gPR) {
                this.gPR = true;
                e eVar = new e(this.mContext, null);
                com.baidu.tbadk.coreExtra.c.d uY = uY(1);
                if (id == d.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == d.f.icon_weixin) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    uZ(3);
                    com.baidu.tbadk.coreExtra.c.d uY2 = uY(3);
                    b(uY2, 4);
                    if (uY2 != null) {
                        eVar.b(uY2);
                    }
                } else if (i == d.f.icon_weixin_q) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    uZ(2);
                    com.baidu.tbadk.coreExtra.c.d uY3 = uY(2);
                    b(uY3, 3);
                    if (uY3 != null) {
                        if (uY3.bls) {
                            uY3.content = "【" + uY3.title + "】 " + uY3.content;
                        }
                        eVar.c(uY3);
                    }
                } else if (i == d.f.icon_qq_zone) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        uZ(4);
                        com.baidu.tbadk.coreExtra.c.d uY4 = uY(4);
                        b(uY4, 5);
                        if (uY4 != null) {
                            eVar.e(uY4);
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
                    uZ(5);
                    com.baidu.tbadk.coreExtra.c.d uY5 = uY(5);
                    b(uY5, 6);
                    if (uY5 != null) {
                        if (!uY5.blr) {
                            uY5.content = j(uY5);
                        }
                        eVar.f(uY5);
                    }
                } else if (i == d.f.icon_sina) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    uZ(6);
                    com.baidu.tbadk.coreExtra.c.d uY6 = uY(6);
                    b(uY6, 7);
                    if (uY6 != null) {
                        if (!uY6.blr) {
                            uY6.content = j(uY6);
                        }
                        eVar.g(uY6);
                    }
                } else if (i == d.f.icon_renren) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    uZ(7);
                    com.baidu.tbadk.coreExtra.c.d uY7 = uY(7);
                    b(uY7, 8);
                    if (uY7 != null) {
                        if (!uY7.blr) {
                            uY7.content = j(uY7);
                        }
                        eVar.h(uY7);
                    }
                } else if (i == d.f.icon_qq_share) {
                    if (!j.oJ()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        uZ(8);
                        com.baidu.tbadk.coreExtra.c.d uY8 = uY(8);
                        b(uY8, 9);
                        if (uY8 != null) {
                            eVar.d(uY8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bc();
                    }
                } else if (i == d.f.icon_copy_link) {
                    b(uY, 10);
                    if (this.gPP != null) {
                        this.gPP.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aE(uY.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
                    }
                    i(uY);
                    if (uY != null && uY.blr) {
                        af(8, uY.blD);
                    }
                }
            }
        }
    }

    private void i(com.baidu.tbadk.coreExtra.c.d dVar) {
        ak s = new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.blH != 0) {
            s.s("obj_param1", dVar.blH);
            if (dVar.blH == 2) {
                s.ab(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.blH == 3) {
                if (dVar.blI != 0) {
                    s.s("obj_type", dVar.blI);
                }
                s.ab("tid", dVar.tid).ab(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(s);
    }

    private com.baidu.tbadk.coreExtra.c.d uY(int i) {
        com.baidu.tbadk.coreExtra.c.d dVar = this.gPQ.get(i);
        if (dVar == null) {
            return this.gPQ.get(1);
        }
        return dVar;
    }

    private void uZ(int i) {
        if (i <= 8 && i > 0) {
            this.gPR = true;
            if (this.gPT != null) {
                r rVar = this.gPT.get(i);
                if (!StringUtils.isNull(rVar.FU()) && rVar.FV() != null && rVar.FV().size() > 0) {
                    l(rVar.FU(), rVar.FV());
                    return;
                }
            }
            if (this.gPS != null) {
                String str = this.gPS.get(i);
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
            if (dVar.bls) {
                TiebaStatic.log(new ak("c10125").ab(ImageViewerConfig.FORUM_ID, dVar.extData).s("obj_type", i));
            } else if (dVar.blt || dVar.blw) {
                TiebaStatic.log(new ak("c10125").ab("tid", dVar.extData).s("obj_type", i).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.blG).s("obj_param1", dVar.blH).ab(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.blu) {
                TiebaStatic.log(new ak("c10427").ab("tid", dVar.extData).s("obj_type", i));
            } else if (dVar.blr) {
                af(i, dVar.blD);
            } else if (dVar.blv) {
                TiebaStatic.log(new ak("c10125").s("obj_param1", 7).s("obj_type", i).ab(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bst() {
        int size = this.gPO.size();
        for (int i = 0; i < size; i++) {
            View view = this.gPO.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), d.C0140d.cp_cont_j);
            }
        }
        aj.s(this.mRootView, d.C0140d.cp_bg_line_e);
        aj.e(this.gPI, d.C0140d.cp_cont_j, 1);
        com.baidu.tbadk.coreExtra.c.d uY = uY(1);
        if (uY != null && StringUtils.isNull(uY.bly)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gPI.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0140d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0140d.cp_cont_h_1)), 23, 30, 33);
            }
            this.gPI.setText(spannableStringBuilder);
        }
        aj.e(this.gPK, d.C0140d.cp_cont_b, 1);
        aj.s(this.gPK, d.f.dialog_share_cancel_button_bg_selector);
        aj.s(this.mLine, d.C0140d.cp_bg_line_a);
        aj.s(this.mLine2, d.C0140d.cp_bg_line_a);
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

    private boolean va(int i) {
        return (i & 1) > 0;
    }

    private boolean vb(int i) {
        return (i & 2) > 0;
    }

    private boolean vc(int i) {
        return (i & 4) > 0;
    }

    private boolean vd(int i) {
        return (i & 8) > 0;
    }

    private boolean ve(int i) {
        return (i & 16) > 0;
    }
}
