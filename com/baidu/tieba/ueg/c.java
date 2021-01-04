package com.baidu.tieba.ueg;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    private String nEB;
    private a nEC;

    /* loaded from: classes.dex */
    public interface a {
        void dcl();

        void dcm();

        void dcn();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.nEB = "https://lookup.api.bsb.baidu.com/urlquery?url=" + URLEncoder.encode(str) + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getCuid();
        this.nEC = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: ac */
    public Integer doInBackground(String... strArr) {
        int i = -1;
        try {
            z zVar = new z(this.nEB);
            zVar.bvQ().bwz().mIsNeedAddCommenParam = false;
            zVar.bvQ().bwz().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(zVar.getNetData())).optJSONArray("result");
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
        if (this.nEC != null && num != null) {
            if (num.intValue() == -1) {
                this.nEC.onError(null);
            } else if (num.intValue() == 1) {
                this.nEC.dcl();
            } else if (num.intValue() == 2 || num.intValue() == 0) {
                this.nEC.dcm();
            } else {
                this.nEC.dcn();
            }
        }
    }
}
