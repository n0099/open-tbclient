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
/* loaded from: classes10.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aFH;
    public CustomMessageListener bhY;
    public CustomMessageListener bqe;
    private boolean bsd;
    private BdPageContext bsg;
    private int bsh;
    private CustomMessageListener cbL;
    private ImageView hJn;
    public FrameLayout hKb;
    public ImageView hNA;
    public TBLottieAnimationView hNB;
    public FrameLayout hNC;
    public ImageView hNR;
    public RelativeLayout hNz;
    private boolean hOi;
    private int hOk;
    private View hOm;
    private View hOn;
    private Handler hOq;
    private Animator.AnimatorListener hOt;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private a oAa;
    private CustomMessageListener oAb;
    private CustomMessageListener oAc;
    private CustomMessageListener oAd;
    private final com.baidu.tieba.yuyinala.liveroom.data.a ovA;
    private b ozJ;
    public RelativeLayout ozK;
    public FrameLayout ozL;
    public FrameLayout ozM;
    public FrameLayout ozN;
    public ImageView ozO;
    public TextView ozP;
    private TextView ozQ;
    private FrameLayout ozR;
    public View ozS;
    private View ozT;
    private View ozU;
    public CustomMessageListener ozV;
    public CustomMessageListener ozW;
    public CustomMessageListener ozX;
    public CustomMessageListener ozY;
    public CustomMessageListener ozZ;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext, com.baidu.tieba.yuyinala.liveroom.data.a aVar) {
        super(bdPageContext.getPageActivity());
        this.hOi = false;
        this.handler = new Handler();
        this.hOk = -1;
        this.bsh = 0;
        this.hOq = new Handler();
        this.hOt = new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hNB.setVisibility(8);
                AlaLiveBottomOperationView.this.hNA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.ozJ != null) {
                    if (view == AlaLiveBottomOperationView.this.ozR) {
                        AlaLiveBottomOperationView.this.ozJ.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.ozM) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(AlaLiveBottomOperationView.this.bsg.getPageActivity());
                            return;
                        }
                        HashMap hashMap = new HashMap(2);
                        hashMap.put("context", AlaLiveBottomOperationView.this.bsg);
                        hashMap.put("ala_live_show_data", AlaLiveBottomOperationView.this.ovA.owJ.Fp());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501006, hashMap));
                    } else if (view == AlaLiveBottomOperationView.this.ozL || view == AlaLiveBottomOperationView.this.ozK) {
                        AlaLiveBottomOperationView.this.hOm = view;
                        if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                            if (!AlaLiveBottomOperationView.this.bsd) {
                                AlaLiveBottomOperationView.this.cw(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bsh = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cw(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hNC) {
                        AlaLiveBottomOperationView.this.ae(null);
                    } else if (view == AlaLiveBottomOperationView.this.hNR) {
                        AlaLiveBottomOperationView.this.hOn = view;
                        if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                            if (AlaLiveBottomOperationView.this.bsd) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bsh = 2;
                            } else {
                                AlaLiveBottomOperationView.this.ozJ.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.ozJ.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.zU(true);
                    } else if (view == AlaLiveBottomOperationView.this.hKb) {
                        AlaLiveBottomOperationView.this.ozJ.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.ozN) {
                        if (view == AlaLiveBottomOperationView.this.ozT) {
                            AlaLiveBottomOperationView.this.ozJ.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.ecZ().Yt(), null, h.oIR, 0));
                    }
                }
            }
        };
        this.oAb = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.oAc = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.e.edy().a(AlaLiveBottomOperationView.this.ozO, AlaLiveBottomOperationView.this.ozP, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bsg);
                }
            }
        };
        this.oAd = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.ae((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bsh == 1 || AlaLiveBottomOperationView.this.bsh == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bsh == 1) {
                                    AlaLiveBottomOperationView.this.cw(AlaLiveBottomOperationView.this.hOm);
                                } else if (AlaLiveBottomOperationView.this.bsh == 2) {
                                    AlaLiveBottomOperationView.this.ozJ.a(AlaLiveBottomOperationView.this.hOn, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bsh = 0;
                    }
                }
            }
        };
        this.bsg = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        this.ovA = aVar;
        initView();
    }

    public void Tz() {
        ckh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nV(boolean z) {
        if (this.ozJ != null && z) {
            this.ozJ.a(this.hNC, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hNC.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.ozR.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible() {
        boolean iN = com.baidu.live.ao.a.Ym().iN(com.baidu.live.ao.a.Ym().Ys());
        this.ozO.setImageResource(iN ? a.e.yuyin_sdk_wheat_connected_wheat : a.e.yuyin_sdk_wheat_connecting_wheat);
        setSendView(iN);
        if (ebS()) {
            this.ozN.setVisibility(8);
            if (com.baidu.live.ao.a.Ym().Yn()) {
                this.ozN.setVisibility(iN ? 0 : 8);
                return;
            }
            return;
        }
        this.ozN.setVisibility(0);
    }

    private void setSendView(boolean z) {
        if (z && this.ozK.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            this.ozK.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveBottomOperationView.this.ozK.setVisibility(8);
                    AlaLiveBottomOperationView.this.ozL.setVisibility(0);
                    AlaLiveBottomOperationView.this.ozM.setVisibility(0);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    AlaLiveBottomOperationView.this.ozL.startAnimation(alphaAnimation);
                    AlaLiveBottomOperationView.this.ozM.startAnimation(alphaAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        } else if (!z && this.ozL.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            this.ozL.startAnimation(alphaAnimation);
            this.ozM.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveBottomOperationView.this.ozL.setVisibility(8);
                    AlaLiveBottomOperationView.this.ozM.setVisibility(8);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation2.setDuration(300L);
                    AlaLiveBottomOperationView.this.ozK.startAnimation(translateAnimation2);
                    AlaLiveBottomOperationView.this.ozK.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public boolean ebS() {
        ab abVar = null;
        if (this.ovA != null && this.ovA.owJ != null) {
            abVar = this.ovA.owJ.Fp();
        }
        if (abVar == null) {
            abVar = c.ecZ().Yt();
        }
        return (abVar == null || abVar.aKy == null || abVar.aKy.getRoomMode() != 100) ? false : true;
    }

    public void setQuickImInputVisible(boolean z) {
        this.hNR.setVisibility(z ? 0 : 8);
        this.ozS.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.ozT = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.hJn = (ImageView) this.rootView.findViewById(a.f.ala_audio_more_btn);
        this.ozU = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hNz = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.ozK = (RelativeLayout) this.rootView.findViewById(a.f.ala_audio_long_send_layout);
        this.hNA = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hNC = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.ozL = (FrameLayout) this.rootView.findViewById(a.f.ala_audio_short_send_layout);
        this.ozM = (FrameLayout) this.rootView.findViewById(a.f.ala_audio_short_emoji_layout);
        this.ozN = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.ozO = (ImageView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_btn);
        this.ozP = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.ozQ = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.ozR = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.ozS = this.rootView.findViewById(a.f.divider);
        this.hNR = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hKb = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hNB = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        this.hNB.setImageAssetsFolder("lottie/yuyinGiftImages");
        this.hNB.setAnimation("lottie/yuyin_liveshow_gift.json");
        this.hNB.setVisibility(8);
        this.hNB.addAnimatorListener(this.hOt);
        EG();
        setConnectWheatBtnVisible();
        if (TbadkCoreApplication.isLogin()) {
            this.hJn.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
                @Override // java.lang.Runnable
                public void run() {
                    ab abVar = null;
                    if (AlaLiveBottomOperationView.this.ovA != null && AlaLiveBottomOperationView.this.ovA.owJ != null) {
                        abVar = AlaLiveBottomOperationView.this.ovA.owJ.Fp();
                    }
                    if (abVar == null) {
                        abVar = c.ecZ().Yt();
                    }
                    new j().a(AlaLiveBottomOperationView.this.hJn, AlaLiveBottomOperationView.this.bsg, abVar);
                }
            }, 500L);
        }
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hOk != i) {
            this.hOk = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hNz.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hNz.setLayoutParams(layoutParams);
        }
    }

    private void EG() {
        this.hNC.setOnClickListener(this.aFH);
        this.ozL.setOnClickListener(this.aFH);
        this.ozM.setOnClickListener(this.aFH);
        this.ozN.setOnClickListener(this.aFH);
        this.ozR.setOnClickListener(this.aFH);
        this.hNz.setOnClickListener(this.aFH);
        this.ozK.setOnClickListener(this.aFH);
        this.hNR.setOnClickListener(this.aFH);
        this.hKb.setOnClickListener(this.aFH);
        this.ozT.setOnClickListener(this.aFH);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.ozJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zU(boolean z) {
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
        this.ozJ.a(this.hNC, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.ozJ.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
        this.ozJ.a(view, 1, null);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            zU(false);
        }
    }

    private void ckh() {
        if (this.oAa == null) {
            this.oAa = new a();
        }
        this.hOq.removeCallbacks(this.oAa);
        this.hOq.postDelayed(this.oAa, 5000L);
    }

    public void ccK() {
        if (this.hNB != null) {
            if (this.hNB.isAnimating()) {
                this.hNB.cancelAnimation();
            }
            this.hNB.setVisibility(8);
        }
        if (this.hNA != null) {
            this.hNA.setVisibility(0);
        }
        this.hOq.removeCallbacksAndMessages(null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bqe);
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.ozX);
        MessageManager.getInstance().unRegisterListener(this.ozV);
        MessageManager.getInstance().unRegisterListener(this.ozW);
        MessageManager.getInstance().unRegisterListener(this.ozY);
        MessageManager.getInstance().unRegisterListener(this.ozZ);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.oAb);
        MessageManager.getInstance().unRegisterListener(this.oAc);
        MessageManager.getInstance().unRegisterListener(this.oAd);
        MessageManager.getInstance().unRegisterListener(this.cbL);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bsd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bqT == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bqU);
            }
            this.mDialog = new BdAlertDialog(this.bsg.getPageActivity());
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
            this.mDialog.create(this.bsg);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bhY.setTag(this.bsg.getUniqueId());
        MessageManager.getInstance().registerListener(this.bhY);
        if (this.ozV == null) {
            this.ozV = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    AlaLiveBottomOperationView.this.ozJ.a(null, 3, null);
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ozV);
        this.ozW = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.ozJ.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.ozW);
        this.ozX = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.ozJ.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.ozX);
        this.ozY = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.ozU.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ozY);
        this.ozZ = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.Mi(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ozZ);
        this.cbL = new CustomMessageListener(2501074) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.setConnectWheatBtnVisible();
            }
        };
        MessageManager.getInstance().registerListener(this.cbL);
        this.bqe.setTag(this.bsg.getUniqueId());
        MessageManager.getInstance().registerListener(this.bqe);
        MessageManager.getInstance().registerListener(this.oAb);
        MessageManager.getInstance().registerListener(this.oAc);
        MessageManager.getInstance().registerListener(this.oAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi(int i) {
        if (i <= 0) {
            this.ozQ.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ozQ.getLayoutParams();
        layoutParams.width = Mk(i);
        this.ozQ.setLayoutParams(layoutParams);
        this.ozQ.setText(Mj(i));
        this.ozQ.setVisibility(0);
    }

    private String Mj(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int Mk(int i) {
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
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveBottomOperationView.this.hNB.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hNB.isAnimating()) {
                AlaLiveBottomOperationView.this.hNB.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hNB.playAnimation();
            AlaLiveBottomOperationView.this.hNA.setVisibility(4);
            AlaLiveBottomOperationView.this.hOq.removeCallbacks(AlaLiveBottomOperationView.this.oAa);
            AlaLiveBottomOperationView.this.hOq.postDelayed(AlaLiveBottomOperationView.this.oAa, 32000L);
        }
    }
}
