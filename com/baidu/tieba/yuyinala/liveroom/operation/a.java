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
    private ViewGroup bJN;
    CustomMessageTask.CustomRunnable btX;
    private Handler handler;
    private FrameLayout hql;
    private long hqo;
    private CustomMessageListener hqq;
    private CustomMessageListener hqr;
    private CustomMessageListener hqs;
    private CustomMessageListener hqt;
    private CustomMessageListener hqu;
    private CustomMessageListener hqv;
    private AlaLiveBottomOperationView nXU;
    private com.baidu.tieba.yuyinala.liveroom.data.a nXV;
    private InterfaceC0911a nXW;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0911a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hqq = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
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
                    bn bnVar = com.baidu.live.aa.a.PQ().btT;
                    if (bnVar != null && (coVar = bnVar.aPy) != null) {
                        str = coVar.aSq;
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
        this.hqr = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom.aJm;
                    i = com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hqs = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.yR(false);
            }
        };
        this.hqt = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w wVar = null;
                    if (a.this.nXV != null && a.this.nXV.nVs != null) {
                        wVar = a.this.nXV.nVs.Hi();
                    }
                    if (wVar == null || wVar.aJr == null) {
                        a.this.yR(false);
                    } else {
                        a.this.yR(wVar.aJr.isNewUser);
                    }
                }
            }
        };
        this.hqu = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.btX = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.nXU != null) {
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
        this.hqv = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cgI();
            }
        };
        MessageManager.getInstance().registerListener(this.hqq);
        MessageManager.getInstance().registerListener(this.hqr);
        MessageManager.getInstance().registerListener(this.hqs);
        MessageManager.getInstance().registerListener(this.hqt);
        MessageManager.getInstance().registerListener(this.hqu);
        MessageManager.getInstance().registerListener(this.hqv);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.btX);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mS(boolean z) {
        if (this.nXU != null) {
            this.nXU.mS(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.nXU != null) {
            this.nXU.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.nXV = aVar;
            this.bJN = viewGroup;
            if (this.nXU == null) {
                this.nXU = new AlaLiveBottomOperationView(getPageContext());
            }
            this.nXU.registerListeners();
            this.nXU.setOnLiveViewOperationBtnClickListener(bVar);
            this.nXU.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.nXU.getRootView()) >= 0) {
                viewGroup.removeView(this.nXU.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.nXU.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.nXU.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.nXU.getRootView(), layoutParams);
            if (this.hql == null) {
                this.hql = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cgC();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.nXU.hnn != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.nXU.hnn.setVisibility(8);
                    if (this.nXU.hnn.getParent() != null && (this.nXU.hnn.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.nXU.hnn.getParent()).removeView(this.nXU.hnn);
                    }
                    aVar.hgC.getLiveContainerView().addView(this.nXU.hnn, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hql.getParent() != null && (this.hql.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hql.getParent()).removeView(this.hql);
                    }
                    aVar.hgC.getLiveContainerView().addView(this.hql, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.nXU.setGiftBtnVisible(false);
            } else {
                this.nXU.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.nXU.setQuickImInputVisible(false);
            } else {
                this.nXU.setQuickImInputVisible(true);
            }
            this.nXU.setChatBtnVisible(com.baidu.live.aa.b.Qa().Qb());
            this.nXU.setMoreLayoutVisible(false);
        }
    }

    private void cgC() {
    }

    public void cgE() {
        this.hqo = 0L;
        if (this.bJN != null && this.nXU != null && this.bJN.indexOfChild(this.nXU.getRootView()) > 0) {
            this.bJN.removeView(this.nXU.getRootView());
        }
        if (this.hql != null && (this.hql.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hql.getParent()).removeView(this.hql);
        }
        if (this.nXU != null && this.nXU.hnn != null && (this.nXU.hnn.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.nXU.hnn.getParent()).removeView(this.nXU.hnn);
        }
    }

    public void setVisibility(int i) {
        if (this.nXU != null && this.nXU.getRootView() != null) {
            this.nXU.getRootView().setVisibility(i);
        }
        if (this.hql != null) {
            this.hql.setVisibility(i);
        }
    }

    public void a(n nVar, w wVar) {
        if (this.nXU != null) {
            if (wVar != null && wVar.aJr != null) {
                yR(wVar.aJr.isNewUser);
            } else {
                yR(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (nVar.GQ() != null) {
                    alaStaticItem.addParams("gifts_value", nVar.GQ().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, nVar.GQ().FT());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, nVar.GQ().FU());
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

    public void a(InterfaceC0911a interfaceC0911a) {
    }

    public void Mg(int i) {
        if (this.nXU != null && this.nXU.hnn != null) {
            this.nXU.hnn.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.nXU != null && this.nXU.hqC != null) {
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
                            FrameLayout frameLayout2 = a.this.nXU.hqC;
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
        this.hqo = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hqq);
        MessageManager.getInstance().unRegisterListener(this.hqr);
        MessageManager.getInstance().unRegisterListener(this.hqs);
        MessageManager.getInstance().unRegisterListener(this.hqt);
        MessageManager.getInstance().unRegisterListener(this.hqu);
        MessageManager.getInstance().unRegisterListener(this.hqv);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.nXW = null;
        if (this.nXU != null) {
            this.nXU.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgI() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(boolean z) {
        boolean z2 = true;
        aj ajVar = com.baidu.tieba.yuyinala.liveroom.n.b.dYt().bom;
        z2 = (ajVar == null || ajVar.aKz == 1 || StringUtils.isNull(ajVar.aKA, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
