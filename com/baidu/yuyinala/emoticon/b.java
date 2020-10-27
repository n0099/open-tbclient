package com.baidu.yuyinala.emoticon;

import android.content.DialogInterface;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.pb.interactionpopupwindow.c;
import com.baidu.yuyinala.emoticon.AlaEmoticonListView;
import com.baidu.yuyinala.emoticon.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<AlaEmoticonListView, AlaEmoticonListDialogData> implements c, AlaEmoticonListView.a, a.InterfaceC0921a {
    private com.baidu.yuyinala.emoticon.b.a okk;

    public b(TbPageContext tbPageContext, w wVar) {
        super(tbPageContext, new AlaEmoticonListView(tbPageContext), null);
        ((AlaEmoticonListView) this.bwe).a((c) this);
        ((AlaEmoticonListView) this.bwe).a((AlaEmoticonListView.a) this);
        fG(80);
        cA(true);
        cB(true);
        this.okk = new com.baidu.yuyinala.emoticon.b.a(wVar);
        this.okk.a(this);
        a((DialogInterface.OnDismissListener) this.bwe);
    }

    @Override // com.baidu.yuyinala.emoticon.AlaEmoticonListView.a
    public void loadData() {
        this.okk.eaZ();
    }

    @Override // com.baidu.yuyinala.emoticon.AlaEmoticonListView.a
    public void a(com.baidu.yuyinala.emoticon.a.a aVar) {
        if (aVar != null) {
            this.okk.WJ(aVar.getId());
            b(aVar);
        }
    }

    private void b(com.baidu.yuyinala.emoticon.a.a aVar) {
        String id;
        if (aVar != null) {
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
            jSONObject.put("meme_id", id);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "meme");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.okk != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.okk.getCustomRoomId());
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "memeicon_clk").setContentExt(jSONObject));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QG() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QH() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.yuyinala.emoticon.b.a.InterfaceC0921a
    public void a(AlaEmoticonListDialogData alaEmoticonListDialogData) {
        ((AlaEmoticonListView) this.bwe).a(alaEmoticonListDialogData, true);
    }

    @Override // com.baidu.yuyinala.emoticon.b.a.InterfaceC0921a
    public void WI(String str) {
        if (StringUtils.isNull(str)) {
            this.mPageContext.showToast(a.i.send_emoticon_fail);
        } else {
            this.mPageContext.showToast(str);
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        loadData();
    }
}
