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
    private w aFN;
    private ViewGroup bNk;
    private com.baidu.live.liveroom.a.a hig;
    public FrameLayout hii;
    public FrameLayout hij;
    private AlphaGradientHListView hik;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private a olA;
    private String otherParams;
    private AdapterView.c hin = new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            p pVar = (p) c.this.olA.getItem(i);
            if (pVar != null) {
                if (c.this.hig != null) {
                    c.this.hig.fh(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(pVar.aJV.userUk), pVar.aJV.userName, pVar.aJV.portrait, 0, 0, "", "", 0L, 0L, 0L, 0, "", c.this.mLiveId, false, "", "", pVar.aJV.userName, "")));
                c.this.Nt(i);
            }
        }
    };
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.2
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
        this.hig = aVar;
        MessageManager.getInstance().registerListener(this.gDG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, w wVar) {
        this.mLiveId = str;
        this.aFN = wVar;
    }

    public void Wo(String str) {
        this.mLiveId = str;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.hii == null) {
                this.hii = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bNk != null && this.bNk.indexOfChild(this.hii) > 0) {
                this.bNk.removeView(this.hii);
            }
            this.bNk = viewGroup;
            this.hii.setId(a.f.ala_liveroom_audience);
            this.hij = (FrameLayout) this.hii.findViewById(a.f.content_layout);
            this.hik = (AlphaGradientHListView) this.hii.findViewById(a.f.ala_live_guest_listview);
            this.hik.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.olA = new a(getPageContext().getPageActivity());
            this.hik.setAdapter((ListAdapter) this.olA);
            this.hik.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hik.setOnItemClickListener(this.hin);
            this.hik.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.hik.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.bNk.addView(this.hii, layoutParams);
        }
    }

    public void dX(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nt(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
            jSONObject.put("icon_num", i + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "headicon_clk").setContentExt(jSONObject));
    }

    public void e(q qVar) {
        if ((qVar == null || TextUtils.isEmpty(qVar.liveId) || qVar.liveId.equals(this.mLiveId)) && this.olA != null) {
            this.olA.d(qVar);
            this.olA.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
