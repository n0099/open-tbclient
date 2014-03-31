package com.baidu.tieba.pb.image;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.data.ai;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class y extends BaseAdapter {
    private com.baidu.tieba.data.t b;
    private Context c;
    private boolean f;
    private int j;
    private com.baidu.tieba.data.v a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public y(Context context, com.baidu.tieba.data.t tVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = tVar;
        this.j = com.baidu.adp.lib.util.i.b(this.c);
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
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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

    public final com.baidu.tieba.data.t e() {
        return this.b;
    }

    public final void a(com.baidu.tieba.data.v vVar) {
        this.a = vVar;
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
        ab abVar;
        View view2;
        LinearLayout.LayoutParams layoutParams;
        Object obj;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 0) {
                View inflate = from.inflate(com.baidu.tieba.a.i.image_pb_list_item, (ViewGroup) null);
                ab abVar2 = new ab(this, (byte) 0);
                abVar2.a = (TextView) inflate.findViewById(com.baidu.tieba.a.h.image_pb_item_comment);
                abVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.a.h.image_pb_item_auther);
                abVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.a.h.image_pb_item_time);
                abVar2.d = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.seg);
                obj = abVar2;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(com.baidu.tieba.a.i.image_pb_list_header, (ViewGroup) null);
                ab abVar3 = new ab(this, (byte) 0);
                abVar3.g = (LinearLayout) inflate2.findViewById(com.baidu.tieba.a.h.header);
                abVar3.i = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.image_pb_comment);
                abVar3.j = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.image_pb_author);
                abVar3.k = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.image_pb_reply_number);
                abVar3.l = (LinearLayout) inflate2.findViewById(com.baidu.tieba.a.h.seg);
                abVar3.h = (ImagePbImageView) inflate2.findViewById(com.baidu.tieba.a.h.image_pb_image);
                obj = abVar3;
                view3 = inflate2;
            } else {
                View inflate3 = from.inflate(com.baidu.tieba.a.i.page_item, (ViewGroup) null);
                ab abVar4 = new ab(this, (byte) 0);
                abVar4.e = (TextView) inflate3.findViewById(com.baidu.tieba.a.h.page_text);
                abVar4.f = (ProgressBar) inflate3.findViewById(com.baidu.tieba.a.h.progress);
                this.g.add(abVar4.f);
                obj = abVar4;
                view3 = inflate3;
            }
            view3.setTag(obj);
            abVar = obj;
            view2 = view3;
        } else {
            abVar = (ab) view.getTag();
            view2 = view;
        }
        if (itemViewType == 0) {
            abVar.a.setGravity(3);
            abVar.a.setMovementMethod(LinkMovementMethod.getInstance());
            abVar.a.setTextColor(this.c.getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            ai aiVar = this.a.a().get(i - 1);
            abVar.c.setVisibility(0);
            abVar.b.setVisibility(0);
            abVar.b.setText(aiVar.g().getUserName());
            abVar.b.setOnClickListener(new z(this, aiVar.g().getUserId(), aiVar.g().getUserName()));
            abVar.c.setText(bc.a(aiVar.f()));
            abVar.d.setVisibility(8);
            abVar.d.removeAllViews();
            ArrayList<com.baidu.tieba.data.f> j = aiVar.j();
            com.baidu.tieba.util.j jVar = new com.baidu.tieba.util.j(this.c);
            jVar.a(-13421773);
            jVar.a(abVar.a, abVar.d, j, false);
            abVar.a.setTextSize(2, 13.0f);
            try {
                if (TbadkApplication.j().l() == 1) {
                    abVar.a.setTextColor(ba.a(1));
                    abVar.c.setTextColor(ba.b(1));
                } else {
                    abVar.a.setTextColor(-13421773);
                    abVar.c.setTextColor(-6710887);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "setNormalSkin", e.getMessage());
            }
        } else if (itemViewType == 1) {
            if (abVar.f == null || abVar.e == null) {
                return view2;
            }
            abVar.e.setTextSize(2, 13.0f);
            if (this.f) {
                abVar.f.setVisibility(0);
                abVar.e.setText(com.baidu.tieba.a.k.data_loading_1);
                a(abVar, true);
            } else {
                abVar.f.setVisibility(8);
                if (!this.d) {
                    abVar.e.setText(this.c.getString(com.baidu.tieba.a.k.image_pb_noreply));
                    abVar.e.setFocusable(true);
                    abVar.e.setTextColor(this.c.getResources().getColor(com.baidu.tieba.a.e.gray));
                    a(abVar, false);
                } else {
                    abVar.e.setText(com.baidu.tieba.a.k.load_more);
                    a(abVar, true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList<com.baidu.tieba.data.f> j2 = this.b.a().j();
            com.baidu.tieba.util.j jVar2 = new com.baidu.tieba.util.j(this.c);
            abVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            jVar2.a(true);
            jVar2.a(abVar.i, abVar.l, j2, false);
            abVar.i.setTextSize(2, 13.0f);
            if (abVar.i.getText().toString().trim().length() == 0) {
                abVar.i.setVisibility(8);
            }
            abVar.j.setText(this.b.e());
            abVar.j.setOnClickListener(new aa(this, this.b.i(), this.b.e()));
            abVar.h.setTag(this.b.b());
            if (this.k != null) {
                abVar.h.setOnClickListener(this.k);
            }
            if (this.a != null) {
                int c = this.a.c();
                TextView textView = abVar.k;
                if (c == 0) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(String.valueOf(String.valueOf(c)) + this.c.getString(com.baidu.tieba.a.k.comment_number));
                    textView.setVisibility(0);
                }
            }
            int g = this.b.g();
            int f = this.b.f();
            if (f > 0.6f * this.j) {
                abVar.h.setIsScale(true);
                g = (g * this.j) / f;
            } else {
                abVar.h.setIsScale(false);
            }
            if (g >= this.i) {
                abVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.i);
            } else if (g <= this.h) {
                abVar.h.setScale(0);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.h);
            } else {
                abVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, g);
            }
            abVar.h.setLayoutParams(layoutParams);
            try {
                if (TbadkApplication.j().l() == 1) {
                    abVar.i.setTextColor(ba.a(1));
                    abVar.k.setTextColor(ba.b(1));
                    abVar.g.setBackgroundColor(ba.d(1));
                } else {
                    abVar.i.setTextColor(-13421773);
                    abVar.k.setTextColor(-6710887);
                    abVar.g.setBackgroundColor(-1);
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "setHeaderSkin", e2.getMessage());
            }
        }
        return view2;
    }

    private void a(ab abVar, boolean z) {
        try {
            if (TbadkApplication.j().l() == 1) {
                if (z) {
                    abVar.e.setTextColor(ba.a(1));
                } else {
                    abVar.e.setTextColor(ba.c(1));
                }
            } else if (z) {
                abVar.e.setTextColor(-13421773);
            } else {
                abVar.e.setTextColor(this.c.getResources().getColor(com.baidu.tieba.a.e.gray));
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "setPageSkin", e.getMessage());
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
