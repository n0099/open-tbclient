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
    private a oqq;
    private f oqr;
    private CustomMessageListener oqs;
    private CustomMessageListener oqt;
    private CustomMessageListener oqu;
    private CustomMessageListener oqv;
    private CustomMessageListener oqw;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oqs = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aGe != null && b.this.aGe.aLl != null && b.this.aGe.aLl.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).QW().liveId)) {
                    if (((YuyinFollowRoomMessage) customResponsedMessage).QW().isFollowed) {
                        if (b.this.oqq != null) {
                            b.this.oqq.ecV();
                        }
                    } else if (b.this.oqq != null) {
                        b.this.oqq.ecW();
                    }
                }
            }
        };
        this.oqt = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                    try {
                        ShowRoomCard QZ = ((YuyinShowRoomDialogMessage) customResponsedMessage).QZ();
                        b.this.oqr = new f(b.this.mActivity);
                        b.this.oqr.ai(QZ.alaLiveShowData);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.oqu = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                    b.this.ecR();
                }
            }
        };
        this.oqv = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                    b.this.oqq.VP(((YuyinRenameRoomMessage) customResponsedMessage).QY().name);
                }
            }
        };
        this.oqw = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                    b.this.oqq.VQ(((YuyinModifyRoomMessage) customResponsedMessage).QX().url);
                }
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.oqq.getView()) {
                    b.this.oqr = new f(b.this.mActivity);
                    b.this.oqr.ai(b.this.aGe);
                    b.this.ecY();
                }
            }
        };
        this.mActivity = tbPageContext.getPageActivity();
        MessageManager.getInstance().registerListener(this.oqs);
        MessageManager.getInstance().registerListener(this.oqv);
        MessageManager.getInstance().registerListener(this.oqw);
        MessageManager.getInstance().registerListener(this.oqt);
        MessageManager.getInstance().registerListener(this.oqu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecR() {
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
            if (this.oqq != null && this.oqq.getView().getParent() != null) {
                ((ViewGroup) this.oqq.getView().getParent()).removeView(this.oqq.getView());
            }
            if (this.oqq == null) {
                this.oqq = new a(this.mActivity);
            }
            this.oqq.setId(i);
            this.oqq.getView().setOnClickListener(this.onClickListener);
            if (this.aGe != null) {
                this.oqq.ad(this.aGe);
            }
            this.oqq.getView().setVisibility(0);
            aK(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.oqq != null && this.oqq.getView() != null && this.oqq.getView().getParent() != null) {
            ((ViewGroup) this.oqq.getView().getParent()).removeView(this.oqq.getView());
        }
        if (this.oqq != null) {
            this.oqq.onDestroy();
            this.oqq = null;
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.oqq.getView() == null || this.oqq.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.oqq.getView(), 0, layoutParams);
        }
    }

    public void M(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && this.oqq != null) {
            this.aGe = xVar;
            this.oqq.ae(xVar);
        }
    }

    public void a(x xVar, RelativeLayout relativeLayout) {
        if (this.oqq == null) {
            e(relativeLayout, xVar);
        }
        if (xVar != null && xVar.mLiveInfo != null && this.oqq != null) {
            this.aGe = xVar;
            this.oqq.ad(this.aGe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecY() {
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
        if (this.oqq != null) {
            this.oqq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.oqs);
        MessageManager.getInstance().unRegisterListener(this.oqv);
        MessageManager.getInstance().unRegisterListener(this.oqw);
        MessageManager.getInstance().unRegisterListener(this.oqt);
        MessageManager.getInstance().unRegisterListener(this.oqu);
    }

    public void Io(String str) {
        if (this.oqr != null) {
            this.oqr.Io(str);
        }
    }
}
