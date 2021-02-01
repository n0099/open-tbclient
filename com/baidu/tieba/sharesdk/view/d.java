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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public class d implements View.OnClickListener {
    private static final int hIE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hIF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    protected final View bUP;
    private float eVC;
    private boolean eVE;
    private CustomMessageListener eVF;
    private int hideMode;
    private final Context mContext;
    private AlertDialog mDialog;
    private boolean mIsLandscape;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private PermissionJudgePolicy mPermissionJudgement;
    protected final View mRootView;
    protected final List<View> nkA;
    private View.OnClickListener nkB;
    protected final SparseArray<ShareItem> nkC;
    private boolean nkD;
    private SparseArray<String> nkE;
    private SparseArray<af> nkF;
    private final TextView nky;
    private ShareGridLayout nkz;
    private final EMTextView nli;
    private boolean nlj;
    private int nlk;
    private int nll;
    private DialogInterface.OnCancelListener onCancelListener;

    public d(Context context, boolean z, int i) {
        this.eVC = 0.33f;
        this.nkC = new SparseArray<>(8);
        this.nkD = false;
        this.nlj = true;
        this.nlk = 0;
        this.mIsLandscape = false;
        this.nll = 1;
        this.eVE = true;
        this.eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.sharesdk.view.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    d.this.dJt();
                    d.this.nkz.removeAllViews();
                    d.this.dJs();
                }
            }
        };
        this.hideMode = 0;
        this.hideMode = i;
        this.mContext = context;
        this.mIsLandscape = z;
        this.nkA = new ArrayList();
        this.mRootView = cFT();
        this.bUP = this.mRootView.findViewById(R.id.share_dialog_main_view);
        this.nky = (TextView) this.mRootView.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.nky.setText(sharePanelText);
        }
        this.nkz = (ShareGridLayout) this.mRootView.findViewById(R.id.share_grid_layout);
        ViewGroup.LayoutParams layoutParams = this.nkz.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = ShareGridLayout.nIW;
            marginLayoutParams.rightMargin = ShareGridLayout.nIW;
            this.nkz.setLayoutParams(marginLayoutParams);
        }
        this.nkz.setItemParams(hIE, hIF);
        this.nli = (EMTextView) this.mRootView.findViewById(R.id.btnShareCancel);
        this.nli.setOnClickListener(this);
    }

    protected View cFT() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    public d(Context context) {
        this(context, false, 0);
    }

    private void bWS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sharesdk.view.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.mDialog != null && d.this.mDialog.isShowing()) {
                    d.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dJz() {
        ArrayList arrayList = new ArrayList(this.nkA);
        this.nkA.clear();
        if (!IU(this.hideMode)) {
            a(R.string.share_weixin, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!IV(this.hideMode)) {
            a(R.string.share_weixin_timeline, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!IW(this.hideMode)) {
            a(R.string.share_qq_friends, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!IZ(this.hideMode)) {
            a(R.string.share_qzone, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!IX(this.hideMode)) {
            a(R.string.share_sina_weibo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (Ja(this.hideMode)) {
            dp(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.nkA.addAll(arrayList);
        }
        if (this.nlj) {
            dp(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nkA.add(shareDialogItemView.dJw());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dp(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nkA.add(shareDialogItemView.dJw());
    }

    /* renamed from: do  reason: not valid java name */
    public LinearLayout m47do(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        return shareDialogItemView.dJw();
    }

    public int dJr() {
        if (this.nkA == null) {
            return 0;
        }
        return this.nkA.size();
    }

    public void a(View view, int i, View.OnClickListener onClickListener) {
        if (i <= this.nkA.size() && i >= 0) {
            this.nkA.add(i, view);
            if (onClickListener != null) {
                view.setOnClickListener(new a(onClickListener));
            }
        }
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        private View.OnClickListener nkH;

        public a(View.OnClickListener onClickListener) {
            this.nkH = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
            if (this.nkH != null) {
                this.nkH.onClick(view);
            }
        }
    }

    public void setIsCopyLink(boolean z) {
        this.nlj = z;
    }

    public void setCustomCopyTitle(int i) {
        this.nlk = i;
    }

    public void j(SparseArray<String> sparseArray) {
        this.nkE = sparseArray;
    }

    public void a(ShareItem shareItem, boolean z) {
        Location ctF;
        if (z && (ctF = ctF()) != null) {
            shareItem.location = ctF;
        }
        this.nkC.put(1, shareItem);
        if (!StringUtils.isNull(shareItem.fuS)) {
            this.nky.setText(shareItem.fuS);
        }
    }

    public void b(int i, ShareItem shareItem, boolean z) {
        Location ctF;
        if (z && (ctF = ctF()) != null) {
            shareItem.location = ctF;
        }
        this.nkC.put(i, shareItem);
    }

    private Location ctF() {
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
            this.nkB = onClickListener;
        }
    }

    public void dJs() {
        if (!dJv()) {
            dJz();
            if (!g.bzj()) {
                this.nkz.setVisibility(8);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nkA.size()) {
                    this.nkz.addView(this.nkA.get(i2), new ViewGroup.LayoutParams(hIE, hIF));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dJv() {
        return false;
    }

    public void show() {
        if (!j.isNetWorkAvailable()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.bzj()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            dJs();
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.sharesdk.view.d.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (d.this.mOnDismissListener != null) {
                        d.this.mOnDismissListener.onDismiss(dialogInterface);
                    }
                    MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharesdk.view.d.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (d.this.onCancelListener != null) {
                        d.this.onCancelListener.onCancel(dialogInterface);
                    }
                }
            });
            if (this.mContext instanceof Activity) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, (Activity) this.mContext);
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.bUP).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                if (this.eVE) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                } else {
                    window.setWindowAnimations(R.style.normal_dialog_style);
                }
                window.setGravity(80);
                d(window);
                window.setContentView(this.mRootView);
                window.setDimAmount(this.eVC);
                dJt();
                bWS();
                com.baidu.adp.base.j.K(this.mContext).registerListener(this.eVF);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
            }
        }
    }

    protected void d(Window window) {
        window.setLayout(-1, -2);
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void g(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            this.nkD = false;
            if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    this.mOnDismissListener.onDismiss(this.mDialog);
                }
                com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, (Activity) this.mContext);
                MessageManager.getInstance().unRegisterListener(this.eVF);
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
        if (id != R.id.btnShareCancel && i != R.drawable.icon_pure_share_copy40 && dJA()) {
            this.nkD = false;
            return;
        }
        if (i != R.drawable.icon_pure_share_download40) {
            dismiss();
        }
        if (this.nkC.size() != 0) {
            if (id == R.id.btnShareCancel || !this.nkD) {
                this.nkD = true;
                ShareItem IS = IS(1);
                g gVar = new g(this.mContext, null);
                if (IS != null && IS.fvn) {
                    TiebaStatic.log(new ar("c13531").dR("obj_id", IS.fvo).ap("obj_type", IS.fvp).dR("obj_source", IS.fvq));
                }
                if (id == R.id.btnShareCancel) {
                    f("share_cancel", new Object[0]);
                    if (IS != null && IS.fuL) {
                        a(IS, 16);
                    }
                    if (this.onCancelListener != null) {
                        this.onCancelListener.onCancel(this.mDialog);
                        return;
                    }
                    return;
                }
                ar arVar = new ar("c13724");
                if (i == R.drawable.icon_mask_share_wechat40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_weixin", new Object[0]);
                    IT(3);
                    ShareItem IS2 = IS(3);
                    a(IS2, 4);
                    if (IS2 != null) {
                        if (l(IS2) && IS2.getCommandChannelArray() != null && IS2.getCommandChannelArray().contains(3)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IS2, this.mContext, 3, this.onCancelListener);
                        } else if (IS2.fvl == 1) {
                            o(IS2);
                        } else {
                            gVar.e(IS2);
                        }
                    }
                    arVar.ap("obj_type", 2);
                } else if (i == R.drawable.icon_mask_share_circle40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_pyq", new Object[0]);
                    IT(2);
                    ShareItem IS3 = IS(2);
                    a(IS3, 3);
                    if (IS3 != null) {
                        if (l(IS3) && IS3.getCommandChannelArray() != null && IS3.getCommandChannelArray().contains(2)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IS3, this.mContext, 2, this.onCancelListener);
                        } else if (IS3.fvl == 1) {
                            o(IS3);
                        } else {
                            if (IS3.fuG) {
                                IS3.content = "【" + IS3.title + "】 " + IS3.content;
                            }
                            gVar.f(IS3);
                        }
                    }
                    arVar.ap("obj_type", 3);
                } else if (i == R.drawable.icon_mask_share_qqzone40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qzone", new Object[0]);
                        IT(4);
                        ShareItem IS4 = IS(4);
                        a(IS4, 5);
                        if (IS4 != null) {
                            if (l(IS4) && IS4.getCommandChannelArray() != null && IS4.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IS4, this.mContext, 4, this.onCancelListener);
                            } else {
                                gVar.h(IS4);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
                    }
                    arVar.ap("obj_type", 5);
                } else if (i == R.drawable.icon_qq_weibo) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_qweibo", new Object[0]);
                    IT(5);
                    ShareItem IS5 = IS(5);
                    if (IS5 != null) {
                        if (!IS5.fuF) {
                            IS5.content = m(IS5);
                        }
                        gVar.i(IS5);
                    }
                } else if (i == R.drawable.icon_mask_share_weibo40_svg) {
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
                        if (l(IS6) && IS6.getCommandChannelArray() != null && IS6.getCommandChannelArray().contains(4)) {
                            com.baidu.tbadk.coreExtra.share.a.a(IS6, this.mContext, 6, this.onCancelListener);
                        } else {
                            gVar.j(IS6);
                        }
                    }
                    arVar.ap("obj_type", 6);
                } else if (i == R.drawable.icon_renren) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    f("share_to_renren", new Object[0]);
                    IT(7);
                    ShareItem IS7 = IS(7);
                    if (IS7 != null) {
                        if (!IS7.fuF) {
                            IS7.content = m(IS7);
                        }
                        gVar.k(IS7);
                    }
                } else if (i == R.drawable.icon_mask_share_qq40_svg) {
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                        return;
                    }
                    if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                        f("share_to_qq_friend", new Object[0]);
                        IT(8);
                        ShareItem IS8 = IS(8);
                        a(IS8, 9);
                        if (IS8 != null) {
                            if (l(IS8) && IS8.getCommandChannelArray() != null && IS8.getCommandChannelArray().contains(4)) {
                                com.baidu.tbadk.coreExtra.share.a.a(IS8, this.mContext, 8, this.onCancelListener);
                            } else {
                                gVar.g(IS8);
                            }
                        }
                    } else {
                        BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
                    }
                    arVar.ap("obj_type", 4);
                } else if (i == R.drawable.icon_pure_share_download40) {
                    if (this.mPermissionJudgement == null) {
                        this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.mPermissionJudgement.clearRequestPermissionList();
                    this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                        this.nkD = false;
                        return;
                    }
                    dismiss();
                    a(IS, 17);
                    if (o.z(IS.imageUri)) {
                        if (o.copyImageFile(o.getImageRealPathFromUri(this.mContext, IS.imageUri), UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase(), this.mContext) == 0) {
                            l.showToast(this.mContext, "保存成功！");
                        } else {
                            l.showToast(this.mContext, "保存失败！");
                        }
                    } else {
                        String uri = IS.imageUri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            new p(currentActivity, uri, new p.a() { // from class: com.baidu.tieba.sharesdk.view.d.5
                                @Override // com.baidu.tbadk.util.p.a
                                public void onError(int i2, String str) {
                                    l.showToast(d.this.mContext, "保存失败！");
                                }

                                @Override // com.baidu.tbadk.util.p.a
                                public void onSuccess(String str) {
                                    l.showToast(d.this.mContext, "保存成功！");
                                }
                            }).execute(new String[0]);
                        } else {
                            return;
                        }
                    }
                    arVar.ap("obj_type", 1);
                } else if (i == R.drawable.icon_pure_share_copy40) {
                    a(IS, 10);
                    if (this.nkB != null) {
                        this.nkB.onClick(view);
                    } else {
                        com.baidu.adp.lib.util.a.copyToClipboard(IS.linkUrl);
                        l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
                    }
                    n(IS);
                    if (IS != null && IS.fuF) {
                        bV(8, IS.fuU);
                    }
                }
                arVar.ap("obj_source", 6);
                TiebaStatic.log(arVar);
            }
        }
    }

    private boolean l(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.fvs) || TextUtils.isEmpty(shareItem.fvt)) ? false : true;
    }

    private void o(final ShareItem shareItem) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (this.mContext instanceof Activity)) {
            Activity activity = (Activity) this.mContext;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.At(shareItem.title);
            aVar.Au(shareItem.content);
            aVar.setAutoNight(false);
            aVar.jF(true);
            aVar.setTitleShowCenter(true);
            aVar.a(R.string.share_copy, new a.b() { // from class: com.baidu.tieba.sharesdk.view.d.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.content);
                    l.showToast(d.this.mContext.getApplicationContext(), R.string.copy_success);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.share_cancel, new a.b() { // from class: com.baidu.tieba.sharesdk.view.d.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(com.baidu.adp.base.j.K(activity));
            aVar.bqx();
        }
    }

    private void n(ShareItem shareItem) {
        ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ap("obj_source", 7);
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
        ap.ap("obj_locate", 9);
        TiebaStatic.log(ap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem IS(int i) {
        ShareItem shareItem = this.nkC.get(i);
        if (shareItem == null) {
            return this.nkC.get(1);
        }
        return shareItem;
    }

    private void IT(int i) {
        if (i <= 8 && i > 0) {
            this.nkD = true;
            if (this.nkF != null) {
                af afVar = this.nkF.get(i);
                if (!StringUtils.isNull(afVar.bwB()) && afVar.bwC() != null && afVar.bwC().size() > 0) {
                    f(afVar.bwB(), afVar.bwC());
                    return;
                }
            }
            if (this.nkE != null) {
                String str = this.nkE.get(i);
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
        String str;
        if (shareItem != null) {
            if (shareItem.extData == null) {
                if (shareItem.isFromImageViewer) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_type", i).ap("obj_source", shareItem.fuX));
                }
            } else if (shareItem.fuG) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).ap("obj_type", i).ap("obj_source", shareItem.fuX));
            } else if (shareItem.fuH || shareItem.fuK) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).ap("obj_type", i).ap("obj_source", shareItem.fuX).ap("obj_param1", shareItem.fuY).dR("fid", shareItem.fid).ap(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fuZ));
            } else if (shareItem.fuI) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).ap("obj_type", i));
            } else if (shareItem.fuF) {
                bV(i, shareItem.fuU);
            } else if (shareItem.fuJ) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_param1", 7).ap("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fuL) {
                ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_type", i);
                ap.ap("obj_source", shareItem.fuX);
                if (!au.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        ap.ap("obj_param1", 9);
                    }
                    ap.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(ap);
            } else if (shareItem.fuN) {
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
                    str = "6";
                }
                TiebaStatic.log(new ar("c13365").dR("obj_locate", str).dR("topic_id", shareItem.extData));
            } else if (shareItem.fuO) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                arVar.dR("tid", shareItem.extData);
                arVar.dR("post_id", shareItem.pid);
                arVar.ap("obj_source", 18);
                TiebaStatic.log(arVar);
            } else if (shareItem.fuP) {
                ar arVar2 = new ar("c13953");
                arVar2.ap("obj_type", i);
                arVar2.dR("obj_name", shareItem.title);
                TiebaStatic.log(arVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void dJt() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.bUP).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.nky, R.color.CAM_X0108, 1);
        ap.n(this.nli, R.color.CAM_X0107);
    }

    private String m(ShareItem shareItem) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(shareItem.title)) {
            sb.append("【");
            sb.append(shareItem.title);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(shareItem.title)) {
            sb.append(shareItem.content);
        }
        return sb.toString();
    }

    private boolean IU(int i) {
        return (i & 1) > 0;
    }

    private boolean IV(int i) {
        return (i & 2) > 0;
    }

    private boolean IZ(int i) {
        return (i & 4) > 0;
    }

    private boolean IW(int i) {
        return (i & 8) > 0;
    }

    private boolean IX(int i) {
        return (i & 16) > 0;
    }

    private boolean Ja(int i) {
        return (i & 32) > 0;
    }

    public void b(ShareDialogConfig.From from) {
        com.baidu.tbadk.coreExtra.data.ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bwz() && !au.isEmpty(sharePanelConfData.getText())) {
            this.nky.setText(sharePanelConfData.getText());
        }
    }

    public boolean dJA() {
        return this.nll == 2 && bkN();
    }

    private boolean bkN() {
        if (!(this.mContext instanceof Activity)) {
            return false;
        }
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission((Activity) this.mContext);
    }

    public void Jb(int i) {
        this.nll = i;
    }

    public void xY(boolean z) {
        this.eVE = z;
    }
}
