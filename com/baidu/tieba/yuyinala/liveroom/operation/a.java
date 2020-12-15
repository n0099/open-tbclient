package com.baidu.tieba.yuyinala.liveroom.operation;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ak;
import com.baidu.live.data.bo;
import com.baidu.live.data.cq;
import com.baidu.live.data.w;
import com.baidu.live.gift.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private ViewGroup bNk;
    CustomMessageTask.CustomRunnable bxu;
    private Handler handler;
    private long hzB;
    private CustomMessageListener hzD;
    private CustomMessageListener hzE;
    private CustomMessageListener hzF;
    private CustomMessageListener hzG;
    private CustomMessageListener hzH;
    private CustomMessageListener hzI;
    private FrameLayout hzy;
    private com.baidu.tieba.yuyinala.liveroom.data.a ooA;
    private InterfaceC0931a ooB;
    private AlaLiveBottomOperationView ooz;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0931a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hzD = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cq cqVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bo boVar = com.baidu.live.ae.a.RB().bxq;
                    if (boVar != null && (cqVar = boVar.aQN) != null) {
                        str = cqVar.aTH;
                        j = IMConnection.RETRY_DELAY_TIMES;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, j, 3000);
                }
            }
        };
        this.hzE = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ.aKm;
                    i = com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hzF = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zC(false);
            }
        };
        this.hzG = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w wVar = null;
                    if (a.this.ooA != null && a.this.ooA.olV != null) {
                        wVar = a.this.ooA.olV.Iq();
                    }
                    if (wVar == null || wVar.aKr == null) {
                        a.this.zC(false);
                    } else {
                        a.this.zC(wVar.aKr.isNewUser);
                    }
                }
            }
        };
        this.hzH = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bxu = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.ooz != null) {
                        int[] iArr = new int[2];
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(2501066, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hzI = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cjW();
            }
        };
        MessageManager.getInstance().registerListener(this.hzD);
        MessageManager.getInstance().registerListener(this.hzE);
        MessageManager.getInstance().registerListener(this.hzF);
        MessageManager.getInstance().registerListener(this.hzG);
        MessageManager.getInstance().registerListener(this.hzH);
        MessageManager.getInstance().registerListener(this.hzI);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bxu);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void no(boolean z) {
        if (this.ooz != null) {
            this.ooz.no(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.ooz != null) {
            this.ooz.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.ooA = aVar;
            this.bNk = viewGroup;
            if (this.ooz == null) {
                this.ooz = new AlaLiveBottomOperationView(getPageContext());
            }
            this.ooz.registerListeners();
            this.ooz.setOnLiveViewOperationBtnClickListener(bVar);
            this.ooz.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.ooz.getRootView()) >= 0) {
                viewGroup.removeView(this.ooz.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.ooz.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.ooz.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.ooz.getRootView(), layoutParams);
            if (this.hzy == null) {
                this.hzy = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cjQ();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.ooz.hwB != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.ooz.hwB.setVisibility(8);
                    if (this.ooz.hwB.getParent() != null && (this.ooz.hwB.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.ooz.hwB.getParent()).removeView(this.ooz.hwB);
                    }
                    aVar.hpS.getLiveContainerView().addView(this.ooz.hwB, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hzy.getParent() != null && (this.hzy.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hzy.getParent()).removeView(this.hzy);
                    }
                    aVar.hpS.getLiveContainerView().addView(this.hzy, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.ooz.setGiftBtnVisible(false);
            } else {
                this.ooz.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.ooz.setQuickImInputVisible(false);
            } else {
                this.ooz.setQuickImInputVisible(true);
            }
            this.ooz.setChatBtnVisible(com.baidu.live.ae.b.RL().RM());
            this.ooz.setMoreLayoutVisible(false);
        }
    }

    private void cjQ() {
    }

    public void cjS() {
        this.hzB = 0L;
        if (this.bNk != null && this.ooz != null && this.bNk.indexOfChild(this.ooz.getRootView()) > 0) {
            this.bNk.removeView(this.ooz.getRootView());
        }
        if (this.hzy != null && (this.hzy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hzy.getParent()).removeView(this.hzy);
        }
        if (this.ooz != null && this.ooz.hwB != null && (this.ooz.hwB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ooz.hwB.getParent()).removeView(this.ooz.hwB);
        }
    }

    public void setVisibility(int i) {
        if (this.ooz != null && this.ooz.getRootView() != null) {
            this.ooz.getRootView().setVisibility(i);
        }
        if (this.hzy != null) {
            this.hzy.setVisibility(i);
        }
    }

    public void a(o oVar, w wVar) {
        if (this.ooz != null) {
            if (wVar != null && wVar.aKr != null) {
                zC(wVar.aKr.isNewUser);
            } else {
                zC(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.HW() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.HW().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.HW().GX());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.HW().GY());
                }
                if (wVar != null && wVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", wVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", wVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(InterfaceC0931a interfaceC0931a) {
    }

    public void NB(int i) {
        if (this.ooz != null && this.ooz.hwB != null) {
            this.ooz.hwB.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.ooz != null && this.ooz.hzP != null) {
            final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.g.toast_gift_guide, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(a.f.textView);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.arrow_imageView);
            textView.setText(str);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                textView.setBackgroundResource(a.e.bg_guide_gift_toast_hk);
                imageView.setImageResource(a.e.bg_guide_gift_toast_arrow_hk);
            } else {
                textView.setBackgroundResource(a.e.bg_guide_gift_toast_qm);
                imageView.setImageResource(a.e.bg_guide_gift_toast_arrow_qm);
            }
            final FrameLayout frameLayout = (FrameLayout) getPageContext().getPageActivity().getWindow().getDecorView();
            if (frameLayout != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (frameLayout != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout2 = a.this.ooz.hzP;
                            int[] iArr = new int[2];
                            frameLayout2.getLocationOnScreen(iArr);
                            int dimensionPixelSize = ((BdUtilHelper.getScreenSize(pageActivity).widthPixels - iArr[0]) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds44)) - (frameLayout2.getWidth() / 2);
                            inflate.measure(0, 0);
                            int measuredHeight = (iArr[1] - inflate.getMeasuredHeight()) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.rightMargin = dimensionPixelSize;
                            layoutParams.topMargin = measuredHeight;
                            layoutParams.gravity = 5;
                            frameLayout.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (frameLayout != null) {
                            frameLayout.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public void onDestory() {
        this.hzB = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hzD);
        MessageManager.getInstance().unRegisterListener(this.hzE);
        MessageManager.getInstance().unRegisterListener(this.hzF);
        MessageManager.getInstance().unRegisterListener(this.hzG);
        MessageManager.getInstance().unRegisterListener(this.hzH);
        MessageManager.getInstance().unRegisterListener(this.hzI);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.ooB = null;
        if (this.ooz != null) {
            this.ooz.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjW() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zC(boolean z) {
        boolean z2 = true;
        ak akVar = com.baidu.tieba.yuyinala.liveroom.n.b.edX().brJ;
        z2 = (akVar == null || akVar.aLH == 1 || StringUtils.isNull(akVar.aLI, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
