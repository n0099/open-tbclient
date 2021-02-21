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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final TextView nkX;
    private ShareGridLayout nkZ;
    private View.OnClickListener nlb;
    private SparseArray<String> nle;
    private SparseArray<af> nlf;
    private static final int hIS = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int hIT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int nkU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nkV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int nkW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int fvH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> nlc = new SparseArray<>(8);
    private boolean nld = false;
    private final List<View> nla = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView nkY = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nkY.setText(sharePanelText);
        }
        this.nkZ = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nkZ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nJw;
            marginLayoutParams.rightMargin = ShareGridLayout.nJw;
            this.nkZ.setLayoutParams(marginLayoutParams);
        }
        this.nkZ.setItemParams(hIS, hIT);
        this.nkX = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.nkX.setOnClickListener(this);
        if (!IU(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!IV(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!IW(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!IX(i)) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bzj()) {
            this.nkZ.setVisibility(8);
        }
    }

    private void bWZ() {
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
                com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0213).bv(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nkU, nkU);
            layoutParams.topMargin = nkV;
            layoutParams.bottomMargin = nkW;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, fvH);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.nla.add(linearLayout);
        }
    }

    public LinearLayout dp(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0213).bv(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nkU, nkU);
        layoutParams.topMargin = nkV;
        layoutParams.bottomMargin = nkW;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, fvH);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dJz() {
        if (this.nla == null) {
            return 0;
        }
        return this.nla.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nla.size() && i >= 0) {
            this.nla.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0866a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class View$OnClickListenerC0866a implements View.OnClickListener {
        private View.OnClickListener nlh;

        public View$OnClickListenerC0866a(View.OnClickListener onClickListener) {
            this.nlh = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.nlh != null) {
                this.nlh.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location ctM;
        if (z && (ctM = ctM()) != null) {
            shareItem.location = ctM;
        }
        this.nlc.put(1, shareItem);
    }

    private Location ctM() {
        if (ae.checkLocationForGoogle(this.mContext)) {
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
            this.nlb = onClickListener;
        }
    }

    public void dJA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.nla.size()) {
                this.nkZ.addView(this.nla.get(i2), new ViewGroup.LayoutParams(hIS, hIT));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bzj()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dJA();
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
            dJB();
            bWZ();
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
            this.nld = false;
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
        if (this.nlc.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.nld) {
                this.nld = true;
                g gVar = new g(this.mContext, null);
                ShareItem IS = IS(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    IT(3);
                    ShareItem IS2 = IS(3);
                    a(IS2, 4);
                    if (IS2 != null) {
                        gVar.e(IS2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IT(2);
                    ShareItem IS3 = IS(2);
                    a(IS3, 3);
                    if (IS3 != null) {
                        if (IS3.fuG) {
                            IS3.content = "【" + IS3.title + "】 " + IS3.content;
                        }
                        gVar.f(IS3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IT(4);
                        ShareItem IS4 = IS(4);
                        a(IS4, 5);
                        if (IS4 != null) {
                            gVar.h(IS4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IT(5);
                    ShareItem IS5 = IS(5);
                    a(IS5, 6);
                    if (IS5 != null) {
                        if (!IS5.fuF) {
                            IS5.content = m(IS5);
                        }
                        gVar.i(IS5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    IT(6);
                    ShareItem IS6 = IS(6);
                    a(IS6, 7);
                    if (IS6 != null) {
                        if (!IS6.fuF) {
                            IS6.content = m(IS6);
                        }
                        gVar.j(IS6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IT(7);
                    ShareItem IS7 = IS(7);
                    a(IS7, 8);
                    if (IS7 != null) {
                        if (!IS7.fuF) {
                            IS7.content = m(IS7);
                        }
                        gVar.k(IS7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IT(8);
                        ShareItem IS8 = IS(8);
                        a(IS8, 9);
                        if (IS8 != null) {
                            gVar.g(IS8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
                    }
                } else if (i == 10) {
                    a(IS, 10);
                    if (this.nlb != null) {
                        this.nlb.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(IS.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(IS);
                    if (IS != null && IS.fuF) {
                        bV(8, IS.fuU);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ap("obj_source", 9);
        if (shareItem.fuY != 0) {
            ap.ap("obj_param1", shareItem.fuY);
            if (shareItem.fuY == 2) {
                ap.dR("fid", shareItem.fid);
            } else if (shareItem.fuY == 3) {
                if (shareItem.fvc != 0) {
                    ap.ap("obj_type", shareItem.fvc);
                }
                ap.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        ap.ap("obj_locate", 7);
        TiebaStatic.log(ap);
    }

    private ShareItem IS(int i) {
        ShareItem shareItem = this.nlc.get(i);
        if (shareItem == null) {
            return this.nlc.get(1);
        }
        return shareItem;
    }

    private void IT(int i) {
        if (i <= 8 && i > 0) {
            this.nld = true;
            if (this.nlf != null) {
                af afVar = this.nlf.get(i);
                if (!StringUtils.isNull(afVar.bwB()) && afVar.bwC() != null && afVar.bwC().size() > 0) {
                    f(afVar.bwB(), afVar.bwC());
                    return;
                }
            }
            if (this.nle != null) {
                String str = this.nle.get(i);
                if (!au.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bV(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fuG) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).ap("obj_type", i));
            } else if (shareItem.fuH || shareItem.fuK) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).ap("obj_type", i).ap("obj_source", shareItem.fuX).ap("obj_param1", shareItem.fuY).dR("fid", shareItem.fid));
            } else if (shareItem.fuI) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).ap("obj_type", i));
            } else if (shareItem.fuF) {
                bV(i, shareItem.fuU);
            } else if (shareItem.fuJ) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_param1", 7).ap("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fuL) {
                ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_type", i);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ap.ap("obj_param1", 9);
                }
                TiebaStatic.log(ap);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dJB() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean IU(int i) {
        return (i & 1) > 0;
    }

    private boolean IV(int i) {
        return (i & 2) > 0;
    }

    private boolean IW(int i) {
        return (i & 8) > 0;
    }

    private boolean IX(int i) {
        return (i & 16) > 0;
    }
}
