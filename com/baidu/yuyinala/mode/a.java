package com.baidu.yuyinala.mode;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a otL;
    private TbPageContext mPageContext;
    private b otM;

    public static a eeI() {
        if (otL == null) {
            synchronized (a.class) {
                if (otL == null) {
                    otL = new a();
                }
            }
        }
        return otL;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.otM = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(Xn(wVar == null ? "" : wVar.aJJ));
        if (this.otM == null) {
            this.otM = new b(tbPageContext, wVar, alaAudioModeDialogData);
        } else {
            this.otM.a(wVar, alaAudioModeDialogData);
        }
        this.otM.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> Xn(String str) {
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

    public void Hv() {
        if (this.otM != null && this.otM.isShowing()) {
            this.otM.dismiss();
        }
    }
}
