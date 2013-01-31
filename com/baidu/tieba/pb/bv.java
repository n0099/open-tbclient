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
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bv extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.c.a c;
    private int d;
    private int e;
    private com.baidu.tieba.b.p f;
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

    public bv(Context context, com.baidu.tieba.b.p pVar, int i, View.OnClickListener onClickListener) {
        this.f = pVar;
        this.a = context;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().c();
            this.o = this.f.a().g();
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
        this.p = TiebaApplication.w();
        this.q = onClickListener;
    }

    private void k() {
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.a.i.k());
        this.l = textView.getLineHeight();
        this.m = (int) textView.getTextSize();
    }

    public void a(com.baidu.tieba.b.p pVar) {
        this.f = pVar;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().c();
            this.o = this.f.a().g();
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
                        com.baidu.tieba.c.af.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        com.baidu.tieba.view.ag agVar = new com.baidu.tieba.view.ag(this.a);
        int[] a = com.baidu.tieba.c.ah.a(kVar, i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
        layoutParams.topMargin = com.baidu.tieba.c.ah.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        agVar.setScaleType(ImageView.ScaleType.CENTER);
        agVar.setTag(kVar.f());
        agVar.setClickable(true);
        agVar.setFocusable(false);
        agVar.setOnClickListener(new ca(this, arrayList, i));
        agVar.setLayoutParams(layoutParams);
        return agVar;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.k kVar) {
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.tieba.c.ah.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTag(kVar.f());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setImageDrawable(this.a.getResources().getDrawable(R.drawable.video_pic));
        imageView.setOnClickListener(new bw(this));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private TextView a(com.baidu.tieba.a.k kVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = com.baidu.tieba.c.ah.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.a.i.k());
        if (TiebaApplication.b().af() == 1) {
            customTextView.setTextColor(com.baidu.tieba.c.ad.a(1));
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
        cc ccVar;
        int itemViewType;
        View view3;
        cd cdVar;
        View view4;
        long itemId;
        int i2;
        TextView textView;
        int i3;
        com.baidu.tieba.a.av b;
        if (this.b == null) {
            return view;
        }
        try {
            resources = this.a.getResources();
            ccVar = null;
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    if (this.f.a().f()) {
                        view4 = from.inflate(R.layout.pb_item_has_floor, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.pb_item, (ViewGroup) null);
                    }
                    cd cdVar2 = new cd(this, null);
                    cdVar2.g = (ImageView) view4.findViewById(R.id.photo);
                    cdVar2.i = (TextView) view4.findViewById(R.id.user_name);
                    cdVar2.j = (TextView) view4.findViewById(R.id.floor);
                    cdVar2.k = (TextView) view4.findViewById(R.id.rank);
                    cdVar2.l = (TextView) view4.findViewById(R.id.time);
                    cdVar2.m = (TextView) view4.findViewById(R.id.text);
                    cdVar2.m.setLineSpacing(0.0f, 1.2f);
                    cdVar2.n = (LinearLayout) view4.findViewById(R.id.seg);
                    cdVar2.h = (ImageView) view4.findViewById(R.id.mark);
                    cdVar2.d = new cb(this);
                    cdVar2.f = new by(this);
                    cdVar2.e = new bz(this);
                    cdVar2.g.setOnClickListener(cdVar2.d);
                    cdVar2.i.setOnClickListener(cdVar2.d);
                    cdVar2.q = (TextView) view4.findViewById(R.id.forbid_user);
                    cdVar2.r = (TextView) view4.findViewById(R.id.del_post);
                    cdVar2.s = view4.findViewById(R.id.manage_divider);
                    cdVar2.a = -1;
                    cdVar2.g.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.c.e.a((int) R.drawable.photo_bg)));
                    if (this.f.a().f()) {
                        cdVar2.o = (TextView) view4.findViewById(R.id.text_reply_num);
                        cdVar2.p = (ImageView) view4.findViewById(R.id.image_reply_num);
                    }
                    view4.setTag(cdVar2);
                    cdVar = cdVar2;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    cd cdVar3 = new cd(this, null);
                    cdVar3.b = (TextView) view4.findViewById(R.id.page_text);
                    cdVar3.c = (ProgressBar) view4.findViewById(R.id.progress);
                    cdVar3.a = -1;
                    this.i.add(cdVar3.c);
                    view4.setTag(cdVar3);
                    cdVar = cdVar3;
                } else {
                    view4 = from.inflate(R.layout.pb_thread_name, (ViewGroup) null);
                    ccVar = new cc(this, null);
                    ccVar.c = (LinearLayout) view4.findViewById(R.id.top_bar);
                    ccVar.b = (TextView) view4.findViewById(R.id.thread_name);
                    ccVar.e = (Button) view4.findViewById(R.id.pb_title_manage_btn);
                    ccVar.d = (LinearLayout) view4.findViewById(R.id.bottom_bar);
                    ccVar.f = (Button) view4.findViewById(R.id.commit_top);
                    ccVar.h = (Button) view4.findViewById(R.id.cancel_top);
                    ccVar.g = (Button) view4.findViewById(R.id.commit_good);
                    ccVar.i = (Button) view4.findViewById(R.id.cancel_good);
                    ccVar.j = view4.findViewById(R.id.line1);
                    ccVar.k = view4.findViewById(R.id.line2);
                    ccVar.l = view4.findViewById(R.id.line3);
                    ccVar.a = -1;
                    ccVar.d.setVisibility(8);
                    ccVar.g.setOnClickListener(this.q);
                    ccVar.i.setOnClickListener(this.q);
                    ccVar.f.setOnClickListener(this.q);
                    ccVar.h.setOnClickListener(this.q);
                    ccVar.c.setPadding(0, ((PbActivity) this.a).j(), 0, 0);
                    if (this.f != null && this.f.a() != null && (b = this.f.a().b()) != null && b.c() != null && b.c().length() > 0) {
                        ccVar.b.setText(b.c());
                    }
                    ccVar.e.setTag(ccVar.d);
                    ccVar.e.setOnClickListener(new bx(this));
                    view4.setTag(ccVar);
                    cdVar = null;
                }
            } else if (itemViewType == 0 || itemViewType == 1) {
                cdVar = (cd) view.getTag();
                view4 = view;
            } else {
                ccVar = (cc) view.getTag();
                cdVar = null;
                view4 = view;
            }
            itemId = getItemId(i);
            if (this.f.a().f() && itemViewType == 0) {
                if (getItem(i) != null && ((com.baidu.tieba.a.an) getItem(i)).b() == 1) {
                    cdVar.o.setVisibility(4);
                    cdVar.p.setVisibility(4);
                } else {
                    cdVar.o.setVisibility(0);
                    cdVar.p.setVisibility(0);
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view3;
            com.baidu.tieba.c.af.b("PbAdapter", "getView", "error = " + exc.getMessage());
            return view2;
        }
        if (itemViewType == 1 || itemViewType == 2) {
            if (itemId == -1) {
                if (this.h) {
                    cdVar.c.setVisibility(0);
                    cdVar.b.setText(R.string.loading);
                } else {
                    cdVar.c.setVisibility(8);
                    if (this.d == 1) {
                        if (this.f.n() || ((PbActivity) this.a).i() != null) {
                            cdVar.b.setText(R.string.may_have_more);
                        } else if (this.f.c()) {
                            cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        } else {
                            cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().d().a())));
                        }
                    } else if (this.d == 2) {
                        if (this.f.n() || ((PbActivity) this.a).i() != null) {
                            cdVar.b.setText(R.string.load_more);
                        } else if (this.f.c()) {
                            cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                        } else {
                            cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        }
                    } else {
                        cdVar.b.setText((CharSequence) null);
                    }
                }
                a(cdVar);
                return view4;
            } else if (itemId == -2) {
                if (this.g) {
                    cdVar.c.setVisibility(0);
                    cdVar.b.setText(R.string.loading);
                } else {
                    cdVar.c.setVisibility(8);
                    if (this.e == 1 || this.e == 2) {
                        if (this.f.n() || ((PbActivity) this.a).i() != null) {
                            cdVar.b.setText(R.string.may_have_more);
                        } else if (this.f.c()) {
                            if (this.f.k() == this.f.a().d().a()) {
                                cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().d().a())));
                            } else {
                                cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                            }
                        } else {
                            cdVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                        }
                    } else {
                        cdVar.b.setText((CharSequence) null);
                    }
                }
                a(cdVar);
                return view4;
            } else if (itemId == -3) {
                if (this.o == 1 && this.f.i()) {
                    ccVar.e.setVisibility(0);
                    ccVar.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.a.getResources().getDrawable(R.drawable.manage_btn_left), (Drawable) null);
                } else {
                    ccVar.e.setVisibility(8);
                    ((LinearLayout) ccVar.e.getTag()).setVisibility(8);
                }
                a(ccVar);
                return view4;
            } else {
                return view4;
            }
        }
        cdVar.g.setOnClickListener(null);
        cdVar.m.setVisibility(8);
        cdVar.m.setText((CharSequence) null);
        cdVar.m.setMovementMethod(LinkMovementMethod.getInstance());
        cdVar.m.setFocusable(false);
        cdVar.n.setVisibility(8);
        cdVar.n.removeAllViews();
        cdVar.g.setTag(null);
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) getItem(i);
        if (anVar != null) {
            String d = anVar.d().d();
            cdVar.g.setVisibility(0);
            cdVar.i.setVisibility(0);
            cdVar.k.setVisibility(0);
            if (this.f.b()) {
                Bitmap bitmap = null;
                if (d != null && d.length() > 0) {
                    bitmap = this.c.b(d);
                    if (bitmap != null) {
                        cdVar.g.setImageBitmap(bitmap);
                    } else {
                        cdVar.g.setTag(d);
                    }
                }
                if (bitmap == null) {
                    cdVar.g.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                }
                cdVar.g.setVisibility(0);
            } else {
                cdVar.g.setVisibility(8);
            }
            cdVar.d.b(anVar.d().a());
            cdVar.d.a(anVar.d().b());
            String a = anVar.d().a();
            if (a == null || a.length() <= 0 || a.equals("0")) {
                if (TiebaApplication.b().af() == 1) {
                    cdVar.i.setTextColor(com.baidu.tieba.c.ad.a(1));
                } else {
                    cdVar.i.setTextColor(-16777216);
                }
            } else {
                cdVar.i.setTextColor(-9989158);
            }
            cdVar.g.setOnClickListener(cdVar.d);
            if (this.f.j() != null && anVar.a() != null && this.f.j().equals(anVar.a())) {
                cdVar.h.setVisibility(0);
            } else {
                cdVar.h.setVisibility(8);
            }
            cdVar.i.setTextSize(com.baidu.tieba.a.i.l());
            if (anVar.d() != null) {
                cdVar.i.setText(anVar.d().c());
            } else {
                cdVar.i.setText((CharSequence) null);
            }
            if (anVar.d() != null && anVar.d().k() != 0) {
                cdVar.k.setText(String.valueOf(String.valueOf(anVar.d().k())) + this.a.getString(R.string.grade));
            } else {
                cdVar.k.setText((CharSequence) null);
            }
            cdVar.l.setText(com.baidu.tieba.c.ae.a(anVar.c()));
            if (this.f.a().f()) {
                if (anVar.f() > 0) {
                    cdVar.o.setText(String.valueOf(anVar.f()));
                } else {
                    cdVar.o.setText((CharSequence) null);
                }
            }
            cdVar.j.setText(String.valueOf(String.valueOf(anVar.b())) + this.a.getString(R.string.floor));
            cdVar.q.setVisibility(4);
            cdVar.r.setVisibility(4);
            if (this.o != 0 && this.f.i()) {
                cdVar.q.setVisibility(0);
                cdVar.r.setVisibility(0);
                String a2 = anVar.d().a();
                if (a2 != null && a2.equals(this.p)) {
                    cdVar.q.setVisibility(4);
                }
                if (a2 == null || a2.equals("0") || a2.length() == 0) {
                    cdVar.q.setVisibility(4);
                }
            } else {
                String a3 = this.f.a().b().h().a();
                if (a3 != null && a3.equals(this.p) && anVar.b() != 1) {
                    cdVar.r.setVisibility(0);
                }
            }
            cdVar.s.setVisibility(4);
            if (cdVar.q.getVisibility() == 0 && cdVar.r.getVisibility() == 0) {
                cdVar.s.setVisibility(0);
            }
            int i4 = 0;
            if (anVar.b() == 1) {
                i4 = 1;
            }
            cdVar.f.a(i4);
            cdVar.f.a(anVar.a());
            cdVar.f.b(this.o);
            cdVar.r.setOnClickListener(cdVar.f);
            cdVar.e.a(anVar.d().b());
            cdVar.e.a(this.o);
            cdVar.q.setOnClickListener(cdVar.e);
            ArrayList e3 = anVar.e();
            if (e3 != null && e3.size() > 0) {
                TextView textView2 = null;
                com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) e3.get(0);
                if (kVar == null || (kVar.a() != 0 && kVar.a() != 2)) {
                    i2 = 0;
                } else {
                    cdVar.m.setTextSize(com.baidu.tieba.a.i.k());
                    cdVar.m.setVisibility(0);
                    a(cdVar.m, kVar);
                    textView2 = cdVar.m;
                    i2 = 1;
                }
                int i5 = -1;
                cdVar.n.setVisibility(8);
                int i6 = i2;
                while (i6 < e3.size()) {
                    cdVar.n.setVisibility(0);
                    com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) e3.get(i6);
                    if (kVar2.a() == 3) {
                        if (this.j) {
                            int i7 = i5 + 1;
                            cdVar.n.addView(a(e3, kVar2, i7, this.n));
                            textView = null;
                            i3 = i7;
                        } else {
                            i3 = i5;
                            textView = textView2;
                        }
                    } else if (kVar2.a() == 1000) {
                        cdVar.n.addView(a(e3, kVar2));
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
                        cdVar.n.addView(a4);
                        int i9 = i5;
                        textView = a4;
                        i3 = i9;
                    }
                    i6++;
                    textView2 = textView;
                    i5 = i3;
                }
            } else {
                cdVar.m.setVisibility(0);
                cdVar.m.setText((CharSequence) null);
            }
            b(cdVar);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(cd cdVar) {
        try {
            if (cdVar.a != TiebaApplication.b().af()) {
                cdVar.a = TiebaApplication.b().af();
                if (cdVar.a == 1) {
                    cdVar.b.setTextColor(com.baidu.tieba.c.ad.a(1));
                } else {
                    cdVar.b.setTextColor(-16777216);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void b(cd cdVar) {
        try {
            if (cdVar.a != TiebaApplication.b().af()) {
                cdVar.a = TiebaApplication.b().af();
                if (cdVar.a == 1) {
                    cdVar.k.setTextColor(com.baidu.tieba.c.ad.b(cdVar.a));
                    cdVar.s.setBackgroundColor(this.a.getResources().getColor(R.color.skin_1_divider_color));
                    cdVar.j.setTextColor(com.baidu.tieba.c.ad.b(cdVar.a));
                    cdVar.j.setBackgroundResource(R.drawable.floor_bg_1);
                    cdVar.m.setTextColor(com.baidu.tieba.c.ad.a(cdVar.a));
                    cdVar.m.setLinkTextColor(-9989158);
                    cdVar.l.setTextColor(com.baidu.tieba.c.ad.b(cdVar.a));
                } else {
                    cdVar.k.setTextColor(-9276814);
                    cdVar.s.setBackgroundColor(-6710887);
                    cdVar.j.setTextColor(-9276814);
                    cdVar.j.setBackgroundResource(R.drawable.floor_bg);
                    cdVar.m.setTextColor(-11974584);
                    cdVar.m.setLinkTextColor(-10526484);
                    cdVar.l.setTextColor(-9276814);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }

    private void a(cc ccVar) {
        try {
            if (ccVar.a != TiebaApplication.b().af()) {
                ccVar.a = TiebaApplication.b().af();
                if (ccVar.a == 1) {
                    com.baidu.tieba.c.ad.i(ccVar.c, R.drawable.my_title_bg_hl_1);
                    ccVar.d.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg_1);
                    int a = com.baidu.tieba.c.ad.a(1);
                    ccVar.b.setTextColor(a);
                    ccVar.e.setTextColor(a);
                    ccVar.e.setBackgroundResource(R.drawable.pb_title_manage_btn_bg_1);
                    ccVar.f.setTextColor(a);
                    ccVar.h.setTextColor(a);
                    ccVar.g.setTextColor(a);
                    ccVar.i.setTextColor(a);
                    ccVar.f.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    ccVar.h.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    ccVar.g.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    ccVar.i.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                    int color = this.a.getResources().getColor(R.color.skin_1_divider_color);
                    ccVar.j.setBackgroundColor(color);
                    ccVar.k.setBackgroundColor(color);
                    ccVar.l.setBackgroundColor(color);
                } else {
                    com.baidu.tieba.c.ad.i(ccVar.c, R.drawable.my_title_bg_hl);
                    ccVar.d.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg);
                    ColorStateList colorStateList = this.a.getResources().getColorStateList(R.color.pb_title_btn_color);
                    ccVar.b.setTextColor(-13421773);
                    ccVar.e.setTextColor(-10066330);
                    ccVar.e.setBackgroundResource(R.drawable.pb_title_manage_btn_bg);
                    ccVar.f.setTextColor(colorStateList);
                    ccVar.h.setTextColor(colorStateList);
                    ccVar.g.setTextColor(colorStateList);
                    ccVar.i.setTextColor(colorStateList);
                    ccVar.f.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ccVar.h.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ccVar.g.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ccVar.i.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                    ccVar.j.setBackgroundColor(-2829100);
                    ccVar.k.setBackgroundColor(-2829100);
                    ccVar.l.setBackgroundColor(-2829100);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "setBawuSkin", e.getMessage());
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
    public boolean a(ArrayList arrayList, int i) {
        int i2;
        if (arrayList == null || i < 0) {
            return false;
        }
        int size = arrayList.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            if (arrayList.get(i4) != null && ((com.baidu.tieba.a.k) arrayList.get(i4)).a() == 3) {
                i2 = i3 + 1;
                if (i2 != i) {
                    if (i2 > i) {
                        break;
                    }
                } else {
                    return ((com.baidu.tieba.a.k) arrayList.get(i4)).b() >= 50 || ((com.baidu.tieba.a.k) arrayList.get(i4)).c() >= 50;
                }
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        return false;
    }
}
