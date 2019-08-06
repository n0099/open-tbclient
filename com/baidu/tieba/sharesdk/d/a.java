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
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final TextView iVJ;
    private ShareGridLayout iVL;
    private View.OnClickListener iVN;
    private SparseArray<String> iVQ;
    private SparseArray<v> iVR;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private static final int dUU = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int dSm = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iVG = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iVH = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iVI = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int clx = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<e> iVO = new SparseArray<>(8);
    private boolean iVP = false;
    private final List<View> iVM = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView iVK = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.iVK.setText(sharePanelText);
        }
        this.iVL = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.iVL.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.jtG;
            marginLayoutParams.rightMargin = ShareGridLayout.jtG;
            this.iVL.setLayoutParams(marginLayoutParams);
        }
        this.iVL.setItemParams(dUU, dSm);
        this.iVJ = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.iVJ.setOnClickListener(this);
        if (!Az(i)) {
            ct(R.string.share_weixin, R.drawable.icon_share_wechat_selector);
        }
        if (!AA(i)) {
            ct(R.string.share_weixin_timeline, R.drawable.icon_share_circle_selector);
        }
        if (!AB(i)) {
            ct(R.string.share_qq_friends, R.drawable.icon_share_qq_selector);
        }
        if (!AC(i)) {
            ct(R.string.share_sina_weibo, R.drawable.icon_share_weibo_selector);
        }
        if (!f.aqc()) {
            this.iVL.setVisibility(8);
        }
    }

    private void aLx() {
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iVG, iVG);
        layoutParams.topMargin = iVH;
        layoutParams.bottomMargin = iVI;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, clx);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.iVM.add(linearLayout);
    }

    public LinearLayout cu(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iVG, iVG);
        layoutParams.topMargin = iVH;
        layoutParams.bottomMargin = iVI;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, clx);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int cmo() {
        if (this.iVM == null) {
            return 0;
        }
        return this.iVM.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.iVM.size() && i >= 0) {
            this.iVM.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0407a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class View$OnClickListenerC0407a implements View.OnClickListener {
        private View.OnClickListener iVT;

        public View$OnClickListenerC0407a(View.OnClickListener onClickListener) {
            this.iVT = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.iVT != null) {
                this.iVT.onClick(view);
            }
        }
    }

    public void a(e eVar, boolean z) {
        Location bbJ;
        if (z && (bbJ = bbJ()) != null) {
            eVar.ckN = bbJ;
        }
        this.iVO.put(1, eVar);
    }

    private Location bbJ() {
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
            this.iVN = onClickListener;
        }
    }

    public void cmp() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iVM.size()) {
                this.iVL.addView(this.iVM.get(i2), new ViewGroup.LayoutParams(dUU, dSm));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.kc()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
        } else if (!f.aqc()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
        } else {
            cmp();
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
            cmq();
            aLx();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.iVP = false;
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
        if (this.iVO.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.iVP) {
                this.iVP = true;
                f fVar = new f(this.mContext, null);
                e Ax = Ax(1);
                if (id == R.id.btnShareCancel) {
                    k("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == R.drawable.icon_share_wechat_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_weixin", new Object[0]);
                    Ay(3);
                    e Ax2 = Ax(3);
                    a(Ax2, 4);
                    if (Ax2 != null) {
                        fVar.e(Ax2);
                    }
                } else if (i == R.drawable.icon_share_circle_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_pyq", new Object[0]);
                    Ay(2);
                    e Ax3 = Ax(2);
                    a(Ax3, 3);
                    if (Ax3 != null) {
                        if (Ax3.cky) {
                            Ax3.content = "【" + Ax3.title + "】 " + Ax3.content;
                        }
                        fVar.f(Ax3);
                    }
                } else if (i == R.drawable.icon_qq_zone) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qzone", new Object[0]);
                        Ay(4);
                        e Ax4 = Ax(4);
                        a(Ax4, 5);
                        if (Ax4 != null) {
                            fVar.h(Ax4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agS();
                    }
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_qweibo", new Object[0]);
                    Ay(5);
                    e Ax5 = Ax(5);
                    a(Ax5, 6);
                    if (Ax5 != null) {
                        if (!Ax5.ckx) {
                            Ax5.content = p(Ax5);
                        }
                        fVar.i(Ax5);
                    }
                } else if (i == R.drawable.icon_share_weibo_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_sweibo", new Object[0]);
                    Ay(6);
                    e Ax6 = Ax(6);
                    a(Ax6, 7);
                    if (Ax6 != null) {
                        if (!Ax6.ckx) {
                            Ax6.content = p(Ax6);
                        }
                        fVar.j(Ax6);
                    }
                } else if (i == R.drawable.icon_renren) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                        return;
                    }
                    k("share_to_renren", new Object[0]);
                    Ay(7);
                    e Ax7 = Ax(7);
                    a(Ax7, 8);
                    if (Ax7 != null) {
                        if (!Ax7.ckx) {
                            Ax7.content = p(Ax7);
                        }
                        fVar.k(Ax7);
                    }
                } else if (i == R.drawable.icon_share_qq_selector) {
                    if (!j.kc()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    } else if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        k("share_to_qq_friend", new Object[0]);
                        Ay(8);
                        e Ax8 = Ax(8);
                        a(Ax8, 9);
                        if (Ax8 != null) {
                            fVar.g(Ax8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agS();
                    }
                } else if (i == R.drawable.icon_copy_link) {
                    a(Ax, 10);
                    if (this.iVN != null) {
                        this.iVN.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.aS(Ax.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    q(Ax);
                    if (Ax != null && Ax.ckx) {
                        aD(8, Ax.ckO);
                    }
                }
            }
        }
    }

    private void q(e eVar) {
        an P = new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.ckS != 0) {
            P.P("obj_param1", eVar.ckS);
            if (eVar.ckS == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.ckS == 3) {
                if (eVar.ckW != 0) {
                    P.P("obj_type", eVar.ckW);
                }
                P.bT("tid", eVar.tid).bT("fid", eVar.fid);
            }
        }
        TiebaStatic.log(P);
    }

    private e Ax(int i) {
        e eVar = this.iVO.get(i);
        if (eVar == null) {
            return this.iVO.get(1);
        }
        return eVar;
    }

    private void Ay(int i) {
        if (i <= 8 && i > 0) {
            this.iVP = true;
            if (this.iVR != null) {
                v vVar = this.iVR.get(i);
                if (!StringUtils.isNull(vVar.amD()) && vVar.amE() != null && vVar.amE().size() > 0) {
                    k(vVar.amD(), vVar.amE());
                    return;
                }
            }
            if (this.iVQ != null) {
                String str = this.iVQ.get(i);
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
            if (eVar.cky) {
                TiebaStatic.log(new an("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.ckz || eVar.ckC) {
                TiebaStatic.log(new an("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.ckR).P("obj_param1", eVar.ckS).bT("fid", eVar.fid));
            } else if (eVar.ckA) {
                TiebaStatic.log(new an("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.ckx) {
                aD(i, eVar.ckO);
            } else if (eVar.ckB) {
                TiebaStatic.log(new an("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            } else if (eVar.ckD) {
                an P = new an("c10125").P("obj_type", i);
                if (!aq.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    P.P("obj_param1", 9);
                }
                TiebaStatic.log(P);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cmq() {
    }

    private String p(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private boolean Az(int i) {
        return (i & 1) > 0;
    }

    private boolean AA(int i) {
        return (i & 2) > 0;
    }

    private boolean AB(int i) {
        return (i & 8) > 0;
    }

    private boolean AC(int i) {
        return (i & 16) > 0;
    }
}
