package com.baidu.tieba.yuyinala.liveroom.operation;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.yuyinala.liveroom.data.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.j;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aEh;
    public CustomMessageListener bgy;
    public CustomMessageListener boE;
    private boolean bqD;
    private BdPageContext bqG;
    private int bqH;
    private CustomMessageListener cak;
    private ImageView hHE;
    public FrameLayout hIs;
    public RelativeLayout hLQ;
    public ImageView hLR;
    public TBLottieAnimationView hLS;
    public FrameLayout hLT;
    private int hMB;
    private View hMD;
    private View hME;
    private Handler hMH;
    private Animator.AnimatorListener hMK;
    public ImageView hMi;
    private boolean hMz;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private final com.baidu.tieba.yuyinala.liveroom.data.a otu;
    private b oxE;
    public RelativeLayout oxF;
    public FrameLayout oxG;
    public FrameLayout oxH;
    public FrameLayout oxI;
    public ImageView oxJ;
    public TextView oxK;
    private TextView oxL;
    private FrameLayout oxM;
    public View oxN;
    private View oxO;
    private View oxP;
    public CustomMessageListener oxQ;
    public CustomMessageListener oxR;
    public CustomMessageListener oxS;
    public CustomMessageListener oxT;
    public CustomMessageListener oxU;
    private a oxV;
    private CustomMessageListener oxW;
    private CustomMessageListener oxX;
    private CustomMessageListener oxY;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext, com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        super(bdPageContext.getPageActivity());
        this.hMz = false;
        this.handler = new Handler();
        this.hMB = -1;
        this.bqH = 0;
        this.hMH = new Handler();
        this.hMK = new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hLS.setVisibility(8);
                AlaLiveBottomOperationView.this.hLR.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.oxE != null) {
                    if (view == AlaLiveBottomOperationView.this.oxM) {
                        AlaLiveBottomOperationView.this.oxE.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.oxH) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.bqG.getPageActivity());
                            return;
                        }
                        HashMap hashMap = new HashMap(2);
                        hashMap.put("context", AlaLiveBottomOperationView.this.bqG);
                        hashMap.put("ala_live_show_data", AlaLiveBottomOperationView.this.otu.ouE.Fm());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
                    } else if (view == AlaLiveBottomOperationView.this.oxG || view == AlaLiveBottomOperationView.this.oxF) {
                        AlaLiveBottomOperationView.this.hMD = view;
                        if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                            if (!AlaLiveBottomOperationView.this.bqD) {
                                AlaLiveBottomOperationView.this.cw(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqH = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cw(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hLT) {
                        AlaLiveBottomOperationView.this.ae(null);
                    } else if (view == AlaLiveBottomOperationView.this.hMi) {
                        AlaLiveBottomOperationView.this.hME = view;
                        if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                            if (AlaLiveBottomOperationView.this.bqD) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bqH = 2;
                            } else {
                                AlaLiveBottomOperationView.this.oxE.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.oxE.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.zV(true);
                    } else if (view == AlaLiveBottomOperationView.this.hIs) {
                        AlaLiveBottomOperationView.this.oxE.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.oxI) {
                        if (view == AlaLiveBottomOperationView.this.oxO) {
                            AlaLiveBottomOperationView.this.oxE.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.ecR().Yq(), null, h.oGM, 0));
                    }
                }
            }
        };
        this.oxW = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.oxX = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.e.edq().a(AlaLiveBottomOperationView.this.oxJ, AlaLiveBottomOperationView.this.oxK, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bqG);
                }
            }
        };
        this.oxY = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.ae((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bqH == 1 || AlaLiveBottomOperationView.this.bqH == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bqH == 1) {
                                    AlaLiveBottomOperationView.this.cw(AlaLiveBottomOperationView.this.hMD);
                                } else if (AlaLiveBottomOperationView.this.bqH == 2) {
                                    AlaLiveBottomOperationView.this.oxE.a(AlaLiveBottomOperationView.this.hME, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bqH = 0;
                    }
                }
            }
        };
        this.bqG = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        this.otu = aVar;
        initView();
    }

    public void Tw() {
        ckb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nV(boolean z) {
        if (this.oxE != null && z) {
            this.oxE.a(this.hLT, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hLT.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.oxM.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible() {
        boolean iH = com.baidu.live.ao.a.Yj().iH(com.baidu.live.ao.a.Yj().Yp());
        this.oxJ.setImageResource(iH ? a.e.yuyin_sdk_wheat_connected_wheat : a.e.yuyin_sdk_wheat_connecting_wheat);
        setSendView(iH);
        if (ebK()) {
            this.oxI.setVisibility(8);
            if (com.baidu.live.ao.a.Yj().Yk()) {
                this.oxI.setVisibility(iH ? 0 : 8);
                return;
            }
            return;
        }
        this.oxI.setVisibility(0);
    }

    private void setSendView(boolean z) {
        if (z && this.oxF.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            this.oxF.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveBottomOperationView.this.oxF.setVisibility(8);
                    AlaLiveBottomOperationView.this.oxG.setVisibility(0);
                    AlaLiveBottomOperationView.this.oxH.setVisibility(0);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    AlaLiveBottomOperationView.this.oxG.startAnimation(alphaAnimation);
                    AlaLiveBottomOperationView.this.oxH.startAnimation(alphaAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        } else if (!z && this.oxG.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            this.oxG.startAnimation(alphaAnimation);
            this.oxH.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveBottomOperationView.this.oxG.setVisibility(8);
                    AlaLiveBottomOperationView.this.oxH.setVisibility(8);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation2.setDuration(300L);
                    AlaLiveBottomOperationView.this.oxF.startAnimation(translateAnimation2);
                    AlaLiveBottomOperationView.this.oxF.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public boolean ebK() {
        ab abVar = null;
        if (this.otu != null && this.otu.ouE != null) {
            abVar = this.otu.ouE.Fm();
        }
        if (abVar == null) {
            abVar = c.ecR().Yq();
        }
        return (abVar == null || abVar.aIY == null || abVar.aIY.getRoomMode() != 100) ? false : true;
    }

    public void setQuickImInputVisible(boolean z) {
        this.hMi.setVisibility(z ? 0 : 8);
        this.oxN.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.oxO = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.hHE = (ImageView) this.rootView.findViewById(a.f.ala_audio_more_btn);
        this.oxP = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hLQ = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.oxF = (RelativeLayout) this.rootView.findViewById(a.f.ala_audio_long_send_layout);
        this.hLR = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hLT = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.oxG = (FrameLayout) this.rootView.findViewById(a.f.ala_audio_short_send_layout);
        this.oxH = (FrameLayout) this.rootView.findViewById(a.f.ala_audio_short_emoji_layout);
        this.oxI = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.oxJ = (ImageView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_btn);
        this.oxK = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.oxL = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.oxM = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.oxN = this.rootView.findViewById(a.f.divider);
        this.hMi = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hIs = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hLS = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        this.hLS.setImageAssetsFolder("lottie/yuyinGiftImages");
        this.hLS.setAnimation("lottie/yuyin_liveshow_gift.json");
        this.hLS.setVisibility(8);
        this.hLS.addAnimatorListener(this.hMK);
        ED();
        setConnectWheatBtnVisible();
        if (TbadkCoreApplication.isLogin()) {
            this.hHE.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
                @Override // java.lang.Runnable
                public void run() {
                    ab abVar = null;
                    if (AlaLiveBottomOperationView.this.otu != null && AlaLiveBottomOperationView.this.otu.ouE != null) {
                        abVar = AlaLiveBottomOperationView.this.otu.ouE.Fm();
                    }
                    if (abVar == null) {
                        abVar = c.ecR().Yq();
                    }
                    new j().a(AlaLiveBottomOperationView.this.hHE, AlaLiveBottomOperationView.this.bqG, abVar);
                }
            }, 500L);
        }
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hMB != i) {
            this.hMB = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLQ.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hLQ.setLayoutParams(layoutParams);
        }
    }

    private void ED() {
        this.hLT.setOnClickListener(this.aEh);
        this.oxG.setOnClickListener(this.aEh);
        this.oxH.setOnClickListener(this.aEh);
        this.oxI.setOnClickListener(this.aEh);
        this.oxM.setOnClickListener(this.aEh);
        this.hLQ.setOnClickListener(this.aEh);
        this.oxF.setOnClickListener(this.aEh);
        this.hMi.setOnClickListener(this.aEh);
        this.hIs.setOnClickListener(this.aEh);
        this.oxO.setOnClickListener(this.aEh);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.oxE = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? "quick" : "normal");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "speakbtn_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.oxE.a(this.hLT, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.oxE.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
        this.oxE.a(view, 1, null);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            zV(false);
        }
    }

    private void ckb() {
        if (this.oxV == null) {
            this.oxV = new a();
        }
        this.hMH.removeCallbacks(this.oxV);
        this.hMH.postDelayed(this.oxV, 5000L);
    }

    public void ccE() {
        if (this.hLS != null) {
            if (this.hLS.isAnimating()) {
                this.hLS.cancelAnimation();
            }
            this.hLS.setVisibility(8);
        }
        if (this.hLR != null) {
            this.hLR.setVisibility(0);
        }
        this.hMH.removeCallbacksAndMessages(null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.boE);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oxS);
        MessageManager.getInstance().unRegisterListener(this.oxQ);
        MessageManager.getInstance().unRegisterListener(this.oxR);
        MessageManager.getInstance().unRegisterListener(this.oxT);
        MessageManager.getInstance().unRegisterListener(this.oxU);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.oxW);
        MessageManager.getInstance().unRegisterListener(this.oxX);
        MessageManager.getInstance().unRegisterListener(this.oxY);
        MessageManager.getInstance().unRegisterListener(this.cak);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bpt == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bpu);
            }
            this.mDialog = new BdAlertDialog(this.bqG.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(AlaLiveBottomOperationView.this.getContext(), "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(AlaLiveBottomOperationView.this.getContext(), "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog.dismiss();
                }
            });
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.bqG);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bgy.setTag(this.bqG.getUniqueId());
        MessageManager.getInstance().registerListener(this.bgy);
        if (this.oxQ == null) {
            this.oxQ = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    AlaLiveBottomOperationView.this.oxE.a(null, 3, null);
                }
            };
        }
        MessageManager.getInstance().registerListener(this.oxQ);
        this.oxR = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.oxE.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.oxR);
        this.oxS = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.oxE.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.oxS);
        this.oxT = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.oxP.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.oxT);
        this.oxU = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.Me(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.oxU);
        this.cak = new CustomMessageListener(2501074) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.setConnectWheatBtnVisible();
            }
        };
        MessageManager.getInstance().registerListener(this.cak);
        this.boE.setTag(this.bqG.getUniqueId());
        MessageManager.getInstance().registerListener(this.boE);
        MessageManager.getInstance().registerListener(this.oxW);
        MessageManager.getInstance().registerListener(this.oxX);
        MessageManager.getInstance().registerListener(this.oxY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me(int i) {
        if (i <= 0) {
            this.oxL.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.oxL.getLayoutParams();
        layoutParams.width = Mg(i);
        this.oxL.setLayoutParams(layoutParams);
        this.oxL.setText(Mf(i));
        this.oxL.setVisibility(0);
    }

    private String Mf(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int Mg(int i) {
        if (i <= 0) {
            return 0;
        }
        if (i < 10) {
            return getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds32);
        }
        if (i < 100) {
            return getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds48);
        }
        return getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds60);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hLS.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hLS.isAnimating()) {
                AlaLiveBottomOperationView.this.hLS.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hLS.playAnimation();
            AlaLiveBottomOperationView.this.hLR.setVisibility(4);
            AlaLiveBottomOperationView.this.hMH.removeCallbacks(AlaLiveBottomOperationView.this.oxV);
            AlaLiveBottomOperationView.this.hMH.postDelayed(AlaLiveBottomOperationView.this.oxV, 32000L);
        }
    }
}
