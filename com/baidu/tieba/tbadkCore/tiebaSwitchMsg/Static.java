package com.baidu.tieba.tbadkCore.tiebaSwitchMsg;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.d;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Static {
    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.tbadkCore.tiebaSwitchMsg.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GroupNewsPojo p;
                PluginNetConfigInfos parse;
                int i = 0;
                if (TbadkCoreApplication.getInst().isMainProcess(true) && c.jX().jU().getPlugins().size() != 0 && customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && !TextUtils.isEmpty(p.getCmd())) {
                    String content = p.getContent();
                    if (!TextUtils.isEmpty(content)) {
                        try {
                            JSONObject jSONObject = new JSONObject(content).getJSONObject("userMsg");
                            if (jSONObject != null) {
                                String string = jSONObject.getString("client_version");
                                String jF = PluginPackageManager.ju().jF();
                                if (!TextUtils.isEmpty(jF)) {
                                    String[] split = jF.split("\\.");
                                    if (split.length != 0 && split.length != 3) {
                                        String str = "";
                                        for (int i2 = 0; i2 < split.length && i2 < 3; i2++) {
                                            str = str + split[i2] + ".";
                                        }
                                        jF = str.substring(0, str.length() - 1);
                                    }
                                    if (Util.I(string, jF) == Util.VersionCompare.EQUAL && (parse = PluginNetConfigInfos.parse(jSONObject.toString())) != null && !parse.getConfigs().isEmpty()) {
                                        PluginNetConfigInfos.PluginConfig pluginConfig = parse.getConfigs().get(0);
                                        PluginNetConfigInfos.PluginConfig pluginConfig2 = PluginPackageManager.ju().getPluginConfig(pluginConfig.package_name);
                                        d.jR().jS().addOrUpdateConfig(pluginConfig);
                                        if (pluginConfig2 == null) {
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000987, pluginConfig));
                                            return;
                                        }
                                        if (pluginConfig.enable_version_code != null) {
                                            pluginConfig2.enable = 1;
                                            int[] iArr = pluginConfig.enable_version_code;
                                            int length = iArr.length;
                                            while (true) {
                                                if (i < length) {
                                                    if (iArr[i] != pluginConfig2.version_code) {
                                                        i++;
                                                    } else {
                                                        pluginConfig2.enable = 0;
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        if (pluginConfig.display_name != null) {
                                            pluginConfig2.display_name = pluginConfig.display_name;
                                        }
                                        if (pluginConfig.ext != null) {
                                            pluginConfig2.ext = pluginConfig.ext;
                                        }
                                        if (pluginConfig.forbidden >= 0) {
                                            pluginConfig2.forbidden = pluginConfig.forbidden;
                                        }
                                        if (pluginConfig.forbidden_features != null) {
                                            pluginConfig2.forbidden_features = pluginConfig.forbidden_features;
                                        }
                                        if (pluginConfig.icon != null) {
                                            pluginConfig2.icon = pluginConfig.icon;
                                        }
                                        if (pluginConfig.load_priority >= 0) {
                                            pluginConfig2.load_priority = pluginConfig.load_priority;
                                        }
                                        if (pluginConfig.priority >= 0) {
                                            pluginConfig2.priority = pluginConfig.priority;
                                        }
                                        if (pluginConfig.verbose != null) {
                                            pluginConfig2.verbose = pluginConfig.verbose;
                                        }
                                        if (pluginConfig.version_code > 0) {
                                            pluginConfig2.version_code = pluginConfig.version_code;
                                        }
                                        if (pluginConfig.newest != null) {
                                            if (pluginConfig2.newest == null) {
                                                pluginConfig2.newest = new PluginNetConfigInfos.Newest();
                                            }
                                            if (pluginConfig.newest.change_log != null) {
                                                pluginConfig2.newest.change_log = pluginConfig.newest.change_log;
                                            }
                                            if (pluginConfig.newest.download_type > 0) {
                                                pluginConfig2.newest.download_type = pluginConfig.newest.download_type;
                                            }
                                            if (pluginConfig.newest.is_force_update > 0) {
                                                pluginConfig2.newest.is_force_update = pluginConfig.newest.is_force_update;
                                            }
                                            if (pluginConfig.newest.md5 != null) {
                                                pluginConfig2.newest.md5 = pluginConfig.newest.md5;
                                            }
                                            if (pluginConfig.newest.newest_ext != null) {
                                                pluginConfig2.newest.newest_ext = pluginConfig.newest.newest_ext;
                                            }
                                            if (pluginConfig.newest.size > 0) {
                                                pluginConfig2.newest.size = pluginConfig.newest.size;
                                            }
                                            if (pluginConfig.newest.url != null) {
                                                pluginConfig2.newest.url = pluginConfig.newest.url;
                                            }
                                            if (pluginConfig.newest.version != null) {
                                                pluginConfig2.newest.version = pluginConfig.newest.version;
                                            }
                                            if (pluginConfig.newest.version_code > 0) {
                                                pluginConfig2.newest.version_code = pluginConfig.newest.version_code;
                                            }
                                        }
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000987, pluginConfig2));
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_PLUGIN_CONFIG_SYNC);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_PLUGIN_CONFIG_SYNC, customMessageListener);
        }
    }
}
