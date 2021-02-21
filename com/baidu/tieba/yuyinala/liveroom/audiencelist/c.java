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
import com.baidu.live.data.ab;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
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
    private ab aDd;
    private ViewGroup bRb;
    private com.baidu.live.liveroom.a.a htV;
    public FrameLayout htX;
    public FrameLayout htY;
    private AlphaGradientHListView htZ;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private a oug;
    private AdapterView.c huc = new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            u uVar = (u) c.this.oug.getItem(i);
            if (uVar != null) {
                if (c.this.htV != null) {
                    c.this.htV.dF(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(uVar.aId.userUk), uVar.aId.userName, uVar.aId.portrait, 0, 0, "", "", 0L, 0L, 0L, 0, "", c.this.mLiveId, false, "", "", uVar.aId.userName, "")));
                c.this.LU(i);
            }
        }
    };
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.c.2
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
        this.htV = aVar;
        MessageManager.getInstance().registerListener(this.gNG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, ab abVar) {
        this.mLiveId = str;
        this.aDd = abVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.htX == null) {
                this.htX = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bRb != null && this.bRb.indexOfChild(this.htX) > 0) {
                this.bRb.removeView(this.htX);
            }
            this.bRb = viewGroup;
            this.htX.setId(a.f.ala_liveroom_audience);
            this.htY = (FrameLayout) this.htX.findViewById(a.f.content_layout);
            this.htZ = (AlphaGradientHListView) this.htX.findViewById(a.f.ala_live_guest_listview);
            this.htZ.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.oug = new a(getPageContext().getPageActivity());
            this.htZ.setAdapter((ListAdapter) this.oug);
            this.htZ.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.htZ.setOnItemClickListener(this.huc);
            this.htZ.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.htZ.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds24);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.bRb.addView(this.htX, layoutParams);
        }
    }

    public void cr(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LU(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("icon_num", i + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "headicon_clk").setContentExt(jSONObject));
    }

    public void e(v vVar) {
        if ((vVar == null || TextUtils.isEmpty(vVar.liveId) || vVar.liveId.equals(this.mLiveId)) && this.oug != null) {
            this.oug.d(vVar);
            this.oug.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
