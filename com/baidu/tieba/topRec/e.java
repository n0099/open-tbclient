package com.baidu.tieba.topRec;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.r;
import com.baidu.tieba.topRec.TRForumListData;
/* loaded from: classes.dex */
public final class e extends BaseAdapter implements View.OnClickListener {
    private TRForumListData a;
    private TopRecActivity c;
    private aa d;
    private boolean b = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h = true;

    public e(TopRecActivity topRecActivity) {
        this.c = topRecActivity;
        this.d = new aa(this.c);
        this.d.a(400, 400);
    }

    public final void a(TRForumListData tRForumListData) {
        this.a = tRForumListData;
        if (this.h && this.a.forum_list.length >= 20) {
            this.g = 20;
            this.h = false;
        }
        notifyDataSetChanged();
    }

    public final void a() {
        if (this.a != null) {
            if (this.a.forum_list.length - this.g > 20) {
                this.g += 20;
                this.b = false;
            } else {
                this.g = this.a.forum_list.length;
                this.b = true;
            }
            notifyDataSetChanged();
        }
    }

    public final boolean b() {
        return this.b;
    }

    public final void a(int i, int i2) {
        this.e = i;
        this.f = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.g < this.a.forum_list.length ? this.g : this.a.forum_list.length;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (i < this.a.forum_list.length) {
            return this.a.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (i < this.a.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.c, com.baidu.tieba.a.i.top_recommended_list_item, null);
            g gVar = new g(this);
            gVar.a = (ImageView) view.findViewById(com.baidu.tieba.a.h.forum_avatar);
            gVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.name);
            gVar.c = (TextView) view.findViewById(com.baidu.tieba.a.h.member_count);
            gVar.d = (TextView) view.findViewById(com.baidu.tieba.a.h.thread_count);
            gVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.slogan);
            gVar.f = (TextView) view.findViewById(com.baidu.tieba.a.h.like);
            view.setTag(gVar);
            view.setOnClickListener(this);
        }
        g gVar2 = (g) view.getTag();
        int l = TbadkApplication.j().l();
        ba.c(gVar2.b, l);
        ba.c(gVar2.c, l);
        ba.c(gVar2.d, l);
        ba.c(gVar2.e, l);
        ba.c(gVar2.f, l);
        if (l != 1) {
            gVar2.b.setTextColor(-14277082);
            gVar2.c.setTextColor(-6775644);
            gVar2.d.setTextColor(-6775644);
            gVar2.e.setTextColor(-6842215);
        }
        if (l == 1) {
            view.setBackgroundColor(this.c.getResources().getColor(com.baidu.tieba.a.e.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.c.getResources().getColor(com.baidu.tieba.a.e.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.a.forum_list[i];
        com.baidu.adp.lib.util.f.e("ForumListAdapter", "getView", "forum name:" + this.a.forum_list[i].forum_name + "forum avatar:" + this.a.forum_list[i].avatar);
        String str = tRForum.avatar;
        this.d.f(str, new f(this, str, gVar2.a));
        gVar2.a.setTag(str);
        gVar2.b.setText(tRForum.forum_name);
        gVar2.c.setText(String.valueOf(this.c.getString(com.baidu.tieba.a.k.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        gVar2.d.setText(String.valueOf(this.c.getString(com.baidu.tieba.a.k.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        gVar2.e.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.f != 0) {
                gVar2.f.setBackgroundResource(this.f);
            }
            gVar2.f.setText(com.baidu.tieba.a.k.attention_y);
            gVar2.f.setGravity(17);
            if (TbadkApplication.j().l() == 1) {
                gVar2.f.setTextColor(this.c.getResources().getColor(com.baidu.tieba.a.e.forum_list_already_attention_night));
            } else {
                gVar2.f.setTextColor(this.c.getResources().getColor(com.baidu.tieba.a.e.forum_list_attention));
            }
            gVar2.f.setPadding(0, 0, 0, com.baidu.adp.lib.util.i.a((Context) this.c, 2.0f));
            gVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            gVar2.f.setOnClickListener(this.c);
        } else {
            if (this.e != 0) {
                gVar2.f.setBackgroundResource(this.e);
            }
            gVar2.f.setText(com.baidu.tieba.a.k.attention_n);
            gVar2.f.setTextColor(this.c.getResources().getColor(com.baidu.tieba.a.e.forum_list_attention));
            gVar2.f.setPadding(com.baidu.adp.lib.util.i.a((Context) this.c, 30.0f), 0, com.baidu.adp.lib.util.i.a((Context) this.c, 10.0f), com.baidu.adp.lib.util.i.a((Context) this.c, 2.0f));
            gVar2.f.setGravity(16);
            gVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            gVar2.f.setOnClickListener(this.c);
        }
        return view;
    }

    public final int c() {
        if (this.a == null || this.a.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.a.forum_list.length; i2++) {
            int d = r.c().d(this.a.forum_list[i2].forum_name);
            if (d == 1) {
                if (this.a.forum_list[i2].is_like == 0) {
                    this.a.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (d == -1 && this.a.forum_list[i2].is_like == 1) {
                this.a.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.c.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.c).a(((g) view.getTag()).b.getText().toString(), null)));
    }
}
