package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.q0.r.a0.a;
import c.a.q0.r.a0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
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
/* loaded from: classes6.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:137:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[Catch: Exception -> 0x02d2, TryCatch #2 {Exception -> 0x02d2, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0035, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x005e, B:20:0x0064, B:21:0x0068, B:23:0x0070, B:25:0x0078, B:28:0x0081, B:36:0x0098, B:38:0x00a0, B:40:0x00a6, B:42:0x00ac, B:54:0x00c6, B:60:0x00da, B:74:0x010b, B:76:0x017b, B:94:0x01b4, B:100:0x01dd, B:102:0x01e7, B:103:0x01ef, B:105:0x01f5, B:107:0x022b, B:110:0x0235, B:115:0x025f, B:114:0x025c, B:116:0x0262, B:118:0x026a, B:119:0x027c, B:121:0x0284, B:122:0x029b, B:124:0x02a3, B:126:0x02c0, B:128:0x02c8, B:106:0x0215, B:99:0x01da, B:79:0x0185, B:81:0x018b, B:84:0x0195, B:86:0x019b, B:89:0x01a4, B:91:0x01aa, B:63:0x00e6, B:66:0x00f2, B:70:0x00fe, B:31:0x008b, B:111:0x0244, B:96:0x01c0), top: B:139:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ac A[Catch: Exception -> 0x02d2, TryCatch #2 {Exception -> 0x02d2, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0035, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x005e, B:20:0x0064, B:21:0x0068, B:23:0x0070, B:25:0x0078, B:28:0x0081, B:36:0x0098, B:38:0x00a0, B:40:0x00a6, B:42:0x00ac, B:54:0x00c6, B:60:0x00da, B:74:0x010b, B:76:0x017b, B:94:0x01b4, B:100:0x01dd, B:102:0x01e7, B:103:0x01ef, B:105:0x01f5, B:107:0x022b, B:110:0x0235, B:115:0x025f, B:114:0x025c, B:116:0x0262, B:118:0x026a, B:119:0x027c, B:121:0x0284, B:122:0x029b, B:124:0x02a3, B:126:0x02c0, B:128:0x02c8, B:106:0x0215, B:99:0x01da, B:79:0x0185, B:81:0x018b, B:84:0x0195, B:86:0x019b, B:89:0x01a4, B:91:0x01aa, B:63:0x00e6, B:66:0x00f2, B:70:0x00fe, B:31:0x008b, B:111:0x0244, B:96:0x01c0), top: B:139:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00da A[Catch: Exception -> 0x02d2, TryCatch #2 {Exception -> 0x02d2, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0035, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x005e, B:20:0x0064, B:21:0x0068, B:23:0x0070, B:25:0x0078, B:28:0x0081, B:36:0x0098, B:38:0x00a0, B:40:0x00a6, B:42:0x00ac, B:54:0x00c6, B:60:0x00da, B:74:0x010b, B:76:0x017b, B:94:0x01b4, B:100:0x01dd, B:102:0x01e7, B:103:0x01ef, B:105:0x01f5, B:107:0x022b, B:110:0x0235, B:115:0x025f, B:114:0x025c, B:116:0x0262, B:118:0x026a, B:119:0x027c, B:121:0x0284, B:122:0x029b, B:124:0x02a3, B:126:0x02c0, B:128:0x02c8, B:106:0x0215, B:99:0x01da, B:79:0x0185, B:81:0x018b, B:84:0x0195, B:86:0x019b, B:89:0x01a4, B:91:0x01aa, B:63:0x00e6, B:66:0x00f2, B:70:0x00fe, B:31:0x008b, B:111:0x0244, B:96:0x01c0), top: B:139:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017b A[Catch: Exception -> 0x02d2, TryCatch #2 {Exception -> 0x02d2, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0035, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x005e, B:20:0x0064, B:21:0x0068, B:23:0x0070, B:25:0x0078, B:28:0x0081, B:36:0x0098, B:38:0x00a0, B:40:0x00a6, B:42:0x00ac, B:54:0x00c6, B:60:0x00da, B:74:0x010b, B:76:0x017b, B:94:0x01b4, B:100:0x01dd, B:102:0x01e7, B:103:0x01ef, B:105:0x01f5, B:107:0x022b, B:110:0x0235, B:115:0x025f, B:114:0x025c, B:116:0x0262, B:118:0x026a, B:119:0x027c, B:121:0x0284, B:122:0x029b, B:124:0x02a3, B:126:0x02c0, B:128:0x02c8, B:106:0x0215, B:99:0x01da, B:79:0x0185, B:81:0x018b, B:84:0x0195, B:86:0x019b, B:89:0x01a4, B:91:0x01aa, B:63:0x00e6, B:66:0x00f2, B:70:0x00fe, B:31:0x008b, B:111:0x0244, B:96:0x01c0), top: B:139:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018b A[Catch: Exception -> 0x02d2, TryCatch #2 {Exception -> 0x02d2, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0035, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x005e, B:20:0x0064, B:21:0x0068, B:23:0x0070, B:25:0x0078, B:28:0x0081, B:36:0x0098, B:38:0x00a0, B:40:0x00a6, B:42:0x00ac, B:54:0x00c6, B:60:0x00da, B:74:0x010b, B:76:0x017b, B:94:0x01b4, B:100:0x01dd, B:102:0x01e7, B:103:0x01ef, B:105:0x01f5, B:107:0x022b, B:110:0x0235, B:115:0x025f, B:114:0x025c, B:116:0x0262, B:118:0x026a, B:119:0x027c, B:121:0x0284, B:122:0x029b, B:124:0x02a3, B:126:0x02c0, B:128:0x02c8, B:106:0x0215, B:99:0x01da, B:79:0x0185, B:81:0x018b, B:84:0x0195, B:86:0x019b, B:89:0x01a4, B:91:0x01aa, B:63:0x00e6, B:66:0x00f2, B:70:0x00fe, B:31:0x008b, B:111:0x0244, B:96:0x01c0), top: B:139:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01aa A[Catch: Exception -> 0x02d2, TryCatch #2 {Exception -> 0x02d2, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0035, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x005e, B:20:0x0064, B:21:0x0068, B:23:0x0070, B:25:0x0078, B:28:0x0081, B:36:0x0098, B:38:0x00a0, B:40:0x00a6, B:42:0x00ac, B:54:0x00c6, B:60:0x00da, B:74:0x010b, B:76:0x017b, B:94:0x01b4, B:100:0x01dd, B:102:0x01e7, B:103:0x01ef, B:105:0x01f5, B:107:0x022b, B:110:0x0235, B:115:0x025f, B:114:0x025c, B:116:0x0262, B:118:0x026a, B:119:0x027c, B:121:0x0284, B:122:0x029b, B:124:0x02a3, B:126:0x02c0, B:128:0x02c8, B:106:0x0215, B:99:0x01da, B:79:0x0185, B:81:0x018b, B:84:0x0195, B:86:0x019b, B:89:0x01a4, B:91:0x01aa, B:63:0x00e6, B:66:0x00f2, B:70:0x00fe, B:31:0x008b, B:111:0x0244, B:96:0x01c0), top: B:139:0x001d, inners: #0, #1 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i2;
        String string;
        int i3;
        String str;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    a.t(uri, false);
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
                                        str = "tid";
                                        i4 = 2;
                                    } else if (string4.contains("type=recommend")) {
                                        str = "tid";
                                        i4 = 3;
                                    } else {
                                        if (string4.contains("type=attention-bazhu")) {
                                            i4 = 4;
                                        } else {
                                            i4 = string4.contains("type=attention-common") ? 5 : 5;
                                        }
                                        str = "tid";
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
                                        if (b.a().d()) {
                                            b.a().i(2);
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
                                        if (string4.contains("unidispatch/pb")) {
                                            Uri parse2 = Uri.parse(string4);
                                            String queryParameter3 = parse2.getQueryParameter("obj_param1");
                                            String str2 = str;
                                            String queryParameter4 = parse2.getQueryParameter(str2);
                                            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
                                            if (BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter3) || "2".equals(queryParameter3)) {
                                                statisticItem.param("obj_source", 1);
                                                statisticItem.param(str2, queryParameter4);
                                                TiebaStatic.log(statisticItem);
                                            }
                                        }
                                    }
                                }
                                str = "tid";
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
                            str = "tid";
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
                        str = "tid";
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
