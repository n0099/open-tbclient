package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.FrameNumCallBackHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.NewPhoneFrameView;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p {
    private com.baidu.live.an.a gYL;
    private long mLastPlayTime;
    private List<com.baidu.live.im.data.b> oHk;
    private boolean oHl;
    private NewPhoneFrameView oHm;

    public void a(TbPageContext tbPageContext, com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put("live_id", Yq.aIU.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yq.aIU.croom_id);
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "voiceframe");
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "framepop_show").setContentExt(jSONObject));
        if (this.oHk == null) {
            this.oHk = new ArrayList();
        }
        this.oHk.add(bVar);
        if (!this.oHl || System.currentTimeMillis() - this.mLastPlayTime > AppStatusRules.DEFAULT_GRANULARITY) {
            g(tbPageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final TbPageContext tbPageContext) {
        if (ListUtils.isEmpty(this.oHk)) {
            this.oHl = false;
            return;
        }
        this.mLastPlayTime = System.currentTimeMillis();
        final com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) ListUtils.remove(this.oHk, 0);
        if (bVar == null) {
            g(tbPageContext);
            return;
        }
        View view = null;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            view = tbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            g(tbPageContext);
        } else if (edJ()) {
            this.oHl = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().e((ViewGroup) view, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.p.1
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void onVideoPlayStart() {
                    p.this.b(tbPageContext, bVar);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void onVideoPlayEnd() {
                    super.onVideoPlayEnd();
                    p.this.edK();
                    p.this.g(tbPageContext);
                }
            });
        } else {
            g(tbPageContext);
        }
    }

    private boolean edJ() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CK(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final TbPageContext tbPageContext, com.baidu.live.im.data.b bVar) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            final View view = null;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                view = tbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            }
            if (view != null && (view instanceof ViewGroup)) {
                if (this.oHm == null) {
                    this.oHm = new NewPhoneFrameView(tbPageContext.getPageActivity());
                } else if (this.oHm.getParent() != null) {
                    ((ViewGroup) this.oHm.getParent()).removeView(this.oHm);
                }
                if (view instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.bottomMargin = (int) h(tbPageContext);
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    this.oHm.setLayoutParams(layoutParams);
                    ((RelativeLayout) view).addView(this.oHm);
                }
                this.oHm.setNewPhoneFrameInfo(bVar.getContent());
                WB(String.valueOf(this.oHm.getFrameId()));
                this.oHm.setListener(new NewPhoneFrameView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.p.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.NewPhoneFrameView.a
                    public void WC(String str) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
                            if (Yq != null && Yq.aIU != null) {
                                jSONObject.put("live_id", Yq.aIU.live_id);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yq.aIU.croom_id);
                                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "voiceframe");
                            }
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "framegeton_clk").setContentExt(jSONObject));
                        if (p.this.gYL == null) {
                            p.this.gYL = new com.baidu.live.an.a(tbPageContext.getPageActivity());
                        }
                        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                        cVar.url = str;
                        cVar.bWs = 0.7f;
                        p.this.gYL.alaLiveShowData = com.baidu.live.ao.a.Yj().Yq();
                        p.this.gYL.a(cVar);
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.NewPhoneFrameView.a
                    public void edL() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
                            if (Yq != null && Yq.aIU != null) {
                                jSONObject.put("live_id", Yq.aIU.live_id);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yq.aIU.croom_id);
                                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "voiceframe");
                            }
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "frameclose_clk").setContentExt(jSONObject));
                        p.this.edK();
                        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().dh((ViewGroup) view);
                    }
                });
                this.oHm.efg();
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 530);
                ofInt.setDuration(5300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.p.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (p.this.oHm != null) {
                            p.this.oHm.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    }
                });
                ofInt.start();
            }
        }
    }

    private double h(TbPageContext tbPageContext) {
        double d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(105.0f, tbPageContext.getPageActivity());
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        if (screenFullSize != null && screenFullSize[0] > 0 && screenFullSize[1] > 0) {
            return ((screenFullSize[0] * 2436) * 0.125d) / 1125.0d;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edK() {
        if (this.oHm != null && this.oHm.getParent() != null && (this.oHm.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.oHm.getParent()).removeView(this.oHm);
        }
    }

    private void WB(String str) {
        new com.baidu.tieba.yuyinala.liveroom.wheat.model.g(null, new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.p.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
            public void a(FrameNumCallBackHttpResponseMessage frameNumCallBackHttpResponseMessage) {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
            public void onFail(int i, String str2) {
            }
        }).ha("notice", str);
    }
}
