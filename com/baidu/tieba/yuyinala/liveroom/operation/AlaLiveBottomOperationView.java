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
    private View.OnClickListener aGQ;
    public CustomMessageListener bgy;
    public CustomMessageListener bon;
    private boolean bqg;
    private BdPageContext bqi;
    private int bqj;
    public ImageView hAc;
    private boolean hAr;
    private int hAt;
    private View hAv;
    private View hAw;
    private Handler handler;
    public FrameLayout hwz;
    public RelativeLayout hzK;
    public ImageView hzL;
    public FrameLayout hzN;
    private Context mContext;
    private BdAlertDialog mDialog;
    private b ooD;
    public FrameLayout ooE;
    public TextView ooF;
    private TextView ooG;
    private FrameLayout ooH;
    public View ooI;
    private View ooJ;
    private View ooK;
    public CustomMessageListener ooL;
    public CustomMessageListener ooM;
    public CustomMessageListener ooN;
    public CustomMessageListener ooO;
    public CustomMessageListener ooP;
    public CustomMessageListener ooQ;
    private n ooR;
    private CustomMessageListener ooS;
    private CustomMessageListener ooT;
    private CustomMessageListener ooU;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hAr = false;
        this.handler = new Handler();
        this.hAt = -1;
        this.bqj = 0;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.ooD != null) {
                    if (view == AlaLiveBottomOperationView.this.ooH) {
                        AlaLiveBottomOperationView.this.ooD.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.hzK) {
                        AlaLiveBottomOperationView.this.hAv = view;
                        if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                            if (!AlaLiveBottomOperationView.this.bqg) {
                                AlaLiveBottomOperationView.this.cr(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bqj = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cr(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hzN) {
                        AlaLiveBottomOperationView.this.Z(null);
                    } else if (view == AlaLiveBottomOperationView.this.hAc) {
                        AlaLiveBottomOperationView.this.hAw = view;
                        if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                            if (AlaLiveBottomOperationView.this.bqg) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bqj = 2;
                            } else {
                                AlaLiveBottomOperationView.this.ooD.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.ooD.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.zD(true);
                    } else if (view == AlaLiveBottomOperationView.this.hwz) {
                        AlaLiveBottomOperationView.this.ooD.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.ooE) {
                        if (view == AlaLiveBottomOperationView.this.ooJ) {
                            AlaLiveBottomOperationView.this.ooD.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.eeo().Zd(), null, g.ouF, 0));
                    }
                }
            }
        };
        this.ooS = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.ooT = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    if (AlaLiveBottomOperationView.this.ooR == null) {
                        AlaLiveBottomOperationView.this.ooR = new n();
                    }
                    AlaLiveBottomOperationView.this.ooR.a(AlaLiveBottomOperationView.this.ooE, AlaLiveBottomOperationView.this.ooF, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bqi);
                }
            }
        };
        this.ooU = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.Z((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.bon = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bqj == 1 || AlaLiveBottomOperationView.this.bqj == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bqj == 1) {
                                    AlaLiveBottomOperationView.this.cr(AlaLiveBottomOperationView.this.hAv);
                                } else if (AlaLiveBottomOperationView.this.bqj == 2) {
                                    AlaLiveBottomOperationView.this.ooD.a(AlaLiveBottomOperationView.this.hAw, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bqj = 0;
                    }
                }
            }
        };
        this.bqi = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void no(boolean z) {
        if (this.ooD != null && z) {
            this.ooD.a(this.hzN, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hzN.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.ooH.setVisibility(z ? 0 : 8);
    }

    public void setMoreLayoutVisible(boolean z) {
        this.ooJ.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible(boolean z) {
        this.ooE.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.hAc.setVisibility(z ? 0 : 8);
        this.ooI.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.ooJ = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.ooK = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hzK = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hzL = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hzN = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.ooE = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.ooF = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.ooG = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.ooH = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.ooI = this.rootView.findViewById(a.f.divider);
        this.hAc = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hwz = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        HH();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hAt != i) {
            this.hAt = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hzK.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hzK.setLayoutParams(layoutParams);
        }
    }

    private void HH() {
        this.hzN.setOnClickListener(this.aGQ);
        this.ooE.setOnClickListener(this.aGQ);
        this.ooH.setOnClickListener(this.aGQ);
        this.hzK.setOnClickListener(this.aGQ);
        this.hAc.setOnClickListener(this.aGQ);
        this.hwz.setOnClickListener(this.aGQ);
        this.ooJ.setOnClickListener(this.aGQ);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.ooD = bVar;
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
    public void Z(String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.ooD.a(this.hzN, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.ooD.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            zD(false);
        }
        this.ooD.a(view, 1, null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bon);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.ooN);
        MessageManager.getInstance().unRegisterListener(this.ooL);
        MessageManager.getInstance().unRegisterListener(this.ooM);
        MessageManager.getInstance().unRegisterListener(this.ooO);
        MessageManager.getInstance().unRegisterListener(this.ooP);
        MessageManager.getInstance().unRegisterListener(this.ooQ);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.ooS);
        MessageManager.getInstance().unRegisterListener(this.ooT);
        MessageManager.getInstance().unRegisterListener(this.ooU);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bpe == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bpf);
            }
            this.mDialog = new BdAlertDialog(this.bqi.getPageActivity());
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
            this.mDialog.create(this.bqi);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bgy.setTag(this.bqi.getUniqueId());
        MessageManager.getInstance().registerListener(this.bgy);
        if (this.ooL == null) {
            this.ooL = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    AlaLiveBottomOperationView.this.ooD.a(null, 3, null);
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ooL);
        this.ooM = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.ooD.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.ooM);
        this.ooN = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.ooD.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.ooN);
        this.ooO = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.ooK.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ooO);
        this.ooP = new CustomMessageListener(2501016) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501016 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.ooJ.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ooP);
        this.ooQ = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.NC(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ooQ);
        this.bon.setTag(this.bqi.getUniqueId());
        MessageManager.getInstance().registerListener(this.bon);
        MessageManager.getInstance().registerListener(this.ooS);
        MessageManager.getInstance().registerListener(this.ooT);
        MessageManager.getInstance().registerListener(this.ooU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC(int i) {
        if (i <= 0) {
            this.ooG.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ooG.getLayoutParams();
        layoutParams.width = NE(i);
        this.ooG.setLayoutParams(layoutParams);
        this.ooG.setText(ND(i));
        this.ooG.setVisibility(0);
    }

    private String ND(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int NE(int i) {
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
