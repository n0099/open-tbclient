package com.baidu.tieba.yuyinala.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import com.baidu.live.ab.c;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.gift.ai;
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
public class a implements com.baidu.live.c.b {
    private int availableHeight;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private com.baidu.live.c.a oae;
    private b oaf;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bzA = true;
    private boolean hCf = false;
    private int hfA = -1;
    private CustomMessageListener hfB = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.yuyinala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.oaf != null) {
                a.this.oaf.S(false, true);
            }
        }
    };
    private CustomMessageListener hCg = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.yuyinala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.oaf != null) {
                a.this.oaf.nV(false);
                a.this.oaf.bTu();
            }
        }
    };
    private CustomMessageListener gNU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.yuyinala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.hfA) {
                a.this.hfA = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cbk();
                        if (a.this.oaf != null) {
                            a.this.oaf.nS(false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.RX()) {
                        a.this.cbj();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cbl();
                    }
                    if (a.this.oaf != null) {
                        a.this.oaf.onStart();
                        a.this.oaf.cim();
                    }
                }
            }
        }
    };
    private CustomMessageListener hCh = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.yuyinala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.chC();
            }
        }
    };
    private CustomMessageListener bBv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.yuyinala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cbk();
                    if (a.this.oaf != null) {
                        a.this.oaf.nS(false);
                    }
                } else if (a.this.oaf != null) {
                    if (a.this.oaf.chV()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.RX()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cbj();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && l.RX()) {
                        a.this.cbj();
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    @Override // com.baidu.live.c.b
    public void a(TbPageContext tbPageContext, com.baidu.live.c.a aVar) {
        this.mPageContext = tbPageContext;
        this.oae = aVar;
        init();
    }

    private void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.hCf = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.hCf = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.hfB);
        MessageManager.getInstance().registerListener(this.hCg);
        MessageManager.getInstance().registerListener(this.gNU);
        MessageManager.getInstance().registerListener(this.hCh);
        MessageManager.getInstance().registerListener(this.bBv);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.EF().requestData(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cbe();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.oaf = new b(getPageContext(), this);
            this.oaf.aw(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cbe() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.player.a.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                a.this.b(false, false, -1L);
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    @Override // com.baidu.live.c.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.oaf != null) {
            this.oaf.dI(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
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
                    if (a.this.oaf != null) {
                        a.this.oaf.cid();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.oaf != null) {
                        a.this.oaf.cid();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bzA)) {
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

    @Override // com.baidu.live.c.b
    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.oaf != null) {
            if (realScreenOrientation == 2) {
                this.oaf.cie();
            } else {
                this.oaf.cif();
            }
        }
    }

    @Override // com.baidu.live.c.b
    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bzA = true;
        if (this.oaf != null) {
            this.oaf.onResume();
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbl() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void cbj() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
        }
    }

    @Override // com.baidu.live.c.b
    public void onStart() {
        if (this.oaf != null) {
            this.oaf.nX(false);
            this.oaf.onStart();
        }
    }

    @Override // com.baidu.live.c.b
    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.hCf) {
            this.bzA = false;
            if (this.oaf != null) {
                this.oaf.onPause();
            }
        }
    }

    @Override // com.baidu.live.c.b
    public void onStop() {
        if (this.oaf != null) {
            this.oaf.nX(true);
            this.oaf.nS(true);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    @Override // com.baidu.live.c.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.oaf != null && this.oaf.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.oaf != null) {
            this.oaf.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.c.b
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.oaf != null) {
            this.oaf.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chC() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.oaf != null) {
                        a.this.oaf.mI(true);
                        a.this.oaf.chU();
                        a.this.oaf.chE();
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        c.PX().release();
        ai.GP();
        com.baidu.live.entereffect.a.EF().cancelLoad();
        if (this.oaf != null) {
            this.oaf.cil();
        }
        if (this.oae != null) {
            this.oae.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.live.c.b
    public void onDestroy() {
        if (this.hCf) {
            MessageManager.getInstance().unRegisterListener(this.hCg);
            MessageManager.getInstance().unRegisterListener(this.hfB);
            MessageManager.getInstance().unRegisterListener(this.gNU);
            MessageManager.getInstance().unRegisterListener(this.hCh);
            MessageManager.getInstance().unRegisterListener(this.bBv);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.oaf != null) {
                this.oaf.destroy();
                this.oaf = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }

    @Override // com.baidu.live.c.b
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
