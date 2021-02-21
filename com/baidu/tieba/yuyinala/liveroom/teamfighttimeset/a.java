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
/* loaded from: classes11.dex */
public class a extends Dialog {
    private ab aDd;
    private View bYd;
    private Activity mActivity;
    private TextView mdj;
    private TextView ouu;
    public CustomMessageListener oux;
    private b ozR;
    private InterfaceC0937a ozS;
    private IndicatorSeekBar ozT;
    private IndicatorSeekBar ozU;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0937a {
        void onDismiss();
    }

    public a(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.oux = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).Bm() != 2 && a.this.isShowing()) {
                    a.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        init();
    }

    private void init() {
        initView();
        YB();
    }

    private void YB() {
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
        this.bYd = findViewById(a.f.view);
        this.mdj = (TextView) findViewById(a.f.tv_cancel);
        this.ouu = (TextView) findViewById(a.f.tv_confirm);
        this.ozT = (IndicatorSeekBar) findViewById(a.f.sb_pk_time);
        this.ozU = (IndicatorSeekBar) findViewById(a.f.sb_punish_time);
        this.ozR = new b(this.mActivity);
        this.ozT.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.1
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
        this.ozU.setOnSeekChangeListener(new d() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.2
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
        this.bYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.mdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.ouu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ozR != null) {
                    a.this.ozR.d(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(a.this.aDd), 0, 1, 0, a.this.ozT.getProgress() + "", a.this.ozU.getProgress() + "");
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
        this.ozR.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a.6
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void a(TimeSettingResponseMessage timeSettingResponseMessage) {
                if (a.this.ozT != null && a.this.ozU != null) {
                    com.baidu.live.d.xc().putInt("audio_live_pk_time", a.this.ozT.getProgress());
                    com.baidu.live.d.xc().putInt("audio_live_punish_time", a.this.ozU.getProgress());
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
        this.aDd = abVar;
        try {
            show();
            if (this.ozT != null) {
                this.ozT.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ay(abVar));
                this.ozT.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.az(abVar));
                this.ozT.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aA(abVar));
            }
            if (this.ozU != null) {
                this.ozU.setMin(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aB(abVar));
                this.ozU.setMax(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aC(abVar));
                this.ozU.setProgress(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aD(abVar));
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.ozS != null) {
                this.ozS.onDismiss();
            }
            super.dismiss();
            MessageManager.getInstance().unRegisterListener(this.oux);
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            MessageManager.getInstance().registerListener(this.oux);
        } catch (Throwable th) {
        }
    }
}
