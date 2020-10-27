package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String nfl;
    private a nfm;

    /* loaded from: classes.dex */
    public interface a {
        void cVs();

        void cVt();

        void cVu();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.nfl = "https://lookup.api.bsb.baidu.com/urlquery?url=" + str + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getImei();
        this.nfm = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: V */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            aa aaVar = new aa(this.nfl);
            aaVar.bon().boT().mIsNeedAddCommenParam = false;
            aaVar.bon().boT().mIsUseCurrentBDUSS = false;
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
        if (this.nfm != null && num != null) {
            if (num.intValue() == -1) {
                this.nfm.onError(null);
            } else if (num.intValue() == 1) {
                this.nfm.cVs();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.nfm.cVt();
            } else {
                this.nfm.cVu();
            }
        }
    }
}
