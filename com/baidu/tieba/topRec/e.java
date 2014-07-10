package com.baidu.tieba.topRec;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.r;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ai;
import com.baidu.tieba.s;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {
    private TRForumListData a;
    private TopRecActivity c;
    private boolean b = false;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private boolean g = true;

    public e(TopRecActivity topRecActivity) {
        this.c = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.a = tRForumListData;
        if (this.g && this.a.forum_list.length >= 20) {
            this.f = 20;
            this.g = false;
        }
        notifyDataSetChanged();
    }

    public void a() {
        if (this.a != null) {
            if (this.a.forum_list.length - this.f > 20) {
                this.f += 20;
                this.b = false;
            } else {
                this.f = this.a.forum_list.length;
                this.b = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean b() {
        return this.b;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.f < this.a.forum_list.length ? this.f : this.a.forum_list.length;
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
            view = View.inflate(this.c, w.top_recommended_list_item, null);
            f fVar = new f(this);
            fVar.a = (HeadImageView) view.findViewById(v.forum_avatar);
            fVar.b = (TextView) view.findViewById(v.name);
            fVar.c = (TextView) view.findViewById(v.member_count);
            fVar.d = (TextView) view.findViewById(v.thread_count);
            fVar.e = (TextView) view.findViewById(v.slogan);
            fVar.f = (TextView) view.findViewById(v.like);
            view.setTag(fVar);
            view.setOnClickListener(this);
        }
        f fVar2 = (f) view.getTag();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        bk.c(fVar2.b, skinType);
        bk.c(fVar2.c, skinType);
        bk.c(fVar2.d, skinType);
        bk.c(fVar2.e, skinType);
        bk.c(fVar2.f, skinType);
        if (skinType != 1) {
            fVar2.b.setTextColor(-14277082);
            fVar2.c.setTextColor(-6775644);
            fVar2.d.setTextColor(-6775644);
            fVar2.e.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.c.getResources().getColor(s.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.c.getResources().getColor(s.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.a.forum_list[i];
        String str = tRForum.avatar;
        fVar2.a.setTag(str);
        fVar2.a.a(str, 10, 400, 400, false);
        fVar2.b.setText(tRForum.forum_name);
        fVar2.c.setText(String.valueOf(this.c.getString(y.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        fVar2.d.setText(String.valueOf(this.c.getString(y.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        fVar2.e.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.e != 0) {
                fVar2.f.setBackgroundResource(this.e);
            }
            fVar2.f.setText(y.attention_y);
            fVar2.f.setGravity(17);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                fVar2.f.setTextColor(this.c.getResources().getColor(s.forum_list_already_attention_night));
            } else {
                fVar2.f.setTextColor(this.c.getResources().getColor(s.forum_list_attention));
            }
            fVar2.f.setPadding(0, 0, 0, com.baidu.adp.lib.util.j.a((Context) this.c, 2.0f));
            fVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.f.setOnClickListener(this.c);
        } else {
            if (this.d != 0) {
                fVar2.f.setBackgroundResource(this.d);
            }
            fVar2.f.setText(y.attention_n);
            fVar2.f.setTextColor(this.c.getResources().getColor(s.forum_list_attention));
            fVar2.f.setPadding(com.baidu.adp.lib.util.j.a((Context) this.c, 30.0f), 0, com.baidu.adp.lib.util.j.a((Context) this.c, 10.0f), com.baidu.adp.lib.util.j.a((Context) this.c, 2.0f));
            fVar2.f.setGravity(16);
            fVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.f.setOnClickListener(this.c);
        }
        return view;
    }

    public int c() {
        if (this.a == null || this.a.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.a.forum_list.length; i2++) {
            int d = ai.c().d(this.a.forum_list[i2].forum_name);
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
        this.c.sendMessage(new CustomMessage(2003000, new r(this.c).a(((f) view.getTag()).b.getText().toString(), null)));
    }
}
