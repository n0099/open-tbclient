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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData dFF;
    private TopRecActivity dFO;
    private boolean dFN = false;
    private int dFP = 0;
    private int dFQ = 0;
    private int cQS = 0;
    private boolean dFR = true;

    public d(TopRecActivity topRecActivity) {
        this.dFO = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dFF = tRForumListData;
        if (this.dFR && this.dFF.forum_list.length >= 20) {
            this.cQS = 20;
            this.dFR = false;
        }
        notifyDataSetChanged();
    }

    public void aDw() {
        if (this.dFF != null) {
            if (this.dFF.forum_list.length - this.cQS > 20) {
                this.cQS += 20;
                this.dFN = false;
            } else {
                this.cQS = this.dFF.forum_list.length;
                this.dFN = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aDx() {
        return this.dFN;
    }

    public void bg(int i, int i2) {
        this.dFP = i;
        this.dFQ = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dFF == null) {
            return 0;
        }
        return this.cQS < this.dFF.forum_list.length ? this.cQS : this.dFF.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dFF.forum_list.length) {
            return this.dFF.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dFF.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dFO.getPageContext().getPageActivity(), r.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.btk = (BarImageView) view.findViewById(r.g.forum_avatar);
            aVar.daX = (TextView) view.findViewById(r.g.name);
            aVar.btl = (TextView) view.findViewById(r.g.member_count);
            aVar.dFS = (TextView) view.findViewById(r.g.thread_count);
            aVar.dFT = (TextView) view.findViewById(r.g.slogan);
            aVar.dFU = (TextView) view.findViewById(r.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        at.d(aVar2.daX, skinType);
        at.d(aVar2.btl, skinType);
        at.d(aVar2.dFS, skinType);
        at.d(aVar2.dFT, skinType);
        at.d(aVar2.dFU, skinType);
        if (skinType != 1) {
            aVar2.daX.setTextColor(-14277082);
            aVar2.btl.setTextColor(-6775644);
            aVar2.dFS.setTextColor(-6775644);
            aVar2.dFT.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dFO.getResources().getColor(r.d.common_color_10150));
        } else {
            view.setBackgroundColor(this.dFO.getResources().getColor(r.d.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dFF.forum_list[i];
        String str = tRForum.avatar;
        aVar2.btk.setTag(str);
        aVar2.btk.a(str, 10, 400, 400, false);
        aVar2.daX.setText(tRForum.forum_name);
        aVar2.btl.setText(String.valueOf(this.dFO.getPageContext().getString(r.j.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dFS.setText(String.valueOf(this.dFO.getPageContext().getString(r.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dFT.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dFQ != 0) {
                at.k(aVar2.dFU, this.dFQ);
            }
            aVar2.dFU.setText(r.j.attention_y);
            aVar2.dFU.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.dFU.setTextColor(this.dFO.getResources().getColor(r.d.common_color_10204));
            } else {
                aVar2.dFU.setTextColor(this.dFO.getResources().getColor(r.d.common_color_10202));
            }
            aVar2.dFU.setPadding(0, 0, 0, k.dip2px(this.dFO.getPageContext().getPageActivity(), 2.0f));
            aVar2.dFU.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dFU.setOnClickListener(this.dFO);
        } else {
            if (this.dFP != 0) {
                at.k(aVar2.dFU, this.dFP);
            }
            aVar2.dFU.setText(r.j.attention_n);
            aVar2.dFU.setTextColor(this.dFO.getResources().getColor(r.d.common_color_10202));
            aVar2.dFU.setPadding(k.dip2px(this.dFO.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dFO.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dFO.getPageContext().getPageActivity(), 2.0f));
            aVar2.dFU.setGravity(16);
            aVar2.dFU.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dFU.setOnClickListener(this.dFO);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        BarImageView btk;
        TextView btl;
        TextView dFS;
        TextView dFT;
        TextView dFU;
        TextView daX;

        a() {
        }
    }

    public int aDy() {
        if (this.dFF == null || this.dFF.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dFF.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dFF.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dFF.forum_list[i2].is_like == 0) {
                    this.dFF.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dFF.forum_list[i2].is_like == 1) {
                this.dFF.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dFO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dFO.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).daX.getText().toString(), null)));
    }
}
