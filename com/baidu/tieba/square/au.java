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
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class au extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f2353a;
    private com.baidu.tieba.util.a b;
    private String c;
    private boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public au(com.baidu.tieba.j jVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.f2353a = jVar;
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
                view = LayoutInflater.from(this.f2353a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                aw awVar2 = new aw(this, null);
                awVar2.b = (ImageView) view.findViewById(R.id.forum_avatar);
                awVar2.f2355a = (TextView) view.findViewById(R.id.name);
                awVar2.c = (TextView) view.findViewById(R.id.member_count);
                awVar2.d = (TextView) view.findViewById(R.id.thread_count);
                awVar2.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(awVar2);
                awVar = awVar2;
                view2 = view;
            } else {
                awVar = (aw) view.getTag();
                view2 = view;
            }
            try {
                BarSuggestModel.Forum item = getItem(i);
                if (item != null) {
                    this.f2353a.m().a(TiebaApplication.g().as() == 1);
                    this.f2353a.m().a(view2);
                    String str = item.avatar;
                    this.b.e(str, new av(this, awVar.b));
                    awVar.b.setTag(str);
                    awVar.b.invalidate();
                    if (this.d) {
                        awVar.f2355a.setText(item.forum_name.concat(this.c));
                    } else {
                        awVar.f2355a.setText(item.forum_name);
                    }
                    awVar.b.setTag(item.avatar);
                    awVar.c.setText(this.f2353a.getString(R.string.forum_list_attention_tv) + " " + b(item.member_num));
                    awVar.d.setText(this.f2353a.getString(R.string.forum_list_thread_tv) + " " + b(item.thread_num));
                    awVar.e.setText(item.slogan);
                }
            } catch (Exception e2) {
                e = e2;
                be.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
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
            return String.valueOf(i / VersionUtils.CUR_DEVELOPMENT) + this.f2353a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
