package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.mvc.b.a;
/* loaded from: classes5.dex */
public class PluginConfigWrapper extends PluginNetConfigInfos.PluginConfig implements a {
    public static final int DOWNLOADED_BUT_FORBIDDEN = 1;
    public static final int DOWNLOADED_NOT_FORBIDDEN = 2;
    public static final int DOWNLOADING = 3;
    public static final int DOWNLOAD_NOT = 0;
    public static final int DOWNLOAD_UPDATE = 4;
    private static final long serialVersionUID = 1;
    private int mDownLoadStatus;
    private int mDownloadProgress;

    public PluginConfigWrapper(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null) {
            this.icon = pluginConfig.icon;
            this.display_name = pluginConfig.display_name;
            this.forbidden = pluginConfig.forbidden;
            this.version_code = pluginConfig.version_code;
            this.ext = pluginConfig.ext;
            this.newest = pluginConfig.newest;
            this.package_name = pluginConfig.package_name;
            this.verbose = pluginConfig.verbose;
        }
    }

    public int getDownLoadStatus() {
        return this.mDownLoadStatus;
    }

    public void setDownLoadStatus(int i) {
        this.mDownLoadStatus = i;
    }

    public int getDownLoadPercent() {
        return this.mDownloadProgress;
    }

    public void setDownLoadPercent(int i) {
        this.mDownloadProgress = i;
    }
}
