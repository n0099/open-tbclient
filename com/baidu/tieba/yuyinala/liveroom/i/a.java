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
/* loaded from: classes10.dex */
public class a {
    private boolean bik;
    private TextView eGI;
    private ImageView hAV;
    private RelativeLayout hAX;
    private x hAZ;
    private AnimatorSet hBe;
    private AnimatorSet hBf;
    private AnimatorSet hBg;
    private Context mContext;
    private String mName;
    private h ohh;
    private BarImageView olG;
    private AlaLoadingButton olH;
    private View mView = null;
    public boolean hBb = false;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.ohh = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.olH = (AlaLoadingButton) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.olH.setSelected(true);
        this.olG = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eGI = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.hAV = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hAX = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        this.olG.setShowOval(true);
        this.olG.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.olG.setAutoChangeStyle(false);
        this.olH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dZc();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.olH.setStatus(3);
                    a.this.ohh.y(a.this.hAZ.aGy.aQH, a.this.hAZ.aGy.live_id, 1);
                    a.this.ohh.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.dYZ();
                            a.this.bik = true;
                            a.this.olH.setStatus(4);
                            a.this.cfu();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.bik = false;
                            a.this.olH.setStatus(1);
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
    public void dZc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hAZ.aGy.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hAZ.aGy.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void dZd() {
        this.bik = true;
        cfu();
    }

    public void dZe() {
        this.bik = false;
        cfm();
        dZf();
    }

    public View getView() {
        return this.mView;
    }

    public void UI(String str) {
        this.mName = str;
        dZf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZf() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.bik) {
            if (textLengthAllOne <= 10) {
                this.eGI.setText(str);
                return;
            }
            this.eGI.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.eGI.setText(str);
        } else {
            this.eGI.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void UJ(String str) {
        this.olG.startLoad(str, 12, false, false);
    }

    public void ad(x xVar) {
        if (xVar != null) {
            this.hAZ = xVar;
            if (this.hAZ.aGy != null) {
                this.bik = this.hAZ.aGy.is_followed;
                this.mName = this.hAZ.aGy.room_name;
                if (!this.hAZ.aGy.cover.equals(this.olG.getUrl())) {
                    this.olG.stopLoad();
                    this.olG.startLoad(this.hAZ.aGy.cover, 12, false, false);
                }
                dZf();
                this.hBb = false;
                if (this.hAZ.aGy.is_followed) {
                    this.hAX.setVisibility(8);
                    return;
                }
                this.hAX.setVisibility(0);
                this.olH.setStatus(1);
                this.olH.setVisibility(0);
            }
        }
    }

    public void ae(x xVar) {
        if (xVar != null) {
            this.hAZ = xVar;
            if (this.hAZ.aGy != null) {
                this.mName = this.hAZ.aGy.room_name;
                this.olG.stopLoad();
                this.olG.startLoad(this.hAZ.aGy.cover, 12, false, false);
                dZf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfu() {
        if (!this.hBb) {
            this.hBb = true;
            this.hBg = cfx();
            AnimatorSet cfw = cfw();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cfw).after(this.hBg);
            this.hBf = cfv();
            AnimatorSet a2 = a(animatorSet);
            this.hBe = new AnimatorSet();
            this.hBe.play(a2).after(this.hBf);
            this.hBe.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.olH, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.olH, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.olH.setVisibility(8);
                a.this.olH.setScaleX(1.0f);
                a.this.olH.setScaleY(1.0f);
                a.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cfv() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.olH, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.olH, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.olH.setScaleX(1.15f);
                a.this.olH.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cfw() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAV, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAV, "scaleY", 1.15f, 1.0f).setDuration(42L);
        ValueAnimator duration3 = ObjectAnimator.ofFloat(1.0f).setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).before(duration3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hAX.setVisibility(8);
                a.this.hAV.setVisibility(8);
                a.this.dZf();
            }
        });
        return animatorSet;
    }

    private AnimatorSet cfx() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAV, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAV, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hAV.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hAV.setScaleX(1.15f);
                a.this.hAV.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hBb && animatorSet != null) {
            animatorSet.start();
        }
    }

    private void cancelAnimation() {
        if (this.hBe != null) {
            this.hBe.removeAllListeners();
            this.hBe.cancel();
        }
        if (this.hBf != null) {
            this.hBf.removeAllListeners();
            this.hBf.cancel();
        }
        if (this.hBg != null) {
            this.hBg.removeAllListeners();
            this.hBg.cancel();
        }
    }

    public void cfm() {
        if (this.hBb) {
            this.hBb = false;
            cancelAnimation();
        }
        this.olH.setScaleY(1.0f);
        this.olH.setScaleX(1.0f);
        this.olH.setStatus(1);
        this.olH.setVisibility(0);
        this.hAX.setVisibility(0);
        this.hAV.setVisibility(4);
    }

    public void onDestroy() {
        this.hBb = false;
    }
}
