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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.g;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.e;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes10.dex */
public class a extends Dialog {
    private x aBr;
    private View bUe;
    private TextView lTQ;
    private Activity mActivity;
    private TextView oka;
    public CustomMessageListener okd;
    private b opB;
    private InterfaceC0931a opC;
    private IndicatorSeekBar opD;
    private IndicatorSeekBar opE;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0931a {
        void onDismiss();
    }

    public a(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.okd = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).AC() != 2 && a.this.isShowing()) {
                    a.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        init();
    }

    private void init() {
        initView();
        WL();
    }

    private void WL() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(this.mActivity);
            attributes.width = -1;
            attributes.gravity = 80;
            attributes.flags = PlatformPlugin.DEFAULT_SYSTEM_UI;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.g.yuyin_layout_dialog_teamfight_time_setting);
        this.bUe = findViewById(a.f.view);
        this.lTQ = (TextView) findViewById(a.f.tv_cancel);
        this.oka = (TextView) findViewById(a.f.tv_confirm);
        this.opD = (IndicatorSeekBar) findViewById(a.f.sb_pk_time);
        this.opE = (IndicatorSeekBar) findViewById(a.f.sb_punish_time);
        this.opB = new b(this.mActivity);
        this.opD.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(e eVar) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(IndicatorSeekBar indicatorSeekBar) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "battletimebar_clk"));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void b(IndicatorSeekBar indicatorSeekBar) {
            }
        });
        this.opE.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.2
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(e eVar) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void a(IndicatorSeekBar indicatorSeekBar) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "punishtimebar_clk"));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.d
            public void b(IndicatorSeekBar indicatorSeekBar) {
            }
        });
        this.bUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.lTQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.oka.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.opB != null) {
                    a.this.opB.d(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(a.this.aBr), 0, 1, 0, a.this.opD.getProgress() + "", a.this.opE.getProgress() + "");
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk"));
            }
        });
        this.opB.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void a(TimeSettingResponseMessage timeSettingResponseMessage) {
                if (a.this.opD != null && a.this.opE != null) {
                    com.baidu.live.d.xf().putInt("audio_live_pk_time", a.this.opD.getProgress());
                    com.baidu.live.d.xf().putInt("audio_live_punish_time", a.this.opE.getProgress());
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

    public void ac(x xVar) {
        this.aBr = xVar;
        try {
            show();
            if (this.opD != null) {
                this.opD.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ay(xVar));
                this.opD.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.az(xVar));
                this.opD.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aA(xVar));
            }
            if (this.opE != null) {
                this.opE.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aB(xVar));
                this.opE.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aC(xVar));
                this.opE.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aD(xVar));
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.opC != null) {
                this.opC.onDismiss();
            }
            super.dismiss();
            MessageManager.getInstance().unRegisterListener(this.okd);
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            MessageManager.getInstance().registerListener(this.okd);
        } catch (Throwable th) {
        }
    }
}
