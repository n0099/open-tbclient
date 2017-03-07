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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData dsg;
    private TopRecActivity dsp;
    private boolean dso = false;
    private int dsq = 0;
    private int dsr = 0;
    private int cEz = 0;
    private boolean dss = true;

    public d(TopRecActivity topRecActivity) {
        this.dsp = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dsg = tRForumListData;
        if (this.dss && this.dsg.forum_list.length >= 20) {
            this.cEz = 20;
            this.dss = false;
        }
        notifyDataSetChanged();
    }

    public void axm() {
        if (this.dsg != null) {
            if (this.dsg.forum_list.length - this.cEz > 20) {
                this.cEz += 20;
                this.dso = false;
            } else {
                this.cEz = this.dsg.forum_list.length;
                this.dso = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean axn() {
        return this.dso;
    }

    public void aZ(int i, int i2) {
        this.dsq = i;
        this.dsr = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dsg == null) {
            return 0;
        }
        return this.cEz < this.dsg.forum_list.length ? this.cEz : this.dsg.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dsg.forum_list.length) {
            return this.dsg.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dsg.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dsp.getPageContext().getPageActivity(), w.j.top_recommended_list_item, null);
            a aVar = new a();
            aVar.dst = (BarImageView) view.findViewById(w.h.forum_avatar);
            aVar.bap = (TextView) view.findViewById(w.h.name);
            aVar.dsu = (TextView) view.findViewById(w.h.member_count);
            aVar.dsv = (TextView) view.findViewById(w.h.thread_count);
            aVar.dsw = (TextView) view.findViewById(w.h.slogan);
            aVar.dsx = (TextView) view.findViewById(w.h.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        aq.c(aVar2.bap, skinType);
        aq.c(aVar2.dsu, skinType);
        aq.c(aVar2.dsv, skinType);
        aq.c(aVar2.dsw, skinType);
        aq.c(aVar2.dsx, skinType);
        if (skinType != 1) {
            aVar2.bap.setTextColor(-14277082);
            aVar2.dsu.setTextColor(-6775644);
            aVar2.dsv.setTextColor(-6775644);
            aVar2.dsw.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dsp.getResources().getColor(w.e.common_color_10150));
        } else {
            view.setBackgroundColor(this.dsp.getResources().getColor(w.e.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dsg.forum_list[i];
        String str = tRForum.avatar;
        aVar2.dst.setTag(str);
        aVar2.dst.a(str, 10, 400, 400, false);
        aVar2.bap.setText(tRForum.forum_name);
        aVar2.dsu.setText(String.valueOf(this.dsp.getPageContext().getString(w.l.attention)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dsv.setText(String.valueOf(this.dsp.getPageContext().getString(w.l.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dsw.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dsr != 0) {
                aq.j(aVar2.dsx, this.dsr);
            }
            aVar2.dsx.setText(w.l.relate_forum_is_followed);
            aVar2.dsx.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.dsx.setTextColor(this.dsp.getResources().getColor(w.e.common_color_10204));
            } else {
                aVar2.dsx.setTextColor(this.dsp.getResources().getColor(w.e.common_color_10202));
            }
            aVar2.dsx.setPadding(0, 0, 0, k.dip2px(this.dsp.getPageContext().getPageActivity(), 2.0f));
            aVar2.dsx.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dsx.setOnClickListener(this.dsp);
        } else {
            if (this.dsq != 0) {
                aq.j(aVar2.dsx, this.dsq);
            }
            aVar2.dsx.setText(w.l.attention);
            aVar2.dsx.setTextColor(this.dsp.getResources().getColor(w.e.common_color_10202));
            aVar2.dsx.setPadding(k.dip2px(this.dsp.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dsp.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dsp.getPageContext().getPageActivity(), 2.0f));
            aVar2.dsx.setGravity(16);
            aVar2.dsx.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dsx.setOnClickListener(this.dsp);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView bap;
        BarImageView dst;
        TextView dsu;
        TextView dsv;
        TextView dsw;
        TextView dsx;

        a() {
        }
    }

    public int axo() {
        if (this.dsg == null || this.dsg.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dsg.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dsg.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dsg.forum_list[i2].is_like == 0) {
                    this.dsg.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dsg.forum_list[i2].is_like == 1) {
                this.dsg.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dsp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dsp.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).bap.getText().toString(), null)));
    }
}
