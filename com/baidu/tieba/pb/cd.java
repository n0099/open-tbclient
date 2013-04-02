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
public class cd extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.c.a c;
    private int d;
    private int e;
    private com.baidu.tieba.b.r f;
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

    public cd(Context context, com.baidu.tieba.b.r rVar, int i, View.OnClickListener onClickListener) {
        this.f = rVar;
        this.a = context;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().d();
            this.o = this.f.a().l();
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
        this.p = TiebaApplication.y();
        this.q = onClickListener;
    }

    private void k() {
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.a.i.k());
        this.l = textView.getLineHeight();
        this.m = (int) textView.getTextSize();
    }

    public void a(com.baidu.tieba.b.r rVar) {
        this.f = rVar;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().d();
            this.o = this.f.a().l();
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
        pbImageView.setOnClickListener(new ci(this, arrayList, i));
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
        imageView.setOnClickListener(new ce(this));
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
        if (TiebaApplication.b().ah() == 1) {
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
        ck ckVar;
        int itemViewType;
        View view3;
        cl clVar;
        View view4;
        long itemId;
        int i2;
        TextView textView;
        int i3;
        com.baidu.tieba.a.ax b;
        if (this.b == null) {
            return view;
        }
        try {
            resources = this.a.getResources();
            ckVar = null;
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    if (this.f.a().k()) {
                        view4 = from.inflate(R.layout.pb_item_has_floor, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.pb_item, (ViewGroup) null);
                    }
                    cl clVar2 = new cl(this, null);
                    clVar2.g = (ImageView) view4.findViewById(R.id.photo);
                    clVar2.i = (TextView) view4.findViewById(R.id.user_name);
                    clVar2.j = (TextView) view4.findViewById(R.id.floor);
                    clVar2.k = (TextView) view4.findViewById(R.id.rank);
                    clVar2.l = (TextView) view4.findViewById(R.id.time);
                    clVar2.m = (TextView) view4.findViewById(R.id.text);
                    clVar2.m.setLineSpacing(0.0f, 1.2f);
                    clVar2.n = (LinearLayout) view4.findViewById(R.id.seg);
                    clVar2.h = (ImageView) view4.findViewById(R.id.mark);
                    clVar2.d = new cj(this);
                    clVar2.f = new cg(this);
                    clVar2.e = new ch(this);
                    clVar2.g.setOnClickListener(clVar2.d);
                    clVar2.i.setOnClickListener(clVar2.d);
                    clVar2.q = (TextView) view4.findViewById(R.id.forbid_user);
                    clVar2.r = (TextView) view4.findViewById(R.id.del_post);
                    clVar2.s = view4.findViewById(R.id.manage_divider);
                    clVar2.a = -1;
                    clVar2.g.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.c.e.a((int) R.drawable.photo_bg)));
                    if (this.f.a().k()) {
                        clVar2.o = (TextView) view4.findViewById(R.id.text_reply_num);
                        clVar2.p = (ImageView) view4.findViewById(R.id.image_reply_num);
                    }
                    view4.setTag(clVar2);
                    clVar = clVar2;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    cl clVar3 = new cl(this, null);
                    clVar3.b = (TextView) view4.findViewById(R.id.page_text);
                    clVar3.c = (ProgressBar) view4.findViewById(R.id.progress);
                    clVar3.a = -1;
                    this.i.add(clVar3.c);
                    view4.setTag(clVar3);
                    clVar = clVar3;
                } else {
                    view4 = from.inflate(R.layout.pb_thread_name, (ViewGroup) null);
                    ckVar = new ck(this, null);
                    ckVar.c = (LinearLayout) view4.findViewById(R.id.top_bar);
                    ckVar.b = (TextView) view4.findViewById(R.id.thread_name);
                    ckVar.e = (Button) view4.findViewById(R.id.pb_title_manage_btn);
                    ckVar.d = (LinearLayout) view4.findViewById(R.id.bottom_bar);
                    ckVar.f = (Button) view4.findViewById(R.id.commit_top);
                    ckVar.h = (Button) view4.findViewById(R.id.cancel_top);
                    ckVar.g = (Button) view4.findViewById(R.id.commit_good);
                    ckVar.i = (Button) view4.findViewById(R.id.cancel_good);
                    ckVar.j = view4.findViewById(R.id.line1);
                    ckVar.k = view4.findViewById(R.id.line2);
                    ckVar.l = view4.findViewById(R.id.line3);
                    ckVar.a = -1;
                    ckVar.d.setVisibility(8);
                    ckVar.g.setOnClickListener(this.q);
                    ckVar.i.setOnClickListener(this.q);
                    ckVar.f.setOnClickListener(this.q);
                    ckVar.h.setOnClickListener(this.q);
                    ckVar.c.setPadding(0, ((PbActivity) this.a).j(), 0, 0);
                    if (this.f != null && this.f.a() != null && (b = this.f.a().b()) != null && b.c() != null && b.c().length() > 0) {
                        ckVar.b.setText(b.c());
                    }
                    ckVar.e.setTag(ckVar.d);
                    ckVar.e.setOnClickListener(new cf(this));
                    view4.setTag(ckVar);
                    clVar = null;
                }
            } else if (itemViewType == 0 || itemViewType == 1) {
                clVar = (cl) view.getTag();
                view4 = view;
            } else {
                ckVar = (ck) view.getTag();
                clVar = null;
                view4 = view;
            }
            itemId = getItemId(i);
            if (this.f.a().k() && itemViewType == 0) {
                if (getItem(i) != null && ((com.baidu.tieba.a.an) getItem(i)).c() == 1) {
                    clVar.o.setVisibility(4);
                    clVar.p.setVisibility(4);
                } else {
                    clVar.o.setVisibility(0);
                    clVar.p.setVisibility(0);
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
                    clVar.c.setVisibility(0);
                    clVar.b.setText(R.string.loading);
                } else {
                    clVar.c.setVisibility(8);
                    if (this.d == 1) {
                        if (((PbActivity) this.a).i() != null) {
                            clVar.b.setText(R.string.may_have_more);
                        } else if (this.f.c()) {
                            clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        } else {
                            clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().e().a())));
                        }
                    } else if (this.d == 2) {
                        if (((PbActivity) this.a).i() != null) {
                            clVar.b.setText(R.string.load_more);
                        } else if (this.f.c()) {
                            clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                        } else {
                            clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        }
                    } else {
                        clVar.b.setText((CharSequence) null);
                    }
                }
                a(clVar);
                return view4;
            } else if (itemId == -2) {
                if (this.g) {
                    clVar.c.setVisibility(0);
                    clVar.b.setText(R.string.loading);
                } else {
                    clVar.c.setVisibility(8);
                    if (this.e == 1 || this.e == 2) {
                        if (((PbActivity) this.a).i() != null) {
                            clVar.b.setText(R.string.may_have_more);
                        } else if (this.f.c()) {
                            if (this.f.k() == this.f.a().e().a()) {
                                clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().e().a())));
                            } else {
                                clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                            }
                        } else {
                            clVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                        }
                    } else {
                        clVar.b.setText((CharSequence) null);
                    }
                }
                a(clVar);
                return view4;
            } else if (itemId == -3) {
                if (this.o == 1 && this.f.i()) {
                    ckVar.e.setVisibility(0);
                    ckVar.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.a.getResources().getDrawable(R.drawable.manage_btn_left), (Drawable) null);
                } else {
                    ckVar.e.setVisibility(8);
                    ((LinearLayout) ckVar.e.getTag()).setVisibility(8);
                }
                a(ckVar);
                return view4;
            } else {
                return view4;
            }
        }
        clVar.g.setOnClickListener(null);
        clVar.m.setVisibility(8);
        clVar.m.setText((CharSequence) null);
        clVar.m.setMovementMethod(LinkMovementMethod.getInstance());
        clVar.m.setFocusable(false);
        clVar.n.setVisibility(8);
        clVar.n.removeAllViews();
        clVar.g.setTag(null);
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) getItem(i);
        if (anVar != null) {
            String d = anVar.e().d();
            clVar.g.setVisibility(0);
            clVar.i.setVisibility(0);
            clVar.k.setVisibility(0);
            if (this.f.b()) {
                Bitmap bitmap = null;
                if (d != null && d.length() > 0) {
                    bitmap = this.c.b(d);
                    if (bitmap != null) {
                        clVar.g.setImageBitmap(bitmap);
                    } else {
                        clVar.g.setTag(d);
                    }
                }
                if (bitmap == null) {
                    clVar.g.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                }
                clVar.g.setVisibility(0);
            } else {
                clVar.g.setVisibility(8);
            }
            clVar.d.b(anVar.e().a());
            clVar.d.a(anVar.e().b());
            String a = anVar.e().a();
            if (a == null || a.length() <= 0 || a.equals("0")) {
                if (TiebaApplication.b().ah() == 1) {
                    clVar.i.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    clVar.i.setTextColor(-16777216);
                }
            } else {
                clVar.i.setTextColor(-9989158);
            }
            clVar.g.setOnClickListener(clVar.d);
            if (this.f.n() && this.f.j() != null && anVar.a() != null && this.f.j().equals(anVar.a())) {
                clVar.h.setVisibility(0);
            } else {
                clVar.h.setVisibility(8);
            }
            clVar.i.setTextSize(com.baidu.tieba.a.i.l());
            if (anVar.e() != null) {
                clVar.i.setText(anVar.e().c());
            } else {
                clVar.i.setText((CharSequence) null);
            }
            if (anVar.e() != null && anVar.e().k() != 0) {
                clVar.k.setText(String.valueOf(String.valueOf(anVar.e().k())) + this.a.getString(R.string.grade));
            } else {
                clVar.k.setText((CharSequence) null);
            }
            clVar.l.setText(com.baidu.tieba.c.af.a(anVar.d()));
            if (this.f.a().k()) {
                if (anVar.g() > 0) {
                    clVar.o.setText(String.valueOf(anVar.g()));
                } else {
                    clVar.o.setText((CharSequence) null);
                }
            }
            clVar.j.setText(String.valueOf(String.valueOf(anVar.c())) + this.a.getString(R.string.floor));
            clVar.q.setVisibility(4);
            clVar.r.setVisibility(4);
            if (this.o != 0 && this.f.i()) {
                clVar.q.setVisibility(0);
                clVar.r.setVisibility(0);
                String a2 = anVar.e().a();
                if (a2 != null && a2.equals(this.p)) {
                    clVar.q.setVisibility(4);
                }
                if (a2 == null || a2.equals("0") || a2.length() == 0) {
                    clVar.q.setVisibility(4);
                }
            } else {
                String a3 = this.f.a().b().h().a();
                if (a3 != null && a3.equals(this.p) && anVar.c() != 1) {
                    clVar.r.setVisibility(0);
                }
            }
            clVar.s.setVisibility(4);
            if (clVar.q.getVisibility() == 0 && clVar.r.getVisibility() == 0) {
                clVar.s.setVisibility(0);
            }
            int i4 = 0;
            if (anVar.c() == 1) {
                i4 = 1;
            }
            clVar.f.a(i4);
            clVar.f.a(anVar.a());
            clVar.f.b(this.o);
            clVar.r.setOnClickListener(clVar.f);
            clVar.e.a(anVar.e().b());
            clVar.e.a(this.o);
            clVar.q.setOnClickListener(clVar.e);
            ArrayList f = anVar.f();
            if (f != null && f.size() > 0) {
                TextView textView2 = null;
                com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) f.get(0);
                if (kVar == null || (kVar.a() != 0 && kVar.a() != 2)) {
                    i2 = 0;
                } else {
                    clVar.m.setTextSize(com.baidu.tieba.a.i.k());
                    clVar.m.setVisibility(0);
                    a(clVar.m, kVar);
                    textView2 = clVar.m;
                    i2 = 1;
                }
                int i5 = -1;
                clVar.n.setVisibility(8);
                int i6 = i2;
                while (i6 < f.size()) {
                    clVar.n.setVisibility(0);
                    com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) f.get(i6);
                    if (kVar2.a() == 3) {
                        if (this.j) {
                            int i7 = i5 + 1;
                            clVar.n.addView(a(f, kVar2, i7, this.n));
                            textView = null;
                            i3 = i7;
                        } else {
                            i3 = i5;
                            textView = textView2;
                        }
                    } else if (kVar2.a() == 1000) {
                        clVar.n.addView(a(f, kVar2));
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
                        clVar.n.addView(a4);
                        int i9 = i5;
                        textView = a4;
                        i3 = i9;
                    }
                    i6++;
                    textView2 = textView;
                    i5 = i3;
                }
            } else {
                clVar.m.setVisibility(0);
                clVar.m.setText((CharSequence) null);
            }
            b(clVar);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(cl clVar) {
        try {
            if (clVar.a != TiebaApplication.b().ah()) {
                clVar.a = TiebaApplication.b().ah();
                if (clVar.a == 1) {
                    clVar.b.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    clVar.b.setTextColor(-16777216);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void b(cl clVar) {
        try {
            if (clVar.a != TiebaApplication.b().ah()) {
                clVar.a = TiebaApplication.b().ah();
                if (clVar.a == 1) {
                    clVar.k.setTextColor(com.baidu.tieba.c.ae.b(clVar.a));
                    clVar.s.setBackgroundColor(this.a.getResources().getColor(R.color.skin_1_divider_color));
                    clVar.j.setTextColor(com.baidu.tieba.c.ae.b(clVar.a));
                    clVar.j.setBackgroundResource(R.drawable.floor_bg_1);
                    clVar.m.setTextColor(com.baidu.tieba.c.ae.a(clVar.a));
                    clVar.m.setLinkTextColor(-9989158);
                    clVar.l.setTextColor(com.baidu.tieba.c.ae.b(clVar.a));
                } else {
                    clVar.k.setTextColor(-9276814);
                    clVar.s.setBackgroundColor(-6710887);
                    clVar.j.setTextColor(-9276814);
                    clVar.j.setBackgroundResource(R.drawable.floor_bg);
                    clVar.m.setTextColor(-11974584);
                    clVar.m.setLinkTextColor(-10526484);
                    clVar.l.setTextColor(-9276814);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }

    private void a(ck ckVar) {
        try {
            if (ckVar.a != TiebaApplication.b().ah()) {
                ckVar.a = TiebaApplication.b().ah();
                if (ckVar.a == 1) {
                    com.baidu.tieba.c.ae.h(ckVar.c, R.drawable.my_title_bg_hl_1);
                    ckVar.d.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg_1);
                    int a = com.baidu.tieba.c.ae.a(1);
                    ckVar.b.setTextColor(a);
                    ckVar.e.setTextColor(a);
                    ckVar.e.setBackgroundResource(R.drawable.pb_title_manage_btn_bg_1);
                    ckVar.f.setTextColor(a);
                    ckVar.h.setTextColor(a);
                    ckVar.g.setTextColor(a);
                    ckVar.i.setTextColor(a);
                    ckVar.f.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    ckVar.h.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    ckVar.g.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    ckVar.i.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    int color = this.a.getResources().getColor(R.color.skin_1_divider_color);
                    ckVar.j.setBackgroundColor(color);
                    ckVar.k.setBackgroundColor(color);
                    ckVar.l.setBackgroundColor(color);
                } else {
                    com.baidu.tieba.c.ae.h(ckVar.c, R.drawable.my_title_bg_hl);
                    ckVar.d.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg);
                    ColorStateList colorStateList = this.a.getResources().getColorStateList(R.color.pb_title_btn_color);
                    ckVar.b.setTextColor(-13421773);
                    ckVar.e.setTextColor(-10066330);
                    ckVar.e.setBackgroundResource(R.drawable.pb_title_manage_btn_bg);
                    ckVar.f.setTextColor(colorStateList);
                    ckVar.h.setTextColor(colorStateList);
                    ckVar.g.setTextColor(colorStateList);
                    ckVar.i.setTextColor(colorStateList);
                    ckVar.f.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ckVar.h.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ckVar.g.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ckVar.i.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ckVar.j.setBackgroundColor(-2829100);
                    ckVar.k.setBackgroundColor(-2829100);
                    ckVar.l.setBackgroundColor(-2829100);
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
