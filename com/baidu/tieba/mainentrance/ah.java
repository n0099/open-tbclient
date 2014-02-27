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
public final class ah extends BaseAdapter {
    private final com.baidu.tieba.f a;
    private final com.baidu.tieba.util.i b;
    private final String c;
    private final boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e = null;

    public ah(com.baidu.tieba.f fVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = fVar;
        this.c = fVar.getText(R.string.forum).toString();
        this.b = new com.baidu.tieba.util.i(fVar);
    }

    public final void a(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.e = arrayList;
        if (this.e != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
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
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0160  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        aj ajVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                aj ajVar2 = new aj(this, (byte) 0);
                ajVar2.b = (HeadImageView) view.findViewById(R.id.forum_avatar);
                ajVar2.b.setGifIconSupport(false);
                ajVar2.a = (TextView) view.findViewById(R.id.name);
                ajVar2.c = (TextView) view.findViewById(R.id.member_count);
                ajVar2.d = (TextView) view.findViewById(R.id.thread_count);
                ajVar2.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(ajVar2);
                ajVar = ajVar2;
                view2 = view;
            } else {
                ajVar = (aj) view.getTag();
                view2 = view;
            }
            try {
                item = getItem(i);
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
                this.a.getLayoutMode().a(TiebaApplication.g().ae() == 1);
                this.a.getLayoutMode().a(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TiebaApplication.g().ae() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            this.b.f(str, new ai(this, ajVar.b));
            ajVar.b.setTag(str);
            ajVar.b.invalidate();
            if (this.d) {
                ajVar.a.setText(item.forum_name.concat(this.c));
            } else {
                ajVar.a.setText(item.forum_name);
            }
            ajVar.b.setTag(item.avatar);
            ajVar.c.setText(String.valueOf(this.a.getString(R.string.forum_list_attention_tv)) + " " + b(item.member_num));
            ajVar.d.setText(String.valueOf(this.a.getString(R.string.forum_list_thread_tv)) + " " + b(item.thread_num));
            ajVar.e.setText(item.slogan);
            this.a.getLayoutMode().a(TiebaApplication.g().ae() == 1);
            this.a.getLayoutMode().a(view2);
        }
        return view2;
    }

    private String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
