package com.baidu.yuyinala.mode;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static a oWO;
    private TbPageContext mPageContext;
    private b oWP;

    public static a ejk() {
        if (oWO == null) {
            synchronized (a.class) {
                if (oWO == null) {
                    oWO = new a();
                }
            }
        }
        return oWO;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oWP = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(Yg(abVar == null ? "" : abVar.aIT));
        if (this.oWP == null) {
            this.oWP = new b(tbPageContext, abVar, alaAudioModeDialogData);
        } else {
            this.oWP.a(abVar, alaAudioModeDialogData);
        }
        this.oWP.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> Yg(String str) {
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

    public void FA() {
        if (this.oWP != null && this.oWP.isShowing()) {
            this.oWP.dismiss();
        }
    }
}
