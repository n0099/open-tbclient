package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String kto;
    private a ktp;

    /* loaded from: classes.dex */
    public interface a {
        void bZj();

        void bZk();

        void bZl();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.kto = "https://lookup.api.bsb.baidu.com/urlquery?url=" + str + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getImei();
        this.ktp = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: J */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            x xVar = new x(this.kto);
            xVar.aDU().aEu().mIsNeedAddCommenParam = false;
            xVar.aDU().aEu().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(xVar.getNetData())).optJSONArray("result");
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
        if (this.ktp != null && num != null) {
            if (num.intValue() == -1) {
                this.ktp.onError(null);
            } else if (num.intValue() == 1) {
                this.ktp.bZj();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.ktp.bZk();
            } else {
                this.ktp.bZl();
            }
        }
    }
}
