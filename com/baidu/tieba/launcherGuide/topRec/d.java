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
    private TRForumListData cED;
    private TopRecActivity cEM;
    private boolean cEL = false;
    private int cEN = 0;
    private int cEO = 0;
    private int bSr = 0;
    private boolean cEP = true;

    public d(TopRecActivity topRecActivity) {
        this.cEM = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.cED = tRForumListData;
        if (this.cEP && this.cED.forum_list.length >= 20) {
            this.bSr = 20;
            this.cEP = false;
        }
        notifyDataSetChanged();
    }

    public void anr() {
        if (this.cED != null) {
            if (this.cED.forum_list.length - this.bSr > 20) {
                this.bSr += 20;
                this.cEL = false;
            } else {
                this.bSr = this.cED.forum_list.length;
                this.cEL = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean ans() {
        return this.cEL;
    }

    public void aF(int i, int i2) {
        this.cEN = i;
        this.cEO = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cED == null) {
            return 0;
        }
        return this.bSr < this.cED.forum_list.length ? this.bSr : this.cED.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.cED.forum_list.length) {
            return this.cED.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.cED.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.cEM.getPageContext().getPageActivity(), t.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.cEQ = (BarImageView) view.findViewById(t.g.forum_avatar);
            aVar.cao = (TextView) view.findViewById(t.g.name);
            aVar.cER = (TextView) view.findViewById(t.g.member_count);
            aVar.cES = (TextView) view.findViewById(t.g.thread_count);
            aVar.cET = (TextView) view.findViewById(t.g.slogan);
            aVar.cEU = (TextView) view.findViewById(t.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        at.d(aVar2.cao, skinType);
        at.d(aVar2.cER, skinType);
        at.d(aVar2.cES, skinType);
        at.d(aVar2.cET, skinType);
        at.d(aVar2.cEU, skinType);
        if (skinType != 1) {
            aVar2.cao.setTextColor(-14277082);
            aVar2.cER.setTextColor(-6775644);
            aVar2.cES.setTextColor(-6775644);
            aVar2.cET.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.cEM.getResources().getColor(t.d.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.cEM.getResources().getColor(t.d.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.cED.forum_list[i];
        String str = tRForum.avatar;
        aVar2.cEQ.setTag(str);
        aVar2.cEQ.a(str, 10, 400, 400, false);
        aVar2.cao.setText(tRForum.forum_name);
        aVar2.cER.setText(String.valueOf(this.cEM.getPageContext().getString(t.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.cES.setText(String.valueOf(this.cEM.getPageContext().getString(t.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.cET.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.cEO != 0) {
                at.k(aVar2.cEU, this.cEO);
            }
            aVar2.cEU.setText(t.j.attention_y);
            aVar2.cEU.setGravity(17);
            if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
                aVar2.cEU.setTextColor(this.cEM.getResources().getColor(t.d.forum_list_already_attention_night));
            } else {
                aVar2.cEU.setTextColor(this.cEM.getResources().getColor(t.d.forum_list_attention));
            }
            aVar2.cEU.setPadding(0, 0, 0, k.dip2px(this.cEM.getPageContext().getPageActivity(), 2.0f));
            aVar2.cEU.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.cEU.setOnClickListener(this.cEM);
        } else {
            if (this.cEN != 0) {
                at.k(aVar2.cEU, this.cEN);
            }
            aVar2.cEU.setText(t.j.attention_n);
            aVar2.cEU.setTextColor(this.cEM.getResources().getColor(t.d.forum_list_attention));
            aVar2.cEU.setPadding(k.dip2px(this.cEM.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.cEM.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.cEM.getPageContext().getPageActivity(), 2.0f));
            aVar2.cEU.setGravity(16);
            aVar2.cEU.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.cEU.setOnClickListener(this.cEM);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        BarImageView cEQ;
        TextView cER;
        TextView cES;
        TextView cET;
        TextView cEU;
        TextView cao;

        a() {
        }
    }

    public int ant() {
        if (this.cED == null || this.cED.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.cED.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.cED.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.cED.forum_list[i2].is_like == 0) {
                    this.cED.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.cED.forum_list[i2].is_like == 1) {
                this.cED.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cEM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cEM.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).cao.getText().toString(), null)));
    }
}
