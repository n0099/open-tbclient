package com.baidu.tieba.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bw extends BaseAdapter {
    private com.baidu.tieba.j a;
    private com.baidu.tieba.util.i b;
    private String c;
    private boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public bw(com.baidu.tieba.j jVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = jVar;
        this.c = jVar.getText(R.string.forum).toString();
        this.e = arrayList;
        this.b = new com.baidu.tieba.util.i(jVar);
    }

    public void a(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.e = arrayList;
        if (this.e != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        by byVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                byVar = new by(this, null);
                byVar.b = (HeadImageView) view.findViewById(R.id.forum_avatar);
                byVar.b.setGifIconSupport(false);
                byVar.a = (TextView) view.findViewById(R.id.name);
                byVar.c = (TextView) view.findViewById(R.id.member_count);
                byVar.d = (TextView) view.findViewById(R.id.thread_count);
                byVar.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(byVar);
                view2 = view;
            } else {
                byVar = (by) view.getTag();
                view2 = view;
            }
            try {
                item = getItem(i);
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
                a(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TiebaApplication.h().al() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            this.b.f(str, new bx(this, byVar.b));
            byVar.b.setTag(str);
            byVar.b.invalidate();
            if (this.d) {
                byVar.a.setText(item.forum_name.concat(this.c));
            } else {
                byVar.a.setText(item.forum_name);
            }
            byVar.b.setTag(item.avatar);
            byVar.c.setText(this.a.getString(R.string.forum_list_attention_tv) + " " + b(item.member_num));
            byVar.d.setText(this.a.getString(R.string.forum_list_thread_tv) + " " + b(item.thread_num));
            byVar.e.setText(item.slogan);
            a(view2);
        }
        return view2;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TiebaApplication.h().al() == 1);
        this.a.getLayoutMode().a(view);
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
