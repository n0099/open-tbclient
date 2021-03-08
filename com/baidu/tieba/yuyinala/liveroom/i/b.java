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
import com.baidu.live.data.ab;
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
    private ab aED;
    private Activity mActivity;
    private View.OnClickListener onClickListener;
    private a oyh;
    private f oyi;
    private CustomMessageListener oyj;
    private CustomMessageListener oyk;
    private CustomMessageListener oyl;
    private CustomMessageListener oym;
    private CustomMessageListener oyn;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oyj = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aED != null && b.this.aED.aKu != null && b.this.aED.aKu.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).OC().liveId)) {
                    if (((YuyinFollowRoomMessage) customResponsedMessage).OC().isFollowed) {
                        if (b.this.oyh != null) {
                            b.this.oyh.ebF();
                        }
                    } else if (b.this.oyh != null) {
                        b.this.oyh.ebG();
                    }
                }
            }
        };
        this.oyk = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                    try {
                        ShowRoomCard OF = ((YuyinShowRoomDialogMessage) customResponsedMessage).OF();
                        b.this.oyi = new f(b.this.mActivity, OF.alaLiveShowData);
                        b.this.oyi.ai(OF.alaLiveShowData);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.oyl = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                    b.this.ebB();
                }
            }
        };
        this.oym = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinRenameRoomMessage) && b.this.oyh != null) {
                    b.this.oyh.VZ(((YuyinRenameRoomMessage) customResponsedMessage).OE().name);
                }
            }
        };
        this.oyn = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinModifyRoomMessage) && b.this.oyh != null) {
                    b.this.oyh.Wa(((YuyinModifyRoomMessage) customResponsedMessage).OD().url);
                }
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.oyh != null && view == b.this.oyh.getView()) {
                    b.this.oyi = new f(b.this.mActivity, b.this.aED);
                    b.this.oyi.ai(b.this.aED);
                    b.this.ebI();
                }
            }
        };
        this.mActivity = tbPageContext.getPageActivity();
        MessageManager.getInstance().registerListener(this.oyj);
        MessageManager.getInstance().registerListener(this.oym);
        MessageManager.getInstance().registerListener(this.oyn);
        MessageManager.getInstance().registerListener(this.oyk);
        MessageManager.getInstance().registerListener(this.oyl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "dialog");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    public void e(ViewGroup viewGroup, ab abVar) {
        a(viewGroup, abVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, ab abVar, int i) {
        if (viewGroup != null) {
            this.aED = abVar;
            if (this.oyh != null && this.oyh.getView().getParent() != null) {
                ((ViewGroup) this.oyh.getView().getParent()).removeView(this.oyh.getView());
            }
            if (this.oyh == null) {
                this.oyh = new a(this.mActivity);
            }
            this.oyh.setId(i);
            this.oyh.getView().setOnClickListener(this.onClickListener);
            if (this.aED != null) {
                this.oyh.ac(this.aED);
            }
            this.oyh.getView().setVisibility(0);
            aK(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        super.Au();
        if (this.oyh != null) {
            this.oyh.onDestroy();
            this.oyh = null;
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.oyh != null) {
            if (this.oyh.getView() == null || this.oyh.getView().getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
                layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
                viewGroup.addView(this.oyh.getView(), 0, layoutParams);
            }
        }
    }

    public void N(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && this.oyh != null) {
            this.aED = abVar;
            this.oyh.ad(abVar);
        }
    }

    public void a(ab abVar, RelativeLayout relativeLayout) {
        if (this.oyh == null) {
            e(relativeLayout, abVar);
        } else if (abVar != null && abVar.mLiveInfo != null) {
            this.aED = abVar;
            this.oyh.ac(this.aED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oyh != null) {
            this.oyh.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.oyj);
        MessageManager.getInstance().unRegisterListener(this.oym);
        MessageManager.getInstance().unRegisterListener(this.oyn);
        MessageManager.getInstance().unRegisterListener(this.oyk);
        MessageManager.getInstance().unRegisterListener(this.oyl);
    }

    public void HR(String str) {
        if (this.oyi != null) {
            this.oyi.HR(str);
        }
    }
}
