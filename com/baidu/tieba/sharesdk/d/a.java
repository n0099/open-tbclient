package com.baidu.tieba.sharesdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a implements View.OnClickListener {
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final TextView msG;
    private ShareGridLayout msI;
    private View.OnClickListener msK;
    private SparseArray<String> msN;
    private SparseArray<af> msO;
    private static final int gWd = (int) (0.2d * (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)));
    private static final int gWe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int msD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int msE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int msF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eTu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private final SparseArray<ShareItem> msL = new SparseArray<>(8);
    private boolean msM = false;
    private final List<View> msJ = new ArrayList();
    private final View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
    private final TextView msH = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);

    public a(Context context, boolean z, int i) {
        this.mIsLandscape = false;
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.msH.setText(sharePanelText);
        }
        this.msI = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.msI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.mSa;
            marginLayoutParams.rightMargin = ShareGridLayout.mSa;
            this.msI.setLayoutParams(marginLayoutParams);
        }
        this.msI.setItemParams(gWd, gWe);
        this.msG = (TextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.msG.setOnClickListener(this);
        if (!Ip(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!Iq(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!Ir(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!Is(i)) {
            a(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!g.bti()) {
            this.msI.setVisibility(8);
        }
    }

    private void bPb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.d.a.1
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

    private void a(com.baidu.tbadk.core.util.d.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bnv().oO(1).oP(R.color.cp_bg_line_i).bf(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(msD, msD);
            layoutParams.topMargin = msE;
            layoutParams.bottomMargin = msF;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eTu);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
            linearLayout.setOnClickListener(this);
            this.msJ.add(linearLayout);
        }
    }

    public LinearLayout dm(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.bnv().oO(1).oP(R.color.cp_bg_line_i).bf(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(msD, msD);
        layoutParams.topMargin = msE;
        layoutParams.bottomMargin = msF;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, eTu);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.mContext.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public int dAv() {
        if (this.msJ == null) {
            return 0;
        }
        return this.msJ.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.msJ.size() && i >= 0) {
            this.msJ.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new View$OnClickListenerC0814a(onClickListener));
            }
        }
    }

    /* renamed from: com.baidu.tieba.sharesdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class View$OnClickListenerC0814a implements View.OnClickListener {
        private View.OnClickListener msQ;

        public View$OnClickListenerC0814a(View.OnClickListener onClickListener) {
            this.msQ = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (this.msQ != null) {
                this.msQ.onClick(view);
            }
        }
    }

    public void a(ShareItem shareItem, boolean z) {
        Location cjT;
        if (z && (cjT = cjT()) != null) {
            shareItem.location = cjT;
        }
        this.msL.put(1, shareItem);
    }

    private Location cjT() {
        if (ae.checkLocationForGoogle(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
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
            this.msK = onClickListener;
        }
    }

    public void dAw() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.msJ.size()) {
                this.msI.addView(this.msJ.get(i2), new ViewGroup.LayoutParams(gWd, gWe));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bti()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dAw();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.d.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.mOnDismissListener != null) {
                        a.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            this.mRootView.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.mDialog.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            dAx();
            bPb();
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.msM = false;
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
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
        if (this.msL.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.msM) {
                this.msM = true;
                g gVar = new g(this.mContext, null);
                ShareItem In = In(1);
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    dismiss();
                } else if (i == 4) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    Io(3);
                    ShareItem In2 = In(3);
                    a(In2, 4);
                    if (In2 != null) {
                        gVar.f(In2);
                    }
                } else if (i == 3) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    Io(2);
                    ShareItem In3 = In(2);
                    a(In3, 3);
                    if (In3 != null) {
                        if (In3.eSs) {
                            In3.content = "【" + In3.title + "】 " + In3.content;
                        }
                        gVar.g(In3);
                    }
                } else if (i == 5) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        Io(4);
                        ShareItem In4 = In(4);
                        a(In4, 5);
                        if (In4 != null) {
                            gVar.i(In4);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bkP();
                    }
                } else if (i == 6) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    Io(5);
                    ShareItem In5 = In(5);
                    a(In5, 6);
                    if (In5 != null) {
                        if (!In5.eSr) {
                            In5.content = m(In5);
                        }
                        gVar.j(In5);
                    }
                } else if (i == 7) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_sweibo", new Object[0]);
                    Io(6);
                    ShareItem In6 = In(6);
                    a(In6, 7);
                    if (In6 != null) {
                        if (!In6.eSr) {
                            In6.content = m(In6);
                        }
                        gVar.k(In6);
                    }
                } else if (i == 8) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    Io(7);
                    ShareItem In7 = In(7);
                    a(In7, 8);
                    if (In7 != null) {
                        if (!In7.eSr) {
                            In7.content = m(In7);
                        }
                        gVar.l(In7);
                    }
                } else if (i == 9) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    } else if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        Io(8);
                        ShareItem In8 = In(8);
                        a(In8, 9);
                        if (In8 != null) {
                            gVar.h(In8);
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bkP();
                    }
                } else if (i == 10) {
                    a(In, 10);
                    if (this.msK != null) {
                        this.msK.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(In.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(In);
                    if (In != null && In.eSr) {
                        bK(8, In.eSG);
                    }
                }
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).aj("obj_source", 9);
        if (shareItem.eSK != 0) {
            aj.aj("obj_param1", shareItem.eSK);
            if (shareItem.eSK == 2) {
                aj.dK("fid", shareItem.fid);
            } else if (shareItem.eSK == 3) {
                if (shareItem.eSO != 0) {
                    aj.aj("obj_type", shareItem.eSO);
                }
                aj.dK("tid", shareItem.tid).dK("fid", shareItem.fid);
            }
        }
        aj.aj("obj_locate", 7);
        TiebaStatic.log(aj);
    }

    private ShareItem In(int i) {
        ShareItem shareItem = this.msL.get(i);
        if (shareItem == null) {
            return this.msL.get(1);
        }
        return shareItem;
    }

    private void Io(int i) {
        if (i <= 8 && i > 0) {
            this.msM = true;
            if (this.msO != null) {
                af afVar = this.msO.get(i);
                if (!StringUtils.isNull(afVar.bqz()) && afVar.bqA() != null && afVar.bqA().size() > 0) {
                    f(afVar.bqz(), afVar.bqA());
                    return;
                }
            }
            if (this.msN != null) {
                String str = this.msN.get(i);
                if (!at.isEmpty(str)) {
                    f(str, new Object[0]);
                }
            }
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void bK(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eSs) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dK("fid", shareItem.extData).aj("obj_type", i));
            } else if (shareItem.eSt || shareItem.eSw) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dK("tid", shareItem.extData).aj("obj_type", i).aj("obj_source", shareItem.eSJ).aj("obj_param1", shareItem.eSK).dK("fid", shareItem.fid));
            } else if (shareItem.eSu) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dK("tid", shareItem.extData).aj("obj_type", i));
            } else if (shareItem.eSr) {
                bK(i, shareItem.eSG);
            } else if (shareItem.eSv) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_param1", 7).aj("obj_type", i).dK("fid", shareItem.extData));
            } else if (shareItem.eSx) {
                aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_type", i);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    aj.aj("obj_param1", 9);
                }
                TiebaStatic.log(aj);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dAx() {
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private boolean Ip(int i) {
        return (i & 1) > 0;
    }

    private boolean Iq(int i) {
        return (i & 2) > 0;
    }

    private boolean Ir(int i) {
        return (i & 8) > 0;
    }

    private boolean Is(int i) {
        return (i & 16) > 0;
    }
}
