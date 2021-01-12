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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aBr;
    private Activity mActivity;
    private a olJ;
    private f olK;
    private CustomMessageListener olL;
    private CustomMessageListener olM;
    private CustomMessageListener olN;
    private CustomMessageListener olO;
    private CustomMessageListener olP;
    private View.OnClickListener onClickListener;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.olL = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aBr != null && b.this.aBr.aGy != null && b.this.aBr.aGy.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).Nb().liveId)) {
                    if (((YuyinFollowRoomMessage) customResponsedMessage).Nb().isFollowed) {
                        if (b.this.olJ != null) {
                            b.this.olJ.dZd();
                        }
                    } else if (b.this.olJ != null) {
                        b.this.olJ.dZe();
                    }
                }
            }
        };
        this.olM = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                    try {
                        ShowRoomCard Ne = ((YuyinShowRoomDialogMessage) customResponsedMessage).Ne();
                        b.this.olK = new f(b.this.mActivity);
                        b.this.olK.ai(Ne.alaLiveShowData);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.olN = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                    b.this.dYZ();
                }
            }
        };
        this.olO = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinRenameRoomMessage) {
                    b.this.olJ.UH(((YuyinRenameRoomMessage) customResponsedMessage).Nd().name);
                }
            }
        };
        this.olP = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinModifyRoomMessage) {
                    b.this.olJ.UI(((YuyinModifyRoomMessage) customResponsedMessage).Nc().url);
                }
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.olJ.getView()) {
                    b.this.olK = new f(b.this.mActivity);
                    b.this.olK.ai(b.this.aBr);
                    b.this.dZg();
                }
            }
        };
        this.mActivity = tbPageContext.getPageActivity();
        MessageManager.getInstance().registerListener(this.olL);
        MessageManager.getInstance().registerListener(this.olO);
        MessageManager.getInstance().registerListener(this.olP);
        MessageManager.getInstance().registerListener(this.olM);
        MessageManager.getInstance().registerListener(this.olN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
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
            this.aBr = xVar;
            if (this.olJ != null && this.olJ.getView().getParent() != null) {
                ((ViewGroup) this.olJ.getView().getParent()).removeView(this.olJ.getView());
            }
            if (this.olJ == null) {
                this.olJ = new a(this.mActivity);
            }
            this.olJ.setId(i);
            this.olJ.getView().setOnClickListener(this.onClickListener);
            if (this.aBr != null) {
                this.olJ.ad(this.aBr);
            }
            this.olJ.getView().setVisibility(0);
            aK(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        if (this.olJ != null && this.olJ.getView() != null && this.olJ.getView().getParent() != null) {
            ((ViewGroup) this.olJ.getView().getParent()).removeView(this.olJ.getView());
        }
        if (this.olJ != null) {
            this.olJ.onDestroy();
            this.olJ = null;
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.olJ.getView() == null || this.olJ.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
            viewGroup.addView(this.olJ.getView(), 0, layoutParams);
        }
    }

    public void M(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && this.olJ != null) {
            this.aBr = xVar;
            this.olJ.ae(xVar);
        }
    }

    public void a(x xVar, RelativeLayout relativeLayout) {
        if (this.olJ == null) {
            e(relativeLayout, xVar);
        }
        if (xVar != null && xVar.mLiveInfo != null && this.olJ != null) {
            this.aBr = xVar;
            this.olJ.ad(this.aBr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.olJ != null) {
            this.olJ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.olL);
        MessageManager.getInstance().unRegisterListener(this.olO);
        MessageManager.getInstance().unRegisterListener(this.olP);
        MessageManager.getInstance().unRegisterListener(this.olM);
        MessageManager.getInstance().unRegisterListener(this.olN);
    }

    public void Hd(String str) {
        if (this.olK != null) {
            this.olK.Hd(str);
        }
    }
}
