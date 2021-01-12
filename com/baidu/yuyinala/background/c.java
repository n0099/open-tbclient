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
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bAF;
    private CommonEmptyView btf;
    private HListView guy;
    private View oLi;
    private View oLj;
    private View oLk;
    private com.baidu.yuyinala.background.a.a oLl;
    private a oLm;
    private AlaAudioBackgroundDialogData oLn;
    private boolean oLo;
    private com.baidu.yuyinala.background.b.a oLp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap);

        void a(com.baidu.yuyinala.background.b.a aVar, String str);

        void ego();

        void egp();

        String getCustomRoomId();

        void loadData();
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oLm = aVar;
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
        this.oLn = alaAudioBackgroundDialogData;
        if (z) {
            if (this.oLn == null || ListUtils.isEmpty(alaAudioBackgroundDialogData.getBgList())) {
                egv();
            } else {
                a(alaAudioBackgroundDialogData.getBgList(), aVar);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oLl = new com.baidu.yuyinala.background.a.a(this.mTbPageContext.getPageActivity());
        this.guy = (HListView) getViewGroup().findViewById(a.f.background_lv);
        this.guy.setAdapter((ListAdapter) this.oLl);
        this.guy.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.guy.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oLi = getViewGroup().findViewById(a.f.cancle_tv);
        this.oLj = getViewGroup().findViewById(a.f.confirm_tv);
        this.btf = (CommonEmptyView) getViewGroup().findViewById(a.f.bg_empty_view);
        this.oLk = getViewGroup().findViewById(a.f.bg_succ_view);
        this.oLi.setOnClickListener(this);
        this.oLj.setOnClickListener(this);
        this.guy.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bAF = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oLi) {
            egu();
            if (this.bAF != null) {
                this.bAF.dismiss();
            }
        } else if (view == this.oLj) {
            this.oLo = true;
            ego();
            if (this.bAF != null) {
                this.bAF.dismiss();
            }
            egt();
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        MY(i);
        com.baidu.yuyinala.background.b.a item = this.oLl.getItem(i);
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
        if (this.oLm != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oLm.getCustomRoomId());
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "background_clk").setContentExt(jSONObject));
    }

    private void egt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "background");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oLm != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oLm.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "backchange_cfm").setContentExt(jSONObject));
    }

    public void MY(int i) {
        if (i >= 0) {
            this.guy.smoothScrollToPosition(i);
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
        if (!StringUtils.isNull(aVar.getOriginalUrl()) && aVar != this.oLp) {
            if (this.oLp != null) {
                BdResourceLoader.getInstance().cancelLoad(this.oLp.getOriginalUrl(), 10, null);
                this.oLp.setLoading(false);
            }
            this.oLp = aVar;
            this.oLp.setLoading(true);
            this.oLl.notifyDataSetChanged();
            BdResourceLoader.getInstance().loadResource(this.oLp.getOriginalUrl(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.yuyinala.background.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && c.this.oLp != null && !StringUtils.isNull(c.this.oLp.getOriginalUrl()) && c.this.oLp.getOriginalUrl().equals(str)) {
                        if (c.this.oLm != null) {
                            if (bdImage.getImage() == null || bdImage.getImage().isRecycled()) {
                                c.this.e(aVar);
                            } else {
                                c.this.oLm.a(c.this.oLp, Bitmap.createBitmap(bdImage.getImage()));
                            }
                        }
                        if (c.this.oLp != null) {
                            c.this.oLp.setLoading(false);
                        }
                        c.this.oLl.notifyDataSetChanged();
                    }
                }
            }, getTbPageContext().getUniqueId());
        }
    }

    private void d(final com.baidu.yuyinala.background.b.a aVar) {
        if (!StringUtils.isNull(aVar.egC()) && aVar != this.oLp) {
            if (this.oLp != null) {
                this.oLp.setLoading(false);
            }
            this.oLp = aVar;
            this.oLp.setLoading(true);
            this.oLl.notifyDataSetChanged();
            com.baidu.yuyinala.background.c.b.b(this.oLp.egC(), this.oLp.getMd5(), new a.InterfaceC0952a() { // from class: com.baidu.yuyinala.background.c.2
                @Override // com.baidu.yuyinala.background.c.a.InterfaceC0952a
                public void zV(boolean z) {
                    if (!z) {
                        c.this.e(aVar);
                        return;
                    }
                    c.this.oLm.a(aVar, com.baidu.yuyinala.background.c.b.Vz(com.baidu.live.ah.b.hl(c.this.oLp.getMd5())));
                    if (c.this.oLp != null) {
                        c.this.oLp.setLoading(false);
                    }
                    c.this.oLl.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.yuyinala.background.b.a aVar) {
        if (aVar != null && aVar == this.oLp) {
            if (aVar != null) {
                aVar.setLoading(false);
            }
            this.oLp = null;
            this.oLl.notifyDataSetChanged();
        }
    }

    private void ego() {
        if (this.oLm != null) {
            this.oLm.ego();
        }
    }

    private void egu() {
        if (this.oLm != null) {
            this.oLm.egp();
        }
        this.oLl.notifyDataSetChanged();
    }

    private void a(List<com.baidu.yuyinala.background.b.a> list, com.baidu.yuyinala.background.b.a aVar) {
        this.oLk.setVisibility(0);
        this.btf.setVisibility(8);
        this.oLl.setBgList(list);
        MY(ListUtils.getPosition(list, aVar));
    }

    private void egv() {
        this.btf.reset();
        this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.background.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.oLm != null) {
                    c.this.oLm.loadData();
                }
                c.this.btf.setVisibility(8);
                c.this.oLk.setVisibility(0);
            }
        });
        this.btf.setTitle(a.h.sdk_net_no);
        this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.btf.setVisibility(0);
        this.oLk.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oLo) {
            this.oLo = false;
        } else {
            egu();
        }
        if (this.oLp != null) {
            BdResourceLoader.getInstance().cancelLoad(this.oLp.getOriginalUrl(), 10, null);
            this.oLp = null;
        }
        a((List<com.baidu.yuyinala.background.b.a>) null, (com.baidu.yuyinala.background.b.a) null);
    }
}
