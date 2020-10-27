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
import com.baidu.tieba.yuyinala.liveroom.wheat.b.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.m;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveBottomOperationView extends FrameLayout {
    private View.OnClickListener aFf;
    public CustomMessageListener bcQ;
    private boolean blo;
    private BdPageContext blq;
    private int blr;
    public CustomMessageListener blw;
    private Handler handler;
    public FrameLayout hht;
    public RelativeLayout hkH;
    public ImageView hkI;
    public FrameLayout hkJ;
    public ImageView hkY;
    private boolean hlm;
    private int hlo;
    private View hlq;
    private View hlr;
    private Context mContext;
    private BdAlertDialog mDialog;
    private b nQQ;
    public FrameLayout nQR;
    public TextView nQS;
    private TextView nQT;
    private FrameLayout nQU;
    public View nQV;
    private View nQW;
    private View nQX;
    public CustomMessageListener nQY;
    public CustomMessageListener nQZ;
    public CustomMessageListener nRa;
    public CustomMessageListener nRb;
    public CustomMessageListener nRc;
    public CustomMessageListener nRd;
    private m nRe;
    private CustomMessageListener nRf;
    private CustomMessageListener nRg;
    private CustomMessageListener nRh;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hlm = false;
        this.handler = new Handler();
        this.hlo = -1;
        this.blr = 0;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.nQQ != null) {
                    if (view == AlaLiveBottomOperationView.this.nQU) {
                        AlaLiveBottomOperationView.this.nQQ.b(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.hkH) {
                        AlaLiveBottomOperationView.this.hlq = view;
                        if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                            if (!AlaLiveBottomOperationView.this.blo) {
                                AlaLiveBottomOperationView.this.cc(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.blr = 1;
                        } else {
                            AlaLiveBottomOperationView.this.cc(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hkJ) {
                        AlaLiveBottomOperationView.this.Va(null);
                    } else if (view == AlaLiveBottomOperationView.this.hkY) {
                        AlaLiveBottomOperationView.this.hlr = view;
                        if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                            if (AlaLiveBottomOperationView.this.blo) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.blr = 2;
                            } else {
                                AlaLiveBottomOperationView.this.nQQ.b(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.nQQ.b(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.yJ(true);
                    } else if (view == AlaLiveBottomOperationView.this.hht) {
                        AlaLiveBottomOperationView.this.nQQ.b(view, 8, null);
                    } else if (view == AlaLiveBottomOperationView.this.nQR) {
                        AlaLiveBottomOperationView.this.LP(f.nWw);
                    } else if (view == AlaLiveBottomOperationView.this.nQW) {
                        AlaLiveBottomOperationView.this.nQQ.b(view, 22, null);
                    }
                }
            }
        };
        this.nRf = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null) {
                    AlaLiveBottomOperationView.this.LP(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        this.nRg = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    if (AlaLiveBottomOperationView.this.nRe == null) {
                        AlaLiveBottomOperationView.this.nRe = new m();
                    }
                    AlaLiveBottomOperationView.this.nRe.a(AlaLiveBottomOperationView.this.nQR, AlaLiveBottomOperationView.this.nQS, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.blq);
                }
            }
        };
        this.nRh = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String)) {
                    AlaLiveBottomOperationView.this.Va((String) customResponsedMessage.getData());
                }
            }
        };
        this.blw = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.blr == 1 || AlaLiveBottomOperationView.this.blr == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.blr == 1) {
                                    AlaLiveBottomOperationView.this.cc(AlaLiveBottomOperationView.this.hlq);
                                } else if (AlaLiveBottomOperationView.this.blr == 2) {
                                    AlaLiveBottomOperationView.this.nQQ.b(AlaLiveBottomOperationView.this.hlr, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.blr = 0;
                    }
                }
            }
        };
        this.blq = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mJ(boolean z) {
        if (this.nQQ != null && z) {
            this.nQQ.b(this.hkJ, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hkJ.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.nQU.setVisibility(z ? 0 : 8);
    }

    public void setMoreLayoutVisible(boolean z) {
        this.nQW.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible(boolean z) {
        this.nQR.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.hkY.setVisibility(z ? 0 : 8);
        this.nQV.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.h.yuyinala_liveroom_vertical_bottom_operation, this);
        this.nQW = this.rootView.findViewById(a.g.ala_audio_more_layout);
        this.nQX = this.rootView.findViewById(a.g.func_red_dot_iv);
        this.hkH = (RelativeLayout) this.rootView.findViewById(a.g.ala_live_room_guest_message_layout);
        this.hkI = (ImageView) this.rootView.findViewById(a.g.ala_live_room_gift_btn);
        this.hkJ = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_gift_layout);
        this.nQR = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_connect_wheat_layout);
        this.nQS = (TextView) this.rootView.findViewById(a.g.ala_live_room_connect_wheat_red_dot_iv);
        this.nQT = (TextView) this.rootView.findViewById(a.g.ala_live_room_chat_num_tv);
        this.nQU = (FrameLayout) this.rootView.findViewById(a.g.ala_live_room_chat_btn_layout);
        this.nQV = this.rootView.findViewById(a.g.divider);
        this.hkY = (ImageView) this.rootView.findViewById(a.g.iv_quick_im_input);
        this.hht = (FrameLayout) View.inflate(this.mContext, a.h.ala_live_room_top_pure_layout_hk, null);
        Ga();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hlo != i) {
            this.hlo = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkH.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.g.optLayout);
            }
            this.hkH.setLayoutParams(layoutParams);
        }
    }

    private void Ga() {
        this.hkJ.setOnClickListener(this.aFf);
        this.nQR.setOnClickListener(this.aFf);
        this.nQU.setOnClickListener(this.aFf);
        this.hkH.setOnClickListener(this.aFf);
        this.hkY.setOnClickListener(this.aFf);
        this.hht.setOnClickListener(this.aFf);
        this.nQW.setOnClickListener(this.aFf);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.nQQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ(boolean z) {
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
    public void Va(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.nQQ.b(this.hkJ, 2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LP(int i) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        this.nQR.setTag(Integer.valueOf(i));
        this.nQQ.b(this.nQR, 21, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            yJ(false);
        }
        this.nQQ.b(view, 1, null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.blw);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.nRa);
        MessageManager.getInstance().unRegisterListener(this.nQY);
        MessageManager.getInstance().unRegisterListener(this.nQZ);
        MessageManager.getInstance().unRegisterListener(this.nRb);
        MessageManager.getInstance().unRegisterListener(this.nRc);
        MessageManager.getInstance().unRegisterListener(this.nRd);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.nRf);
        MessageManager.getInstance().unRegisterListener(this.nRg);
        MessageManager.getInstance().unRegisterListener(this.nRh);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.blo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bkr == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bks);
            }
            this.mDialog = new BdAlertDialog(this.blq.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.10
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.blq);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bcQ.setTag(this.blq.getUniqueId());
        MessageManager.getInstance().registerListener(this.bcQ);
        this.nQY = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nQQ.b(null, 3, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nQY);
        this.nQZ = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nQQ.b(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nQZ);
        this.nRa = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nQQ.b(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nRa);
        this.nRb = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.nQX.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nRb);
        this.nRc = new CustomMessageListener(2501016) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501016 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.nQW.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nRc);
        this.nRd = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.LQ(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nRd);
        this.blw.setTag(this.blq.getUniqueId());
        MessageManager.getInstance().registerListener(this.blw);
        MessageManager.getInstance().registerListener(this.nRf);
        MessageManager.getInstance().registerListener(this.nRg);
        MessageManager.getInstance().registerListener(this.nRh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LQ(int i) {
        if (i <= 0) {
            this.nQT.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.nQT.getLayoutParams();
        layoutParams.width = LS(i);
        this.nQT.setLayoutParams(layoutParams);
        this.nQT.setText(LR(i));
        this.nQT.setVisibility(0);
    }

    private String LR(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int LS(int i) {
        if (i <= 0) {
            return 0;
        }
        if (i < 10) {
            return getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds32);
        }
        if (i < 100) {
            return getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds48);
        }
        return getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds60);
    }
}
