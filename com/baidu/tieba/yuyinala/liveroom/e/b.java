package com.baidu.tieba.yuyinala.liveroom.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private HeadImageView aVk;
    private AlaLastLiveroomInfo bWu;
    private TextView cTD;
    private int hum;
    private int hun;
    private TbPageContext mContext;
    private ValueAnimator mValueAnimator;
    private View mView;
    private boolean huq = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.yuyinala.liveroom.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.startAnim();
                    return;
                case 2:
                    b.this.huq = true;
                    b.this.hide();
                    return;
                default:
                    return;
            }
        }
    };
    private int huo = com.baidu.live.ae.a.Qj().buX.aNj;
    private int hup = com.baidu.live.ae.a.Qj().buX.aNk;

    public b(@NonNull TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.hum = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hun = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds94);
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_back_to_last_live_button, (ViewGroup) null);
        this.aVk = (HeadImageView) this.mView.findViewById(a.f.back_to_last_live_portrait);
        this.aVk.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aVk.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aVk.setIsRound(true);
        this.aVk.setAutoChangeStyle(false);
        this.aVk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cTD = (TextView) this.mView.findViewById(a.f.back_to_last_live_content);
    }

    public void show() {
        if (this.mView != null && this.mView.getParent() != null && !this.huq) {
            this.mView.setVisibility(0);
        }
    }

    public void hide() {
        if (this.mView != null && this.mView.getParent() != null) {
            this.mView.setVisibility(8);
        }
    }

    public void d(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (alaLastLiveroomInfo != null) {
            ccB();
            this.aVk.startLoad(alaLastLiveroomInfo.getLastAnchorPortrait(), 10, false);
            this.bWu = alaLastLiveroomInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        int i;
        int width = this.cTD.getWidth();
        int width2 = this.mView.getWidth();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVk.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.addRule(11);
            layoutParams.removeRule(1);
            i = 500;
        } else {
            layoutParams.addRule(1, a.f.back_to_last_live_icon);
            i = 0;
        }
        this.aVk.setLayoutParams(layoutParams);
        if (this.mValueAnimator != null && this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator = ValueAnimator.ofInt(width2, (width2 - width) - this.hum).setDuration(i);
        this.mValueAnimator.setInterpolator(new AccelerateInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.e.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.mView.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.mView.requestLayout();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.e.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.mView.getLayoutParams().width = b.this.hun;
                b.this.mView.requestLayout();
                Message message = new Message();
                message.what = 2;
                b.this.mHandler.sendMessageDelayed(message, b.this.hup);
            }
        });
        this.mValueAnimator.start();
    }

    private void ccB() {
        if (this.aVk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVk.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
            }
            layoutParams.addRule(1, a.f.back_to_last_live_content);
            this.aVk.setLayoutParams(layoutParams);
        }
    }

    public void ccC() {
        if (this.bWu != null && this.bWu.getLastLiveId() > 0 && this.mContext != null) {
            if (this.bWu.getIsAudio() == 1) {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext.getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(this.bWu.getLastLiveId(), "", "live_sdk");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(this.bWu.getLastCover())) {
                        jSONObject.put("cover", this.bWu.getLastCover());
                    }
                    if (!TextUtils.isEmpty(this.bWu.getLastVideoUrl())) {
                        jSONObject.put("live_url", this.bWu.getLastVideoUrl());
                    }
                    jSONObject.put("enterLiveId", this.bWu.getLastLiveId());
                    yuyinAlaLiveRoomActivityConfig.addExtraByParams(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                return;
            }
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(this.bWu.getLastLiveId(), "", "live_sdk");
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.bWu.getLastCover())) {
                    jSONObject2.put("cover", this.bWu.getLastCover());
                }
                if (!TextUtils.isEmpty(this.bWu.getLastVideoUrl())) {
                    jSONObject2.put("live_url", this.bWu.getLastVideoUrl());
                }
                jSONObject2.put("enterLiveId", this.bWu.getLastLiveId());
                alaLiveRoomActivityConfig.addExtraByParams(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501058, "close_yuyin_activity"));
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
        release();
    }

    private RelativeLayout.LayoutParams ccD() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
        return layoutParams;
    }

    public void aH(ViewGroup viewGroup) {
        if (this.mView != null && viewGroup != null && this.mView.getParent() == null) {
            viewGroup.addView(this.mView, ccD());
            if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
                hide();
            } else {
                show();
            }
            this.mHandler.removeCallbacksAndMessages(null);
            Message message = new Message();
            message.what = 1;
            this.mHandler.sendMessageDelayed(message, this.huo);
        }
    }

    public void ccE() {
        release();
    }

    private void release() {
        this.huq = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
            this.mValueAnimator = null;
        }
        if (this.mView != null && this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
    }
}
