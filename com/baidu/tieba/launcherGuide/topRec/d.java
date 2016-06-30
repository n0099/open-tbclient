package com.baidu.tieba.launcherGuide.topRec;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData dkd;
    private TopRecActivity dkm;
    private boolean dkl = false;
    private int dkn = 0;
    private int dko = 0;
    private int cwr = 0;
    private boolean dkp = true;

    public d(TopRecActivity topRecActivity) {
        this.dkm = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dkd = tRForumListData;
        if (this.dkp && this.dkd.forum_list.length >= 20) {
            this.cwr = 20;
            this.dkp = false;
        }
        notifyDataSetChanged();
    }

    public void avD() {
        if (this.dkd != null) {
            if (this.dkd.forum_list.length - this.cwr > 20) {
                this.cwr += 20;
                this.dkl = false;
            } else {
                this.cwr = this.dkd.forum_list.length;
                this.dkl = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean avE() {
        return this.dkl;
    }

    public void aW(int i, int i2) {
        this.dkn = i;
        this.dko = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dkd == null) {
            return 0;
        }
        return this.cwr < this.dkd.forum_list.length ? this.cwr : this.dkd.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dkd.forum_list.length) {
            return this.dkd.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dkd.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dkm.getPageContext().getPageActivity(), u.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.bdw = (BarImageView) view.findViewById(u.g.forum_avatar);
            aVar.cFy = (TextView) view.findViewById(u.g.name);
            aVar.bdx = (TextView) view.findViewById(u.g.member_count);
            aVar.dkq = (TextView) view.findViewById(u.g.thread_count);
            aVar.dkr = (TextView) view.findViewById(u.g.slogan);
            aVar.dks = (TextView) view.findViewById(u.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.d(aVar2.cFy, skinType);
        av.d(aVar2.bdx, skinType);
        av.d(aVar2.dkq, skinType);
        av.d(aVar2.dkr, skinType);
        av.d(aVar2.dks, skinType);
        if (skinType != 1) {
            aVar2.cFy.setTextColor(-14277082);
            aVar2.bdx.setTextColor(-6775644);
            aVar2.dkq.setTextColor(-6775644);
            aVar2.dkr.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dkm.getResources().getColor(u.d.common_color_10150));
        } else {
            view.setBackgroundColor(this.dkm.getResources().getColor(u.d.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dkd.forum_list[i];
        String str = tRForum.avatar;
        aVar2.bdw.setTag(str);
        aVar2.bdw.a(str, 10, 400, 400, false);
        aVar2.cFy.setText(tRForum.forum_name);
        aVar2.bdx.setText(String.valueOf(this.dkm.getPageContext().getString(u.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dkq.setText(String.valueOf(this.dkm.getPageContext().getString(u.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dkr.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dko != 0) {
                av.k(aVar2.dks, this.dko);
            }
            aVar2.dks.setText(u.j.attention_y);
            aVar2.dks.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.dks.setTextColor(this.dkm.getResources().getColor(u.d.common_color_10204));
            } else {
                aVar2.dks.setTextColor(this.dkm.getResources().getColor(u.d.common_color_10202));
            }
            aVar2.dks.setPadding(0, 0, 0, k.dip2px(this.dkm.getPageContext().getPageActivity(), 2.0f));
            aVar2.dks.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dks.setOnClickListener(this.dkm);
        } else {
            if (this.dkn != 0) {
                av.k(aVar2.dks, this.dkn);
            }
            aVar2.dks.setText(u.j.attention_n);
            aVar2.dks.setTextColor(this.dkm.getResources().getColor(u.d.common_color_10202));
            aVar2.dks.setPadding(k.dip2px(this.dkm.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dkm.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dkm.getPageContext().getPageActivity(), 2.0f));
            aVar2.dks.setGravity(16);
            aVar2.dks.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dks.setOnClickListener(this.dkm);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        BarImageView bdw;
        TextView bdx;
        TextView cFy;
        TextView dkq;
        TextView dkr;
        TextView dks;

        a() {
        }
    }

    public int avF() {
        if (this.dkd == null || this.dkd.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dkd.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dkd.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dkd.forum_list[i2].is_like == 0) {
                    this.dkd.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dkd.forum_list[i2].is_like == 1) {
                this.dkd.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dkm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dkm.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).cFy.getText().toString(), null)));
    }
}
