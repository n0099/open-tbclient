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
    private w aEc;
    private Activity mActivity;
    private a nPq;
    private f nPr;
    private CustomMessageListener nPs = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aEc != null && b.this.aEc.aIS != null && b.this.aEc.aIS.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).NN().liveId)) {
                if (((YuyinFollowRoomMessage) customResponsedMessage).NN().isFollowed) {
                    if (b.this.nPq != null) {
                        b.this.nPq.dVl();
                    }
                } else if (b.this.nPq != null) {
                    b.this.nPq.dVm();
                }
            }
        }
    };
    private CustomMessageListener nPt = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                try {
                    ShowRoomCard NQ = ((YuyinShowRoomDialogMessage) customResponsedMessage).NQ();
                    b.this.nPr = new f(b.this.mActivity);
                    b.this.nPr.S(NQ.alaLiveShowData);
                } catch (Exception e) {
                }
            }
        }
    };
    private CustomMessageListener nPu = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                b.this.dVk();
            }
        }
    };
    private CustomMessageListener nPv = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                b.this.nPq.UY(((YuyinRenameRoomMessage) customResponsedMessage).NP().name);
            }
        }
    };
    private CustomMessageListener nPw = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                b.this.nPq.UZ(((YuyinModifyRoomMessage) customResponsedMessage).NO().url);
            }
        }
    };
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.nPq.getView()) {
                b.this.nPr = new f(b.this.mActivity);
                b.this.nPr.S(b.this.aEc);
                b.this.dVo();
            }
        }
    };

    public b(Activity activity) {
        this.mActivity = activity;
        MessageManager.getInstance().registerListener(this.nPs);
        MessageManager.getInstance().registerListener(this.nPv);
        MessageManager.getInstance().registerListener(this.nPw);
        MessageManager.getInstance().registerListener(this.nPt);
        MessageManager.getInstance().registerListener(this.nPu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "dialog");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    public void d(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            this.aEc = wVar;
            if (this.nPq != null && this.nPq.getView().getParent() != null) {
                ((ViewGroup) this.nPq.getView().getParent()).removeView(this.nPq.getView());
            }
            if (this.nPq == null) {
                this.nPq = new a(this.mActivity);
            }
            this.nPq.setId(i);
            this.nPq.getView().setOnClickListener(this.fcr);
            if (this.aEc != null) {
                this.nPq.N(this.aEc);
            }
            this.nPq.getView().setVisibility(0);
            aA(viewGroup);
        }
    }

    private void aA(ViewGroup viewGroup) {
        if (this.nPq.getView() == null || this.nPq.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds12) : 0);
            viewGroup.addView(this.nPq.getView(), 0, layoutParams);
        }
    }

    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.nPq != null) {
            this.aEc = wVar;
            this.nPq.O(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    public void onDestroy() {
        if (this.nPq != null) {
            this.nPq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.nPs);
        MessageManager.getInstance().unRegisterListener(this.nPv);
        MessageManager.getInstance().unRegisterListener(this.nPw);
        MessageManager.getInstance().unRegisterListener(this.nPt);
        MessageManager.getInstance().unRegisterListener(this.nPu);
    }

    public void HF(String str) {
        if (this.nPr != null) {
            this.nPr.HF(str);
        }
    }
}
