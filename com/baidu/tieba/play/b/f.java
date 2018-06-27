package com.baidu.tieba.play.b;

import com.coremedia.iso.boxes.UserBox;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private List<a> mList = new ArrayList();

    public void F(String str, String str2, String str3) {
        this.mList.add(new a(str, str2, str3));
    }

    public String bmL() {
        JSONObject jSONObject = new JSONObject();
        try {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                jSONObject.put(i + "", this.mList.get(i).bmM());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    private static class a {
        public final String error;
        public final String ghE;
        public final String uuid;

        public a(String str, String str2, String str3) {
            this.uuid = str;
            this.error = str2;
            this.ghE = str3;
        }

        public JSONObject bmM() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UserBox.TYPE, this.uuid);
                jSONObject.put("error", this.error);
                jSONObject.put("sub_error", this.ghE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
