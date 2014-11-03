package com.baidu.tieba.xiuba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class XiubaGetUserInfoModel {
    private GetUserInfoTask mGetUserInfoTask;
    private GetUserInfoCallback userInfoCallBack;

    /* loaded from: classes.dex */
    public interface GetUserInfoCallback {
        void callBack(UserInfo userInfo);
    }

    public void setUserInfoCallBack(GetUserInfoCallback getUserInfoCallback) {
        this.userInfoCallBack = getUserInfoCallback;
    }

    public void sendGetUserInfoTask() {
        if (this.mGetUserInfoTask != null) {
            this.mGetUserInfoTask.cancel(true);
        }
        this.mGetUserInfoTask = new GetUserInfoTask(this, null);
        this.mGetUserInfoTask.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserInfo getUserInfo() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(TbConfig.SERVER_ADDRESS);
        stringBuffer.append("c/e/xiuba/getopenid");
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            ac acVar = new ac(stringBuffer.toString());
            acVar.h(arrayList);
            String lA = acVar.lA();
            UserInfo userInfo = new UserInfo();
            userInfo.parseJson(lA);
            return userInfo;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* loaded from: classes.dex */
    class GetUserInfoTask extends BdAsyncTask<Void, Void, UserInfo> {
        private GetUserInfoTask() {
        }

        /* synthetic */ GetUserInfoTask(XiubaGetUserInfoModel xiubaGetUserInfoModel, GetUserInfoTask getUserInfoTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public UserInfo doInBackground(Void... voidArr) {
            return XiubaGetUserInfoModel.this.getUserInfo();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(UserInfo userInfo) {
            super.onPostExecute((GetUserInfoTask) userInfo);
            if (XiubaGetUserInfoModel.this.userInfoCallBack != null) {
                XiubaGetUserInfoModel.this.userInfoCallBack.callBack(userInfo);
            }
        }
    }
}
