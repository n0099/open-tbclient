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
import com.baidu.tieba.model.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tieba.g {
    private bq k;
    private ImageView b = null;
    private BdListView c = null;
    private LinearLayout d = null;
    private ProgressBar e = null;
    private bl f = null;
    private Handler g = new Handler();
    private bk j = null;
    private RelativeLayout l = null;
    private RelativeLayout m = null;
    private TextView n = null;

    /* renamed from: a  reason: collision with root package name */
    int f1556a = 0;
    private Runnable o = new bd(this);

    public static void a(Activity activity, boolean z, String str) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (z) {
            intent.putExtra("follow", true);
        }
        intent.putExtra("un", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        a(bundle);
        b();
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.b(this.l, i);
        com.baidu.tieba.util.ah.d(this.m, i);
        com.baidu.tieba.util.ah.f(this.n, i);
        com.baidu.tieba.util.ah.a(this.b, i);
        this.f.notifyDataSetChanged();
        TextView textView = (TextView) this.d.findViewById(R.id.person_num);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.dots1);
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.dots2);
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
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.f != null) {
            this.f.a();
            if (this.f.c() != null) {
                this.f.c().b();
            }
            this.f = null;
        }
        this.g.removeCallbacks(this.o);
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.k = new bq();
        if (bundle != null) {
            this.k.a(bundle.getBoolean("follow", false));
            this.k.a(bundle.getString("un"));
            return;
        }
        Intent intent = getIntent();
        this.k.a(intent.getBooleanExtra("follow", false));
        this.k.a(intent.getStringExtra("un"));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.k.b());
        bundle.putString("un", this.k.a());
    }

    private void b() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.m = (RelativeLayout) findViewById(R.id.title);
        this.n = (TextView) findViewById(R.id.title_text);
        this.e = (ProgressBar) findViewById(R.id.progress);
        if (this.k.b()) {
            this.n.setText(R.string.attention);
        } else {
            this.n.setText(R.string.fans);
        }
        this.b = (ImageView) findViewById(R.id.back);
        this.b.setOnClickListener(new bf(this));
        this.f = new bl(this, getIntent().getBooleanExtra("follow", false), this.k.a() != null && this.k.a().equals(TiebaApplication.E()), new bg(this), new bh(this), new bi(this));
        this.f.a(this.k.c().b());
        this.c = (BdListView) findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.f);
        this.d = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.person_list_header, (ViewGroup) null);
        this.d.setVisibility(8);
        this.d.setClickable(false);
        this.d.setEnabled(false);
        this.c.addHeaderView(this.d, null, false);
        this.c.setOnScrollListener(new bj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.j == null) {
            if (!z) {
                this.e.setVisibility(0);
                this.j = new bk(this, this.k.a(), this.k.b(), 0);
                this.j.execute(new String[0]);
                return;
            }
            if (this.f != null) {
                this.f.b(true);
                this.f.notifyDataSetChanged();
            }
            this.j = new bk(this, this.k.a(), this.k.b(), this.k.c().a().d() + 1);
            this.j.setPriority(3);
            this.j.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        UserData userData;
        if (this.f != null && this.f.getItemViewType(this.f1556a) == 0 && (userData = (UserData) this.f.getItem(this.f1556a)) != null && userData.getId() != null && userData.getName() != null && !userData.getId().equals(TiebaApplication.E())) {
            if (TiebaApplication.f().t()) {
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
