package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[Catch: Exception -> 0x0224, TryCatch #1 {Exception -> 0x0224, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005e, B:15:0x0064, B:17:0x006d, B:57:0x01c7, B:20:0x0077, B:22:0x0081, B:23:0x0089, B:25:0x0092, B:32:0x00a4, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0123, B:44:0x0140, B:46:0x0149, B:48:0x017a, B:80:0x0227, B:49:0x017d, B:51:0x0186, B:52:0x019c, B:54:0x01a5, B:76:0x020b, B:66:0x01e7, B:68:0x01ed, B:71:0x01f9, B:73:0x01ff, B:60:0x01d3, B:47:0x015c), top: B:93:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092 A[Catch: Exception -> 0x0224, TryCatch #1 {Exception -> 0x0224, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005e, B:15:0x0064, B:17:0x006d, B:57:0x01c7, B:20:0x0077, B:22:0x0081, B:23:0x0089, B:25:0x0092, B:32:0x00a4, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0123, B:44:0x0140, B:46:0x0149, B:48:0x017a, B:80:0x0227, B:49:0x017d, B:51:0x0186, B:52:0x019c, B:54:0x01a5, B:76:0x020b, B:66:0x01e7, B:68:0x01ed, B:71:0x01f9, B:73:0x01ff, B:60:0x01d3, B:47:0x015c), top: B:93:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109 A[Catch: Exception -> 0x0224, TryCatch #1 {Exception -> 0x0224, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005e, B:15:0x0064, B:17:0x006d, B:57:0x01c7, B:20:0x0077, B:22:0x0081, B:23:0x0089, B:25:0x0092, B:32:0x00a4, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0123, B:44:0x0140, B:46:0x0149, B:48:0x017a, B:80:0x0227, B:49:0x017d, B:51:0x0186, B:52:0x019c, B:54:0x01a5, B:76:0x020b, B:66:0x01e7, B:68:0x01ed, B:71:0x01f9, B:73:0x01ff, B:60:0x01d3, B:47:0x015c), top: B:93:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x023b  */
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
        int i3;
        int i4 = 1;
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
                        int i5 = optInt != 2 ? 1 : 0;
                        if (str3 != null || optInt != 1) {
                            i4 = 0;
                        } else if (!str3.equals(getString(R.string.des_page_home_recommend))) {
                            i4 = 2;
                        }
                        ap ah = new ap(TbadkCoreStatisticKey.PUSH_CCLICK).ah("obj_type", 2).dn("task_id", str).dn(TiebaInitialize.Params.OBJ_TO, str2).ah("obj_source", i).ah("obj_locate", i2).ah("obj_param1", i5).ah(TiebaInitialize.Params.OBJ_PARAM2, i4);
                        if (TextUtils.isEmpty(str2) && str2.contains("HotThreadList")) {
                            i3 = 6;
                        } else if (TextUtils.isEmpty(str2) && str2.contains("HotInteraction")) {
                            i3 = 7;
                        } else {
                            i3 = (TextUtils.isEmpty(str2) && str2.contains("frs?kw=")) ? 7 : i;
                        }
                        ah.ah("obj_source", i3);
                        TiebaStatic.log(ah);
                        if (!TextUtils.isEmpty(str2)) {
                            String str4 = str2 + "&from_yunpush=1";
                            if (Qd(str4)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(str4);
                                mainTabActivityConfig.setPushFollowUpAction(optInt);
                                mainTabActivityConfig.setPushDesPage(str3);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                            } else {
                                bd.baV().b(getPageContext(), new String[]{str4, "yun_push_tag"});
                            }
                            if (str4.contains("ForumGradePage")) {
                                ap t = new ap("c13782").t("uid", TbadkCoreApplication.getCurrentAccountId());
                                try {
                                    Uri parse = Uri.parse(str4);
                                    String queryParameter = parse.getQueryParameter("forum_id");
                                    String queryParameter2 = parse.getQueryParameter("obj_type");
                                    t.dn("fid", queryParameter);
                                    t.dn("obj_type", queryParameter2);
                                } catch (Exception e) {
                                    BdLog.e(e);
                                }
                                TiebaStatic.log(t);
                            }
                            if (str4.contains("unidispatch/hotuserrank")) {
                                TiebaStatic.log(new ap("c13662").t("uid", TbadkCoreApplication.getCurrentAccountId()));
                            }
                            if (str4.contains("weeklygodview")) {
                                TiebaStatic.log(new ap("c13691").t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_source", 2));
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
                    i4 = 0;
                    ap ah2 = new ap(TbadkCoreStatisticKey.PUSH_CCLICK).ah("obj_type", 2).dn("task_id", str).dn(TiebaInitialize.Params.OBJ_TO, str2).ah("obj_source", i).ah("obj_locate", i2).ah("obj_param1", i5).ah(TiebaInitialize.Params.OBJ_PARAM2, i4);
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                    ah2.ah("obj_source", i3);
                    TiebaStatic.log(ah2);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        finish();
    }

    private boolean Qd(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("flt://") || str.startsWith("bdtiebalive://") || str.startsWith("tiebachushou://");
    }
}
