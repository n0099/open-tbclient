package com.baidu.tieba.play.b;

import com.coremedia.iso.boxes.UserBox;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private List<a> mList = new ArrayList();

    public void J(String str, String str2, String str3) {
        this.mList.add(new a(str, str2, str3));
    }

    public String bmd() {
        JSONObject jSONObject = new JSONObject();
        try {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                jSONObject.put(i + "", this.mList.get(i).bme());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    private static class a {
        public final String error;
        public final String fwv;
        public final String gwC;

        public a(String str, String str2, String str3) {
            this.fwv = str;
            this.error = str2;
            this.gwC = str3;
        }

        public JSONObject bme() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UserBox.TYPE, this.fwv);
                jSONObject.put("error", this.error);
                jSONObject.put("sub_error", this.gwC);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
