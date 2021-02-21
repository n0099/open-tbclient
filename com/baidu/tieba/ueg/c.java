package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String nKg;
    private a nKh;

    /* loaded from: classes.dex */
    public interface a {
        void daA();

        void daB();

        void daz();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.nKg = "https://lookup.api.bsb.baidu.com/urlquery?url=" + URLEncoder.encode(str) + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getCuid();
        this.nKh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: ac */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            aa aaVar = new aa(this.nKg);
            aaVar.bsr().bta().mIsNeedAddCommenParam = false;
            aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(aaVar.getNetData())).optJSONArray("result");
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
        if (this.nKh != null && num != null) {
            if (num.intValue() == -1) {
                this.nKh.onError(null);
            } else if (num.intValue() == 1) {
                this.nKh.daz();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.nKh.daA();
            } else {
                this.nKh.daB();
            }
        }
    }
}
