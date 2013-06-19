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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.c.bm k;
    private ImageView d = null;
    private BdListView e = null;
    private LinearLayout f = null;
    private ProgressBar g = null;
    private bt h = null;
    private Handler i = new Handler();
    private bs j = null;
    private RelativeLayout l = null;
    private RelativeLayout m = null;
    private TextView n = null;
    int c = 0;
    private Runnable o = new bl(this);

    public static void a(Activity activity, boolean z, String str) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (z) {
            intent.putExtra("follow", true);
        }
        intent.putExtra("un", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        a(bundle);
        b();
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.b(this.l, i);
        com.baidu.tieba.d.ac.d(this.m, i);
        com.baidu.tieba.d.ac.f(this.n, i);
        com.baidu.tieba.d.ac.a(this.d, i);
        this.h.notifyDataSetChanged();
        TextView textView = (TextView) this.f.findViewById(R.id.person_num);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.dots1);
        ImageView imageView2 = (ImageView) this.f.findViewById(R.id.dots2);
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
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.h != null) {
            this.h.a();
            if (this.h.c() != null) {
                this.h.c().b();
            }
            this.h = null;
        }
        this.i.removeCallbacks(this.o);
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.k = new com.baidu.tieba.c.bm();
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
        this.g = (ProgressBar) findViewById(R.id.progress);
        if (this.k.b()) {
            this.n.setText(R.string.attention);
        } else {
            this.n.setText(R.string.fans);
        }
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new bn(this));
        this.h = new bt(this, getIntent().getBooleanExtra("follow", false), this.k.a().equals(TiebaApplication.C()), new bo(this), new bp(this), new bq(this));
        this.h.a(this.k.c().b());
        this.e = (BdListView) findViewById(R.id.list);
        this.e.setAdapter((ListAdapter) this.h);
        this.f = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.person_list_header, (ViewGroup) null);
        this.f.setVisibility(8);
        this.f.setClickable(false);
        this.f.setEnabled(false);
        this.e.addHeaderView(this.f, null, false);
        this.e.setOnScrollListener(new br(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.j == null) {
            if (!z) {
                this.g.setVisibility(0);
                this.j = new bs(this, this.k.a(), this.k.b(), 0);
                this.j.execute(new String[0]);
                return;
            }
            if (this.h != null) {
                this.h.b(true);
                this.h.notifyDataSetChanged();
            }
            this.j = new bs(this, this.k.a(), this.k.b(), this.k.c().a().d() + 1);
            this.j.setPriority(3);
            this.j.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.baidu.tieba.a.be beVar;
        if (this.h != null && this.h.getItemViewType(this.c) == 0 && (beVar = (com.baidu.tieba.a.be) this.h.getItem(this.c)) != null && beVar.a() != null && beVar.c() != null && !beVar.a().equals(TiebaApplication.C())) {
            if (TiebaApplication.e().p()) {
                StatService.onEvent(this, "enter_chat", "personlistclick", 1);
            }
            ChatActivity.a(this, beVar.a(), beVar.c(), beVar.e(), null, null);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1100028) {
            c();
        }
    }
}
