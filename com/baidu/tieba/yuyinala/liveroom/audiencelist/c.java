package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private w aEc;
    private ViewGroup bEg;
    private com.baidu.live.liveroom.a.a gSJ;
    public FrameLayout gSL;
    public FrameLayout gSM;
    private AlphaGradientHListView gSN;
    private AdapterView.c gSQ = new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            p pVar = (p) c.this.nOZ.getItem(i);
            if (pVar != null) {
                if (c.this.gSJ != null) {
                    c.this.gSJ.eO(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(pVar.aIe.userUk), pVar.aIe.userName, pVar.aIe.portrait, 0, 0, "", "", 0L, 0L, 0L, 0, "", c.this.mLiveId, false, "", "", pVar.aIe.userName, "")));
                c.this.LI(i);
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                c.this.otherParams = str;
            }
        }
    };
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private a nOZ;
    private String otherParams;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        this.mTbPageContext = tbPageContext;
        this.gSJ = aVar;
        MessageManager.getInstance().registerListener(this.gpA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, w wVar) {
        this.mLiveId = str;
        this.aEc = wVar;
    }

    public void UX(String str) {
        this.mLiveId = str;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gSL == null) {
                this.gSL = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.yuyin_ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bEg != null && this.bEg.indexOfChild(this.gSL) > 0) {
                this.bEg.removeView(this.gSL);
            }
            this.bEg = viewGroup;
            this.gSL.setId(a.g.ala_liveroom_audience);
            this.gSM = (FrameLayout) this.gSL.findViewById(a.g.content_layout);
            this.gSN = (AlphaGradientHListView) this.gSL.findViewById(a.g.ala_live_guest_listview);
            this.gSN.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.nOZ = new a(getPageContext().getPageActivity());
            this.gSN.setAdapter((ListAdapter) this.nOZ);
            this.gSN.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gSN.setOnItemClickListener(this.gSQ);
            this.gSN.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gSN.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.bEg.addView(this.gSL, layoutParams);
        }
    }

    public void dI(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LI(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
            jSONObject.put("icon_num", i + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "headicon_clk").setContentExt(jSONObject));
    }

    public void e(q qVar) {
        if ((qVar == null || TextUtils.isEmpty(qVar.liveId) || qVar.liveId.equals(this.mLiveId)) && this.nOZ != null) {
            this.nOZ.d(qVar);
            this.nOZ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
