package com.baidu.tieba.passaccount.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.switchs.FaceFeedbackEnableSwitch;
import com.baidu.tieba.R;
import d.b.i0.a2.d.c;
/* loaded from: classes4.dex */
public class RemindActivity extends BaseActivity<RemindActivity> {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.tieba.passaccount.app.RemindActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0208a implements c.e {
            public C0208a() {
            }

            @Override // d.b.i0.a2.d.c.e
            public void a(boolean z, boolean z2, String str) {
                d.b.i0.a2.d.b.f().d(z2, str);
                RemindActivity.this.finishActivity(true);
            }

            @Override // d.b.i0.a2.d.c.e
            public void b(boolean z, String str) {
                d.b.i0.a2.d.b.f().d(z, str);
                RemindActivity.this.finishActivity(true);
            }

            @Override // d.b.i0.a2.d.c.e
            public void c() {
                d.b.i0.a2.d.b.f().d(false, null);
            }

            @Override // d.b.i0.a2.d.c.e
            public void onFail() {
                d.b.i0.a2.d.b.f().d(false, null);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.i().g(RemindActivity.this, new C0208a());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) RemindActivity.this.getPageContext(), new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        finishActivity(false);
    }

    public void finishActivity(boolean z) {
        super.finish();
        if (z) {
            return;
        }
        d.b.i0.a2.d.b.f().a(null);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remind_activity_layout);
        ((NavigationBar) findViewById(R.id.view_navigation_bar)).addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ((Button) findViewById(R.id.remind_button)).setOnClickListener(new a());
        findViewById(R.id.feed_back_container).setVisibility(FaceFeedbackEnableSwitch.isOn() ? 0 : 8);
        ((TextView) findViewById(R.id.feed_back_text)).setOnClickListener(new b());
    }
}
