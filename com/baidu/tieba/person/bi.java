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
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bi extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.c.bi b;
    private ArrayList c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private com.baidu.tieba.d.a i;
    private View.OnClickListener j;

    public bi(Context context) {
        int i = BdWebErrorView.ERROR_CODE_400;
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = context;
        this.d = false;
        this.e = false;
        this.c = new ArrayList();
        int a = com.baidu.tieba.d.ag.a(context, 267.0f);
        this.h = a <= 400 ? a : i;
        this.i = new com.baidu.tieba.d.a(this.a);
        this.i.a(this.h, (int) (this.h * 1.62f));
        this.j = new bj(this);
    }

    public com.baidu.tieba.d.a a() {
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
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        if (this.b.b().e() == 1) {
            size++;
        }
        if (this.b.b().f() == 1) {
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
            i2 = this.b.b().f() == 1 ? i - 1 : i;
            if (this.b.b().e() == 1 && i == getCount() - 1) {
                i2 = -2;
            }
        } else {
            i2 = i;
        }
        return i2;
    }

    public void a(com.baidu.tieba.c.bi biVar) {
        this.b = biVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00c5, code lost:
        if (r11.e != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c7, code lost:
        if (r2 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00c9, code lost:
        r6.c.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ce, code lost:
        a(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0110, code lost:
        if (r11.d == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0112, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0114, code lost:
        r6.c.setVisibility(8);
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        bk bkVar;
        boolean z;
        boolean z2;
        View view2;
        boolean z3 = true;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.a);
            bk bkVar2 = new bk(this, null);
            if (itemViewType == 0) {
                View inflate = from.inflate(R.layout.person_lbs_item, (ViewGroup) null);
                bkVar2.e = (LinearLayout) inflate.findViewById(R.id.content_bg);
                bkVar2.e.setClickable(true);
                bkVar2.e.setOnClickListener(this.j);
                bkVar2.d = (LinearLayout) inflate.findViewById(R.id.timeline_bg);
                bkVar2.j = (TextView) inflate.findViewById(R.id.time);
                bkVar2.i = (TextView) inflate.findViewById(R.id.position);
                bkVar2.h = (ImageView) inflate.findViewById(R.id.pos_icon);
                bkVar2.g = (TextView) inflate.findViewById(R.id.text);
                bkVar2.f = (ImageView) inflate.findViewById(R.id.image);
                bkVar2.g.setMovementMethod(LinkMovementMethod.getInstance());
                bkVar2.g.setFocusable(false);
                bkVar2.g.setLineSpacing(0.0f, 1.2f);
                bkVar2.k = (TextView) inflate.findViewById(R.id.reply_num);
                a(bkVar2.g);
                view2 = inflate;
            } else {
                View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                bkVar2.b = (TextView) inflate2.findViewById(R.id.page_text);
                bkVar2.c = (ProgressBar) inflate2.findViewById(R.id.progress);
                this.c.add(bkVar2.c);
                view2 = inflate2;
            }
            bkVar2.a = -1;
            view2.setTag(bkVar2);
            bkVar = bkVar2;
            view = view2;
        } else {
            bkVar = (bk) view.getTag();
        }
        if (itemViewType == 1) {
            if (getItemId(i) == -1) {
                bkVar.b.setText(this.a.getString(R.string.pre_page));
            } else {
                bkVar.b.setText(this.a.getString(R.string.next_page));
            }
        } else {
            Object item = getItem(i);
            bkVar.g.setVisibility(8);
            bkVar.g.setText((CharSequence) null);
            bkVar.f.setVisibility(8);
            bkVar.f.setTag(null);
            if (item != null && (item instanceof com.baidu.tieba.a.ao)) {
                com.baidu.tieba.a.ao aoVar = (com.baidu.tieba.a.ao) item;
                bkVar.j.setText(aoVar.a());
                bkVar.e.setTag(aoVar.d());
                com.baidu.tieba.a.ao aoVar2 = (com.baidu.tieba.a.ao) getItem(i - 1);
                if (aoVar2 != null && aoVar2.a() != null && aoVar2.a().equals(aoVar.a())) {
                    bkVar.j.setVisibility(8);
                    a((View) bkVar.d, false);
                } else {
                    bkVar.j.setVisibility(0);
                    a((View) bkVar.d, true);
                }
                if ("".equals(aoVar.c())) {
                    bkVar.i.setVisibility(4);
                    bkVar.h.setVisibility(4);
                } else {
                    bkVar.i.setVisibility(0);
                    bkVar.h.setVisibility(0);
                    bkVar.i.setText(aoVar.c());
                }
                if (aoVar.b() > 0) {
                    bkVar.k.setText(String.valueOf(aoVar.b()));
                    bkVar.k.setVisibility(0);
                } else {
                    bkVar.k.setVisibility(8);
                }
                ArrayList j = aoVar.e().j();
                if (j != null && j.size() > 0) {
                    int size = j.size();
                    int i2 = 0;
                    boolean z4 = false;
                    boolean z5 = false;
                    while (i2 < size) {
                        com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) j.get(i2);
                        if (kVar == null) {
                            break;
                        }
                        if (kVar.a() == 0 || kVar.a() == 2) {
                            bkVar.g.setVisibility(0);
                            if (!z5) {
                                a(bkVar.g, kVar);
                                z = z4;
                                z2 = z5;
                            }
                            z = z4;
                            z2 = z5;
                        } else {
                            if (kVar.a() == 3) {
                                bkVar.f.setVisibility(0);
                                if (z4) {
                                    z = z4;
                                    z2 = true;
                                } else {
                                    int[] a = com.baidu.tieba.d.ag.a(kVar, this.h);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
                                    bkVar.f.setTag(kVar.f());
                                    bkVar.f.setFocusable(false);
                                    bkVar.f.setLayoutParams(layoutParams);
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
                b(bkVar);
            }
        }
        return view;
    }

    private void a(View view, boolean z) {
        if (!z) {
            if (TiebaApplication.d().ai() == 1) {
                view.setBackgroundResource(R.drawable.timeline_below_1);
            } else {
                view.setBackgroundResource(R.drawable.timeline_below);
            }
        } else if (TiebaApplication.d().ai() == 1) {
            view.setBackgroundResource(R.drawable.timeline_above_1);
        } else {
            view.setBackgroundResource(R.drawable.timeline_above);
        }
    }

    private void a(bk bkVar) {
        try {
            if (bkVar.a != TiebaApplication.d().ai()) {
                bkVar.a = TiebaApplication.d().ai();
                if (bkVar.a == 1) {
                    bkVar.b.setTextColor(com.baidu.tieba.d.ac.a(1));
                } else {
                    bkVar.b.setTextColor(-16777216);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void b(bk bkVar) {
        try {
            if (bkVar.a != TiebaApplication.d().ai()) {
                bkVar.a = TiebaApplication.d().ai();
                if (bkVar.a == 1) {
                    bkVar.g.setTextColor(com.baidu.tieba.d.ac.a(bkVar.a));
                    bkVar.g.setLinkTextColor(-9989158);
                    com.baidu.tieba.d.ac.h(bkVar.e, (int) R.drawable.lbs_weitie_bg_1);
                } else {
                    bkVar.g.setTextColor(-11974584);
                    bkVar.g.setLinkTextColor(-10526484);
                    com.baidu.tieba.d.ac.h(bkVar.e, (int) R.drawable.lbs_weitie_bg);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "setItemSkin", e.getMessage());
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
