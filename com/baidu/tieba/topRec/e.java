package com.baidu.tieba.topRec;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.as;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TRForumListData f1867a;
    private TopRecActivity c;
    private com.baidu.tieba.util.a d;
    private boolean b = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h = true;

    public e(TopRecActivity topRecActivity) {
        this.c = topRecActivity;
        this.d = new com.baidu.tieba.util.a(this.c);
        this.d.a(BdWebErrorView.ERROR_CODE_400, BdWebErrorView.ERROR_CODE_400);
    }

    public void a(TRForumListData tRForumListData) {
        this.f1867a = tRForumListData;
        if (this.h && this.f1867a.forum_list.length >= 20) {
            this.g = 20;
            this.h = false;
        }
        notifyDataSetChanged();
    }

    public void a() {
        if (this.f1867a != null) {
            if (this.f1867a.forum_list.length - this.g > 20) {
                this.g += 20;
                this.b = false;
            } else {
                this.g = this.f1867a.forum_list.length;
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
        if (this.f1867a == null) {
            return 0;
        }
        return this.g < this.f1867a.forum_list.length ? this.g : this.f1867a.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.f1867a.forum_list.length) {
            return this.f1867a.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.f1867a.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.c, R.layout.top_recommended_list_item, null);
            g gVar = new g(this);
            gVar.f1869a = (ImageView) view.findViewById(R.id.forum_avatar);
            gVar.b = (TextView) view.findViewById(R.id.name);
            gVar.c = (TextView) view.findViewById(R.id.member_count);
            gVar.d = (TextView) view.findViewById(R.id.thread_count);
            gVar.e = (TextView) view.findViewById(R.id.slogan);
            gVar.f = (TextView) view.findViewById(R.id.like);
            view.setTag(gVar);
            view.setOnClickListener(this);
        }
        g gVar2 = (g) view.getTag();
        int ap = TiebaApplication.g().ap();
        as.c(gVar2.b, ap);
        as.c(gVar2.c, ap);
        as.c(gVar2.d, ap);
        as.c(gVar2.e, ap);
        as.c(gVar2.f, ap);
        if (ap != 1) {
            gVar2.b.setTextColor(-14277082);
            gVar2.c.setTextColor(-6775644);
            gVar2.d.setTextColor(-6775644);
            gVar2.e.setTextColor(-6842215);
        }
        if (ap == 1) {
            view.setBackgroundColor(this.c.getResources().getColor(R.color.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.c.getResources().getColor(R.color.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.f1867a.forum_list[i];
        av.e("ForumListAdapter", "getView", "forum name:" + this.f1867a.forum_list[i].forum_name + "forum avatar:" + this.f1867a.forum_list[i].avatar);
        String str = tRForum.avatar;
        this.d.e(str, new f(this, str, gVar2.f1869a));
        gVar2.f1869a.setTag(str);
        gVar2.b.setText(tRForum.forum_name);
        gVar2.c.setText(String.valueOf(this.c.getString(R.string.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        gVar2.d.setText(String.valueOf(this.c.getString(R.string.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        gVar2.e.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.f != 0) {
                gVar2.f.setBackgroundResource(this.f);
            }
            gVar2.f.setText(R.string.attention_y);
            gVar2.f.setGravity(17);
            if (TiebaApplication.g().ap() == 1) {
                gVar2.f.setTextColor(this.c.getResources().getColor(R.color.forum_list_already_attention_night));
            } else {
                gVar2.f.setTextColor(this.c.getResources().getColor(R.color.forum_list_attention));
            }
            gVar2.f.setPadding(0, 0, 0, UtilHelper.a((Context) this.c, 2.0f));
            gVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            gVar2.f.setOnClickListener(this.c);
        } else {
            if (this.e != 0) {
                gVar2.f.setBackgroundResource(this.e);
            }
            gVar2.f.setText(R.string.attention_n);
            gVar2.f.setTextColor(this.c.getResources().getColor(R.color.forum_list_attention));
            gVar2.f.setPadding(UtilHelper.a((Context) this.c, 30.0f), 0, UtilHelper.a((Context) this.c, 10.0f), UtilHelper.a((Context) this.c, 2.0f));
            gVar2.f.setGravity(16);
            gVar2.f.setTag(Integer.valueOf(tRForum.forum_id));
            gVar2.f.setOnClickListener(this.c);
        }
        return view;
    }

    public int c() {
        if (this.f1867a == null || this.f1867a.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f1867a.forum_list.length; i2++) {
            int d = TiebaApplication.g().d(this.f1867a.forum_list[i2].forum_name);
            if (d == 1) {
                if (this.f1867a.forum_list[i2].is_like == 0) {
                    this.f1867a.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (d == -1 && this.f1867a.forum_list[i2].is_like == 1) {
                this.f1867a.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity.a(this.c, ((g) view.getTag()).b.getText().toString(), (String) null);
    }
}
