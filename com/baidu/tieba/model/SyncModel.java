package com.baidu.tieba.model;

import com.baidu.tieba.data.ClientData;
import com.baidu.tieba.data.ConfigData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SyncModel {
    private VersionData mVersion = new VersionData();
    private ClientData mClient = new ClientData();
    private ConfigData mConfig = new ConfigData();

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.mVersion.parserJson(json.optJSONObject(TiebaUpdateService.TAG_VERSION));
                this.mClient.parserJson(json.optJSONObject("client"));
                this.mConfig.parserJson(json.optJSONObject("config"));
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
            }
        }
    }

    public void setVersion(VersionData version) {
        this.mVersion = version;
    }

    public VersionData getVersion() {
        return this.mVersion;
    }

    public void setClient(ClientData client) {
        this.mClient = client;
    }

    public ClientData getClient() {
        return this.mClient;
    }
}
