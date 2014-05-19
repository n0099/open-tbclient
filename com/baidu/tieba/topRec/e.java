package com.baidu.tieba.topRec;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.ad;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {
    private TRForumListData a;
    private TopRecActivity c;
    private ab d;
    private boolean b = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h = true;

    public e(TopRecActivity topRecActivity) {
        this.c = topRecActivity;
        this.d = new ab(this.c);
        this.d.a(400, 400);
    }

    public void a(TRForumListData tRForumListData) {
        this.a = tRForumListData;
        if (this.h && this.a.forum_list.length >= 20) {
            this.g = 20;
            this.h = false;
        }
        notifyDataSetChanged();
    }

    public void a() {
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

    public boolean b() {
        return this.b;
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.g < this.a.forum_list.length ? this.g : this.a.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.a.forum_list.length) {
            return this.a.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.a.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.c, s.top_recommended_list_item, null);
            g gVar = new g(this);
            gVar.a = (ImageView) view.findViewById(r.forum_avatar);
            gVar.b = (TextView) view.findViewById(r.name);
            gVar.c = (TextView) view.findViewById(r.member_count);
            gVar.d = (TextView) view.findViewById(r.thread_count);
            gVar.e = (TextView) view.findViewById(r.slogan);
            gVar.f = (TextView) view.findViewById(r.like);
            view.setTag(gVar);
            view.setOnClickListener(this);
        }
        g gVar2 = (g) view.getTag();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        bc.c(gVar2.b, skinType);
        bc.c(gVar2.c, skinType);
        bc.c(gVar2.d, skinType);
        bc.c(gVar2.e, skinType);
        bc.c(gVar2.f, skinType);
        if (skinType != 1) {
            gVar2.b.setTextColor(-14277082);
            gVar2.c.setTextColor(-6775644);
            gVar2.d.setTextColor(-6775644);
            gVar2.e.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.c.getResources().getColor(com.baidu.tieba.o.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.c.getResources().getColor(com.baidu.tieba.o.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.a.forum_list[i];
        BdLog.d("ForumListAdapter", "getView", "forum name:" + this.a.forum_list[i].forum_name + "forum avatar:" + this.a.forum_list[i].avatar);
        String str = tRForum.avatar;
        this.d.e(str, new f(this, str, gVar2.a));
        gVar2.a.setTag(str);
        gVar2.b.setText(tRForum.forum_name);
        gVar2.c.setText(String.valueOf(this.c.getString(u.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        gVar2.d.setText(String.valueOf(this.c.getString(u.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        gVar2.e.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.f != 0) {
                gVar2.f.setBackgroundResource(this.f);
            }
            gVar2.f.setText(u.attention_y);
            gVar2.f.setGravity(17);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                gVar2.f.setTextColor(this.c.getResources().getColor(com.baidu.tieba.o.forum_list_already_attention_night));
            } else {
                gVar2.f.setTextColor(this.c.getResources().getColor(com.baidu.tieba.o.forum_list_attention));
            }
            gVar2.f.setPadding(0, 0, 0, com.baidu.adp.lib.util.h.a((Context) this.c, 2.0f));
            gVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            gVar2.f.setOnClickListener(this.c);
        } else {
            if (this.e != 0) {
                gVar2.f.setBackgroundResource(this.e);
            }
            gVar2.f.setText(u.attention_n);
            gVar2.f.setTextColor(this.c.getResources().getColor(com.baidu.tieba.o.forum_list_attention));
            gVar2.f.setPadding(com.baidu.adp.lib.util.h.a((Context) this.c, 30.0f), 0, com.baidu.adp.lib.util.h.a((Context) this.c, 10.0f), com.baidu.adp.lib.util.h.a((Context) this.c, 2.0f));
            gVar2.f.setGravity(16);
            gVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            gVar2.f.setOnClickListener(this.c);
        }
        return view;
    }

    public int c() {
        if (this.a == null || this.a.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.a.forum_list.length; i2++) {
            int d = ad.c().d(this.a.forum_list[i2].forum_name);
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
    public void onClick(View view) {
        this.c.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.c).a(((g) view.getTag()).b.getText().toString(), null)));
    }
}
