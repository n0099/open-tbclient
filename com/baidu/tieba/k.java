package com.baidu.tieba;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.cc;
import com.compatible.smartbarutil.SmartBarUtils;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public abstract class k extends FragmentActivity {
    protected boolean c;
    private ProgressBar e;
    private e f;
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener d = null;
    protected int b = -1;

    protected abstract void b(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.c = TiebaApplication.g().bu();
        if (this.c) {
            SmartBarUtils.initActionBar(this);
            SmartBarUtils.setActionBarTabsShowAtBottom(this, true);
            SmartBarUtils.setActionBarViewCollapsable(this, true);
        }
        super.onCreate(bundle);
        com.baidu.tieba.account.m.a().b();
        TiebaApplication.v(true);
        cc.a(getClass().getName());
        this.f = new e();
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.i.l());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a(TiebaApplication.g().al());
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.g().ax();
        cc.a(getClass().getName());
    }

    public void a(int i) {
        if (i != this.b) {
            this.b = i;
            b(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.g().ay();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f != null) {
            this.f.b();
        }
        super.onDestroy();
    }

    public e a() {
        return this.f;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void b() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    public void a(String str) {
        BdUtilHelper.a((Context) this, str);
    }

    public void c(int i) {
        BdUtilHelper.a((Context) this, i);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f == null) {
            this.f = new e();
        }
        this.f.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    public void c() {
        a(0, 0);
    }

    public void a(int i, int i2) {
        if (this.e == null) {
            this.e = new ProgressBar(this);
            this.e.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.e, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.e.setPadding(BdUtilHelper.a(this, i), BdUtilHelper.a(this, i2), 0, 0);
        this.e.setVisibility(0);
    }

    public void d() {
        if (this.e != null) {
            this.e.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
