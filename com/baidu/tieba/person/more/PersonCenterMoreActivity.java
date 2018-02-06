package com.baidu.tieba.person.more;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes3.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    private b giK;
    private Bundle giL;
    private e giM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE) != null) {
            this.giL = getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(d.h.person_center_more_layout);
        this.giK = new b(getPageContext(), this.giL, new v<e>() { // from class: com.baidu.tieba.person.more.PersonCenterMoreActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, e eVar) {
                PersonCenterMoreActivity.this.giM = eVar;
                if (PersonCenterMoreActivity.this.giM != null && !PersonCenterMoreActivity.this.adh()) {
                    PersonCenterMoreActivity.this.qT(PersonCenterMoreActivity.this.giM.eco);
                }
            }
        });
        this.giK.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adh() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DI();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.v(pageActivity);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (25040 == i && iArr[0] == 0) {
            qT(this.giM.eco);
        }
    }

    private void qS(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(getPageContext().getPageActivity(), d.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                aw.Du().c(getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.b.b(getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                qS(str);
            } else if (str.startsWith("nohead:url")) {
                aw.Du().c(getPageContext(), new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                aw.Du().c(getPageContext(), new String[]{str});
            }
        }
    }
}
