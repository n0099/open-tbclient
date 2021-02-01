package com.baidu.yuyinala.mode;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static a oWo;
    private TbPageContext mPageContext;
    private b oWp;

    public static a ejc() {
        if (oWo == null) {
            synchronized (a.class) {
                if (oWo == null) {
                    oWo = new a();
                }
            }
        }
        return oWo;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oWp = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(XU(abVar == null ? "" : abVar.aIT));
        if (this.oWp == null) {
            this.oWp = new b(tbPageContext, abVar, alaAudioModeDialogData);
        } else {
            this.oWp.a(abVar, alaAudioModeDialogData);
        }
        this.oWp.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> XU(String str) {
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
        if (this.oWp != null && this.oWp.isShowing()) {
            this.oWp.dismiss();
        }
    }
}
