package com.baidu.tieba.sharesdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private int hideMode;
    private final TextView iOk;
    private View.OnClickListener iOn;
    private SparseArray<String> iOq;
    private SparseArray<v> iOr;
    private ShareGridLayout iOy;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private DialogInterface.OnCancelListener onCancelListener;
    private static final int dQZ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int dOu = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iOu = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iOv = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iOw = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int cke = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iOo = new SparseArray<>(8);
    private boolean iOp = false;
    private boolean iOz = true;
    private final List<View> iOm = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    private final TextView iOx = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public b(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.iOx.setText(sharePanelText);
        }
        this.iOy = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.iOy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.jms;
            marginLayoutParams.rightMargin = ShareGridLayout.jms;
            this.iOy.setLayoutParams(marginLayoutParams);
        }
        this.iOy.setItemParams(dQZ, dOu);
        this.iOk = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.iOk.setOnClickListener(this);
        if (!zR(i)) {
            cp(R.string.share_weixin, R.drawable.icon_share_wechat_n);
        }
        if (!zS(i)) {
            cp(R.string.share_weixin_timeline, R.drawable.icon_share_circle_n);
        }
        if (!zT(i)) {
            cp(R.string.share_qq_friends, R.drawable.icon_share_qq_n);
        }
        if (!zV(i)) {
            cp(R.string.share_qzone, R.drawable.icon_share_qqzone_n);
        }
        if (!zU(i)) {
            cp(R.string.share_sina_weibo, R.drawable.icon_share_weibo_n);
        }
        if (zW(i)) {
            cp(R.string.share_save_pic, R.drawable.icon_share_photo_album);
        }
        if (!f.aoU()) {
            this.iOy.setVisibility(8);
        }
    }

    private void aJQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (b.this.mDialog != null && b.this.mDialog.isShowing()) {
                    b.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void cp(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iOu, iOu);
        layoutParams.topMargin = iOv;
        layoutParams.bottomMargin = iOw;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cke);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        al.d(imageView, i2);
        al.j(textView, R.color.cp_cont_f);
        linearLayout.setOnClickListener(this);
        this.iOm.add(linearLayout);
    }

    public LinearLayout cq(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iOu, iOu);
        layoutParams.topMargin = iOv;
        layoutParams.bottomMargin = iOw;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cke);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        al.c(imageView, i2);
        al.j(textView, R.color.cp_cont_f);
        return linearLayout;
    }

    public int cjf() {
        if (this.iOm == null) {
            return 0;
        }
        return this.iOm.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iOm.size() && i >= 0) {
            this.iOm.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener iOt;

        public a(View.OnClickListener onClickListener) {
            this.iOt = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (this.iOt != null) {
                this.iOt.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.iOz = z;
    }

    public void f(SparseArray<String> sparseArray) {
        this.iOq = sparseArray;
    }

    public void a(e eVar, boolean z) {
        Location aZI;
        if (z && (aZI = aZI()) != null) {
            eVar.cjB = aZI;
        }
        this.iOo.put(1, eVar);
        if (!StringUtils.isNull(eVar.cjw)) {
            this.iOx.setText(eVar.cjw);
        }
    }

    private Location aZI() {
        if (ab.cw(this.mContext)) {
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
            this.iOn = onClickListener;
        }
    }

    public void cjg() {
        if (this.iOz) {
            cp(R.string.share_copy, R.drawable.icon_share_copy_n);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iOm.size()) {
                this.iOy.addView(this.iOm.get(i2), new ViewGroup.LayoutParams(dQZ, dOu));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.jS()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aoU()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cjg();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.mOnDismissListener != null) {
                        b.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.d.b.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (b.this.onCancelListener != null) {
                        b.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.mDialog, (Activity) this.mContext);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background_1);
            } else {
                this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            }
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.share_dialog_style);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.mRootView);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background_1);
                } else {
                    window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background);
                }
                cjh();
                aJQ();
            }
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iOp = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                g.b(this.mDialog, (Activity) this.mContext);
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
        if (this.iOo.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.iOp) {
                this.iOp = true;
                e zP = zP(1);
                f fVar = new f(this.mContext, null);
                if (id == R.id.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    if (zP != null && zP.cjr) {
                        a(zP, 16);
                    }
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_n) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    zQ(3);
                    e zP2 = zP(3);
                    a(zP2, 4);
                    if (zP2 != null) {
                        if (zP2.cjT == 1) {
                            r(zP2);
                        } else {
                            fVar.e(zP2);
                        }
                    }
                } else if (i == R.drawable.icon_share_circle_n) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    zQ(2);
                    e zP3 = zP(2);
                    a(zP3, 3);
                    if (zP3 != null) {
                        if (zP3.cjT == 1) {
                            r(zP3);
                            return;
                        }
                        if (zP3.cjm) {
                            zP3.content = "【" + zP3.title + "】 " + zP3.content;
                        }
                        fVar.f(zP3);
                    }
                } else if (i == R.drawable.icon_share_qqzone_n) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        zQ(4);
                        e zP4 = zP(4);
                        a(zP4, 5);
                        if (zP4 != null) {
                            fVar.h(zP4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).afO();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    zQ(5);
                    e zP5 = zP(5);
                    a(zP5, 6);
                    if (zP5 != null) {
                        if (!zP5.cjl) {
                            zP5.content = p(zP5);
                        }
                        fVar.i(zP5);
                    }
                } else if (i == R.drawable.icon_share_weibo_n) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    zQ(6);
                    e zP6 = zP(6);
                    a(zP6, 7);
                    if (zP6 != null) {
                        if (!zP6.cjl) {
                            zP6.content = p(zP6);
                        }
                        fVar.j(zP6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    zQ(7);
                    e zP7 = zP(7);
                    a(zP7, 8);
                    if (zP7 != null) {
                        if (!zP7.cjl) {
                            zP7.content = p(zP7);
                        }
                        fVar.k(zP7);
                    }
                } else if (i == R.drawable.icon_share_qq_n) {
                    if (!j.jS()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        zQ(8);
                        e zP8 = zP(8);
                        a(zP8, 9);
                        if (zP8 != null) {
                            fVar.g(zP8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).afO();
                    }
                } else if (i == R.drawable.icon_share_photo_album) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    this.mPermissionJudgement.aiM();
                    this.mPermissionJudgement.e((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!this.mPermissionJudgement.aa((Activity) this.mContext)) {
                        a(zP, 17);
                        String uri = zP.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new n(currentActivity, uri, new n.a() { // from class: com.baidu.tieba.sharesdk.d.b.4
                                @Override // com.baidu.tbadk.util.n.a
                                public void onError(int i2, String str) {
                                    l.showToast(b.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.n.a
                                public void onSuccess(String str) {
                                    l.showToast(b.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        }
                    }
                } else if (i == R.drawable.icon_share_copy_n) {
                    a(zP, 10);
                    if (this.iOn != null) {
                        this.iOn.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aR(zP.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    q(zP);
                    if (zP != null && zP.cjl) {
                        aD(8, zP.cjC);
                    }
                }
            }
        }
    }

    private void r(final e eVar) {
        if (eVar != null && !TextUtils.isEmpty(eVar.content) && !TextUtils.isEmpty(eVar.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.mC(eVar.title);
            aVar.mD(eVar.content);
            aVar.setAutoNight(false);
            aVar.dM(true);
            aVar.dT(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.aR(eVar.content);
                    l.showToast(b.this.mContext.getApplicationContext(), (int) R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.d.b.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(i.ab(activity));
            aVar.afG();
        }
    }

    private void q(e eVar) {
        am P = new am("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.cjG != 0) {
            P.P("obj_param1", eVar.cjG);
            if (eVar.cjG == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.cjG == 3) {
                if (eVar.cjK != 0) {
                    P.P("obj_type", eVar.cjK);
                }
                P.bT("tid", eVar.tid).bT("fid", eVar.fid);
            }
        }
        TiebaStatic.log(P);
    }

    private e zP(int i) {
        e eVar = this.iOo.get(i);
        if (eVar == null) {
            return this.iOo.get(1);
        }
        return eVar;
    }

    private void zQ(int i) {
        if (i <= 8 && i > 0) {
            this.iOp = true;
            if (this.iOr != null) {
                v vVar = this.iOr.get(i);
                if (!StringUtils.isNull(vVar.alw()) && vVar.alx() != null && vVar.alx().size() > 0) {
                    k(vVar.alw(), vVar.alx());
                    return;
                }
            }
            if (this.iOq != null) {
                String str = this.iOq.get(i);
                if (!ap.isEmpty(str)) {
                    k(str, new Object[0]);
                }
            }
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void aD(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(e eVar, int i) {
        String str;
        if (eVar != null && eVar.extData != null) {
            if (eVar.cjm) {
                TiebaStatic.log(new am("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.cjn || eVar.cjq) {
                TiebaStatic.log(new am("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cjF).P("obj_param1", eVar.cjG).bT("fid", eVar.fid));
            } else if (eVar.cjo) {
                TiebaStatic.log(new am("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.cjl) {
                aD(i, eVar.cjC);
            } else if (eVar.cjp) {
                TiebaStatic.log(new am("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            } else if (eVar.cjr) {
                am P = new am("c10125").P("obj_type", i);
                if (!ap.isEmpty(eVar.linkUrl)) {
                    if (eVar.linkUrl.contains("worldcup")) {
                        P.P("obj_param1", 9);
                    }
                    P.bT("obj_url", eVar.linkUrl);
                }
                TiebaStatic.log(P);
            } else if (eVar.cjt) {
                if (i == 3) {
                    str = "1";
                } else if (i == 4) {
                    str = "2";
                } else if (i == 9) {
                    str = "4";
                } else if (i == 5) {
                    str = "3";
                } else if (i == 7) {
                    str = "5";
                } else {
                    str = Constants.VIA_SHARE_TYPE_INFO;
                }
                TiebaStatic.log(new am("c13365").bT("obj_locate", str).bT("topic_id", eVar.extData));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cjh() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            al.k(this.mRootView, R.drawable.transmit_share_dialog_background_1);
        } else {
            al.k(this.mRootView, R.drawable.transmit_share_dialog_background);
        }
        al.f(this.iOx, R.color.cp_cont_c, 1);
        al.f(this.iOk, R.color.cp_cont_j, 1);
    }

    private String p(e eVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(eVar.title)) {
            sb.append("【");
            sb.append(eVar.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(eVar.title)) {
            sb.append(eVar.content);
        }
        return sb.toString();
    }

    private boolean zR(int i) {
        return (i & 1) > 0;
    }

    private boolean zS(int i) {
        return (i & 2) > 0;
    }

    private boolean zV(int i) {
        return (i & 4) > 0;
    }

    private boolean zT(int i) {
        return (i & 8) > 0;
    }

    private boolean zU(int i) {
        return (i & 16) > 0;
    }

    private boolean zW(int i) {
        return (i & 32) > 0;
    }
}
