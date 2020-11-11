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
    private w aES;
    private Activity mActivity;
    private f nWA;
    private a nWz;
    private CustomMessageListener nWB = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aES != null && b.this.aES.aJK != null && b.this.aES.aJK.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).On().liveId)) {
                if (((YuyinFollowRoomMessage) customResponsedMessage).On().isFollowed) {
                    if (b.this.nWz != null) {
                        b.this.nWz.dYa();
                    }
                } else if (b.this.nWz != null) {
                    b.this.nWz.dYb();
                }
            }
        }
    };
    private CustomMessageListener nWC = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                try {
                    ShowRoomCard Oq = ((YuyinShowRoomDialogMessage) customResponsedMessage).Oq();
                    b.this.nWA = new f(b.this.mActivity);
                    b.this.nWA.Z(Oq.alaLiveShowData);
                } catch (Exception e) {
                }
            }
        }
    };
    private CustomMessageListener nWD = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                b.this.dXZ();
            }
        }
    };
    private CustomMessageListener nWE = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                b.this.nWz.Vp(((YuyinRenameRoomMessage) customResponsedMessage).Op().name);
            }
        }
    };
    private CustomMessageListener nWF = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                b.this.nWz.Vq(((YuyinModifyRoomMessage) customResponsedMessage).Oo().url);
            }
        }
    };
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.nWz.getView()) {
                b.this.nWA = new f(b.this.mActivity);
                b.this.nWA.Z(b.this.aES);
                b.this.dYd();
            }
        }
    };

    public b(Activity activity) {
        this.mActivity = activity;
        MessageManager.getInstance().registerListener(this.nWB);
        MessageManager.getInstance().registerListener(this.nWE);
        MessageManager.getInstance().registerListener(this.nWF);
        MessageManager.getInstance().registerListener(this.nWC);
        MessageManager.getInstance().registerListener(this.nWD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
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
            this.aES = wVar;
            if (this.nWz != null && this.nWz.getView().getParent() != null) {
                ((ViewGroup) this.nWz.getView().getParent()).removeView(this.nWz.getView());
            }
            if (this.nWz == null) {
                this.nWz = new a(this.mActivity);
            }
            this.nWz.setId(i);
            this.nWz.getView().setOnClickListener(this.fii);
            if (this.aES != null) {
                this.nWz.V(this.aES);
            }
            this.nWz.getView().setVisibility(0);
            aC(viewGroup);
        }
    }

    private void aC(ViewGroup viewGroup) {
        if (this.nWz.getView() == null || this.nWz.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.nWz.getView(), 0, layoutParams);
        }
    }

    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.nWz != null) {
            this.aES = wVar;
            this.nWz.W(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    public void onDestroy() {
        if (this.nWz != null) {
            this.nWz.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.nWB);
        MessageManager.getInstance().unRegisterListener(this.nWE);
        MessageManager.getInstance().unRegisterListener(this.nWF);
        MessageManager.getInstance().unRegisterListener(this.nWC);
        MessageManager.getInstance().unRegisterListener(this.nWD);
    }

    public void HX(String str) {
        if (this.nWA != null) {
            this.nWA.HX(str);
        }
    }
}
