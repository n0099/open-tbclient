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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    private b gkf;
    private Bundle gkg;
    private f gkh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE) != null) {
            this.gkg = getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(e.h.person_center_more_layout);
        this.gkf = new b(getPageContext(), this.gkg, new ad<f>() { // from class: com.baidu.tieba.person.more.PersonCenterMoreActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, f fVar) {
                PersonCenterMoreActivity.this.gkh = fVar;
                if (PersonCenterMoreActivity.this.gkh != null && !PersonCenterMoreActivity.this.agD()) {
                    PersonCenterMoreActivity.this.sW(PersonCenterMoreActivity.this.gkh.akS);
                }
            }
        });
        this.gkf.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agD() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Dp();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.A(pageActivity);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i && iArr[0] == 0) {
            sW(this.gkh.akS);
        }
    }

    private void sV(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(getPageContext().getPageActivity(), e.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                ay.Db().c(getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                sV(str);
            } else if (str.startsWith("nohead:url")) {
                ay.Db().c(getPageContext(), new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ay.Db().c(getPageContext(), new String[]{str});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gkf != null) {
            this.gkf.onChangeSkinType();
        }
    }
}
