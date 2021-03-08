package com.baidu.tieba.yuyinala.endliveroom;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.m;
import com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView;
import com.baidu.tieba.yuyinala.liveroom.roomcard.AlaGetCollectRoomHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private ab aED;
    private AlaLiveInfoData mLiveInfo;
    private TbPageContext mTbPageContext;
    private View mView;
    private h otG;
    private boolean isFollowed = false;
    private String mPortrait = "";
    private String otherParams = "";
    private AlaLiveAudienceEndView.a otH = new AlaLiveAudienceEndView.a() { // from class: com.baidu.tieba.yuyinala.endliveroom.a.1
        @Override // com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.a
        public void MP() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        }

        @Override // com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.a
        public void f(AlaLiveInfoData alaLiveInfoData) {
            Log.i("EndDebug", "@@ onPlayRecommendViewClick mTbPageContext = " + a.this.mTbPageContext);
            if (a.this.mTbPageContext == null) {
                TiebaInitialize.log(new StatisticItem("c11890"));
                return;
            }
            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(a.this.mTbPageContext.getPageActivity());
            yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(alaLiveInfoData.live_id, String.valueOf(alaLiveInfoData.room_id), "end_live_recommend");
            if (TextUtils.isEmpty(a.this.otherParams)) {
                a.this.otherParams = "";
            }
            try {
                String flvUrl = alaLiveInfoData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                String str = alaLiveInfoData.cover;
                String valueOf = String.valueOf(alaLiveInfoData.room_id);
                String valueOf2 = String.valueOf(alaLiveInfoData.live_id);
                JSONObject jSONObject = new JSONObject(a.this.otherParams);
                jSONObject.put("live_url", flvUrl);
                jSONObject.put("cover", str);
                jSONObject.put("enterRoomId", valueOf);
                jSONObject.put("enterLiveId", valueOf2);
                jSONObject.put("screen_direction", alaLiveInfoData.screen_direction);
                a.this.otherParams = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            yuyinAlaLiveRoomActivityConfig.addExtraByParams(a.this.otherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
            StatisticItem param = new StatisticItem("c11890").param("live_id", alaLiveInfoData.live_id).param("description", alaLiveInfoData.description);
            if (a.this.mLiveInfo != null) {
                param.param("uid", a.this.mLiveInfo.user_id);
            }
            TiebaInitialize.log(param);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("model", "youlike");
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, UbcStatConstant.Page.VOICE_ROOM_END, null).setContentExt(jSONObject2));
        }

        @Override // com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.a
        public void nb(final boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
                return;
            }
            if (a.this.mView instanceof AlaLiveAudienceEndView) {
                ((AlaLiveAudienceEndView) a.this.mView).nc(!z);
            }
            a.this.isFollowed = !z;
            if (BdUtilHelper.isNetOk()) {
                if (a.this.aED != null && a.this.aED.aKu != null && a.this.aED.aKu.aVk != null) {
                    a.this.otG.a(new h.a() { // from class: com.baidu.tieba.yuyinala.endliveroom.a.1.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (z) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.yuyinala_uncollection_success_toast));
                                return;
                            }
                            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, a.this.aED.aKu.croom_id);
                            } catch (Exception e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM_END, "collect_succ").setContentExt(jSONObject));
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                        }
                    });
                    if (a.this.aED != null && a.this.aED.aKu != null) {
                        a.this.otG.y(a.this.aED.aKu.aVk, a.this.aED.aKu.live_id, z ? 0 : 1);
                    }
                    if (!z && TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", a.this.mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", a.this.mLiveInfo.room_id + "");
                            alaStaticItem.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem.addParams("other_params", a.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("loc", "live_end");
                        alaStaticItem2.addParams("other_params", a.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        return;
                    }
                    return;
                }
                return;
            }
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.otG = new h(this.mTbPageContext.getPageActivity());
    }

    public View getView() {
        return this.mView;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, View view, ab abVar, boolean z, ArrayList<AlaLiveInfoData> arrayList) {
        if (abVar != null) {
            boolean z2 = abVar.aKu != null ? abVar.aKu.is_followed : false;
            String str = "";
            if (abVar.aKu != null) {
                str = abVar.aKu.cover;
            }
            this.mLiveInfo = abVar.mLiveInfo;
            this.aED = abVar;
            this.mPortrait = str;
            this.isFollowed = z2;
            if (this.mLiveInfo == null) {
                this.mLiveInfo = new AlaLiveInfoData();
            }
            bUQ();
            TiebaInitialize.log(new StatisticItem("c11888"));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("model", "youlike");
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1392, "show", UbcStatConstant.Page.VOICE_ROOM_END, null).setContentExt(jSONObject));
            this.mView = view;
            if (this.mView == null) {
                this.mView = new AlaLiveAudienceEndView(alaLiveRoomBlurPageLayout.getContext());
            }
            this.mView.setId(a.f.ala_liveroom_audience_end_view);
            if (this.mView instanceof AlaLiveAudienceEndView) {
                ((AlaLiveAudienceEndView) this.mView).setCallback(this.otH);
                ((AlaLiveAudienceEndView) this.mView).setData(this.mTbPageContext, abVar, z, this.isFollowed, this.mPortrait, Lr());
                ((AlaLiveAudienceEndView) this.mView).X(arrayList);
            }
            if (this.mView != null) {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
                alaLiveRoomBlurPageLayout.e(this.mView, new FrameLayout.LayoutParams(screenFullSize[0], screenFullSize[1]));
            }
        }
    }

    public void X(ArrayList<AlaLiveInfoData> arrayList) {
        if (this.mView instanceof AlaLiveAudienceEndView) {
            ((AlaLiveAudienceEndView) this.mView).X(arrayList);
        }
    }

    public void bUQ() {
        if (this.mView != null && this.mView.getParent() != null) {
            ((ViewGroup) this.mView).removeView(this.mView);
        }
    }

    public boolean bUR() {
        return (getView() == null || getView().getParent() == null) ? false : true;
    }

    public void C(int i, int i2) {
        if ((this.mView instanceof AlaLiveAudienceEndView) && this.mView.getParent() != null) {
            this.mView.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            int virtualBarHeight = m.getVirtualBarHeight(this.mTbPageContext.getPageActivity());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((AlaLiveAudienceEndView) this.mView).getRecParentView().getLayoutParams();
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds90) - virtualBarHeight;
            ((AlaLiveAudienceEndView) this.mView).getRecParentView().setLayoutParams(layoutParams);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021010);
        MessageManager.getInstance().unRegisterTask(1021026);
        MessageManager.getInstance().removeMessage(this.mId);
        if (this.mView instanceof AlaLiveAudienceEndView) {
            ((AlaLiveAudienceEndView) this.mView).onDestory();
        }
        if (this.otG != null) {
            this.otG.onDestroy();
        }
        this.mView = null;
        this.mTbPageContext = null;
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
