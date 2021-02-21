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
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.a {
    private ab aDd;
    private Activity mActivity;
    private View.OnClickListener onClickListener;
    private a owc;
    private f owd;
    private CustomMessageListener owe;
    private CustomMessageListener owf;
    private CustomMessageListener owg;
    private CustomMessageListener owh;
    private CustomMessageListener owi;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.owe = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aDd != null && b.this.aDd.aIU != null && b.this.aDd.aIU.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).Oz().liveId)) {
                    if (((YuyinFollowRoomMessage) customResponsedMessage).Oz().isFollowed) {
                        if (b.this.owc != null) {
                            b.this.owc.ebx();
                        }
                    } else if (b.this.owc != null) {
                        b.this.owc.eby();
                    }
                }
            }
        };
        this.owf = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                    try {
                        ShowRoomCard OC = ((YuyinShowRoomDialogMessage) customResponsedMessage).OC();
                        b.this.owd = new f(b.this.mActivity, OC.alaLiveShowData);
                        b.this.owd.ai(OC.alaLiveShowData);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.owg = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                    b.this.ebt();
                }
            }
        };
        this.owh = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinRenameRoomMessage) && b.this.owc != null) {
                    b.this.owc.VS(((YuyinRenameRoomMessage) customResponsedMessage).OB().name);
                }
            }
        };
        this.owi = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinModifyRoomMessage) && b.this.owc != null) {
                    b.this.owc.VT(((YuyinModifyRoomMessage) customResponsedMessage).OA().url);
                }
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.owc != null && view == b.this.owc.getView()) {
                    b.this.owd = new f(b.this.mActivity, b.this.aDd);
                    b.this.owd.ai(b.this.aDd);
                    b.this.ebA();
                }
            }
        };
        this.mActivity = tbPageContext.getPageActivity();
        MessageManager.getInstance().registerListener(this.owe);
        MessageManager.getInstance().registerListener(this.owh);
        MessageManager.getInstance().registerListener(this.owi);
        MessageManager.getInstance().registerListener(this.owf);
        MessageManager.getInstance().registerListener(this.owg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
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
            this.aDd = abVar;
            if (this.owc != null && this.owc.getView().getParent() != null) {
                ((ViewGroup) this.owc.getView().getParent()).removeView(this.owc.getView());
            }
            if (this.owc == null) {
                this.owc = new a(this.mActivity);
            }
            this.owc.setId(i);
            this.owc.getView().setOnClickListener(this.onClickListener);
            if (this.aDd != null) {
                this.owc.ac(this.aDd);
            }
            this.owc.getView().setVisibility(0);
            aK(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.owc != null) {
            this.owc.onDestroy();
            this.owc = null;
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.owc != null) {
            if (this.owc.getView() == null || this.owc.getView().getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
                layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
                viewGroup.addView(this.owc.getView(), 0, layoutParams);
            }
        }
    }

    public void N(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && this.owc != null) {
            this.aDd = abVar;
            this.owc.ad(abVar);
        }
    }

    public void a(ab abVar, RelativeLayout relativeLayout) {
        if (this.owc == null) {
            e(relativeLayout, abVar);
        } else if (abVar != null && abVar.mLiveInfo != null) {
            this.aDd = abVar;
            this.owc.ac(this.aDd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roominfo_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.owc != null) {
            this.owc.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.owe);
        MessageManager.getInstance().unRegisterListener(this.owh);
        MessageManager.getInstance().unRegisterListener(this.owi);
        MessageManager.getInstance().unRegisterListener(this.owf);
        MessageManager.getInstance().unRegisterListener(this.owg);
    }

    public void HI(String str) {
        if (this.owd != null) {
            this.owd.HI(str);
        }
    }
}
