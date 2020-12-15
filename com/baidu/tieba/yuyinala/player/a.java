package com.baidu.tieba.yuyinala.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.gift.aj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.utils.l;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.e.b {
    private int availableHeight;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private com.baidu.live.e.a ozG;
    private b ozH;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bJi = true;
    private boolean hRs = false;
    private int huE = -1;
    private CustomMessageListener huF = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.yuyinala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.ozH != null) {
                a.this.ozH.S(false, true);
            }
        }
    };
    private CustomMessageListener hRt = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.yuyinala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ozH != null) {
                a.this.ozH.oA(false);
                a.this.ozH.bZg();
            }
        }
    };
    private CustomMessageListener hdp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.yuyinala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.huE) {
                a.this.huE = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cgX();
                        if (a.this.ozH != null) {
                            a.this.ozH.ox(false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.Ww()) {
                        a.this.cgW();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cgY();
                    }
                    if (a.this.ozH != null) {
                        a.this.ozH.onStart();
                        a.this.ozH.cod();
                    }
                }
            }
        }
    };
    private CustomMessageListener hRu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.yuyinala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.cns();
            }
        }
    };
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.yuyinala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cgX();
                    if (a.this.ozH != null) {
                        a.this.ozH.ox(false);
                    }
                } else if (a.this.ozH != null) {
                    if (a.this.ozH.cnM()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.Ww()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cgW();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && l.Ww()) {
                        a.this.cgW();
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    @Override // com.baidu.live.e.b
    public void a(TbPageContext tbPageContext, com.baidu.live.e.a aVar) {
        this.mPageContext = tbPageContext;
        this.ozG = aVar;
        init();
    }

    private void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.hRs = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.h.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.hRs = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.huF);
        MessageManager.getInstance().registerListener(this.hRt);
        MessageManager.getInstance().registerListener(this.hdp);
        MessageManager.getInstance().registerListener(this.hRu);
        MessageManager.getInstance().registerListener(this.byv);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.Gi().bA(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cgR();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.ozH = new b(getPageContext(), this);
            this.ozH.aw(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cgR() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.player.a.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                a.this.b(false, false, -1L);
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    @Override // com.baidu.live.e.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.ozH != null) {
            this.ozH.dX(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.yuyinala.player.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(a.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(a.this.getPageContext().getPageActivity());
                boolean z = a.this.availableHeight != rect.bottom;
                a.this.availableHeight = rect.bottom;
                if (a.this.mLastScreenHeight != screenFullSize[1]) {
                    if (a.this.ozH != null) {
                        a.this.ozH.cnU();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.ozH != null) {
                        a.this.ozH.cnU();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bJi)) {
                    a.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    @Override // com.baidu.live.e.b
    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.ozH != null) {
            if (realScreenOrientation == 2) {
                this.ozH.cnV();
            } else {
                this.ozH.cnW();
            }
        }
    }

    @Override // com.baidu.live.e.b
    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bJi = true;
        if (this.ozH != null) {
            this.ozH.onResume();
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void cgW() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgX() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    @Override // com.baidu.live.e.b
    public void onStart() {
        if (this.ozH != null) {
            this.ozH.oC(false);
            this.ozH.onStart();
        }
    }

    @Override // com.baidu.live.e.b
    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.hRs) {
            this.bJi = false;
            if (this.ozH != null) {
                this.ozH.onPause();
            }
        }
    }

    @Override // com.baidu.live.e.b
    public void onStop() {
        if (this.ozH != null) {
            this.ozH.oC(true);
            this.ozH.ox(true);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    @Override // com.baidu.live.e.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.ozH != null && this.ozH.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ozH != null) {
            this.ozH.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.e.b
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ozH != null) {
            this.ozH.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cns() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ozH != null) {
                        a.this.ozH.nn(true);
                        a.this.ozH.cnL();
                        a.this.ozH.cnu();
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        com.baidu.live.ag.a.b.Sm().release();
        aj.Iy();
        com.baidu.live.entereffect.a.Gi().release();
        if (this.ozH != null) {
            this.ozH.coc();
        }
        if (this.ozG != null) {
            this.ozG.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.live.e.b
    public void onDestroy() {
        if (this.hRs) {
            MessageManager.getInstance().unRegisterListener(this.hRt);
            MessageManager.getInstance().unRegisterListener(this.huF);
            MessageManager.getInstance().unRegisterListener(this.hdp);
            MessageManager.getInstance().unRegisterListener(this.hRu);
            MessageManager.getInstance().unRegisterListener(this.byv);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.ozH != null) {
                this.ozH.destroy();
                this.ozH = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }

    @Override // com.baidu.live.e.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (TextUtils.equals(PermissionRequest.RESOURCE_AUDIO_CAPTURE, strArr[i2]) && iArr.length > i2 && iArr[i2] == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501046));
                }
                if (TextUtils.equals("android.permission.WRITE_EXTERNAL_STORAGE", strArr[i2]) && iArr.length > i2 && iArr[i2] == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501061));
                }
            }
        }
    }
}
