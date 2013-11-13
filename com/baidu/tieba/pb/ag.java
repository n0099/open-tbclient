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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ImagePbImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends BaseAdapter {
    private com.baidu.tieba.data.ab b;
    private Context c;
    private boolean f;
    private int j;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ad f2064a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public ag(Context context, com.baidu.tieba.data.ab abVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = abVar;
        this.j = UtilHelper.a(this.c);
    }

    public void a() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        this.g.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.bg.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        if (this.f2064a == null || !this.d) {
            return false;
        }
        return this.f2064a.e();
    }

    public boolean c() {
        return !this.d || this.f2064a == null || this.f2064a.d();
    }

    public int d() {
        if (this.f2064a == null || this.f2064a.a() == null) {
            return 1;
        }
        return (this.f2064a.a().size() / 10) + 1;
    }

    public com.baidu.tieba.data.ab e() {
        return this.b;
    }

    public void a(com.baidu.tieba.data.ad adVar) {
        this.f2064a = adVar;
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
        if (this.f2064a == null || this.f2064a.a() == null) {
            return 1;
        }
        if (this.f2064a.a().size() != this.e) {
            this.e = this.f2064a.a().size();
            notifyDataSetChanged();
            return 0;
        } else if (this.f2064a.a().size() == 0 || this.f2064a.c() == 0) {
            this.d = false;
            return 2;
        } else if (b()) {
            return this.f2064a.a().size() + 2;
        } else {
            return this.f2064a.a().size() + 1;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f2064a == null || this.f2064a.a() == null || i >= this.f2064a.a().size()) {
            return null;
        }
        return this.f2064a.a().get(i + 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int b = this.f2064a != null ? this.f2064a.b() : 0;
        if (i == 0) {
            return 2;
        }
        return (i == b + 1 || !this.d) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        aj ajVar;
        View view2;
        LinearLayout.LayoutParams layoutParams;
        Object obj;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 0) {
                View inflate = from.inflate(R.layout.image_pb_list_item, (ViewGroup) null);
                aj ajVar2 = new aj(this, null);
                ajVar2.f2067a = (TextView) inflate.findViewById(R.id.image_pb_item_comment);
                ajVar2.b = (TextView) inflate.findViewById(R.id.image_pb_item_auther);
                ajVar2.c = (TextView) inflate.findViewById(R.id.image_pb_item_time);
                ajVar2.d = (LinearLayout) inflate.findViewById(R.id.seg);
                obj = ajVar2;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(R.layout.image_pb_list_header, (ViewGroup) null);
                aj ajVar3 = new aj(this, null);
                ajVar3.g = (LinearLayout) inflate2.findViewById(R.id.header);
                ajVar3.i = (TextView) inflate2.findViewById(R.id.image_pb_comment);
                ajVar3.j = (TextView) inflate2.findViewById(R.id.image_pb_author);
                ajVar3.k = (TextView) inflate2.findViewById(R.id.image_pb_reply_number);
                ajVar3.l = (LinearLayout) inflate2.findViewById(R.id.seg);
                ajVar3.h = (ImagePbImageView) inflate2.findViewById(R.id.image_pb_image);
                obj = ajVar3;
                view3 = inflate2;
            } else {
                View inflate3 = from.inflate(R.layout.page_item, (ViewGroup) null);
                aj ajVar4 = new aj(this, null);
                ajVar4.e = (TextView) inflate3.findViewById(R.id.page_text);
                ajVar4.f = (ProgressBar) inflate3.findViewById(R.id.progress);
                this.g.add(ajVar4.f);
                obj = ajVar4;
                view3 = inflate3;
            }
            view3.setTag(obj);
            ajVar = obj;
            view2 = view3;
        } else {
            ajVar = (aj) view.getTag();
            view2 = view;
        }
        if (itemViewType == 0) {
            ajVar.f2067a.setGravity(3);
            ajVar.f2067a.setMovementMethod(LinkMovementMethod.getInstance());
            ajVar.f2067a.setTextColor(this.c.getResources().getColor(R.color.reg_font_color));
            com.baidu.tieba.data.as asVar = this.f2064a.a().get(i - 1);
            ajVar.c.setVisibility(0);
            ajVar.b.setVisibility(0);
            ajVar.b.setText(asVar.g().getName());
            ajVar.b.setOnClickListener(new ah(this, asVar.g().getId(), asVar.g().getName()));
            ajVar.c.setText(com.baidu.tieba.util.be.b(asVar.f()));
            ajVar.d.setVisibility(8);
            ajVar.d.removeAllViews();
            ArrayList<com.baidu.tieba.data.j> i2 = asVar.i();
            com.baidu.tieba.util.p pVar = new com.baidu.tieba.util.p(this.c);
            pVar.a(-13421773);
            pVar.a(ajVar.f2067a, ajVar.d, i2, false);
            ajVar.f2067a.setTextSize(2, 13.0f);
            b(ajVar);
        } else if (itemViewType == 1) {
            if (ajVar.f == null || ajVar.e == null) {
                return view2;
            }
            ajVar.e.setTextSize(2, 13.0f);
            if (this.f) {
                ajVar.f.setVisibility(0);
                ajVar.e.setText(R.string.data_loading_1);
                a(ajVar, true);
            } else {
                ajVar.f.setVisibility(8);
                if (!this.d) {
                    ajVar.e.setText(this.c.getString(R.string.image_pb_noreply));
                    ajVar.e.setFocusable(true);
                    ajVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
                    a(ajVar, false);
                } else {
                    ajVar.e.setText(R.string.load_more);
                    a(ajVar, true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList<com.baidu.tieba.data.j> i3 = this.b.a().i();
            com.baidu.tieba.util.p pVar2 = new com.baidu.tieba.util.p(this.c);
            ajVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            pVar2.a(true);
            pVar2.a(ajVar.i, ajVar.l, i3, false);
            ajVar.i.setTextSize(2, 13.0f);
            if (ajVar.i.getText().toString().trim().length() == 0) {
                ajVar.i.setVisibility(8);
            }
            ajVar.j.setText(this.b.e());
            ajVar.j.setOnClickListener(new ai(this, this.b.i(), this.b.e()));
            ajVar.h.setTag(this.b.b());
            if (this.k != null) {
                ajVar.h.setOnClickListener(this.k);
            }
            if (this.f2064a != null) {
                a(this.f2064a.c(), ajVar.k);
            }
            int g = this.b.g();
            int f = this.b.f();
            if (f > 0.6f * this.j) {
                ajVar.h.setIsScale(true);
                g = (g * this.j) / f;
            } else {
                ajVar.h.setIsScale(false);
            }
            if (g >= this.i) {
                ajVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.i);
            } else if (g <= this.h) {
                ajVar.h.setScale(0);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.h);
            } else {
                ajVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, g);
            }
            ajVar.h.setLayoutParams(layoutParams);
            a(ajVar);
        }
        return view2;
    }

    private void a(aj ajVar) {
        try {
            if (TiebaApplication.g().ap() == 1) {
                ajVar.i.setTextColor(com.baidu.tieba.util.bd.a(1));
                ajVar.k.setTextColor(com.baidu.tieba.util.bd.b(1));
                ajVar.g.setBackgroundColor(com.baidu.tieba.util.bd.d(1));
            } else {
                ajVar.i.setTextColor(-13421773);
                ajVar.k.setTextColor(-6710887);
                ajVar.g.setBackgroundColor(-1);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "setHeaderSkin", e.getMessage());
        }
    }

    private void b(aj ajVar) {
        try {
            if (TiebaApplication.g().ap() == 1) {
                ajVar.f2067a.setTextColor(com.baidu.tieba.util.bd.a(1));
                ajVar.c.setTextColor(com.baidu.tieba.util.bd.b(1));
            } else {
                ajVar.f2067a.setTextColor(-13421773);
                ajVar.c.setTextColor(-6710887);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "setNormalSkin", e.getMessage());
        }
    }

    private void a(aj ajVar, boolean z) {
        try {
            if (TiebaApplication.g().ap() == 1) {
                if (z) {
                    ajVar.e.setTextColor(com.baidu.tieba.util.bd.a(1));
                } else {
                    ajVar.e.setTextColor(com.baidu.tieba.util.bd.c(1));
                }
            } else if (z) {
                ajVar.e.setTextColor(-13421773);
            } else {
                ajVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void a(int i, TextView textView) {
        if (i == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(String.valueOf(i) + this.c.getString(R.string.comment_number));
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
