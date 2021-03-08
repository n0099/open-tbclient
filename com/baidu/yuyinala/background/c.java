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
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioBackgroundDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bFL;
    private CommonEmptyView byj;
    private HListView gzf;
    private View oXU;
    private View oXV;
    private View oXW;
    private com.baidu.yuyinala.background.a.a oXX;
    private a oXY;
    private AlaAudioBackgroundDialogData oXZ;
    private boolean oYa;
    private com.baidu.yuyinala.background.b.a oYb;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void a(com.baidu.yuyinala.background.b.a aVar, String str);

        void eiY();

        void eiZ();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oXY = aVar;
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
        this.oXZ = alaAudioBackgroundDialogData;
        if (z) {
            if (this.oXZ == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                ejf();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oXX = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.gzf = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.gzf.setAdapter((ListAdapter) this.oXX);
        this.gzf.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gzf.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oXU = getViewGroup().findViewById(a.f.cancle_tv);
        this.oXV = getViewGroup().findViewById(a.f.confirm_tv);
        this.byj = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oXW = getViewGroup().findViewById(a.f.bg_succ_view);
        this.oXU.setOnClickListener(this);
        this.oXV.setOnClickListener(this);
        this.gzf.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bFL = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oXU) {
            eje();
            if (this.bFL != null) {
                this.bFL.dismiss();
            }
        } else if (view == this.oXV) {
            this.oYa = true;
            eiY();
            if (this.bFL != null) {
                this.bFL.dismiss();
            }
            ejd();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Nz(i);
        com.baidu.yuyinala.background.b.a item = this.oXX.getItem(i);
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
        if (this.oXY != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oXY.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void ejd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oXY != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oXY.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void Nz(int i) {
        if (i >= 0) {
            this.gzf.smoothScrollToPosition(i);
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
        if (!StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.oYb) {
            if (this.oYb != null) {
                BdResourceLoader.getInstance().cancelLoad(this.oYb.getOriginalUrl(), 10, null);
                this.oYb.setLoading(false);
            }
            this.oYb = aVar;
            this.oYb.setLoading(true);
            this.oXX.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.oYb.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.oYb != null && !StringUtils.isNull(c.this.oYb.getOriginalUrl()) && c.this.oYb.getOriginalUrl().equals(str)) {
                        if (c.this.oXY != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.e(aVar);
                            } else {
                                c.this.oXY.a(c.this.oYb, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        if (c.this.oYb != null) {
                            c.this.oYb.setLoading(false);
                        }
                        c.this.oXX.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    private void d(final com.baidu.yuyinala.background.b.a aVar) {
        if (!StringUtils.isNull(aVar.ejm()) && aVar != this.oYb) {
            if (this.oYb != null) {
                this.oYb.setLoading(false);
            }
            this.oYb = aVar;
            this.oYb.setLoading(true);
            this.oXX.notifyDataSetChanged();
            com.baidu.yuyinala.background.c.b.b(this.oYb.ejm(), this.oYb.getMd5(), new a.InterfaceC0964a() { // from class: com.baidu.yuyinala.background.c.2
                @Override // com.baidu.yuyinala.background.c.a.InterfaceC0964a
                public void An(boolean z) {
                    if (!z) {
                        c.this.e(aVar);
                        return;
                    }
                    c.this.oXY.a(aVar, com.baidu.yuyinala.background.c.b.it(com.baidu.live.storage.b.hN(c.this.oYb.getMd5())));
                    if (c.this.oYb != null) {
                        c.this.oYb.setLoading(false);
                    }
                    c.this.oXX.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.oYb) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.oYb = null;
            this.oXX.notifyDataSetChanged();
        }
    }

    private void eiY() {
        if (this.oXY != null) {
            this.oXY.eiY();
        }
    }

    private void eje() {
        if (this.oXY != null) {
            this.oXY.eiZ();
        }
        this.oXX.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oXW.setVisibility(0);
        this.byj.setVisibility(8);
        this.oXX.setBgList(list);
        Nz(ListUtils.getPosition(list, aVar));
    }

    private void ejf() {
        this.byj.reset();
        this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.oXY != null) {
                    c.this.oXY.loadData();
                }
                c.this.byj.setVisibility(8);
                c.this.oXW.setVisibility(0);
            }
        });
        this.byj.setTitle(a.h.sdk_net_no);
        this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.byj.setVisibility(0);
        this.oXW.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oYa) {
            this.oYa = false;
        } else {
            eje();
        }
        if (this.oYb != null) {
            BdResourceLoader.getInstance().cancelLoad(this.oYb.getOriginalUrl(), 10, null);
            this.oYb = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
