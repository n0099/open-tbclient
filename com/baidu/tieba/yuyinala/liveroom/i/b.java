package com.baidu.tieba.yuyinala.liveroom.i;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.message.FollowPersonSuccMessage;
import com.baidu.live.message.ShowRoomCard;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.message.YuyinModifyRoomMessage;
import com.baidu.live.message.YuyinRenameRoomMessage;
import com.baidu.live.message.YuyinShowRoomDialogMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.roomcard.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aGe;
    private Activity mActivity;
    private View.OnClickListener onClickListener;
    private a oqr;
    private f oqs;
    private CustomMessageListener oqt;
    private CustomMessageListener oqu;
    private CustomMessageListener oqv;
    private CustomMessageListener oqw;
    private CustomMessageListener oqx;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oqt = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aGe != null && b.this.aGe.aLl != null && b.this.aGe.aLl.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).QW().liveId)) {
                    if (((YuyinFollowRoomMessage) customResponsedMessage).QW().isFollowed) {
                        if (b.this.oqr != null) {
                            b.this.oqr.ecU();
                        }
                    } else if (b.this.oqr != null) {
                        b.this.oqr.ecV();
                    }
                }
            }
        };
        this.oqu = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                    try {
                        ShowRoomCard QZ = ((YuyinShowRoomDialogMessage) customResponsedMessage).QZ();
                        b.this.oqs = new f(b.this.mActivity);
                        b.this.oqs.ai(QZ.alaLiveShowData);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.oqv = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                    b.this.ecQ();
                }
            }
        };
        this.oqw = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                    b.this.oqr.VQ(((YuyinRenameRoomMessage) customResponsedMessage).QY().name);
                }
            }
        };
        this.oqx = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                    b.this.oqr.VR(((YuyinModifyRoomMessage) customResponsedMessage).QX().url);
                }
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.oqr.getView()) {
                    b.this.oqs = new f(b.this.mActivity);
                    b.this.oqs.ai(b.this.aGe);
                    b.this.ecX();
                }
            }
        };
        this.mActivity = tbPageContext.getPageActivity();
        MessageManager.getInstance().registerListener(this.oqt);
        MessageManager.getInstance().registerListener(this.oqw);
        MessageManager.getInstance().registerListener(this.oqx);
        MessageManager.getInstance().registerListener(this.oqu);
        MessageManager.getInstance().registerListener(this.oqv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "dialog");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    public void e(ViewGroup viewGroup, x xVar) {
        a(viewGroup, xVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, x xVar, int i) {
        if (viewGroup != null) {
            this.aGe = xVar;
            if (this.oqr != null && this.oqr.getView().getParent() != null) {
                ((ViewGroup) this.oqr.getView().getParent()).removeView(this.oqr.getView());
            }
            if (this.oqr == null) {
                this.oqr = new a(this.mActivity);
            }
            this.oqr.setId(i);
            this.oqr.getView().setOnClickListener(this.onClickListener);
            if (this.aGe != null) {
                this.oqr.ad(this.aGe);
            }
            this.oqr.getView().setVisibility(0);
            aK(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.oqr != null && this.oqr.getView() != null && this.oqr.getView().getParent() != null) {
            ((ViewGroup) this.oqr.getView().getParent()).removeView(this.oqr.getView());
        }
        if (this.oqr != null) {
            this.oqr.onDestroy();
            this.oqr = null;
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.oqr.getView() == null || this.oqr.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.oqr.getView(), 0, layoutParams);
        }
    }

    public void M(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && this.oqr != null) {
            this.aGe = xVar;
            this.oqr.ae(xVar);
        }
    }

    public void a(x xVar, RelativeLayout relativeLayout) {
        if (this.oqr == null) {
            e(relativeLayout, xVar);
        }
        if (xVar != null && xVar.mLiveInfo != null && this.oqr != null) {
            this.aGe = xVar;
            this.oqr.ad(this.aGe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oqr != null) {
            this.oqr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.oqt);
        MessageManager.getInstance().unRegisterListener(this.oqw);
        MessageManager.getInstance().unRegisterListener(this.oqx);
        MessageManager.getInstance().unRegisterListener(this.oqu);
        MessageManager.getInstance().unRegisterListener(this.oqv);
    }

    public void Ip(String str) {
        if (this.oqs != null) {
            this.oqs.Ip(str);
        }
    }
}
