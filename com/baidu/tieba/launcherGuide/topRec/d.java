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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData bSE;
    private TopRecActivity bSN;
    private boolean bSM = false;
    private int bSO = 0;
    private int bSP = 0;
    private int bSQ = 0;
    private boolean bSR = true;

    public d(TopRecActivity topRecActivity) {
        this.bSN = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bSE = tRForumListData;
        if (this.bSR && this.bSE.forum_list.length >= 20) {
            this.bSQ = 20;
            this.bSR = false;
        }
        notifyDataSetChanged();
    }

    public void aaR() {
        if (this.bSE != null) {
            if (this.bSE.forum_list.length - this.bSQ > 20) {
                this.bSQ += 20;
                this.bSM = false;
            } else {
                this.bSQ = this.bSE.forum_list.length;
                this.bSM = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aaS() {
        return this.bSM;
    }

    public void as(int i, int i2) {
        this.bSO = i;
        this.bSP = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bSE == null) {
            return 0;
        }
        return this.bSQ < this.bSE.forum_list.length ? this.bSQ : this.bSE.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bSE.forum_list.length) {
            return this.bSE.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bSE.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.bSN.getPageContext().getPageActivity(), i.g.top_recommended_list_item, null);
            a aVar = new a();
            aVar.bSS = (BarImageView) view.findViewById(i.f.forum_avatar);
            aVar.bsb = (TextView) view.findViewById(i.f.name);
            aVar.bST = (TextView) view.findViewById(i.f.member_count);
            aVar.bSU = (TextView) view.findViewById(i.f.thread_count);
            aVar.bRp = (TextView) view.findViewById(i.f.slogan);
            aVar.bSV = (TextView) view.findViewById(i.f.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        am.d(aVar2.bsb, skinType);
        am.d(aVar2.bST, skinType);
        am.d(aVar2.bSU, skinType);
        am.d(aVar2.bRp, skinType);
        am.d(aVar2.bSV, skinType);
        if (skinType != 1) {
            aVar2.bsb.setTextColor(-14277082);
            aVar2.bST.setTextColor(-6775644);
            aVar2.bSU.setTextColor(-6775644);
            aVar2.bRp.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.bSN.getResources().getColor(i.c.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.bSN.getResources().getColor(i.c.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bSE.forum_list[i];
        String str = tRForum.avatar;
        aVar2.bSS.setTag(str);
        aVar2.bSS.a(str, 10, 400, 400, false);
        aVar2.bsb.setText(tRForum.forum_name);
        aVar2.bST.setText(String.valueOf(this.bSN.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.bSU.setText(String.valueOf(this.bSN.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.bRp.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bSP != 0) {
                am.i((View) aVar2.bSV, this.bSP);
            }
            aVar2.bSV.setText(i.h.attention_y);
            aVar2.bSV.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                aVar2.bSV.setTextColor(this.bSN.getResources().getColor(i.c.forum_list_already_attention_night));
            } else {
                aVar2.bSV.setTextColor(this.bSN.getResources().getColor(i.c.forum_list_attention));
            }
            aVar2.bSV.setPadding(0, 0, 0, k.dip2px(this.bSN.getPageContext().getPageActivity(), 2.0f));
            aVar2.bSV.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.bSV.setOnClickListener(this.bSN);
        } else {
            if (this.bSO != 0) {
                am.i((View) aVar2.bSV, this.bSO);
            }
            aVar2.bSV.setText(i.h.attention_n);
            aVar2.bSV.setTextColor(this.bSN.getResources().getColor(i.c.forum_list_attention));
            aVar2.bSV.setPadding(k.dip2px(this.bSN.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.bSN.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.bSN.getPageContext().getPageActivity(), 2.0f));
            aVar2.bSV.setGravity(16);
            aVar2.bSV.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.bSV.setOnClickListener(this.bSN);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView bRp;
        BarImageView bSS;
        TextView bST;
        TextView bSU;
        TextView bSV;
        TextView bsb;

        a() {
        }
    }

    public int aaT() {
        if (this.bSE == null || this.bSE.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bSE.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.bSE.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.bSE.forum_list[i2].is_like == 0) {
                    this.bSE.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.bSE.forum_list[i2].is_like == 1) {
                this.bSE.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bSN.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).bsb.getText().toString(), null)));
    }
}
