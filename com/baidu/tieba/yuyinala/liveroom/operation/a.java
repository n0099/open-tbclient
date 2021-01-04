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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    CustomMessageTask.CustomRunnable bCf;
    private ViewGroup bRX;
    private CustomMessageListener hLB;
    private CustomMessageListener hLC;
    private CustomMessageListener hLD;
    private CustomMessageListener hLE;
    private CustomMessageListener hLF;
    private CustomMessageListener hLG;
    private FrameLayout hLw;
    private long hLz;
    private Handler handler;
    private AlaLiveBottomOperationView orR;
    private com.baidu.tieba.yuyinala.liveroom.data.a orS;
    private InterfaceC0906a orT;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0906a {
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hLB = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cs csVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bq bqVar = com.baidu.live.af.a.SE().bCb;
                    if (bqVar != null && (csVar = bqVar.aRC) != null) {
                        str = csVar.aUF;
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
        this.hLC = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr != null) {
                    str = com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr.aKL;
                    i = com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hLD = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zC(false);
            }
        };
        this.hLE = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    x xVar = null;
                    if (a.this.orS != null && a.this.orS.ooR != null) {
                        xVar = a.this.orS.ooR.HR();
                    }
                    if (xVar == null || xVar.aKQ == null) {
                        a.this.zC(false);
                    } else {
                        a.this.zC(xVar.aKQ.isNewUser);
                    }
                }
            }
        };
        this.hLF = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.bCf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.10
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.orR != null) {
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
        this.hLG = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cmL();
            }
        };
        MessageManager.getInstance().registerListener(this.hLB);
        MessageManager.getInstance().registerListener(this.hLC);
        MessageManager.getInstance().registerListener(this.hLD);
        MessageManager.getInstance().registerListener(this.hLE);
        MessageManager.getInstance().registerListener(this.hLF);
        MessageManager.getInstance().registerListener(this.hLG);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501066, this.bCf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void nO(boolean z) {
        if (this.orR != null) {
            this.orR.nO(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.orR != null) {
            this.orR.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.orS = aVar;
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            this.bRX = viewGroup2;
            if (this.orR == null) {
                this.orR = new AlaLiveBottomOperationView(getPageContext());
            }
            this.orR.VI();
            this.orR.registerListeners();
            this.orR.setOnLiveViewOperationBtnClickListener(bVar);
            this.orR.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup2.indexOfChild(this.orR.getRootView()) >= 0) {
                viewGroup2.removeView(this.orR.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.orR.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.orR.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            u.a(viewGroup2, this.orR.getRootView(), layoutParams, 400);
            if (this.hLw == null) {
                this.hLw = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.a(view, 8, null);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cmF();
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.orR.hIy != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.orR.hIy.setVisibility(8);
                    if (this.orR.hIy.getParent() != null && (this.orR.hIy.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.orR.hIy.getParent()).removeView(this.orR.hIy);
                    }
                    aVar.hBO.getLiveContainerView().addView(this.orR.hIy, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hLw.getParent() != null && (this.hLw.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLw.getParent()).removeView(this.hLw);
                    }
                    aVar.hBO.getLiveContainerView().addView(this.hLw, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                this.orR.setGiftBtnVisible(false);
            } else {
                this.orR.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                this.orR.setQuickImInputVisible(false);
            } else {
                this.orR.setQuickImInputVisible(true);
            }
            this.orR.setChatBtnVisible(com.baidu.live.af.b.SP().SQ());
        }
    }

    private void cmF() {
    }

    public void cmH() {
        this.hLz = 0L;
        if (this.bRX != null && this.orR != null && this.bRX.indexOfChild(this.orR.getRootView()) > 0) {
            this.bRX.removeView(this.orR.getRootView());
        }
        if (this.hLw != null && (this.hLw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLw.getParent()).removeView(this.hLw);
        }
        if (this.orR != null && this.orR.hIy != null && (this.orR.hIy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.orR.hIy.getParent()).removeView(this.orR.hIy);
        }
        if (this.orR != null) {
            this.orR.cft();
        }
    }

    public void setVisibility(int i) {
        if (this.orR != null && this.orR.getRootView() != null) {
            this.orR.getRootView().setVisibility(i);
        }
        if (this.hLw != null) {
            this.hLw.setVisibility(i);
        }
    }

    public void a(o oVar, x xVar) {
        if (this.orR != null) {
            if (xVar != null && xVar.aKQ != null) {
                zC(xVar.aKQ.isNewUser);
            } else {
                zC(false);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.Hx() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.Hx().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.Hx().Gx());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.Hx().Gy());
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

    public void a(InterfaceC0906a interfaceC0906a) {
    }

    public void No(int i) {
        if (this.orR != null && this.orR.hIy != null) {
            this.orR.hIy.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.orR != null && this.orR.hLN != null) {
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
                            FrameLayout frameLayout2 = a.this.orR.hLN;
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
        this.hLz = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hLB);
        MessageManager.getInstance().unRegisterListener(this.hLC);
        MessageManager.getInstance().unRegisterListener(this.hLD);
        MessageManager.getInstance().unRegisterListener(this.hLE);
        MessageManager.getInstance().unRegisterListener(this.hLF);
        MessageManager.getInstance().unRegisterListener(this.hLG);
        MessageManager.getInstance().unRegisterTask(2501066);
        this.orT = null;
        if (this.orR != null) {
            this.orR.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zC(boolean z) {
        boolean z2 = true;
        am amVar = com.baidu.tieba.yuyinala.liveroom.p.b.edp().bwr;
        z2 = (amVar == null || amVar.aMl == 1 || StringUtils.isNull(amVar.aMm, true)) ? false : false;
        HashMap hashMap = new HashMap(2);
        hashMap.put("is_new_user", Boolean.valueOf(z));
        hashMap.put("show_super_recharge", Boolean.valueOf(z2));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501025, hashMap));
    }
}
