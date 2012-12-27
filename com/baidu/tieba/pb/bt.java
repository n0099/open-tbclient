package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.CustomTextView;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bt extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.c.a c;
    private int d;
    private int e;
    private com.baidu.tieba.b.n f;
    private boolean g;
    private boolean h;
    private ArrayList i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private String p;
    private View.OnClickListener q;

    public bt(Context context, com.baidu.tieba.b.n nVar, int i, View.OnClickListener onClickListener) {
        this.f = nVar;
        this.a = context;
        if (this.f == null || this.f.a() == null) {
            this.b = null;
            this.o = 0;
        } else {
            this.b = this.f.a().c();
            this.o = this.f.a().g();
        }
        this.j = true;
        this.d = 0;
        this.e = 0;
        this.g = false;
        this.h = false;
        this.k = 3;
        this.n = i > 350 ? 350 : i;
        this.c = new com.baidu.tieba.c.a(this.a);
        this.c.a(this.n, (int) (this.n * 1.62f));
        this.i = new ArrayList();
        this.p = TiebaApplication.u();
        this.q = onClickListener;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.j jVar) {
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.tieba.c.ag.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTag(jVar.f());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setImageDrawable(this.a.getResources().getDrawable(R.drawable.video_pic));
        imageView.setOnClickListener(new bu(this));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.j jVar, int i, int i2) {
        com.baidu.tieba.view.ag agVar = new com.baidu.tieba.view.ag(this.a);
        int[] a = com.baidu.tieba.c.ag.a(jVar, i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
        layoutParams.topMargin = com.baidu.tieba.c.ag.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        agVar.setScaleType(ImageView.ScaleType.CENTER);
        agVar.setTag(jVar.f());
        agVar.setClickable(true);
        agVar.setFocusable(false);
        agVar.setOnClickListener(new by(this, arrayList, i));
        agVar.setLayoutParams(layoutParams);
        return agVar;
    }

    private TextView a(com.baidu.tieba.a.j jVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = com.baidu.tieba.c.ag.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.a.h.k());
        customTextView.setTextColor(-11974584);
        a(customTextView, jVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private void a(TextView textView, com.baidu.tieba.a.j jVar) {
        if (textView == null || jVar == null) {
            return;
        }
        if (jVar.a() == 2) {
            textView.setText(jVar.a(this.a, this.l, this.m));
        } else {
            textView.setText(jVar.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ArrayList arrayList, int i) {
        int i2;
        if (arrayList == null || i < 0) {
            return false;
        }
        int size = arrayList.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            if (arrayList.get(i4) != null && ((com.baidu.tieba.a.j) arrayList.get(i4)).a() == 3) {
                i2 = i3 + 1;
                if (i2 != i) {
                    if (i2 > i) {
                        break;
                    }
                } else {
                    return ((com.baidu.tieba.a.j) arrayList.get(i4)).b() >= 50 || ((com.baidu.tieba.a.j) arrayList.get(i4)).c() >= 50;
                }
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        return false;
    }

    private void k() {
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.a.h.k());
        this.l = textView.getLineHeight();
        this.m = (int) textView.getTextSize();
    }

    public void a() {
        if (this.i == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.i.size()) {
                this.i.clear();
                return;
            }
            try {
                ((ProgressBar) this.i.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(com.baidu.tieba.b.n nVar) {
        this.f = nVar;
        if (this.f == null || this.f.a() == null) {
            this.b = null;
            this.o = 0;
            return;
        }
        this.b = this.f.a().c();
        this.o = this.f.a().g();
    }

    public void a(boolean z) {
        this.g = z;
    }

    public com.baidu.tieba.c.a b() {
        return this.c;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void c(int i) {
        this.k = i;
        k();
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean c() {
        return this.d != 0;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.e != 0;
    }

    public int f() {
        return this.e;
    }

    public boolean g() {
        return this.g;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size() + 1;
            if (this.d != 0) {
                size++;
            }
            return this.e != 0 ? size + 1 : size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (this.b == null || itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == 0) {
            return -3;
        }
        int i2 = this.d != 0 ? i - 2 : i - 1;
        if (this.e != 0 && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return (getItemId(i) == -1 || getItemId(i) == -2) ? 1 : 2;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0163: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:36:0x0162 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        Resources resources;
        ca caVar;
        int itemViewType;
        View view3;
        cb cbVar;
        View view4;
        long itemId;
        int i2;
        TextView textView;
        int i3;
        com.baidu.tieba.a.as b;
        if (this.b == null) {
            return view;
        }
        try {
            resources = this.a.getResources();
            caVar = null;
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    view4 = this.f.a().f() ? from.inflate(R.layout.pb_item_has_floor, (ViewGroup) null) : from.inflate(R.layout.pb_item, (ViewGroup) null);
                    cb cbVar2 = new cb(this, null);
                    cbVar2.f = (ImageView) view4.findViewById(R.id.photo);
                    cbVar2.h = (TextView) view4.findViewById(R.id.user_name);
                    cbVar2.i = (TextView) view4.findViewById(R.id.floor);
                    cbVar2.j = (TextView) view4.findViewById(R.id.rank);
                    cbVar2.k = (TextView) view4.findViewById(R.id.time);
                    cbVar2.l = (TextView) view4.findViewById(R.id.text);
                    cbVar2.l.setLineSpacing(0.0f, 1.2f);
                    cbVar2.m = (LinearLayout) view4.findViewById(R.id.seg);
                    cbVar2.g = (ImageView) view4.findViewById(R.id.mark);
                    cbVar2.c = new bz(this);
                    cbVar2.e = new bw(this);
                    cbVar2.d = new bx(this);
                    cbVar2.f.setOnClickListener(cbVar2.c);
                    cbVar2.h.setOnClickListener(cbVar2.c);
                    cbVar2.p = (TextView) view4.findViewById(R.id.forbid_user);
                    cbVar2.q = (TextView) view4.findViewById(R.id.del_post);
                    cbVar2.r = view4.findViewById(R.id.manage_divider);
                    cbVar2.f.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.c.e.a((int) R.drawable.photo_bg)));
                    if (this.f.a().f()) {
                        cbVar2.n = (TextView) view4.findViewById(R.id.text_reply_num);
                        cbVar2.o = (ImageView) view4.findViewById(R.id.image_reply_num);
                    }
                    view4.setTag(cbVar2);
                    cbVar = cbVar2;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    cb cbVar3 = new cb(this, null);
                    cbVar3.a = (TextView) view4.findViewById(R.id.page_text);
                    cbVar3.b = (ProgressBar) view4.findViewById(R.id.progress);
                    this.i.add(cbVar3.b);
                    view4.setTag(cbVar3);
                    cbVar = cbVar3;
                } else {
                    view4 = from.inflate(R.layout.pb_thread_name, (ViewGroup) null);
                    caVar = new ca(this, null);
                    caVar.a = (TextView) view4.findViewById(R.id.thread_name);
                    caVar.c = (Button) view4.findViewById(R.id.pb_title_manage_btn);
                    caVar.b = (LinearLayout) view4.findViewById(R.id.bottom_bar);
                    caVar.d = (Button) view4.findViewById(R.id.commit_top);
                    caVar.f = (Button) view4.findViewById(R.id.cancel_top);
                    caVar.e = (Button) view4.findViewById(R.id.commit_good);
                    caVar.g = (Button) view4.findViewById(R.id.cancel_good);
                    caVar.b.setVisibility(8);
                    caVar.e.setOnClickListener(this.q);
                    caVar.g.setOnClickListener(this.q);
                    caVar.d.setOnClickListener(this.q);
                    caVar.f.setOnClickListener(this.q);
                    if (this.f != null && this.f.a() != null && (b = this.f.a().b()) != null && b.c() != null && b.c().length() > 0) {
                        caVar.a.setText(b.c());
                    }
                    caVar.c.setTag(caVar.b);
                    caVar.c.setOnClickListener(new bv(this));
                    view4.setTag(caVar);
                    cbVar = null;
                }
            } else if (itemViewType == 0 || itemViewType == 1) {
                cbVar = (cb) view.getTag();
                view4 = view;
            } else {
                caVar = (ca) view.getTag();
                cbVar = null;
                view4 = view;
            }
            itemId = getItemId(i);
            if (this.f.a().f() && itemViewType == 0) {
                if (getItem(i) == null || ((com.baidu.tieba.a.am) getItem(i)).b() != 1) {
                    cbVar.n.setVisibility(0);
                    cbVar.o.setVisibility(0);
                } else {
                    cbVar.n.setVisibility(4);
                    cbVar.o.setVisibility(4);
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view3;
            com.baidu.tieba.c.ae.b("PbAdapter", "getView", "error = " + exc.getMessage());
            return view2;
        }
        if (itemViewType == 1 || itemViewType == 2) {
            if (itemId == -1) {
                if (this.h) {
                    cbVar.b.setVisibility(0);
                    cbVar.a.setText(R.string.loading);
                    return view4;
                }
                cbVar.b.setVisibility(8);
                if (this.d == 1) {
                    if (this.f.n()) {
                        cbVar.a.setText(R.string.may_have_more);
                        return view4;
                    } else if (this.f.c()) {
                        cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        return view4;
                    } else {
                        cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().d().a())));
                        return view4;
                    }
                } else if (this.d != 2) {
                    cbVar.a.setText((CharSequence) null);
                    return view4;
                } else if (this.f.n()) {
                    cbVar.a.setText(R.string.load_more);
                    return view4;
                } else if (this.f.c()) {
                    cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                    return view4;
                } else {
                    cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                    return view4;
                }
            } else if (itemId != -2) {
                if (itemId == -3) {
                    if (this.o == 1 && this.f.i()) {
                        caVar.c.setVisibility(0);
                        caVar.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.a.getResources().getDrawable(R.drawable.manage_btn_left), (Drawable) null);
                        return view4;
                    }
                    caVar.c.setVisibility(8);
                    ((LinearLayout) caVar.c.getTag()).setVisibility(8);
                    return view4;
                }
                return view4;
            } else if (this.g) {
                cbVar.b.setVisibility(0);
                cbVar.a.setText(R.string.loading);
                return view4;
            } else {
                cbVar.b.setVisibility(8);
                if (this.e != 1 && this.e != 2) {
                    cbVar.a.setText((CharSequence) null);
                    return view4;
                } else if (this.f.n()) {
                    cbVar.a.setText(R.string.may_have_more);
                    return view4;
                } else if (!this.f.c()) {
                    cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                    return view4;
                } else if (this.f.k() == this.f.a().d().a()) {
                    cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().d().a())));
                    return view4;
                } else {
                    cbVar.a.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                    return view4;
                }
            }
        }
        cbVar.f.setOnClickListener(null);
        cbVar.l.setVisibility(8);
        cbVar.l.setText((CharSequence) null);
        cbVar.l.setMovementMethod(LinkMovementMethod.getInstance());
        cbVar.l.setFocusable(false);
        cbVar.m.setVisibility(8);
        cbVar.m.removeAllViews();
        cbVar.f.setTag(null);
        com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) getItem(i);
        if (amVar != null) {
            String d = amVar.d().d();
            cbVar.f.setVisibility(0);
            cbVar.h.setVisibility(0);
            cbVar.j.setVisibility(0);
            if (this.f.b()) {
                Bitmap bitmap = null;
                if (d != null && d.length() > 0) {
                    bitmap = this.c.b(d);
                    if (bitmap != null) {
                        cbVar.f.setImageBitmap(bitmap);
                    } else {
                        cbVar.f.setTag(d);
                    }
                }
                if (bitmap == null) {
                    cbVar.f.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                }
                cbVar.f.setVisibility(0);
            } else {
                cbVar.f.setVisibility(8);
            }
            cbVar.c.b(amVar.d().a());
            cbVar.c.a(amVar.d().b());
            String a = amVar.d().a();
            if (a == null || a.length() <= 0 || a.equals("0")) {
                cbVar.h.setTextColor(-16777216);
            } else {
                cbVar.h.setTextColor(-9989158);
            }
            cbVar.f.setOnClickListener(cbVar.c);
            if (this.f.j() == null || amVar.a() == null || !this.f.j().equals(amVar.a())) {
                cbVar.g.setVisibility(8);
            } else {
                cbVar.g.setVisibility(0);
            }
            cbVar.h.setTextSize(com.baidu.tieba.a.h.l());
            if (amVar.d() != null) {
                cbVar.h.setText(amVar.d().c());
            } else {
                cbVar.h.setText((CharSequence) null);
            }
            if (amVar.d() == null || amVar.d().k() == 0) {
                cbVar.j.setText((CharSequence) null);
            } else {
                cbVar.j.setText(String.valueOf(String.valueOf(amVar.d().k())) + this.a.getString(R.string.grade));
            }
            cbVar.k.setText(com.baidu.tieba.c.ad.a(amVar.c()));
            if (this.f.a().f()) {
                if (amVar.f() > 0) {
                    cbVar.n.setText(String.valueOf(amVar.f()));
                } else {
                    cbVar.n.setText((CharSequence) null);
                }
            }
            cbVar.i.setText(String.valueOf(String.valueOf(amVar.b())) + this.a.getString(R.string.floor));
            cbVar.p.setVisibility(4);
            cbVar.q.setVisibility(4);
            if (this.o == 0 || !this.f.i()) {
                String a2 = this.f.a().b().h().a();
                if (a2 != null && a2.equals(this.p) && amVar.b() != 1) {
                    cbVar.q.setVisibility(0);
                }
            } else {
                cbVar.p.setVisibility(0);
                cbVar.q.setVisibility(0);
                String a3 = amVar.d().a();
                if (a3 != null && a3.equals(this.p)) {
                    cbVar.p.setVisibility(4);
                }
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    cbVar.p.setVisibility(4);
                }
            }
            cbVar.r.setVisibility(4);
            if (cbVar.p.getVisibility() == 0 && cbVar.q.getVisibility() == 0) {
                cbVar.r.setVisibility(0);
            }
            cbVar.e.a(amVar.b() == 1 ? 1 : 0);
            cbVar.e.a(amVar.a());
            cbVar.e.b(this.o);
            cbVar.q.setOnClickListener(cbVar.e);
            cbVar.d.a(amVar.d().b());
            cbVar.d.a(this.o);
            cbVar.p.setOnClickListener(cbVar.d);
            ArrayList e3 = amVar.e();
            if (e3 == null || e3.size() <= 0) {
                cbVar.l.setVisibility(0);
                cbVar.l.setText((CharSequence) null);
                view2 = view4;
            } else {
                TextView textView2 = null;
                com.baidu.tieba.a.j jVar = (com.baidu.tieba.a.j) e3.get(0);
                if (jVar == null || !(jVar.a() == 0 || jVar.a() == 2)) {
                    i2 = 0;
                } else {
                    cbVar.l.setTextSize(com.baidu.tieba.a.h.k());
                    cbVar.l.setVisibility(0);
                    a(cbVar.l, jVar);
                    textView2 = cbVar.l;
                    i2 = 1;
                }
                int i4 = -1;
                cbVar.m.setVisibility(8);
                int i5 = i2;
                while (i5 < e3.size()) {
                    cbVar.m.setVisibility(0);
                    com.baidu.tieba.a.j jVar2 = (com.baidu.tieba.a.j) e3.get(i5);
                    if (jVar2.a() == 3) {
                        if (this.j) {
                            int i6 = i4 + 1;
                            cbVar.m.addView(a(e3, jVar2, i6, this.n));
                            textView = null;
                            i3 = i6;
                        } else {
                            i3 = i4;
                            textView = textView2;
                        }
                    } else if (jVar2.a() == 1000) {
                        cbVar.m.addView(a(e3, jVar2));
                        int i7 = i4;
                        textView = null;
                        i3 = i7;
                    } else if (textView2 == null) {
                        TextView a4 = a(jVar2);
                        cbVar.m.addView(a4);
                        int i8 = i4;
                        textView = a4;
                        i3 = i8;
                    } else if (jVar2.a() == 2) {
                        textView2.append(jVar2.a(this.a, this.l, this.m));
                        i3 = i4;
                        textView = textView2;
                    } else {
                        textView2.append(jVar2.e());
                        i3 = i4;
                        textView = textView2;
                    }
                    i5++;
                    textView2 = textView;
                    i4 = i3;
                }
                view2 = view4;
            }
            return view2;
        }
        return view4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.j;
    }

    public int j() {
        return this.k;
    }
}
