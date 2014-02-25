package com.baidu.tieba.mainentrance;

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
public class ak extends BaseAdapter {
    private final com.baidu.tieba.f a;
    private final com.baidu.tieba.util.i b;
    private final String c;
    private final boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public ak(com.baidu.tieba.f fVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = fVar;
        this.c = fVar.getText(R.string.forum).toString();
        this.e = arrayList;
        this.b = new com.baidu.tieba.util.i(fVar);
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
        am amVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                amVar = new am(this, null);
                amVar.b = (HeadImageView) view.findViewById(R.id.forum_avatar);
                amVar.b.setGifIconSupport(false);
                amVar.a = (TextView) view.findViewById(R.id.name);
                amVar.c = (TextView) view.findViewById(R.id.member_count);
                amVar.d = (TextView) view.findViewById(R.id.thread_count);
                amVar.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(amVar);
                view2 = view;
            } else {
                amVar = (am) view.getTag();
                view2 = view;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
        try {
            item = getItem(i);
        } catch (Exception e3) {
            e = e3;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
            a(view2);
            return view2;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            this.b.f(str, new al(this, amVar.b));
            amVar.b.setTag(str);
            amVar.b.invalidate();
            if (this.d) {
                amVar.a.setText(item.forum_name.concat(this.c));
            } else {
                amVar.a.setText(item.forum_name);
            }
            amVar.b.setTag(item.avatar);
            amVar.c.setText(String.valueOf(this.a.getString(R.string.forum_list_attention_tv)) + " " + b(item.member_num));
            amVar.d.setText(String.valueOf(this.a.getString(R.string.forum_list_thread_tv)) + " " + b(item.thread_num));
            amVar.e.setText(item.slogan);
            a(view2);
        }
        return view2;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
        this.a.getLayoutMode().a(view);
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
