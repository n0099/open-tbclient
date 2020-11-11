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
import com.baidu.live.gift.ah;
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
    private com.baidu.live.c.a ojb;
    private b ojc;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bFL = true;
    private boolean hIc = false;
    private int hlw = -1;
    private CustomMessageListener hlx = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.yuyinala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.ojc != null) {
                a.this.ojc.S(false, true);
            }
        }
    };
    private CustomMessageListener hId = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.yuyinala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ojc != null) {
                a.this.ojc.oe(false);
                a.this.ojc.bWc();
            }
        }
    };
    private CustomMessageListener gUt = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.yuyinala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.hlw) {
                a.this.hlw = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cdL();
                        if (a.this.ojc != null) {
                            a.this.ojc.ob(false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.UF()) {
                        a.this.cdK();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cdM();
                    }
                    if (a.this.ojc != null) {
                        a.this.ojc.onStart();
                        a.this.ojc.ckO();
                    }
                }
            }
        }
    };
    private CustomMessageListener hIe = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.yuyinala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.cke();
            }
        }
    };
    private CustomMessageListener bHB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.yuyinala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cdL();
                    if (a.this.ojc != null) {
                        a.this.ojc.ob(false);
                    }
                } else if (a.this.ojc != null) {
                    if (a.this.ojc.ckx()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.UF()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cdK();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && l.UF()) {
                        a.this.cdK();
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
        this.ojb = aVar;
        init();
    }

    private void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.hIc = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.h.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.hIc = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.hlx);
        MessageManager.getInstance().registerListener(this.hId);
        MessageManager.getInstance().registerListener(this.gUt);
        MessageManager.getInstance().registerListener(this.hIe);
        MessageManager.getInstance().registerListener(this.bHB);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.Fg().requestData(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cdF();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.ojc = new b(getPageContext(), this);
            this.ojc.aw(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cdF() {
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

    @Override // com.baidu.live.c.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.ojc != null) {
            this.ojc.dI(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
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
                    if (a.this.ojc != null) {
                        a.this.ojc.ckF();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.ojc != null) {
                        a.this.ojc.ckF();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bFL)) {
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
        if (this.ojc != null) {
            if (realScreenOrientation == 2) {
                this.ojc.ckG();
            } else {
                this.ojc.ckH();
            }
        }
    }

    @Override // com.baidu.live.c.b
    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bFL = true;
        if (this.ojc != null) {
            this.ojc.onResume();
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdM() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void cdK() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdL() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    @Override // com.baidu.live.c.b
    public void onStart() {
        if (this.ojc != null) {
            this.ojc.og(false);
            this.ojc.onStart();
        }
    }

    @Override // com.baidu.live.c.b
    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.hIc) {
            this.bFL = false;
            if (this.ojc != null) {
                this.ojc.onPause();
            }
        }
    }

    @Override // com.baidu.live.c.b
    public void onStop() {
        if (this.ojc != null) {
            this.ojc.og(true);
            this.ojc.ob(true);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    @Override // com.baidu.live.c.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.ojc != null && this.ojc.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ojc != null) {
            this.ojc.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.c.b
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ojc != null) {
            this.ojc.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cke() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ojc != null) {
                        a.this.ojc.mR(true);
                        a.this.ojc.ckw();
                        a.this.ojc.ckg();
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        com.baidu.live.ac.a.b.Qx().release();
        ah.Hq();
        com.baidu.live.entereffect.a.Fg().release();
        if (this.ojc != null) {
            this.ojc.ckN();
        }
        if (this.ojb != null) {
            this.ojb.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.live.c.b
    public void onDestroy() {
        if (this.hIc) {
            MessageManager.getInstance().unRegisterListener(this.hId);
            MessageManager.getInstance().unRegisterListener(this.hlx);
            MessageManager.getInstance().unRegisterListener(this.gUt);
            MessageManager.getInstance().unRegisterListener(this.hIe);
            MessageManager.getInstance().unRegisterListener(this.bHB);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.ojc != null) {
                this.ojc.destroy();
                this.ojc = null;
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
