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
/* loaded from: classes11.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aHh;
    public CustomMessageListener bih;
    public CustomMessageListener bpW;
    private boolean brO;
    private BdPageContext brR;
    private int brS;
    private CustomMessageListener caU;
    public FrameLayout hIy;
    public RelativeLayout hLK;
    public ImageView hLL;
    public TBLottieAnimationView hLM;
    public FrameLayout hLN;
    private Handler hMB;
    private Animator.AnimatorListener hME;
    public ImageView hMc;
    private boolean hMt;
    private int hMv;
    private View hMx;
    private View hMy;
    private Handler handler;
    private Context mContext;
    private BdAlertDialog mDialog;
    private b orX;
    public FrameLayout orY;
    public ImageView orZ;
    public TextView osa;
    private TextView osb;
    private FrameLayout osc;
    public View osd;
    private View ose;
    private View osf;
    public CustomMessageListener osg;
    public CustomMessageListener osh;
    public CustomMessageListener osi;
    public CustomMessageListener osj;
    public CustomMessageListener osk;
    private n osl;
    private a osm;
    private CustomMessageListener osn;
    private CustomMessageListener oso;
    private CustomMessageListener osp;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hMt = false;
        this.handler = new Handler();
        this.hMv = -1;
        this.brS = 0;
        this.hMB = new Handler();
        this.hME = new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveBottomOperationView.this.hLM.setVisibility(8);
                AlaLiveBottomOperationView.this.hLL.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.orX != null) {
                    if (view == AlaLiveBottomOperationView.this.osc) {
                        AlaLiveBottomOperationView.this.orX.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.hLK) {
                        AlaLiveBottomOperationView.this.hMx = view;
                        if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                            if (!AlaLiveBottomOperationView.this.brO) {
                                AlaLiveBottomOperationView.this.cA(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.brS = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cA(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hLN) {
                        AlaLiveBottomOperationView.this.ae(null);
                    } else if (view == AlaLiveBottomOperationView.this.hMc) {
                        AlaLiveBottomOperationView.this.hMy = view;
                        if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                            if (AlaLiveBottomOperationView.this.brO) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.brS = 2;
                            } else {
                                AlaLiveBottomOperationView.this.orX.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.orX.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.zD(true);
                    } else if (view == AlaLiveBottomOperationView.this.hIy) {
                        AlaLiveBottomOperationView.this.orX.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.orY) {
                        if (view == AlaLiveBottomOperationView.this.ose) {
                            AlaLiveBottomOperationView.this.orX.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.eeo().aas(), null, g.oBs, 0));
                    }
                }
            }
        };
        this.osn = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.oso = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    if (AlaLiveBottomOperationView.this.osl == null) {
                        AlaLiveBottomOperationView.this.osl = new n();
                    }
                    AlaLiveBottomOperationView.this.osl.a(AlaLiveBottomOperationView.this.orY, AlaLiveBottomOperationView.this.osa, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.brR);
                }
            }
        };
        this.osp = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.ae((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.brS == 1 || AlaLiveBottomOperationView.this.brS == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.brS == 1) {
                                    AlaLiveBottomOperationView.this.cA(AlaLiveBottomOperationView.this.hMx);
                                } else if (AlaLiveBottomOperationView.this.brS == 2) {
                                    AlaLiveBottomOperationView.this.orX.a(AlaLiveBottomOperationView.this.hMy, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.brS = 0;
                    }
                }
            }
        };
        this.brR = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    public void VI() {
        cmM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO(boolean z) {
        if (this.orX != null && z) {
            this.orX.a(this.hLN, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hLN.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.osc.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible(boolean z) {
        this.orY.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.hMc.setVisibility(z ? 0 : 8);
        this.osd.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.ose = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.osf = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hLK = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hLL = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hLN = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.orY = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.orZ = (ImageView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_btn);
        this.osa = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.osb = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.osc = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.osd = this.rootView.findViewById(a.f.divider);
        this.hMc = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hIy = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        this.hLM = (TBLottieAnimationView) this.rootView.findViewById(a.f.ala_live_room_gift_btn_lottie);
        this.hLM.setImageAssetsFolder("lottie/yuyinGiftImages");
        this.hLM.setAnimation("lottie/yuyin_liveshow_gift.json");
        this.hLM.setVisibility(8);
        this.hLM.addAnimatorListener(this.hME);
        Hi();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hMv != i) {
            this.hMv = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLK.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hLK.setLayoutParams(layoutParams);
        }
    }

    private void Hi() {
        this.hLN.setOnClickListener(this.aHh);
        this.orY.setOnClickListener(this.aHh);
        this.osc.setOnClickListener(this.aHh);
        this.hLK.setOnClickListener(this.aHh);
        this.hMc.setOnClickListener(this.aHh);
        this.hIy.setOnClickListener(this.aHh);
        this.ose.setOnClickListener(this.aHh);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.orX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zD(boolean z) {
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
        this.orX.a(this.hLN, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.orX.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        this.orX.a(view, 1, null);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            zD(false);
        }
    }

    private void cmM() {
        if (this.osm == null) {
            this.osm = new a();
        }
        this.hMB.removeCallbacks(this.osm);
        this.hMB.postDelayed(this.osm, 5000L);
    }

    public void cft() {
        if (this.hLM != null) {
            if (this.hLM.isAnimating()) {
                this.hLM.cancelAnimation();
            }
            this.hLM.setVisibility(8);
        }
        if (this.hLL != null) {
            this.hLL.setVisibility(0);
        }
        this.hMB.removeCallbacksAndMessages(null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bpW);
        MessageManager.getInstance().unRegisterListener(this.bih);
        MessageManager.getInstance().unRegisterListener(this.osi);
        MessageManager.getInstance().unRegisterListener(this.osg);
        MessageManager.getInstance().unRegisterListener(this.osh);
        MessageManager.getInstance().unRegisterListener(this.osj);
        MessageManager.getInstance().unRegisterListener(this.osk);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.osn);
        MessageManager.getInstance().unRegisterListener(this.oso);
        MessageManager.getInstance().unRegisterListener(this.osp);
        MessageManager.getInstance().unRegisterListener(this.caU);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.brO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bqL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bqM);
            }
            this.mDialog = new BdAlertDialog(this.brR.getPageActivity());
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
            this.mDialog.create(this.brR);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bih.setTag(this.brR.getUniqueId());
        MessageManager.getInstance().registerListener(this.bih);
        if (this.osg == null) {
            this.osg = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    AlaLiveBottomOperationView.this.orX.a(null, 3, null);
                }
            };
        }
        MessageManager.getInstance().registerListener(this.osg);
        this.osh = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.orX.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.osh);
        this.osi = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.orX.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.osi);
        this.osj = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.osf.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.osj);
        this.osk = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.Np(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.osk);
        this.caU = new CustomMessageListener(2501074) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.orZ.setImageResource(com.baidu.live.aq.a.aam().jm(com.baidu.live.aq.a.aam().aar()) ? a.e.yuyin_sdk_wheat_connected_wheat : a.e.yuyin_sdk_wheat_connecting_wheat);
            }
        };
        MessageManager.getInstance().registerListener(this.caU);
        this.bpW.setTag(this.brR.getUniqueId());
        MessageManager.getInstance().registerListener(this.bpW);
        MessageManager.getInstance().registerListener(this.osn);
        MessageManager.getInstance().registerListener(this.oso);
        MessageManager.getInstance().registerListener(this.osp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Np(int i) {
        if (i <= 0) {
            this.osb.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.osb.getLayoutParams();
        layoutParams.width = Nr(i);
        this.osb.setLayoutParams(layoutParams);
        this.osb.setText(Nq(i));
        this.osb.setVisibility(0);
    }

    private String Nq(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int Nr(int i) {
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
            AlaLiveBottomOperationView.this.hLM.setVisibility(0);
            if (AlaLiveBottomOperationView.this.hLM.isAnimating()) {
                AlaLiveBottomOperationView.this.hLM.cancelAnimation();
            }
            AlaLiveBottomOperationView.this.hLM.playAnimation();
            AlaLiveBottomOperationView.this.hLL.setVisibility(4);
            AlaLiveBottomOperationView.this.hMB.removeCallbacks(AlaLiveBottomOperationView.this.osm);
            AlaLiveBottomOperationView.this.hMB.postDelayed(AlaLiveBottomOperationView.this.osm, 32000L);
        }
    }
}
