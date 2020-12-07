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
    private w aFN;
    private Activity mActivity;
    private a onb;
    private f onc;
    private CustomMessageListener ond = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aFN != null && b.this.aFN.aKL != null && b.this.aFN.aKL.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).PX().liveId)) {
                if (((YuyinFollowRoomMessage) customResponsedMessage).PX().isFollowed) {
                    if (b.this.onb != null) {
                        b.this.onb.edD();
                    }
                } else if (b.this.onb != null) {
                    b.this.onb.edE();
                }
            }
        }
    };
    private CustomMessageListener onf = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                try {
                    ShowRoomCard Qa = ((YuyinShowRoomDialogMessage) customResponsedMessage).Qa();
                    b.this.onc = new f(b.this.mActivity);
                    b.this.onc.ae(Qa.alaLiveShowData);
                } catch (Exception e) {
                }
            }
        }
    };
    private CustomMessageListener ong = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                b.this.edC();
            }
        }
    };
    private CustomMessageListener onh = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                b.this.onb.Wp(((YuyinRenameRoomMessage) customResponsedMessage).PZ().name);
            }
        }
    };
    private CustomMessageListener oni = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                b.this.onb.Wq(((YuyinModifyRoomMessage) customResponsedMessage).PY().url);
            }
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.onb.getView()) {
                b.this.onc = new f(b.this.mActivity);
                b.this.onc.ae(b.this.aFN);
                b.this.edG();
            }
        }
    };

    public b(Activity activity) {
        this.mActivity = activity;
        MessageManager.getInstance().registerListener(this.ond);
        MessageManager.getInstance().registerListener(this.onh);
        MessageManager.getInstance().registerListener(this.oni);
        MessageManager.getInstance().registerListener(this.onf);
        MessageManager.getInstance().registerListener(this.ong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "dialog");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    public void e(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            this.aFN = wVar;
            if (this.onb != null && this.onb.getView().getParent() != null) {
                ((ViewGroup) this.onb.getView().getParent()).removeView(this.onb.getView());
            }
            if (this.onb == null) {
                this.onb = new a(this.mActivity);
            }
            this.onb.setId(i);
            this.onb.getView().setOnClickListener(this.foP);
            if (this.aFN != null) {
                this.onb.aa(this.aFN);
            }
            this.onb.getView().setVisibility(0);
            ay(viewGroup);
        }
    }

    private void ay(ViewGroup viewGroup) {
        if (this.onb.getView() == null || this.onb.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.onb.getView(), 0, layoutParams);
        }
    }

    public void M(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.onb != null) {
            this.aFN = wVar;
            this.onb.ab(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    public void onDestroy() {
        if (this.onb != null) {
            this.onb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ond);
        MessageManager.getInstance().unRegisterListener(this.onh);
        MessageManager.getInstance().unRegisterListener(this.oni);
        MessageManager.getInstance().unRegisterListener(this.onf);
        MessageManager.getInstance().unRegisterListener(this.ong);
    }

    public void In(String str) {
        if (this.onc != null) {
            this.onc.In(str);
        }
    }
}
