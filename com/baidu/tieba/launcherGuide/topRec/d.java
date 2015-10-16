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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData bSP;
    private TopRecActivity bSY;
    private boolean bSX = false;
    private int bSZ = 0;
    private int bTa = 0;
    private int bTb = 0;
    private boolean bTc = true;

    public d(TopRecActivity topRecActivity) {
        this.bSY = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bSP = tRForumListData;
        if (this.bTc && this.bSP.forum_list.length >= 20) {
            this.bTb = 20;
            this.bTc = false;
        }
        notifyDataSetChanged();
    }

    public void aaR() {
        if (this.bSP != null) {
            if (this.bSP.forum_list.length - this.bTb > 20) {
                this.bTb += 20;
                this.bSX = false;
            } else {
                this.bTb = this.bSP.forum_list.length;
                this.bSX = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aaS() {
        return this.bSX;
    }

    public void as(int i, int i2) {
        this.bSZ = i;
        this.bTa = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bSP == null) {
            return 0;
        }
        return this.bTb < this.bSP.forum_list.length ? this.bTb : this.bSP.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bSP.forum_list.length) {
            return this.bSP.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bSP.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.bSY.getPageContext().getPageActivity(), i.g.top_recommended_list_item, null);
            a aVar = new a();
            aVar.bTd = (BarImageView) view.findViewById(i.f.forum_avatar);
            aVar.bsm = (TextView) view.findViewById(i.f.name);
            aVar.bTe = (TextView) view.findViewById(i.f.member_count);
            aVar.bTf = (TextView) view.findViewById(i.f.thread_count);
            aVar.bRA = (TextView) view.findViewById(i.f.slogan);
            aVar.bTg = (TextView) view.findViewById(i.f.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        an.d(aVar2.bsm, skinType);
        an.d(aVar2.bTe, skinType);
        an.d(aVar2.bTf, skinType);
        an.d(aVar2.bRA, skinType);
        an.d(aVar2.bTg, skinType);
        if (skinType != 1) {
            aVar2.bsm.setTextColor(-14277082);
            aVar2.bTe.setTextColor(-6775644);
            aVar2.bTf.setTextColor(-6775644);
            aVar2.bRA.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.bSY.getResources().getColor(i.c.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.bSY.getResources().getColor(i.c.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bSP.forum_list[i];
        String str = tRForum.avatar;
        aVar2.bTd.setTag(str);
        aVar2.bTd.a(str, 10, 400, 400, false);
        aVar2.bsm.setText(tRForum.forum_name);
        aVar2.bTe.setText(String.valueOf(this.bSY.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.bTf.setText(String.valueOf(this.bSY.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.bRA.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bTa != 0) {
                an.i((View) aVar2.bTg, this.bTa);
            }
            aVar2.bTg.setText(i.h.attention_y);
            aVar2.bTg.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                aVar2.bTg.setTextColor(this.bSY.getResources().getColor(i.c.forum_list_already_attention_night));
            } else {
                aVar2.bTg.setTextColor(this.bSY.getResources().getColor(i.c.forum_list_attention));
            }
            aVar2.bTg.setPadding(0, 0, 0, k.dip2px(this.bSY.getPageContext().getPageActivity(), 2.0f));
            aVar2.bTg.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.bTg.setOnClickListener(this.bSY);
        } else {
            if (this.bSZ != 0) {
                an.i((View) aVar2.bTg, this.bSZ);
            }
            aVar2.bTg.setText(i.h.attention_n);
            aVar2.bTg.setTextColor(this.bSY.getResources().getColor(i.c.forum_list_attention));
            aVar2.bTg.setPadding(k.dip2px(this.bSY.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.bSY.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.bSY.getPageContext().getPageActivity(), 2.0f));
            aVar2.bTg.setGravity(16);
            aVar2.bTg.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.bTg.setOnClickListener(this.bSY);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView bRA;
        BarImageView bTd;
        TextView bTe;
        TextView bTf;
        TextView bTg;
        TextView bsm;

        a() {
        }
    }

    public int aaT() {
        if (this.bSP == null || this.bSP.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bSP.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.bSP.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.bSP.forum_list[i2].is_like == 0) {
                    this.bSP.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.bSP.forum_list[i2].is_like == 1) {
                this.bSP.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bSY.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).bsm.getText().toString(), null)));
    }
}
