package com.baidu.tieba.passaccount.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AuthVerifyData;
import com.baidu.tbadk.s.u;
import com.baidu.tieba.d;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.a.c;
/* loaded from: classes3.dex */
public class RemindActivity extends BaseActivity<RemindActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.remind_activity_layout);
        ((NavigationBar) findViewById(d.g.view_navigation_bar)).addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ((Button) findViewById(d.g.remind_button)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.passaccount.app.RemindActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.bHm().b(new c.a() { // from class: com.baidu.tieba.passaccount.app.RemindActivity.1.1
                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void d(boolean z, boolean z2, String str) {
                        b.bHf().s(z2, str);
                        RemindActivity.this.finishActivity(true);
                    }

                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void q(boolean z, String str) {
                        b.bHf().s(z, str);
                        RemindActivity.this.finishActivity(true);
                    }

                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void onUnavailable() {
                        b.bHf().s(false, null);
                    }

                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void onFail() {
                        b.bHf().s(false, null);
                    }
                });
            }
        });
        findViewById(d.g.feed_back_container).setVisibility(u.jK() ? 0 : 8);
        ((TextView) findViewById(d.g.feed_back_text)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.passaccount.app.RemindActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.passaccount.app.RemindActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ba.adD().a(RemindActivity.this.getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        finishActivity(false);
    }

    public void finishActivity(boolean z) {
        super.finish();
        if (!z) {
            b.bHf().a((AuthVerifyData.c) null);
        }
    }
}
