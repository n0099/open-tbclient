package com.baidu.tieba.yuyinala.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.audiolive.c;
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
import com.baidu.live.utils.m;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes11.dex */
public class a implements c {
    private int availableHeight;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private com.baidu.live.audiolive.b oNr;
    private b oNs;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bMU = true;
    private boolean idT = false;
    private int hGr = -1;
    private CustomMessageListener hGs = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.yuyinala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.oNs != null) {
                a.this.oNs.U(false, true);
            }
        }
    };
    private CustomMessageListener idU = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.yuyinala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.oNs != null) {
                a.this.oNs.pf(false);
                a.this.oNs.bZb();
            }
        }
    };
    private CustomMessageListener hpb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.yuyinala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.hGr) {
                a.this.hGr = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cgU();
                        if (a.this.oNs != null) {
                            a.this.oNs.pc(false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && m.Vp()) {
                        a.this.cgT();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cgV();
                    }
                    if (a.this.oNs != null) {
                        a.this.oNs.onStart();
                        a.this.oNs.coj();
                    }
                }
            }
        }
    };
    private CustomMessageListener idV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.yuyinala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.cny();
            }
        }
    };
    private CustomMessageListener bCb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.yuyinala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cgU();
                    if (a.this.oNs != null) {
                        a.this.oNs.pc(false);
                    }
                } else if (a.this.oNs != null) {
                    if (a.this.oNs.cnS()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && m.Vp()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cgT();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && m.Vp()) {
                        a.this.cgT();
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    @Override // com.baidu.live.audiolive.c
    public void a(TbPageContext tbPageContext, com.baidu.live.audiolive.b bVar) {
        this.mPageContext = tbPageContext;
        this.oNr = bVar;
        init();
    }

    private void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.idT = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.h.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.idT = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.hGs);
        MessageManager.getInstance().registerListener(this.idU);
        MessageManager.getInstance().registerListener(this.hpb);
        MessageManager.getInstance().registerListener(this.idV);
        MessageManager.getInstance().registerListener(this.bCb);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.CV().by(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cgO();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.oNs = new b(getPageContext(), this);
            this.oNs.au(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cgO() {
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

    @Override // com.baidu.live.audiolive.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.oNs != null) {
            this.oNs.cr(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
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
                    if (a.this.oNs != null) {
                        a.this.oNs.coa();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.oNs != null) {
                        a.this.oNs.coa();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bMU)) {
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

    @Override // com.baidu.live.audiolive.c
    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.oNs != null) {
            if (realScreenOrientation == 2) {
                this.oNs.cob();
            } else {
                this.oNs.coc();
            }
        }
    }

    public boolean cnw() {
        return false;
    }

    @Override // com.baidu.live.audiolive.c
    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bMU = true;
        if (this.oNs != null) {
            this.oNs.onResume();
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgV() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void cgT() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgU() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    @Override // com.baidu.live.audiolive.c
    public void onStart() {
        if (this.oNs != null) {
            this.oNs.ph(false);
            this.oNs.onStart();
        }
    }

    @Override // com.baidu.live.audiolive.c
    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.idT) {
            this.bMU = false;
            if (this.oNs != null) {
                this.oNs.onPause();
            }
        }
    }

    @Override // com.baidu.live.audiolive.c
    public void onStop() {
        if (this.oNs != null) {
            this.oNs.ph(true);
            this.oNs.pc(true);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    @Override // com.baidu.live.audiolive.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.oNs != null && this.oNs.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.oNs != null) {
            this.oNs.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.audiolive.c
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.oNs != null) {
            this.oNs.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cny() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.oNs != null) {
                        a.this.oNs.nU(true);
                        a.this.oNs.cnR();
                        a.this.oNs.Aq(false);
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        com.baidu.live.storage.opt.b.Rg().release();
        aj.Fu();
        com.baidu.live.entereffect.a.CV().release();
        if (this.oNs != null) {
            this.oNs.coi();
        }
        if (this.oNr != null) {
            this.oNr.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.live.audiolive.c
    public void onDestroy() {
        if (this.idT) {
            MessageManager.getInstance().unRegisterListener(this.idU);
            MessageManager.getInstance().unRegisterListener(this.hGs);
            MessageManager.getInstance().unRegisterListener(this.hpb);
            MessageManager.getInstance().unRegisterListener(this.idV);
            MessageManager.getInstance().unRegisterListener(this.bCb);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.oNs != null) {
                this.oNs.destroy();
                this.oNs = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }

    @Override // com.baidu.live.audiolive.c
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
