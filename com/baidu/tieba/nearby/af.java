package com.baidu.tieba.nearby;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.PbImageView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class af extends BaseAdapter {
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

    public af(Context context, com.baidu.tieba.b.q qVar, int i, View.OnClickListener onClickListener) {
        this.f = qVar;
        this.a = context;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().d();
        } else {
            this.b = null;
        }
        this.j = true;
        this.d = 0;
        this.e = 0;
        this.g = false;
        this.h = false;
        this.k = 3;
        this.n = i;
        this.c = new com.baidu.tieba.c.a(this.a);
        this.c.a(this.n, (int) (this.n * 1.62f));
        this.i = new ArrayList();
        this.o = com.baidu.tieba.c.ai.a(context, 10.0f);
    }

    private void i() {
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.0f);
        this.l = textView.getLineHeight();
        this.m = (int) textView.getTextSize();
    }

    public void a(com.baidu.tieba.b.q qVar) {
        this.f = qVar;
        if (this.f != null && this.f.a() != null) {
            this.b = this.f.a().d();
        } else {
            this.b = null;
        }
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
            int size = this.b.size();
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
        if (i == 0) {
            return 0;
        }
        int i2 = this.d != 0 ? i - 1 : i;
        if (this.d != 0 && i == 1) {
            i2 = -1;
        }
        if (this.e != 0 && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.k kVar, int i, int i2) {
        PbImageView pbImageView = new PbImageView(this.a);
        int[] a = com.baidu.tieba.c.ai.a(kVar, i2);
        int i3 = this.n;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, (int) ((i3 * a[1]) / a[0]));
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbImageView.setScaleType(ImageView.ScaleType.CENTER);
        pbImageView.setTag(kVar.f());
        pbImageView.setClickable(false);
        pbImageView.setFocusable(false);
        pbImageView.setLayoutParams(layoutParams);
        pbImageView.setNearbyPbImage(true);
        return pbImageView;
    }

    private ImageView a(ArrayList arrayList, com.baidu.tieba.a.k kVar) {
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTag(kVar.f());
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setImageDrawable(this.a.getResources().getDrawable(R.drawable.video_pic));
        imageView.setOnClickListener(new ag(this));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00a2: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:22:0x00a1 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        Resources resources;
        int itemViewType;
        View view3;
        aj ajVar;
        View view4;
        long itemId;
        com.baidu.tieba.a.al alVar;
        String str;
        SpannableStringBuilder spannableStringBuilder;
        String str2;
        boolean z;
        int i2;
        if (this.b == null) {
            return view;
        }
        try {
            resources = this.a.getResources();
            itemViewType = getItemViewType(i);
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (itemViewType == 0) {
                        view4 = from.inflate(R.layout.nearby_pb_item, (ViewGroup) null);
                        aj ajVar2 = new aj(this, null);
                        ajVar2.e = (ImageView) view4.findViewById(R.id.portrait);
                        ajVar2.f = (TextView) view4.findViewById(R.id.text_time);
                        ajVar2.g = (TextView) view4.findViewById(R.id.text_content);
                        ajVar2.g.setLineSpacing(0.0f, 1.0f);
                        ajVar2.h = (LinearLayout) view4.findViewById(R.id.seg);
                        ajVar2.d = new ai(this);
                        ajVar2.e.setOnClickListener(ajVar2.d);
                        ajVar2.k = (RelativeLayout) view4.findViewById(R.id.nearby_post_layout);
                        ajVar2.a = -1;
                        view4.setTag(ajVar2);
                        ajVar = ajVar2;
                    } else if (itemViewType == 1) {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        aj ajVar3 = new aj(this, null);
                        ajVar3.b = (TextView) view4.findViewById(R.id.page_text);
                        ajVar3.c = (ProgressBar) view4.findViewById(R.id.progress);
                        ajVar3.a = -1;
                        this.i.add(ajVar3.c);
                        view4.setTag(ajVar3);
                        ajVar = ajVar3;
                    } else {
                        view4 = from.inflate(R.layout.nearby_pb_thread, (ViewGroup) null);
                        aj ajVar4 = new aj(this, null);
                        ajVar4.e = (ImageView) view4.findViewById(R.id.portrait);
                        ajVar4.o = (TextView) view4.findViewById(R.id.text_user);
                        ajVar4.f = (TextView) view4.findViewById(R.id.text_time);
                        ajVar4.g = (TextView) view4.findViewById(R.id.text_content);
                        ajVar4.g.setLineSpacing(0.0f, 1.0f);
                        ajVar4.h = (LinearLayout) view4.findViewById(R.id.seg);
                        ajVar4.d = new ai(this);
                        ajVar4.e.setOnClickListener(ajVar4.d);
                        ajVar4.o.setOnClickListener(ajVar4.d);
                        ajVar4.l = (TextView) view4.findViewById(R.id.place);
                        ajVar4.m = (LinearLayout) view4.findViewById(R.id.layout_place);
                        ajVar4.n = (LinearLayout) view4.findViewById(R.id.nearby_thread_layout);
                        ajVar4.i = (ImageView) view4.findViewById(R.id.nearby_thread_left1);
                        ajVar4.j = (ImageView) view4.findViewById(R.id.nearby_thread_left2);
                        ajVar4.a = -1;
                        view4.setTag(ajVar4);
                        ajVar = ajVar4;
                    }
                } else {
                    ajVar = (aj) view.getTag();
                    view4 = view;
                }
                itemId = getItemId(i);
            } catch (Exception e) {
                exc = e;
                view2 = view3;
                com.baidu.tieba.c.ag.b("PbAdapter", "getView", "error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        if (itemViewType == 1) {
            if (itemId == -1) {
                if (this.h) {
                    ajVar.c.setVisibility(0);
                    ajVar.b.setText(R.string.loading);
                } else {
                    ajVar.c.setVisibility(8);
                    if (this.d == 1) {
                        ajVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                    } else if (this.d == 2) {
                        ajVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.l())));
                    } else {
                        ajVar.b.setText((CharSequence) null);
                    }
                }
                a(ajVar);
                return view4;
            } else if (itemId == -2) {
                boolean z2 = true;
                if (this.g) {
                    ajVar.c.setVisibility(0);
                    ajVar.b.setText(R.string.loading);
                } else {
                    ajVar.c.setVisibility(8);
                    if (this.e == 1 || this.e == 2) {
                        if (this.f.k() == this.f.a().e().a()) {
                            ajVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().e().a())));
                        } else {
                            ajVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.k())));
                        }
                        if (this.f.a().d().size() <= 1) {
                            ajVar.b.setText(this.a.getString(R.string.nearby_pb_nodata));
                            ajVar.b.setFocusable(true);
                            ajVar.b.setTextSize(2, 13.0f);
                            z2 = false;
                        } else {
                            ajVar.b.setFocusable(false);
                            ajVar.b.setTextSize(2, 17.0f);
                            z2 = true;
                        }
                    } else {
                        ajVar.b.setText((CharSequence) null);
                    }
                }
                a(ajVar, z2);
                return view4;
            } else {
                return view4;
            }
        }
        ajVar.e.setOnClickListener(null);
        ajVar.g.setVisibility(8);
        ajVar.g.setText((CharSequence) null);
        ajVar.g.setMovementMethod(LinkMovementMethod.getInstance());
        ajVar.g.setFocusable(false);
        ajVar.h.setVisibility(8);
        ajVar.h.removeAllViews();
        ajVar.e.setTag(null);
        if (itemViewType == 2) {
            ajVar.l.setText((CharSequence) null);
        }
        if (itemViewType == 2) {
            alVar = this.f.a().h();
        } else {
            alVar = (com.baidu.tieba.a.al) getItem(i);
        }
        if (alVar != null) {
            String d = alVar.e().d();
            ajVar.e.setVisibility(0);
            if (this.f.b()) {
                Bitmap bitmap = null;
                if (d != null && d.length() > 0) {
                    bitmap = this.c.b(d);
                    if (bitmap != null) {
                        ajVar.e.setImageBitmap(bitmap);
                    } else {
                        ajVar.e.setTag(d);
                    }
                }
                if (bitmap == null) {
                    ajVar.e.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                }
                ajVar.e.setVisibility(0);
            } else {
                ajVar.e.setVisibility(8);
            }
            ajVar.d.b(alVar.e().a());
            ajVar.d.a(alVar.e().b());
            ajVar.e.setOnClickListener(ajVar.d);
            if (itemViewType == 2) {
                ajVar.o.setTextColor(-9989158);
                if (alVar.e() != null) {
                    ajVar.o.setText(alVar.e().c());
                } else {
                    ajVar.o.setText((CharSequence) null);
                }
            }
            new Date().setTime(alVar.d());
            ajVar.f.setText(alVar.b());
            if (itemViewType == 2) {
                String a = this.f.a().c().a();
                if (a == null || a.equalsIgnoreCase("")) {
                    ajVar.m.setVisibility(8);
                } else {
                    ajVar.m.setVisibility(0);
                    ajVar.l.setText(a);
                }
            }
            ArrayList f = alVar.f();
            if (itemViewType == 2) {
                if (f != null && f.size() > 0) {
                    int i3 = -1;
                    boolean z3 = false;
                    ajVar.h.setVisibility(8);
                    int i4 = 0;
                    while (i4 < f.size()) {
                        ajVar.h.setVisibility(0);
                        com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) f.get(i4);
                        if (kVar.a() == 3) {
                            if (this.j) {
                                i2 = i3 + 1;
                                ajVar.h.addView(a(f, kVar, i2, this.n));
                                z = true;
                            }
                            z = z3;
                            i2 = i3;
                        } else if (kVar.a() == 1000) {
                            ajVar.h.addView(a(f, kVar));
                            z = true;
                            i2 = i3;
                        } else {
                            ajVar.g.setVisibility(0);
                            if (kVar.a() == 2) {
                                ajVar.g.append(kVar.a(this.a, this.l, this.m));
                                z = z3;
                                i2 = i3;
                            } else {
                                ajVar.g.append(kVar.e());
                                z = z3;
                                i2 = i3;
                            }
                        }
                        i4++;
                        i3 = i2;
                        z3 = z;
                    }
                    if (z3) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.setMargins(0, 0, 0, com.baidu.tieba.c.ai.a(this.a, 8.0f));
                        ajVar.g.setLayoutParams(layoutParams);
                    }
                } else {
                    ajVar.g.setVisibility(0);
                    ajVar.g.setText((CharSequence) null);
                }
            } else if (itemViewType == 0) {
                if (alVar.e() == null) {
                    str = null;
                    spannableStringBuilder = new SpannableStringBuilder("：");
                    str2 = null;
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.valueOf(alVar.e().c()) + "：");
                    str = alVar.e().b();
                    spannableStringBuilder = spannableStringBuilder2;
                    str2 = alVar.e().a();
                }
                int length = spannableStringBuilder.length();
                if (f != null && f.size() > 0) {
                    for (int i5 = 0; i5 < f.size(); i5++) {
                        com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) f.get(i5);
                        if (kVar2.a() == 0) {
                            spannableStringBuilder.append((CharSequence) kVar2.e());
                        } else if (kVar2.a() == 2) {
                            spannableStringBuilder.append((CharSequence) kVar2.a(this.a, ajVar.g.getLineHeight(), (int) ajVar.g.getTextSize()));
                        }
                    }
                }
                spannableStringBuilder.setSpan(new ah(this, str, str2), 0, length, 18);
                ajVar.g.setText(spannableStringBuilder);
                ajVar.g.setMovementMethod(LinkMovementMethod.getInstance());
                ajVar.g.setVisibility(0);
            }
            a(ajVar, itemViewType);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(aj ajVar, boolean z) {
        try {
            ajVar.a = TiebaApplication.b().ag();
            if (ajVar.a == 1) {
                if (z) {
                    ajVar.b.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    ajVar.b.setTextColor(com.baidu.tieba.c.ae.c(1));
                }
            } else if (z) {
                ajVar.b.setTextColor(-16777216);
            } else {
                ajVar.b.setTextColor(this.a.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void a(aj ajVar) {
        a(ajVar, true);
    }

    private void a(aj ajVar, int i) {
        try {
            if (ajVar.a != TiebaApplication.b().ag()) {
                ajVar.a = TiebaApplication.b().ag();
                if (ajVar.a == 1) {
                    ajVar.g.setTextColor(-6710887);
                    ajVar.g.setLinkTextColor(-9989158);
                    ajVar.f.setTextColor(-10066330);
                    if (i == 2) {
                        ajVar.l.setTextColor(-6710887);
                        ajVar.n.setBackgroundResource(R.drawable.nearby_post_bg_1);
                        ajVar.n.setPadding(this.o, this.o, this.o, this.o);
                        ajVar.i.setBackgroundColor(-14983539);
                        ajVar.j.setBackgroundColor(-14983539);
                    } else if (i == 0) {
                        ajVar.k.setBackgroundResource(R.drawable.nearby_pb_bg_1);
                        ajVar.k.setPadding(this.o, this.o, this.o, this.o);
                    }
                } else {
                    ajVar.g.setTextColor(-14277082);
                    ajVar.g.setLinkTextColor(-10526484);
                    ajVar.f.setTextColor(-6710887);
                    if (i == 2) {
                        ajVar.l.setTextColor(-6710887);
                        ajVar.n.setBackgroundResource(R.drawable.nearby_post_bg);
                        ajVar.n.setPadding(this.o, this.o, this.o, this.o);
                        ajVar.i.setBackgroundColor(-14114073);
                        ajVar.j.setBackgroundColor(-14114073);
                    } else if (i == 0) {
                        ajVar.k.setBackgroundResource(R.drawable.nearby_pb_bg);
                        ajVar.k.setPadding(this.o, this.o, this.o, this.o);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        long itemId = getItemId(i);
        if (itemId == 0) {
            return 2;
        }
        if (itemId == -1 || itemId == -2) {
            return 1;
        }
        return 0;
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

    public void b(int i) {
        this.e = i;
    }

    public boolean d() {
        return this.e != 0;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean e() {
        return this.g;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean f() {
        return this.h;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean g() {
        return this.j;
    }

    public void c(int i) {
        this.k = i;
        i();
    }

    public int h() {
        return this.k;
    }
}
