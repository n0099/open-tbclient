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
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private AlertDialog awV;
    private View.OnClickListener hdW;
    private SparseArray<String> hdZ;
    private SparseArray<v> hea;
    private TextView hef;
    private final LinearLayout heg;
    private final LinearLayout heh;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private final SparseArray<d> hdX = new SparseArray<>(8);
    private boolean hdY = false;
    private boolean hei = true;
    private final List<View> hdV = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_dialog_content, (ViewGroup) null);
    private final TextView hed = (TextView) this.mRootView.findViewById(e.g.share_dialog_title);
    private final View hee = this.mRootView.findViewById(e.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(e.g.line);
    private final View dAC = this.mRootView.findViewById(e.g.line_2);
    private final TextView hdT = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.hdT.setOnClickListener(this);
        if (!uX(i)) {
            bM(e.j.share_weixin, e.f.icon_weixin);
        }
        if (!uY(i)) {
            bM(e.j.share_weixin_timeline, e.f.icon_weixin_q);
        }
        if (!vb(i)) {
            bM(e.j.share_qzone, e.f.icon_qq_zone);
        }
        if (!uZ(i)) {
            bM(e.j.share_qq_friends, e.f.icon_qq_share);
        }
        if (!va(i)) {
            bM(e.j.share_sina_weibo, e.f.icon_sina);
        }
        if (vc(i)) {
            bM(e.j.share_save_pic, e.f.icon_download_n);
        }
        this.heg = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_1);
        this.heh = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_2);
        if (!com.baidu.tbadk.coreExtra.c.e.KA()) {
            this.heg.setVisibility(8);
            this.heh.setVisibility(8);
        }
    }

    private void acI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (b.this.awV != null && b.this.awV.isShowing()) {
                    b.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private TextView bM(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bAm());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.hdV.add(textView);
        return textView;
    }

    public TextView bN(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bAm());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bAm() {
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

    public int bAj() {
        if (this.hdV == null) {
            return 0;
        }
        return this.hdV.size();
    }

    public void c(View view, View.OnClickListener onClickListener) {
        this.hdV.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.hdV.size() && i >= 0) {
            this.hdV.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener hec;

        public a(View.OnClickListener onClickListener) {
            this.hec = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.hec != null) {
                this.hec.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.hei = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.hdZ = sparseArray;
    }

    public void a(d dVar, boolean z) {
        Location asH;
        if (z && (asH = asH()) != null) {
            dVar.aSO = asH;
        }
        this.hdX.put(1, dVar);
        this.hed.setVisibility(dVar.aSJ ? 0 : 8);
        if (!StringUtils.isNull(dVar.aSK)) {
            this.hed.setText(dVar.aSK);
        }
    }

    private Location asH() {
        if (ab.bC(this.mContext)) {
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
            this.hdW = onClickListener;
        }
    }

    public void bAk() {
        if (this.hei) {
            this.hef = bM(e.j.share_copy, e.f.icon_copy_link);
        }
        int size = this.hdV.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bN = bN(e.j.share_weixin_timeline, e.f.icon_weixin_q);
                bN.setVisibility(4);
                this.hdV.add(bN);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.heg.addView(this.hdV.get(i2));
                } else {
                    this.heh.addView(this.hdV.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.heg.addView(this.hdV.get(i3));
            }
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.KA()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bAk();
            this.awV = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.awV.setCanceledOnTouchOutside(true);
            this.awV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            this.awV.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (b.this.onCancelListener != null) {
                        b.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.awV, (Activity) this.mContext);
            }
            Window window = this.awV.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bAl();
            acI();
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
        if (this.awV != null) {
            this.hdY = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.awV);
                }
                g.b(this.awV, (Activity) this.mContext);
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
        if (this.hdX.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.hdY) {
                this.hdY = true;
                d uV = uV(1);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    if (uV != null && uV.aSI) {
                        a(uV, 16);
                    }
                    dismiss();
                } else if (i == e.f.icon_weixin) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    uW(3);
                    d uV2 = uV(3);
                    a(uV2, 4);
                    if (uV2 != null) {
                        if (uV2.aTd == 1) {
                            o(uV2);
                        } else {
                            eVar.b(uV2);
                        }
                    }
                } else if (i == e.f.icon_weixin_q) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    uW(2);
                    d uV3 = uV(2);
                    a(uV3, 3);
                    if (uV3 != null) {
                        if (uV3.aTd == 1) {
                            o(uV3);
                            return;
                        }
                        if (uV3.aSD) {
                            uV3.content = "【" + uV3.title + "】 " + uV3.content;
                        }
                        eVar.c(uV3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        uW(4);
                        d uV4 = uV(4);
                        a(uV4, 5);
                        if (uV4 != null) {
                            eVar.e(uV4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    uW(5);
                    d uV5 = uV(5);
                    a(uV5, 6);
                    if (uV5 != null) {
                        if (!uV5.aSC) {
                            uV5.content = m(uV5);
                        }
                        eVar.f(uV5);
                    }
                } else if (i == e.f.icon_sina) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    uW(6);
                    d uV6 = uV(6);
                    a(uV6, 7);
                    if (uV6 != null) {
                        if (!uV6.aSC) {
                            uV6.content = m(uV6);
                        }
                        eVar.g(uV6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    uW(7);
                    d uV7 = uV(7);
                    a(uV7, 8);
                    if (uV7 != null) {
                        if (!uV7.aSC) {
                            uV7.content = m(uV7);
                        }
                        eVar.h(uV7);
                    }
                } else if (i == e.f.icon_qq_share) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        uW(8);
                        d uV8 = uV(8);
                        a(uV8, 9);
                        if (uV8 != null) {
                            eVar.d(uV8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
                    }
                } else if (i == e.f.icon_download_n) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    this.mPermissionJudgement.EG();
                    this.mPermissionJudgement.c((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.B((Activity) this.mContext)) {
                        a(uV, 17);
                        String uri = uV.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new k(currentActivity, uri, new k.a() { // from class: com.baidu.tieba.sharesdk.d.b.4
                                @Override // com.baidu.tbadk.util.k.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.k.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(uV, 10);
                    if (this.hdW != null) {
                        this.hdW.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uV.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uV);
                    if (uV != null && uV.aSC) {
                        ai(8, uV.aSP);
                    }
                }
            }
        }
    }

    private void o(final d dVar) {
        if (dVar != null && !TextUtils.isEmpty(dVar.content) && !TextUtils.isEmpty(dVar.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.eJ(dVar.title);
            aVar.eK(dVar.content);
            aVar.setAutoNight(false);
            aVar.bg(true);
            aVar.bn(true);
            aVar.a(e.j.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.bg(dVar.content);
                    l.showToast(b.this.mContext.getApplicationContext(), e.j.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.aK(activity));
            aVar.BS();
        }
    }

    private void n(d dVar) {
        am y = new am("share_success").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aST != 0) {
            y.y("obj_param1", dVar.aST);
            if (dVar.aST == 2) {
                y.aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aST == 3) {
                if (dVar.aSU != 0) {
                    y.y("obj_type", dVar.aSU);
                }
                y.aB("tid", dVar.tid).aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(y);
    }

    private d uV(int i) {
        d dVar = this.hdX.get(i);
        if (dVar == null) {
            return this.hdX.get(1);
        }
        return dVar;
    }

    private void uW(int i) {
        if (i <= 8 && i > 0) {
            this.hdY = true;
            if (this.hea != null) {
                v vVar = this.hea.get(i);
                if (!StringUtils.isNull(vVar.Hh()) && vVar.Hi() != null && vVar.Hi().size() > 0) {
                    l(vVar.Hh(), vVar.Hi());
                    return;
                }
            }
            if (this.hdZ != null) {
                String str = this.hdZ.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void ai(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aSD) {
                TiebaStatic.log(new am("c10125").aB(ImageViewerConfig.FORUM_ID, dVar.extData).y("obj_type", i));
            } else if (dVar.aSE || dVar.aSH) {
                TiebaStatic.log(new am("c10125").aB("tid", dVar.extData).y("obj_type", i).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSS).y("obj_param1", dVar.aST).aB(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSF) {
                TiebaStatic.log(new am("c10427").aB("tid", dVar.extData).y("obj_type", i));
            } else if (dVar.aSC) {
                ai(i, dVar.aSP);
            } else if (dVar.aSG) {
                TiebaStatic.log(new am("c10125").y("obj_param1", 7).y("obj_type", i).aB(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSI) {
                am y = new am("c10125").y("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl)) {
                    if (dVar.linkUrl.contains("worldcup")) {
                        y.y("obj_param1", 9);
                    }
                    y.aB("obj_url", dVar.linkUrl);
                }
                TiebaStatic.log(y);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bAl() {
        int size = this.hdV.size();
        for (int i = 0; i < size; i++) {
            View view = this.hdV.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), e.d.cp_cont_j);
            }
        }
        al.i(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.hed, e.d.cp_cont_j, 1);
        d uV = uV(1);
        if (uV != null && StringUtils.isNull(uV.aSK)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hed.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 23, 30, 33);
            }
            this.hed.setText(spannableStringBuilder);
        }
        al.c(this.hdT, e.d.cp_cont_b, 1);
        al.i(this.hdT, e.f.dialog_share_cancel_button_bg_selector);
        al.i(this.mLine, e.d.cp_bg_line_a);
        al.i(this.dAC, e.d.cp_bg_line_a);
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

    private boolean uX(int i) {
        return (i & 1) > 0;
    }

    private boolean uY(int i) {
        return (i & 2) > 0;
    }

    private boolean vb(int i) {
        return (i & 4) > 0;
    }

    private boolean uZ(int i) {
        return (i & 8) > 0;
    }

    private boolean va(int i) {
        return (i & 16) > 0;
    }

    private boolean vc(int i) {
        return (i & 32) > 0;
    }
}
