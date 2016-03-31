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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData cEL;
    private TopRecActivity cEU;
    private boolean cET = false;
    private int cEV = 0;
    private int cEW = 0;
    private int bRQ = 0;
    private boolean cEX = true;

    public d(TopRecActivity topRecActivity) {
        this.cEU = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.cEL = tRForumListData;
        if (this.cEX && this.cEL.forum_list.length >= 20) {
            this.bRQ = 20;
            this.cEX = false;
        }
        notifyDataSetChanged();
    }

    public void ans() {
        if (this.cEL != null) {
            if (this.cEL.forum_list.length - this.bRQ > 20) {
                this.bRQ += 20;
                this.cET = false;
            } else {
                this.bRQ = this.cEL.forum_list.length;
                this.cET = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean ant() {
        return this.cET;
    }

    public void aG(int i, int i2) {
        this.cEV = i;
        this.cEW = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cEL == null) {
            return 0;
        }
        return this.bRQ < this.cEL.forum_list.length ? this.bRQ : this.cEL.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.cEL.forum_list.length) {
            return this.cEL.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.cEL.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.cEU.getPageContext().getPageActivity(), t.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.cEY = (BarImageView) view.findViewById(t.g.forum_avatar);
            aVar.bZJ = (TextView) view.findViewById(t.g.name);
            aVar.cEZ = (TextView) view.findViewById(t.g.member_count);
            aVar.cFa = (TextView) view.findViewById(t.g.thread_count);
            aVar.cDs = (TextView) view.findViewById(t.g.slogan);
            aVar.cFb = (TextView) view.findViewById(t.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        at.d(aVar2.bZJ, skinType);
        at.d(aVar2.cEZ, skinType);
        at.d(aVar2.cFa, skinType);
        at.d(aVar2.cDs, skinType);
        at.d(aVar2.cFb, skinType);
        if (skinType != 1) {
            aVar2.bZJ.setTextColor(-14277082);
            aVar2.cEZ.setTextColor(-6775644);
            aVar2.cFa.setTextColor(-6775644);
            aVar2.cDs.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.cEU.getResources().getColor(t.d.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.cEU.getResources().getColor(t.d.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.cEL.forum_list[i];
        String str = tRForum.avatar;
        aVar2.cEY.setTag(str);
        aVar2.cEY.a(str, 10, 400, 400, false);
        aVar2.bZJ.setText(tRForum.forum_name);
        aVar2.cEZ.setText(String.valueOf(this.cEU.getPageContext().getString(t.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.cFa.setText(String.valueOf(this.cEU.getPageContext().getString(t.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.cDs.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.cEW != 0) {
                at.k(aVar2.cFb, this.cEW);
            }
            aVar2.cFb.setText(t.j.attention_y);
            aVar2.cFb.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                aVar2.cFb.setTextColor(this.cEU.getResources().getColor(t.d.forum_list_already_attention_night));
            } else {
                aVar2.cFb.setTextColor(this.cEU.getResources().getColor(t.d.forum_list_attention));
            }
            aVar2.cFb.setPadding(0, 0, 0, k.dip2px(this.cEU.getPageContext().getPageActivity(), 2.0f));
            aVar2.cFb.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.cFb.setOnClickListener(this.cEU);
        } else {
            if (this.cEV != 0) {
                at.k(aVar2.cFb, this.cEV);
            }
            aVar2.cFb.setText(t.j.attention_n);
            aVar2.cFb.setTextColor(this.cEU.getResources().getColor(t.d.forum_list_attention));
            aVar2.cFb.setPadding(k.dip2px(this.cEU.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.cEU.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.cEU.getPageContext().getPageActivity(), 2.0f));
            aVar2.cFb.setGravity(16);
            aVar2.cFb.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.cFb.setOnClickListener(this.cEU);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView bZJ;
        TextView cDs;
        BarImageView cEY;
        TextView cEZ;
        TextView cFa;
        TextView cFb;

        a() {
        }
    }

    public int anu() {
        if (this.cEL == null || this.cEL.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.cEL.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.cEL.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.cEL.forum_list[i2].is_like == 0) {
                    this.cEL.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.cEL.forum_list[i2].is_like == 1) {
                this.cEL.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cEU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cEU.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).bZJ.getText().toString(), null)));
    }
}
