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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView iUF;
    private ShareGridLayout iUH;
    private View.OnClickListener iUJ;
    private SparseArray<String> iUM;
    private SparseArray<v> iUN;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int dUN = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int dSf = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iUC = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iUD = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iUE = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int clq = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iUK = new SparseArray<>(8);
    private boolean iUL = false;
    private final List<View> iUI = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView iUG = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.iUG.setText(sharePanelText);
        }
        this.iUH = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.iUH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.jsz;
            marginLayoutParams.rightMargin = ShareGridLayout.jsz;
            this.iUH.setLayoutParams(marginLayoutParams);
        }
        this.iUH.setItemParams(dUN, dSf);
        this.iUF = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.iUF.setOnClickListener(this);
        if (!Ax(i)) {
            ct(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!Ay(i)) {
            ct(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!Az(i)) {
            ct(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!AA(i)) {
            ct(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!f.aqa()) {
            this.iUH.setVisibility(8);
        }
    }

    private void aLv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.mDialog != null && a.this.mDialog.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void ct(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iUC, iUC);
        layoutParams.topMargin = iUD;
        layoutParams.bottomMargin = iUE;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, clq);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.iUI.add(linearLayout);
    }

    public LinearLayout cu(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iUC, iUC);
        layoutParams.topMargin = iUD;
        layoutParams.bottomMargin = iUE;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, clq);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int clW() {
        if (this.iUI == null) {
            return 0;
        }
        return this.iUI.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iUI.size() && i >= 0) {
            this.iUI.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0401a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0401a implements View.OnClickListener {
        private View.OnClickListener iUP;

        public View$OnClickListenerC0401a(View.OnClickListener onClickListener) {
            this.iUP = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.iUP != null) {
                this.iUP.onClick(view);
            }
        }
    }

    public void a(e eVar, boolean z) {
        Location bbH;
        if (z && (bbH = bbH()) != null) {
            eVar.ckG = bbH;
        }
        this.iUK.put(1, eVar);
    }

    private Location bbH() {
        if (ab.cx(this.mContext)) {
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
            this.iUJ = onClickListener;
        }
    }

    public void clX() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iUI.size()) {
                this.iUH.addView(this.iUI.get(i2), new ViewGroup.LayoutParams(dUN, dSf));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.kc()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aqa()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            clX();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(2001277);
                }
            });
            if (this.mContext instanceof Activity) {
                g.a(this.mDialog, (Activity) this.mContext);
            }
            this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background);
            clY();
            aLv();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iUL = false;
            if (this.mContext instanceof Activity) {
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
        if (this.iUK.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.iUL) {
                this.iUL = true;
                f fVar = new f(this.mContext, null);
                e Av = Av(1);
                if (id == R.id.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    Aw(3);
                    e Av2 = Av(3);
                    a(Av2, 4);
                    if (Av2 != null) {
                        fVar.e(Av2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    Aw(2);
                    e Av3 = Av(2);
                    a(Av3, 3);
                    if (Av3 != null) {
                        if (Av3.ckr) {
                            Av3.content = "【" + Av3.title + "】 " + Av3.content;
                        }
                        fVar.f(Av3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        Aw(4);
                        e Av4 = Av(4);
                        a(Av4, 5);
                        if (Av4 != null) {
                            fVar.h(Av4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agQ();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    Aw(5);
                    e Av5 = Av(5);
                    a(Av5, 6);
                    if (Av5 != null) {
                        if (!Av5.ckq) {
                            Av5.content = p(Av5);
                        }
                        fVar.i(Av5);
                    }
                } else if (i == R.drawable.icon_share_weibo_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    Aw(6);
                    e Av6 = Av(6);
                    a(Av6, 7);
                    if (Av6 != null) {
                        if (!Av6.ckq) {
                            Av6.content = p(Av6);
                        }
                        fVar.j(Av6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    Aw(7);
                    e Av7 = Av(7);
                    a(Av7, 8);
                    if (Av7 != null) {
                        if (!Av7.ckq) {
                            Av7.content = p(Av7);
                        }
                        fVar.k(Av7);
                    }
                } else if (i == R.drawable.icon_share_qq_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        Aw(8);
                        e Av8 = Av(8);
                        a(Av8, 9);
                        if (Av8 != null) {
                            fVar.g(Av8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agQ();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(Av, 10);
                    if (this.iUJ != null) {
                        this.iUJ.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aS(Av.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    q(Av);
                    if (Av != null && Av.ckq) {
                        aD(8, Av.ckH);
                    }
                }
            }
        }
    }

    private void q(e eVar) {
        an P = new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.ckL != 0) {
            P.P("obj_param1", eVar.ckL);
            if (eVar.ckL == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.ckL == 3) {
                if (eVar.ckP != 0) {
                    P.P("obj_type", eVar.ckP);
                }
                P.bT("tid", eVar.tid).bT("fid", eVar.fid);
            }
        }
        TiebaStatic.log(P);
    }

    private e Av(int i) {
        e eVar = this.iUK.get(i);
        if (eVar == null) {
            return this.iUK.get(1);
        }
        return eVar;
    }

    private void Aw(int i) {
        if (i <= 8 && i > 0) {
            this.iUL = true;
            if (this.iUN != null) {
                v vVar = this.iUN.get(i);
                if (!StringUtils.isNull(vVar.amB()) && vVar.amC() != null && vVar.amC().size() > 0) {
                    k(vVar.amB(), vVar.amC());
                    return;
                }
            }
            if (this.iUM != null) {
                String str = this.iUM.get(i);
                if (!aq.isEmpty(str)) {
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
        if (eVar != null && eVar.extData != null) {
            if (eVar.ckr) {
                TiebaStatic.log(new an("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.cks || eVar.ckv) {
                TiebaStatic.log(new an("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.ckK).P("obj_param1", eVar.ckL).bT("fid", eVar.fid));
            } else if (eVar.ckt) {
                TiebaStatic.log(new an("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.ckq) {
                aD(i, eVar.ckH);
            } else if (eVar.cku) {
                TiebaStatic.log(new an("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            } else if (eVar.ckw) {
                an P = new an("c10125").P("obj_type", i);
                if (!aq.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    P.P("obj_param1", 9);
                }
                TiebaStatic.log(P);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void clY() {
    }

    private String p(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private boolean Ax(int i) {
        return (i & 1) > 0;
    }

    private boolean Ay(int i) {
        return (i & 2) > 0;
    }

    private boolean Az(int i) {
        return (i & 8) > 0;
    }

    private boolean AA(int i) {
        return (i & 16) > 0;
    }
}
