package com.baidu.tieba.square;

import android.app.Activity;
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
import com.baidu.tieba.home.SearchActivity;
import com.baidu.tieba.model.bx;
import com.baidu.tieba.model.by;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.view.ax;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SquareActivity extends com.baidu.tieba.g implements AbsListView.OnScrollListener, com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private ab f1734a = null;
    private bx b = null;
    private boolean c = false;
    private boolean d = false;
    private by e = new w(this);
    private ax f = new x(this);
    private View.OnKeyListener g = new y(this);
    private com.baidu.adp.widget.ListView.b j = new z(this);

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
    }

    private void b() {
        this.f1734a = new ab(this, this.g);
        this.f1734a.a(this.j);
    }

    private void c() {
        this.b = new bx();
        this.b.a(this.e);
        this.d = true;
        a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f1734a.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f1734a.b(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        this.f1734a.g();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1734a.h();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.p()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            aq.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.p()) {
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
                WriteActivity.a(this, com.baidu.tieba.data.g.h(), com.baidu.tieba.data.g.g(), antiData);
                break;
            case 4:
                AboutActivity.a(this);
                break;
            case 5:
                UtilHelper.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        this.f1734a.i();
        l();
        super.onDestroy();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.g().u()) {
                StatService.onEvent(this, "sq_tb_search", "click", 1);
            }
            SearchActivity.a(this, getString(R.string.home));
        } else if (view == this.f1734a.d()) {
            if (TiebaApplication.g().u()) {
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
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.f1734a.a(i);
    }

    private void l() {
        this.b.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        if (this.b != null) {
            boolean z6 = this.b.a() == null || this.b.a().d();
            boolean z7 = z;
            if (NetWorkCore.b(this) == NetWorkCore.NetworkState.UNAVAIL) {
                this.d = false;
                z3 = true;
                z2 = false;
            } else {
                boolean z8 = z6;
                z2 = z7;
                z3 = z8;
            }
            if (!this.d) {
                z4 = z3;
                z5 = z2;
            }
            if (z4 || z5) {
                l();
                if (z5) {
                    this.b.b();
                } else {
                    this.b.c();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
