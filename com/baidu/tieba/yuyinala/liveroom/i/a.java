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
import com.baidu.live.data.ab;
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
/* loaded from: classes10.dex */
public class a {
    private boolean bnd;
    private TextView eKp;
    private ImageView hHc;
    private RelativeLayout hHe;
    private ab hHg;
    private AnimatorSet hHl;
    private AnimatorSet hHm;
    private AnimatorSet hHn;
    private Context mContext;
    private String mName;
    private h otG;
    private BarImageView oyd;
    private AlaLoadingButton oye;
    private View mView = null;
    public boolean hHi = false;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.otG = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.oye = (AlaLoadingButton) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.oye.setSelected(true);
        this.oyd = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eKp = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.hHc = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hHe = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        this.oyd.setShowOval(true);
        this.oyd.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.oyd.setAutoChangeStyle(false);
        this.oye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ebE();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.oye.setStatus(3);
                    a.this.otG.y(a.this.hHg.aKu.aVk, a.this.hHg.aKu.live_id, 1);
                    a.this.otG.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.ebB();
                            a.this.bnd = true;
                            a.this.oye.setStatus(4);
                            a.this.cgA();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.bnd = false;
                            a.this.oye.setStatus(1);
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
    public void ebE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hHg.aKu.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hHg.aKu.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void ebF() {
        this.bnd = true;
        cgA();
    }

    public void ebG() {
        this.bnd = false;
        cgs();
        ebH();
    }

    public View getView() {
        return this.mView;
    }

    public void VZ(String str) {
        this.mName = str;
        ebH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebH() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.bnd) {
            if (textLengthAllOne <= 10) {
                this.eKp.setText(str);
                return;
            }
            this.eKp.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.eKp.setText(str);
        } else {
            this.eKp.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void Wa(String str) {
        this.oyd.startLoad(str, 12, false, false);
    }

    public void ac(ab abVar) {
        if (abVar != null) {
            this.hHg = abVar;
            if (this.hHg.aKu != null) {
                this.bnd = this.hHg.aKu.is_followed;
                this.mName = this.hHg.aKu.room_name;
                if (!this.hHg.aKu.cover.equals(this.oyd.getUrl())) {
                    this.oyd.stopLoad();
                    this.oyd.startLoad(this.hHg.aKu.cover, 12, false, false);
                }
                ebH();
                this.hHi = false;
                if (this.hHg.aKu.is_followed) {
                    this.hHe.setVisibility(8);
                    return;
                }
                this.hHe.setVisibility(0);
                this.oye.setStatus(1);
                this.oye.setVisibility(0);
            }
        }
    }

    public void ad(ab abVar) {
        if (abVar != null) {
            this.hHg = abVar;
            if (this.hHg.aKu != null) {
                this.mName = this.hHg.aKu.room_name;
                this.oyd.stopLoad();
                this.oyd.startLoad(this.hHg.aKu.cover, 12, false, false);
                ebH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgA() {
        if (!this.hHi) {
            this.hHi = true;
            this.hHn = cgD();
            AnimatorSet cgC = cgC();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgC).after(this.hHn);
            this.hHm = cgB();
            AnimatorSet a2 = a(animatorSet);
            this.hHl = new AnimatorSet();
            this.hHl.play(a2).after(this.hHm);
            this.hHl.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.oye, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.oye, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.oye.setVisibility(8);
                a.this.oye.setScaleX(1.0f);
                a.this.oye.setScaleY(1.0f);
                a.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgB() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.oye, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.oye, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.oye.setScaleX(1.15f);
                a.this.oye.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgC() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHc, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hHc, "scaleY", 1.15f, 1.0f).setDuration(42L);
        ValueAnimator duration3 = ObjectAnimator.ofFloat(1.0f).setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).before(duration3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hHe.setVisibility(8);
                a.this.hHc.setVisibility(8);
                a.this.ebH();
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgD() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHc, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hHc, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hHc.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hHc.setScaleX(1.15f);
                a.this.hHc.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hHi && animatorSet != null) {
            animatorSet.start();
        }
    }

    private void cancelAnimation() {
        if (this.hHl != null) {
            this.hHl.removeAllListeners();
            this.hHl.cancel();
        }
        if (this.hHm != null) {
            this.hHm.removeAllListeners();
            this.hHm.cancel();
        }
        if (this.hHn != null) {
            this.hHn.removeAllListeners();
            this.hHn.cancel();
        }
    }

    public void cgs() {
        if (this.hHi) {
            this.hHi = false;
            cancelAnimation();
        }
        this.oye.setScaleY(1.0f);
        this.oye.setScaleX(1.0f);
        this.oye.setStatus(1);
        this.oye.setVisibility(0);
        this.hHe.setVisibility(0);
        this.hHc.setVisibility(4);
    }

    public void onDestroy() {
        this.hHi = false;
    }
}
