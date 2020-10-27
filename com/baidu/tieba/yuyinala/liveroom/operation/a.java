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
import com.baidu.live.data.ai;
import com.baidu.live.data.bm;
import com.baidu.live.data.cl;
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
    private ViewGroup bEg;
    CustomMessageTask.CustomRunnable bsC;
    private Handler handler;
    private CustomMessageListener hkA;
    private CustomMessageListener hkB;
    private CustomMessageListener hkC;
    private CustomMessageListener hkD;
    private FrameLayout hku;
    private long hkx;
    private CustomMessageListener hky;
    private CustomMessageListener hkz;
    private AlaLiveBottomOperationView nQK;
    private com.baidu.tieba.yuyinala.liveroom.data.a nQL;
    private InterfaceC0895a nQM;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0895a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hky = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cl clVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bm bmVar = com.baidu.live.z.a.Pq().bsy;
                    if (bmVar != null && (clVar = bmVar.aOB) != null) {
                        str = clVar.aRk;
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
        this.hkz = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT.aIv;
                    i = com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hkA = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.yI(false);
            }
        };
        this.hkB = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w wVar = null;
                    if (a.this.nQL != null && a.this.nQL.nPk != null) {
                        wVar = a.this.nQL.nPk.GH();
                    }
                    if (wVar == null || wVar.aIA == null) {
                        a.this.yI(false);
                    } else {
                        a.this.yI(wVar.aIA.isNewUser);
                    }
                }
            }
        };
        this.hkC = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bsC = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.nQK != null) {
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
        this.hkD = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ceg();
            }
        };
        MessageManager.getInstance().registerListener(this.hky);
        MessageManager.getInstance().registerListener(this.hkz);
        MessageManager.getInstance().registerListener(this.hkA);
        MessageManager.getInstance().registerListener(this.hkB);
        MessageManager.getInstance().registerListener(this.hkC);
        MessageManager.getInstance().registerListener(this.hkD);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bsC);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mJ(boolean z) {
        if (this.nQK != null) {
            this.nQK.mJ(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.nQK != null) {
            this.nQK.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.nQL = aVar;
            this.bEg = viewGroup;
            if (this.nQK == null) {
                this.nQK = new AlaLiveBottomOperationView(getPageContext());
            }
            this.nQK.registerListeners();
            this.nQK.setOnLiveViewOperationBtnClickListener(bVar);
            this.nQK.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.nQK.getRootView()) >= 0) {
                viewGroup.removeView(this.nQK.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.nQK.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.nQK.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.nQK.getRootView(), layoutParams);
            if (this.hku == null) {
                this.hku = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.b(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                ceb();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.nQK.hht != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.nQK.hht.setVisibility(8);
                    if (this.nQK.hht.getParent() != null && (this.nQK.hht.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.nQK.hht.getParent()).removeView(this.nQK.hht);
                    }
                    aVar.haA.getLiveContainerView().addView(this.nQK.hht, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hku.getParent() != null && (this.hku.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hku.getParent()).removeView(this.hku);
                    }
                    aVar.haA.getLiveContainerView().addView(this.hku, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.nQK.setGiftBtnVisible(false);
            } else {
                this.nQK.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.nQK.setQuickImInputVisible(false);
            } else {
                this.nQK.setQuickImInputVisible(true);
            }
            this.nQK.setChatBtnVisible(com.baidu.live.z.b.Pz().PA());
            this.nQK.setMoreLayoutVisible(false);
        }
    }

    private void ceb() {
    }

    public void ced() {
        this.hkx = 0L;
        if (this.bEg != null && this.nQK != null && this.bEg.indexOfChild(this.nQK.getRootView()) > 0) {
            this.bEg.removeView(this.nQK.getRootView());
        }
        if (this.hku != null && (this.hku.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hku.getParent()).removeView(this.hku);
        }
        if (this.nQK != null && this.nQK.hht != null && (this.nQK.hht.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.nQK.hht.getParent()).removeView(this.nQK.hht);
        }
    }

    public void setVisibility(int i) {
        if (this.nQK != null && this.nQK.getRootView() != null) {
            this.nQK.getRootView().setVisibility(i);
        }
        if (this.hku != null) {
            this.hku.setVisibility(i);
        }
    }

    public void a(o oVar, w wVar) {
        if (this.nQK != null) {
            if (wVar != null && wVar.aIA != null) {
                yI(wVar.aIA.isNewUser);
            } else {
                yI(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.Gp() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.Gp().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.Gp().Fs());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.Gp().Ft());
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

    public void a(InterfaceC0895a interfaceC0895a) {
    }

    public void LO(int i) {
        if (this.nQK != null && this.nQK.hht != null) {
            this.nQK.hht.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.nQK != null && this.nQK.hkJ != null) {
            final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_gift_guide, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(a.g.textView);
            ImageView imageView = (ImageView) inflate.findViewById(a.g.arrow_imageView);
            textView.setText(str);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                textView.setBackgroundResource(a.f.bg_guide_gift_toast_hk);
                imageView.setImageResource(a.f.bg_guide_gift_toast_arrow_hk);
            } else {
                textView.setBackgroundResource(a.f.bg_guide_gift_toast_qm);
                imageView.setImageResource(a.f.bg_guide_gift_toast_arrow_qm);
            }
            final FrameLayout frameLayout = (FrameLayout) getPageContext().getPageActivity().getWindow().getDecorView();
            if (frameLayout != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (frameLayout != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout2 = a.this.nQK.hkJ;
                            int[] iArr = new int[2];
                            frameLayout2.getLocationOnScreen(iArr);
                            int dimensionPixelSize = ((BdUtilHelper.getScreenSize(pageActivity).widthPixels - iArr[0]) - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds44)) - (frameLayout2.getWidth() / 2);
                            inflate.measure(0, 0);
                            int measuredHeight = (iArr[1] - inflate.getMeasuredHeight()) - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds8);
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
        this.hkx = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hky);
        MessageManager.getInstance().unRegisterListener(this.hkz);
        MessageManager.getInstance().unRegisterListener(this.hkA);
        MessageManager.getInstance().unRegisterListener(this.hkB);
        MessageManager.getInstance().unRegisterListener(this.hkC);
        MessageManager.getInstance().unRegisterListener(this.hkD);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.nQM = null;
        if (this.nQK != null) {
            this.nQK.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI(boolean z) {
        boolean z2 = true;
        ai aiVar = com.baidu.tieba.yuyinala.liveroom.n.b.dVE().bmT;
        z2 = (aiVar == null || aiVar.aJz == 1 || StringUtils.isNull(aiVar.aJA, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
