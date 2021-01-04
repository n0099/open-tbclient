package com.baidu.tieba.yuyinala.liveroom.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.live.view.AlaLoadingButton;
import com.baidu.tieba.yuyinala.liveroom.roomcard.AlaGetCollectRoomHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean bmX;
    private TextView eLt;
    private ImageView hFB;
    private RelativeLayout hFD;
    private x hFF;
    private AnimatorSet hFK;
    private AnimatorSet hFL;
    private AnimatorSet hFM;
    private Context mContext;
    private String mName;
    private h olM;
    private BarImageView oqn;
    private AlaLoadingButton oqo;
    private View mView = null;
    public boolean hFH = false;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.olM = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.oqo = (AlaLoadingButton) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.oqo.setSelected(true);
        this.oqn = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eLt = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.hFB = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hFD = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        this.oqn.setShowOval(true);
        this.oqn.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.oqn.setAutoChangeStyle(false);
        this.oqo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ecT();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.oqo.setStatus(3);
                    a.this.olM.y(a.this.hFF.aLl.aVu, a.this.hFF.aLl.live_id, 1);
                    a.this.olM.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.ecQ();
                            a.this.bmX = true;
                            a.this.oqo.setStatus(4);
                            a.this.cjl();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.bmX = false;
                            a.this.oqo.setStatus(1);
                            BdUtilHelper.showToast(a.this.mContext, "房间收藏失败", 3000);
                        }
                    });
                } else {
                    BdUtilHelper.showToast(a.this.mContext, a.this.mContext.getResources().getString(a.h.sdk_neterror));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hFF.aLl.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hFF.aLl.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void ecU() {
        this.bmX = true;
        cjl();
    }

    public void ecV() {
        this.bmX = false;
        cjd();
        ecW();
    }

    public View getView() {
        return this.mView;
    }

    public void VQ(String str) {
        this.mName = str;
        ecW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecW() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.bmX) {
            if (textLengthAllOne <= 10) {
                this.eLt.setText(str);
                return;
            }
            this.eLt.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.eLt.setText(str);
        } else {
            this.eLt.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void VR(String str) {
        this.oqn.startLoad(str, 12, false, false);
    }

    public void ad(x xVar) {
        if (xVar != null) {
            this.hFF = xVar;
            if (this.hFF.aLl != null) {
                this.bmX = this.hFF.aLl.is_followed;
                this.mName = this.hFF.aLl.room_name;
                if (!this.hFF.aLl.cover.equals(this.oqn.getUrl())) {
                    this.oqn.stopLoad();
                    this.oqn.startLoad(this.hFF.aLl.cover, 12, false, false);
                }
                ecW();
                this.hFH = false;
                if (this.hFF.aLl.is_followed) {
                    this.hFD.setVisibility(8);
                    return;
                }
                this.hFD.setVisibility(0);
                this.oqo.setStatus(1);
                this.oqo.setVisibility(0);
            }
        }
    }

    public void ae(x xVar) {
        if (xVar != null) {
            this.hFF = xVar;
            if (this.hFF.aLl != null) {
                this.mName = this.hFF.aLl.room_name;
                this.oqn.stopLoad();
                this.oqn.startLoad(this.hFF.aLl.cover, 12, false, false);
                ecW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjl() {
        if (!this.hFH) {
            this.hFH = true;
            this.hFM = cjo();
            AnimatorSet cjn = cjn();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cjn).after(this.hFM);
            this.hFL = cjm();
            AnimatorSet a2 = a(animatorSet);
            this.hFK = new AnimatorSet();
            this.hFK.play(a2).after(this.hFL);
            this.hFK.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.oqo, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.oqo, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.oqo.setVisibility(8);
                a.this.oqo.setScaleX(1.0f);
                a.this.oqo.setScaleY(1.0f);
                a.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cjm() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.oqo, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.oqo, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.oqo.setScaleX(1.15f);
                a.this.oqo.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cjn() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFB, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFB, "scaleY", 1.15f, 1.0f).setDuration(42L);
        ValueAnimator duration3 = ObjectAnimator.ofFloat(1.0f).setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).before(duration3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hFD.setVisibility(8);
                a.this.hFB.setVisibility(8);
                a.this.ecW();
            }
        });
        return animatorSet;
    }

    private AnimatorSet cjo() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFB, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFB, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hFB.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hFB.setScaleX(1.15f);
                a.this.hFB.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hFH && animatorSet != null) {
            animatorSet.start();
        }
    }

    private void cancelAnimation() {
        if (this.hFK != null) {
            this.hFK.removeAllListeners();
            this.hFK.cancel();
        }
        if (this.hFL != null) {
            this.hFL.removeAllListeners();
            this.hFL.cancel();
        }
        if (this.hFM != null) {
            this.hFM.removeAllListeners();
            this.hFM.cancel();
        }
    }

    public void cjd() {
        if (this.hFH) {
            this.hFH = false;
            cancelAnimation();
        }
        this.oqo.setScaleY(1.0f);
        this.oqo.setScaleX(1.0f);
        this.oqo.setStatus(1);
        this.oqo.setVisibility(0);
        this.hFD.setVisibility(0);
        this.hFB.setVisibility(4);
    }

    public void onDestroy() {
        this.hFH = false;
    }
}
