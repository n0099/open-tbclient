package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.q0.s.y.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JUME_SCHEME = "jump_scheme";
    public static final String PUSH_BODY = "tbyunpushnotifybody=";
    public static final String SERVICE_ID = "service_id";
    public static final String TASK_ID = "task_id";
    public transient /* synthetic */ FieldHolder $fh;

    public YunPushProxyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean needToMainTab(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find() || str.startsWith(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=") : invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c A[Catch: Exception -> 0x027a, TryCatch #2 {Exception -> 0x027a, blocks: (B:5:0x0019, B:7:0x001f, B:9:0x0031, B:12:0x0048, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:25:0x0074, B:28:0x007d, B:36:0x0094, B:38:0x009c, B:40:0x00a2, B:42:0x00a8, B:54:0x00c0, B:60:0x00d3, B:73:0x00fc, B:75:0x016c, B:93:0x01a5, B:99:0x01ce, B:101:0x01d4, B:103:0x020a, B:106:0x0214, B:111:0x023e, B:110:0x023b, B:112:0x0241, B:114:0x0249, B:115:0x025b, B:117:0x0263, B:102:0x01f4, B:98:0x01cb, B:78:0x0176, B:80:0x017c, B:83:0x0186, B:85:0x018c, B:88:0x0195, B:90:0x019b, B:63:0x00dd, B:66:0x00e7, B:69:0x00f1, B:31:0x0087, B:107:0x0223, B:95:0x01b1), top: B:128:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8 A[Catch: Exception -> 0x027a, TryCatch #2 {Exception -> 0x027a, blocks: (B:5:0x0019, B:7:0x001f, B:9:0x0031, B:12:0x0048, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:25:0x0074, B:28:0x007d, B:36:0x0094, B:38:0x009c, B:40:0x00a2, B:42:0x00a8, B:54:0x00c0, B:60:0x00d3, B:73:0x00fc, B:75:0x016c, B:93:0x01a5, B:99:0x01ce, B:101:0x01d4, B:103:0x020a, B:106:0x0214, B:111:0x023e, B:110:0x023b, B:112:0x0241, B:114:0x0249, B:115:0x025b, B:117:0x0263, B:102:0x01f4, B:98:0x01cb, B:78:0x0176, B:80:0x017c, B:83:0x0186, B:85:0x018c, B:88:0x0195, B:90:0x019b, B:63:0x00dd, B:66:0x00e7, B:69:0x00f1, B:31:0x0087, B:107:0x0223, B:95:0x01b1), top: B:128:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d3 A[Catch: Exception -> 0x027a, TryCatch #2 {Exception -> 0x027a, blocks: (B:5:0x0019, B:7:0x001f, B:9:0x0031, B:12:0x0048, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:25:0x0074, B:28:0x007d, B:36:0x0094, B:38:0x009c, B:40:0x00a2, B:42:0x00a8, B:54:0x00c0, B:60:0x00d3, B:73:0x00fc, B:75:0x016c, B:93:0x01a5, B:99:0x01ce, B:101:0x01d4, B:103:0x020a, B:106:0x0214, B:111:0x023e, B:110:0x023b, B:112:0x0241, B:114:0x0249, B:115:0x025b, B:117:0x0263, B:102:0x01f4, B:98:0x01cb, B:78:0x0176, B:80:0x017c, B:83:0x0186, B:85:0x018c, B:88:0x0195, B:90:0x019b, B:63:0x00dd, B:66:0x00e7, B:69:0x00f1, B:31:0x0087, B:107:0x0223, B:95:0x01b1), top: B:128:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016c A[Catch: Exception -> 0x027a, TryCatch #2 {Exception -> 0x027a, blocks: (B:5:0x0019, B:7:0x001f, B:9:0x0031, B:12:0x0048, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:25:0x0074, B:28:0x007d, B:36:0x0094, B:38:0x009c, B:40:0x00a2, B:42:0x00a8, B:54:0x00c0, B:60:0x00d3, B:73:0x00fc, B:75:0x016c, B:93:0x01a5, B:99:0x01ce, B:101:0x01d4, B:103:0x020a, B:106:0x0214, B:111:0x023e, B:110:0x023b, B:112:0x0241, B:114:0x0249, B:115:0x025b, B:117:0x0263, B:102:0x01f4, B:98:0x01cb, B:78:0x0176, B:80:0x017c, B:83:0x0186, B:85:0x018c, B:88:0x0195, B:90:0x019b, B:63:0x00dd, B:66:0x00e7, B:69:0x00f1, B:31:0x0087, B:107:0x0223, B:95:0x01b1), top: B:128:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017c A[Catch: Exception -> 0x027a, TryCatch #2 {Exception -> 0x027a, blocks: (B:5:0x0019, B:7:0x001f, B:9:0x0031, B:12:0x0048, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:25:0x0074, B:28:0x007d, B:36:0x0094, B:38:0x009c, B:40:0x00a2, B:42:0x00a8, B:54:0x00c0, B:60:0x00d3, B:73:0x00fc, B:75:0x016c, B:93:0x01a5, B:99:0x01ce, B:101:0x01d4, B:103:0x020a, B:106:0x0214, B:111:0x023e, B:110:0x023b, B:112:0x0241, B:114:0x0249, B:115:0x025b, B:117:0x0263, B:102:0x01f4, B:98:0x01cb, B:78:0x0176, B:80:0x017c, B:83:0x0186, B:85:0x018c, B:88:0x0195, B:90:0x019b, B:63:0x00dd, B:66:0x00e7, B:69:0x00f1, B:31:0x0087, B:107:0x0223, B:95:0x01b1), top: B:128:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019b A[Catch: Exception -> 0x027a, TryCatch #2 {Exception -> 0x027a, blocks: (B:5:0x0019, B:7:0x001f, B:9:0x0031, B:12:0x0048, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:25:0x0074, B:28:0x007d, B:36:0x0094, B:38:0x009c, B:40:0x00a2, B:42:0x00a8, B:54:0x00c0, B:60:0x00d3, B:73:0x00fc, B:75:0x016c, B:93:0x01a5, B:99:0x01ce, B:101:0x01d4, B:103:0x020a, B:106:0x0214, B:111:0x023e, B:110:0x023b, B:112:0x0241, B:114:0x0249, B:115:0x025b, B:117:0x0263, B:102:0x01f4, B:98:0x01cb, B:78:0x0176, B:80:0x017c, B:83:0x0186, B:85:0x018c, B:88:0x0195, B:90:0x019b, B:63:0x00dd, B:66:0x00e7, B:69:0x00f1, B:31:0x0087, B:107:0x0223, B:95:0x01b1), top: B:128:0x0019, inners: #0, #1 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i2;
        String string;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    a.l(uri, false);
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
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                                StatisticItem param3 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                            StatisticItem param32 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
                        StatisticItem param322 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, string4).param("obj_source", i2).param("obj_locate", i5).param("obj_param1", i6).param(TiebaStatic.Params.OBJ_PARAM2, i3).param(TiebaStatic.Params.OBJ_PARAM3, i4).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
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
}
