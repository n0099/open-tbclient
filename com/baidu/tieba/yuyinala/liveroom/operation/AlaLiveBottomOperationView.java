package com.baidu.tieba.yuyinala.liveroom.operation;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.yuyinala.liveroom.data.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.n;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aEk;
    public CustomMessageListener bcy;
    private boolean bkX;
    private BdPageContext bkZ;
    private int bla;
    public CustomMessageListener blf;
    private Handler handler;
    public FrameLayout hmU;
    private boolean hqN;
    private int hqP;
    private View hqR;
    private View hqS;
    public RelativeLayout hqg;
    public ImageView hqh;
    public FrameLayout hqj;
    public ImageView hqy;
    private Context mContext;
    private BdAlertDialog mDialog;
    private b nZD;
    public FrameLayout nZE;
    public TextView nZF;
    private TextView nZG;
    private FrameLayout nZH;
    public View nZI;
    private View nZJ;
    private View nZK;
    public CustomMessageListener nZL;
    public CustomMessageListener nZM;
    public CustomMessageListener nZN;
    public CustomMessageListener nZO;
    public CustomMessageListener nZP;
    public CustomMessageListener nZQ;
    private n nZR;
    private CustomMessageListener nZS;
    private CustomMessageListener nZT;
    private CustomMessageListener nZU;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hqN = false;
        this.handler = new Handler();
        this.hqP = -1;
        this.bla = 0;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.nZD != null) {
                    if (view == AlaLiveBottomOperationView.this.nZH) {
                        AlaLiveBottomOperationView.this.nZD.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.hqg) {
                        AlaLiveBottomOperationView.this.hqR = view;
                        if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                            if (!AlaLiveBottomOperationView.this.bkX) {
                                AlaLiveBottomOperationView.this.ck(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bla = 1;
                        } else {
                            AlaLiveBottomOperationView.this.ck(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hqj) {
                        AlaLiveBottomOperationView.this.Y(null);
                    } else if (view == AlaLiveBottomOperationView.this.hqy) {
                        AlaLiveBottomOperationView.this.hqS = view;
                        if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                            if (AlaLiveBottomOperationView.this.bkX) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bla = 2;
                            } else {
                                AlaLiveBottomOperationView.this.nZD.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.nZD.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.yZ(true);
                    } else if (view == AlaLiveBottomOperationView.this.hmU) {
                        AlaLiveBottomOperationView.this.nZD.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.nZE) {
                        if (view == AlaLiveBottomOperationView.this.nZJ) {
                            AlaLiveBottomOperationView.this.nZD.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.dYK().WE(), null, g.ofF, 0));
                    }
                }
            }
        };
        this.nZS = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.nZT = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    if (AlaLiveBottomOperationView.this.nZR == null) {
                        AlaLiveBottomOperationView.this.nZR = new n();
                    }
                    AlaLiveBottomOperationView.this.nZR.a(AlaLiveBottomOperationView.this.nZE, AlaLiveBottomOperationView.this.nZF, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bkZ);
                }
            }
        };
        this.nZU = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.Y((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.blf = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bla == 1 || AlaLiveBottomOperationView.this.bla == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bla == 1) {
                                    AlaLiveBottomOperationView.this.ck(AlaLiveBottomOperationView.this.hqR);
                                } else if (AlaLiveBottomOperationView.this.bla == 2) {
                                    AlaLiveBottomOperationView.this.nZD.a(AlaLiveBottomOperationView.this.hqS, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bla = 0;
                    }
                }
            }
        };
        this.bkZ = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mT(boolean z) {
        if (this.nZD != null && z) {
            this.nZD.a(this.hqj, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hqj.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.nZH.setVisibility(z ? 0 : 8);
    }

    public void setMoreLayoutVisible(boolean z) {
        this.nZJ.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible(boolean z) {
        this.nZE.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.hqy.setVisibility(z ? 0 : 8);
        this.nZI.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.nZJ = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.nZK = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hqg = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hqh = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hqj = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.nZE = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.nZF = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.nZG = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.nZH = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.nZI = this.rootView.findViewById(a.f.divider);
        this.hqy = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hmU = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        FS();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hqP != i) {
            this.hqP = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqg.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hqg.setLayoutParams(layoutParams);
        }
    }

    private void FS() {
        this.hqj.setOnClickListener(this.aEk);
        this.nZE.setOnClickListener(this.aEk);
        this.nZH.setOnClickListener(this.aEk);
        this.hqg.setOnClickListener(this.aEk);
        this.hqy.setOnClickListener(this.aEk);
        this.hmU.setOnClickListener(this.aEk);
        this.nZJ.setOnClickListener(this.aEk);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.nZD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yZ(boolean z) {
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
    public void Y(String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.nZD.a(this.hqj, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.nZD.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            yZ(false);
        }
        this.nZD.a(view, 1, null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.blf);
        MessageManager.getInstance().unRegisterListener(this.bcy);
        MessageManager.getInstance().unRegisterListener(this.nZN);
        MessageManager.getInstance().unRegisterListener(this.nZL);
        MessageManager.getInstance().unRegisterListener(this.nZM);
        MessageManager.getInstance().unRegisterListener(this.nZO);
        MessageManager.getInstance().unRegisterListener(this.nZP);
        MessageManager.getInstance().unRegisterListener(this.nZQ);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.nZS);
        MessageManager.getInstance().unRegisterListener(this.nZT);
        MessageManager.getInstance().unRegisterListener(this.nZU);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bkX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bka == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bkb);
            }
            this.mDialog = new BdAlertDialog(this.bkZ.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.10
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
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
            this.mDialog.create(this.bkZ);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bcy.setTag(this.bkZ.getUniqueId());
        MessageManager.getInstance().registerListener(this.bcy);
        this.nZL = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nZD.a(null, 3, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nZL);
        this.nZM = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nZD.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nZM);
        this.nZN = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nZD.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nZN);
        this.nZO = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.nZK.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nZO);
        this.nZP = new CustomMessageListener(2501016) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501016 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.nZJ.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nZP);
        this.nZQ = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.MK(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nZQ);
        this.blf.setTag(this.bkZ.getUniqueId());
        MessageManager.getInstance().registerListener(this.blf);
        MessageManager.getInstance().registerListener(this.nZS);
        MessageManager.getInstance().registerListener(this.nZT);
        MessageManager.getInstance().registerListener(this.nZU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MK(int i) {
        if (i <= 0) {
            this.nZG.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.nZG.getLayoutParams();
        layoutParams.width = MM(i);
        this.nZG.setLayoutParams(layoutParams);
        this.nZG.setText(ML(i));
        this.nZG.setVisibility(0);
    }

    private String ML(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int MM(int i) {
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
}
