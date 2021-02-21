package com.baidu.tieba.lc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.appsearchlib.Info;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.heytap.mcssdk.mode.Message;
import java.io.IOException;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {
    private IClientUpdaterCallback kZq;
    private volatile ClientUpdateInfo kZr;
    private String kZs;
    private boolean kZt;
    private Handler mHandler;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.lc.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.kZr != null && "1".equals(a.this.kZr.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(a.this.kZr.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(a.this.kZr.mVername);
                versionData.setNewVersionCode(Integer.parseInt(a.this.kZr.mVercode));
                versionData.setNewFile(a.this.kZr.mPackageName + a.this.kZr.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(a.this.kZr.mStatus));
                versionData.setNewVersionDesc(a.this.kZr.mChangelog);
                versionData.setUrl(a.this.kZr.mDownurl);
                versionData.setSize(a.this.kZr.mSize);
                versionData.setPatch(a.this.kZr.mPatchDownUrl);
                versionData.setPatchSize(a.this.kZr.mPatchSize);
                versionData.setTiebaIconUrl(a.this.kZr.mIconUrl);
                versionData.setApkMD5RSA(a.this.kZr.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.kZr, a.this.kZs)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || a.this.kZt) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.kZr, a.this.kZs)));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                    }
                }
            }
        }
    };
    private ClientUpdater kZp = ClientUpdater.getInstance(TbadkCoreApplication.getInst());

    public a(boolean z) {
        this.kZt = z;
        this.kZp.setUseCFG(false);
        this.kZp.setUseRSA(false);
        this.kZp.setFileProvider("com.baidu.tieba.fileprovider");
        this.kZq = new IClientUpdaterCallback() { // from class: com.baidu.tieba.lc.a.2
            @Override // com.baidu.clientupdate.IClientUpdaterCallback
            public void onError(JSONObject jSONObject) {
            }

            @Override // com.baidu.clientupdate.IClientUpdaterCallback
            public void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
                if (clientUpdateInfo != null && !TextUtils.isEmpty(a.this.kZs)) {
                    a.this.kZr = clientUpdateInfo;
                    a.this.mHandler.post(a.this.mRunnable);
                }
            }

            @Override // com.baidu.clientupdate.IClientUpdaterCallback
            public void onException(JSONObject jSONObject) {
            }

            @Override // com.baidu.clientupdate.IClientUpdaterCallback
            public void onFetched(JSONObject jSONObject) {
                JSONObject optJSONObject;
                JSONObject optJSONObject2;
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(Message.RULE)) != null && (optJSONObject2 = optJSONObject.optJSONObject("custom")) != null) {
                    a.this.kZs = optJSONObject2.optString("apk_MD5_RSA");
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: T */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        this.kZp.setOsName(Info.PASSWORD);
        this.kZp.setTypeId("0");
        this.kZp.setFrom("tieba");
        this.kZp.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
        this.kZp.addParamValue("tieba_versionname", TbConfig.getVersion());
        this.kZp.checkUpdate(this.kZq);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
