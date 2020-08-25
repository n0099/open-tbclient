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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:102:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[Catch: Exception -> 0x0270, TryCatch #0 {Exception -> 0x0270, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x0065, B:17:0x006e, B:62:0x01dc, B:20:0x0078, B:22:0x0082, B:23:0x008a, B:25:0x0093, B:32:0x00a5, B:36:0x00b4, B:71:0x01fc, B:74:0x0208, B:77:0x0214, B:39:0x00be, B:41:0x0105, B:44:0x010f, B:46:0x011e, B:48:0x0138, B:49:0x0155, B:51:0x015e, B:53:0x018f, B:99:0x0274, B:54:0x0192, B:56:0x019b, B:57:0x01b1, B:59:0x01ba, B:95:0x0257, B:80:0x0220, B:82:0x0226, B:85:0x0232, B:87:0x0238, B:90:0x0244, B:92:0x024a, B:65:0x01e8, B:52:0x0171), top: B:109:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[Catch: Exception -> 0x0270, TryCatch #0 {Exception -> 0x0270, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x0065, B:17:0x006e, B:62:0x01dc, B:20:0x0078, B:22:0x0082, B:23:0x008a, B:25:0x0093, B:32:0x00a5, B:36:0x00b4, B:71:0x01fc, B:74:0x0208, B:77:0x0214, B:39:0x00be, B:41:0x0105, B:44:0x010f, B:46:0x011e, B:48:0x0138, B:49:0x0155, B:51:0x015e, B:53:0x018f, B:99:0x0274, B:54:0x0192, B:56:0x019b, B:57:0x01b1, B:59:0x01ba, B:95:0x0257, B:80:0x0220, B:82:0x0226, B:85:0x0232, B:87:0x0238, B:90:0x0244, B:92:0x024a, B:65:0x01e8, B:52:0x0171), top: B:109:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[Catch: Exception -> 0x0270, TryCatch #0 {Exception -> 0x0270, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x0065, B:17:0x006e, B:62:0x01dc, B:20:0x0078, B:22:0x0082, B:23:0x008a, B:25:0x0093, B:32:0x00a5, B:36:0x00b4, B:71:0x01fc, B:74:0x0208, B:77:0x0214, B:39:0x00be, B:41:0x0105, B:44:0x010f, B:46:0x011e, B:48:0x0138, B:49:0x0155, B:51:0x015e, B:53:0x018f, B:99:0x0274, B:54:0x0192, B:56:0x019b, B:57:0x01b1, B:59:0x01ba, B:95:0x0257, B:80:0x0220, B:82:0x0226, B:85:0x0232, B:87:0x0238, B:90:0x0244, B:92:0x024a, B:65:0x01e8, B:52:0x0171), top: B:109:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e A[Catch: Exception -> 0x0270, TryCatch #0 {Exception -> 0x0270, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x0065, B:17:0x006e, B:62:0x01dc, B:20:0x0078, B:22:0x0082, B:23:0x008a, B:25:0x0093, B:32:0x00a5, B:36:0x00b4, B:71:0x01fc, B:74:0x0208, B:77:0x0214, B:39:0x00be, B:41:0x0105, B:44:0x010f, B:46:0x011e, B:48:0x0138, B:49:0x0155, B:51:0x015e, B:53:0x018f, B:99:0x0274, B:54:0x0192, B:56:0x019b, B:57:0x01b1, B:59:0x01ba, B:95:0x0257, B:80:0x0220, B:82:0x0226, B:85:0x0232, B:87:0x0238, B:90:0x0244, B:92:0x024a, B:65:0x01e8, B:52:0x0171), top: B:109:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f9  */
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
        int i4 = 0;
        int i5 = 1;
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
                        int i6 = optInt != 2 ? 1 : 0;
                        if (str3 != null && optInt == 1) {
                            i4 = !str3.equals(getString(R.string.des_page_home_recommend)) ? 1 : 2;
                        }
                        if (str2 != null) {
                            if (str2.contains("type=interaction")) {
                                i5 = 2;
                            } else if (str2.contains("type=recommend")) {
                                i5 = 3;
                            } else if (str2.contains("type=attention-bazhu")) {
                                i5 = 4;
                            } else if (str2.contains("type=attention-common")) {
                                i5 = 5;
                            }
                        }
                        aq ai = new aq(TbadkCoreStatisticKey.PUSH_CCLICK).ai("obj_type", 2).dD("task_id", str).dD(TiebaInitialize.Params.OBJ_TO, str2).ai("obj_source", i).ai("obj_locate", i2).ai("obj_param1", i6).ai(TiebaInitialize.Params.OBJ_PARAM2, i4).ai(TiebaInitialize.Params.OBJ_PARAM3, i5);
                        if (TextUtils.isEmpty(str2) && str2.contains("HotThreadList")) {
                            i3 = 6;
                        } else if (TextUtils.isEmpty(str2) && str2.contains("HotInteraction")) {
                            i3 = 7;
                        } else if (TextUtils.isEmpty(str2) && str2.contains("frs?kw=")) {
                            i3 = 7;
                        } else {
                            i3 = (TextUtils.isEmpty(str2) && str2.contains("collect")) ? 8 : i;
                        }
                        ai.ai("obj_source", i3);
                        TiebaStatic.log(ai);
                        if (!TextUtils.isEmpty(str2)) {
                            String str4 = str2 + "&from_yunpush=1";
                            if (Tc(str4)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(str4);
                                mainTabActivityConfig.setPushFollowUpAction(optInt);
                                mainTabActivityConfig.setPushDesPage(str3);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                            } else {
                                be.bju().b(getPageContext(), new String[]{str4, "yun_push_tag"});
                            }
                            if (str4.contains("ForumGradePage")) {
                                aq u = new aq("c13782").u("uid", TbadkCoreApplication.getCurrentAccountId());
                                try {
                                    Uri parse = Uri.parse(str4);
                                    String queryParameter = parse.getQueryParameter("forum_id");
                                    String queryParameter2 = parse.getQueryParameter("obj_type");
                                    u.dD("fid", queryParameter);
                                    u.dD("obj_type", queryParameter2);
                                } catch (Exception e) {
                                    BdLog.e(e);
                                }
                                TiebaStatic.log(u);
                            }
                            if (str4.contains("unidispatch/hotuserrank")) {
                                TiebaStatic.log(new aq("c13662").u("uid", TbadkCoreApplication.getCurrentAccountId()));
                            }
                            if (str4.contains("weeklygodview")) {
                                TiebaStatic.log(new aq("c13691").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_source", 2));
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
                        if (!str3.equals(getString(R.string.des_page_home_recommend))) {
                        }
                    }
                    if (str2 != null) {
                    }
                    aq ai2 = new aq(TbadkCoreStatisticKey.PUSH_CCLICK).ai("obj_type", 2).dD("task_id", str).dD(TiebaInitialize.Params.OBJ_TO, str2).ai("obj_source", i).ai("obj_locate", i2).ai("obj_param1", i6).ai(TiebaInitialize.Params.OBJ_PARAM2, i4).ai(TiebaInitialize.Params.OBJ_PARAM3, i5);
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                    ai2.ai("obj_source", i3);
                    TiebaStatic.log(ai2);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        finish();
    }

    private boolean Tc(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("flt://") || str.startsWith("bdtiebalive://") || str.startsWith("tiebachushou://") || str.contains("achievement=");
    }
}
