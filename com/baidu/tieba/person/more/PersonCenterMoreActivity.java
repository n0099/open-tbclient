package com.baidu.tieba.person.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.o0.g2.j.b;
import d.a.o0.h2.e.h;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    public h mItemData;
    public b mMoreController;
    public b0 mOnCardSubClickListenner = new a();
    public Bundle mUrlBundle;

    /* loaded from: classes5.dex */
    public class a extends b0<h> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, h hVar) {
            PersonCenterMoreActivity.this.mItemData = hVar;
            if (PersonCenterMoreActivity.this.mItemData == null || PersonCenterMoreActivity.this.requestPermission()) {
                return;
            }
            PersonCenterMoreActivity personCenterMoreActivity = PersonCenterMoreActivity.this;
            personCenterMoreActivity.dealUrlMapClick(personCenterMoreActivity.mItemData.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealUrlMapClick(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            processPerosnWalletUrlClick(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, ""));
            sb.append(str.contains("?") ? "&" : "?");
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    private void processPerosnWalletUrlClick(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                l.L(getPageContext().getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            d.a.n0.l.a.s(getPageContext().getPageActivity(), true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestPermission() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        b bVar = this.mMoreController;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.mUrlBundle = intent.getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
        }
        setContentView(R.layout.person_center_more_layout);
        b bVar = new b(getPageContext(), this.mUrlBundle, this.mOnCardSubClickListenner);
        this.mMoreController = bVar;
        bVar.b();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i2 && iArr[0] == 0) {
            dealUrlMapClick(this.mItemData.k);
        }
    }
}
