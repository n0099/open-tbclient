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
public class bj extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.model.bl b;
    private ArrayList c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private com.baidu.tieba.util.a i;
    private View.OnClickListener j;

    public bj(Context context) {
        int i = BdWebErrorView.ERROR_CODE_400;
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = context;
        this.d = false;
        this.e = false;
        this.c = new ArrayList();
        int a = com.baidu.tieba.util.ab.a(context, 267.0f);
        this.h = a <= 400 ? a : i;
        this.i = new com.baidu.tieba.util.a(this.a);
        this.i.a(this.h, (int) (this.h * 1.62f));
        this.j = new bk(this);
    }

    public com.baidu.tieba.util.a a() {
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
                        com.baidu.tieba.util.z.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        if (this.b.b().f() == 1) {
            size++;
        }
        if (this.b.b().g() == 1) {
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

    private void a(TextView textView, com.baidu.tieba.data.i iVar) {
        if (textView != null && iVar != null) {
            if (iVar.a() == 2) {
                textView.append(iVar.a(this.a, this.f, this.g));
            } else {
                textView.append(iVar.e());
            }
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        if (this.b != null) {
            i2 = this.b.b().g() == 1 ? i - 1 : i;
            if (this.b.b().f() == 1 && i == getCount() - 1) {
                i2 = -2;
            }
        } else {
            i2 = i;
        }
        return i2;
    }

    public void a(com.baidu.tieba.model.bl blVar) {
        this.b = blVar;
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
                blVar2.j = (TextView) inflate.findViewById(R.id.time);
                blVar2.i = (TextView) inflate.findViewById(R.id.position);
                blVar2.h = (ImageView) inflate.findViewById(R.id.pos_icon);
                blVar2.g = (TextView) inflate.findViewById(R.id.text);
                blVar2.f = (ImageView) inflate.findViewById(R.id.image);
                blVar2.g.setMovementMethod(LinkMovementMethod.getInstance());
                blVar2.g.setFocusable(false);
                blVar2.g.setLineSpacing(0.0f, 1.2f);
                blVar2.k = (TextView) inflate.findViewById(R.id.reply_num);
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
            if (item != null && (item instanceof com.baidu.tieba.data.al)) {
                com.baidu.tieba.data.al alVar = (com.baidu.tieba.data.al) item;
                blVar.j.setText(alVar.a());
                blVar.e.setTag(alVar.d());
                com.baidu.tieba.data.al alVar2 = (com.baidu.tieba.data.al) getItem(i - 1);
                if (alVar2 != null && alVar2.a() != null && alVar2.a().equals(alVar.a())) {
                    blVar.j.setVisibility(8);
                    a((View) blVar.d, false);
                } else {
                    blVar.j.setVisibility(0);
                    a((View) blVar.d, true);
                }
                if ("".equals(alVar.c())) {
                    blVar.i.setVisibility(4);
                    blVar.h.setVisibility(4);
                } else {
                    blVar.i.setVisibility(0);
                    blVar.h.setVisibility(0);
                    blVar.i.setText(alVar.c());
                }
                if (alVar.b() > 0) {
                    blVar.k.setText(String.valueOf(alVar.b()));
                    blVar.k.setVisibility(0);
                } else {
                    blVar.k.setVisibility(8);
                }
                ArrayList j = alVar.e().j();
                if (j != null && j.size() > 0) {
                    int size = j.size();
                    int i2 = 0;
                    boolean z4 = false;
                    boolean z5 = false;
                    while (i2 < size) {
                        com.baidu.tieba.data.i iVar = (com.baidu.tieba.data.i) j.get(i2);
                        if (iVar == null) {
                            break;
                        }
                        if (iVar.a() == 0 || iVar.a() == 2) {
                            blVar.g.setVisibility(0);
                            if (!z5) {
                                a(blVar.g, iVar);
                                z = z4;
                                z2 = z5;
                            }
                            z = z4;
                            z2 = z5;
                        } else {
                            if (iVar.a() == 3) {
                                blVar.f.setVisibility(0);
                                if (z4) {
                                    z = z4;
                                    z2 = true;
                                } else {
                                    int[] a = com.baidu.tieba.util.ab.a(iVar, this.h);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a[0], a[1]);
                                    blVar.f.setTag(iVar.f());
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
            if (TiebaApplication.f().at() == 1) {
                view.setBackgroundResource(R.drawable.timeline_below_1);
            } else {
                view.setBackgroundResource(R.drawable.timeline_below);
            }
        } else if (TiebaApplication.f().at() == 1) {
            view.setBackgroundResource(R.drawable.timeline_above_1);
        } else {
            view.setBackgroundResource(R.drawable.timeline_above);
        }
    }

    private void a(bl blVar) {
        try {
            if (blVar.a != TiebaApplication.f().at()) {
                blVar.a = TiebaApplication.f().at();
                if (blVar.a == 1) {
                    blVar.b.setTextColor(com.baidu.tieba.util.x.a(1));
                } else {
                    blVar.b.setTextColor(-16777216);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void b(bl blVar) {
        try {
            if (blVar.a != TiebaApplication.f().at()) {
                blVar.a = TiebaApplication.f().at();
                if (blVar.a == 1) {
                    blVar.g.setTextColor(com.baidu.tieba.util.x.a(blVar.a));
                    blVar.g.setLinkTextColor(-9989158);
                    com.baidu.tieba.util.x.h(blVar.e, (int) R.drawable.lbs_weitie_bg_1);
                } else {
                    blVar.g.setTextColor(-11974584);
                    blVar.g.setLinkTextColor(-10526484);
                    com.baidu.tieba.util.x.h(blVar.e, (int) R.drawable.lbs_weitie_bg);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "setItemSkin", e.getMessage());
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
