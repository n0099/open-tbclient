package com.baidu.tieba.person.more;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes3.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    private b fTL;
    private Bundle fTM;
    private e fTN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE) != null) {
            this.fTM = getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(d.i.person_center_more_layout);
        this.fTL = new b(getPageContext(), this.fTM, new ad<e>() { // from class: com.baidu.tieba.person.more.PersonCenterMoreActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, e eVar) {
                PersonCenterMoreActivity.this.fTN = eVar;
                if (PersonCenterMoreActivity.this.fTN != null && !PersonCenterMoreActivity.this.abu()) {
                    PersonCenterMoreActivity.this.rR(PersonCenterMoreActivity.this.fTN.adc);
                }
            }
        });
        this.fTL.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abu() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Aj();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(pageActivity);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i && iArr[0] == 0) {
            rR(this.fTN.adc);
        }
    }

    private void rQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(getPageContext().getPageActivity(), d.k.cosume_record_plugin_not_install_tip);
                    return;
                }
                az.zV().c(getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                rQ(str);
            } else if (str.startsWith("nohead:url")) {
                az.zV().c(getPageContext(), new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                az.zV().c(getPageContext(), new String[]{str});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fTL != null) {
            this.fTL.onChangeSkinType();
        }
    }
}
