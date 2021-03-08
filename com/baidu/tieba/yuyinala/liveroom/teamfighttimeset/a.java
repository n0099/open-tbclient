package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends Dialog {
    private ab aED;
    private View bZD;
    private Activity mActivity;
    private TextView mfm;
    private b oBW;
    private InterfaceC0943a oBX;
    private IndicatorSeekBar oBY;
    private IndicatorSeekBar oBZ;
    public CustomMessageListener owC;
    private TextView owz;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0943a {
        void onDismiss();
    }

    public a(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.owC = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).Bp() != 2 && a.this.isShowing()) {
                    a.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        init();
    }

    private void init() {
        initView();
        YE();
    }

    private void YE() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(this.mActivity);
            attributes.width = -1;
            attributes.gravity = 80;
            attributes.flags = 1280;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.g.yuyin_layout_dialog_teamfight_time_setting);
        this.bZD = findViewById(a.f.view);
        this.mfm = (TextView) findViewById(a.f.tv_cancel);
        this.owz = (TextView) findViewById(a.f.tv_confirm);
        this.oBY = (IndicatorSeekBar) findViewById(a.f.sb_pk_time);
        this.oBZ = (IndicatorSeekBar) findViewById(a.f.sb_punish_time);
        this.oBW = new b(this.mActivity);
        this.oBY.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(e eVar) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(IndicatorSeekBar indicatorSeekBar) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "battletimebar_clk").setContentExt(jSONObject));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void b(IndicatorSeekBar indicatorSeekBar) {
            }
        });
        this.oBZ.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.2
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(e eVar) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(IndicatorSeekBar indicatorSeekBar) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "punishtimebar_clk").setContentExt(jSONObject));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void b(IndicatorSeekBar indicatorSeekBar) {
            }
        });
        this.bZD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.mfm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.owz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oBW != null) {
                    a.this.oBW.d(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(a.this.aED), 0, 1, 0, a.this.oBY.getProgress() + "", a.this.oBZ.getProgress() + "");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk").setContentExt(jSONObject));
            }
        });
        this.oBW.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void a(TimeSettingResponseMessage timeSettingResponseMessage) {
                if (a.this.oBY != null && a.this.oBZ != null) {
                    com.baidu.live.d.xf().putInt("audio_live_pk_time", a.this.oBY.getProgress());
                    com.baidu.live.d.xf().putInt("audio_live_punish_time", a.this.oBZ.getProgress());
                }
                a.this.dismiss();
                BdUtilHelper.showToast(a.this.getContext(), "设置成功，团战即将开始");
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void onFail(int i, String str) {
                a.this.dismiss();
                BdUtilHelper.showToast(a.this.getContext(), "团战开始失败，请重试");
            }
        });
    }

    public void ab(ab abVar) {
        this.aED = abVar;
        try {
            show();
            if (this.oBY != null) {
                this.oBY.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ay(abVar));
                this.oBY.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.az(abVar));
                this.oBY.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aA(abVar));
            }
            if (this.oBZ != null) {
                this.oBZ.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aB(abVar));
                this.oBZ.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aC(abVar));
                this.oBZ.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aD(abVar));
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.oBX != null) {
                this.oBX.onDismiss();
            }
            super.dismiss();
            MessageManager.getInstance().unRegisterListener(this.owC);
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            MessageManager.getInstance().registerListener(this.owC);
        } catch (Throwable th) {
        }
    }
}
