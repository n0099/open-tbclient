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
import com.baidu.yuyinala.background.c.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioBackgroundDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bEl;
    private CommonEmptyView bwJ;
    private HListView gxw;
    private View oVP;
    private View oVQ;
    private View oVR;
    private com.baidu.yuyinala.background.a.a oVS;
    private a oVT;
    private AlaAudioBackgroundDialogData oVU;
    private boolean oVV;
    private com.baidu.yuyinala.background.b.a oVW;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void a(com.baidu.yuyinala.background.b.a aVar, String str);

        void eiO();

        void eiP();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oVT = aVar;
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
        this.oVU = alaAudioBackgroundDialogData;
        if (z) {
            if (this.oVU == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                eiV();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oVS = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.gxw = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.gxw.setAdapter((ListAdapter) this.oVS);
        this.gxw.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gxw.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oVP = getViewGroup().findViewById(a.f.cancle_tv);
        this.oVQ = getViewGroup().findViewById(a.f.confirm_tv);
        this.bwJ = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oVR = getViewGroup().findViewById(a.f.bg_succ_view);
        this.oVP.setOnClickListener(this);
        this.oVQ.setOnClickListener(this);
        this.gxw.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bEl = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oVP) {
            eiU();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
        } else if (view == this.oVQ) {
            this.oVV = true;
            eiO();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
            eiT();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Nv(i);
        com.baidu.yuyinala.background.b.a item = this.oVS.getItem(i);
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
        if (this.oVT != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oVT.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void eiT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oVT != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oVT.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void Nv(int i) {
        if (i >= 0) {
            this.gxw.smoothScrollToPosition(i);
        }
    }

    private void b(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null) {
            if (aVar.getType() == 0) {
                c(aVar);
            } else {
                d(aVar);
            }
        }
    }

    private void c(final com.baidu.yuyinala.background.b.a aVar) {
        if (!StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.oVW) {
            if (this.oVW != null) {
                BdResourceLoader.getInstance().cancelLoad(this.oVW.getOriginalUrl(), 10, null);
                this.oVW.setLoading(false);
            }
            this.oVW = aVar;
            this.oVW.setLoading(true);
            this.oVS.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.oVW.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.oVW != null && !StringUtils.isNull(c.this.oVW.getOriginalUrl()) && c.this.oVW.getOriginalUrl().equals(str)) {
                        if (c.this.oVT != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.e(aVar);
                            } else {
                                c.this.oVT.a(c.this.oVW, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        if (c.this.oVW != null) {
                            c.this.oVW.setLoading(false);
                        }
                        c.this.oVS.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    private void d(final com.baidu.yuyinala.background.b.a aVar) {
        if (!StringUtils.isNull(aVar.ejc()) && aVar != this.oVW) {
            if (this.oVW != null) {
                this.oVW.setLoading(false);
            }
            this.oVW = aVar;
            this.oVW.setLoading(true);
            this.oVS.notifyDataSetChanged();
            com.baidu.yuyinala.background.c.b.b(this.oVW.ejc(), this.oVW.getMd5(), new a.InterfaceC0958a() { // from class: com.baidu.yuyinala.background.c.2
                @Override // com.baidu.yuyinala.background.c.a.InterfaceC0958a
                public void Ao(boolean z) {
                    if (!z) {
                        c.this.e(aVar);
                        return;
                    }
                    c.this.oVT.a(aVar, com.baidu.yuyinala.background.c.b.in(com.baidu.live.storage.b.hH(c.this.oVW.getMd5())));
                    if (c.this.oVW != null) {
                        c.this.oVW.setLoading(false);
                    }
                    c.this.oVS.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.oVW) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.oVW = null;
            this.oVS.notifyDataSetChanged();
        }
    }

    private void eiO() {
        if (this.oVT != null) {
            this.oVT.eiO();
        }
    }

    private void eiU() {
        if (this.oVT != null) {
            this.oVT.eiP();
        }
        this.oVS.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oVR.setVisibility(0);
        this.bwJ.setVisibility(8);
        this.oVS.setBgList(list);
        Nv(ListUtils.getPosition(list, aVar));
    }

    private void eiV() {
        this.bwJ.reset();
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.oVT != null) {
                    c.this.oVT.loadData();
                }
                c.this.bwJ.setVisibility(8);
                c.this.oVR.setVisibility(0);
            }
        });
        this.bwJ.setTitle(a.h.sdk_net_no);
        this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bwJ.setVisibility(0);
        this.oVR.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oVV) {
            this.oVV = false;
        } else {
            eiU();
        }
        if (this.oVW != null) {
            BdResourceLoader.getInstance().cancelLoad(this.oVW.getOriginalUrl(), 10, null);
            this.oVW = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
