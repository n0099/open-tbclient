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
    private TextView ojZ;
    public CustomMessageListener okc;
    private b opA;
    private InterfaceC0931a opB;
    private IndicatorSeekBar opC;
    private IndicatorSeekBar opD;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0931a {
        void onDismiss();
    }

    public a(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.okc = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.7
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
        this.ojZ = (TextView) findViewById(a.f.tv_confirm);
        this.opC = (IndicatorSeekBar) findViewById(a.f.sb_pk_time);
        this.opD = (IndicatorSeekBar) findViewById(a.f.sb_punish_time);
        this.opA = new b(this.mActivity);
        this.opC.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.1
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
        this.opD.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.2
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
        this.ojZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.opA != null) {
                    a.this.opA.d(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(a.this.aBr), 0, 1, 0, a.this.opC.getProgress() + "", a.this.opD.getProgress() + "");
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk"));
            }
        });
        this.opA.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void a(TimeSettingResponseMessage timeSettingResponseMessage) {
                if (a.this.opC != null && a.this.opD != null) {
                    com.baidu.live.d.xf().putInt("audio_live_pk_time", a.this.opC.getProgress());
                    com.baidu.live.d.xf().putInt("audio_live_punish_time", a.this.opD.getProgress());
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
            if (this.opC != null) {
                this.opC.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ay(xVar));
                this.opC.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.az(xVar));
                this.opC.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aA(xVar));
            }
            if (this.opD != null) {
                this.opD.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aB(xVar));
                this.opD.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aC(xVar));
                this.opD.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aD(xVar));
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.opB != null) {
                this.opB.onDismiss();
            }
            super.dismiss();
            MessageManager.getInstance().unRegisterListener(this.okc);
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            MessageManager.getInstance().registerListener(this.okc);
        } catch (Throwable th) {
        }
    }
}
