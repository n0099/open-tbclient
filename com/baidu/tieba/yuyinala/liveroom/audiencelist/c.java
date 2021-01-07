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
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class c {
    private x aGe;
    private ViewGroup bRX;
    private com.baidu.live.liveroom.a.a huc;
    public FrameLayout hue;
    public FrameLayout huf;
    private AlphaGradientHListView hug;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private a oot;
    private String otherParams;
    private AdapterView.c huj = new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            q qVar = (q) c.this.oot.getItem(i);
            if (qVar != null) {
                if (c.this.huc != null) {
                    c.this.huc.ff(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(qVar.aKu.userUk), qVar.aKu.userName, qVar.aKu.portrait, 0, 0, "", "", 0L, 0L, 0L, 0, "", c.this.mLiveId, false, "", "", qVar.aKu.userName, "")));
                c.this.Nf(i);
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.2
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

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        this.mTbPageContext = tbPageContext;
        this.huc = aVar;
        MessageManager.getInstance().registerListener(this.gPs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, x xVar) {
        this.mLiveId = str;
        this.aGe = xVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.hue == null) {
                this.hue = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bRX != null && this.bRX.indexOfChild(this.hue) > 0) {
                this.bRX.removeView(this.hue);
            }
            this.bRX = viewGroup;
            this.hue.setId(a.f.ala_liveroom_audience);
            this.huf = (FrameLayout) this.hue.findViewById(a.f.content_layout);
            this.hug = (AlphaGradientHListView) this.hue.findViewById(a.f.ala_live_guest_listview);
            this.hug.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.oot = new a(getPageContext().getPageActivity());
            this.hug.setAdapter((ListAdapter) this.oot);
            this.hug.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hug.setOnItemClickListener(this.huj);
            this.hug.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.hug.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds24);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.bRX.addView(this.hue, layoutParams);
        }
    }

    public void dU(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nf(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("icon_num", i + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "headicon_clk").setContentExt(jSONObject));
    }

    public void e(r rVar) {
        if ((rVar == null || TextUtils.isEmpty(rVar.liveId) || rVar.liveId.equals(this.mLiveId)) && this.oot != null) {
            this.oot.d(rVar);
            this.oot.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
