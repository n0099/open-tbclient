package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.ColorStateList;
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
import com.baidu.tieba.view.PbImageView;
import com.baidu.zeus.WebChromeClient;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ca extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.c.a c;
    private int d;
    private int e;
    private com.baidu.tieba.b.q f;
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

    public ca(Context context, com.baidu.tieba.b.q qVar, int i, View.OnClickListener onClickListener) {
        this.f = qVar;
        this.a = context;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().d();
            this.o = this.f.a().j();
        } else {
            this.b = null;
            this.o = 0;
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
        this.p = TiebaApplication.x();
        this.q = onClickListener;
    }

    private void k() {
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.a.i.k());
        this.l = textView.getLineHeight();
        this.m = (int) textView.getTextSize();
    }

    public void a(com.baidu.tieba.b.q qVar) {
        this.f = qVar;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().d();
            this.o = this.f.a().j();
            return;
        }
        this.b = null;
        this.o = 0;
    }

    public void a() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        ((ProgressBar) this.i.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    public com.baidu.tieba.c.a b() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size() + 1;
            if (this.d != 0) {
                size++;
            }
            if (this.e != 0) {
                return size + 1;
            }
            return size;
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
        int i2;
        if (i == 0) {
            return -3;
        }
        if (this.d != 0) {
            i2 = i - 2;
        } else {
            i2 = i - 1;
        }
        if (this.e != 0 && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.k kVar, int i, int i2) {
        PbImageView pbImageView = new PbImageView(this.a);
        int[] a = com.baidu.tieba.c.ai.a(kVar, i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
        layoutParams.topMargin = com.baidu.tieba.c.ai.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        pbImageView.setScaleType(ImageView.ScaleType.CENTER);
        pbImageView.setTag(kVar.f());
        pbImageView.setClickable(true);
        pbImageView.setFocusable(false);
        pbImageView.setOnClickListener(new cf(this, arrayList, i));
        pbImageView.setLayoutParams(layoutParams);
        return pbImageView;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.k kVar) {
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.tieba.c.ai.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTag(kVar.f());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setImageDrawable(this.a.getResources().getDrawable(R.drawable.video_pic));
        imageView.setOnClickListener(new cb(this));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private TextView a(com.baidu.tieba.a.k kVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = com.baidu.tieba.c.ai.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.a.i.k());
        if (TiebaApplication.b().ag() == 1) {
            customTextView.setTextColor(com.baidu.tieba.c.ae.a(1));
            customTextView.setLinkTextColor(-9989158);
        } else {
            customTextView.setTextColor(-11974584);
            customTextView.setLinkTextColor(-10526484);
        }
        a(customTextView, kVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private void a(TextView textView, com.baidu.tieba.a.k kVar) {
        if (textView != null && kVar != null) {
            if (kVar.a() == 2) {
                textView.setText(kVar.a(this.a, this.l, this.m));
            } else {
                textView.setText(kVar.e());
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0169: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:37:0x0168 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        Resources resources;
        ch chVar;
        int itemViewType;
        View view3;
        ci ciVar;
        View view4;
        long itemId;
        int i2;
        TextView textView;
        int i3;
        com.baidu.tieba.a.at b;
        if (this.b == null) {
            return view;
        }
        try {
            resources = this.a.getResources();
            chVar = null;
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    if (this.f.a().i()) {
                        view4 = from.inflate(R.layout.pb_item_has_floor, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.pb_item, (ViewGroup) null);
                    }
                    ci ciVar2 = new ci(this, null);
                    ciVar2.g = (ImageView) view4.findViewById(R.id.photo);
                    ciVar2.i = (TextView) view4.findViewById(R.id.user_name);
                    ciVar2.j = (TextView) view4.findViewById(R.id.floor);
                    ciVar2.k = (TextView) view4.findViewById(R.id.rank);
                    ciVar2.l = (TextView) view4.findViewById(R.id.time);
                    ciVar2.m = (TextView) view4.findViewById(R.id.text);
                    ciVar2.m.setLineSpacing(0.0f, 1.2f);
                    ciVar2.n = (LinearLayout) view4.findViewById(R.id.seg);
                    ciVar2.h = (ImageView) view4.findViewById(R.id.mark);
                    ciVar2.d = new cg(this);
                    ciVar2.f = new cd(this);
                    ciVar2.e = new ce(this);
                    ciVar2.g.setOnClickListener(ciVar2.d);
                    ciVar2.i.setOnClickListener(ciVar2.d);
                    ciVar2.q = (TextView) view4.findViewById(R.id.forbid_user);
                    ciVar2.r = (TextView) view4.findViewById(R.id.del_post);
                    ciVar2.s = view4.findViewById(R.id.manage_divider);
                    ciVar2.a = -1;
                    ciVar2.g.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.c.e.a((int) R.drawable.photo_bg)));
                    if (this.f.a().i()) {
                        ciVar2.o = (TextView) view4.findViewById(R.id.text_reply_num);
                        ciVar2.p = (ImageView) view4.findViewById(R.id.image_reply_num);
                    }
                    view4.setTag(ciVar2);
                    ciVar = ciVar2;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    ci ciVar3 = new ci(this, null);
                    ciVar3.b = (TextView) view4.findViewById(R.id.page_text);
                    ciVar3.c = (ProgressBar) view4.findViewById(R.id.progress);
                    ciVar3.a = -1;
                    this.i.add(ciVar3.c);
                    view4.setTag(ciVar3);
                    ciVar = ciVar3;
                } else {
                    view4 = from.inflate(R.layout.pb_thread_name, (ViewGroup) null);
                    chVar = new ch(this, null);
                    chVar.c = (LinearLayout) view4.findViewById(R.id.top_bar);
                    chVar.b = (TextView) view4.findViewById(R.id.thread_name);
                    chVar.e = (Button) view4.findViewById(R.id.pb_title_manage_btn);
                    chVar.d = (LinearLayout) view4.findViewById(R.id.bottom_bar);
                    chVar.f = (Button) view4.findViewById(R.id.commit_top);
                    chVar.h = (Button) view4.findViewById(R.id.cancel_top);
                    chVar.g = (Button) view4.findViewById(R.id.commit_good);
                    chVar.i = (Button) view4.findViewById(R.id.cancel_good);
                    chVar.j = view4.findViewById(R.id.line1);
                    chVar.k = view4.findViewById(R.id.line2);
                    chVar.l = view4.findViewById(R.id.line3);
                    chVar.a = -1;
                    chVar.d.setVisibility(8);
                    chVar.g.setOnClickListener(this.q);
                    chVar.i.setOnClickListener(this.q);
                    chVar.f.setOnClickListener(this.q);
                    chVar.h.setOnClickListener(this.q);
                    chVar.c.setPadding(0, ((PbActivity) this.a).j(), 0, 0);
                    if (this.f != null && this.f.a() != null && (b = this.f.a().b()) != null && b.c() != null && b.c().length() > 0) {
                        chVar.b.setText(b.c());
                    }
                    chVar.e.setTag(chVar.d);
                    chVar.e.setOnClickListener(new cc(this));
                    view4.setTag(chVar);
                    ciVar = null;
                }
            } else if (itemViewType == 0 || itemViewType == 1) {
                ciVar = (ci) view.getTag();
                view4 = view;
            } else {
                chVar = (ch) view.getTag();
                ciVar = null;
                view4 = view;
            }
            itemId = getItemId(i);
            if (this.f.a().i() && itemViewType == 0) {
                if (getItem(i) != null && ((com.baidu.tieba.a.al) getItem(i)).c() == 1) {
                    ciVar.o.setVisibility(4);
                    ciVar.p.setVisibility(4);
                } else {
                    ciVar.o.setVisibility(0);
                    ciVar.p.setVisibility(0);
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view3;
            com.baidu.tieba.c.ag.b("PbAdapter", "getView", "error = " + exc.getMessage());
            return view2;
        }
        if (itemViewType == 1 || itemViewType == 2) {
            if (itemId == -1) {
                if (this.h) {
                    ciVar.c.setVisibility(0);
                    ciVar.b.setText(R.string.loading);
                } else {
                    ciVar.c.setVisibility(8);
                    if (this.d == 1) {
                        if (this.f.n() || ((PbActivity) this.a).i() != null) {
                            ciVar.b.setText(R.string.may_have_more);
                        } else if (this.f.c()) {
                            ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        } else {
                            ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().e().a())));
                        }
                    } else if (this.d == 2) {
                        if (this.f.n() || ((PbActivity) this.a).i() != null) {
                            ciVar.b.setText(R.string.load_more);
                        } else if (this.f.c()) {
                            ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                        } else {
                            ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        }
                    } else {
                        ciVar.b.setText((CharSequence) null);
                    }
                }
                a(ciVar);
                return view4;
            } else if (itemId == -2) {
                if (this.g) {
                    ciVar.c.setVisibility(0);
                    ciVar.b.setText(R.string.loading);
                } else {
                    ciVar.c.setVisibility(8);
                    if (this.e == 1 || this.e == 2) {
                        if (this.f.n() || ((PbActivity) this.a).i() != null) {
                            ciVar.b.setText(R.string.may_have_more);
                        } else if (this.f.c()) {
                            if (this.f.k() == this.f.a().e().a()) {
                                ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().e().a())));
                            } else {
                                ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                            }
                        } else {
                            ciVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                        }
                    } else {
                        ciVar.b.setText((CharSequence) null);
                    }
                }
                a(ciVar);
                return view4;
            } else if (itemId == -3) {
                if (this.o == 1 && this.f.i()) {
                    chVar.e.setVisibility(0);
                    chVar.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.a.getResources().getDrawable(R.drawable.manage_btn_left), (Drawable) null);
                } else {
                    chVar.e.setVisibility(8);
                    ((LinearLayout) chVar.e.getTag()).setVisibility(8);
                }
                a(chVar);
                return view4;
            } else {
                return view4;
            }
        }
        ciVar.g.setOnClickListener(null);
        ciVar.m.setVisibility(8);
        ciVar.m.setText((CharSequence) null);
        ciVar.m.setMovementMethod(LinkMovementMethod.getInstance());
        ciVar.m.setFocusable(false);
        ciVar.n.setVisibility(8);
        ciVar.n.removeAllViews();
        ciVar.g.setTag(null);
        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) getItem(i);
        if (alVar != null) {
            String d = alVar.e().d();
            ciVar.g.setVisibility(0);
            ciVar.i.setVisibility(0);
            ciVar.k.setVisibility(0);
            if (this.f.b()) {
                Bitmap bitmap = null;
                if (d != null && d.length() > 0) {
                    bitmap = this.c.b(d);
                    if (bitmap != null) {
                        ciVar.g.setImageBitmap(bitmap);
                    } else {
                        ciVar.g.setTag(d);
                    }
                }
                if (bitmap == null) {
                    ciVar.g.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                }
                ciVar.g.setVisibility(0);
            } else {
                ciVar.g.setVisibility(8);
            }
            ciVar.d.b(alVar.e().a());
            ciVar.d.a(alVar.e().b());
            String a = alVar.e().a();
            if (a == null || a.length() <= 0 || a.equals("0")) {
                if (TiebaApplication.b().ag() == 1) {
                    ciVar.i.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    ciVar.i.setTextColor(-16777216);
                }
            } else {
                ciVar.i.setTextColor(-9989158);
            }
            ciVar.g.setOnClickListener(ciVar.d);
            if (this.f.j() != null && alVar.a() != null && this.f.j().equals(alVar.a())) {
                ciVar.h.setVisibility(0);
            } else {
                ciVar.h.setVisibility(8);
            }
            ciVar.i.setTextSize(com.baidu.tieba.a.i.l());
            if (alVar.e() != null) {
                ciVar.i.setText(alVar.e().c());
            } else {
                ciVar.i.setText((CharSequence) null);
            }
            if (alVar.e() != null && alVar.e().k() != 0) {
                ciVar.k.setText(String.valueOf(String.valueOf(alVar.e().k())) + this.a.getString(R.string.grade));
            } else {
                ciVar.k.setText((CharSequence) null);
            }
            ciVar.l.setText(com.baidu.tieba.c.af.a(alVar.d()));
            if (this.f.a().i()) {
                if (alVar.g() > 0) {
                    ciVar.o.setText(String.valueOf(alVar.g()));
                } else {
                    ciVar.o.setText((CharSequence) null);
                }
            }
            ciVar.j.setText(String.valueOf(String.valueOf(alVar.c())) + this.a.getString(R.string.floor));
            ciVar.q.setVisibility(4);
            ciVar.r.setVisibility(4);
            if (this.o != 0 && this.f.i()) {
                ciVar.q.setVisibility(0);
                ciVar.r.setVisibility(0);
                String a2 = alVar.e().a();
                if (a2 != null && a2.equals(this.p)) {
                    ciVar.q.setVisibility(4);
                }
                if (a2 == null || a2.equals("0") || a2.length() == 0) {
                    ciVar.q.setVisibility(4);
                }
            } else {
                String a3 = this.f.a().b().h().a();
                if (a3 != null && a3.equals(this.p) && alVar.c() != 1) {
                    ciVar.r.setVisibility(0);
                }
            }
            ciVar.s.setVisibility(4);
            if (ciVar.q.getVisibility() == 0 && ciVar.r.getVisibility() == 0) {
                ciVar.s.setVisibility(0);
            }
            int i4 = 0;
            if (alVar.c() == 1) {
                i4 = 1;
            }
            ciVar.f.a(i4);
            ciVar.f.a(alVar.a());
            ciVar.f.b(this.o);
            ciVar.r.setOnClickListener(ciVar.f);
            ciVar.e.a(alVar.e().b());
            ciVar.e.a(this.o);
            ciVar.q.setOnClickListener(ciVar.e);
            ArrayList f = alVar.f();
            if (f != null && f.size() > 0) {
                TextView textView2 = null;
                com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) f.get(0);
                if (kVar == null || (kVar.a() != 0 && kVar.a() != 2)) {
                    i2 = 0;
                } else {
                    ciVar.m.setTextSize(com.baidu.tieba.a.i.k());
                    ciVar.m.setVisibility(0);
                    a(ciVar.m, kVar);
                    textView2 = ciVar.m;
                    i2 = 1;
                }
                int i5 = -1;
                ciVar.n.setVisibility(8);
                int i6 = i2;
                while (i6 < f.size()) {
                    ciVar.n.setVisibility(0);
                    com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) f.get(i6);
                    if (kVar2.a() == 3) {
                        if (this.j) {
                            int i7 = i5 + 1;
                            ciVar.n.addView(a(f, kVar2, i7, this.n));
                            textView = null;
                            i3 = i7;
                        } else {
                            i3 = i5;
                            textView = textView2;
                        }
                    } else if (kVar2.a() == 1000) {
                        ciVar.n.addView(a(f, kVar2));
                        int i8 = i5;
                        textView = null;
                        i3 = i8;
                    } else if (textView2 != null) {
                        if (kVar2.a() == 2) {
                            textView2.append(kVar2.a(this.a, this.l, this.m));
                            i3 = i5;
                            textView = textView2;
                        } else {
                            textView2.append(kVar2.e());
                            i3 = i5;
                            textView = textView2;
                        }
                    } else {
                        TextView a4 = a(kVar2);
                        ciVar.n.addView(a4);
                        int i9 = i5;
                        textView = a4;
                        i3 = i9;
                    }
                    i6++;
                    textView2 = textView;
                    i5 = i3;
                }
            } else {
                ciVar.m.setVisibility(0);
                ciVar.m.setText((CharSequence) null);
            }
            b(ciVar);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(ci ciVar) {
        try {
            if (ciVar.a != TiebaApplication.b().ag()) {
                ciVar.a = TiebaApplication.b().ag();
                if (ciVar.a == 1) {
                    ciVar.b.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    ciVar.b.setTextColor(-16777216);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void b(ci ciVar) {
        try {
            if (ciVar.a != TiebaApplication.b().ag()) {
                ciVar.a = TiebaApplication.b().ag();
                if (ciVar.a == 1) {
                    ciVar.k.setTextColor(com.baidu.tieba.c.ae.b(ciVar.a));
                    ciVar.s.setBackgroundColor(this.a.getResources().getColor(R.color.skin_1_divider_color));
                    ciVar.j.setTextColor(com.baidu.tieba.c.ae.b(ciVar.a));
                    ciVar.j.setBackgroundResource(R.drawable.floor_bg_1);
                    ciVar.m.setTextColor(com.baidu.tieba.c.ae.a(ciVar.a));
                    ciVar.m.setLinkTextColor(-9989158);
                    ciVar.l.setTextColor(com.baidu.tieba.c.ae.b(ciVar.a));
                } else {
                    ciVar.k.setTextColor(-9276814);
                    ciVar.s.setBackgroundColor(-6710887);
                    ciVar.j.setTextColor(-9276814);
                    ciVar.j.setBackgroundResource(R.drawable.floor_bg);
                    ciVar.m.setTextColor(-11974584);
                    ciVar.m.setLinkTextColor(-10526484);
                    ciVar.l.setTextColor(-9276814);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }

    private void a(ch chVar) {
        try {
            if (chVar.a != TiebaApplication.b().ag()) {
                chVar.a = TiebaApplication.b().ag();
                if (chVar.a == 1) {
                    com.baidu.tieba.c.ae.i(chVar.c, R.drawable.my_title_bg_hl_1);
                    chVar.d.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg_1);
                    int a = com.baidu.tieba.c.ae.a(1);
                    chVar.b.setTextColor(a);
                    chVar.e.setTextColor(a);
                    chVar.e.setBackgroundResource(R.drawable.pb_title_manage_btn_bg_1);
                    chVar.f.setTextColor(a);
                    chVar.h.setTextColor(a);
                    chVar.g.setTextColor(a);
                    chVar.i.setTextColor(a);
                    chVar.f.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    chVar.h.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    chVar.g.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    chVar.i.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    int color = this.a.getResources().getColor(R.color.skin_1_divider_color);
                    chVar.j.setBackgroundColor(color);
                    chVar.k.setBackgroundColor(color);
                    chVar.l.setBackgroundColor(color);
                } else {
                    com.baidu.tieba.c.ae.i(chVar.c, R.drawable.my_title_bg_hl);
                    chVar.d.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg);
                    ColorStateList colorStateList = this.a.getResources().getColorStateList(R.color.pb_title_btn_color);
                    chVar.b.setTextColor(-13421773);
                    chVar.e.setTextColor(-10066330);
                    chVar.e.setBackgroundResource(R.drawable.pb_title_manage_btn_bg);
                    chVar.f.setTextColor(colorStateList);
                    chVar.h.setTextColor(colorStateList);
                    chVar.g.setTextColor(colorStateList);
                    chVar.i.setTextColor(colorStateList);
                    chVar.f.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    chVar.h.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    chVar.g.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    chVar.i.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    chVar.j.setBackgroundColor(-2829100);
                    chVar.k.setBackgroundColor(-2829100);
                    chVar.l.setBackgroundColor(-2829100);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        if (getItemId(i) == -1 || getItemId(i) == -2) {
            return 1;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(int i) {
        this.d = i;
    }

    public boolean c() {
        return this.d != 0;
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.e = i;
    }

    public boolean e() {
        return this.e != 0;
    }

    public int f() {
        return this.e;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean g() {
        return this.g;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean h() {
        return this.h;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean i() {
        return this.j;
    }

    public void c(int i) {
        this.k = i;
        k();
    }

    public int j() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.baidu.tieba.a.k kVar) {
        StringBuffer stringBuffer = new StringBuffer((int) WebChromeClient.STRING_DLG_BTN_SET);
        if (kVar.c() * kVar.b() > com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) {
            double sqrt = Math.sqrt((com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) / (kVar.c() * kVar.b()));
            stringBuffer.append("width=");
            stringBuffer.append(String.valueOf((int) (kVar.b() * sqrt)));
            stringBuffer.append("&height=");
            stringBuffer.append(String.valueOf((int) (sqrt * kVar.c())));
        } else {
            float b = kVar.b() / kVar.c();
            double sqrt2 = Math.sqrt((com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) / b);
            stringBuffer.append("width=");
            stringBuffer.append(String.valueOf((int) (b * sqrt2)));
            stringBuffer.append("&height=");
            stringBuffer.append(String.valueOf((int) sqrt2));
        }
        stringBuffer.append("&src=");
        stringBuffer.append(com.baidu.tieba.c.af.f(kVar.f()));
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.k a(ArrayList arrayList, int i) {
        int i2;
        if (arrayList == null || i < 0) {
            return null;
        }
        int size = arrayList.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            if (arrayList.get(i4) != null && ((com.baidu.tieba.a.k) arrayList.get(i4)).a() == 3) {
                i2 = i3 + 1;
                if (i2 == i) {
                    if (((com.baidu.tieba.a.k) arrayList.get(i4)).b() >= 50 || ((com.baidu.tieba.a.k) arrayList.get(i4)).c() >= 50) {
                        return (com.baidu.tieba.a.k) arrayList.get(i4);
                    }
                    return null;
                } else if (i2 > i) {
                    break;
                }
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        return null;
    }
}
