package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.post.PersonPostThreadModel;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements c, g {

    /* renamed from: a  reason: collision with root package name */
    private PersonPostThreadModel f1724a;
    private r b;
    private String c;
    private String d;
    private Activity e;

    public q(Context context, String str, String str2) {
        this.e = (Activity) context;
        this.c = str;
        this.d = str2;
    }

    public void a(boolean z) {
        PersonPostThreadModel.fetchThread(this, z, this.c);
    }

    @Override // com.baidu.tieba.person.post.g
    public void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        if (z) {
            this.f1724a = personPostThreadModel;
        } else if (this.f1724a != null) {
            this.f1724a.post_list.addAll(personPostThreadModel.post_list);
        }
        if (this.b != null) {
            this.b.a(personPostThreadModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(r rVar) {
        this.b = rVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1724a == null || this.f1724a.post_list == null) {
            return 0;
        }
        return this.f1724a.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f1724a.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        s sVar;
        if (view == null) {
            av.e("PersonThreadAdapter", "getView", "create convertView");
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_thread, viewGroup, false);
            s sVar2 = new s(view);
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        if (i == 0) {
            sVar.f1711a.setVisibility(0);
        } else {
            sVar.f1711a.setVisibility(8);
        }
        PersonPostThreadModel.PostList postList = this.f1724a.post_list.get(i);
        sVar.a(postList, this.d);
        String str = postList.title;
        if (str.trim().length() > 0) {
            sVar.g.setText(str);
            sVar.g.setVisibility(0);
        } else {
            sVar.g.setVisibility(8);
        }
        if (postList.media != null && postList.media.length > 0) {
            int min = Math.min(postList.media.length, 3);
            String[] strArr = new String[min];
            for (int i2 = 0; i2 < min; i2++) {
                strArr[i2] = postList.media[i2].big_pic;
            }
            sVar.i.setTags(strArr);
        } else {
            sVar.i.setTags(null);
        }
        if (postList.abs != null && postList.abs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs.length; i3++) {
                sb.append(postList.abs[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                sVar.h.setText(sb2);
                sVar.h.setVisibility(0);
            } else {
                sVar.h.setVisibility(8);
            }
        } else {
            sVar.h.setVisibility(8);
        }
        sVar.a(this);
        sVar.a(TiebaApplication.g().ap());
        return view;
    }

    @Override // com.baidu.tieba.person.post.c
    public void a(View view) {
        switch (view.getId()) {
            case R.id.portrait /* 2131099830 */:
                this.e.finish();
                return;
            case R.id.item_header /* 2131100015 */:
            case R.id.item_content /* 2131100648 */:
                String[] strArr = (String[]) view.getTag();
                if (strArr != null) {
                    NewPbActivity.a(view.getContext(), strArr[0], strArr[1], "person_post");
                    av.e("PersonThreadAdapter", "on", "start thread = " + strArr[0] + " post_id = " + strArr[1]);
                    return;
                }
                return;
            case R.id.forum_name /* 2131100652 */:
                String str = (String) view.getTag();
                if (str != null) {
                    FrsActivity.a(view.getContext(), str, "");
                    return;
                }
                return;
            case R.id.username /* 2131100654 */:
                this.e.finish();
                return;
            default:
                return;
        }
    }
}
