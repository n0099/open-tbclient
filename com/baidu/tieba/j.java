package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.view.GuidPageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a {
    private com.baidu.tieba.util.i c;
    private e f;
    private c g;
    protected ProgressDialog h = null;

    /* renamed from: a  reason: collision with root package name */
    private DialogInterface.OnCancelListener f1730a = null;
    private AlertDialog b = null;
    protected int i = -1;
    private GuidPageView d = null;
    private long e = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.e = System.currentTimeMillis();
        this.c = com.baidu.tieba.util.i.a();
        super.onCreate(bundle);
        this.f = new e();
        this.g = new c();
        this.g.a(this.f);
        getLayoutInflater().setFactory(this.g);
        if (g()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.v(true);
        TiebaApplication.g().a(getClass().getName());
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                be.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    public boolean g() {
        return false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        j();
        if (this.d != null) {
            this.d.a();
        }
        if (this.f != null) {
            this.f.a();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.a.a
    public void a_() {
    }

    public void b(String str) {
        if (this.f1730a == null) {
            this.f1730a = new k(this);
        }
        if (str != null) {
            this.h = ProgressDialog.show(this, "", str, true, false, this.f1730a);
        } else {
            this.h = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.f1730a);
        }
    }

    public void i() {
        this.h = null;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.h = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.h = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void j() {
        if (this.h != null) {
            try {
                if (this.h.isShowing()) {
                    this.h.dismiss();
                }
            } catch (Exception e) {
                be.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.h = null;
        }
    }

    @Override // com.baidu.adp.a.a
    public void a(String str) {
        this.c.a(str, 2000);
    }

    public void a(int i, int i2) {
        this.c.a(i, 2000, i2);
    }

    public void b(int i) {
        this.c.a(i, 2000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            be.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(InputMethodManager inputMethodManager, View view) {
        if (view != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view, 0);
            } catch (Exception e) {
            }
        }
    }

    public void a(View view, int i) {
        new Handler().postDelayed(new l(this, view), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.b();
        TiebaApplication.g().aE();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                be.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.c();
        if (TiebaApplication.g().as() != this.i) {
            this.i = TiebaApplication.g().as();
            a(this.i);
        }
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                be.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.g().aD();
        TiebaApplication.g().a(getClass().getName());
        if (this.e > 0) {
            this.e = System.currentTimeMillis() - this.e;
            if (this.e < 5000) {
                String str = null;
                if (this instanceof NewPbActivity) {
                    str = "op_pb_enter";
                } else if (this instanceof FrsActivity) {
                    str = "op_frs_enter";
                } else if (this instanceof EnterForumActivity) {
                    str = "op_home_enter";
                }
                if (str != null) {
                    bf.a(str, this.e, 0L);
                }
            }
            this.e = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        UtilHelper.a((Activity) this);
    }

    public e m() {
        return this.f;
    }
}
