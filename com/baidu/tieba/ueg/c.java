package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String jwy;
    private a jwz;

    /* loaded from: classes.dex */
    public interface a {
        void bJX();

        void bJY();

        void bJZ();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.jwy = "https://lookup.api.bsb.baidu.com/urlquery?url=" + str + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getImei();
        this.jwz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            x xVar = new x(this.jwy);
            xVar.aiK().ajM().mIsNeedAddCommenParam = false;
            xVar.aiK().ajM().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(xVar.ain())).optJSONArray("result");
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
        if (this.jwz != null && num != null) {
            if (num.intValue() == -1) {
                this.jwz.onError(null);
            } else if (num.intValue() == 1) {
                this.jwz.bJX();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.jwz.bJY();
            } else {
                this.jwz.bJZ();
            }
        }
    }
}
