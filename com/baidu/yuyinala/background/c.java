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
    private CommonEmptyView boq;
    private HListView gaZ;
    private View ojL;
    private View ojM;
    private View ojN;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c ojO;
    private com.baidu.yuyinala.background.a.a ojP;
    private a ojQ;
    private AlaAudioBackgroundDialogData ojR;
    private boolean ojS;
    private com.baidu.yuyinala.background.b.a ojT;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void eaI();

        void eaJ();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.ojQ = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.activity_ala_audio_background;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData) {
        a(alaAudioBackgroundDialogData, null, false);
    }

    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar, boolean z) {
        this.ojR = alaAudioBackgroundDialogData;
        if (z) {
            if (this.ojR == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                eaN();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ojP = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.gaZ = (HListView) getViewGroup().findViewById(a.g.background_lv);
        this.gaZ.setAdapter((ListAdapter) this.ojP);
        this.gaZ.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8));
        this.gaZ.setSelector(this.mTbPageContext.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.ojL = getViewGroup().findViewById(a.g.cancle_tv);
        this.ojM = getViewGroup().findViewById(a.g.confirm_tv);
        this.boq = (CommonEmptyView) getViewGroup().findViewById(a.g.bg_empty_view);
        this.ojN = getViewGroup().findViewById(a.g.bg_succ_view);
        this.ojL.setOnClickListener(this);
        this.ojM.setOnClickListener(this);
        this.gaZ.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.ojO = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ojL) {
            eaM();
            if (this.ojO != null) {
                this.ojO.dismiss();
            }
        } else if (view == this.ojM) {
            this.ojS = true;
            eaI();
            if (this.ojO != null) {
                this.ojO.dismiss();
            }
            eaL();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        MW(i);
        com.baidu.yuyinala.background.b.a item = this.ojP.getItem(i);
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
        if (this.ojQ != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ojQ.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void eaL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ojQ != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ojQ.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void MW(int i) {
        if (i >= 0) {
            this.gaZ.smoothScrollToPosition(i);
        }
    }

    private void b(final com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.ojT) {
            if (this.ojT != null) {
                BdResourceLoader.getInstance().cancelLoad(this.ojT.getOriginalUrl(), 10, null);
                this.ojT.setLoading(false);
            }
            this.ojT = aVar;
            this.ojT.setLoading(true);
            this.ojP.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.ojT.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.ojT != null && !StringUtils.isNull(c.this.ojT.getOriginalUrl()) && c.this.ojT.getOriginalUrl().equals(str)) {
                        if (c.this.ojQ != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.c(aVar);
                            } else {
                                c.this.ojQ.a(c.this.ojT, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        c.this.ojT.setLoading(false);
                        c.this.ojP.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.ojT) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.ojT = null;
            this.ojP.notifyDataSetChanged();
        }
    }

    private void eaI() {
        if (this.ojQ != null) {
            this.ojQ.eaI();
        }
    }

    private void eaM() {
        if (this.ojQ != null) {
            this.ojQ.eaJ();
        }
        this.ojP.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.ojN.setVisibility(0);
        this.boq.setVisibility(8);
        this.ojP.setBgList(list);
        MW(ListUtils.getPosition(list, aVar));
    }

    private void eaN() {
        this.boq.reset();
        this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ojQ != null) {
                    c.this.ojQ.loadData();
                }
                c.this.boq.setVisibility(8);
                c.this.ojN.setVisibility(0);
            }
        });
        this.boq.setTitle(a.i.sdk_net_no);
        this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.boq.setVisibility(0);
        this.ojN.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ojS) {
            this.ojS = false;
        } else {
            eaM();
        }
        if (this.ojT != null) {
            BdResourceLoader.getInstance().cancelLoad(this.ojT.getOriginalUrl(), 10, null);
            this.ojT = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
