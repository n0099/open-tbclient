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
/* loaded from: classes11.dex */
public class a {
    private boolean blC;
    private TextView eIO;
    private AnimatorSet hFC;
    private AnimatorSet hFD;
    private AnimatorSet hFE;
    private ImageView hFt;
    private RelativeLayout hFv;
    private ab hFx;
    private Context mContext;
    private String mName;
    private h orB;
    private BarImageView ovY;
    private AlaLoadingButton ovZ;
    private View mView = null;
    public boolean hFz = false;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.orB = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.ovZ = (AlaLoadingButton) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.ovZ.setSelected(true);
        this.ovY = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eIO = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.hFt = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hFv = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        this.ovY.setShowOval(true);
        this.ovY.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.ovY.setAutoChangeStyle(false);
        this.ovZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ebw();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.ovZ.setStatus(3);
                    a.this.orB.y(a.this.hFx.aIU.aTK, a.this.hFx.aIU.live_id, 1);
                    a.this.orB.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.ebt();
                            a.this.blC = true;
                            a.this.ovZ.setStatus(4);
                            a.this.cgu();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.blC = false;
                            a.this.ovZ.setStatus(1);
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
    public void ebw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hFx.aIU.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hFx.aIU.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void ebx() {
        this.blC = true;
        cgu();
    }

    public void eby() {
        this.blC = false;
        cgm();
        ebz();
    }

    public View getView() {
        return this.mView;
    }

    public void VS(String str) {
        this.mName = str;
        ebz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebz() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.blC) {
            if (textLengthAllOne <= 10) {
                this.eIO.setText(str);
                return;
            }
            this.eIO.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.eIO.setText(str);
        } else {
            this.eIO.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void VT(String str) {
        this.ovY.startLoad(str, 12, false, false);
    }

    public void ac(ab abVar) {
        if (abVar != null) {
            this.hFx = abVar;
            if (this.hFx.aIU != null) {
                this.blC = this.hFx.aIU.is_followed;
                this.mName = this.hFx.aIU.room_name;
                if (!this.hFx.aIU.cover.equals(this.ovY.getUrl())) {
                    this.ovY.stopLoad();
                    this.ovY.startLoad(this.hFx.aIU.cover, 12, false, false);
                }
                ebz();
                this.hFz = false;
                if (this.hFx.aIU.is_followed) {
                    this.hFv.setVisibility(8);
                    return;
                }
                this.hFv.setVisibility(0);
                this.ovZ.setStatus(1);
                this.ovZ.setVisibility(0);
            }
        }
    }

    public void ad(ab abVar) {
        if (abVar != null) {
            this.hFx = abVar;
            if (this.hFx.aIU != null) {
                this.mName = this.hFx.aIU.room_name;
                this.ovY.stopLoad();
                this.ovY.startLoad(this.hFx.aIU.cover, 12, false, false);
                ebz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgu() {
        if (!this.hFz) {
            this.hFz = true;
            this.hFE = cgx();
            AnimatorSet cgw = cgw();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgw).after(this.hFE);
            this.hFD = cgv();
            AnimatorSet a2 = a(animatorSet);
            this.hFC = new AnimatorSet();
            this.hFC.play(a2).after(this.hFD);
            this.hFC.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ovZ, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ovZ, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.ovZ.setVisibility(8);
                a.this.ovZ.setScaleX(1.0f);
                a.this.ovZ.setScaleY(1.0f);
                a.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgv() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ovZ, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ovZ, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.ovZ.setScaleX(1.15f);
                a.this.ovZ.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgw() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFt, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFt, "scaleY", 1.15f, 1.0f).setDuration(42L);
        ValueAnimator duration3 = ObjectAnimator.ofFloat(1.0f).setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).before(duration3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hFv.setVisibility(8);
                a.this.hFt.setVisibility(8);
                a.this.ebz();
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgx() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFt, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFt, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hFt.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hFt.setScaleX(1.15f);
                a.this.hFt.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hFz && animatorSet != null) {
            animatorSet.start();
        }
    }

    private void cancelAnimation() {
        if (this.hFC != null) {
            this.hFC.removeAllListeners();
            this.hFC.cancel();
        }
        if (this.hFD != null) {
            this.hFD.removeAllListeners();
            this.hFD.cancel();
        }
        if (this.hFE != null) {
            this.hFE.removeAllListeners();
            this.hFE.cancel();
        }
    }

    public void cgm() {
        if (this.hFz) {
            this.hFz = false;
            cancelAnimation();
        }
        this.ovZ.setScaleY(1.0f);
        this.ovZ.setScaleX(1.0f);
        this.ovZ.setStatus(1);
        this.ovZ.setVisibility(0);
        this.hFv.setVisibility(0);
        this.hFt.setVisibility(4);
    }

    public void onDestroy() {
        this.hFz = false;
    }
}
