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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.ImagePbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ak extends BaseAdapter {
    private com.baidu.tieba.a.u b;
    private Context c;
    private boolean f;
    private int j;
    private com.baidu.tieba.a.w a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList g = new ArrayList();

    public ak(Context context, com.baidu.tieba.a.u uVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = uVar;
        this.j = com.baidu.tieba.c.ai.a(this.c);
    }

    public void a() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        ((ProgressBar) this.g.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.g.clear();
                    return;
                }
            }
        }
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

    public com.baidu.tieba.a.u e() {
        return this.b;
    }

    public void a(com.baidu.tieba.a.w wVar) {
        this.a = wVar;
    }

    public void a(boolean z) {
        this.f = z;
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
        } else if (this.a.a().size() == 0 || this.a.c() == 0) {
            this.d = false;
            return 2;
        } else if (b()) {
            return this.a.a().size() + 2;
        } else {
            return this.a.a().size() + 1;
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
        if (i == this.a.b() + 1 || !this.d) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        an anVar;
        View view2;
        LinearLayout.LayoutParams layoutParams;
        Object obj;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 0) {
                View inflate = from.inflate(R.layout.image_pb_list_item, (ViewGroup) null);
                an anVar2 = new an(this, null);
                anVar2.a = (TextView) inflate.findViewById(R.id.image_pb_item_comment);
                anVar2.b = (TextView) inflate.findViewById(R.id.image_pb_item_auther);
                anVar2.c = (TextView) inflate.findViewById(R.id.image_pb_item_time);
                anVar2.d = (LinearLayout) inflate.findViewById(R.id.seg);
                obj = anVar2;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(R.layout.image_pb_list_header, (ViewGroup) null);
                an anVar3 = new an(this, null);
                anVar3.g = (LinearLayout) inflate2.findViewById(R.id.header);
                anVar3.i = (TextView) inflate2.findViewById(R.id.image_pb_comment);
                anVar3.j = (TextView) inflate2.findViewById(R.id.image_pb_author);
                anVar3.k = (TextView) inflate2.findViewById(R.id.image_pb_reply_number);
                anVar3.l = (LinearLayout) inflate2.findViewById(R.id.seg);
                anVar3.h = (ImagePbImageView) inflate2.findViewById(R.id.image_pb_image);
                obj = anVar3;
                view3 = inflate2;
            } else {
                View inflate3 = from.inflate(R.layout.page_item, (ViewGroup) null);
                an anVar4 = new an(this, null);
                anVar4.e = (TextView) inflate3.findViewById(R.id.page_text);
                anVar4.f = (ProgressBar) inflate3.findViewById(R.id.progress);
                this.g.add(anVar4.f);
                obj = anVar4;
                view3 = inflate3;
            }
            view3.setTag(obj);
            anVar = obj;
            view2 = view3;
        } else {
            anVar = (an) view.getTag();
            view2 = view;
        }
        if (itemViewType == 0) {
            anVar.a.setGravity(3);
            anVar.a.setMovementMethod(LinkMovementMethod.getInstance());
            anVar.a.setTextColor(this.c.getResources().getColor(R.color.reg_font_color));
            com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) this.a.a().get(i - 1);
            anVar.c.setVisibility(0);
            anVar.b.setVisibility(0);
            anVar.b.setText(alVar.e().b());
            anVar.b.setOnClickListener(new al(this, alVar.e().a(), alVar.e().b()));
            anVar.c.setText(com.baidu.tieba.c.af.a(alVar.d()));
            anVar.d.setVisibility(8);
            anVar.d.removeAllViews();
            ArrayList f = alVar.f();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this.c);
            gVar.a(-13421773);
            gVar.a(anVar.a, anVar.d, f, false);
            anVar.a.setTextSize(2, 13.0f);
            b(anVar);
        } else if (itemViewType == 1) {
            if (anVar.f == null || anVar.e == null) {
                return view2;
            }
            anVar.e.setTextSize(2, 13.0f);
            if (this.f) {
                anVar.f.setVisibility(0);
                anVar.e.setText(R.string.data_loading_1);
                a(anVar, true);
            } else {
                anVar.f.setVisibility(8);
                if (!this.d) {
                    anVar.e.setText(this.c.getString(R.string.image_pb_noreply));
                    anVar.e.setFocusable(true);
                    anVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
                    a(anVar, false);
                } else {
                    anVar.e.setText(R.string.load_more);
                    a(anVar, true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList f2 = this.b.a().f();
            com.baidu.tieba.c.g gVar2 = new com.baidu.tieba.c.g(this.c);
            anVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            gVar2.a(true);
            gVar2.a(anVar.i, anVar.l, f2, false);
            anVar.i.setTextSize(2, 13.0f);
            if (anVar.i.getText().toString().trim().length() == 0) {
                anVar.i.setVisibility(8);
            }
            anVar.j.setText(this.b.e());
            anVar.j.setOnClickListener(new am(this, this.b.i(), this.b.e()));
            anVar.h.setTag(this.b.b());
            if (this.k != null) {
                anVar.h.setOnClickListener(this.k);
            }
            if (this.a != null) {
                a(this.a.c(), anVar.k);
            }
            int g = this.b.g();
            int f3 = this.b.f();
            if (f3 > 0.6f * this.j) {
                anVar.h.setIsScale(true);
                g = (g * this.j) / f3;
            } else {
                anVar.h.setIsScale(false);
            }
            if (g >= this.i) {
                anVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.i);
            } else if (g <= this.h) {
                anVar.h.setScale(0);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.h);
            } else {
                anVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, g);
            }
            anVar.h.setLayoutParams(layoutParams);
            a(anVar);
        }
        return view2;
    }

    private void a(an anVar) {
        try {
            if (TiebaApplication.b().ag() == 1) {
                anVar.i.setTextColor(com.baidu.tieba.c.ae.a(1));
                anVar.k.setTextColor(com.baidu.tieba.c.ae.b(1));
                anVar.g.setBackgroundColor(com.baidu.tieba.c.ae.d(1));
            } else {
                anVar.i.setTextColor(-13421773);
                anVar.k.setTextColor(-6710887);
                anVar.g.setBackgroundColor(-1);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setHeaderSkin", e.getMessage());
        }
    }

    private void b(an anVar) {
        try {
            if (TiebaApplication.b().ag() == 1) {
                anVar.a.setTextColor(com.baidu.tieba.c.ae.a(1));
                anVar.c.setTextColor(com.baidu.tieba.c.ae.b(1));
            } else {
                anVar.a.setTextColor(-13421773);
                anVar.c.setTextColor(-6710887);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setNormalSkin", e.getMessage());
        }
    }

    private void a(an anVar, boolean z) {
        try {
            if (TiebaApplication.b().ag() == 1) {
                if (z) {
                    anVar.e.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    anVar.e.setTextColor(com.baidu.tieba.c.ae.c(1));
                }
            } else if (z) {
                anVar.e.setTextColor(-13421773);
            } else {
                anVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void a(int i, TextView textView) {
        if (i == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(String.valueOf(String.valueOf(i)) + this.c.getString(R.string.comment_number));
        textView.setVisibility(0);
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }
}
