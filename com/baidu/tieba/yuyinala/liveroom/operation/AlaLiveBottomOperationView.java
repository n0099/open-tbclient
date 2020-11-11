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
    private View.OnClickListener aFV;
    public CustomMessageListener bek;
    private boolean bmI;
    private BdPageContext bmK;
    private int bmL;
    public CustomMessageListener bmQ;
    private Handler handler;
    public FrameLayout hnn;
    public ImageView hqA;
    public FrameLayout hqC;
    public ImageView hqR;
    public RelativeLayout hqz;
    private boolean hrg;
    private int hri;
    private View hrk;
    private View hrl;
    private Context mContext;
    private BdAlertDialog mDialog;
    private b nYa;
    public FrameLayout nYb;
    public TextView nYc;
    private TextView nYd;
    private FrameLayout nYe;
    public View nYf;
    private View nYg;
    private View nYh;
    public CustomMessageListener nYi;
    public CustomMessageListener nYj;
    public CustomMessageListener nYk;
    public CustomMessageListener nYl;
    public CustomMessageListener nYm;
    public CustomMessageListener nYn;
    private n nYo;
    private CustomMessageListener nYp;
    private CustomMessageListener nYq;
    private CustomMessageListener nYr;
    public View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlaLiveBottomOperationView(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity());
        this.hrg = false;
        this.handler = new Handler();
        this.hri = -1;
        this.bmL = 0;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveBottomOperationView.this.nYa != null) {
                    if (view == AlaLiveBottomOperationView.this.nYe) {
                        AlaLiveBottomOperationView.this.nYa.a(view, 23, null);
                    } else if (view == AlaLiveBottomOperationView.this.hqz) {
                        AlaLiveBottomOperationView.this.hrk = view;
                        if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(AlaLiveBottomOperationView.this.mContext).isIMLogined()) {
                            BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                            if (!AlaLiveBottomOperationView.this.bmI) {
                                AlaLiveBottomOperationView.this.ch(view);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            AlaLiveBottomOperationView.this.bmL = 1;
                        } else {
                            AlaLiveBottomOperationView.this.ch(view);
                        }
                    } else if (view == AlaLiveBottomOperationView.this.hqC) {
                        AlaLiveBottomOperationView.this.X(null);
                    } else if (view == AlaLiveBottomOperationView.this.hqR) {
                        AlaLiveBottomOperationView.this.hrl = view;
                        if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                            if (AlaLiveBottomOperationView.this.bmI) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                                AlaLiveBottomOperationView.this.bmL = 2;
                            } else {
                                AlaLiveBottomOperationView.this.nYa.a(view, 11, null);
                            }
                        } else {
                            AlaLiveBottomOperationView.this.nYa.a(view, 11, null);
                        }
                        AlaLiveBottomOperationView.this.yS(true);
                    } else if (view == AlaLiveBottomOperationView.this.hnn) {
                        AlaLiveBottomOperationView.this.nYa.a(view, 8, null);
                    } else if (view != AlaLiveBottomOperationView.this.nYb) {
                        if (view == AlaLiveBottomOperationView.this.nYg) {
                            AlaLiveBottomOperationView.this.nYa.a(view, 22, null);
                        }
                    } else {
                        AlaLiveBottomOperationView.this.a(new e(c.dYL().Xn(), null, g.oeb, 0));
                    }
                }
            }
        };
        this.nYp = new CustomMessageListener(2501010) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501010 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e)) {
                    AlaLiveBottomOperationView.this.a((e) customResponsedMessage.getData());
                }
            }
        };
        this.nYq = new CustomMessageListener(2501027) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501027 && (customResponsedMessage.getData() instanceof String)) {
                    if (AlaLiveBottomOperationView.this.nYo == null) {
                        AlaLiveBottomOperationView.this.nYo = new n();
                    }
                    AlaLiveBottomOperationView.this.nYo.a(AlaLiveBottomOperationView.this.nYb, AlaLiveBottomOperationView.this.nYc, (String) customResponsedMessage.getData(), AlaLiveBottomOperationView.this.bmK);
                }
            }
        };
        this.nYr = new CustomMessageListener(2501011) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501011 && (customResponsedMessage.getData() instanceof String[])) {
                    AlaLiveBottomOperationView.this.X((String[]) customResponsedMessage.getData());
                }
            }
        };
        this.bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (AlaLiveBottomOperationView.this.bmL == 1 || AlaLiveBottomOperationView.this.bmL == 2) {
                        if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                            YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                            if (yuyinImForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(AlaLiveBottomOperationView.this.getContext(), AlaLiveBottomOperationView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (yuyinImForbiddenStateData.banState == 0) {
                                if (AlaLiveBottomOperationView.this.bmL == 1) {
                                    AlaLiveBottomOperationView.this.ch(AlaLiveBottomOperationView.this.hrk);
                                } else if (AlaLiveBottomOperationView.this.bmL == 2) {
                                    AlaLiveBottomOperationView.this.nYa.a(AlaLiveBottomOperationView.this.hrl, 11, null);
                                }
                            } else {
                                AlaLiveBottomOperationView.this.a(yuyinImForbiddenStateData);
                            }
                        }
                        AlaLiveBottomOperationView.this.bmL = 0;
                    }
                }
            }
        };
        this.bmK = bdPageContext;
        this.mContext = bdPageContext.getPageActivity();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mS(boolean z) {
        if (this.nYa != null && z) {
            this.nYa.a(this.hqC, 2, null);
        }
    }

    public void setGiftBtnVisible(boolean z) {
        this.hqC.setVisibility(z ? 0 : 8);
    }

    public void setChatBtnVisible(boolean z) {
        this.nYe.setVisibility(z ? 0 : 8);
    }

    public void setMoreLayoutVisible(boolean z) {
        this.nYg.setVisibility(z ? 0 : 8);
    }

    public void setConnectWheatBtnVisible(boolean z) {
        this.nYb.setVisibility(z ? 0 : 8);
    }

    public void setQuickImInputVisible(boolean z) {
        this.hqR.setVisibility(z ? 0 : 8);
        this.nYf.setVisibility(z ? 0 : 8);
    }

    private void initView() {
        this.rootView = View.inflate(this.mContext, a.g.yuyinala_liveroom_vertical_bottom_operation, this);
        this.nYg = this.rootView.findViewById(a.f.ala_audio_more_layout);
        this.nYh = this.rootView.findViewById(a.f.func_red_dot_iv);
        this.hqz = (RelativeLayout) this.rootView.findViewById(a.f.ala_live_room_guest_message_layout);
        this.hqA = (ImageView) this.rootView.findViewById(a.f.ala_live_room_gift_btn);
        this.hqC = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_gift_layout);
        this.nYb = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_layout);
        this.nYc = (TextView) this.rootView.findViewById(a.f.ala_live_room_connect_wheat_red_dot_iv);
        this.nYd = (TextView) this.rootView.findViewById(a.f.ala_live_room_chat_num_tv);
        this.nYe = (FrameLayout) this.rootView.findViewById(a.f.ala_live_room_chat_btn_layout);
        this.nYf = this.rootView.findViewById(a.f.divider);
        this.hqR = (ImageView) this.rootView.findViewById(a.f.iv_quick_im_input);
        this.hnn = (FrameLayout) View.inflate(this.mContext, a.g.ala_live_room_top_pure_layout_hk, null);
        GB();
    }

    public void setMsgLayoutWidth(boolean z) {
        int i = z ? 2 : 1;
        if (this.hri != i) {
            this.hri = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqz.getLayoutParams();
            if (z) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds400);
                layoutParams.addRule(0, 0);
            } else {
                layoutParams.width = -1;
                layoutParams.addRule(0, a.f.optLayout);
            }
            this.hqz.setLayoutParams(layoutParams);
        }
    }

    private void GB() {
        this.hqC.setOnClickListener(this.aFV);
        this.nYb.setOnClickListener(this.aFV);
        this.nYe.setOnClickListener(this.aFV);
        this.hqz.setOnClickListener(this.aFV);
        this.hqR.setOnClickListener(this.aFV);
        this.hnn.setOnClickListener(this.aFV);
        this.nYg.setOnClickListener(this.aFV);
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public void setOnLiveViewOperationBtnClickListener(b bVar) {
        this.nYa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS(boolean z) {
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
    public void X(String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_GIFT);
            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        this.nYa.a(this.hqC, 2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else {
            this.nYa.a(21, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(View view) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            yS(false);
        }
        this.nYa.a(view, 1, null);
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.bmQ);
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.nYk);
        MessageManager.getInstance().unRegisterListener(this.nYi);
        MessageManager.getInstance().unRegisterListener(this.nYj);
        MessageManager.getInstance().unRegisterListener(this.nYl);
        MessageManager.getInstance().unRegisterListener(this.nYm);
        MessageManager.getInstance().unRegisterListener(this.nYn);
        MessageManager.getInstance().unRegisterTask(2501010);
        MessageManager.getInstance().unRegisterTask(2501027);
        MessageManager.getInstance().unRegisterListener(this.nYp);
        MessageManager.getInstance().unRegisterListener(this.nYq);
        MessageManager.getInstance().unRegisterListener(this.nYr);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bmI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.blL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.blM);
            }
            this.mDialog = new BdAlertDialog(this.bmK.getPageActivity());
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
            this.mDialog.create(this.bmK);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    public void registerListeners() {
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (AlaLiveBottomOperationView.this.mDialog != null && AlaLiveBottomOperationView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    AlaLiveBottomOperationView.this.mDialog.dismiss();
                }
            }
        };
        this.bek.setTag(this.bmK.getUniqueId());
        MessageManager.getInstance().registerListener(this.bek);
        this.nYi = new CustomMessageListener(2501002) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nYa.a(null, 3, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nYi);
        this.nYj = new CustomMessageListener(2501003) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nYa.a(null, 16, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nYj);
        this.nYk = new CustomMessageListener(2501004) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaLiveBottomOperationView.this.nYa.a(null, 20, null);
            }
        };
        MessageManager.getInstance().registerListener(this.nYk);
        this.nYl = new CustomMessageListener(2501017) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501017 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.nYh.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nYl);
        this.nYm = new CustomMessageListener(2501016) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501016 && (customResponsedMessage.getData() instanceof Boolean)) {
                    AlaLiveBottomOperationView.this.nYg.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nYm);
        this.nYn = new CustomMessageListener(2501020) { // from class: com.baidu.tieba.yuyinala.liveroom.operation.AlaLiveBottomOperationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501020 && (customResponsedMessage.getData() instanceof Integer)) {
                    AlaLiveBottomOperationView.this.Mh(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nYn);
        this.bmQ.setTag(this.bmK.getUniqueId());
        MessageManager.getInstance().registerListener(this.bmQ);
        MessageManager.getInstance().registerListener(this.nYp);
        MessageManager.getInstance().registerListener(this.nYq);
        MessageManager.getInstance().registerListener(this.nYr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(int i) {
        if (i <= 0) {
            this.nYd.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.nYd.getLayoutParams();
        layoutParams.width = Mj(i);
        this.nYd.setLayoutParams(layoutParams);
        this.nYd.setText(Mi(i));
        this.nYd.setVisibility(0);
    }

    private String Mi(int i) {
        if (i <= 0) {
            return null;
        }
        if (i < 100) {
            return String.valueOf(i);
        }
        return "99+";
    }

    private int Mj(int i) {
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
