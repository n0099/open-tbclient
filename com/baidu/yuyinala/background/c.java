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
    private CommonEmptyView bpJ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bxf;
    private HListView ggP;
    private View osR;
    private View osS;
    private View osT;
    private com.baidu.yuyinala.background.a.a osU;
    private a osV;
    private AlaAudioBackgroundDialogData osW;
    private boolean osX;
    private com.baidu.yuyinala.background.b.a osY;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void eeq();

        void eer();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.osV = aVar;
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
        this.osW = alaAudioBackgroundDialogData;
        if (z) {
            if (this.osW == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                eev();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.osU = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.ggP = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.ggP.setAdapter((ListAdapter) this.osU);
        this.ggP.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.ggP.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.osR = getViewGroup().findViewById(a.f.cancle_tv);
        this.osS = getViewGroup().findViewById(a.f.confirm_tv);
        this.bpJ = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.osT = getViewGroup().findViewById(a.f.bg_succ_view);
        this.osR.setOnClickListener(this);
        this.osS.setOnClickListener(this);
        this.ggP.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bxf = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.osR) {
            eeu();
            if (this.bxf != null) {
                this.bxf.dismiss();
            }
        } else if (view == this.osS) {
            this.osX = true;
            eeq();
            if (this.bxf != null) {
                this.bxf.dismiss();
            }
            eet();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Np(i);
        com.baidu.yuyinala.background.b.a item = this.osU.getItem(i);
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
        if (this.osV != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.osV.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void eet() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.osV != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.osV.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void Np(int i) {
        if (i >= 0) {
            this.ggP.smoothScrollToPosition(i);
        }
    }

    private void b(final com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.osY) {
            if (this.osY != null) {
                BdResourceLoader.getInstance().cancelLoad(this.osY.getOriginalUrl(), 10, null);
                this.osY.setLoading(false);
            }
            this.osY = aVar;
            this.osY.setLoading(true);
            this.osU.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.osY.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.osY != null && !StringUtils.isNull(c.this.osY.getOriginalUrl()) && c.this.osY.getOriginalUrl().equals(str)) {
                        if (c.this.osV != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.c(aVar);
                            } else {
                                c.this.osV.a(c.this.osY, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        c.this.osY.setLoading(false);
                        c.this.osU.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.osY) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.osY = null;
            this.osU.notifyDataSetChanged();
        }
    }

    private void eeq() {
        if (this.osV != null) {
            this.osV.eeq();
        }
    }

    private void eeu() {
        if (this.osV != null) {
            this.osV.eer();
        }
        this.osU.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.osT.setVisibility(0);
        this.bpJ.setVisibility(8);
        this.osU.setBgList(list);
        Np(ListUtils.getPosition(list, aVar));
    }

    private void eev() {
        this.bpJ.reset();
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.osV != null) {
                    c.this.osV.loadData();
                }
                c.this.bpJ.setVisibility(8);
                c.this.osT.setVisibility(0);
            }
        });
        this.bpJ.setTitle(a.h.sdk_net_no);
        this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bpJ.setVisibility(0);
        this.osT.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.osX) {
            this.osX = false;
        } else {
            eeu();
        }
        if (this.osY != null) {
            BdResourceLoader.getInstance().cancelLoad(this.osY.getOriginalUrl(), 10, null);
            this.osY = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
