package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.c.aq b;
    private View.OnClickListener c;

    public d(Context context, com.baidu.tieba.c.aq aqVar, View.OnClickListener onClickListener) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = context;
        this.b = aqVar;
        this.c = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.a().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.a().size()) {
            return null;
        }
        return this.b.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItem(i) != null) {
            if (((com.baidu.tieba.c.ar) getItem(i)).a() == 0) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0193: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:36:0x0192 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int itemViewType;
        int ai;
        View view3;
        e eVar;
        View view4;
        f fVar = null;
        try {
            itemViewType = getItemViewType(i);
            ai = TiebaApplication.d().ai();
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    view4 = from.inflate(R.layout.distance_node, (ViewGroup) null);
                    eVar = new e(this);
                    eVar.b = (TextView) view4.findViewById(R.id.distance_text);
                    eVar.a = (ImageView) view4.findViewById(R.id.distance_icon);
                    view4.setTag(eVar);
                } else {
                    if (itemViewType == 1) {
                        view4 = from.inflate(R.layout.nearby_forum_node, (ViewGroup) null);
                        f fVar2 = new f(this);
                        fVar2.b = (LinearLayout) view4.findViewById(R.id.nearby_forum_node_layout);
                        fVar2.b.setOnClickListener(this.c);
                        fVar2.a = (TextView) view4.findViewById(R.id.forum_name);
                        fVar2.c = (Button) view4.findViewById(R.id.like);
                        fVar2.d = (RatingBar) view4.findViewById(R.id.forum_ratingbar);
                        fVar2.e = (TextView) view4.findViewById(R.id.member_count);
                        fVar2.f = (TextView) view4.findViewById(R.id.thread_count);
                        fVar2.g = (ImageView) view4.findViewById(R.id.div);
                        view4.setTag(fVar2);
                        eVar = null;
                        fVar = fVar2;
                    }
                    eVar = null;
                    view4 = view;
                }
            } else if (itemViewType == 0) {
                eVar = (e) view.getTag();
                view4 = view;
            } else {
                if (itemViewType == 1) {
                    eVar = null;
                    view4 = view;
                    fVar = (f) view.getTag();
                }
                eVar = null;
                view4 = view;
            }
            com.baidu.tieba.c.ar arVar = (com.baidu.tieba.c.ar) getItem(i);
            if (itemViewType == 0) {
                eVar.b.setText(arVar.b());
                if (ai == 1) {
                    eVar.a.setBackgroundResource(R.drawable.icon_distance_node_1);
                    return view4;
                }
                eVar.a.setBackgroundResource(R.drawable.icon_distance_node);
                return view4;
            } else if (itemViewType == 1) {
                fVar.a.setText(arVar.c());
                fVar.d.setRating(arVar.e());
                fVar.e.setText(String.valueOf(arVar.g()));
                fVar.f.setText(String.valueOf(arVar.h()));
                fVar.b.setTag(arVar.c());
                fVar.c.setTag(R.id.tag_nearby_forum_name, arVar.c());
                fVar.c.setTag(R.id.tag_nearby_forum_id, arVar.d());
                fVar.c.setOnClickListener(this.c);
                if (arVar.f()) {
                    fVar.c.setBackgroundResource(R.drawable.icon_like);
                    fVar.c.setClickable(false);
                } else {
                    fVar.c.setBackgroundResource(R.drawable.icon_not_like);
                    fVar.c.setClickable(true);
                }
                if (ai == 1) {
                    fVar.a.setTextColor(-8682095);
                    fVar.e.setTextColor(-11446171);
                    fVar.f.setTextColor(-11446171);
                    fVar.b.setBackgroundResource(R.drawable.nearby_forum_node_selector_1);
                    fVar.g.setBackgroundColor(-13421773);
                    return view4;
                }
                fVar.a.setTextColor(-14277082);
                fVar.e.setTextColor(-7829368);
                fVar.f.setTextColor(-7829368);
                fVar.b.setBackgroundResource(R.drawable.nearby_forum_node_selector);
                fVar.g.setBackgroundColor(-1710619);
                return view4;
            } else {
                return view4;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
            return view2;
        }
    }
}
