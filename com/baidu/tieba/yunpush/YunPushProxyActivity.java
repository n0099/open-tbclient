package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes21.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[Catch: Exception -> 0x029a, TryCatch #1 {Exception -> 0x029a, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0073, B:18:0x0079, B:20:0x0082, B:65:0x0206, B:23:0x008c, B:25:0x0096, B:26:0x009e, B:28:0x00a7, B:35:0x00b9, B:39:0x00c8, B:74:0x0226, B:77:0x0232, B:80:0x023e, B:42:0x00d2, B:44:0x012f, B:47:0x0139, B:49:0x0148, B:51:0x0162, B:52:0x017f, B:54:0x0188, B:56:0x01b9, B:102:0x029e, B:57:0x01bc, B:59:0x01c5, B:60:0x01db, B:62:0x01e4, B:98:0x0281, B:83:0x024a, B:85:0x0250, B:88:0x025c, B:90:0x0262, B:93:0x026e, B:95:0x0274, B:68:0x0212, B:55:0x019b), top: B:115:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7 A[Catch: Exception -> 0x029a, TryCatch #1 {Exception -> 0x029a, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0073, B:18:0x0079, B:20:0x0082, B:65:0x0206, B:23:0x008c, B:25:0x0096, B:26:0x009e, B:28:0x00a7, B:35:0x00b9, B:39:0x00c8, B:74:0x0226, B:77:0x0232, B:80:0x023e, B:42:0x00d2, B:44:0x012f, B:47:0x0139, B:49:0x0148, B:51:0x0162, B:52:0x017f, B:54:0x0188, B:56:0x01b9, B:102:0x029e, B:57:0x01bc, B:59:0x01c5, B:60:0x01db, B:62:0x01e4, B:98:0x0281, B:83:0x024a, B:85:0x0250, B:88:0x025c, B:90:0x0262, B:93:0x026e, B:95:0x0274, B:68:0x0212, B:55:0x019b), top: B:115:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8 A[Catch: Exception -> 0x029a, TryCatch #1 {Exception -> 0x029a, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0073, B:18:0x0079, B:20:0x0082, B:65:0x0206, B:23:0x008c, B:25:0x0096, B:26:0x009e, B:28:0x00a7, B:35:0x00b9, B:39:0x00c8, B:74:0x0226, B:77:0x0232, B:80:0x023e, B:42:0x00d2, B:44:0x012f, B:47:0x0139, B:49:0x0148, B:51:0x0162, B:52:0x017f, B:54:0x0188, B:56:0x01b9, B:102:0x029e, B:57:0x01bc, B:59:0x01c5, B:60:0x01db, B:62:0x01e4, B:98:0x0281, B:83:0x024a, B:85:0x0250, B:88:0x025c, B:90:0x0262, B:93:0x026e, B:95:0x0274, B:68:0x0212, B:55:0x019b), top: B:115:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0148 A[Catch: Exception -> 0x029a, TryCatch #1 {Exception -> 0x029a, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x001f, B:9:0x0043, B:10:0x004b, B:12:0x0057, B:13:0x005f, B:15:0x006b, B:16:0x0073, B:18:0x0079, B:20:0x0082, B:65:0x0206, B:23:0x008c, B:25:0x0096, B:26:0x009e, B:28:0x00a7, B:35:0x00b9, B:39:0x00c8, B:74:0x0226, B:77:0x0232, B:80:0x023e, B:42:0x00d2, B:44:0x012f, B:47:0x0139, B:49:0x0148, B:51:0x0162, B:52:0x017f, B:54:0x0188, B:56:0x01b9, B:102:0x029e, B:57:0x01bc, B:59:0x01c5, B:60:0x01db, B:62:0x01e4, B:98:0x0281, B:83:0x024a, B:85:0x0250, B:88:0x025c, B:90:0x0262, B:93:0x026e, B:95:0x0274, B:68:0x0212, B:55:0x019b), top: B:115:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0223  */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        int i;
        int optInt;
        String str4;
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
                    if (jSONObject.isNull(Constants.EXTRA_SERVICE)) {
                        str2 = "";
                    } else {
                        str2 = jSONObject.getString(Constants.EXTRA_SERVICE);
                    }
                    if (jSONObject.isNull("jump_scheme")) {
                        str3 = "";
                    } else {
                        str3 = jSONObject.getString("jump_scheme");
                    }
                    if (!StringUtils.isNull(str3)) {
                        if (str3.equals(UrlSchemaHelper.JUMP_TO_CHAT) || str3.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                            i = 1;
                        } else if (str3.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                            i = 2;
                        } else if (str3.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                            i = 3;
                        }
                        optInt = jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE)) {
                            str4 = null;
                        } else {
                            str4 = jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        }
                        if (optInt != 1) {
                            i2 = 2;
                        } else {
                            i2 = optInt == 2 ? 1 : 0;
                        }
                        int i6 = optInt != 2 ? 1 : 0;
                        if (str4 != null && optInt == 1) {
                            i4 = !str4.equals(getString(R.string.des_page_home_recommend)) ? 1 : 2;
                        }
                        if (str3 != null) {
                            if (str3.contains("type=interaction")) {
                                i5 = 2;
                            } else if (str3.contains("type=recommend")) {
                                i5 = 3;
                            } else if (str3.contains("type=attention-bazhu")) {
                                i5 = 4;
                            } else if (str3.contains("type=attention-common")) {
                                i5 = 5;
                            }
                        }
                        aq al = new aq(TbadkCoreStatisticKey.PUSH_CCLICK).al("obj_type", 2).dR("task_id", str).dR(Constants.EXTRA_SERVICE, str2).dR("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, str3).al("obj_source", i).al("obj_locate", i2).al("obj_param1", i6).al(TiebaInitialize.Params.OBJ_PARAM2, i4).al(TiebaInitialize.Params.OBJ_PARAM3, i5);
                        if (TextUtils.isEmpty(str3) && str3.contains("HotThreadList")) {
                            i3 = 6;
                        } else if (TextUtils.isEmpty(str3) && str3.contains("HotInteraction")) {
                            i3 = 7;
                        } else if (TextUtils.isEmpty(str3) && str3.contains("frs?kw=")) {
                            i3 = 7;
                        } else {
                            i3 = (TextUtils.isEmpty(str3) && str3.contains("collect")) ? 8 : i;
                        }
                        al.al("obj_source", i3);
                        TiebaStatic.log(al);
                        if (!TextUtils.isEmpty(str3)) {
                            String str5 = str3 + "&from_yunpush=1";
                            if (Vf(str5)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(str5);
                                mainTabActivityConfig.setPushFollowUpAction(optInt);
                                mainTabActivityConfig.setPushDesPage(str4);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                            } else {
                                be.brr().b(getPageContext(), new String[]{str5, "yun_push_tag"});
                            }
                            if (str5.contains("ForumGradePage")) {
                                aq w = new aq("c13782").w("uid", TbadkCoreApplication.getCurrentAccountId());
                                try {
                                    Uri parse = Uri.parse(str5);
                                    String queryParameter = parse.getQueryParameter("forum_id");
                                    String queryParameter2 = parse.getQueryParameter("obj_type");
                                    w.dR("fid", queryParameter);
                                    w.dR("obj_type", queryParameter2);
                                } catch (Exception e) {
                                    BdLog.e(e);
                                }
                                TiebaStatic.log(w);
                            }
                            if (str5.contains("unidispatch/hotuserrank")) {
                                TiebaStatic.log(new aq("c13662").w("uid", TbadkCoreApplication.getCurrentAccountId()));
                            }
                            if (str5.contains("weeklygodview")) {
                                TiebaStatic.log(new aq("c13691").w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_source", 2));
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
                    if (str4 != null) {
                        if (!str4.equals(getString(R.string.des_page_home_recommend))) {
                        }
                    }
                    if (str3 != null) {
                    }
                    aq al2 = new aq(TbadkCoreStatisticKey.PUSH_CCLICK).al("obj_type", 2).dR("task_id", str).dR(Constants.EXTRA_SERVICE, str2).dR("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, str3).al("obj_source", i).al("obj_locate", i2).al("obj_param1", i6).al(TiebaInitialize.Params.OBJ_PARAM2, i4).al(TiebaInitialize.Params.OBJ_PARAM3, i5);
                    if (TextUtils.isEmpty(str3)) {
                    }
                    if (TextUtils.isEmpty(str3)) {
                    }
                    if (TextUtils.isEmpty(str3)) {
                    }
                    if (TextUtils.isEmpty(str3)) {
                    }
                    al2.al("obj_source", i3);
                    TiebaStatic.log(al2);
                    if (!TextUtils.isEmpty(str3)) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        finish();
    }

    private boolean Vf(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail") || str.startsWith("flt://") || str.startsWith("bdtiebalive://") || str.startsWith("tiebachushou://") || str.contains("achievement=");
    }
}
