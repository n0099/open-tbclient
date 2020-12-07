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
    private boolean blr;
    private TextView eBQ;
    private w htI;
    private TextView iZV;
    private Context mContext;
    private String mName;
    private View mView = null;
    private h ojW;
    private BarImageView omY;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.ojW = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.iZV = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.omY = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eBQ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.omY.setShowOval(true);
        this.omY.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.omY.setAutoChangeStyle(false);
        this.iZV.setBackgroundResource(a.e.yuyin_sdk_round_btn_qm_bg_radius_12_n);
        this.iZV.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.iZV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.edB();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.ojW.w(a.this.htI.aKL.aUg, a.this.htI.aKL.live_id, 1);
                    a.this.ojW.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.edC();
                            a.this.iZV.setVisibility(8);
                            a.this.blr = true;
                            a.this.edF();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.blr = false;
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
    public void edB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.htI.aKL.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.htI.aKL.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void edD() {
        this.blr = true;
        this.iZV.setVisibility(8);
        edF();
    }

    public void edE() {
        this.blr = false;
        this.iZV.setVisibility(0);
        edF();
    }

    public View getView() {
        return this.mView;
    }

    public void Wp(String str) {
        this.mName = str;
        edF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edF() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.blr) {
            if (textLengthAllOne <= 10) {
                this.eBQ.setText(str);
                return;
            }
            this.eBQ.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.eBQ.setText(str);
        } else {
            this.eBQ.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void Wq(String str) {
        this.omY.startLoad(str, 12, false, false);
    }

    public void aa(w wVar) {
        if (wVar != null) {
            this.htI = wVar;
            if (this.htI.aKL != null) {
                this.blr = this.htI.aKL.is_followed;
                this.mName = this.htI.aKL.room_name;
                this.omY.stopLoad();
                this.omY.startLoad(this.htI.aKL.cover, 12, false, false);
                edF();
                if (this.htI.aKL.is_followed) {
                    this.iZV.setVisibility(8);
                } else {
                    this.iZV.setVisibility(0);
                }
            }
        }
    }

    public void ab(w wVar) {
        if (wVar != null) {
            this.htI = wVar;
            if (this.htI.aKL != null) {
                this.mName = this.htI.aKL.room_name;
                this.omY.stopLoad();
                this.omY.startLoad(this.htI.aKL.cover, 12, false, false);
                edF();
            }
        }
    }

    public void onDestroy() {
    }
}
