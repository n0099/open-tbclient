package com.baidu.tieba.person.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes24.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    private ab hbz = new ab<h>() { // from class: com.baidu.tieba.person.more.PersonCenterMoreActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.ab
        public void a(View view, h hVar) {
            PersonCenterMoreActivity.this.mjo = hVar;
            if (PersonCenterMoreActivity.this.mjo != null && !PersonCenterMoreActivity.this.cgQ()) {
                PersonCenterMoreActivity.this.QT(PersonCenterMoreActivity.this.mjo.aJj);
            }
        }
    };
    private b mjm;
    private Bundle mjn;
    private h mjo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.mjn = intent.getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(R.layout.person_center_more_layout);
        this.mjm = new b(getPageContext(), this.mjn, this.hbz);
        this.mjm.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgQ() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i && iArr[0] == 0) {
            QT(this.mjo.aJj);
        }
    }

    private void QS(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(getPageContext().getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                bf.bua().b(getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QT(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                QS(str);
            } else if (str.startsWith("nohead:url")) {
                bf.bua().b(getPageContext(), new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                bf.bua().b(getPageContext(), new String[]{str});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mjm != null) {
            this.mjm.onChangeSkinType();
        }
    }
}
