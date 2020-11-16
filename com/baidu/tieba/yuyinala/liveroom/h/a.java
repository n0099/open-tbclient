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
    private boolean bhc;
    private TextView euO;
    private w hkk;
    private TextView iPe;
    private Context mContext;
    private String mName;
    private View mView = null;
    private h nUY;
    private BarImageView nXZ;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.nUY = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.iPe = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.nXZ = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.euO = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.nXZ.setShowOval(true);
        this.nXZ.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.nXZ.setAutoChangeStyle(false);
        this.iPe.setBackgroundResource(a.e.yuyin_sdk_round_btn_qm_bg_radius_12_n);
        this.iPe.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.iPe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dXX();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.nUY.w(a.this.hkk.aHZ.aRe, a.this.hkk.aHZ.live_id, 1);
                    a.this.nUY.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.dXY();
                            a.this.iPe.setVisibility(8);
                            a.this.bhc = true;
                            a.this.dYb();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.bhc = false;
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
    public void dXX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hkk.aHZ.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.hkk.aHZ.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void dXZ() {
        this.bhc = true;
        this.iPe.setVisibility(8);
        dYb();
    }

    public void dYa() {
        this.bhc = false;
        this.iPe.setVisibility(0);
        dYb();
    }

    public View getView() {
        return this.mView;
    }

    public void Va(String str) {
        this.mName = str;
        dYb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYb() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.bhc) {
            if (textLengthAllOne <= 10) {
                this.euO.setText(str);
                return;
            }
            this.euO.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.euO.setText(str);
        } else {
            this.euO.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void Vb(String str) {
        this.nXZ.startLoad(str, 12, false, false);
    }

    public void V(w wVar) {
        if (wVar != null) {
            this.hkk = wVar;
            if (this.hkk.aHZ != null) {
                this.bhc = this.hkk.aHZ.is_followed;
                this.mName = this.hkk.aHZ.room_name;
                this.nXZ.stopLoad();
                this.nXZ.startLoad(this.hkk.aHZ.cover, 12, false, false);
                dYb();
                if (this.hkk.aHZ.is_followed) {
                    this.iPe.setVisibility(8);
                } else {
                    this.iPe.setVisibility(0);
                }
            }
        }
    }

    public void W(w wVar) {
        if (wVar != null) {
            this.hkk = wVar;
            if (this.hkk.aHZ != null) {
                this.mName = this.hkk.aHZ.room_name;
                this.nXZ.stopLoad();
                this.nXZ.startLoad(this.hkk.aHZ.cover, 12, false, false);
                dYb();
            }
        }
    }

    public void onDestroy() {
    }
}
