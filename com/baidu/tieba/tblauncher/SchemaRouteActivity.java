package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.util.bc;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class SchemaRouteActivity extends BaseActivity {
    private final f.a hBk = new f.a() { // from class: com.baidu.tieba.tblauncher.SchemaRouteActivity.1
        @Override // com.baidu.tbadk.BdToken.f.a
        public void C(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.PARAM_URL) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(SchemaRouteActivity.this.getActivity(), null, (String) hashMap.get(com.baidu.tbadk.BdToken.f.PARAM_URL), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
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
            B(intent.getData());
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!TextUtils.isEmpty(dataString) && (dataString.contains("invoke_frs") || dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
                frsActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig));
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                f.D(intent.getData());
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains("unidispatch/pb"))) {
                if ("tbpb://tieba.baidu.com".equals(dataString)) {
                    if (!com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig((Context) getActivity(), false)));
                        return;
                    }
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
                pbActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                f.C(intent.getData());
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
                Uri data = intent.getData();
                if (com.baidu.tbadk.BdToken.f.p(data)) {
                    com.baidu.tbadk.BdToken.f.aMH().d(data, this.hBk);
                } else {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                    tbWebViewActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                }
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
                TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
                topicDetailActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, topicDetailActivityConfig));
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                f.E(intent.getData());
            } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
                PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
                personPolymericActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig));
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                f.F(intent.getData());
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumsquare")) {
                ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
                forumSquareActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSquareActivityConfig));
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
                hotUserRankActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/openapp")) {
                if (!com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig((Context) getActivity(), false)));
                }
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains(com.baidu.tbadk.BdToken.f.HOST + com.baidu.tbadk.BdToken.f.dzY)) {
                Uri parse = Uri.parse(dataString);
                bc.aWU().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + parse.getQueryParameter(com.baidu.tbadk.BdToken.f.dAr) + "&livetype=" + parse.getQueryParameter(com.baidu.tbadk.BdToken.f.dAq)});
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/onekeysign")) {
                if (TbadkCoreApplication.isLogin()) {
                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(getPageContext().getPageActivity());
                    signAllForumActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, signAllForumActivityConfig));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this).createNormalCfg(1)));
                }
                com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                f.G(intent.getData());
            }
        }
    }

    private void B(Uri uri) {
        if (uri != null && com.baidu.tbadk.BdToken.f.p(uri)) {
            String queryParameter = uri.getQueryParameter("obj_locate");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("mdp")) {
                UtilHelper.clearClipBoard();
            }
        }
    }
}
