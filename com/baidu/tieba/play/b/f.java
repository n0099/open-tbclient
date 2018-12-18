package com.baidu.tieba.play.b;

import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private List<a> mList = new ArrayList();

    public void O(String str, String str2, String str3) {
        this.mList.add(new a(str, str2, str3));
    }

    public String bsk() {
        JSONObject jSONObject = new JSONObject();
        try {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                jSONObject.put(i + "", this.mList.get(i).bsl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    private static class a {
        public final String error;
        public final String gFp;
        public final String uuid;

        public a(String str, String str2, String str3) {
            this.uuid = str;
            this.error = str2;
            this.gFp = str3;
        }

        public JSONObject bsl() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uuid", this.uuid);
                jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.error);
                jSONObject.put("sub_error", this.gFp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
