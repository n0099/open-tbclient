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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData diD;
    private TopRecActivity diM;
    private boolean diL = false;
    private int diN = 0;
    private int diO = 0;
    private int cvZ = 0;
    private boolean diP = true;

    public d(TopRecActivity topRecActivity) {
        this.diM = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.diD = tRForumListData;
        if (this.diP && this.diD.forum_list.length >= 20) {
            this.cvZ = 20;
            this.diP = false;
        }
        notifyDataSetChanged();
    }

    public void awJ() {
        if (this.diD != null) {
            if (this.diD.forum_list.length - this.cvZ > 20) {
                this.cvZ += 20;
                this.diL = false;
            } else {
                this.cvZ = this.diD.forum_list.length;
                this.diL = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean awK() {
        return this.diL;
    }

    public void aV(int i, int i2) {
        this.diN = i;
        this.diO = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.diD == null) {
            return 0;
        }
        return this.cvZ < this.diD.forum_list.length ? this.cvZ : this.diD.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.diD.forum_list.length) {
            return this.diD.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.diD.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.diM.getPageContext().getPageActivity(), r.h.top_recommended_list_item, null);
            a aVar = new a();
            aVar.diQ = (BarImageView) view.findViewById(r.g.forum_avatar);
            aVar.cGh = (TextView) view.findViewById(r.g.name);
            aVar.diR = (TextView) view.findViewById(r.g.member_count);
            aVar.diS = (TextView) view.findViewById(r.g.thread_count);
            aVar.diT = (TextView) view.findViewById(r.g.slogan);
            aVar.diU = (TextView) view.findViewById(r.g.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        ar.d(aVar2.cGh, skinType);
        ar.d(aVar2.diR, skinType);
        ar.d(aVar2.diS, skinType);
        ar.d(aVar2.diT, skinType);
        ar.d(aVar2.diU, skinType);
        if (skinType != 1) {
            aVar2.cGh.setTextColor(-14277082);
            aVar2.diR.setTextColor(-6775644);
            aVar2.diS.setTextColor(-6775644);
            aVar2.diT.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.diM.getResources().getColor(r.d.common_color_10150));
        } else {
            view.setBackgroundColor(this.diM.getResources().getColor(r.d.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.diD.forum_list[i];
        String str = tRForum.avatar;
        aVar2.diQ.setTag(str);
        aVar2.diQ.a(str, 10, 400, 400, false);
        aVar2.cGh.setText(tRForum.forum_name);
        aVar2.diR.setText(String.valueOf(this.diM.getPageContext().getString(r.j.attention)) + " " + String.valueOf(tRForum.member_count));
        aVar2.diS.setText(String.valueOf(this.diM.getPageContext().getString(r.j.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.diT.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.diO != 0) {
                ar.k(aVar2.diU, this.diO);
            }
            aVar2.diU.setText(r.j.attention_y);
            aVar2.diU.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.diU.setTextColor(this.diM.getResources().getColor(r.d.common_color_10204));
            } else {
                aVar2.diU.setTextColor(this.diM.getResources().getColor(r.d.common_color_10202));
            }
            aVar2.diU.setPadding(0, 0, 0, k.dip2px(this.diM.getPageContext().getPageActivity(), 2.0f));
            aVar2.diU.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.diU.setOnClickListener(this.diM);
        } else {
            if (this.diN != 0) {
                ar.k(aVar2.diU, this.diN);
            }
            aVar2.diU.setText(r.j.attention);
            aVar2.diU.setTextColor(this.diM.getResources().getColor(r.d.common_color_10202));
            aVar2.diU.setPadding(k.dip2px(this.diM.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.diM.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.diM.getPageContext().getPageActivity(), 2.0f));
            aVar2.diU.setGravity(16);
            aVar2.diU.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.diU.setOnClickListener(this.diM);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView cGh;
        BarImageView diQ;
        TextView diR;
        TextView diS;
        TextView diT;
        TextView diU;

        a() {
        }
    }

    public int awL() {
        if (this.diD == null || this.diD.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.diD.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.diD.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.diD.forum_list[i2].is_like == 0) {
                    this.diD.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.diD.forum_list[i2].is_like == 1) {
                this.diD.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.diM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.diM.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).cGh.getText().toString(), null)));
    }
}
