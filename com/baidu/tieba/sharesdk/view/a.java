package com.baidu.tieba.sharesdk.view;

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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final TextView naP;
    private ShareGridLayout naR;
    private View.OnClickListener naT;
    private SparseArray<String> naW;
    private SparseArray<af> naX;
    private static final int hEs = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hEt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int naM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int naN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int naO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int ftq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> naU = new SparseArray<>(8);
    private boolean naV = false;
    private final List<View> naS = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView naQ = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.naQ.setText(sharePanelText);
        }
        this.naR = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.naR.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nzl;
            marginLayoutParams.rightMargin = ShareGridLayout.nzl;
            this.naR.setLayoutParams(marginLayoutParams);
        }
        this.naR.setItemParams(hEs, hEt);
        this.naP = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.naP.setOnClickListener(this);
        if (!IA(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!IB(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!IC(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!ID(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.byR()) {
            this.naR.setVisibility(8);
        }
    }

    private void bWo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.view.a.1
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

    private void a(com.baidu.tbadk.core.util.e.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
                com.baidu.tbadk.core.util.f.a.btb().oJ(1).oK(R.color.CAM_X0213).bz(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(naM, naM);
            layoutParams.topMargin = naN;
            layoutParams.bottomMargin = naO;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, ftq);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.naS.add(linearLayout);
        }
    }

    public LinearLayout dr(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btb().oJ(1).oK(R.color.CAM_X0213).bz(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(naM, naM);
        layoutParams.topMargin = naN;
        layoutParams.bottomMargin = naO;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, ftq);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dHg() {
        if (this.naS == null) {
            return 0;
        }
        return this.naS.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.naS.size() && i >= 0) {
            this.naS.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0861a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class View$OnClickListenerC0861a implements View.OnClickListener {
        private View.OnClickListener naZ;

        public View$OnClickListenerC0861a(View.OnClickListener onClickListener) {
            this.naZ = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.naZ != null) {
                this.naZ.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cst;
        if (z && (cst = cst()) != null) {
            shareItem.location = cst;
        }
        this.naU.put(1, shareItem);
    }

    private Location cst() {
        if (ad.checkLocationForGoogle(this.mContext)) {
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
            this.naT = onClickListener;
        }
    }

    public void dHh() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.naS.size()) {
                this.naR.addView(this.naS.get(i2), new ViewGroup.LayoutParams(hEs, hEt));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.byR()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dHh();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.view.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            dHi();
            bWo();
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.naV = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
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
        if (this.naU.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.naV) {
                this.naV = true;
                g gVar = new g(this.mContext, null);
                ShareItem Iy = Iy(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Iz(3);
                    ShareItem Iy2 = Iy(3);
                    a(Iy2, 4);
                    if (Iy2 != null) {
                        gVar.e(Iy2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Iz(2);
                    ShareItem Iy3 = Iy(2);
                    a(Iy3, 3);
                    if (Iy3 != null) {
                        if (Iy3.fso) {
                            Iy3.content = "【" + Iy3.title + "】 " + Iy3.content;
                        }
                        gVar.f(Iy3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Iz(4);
                        ShareItem Iy4 = Iy(4);
                        a(Iy4, 5);
                        if (Iy4 != null) {
                            gVar.h(Iy4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqk();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Iz(5);
                    ShareItem Iy5 = Iy(5);
                    a(Iy5, 6);
                    if (Iy5 != null) {
                        if (!Iy5.fsn) {
                            Iy5.content = m(Iy5);
                        }
                        gVar.i(Iy5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Iz(6);
                    ShareItem Iy6 = Iy(6);
                    a(Iy6, 7);
                    if (Iy6 != null) {
                        if (!Iy6.fsn) {
                            Iy6.content = m(Iy6);
                        }
                        gVar.j(Iy6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Iz(7);
                    ShareItem Iy7 = Iy(7);
                    a(Iy7, 8);
                    if (Iy7 != null) {
                        if (!Iy7.fsn) {
                            Iy7.content = m(Iy7);
                        }
                        gVar.k(Iy7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Iz(8);
                        ShareItem Iy8 = Iy(8);
                        a(Iy8, 9);
                        if (Iy8 != null) {
                            gVar.g(Iy8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqk();
                    }
                } else if (i == 10) {
                    a(Iy, 10);
                    if (this.naT != null) {
                        this.naT.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(Iy.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(Iy);
                    if (Iy != null && Iy.fsn) {
                        bO(8, Iy.fsC);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 9);
        if (shareItem.fsG != 0) {
            an.an("obj_param1", shareItem.fsG);
            if (shareItem.fsG == 2) {
                an.dW("fid", shareItem.fid);
            } else if (shareItem.fsG == 3) {
                if (shareItem.fsK != 0) {
                    an.an("obj_type", shareItem.fsK);
                }
                an.dW("tid", shareItem.tid).dW("fid", shareItem.fid);
            }
        }
        an.an("obj_locate", 7);
        TiebaStatic.log(an);
    }

    private ShareItem Iy(int i) {
        ShareItem shareItem = this.naU.get(i);
        if (shareItem == null) {
            return this.naU.get(1);
        }
        return shareItem;
    }

    private void Iz(int i) {
        if (i <= 8 && i > 0) {
            this.naV = true;
            if (this.naX != null) {
                af afVar = this.naX.get(i);
                if (!StringUtils.isNull(afVar.bwj()) && afVar.bwk() != null && afVar.bwk().size() > 0) {
                    f(afVar.bwj(), afVar.bwk());
                    return;
                }
            }
            if (this.naW != null) {
                String str = this.naW.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bO(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fso) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dW("fid", shareItem.extData).an("obj_type", i));
            } else if (shareItem.fsp || shareItem.fss) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dW("tid", shareItem.extData).an("obj_type", i).an("obj_source", shareItem.fsF).an("obj_param1", shareItem.fsG).dW("fid", shareItem.fid));
            } else if (shareItem.fsq) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dW("tid", shareItem.extData).an("obj_type", i));
            } else if (shareItem.fsn) {
                bO(i, shareItem.fsC);
            } else if (shareItem.fsr) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_param1", 7).an("obj_type", i).dW("fid", shareItem.extData));
            } else if (shareItem.fst) {
                aq an = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).an("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    an.an("obj_param1", 9);
                }
                TiebaStatic.log(an);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dHi() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean IA(int i) {
        return (i & 1) > 0;
    }

    private boolean IB(int i) {
        return (i & 2) > 0;
    }

    private boolean IC(int i) {
        return (i & 8) > 0;
    }

    private boolean ID(int i) {
        return (i & 16) > 0;
    }
}
