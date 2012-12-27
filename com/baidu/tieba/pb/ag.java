package com.baidu.tieba.pb;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImagePbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends BaseAdapter {
    private com.baidu.tieba.a.t b;
    private Context c;
    private boolean f;
    private int j;
    private com.baidu.tieba.a.v a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList g = new ArrayList();

    public ag(Context context, com.baidu.tieba.a.t tVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = tVar;
        this.j = com.baidu.tieba.c.ag.a(this.c);
    }

    private void a(int i, TextView textView) {
        if (i == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(String.valueOf(String.valueOf(i)) + this.c.getString(R.string.comment_number));
        textView.setVisibility(0);
    }

    public void a() {
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                this.g.clear();
                return;
            }
            try {
                ((ProgressBar) this.g.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(com.baidu.tieba.a.v vVar) {
        this.a = vVar;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean b() {
        if (this.a == null || !this.d) {
            return false;
        }
        return this.a.e();
    }

    public boolean c() {
        return !this.d || this.a == null || this.a.d();
    }

    public int d() {
        if (this.a == null || this.a.a() == null) {
            return 1;
        }
        return (this.a.a().size() / 10) + 1;
    }

    public com.baidu.tieba.a.t e() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        this.d = true;
        if (this.b == null) {
            return 0;
        }
        if (this.a == null || this.a.a() == null) {
            return 1;
        }
        if (this.a.a().size() != this.e) {
            this.e = this.a.a().size();
            notifyDataSetChanged();
            return 0;
        } else if (this.a.a().size() != 0 && this.a.c() != 0) {
            return b() ? this.a.a().size() + 2 : this.a.a().size() + 1;
        } else {
            this.d = false;
            return 2;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || this.a.a() == null || i >= this.a.a().size()) {
            return null;
        }
        return this.a.a().get(i + 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 2;
        }
        return (i == this.a.b() + 1 || !this.d) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        aj ajVar;
        View view2;
        LinearLayout.LayoutParams layoutParams;
        aj ajVar2;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 0) {
                View inflate = from.inflate(R.layout.image_pb_list_item, (ViewGroup) null);
                aj ajVar3 = new aj(this, null);
                ajVar3.a = (TextView) inflate.findViewById(R.id.image_pb_item_comment);
                ajVar3.b = (TextView) inflate.findViewById(R.id.image_pb_item_auther);
                ajVar3.c = (TextView) inflate.findViewById(R.id.image_pb_item_time);
                ajVar3.d = (LinearLayout) inflate.findViewById(R.id.seg);
                ajVar2 = ajVar3;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(R.layout.image_pb_list_header, (ViewGroup) null);
                aj ajVar4 = new aj(this, null);
                ajVar4.h = (TextView) inflate2.findViewById(R.id.image_pb_comment);
                ajVar4.i = (TextView) inflate2.findViewById(R.id.image_pb_author);
                ajVar4.j = (TextView) inflate2.findViewById(R.id.image_pb_reply_number);
                ajVar4.k = (LinearLayout) inflate2.findViewById(R.id.seg);
                ajVar4.g = (ImagePbImageView) inflate2.findViewById(R.id.image_pb_image);
                ajVar2 = ajVar4;
                view3 = inflate2;
            } else {
                View inflate3 = from.inflate(R.layout.page_item, (ViewGroup) null);
                aj ajVar5 = new aj(this, null);
                ajVar5.e = (TextView) inflate3.findViewById(R.id.page_text);
                ajVar5.f = (ProgressBar) inflate3.findViewById(R.id.progress);
                this.g.add(ajVar5.f);
                ajVar2 = ajVar5;
                view3 = inflate3;
            }
            view3.setTag(ajVar2);
            ajVar = ajVar2;
            view2 = view3;
        } else {
            ajVar = (aj) view.getTag();
            view2 = view;
        }
        if (itemViewType == 0) {
            ajVar.a.setGravity(3);
            ajVar.a.setMovementMethod(LinkMovementMethod.getInstance());
            ajVar.a.setTextColor(this.c.getResources().getColor(R.color.reg_font_color));
            com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) this.a.a().get(i - 1);
            ajVar.c.setVisibility(0);
            ajVar.b.setVisibility(0);
            ajVar.b.setText(amVar.d().b());
            ajVar.b.setOnClickListener(new ah(this, amVar.d().a(), amVar.d().b()));
            ajVar.c.setText(com.baidu.tieba.c.ad.a(amVar.c()));
            ajVar.d.setVisibility(8);
            ajVar.d.removeAllViews();
            new com.baidu.tieba.c.g(this.c).a(ajVar.a, ajVar.d, amVar.e(), false);
            ajVar.a.setTextSize(2, 13.0f);
        } else if (itemViewType == 1) {
            if (ajVar.f == null || ajVar.e == null) {
                return view2;
            }
            ajVar.e.setTextSize(2, 13.0f);
            if (this.f) {
                ajVar.f.setVisibility(0);
                ajVar.e.setText(R.string.data_loading_1);
            } else {
                ajVar.f.setVisibility(8);
                ajVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
                if (this.d) {
                    ajVar.e.setText(R.string.load_more);
                } else {
                    ajVar.e.setText(this.c.getString(R.string.image_pb_noreply));
                    ajVar.e.setFocusable(true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList e = this.b.a().e();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this.c);
            ajVar.h.setMovementMethod(LinkMovementMethod.getInstance());
            gVar.a(true);
            gVar.a(ajVar.h, ajVar.k, e, false);
            ajVar.h.setTextSize(2, 13.0f);
            if (ajVar.h.getText().toString().trim().length() == 0) {
                ajVar.h.setVisibility(8);
            }
            ajVar.i.setText(this.b.e());
            ajVar.i.setOnClickListener(new ai(this, this.b.i(), this.b.e()));
            ajVar.g.setTag(this.b.b());
            if (this.k != null) {
                ajVar.g.setOnClickListener(this.k);
            }
            if (this.a != null) {
                a(this.a.c(), ajVar.j);
            }
            int g = this.b.g();
            if (this.b.f() > this.j) {
                g = (g * this.j) / this.b.f();
            }
            if (g >= this.i) {
                ajVar.g.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.i);
            } else if (g <= this.h) {
                ajVar.g.setScale(0);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.h);
            } else {
                ajVar.g.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, g);
            }
            ajVar.g.setLayoutParams(layoutParams);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
