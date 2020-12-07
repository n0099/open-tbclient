package com.baidu.yuyinala.mode;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a oKv;
    private TbPageContext mPageContext;
    private b oKw;

    public static a ekt() {
        if (oKv == null) {
            synchronized (a.class) {
                if (oKv == null) {
                    oKv = new a();
                }
            }
        }
        return oKv;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oKw = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(Yt(wVar == null ? "" : wVar.aKK));
        if (this.oKw == null) {
            this.oKw = new b(tbPageContext, wVar, alaAudioModeDialogData);
        } else {
            this.oKw.a(wVar, alaAudioModeDialogData);
        }
        this.oKw.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> Yt(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("mode_list");
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                com.baidu.yuyinala.mode.b.a aVar = new com.baidu.yuyinala.mode.b.a();
                aVar.parse(optJSONObject);
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void ID() {
        if (this.oKw != null && this.oKw.isShowing()) {
            this.oKw.dismiss();
        }
    }
}
