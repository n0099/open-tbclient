package com.baidu.tieba.person;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bj extends BaseAdapter {
    private Context a;
    private ArrayList c;
    private int f;
    private int g;
    private int h;
    private com.baidu.tieba.c.a i;
    private View.OnClickListener j;
    private com.baidu.tieba.b.t b = null;
    private boolean d = false;
    private boolean e = false;

    public bj(Context context) {
        this.a = null;
        this.c = null;
        this.a = context;
        this.c = new ArrayList();
        int a = com.baidu.tieba.c.ai.a(context, 234.0f);
        this.h = a <= 350 ? a : 350;
        this.i = new com.baidu.tieba.c.a(this.a);
        this.i.a(this.h, (int) (this.h * 1.62f));
        this.j = new bk(this);
    }

    public com.baidu.tieba.c.a a() {
        return this.i;
    }

    private void a(TextView textView) {
        if (this.g == 0) {
            this.f = textView.getLineHeight();
            this.g = (int) textView.getTextSize();
        }
    }

    public void b() {
        if (this.c != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.c.size()) {
                    try {
                        ((ProgressBar) this.c.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.c.clear();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        int size = this.b.a().size();
        if (this.b.b().c() == 1) {
            size++;
        }
        if (this.b.b().d() == 1) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b != null) {
            int size = this.b.a().size();
            long itemId = getItemId(i);
            if (itemId >= 0 && itemId < size) {
                return this.b.a().get((int) itemId);
            }
        }
        return null;
    }

    private void a(TextView textView, com.baidu.tieba.a.k kVar) {
        if (textView != null && kVar != null) {
            if (kVar.a() == 2) {
                textView.append(kVar.a(this.a, this.f, this.g));
            } else {
                textView.append(kVar.e());
            }
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        if (this.b != null) {
            i2 = this.b.b().d() == 1 ? i - 1 : i;
            if (this.b.b().c() == 1 && i == getCount() - 1) {
                i2 = -2;
            }
        } else {
            i2 = i;
        }
        return i2;
    }

    public void a(com.baidu.tieba.b.t tVar) {
        this.b = tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a3, code lost:
        if (r11.e != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a5, code lost:
        if (r2 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a7, code lost:
        r6.c.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ac, code lost:
        a(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ee, code lost:
        if (r11.d == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f0, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f2, code lost:
        r6.c.setVisibility(8);
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        bl blVar;
        boolean z;
        boolean z2;
        View view2;
        boolean z3 = true;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.a);
            bl blVar2 = new bl(this, null);
            if (itemViewType == 0) {
                View inflate = from.inflate(R.layout.person_lbs_item, (ViewGroup) null);
                blVar2.e = (LinearLayout) inflate.findViewById(R.id.content_bg);
                blVar2.e.setClickable(true);
                blVar2.e.setOnClickListener(this.j);
                blVar2.d = (LinearLayout) inflate.findViewById(R.id.timeline_bg);
                blVar2.h = (TextView) inflate.findViewById(R.id.time);
                blVar2.g = (TextView) inflate.findViewById(R.id.text);
                blVar2.f = (ImageView) inflate.findViewById(R.id.image);
                blVar2.g.setMovementMethod(LinkMovementMethod.getInstance());
                blVar2.g.setFocusable(false);
                blVar2.g.setLineSpacing(0.0f, 1.2f);
                a(blVar2.g);
                view2 = inflate;
            } else {
                View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                blVar2.b = (TextView) inflate2.findViewById(R.id.page_text);
                blVar2.c = (ProgressBar) inflate2.findViewById(R.id.progress);
                this.c.add(blVar2.c);
                view2 = inflate2;
            }
            blVar2.a = -1;
            view2.setTag(blVar2);
            blVar = blVar2;
            view = view2;
        } else {
            blVar = (bl) view.getTag();
        }
        if (itemViewType == 1) {
            if (getItemId(i) == -1) {
                blVar.b.setText(this.a.getString(R.string.pre_page));
            } else {
                blVar.b.setText(this.a.getString(R.string.next_page));
            }
        } else {
            Object item = getItem(i);
            blVar.g.setVisibility(8);
            blVar.g.setText((CharSequence) null);
            blVar.f.setVisibility(8);
            blVar.f.setTag(null);
            if (item != null && (item instanceof com.baidu.tieba.a.aj)) {
                com.baidu.tieba.a.aj ajVar = (com.baidu.tieba.a.aj) item;
                blVar.h.setText(ajVar.a());
                blVar.e.setTag(ajVar.b());
                com.baidu.tieba.a.aj ajVar2 = (com.baidu.tieba.a.aj) getItem(i - 1);
                if (ajVar2 != null && ajVar2.a() != null && ajVar2.a().equals(ajVar.a())) {
                    blVar.h.setVisibility(8);
                    a((View) blVar.d, false);
                } else {
                    blVar.h.setVisibility(0);
                    a((View) blVar.d, true);
                }
                ArrayList f = ajVar.c().f();
                if (f != null && f.size() > 0) {
                    int size = f.size();
                    int i2 = 0;
                    boolean z4 = false;
                    boolean z5 = false;
                    while (i2 < size) {
                        com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) f.get(i2);
                        if (kVar == null) {
                            break;
                        }
                        if (kVar.a() == 0 || kVar.a() == 2) {
                            blVar.g.setVisibility(0);
                            if (!z5) {
                                a(blVar.g, kVar);
                                z = z4;
                                z2 = z5;
                            }
                            z = z4;
                            z2 = z5;
                        } else {
                            if (kVar.a() == 3) {
                                blVar.f.setVisibility(0);
                                if (z4) {
                                    z = z4;
                                    z2 = true;
                                } else {
                                    int[] a = com.baidu.tieba.c.ai.a(kVar, this.h);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
                                    blVar.f.setTag(kVar.f());
                                    blVar.f.setFocusable(false);
                                    blVar.f.setLayoutParams(layoutParams);
                                    z = true;
                                    z2 = true;
                                }
                            }
                            z = z4;
                            z2 = z5;
                        }
                        i2++;
                        z5 = z2;
                        z4 = z;
                    }
                }
                b(blVar);
            }
        }
        return view;
    }

    private void a(View view, boolean z) {
        if (!z) {
            if (TiebaApplication.b().ag() == 1) {
                view.setBackgroundResource(R.drawable.timeline_below_1);
            } else {
                view.setBackgroundResource(R.drawable.timeline_below);
            }
        } else if (TiebaApplication.b().ag() == 1) {
            view.setBackgroundResource(R.drawable.timeline_above_1);
        } else {
            view.setBackgroundResource(R.drawable.timeline_above);
        }
    }

    private void a(bl blVar) {
        try {
            if (blVar.a != TiebaApplication.b().ag()) {
                blVar.a = TiebaApplication.b().ag();
                if (blVar.a == 1) {
                    blVar.b.setTextColor(com.baidu.tieba.c.ae.a(1));
                } else {
                    blVar.b.setTextColor(-16777216);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void b(bl blVar) {
        try {
            if (blVar.a != TiebaApplication.b().ag()) {
                blVar.a = TiebaApplication.b().ag();
                if (blVar.a == 1) {
                    blVar.g.setTextColor(com.baidu.tieba.c.ae.a(blVar.a));
                    blVar.g.setLinkTextColor(-9989158);
                    com.baidu.tieba.c.ae.i(blVar.e, R.drawable.lbs_weitie_bg_1);
                } else {
                    blVar.g.setTextColor(-11974584);
                    blVar.g.setLinkTextColor(-10526484);
                    com.baidu.tieba.c.ae.i(blVar.e, R.drawable.lbs_weitie_bg);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemId(i) < 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
