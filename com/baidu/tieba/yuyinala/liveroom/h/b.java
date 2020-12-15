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
    private a ond;
    private f onf;
    private CustomMessageListener ong = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aFN != null && b.this.aFN.aKL != null && b.this.aFN.aKL.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).PX().liveId)) {
                if (((YuyinFollowRoomMessage) customResponsedMessage).PX().isFollowed) {
                    if (b.this.ond != null) {
                        b.this.ond.edE();
                    }
                } else if (b.this.ond != null) {
                    b.this.ond.edF();
                }
            }
        }
    };
    private CustomMessageListener onh = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                try {
                    ShowRoomCard Qa = ((YuyinShowRoomDialogMessage) customResponsedMessage).Qa();
                    b.this.onf = new f(b.this.mActivity);
                    b.this.onf.ae(Qa.alaLiveShowData);
                } catch (Exception e) {
                }
            }
        }
    };
    private CustomMessageListener oni = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                b.this.edD();
            }
        }
    };
    private CustomMessageListener onj = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                b.this.ond.Wp(((YuyinRenameRoomMessage) customResponsedMessage).PZ().name);
            }
        }
    };
    private CustomMessageListener onk = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                b.this.ond.Wq(((YuyinModifyRoomMessage) customResponsedMessage).PY().url);
            }
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.ond.getView()) {
                b.this.onf = new f(b.this.mActivity);
                b.this.onf.ae(b.this.aFN);
                b.this.edH();
            }
        }
    };

    public b(Activity activity) {
        this.mActivity = activity;
        MessageManager.getInstance().registerListener(this.ong);
        MessageManager.getInstance().registerListener(this.onj);
        MessageManager.getInstance().registerListener(this.onk);
        MessageManager.getInstance().registerListener(this.onh);
        MessageManager.getInstance().registerListener(this.oni);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edD() {
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
            if (this.ond != null && this.ond.getView().getParent() != null) {
                ((ViewGroup) this.ond.getView().getParent()).removeView(this.ond.getView());
            }
            if (this.ond == null) {
                this.ond = new a(this.mActivity);
            }
            this.ond.setId(i);
            this.ond.getView().setOnClickListener(this.foP);
            if (this.aFN != null) {
                this.ond.aa(this.aFN);
            }
            this.ond.getView().setVisibility(0);
            ay(viewGroup);
        }
    }

    private void ay(ViewGroup viewGroup) {
        if (this.ond.getView() == null || this.ond.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.ond.getView(), 0, layoutParams);
        }
    }

    public void M(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.ond != null) {
            this.aFN = wVar;
            this.ond.ab(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edH() {
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
        if (this.ond != null) {
            this.ond.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ong);
        MessageManager.getInstance().unRegisterListener(this.onj);
        MessageManager.getInstance().unRegisterListener(this.onk);
        MessageManager.getInstance().unRegisterListener(this.onh);
        MessageManager.getInstance().unRegisterListener(this.oni);
    }

    public void In(String str) {
        if (this.onf != null) {
            this.onf.In(str);
        }
    }
}
