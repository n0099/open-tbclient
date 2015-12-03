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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TopRecActivity cjH;
    private TRForumListData cjy;
    private boolean cjG = false;
    private int cjI = 0;
    private int cjJ = 0;
    private int cjK = 0;
    private boolean cjL = true;

    public d(TopRecActivity topRecActivity) {
        this.cjH = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.cjy = tRForumListData;
        if (this.cjL && this.cjy.forum_list.length >= 20) {
            this.cjK = 20;
            this.cjL = false;
        }
        notifyDataSetChanged();
    }

    public void aeO() {
        if (this.cjy != null) {
            if (this.cjy.forum_list.length - this.cjK > 20) {
                this.cjK += 20;
                this.cjG = false;
            } else {
                this.cjK = this.cjy.forum_list.length;
                this.cjG = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aeP() {
        return this.cjG;
    }

    public void aw(int i, int i2) {
        this.cjI = i;
        this.cjJ = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cjy == null) {
            return 0;
        }
        return this.cjK < this.cjy.forum_list.length ? this.cjK : this.cjy.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.cjy.forum_list.length) {
            return this.cjy.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.cjy.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.cjH.getPageContext().getPageActivity(), n.g.top_recommended_list_item, null);
            a aVar = new a();
            aVar.cjM = (BarImageView) view.findViewById(n.f.forum_avatar);
            aVar.bHW = (TextView) view.findViewById(n.f.name);
            aVar.cjN = (TextView) view.findViewById(n.f.member_count);
            aVar.cjO = (TextView) view.findViewById(n.f.thread_count);
            aVar.cii = (TextView) view.findViewById(n.f.slogan);
            aVar.cjP = (TextView) view.findViewById(n.f.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        as.d(aVar2.bHW, skinType);
        as.d(aVar2.cjN, skinType);
        as.d(aVar2.cjO, skinType);
        as.d(aVar2.cii, skinType);
        as.d(aVar2.cjP, skinType);
        if (skinType != 1) {
            aVar2.bHW.setTextColor(-14277082);
            aVar2.cjN.setTextColor(-6775644);
            aVar2.cjO.setTextColor(-6775644);
            aVar2.cii.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.cjH.getResources().getColor(n.c.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.cjH.getResources().getColor(n.c.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.cjy.forum_list[i];
        String str = tRForum.avatar;
        aVar2.cjM.setTag(str);
        aVar2.cjM.a(str, 10, 400, 400, false);
        aVar2.bHW.setText(tRForum.forum_name);
        aVar2.cjN.setText(String.valueOf(this.cjH.getPageContext().getString(n.i.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.cjO.setText(String.valueOf(this.cjH.getPageContext().getString(n.i.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.cii.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.cjJ != 0) {
                as.i((View) aVar2.cjP, this.cjJ);
            }
            aVar2.cjP.setText(n.i.attention_y);
            aVar2.cjP.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                aVar2.cjP.setTextColor(this.cjH.getResources().getColor(n.c.forum_list_already_attention_night));
            } else {
                aVar2.cjP.setTextColor(this.cjH.getResources().getColor(n.c.forum_list_attention));
            }
            aVar2.cjP.setPadding(0, 0, 0, k.dip2px(this.cjH.getPageContext().getPageActivity(), 2.0f));
            aVar2.cjP.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.cjP.setOnClickListener(this.cjH);
        } else {
            if (this.cjI != 0) {
                as.i((View) aVar2.cjP, this.cjI);
            }
            aVar2.cjP.setText(n.i.attention_n);
            aVar2.cjP.setTextColor(this.cjH.getResources().getColor(n.c.forum_list_attention));
            aVar2.cjP.setPadding(k.dip2px(this.cjH.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.cjH.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.cjH.getPageContext().getPageActivity(), 2.0f));
            aVar2.cjP.setGravity(16);
            aVar2.cjP.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.cjP.setOnClickListener(this.cjH);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView bHW;
        TextView cii;
        BarImageView cjM;
        TextView cjN;
        TextView cjO;
        TextView cjP;

        a() {
        }
    }

    public int aeQ() {
        if (this.cjy == null || this.cjy.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.cjy.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.cjy.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.cjy.forum_list[i2].is_like == 0) {
                    this.cjy.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.cjy.forum_list[i2].is_like == 1) {
                this.cjy.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cjH.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cjH.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).bHW.getText().toString(), null)));
    }
}
