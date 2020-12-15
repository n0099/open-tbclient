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
    private w htK;
    private TextView iZX;
    private Context mContext;
    private String mName;
    private View mView = null;
    private h ojY;
    private BarImageView ona;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.ojY = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.iZX = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.ona = (BarImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eBQ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.ona.setShowOval(true);
        this.ona.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.ona.setAutoChangeStyle(false);
        this.iZX.setBackgroundResource(a.e.yuyin_sdk_round_btn_qm_bg_radius_12_n);
        this.iZX.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.iZX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.edC();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.ojY.w(a.this.htK.aKL.aUg, a.this.htK.aKL.live_id, 1);
                    a.this.ojY.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.edD();
                            a.this.iZX.setVisibility(8);
                            a.this.blr = true;
                            a.this.edG();
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
    public void edC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.htK.aKL.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.htK.aKL.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void edE() {
        this.blr = true;
        this.iZX.setVisibility(8);
        edG();
    }

    public void edF() {
        this.blr = false;
        this.iZX.setVisibility(0);
        edG();
    }

    public View getView() {
        return this.mView;
    }

    public void Wp(String str) {
        this.mName = str;
        edG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edG() {
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
        this.ona.startLoad(str, 12, false, false);
    }

    public void aa(w wVar) {
        if (wVar != null) {
            this.htK = wVar;
            if (this.htK.aKL != null) {
                this.blr = this.htK.aKL.is_followed;
                this.mName = this.htK.aKL.room_name;
                this.ona.stopLoad();
                this.ona.startLoad(this.htK.aKL.cover, 12, false, false);
                edG();
                if (this.htK.aKL.is_followed) {
                    this.iZX.setVisibility(8);
                } else {
                    this.iZX.setVisibility(0);
                }
            }
        }
    }

    public void ab(w wVar) {
        if (wVar != null) {
            this.htK = wVar;
            if (this.htK.aKL != null) {
                this.mName = this.htK.aKL.room_name;
                this.ona.stopLoad();
                this.ona.startLoad(this.htK.aKL.cover, 12, false, false);
                edG();
            }
        }
    }

    public void onDestroy() {
    }
}
