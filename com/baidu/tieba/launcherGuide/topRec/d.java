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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData dpN;
    private TopRecActivity dpW;
    private boolean dpV = false;
    private int dpX = 0;
    private int dpY = 0;
    private int cDd = 0;
    private boolean dpZ = true;

    public d(TopRecActivity topRecActivity) {
        this.dpW = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.dpN = tRForumListData;
        if (this.dpZ && this.dpN.forum_list.length >= 20) {
            this.cDd = 20;
            this.dpZ = false;
        }
        notifyDataSetChanged();
    }

    public void axQ() {
        if (this.dpN != null) {
            if (this.dpN.forum_list.length - this.cDd > 20) {
                this.cDd += 20;
                this.dpV = false;
            } else {
                this.cDd = this.dpN.forum_list.length;
                this.dpV = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean axR() {
        return this.dpV;
    }

    public void aV(int i, int i2) {
        this.dpX = i;
        this.dpY = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dpN == null) {
            return 0;
        }
        return this.cDd < this.dpN.forum_list.length ? this.cDd : this.dpN.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.dpN.forum_list.length) {
            return this.dpN.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.dpN.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.dpW.getPageContext().getPageActivity(), r.j.top_recommended_list_item, null);
            a aVar = new a();
            aVar.dqa = (BarImageView) view.findViewById(r.h.forum_avatar);
            aVar.aUd = (TextView) view.findViewById(r.h.name);
            aVar.dqb = (TextView) view.findViewById(r.h.member_count);
            aVar.dqc = (TextView) view.findViewById(r.h.thread_count);
            aVar.dqd = (TextView) view.findViewById(r.h.slogan);
            aVar.dqe = (TextView) view.findViewById(r.h.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        ap.d(aVar2.aUd, skinType);
        ap.d(aVar2.dqb, skinType);
        ap.d(aVar2.dqc, skinType);
        ap.d(aVar2.dqd, skinType);
        ap.d(aVar2.dqe, skinType);
        if (skinType != 1) {
            aVar2.aUd.setTextColor(-14277082);
            aVar2.dqb.setTextColor(-6775644);
            aVar2.dqc.setTextColor(-6775644);
            aVar2.dqd.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.dpW.getResources().getColor(r.e.common_color_10150));
        } else {
            view.setBackgroundColor(this.dpW.getResources().getColor(r.e.common_color_10163));
        }
        TRForumListData.TRForum tRForum = this.dpN.forum_list[i];
        String str = tRForum.avatar;
        aVar2.dqa.setTag(str);
        aVar2.dqa.a(str, 10, 400, 400, false);
        aVar2.aUd.setText(tRForum.forum_name);
        aVar2.dqb.setText(String.valueOf(this.dpW.getPageContext().getString(r.l.attention)) + " " + String.valueOf(tRForum.member_count));
        aVar2.dqc.setText(String.valueOf(this.dpW.getPageContext().getString(r.l.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.dqd.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.dpY != 0) {
                ap.j((View) aVar2.dqe, this.dpY);
            }
            aVar2.dqe.setText(r.l.relate_forum_is_followed);
            aVar2.dqe.setGravity(17);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                aVar2.dqe.setTextColor(this.dpW.getResources().getColor(r.e.common_color_10204));
            } else {
                aVar2.dqe.setTextColor(this.dpW.getResources().getColor(r.e.common_color_10202));
            }
            aVar2.dqe.setPadding(0, 0, 0, k.dip2px(this.dpW.getPageContext().getPageActivity(), 2.0f));
            aVar2.dqe.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dqe.setOnClickListener(this.dpW);
        } else {
            if (this.dpX != 0) {
                ap.j((View) aVar2.dqe, this.dpX);
            }
            aVar2.dqe.setText(r.l.attention);
            aVar2.dqe.setTextColor(this.dpW.getResources().getColor(r.e.common_color_10202));
            aVar2.dqe.setPadding(k.dip2px(this.dpW.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.dpW.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.dpW.getPageContext().getPageActivity(), 2.0f));
            aVar2.dqe.setGravity(16);
            aVar2.dqe.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.dqe.setOnClickListener(this.dpW);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView aUd;
        BarImageView dqa;
        TextView dqb;
        TextView dqc;
        TextView dqd;
        TextView dqe;

        a() {
        }
    }

    public int axS() {
        if (this.dpN == null || this.dpN.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.dpN.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.dpN.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.dpN.forum_list[i2].is_like == 0) {
                    this.dpN.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.dpN.forum_list[i2].is_like == 1) {
                this.dpN.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dpW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dpW.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).aUd.getText().toString(), null)));
    }
}
