package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.model.cb;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tieba.j {
    private cb h;
    private NavigationBar j;
    private BdListView b = null;
    private LinearLayout c = null;
    private ProgressBar d = null;
    private bn e = null;
    private Handler f = new Handler();
    private bm g = null;
    private RelativeLayout i = null;
    private TextView k = null;
    private int l = 0;

    /* renamed from: a  reason: collision with root package name */
    int f2204a = 0;
    private com.baidu.tieba.data.aq m = null;
    private Runnable n = new bg(this);

    public static void a(Activity activity, boolean z, String str, int i) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (z) {
            intent.putExtra("follow", true);
        } else {
            intent.putExtra("follow", false);
        }
        intent.putExtra("user_sex", i);
        intent.putExtra("un", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        a(bundle);
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bd.b(this.i, i);
        this.j.c(i);
        this.e.notifyDataSetChanged();
        TextView textView = (TextView) this.c.findViewById(R.id.person_num);
        ImageView imageView = (ImageView) this.c.findViewById(R.id.dots1);
        ImageView imageView2 = (ImageView) this.c.findViewById(R.id.dots2);
        if (i == 1) {
            textView.setTextColor(-11446171);
            imageView.setBackgroundResource(R.drawable.dot_bg_1);
            imageView2.setBackgroundResource(R.drawable.dot_bg_1);
        } else {
            textView.setTextColor(-6842215);
            imageView.setBackgroundResource(R.drawable.dot_bg);
            imageView2.setBackgroundResource(R.drawable.dot_bg);
        }
        Drawable background = imageView.getBackground();
        if (background instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            bitmapDrawable.mutate();
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
        Drawable background2 = imageView2.getBackground();
        if (background2 instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) background2;
            bitmapDrawable2.mutate();
            bitmapDrawable2.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.e != null) {
            this.e.a();
            if (this.e.c() != null) {
                this.e.c().b();
            }
            this.e = null;
        }
        this.f.removeCallbacks(this.n);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.h = new cb();
        if (bundle != null) {
            this.h.a(bundle.getBoolean("follow", false));
            this.h.a(bundle.getString("un"));
            this.l = bundle.getInt("user_sex");
            this.h.a(this.l);
            return;
        }
        Intent intent = getIntent();
        this.h.a(intent.getBooleanExtra("follow", false));
        this.h.a(intent.getStringExtra("un"));
        this.l = intent.getIntExtra("user_sex", 0);
        this.h.a(this.l);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.h.c());
        bundle.putString("un", this.h.a());
        bundle.putInt("user_sex", this.l);
    }

    private void a() {
        boolean z = true;
        this.i = (RelativeLayout) findViewById(R.id.parent);
        this.j = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.k = this.j.a("");
        this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (ProgressBar) findViewById(R.id.progress);
        String A = TiebaApplication.A();
        String a2 = this.h.a();
        if (A != null && A.equals(a2)) {
            if (this.h.c()) {
                this.k.setText(R.string.my_attention);
            } else {
                this.k.setText(R.string.fans);
            }
        } else if (this.h.c()) {
            if (this.l == 2) {
                this.k.setText(R.string.her_attention_people);
            } else if (this.l == 1) {
                this.k.setText(R.string.his_attention_people);
            } else {
                this.k.setText(R.string.ta_attention_people);
            }
        } else if (this.l == 2) {
            this.k.setText(R.string.attention_to_her);
        } else if (this.l == 1) {
            this.k.setText(R.string.attention_to_him);
        } else {
            this.k.setText(R.string.attention_to_ta);
        }
        bi biVar = new bi(this);
        bj bjVar = new bj(this);
        bk bkVar = new bk(this);
        if (this.h.a() == null || !this.h.a().equals(TiebaApplication.A())) {
            z = false;
        }
        this.e = new bn(this, getIntent().getBooleanExtra("follow", false), z, this.h.b(), biVar, bjVar, bkVar);
        this.b = (BdListView) findViewById(R.id.list);
        this.b.setAdapter((ListAdapter) this.e);
        this.c = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.person_list_header, (ViewGroup) null);
        this.c.setVisibility(8);
        this.c.setClickable(false);
        this.c.setEnabled(false);
        this.b.addHeaderView(this.c, null, false);
        this.b.setOnScrollListener(new bl(this));
    }

    private void b() {
        this.g = new bm(this, this.h.a(), this.h.c(), 0, true);
        this.g.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.g == null) {
            if (!z) {
                this.d.setVisibility(0);
                this.g = new bm(this, this.h.a(), this.h.c(), 0);
                this.g.execute(new String[0]);
                return;
            }
            if (this.e != null) {
                this.e.b(true);
                this.e.notifyDataSetChanged();
            }
            this.g = new bm(this, this.h.a(), this.h.c(), this.h.d().a().d() + 1);
            this.g.setPriority(3);
            this.g.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        UserData userData;
        if (this.e != null && this.e.getItemViewType(this.f2204a) == 0 && (userData = (UserData) this.e.getItem(this.f2204a)) != null && userData.getId() != null && userData.getName() != null && !userData.getId().equals(TiebaApplication.A())) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "enter_chat", "personlistclick", 1);
            }
            ChatActivity.a(this, userData.getId(), userData.getName(), userData.getPortrait(), null, null);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            c();
        }
    }
}
