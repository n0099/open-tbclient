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
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.js4;
import com.repackage.ls4;
import com.repackage.lt7;
import com.repackage.mt7;
import com.repackage.um4;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YunPushProxyActivity extends BaseActivity<YunPushProxyActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JUME_SCHEME = "jump_scheme";
    public static final String PUSH_BODY = "tbyunpushnotifybody=";
    public static final String SERVICE_ID = "service_id";
    public static final String TASK_ID = "task_id";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isJumpPB;

    public YunPushProxyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isJumpPB = false;
    }

    private boolean needToMainTab(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (SchemeActionHelper.needMainTabActivity(str)) {
                return true;
            }
            if (!Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find()) {
                return str.startsWith(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TOPIC_DETAIL) || str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER) || str.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || str.contains("achievement=");
            }
            this.isJumpPB = true;
            return true;
        }
        return invokeL.booleanValue;
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

    /* JADX WARN: Removed duplicated region for block: B:105:0x01e4 A[Catch: Exception -> 0x0376, TryCatch #2 {Exception -> 0x0376, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:22:0x0075, B:25:0x007c, B:26:0x0092, B:28:0x0094, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:38:0x00b6, B:46:0x00cd, B:48:0x00d5, B:50:0x00db, B:52:0x00e1, B:67:0x00fe, B:73:0x0112, B:88:0x0147, B:90:0x01b5, B:108:0x01ee, B:114:0x0217, B:116:0x0221, B:117:0x0229, B:121:0x0238, B:123:0x023e, B:128:0x026d, B:127:0x026a, B:129:0x0271, B:131:0x027b, B:133:0x0285, B:135:0x0289, B:136:0x0299, B:138:0x02d4, B:140:0x02dc, B:145:0x0304, B:144:0x0301, B:146:0x0307, B:148:0x030f, B:149:0x0321, B:151:0x0329, B:152:0x0340, B:154:0x0348, B:156:0x0363, B:158:0x036b, B:137:0x02be, B:113:0x0214, B:93:0x01bf, B:95:0x01c5, B:98:0x01cf, B:100:0x01d5, B:103:0x01de, B:105:0x01e4, B:76:0x0120, B:79:0x012c, B:83:0x0138, B:41:0x00c0, B:141:0x02eb, B:124:0x024d, B:110:0x01fa), top: B:171:0x0020, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5 A[Catch: Exception -> 0x0376, TryCatch #2 {Exception -> 0x0376, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:22:0x0075, B:25:0x007c, B:26:0x0092, B:28:0x0094, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:38:0x00b6, B:46:0x00cd, B:48:0x00d5, B:50:0x00db, B:52:0x00e1, B:67:0x00fe, B:73:0x0112, B:88:0x0147, B:90:0x01b5, B:108:0x01ee, B:114:0x0217, B:116:0x0221, B:117:0x0229, B:121:0x0238, B:123:0x023e, B:128:0x026d, B:127:0x026a, B:129:0x0271, B:131:0x027b, B:133:0x0285, B:135:0x0289, B:136:0x0299, B:138:0x02d4, B:140:0x02dc, B:145:0x0304, B:144:0x0301, B:146:0x0307, B:148:0x030f, B:149:0x0321, B:151:0x0329, B:152:0x0340, B:154:0x0348, B:156:0x0363, B:158:0x036b, B:137:0x02be, B:113:0x0214, B:93:0x01bf, B:95:0x01c5, B:98:0x01cf, B:100:0x01d5, B:103:0x01de, B:105:0x01e4, B:76:0x0120, B:79:0x012c, B:83:0x0138, B:41:0x00c0, B:141:0x02eb, B:124:0x024d, B:110:0x01fa), top: B:171:0x0020, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1 A[Catch: Exception -> 0x0376, TryCatch #2 {Exception -> 0x0376, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:22:0x0075, B:25:0x007c, B:26:0x0092, B:28:0x0094, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:38:0x00b6, B:46:0x00cd, B:48:0x00d5, B:50:0x00db, B:52:0x00e1, B:67:0x00fe, B:73:0x0112, B:88:0x0147, B:90:0x01b5, B:108:0x01ee, B:114:0x0217, B:116:0x0221, B:117:0x0229, B:121:0x0238, B:123:0x023e, B:128:0x026d, B:127:0x026a, B:129:0x0271, B:131:0x027b, B:133:0x0285, B:135:0x0289, B:136:0x0299, B:138:0x02d4, B:140:0x02dc, B:145:0x0304, B:144:0x0301, B:146:0x0307, B:148:0x030f, B:149:0x0321, B:151:0x0329, B:152:0x0340, B:154:0x0348, B:156:0x0363, B:158:0x036b, B:137:0x02be, B:113:0x0214, B:93:0x01bf, B:95:0x01c5, B:98:0x01cf, B:100:0x01d5, B:103:0x01de, B:105:0x01e4, B:76:0x0120, B:79:0x012c, B:83:0x0138, B:41:0x00c0, B:141:0x02eb, B:124:0x024d, B:110:0x01fa), top: B:171:0x0020, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0112 A[Catch: Exception -> 0x0376, TryCatch #2 {Exception -> 0x0376, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:22:0x0075, B:25:0x007c, B:26:0x0092, B:28:0x0094, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:38:0x00b6, B:46:0x00cd, B:48:0x00d5, B:50:0x00db, B:52:0x00e1, B:67:0x00fe, B:73:0x0112, B:88:0x0147, B:90:0x01b5, B:108:0x01ee, B:114:0x0217, B:116:0x0221, B:117:0x0229, B:121:0x0238, B:123:0x023e, B:128:0x026d, B:127:0x026a, B:129:0x0271, B:131:0x027b, B:133:0x0285, B:135:0x0289, B:136:0x0299, B:138:0x02d4, B:140:0x02dc, B:145:0x0304, B:144:0x0301, B:146:0x0307, B:148:0x030f, B:149:0x0321, B:151:0x0329, B:152:0x0340, B:154:0x0348, B:156:0x0363, B:158:0x036b, B:137:0x02be, B:113:0x0214, B:93:0x01bf, B:95:0x01c5, B:98:0x01cf, B:100:0x01d5, B:103:0x01de, B:105:0x01e4, B:76:0x0120, B:79:0x012c, B:83:0x0138, B:41:0x00c0, B:141:0x02eb, B:124:0x024d, B:110:0x01fa), top: B:171:0x0020, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b5 A[Catch: Exception -> 0x0376, TryCatch #2 {Exception -> 0x0376, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:22:0x0075, B:25:0x007c, B:26:0x0092, B:28:0x0094, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:38:0x00b6, B:46:0x00cd, B:48:0x00d5, B:50:0x00db, B:52:0x00e1, B:67:0x00fe, B:73:0x0112, B:88:0x0147, B:90:0x01b5, B:108:0x01ee, B:114:0x0217, B:116:0x0221, B:117:0x0229, B:121:0x0238, B:123:0x023e, B:128:0x026d, B:127:0x026a, B:129:0x0271, B:131:0x027b, B:133:0x0285, B:135:0x0289, B:136:0x0299, B:138:0x02d4, B:140:0x02dc, B:145:0x0304, B:144:0x0301, B:146:0x0307, B:148:0x030f, B:149:0x0321, B:151:0x0329, B:152:0x0340, B:154:0x0348, B:156:0x0363, B:158:0x036b, B:137:0x02be, B:113:0x0214, B:93:0x01bf, B:95:0x01c5, B:98:0x01cf, B:100:0x01d5, B:103:0x01de, B:105:0x01e4, B:76:0x0120, B:79:0x012c, B:83:0x0138, B:41:0x00c0, B:141:0x02eb, B:124:0x024d, B:110:0x01fa), top: B:171:0x0020, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c5 A[Catch: Exception -> 0x0376, TryCatch #2 {Exception -> 0x0376, blocks: (B:5:0x0020, B:7:0x0026, B:9:0x0038, B:12:0x004f, B:14:0x0055, B:16:0x005b, B:18:0x0061, B:20:0x0067, B:22:0x0075, B:25:0x007c, B:26:0x0092, B:28:0x0094, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:38:0x00b6, B:46:0x00cd, B:48:0x00d5, B:50:0x00db, B:52:0x00e1, B:67:0x00fe, B:73:0x0112, B:88:0x0147, B:90:0x01b5, B:108:0x01ee, B:114:0x0217, B:116:0x0221, B:117:0x0229, B:121:0x0238, B:123:0x023e, B:128:0x026d, B:127:0x026a, B:129:0x0271, B:131:0x027b, B:133:0x0285, B:135:0x0289, B:136:0x0299, B:138:0x02d4, B:140:0x02dc, B:145:0x0304, B:144:0x0301, B:146:0x0307, B:148:0x030f, B:149:0x0321, B:151:0x0329, B:152:0x0340, B:154:0x0348, B:156:0x0363, B:158:0x036b, B:137:0x02be, B:113:0x0214, B:93:0x01bf, B:95:0x01c5, B:98:0x01cf, B:100:0x01d5, B:103:0x01de, B:105:0x01e4, B:76:0x0120, B:79:0x012c, B:83:0x0138, B:41:0x00c0, B:141:0x02eb, B:124:0x024d, B:110:0x01fa), top: B:171:0x0020, inners: #0, #1, #3 }] */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i;
        int optInt;
        String string;
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            js4.u(this);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String uri = intent.getData().toString();
                    js4.t(uri, false);
                    if (uri.contains(PUSH_BODY)) {
                        JSONObject jSONObject = new JSONObject(uri.substring(uri.indexOf(PUSH_BODY) + 20));
                        String str2 = "";
                        String string2 = !jSONObject.isNull("task_id") ? jSONObject.getString("task_id") : "";
                        String string3 = !jSONObject.isNull("service_id") ? jSONObject.getString("service_id") : "";
                        if (!jSONObject.isNull(JUME_SCHEME)) {
                            String string4 = jSONObject.getString(JUME_SCHEME);
                            if (!Uri.parse(string4).isOpaque()) {
                                str2 = string4;
                            } else if (um4.e()) {
                                throw new IllegalStateException(string4 + "：scheme 格式非法");
                            }
                        }
                        if (!StringUtils.isNull(str2)) {
                            if (!str2.equals(UrlSchemaHelper.JUMP_TO_CHAT) && !str2.equals(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT) && !str2.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                if (str2.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                                    i = 2;
                                } else if (str2.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                                    i = 3;
                                }
                                optInt = !jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) ? jSONObject.optInt(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION) : 0;
                                string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                                if (optInt == 1) {
                                    i3 = 2;
                                    i2 = 2;
                                } else {
                                    i2 = 2;
                                    i3 = optInt == 2 ? 1 : 0;
                                }
                                int i7 = optInt == i2 ? 1 : 0;
                                if (string == null && optInt == 1) {
                                    i4 = string.equals(getString(R.string.obfuscated_res_0x7f0f04bd)) ? 1 : 2;
                                } else {
                                    i4 = 0;
                                }
                                if (str2 != null) {
                                    str = string;
                                    if (str2.contains("type=interaction")) {
                                        i5 = optInt;
                                        i6 = 2;
                                    } else if (str2.contains("type=recommend")) {
                                        i5 = optInt;
                                        i6 = 3;
                                    } else {
                                        if (str2.contains("type=attention-bazhu")) {
                                            i6 = 4;
                                        } else {
                                            i6 = str2.contains("type=attention-common") ? 5 : 5;
                                        }
                                        i5 = optInt;
                                    }
                                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                    if (TextUtils.isEmpty(str2) && str2.contains("HotThreadList")) {
                                        i = 6;
                                    } else {
                                        if ((!TextUtils.isEmpty(str2) || !str2.contains("HotInteraction")) && (TextUtils.isEmpty(str2) || !str2.contains("frs?kw="))) {
                                            if (!TextUtils.isEmpty(str2) && str2.contains("collect")) {
                                                i = 8;
                                            }
                                        }
                                        i = 7;
                                    }
                                    param.param("obj_source", i);
                                    TiebaStatic.log(param);
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            str2 = Uri.parse(str2).buildUpon().appendQueryParameter("from_yunpush", "1").build().toString();
                                        } catch (Exception e) {
                                            BdLog.e(e);
                                        }
                                        if (ls4.a().d()) {
                                            ls4.a().i(2);
                                        }
                                        if (needToMainTab(str2)) {
                                            int i8 = -1;
                                            if (str2.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                                                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MSG_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                try {
                                                    Uri parse = Uri.parse(str2);
                                                    String queryParameter = parse.getQueryParameter("fid");
                                                    String queryParameter2 = parse.getQueryParameter("tid");
                                                    String queryParameter3 = parse.getQueryParameter("pid");
                                                    param2.param("fid", queryParameter);
                                                    param2.param("pid", queryParameter3);
                                                    param2.param("tid", queryParameter2);
                                                } catch (Exception e2) {
                                                    BdLog.e(e2);
                                                }
                                                TiebaStatic.log(param2);
                                                i8 = 3;
                                            }
                                            if (ls4.a().d() && lt7.a().e() && this.isJumpPB) {
                                                lt7.a().g(true);
                                                mt7.n(new String[]{str2});
                                            }
                                            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                            mainTabActivityConfig.setTargetScheme(str2);
                                            mainTabActivityConfig.setPushFollowUpAction(i5);
                                            mainTabActivityConfig.setPushDesPage(str);
                                            mainTabActivityConfig.setBottomTab(i8);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                        } else {
                                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str2, UrlManager.YUN_PUSH_TAG});
                                        }
                                        if (str2.contains("ForumGradePage")) {
                                            StatisticItem param3 = new StatisticItem("c13782").param("uid", TbadkCoreApplication.getCurrentAccountId());
                                            try {
                                                Uri parse2 = Uri.parse(str2);
                                                String queryParameter4 = parse2.getQueryParameter("forum_id");
                                                String queryParameter5 = parse2.getQueryParameter("obj_type");
                                                param3.param("fid", queryParameter4);
                                                param3.param("obj_type", queryParameter5);
                                            } catch (Exception e3) {
                                                BdLog.e(e3);
                                            }
                                            TiebaStatic.log(param3);
                                        }
                                        if (str2.contains("unidispatch/hotuserrank")) {
                                            TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                                        }
                                        if (str2.contains("weeklygodview")) {
                                            TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 2));
                                        }
                                        if (str2.contains(PbModel.UNIDISPATCH_PB)) {
                                            Uri parse3 = Uri.parse(str2);
                                            String queryParameter6 = parse3.getQueryParameter("obj_param1");
                                            String queryParameter7 = parse3.getQueryParameter("tid");
                                            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
                                            if (BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter6) || "2".equals(queryParameter6)) {
                                                statisticItem.param("obj_source", 1);
                                                statisticItem.param("tid", queryParameter7);
                                                TiebaStatic.log(statisticItem);
                                            }
                                        }
                                    }
                                } else {
                                    str = string;
                                }
                                i5 = optInt;
                                i6 = 1;
                                StatisticItem param4 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                                if (TextUtils.isEmpty(str2)) {
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    i = 8;
                                }
                                param4.param("obj_source", i);
                                TiebaStatic.log(param4);
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                            i = 1;
                            if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                            }
                            string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                            if (optInt == 1) {
                            }
                            if (optInt == i2) {
                            }
                            if (string == null) {
                            }
                            i4 = 0;
                            if (str2 != null) {
                            }
                            i5 = optInt;
                            i6 = 1;
                            StatisticItem param42 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                            if (TextUtils.isEmpty(str2)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            param42.param("obj_source", i);
                            TiebaStatic.log(param42);
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                        i = 0;
                        if (!jSONObject.isNull(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION)) {
                        }
                        string = jSONObject.isNull(MainTabActivityConfig.PUSH_DES_PAGE) ? null : jSONObject.getString(MainTabActivityConfig.PUSH_DES_PAGE);
                        if (optInt == 1) {
                        }
                        if (optInt == i2) {
                        }
                        if (string == null) {
                        }
                        i4 = 0;
                        if (str2 != null) {
                        }
                        i5 = optInt;
                        i6 = 1;
                        StatisticItem param422 = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("obj_type", 2).param("task_id", string2).param("service_id", string3).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, str2).param("obj_source", i).param("obj_locate", i3).param("obj_param1", i7).param(TiebaStatic.Params.OBJ_PARAM2, i4).param(TiebaStatic.Params.OBJ_PARAM3, i6).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        param422.param("obj_source", i);
                        TiebaStatic.log(param422);
                        if (!TextUtils.isEmpty(str2)) {
                        }
                    }
                }
            } catch (Exception e4) {
                BdLog.e(e4);
            }
            finish();
        }
    }
}
