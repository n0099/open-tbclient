package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.BdToken.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.tbadkCore.data.m;
import java.util.HashMap;
/* loaded from: classes.dex */
public class SchemaRouteActivity extends BaseActivity {
    private final f.a jic = new f.a() { // from class: com.baidu.tieba.tblauncher.SchemaRouteActivity.1
        @Override // com.baidu.tbadk.BdToken.f.a
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(f.PARAM_URL) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(SchemaRouteActivity.this.getActivity(), null, (String) hashMap.get(f.PARAM_URL), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                tbWebViewActivityConfig.setUri((Uri) hashMap.get(f.eEe));
                SchemaRouteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        al(getIntent());
        finish();
    }

    private void al(Intent intent) {
        if (intent != null) {
            H(intent.getData());
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            v.v(intent.getData());
            v.u(intent.getData());
            if (!TextUtils.isEmpty(dataString) && (dataString.contains("invoke_frs") || dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
                frsActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig));
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains("unidispatch/pb"))) {
                if ("tbpb://tieba.baidu.com".equals(dataString)) {
                    if (!com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig((Context) getActivity(), false)));
                        return;
                    }
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
                pbActivityConfig.setUri(intent.getData());
                if (dataString.contains("isLocateToComment") && dataString.contains("isLocateToComment=1")) {
                    pbActivityConfig.setJumpToCommentArea(true);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
                Uri data = intent.getData();
                if (f.r(data)) {
                    f.bhH().a(dataString, data, this.jic);
                } else {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                    tbWebViewActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                }
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
                TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
                topicDetailActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, topicDetailActivityConfig));
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
                PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
                personPolymericActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig));
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumsquare")) {
                ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
                forumSquareActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSquareActivityConfig));
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
                hotUserRankActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("unidispatch/openapp") || dataString.contains("donothing"))) {
                if (!com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig((Context) getActivity(), false)));
                }
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains(f.HOST + f.eDE)) {
                Uri parse = Uri.parse(dataString);
                bf.bsV().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + parse.getQueryParameter(f.eEb) + "&livetype=" + parse.getQueryParameter(f.eEa)});
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/onekeysign")) {
                if (TbadkCoreApplication.isLogin()) {
                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(getPageContext().getPageActivity());
                    signAllForumActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, signAllForumActivityConfig));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this).createNormalCfg(1)));
                }
                com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
            } else {
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumRuleDetail")) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(f.eEf), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/item")) {
                    String queryParameter = Uri.parse(dataString).getQueryParameter(f.eEg);
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(queryParameter));
                    sendMessage(new CustomMessage(2002015, new m(this, "GameItemDetailsPage", hashMap)));
                }
            }
        }
    }

    private void H(Uri uri) {
        if (uri != null && f.r(uri)) {
            String queryParameter = uri.getQueryParameter("obj_locate");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("mdp")) {
                UtilHelper.clearClipBoard();
            }
        }
    }
}
