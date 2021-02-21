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
import com.baidu.live.data.ab;
import com.baidu.live.data.aq;
import com.baidu.live.data.bv;
import com.baidu.live.data.cy;
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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    CustomMessageTask.CustomRunnable bAW;
    private ViewGroup bRb;
    private FrameLayout hLC;
    private long hLF;
    private CustomMessageListener hLH;
    private CustomMessageListener hLI;
    private CustomMessageListener hLJ;
    private CustomMessageListener hLK;
    private CustomMessageListener hLL;
    private CustomMessageListener hLM;
    private Handler handler;
    private String otherParams;
    private InterfaceC0933a oxA;
    private AlaLiveBottomOperationView oxy;
    private com.baidu.tieba.yuyinala.liveroom.data.a oxz;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0933a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hLH = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cy cyVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bv bvVar = com.baidu.live.ae.a.Qj().bAS;
                    if (bvVar != null && (cyVar = bvVar.aPN) != null) {
                        str = cyVar.aSV;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, j, 3000);
                }
            }
        };
        this.hLI = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg.aIu;
                    i = com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, 1000L, i);
                }
            }
        };
        this.hLJ = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zU(false);
            }
        };
        this.hLK = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    ab abVar = null;
                    if (a.this.oxz != null && a.this.oxz.ouE != null) {
                        abVar = a.this.oxz.ouE.Fm();
                    }
                    if (abVar == null || abVar.aIz == null) {
                        a.this.zU(false);
                    } else {
                        a.this.zU(abVar.aIz.isNewUser);
                    }
                }
            }
        };
        this.hLL = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bAW = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.oxy != null) {
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
        this.hLM = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cka();
            }
        };
        MessageManager.getInstance().registerListener(this.hLH);
        MessageManager.getInstance().registerListener(this.hLI);
        MessageManager.getInstance().registerListener(this.hLJ);
        MessageManager.getInstance().registerListener(this.hLK);
        MessageManager.getInstance().registerListener(this.hLL);
        MessageManager.getInstance().registerListener(this.hLM);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void nV(boolean z) {
        if (this.oxy != null) {
            this.oxy.nV(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.oxy != null) {
            this.oxy.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.oxz = aVar;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            this.bRb = viewGroup2;
            if (this.oxy == null) {
                this.oxy = new AlaLiveBottomOperationView(getPageContext(), aVar);
            }
            this.oxy.Tw();
            this.oxy.registerListeners();
            this.oxy.setOnLiveViewOperationBtnClickListener(bVar);
            this.oxy.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup2.indexOfChild(this.oxy.getRootView()) >= 0) {
                viewGroup2.removeView(this.oxy.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.oxy.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.oxy.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            u.a(viewGroup2, this.oxy.getRootView(), layoutParams, 400);
            if (this.hLC == null) {
                this.hLC = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cjU();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.oxy.hIs != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.oxy.hIs.setVisibility(8);
                    if (this.oxy.hIs.getParent() != null && (this.oxy.hIs.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.oxy.hIs.getParent()).removeView(this.oxy.hIs);
                    }
                    aVar.hBG.getLiveContainerView().addView(this.oxy.hIs, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hLC.getParent() != null && (this.hLC.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLC.getParent()).removeView(this.hLC);
                    }
                    aVar.hBG.getLiveContainerView().addView(this.hLC, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.oxy.setGiftBtnVisible(false);
            } else {
                this.oxy.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.oxy.setQuickImInputVisible(false);
            } else {
                this.oxy.setQuickImInputVisible(true);
            }
            this.oxy.setChatBtnVisible(com.baidu.live.ae.b.Qv().Qw());
        }
    }

    private void cjU() {
    }

    public void cjW() {
        this.hLF = 0L;
        if (this.bRb != null && this.oxy != null && this.bRb.indexOfChild(this.oxy.getRootView()) > 0) {
            this.bRb.removeView(this.oxy.getRootView());
        }
        if (this.hLC != null && (this.hLC.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLC.getParent()).removeView(this.hLC);
        }
        if (this.oxy != null && this.oxy.hIs != null && (this.oxy.hIs.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.oxy.hIs.getParent()).removeView(this.oxy.hIs);
        }
        if (this.oxy != null) {
            this.oxy.ccE();
        }
    }

    public void setVisibility(int i) {
        if (this.oxy != null && this.oxy.getRootView() != null) {
            this.oxy.getRootView().setVisibility(i);
        }
        if (this.hLC != null) {
            this.hLC.setVisibility(i);
        }
    }

    public void a(o oVar, ab abVar) {
        if (this.oxy != null) {
            if (abVar != null && abVar.aIz != null) {
                zU(abVar.aIz.isNewUser);
            } else {
                zU(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.ES() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.ES().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.ES().DR());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.ES().DS());
                }
                if (abVar != null && abVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", abVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", abVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void a(InterfaceC0933a interfaceC0933a) {
    }

    public void Md(int i) {
        if (this.oxy != null && this.oxy.hIs != null) {
            this.oxy.hIs.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.oxy != null && this.oxy.hLT != null) {
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
                            FrameLayout frameLayout2 = a.this.oxy.hLT;
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
        this.hLF = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hLH);
        MessageManager.getInstance().unRegisterListener(this.hLI);
        MessageManager.getInstance().unRegisterListener(this.hLJ);
        MessageManager.getInstance().unRegisterListener(this.hLK);
        MessageManager.getInstance().unRegisterListener(this.hLL);
        MessageManager.getInstance().unRegisterListener(this.hLM);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.oxA = null;
        if (this.oxy != null) {
            this.oxy.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cka() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zU(boolean z) {
        boolean z2 = true;
        aq aqVar = com.baidu.tieba.yuyinala.liveroom.p.b.ebT().bvg;
        z2 = (aqVar == null || aqVar.aKc == 1 || StringUtils.isNull(aqVar.aKd, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
