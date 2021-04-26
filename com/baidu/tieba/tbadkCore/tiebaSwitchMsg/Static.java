package com.baidu.tieba.tbadkCore.tiebaSwitchMsg;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.util.Util;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import d.a.c.h.j.g.d;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Static {

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            PluginNetConfigInfos parse;
            if (!TbadkCoreApplication.getInst().isMainProcess(true) || d.k().l().getPlugins().size() == 0 || customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null || TextUtils.isEmpty(p.getCmd())) {
                return;
            }
            String content = p.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(content).getJSONObject(TbEnum.SystemMessage.KEY_USER_MSG);
                if (jSONObject == null) {
                    return;
                }
                String string = jSONObject.getString("client_version");
                String M = PluginPackageManager.O().M();
                if (TextUtils.isEmpty(M)) {
                    return;
                }
                String[] split = M.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split.length != 0 && split.length != 3) {
                    String str = "";
                    for (int i2 = 0; i2 < split.length && i2 < 3; i2++) {
                        str = str + split[i2] + ".";
                    }
                    M = str.substring(0, str.length() - 1);
                }
                if (Util.c(string, M) == Util.VersionCompare.EQUAL && (parse = PluginNetConfigInfos.parse(jSONObject.toString())) != null && !parse.getConfigs().isEmpty()) {
                    PluginNetConfigInfos.PluginConfig pluginConfig = parse.getConfigs().get(0);
                    PluginNetConfigInfos.PluginConfig R = PluginPackageManager.O().R(pluginConfig.package_name);
                    d.a.c.h.j.f.d.c().d().addOrUpdateConfig(pluginConfig);
                    if (R == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000987, pluginConfig));
                        return;
                    }
                    if (pluginConfig.enable_version_code != null) {
                        R.enable = 1;
                        int[] iArr = pluginConfig.enable_version_code;
                        int length = iArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            } else if (iArr[i3] == R.version_code) {
                                R.enable = 0;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (pluginConfig.display_name != null) {
                        R.display_name = pluginConfig.display_name;
                    }
                    if (pluginConfig.ext != null) {
                        R.ext = pluginConfig.ext;
                    }
                    if (pluginConfig.forbidden >= 0) {
                        R.forbidden = pluginConfig.forbidden;
                    }
                    if (pluginConfig.forbidden_features != null) {
                        R.forbidden_features = pluginConfig.forbidden_features;
                    }
                    if (pluginConfig.icon != null) {
                        R.icon = pluginConfig.icon;
                    }
                    if (pluginConfig.load_priority >= 0) {
                        R.load_priority = pluginConfig.load_priority;
                    }
                    if (pluginConfig.priority >= 0) {
                        R.priority = pluginConfig.priority;
                    }
                    if (pluginConfig.verbose != null) {
                        R.verbose = pluginConfig.verbose;
                    }
                    if (pluginConfig.version_code > 0) {
                        R.version_code = pluginConfig.version_code;
                    }
                    if (pluginConfig.newest != null) {
                        if (R.newest == null) {
                            R.newest = new PluginNetConfigInfos.Newest();
                        }
                        if (pluginConfig.newest.change_log != null) {
                            R.newest.change_log = pluginConfig.newest.change_log;
                        }
                        if (pluginConfig.newest.download_type > 0) {
                            R.newest.download_type = pluginConfig.newest.download_type;
                        }
                        if (pluginConfig.newest.is_force_update > 0) {
                            R.newest.is_force_update = pluginConfig.newest.is_force_update;
                        }
                        if (pluginConfig.newest.md5 != null) {
                            R.newest.md5 = pluginConfig.newest.md5;
                        }
                        if (pluginConfig.newest.newest_ext != null) {
                            R.newest.newest_ext = pluginConfig.newest.newest_ext;
                        }
                        if (pluginConfig.newest.size > 0) {
                            R.newest.size = pluginConfig.newest.size;
                        }
                        if (pluginConfig.newest.url != null) {
                            R.newest.url = pluginConfig.newest.url;
                        }
                        if (pluginConfig.newest.version != null) {
                            R.newest.version = pluginConfig.newest.version;
                        }
                        if (pluginConfig.newest.version_code > 0) {
                            R.newest.version_code = pluginConfig.newest.version_code;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000987, R));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static {
        a aVar = new a(0);
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerStickyMode(2001401);
            MessageManager.getInstance().registerListener(2001401, aVar);
        }
    }
}
