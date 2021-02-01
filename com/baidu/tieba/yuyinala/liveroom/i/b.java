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
    private a ovC;
    private f ovD;
    private CustomMessageListener ovE;
    private CustomMessageListener ovF;
    private CustomMessageListener ovG;
    private CustomMessageListener ovH;
    private CustomMessageListener ovI;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ovE = new CustomMessageListener(2501028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinFollowRoomMessage) && b.this.aDd != null && b.this.aDd.aIU != null && b.this.aDd.aIU.live_id.equals(((YuyinFollowRoomMessage) customResponsedMessage).Oz().liveId)) {
                    if (((YuyinFollowRoomMessage) customResponsedMessage).Oz().isFollowed) {
                        if (b.this.ovC != null) {
                            b.this.ovC.ebp();
                        }
                    } else if (b.this.ovC != null) {
                        b.this.ovC.ebq();
                    }
                }
            }
        };
        this.ovF = new CustomMessageListener(2501054) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof YuyinShowRoomDialogMessage) {
                    try {
                        ShowRoomCard OC = ((YuyinShowRoomDialogMessage) customResponsedMessage).OC();
                        b.this.ovD = new f(b.this.mActivity, OC.alaLiveShowData);
                        b.this.ovD.ai(OC.alaLiveShowData);
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.ovG = new CustomMessageListener(2501055) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof FollowPersonSuccMessage) {
                    b.this.ebl();
                }
            }
        };
        this.ovH = new CustomMessageListener(2501029) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinRenameRoomMessage) && b.this.ovC != null) {
                    b.this.ovC.VG(((YuyinRenameRoomMessage) customResponsedMessage).OB().name);
                }
            }
        };
        this.ovI = new CustomMessageListener(2501030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof YuyinModifyRoomMessage) && b.this.ovC != null) {
                    b.this.ovC.VH(((YuyinModifyRoomMessage) customResponsedMessage).OA().url);
                }
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ovC != null && view == b.this.ovC.getView()) {
                    b.this.ovD = new f(b.this.mActivity, b.this.aDd);
                    b.this.ovD.ai(b.this.aDd);
                    b.this.ebs();
                }
            }
        };
        this.mActivity = tbPageContext.getPageActivity();
        MessageManager.getInstance().registerListener(this.ovE);
        MessageManager.getInstance().registerListener(this.ovH);
        MessageManager.getInstance().registerListener(this.ovI);
        MessageManager.getInstance().registerListener(this.ovF);
        MessageManager.getInstance().registerListener(this.ovG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
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
            if (this.ovC != null && this.ovC.getView().getParent() != null) {
                ((ViewGroup) this.ovC.getView().getParent()).removeView(this.ovC.getView());
            }
            if (this.ovC == null) {
                this.ovC = new a(this.mActivity);
            }
            this.ovC.setId(i);
            this.ovC.getView().setOnClickListener(this.onClickListener);
            if (this.aDd != null) {
                this.ovC.ac(this.aDd);
            }
            this.ovC.getView().setVisibility(0);
            aK(viewGroup);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.ovC != null) {
            this.ovC.onDestroy();
            this.ovC = null;
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.ovC != null) {
            if (this.ovC.getView() == null || this.ovC.getView().getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds72));
                layoutParams.leftMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds20);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds12) : 0);
                viewGroup.addView(this.ovC.getView(), 0, layoutParams);
            }
        }
    }

    public void N(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && this.ovC != null) {
            this.aDd = abVar;
            this.ovC.ad(abVar);
        }
    }

    public void a(ab abVar, RelativeLayout relativeLayout) {
        if (this.ovC == null) {
            e(relativeLayout, abVar);
        } else if (abVar != null && abVar.mLiveInfo != null) {
            this.aDd = abVar;
            this.ovC.ac(this.aDd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebs() {
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
        if (this.ovC != null) {
            this.ovC.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ovE);
        MessageManager.getInstance().unRegisterListener(this.ovH);
        MessageManager.getInstance().unRegisterListener(this.ovI);
        MessageManager.getInstance().unRegisterListener(this.ovF);
        MessageManager.getInstance().unRegisterListener(this.ovG);
    }

    public void HH(String str) {
        if (this.ovD != null) {
            this.ovD.HH(str);
        }
    }
}
