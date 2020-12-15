package com.baidu.tieba.yuyinala.liveroom.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
/* loaded from: classes4.dex */
public class b {
    private TextView cRf;
    private int hiA;
    private HeadImageView hix;
    private AlaLastLiveroomInfo hiy;
    private int hiz;
    private TbPageContext mContext;
    private ValueAnimator mValueAnimator;
    private View mView;
    private boolean hiD = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.yuyinala.liveroom.e.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.startAnim();
                    return;
                case 2:
                    b.this.hiD = true;
                    b.this.hide();
                    return;
                default:
                    return;
            }
        }
    };
    private int hiB = com.baidu.live.ae.a.RB().brA.aOC;
    private int hiC = com.baidu.live.ae.a.RB().brA.aOD;

    public b(@NonNull TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.hiz = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hiA = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds94);
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_back_to_last_live_button, (ViewGroup) null);
        this.hix = (HeadImageView) this.mView.findViewById(a.f.back_to_last_live_portrait);
        this.hix.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hix.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hix.setIsRound(true);
        this.hix.setAutoChangeStyle(false);
        this.hix.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cRf = (TextView) this.mView.findViewById(a.f.back_to_last_live_content);
    }

    public void show() {
        if (this.mView != null && this.mView.getParent() != null && !this.hiD) {
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
            ccA();
            this.hix.startLoad(alaLastLiveroomInfo.getLastAnchorPortrait(), 10, false);
            this.hiy = alaLastLiveroomInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        int i;
        int width = this.cRf.getWidth();
        int width2 = this.mView.getWidth();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hix.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.addRule(11);
            layoutParams.removeRule(1);
            i = 500;
        } else {
            layoutParams.addRule(1, a.f.back_to_last_live_icon);
            i = 0;
        }
        this.hix.setLayoutParams(layoutParams);
        if (this.mValueAnimator != null && this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator = ValueAnimator.ofInt(width2, (width2 - width) - this.hiz).setDuration(i);
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
                b.this.mView.getLayoutParams().width = b.this.hiA;
                b.this.mView.requestLayout();
                Message message = new Message();
                message.what = 2;
                b.this.mHandler.sendMessageDelayed(message, b.this.hiC);
            }
        });
        this.mValueAnimator.start();
    }

    private void ccA() {
        if (this.hix != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hix.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
            }
            layoutParams.addRule(1, a.f.back_to_last_live_content);
            this.hix.setLayoutParams(layoutParams);
        }
    }

    public void ccB() {
        if (this.hiy != null && this.hiy.getLastLiveId() > 0 && this.mContext != null) {
            if (this.hiy.getIsAudio() == 1) {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext.getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(this.hiy.getLastLiveId(), "", "live_sdk");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(this.hiy.getLastCover())) {
                        jSONObject.put("cover", this.hiy.getLastCover());
                    }
                    if (!TextUtils.isEmpty(this.hiy.getLastVideoUrl())) {
                        jSONObject.put("live_url", this.hiy.getLastVideoUrl());
                    }
                    jSONObject.put("enterLiveId", this.hiy.getLastLiveId());
                    yuyinAlaLiveRoomActivityConfig.addExtraByParams(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                return;
            }
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(this.hiy.getLastLiveId(), "", "live_sdk");
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.hiy.getLastCover())) {
                    jSONObject2.put("cover", this.hiy.getLastCover());
                }
                if (!TextUtils.isEmpty(this.hiy.getLastVideoUrl())) {
                    jSONObject2.put("live_url", this.hiy.getLastVideoUrl());
                }
                jSONObject2.put("enterLiveId", this.hiy.getLastLiveId());
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

    private RelativeLayout.LayoutParams ccC() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds120);
        return layoutParams;
    }

    public void av(ViewGroup viewGroup) {
        if (this.mView != null && viewGroup != null && this.mView.getParent() == null) {
            viewGroup.addView(this.mView, ccC());
            if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
                hide();
            } else {
                show();
            }
            this.mHandler.removeCallbacksAndMessages(null);
            Message message = new Message();
            message.what = 1;
            this.mHandler.sendMessageDelayed(message, this.hiB);
        }
    }

    public void ccD() {
        release();
    }

    private void release() {
        this.hiD = false;
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
