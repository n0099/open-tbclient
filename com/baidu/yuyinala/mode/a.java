package com.baidu.yuyinala.mode;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a oMi;
    private TbPageContext mPageContext;
    private b oMj;

    public static a egK() {
        if (oMi == null) {
            synchronized (a.class) {
                if (oMi == null) {
                    oMi = new a();
                }
            }
        }
        return oMi;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oMj = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(WV(xVar == null ? "" : xVar.aGx));
        if (this.oMj == null) {
            this.oMj = new b(tbPageContext, xVar, alaAudioModeDialogData);
        } else {
            this.oMj.a(xVar, alaAudioModeDialogData);
        }
        this.oMj.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> WV(String str) {
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
        if (this.oMj != null && this.oMj.isShowing()) {
            this.oMj.dismiss();
        }
    }
}
