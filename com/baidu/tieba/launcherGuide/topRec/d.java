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
    private TRForumListData dnc;
    private TopRecActivity dnl;
    private boolean dnk = false;
    private int dnm = 0;
    private int dnn = 0;
    private int czg = 0;
    private boolean dno = true;

    public d(TopRecActivity topRecActivity) {
        this.dnl = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dnc = tRForumListData;
        if (this.dno && this.dnc.forum_list.length >= 20) {
            this.czg = 20;
            this.dno = false;
        }
        notifyDataSetChanged();
    }

    public void awp() {
        if (this.dnc != null) {
            if (this.dnc.forum_list.length - this.czg > 20) {
                this.czg += 20;
                this.dnk = false;
            } else {
                this.czg = this.dnc.forum_list.length;
                this.dnk = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean awq() {
        return this.dnk;
    }

    public void aZ(int i, int i2) {
        this.dnm = i;
        this.dnn = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dnc == null) {
            return 0;
        }
        return this.czg < this.dnc.forum_list.length ? this.czg : this.dnc.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dnc.forum_list.length) {
            return this.dnc.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dnc.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dnl.getPageContext().getPageActivity(), u.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.beI = (BarImageView) view.findViewById(u.g.forum_avatar);
            aVar.cIn = (TextView) view.findViewById(u.g.name);
            aVar.beJ = (TextView) view.findViewById(u.g.member_count);
            aVar.dnp = (TextView) view.findViewById(u.g.thread_count);
            aVar.dnq = (TextView) view.findViewById(u.g.slogan);
            aVar.dnr = (TextView) view.findViewById(u.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        av.d(aVar2.cIn, skinType);
        av.d(aVar2.beJ, skinType);
        av.d(aVar2.dnp, skinType);
        av.d(aVar2.dnq, skinType);
        av.d(aVar2.dnr, skinType);
        if (skinType != 1) {
            aVar2.cIn.setTextColor(-14277082);
            aVar2.beJ.setTextColor(-6775644);
            aVar2.dnp.setTextColor(-6775644);
            aVar2.dnq.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dnl.getResources().getColor(u.d.common_color_10150));
        } else {
            view.setBackgroundColor(this.dnl.getResources().getColor(u.d.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dnc.forum_list[i];
        String str = tRForum.avatar;
        aVar2.beI.setTag(str);
        aVar2.beI.a(str, 10, 400, 400, false);
        aVar2.cIn.setText(tRForum.forum_name);
        aVar2.beJ.setText(String.valueOf(this.dnl.getPageContext().getString(u.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dnp.setText(String.valueOf(this.dnl.getPageContext().getString(u.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dnq.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dnn != 0) {
                av.k(aVar2.dnr, this.dnn);
            }
            aVar2.dnr.setText(u.j.attention_y);
            aVar2.dnr.setGravity(17);
            if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
                aVar2.dnr.setTextColor(this.dnl.getResources().getColor(u.d.common_color_10204));
            } else {
                aVar2.dnr.setTextColor(this.dnl.getResources().getColor(u.d.common_color_10202));
            }
            aVar2.dnr.setPadding(0, 0, 0, k.dip2px(this.dnl.getPageContext().getPageActivity(), 2.0f));
            aVar2.dnr.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dnr.setOnClickListener(this.dnl);
        } else {
            if (this.dnm != 0) {
                av.k(aVar2.dnr, this.dnm);
            }
            aVar2.dnr.setText(u.j.attention_n);
            aVar2.dnr.setTextColor(this.dnl.getResources().getColor(u.d.common_color_10202));
            aVar2.dnr.setPadding(k.dip2px(this.dnl.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dnl.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dnl.getPageContext().getPageActivity(), 2.0f));
            aVar2.dnr.setGravity(16);
            aVar2.dnr.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dnr.setOnClickListener(this.dnl);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        BarImageView beI;
        TextView beJ;
        TextView cIn;
        TextView dnp;
        TextView dnq;
        TextView dnr;

        a() {
        }
    }

    public int awr() {
        if (this.dnc == null || this.dnc.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dnc.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dnc.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dnc.forum_list[i2].is_like == 0) {
                    this.dnc.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dnc.forum_list[i2].is_like == 1) {
                this.dnc.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dnl.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dnl.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).cIn.getText().toString(), null)));
    }
}
