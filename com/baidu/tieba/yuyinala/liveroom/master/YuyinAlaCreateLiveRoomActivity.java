package com.baidu.tieba.yuyinala.liveroom.master;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewTreeObserver;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.PermissionUtil;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.l;
import com.baidu.tieba.yuyinala.liveroom.i.d;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaCreateLiveRoomActivity extends BaseActivity<YuyinAlaCreateLiveRoomActivity> {
    private int availableHeight;
    private PermissionJudgePolicy bAY;
    private boolean bve;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private String hde;
    private Bundle huB;
    private a onS;
    private d onT;
    private boolean mIsKeyboardOpen = false;
    private volatile boolean isBackground = false;
    private boolean huA = false;
    private boolean huC = false;
    private boolean huD = true;
    private int huE = -1;
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                YuyinAlaCreateLiveRoomActivity.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };
    private CustomMessageListener huG = new CustomMessageListener(2913169, true) { // from class: com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                YuyinAlaCreateLiveRoomActivity.this.huD = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener hdp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType;
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && (netType = BdNetTypeUtil.netType()) != YuyinAlaCreateLiveRoomActivity.this.huE) {
                YuyinAlaCreateLiveRoomActivity.this.huE = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        YuyinAlaCreateLiveRoomActivity.this.cgX();
                    } else if (BdNetTypeUtil.isMobileNet() && l.Wx()) {
                        YuyinAlaCreateLiveRoomActivity.this.cgW();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        YuyinAlaCreateLiveRoomActivity.this.cgY();
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isBackground = false;
        setIsAddSwipeBackLayout(false);
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        this.bve = true;
        if (!isFinishing()) {
            this.huB = bundle;
            if (!cgQ()) {
                init();
            }
            TbConfig.liveScene = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.VOICE_CREATE_ROOM, "").setContentExt(jSONObject));
    }

    private boolean cgQ() {
        Activity pageActivity = getPageContext().getPageActivity();
        this.bAY = new PermissionJudgePolicy();
        this.bAY.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity.3
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
                YuyinAlaCreateLiveRoomActivity.this.huA = true;
                YuyinAlaCreateLiveRoomActivity.this.finish();
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
                YuyinAlaCreateLiveRoomActivity.this.huA = true;
                YuyinAlaCreateLiveRoomActivity.this.finish();
            }
        });
        this.bAY.clearRequestPermissionList();
        this.bAY.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        this.bAY.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.bAY.startRequestPermission(pageActivity);
    }

    private void init() {
        this.huA = true;
        setUseStyleImmersiveSticky(true);
        getWindow().addFlags(128);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        initData(this.huB);
    }

    private void initData(Bundle bundle) {
        if (!UtilHelper.isARM()) {
            cgR();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_forum_name");
            String stringExtra2 = intent.getStringExtra("live_forum_id");
            this.huC = intent.getBooleanExtra("stop_im_when_close", false);
            intent.getIntExtra("create_master_live_type", 1);
            String stringExtra3 = intent.getStringExtra("special_forum_type");
            String stringExtra4 = intent.getStringExtra("live_info_core");
            if (!TextUtils.isEmpty(stringExtra4)) {
                try {
                    new AlaLivePersonData().parseJson(new JSONObject(stringExtra4));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String stringExtra5 = intent.getStringExtra(AlaMasterLiveRoomActivityConfig.LIVE_START_PARAMS);
            if (!TextUtils.isEmpty(stringExtra5)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra5);
                    AlaLiveSwitchData.liveActivityType = jSONObject.getString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                    String optString = jSONObject.optString("extra");
                    if (TextUtils.isEmpty(optString)) {
                        this.hde = null;
                    } else {
                        this.hde = new JSONObject(optString).optString("live_back_scheme");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.hde = null;
                    AlaLiveSwitchData.liveActivityType = "";
                }
            }
            MessageManager.getInstance().registerListener(this.hdp);
            MessageManager.getInstance().registerListener(this.byv);
            MessageManager.getInstance().registerListener(this.huG);
            a(bundle, stringExtra, stringExtra2, stringExtra3);
        }
    }

    private void cgR() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                YuyinAlaCreateLiveRoomActivity.this.finish();
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    private void a(Bundle bundle, String str, String str2, String str3) {
        this.onT = new d(getPageContext());
        this.onS = new a(this);
        this.onS.a(this.onT);
        this.onS.a(str, str2, str3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (YuyinAlaCreateLiveRoomActivity.this.huD) {
                    Rect rect = new Rect();
                    YuyinAlaCreateLiveRoomActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int statusBarHeight = BdUtilHelper.getStatusBarHeight(YuyinAlaCreateLiveRoomActivity.this.getPageContext().getPageActivity());
                    int[] screenFullSize = ViewCommonUtil.getScreenFullSize(YuyinAlaCreateLiveRoomActivity.this.getPageContext().getPageActivity());
                    boolean z = YuyinAlaCreateLiveRoomActivity.this.availableHeight != rect.bottom;
                    YuyinAlaCreateLiveRoomActivity.this.availableHeight = rect.bottom;
                    if (Math.abs(screenFullSize[1] - rect.bottom) > screenFullSize[1] / 4 && (!YuyinAlaCreateLiveRoomActivity.this.mIsKeyboardOpen || z)) {
                        YuyinAlaCreateLiveRoomActivity.this.mIsKeyboardOpen = true;
                        TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                        YuyinAlaCreateLiveRoomActivity.this.onKeyboardVisibilityChanged(true);
                    } else if (Math.abs(screenFullSize[1] - rect.height()) <= statusBarHeight && YuyinAlaCreateLiveRoomActivity.this.mIsKeyboardOpen) {
                        YuyinAlaCreateLiveRoomActivity.this.mIsKeyboardOpen = false;
                        YuyinAlaCreateLiveRoomActivity.this.onKeyboardVisibilityChanged(false);
                    }
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.huA) {
            getWindow().clearFlags(128);
            MessageManager.getInstance().unRegisterListener(this.hdp);
            MessageManager.getInstance().unRegisterListener(this.byv);
            MessageManager.getInstance().unRegisterListener(this.huG);
            getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            this.byv = null;
            this.hdp = null;
            System.gc();
        }
        AlaLiveSwitchData.liveActivityType = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomActivity:onActivityResult:" + i2 + "," + i);
        if (this.onS != null) {
            this.onS.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ArrayMap<String, Boolean> transformPermissionResult;
        if (25040 == i && (transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr)) != null && transformPermissionResult.size() > 0) {
            if (transformPermissionResult.containsKey(PermissionRequest.RESOURCE_VIDEO_CAPTURE) || transformPermissionResult.containsKey(PermissionRequest.RESOURCE_AUDIO_CAPTURE) || transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE")) {
                int i2 = 0;
                for (int i3 = 0; i3 < strArr.length && iArr[i3] == 0; i3++) {
                    i2++;
                }
                if (i2 == strArr.length) {
                    init();
                } else if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!this.bAY.checkPermissionForbidden(getActivity(), str)) {
                            return;
                        }
                    }
                    finish();
                }
            } else if (transformPermissionResult.containsKey("android.permission.ACCESS_FINE_LOCATION") || transformPermissionResult.containsKey("android.permission.ACCESS_COARSE_LOCATION")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO));
            }
        }
    }

    public void cgU() {
        this.isBackground = false;
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.isBackground) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913072));
            if (this.huC) {
                BdSocketLinkService.setHasAbsoluteClose(true);
                BdSocketLinkService.close("live close");
            }
            super.finish();
            if (!TextUtils.isEmpty(this.hde)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hde);
                    this.hde = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.onS != null) {
            this.onS.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }
}
