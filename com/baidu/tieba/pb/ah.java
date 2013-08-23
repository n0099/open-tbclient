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
public class ah extends BaseAdapter {
    private com.baidu.tieba.data.ab b;
    private Context c;
    private boolean f;
    private int j;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ad f1484a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList g = new ArrayList();

    public ah(Context context, com.baidu.tieba.data.ab abVar) {
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
                        ((ProgressBar) this.g.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.aq.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        if (this.f1484a == null || !this.d) {
            return false;
        }
        return this.f1484a.e();
    }

    public boolean c() {
        return !this.d || this.f1484a == null || this.f1484a.d();
    }

    public int d() {
        if (this.f1484a == null || this.f1484a.a() == null) {
            return 1;
        }
        return (this.f1484a.a().size() / 10) + 1;
    }

    public com.baidu.tieba.data.ab e() {
        return this.b;
    }

    public void a(com.baidu.tieba.data.ad adVar) {
        this.f1484a = adVar;
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
        if (this.f1484a == null || this.f1484a.a() == null) {
            return 1;
        }
        if (this.f1484a.a().size() != this.e) {
            this.e = this.f1484a.a().size();
            notifyDataSetChanged();
            return 0;
        } else if (this.f1484a.a().size() == 0 || this.f1484a.c() == 0) {
            this.d = false;
            return 2;
        } else if (b()) {
            return this.f1484a.a().size() + 2;
        } else {
            return this.f1484a.a().size() + 1;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f1484a == null || this.f1484a.a() == null || i >= this.f1484a.a().size()) {
            return null;
        }
        return this.f1484a.a().get(i + 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int b = this.f1484a != null ? this.f1484a.b() : 0;
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
        ak akVar;
        View view2;
        LinearLayout.LayoutParams layoutParams;
        Object obj;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 0) {
                View inflate = from.inflate(R.layout.image_pb_list_item, (ViewGroup) null);
                ak akVar2 = new ak(this, null);
                akVar2.f1487a = (TextView) inflate.findViewById(R.id.image_pb_item_comment);
                akVar2.b = (TextView) inflate.findViewById(R.id.image_pb_item_auther);
                akVar2.c = (TextView) inflate.findViewById(R.id.image_pb_item_time);
                akVar2.d = (LinearLayout) inflate.findViewById(R.id.seg);
                obj = akVar2;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(R.layout.image_pb_list_header, (ViewGroup) null);
                ak akVar3 = new ak(this, null);
                akVar3.g = (LinearLayout) inflate2.findViewById(R.id.header);
                akVar3.i = (TextView) inflate2.findViewById(R.id.image_pb_comment);
                akVar3.j = (TextView) inflate2.findViewById(R.id.image_pb_author);
                akVar3.k = (TextView) inflate2.findViewById(R.id.image_pb_reply_number);
                akVar3.l = (LinearLayout) inflate2.findViewById(R.id.seg);
                akVar3.h = (ImagePbImageView) inflate2.findViewById(R.id.image_pb_image);
                obj = akVar3;
                view3 = inflate2;
            } else {
                View inflate3 = from.inflate(R.layout.page_item, (ViewGroup) null);
                ak akVar4 = new ak(this, null);
                akVar4.e = (TextView) inflate3.findViewById(R.id.page_text);
                akVar4.f = (ProgressBar) inflate3.findViewById(R.id.progress);
                this.g.add(akVar4.f);
                obj = akVar4;
                view3 = inflate3;
            }
            view3.setTag(obj);
            akVar = obj;
            view2 = view3;
        } else {
            akVar = (ak) view.getTag();
            view2 = view;
        }
        if (itemViewType == 0) {
            akVar.f1487a.setGravity(3);
            akVar.f1487a.setMovementMethod(LinkMovementMethod.getInstance());
            akVar.f1487a.setTextColor(this.c.getResources().getColor(R.color.reg_font_color));
            com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) this.f1484a.a().get(i - 1);
            akVar.c.setVisibility(0);
            akVar.b.setVisibility(0);
            akVar.b.setText(asVar.g().getName());
            akVar.b.setOnClickListener(new ai(this, asVar.g().getId(), asVar.g().getName()));
            akVar.c.setText(com.baidu.tieba.util.ap.a(asVar.f()));
            akVar.d.setVisibility(8);
            akVar.d.removeAllViews();
            ArrayList i2 = asVar.i();
            com.baidu.tieba.util.h hVar = new com.baidu.tieba.util.h(this.c);
            hVar.a(-13421773);
            hVar.a(akVar.f1487a, akVar.d, i2, false);
            akVar.f1487a.setTextSize(2, 13.0f);
            b(akVar);
        } else if (itemViewType == 1) {
            if (akVar.f == null || akVar.e == null) {
                return view2;
            }
            akVar.e.setTextSize(2, 13.0f);
            if (this.f) {
                akVar.f.setVisibility(0);
                akVar.e.setText(R.string.data_loading_1);
                a(akVar, true);
            } else {
                akVar.f.setVisibility(8);
                if (!this.d) {
                    akVar.e.setText(this.c.getString(R.string.image_pb_noreply));
                    akVar.e.setFocusable(true);
                    akVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
                    a(akVar, false);
                } else {
                    akVar.e.setText(R.string.load_more);
                    a(akVar, true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList i3 = this.b.a().i();
            com.baidu.tieba.util.h hVar2 = new com.baidu.tieba.util.h(this.c);
            akVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            hVar2.a(true);
            hVar2.a(akVar.i, akVar.l, i3, false);
            akVar.i.setTextSize(2, 13.0f);
            if (akVar.i.getText().toString().trim().length() == 0) {
                akVar.i.setVisibility(8);
            }
            akVar.j.setText(this.b.e());
            akVar.j.setOnClickListener(new aj(this, this.b.i(), this.b.e()));
            akVar.h.setTag(this.b.b());
            if (this.k != null) {
                akVar.h.setOnClickListener(this.k);
            }
            if (this.f1484a != null) {
                a(this.f1484a.c(), akVar.k);
            }
            int g = this.b.g();
            int f = this.b.f();
            if (f > 0.6f * this.j) {
                akVar.h.setIsScale(true);
                g = (g * this.j) / f;
            } else {
                akVar.h.setIsScale(false);
            }
            if (g >= this.i) {
                akVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.i);
            } else if (g <= this.h) {
                akVar.h.setScale(0);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.h);
            } else {
                akVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, g);
            }
            akVar.h.setLayoutParams(layoutParams);
            a(akVar);
        }
        return view2;
    }

    private void a(ak akVar) {
        try {
            if (TiebaApplication.g().an() == 1) {
                akVar.i.setTextColor(com.baidu.tieba.util.ao.a(1));
                akVar.k.setTextColor(com.baidu.tieba.util.ao.b(1));
                akVar.g.setBackgroundColor(com.baidu.tieba.util.ao.d(1));
            } else {
                akVar.i.setTextColor(-13421773);
                akVar.k.setTextColor(-6710887);
                akVar.g.setBackgroundColor(-1);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "setHeaderSkin", e.getMessage());
        }
    }

    private void b(ak akVar) {
        try {
            if (TiebaApplication.g().an() == 1) {
                akVar.f1487a.setTextColor(com.baidu.tieba.util.ao.a(1));
                akVar.c.setTextColor(com.baidu.tieba.util.ao.b(1));
            } else {
                akVar.f1487a.setTextColor(-13421773);
                akVar.c.setTextColor(-6710887);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "setNormalSkin", e.getMessage());
        }
    }

    private void a(ak akVar, boolean z) {
        try {
            if (TiebaApplication.g().an() == 1) {
                if (z) {
                    akVar.e.setTextColor(com.baidu.tieba.util.ao.a(1));
                } else {
                    akVar.e.setTextColor(com.baidu.tieba.util.ao.c(1));
                }
            } else if (z) {
                akVar.e.setTextColor(-13421773);
            } else {
                akVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "setPageSkin", e.getMessage());
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
