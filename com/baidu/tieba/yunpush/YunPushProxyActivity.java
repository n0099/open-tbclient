package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: Exception -> 0x01c7, TryCatch #0 {Exception -> 0x01c7, blocks: (B:3:0x0006, B:5:0x000c, B:7:0x001d, B:9:0x0041, B:10:0x0049, B:12:0x0055, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:57:0x018d, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f3, B:38:0x00fc, B:40:0x0105, B:42:0x010e, B:44:0x0117, B:49:0x0143, B:51:0x014c, B:52:0x0162, B:54:0x016b, B:46:0x0120, B:48:0x0126, B:66:0x01ae, B:60:0x0199), top: B:78:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091 A[Catch: Exception -> 0x01c7, TryCatch #0 {Exception -> 0x01c7, blocks: (B:3:0x0006, B:5:0x000c, B:7:0x001d, B:9:0x0041, B:10:0x0049, B:12:0x0055, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:57:0x018d, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f3, B:38:0x00fc, B:40:0x0105, B:42:0x010e, B:44:0x0117, B:49:0x0143, B:51:0x014c, B:52:0x0162, B:54:0x016b, B:46:0x0120, B:48:0x0126, B:66:0x01ae, B:60:0x0199), top: B:78:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f3 A[Catch: Exception -> 0x01c7, TryCatch #0 {Exception -> 0x01c7, blocks: (B:3:0x0006, B:5:0x000c, B:7:0x001d, B:9:0x0041, B:10:0x0049, B:12:0x0055, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:57:0x018d, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f3, B:38:0x00fc, B:40:0x0105, B:42:0x010e, B:44:0x0117, B:49:0x0143, B:51:0x014c, B:52:0x0162, B:54:0x016b, B:46:0x0120, B:48:0x0126, B:66:0x01ae, B:60:0x0199), top: B:78:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d5  */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        int i;
        int optInt;
        String str3;
        int i2;
        int i3 = 1;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String uri = intent.getData().toString();
                if (uri.contains("tbyunpushnotifybody=")) {
                    JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                    if (jSONObject.isNull("task_id")) {
                        str = "";
                    } else {
                        str = jSONObject.getString("task_id");
                    }
                    if (jSONObject.isNull("jump_scheme")) {
                        str2 = "";
                    } else {
                        str2 = jSONObject.getString("jump_scheme");
                    }
                    if (!StringUtils.isNull(str2)) {
                        if (str2.equals(UrlSchemaHelper.JUMP_TO_CHAT) || str2.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                            i = 1;
                        } else if (str2.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                            i = 2;
                        } else if (str2.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                            i = 3;
                        }
                        optInt = jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                            str3 = null;
                        } else {
                            str3 = jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        }
                        if (optInt != 1) {
                            i2 = 2;
                        } else {
                            i2 = optInt == 2 ? 1 : 0;
                        }
                        int i4 = optInt != 2 ? 1 : 0;
                        if (str3 != null || optInt != 1) {
                            i3 = 0;
                        } else if (!str3.equals(getString(R.string.des_page_home_recommend))) {
                            i3 = 2;
                        }
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).ag("obj_type", 2).dh("task_id", str).dh(TiebaInitialize.Params.OBJ_TO, str2).ag("obj_source", i).ag("obj_locate", i2).ag("obj_param1", i4).ag(TiebaInitialize.Params.OBJ_PARAM2, i3));
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str2.startsWith("https") || str2.startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list") || str2.startsWith("bdtiebalive://") || str2.startsWith("tiebachushou://")) {
                                if (OF(str2)) {
                                    MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                    mainTabActivityConfig.setTargetScheme(str2);
                                    mainTabActivityConfig.setPushFollowUpAction(optInt);
                                    mainTabActivityConfig.setPushDesPage(str3);
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                                } else {
                                    ba.aVa().b(getPageContext(), new String[]{str2, "yun_push_tag"});
                                }
                            }
                            if (str2.contains("unidispatch/hotuserrank")) {
                                TiebaStatic.log(new an("c13662").s("uid", TbadkCoreApplication.getCurrentAccountId()));
                            }
                            if (str2.contains("weeklygodview")) {
                                TiebaStatic.log(new an("c13691").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_source", 2));
                            }
                        }
                    }
                    i = 0;
                    if (jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                    }
                    if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                    }
                    if (optInt != 1) {
                    }
                    if (optInt != 2) {
                    }
                    if (str3 != null) {
                    }
                    i3 = 0;
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).ag("obj_type", 2).dh("task_id", str).dh(TiebaInitialize.Params.OBJ_TO, str2).ag("obj_source", i).ag("obj_locate", i2).ag("obj_param1", i4).ag(TiebaInitialize.Params.OBJ_PARAM2, i3));
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            }
        } catch (Exception e) {
        }
        finish();
    }

    private boolean OF(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("bdtiebalive://") || str.startsWith("tiebachushou://");
    }
}
