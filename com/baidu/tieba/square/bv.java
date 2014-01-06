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
public class bv extends BaseAdapter {
    private com.baidu.tieba.j a;
    private com.baidu.tieba.util.i b;
    private String c;
    private boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public bv(com.baidu.tieba.j jVar, ArrayList<BarSuggestModel.Forum> arrayList) {
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
        bx bxVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                bxVar = new bx(this, null);
                bxVar.b = (HeadImageView) view.findViewById(R.id.forum_avatar);
                bxVar.b.setGifIconSupport(false);
                bxVar.a = (TextView) view.findViewById(R.id.name);
                bxVar.c = (TextView) view.findViewById(R.id.member_count);
                bxVar.d = (TextView) view.findViewById(R.id.thread_count);
                bxVar.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(bxVar);
                view2 = view;
            } else {
                bxVar = (bx) view.getTag();
                view2 = view;
            }
            try {
                item = getItem(i);
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bo.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
                a(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TiebaApplication.g().an() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            this.b.f(str, new bw(this, bxVar.b));
            bxVar.b.setTag(str);
            bxVar.b.invalidate();
            if (this.d) {
                bxVar.a.setText(item.forum_name.concat(this.c));
            } else {
                bxVar.a.setText(item.forum_name);
            }
            bxVar.b.setTag(item.avatar);
            bxVar.c.setText(this.a.getString(R.string.forum_list_attention_tv) + " " + b(item.member_num));
            bxVar.d.setText(this.a.getString(R.string.forum_list_thread_tv) + " " + b(item.thread_num));
            bxVar.e.setText(item.slogan);
            a(view2);
        }
        return view2;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TiebaApplication.g().an() == 1);
        this.a.getLayoutMode().a(view);
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
