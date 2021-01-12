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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.am;
import com.baidu.live.data.bq;
import com.baidu.live.data.cs;
import com.baidu.live.data.x;
import com.baidu.live.gift.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.utils.u;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private ViewGroup bNl;
    CustomMessageTask.CustomRunnable bxt;
    private FrameLayout hGQ;
    private long hGT;
    private CustomMessageListener hGV;
    private CustomMessageListener hGW;
    private CustomMessageListener hGX;
    private CustomMessageListener hGY;
    private CustomMessageListener hGZ;
    private CustomMessageListener hHa;
    private Handler handler;
    private AlaLiveBottomOperationView onj;
    private com.baidu.tieba.yuyinala.liveroom.data.a onk;
    private InterfaceC0927a onl;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0927a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hGV = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cs csVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bq bqVar = com.baidu.live.af.a.OJ().bxp;
                    if (bqVar != null && (csVar = bqVar.aMP) != null) {
                        str = csVar.aPS;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, j, 3000);
                }
            }
        };
        this.hGW = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD.aFY;
                    i = com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hGX = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zy(false);
            }
        };
        this.hGY = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    x xVar = null;
                    if (a.this.onk != null && a.this.onk.okk != null) {
                        xVar = a.this.onk.okk.DW();
                    }
                    if (xVar == null || xVar.aGd == null) {
                        a.this.zy(false);
                    } else {
                        a.this.zy(xVar.aGd.isNewUser);
                    }
                }
            }
        };
        this.hGZ = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bxt = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.onj != null) {
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
        this.hHa = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ciU();
            }
        };
        MessageManager.getInstance().registerListener(this.hGV);
        MessageManager.getInstance().registerListener(this.hGW);
        MessageManager.getInstance().registerListener(this.hGX);
        MessageManager.getInstance().registerListener(this.hGY);
        MessageManager.getInstance().registerListener(this.hGZ);
        MessageManager.getInstance().registerListener(this.hHa);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bxt);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void nK(boolean z) {
        if (this.onj != null) {
            this.onj.nK(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.onj != null) {
            this.onj.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.onk = aVar;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            this.bNl = viewGroup2;
            if (this.onj == null) {
                this.onj = new AlaLiveBottomOperationView(getPageContext());
            }
            this.onj.RP();
            this.onj.registerListeners();
            this.onj.setOnLiveViewOperationBtnClickListener(bVar);
            this.onj.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup2.indexOfChild(this.onj.getRootView()) >= 0) {
                viewGroup2.removeView(this.onj.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.onj.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.onj.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            u.a(viewGroup2, this.onj.getRootView(), layoutParams, 400);
            if (this.hGQ == null) {
                this.hGQ = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                ciO();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.onj.hDS != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.onj.hDS.setVisibility(8);
                    if (this.onj.hDS.getParent() != null && (this.onj.hDS.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.onj.hDS.getParent()).removeView(this.onj.hDS);
                    }
                    aVar.hxi.getLiveContainerView().addView(this.onj.hDS, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hGQ.getParent() != null && (this.hGQ.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hGQ.getParent()).removeView(this.hGQ);
                    }
                    aVar.hxi.getLiveContainerView().addView(this.hGQ, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.onj.setGiftBtnVisible(false);
            } else {
                this.onj.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.onj.setQuickImInputVisible(false);
            } else {
                this.onj.setQuickImInputVisible(true);
            }
            this.onj.setChatBtnVisible(com.baidu.live.af.b.OU().OV());
        }
    }

    private void ciO() {
    }

    public void ciQ() {
        this.hGT = 0L;
        if (this.bNl != null && this.onj != null && this.bNl.indexOfChild(this.onj.getRootView()) > 0) {
            this.bNl.removeView(this.onj.getRootView());
        }
        if (this.hGQ != null && (this.hGQ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGQ.getParent()).removeView(this.hGQ);
        }
        if (this.onj != null && this.onj.hDS != null && (this.onj.hDS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.onj.hDS.getParent()).removeView(this.onj.hDS);
        }
        if (this.onj != null) {
            this.onj.cbC();
        }
    }

    public void setVisibility(int i) {
        if (this.onj != null && this.onj.getRootView() != null) {
            this.onj.getRootView().setVisibility(i);
        }
        if (this.hGQ != null) {
            this.hGQ.setVisibility(i);
        }
    }

    public void a(o oVar, x xVar) {
        if (this.onj != null) {
            if (xVar != null && xVar.aGd != null) {
                zy(xVar.aGd.isNewUser);
            } else {
                zy(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.DC() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.DC().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.DC().CC());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.DC().CD());
                }
                if (xVar != null && xVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", xVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", xVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(InterfaceC0927a interfaceC0927a) {
    }

    public void LH(int i) {
        if (this.onj != null && this.onj.hDS != null) {
            this.onj.hDS.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.onj != null && this.onj.hHh != null) {
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
                            FrameLayout frameLayout2 = a.this.onj.hHh;
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
        this.hGT = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hGV);
        MessageManager.getInstance().unRegisterListener(this.hGW);
        MessageManager.getInstance().unRegisterListener(this.hGX);
        MessageManager.getInstance().unRegisterListener(this.hGY);
        MessageManager.getInstance().unRegisterListener(this.hGZ);
        MessageManager.getInstance().unRegisterListener(this.hHa);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.onl = null;
        if (this.onj != null) {
            this.onj.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciU() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy(boolean z) {
        boolean z2 = true;
        am amVar = com.baidu.tieba.yuyinala.liveroom.p.b.dZy().brD;
        z2 = (amVar == null || amVar.aHy == 1 || StringUtils.isNull(amVar.aHz, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
