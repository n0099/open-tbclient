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
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bFr;
    private CommonEmptyView bxT;
    private HListView gzf;
    private View oPK;
    private View oPL;
    private View oPM;
    private com.baidu.yuyinala.background.a.a oPN;
    private a oPO;
    private AlaAudioBackgroundDialogData oPP;
    private boolean oPQ;
    private com.baidu.yuyinala.background.b.a oPR;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void a(com.baidu.yuyinala.background.b.a aVar, String str);

        void eki();

        void ekj();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oPO = aVar;
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
        this.oPP = alaAudioBackgroundDialogData;
        if (z) {
            if (this.oPP == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                ekp();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oPN = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.gzf = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.gzf.setAdapter((ListAdapter) this.oPN);
        this.gzf.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gzf.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oPK = getViewGroup().findViewById(a.f.cancle_tv);
        this.oPL = getViewGroup().findViewById(a.f.confirm_tv);
        this.bxT = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oPM = getViewGroup().findViewById(a.f.bg_succ_view);
        this.oPK.setOnClickListener(this);
        this.oPL.setOnClickListener(this);
        this.gzf.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bFr = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oPK) {
            eko();
            if (this.bFr != null) {
                this.bFr.dismiss();
            }
        } else if (view == this.oPL) {
            this.oPQ = true;
            eki();
            if (this.bFr != null) {
                this.bFr.dismiss();
            }
            ekn();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        OF(i);
        com.baidu.yuyinala.background.b.a item = this.oPN.getItem(i);
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
        if (this.oPO != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oPO.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void ekn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oPO != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oPO.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void OF(int i) {
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
        if (!StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.oPR) {
            if (this.oPR != null) {
                BdResourceLoader.getInstance().cancelLoad(this.oPR.getOriginalUrl(), 10, null);
                this.oPR.setLoading(false);
            }
            this.oPR = aVar;
            this.oPR.setLoading(true);
            this.oPN.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.oPR.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.oPR != null && !StringUtils.isNull(c.this.oPR.getOriginalUrl()) && c.this.oPR.getOriginalUrl().equals(str)) {
                        if (c.this.oPO != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.e(aVar);
                            } else {
                                c.this.oPO.a(c.this.oPR, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        if (c.this.oPR != null) {
                            c.this.oPR.setLoading(false);
                        }
                        c.this.oPN.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    private void d(final com.baidu.yuyinala.background.b.a aVar) {
        if (!StringUtils.isNull(aVar.ekw()) && aVar != this.oPR) {
            if (this.oPR != null) {
                this.oPR.setLoading(false);
            }
            this.oPR = aVar;
            this.oPR.setLoading(true);
            this.oPN.notifyDataSetChanged();
            com.baidu.yuyinala.background.c.b.b(this.oPR.ekw(), this.oPR.getMd5(), new a.InterfaceC0969a() { // from class: com.baidu.yuyinala.background.c.2
                @Override // com.baidu.yuyinala.background.c.a.InterfaceC0969a
                public void zZ(boolean z) {
                    if (!z) {
                        c.this.e(aVar);
                        return;
                    }
                    c.this.oPO.a(aVar, com.baidu.yuyinala.background.c.b.WH(com.baidu.live.ah.b.iw(c.this.oPR.getMd5())));
                    if (c.this.oPR != null) {
                        c.this.oPR.setLoading(false);
                    }
                    c.this.oPN.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.oPR) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.oPR = null;
            this.oPN.notifyDataSetChanged();
        }
    }

    private void eki() {
        if (this.oPO != null) {
            this.oPO.eki();
        }
    }

    private void eko() {
        if (this.oPO != null) {
            this.oPO.ekj();
        }
        this.oPN.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oPM.setVisibility(0);
        this.bxT.setVisibility(8);
        this.oPN.setBgList(list);
        OF(ListUtils.getPosition(list, aVar));
    }

    private void ekp() {
        this.bxT.reset();
        this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.oPO != null) {
                    c.this.oPO.loadData();
                }
                c.this.bxT.setVisibility(8);
                c.this.oPM.setVisibility(0);
            }
        });
        this.bxT.setTitle(a.h.sdk_net_no);
        this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bxT.setVisibility(0);
        this.oPM.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oPQ) {
            this.oPQ = false;
        } else {
            eko();
        }
        if (this.oPR != null) {
            BdResourceLoader.getInstance().cancelLoad(this.oPR.getOriginalUrl(), 10, null);
            this.oPR = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
