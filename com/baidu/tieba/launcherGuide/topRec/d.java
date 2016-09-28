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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData dAb;
    private TopRecActivity dAk;
    private boolean dAj = false;
    private int dAl = 0;
    private int dAm = 0;
    private int cLC = 0;
    private boolean dAn = true;

    public d(TopRecActivity topRecActivity) {
        this.dAk = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dAb = tRForumListData;
        if (this.dAn && this.dAb.forum_list.length >= 20) {
            this.cLC = 20;
            this.dAn = false;
        }
        notifyDataSetChanged();
    }

    public void aBA() {
        if (this.dAb != null) {
            if (this.dAb.forum_list.length - this.cLC > 20) {
                this.cLC += 20;
                this.dAj = false;
            } else {
                this.cLC = this.dAb.forum_list.length;
                this.dAj = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aBB() {
        return this.dAj;
    }

    public void bf(int i, int i2) {
        this.dAl = i;
        this.dAm = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dAb == null) {
            return 0;
        }
        return this.cLC < this.dAb.forum_list.length ? this.cLC : this.dAb.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dAb.forum_list.length) {
            return this.dAb.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dAb.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dAk.getPageContext().getPageActivity(), r.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.bqp = (BarImageView) view.findViewById(r.g.forum_avatar);
            aVar.cVm = (TextView) view.findViewById(r.g.name);
            aVar.bqq = (TextView) view.findViewById(r.g.member_count);
            aVar.dAo = (TextView) view.findViewById(r.g.thread_count);
            aVar.dAp = (TextView) view.findViewById(r.g.slogan);
            aVar.dAq = (TextView) view.findViewById(r.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.d(aVar2.cVm, skinType);
        av.d(aVar2.bqq, skinType);
        av.d(aVar2.dAo, skinType);
        av.d(aVar2.dAp, skinType);
        av.d(aVar2.dAq, skinType);
        if (skinType != 1) {
            aVar2.cVm.setTextColor(-14277082);
            aVar2.bqq.setTextColor(-6775644);
            aVar2.dAo.setTextColor(-6775644);
            aVar2.dAp.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dAk.getResources().getColor(r.d.common_color_10150));
        } else {
            view.setBackgroundColor(this.dAk.getResources().getColor(r.d.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dAb.forum_list[i];
        String str = tRForum.avatar;
        aVar2.bqp.setTag(str);
        aVar2.bqp.a(str, 10, 400, 400, false);
        aVar2.cVm.setText(tRForum.forum_name);
        aVar2.bqq.setText(String.valueOf(this.dAk.getPageContext().getString(r.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dAo.setText(String.valueOf(this.dAk.getPageContext().getString(r.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dAp.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dAm != 0) {
                av.k(aVar2.dAq, this.dAm);
            }
            aVar2.dAq.setText(r.j.attention_y);
            aVar2.dAq.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.dAq.setTextColor(this.dAk.getResources().getColor(r.d.common_color_10204));
            } else {
                aVar2.dAq.setTextColor(this.dAk.getResources().getColor(r.d.common_color_10202));
            }
            aVar2.dAq.setPadding(0, 0, 0, k.dip2px(this.dAk.getPageContext().getPageActivity(), 2.0f));
            aVar2.dAq.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dAq.setOnClickListener(this.dAk);
        } else {
            if (this.dAl != 0) {
                av.k(aVar2.dAq, this.dAl);
            }
            aVar2.dAq.setText(r.j.attention_n);
            aVar2.dAq.setTextColor(this.dAk.getResources().getColor(r.d.common_color_10202));
            aVar2.dAq.setPadding(k.dip2px(this.dAk.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dAk.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dAk.getPageContext().getPageActivity(), 2.0f));
            aVar2.dAq.setGravity(16);
            aVar2.dAq.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dAq.setOnClickListener(this.dAk);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        BarImageView bqp;
        TextView bqq;
        TextView cVm;
        TextView dAo;
        TextView dAp;
        TextView dAq;

        a() {
        }
    }

    public int aBC() {
        if (this.dAb == null || this.dAb.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dAb.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dAb.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dAb.forum_list[i2].is_like == 0) {
                    this.dAb.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dAb.forum_list[i2].is_like == 1) {
                this.dAb.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dAk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dAk.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).cVm.getText().toString(), null)));
    }
}
