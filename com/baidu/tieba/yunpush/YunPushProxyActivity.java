package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    public static final String JUME_SCHEME = "jump_scheme";
    public static final String PUSH_BODY = "tbyunpushnotifybody=";
    public static final String SERVICE_ID = "service_id";
    public static final String TASK_ID = "task_id";

    private boolean needToMainTab(String str) {
        return Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.contains("achievement=");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[Catch: Exception -> 0x0265, TryCatch #1 {Exception -> 0x0265, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0029, B:10:0x0040, B:12:0x0046, B:14:0x004c, B:16:0x0052, B:18:0x0058, B:19:0x005c, B:21:0x0064, B:23:0x006c, B:26:0x0075, B:34:0x008c, B:36:0x0094, B:38:0x009a, B:40:0x00a0, B:52:0x00b8, B:58:0x00cb, B:71:0x00f4, B:73:0x0156, B:91:0x018f, B:97:0x01b8, B:99:0x01be, B:101:0x01f5, B:104:0x01ff, B:109:0x0229, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:113:0x0246, B:115:0x024e, B:100:0x01de, B:96:0x01b5, B:76:0x0160, B:78:0x0166, B:81:0x0170, B:83:0x0176, B:86:0x017f, B:88:0x0185, B:61:0x00d5, B:64:0x00df, B:67:0x00e9, B:29:0x007f, B:105:0x020e, B:93:0x019b), top: B:121:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0 A[Catch: Exception -> 0x0265, TryCatch #1 {Exception -> 0x0265, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0029, B:10:0x0040, B:12:0x0046, B:14:0x004c, B:16:0x0052, B:18:0x0058, B:19:0x005c, B:21:0x0064, B:23:0x006c, B:26:0x0075, B:34:0x008c, B:36:0x0094, B:38:0x009a, B:40:0x00a0, B:52:0x00b8, B:58:0x00cb, B:71:0x00f4, B:73:0x0156, B:91:0x018f, B:97:0x01b8, B:99:0x01be, B:101:0x01f5, B:104:0x01ff, B:109:0x0229, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:113:0x0246, B:115:0x024e, B:100:0x01de, B:96:0x01b5, B:76:0x0160, B:78:0x0166, B:81:0x0170, B:83:0x0176, B:86:0x017f, B:88:0x0185, B:61:0x00d5, B:64:0x00df, B:67:0x00e9, B:29:0x007f, B:105:0x020e, B:93:0x019b), top: B:121:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb A[Catch: Exception -> 0x0265, TryCatch #1 {Exception -> 0x0265, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0029, B:10:0x0040, B:12:0x0046, B:14:0x004c, B:16:0x0052, B:18:0x0058, B:19:0x005c, B:21:0x0064, B:23:0x006c, B:26:0x0075, B:34:0x008c, B:36:0x0094, B:38:0x009a, B:40:0x00a0, B:52:0x00b8, B:58:0x00cb, B:71:0x00f4, B:73:0x0156, B:91:0x018f, B:97:0x01b8, B:99:0x01be, B:101:0x01f5, B:104:0x01ff, B:109:0x0229, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:113:0x0246, B:115:0x024e, B:100:0x01de, B:96:0x01b5, B:76:0x0160, B:78:0x0166, B:81:0x0170, B:83:0x0176, B:86:0x017f, B:88:0x0185, B:61:0x00d5, B:64:0x00df, B:67:0x00e9, B:29:0x007f, B:105:0x020e, B:93:0x019b), top: B:121:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0156 A[Catch: Exception -> 0x0265, TryCatch #1 {Exception -> 0x0265, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0029, B:10:0x0040, B:12:0x0046, B:14:0x004c, B:16:0x0052, B:18:0x0058, B:19:0x005c, B:21:0x0064, B:23:0x006c, B:26:0x0075, B:34:0x008c, B:36:0x0094, B:38:0x009a, B:40:0x00a0, B:52:0x00b8, B:58:0x00cb, B:71:0x00f4, B:73:0x0156, B:91:0x018f, B:97:0x01b8, B:99:0x01be, B:101:0x01f5, B:104:0x01ff, B:109:0x0229, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:113:0x0246, B:115:0x024e, B:100:0x01de, B:96:0x01b5, B:76:0x0160, B:78:0x0166, B:81:0x0170, B:83:0x0176, B:86:0x017f, B:88:0x0185, B:61:0x00d5, B:64:0x00df, B:67:0x00e9, B:29:0x007f, B:105:0x020e, B:93:0x019b), top: B:121:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0166 A[Catch: Exception -> 0x0265, TryCatch #1 {Exception -> 0x0265, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0029, B:10:0x0040, B:12:0x0046, B:14:0x004c, B:16:0x0052, B:18:0x0058, B:19:0x005c, B:21:0x0064, B:23:0x006c, B:26:0x0075, B:34:0x008c, B:36:0x0094, B:38:0x009a, B:40:0x00a0, B:52:0x00b8, B:58:0x00cb, B:71:0x00f4, B:73:0x0156, B:91:0x018f, B:97:0x01b8, B:99:0x01be, B:101:0x01f5, B:104:0x01ff, B:109:0x0229, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:113:0x0246, B:115:0x024e, B:100:0x01de, B:96:0x01b5, B:76:0x0160, B:78:0x0166, B:81:0x0170, B:83:0x0176, B:86:0x017f, B:88:0x0185, B:61:0x00d5, B:64:0x00df, B:67:0x00e9, B:29:0x007f, B:105:0x020e, B:93:0x019b), top: B:121:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0185 A[Catch: Exception -> 0x0265, TryCatch #1 {Exception -> 0x0265, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0029, B:10:0x0040, B:12:0x0046, B:14:0x004c, B:16:0x0052, B:18:0x0058, B:19:0x005c, B:21:0x0064, B:23:0x006c, B:26:0x0075, B:34:0x008c, B:36:0x0094, B:38:0x009a, B:40:0x00a0, B:52:0x00b8, B:58:0x00cb, B:71:0x00f4, B:73:0x0156, B:91:0x018f, B:97:0x01b8, B:99:0x01be, B:101:0x01f5, B:104:0x01ff, B:109:0x0229, B:108:0x0226, B:110:0x022c, B:112:0x0234, B:113:0x0246, B:115:0x024e, B:100:0x01de, B:96:0x01b5, B:76:0x0160, B:78:0x0166, B:81:0x0170, B:83:0x0176, B:86:0x017f, B:88:0x0185, B:61:0x00d5, B:64:0x00df, B:67:0x00e9, B:29:0x007f, B:105:0x020e, B:93:0x019b), top: B:121:0x0015, inners: #0, #2 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i2;
        String string;
        int i3;
        int i4;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String uri = intent.getData().toString();
                if (uri.contains(PUSH_BODY)) {
                    JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf(PUSH_BODY) + 20));
                    String string2 = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                    String string3 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                    String string4 = jSONObject.isNull(JUME_SCHEME) ? "" : jSONObject.getString(JUME_SCHEME);
                    if (!StringUtils.isNull(string4)) {
                        if (!string4.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !string4.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                            if (string4.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                i2 = 2;
                            } else if (string4.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                i2 = 3;
                            }
                            int optInt = !jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                            string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                            int i5 = optInt == 1 ? 2 : optInt == 2 ? 1 : 0;
                            int i6 = optInt == 2 ? 1 : 0;
                            if (string == null && optInt == 1) {
                                i3 = string.equals(getString(R.string.des_page_home_recommend)) ? 1 : 2;
                            } else {
                                i3 = 0;
                            }
                            if (string4 != null) {
                                if (string4.contains("type=interaction")) {
                                    i4 = 2;
                                } else if (string4.contains("type=recommend")) {
                                    i4 = 3;
                                } else if (string4.contains("type=attention-bazhu")) {
                                    i4 = 4;
                                } else if (string4.contains("type=attention-common")) {
                                    i4 = 5;
                                }
                                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(string4) && string4.contains("HotThreadList")) {
                                    i2 = 6;
                                } else {
                                    if ((!TextUtils.isEmpty(string4) || !string4.contains("HotInteraction")) && (TextUtils.isEmpty(string4) || !string4.contains("frs?kw="))) {
                                        if (!TextUtils.isEmpty(string4) && string4.contains("collect")) {
                                            i2 = 8;
                                        }
                                    }
                                    i2 = 7;
                                }
                                param.param("obj_source", i2);
                                TiebaStatic.log(param);
                                if (!TextUtils.isEmpty(string4)) {
                                    try {
                                        string4 = Uri.parse(string4).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                    } catch (Exception e2) {
                                        BdLog.e(e2);
                                    }
                                    if (needToMainTab(string4)) {
                                        MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                        mainTabActivityConfig.setTargetScheme(string4);
                                        mainTabActivityConfig.setPushFollowUpAction(optInt);
                                        mainTabActivityConfig.setPushDesPage(string);
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                    } else {
                                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{string4, UrlManager.YUN_PUSH_TAG});
                                    }
                                    if (string4.contains("ForumGradePage")) {
                                        StatisticItem param2 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        try {
                                            Uri parse = Uri.parse(string4);
                                            String queryParameter = parse.getQueryParameter("forum_id");
                                            String queryParameter2 = parse.getQueryParameter("obj_type");
                                            param2.param("fid", queryParameter);
                                            param2.param("obj_type", queryParameter2);
                                        } catch (Exception e3) {
                                            BdLog.e(e3);
                                        }
                                        TiebaStatic.log(param2);
                                    }
                                    if (string4.contains("unidispatch/hotuserrank")) {
                                        TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                    }
                                    if (string4.contains("weeklygodview")) {
                                        TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                    }
                                }
                            }
                            i4 = 1;
                            StatisticItem param3 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(string4)) {
                            }
                            if (!TextUtils.isEmpty(string4)) {
                            }
                            if (!TextUtils.isEmpty(string4)) {
                                i2 = 8;
                            }
                            param3.param("obj_source", i2);
                            TiebaStatic.log(param3);
                            if (!TextUtils.isEmpty(string4)) {
                            }
                        }
                        i2 = 1;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        if (optInt == 1) {
                        }
                        if (optInt == 2) {
                        }
                        if (string == null) {
                        }
                        i3 = 0;
                        if (string4 != null) {
                        }
                        i4 = 1;
                        StatisticItem param32 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(string4)) {
                        }
                        if (!TextUtils.isEmpty(string4)) {
                        }
                        if (!TextUtils.isEmpty(string4)) {
                        }
                        param32.param("obj_source", i2);
                        TiebaStatic.log(param32);
                        if (!TextUtils.isEmpty(string4)) {
                        }
                    }
                    i2 = 0;
                    if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                    }
                    string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                    if (optInt == 1) {
                    }
                    if (optInt == 2) {
                    }
                    if (string == null) {
                    }
                    i3 = 0;
                    if (string4 != null) {
                    }
                    i4 = 1;
                    StatisticItem param322 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                    if (TextUtils.isEmpty(string4)) {
                    }
                    if (!TextUtils.isEmpty(string4)) {
                    }
                    if (!TextUtils.isEmpty(string4)) {
                    }
                    param322.param("obj_source", i2);
                    TiebaStatic.log(param322);
                    if (!TextUtils.isEmpty(string4)) {
                    }
                }
            }
        } catch (Exception unused) {
        }
        finish();
    }
}
