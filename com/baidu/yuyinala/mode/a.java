package com.baidu.yuyinala.mode;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static a oQJ;
    private TbPageContext mPageContext;
    private b oQK;

    public static a ekE() {
        if (oQJ == null) {
            synchronized (a.class) {
                if (oQJ == null) {
                    oQJ = new a();
                }
            }
        }
        return oQJ;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oQK = null;
        }
        AlaAudioModeDialogData alaAudioModeDialogData = new AlaAudioModeDialogData();
        alaAudioModeDialogData.setModeList(Yc(xVar == null ? "" : xVar.aLk));
        if (this.oQK == null) {
            this.oQK = new b(tbPageContext, xVar, alaAudioModeDialogData);
        } else {
            this.oQK.a(xVar, alaAudioModeDialogData);
        }
        this.oQK.show();
    }

    private List<com.baidu.yuyinala.mode.b.a> Yc(String str) {
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

    public void If() {
        if (this.oQK != null && this.oQK.isShowing()) {
            this.oQK.dismiss();
        }
    }
}
