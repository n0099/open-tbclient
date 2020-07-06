package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String lTR;
    private a lTS;

    /* loaded from: classes.dex */
    public interface a {
        void cwi();

        void cwj();

        void cwk();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.lTR = "https://lookup.api.bsb.baidu.com/urlquery?url=" + str + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getImei();
        this.lTS = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: M */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            y yVar = new y(this.lTR);
            yVar.aWu().aWV().mIsNeedAddCommenParam = false;
            yVar.aWu().aWV().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(yVar.getNetData())).optJSONArray("result");
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
        if (this.lTS != null && num != null) {
            if (num.intValue() == -1) {
                this.lTS.onError(null);
            } else if (num.intValue() == 1) {
                this.lTS.cwi();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.lTS.cwj();
            } else {
                this.lTS.cwk();
            }
        }
    }
}
