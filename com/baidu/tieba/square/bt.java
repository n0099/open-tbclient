package com.baidu.tieba.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bt extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f2414a;
    private com.baidu.tieba.util.i b;
    private String c;
    private boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public bt(com.baidu.tieba.j jVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.f2414a = jVar;
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
        bv bvVar;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.f2414a).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
                bvVar = new bv(this, null);
                bvVar.b = (HeadImageView) view.findViewById(R.id.forum_avatar);
                bvVar.b.setGifIconSupport(false);
                bvVar.f2416a = (TextView) view.findViewById(R.id.name);
                bvVar.c = (TextView) view.findViewById(R.id.member_count);
                bvVar.d = (TextView) view.findViewById(R.id.thread_count);
                bvVar.e = (TextView) view.findViewById(R.id.slogan);
                view.setTag(bvVar);
                view2 = view;
            } else {
                bvVar = (bv) view.getTag();
                view2 = view;
            }
            try {
                BarSuggestModel.Forum item = getItem(i);
                if (item != null) {
                    this.f2414a.getLayoutMode().a(TiebaApplication.g().ap() == 1);
                    this.f2414a.getLayoutMode().a(view2);
                    String str = item.avatar;
                    this.b.f(str, new bu(this, bvVar.b));
                    bvVar.b.setTag(str);
                    bvVar.b.invalidate();
                    if (this.d) {
                        bvVar.f2416a.setText(item.forum_name.concat(this.c));
                    } else {
                        bvVar.f2416a.setText(item.forum_name);
                    }
                    bvVar.b.setTag(item.avatar);
                    bvVar.c.setText(this.f2414a.getString(R.string.forum_list_attention_tv) + " " + b(item.member_num));
                    bvVar.d.setText(this.f2414a.getString(R.string.forum_list_thread_tv) + " " + b(item.thread_num));
                    bvVar.e.setText(item.slogan);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
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
            return String.valueOf(i / VersionUtils.CUR_DEVELOPMENT) + this.f2414a.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
