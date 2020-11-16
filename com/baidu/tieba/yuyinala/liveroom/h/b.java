package com.baidu.tieba.yuyinala.liveroom.h;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.message.FollowPersonSuccMessage;
import com.baidu.live.message.ShowRoomCard;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.message.YuyinModifyRoomMessage;
import com.baidu.live.message.YuyinRenameRoomMessage;
import com.baidu.live.message.YuyinShowRoomDialogMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.roomcard.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private w aDh;
    private Activity mActivity;
    private a nYc;
    private f nYd;
    private CustomMessageListener nYe = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aDh != null && b.this.aDh.aHZ != null && b.this.aDh.aHZ.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).NE().liveId)) {
                if (((YuyinFollowRoomMessage) customResponsedMessage).NE().isFollowed) {
                    if (b.this.nYc != null) {
                        b.this.nYc.dXZ();
                    }
                } else if (b.this.nYc != null) {
                    b.this.nYc.dYa();
                }
            }
        }
    };
    private CustomMessageListener nYf = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                try {
                    ShowRoomCard NH = ((YuyinShowRoomDialogMessage) customResponsedMessage).NH();
                    b.this.nYd = new f(b.this.mActivity);
                    b.this.nYd.Z(NH.alaLiveShowData);
                } catch (Exception e) {
                }
            }
        }
    };
    private CustomMessageListener nYg = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                b.this.dXY();
            }
        }
    };
    private CustomMessageListener nYh = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                b.this.nYc.Va(((YuyinRenameRoomMessage) customResponsedMessage).NG().name);
            }
        }
    };
    private CustomMessageListener nYi = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                b.this.nYc.Vb(((YuyinModifyRoomMessage) customResponsedMessage).NF().url);
            }
        }
    };
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.nYc.getView()) {
                b.this.nYd = new f(b.this.mActivity);
                b.this.nYd.Z(b.this.aDh);
                b.this.dYc();
            }
        }
    };

    public b(Activity activity) {
        this.mActivity = activity;
        MessageManager.getInstance().registerListener(this.nYe);
        MessageManager.getInstance().registerListener(this.nYh);
        MessageManager.getInstance().registerListener(this.nYi);
        MessageManager.getInstance().registerListener(this.nYf);
        MessageManager.getInstance().registerListener(this.nYg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "dialog");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    public void d(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            this.aDh = wVar;
            if (this.nYc != null && this.nYc.getView().getParent() != null) {
                ((ViewGroup) this.nYc.getView().getParent()).removeView(this.nYc.getView());
            }
            if (this.nYc == null) {
                this.nYc = new a(this.mActivity);
            }
            this.nYc.setId(i);
            this.nYc.getView().setOnClickListener(this.fhp);
            if (this.aDh != null) {
                this.nYc.V(this.aDh);
            }
            this.nYc.getView().setVisibility(0);
            ay(viewGroup);
        }
    }

    private void ay(ViewGroup viewGroup) {
        if (this.nYc.getView() == null || this.nYc.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.nYc.getView(), 0, layoutParams);
        }
    }

    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.nYc != null) {
            this.aDh = wVar;
            this.nYc.W(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    public void onDestroy() {
        if (this.nYc != null) {
            this.nYc.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.nYe);
        MessageManager.getInstance().unRegisterListener(this.nYh);
        MessageManager.getInstance().unRegisterListener(this.nYi);
        MessageManager.getInstance().unRegisterListener(this.nYf);
        MessageManager.getInstance().unRegisterListener(this.nYg);
    }

    public void Hy(String str) {
        if (this.nYd != null) {
            this.nYd.Hy(str);
        }
    }
}
