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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    private z eJh = new z<g>() { // from class: com.baidu.tieba.person.more.PersonCenterMoreActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.z
        public void a(View view, g gVar) {
            PersonCenterMoreActivity.this.jfB = gVar;
            if (PersonCenterMoreActivity.this.jfB != null && !PersonCenterMoreActivity.this.blA()) {
                PersonCenterMoreActivity.this.Go(PersonCenterMoreActivity.this.jfB.cHN);
            }
        }
    };
    private Bundle jfA;
    private g jfB;
    private b jfz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.jfA = intent.getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(R.layout.person_center_more_layout);
        this.jfz = new b(getPageContext(), this.jfA, this.eJh);
        this.jfz.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blA() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.startRequestPermission(pageActivity);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i && iArr[0] == 0) {
            Go(this.jfB.cHN);
        }
    }

    private void Gn(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(getPageContext().getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.aEt().b(getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Gn(str);
            } else if (str.startsWith("nohead:url")) {
                ba.aEt().b(getPageContext(), new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.aEt().b(getPageContext(), new String[]{str});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jfz != null) {
            this.jfz.onChangeSkinType();
        }
    }
}
