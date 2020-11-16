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
    private CommonEmptyView bnY;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bvu;
    private HListView ggw;
    private AlaAudioBackgroundDialogData ouA;
    private boolean ouB;
    private com.baidu.yuyinala.background.b.a ouC;
    private View ouv;
    private View ouw;
    private View oux;
    private com.baidu.yuyinala.background.a.a ouy;
    private a ouz;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void eeo();

        void eep();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.ouz = aVar;
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
        this.ouA = alaAudioBackgroundDialogData;
        if (z) {
            if (this.ouA == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                eet();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ouy = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.ggw = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.ggw.setAdapter((ListAdapter) this.ouy);
        this.ggw.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.ggw.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ouv = getViewGroup().findViewById(a.f.cancle_tv);
        this.ouw = getViewGroup().findViewById(a.f.confirm_tv);
        this.bnY = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oux = getViewGroup().findViewById(a.f.bg_succ_view);
        this.ouv.setOnClickListener(this);
        this.ouw.setOnClickListener(this);
        this.ggw.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bvu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ouv) {
            ees();
            if (this.bvu != null) {
                this.bvu.dismiss();
            }
        } else if (view == this.ouw) {
            this.ouB = true;
            eeo();
            if (this.bvu != null) {
                this.bvu.dismiss();
            }
            eer();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        NS(i);
        com.baidu.yuyinala.background.b.a item = this.ouy.getItem(i);
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
        if (this.ouz != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ouz.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void eer() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ouz != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ouz.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void NS(int i) {
        if (i >= 0) {
            this.ggw.smoothScrollToPosition(i);
        }
    }

    private void b(final com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.ouC) {
            if (this.ouC != null) {
                BdResourceLoader.getInstance().cancelLoad(this.ouC.getOriginalUrl(), 10, null);
                this.ouC.setLoading(false);
            }
            this.ouC = aVar;
            this.ouC.setLoading(true);
            this.ouy.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.ouC.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.ouC != null && !StringUtils.isNull(c.this.ouC.getOriginalUrl()) && c.this.ouC.getOriginalUrl().equals(str)) {
                        if (c.this.ouz != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.c(aVar);
                            } else {
                                c.this.ouz.a(c.this.ouC, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        c.this.ouC.setLoading(false);
                        c.this.ouy.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.ouC) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.ouC = null;
            this.ouy.notifyDataSetChanged();
        }
    }

    private void eeo() {
        if (this.ouz != null) {
            this.ouz.eeo();
        }
    }

    private void ees() {
        if (this.ouz != null) {
            this.ouz.eep();
        }
        this.ouy.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oux.setVisibility(0);
        this.bnY.setVisibility(8);
        this.ouy.setBgList(list);
        NS(ListUtils.getPosition(list, aVar));
    }

    private void eet() {
        this.bnY.reset();
        this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ouz != null) {
                    c.this.ouz.loadData();
                }
                c.this.bnY.setVisibility(8);
                c.this.oux.setVisibility(0);
            }
        });
        this.bnY.setTitle(a.h.sdk_net_no);
        this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bnY.setVisibility(0);
        this.oux.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ouB) {
            this.ouB = false;
        } else {
            ees();
        }
        if (this.ouC != null) {
            BdResourceLoader.getInstance().cancelLoad(this.ouC.getOriginalUrl(), 10, null);
            this.ouC = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
