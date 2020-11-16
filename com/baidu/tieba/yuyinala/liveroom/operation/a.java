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
import com.baidu.live.data.aj;
import com.baidu.live.data.bn;
import com.baidu.live.data.co;
import com.baidu.live.data.w;
import com.baidu.live.gift.n;
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
    private ViewGroup bIc;
    CustomMessageTask.CustomRunnable bsl;
    private Handler handler;
    private FrameLayout hpS;
    private long hpV;
    private CustomMessageListener hpX;
    private CustomMessageListener hpY;
    private CustomMessageListener hpZ;
    private CustomMessageListener hqa;
    private CustomMessageListener hqb;
    private CustomMessageListener hqc;
    private AlaLiveBottomOperationView nZx;
    private com.baidu.tieba.yuyinala.liveroom.data.a nZy;
    private InterfaceC0914a nZz;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0914a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hpX = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                co coVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bn bnVar = com.baidu.live.aa.a.Ph().bsh;
                    if (bnVar != null && (coVar = bnVar.aNN) != null) {
                        str = coVar.aQF;
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
        this.hpY = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB.aHB;
                    i = com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hpZ = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.yY(false);
            }
        };
        this.hqa = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w wVar = null;
                    if (a.this.nZy != null && a.this.nZy.nWV != null) {
                        wVar = a.this.nZy.nWV.Gz();
                    }
                    if (wVar == null || wVar.aHG == null) {
                        a.this.yY(false);
                    } else {
                        a.this.yY(wVar.aHG.isNewUser);
                    }
                }
            }
        };
        this.hqb = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bsl = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.nZx != null) {
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
        this.hqc = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cgb();
            }
        };
        MessageManager.getInstance().registerListener(this.hpX);
        MessageManager.getInstance().registerListener(this.hpY);
        MessageManager.getInstance().registerListener(this.hpZ);
        MessageManager.getInstance().registerListener(this.hqa);
        MessageManager.getInstance().registerListener(this.hqb);
        MessageManager.getInstance().registerListener(this.hqc);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bsl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mT(boolean z) {
        if (this.nZx != null) {
            this.nZx.mT(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.nZx != null) {
            this.nZx.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.nZy = aVar;
            this.bIc = viewGroup;
            if (this.nZx == null) {
                this.nZx = new AlaLiveBottomOperationView(getPageContext());
            }
            this.nZx.registerListeners();
            this.nZx.setOnLiveViewOperationBtnClickListener(bVar);
            this.nZx.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.nZx.getRootView()) >= 0) {
                viewGroup.removeView(this.nZx.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.nZx.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.nZx.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.nZx.getRootView(), layoutParams);
            if (this.hpS == null) {
                this.hpS = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hpS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cfV();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.nZx.hmU != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.nZx.hmU.setVisibility(8);
                    if (this.nZx.hmU.getParent() != null && (this.nZx.hmU.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.nZx.hmU.getParent()).removeView(this.nZx.hmU);
                    }
                    aVar.hgj.getLiveContainerView().addView(this.nZx.hmU, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hpS.getParent() != null && (this.hpS.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hpS.getParent()).removeView(this.hpS);
                    }
                    aVar.hgj.getLiveContainerView().addView(this.hpS, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.nZx.setGiftBtnVisible(false);
            } else {
                this.nZx.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.nZx.setQuickImInputVisible(false);
            } else {
                this.nZx.setQuickImInputVisible(true);
            }
            this.nZx.setChatBtnVisible(com.baidu.live.aa.b.Pr().Ps());
            this.nZx.setMoreLayoutVisible(false);
        }
    }

    private void cfV() {
    }

    public void cfX() {
        this.hpV = 0L;
        if (this.bIc != null && this.nZx != null && this.bIc.indexOfChild(this.nZx.getRootView()) > 0) {
            this.bIc.removeView(this.nZx.getRootView());
        }
        if (this.hpS != null && (this.hpS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hpS.getParent()).removeView(this.hpS);
        }
        if (this.nZx != null && this.nZx.hmU != null && (this.nZx.hmU.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.nZx.hmU.getParent()).removeView(this.nZx.hmU);
        }
    }

    public void setVisibility(int i) {
        if (this.nZx != null && this.nZx.getRootView() != null) {
            this.nZx.getRootView().setVisibility(i);
        }
        if (this.hpS != null) {
            this.hpS.setVisibility(i);
        }
    }

    public void a(n nVar, w wVar) {
        if (this.nZx != null) {
            if (wVar != null && wVar.aHG != null) {
                yY(wVar.aHG.isNewUser);
            } else {
                yY(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (nVar.Gh() != null) {
                    alaStaticItem.addParams("gifts_value", nVar.Gh().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, nVar.Gh().Fk());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, nVar.Gh().Fl());
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

    public void a(InterfaceC0914a interfaceC0914a) {
    }

    public void MJ(int i) {
        if (this.nZx != null && this.nZx.hmU != null) {
            this.nZx.hmU.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.nZx != null && this.nZx.hqj != null) {
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
                            FrameLayout frameLayout2 = a.this.nZx.hqj;
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
        this.hpV = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hpX);
        MessageManager.getInstance().unRegisterListener(this.hpY);
        MessageManager.getInstance().unRegisterListener(this.hpZ);
        MessageManager.getInstance().unRegisterListener(this.hqa);
        MessageManager.getInstance().unRegisterListener(this.hqb);
        MessageManager.getInstance().unRegisterListener(this.hqc);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.nZz = null;
        if (this.nZx != null) {
            this.nZx.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY(boolean z) {
        boolean z2 = true;
        aj ajVar = com.baidu.tieba.yuyinala.liveroom.n.b.dYs().bmB;
        z2 = (ajVar == null || ajVar.aIO == 1 || StringUtils.isNull(ajVar.aIP, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
