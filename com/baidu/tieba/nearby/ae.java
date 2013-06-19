package com.baidu.tieba.nearby;

import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NearbyImageView;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.d.a c;
    private int d;
    private int e;
    private com.baidu.tieba.c.bg f;
    private boolean g;
    private boolean h;
    private ArrayList i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    public ae(Context context, com.baidu.tieba.c.bg bgVar, int i, View.OnClickListener onClickListener) {
        this.f = bgVar;
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
        this.c = new com.baidu.tieba.d.a(this.a);
        this.c.a(this.n, (int) (this.n * 1.62f));
        this.i = new ArrayList();
        this.o = com.baidu.tieba.d.ag.a(context, 10.0f);
    }

    private void i() {
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.0f);
        this.l = textView.getLineHeight();
        this.m = (int) textView.getTextSize();
    }

    public void a(com.baidu.tieba.c.bg bgVar) {
        this.f = bgVar;
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
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    public com.baidu.tieba.d.a b() {
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
        NearbyImageView nearbyImageView = new NearbyImageView(this.a);
        int[] a = com.baidu.tieba.d.ag.a(kVar, i2);
        int i3 = this.n;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, (int) ((i3 * a[1]) / a[0]));
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        nearbyImageView.setScaleType(ImageView.ScaleType.CENTER);
        nearbyImageView.setTag(kVar.f());
        nearbyImageView.setClickable(false);
        nearbyImageView.setFocusable(false);
        nearbyImageView.setLayoutParams(layoutParams);
        return nearbyImageView;
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
        imageView.setOnClickListener(new af(this));
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
        ai aiVar;
        View view4;
        long itemId;
        com.baidu.tieba.a.ar arVar;
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
                        ai aiVar2 = new ai(this, null);
                        aiVar2.e = (ImageView) view4.findViewById(R.id.portrait);
                        aiVar2.f = (TextView) view4.findViewById(R.id.text_time);
                        aiVar2.g = (TextView) view4.findViewById(R.id.text_content);
                        aiVar2.g.setLineSpacing(0.0f, 1.0f);
                        aiVar2.h = (LinearLayout) view4.findViewById(R.id.seg);
                        aiVar2.d = new ah(this);
                        aiVar2.e.setOnClickListener(aiVar2.d);
                        aiVar2.k = (RelativeLayout) view4.findViewById(R.id.nearby_post_layout);
                        aiVar2.a = -1;
                        view4.setTag(aiVar2);
                        aiVar = aiVar2;
                    } else if (itemViewType == 1) {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        ai aiVar3 = new ai(this, null);
                        aiVar3.b = (TextView) view4.findViewById(R.id.page_text);
                        aiVar3.c = (ProgressBar) view4.findViewById(R.id.progress);
                        aiVar3.a = -1;
                        this.i.add(aiVar3.c);
                        view4.setTag(aiVar3);
                        aiVar = aiVar3;
                    } else {
                        view4 = from.inflate(R.layout.nearby_pb_thread, (ViewGroup) null);
                        ai aiVar4 = new ai(this, null);
                        aiVar4.e = (ImageView) view4.findViewById(R.id.portrait);
                        aiVar4.o = (TextView) view4.findViewById(R.id.text_user);
                        aiVar4.f = (TextView) view4.findViewById(R.id.text_time);
                        aiVar4.g = (TextView) view4.findViewById(R.id.text_content);
                        aiVar4.g.setLineSpacing(0.0f, 1.0f);
                        aiVar4.h = (LinearLayout) view4.findViewById(R.id.seg);
                        aiVar4.d = new ah(this);
                        aiVar4.e.setOnClickListener(aiVar4.d);
                        aiVar4.o.setOnClickListener(aiVar4.d);
                        aiVar4.l = (TextView) view4.findViewById(R.id.place);
                        aiVar4.m = (LinearLayout) view4.findViewById(R.id.layout_place);
                        aiVar4.n = (LinearLayout) view4.findViewById(R.id.nearby_thread_layout);
                        aiVar4.i = (ImageView) view4.findViewById(R.id.nearby_thread_left1);
                        aiVar4.j = (ImageView) view4.findViewById(R.id.nearby_thread_left2);
                        aiVar4.a = -1;
                        view4.setTag(aiVar4);
                        aiVar = aiVar4;
                    }
                } else {
                    aiVar = (ai) view.getTag();
                    view4 = view;
                }
                itemId = getItemId(i);
            } catch (Exception e) {
                exc = e;
                view2 = view3;
                com.baidu.tieba.d.ae.b("PbAdapter", "getView", "error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        if (itemViewType == 1) {
            if (itemId == -1) {
                if (this.h) {
                    aiVar.c.setVisibility(0);
                    aiVar.b.setText(R.string.loading);
                } else {
                    aiVar.c.setVisibility(8);
                    if (this.d == 1) {
                        aiVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.c())));
                    } else if (this.d == 2) {
                        aiVar.b.setText(MessageFormat.format(resources.getString(R.string.load_prev_page), Integer.valueOf(this.f.d())));
                    } else {
                        aiVar.b.setText((CharSequence) null);
                    }
                }
                a(aiVar);
                return view4;
            } else if (itemId == -2) {
                boolean z2 = true;
                if (this.g) {
                    aiVar.c.setVisibility(0);
                    aiVar.b.setText(R.string.loading);
                } else {
                    aiVar.c.setVisibility(8);
                    if (this.e == 1 || this.e == 2) {
                        if (this.f.c() == this.f.a().e().a()) {
                            aiVar.b.setText(MessageFormat.format(resources.getString(R.string.load_more_atlast), Integer.valueOf(this.f.a().e().a())));
                        } else {
                            aiVar.b.setText(MessageFormat.format(resources.getString(R.string.load_next_page), Integer.valueOf(this.f.c())));
                        }
                        if (this.f.a().d().size() <= 1) {
                            aiVar.b.setText(this.a.getString(R.string.nearby_pb_nodata));
                            aiVar.b.setFocusable(true);
                            aiVar.b.setTextSize(2, 13.0f);
                            z2 = false;
                        } else {
                            aiVar.b.setFocusable(false);
                            aiVar.b.setTextSize(2, 17.0f);
                            z2 = true;
                        }
                    } else {
                        aiVar.b.setText((CharSequence) null);
                    }
                }
                a(aiVar, z2);
                return view4;
            } else {
                return view4;
            }
        }
        aiVar.e.setOnClickListener(null);
        aiVar.g.setVisibility(8);
        aiVar.g.setText((CharSequence) null);
        aiVar.g.setMovementMethod(LinkMovementMethod.getInstance());
        aiVar.g.setFocusable(false);
        aiVar.h.setVisibility(8);
        aiVar.h.removeAllViews();
        aiVar.e.setTag(null);
        if (itemViewType == 2) {
            aiVar.l.setText((CharSequence) null);
        }
        if (itemViewType == 2) {
            arVar = this.f.a().j();
        } else {
            arVar = (com.baidu.tieba.a.ar) getItem(i);
        }
        if (arVar != null) {
            String e3 = arVar.h().e();
            aiVar.e.setVisibility(0);
            if (this.f.b()) {
                com.baidu.adp.widget.a.b bVar = null;
                if (e3 != null && e3.length() > 0) {
                    bVar = this.c.b(e3);
                    if (bVar != null) {
                        bVar.b(aiVar.e);
                    } else {
                        aiVar.e.setTag(e3);
                    }
                }
                if (bVar == null) {
                    aiVar.e.setImageBitmap(com.baidu.tieba.d.d.a((int) R.drawable.photo));
                }
                aiVar.e.setVisibility(0);
            } else {
                aiVar.e.setVisibility(8);
            }
            aiVar.d.b(arVar.h().a());
            aiVar.d.a(arVar.h().c());
            aiVar.e.setOnClickListener(aiVar.d);
            if (itemViewType == 2) {
                aiVar.o.setTextColor(-9989158);
                if (arVar.h() != null) {
                    aiVar.o.setText(arVar.h().d());
                } else {
                    aiVar.o.setText((CharSequence) null);
                }
            }
            new Date().setTime(arVar.g());
            aiVar.f.setText(arVar.e());
            if (itemViewType == 2) {
                String a = this.f.a().c().a();
                if (a == null || a.equalsIgnoreCase("")) {
                    aiVar.m.setVisibility(8);
                } else {
                    aiVar.m.setVisibility(0);
                    aiVar.l.setText(a);
                }
            }
            ArrayList j = arVar.j();
            if (itemViewType == 2) {
                if (j != null && j.size() > 0) {
                    int i3 = -1;
                    boolean z3 = false;
                    aiVar.h.setVisibility(8);
                    int i4 = 0;
                    while (i4 < j.size()) {
                        aiVar.h.setVisibility(0);
                        com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) j.get(i4);
                        if (kVar.a() == 3) {
                            if (this.j) {
                                i2 = i3 + 1;
                                aiVar.h.addView(a(j, kVar, i2, this.n));
                                z = true;
                            }
                            z = z3;
                            i2 = i3;
                        } else if (kVar.a() == 1000) {
                            aiVar.h.addView(a(j, kVar));
                            z = true;
                            i2 = i3;
                        } else {
                            aiVar.g.setVisibility(0);
                            if (kVar.a() == 2) {
                                aiVar.g.append(kVar.a(this.a, this.l, this.m));
                                z = z3;
                                i2 = i3;
                            } else {
                                aiVar.g.append(kVar.e());
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
                        layoutParams.setMargins(0, 0, 0, com.baidu.tieba.d.ag.a(this.a, 8.0f));
                        aiVar.g.setLayoutParams(layoutParams);
                    }
                } else {
                    aiVar.g.setVisibility(0);
                    aiVar.g.setText((CharSequence) null);
                }
            } else if (itemViewType == 0) {
                if (arVar.h() == null) {
                    str = null;
                    spannableStringBuilder = new SpannableStringBuilder("：");
                    str2 = null;
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.valueOf(arVar.h().d()) + "：");
                    str = arVar.h().c();
                    spannableStringBuilder = spannableStringBuilder2;
                    str2 = arVar.h().a();
                }
                int length = spannableStringBuilder.length();
                if (j != null && j.size() > 0) {
                    for (int i5 = 0; i5 < j.size(); i5++) {
                        com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) j.get(i5);
                        if (kVar2.a() == 0) {
                            spannableStringBuilder.append((CharSequence) kVar2.e());
                        } else if (kVar2.a() == 2) {
                            spannableStringBuilder.append((CharSequence) kVar2.a(this.a, aiVar.g.getLineHeight(), (int) aiVar.g.getTextSize()));
                        }
                    }
                }
                spannableStringBuilder.setSpan(new ag(this, str, str2), 0, length, 18);
                aiVar.g.setText(spannableStringBuilder);
                aiVar.g.setMovementMethod(LinkMovementMethod.getInstance());
                aiVar.g.setVisibility(0);
            }
            a(aiVar, itemViewType);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(ai aiVar, boolean z) {
        try {
            aiVar.a = TiebaApplication.e().as();
            if (aiVar.a == 1) {
                if (z) {
                    aiVar.b.setTextColor(com.baidu.tieba.d.ac.a(1));
                } else {
                    aiVar.b.setTextColor(com.baidu.tieba.d.ac.c(1));
                }
            } else if (z) {
                aiVar.b.setTextColor(-16777216);
            } else {
                aiVar.b.setTextColor(this.a.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void a(ai aiVar) {
        a(aiVar, true);
    }

    private void a(ai aiVar, int i) {
        try {
            if (aiVar.a != TiebaApplication.e().as()) {
                aiVar.a = TiebaApplication.e().as();
                if (aiVar.a == 1) {
                    aiVar.g.setTextColor(-6710887);
                    aiVar.g.setLinkTextColor(-9989158);
                    aiVar.f.setTextColor(-10066330);
                    if (i == 2) {
                        aiVar.l.setTextColor(-6710887);
                        aiVar.n.setBackgroundResource(R.drawable.nearby_post_bg_1);
                        aiVar.n.setPadding(this.o, this.o, this.o, this.o);
                        aiVar.i.setBackgroundColor(-14983539);
                        aiVar.j.setBackgroundColor(-14983539);
                    } else if (i == 0) {
                        aiVar.k.setBackgroundResource(R.drawable.nearby_pb_bg_1);
                        aiVar.k.setPadding(this.o, this.o, this.o, this.o);
                    }
                } else {
                    aiVar.g.setTextColor(-14277082);
                    aiVar.g.setLinkTextColor(-10526484);
                    aiVar.f.setTextColor(-6710887);
                    if (i == 2) {
                        aiVar.l.setTextColor(-6710887);
                        aiVar.n.setBackgroundResource(R.drawable.nearby_post_bg);
                        aiVar.n.setPadding(this.o, this.o, this.o, this.o);
                        aiVar.i.setBackgroundColor(-14114073);
                        aiVar.j.setBackgroundColor(-14114073);
                    } else if (i == 0) {
                        aiVar.k.setBackgroundResource(R.drawable.nearby_pb_bg);
                        aiVar.k.setPadding(this.o, this.o, this.o, this.o);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "setItemSkin", e.getMessage());
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
