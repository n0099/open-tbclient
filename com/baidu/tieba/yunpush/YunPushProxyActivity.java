package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: Exception -> 0x0298, TryCatch #0 {Exception -> 0x0298, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:71:0x0207, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0112, B:45:0x011b, B:47:0x0124, B:49:0x012d, B:51:0x0136, B:53:0x013f, B:58:0x0180, B:60:0x0189, B:62:0x01ba, B:102:0x0293, B:63:0x01bd, B:65:0x01c6, B:66:0x01dc, B:68:0x01e5, B:55:0x0148, B:57:0x014e, B:90:0x024b, B:92:0x0251, B:94:0x0257, B:97:0x027a, B:99:0x0280, B:96:0x0260, B:80:0x0227, B:82:0x022d, B:85:0x0239, B:87:0x023f, B:74:0x0213, B:61:0x019c), top: B:114:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091 A[Catch: Exception -> 0x0298, TryCatch #0 {Exception -> 0x0298, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:71:0x0207, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0112, B:45:0x011b, B:47:0x0124, B:49:0x012d, B:51:0x0136, B:53:0x013f, B:58:0x0180, B:60:0x0189, B:62:0x01ba, B:102:0x0293, B:63:0x01bd, B:65:0x01c6, B:66:0x01dc, B:68:0x01e5, B:55:0x0148, B:57:0x014e, B:90:0x024b, B:92:0x0251, B:94:0x0257, B:97:0x027a, B:99:0x0280, B:96:0x0260, B:80:0x0227, B:82:0x022d, B:85:0x0239, B:87:0x023f, B:74:0x0213, B:61:0x019c), top: B:114:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109 A[Catch: Exception -> 0x0298, TryCatch #0 {Exception -> 0x0298, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:71:0x0207, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0112, B:45:0x011b, B:47:0x0124, B:49:0x012d, B:51:0x0136, B:53:0x013f, B:58:0x0180, B:60:0x0189, B:62:0x01ba, B:102:0x0293, B:63:0x01bd, B:65:0x01c6, B:66:0x01dc, B:68:0x01e5, B:55:0x0148, B:57:0x014e, B:90:0x024b, B:92:0x0251, B:94:0x0257, B:97:0x027a, B:99:0x0280, B:96:0x0260, B:80:0x0227, B:82:0x022d, B:85:0x0239, B:87:0x023f, B:74:0x0213, B:61:0x019c), top: B:114:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0189 A[Catch: Exception -> 0x0298, TRY_LEAVE, TryCatch #0 {Exception -> 0x0298, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:71:0x0207, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0112, B:45:0x011b, B:47:0x0124, B:49:0x012d, B:51:0x0136, B:53:0x013f, B:58:0x0180, B:60:0x0189, B:62:0x01ba, B:102:0x0293, B:63:0x01bd, B:65:0x01c6, B:66:0x01dc, B:68:0x01e5, B:55:0x0148, B:57:0x014e, B:90:0x024b, B:92:0x0251, B:94:0x0257, B:97:0x027a, B:99:0x0280, B:96:0x0260, B:80:0x0227, B:82:0x022d, B:85:0x0239, B:87:0x023f, B:74:0x0213, B:61:0x019c), top: B:114:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c6 A[Catch: Exception -> 0x0298, TryCatch #0 {Exception -> 0x0298, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:71:0x0207, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0112, B:45:0x011b, B:47:0x0124, B:49:0x012d, B:51:0x0136, B:53:0x013f, B:58:0x0180, B:60:0x0189, B:62:0x01ba, B:102:0x0293, B:63:0x01bd, B:65:0x01c6, B:66:0x01dc, B:68:0x01e5, B:55:0x0148, B:57:0x014e, B:90:0x024b, B:92:0x0251, B:94:0x0257, B:97:0x027a, B:99:0x0280, B:96:0x0260, B:80:0x0227, B:82:0x022d, B:85:0x0239, B:87:0x023f, B:74:0x0213, B:61:0x019c), top: B:114:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e5 A[Catch: Exception -> 0x0298, TRY_LEAVE, TryCatch #0 {Exception -> 0x0298, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x001e, B:9:0x0042, B:10:0x004a, B:12:0x0056, B:13:0x005d, B:15:0x0063, B:17:0x006c, B:71:0x0207, B:20:0x0076, B:22:0x0080, B:23:0x0088, B:25:0x0091, B:32:0x00a3, B:34:0x00b0, B:36:0x00f0, B:39:0x00fa, B:41:0x0109, B:43:0x0112, B:45:0x011b, B:47:0x0124, B:49:0x012d, B:51:0x0136, B:53:0x013f, B:58:0x0180, B:60:0x0189, B:62:0x01ba, B:102:0x0293, B:63:0x01bd, B:65:0x01c6, B:66:0x01dc, B:68:0x01e5, B:55:0x0148, B:57:0x014e, B:90:0x024b, B:92:0x0251, B:94:0x0257, B:97:0x027a, B:99:0x0280, B:96:0x0260, B:80:0x0227, B:82:0x022d, B:85:0x0239, B:87:0x023f, B:74:0x0213, B:61:0x019c), top: B:114:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021f  */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        int i;
        int optInt;
        String str2;
        int i2;
        int i3;
        String str3;
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
                    String str4 = "";
                    if (!jSONObject.isNull("jump_scheme")) {
                        str4 = jSONObject.getString("jump_scheme");
                    }
                    if (!StringUtils.isNull(str4)) {
                        if (str4.equals(UrlSchemaHelper.JUMP_TO_CHAT) || str4.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                            i = 1;
                        } else if (str4.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                            i = 2;
                        } else if (str4.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                            i = 3;
                        }
                        optInt = jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                            str2 = null;
                        } else {
                            str2 = jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        }
                        if (optInt != 1) {
                            i2 = 2;
                        } else {
                            i2 = optInt == 2 ? 1 : 0;
                        }
                        int i5 = optInt != 2 ? 1 : 0;
                        if (str2 != null || optInt != 1) {
                            i4 = 0;
                        } else if (!str2.equals(getString(R.string.des_page_home_recommend))) {
                            i4 = 2;
                        }
                        ao ag = new ao(TbadkCoreStatisticKey.PUSH_CCLICK).ag("obj_type", 2).dk("task_id", str).dk(TiebaInitialize.Params.OBJ_TO, str4).ag("obj_source", i).ag("obj_locate", i2).ag("obj_param1", i5).ag(TiebaInitialize.Params.OBJ_PARAM2, i4);
                        if (TextUtils.isEmpty(str4) && str4.contains("HotThreadList")) {
                            i3 = 6;
                        } else if (TextUtils.isEmpty(str4) && str4.contains("HotInteraction")) {
                            i3 = 7;
                        } else {
                            i3 = (TextUtils.isEmpty(str4) && str4.contains("frs?kw=")) ? 7 : i;
                        }
                        ag.ag("obj_source", i3);
                        TiebaStatic.log(ag);
                        if (!TextUtils.isEmpty(str4)) {
                            if (str4.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str4.startsWith("https") || str4.startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list") || str4.startsWith("bdtiebalive://") || str4.startsWith("tiebachushou://") || str4.startsWith("flt://") || str4.startsWith("com.baidu.tieba://unidispatch/frs?kw=")) {
                                if (Pr(str4)) {
                                    String str5 = str4 + "&from_yunpush=1";
                                    MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                    mainTabActivityConfig.setTargetScheme(str5);
                                    mainTabActivityConfig.setPushFollowUpAction(optInt);
                                    mainTabActivityConfig.setPushDesPage(str2);
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                                    str3 = str5;
                                } else if (URLUtil.isHttpUrl(str4) || URLUtil.isHttpsUrl(str4) || str4.startsWith("flt://")) {
                                    bc.aWU().b(getPageContext(), new String[]{str4, "yun_push_tag"});
                                    str3 = str4;
                                } else {
                                    Uri parse = Uri.parse(str4);
                                    if (parse != null) {
                                        UtilHelper.dealOneScheme(getPageContext().getPageActivity(), parse.toString());
                                    }
                                }
                                if (str3.contains("ForumGradePage")) {
                                    ao s = new ao("c13782").s("uid", TbadkCoreApplication.getCurrentAccountId());
                                    try {
                                        Uri parse2 = Uri.parse(str3);
                                        String queryParameter = parse2.getQueryParameter("forum_id");
                                        String queryParameter2 = parse2.getQueryParameter("obj_type");
                                        s.dk("fid", queryParameter);
                                        s.dk("obj_type", queryParameter2);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    TiebaStatic.log(s);
                                }
                                if (str3.contains("unidispatch/hotuserrank")) {
                                    TiebaStatic.log(new ao("c13662").s("uid", TbadkCoreApplication.getCurrentAccountId()));
                                }
                                if (str3.contains("weeklygodview")) {
                                    TiebaStatic.log(new ao("c13691").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_source", 2));
                                }
                            }
                            str3 = str4;
                            if (str3.contains("ForumGradePage")) {
                            }
                            if (str3.contains("unidispatch/hotuserrank")) {
                            }
                            if (str3.contains("weeklygodview")) {
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
                    if (str2 != null) {
                    }
                    i4 = 0;
                    ao ag2 = new ao(TbadkCoreStatisticKey.PUSH_CCLICK).ag("obj_type", 2).dk("task_id", str).dk(TiebaInitialize.Params.OBJ_TO, str4).ag("obj_source", i).ag("obj_locate", i2).ag("obj_param1", i5).ag(TiebaInitialize.Params.OBJ_PARAM2, i4);
                    if (TextUtils.isEmpty(str4)) {
                    }
                    if (TextUtils.isEmpty(str4)) {
                    }
                    if (TextUtils.isEmpty(str4)) {
                    }
                    ag2.ag("obj_source", i3);
                    TiebaStatic.log(ag2);
                    if (!TextUtils.isEmpty(str4)) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        finish();
    }

    private boolean Pr(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("bdtiebalive://") || str.startsWith("tiebachushou://");
    }
}
