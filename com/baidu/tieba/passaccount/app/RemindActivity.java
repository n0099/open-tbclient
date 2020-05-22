package com.baidu.tieba.passaccount.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.switchs.FaceFeedbackEnableSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.a.c;
/* loaded from: classes8.dex */
public class RemindActivity extends BaseActivity<RemindActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remind_activity_layout);
        ((NavigationBar) findViewById(R.id.view_navigation_bar)).addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ((Button) findViewById(R.id.remind_button)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.passaccount.app.RemindActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.cBq().b(new c.a() { // from class: com.baidu.tieba.passaccount.app.RemindActivity.1.1
                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void d(boolean z, boolean z2, String str) {
                        b.cBk().u(z2, str);
                        RemindActivity.this.finishActivity(true);
                    }

                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void s(boolean z, String str) {
                        b.cBk().u(z, str);
                        RemindActivity.this.finishActivity(true);
                    }

                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void cAY() {
                        b.cBk().u(false, null);
                    }

                    @Override // com.baidu.tieba.passaccount.a.c.a
                    public void onFail() {
                        b.cBk().u(false, null);
                    }
                });
            }
        });
        findViewById(R.id.feed_back_container).setVisibility(FaceFeedbackEnableSwitch.isOn() ? 0 : 8);
        ((TextView) findViewById(R.id.feed_back_text)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.passaccount.app.RemindActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.passaccount.app.RemindActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ba.aUZ().a(RemindActivity.this.getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
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
            b.cBk().a((i.c) null);
        }
    }
}
