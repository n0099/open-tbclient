package com.baidu.yuyinala.mode;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a ovp;
    private TbPageContext mPageContext;
    private b ovq;

    public static a eeG() {
        if (ovp == null) {
            synchronized (a.class) {
                if (ovp == null) {
                    ovp = new a();
                }
            }
        }
        return ovp;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.ovq = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(WY(wVar == null ? "" : wVar.aHY));
        if (this.ovq == null) {
            this.ovq = new b(tbPageContext, wVar, alaAudioModeDialogData);
        } else {
            this.ovq.a(wVar, alaAudioModeDialogData);
        }
        this.ovq.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> WY(String str) {
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

    public void GM() {
        if (this.ovq != null && this.ovq.isShowing()) {
            this.ovq.dismiss();
        }
    }
}
