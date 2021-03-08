package com.baidu.yuyinala.mode;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a oYT;
    private TbPageContext mPageContext;
    private b oYU;

    public static a eju() {
        if (oYT == null) {
            synchronized (a.class) {
                if (oYT == null) {
                    oYT = new a();
                }
            }
        }
        return oYT;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oYU = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(Yn(abVar == null ? "" : abVar.aKt));
        if (this.oYU == null) {
            this.oYU = new b(tbPageContext, abVar, alaAudioModeDialogData);
        } else {
            this.oYU.a(abVar, alaAudioModeDialogData);
        }
        this.oYU.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> Yn(String str) {
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

    public void FD() {
        if (this.oYU != null && this.oYU.isShowing()) {
            this.oYU.dismiss();
        }
    }
}
