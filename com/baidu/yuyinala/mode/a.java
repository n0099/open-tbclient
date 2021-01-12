package com.baidu.yuyinala.mode;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a oMh;
    private TbPageContext mPageContext;
    private b oMi;

    public static a egK() {
        if (oMh == null) {
            synchronized (a.class) {
                if (oMh == null) {
                    oMh = new a();
                }
            }
        }
        return oMh;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oMi = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(WU(xVar == null ? "" : xVar.aGx));
        if (this.oMi == null) {
            this.oMi = new b(tbPageContext, xVar, alaAudioModeDialogData);
        } else {
            this.oMi.a(xVar, alaAudioModeDialogData);
        }
        this.oMi.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> WU(String str) {
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

    public void Ek() {
        if (this.oMi != null && this.oMi.isShowing()) {
            this.oMi.dismiss();
        }
    }
}
