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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    CustomMessageTask.CustomRunnable bCw;
    private ViewGroup bSB;
    private FrameLayout hNl;
    private long hNo;
    private CustomMessageListener hNq;
    private CustomMessageListener hNr;
    private CustomMessageListener hNs;
    private CustomMessageListener hNt;
    private CustomMessageListener hNu;
    private CustomMessageListener hNv;
    private Handler handler;
    private String otherParams;
    private AlaLiveBottomOperationView ozD;
    private com.baidu.tieba.yuyinala.liveroom.data.a ozE;
    private InterfaceC0939a ozF;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0939a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hNq = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cy cyVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bv bvVar = com.baidu.live.ae.a.Qm().bCs;
                    if (bvVar != null && (cyVar = bvVar.aRn) != null) {
                        str = cyVar.aUv;
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
        this.hNr = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG.aJU;
                    i = com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, 1000L, i);
                }
            }
        };
        this.hNs = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zT(false);
            }
        };
        this.hNt = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    ab abVar = null;
                    if (a.this.ozE != null && a.this.ozE.owJ != null) {
                        abVar = a.this.ozE.owJ.Fp();
                    }
                    if (abVar == null || abVar.aJZ == null) {
                        a.this.zT(false);
                    } else {
                        a.this.zT(abVar.aJZ.isNewUser);
                    }
                }
            }
        };
        this.hNu = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bCw = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.ozD != null) {
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
        this.hNv = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ckg();
            }
        };
        MessageManager.getInstance().registerListener(this.hNq);
        MessageManager.getInstance().registerListener(this.hNr);
        MessageManager.getInstance().registerListener(this.hNs);
        MessageManager.getInstance().registerListener(this.hNt);
        MessageManager.getInstance().registerListener(this.hNu);
        MessageManager.getInstance().registerListener(this.hNv);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bCw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void nV(boolean z) {
        if (this.ozD != null) {
            this.ozD.nV(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.ozD != null) {
            this.ozD.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.ozE = aVar;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            this.bSB = viewGroup2;
            if (this.ozD == null) {
                this.ozD = new AlaLiveBottomOperationView(getPageContext(), aVar);
            }
            this.ozD.Tz();
            this.ozD.registerListeners();
            this.ozD.setOnLiveViewOperationBtnClickListener(bVar);
            this.ozD.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup2.indexOfChild(this.ozD.getRootView()) >= 0) {
                viewGroup2.removeView(this.ozD.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.ozD.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.ozD.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            u.a(viewGroup2, this.ozD.getRootView(), layoutParams, 400);
            if (this.hNl == null) {
                this.hNl = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cka();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.ozD.hKb != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.ozD.hKb.setVisibility(8);
                    if (this.ozD.hKb.getParent() != null && (this.ozD.hKb.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.ozD.hKb.getParent()).removeView(this.ozD.hKb);
                    }
                    aVar.hDp.getLiveContainerView().addView(this.ozD.hKb, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hNl.getParent() != null && (this.hNl.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hNl.getParent()).removeView(this.hNl);
                    }
                    aVar.hDp.getLiveContainerView().addView(this.hNl, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.ozD.setGiftBtnVisible(false);
            } else {
                this.ozD.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.ozD.setQuickImInputVisible(false);
            } else {
                this.ozD.setQuickImInputVisible(true);
            }
            this.ozD.setChatBtnVisible(com.baidu.live.ae.b.Qy().Qz());
        }
    }

    private void cka() {
    }

    public void ckc() {
        this.hNo = 0L;
        if (this.bSB != null && this.ozD != null && this.bSB.indexOfChild(this.ozD.getRootView()) > 0) {
            this.bSB.removeView(this.ozD.getRootView());
        }
        if (this.hNl != null && (this.hNl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hNl.getParent()).removeView(this.hNl);
        }
        if (this.ozD != null && this.ozD.hKb != null && (this.ozD.hKb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ozD.hKb.getParent()).removeView(this.ozD.hKb);
        }
        if (this.ozD != null) {
            this.ozD.ccK();
        }
    }

    public void setVisibility(int i) {
        if (this.ozD != null && this.ozD.getRootView() != null) {
            this.ozD.getRootView().setVisibility(i);
        }
        if (this.hNl != null) {
            this.hNl.setVisibility(i);
        }
    }

    public void a(o oVar, ab abVar) {
        if (this.ozD != null) {
            if (abVar != null && abVar.aJZ != null) {
                zT(abVar.aJZ.isNewUser);
            } else {
                zT(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.EV() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.EV().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.EV().DU());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.EV().DV());
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

    public void a(InterfaceC0939a interfaceC0939a) {
    }

    public void Mh(int i) {
        if (this.ozD != null && this.ozD.hKb != null) {
            this.ozD.hKb.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.ozD != null && this.ozD.hNC != null) {
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
                            FrameLayout frameLayout2 = a.this.ozD.hNC;
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
        this.hNo = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hNq);
        MessageManager.getInstance().unRegisterListener(this.hNr);
        MessageManager.getInstance().unRegisterListener(this.hNs);
        MessageManager.getInstance().unRegisterListener(this.hNt);
        MessageManager.getInstance().unRegisterListener(this.hNu);
        MessageManager.getInstance().unRegisterListener(this.hNv);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.ozF = null;
        if (this.ozD != null) {
            this.ozD.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(boolean z) {
        boolean z2 = true;
        aq aqVar = com.baidu.tieba.yuyinala.liveroom.p.b.ecb().bwG;
        z2 = (aqVar == null || aqVar.aLC == 1 || StringUtils.isNull(aqVar.aLD, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
