package com.baidu.tieba.yuyinala.liveroom.operation;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.n;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aCu;
    private CustomMessageListener bWi;
    public CustomMessageListener bdo;
    public CustomMessageListener blj;
    private boolean bnc;
    private BdPageContext bnf;
    private int bng;
    public FrameLayout hDS;
    private boolean hHN;
    private int hHP;
    private View hHR;
    private View hHS;
    private Handler hHV;
    private Animator.AnimatorListener hHY;
    public RelativeLayout hHe;
    public ImageView hHf;
    public TBLottieAnimationView hHg;
    public FrameLayout hHh;
    public ImageView hHw;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    public CustomMessageListener onA;
    public CustomMessageListener onB;
    public CustomMessageListener onC;
    public CustomMessageListener onD;
    private n onE;
    private a onF;
    private CustomMessageListener onG;
    private CustomMessageListener onH;
    private CustomMessageListener onI;
    private b onq;
    public FrameLayout onr;
    public ImageView ons;
    public TextView ont;
    private TextView onu;
    private FrameLayout onv;
    public View onw;
    private View onx;
    private View ony;
    public CustomMessageListener onz;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hHN = false;
        this.handler = new Handler();
        this.hHP = -1;
        this.bng = 0;
        this.hHV = new Handler();
        this.hHY = new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hHg.setVisibility(8);
                AlaLiveBottomOperationView.this.hHf.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.onq != null) {
                    if (view == AlaLiveBottomOperationView.this.onv) {
                        AlaLiveBottomOperationView.this.onq.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.hHe) {
                        AlaLiveBottomOperationView.this.hHR = view;
                        if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                            if (!AlaLiveBottomOperationView.this.bnc) {
                                AlaLiveBottomOperationView.this.cA(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bng = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cA(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hHh) {
                        AlaLiveBottomOperationView.this.ae(null);
                    } else if (view == AlaLiveBottomOperationView.this.hHw) {
                        AlaLiveBottomOperationView.this.hHS = view;
                        if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                            if (AlaLiveBottomOperationView.this.bnc) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bng = 2;
                            } else {
                                AlaLiveBottomOperationView.this.onq.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.onq.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.zz(true);
                    } else if (view == AlaLiveBottomOperationView.this.hDS) {
                        AlaLiveBottomOperationView.this.onq.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.onr) {
                        if (view == AlaLiveBottomOperationView.this.onx) {
                            AlaLiveBottomOperationView.this.onq.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.eax().WA(), null, g.owN, 0));
                    }
                }
            }
        };
        this.onG = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.onH = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    if (AlaLiveBottomOperationView.this.onE == null) {
                        AlaLiveBottomOperationView.this.onE = new n();
                    }
                    AlaLiveBottomOperationView.this.onE.a(AlaLiveBottomOperationView.this.onr, AlaLiveBottomOperationView.this.ont, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bnf);
                }
            }
        };
        this.onI = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.ae((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bng == 1 || AlaLiveBottomOperationView.this.bng == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bng == 1) {
                                    AlaLiveBottomOperationView.this.cA(AlaLiveBottomOperationView.this.hHR);
                                } else if (AlaLiveBottomOperationView.this.bng == 2) {
                                    AlaLiveBottomOperationView.this.onq.a(AlaLiveBottomOperationView.this.hHS, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bng = 0;
                    }
                }
            }
        };
        this.bnf = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void RP() {
        ciV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nK(boolean z) {
        if (this.onq != null && z) {
            this.onq.a(this.hHh, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hHh.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.onv.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible(boolean z) {
        this.onr.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.hHw.setVisibility(z ? 0 : 8);
        this.onw.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.onx = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.ony = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hHe = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hHf = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hHh = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.onr = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.ons = (ImageView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_btn);
        this.ont = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.onu = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.onv = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.onw = this.rootView.findViewById(a.f.divider);
        this.hHw = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hDS = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hHg = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        this.hHg.setImageAssetsFolder("lottie/yuyinGiftImages");
        this.hHg.setAnimation("lottie/yuyin_liveshow_gift.json");
        this.hHg.setVisibility(8);
        this.hHg.addAnimatorListener(this.hHY);
        Dn();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hHP != i) {
            this.hHP = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHe.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hHe.setLayoutParams(layoutParams);
        }
    }

    private void Dn() {
        this.hHh.setOnClickListener(this.aCu);
        this.onr.setOnClickListener(this.aCu);
        this.onv.setOnClickListener(this.aCu);
        this.hHe.setOnClickListener(this.aCu);
        this.hHw.setOnClickListener(this.aCu);
        this.hDS.setOnClickListener(this.aCu);
        this.onx.setOnClickListener(this.aCu);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.onq = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz(boolean z) {
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
        this.onq.a(this.hHh, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.onq.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        this.onq.a(view, 1, null);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            zz(false);
        }
    }

    private void ciV() {
        if (this.onF == null) {
            this.onF = new a();
        }
        this.hHV.removeCallbacks(this.onF);
        this.hHV.postDelayed(this.onF, 5000L);
    }

    public void cbC() {
        if (this.hHg != null) {
            if (this.hHg.isAnimating()) {
                this.hHg.cancelAnimation();
            }
            this.hHg.setVisibility(8);
        }
        if (this.hHf != null) {
            this.hHf.setVisibility(0);
        }
        this.hHV.removeCallbacksAndMessages(null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.blj);
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.onB);
        MessageManager.getInstance().unRegisterListener(this.onz);
        MessageManager.getInstance().unRegisterListener(this.onA);
        MessageManager.getInstance().unRegisterListener(this.onC);
        MessageManager.getInstance().unRegisterListener(this.onD);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.onG);
        MessageManager.getInstance().unRegisterListener(this.onH);
        MessageManager.getInstance().unRegisterListener(this.onI);
        MessageManager.getInstance().unRegisterListener(this.bWi);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bnc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.blY == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.blZ);
            }
            this.mDialog = new BdAlertDialog(this.bnf.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
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
            this.mDialog.create(this.bnf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bdo.setTag(this.bnf.getUniqueId());
        MessageManager.getInstance().registerListener(this.bdo);
        if (this.onz == null) {
            this.onz = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    AlaLiveBottomOperationView.this.onq.a(null, 3, null);
                }
            };
        }
        MessageManager.getInstance().registerListener(this.onz);
        this.onA = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.onq.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.onA);
        this.onB = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.onq.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.onB);
        this.onC = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.ony.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.onC);
        this.onD = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.LI(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.onD);
        this.bWi = new CustomMessageListener(2501074) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.ons.setImageResource(com.baidu.live.aq.a.Wu().ib(com.baidu.live.aq.a.Wu().Wz()) ? a.e.yuyin_sdk_wheat_connected_wheat : a.e.yuyin_sdk_wheat_connecting_wheat);
            }
        };
        MessageManager.getInstance().registerListener(this.bWi);
        this.blj.setTag(this.bnf.getUniqueId());
        MessageManager.getInstance().registerListener(this.blj);
        MessageManager.getInstance().registerListener(this.onG);
        MessageManager.getInstance().registerListener(this.onH);
        MessageManager.getInstance().registerListener(this.onI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LI(int i) {
        if (i <= 0) {
            this.onu.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.onu.getLayoutParams();
        layoutParams.width = LK(i);
        this.onu.setLayoutParams(layoutParams);
        this.onu.setText(LJ(i));
        this.onu.setVisibility(0);
    }

    private String LJ(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int LK(int i) {
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
            AlaLiveBottomOperationView.this.hHg.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hHg.isAnimating()) {
                AlaLiveBottomOperationView.this.hHg.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hHg.playAnimation();
            AlaLiveBottomOperationView.this.hHf.setVisibility(4);
            AlaLiveBottomOperationView.this.hHV.removeCallbacks(AlaLiveBottomOperationView.this.onF);
            AlaLiveBottomOperationView.this.hHV.postDelayed(AlaLiveBottomOperationView.this.onF, 32000L);
        }
    }
}
