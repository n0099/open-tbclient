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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
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
    private AlertDialog awt;
    private com.baidu.tbadk.core.util.b.a bzi;
    private View.OnClickListener hcR;
    private SparseArray<String> hcU;
    private SparseArray<u> hcV;
    private TextView hda;
    private final LinearLayout hdb;
    private final LinearLayout hdc;
    private int hideMode;
    private final Context mContext;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnCancelListener onCancelListener;
    private final SparseArray<d> hcS = new SparseArray<>(8);
    private boolean hcT = false;
    private boolean hdd = true;
    private final List<View> hcQ = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_dialog_content, (ViewGroup) null);
    private final TextView hcY = (TextView) this.mRootView.findViewById(e.g.share_dialog_title);
    private final View hcZ = this.mRootView.findViewById(e.g.share_dialog_content);
    private final View mLine = this.mRootView.findViewById(e.g.line);
    private final View dzT = this.mRootView.findViewById(e.g.line_2);
    private final TextView hcO = (TextView) this.mRootView.findViewById(e.g.btnShareCancel);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.hcO.setOnClickListener(this);
        if (!uU(i)) {
            bM(e.j.share_weixin, e.f.icon_weixin);
        }
        if (!uV(i)) {
            bM(e.j.share_weixin_timeline, e.f.icon_weixin_q);
        }
        if (!uY(i)) {
            bM(e.j.share_qzone, e.f.icon_qq_zone);
        }
        if (!uW(i)) {
            bM(e.j.share_qq_friends, e.f.icon_qq_share);
        }
        if (!uX(i)) {
            bM(e.j.share_sina_weibo, e.f.icon_sina);
        }
        if (uZ(i)) {
            bM(e.j.share_save_pic, e.f.icon_download_n);
        }
        this.hdb = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_1);
        this.hdc = (LinearLayout) this.mRootView.findViewById(e.g.share_dialog_line_2);
        if (!com.baidu.tbadk.coreExtra.c.e.Kl()) {
            this.hdb.setVisibility(8);
            this.hdc.setVisibility(8);
        }
    }

    private void acl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (b.this.awt != null && b.this.awt.isShowing()) {
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
        textView.setLayoutParams(bzD());
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(this);
        this.hcQ.add(textView);
        return textView;
    }

    public TextView bN(int i, int i2) {
        TextView textView = (TextView) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.share_icon_text, (ViewGroup) null);
        textView.setCompoundDrawables(null, TbadkCoreApplication.getInst().getResources().getDrawable(i2), null, null);
        textView.setText(i);
        textView.setLayoutParams(bzD());
        textView.setTag(Integer.valueOf(i2));
        return textView;
    }

    public LinearLayout.LayoutParams bzD() {
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

    public int bzA() {
        if (this.hcQ == null) {
            return 0;
        }
        return this.hcQ.size();
    }

    public void c(View view, View.OnClickListener onClickListener) {
        this.hcQ.add(0, view);
        if (onClickListener != null) {
            view.setOnClickListener(new a(onClickListener));
        }
    }

    public void a(TextView textView, int i, View.OnClickListener onClickListener) {
        if (i <= this.hcQ.size() && i >= 0) {
            this.hcQ.add(i, textView);
            if (onClickListener != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener hcX;

        public a(View.OnClickListener onClickListener) {
            this.hcX = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.hcX != null) {
                this.hcX.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.hdd = z;
    }

    public void e(SparseArray<String> sparseArray) {
        this.hcU = sparseArray;
    }

    public void a(d dVar, boolean z) {
        Location asj;
        if (z && (asj = asj()) != null) {
            dVar.aSj = asj;
        }
        this.hcS.put(1, dVar);
        this.hcY.setVisibility(dVar.aSf ? 0 : 8);
        if (!StringUtils.isNull(dVar.aSg)) {
            this.hcY.setText(dVar.aSg);
        }
    }

    private Location asj() {
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
            this.hcR = onClickListener;
        }
    }

    public void bzB() {
        if (this.hdd) {
            this.hda = bM(e.j.share_copy, e.f.icon_copy_link);
        }
        int size = this.hcQ.size();
        if (size < 8) {
            for (int i = 0; i < 8 - size; i++) {
                TextView bN = bN(e.j.share_weixin_timeline, e.f.icon_weixin_q);
                bN.setVisibility(4);
                this.hcQ.add(bN);
            }
        }
        if (!this.mIsLandscape) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (i2 < 4) {
                    this.hdb.addView(this.hcQ.get(i2));
                } else {
                    this.hdc.addView(this.hcQ.get(i2));
                }
            }
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 6) {
                this.hdb.addView(this.hcQ.get(i3));
            }
        }
    }

    public void show() {
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
        } else if (!com.baidu.tbadk.coreExtra.c.e.Kl()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_share_install_failure);
        } else {
            bzB();
            this.awt = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
            this.awt.setCanceledOnTouchOutside(true);
            this.awt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            this.awt.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (b.this.onCancelListener != null) {
                        b.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.awt, (Activity) this.mContext);
            }
            Window window = this.awt.getWindow();
            window.setWindowAnimations(e.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bzC();
            acl();
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
        if (this.awt != null) {
            this.hcT = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.awt);
                }
                g.b(this.awt, (Activity) this.mContext);
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
        if (this.hcS.size() != 0) {
            if (view.getId() == e.g.btnShareCancel || !this.hcT) {
                this.hcT = true;
                d uS = uS(1);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
                if (id == e.g.btnShareCancel) {
                    l("share_cancel", new Object[0]);
                    if (uS != null && uS.aSe) {
                        a(uS, 16);
                    }
                    dismiss();
                } else if (i == e.f.icon_weixin) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_weixin", new Object[0]);
                    uT(3);
                    d uS2 = uS(3);
                    a(uS2, 4);
                    if (uS2 != null) {
                        eVar.b(uS2);
                    }
                } else if (i == e.f.icon_weixin_q) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_pyq", new Object[0]);
                    uT(2);
                    d uS3 = uS(2);
                    a(uS3, 3);
                    if (uS3 != null) {
                        if (uS3.aRZ) {
                            uS3.content = "【" + uS3.title + "】 " + uS3.content;
                        }
                        eVar.c(uS3);
                    }
                } else if (i == e.f.icon_qq_zone) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qzone", new Object[0]);
                        uT(4);
                        d uS4 = uS(4);
                        a(uS4, 5);
                        if (uS4 != null) {
                            eVar.e(uS4);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
                    }
                } else if (i == e.f.icon_qq_weibo) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_qweibo", new Object[0]);
                    uT(5);
                    d uS5 = uS(5);
                    a(uS5, 6);
                    if (uS5 != null) {
                        if (!uS5.aRY) {
                            uS5.content = m(uS5);
                        }
                        eVar.f(uS5);
                    }
                } else if (i == e.f.icon_sina) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_sweibo", new Object[0]);
                    uT(6);
                    d uS6 = uS(6);
                    a(uS6, 7);
                    if (uS6 != null) {
                        if (!uS6.aRY) {
                            uS6.content = m(uS6);
                        }
                        eVar.g(uS6);
                    }
                } else if (i == e.f.icon_renren) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                        return;
                    }
                    l("share_to_renren", new Object[0]);
                    uT(7);
                    d uS7 = uS(7);
                    a(uS7, 8);
                    if (uS7 != null) {
                        if (!uS7.aRY) {
                            uS7.content = m(uS7);
                        }
                        eVar.h(uS7);
                    }
                } else if (i == e.f.icon_qq_share) {
                    if (!j.kV()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                    } else if (com.baidu.tieba.tbadkCore.u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        l("share_to_qq_friend", new Object[0]);
                        uT(8);
                        d uS8 = uS(8);
                        a(uS8, 9);
                        if (uS8 != null) {
                            eVar.d(uS8);
                        }
                    } else {
                        BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
                    }
                } else if (i == e.f.icon_download_n) {
                    if (this.bzi == null) {
                        this.bzi = new com.baidu.tbadk.core.util.b.a();
                    }
                    this.bzi.Et();
                    this.bzi.c((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.bzi.A((Activity) this.mContext)) {
                        a(uS, 17);
                        final String uri = uS.imageUri.toString();
                        c.jA().a(uri, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.d.b.4
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.f.b
                            public void onLoaded(final com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                                super.onLoaded((AnonymousClass4) aVar, str, i2);
                                new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tieba.sharesdk.d.b.4.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                                    public String doInBackground(String... strArr) {
                                        String string = b.this.mContext.getString(e.j.save_fail);
                                        if (aVar != null) {
                                            int a2 = com.baidu.tbadk.core.util.l.a(uri, aVar.os(), b.this.mContext);
                                            if (a2 == 0) {
                                                return b.this.mContext.getString(e.j.save_image_to_album);
                                            }
                                            if (a2 == -2) {
                                                return com.baidu.tbadk.core.util.l.CH();
                                            }
                                            return string;
                                        }
                                        return string;
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                                    public void onPostExecute(String str2) {
                                        l.showToast(b.this.mContext, str2);
                                    }
                                }.execute(new String[0]);
                            }
                        }, getPageId());
                    }
                } else if (i == e.f.icon_copy_link) {
                    a(uS, 10);
                    if (this.hcR != null) {
                        this.hcR.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.bg(uS.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                    }
                    n(uS);
                    if (uS != null && uS.aRY) {
                        ag(8, uS.aSk);
                    }
                }
            }
        }
    }

    private void n(d dVar) {
        am x = new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aSo != 0) {
            x.x("obj_param1", dVar.aSo);
            if (dVar.aSo == 2) {
                x.aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aSo == 3) {
                if (dVar.aSp != 0) {
                    x.x("obj_type", dVar.aSp);
                }
                x.aA("tid", dVar.tid).aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(x);
    }

    private d uS(int i) {
        d dVar = this.hcS.get(i);
        if (dVar == null) {
            return this.hcS.get(1);
        }
        return dVar;
    }

    private void uT(int i) {
        if (i <= 8 && i > 0) {
            this.hcT = true;
            if (this.hcV != null) {
                u uVar = this.hcV.get(i);
                if (!StringUtils.isNull(uVar.GT()) && uVar.GU() != null && uVar.GU().size() > 0) {
                    l(uVar.GT(), uVar.GU());
                    return;
                }
            }
            if (this.hcU != null) {
                String str = this.hcU.get(i);
                if (!ao.isEmpty(str)) {
                    l(str, new Object[0]);
                }
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void ag(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aRZ) {
                TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aSa || dVar.aSd) {
                TiebaStatic.log(new am("c10125").aA("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSn).x("obj_param1", dVar.aSo).aA(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSb) {
                TiebaStatic.log(new am("c10427").aA("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aRY) {
                ag(i, dVar.aSk);
            } else if (dVar.aSc) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).aA(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSe) {
                am x = new am("c10125").x("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl)) {
                    if (dVar.linkUrl.contains("worldcup")) {
                        x.x("obj_param1", 9);
                    }
                    x.aA("obj_url", dVar.linkUrl);
                }
                TiebaStatic.log(x);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void bzC() {
        int size = this.hcQ.size();
        for (int i = 0; i < size; i++) {
            View view = this.hcQ.get(i);
            if (view instanceof TextView) {
                a((TextView) view, ((Integer) view.getTag()).intValue(), e.d.cp_cont_j);
            }
        }
        al.i(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.hcY, e.d.cp_cont_j, 1);
        d uS = uS(1);
        if (uS != null && StringUtils.isNull(uS.aSg)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hcY.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 23, 30, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 23, 30, 33);
            }
            this.hcY.setText(spannableStringBuilder);
        }
        al.c(this.hcO, e.d.cp_cont_b, 1);
        al.i(this.hcO, e.f.dialog_share_cancel_button_bg_selector);
        al.i(this.mLine, e.d.cp_bg_line_a);
        al.i(this.dzT, e.d.cp_bg_line_a);
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

    private boolean uU(int i) {
        return (i & 1) > 0;
    }

    private boolean uV(int i) {
        return (i & 2) > 0;
    }

    private boolean uY(int i) {
        return (i & 4) > 0;
    }

    private boolean uW(int i) {
        return (i & 8) > 0;
    }

    private boolean uX(int i) {
        return (i & 16) > 0;
    }

    private boolean uZ(int i) {
        return (i & 32) > 0;
    }

    protected BdUniqueId getPageId() {
        h aI = i.aI(this.mContext);
        if (aI != null) {
            return aI.getUniqueId();
        }
        return null;
    }
}
