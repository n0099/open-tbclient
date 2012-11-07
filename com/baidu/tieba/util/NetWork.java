package com.baidu.tieba.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.AccountShareHelper;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.model.LoginModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWork {
    public static final String BDUSS = "BDUSS";
    private static final String CLIENT_ID = "_client_id";
    private static final String CLIENT_TYPE = "_client_type";
    private static final String CLIENT_TYPE_ANDROID = "2";
    private static final String CLIENT_VERSION = "_client_version";
    private static final String FROM = "from";
    private static final String NET_TYPE = "net_type";
    private static final int NET_TYPE_GET = 1;
    private static final int NET_TYPE_POST = 2;
    private static final int NET_TYPE_POST_CHUNK = 3;
    private static final String PHONE_IMEI = "_phone_imei";
    private static final String TBS = "tbs";
    private NetWorkCore mNet = null;
    private NetWorkCore mNetLogin = null;
    private boolean mIsNeedTbs = false;
    private boolean mNeedBackgroundLogin = true;

    private void initNetWork() {
        this.mNet = new NetWorkCore();
        this.mNetLogin = null;
        this.mIsNeedTbs = false;
        this.mNeedBackgroundLogin = true;
    }

    public NetWork() {
        initNetWork();
    }

    public boolean isNeedBackgroundLogin() {
        return this.mNeedBackgroundLogin;
    }

    public void setNeedBackgroundLogin(boolean needBackgroundLogin) {
        this.mNeedBackgroundLogin = needBackgroundLogin;
    }

    public NetWork(String url) {
        initNetWork();
        this.mNet.setUrl(url);
    }

    public NetWork(Context context, String url) {
        initNetWork();
        this.mNet.setContext(context);
        this.mNet.setUrl(url);
    }

    public NetWork(Context context, String url, ArrayList<BasicNameValuePair> PostData) {
        initNetWork();
        this.mNet.setContext(context);
        this.mNet.setUrl(url);
        this.mNet.setPostData(PostData);
    }

    public void setRequestGzip(Boolean requestGzip) {
        this.mNet.setRequestGzip(requestGzip);
    }

    public boolean getRequestGzip() {
        return this.mNet.getRequestGzip().booleanValue();
    }

    public void setUrl(String url) {
        this.mNet.setUrl(url);
    }

    public String getUrl() {
        return this.mNet.getUrl();
    }

    public void setContext(Context context) {
        this.mNet.setContext(context);
    }

    public Context getContext() {
        return this.mNet.getContext();
    }

    public ArrayList<BasicNameValuePair> getPostData() {
        return this.mNet.getPostData();
    }

    public void setPostData(ArrayList<BasicNameValuePair> mPostData) {
        this.mNet.setPostData(mPostData);
    }

    public void addPostData(String k, String v) {
        this.mNet.addPostData(k, v);
    }

    public void addPostData(BasicNameValuePair data) {
        this.mNet.addPostData(data);
    }

    public void addPostData(String k, byte[] v) {
        this.mNet.addPostData(k, v);
    }

    public void setIsBDImage(boolean isBDImage) {
        this.mNet.setIsBDImage(isBDImage);
    }

    public boolean getIsBDImage() {
        return this.mNet.getIsBDImage();
    }

    private void addSessionData() {
        String bduss = TiebaApplication.getCurrentBduss();
        if (bduss != null) {
            this.mNet.addPostData(BDUSS, bduss);
        }
    }

    private void modSessionData() {
        String bduss = TiebaApplication.getCurrentBduss();
        BasicNameValuePair pair1 = new BasicNameValuePair(BDUSS, bduss);
        BasicNameValuePair pair2 = new BasicNameValuePair(TBS, TiebaApplication.app.getTbs());
        TiebaLog.i("NetWork", "modSessionData", "== BDUSS:" + bduss);
        TiebaLog.i("NetWork", "modSessionData", "== TBS:" + TiebaApplication.app.getTbs());
        if (bduss != null) {
            ArrayList<BasicNameValuePair> param = this.mNet.getPostData();
            int size = param.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair tmp = param.get(i);
                if (tmp.getName().equals(BDUSS)) {
                    param.set(i, pair1);
                } else if (tmp.getName().equals(TBS) && !TiebaApplication.isBaiduAccountManager()) {
                    param.set(i, pair2);
                }
            }
        }
    }

    public int getNetDataSize() {
        return this.mNet.getNetDataSize();
    }

    private void addCommonParam() {
        this.mNet.addPostData(CLIENT_TYPE, "2");
        this.mNet.addPostData(CLIENT_VERSION, Config.VERSION);
        if (TiebaApplication.app.getImei() != null) {
            this.mNet.addPostData(PHONE_IMEI, TiebaApplication.app.getImei());
        }
        String client_id = TiebaApplication.getClientId();
        if (client_id != null) {
            this.mNet.addPostData(CLIENT_ID, client_id);
        }
        String from = TiebaApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.mNet.addPostData("from", from);
        }
        String net_type = this.mNet.getNetType();
        if (net_type != null) {
            this.mNet.addPostData(NET_TYPE, net_type);
        }
        if (this.mIsNeedTbs) {
            if (TiebaApplication.isBaiduAccountManager()) {
                this.mNet.addPostData(TBS, Config.TBS_IGNORE);
            } else {
                this.mNet.addPostData(TBS, TiebaApplication.app.getTbs());
            }
        }
    }

    public boolean isRequestSuccess() {
        return this.mNet.isRequestSuccess();
    }

    public boolean isNetSuccess() {
        return this.mNet.isNetSuccess();
    }

    public int getErrorCode() {
        return this.mNet.getErrorCode();
    }

    public String getNetType() {
        return this.mNet.getNetType();
    }

    public String getErrorString() {
        return this.mNet.getErrorString();
    }

    public void cancelNetConnect() {
        if (this.mNet != null) {
            this.mNet.cancelNetConnect();
        }
        if (this.mNetLogin != null) {
            this.mNetLogin.cancelNetConnect();
        }
    }

    public LoginModel login(String account, String password, boolean login_activity) {
        String data;
        try {
            TiebaLog.i(getClass().toString(), Config.ST_TYPE_LOGIN, "=== need auto login");
            StringBuffer address = new StringBuffer(30);
            address.append(Config.SERVER_ADDRESS);
            address.append(Config.LOGIN_ADDRESS);
            ArrayList<BasicNameValuePair> param = new ArrayList<>();
            BasicNameValuePair tmp = new BasicNameValuePair("un", account);
            param.add(tmp);
            BasicNameValuePair tmp2 = new BasicNameValuePair("passwd", password);
            param.add(tmp2);
            BasicNameValuePair tmp3 = new BasicNameValuePair("isphone", "0");
            param.add(tmp3);
            if (this.mNetLogin == null) {
                this.mNetLogin = new NetWorkCore();
            } else {
                this.mNetLogin.cancelNetConnect();
            }
            this.mNetLogin.setUrl(address.toString());
            this.mNetLogin.setPostData(param);
            this.mNetLogin.setRequestGzip(true);
            this.mNetLogin.setContext(this.mNet.getContext());
            data = this.mNetLogin.postNetData();
        } catch (Exception ex) {
            TiebaLog.e(getClass().toString(), Config.ST_TYPE_LOGIN, ex.getMessage());
        }
        if (this.mNetLogin.isRequestSuccess() && data != null) {
            LoginModel loginData = new LoginModel();
            loginData.parserJson(data);
            String userId = loginData.getUser().getId();
            if (userId == null || userId.length() <= 0) {
                this.mNetLogin.setErrorString(this.mNetLogin.getContext().getString(R.string.neterror));
                return null;
            }
            AccountData obj = new AccountData();
            obj.setAccount(loginData.getUser().getName());
            obj.setPassword(password);
            obj.setID(loginData.getUser().getId());
            obj.setBDUSS(loginData.getUser().getBDUSS());
            obj.setIsActive(1);
            if (loginData.getAnti() != null) {
                obj.setTbs(loginData.getAnti().getTbs());
            }
            DatabaseService.saveAccountData(obj);
            TiebaApplication.setCurrentAccountObj(obj);
            AccountShareHelper.getInstance().valid();
            return loginData;
        }
        if (this.mNetLogin.isNetSuccess()) {
            int err = this.mNetLogin.getErrorCode();
            switch (err) {
                case 1:
                case 2:
                case 5:
                    if (login_activity) {
                        Message msg = TiebaApplication.app.handler.obtainMessage(1);
                        Bundle tmpBundel = new Bundle();
                        tmpBundel.putString(LoginActivity.ACCOUNT, account);
                        msg.setData(tmpBundel);
                        TiebaApplication.app.handler.sendMessage(msg);
                    }
                    this.mNetLogin.cleanErrorString();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] getNetData() {
        addCommonParam();
        return this.mNet.getNetData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BaiduReLogin() {
        TiebaApplication.setCurrentAccount(null);
        TiebaApplication.app.handler.sendMessage(TiebaApplication.app.handler.obtainMessage(1));
    }

    private String process(int type) {
        String data;
        switch (type) {
            case 1:
                addCommonParam();
                data = this.mNet.getNetString();
                break;
            case 2:
                addSessionData();
                addCommonParam();
                data = this.mNet.postNetData();
                break;
            case 3:
                addSessionData();
                addCommonParam();
                data = this.mNet.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.mNet.isRequestSuccess() && this.mNet.isNetSuccess()) {
            if (this.mNet.getErrorCode() == 1 && this.mNeedBackgroundLogin) {
                this.mNet.cleanErrorString();
                if (TiebaApplication.isBaiduAccountManager()) {
                    data = null;
                    BaiduAccount baiduAccount = BaiduAccount.get(TiebaApplication.app);
                    String token = baiduAccount.backgroundReLogin(TiebaApplication.getCurrentAccountName(), TiebaApplication.getCurrentBduss(), new BaiduAccount.CallbackListener() { // from class: com.baidu.tieba.util.NetWork.1
                        @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
                        public void callback() {
                            NetWork.this.BaiduReLogin();
                        }
                    }, new BaiduAccount.CallbackListener() { // from class: com.baidu.tieba.util.NetWork.2
                        @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
                        public void callback() {
                            NetWork.this.mNet.setErrorString(TiebaApplication.app.getString(R.string.error_unkown));
                        }
                    });
                    if (token != null) {
                        DatabaseService.updateAccountToken(TiebaApplication.getCurrentAccountName(), token);
                        TiebaApplication.setCurrentBduss(token);
                        data = process_second(type);
                    }
                } else {
                    AccountData obj = TiebaApplication.getCurrentAccountObj();
                    if (obj == null) {
                        obj = DatabaseService.getActiveAccountData();
                    }
                    if (obj == null) {
                        TiebaApplication.app.handler.sendMessage(TiebaApplication.app.handler.obtainMessage(1));
                        return null;
                    }
                    LoginModel model = login(obj.getAccount(), obj.getPassword(), true);
                    if (model == null) {
                        if (this.mNetLogin != null) {
                            this.mNet.setErrorString(this.mNetLogin.getErrorString());
                            return null;
                        }
                        return null;
                    }
                    data = process_second(type);
                }
            }
            return data;
        }
        return data;
    }

    private String process_second(int type) {
        String data;
        modSessionData();
        switch (type) {
            case 1:
                data = this.mNet.getNetString();
                break;
            case 2:
                data = this.mNet.postNetData();
                break;
            case 3:
                data = this.mNet.postMultiNetData();
                break;
            default:
                return null;
        }
        return data;
    }

    public boolean multiAccountLogin(String account, String password, boolean login_acvitity) {
        LoginModel model = login(account, password, login_acvitity);
        if (model == null) {
            if (this.mNetLogin != null) {
                this.mNet.setErrorString(this.mNetLogin.getErrorString());
            }
            return false;
        }
        return true;
    }

    public String postNetData() {
        return process(2);
    }

    public String getNetString() {
        return process(1);
    }

    public String postMultiNetData() {
        return process(3);
    }

    public String uploadImage(String filename) throws IOException {
        TiebaLog.d("NetWork", "uploadImage", "upload image");
        byte[] data = null;
        try {
            InputStream in = FileHelper.GetStreamFromFile(filename);
            byte[] buf = new byte[5120];
            ByteArrayOutputStream outputstream = new ByteArrayOutputStream(5120);
            while (true) {
                int num = in.read(buf);
                if (num == -1) {
                    break;
                }
                outputstream.write(buf, 0, num);
            }
            data = outputstream.toByteArray();
        } catch (Exception e) {
        }
        if (data == null || data.length <= 0) {
            return null;
        }
        addPostData("pic", data);
        return postMultiNetData();
    }

    public boolean isFileSegSuccess() {
        return this.mNet.isFileSegSuccess();
    }

    public Boolean downloadFile(String name, Handler handler) {
        addSessionData();
        return this.mNet.downloadFile(name, handler);
    }

    public void setIsNeedTbs(boolean mIsNeedTbs) {
        this.mIsNeedTbs = mIsNeedTbs;
    }

    public boolean getIsNeedTbs() {
        return this.mIsNeedTbs;
    }
}
