package com.baidu.tieba.yuyinala.liveroom.h;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
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
import com.baidu.tieba.yuyinala.liveroom.roomcard.AlaGetCollectRoomHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean biQ;
    private TextView ewx;
    private w hkD;
    private TextView iOr;
    private Context mContext;
    private String mName;
    private View mView = null;
    private h nTv;
    private BarImageView nWw;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.nTv = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.iOr = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.nWw = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.ewx = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.nWw.setShowOval(true);
        this.nWw.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.nWw.setAutoChangeStyle(false);
        this.iOr.setBackgroundResource(a.e.yuyin_sdk_round_btn_qm_bg_radius_12_n);
        this.iOr.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.iOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dXY();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.nTv.w(a.this.hkD.aJK.aSP, a.this.hkD.aJK.live_id, 1);
                    a.this.nTv.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.dXZ();
                            a.this.iOr.setVisibility(8);
                            a.this.biQ = true;
                            a.this.dYc();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.biQ = false;
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
    public void dXY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hkD.aJK.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hkD.aJK.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void dYa() {
        this.biQ = true;
        this.iOr.setVisibility(8);
        dYc();
    }

    public void dYb() {
        this.biQ = false;
        this.iOr.setVisibility(0);
        dYc();
    }

    public View getView() {
        return this.mView;
    }

    public void Vp(String str) {
        this.mName = str;
        dYc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYc() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.biQ) {
            if (textLengthAllOne <= 10) {
                this.ewx.setText(str);
                return;
            }
            this.ewx.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.ewx.setText(str);
        } else {
            this.ewx.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void Vq(String str) {
        this.nWw.startLoad(str, 12, false, false);
    }

    public void V(w wVar) {
        if (wVar != null) {
            this.hkD = wVar;
            if (this.hkD.aJK != null) {
                this.biQ = this.hkD.aJK.is_followed;
                this.mName = this.hkD.aJK.room_name;
                this.nWw.stopLoad();
                this.nWw.startLoad(this.hkD.aJK.cover, 12, false, false);
                dYc();
                if (this.hkD.aJK.is_followed) {
                    this.iOr.setVisibility(8);
                } else {
                    this.iOr.setVisibility(0);
                }
            }
        }
    }

    public void W(w wVar) {
        if (wVar != null) {
            this.hkD = wVar;
            if (this.hkD.aJK != null) {
                this.mName = this.hkD.aJK.room_name;
                this.nWw.stopLoad();
                this.nWw.startLoad(this.hkD.aJK.cover, 12, false, false);
                dYc();
            }
        }
    }

    public void onDestroy() {
    }
}
