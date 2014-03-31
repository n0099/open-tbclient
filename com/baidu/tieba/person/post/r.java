package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.af;
import com.baidu.tieba.person.post.PersonPostThreadModel;
/* loaded from: classes.dex */
public final class r extends BaseAdapter implements c, h {
    private PersonPostThreadModel a;
    private s b;
    private final String c;
    private String d;
    private final Activity e;

    public r(Context context, String str) {
        this.e = (Activity) context;
        this.c = str;
    }

    public final void a(boolean z) {
        PersonPostThreadModel.fetchThread(this, z, this.c);
    }

    public final void a() {
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.post.h
    public final void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        if (z) {
            this.a = personPostThreadModel;
        } else if (this.a != null) {
            this.a.post_list.addAll(personPostThreadModel.post_list);
        }
        if (this.b != null) {
            this.b.a(personPostThreadModel, z);
        }
        notifyDataSetChanged();
    }

    public final void a(s sVar) {
        this.b = sVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a == null || this.a.post_list == null) {
            return 0;
        }
        return this.a.post_list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.a.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        t tVar;
        if (view == null) {
            com.baidu.adp.lib.util.f.e("PersonThreadAdapter", "getView", "create convertView");
            view = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.a.i.person_post_item_thread, viewGroup, false);
            t tVar2 = new t(view);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        if (i == 0) {
            tVar.a.setVisibility(0);
        } else {
            tVar.a.setVisibility(8);
        }
        PersonPostThreadModel.PostList postList = this.a.post_list.get(i);
        if (this.d == null) {
            this.d = postList.user_portrait;
        }
        tVar.a(postList, this.d);
        String str = postList.title;
        if (str.trim().length() > 0) {
            tVar.g.setText(str);
            tVar.g.setVisibility(0);
        } else {
            tVar.g.setVisibility(8);
        }
        if (com.baidu.tbadk.core.h.a().f() && postList.media != null && postList.media.length > 0) {
            int min = Math.min(postList.media.length, 3);
            String[] strArr = new String[min];
            for (int i2 = 0; i2 < min; i2++) {
                strArr[i2] = postList.media[i2].big_pic;
            }
            tVar.i.setTags(strArr);
        } else {
            tVar.i.setTags(null);
        }
        if (postList.abs != null && postList.abs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs.length; i3++) {
                sb.append(postList.abs[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                tVar.h.setText(sb2);
                tVar.h.setVisibility(0);
            } else {
                tVar.h.setVisibility(8);
            }
        } else {
            tVar.h.setVisibility(8);
        }
        tVar.a(this);
        tVar.a(TbadkApplication.j().l());
        return view;
    }

    @Override // com.baidu.tieba.person.post.c
    public final void a(View view) {
        String[] strArr;
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.forum_name) {
            String str = (String) view.getTag();
            if (str != null && (this.e instanceof com.baidu.tbadk.a)) {
                ((com.baidu.tbadk.a) this.e).sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.e).a(str, "")));
            }
        } else if (id == com.baidu.tieba.a.h.portrait) {
            this.e.finish();
        } else if (id == com.baidu.tieba.a.h.username) {
            this.e.finish();
        } else if ((id == com.baidu.tieba.a.h.item_content || id == com.baidu.tieba.a.h.item_header) && (strArr = (String[]) view.getTag()) != null) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new af(this.e).a(strArr[0], strArr[1], "person_post")));
            com.baidu.adp.lib.util.f.e("PersonThreadAdapter", "on", "start thread = " + strArr[0] + " post_id = " + strArr[1]);
        }
    }
}
