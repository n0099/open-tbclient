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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.ImagePbImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ah extends BaseAdapter {
    private com.baidu.tieba.data.aa b;
    private Context c;
    private boolean f;
    private int j;
    private com.baidu.tieba.data.ac a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public ah(Context context, com.baidu.tieba.data.aa aaVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = aaVar;
        this.j = BdUtilHelper.b(this.c);
    }

    public final void a() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        this.g.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.g.clear();
                    return;
                }
            }
        }
    }

    public final boolean b() {
        if (this.a == null || !this.d) {
            return false;
        }
        return this.a.e();
    }

    public final boolean c() {
        return !this.d || this.a == null || this.a.d();
    }

    public final int d() {
        if (this.a == null || this.a.a() == null) {
            return 1;
        }
        return (this.a.a().size() / 10) + 1;
    }

    public final com.baidu.tieba.data.aa e() {
        return this.b;
    }

    public final void a(com.baidu.tieba.data.ac acVar) {
        this.a = acVar;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        this.d = true;
        if (this.b == null) {
            return 0;
        }
        if (this.a == null || this.a.a() == null) {
            return 1;
        }
        if (this.a.a().size() != this.e) {
            this.e = this.a.a().size();
            notifyDataSetChanged();
            return 0;
        } else if (this.a.a().size() == 0 || this.a.c() == 0) {
            this.d = false;
            return 2;
        } else if (b()) {
            return this.a.a().size() + 2;
        } else {
            return this.a.a().size() + 1;
        }
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || this.a.a() == null || i >= this.a.a().size()) {
            return null;
        }
        return this.a.a().get(i + 1);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        int b = this.a != null ? this.a.b() : 0;
        if (i == 0) {
            return 2;
        }
        return (i == b + 1 || !this.d) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
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
                ak akVar2 = new ak(this, (byte) 0);
                akVar2.a = (TextView) inflate.findViewById(R.id.image_pb_item_comment);
                akVar2.b = (TextView) inflate.findViewById(R.id.image_pb_item_auther);
                akVar2.c = (TextView) inflate.findViewById(R.id.image_pb_item_time);
                akVar2.d = (LinearLayout) inflate.findViewById(R.id.seg);
                obj = akVar2;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(R.layout.image_pb_list_header, (ViewGroup) null);
                ak akVar3 = new ak(this, (byte) 0);
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
                ak akVar4 = new ak(this, (byte) 0);
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
            akVar.a.setGravity(3);
            akVar.a.setMovementMethod(LinkMovementMethod.getInstance());
            akVar.a.setTextColor(this.c.getResources().getColor(R.color.reg_font_color));
            com.baidu.tieba.data.aq aqVar = this.a.a().get(i - 1);
            akVar.c.setVisibility(0);
            akVar.b.setVisibility(0);
            akVar.b.setText(aqVar.g().getUserName());
            akVar.b.setOnClickListener(new ai(this, aqVar.g().getUserId(), aqVar.g().getUserName()));
            akVar.c.setText(com.baidu.tieba.util.bs.a(aqVar.f()));
            akVar.d.setVisibility(8);
            akVar.d.removeAllViews();
            ArrayList<com.baidu.tieba.data.k> i2 = aqVar.i();
            com.baidu.tieba.util.t tVar = new com.baidu.tieba.util.t(this.c);
            tVar.a(-13421773);
            tVar.a(akVar.a, akVar.d, i2, false);
            akVar.a.setTextSize(2, 13.0f);
            try {
                if (TiebaApplication.g().ae() == 1) {
                    akVar.a.setTextColor(com.baidu.tieba.util.bq.a(1));
                    akVar.c.setTextColor(com.baidu.tieba.util.bq.b(1));
                } else {
                    akVar.a.setTextColor(-13421773);
                    akVar.c.setTextColor(-6710887);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "setNormalSkin", e.getMessage());
            }
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
            ArrayList<com.baidu.tieba.data.k> i3 = this.b.a().i();
            com.baidu.tieba.util.t tVar2 = new com.baidu.tieba.util.t(this.c);
            akVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            tVar2.a(true);
            tVar2.a(akVar.i, akVar.l, i3, false);
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
            if (this.a != null) {
                int c = this.a.c();
                TextView textView = akVar.k;
                if (c == 0) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(String.valueOf(String.valueOf(c)) + this.c.getString(R.string.comment_number));
                    textView.setVisibility(0);
                }
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
            try {
                if (TiebaApplication.g().ae() == 1) {
                    akVar.i.setTextColor(com.baidu.tieba.util.bq.a(1));
                    akVar.k.setTextColor(com.baidu.tieba.util.bq.b(1));
                    akVar.g.setBackgroundColor(com.baidu.tieba.util.bq.d(1));
                } else {
                    akVar.i.setTextColor(-13421773);
                    akVar.k.setTextColor(-6710887);
                    akVar.g.setBackgroundColor(-1);
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "setHeaderSkin", e2.getMessage());
            }
        }
        return view2;
    }

    private void a(ak akVar, boolean z) {
        try {
            if (TiebaApplication.g().ae() == 1) {
                if (z) {
                    akVar.e.setTextColor(com.baidu.tieba.util.bq.a(1));
                } else {
                    akVar.e.setTextColor(com.baidu.tieba.util.bq.c(1));
                }
            } else if (z) {
                akVar.e.setTextColor(-13421773);
            } else {
                akVar.e.setTextColor(this.c.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    public final void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }
}
