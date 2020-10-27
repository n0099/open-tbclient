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
    private boolean bhu;
    private TextView eqE;
    private w heH;
    private TextView iIu;
    private Context mContext;
    private String mName;
    private View mView = null;
    private h nNB;
    private BarImageView nPn;

    public a(Context context) {
        this.mContext = context;
        initView();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.nNB = new h(this.mContext);
        this.mView = View.inflate(this.mContext, a.h.yuyin_ala_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.f.sdk_round_host_bg);
        this.iIu = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.nPn = (BarImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.eqE = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.nPn.setShowOval(true);
        this.nPn.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.nPn.setAutoChangeStyle(false);
        this.iIu.setBackgroundResource(a.f.yuyin_sdk_round_btn_qm_bg_radius_12_n);
        this.iIu.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.iIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dVj();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else if (BdUtilHelper.isNetOk()) {
                    a.this.nNB.v(a.this.heH.aIS.aRy, a.this.heH.aIS.live_id, 1);
                    a.this.nNB.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            a.this.dVk();
                            a.this.iIu.setVisibility(8);
                            a.this.bhu = true;
                            a.this.dVn();
                            BdUtilHelper.showToast(a.this.mContext, "收藏成功，将收到房间的开播提醒", 3000);
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            a.this.bhu = false;
                            BdUtilHelper.showToast(a.this.mContext, "房间收藏失败", 3000);
                        }
                    });
                } else {
                    BdUtilHelper.showToast(a.this.mContext, a.this.mContext.getResources().getString(a.i.sdk_neterror));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.heH.aIS.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.heH.aIS.croom_id);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void dVl() {
        this.bhu = true;
        this.iIu.setVisibility(8);
        dVn();
    }

    public void dVm() {
        this.bhu = false;
        this.iIu.setVisibility(0);
        dVn();
    }

    public View getView() {
        return this.mView;
    }

    public void UY(String str) {
        this.mName = str;
        dVn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVn() {
        String str = this.mName;
        int textLengthAllOne = TextHelper.getTextLengthAllOne(str);
        if (this.bhu) {
            if (textLengthAllOne <= 10) {
                this.eqE.setText(str);
                return;
            }
            this.eqE.setText(TextHelper.subStringWithAllOne(str, 7) + StringHelper.STRING_MORE);
        } else if (textLengthAllOne <= 6) {
            this.eqE.setText(str);
        } else {
            this.eqE.setText(TextHelper.subStringWithAllOne(str, 5) + StringHelper.STRING_MORE);
        }
    }

    public void UZ(String str) {
        this.nPn.startLoad(str, 12, false, false);
    }

    public void N(w wVar) {
        if (wVar != null) {
            this.heH = wVar;
            if (this.heH.aIS != null) {
                this.bhu = this.heH.aIS.is_followed;
                this.mName = this.heH.aIS.room_name;
                this.nPn.stopLoad();
                this.nPn.startLoad(this.heH.aIS.cover, 12, false, false);
                dVn();
                if (this.heH.aIS.is_followed) {
                    this.iIu.setVisibility(8);
                } else {
                    this.iIu.setVisibility(0);
                }
            }
        }
    }

    public void O(w wVar) {
        if (wVar != null) {
            this.heH = wVar;
            if (this.heH.aIS != null) {
                this.mName = this.heH.aIS.room_name;
                this.nPn.stopLoad();
                this.nPn.startLoad(this.heH.aIS.cover, 12, false, false);
                dVn();
            }
        }
    }

    public void onDestroy() {
    }
}
