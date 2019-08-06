package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String juc;
    private a jud;

    /* loaded from: classes.dex */
    public interface a {
        void bJk();

        void bJl();

        void bJm();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.juc = "https://lookup.api.bsb.baidu.com/urlquery?url=" + str + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getImei();
        this.jud = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            x xVar = new x(this.juc);
            xVar.aiG().ajG().mIsNeedAddCommenParam = false;
            xVar.aiG().ajG().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(xVar.aij())).optJSONArray("result");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return i;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    return Integer.valueOf(optJSONObject.optInt("main", -1));
                }
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Integer num) {
        if (this.jud != null && num != null) {
            if (num.intValue() == -1) {
                this.jud.onError(null);
            } else if (num.intValue() == 1) {
                this.jud.bJk();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.jud.bJl();
            } else {
                this.jud.bJm();
            }
        }
    }
}
