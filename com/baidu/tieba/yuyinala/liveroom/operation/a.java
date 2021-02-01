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
    private FrameLayout hLo;
    private long hLr;
    private CustomMessageListener hLt;
    private CustomMessageListener hLu;
    private CustomMessageListener hLv;
    private CustomMessageListener hLw;
    private CustomMessageListener hLx;
    private CustomMessageListener hLy;
    private Handler handler;
    private String otherParams;
    private AlaLiveBottomOperationView owY;
    private com.baidu.tieba.yuyinala.liveroom.data.a owZ;
    private InterfaceC0931a oxa;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0931a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hLt = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
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
        this.hLu = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg.aIu;
                    i = com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, 1000L, i);
                }
            }
        };
        this.hLv = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zU(false);
            }
        };
        this.hLw = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    ab abVar = null;
                    if (a.this.owZ != null && a.this.owZ.oud != null) {
                        abVar = a.this.owZ.oud.Fm();
                    }
                    if (abVar == null || abVar.aIz == null) {
                        a.this.zU(false);
                    } else {
                        a.this.zU(abVar.aIz.isNewUser);
                    }
                }
            }
        };
        this.hLx = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
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
                    if (a.this.owY != null) {
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
        this.hLy = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cjT();
            }
        };
        MessageManager.getInstance().registerListener(this.hLt);
        MessageManager.getInstance().registerListener(this.hLu);
        MessageManager.getInstance().registerListener(this.hLv);
        MessageManager.getInstance().registerListener(this.hLw);
        MessageManager.getInstance().registerListener(this.hLx);
        MessageManager.getInstance().registerListener(this.hLy);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void nV(boolean z) {
        if (this.owY != null) {
            this.owY.nV(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.owY != null) {
            this.owY.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.owZ = aVar;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            this.bRb = viewGroup2;
            if (this.owY == null) {
                this.owY = new AlaLiveBottomOperationView(getPageContext(), aVar);
            }
            this.owY.Tw();
            this.owY.registerListeners();
            this.owY.setOnLiveViewOperationBtnClickListener(bVar);
            this.owY.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup2.indexOfChild(this.owY.getRootView()) >= 0) {
                viewGroup2.removeView(this.owY.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.owY.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.owY.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            u.a(viewGroup2, this.owY.getRootView(), layoutParams, 400);
            if (this.hLo == null) {
                this.hLo = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cjN();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.owY.hIe != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.owY.hIe.setVisibility(8);
                    if (this.owY.hIe.getParent() != null && (this.owY.hIe.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.owY.hIe.getParent()).removeView(this.owY.hIe);
                    }
                    aVar.hBs.getLiveContainerView().addView(this.owY.hIe, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hLo.getParent() != null && (this.hLo.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLo.getParent()).removeView(this.hLo);
                    }
                    aVar.hBs.getLiveContainerView().addView(this.hLo, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.owY.setGiftBtnVisible(false);
            } else {
                this.owY.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.owY.setQuickImInputVisible(false);
            } else {
                this.owY.setQuickImInputVisible(true);
            }
            this.owY.setChatBtnVisible(com.baidu.live.ae.b.Qv().Qw());
        }
    }

    private void cjN() {
    }

    public void cjP() {
        this.hLr = 0L;
        if (this.bRb != null && this.owY != null && this.bRb.indexOfChild(this.owY.getRootView()) > 0) {
            this.bRb.removeView(this.owY.getRootView());
        }
        if (this.hLo != null && (this.hLo.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLo.getParent()).removeView(this.hLo);
        }
        if (this.owY != null && this.owY.hIe != null && (this.owY.hIe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.owY.hIe.getParent()).removeView(this.owY.hIe);
        }
        if (this.owY != null) {
            this.owY.ccx();
        }
    }

    public void setVisibility(int i) {
        if (this.owY != null && this.owY.getRootView() != null) {
            this.owY.getRootView().setVisibility(i);
        }
        if (this.hLo != null) {
            this.hLo.setVisibility(i);
        }
    }

    public void a(o oVar, ab abVar) {
        if (this.owY != null) {
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

    public void a(InterfaceC0931a interfaceC0931a) {
    }

    public void Mc(int i) {
        if (this.owY != null && this.owY.hIe != null) {
            this.owY.hIe.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.owY != null && this.owY.hLF != null) {
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
                            FrameLayout frameLayout2 = a.this.owY.hLF;
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
        this.hLr = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hLt);
        MessageManager.getInstance().unRegisterListener(this.hLu);
        MessageManager.getInstance().unRegisterListener(this.hLv);
        MessageManager.getInstance().unRegisterListener(this.hLw);
        MessageManager.getInstance().unRegisterListener(this.hLx);
        MessageManager.getInstance().unRegisterListener(this.hLy);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.oxa = null;
        if (this.owY != null) {
            this.owY.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjT() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zU(boolean z) {
        boolean z2 = true;
        aq aqVar = com.baidu.tieba.yuyinala.liveroom.p.b.ebL().bvg;
        z2 = (aqVar == null || aqVar.aKc == 1 || StringUtils.isNull(aqVar.aKd, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
