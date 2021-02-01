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
    private HListView gxi;
    private View oVp;
    private View oVq;
    private View oVr;
    private com.baidu.yuyinala.background.a.a oVs;
    private a oVt;
    private AlaAudioBackgroundDialogData oVu;
    private boolean oVv;
    private com.baidu.yuyinala.background.b.a oVw;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void a(com.baidu.yuyinala.background.b.a aVar, String str);

        void eiG();

        void eiH();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oVt = aVar;
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
        this.oVu = alaAudioBackgroundDialogData;
        if (z) {
            if (this.oVu == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                eiN();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oVs = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.gxi = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.gxi.setAdapter((ListAdapter) this.oVs);
        this.gxi.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gxi.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oVp = getViewGroup().findViewById(a.f.cancle_tv);
        this.oVq = getViewGroup().findViewById(a.f.confirm_tv);
        this.bwJ = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oVr = getViewGroup().findViewById(a.f.bg_succ_view);
        this.oVp.setOnClickListener(this);
        this.oVq.setOnClickListener(this);
        this.gxi.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bEl = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oVp) {
            eiM();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
        } else if (view == this.oVq) {
            this.oVv = true;
            eiG();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
            eiL();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Nu(i);
        com.baidu.yuyinala.background.b.a item = this.oVs.getItem(i);
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
        if (this.oVt != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oVt.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void eiL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oVt != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oVt.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void Nu(int i) {
        if (i >= 0) {
            this.gxi.smoothScrollToPosition(i);
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
        if (!StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.oVw) {
            if (this.oVw != null) {
                BdResourceLoader.getInstance().cancelLoad(this.oVw.getOriginalUrl(), 10, null);
                this.oVw.setLoading(false);
            }
            this.oVw = aVar;
            this.oVw.setLoading(true);
            this.oVs.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.oVw.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.oVw != null && !StringUtils.isNull(c.this.oVw.getOriginalUrl()) && c.this.oVw.getOriginalUrl().equals(str)) {
                        if (c.this.oVt != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.e(aVar);
                            } else {
                                c.this.oVt.a(c.this.oVw, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        if (c.this.oVw != null) {
                            c.this.oVw.setLoading(false);
                        }
                        c.this.oVs.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    private void d(final com.baidu.yuyinala.background.b.a aVar) {
        if (!StringUtils.isNull(aVar.eiU()) && aVar != this.oVw) {
            if (this.oVw != null) {
                this.oVw.setLoading(false);
            }
            this.oVw = aVar;
            this.oVw.setLoading(true);
            this.oVs.notifyDataSetChanged();
            com.baidu.yuyinala.background.c.b.b(this.oVw.eiU(), this.oVw.getMd5(), new a.InterfaceC0956a() { // from class: com.baidu.yuyinala.background.c.2
                @Override // com.baidu.yuyinala.background.c.a.InterfaceC0956a
                public void Ao(boolean z) {
                    if (!z) {
                        c.this.e(aVar);
                        return;
                    }
                    c.this.oVt.a(aVar, com.baidu.yuyinala.background.c.b.in(com.baidu.live.storage.b.hH(c.this.oVw.getMd5())));
                    if (c.this.oVw != null) {
                        c.this.oVw.setLoading(false);
                    }
                    c.this.oVs.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.oVw) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.oVw = null;
            this.oVs.notifyDataSetChanged();
        }
    }

    private void eiG() {
        if (this.oVt != null) {
            this.oVt.eiG();
        }
    }

    private void eiM() {
        if (this.oVt != null) {
            this.oVt.eiH();
        }
        this.oVs.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oVr.setVisibility(0);
        this.bwJ.setVisibility(8);
        this.oVs.setBgList(list);
        Nu(ListUtils.getPosition(list, aVar));
    }

    private void eiN() {
        this.bwJ.reset();
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.oVt != null) {
                    c.this.oVt.loadData();
                }
                c.this.bwJ.setVisibility(8);
                c.this.oVr.setVisibility(0);
            }
        });
        this.bwJ.setTitle(a.h.sdk_net_no);
        this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bwJ.setVisibility(0);
        this.oVr.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oVv) {
            this.oVv = false;
        } else {
            eiM();
        }
        if (this.oVw != null) {
            BdResourceLoader.getInstance().cancelLoad(this.oVw.getOriginalUrl(), 10, null);
            this.oVw = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
