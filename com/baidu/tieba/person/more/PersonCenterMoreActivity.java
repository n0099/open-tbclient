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
    private b guQ;
    private Bundle guR;
    private f guS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE) != null) {
            this.guR = getIntent().getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(e.h.person_center_more_layout);
        this.guQ = new b(getPageContext(), this.guR, new ad<f>() { // from class: com.baidu.tieba.person.more.PersonCenterMoreActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, f fVar) {
                PersonCenterMoreActivity.this.guS = fVar;
                if (PersonCenterMoreActivity.this.guS != null && !PersonCenterMoreActivity.this.aiy()) {
                    PersonCenterMoreActivity.this.tR(PersonCenterMoreActivity.this.guS.aoW);
                }
            }
        });
        this.guQ.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiy() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.EG();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.B(pageActivity);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i && iArr[0] == 0) {
            tR(this.guS.aoW);
        }
    }

    private void tQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(getPageContext().getPageActivity(), e.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                ay.Es().c(getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tR(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                tQ(str);
            } else if (str.startsWith("nohead:url")) {
                ay.Es().c(getPageContext(), new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ay.Es().c(getPageContext(), new String[]{str});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.guQ != null) {
            this.guQ.onChangeSkinType();
        }
    }
}
