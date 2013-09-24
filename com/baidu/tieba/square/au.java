package com.baidu.tieba.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.BarSuggestModel;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class au extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1832a;
    private com.baidu.tieba.util.a b;
    private String c;
    private boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public au(com.baidu.tieba.j jVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.f1832a = jVar;
        this.c = jVar.getText(R.string.forum).toString();
        this.e = arrayList;
        this.b = new com.baidu.tieba.util.a(jVar);
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
        aw awVar;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.f1832a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                awVar = new aw(this, null);
                awVar.b = (ImageView) view.findViewById(R.id.forum_avatar);
                awVar.f1834a = (TextView) view.findViewById(R.id.name);
                awVar.c = (TextView) view.findViewById(R.id.member_count);
                awVar.d = (TextView) view.findViewById(R.id.thread_count);
                awVar.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(awVar);
                view2 = view;
            } else {
                awVar = (aw) view.getTag();
                view2 = view;
            }
            try {
                BarSuggestModel.Forum item = getItem(i);
                if (item != null) {
                    this.f1832a.l().a(TiebaApplication.g().ap() == 1);
                    this.f1832a.l().a(view2);
                    String str = item.avatar;
                    this.b.e(str, new av(this, awVar.b));
                    awVar.b.setTag(str);
                    awVar.b.invalidate();
                    if (this.d) {
                        awVar.f1834a.setText(item.forum_name.concat(this.c));
                    } else {
                        awVar.f1834a.setText(item.forum_name);
                    }
                    awVar.b.setTag(item.avatar);
                    awVar.c.setText(String.valueOf(this.f1832a.getString(R.string.forum_list_attention_tv)) + " " + b(item.member_num));
                    awVar.d.setText(String.valueOf(this.f1832a.getString(R.string.forum_list_thread_tv)) + " " + b(item.thread_num));
                    awVar.e.setText(item.slogan);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.av.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        return view2;
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / VersionUtils.CUR_DEVELOPMENT)) + this.f1832a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
