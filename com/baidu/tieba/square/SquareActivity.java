package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.model.cj;
import com.baidu.tieba.model.ck;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.az;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SquareActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    private ax f2330a = null;
    private cj b = null;
    private boolean c = false;
    private boolean d = false;
    private ck e = new x(this);
    private az f = new y(this);
    private View.OnKeyListener g = new z(this);
    private com.baidu.adp.widget.ListView.b j = new aa(this);

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
    }

    private void b() {
        this.f2330a = new ax(this, this.g);
        this.f2330a.a(this.j);
        this.f2330a.e().setClickStatKey("sq_tb_search");
    }

    private void c() {
        this.b = new cj();
        this.b.a(this.e);
        this.d = true;
        a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f2330a.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f2330a.b(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        this.f2330a.k();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f2330a.l();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.n()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            be.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.n()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                MainTabActivity.a(this, 4);
                break;
            case 2:
                AccountActivity.a(this);
                break;
            case 3:
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                WriteActivity.a(this, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
                break;
            case 4:
                AboutActivity.a((Context) this);
                break;
            case 5:
                UtilHelper.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.f2330a.m();
        f();
        super.onDestroy();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f2330a.g()) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "sq_icon_category", "click", 1);
            }
            BarFolderFirstDirActivity.a(this);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f2330a.a(i);
    }

    private void f() {
        this.b.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.b != null) {
            boolean z5 = this.b.a() == null || this.b.a().d();
            boolean z6 = z;
            if (UtilHelper.b()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.d = false;
                z3 = true;
                z2 = false;
            }
            if (this.d) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                f();
                if (z4) {
                    this.b.b();
                } else {
                    this.b.c();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
