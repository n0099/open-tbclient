package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioBackgroundDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bAE;
    private CommonEmptyView btg;
    private HListView goI;
    private View oJD;
    private View oJE;
    private View oJF;
    private com.baidu.yuyinala.background.a.a oJG;
    private a oJH;
    private AlaAudioBackgroundDialogData oJI;
    private boolean oJJ;
    private com.baidu.yuyinala.background.b.a oJK;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void ekc();

        void ekd();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oJH = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.activity_ala_audio_background;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData) {
        a(alaAudioBackgroundDialogData, null, false);
    }

    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar, boolean z) {
        this.oJI = alaAudioBackgroundDialogData;
        if (z) {
            if (this.oJI == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                ekh();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oJG = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.goI = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.goI.setAdapter((ListAdapter) this.oJG);
        this.goI.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.goI.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oJD = getViewGroup().findViewById(a.f.cancle_tv);
        this.oJE = getViewGroup().findViewById(a.f.confirm_tv);
        this.btg = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oJF = getViewGroup().findViewById(a.f.bg_succ_view);
        this.oJD.setOnClickListener(this);
        this.oJE.setOnClickListener(this);
        this.goI.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bAE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oJD) {
            ekg();
            if (this.bAE != null) {
                this.bAE.dismiss();
            }
        } else if (view == this.oJE) {
            this.oJJ = true;
            ekc();
            if (this.bAE != null) {
                this.bAE.dismiss();
            }
            ekf();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        OQ(i);
        com.baidu.yuyinala.background.b.a item = this.oJG.getItem(i);
        b(item);
        a(item);
    }

    private void a(com.baidu.yuyinala.background.b.a aVar) {
        String id;
        JSONObject jSONObject = new JSONObject();
        if (aVar == null) {
            id = "";
        } else {
            try {
                id = aVar.getId();
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put("background_id", id);
        jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.oJH != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oJH.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void ekf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oJH != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oJH.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void OQ(int i) {
        if (i >= 0) {
            this.goI.smoothScrollToPosition(i);
        }
    }

    private void b(final com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.oJK) {
            if (this.oJK != null) {
                BdResourceLoader.getInstance().cancelLoad(this.oJK.getOriginalUrl(), 10, null);
                this.oJK.setLoading(false);
            }
            this.oJK = aVar;
            this.oJK.setLoading(true);
            this.oJG.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.oJK.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.oJK != null && !StringUtils.isNull(c.this.oJK.getOriginalUrl()) && c.this.oJK.getOriginalUrl().equals(str)) {
                        if (c.this.oJH != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.c(aVar);
                            } else {
                                c.this.oJH.a(c.this.oJK, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        c.this.oJK.setLoading(false);
                        c.this.oJG.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.oJK) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.oJK = null;
            this.oJG.notifyDataSetChanged();
        }
    }

    private void ekc() {
        if (this.oJH != null) {
            this.oJH.ekc();
        }
    }

    private void ekg() {
        if (this.oJH != null) {
            this.oJH.ekd();
        }
        this.oJG.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oJF.setVisibility(0);
        this.btg.setVisibility(8);
        this.oJG.setBgList(list);
        OQ(ListUtils.getPosition(list, aVar));
    }

    private void ekh() {
        this.btg.reset();
        this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.oJH != null) {
                    c.this.oJH.loadData();
                }
                c.this.btg.setVisibility(8);
                c.this.oJF.setVisibility(0);
            }
        });
        this.btg.setTitle(a.h.sdk_net_no);
        this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.btg.setVisibility(0);
        this.oJF.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oJJ) {
            this.oJJ = false;
        } else {
            ekg();
        }
        if (this.oJK != null) {
            BdResourceLoader.getInstance().cancelLoad(this.oJK.getOriginalUrl(), 10, null);
            this.oJK = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
