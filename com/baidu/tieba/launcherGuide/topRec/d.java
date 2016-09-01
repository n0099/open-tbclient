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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData dyK;
    private TopRecActivity dyT;
    private boolean dyS = false;
    private int dyU = 0;
    private int dyV = 0;
    private int cKL = 0;
    private boolean dyW = true;

    public d(TopRecActivity topRecActivity) {
        this.dyT = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dyK = tRForumListData;
        if (this.dyW && this.dyK.forum_list.length >= 20) {
            this.cKL = 20;
            this.dyW = false;
        }
        notifyDataSetChanged();
    }

    public void aBc() {
        if (this.dyK != null) {
            if (this.dyK.forum_list.length - this.cKL > 20) {
                this.cKL += 20;
                this.dyS = false;
            } else {
                this.cKL = this.dyK.forum_list.length;
                this.dyS = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aBd() {
        return this.dyS;
    }

    public void bd(int i, int i2) {
        this.dyU = i;
        this.dyV = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dyK == null) {
            return 0;
        }
        return this.cKL < this.dyK.forum_list.length ? this.cKL : this.dyK.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dyK.forum_list.length) {
            return this.dyK.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dyK.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dyT.getPageContext().getPageActivity(), t.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.bqc = (BarImageView) view.findViewById(t.g.forum_avatar);
            aVar.cTS = (TextView) view.findViewById(t.g.name);
            aVar.bqd = (TextView) view.findViewById(t.g.member_count);
            aVar.dyX = (TextView) view.findViewById(t.g.thread_count);
            aVar.dyY = (TextView) view.findViewById(t.g.slogan);
            aVar.dyZ = (TextView) view.findViewById(t.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.d(aVar2.cTS, skinType);
        av.d(aVar2.bqd, skinType);
        av.d(aVar2.dyX, skinType);
        av.d(aVar2.dyY, skinType);
        av.d(aVar2.dyZ, skinType);
        if (skinType != 1) {
            aVar2.cTS.setTextColor(-14277082);
            aVar2.bqd.setTextColor(-6775644);
            aVar2.dyX.setTextColor(-6775644);
            aVar2.dyY.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dyT.getResources().getColor(t.d.common_color_10150));
        } else {
            view.setBackgroundColor(this.dyT.getResources().getColor(t.d.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dyK.forum_list[i];
        String str = tRForum.avatar;
        aVar2.bqc.setTag(str);
        aVar2.bqc.a(str, 10, 400, 400, false);
        aVar2.cTS.setText(tRForum.forum_name);
        aVar2.bqd.setText(String.valueOf(this.dyT.getPageContext().getString(t.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dyX.setText(String.valueOf(this.dyT.getPageContext().getString(t.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dyY.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dyV != 0) {
                av.k(aVar2.dyZ, this.dyV);
            }
            aVar2.dyZ.setText(t.j.attention_y);
            aVar2.dyZ.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.dyZ.setTextColor(this.dyT.getResources().getColor(t.d.common_color_10204));
            } else {
                aVar2.dyZ.setTextColor(this.dyT.getResources().getColor(t.d.common_color_10202));
            }
            aVar2.dyZ.setPadding(0, 0, 0, k.dip2px(this.dyT.getPageContext().getPageActivity(), 2.0f));
            aVar2.dyZ.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dyZ.setOnClickListener(this.dyT);
        } else {
            if (this.dyU != 0) {
                av.k(aVar2.dyZ, this.dyU);
            }
            aVar2.dyZ.setText(t.j.attention_n);
            aVar2.dyZ.setTextColor(this.dyT.getResources().getColor(t.d.common_color_10202));
            aVar2.dyZ.setPadding(k.dip2px(this.dyT.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dyT.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dyT.getPageContext().getPageActivity(), 2.0f));
            aVar2.dyZ.setGravity(16);
            aVar2.dyZ.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dyZ.setOnClickListener(this.dyT);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        BarImageView bqc;
        TextView bqd;
        TextView cTS;
        TextView dyX;
        TextView dyY;
        TextView dyZ;

        a() {
        }
    }

    public int aBe() {
        if (this.dyK == null || this.dyK.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dyK.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dyK.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dyK.forum_list[i2].is_like == 0) {
                    this.dyK.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dyK.forum_list[i2].is_like == 1) {
                this.dyK.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dyT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dyT.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).cTS.getText().toString(), null)));
    }
}
