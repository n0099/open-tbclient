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
    private ImageView hHq;
    public FrameLayout hIe;
    public RelativeLayout hLC;
    public ImageView hLD;
    public TBLottieAnimationView hLE;
    public FrameLayout hLF;
    public ImageView hLU;
    private boolean hMl;
    private int hMn;
    private View hMp;
    private View hMq;
    private Handler hMt;
    private Animator.AnimatorListener hMw;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private final com.baidu.tieba.yuyinala.liveroom.data.a osU;
    private b oxe;
    public RelativeLayout oxf;
    public FrameLayout oxg;
    public FrameLayout oxh;
    public FrameLayout oxi;
    public ImageView oxj;
    public TextView oxk;
    private TextView oxl;
    private FrameLayout oxm;
    public View oxn;
    private View oxo;
    private View oxp;
    public CustomMessageListener oxq;
    public CustomMessageListener oxr;
    public CustomMessageListener oxs;
    public CustomMessageListener oxt;
    public CustomMessageListener oxu;
    private a oxv;
    private CustomMessageListener oxw;
    private CustomMessageListener oxx;
    private CustomMessageListener oxy;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext, com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        super(bdPageContext.getPageActivity());
        this.hMl = false;
        this.handler = new Handler();
        this.hMn = -1;
        this.bqH = 0;
        this.hMt = new Handler();
        this.hMw = new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hLE.setVisibility(8);
                AlaLiveBottomOperationView.this.hLD.setVisibility(0);
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
                if (AlaLiveBottomOperationView.this.oxe != null) {
                    if (view == AlaLiveBottomOperationView.this.oxm) {
                        AlaLiveBottomOperationView.this.oxe.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.oxh) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.bqG.getPageActivity());
                            return;
                        }
                        HashMap hashMap = new HashMap(2);
                        hashMap.put("context", AlaLiveBottomOperationView.this.bqG);
                        hashMap.put("ala_live_show_data", AlaLiveBottomOperationView.this.osU.oud.Fm());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
                    } else if (view == AlaLiveBottomOperationView.this.oxg || view == AlaLiveBottomOperationView.this.oxf) {
                        AlaLiveBottomOperationView.this.hMp = view;
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
                    } else if (view == AlaLiveBottomOperationView.this.hLF) {
                        AlaLiveBottomOperationView.this.ae(null);
                    } else if (view == AlaLiveBottomOperationView.this.hLU) {
                        AlaLiveBottomOperationView.this.hMq = view;
                        if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                            if (AlaLiveBottomOperationView.this.bqD) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bqH = 2;
                            } else {
                                AlaLiveBottomOperationView.this.oxe.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.oxe.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.zV(true);
                    } else if (view == AlaLiveBottomOperationView.this.hIe) {
                        AlaLiveBottomOperationView.this.oxe.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.oxi) {
                        if (view == AlaLiveBottomOperationView.this.oxo) {
                            AlaLiveBottomOperationView.this.oxe.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.ecJ().Yq(), null, h.oGm, 0));
                    }
                }
            }
        };
        this.oxw = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.oxx = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.e.edi().a(AlaLiveBottomOperationView.this.oxj, AlaLiveBottomOperationView.this.oxk, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bqG);
                }
            }
        };
        this.oxy = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.17
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
                                    AlaLiveBottomOperationView.this.cw(AlaLiveBottomOperationView.this.hMp);
                                } else if (AlaLiveBottomOperationView.this.bqH == 2) {
                                    AlaLiveBottomOperationView.this.oxe.a(AlaLiveBottomOperationView.this.hMq, 11, null);
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
        this.osU = aVar;
        initView();
    }

    public void Tw() {
        cjU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nV(boolean z) {
        if (this.oxe != null && z) {
            this.oxe.a(this.hLF, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hLF.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.oxm.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible() {
        boolean iH = com.baidu.live.ao.a.Yj().iH(com.baidu.live.ao.a.Yj().Yp());
        this.oxj.setImageResource(iH ? a.e.yuyin_sdk_wheat_connected_wheat : a.e.yuyin_sdk_wheat_connecting_wheat);
        setSendView(iH);
        if (ebC()) {
            this.oxi.setVisibility(8);
            if (com.baidu.live.ao.a.Yj().Yk()) {
                this.oxi.setVisibility(iH ? 0 : 8);
                return;
            }
            return;
        }
        this.oxi.setVisibility(0);
    }

    private void setSendView(boolean z) {
        if (z && this.oxf.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            this.oxf.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveBottomOperationView.this.oxf.setVisibility(8);
                    AlaLiveBottomOperationView.this.oxg.setVisibility(0);
                    AlaLiveBottomOperationView.this.oxh.setVisibility(0);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    AlaLiveBottomOperationView.this.oxg.startAnimation(alphaAnimation);
                    AlaLiveBottomOperationView.this.oxh.startAnimation(alphaAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        } else if (!z && this.oxg.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            this.oxg.startAnimation(alphaAnimation);
            this.oxh.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveBottomOperationView.this.oxg.setVisibility(8);
                    AlaLiveBottomOperationView.this.oxh.setVisibility(8);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation2.setDuration(300L);
                    AlaLiveBottomOperationView.this.oxf.startAnimation(translateAnimation2);
                    AlaLiveBottomOperationView.this.oxf.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public boolean ebC() {
        ab abVar = null;
        if (this.osU != null && this.osU.oud != null) {
            abVar = this.osU.oud.Fm();
        }
        if (abVar == null) {
            abVar = c.ecJ().Yq();
        }
        return (abVar == null || abVar.aIY == null || abVar.aIY.getRoomMode() != 100) ? false : true;
    }

    public void setQuickImInputVisible(boolean z) {
        this.hLU.setVisibility(z ? 0 : 8);
        this.oxn.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.oxo = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.hHq = (ImageView) this.rootView.findViewById(a.f.ala_audio_more_btn);
        this.oxp = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hLC = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.oxf = (RelativeLayout) this.rootView.findViewById(a.f.ala_audio_long_send_layout);
        this.hLD = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hLF = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.oxg = (FrameLayout) this.rootView.findViewById(a.f.ala_audio_short_send_layout);
        this.oxh = (FrameLayout) this.rootView.findViewById(a.f.ala_audio_short_emoji_layout);
        this.oxi = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.oxj = (ImageView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_btn);
        this.oxk = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.oxl = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.oxm = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.oxn = this.rootView.findViewById(a.f.divider);
        this.hLU = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hIe = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hLE = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        this.hLE.setImageAssetsFolder("lottie/yuyinGiftImages");
        this.hLE.setAnimation("lottie/yuyin_liveshow_gift.json");
        this.hLE.setVisibility(8);
        this.hLE.addAnimatorListener(this.hMw);
        ED();
        setConnectWheatBtnVisible();
        if (TbadkCoreApplication.isLogin()) {
            this.hHq.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
                @Override // java.lang.Runnable
                public void run() {
                    ab abVar = null;
                    if (AlaLiveBottomOperationView.this.osU != null && AlaLiveBottomOperationView.this.osU.oud != null) {
                        abVar = AlaLiveBottomOperationView.this.osU.oud.Fm();
                    }
                    if (abVar == null) {
                        abVar = c.ecJ().Yq();
                    }
                    new j().a(AlaLiveBottomOperationView.this.hHq, AlaLiveBottomOperationView.this.bqG, abVar);
                }
            }, 500L);
        }
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hMn != i) {
            this.hMn = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLC.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hLC.setLayoutParams(layoutParams);
        }
    }

    private void ED() {
        this.hLF.setOnClickListener(this.aEh);
        this.oxg.setOnClickListener(this.aEh);
        this.oxh.setOnClickListener(this.aEh);
        this.oxi.setOnClickListener(this.aEh);
        this.oxm.setOnClickListener(this.aEh);
        this.hLC.setOnClickListener(this.aEh);
        this.oxf.setOnClickListener(this.aEh);
        this.hLU.setOnClickListener(this.aEh);
        this.hIe.setOnClickListener(this.aEh);
        this.oxo.setOnClickListener(this.aEh);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.oxe = bVar;
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
        this.oxe.a(this.hLF, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.oxe.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
        this.oxe.a(view, 1, null);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            zV(false);
        }
    }

    private void cjU() {
        if (this.oxv == null) {
            this.oxv = new a();
        }
        this.hMt.removeCallbacks(this.oxv);
        this.hMt.postDelayed(this.oxv, 5000L);
    }

    public void ccx() {
        if (this.hLE != null) {
            if (this.hLE.isAnimating()) {
                this.hLE.cancelAnimation();
            }
            this.hLE.setVisibility(8);
        }
        if (this.hLD != null) {
            this.hLD.setVisibility(0);
        }
        this.hMt.removeCallbacksAndMessages(null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.boE);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oxs);
        MessageManager.getInstance().unRegisterListener(this.oxq);
        MessageManager.getInstance().unRegisterListener(this.oxr);
        MessageManager.getInstance().unRegisterListener(this.oxt);
        MessageManager.getInstance().unRegisterListener(this.oxu);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.oxw);
        MessageManager.getInstance().unRegisterListener(this.oxx);
        MessageManager.getInstance().unRegisterListener(this.oxy);
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
        if (this.oxq == null) {
            this.oxq = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    AlaLiveBottomOperationView.this.oxe.a(null, 3, null);
                }
            };
        }
        MessageManager.getInstance().registerListener(this.oxq);
        this.oxr = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.oxe.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.oxr);
        this.oxs = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.oxe.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.oxs);
        this.oxt = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.oxp.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.oxt);
        this.oxu = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.Md(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.oxu);
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
        MessageManager.getInstance().registerListener(this.oxw);
        MessageManager.getInstance().registerListener(this.oxx);
        MessageManager.getInstance().registerListener(this.oxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Md(int i) {
        if (i <= 0) {
            this.oxl.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.oxl.getLayoutParams();
        layoutParams.width = Mf(i);
        this.oxl.setLayoutParams(layoutParams);
        this.oxl.setText(Me(i));
        this.oxl.setVisibility(0);
    }

    private String Me(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int Mf(int i) {
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
            AlaLiveBottomOperationView.this.hLE.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hLE.isAnimating()) {
                AlaLiveBottomOperationView.this.hLE.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hLE.playAnimation();
            AlaLiveBottomOperationView.this.hLD.setVisibility(4);
            AlaLiveBottomOperationView.this.hMt.removeCallbacks(AlaLiveBottomOperationView.this.oxv);
            AlaLiveBottomOperationView.this.hMt.postDelayed(AlaLiveBottomOperationView.this.oxv, 32000L);
        }
    }
}
