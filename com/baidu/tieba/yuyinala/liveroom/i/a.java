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
    private ImageView hFf;
    private RelativeLayout hFh;
    private ab hFj;
    private AnimatorSet hFo;
    private AnimatorSet hFp;
    private AnimatorSet hFq;
    private Context mContext;
    private String mName;
    private h ora;
    private BarImageView ovy;
    private AlaLoadingButton ovz;
    private View mView = null;
    public boolean hFl = false;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.ora = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.ovz = (AlaLoadingButton) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.ovz.setSelected(true);
        this.ovy = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eIO = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.hFf = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hFh = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        this.ovy.setShowOval(true);
        this.ovy.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.ovy.setAutoChangeStyle(false);
        this.ovz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ebo();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.ovz.setStatus(3);
                    a.this.ora.y(a.this.hFj.aIU.aTK, a.this.hFj.aIU.live_id, 1);
                    a.this.ora.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.ebl();
                            a.this.blC = true;
                            a.this.ovz.setStatus(4);
                            a.this.cgn();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.blC = false;
                            a.this.ovz.setStatus(1);
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
    public void ebo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hFj.aIU.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hFj.aIU.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void ebp() {
        this.blC = true;
        cgn();
    }

    public void ebq() {
        this.blC = false;
        cgf();
        ebr();
    }

    public View getView() {
        return this.mView;
    }

    public void VG(String str) {
        this.mName = str;
        ebr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebr() {
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

    public void VH(String str) {
        this.ovy.startLoad(str, 12, false, false);
    }

    public void ac(ab abVar) {
        if (abVar != null) {
            this.hFj = abVar;
            if (this.hFj.aIU != null) {
                this.blC = this.hFj.aIU.is_followed;
                this.mName = this.hFj.aIU.room_name;
                if (!this.hFj.aIU.cover.equals(this.ovy.getUrl())) {
                    this.ovy.stopLoad();
                    this.ovy.startLoad(this.hFj.aIU.cover, 12, false, false);
                }
                ebr();
                this.hFl = false;
                if (this.hFj.aIU.is_followed) {
                    this.hFh.setVisibility(8);
                    return;
                }
                this.hFh.setVisibility(0);
                this.ovz.setStatus(1);
                this.ovz.setVisibility(0);
            }
        }
    }

    public void ad(ab abVar) {
        if (abVar != null) {
            this.hFj = abVar;
            if (this.hFj.aIU != null) {
                this.mName = this.hFj.aIU.room_name;
                this.ovy.stopLoad();
                this.ovy.startLoad(this.hFj.aIU.cover, 12, false, false);
                ebr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgn() {
        if (!this.hFl) {
            this.hFl = true;
            this.hFq = cgq();
            AnimatorSet cgp = cgp();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgp).after(this.hFq);
            this.hFp = cgo();
            AnimatorSet a2 = a(animatorSet);
            this.hFo = new AnimatorSet();
            this.hFo.play(a2).after(this.hFp);
            this.hFo.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ovz, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ovz, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.ovz.setVisibility(8);
                a.this.ovz.setScaleX(1.0f);
                a.this.ovz.setScaleY(1.0f);
                a.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgo() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ovz, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ovz, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.ovz.setScaleX(1.15f);
                a.this.ovz.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgp() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFf, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFf, "scaleY", 1.15f, 1.0f).setDuration(42L);
        ValueAnimator duration3 = ObjectAnimator.ofFloat(1.0f).setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).before(duration3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hFh.setVisibility(8);
                a.this.hFf.setVisibility(8);
                a.this.ebr();
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgq() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFf, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFf, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hFf.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hFf.setScaleX(1.15f);
                a.this.hFf.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hFl && animatorSet != null) {
            animatorSet.start();
        }
    }

    private void cancelAnimation() {
        if (this.hFo != null) {
            this.hFo.removeAllListeners();
            this.hFo.cancel();
        }
        if (this.hFp != null) {
            this.hFp.removeAllListeners();
            this.hFp.cancel();
        }
        if (this.hFq != null) {
            this.hFq.removeAllListeners();
            this.hFq.cancel();
        }
    }

    public void cgf() {
        if (this.hFl) {
            this.hFl = false;
            cancelAnimation();
        }
        this.ovz.setScaleY(1.0f);
        this.ovz.setScaleX(1.0f);
        this.ovz.setStatus(1);
        this.ovz.setVisibility(0);
        this.hFh.setVisibility(0);
        this.hFf.setVisibility(4);
    }

    public void onDestroy() {
        this.hFl = false;
    }
}
