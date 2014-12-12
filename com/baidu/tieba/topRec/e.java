package com.baidu.tieba.topRec;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {
    private TRForumListData ccF;
    private TopRecActivity ccO;
    private boolean ccN = false;
    private int ccP = 0;
    private int ccQ = 0;
    private int bXQ = 0;
    private boolean ccR = true;

    public e(TopRecActivity topRecActivity) {
        this.ccO = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.ccF = tRForumListData;
        if (this.ccR && this.ccF.forum_list.length >= 20) {
            this.bXQ = 20;
            this.ccR = false;
        }
        notifyDataSetChanged();
    }

    public void ajx() {
        if (this.ccF != null) {
            if (this.ccF.forum_list.length - this.bXQ > 20) {
                this.bXQ += 20;
                this.ccN = false;
            } else {
                this.bXQ = this.ccF.forum_list.length;
                this.ccN = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean ajy() {
        return this.ccN;
    }

    public void I(int i, int i2) {
        this.ccP = i;
        this.ccQ = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ccF == null) {
            return 0;
        }
        return this.bXQ < this.ccF.forum_list.length ? this.bXQ : this.ccF.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.ccF.forum_list.length) {
            return this.ccF.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.ccF.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.ccO.getPageContext().getPageActivity(), x.top_recommended_list_item, null);
            f fVar = new f(this);
            fVar.azm = (BarImageView) view.findViewById(w.forum_avatar);
            fVar.azp = (TextView) view.findViewById(w.name);
            fVar.azq = (TextView) view.findViewById(w.member_count);
            fVar.azr = (TextView) view.findViewById(w.thread_count);
            fVar.azs = (TextView) view.findViewById(w.slogan);
            fVar.azt = (TextView) view.findViewById(w.like);
            view.setTag(fVar);
            view.setOnClickListener(this);
        }
        f fVar2 = (f) view.getTag();
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        ax.d(fVar2.azp, skinType);
        ax.d(fVar2.azq, skinType);
        ax.d(fVar2.azr, skinType);
        ax.d(fVar2.azs, skinType);
        ax.d(fVar2.azt, skinType);
        if (skinType != 1) {
            fVar2.azp.setTextColor(-14277082);
            fVar2.azq.setTextColor(-6775644);
            fVar2.azr.setTextColor(-6775644);
            fVar2.azs.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.ccO.getResources().getColor(t.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.ccO.getResources().getColor(t.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.ccF.forum_list[i];
        String str = tRForum.avatar;
        fVar2.azm.setTag(str);
        fVar2.azm.a(str, 10, 400, 400, false);
        fVar2.azp.setText(tRForum.forum_name);
        fVar2.azq.setText(String.valueOf(this.ccO.getPageContext().getString(z.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        fVar2.azr.setText(String.valueOf(this.ccO.getPageContext().getString(z.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        fVar2.azs.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.ccQ != 0) {
                ax.i((View) fVar2.azt, this.ccQ);
            }
            fVar2.azt.setText(z.attention_y);
            fVar2.azt.setGravity(17);
            if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                fVar2.azt.setTextColor(this.ccO.getResources().getColor(t.forum_list_already_attention_night));
            } else {
                fVar2.azt.setTextColor(this.ccO.getResources().getColor(t.forum_list_attention));
            }
            fVar2.azt.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.dip2px(this.ccO.getPageContext().getPageActivity(), 2.0f));
            fVar2.azt.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.azt.setOnClickListener(this.ccO);
        } else {
            if (this.ccP != 0) {
                ax.i((View) fVar2.azt, this.ccP);
            }
            fVar2.azt.setText(z.attention_n);
            fVar2.azt.setTextColor(this.ccO.getResources().getColor(t.forum_list_attention));
            fVar2.azt.setPadding(com.baidu.adp.lib.util.l.dip2px(this.ccO.getPageContext().getPageActivity(), 30.0f), 0, com.baidu.adp.lib.util.l.dip2px(this.ccO.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.ccO.getPageContext().getPageActivity(), 2.0f));
            fVar2.azt.setGravity(16);
            fVar2.azt.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.azt.setOnClickListener(this.ccO);
        }
        return view;
    }

    public int ajz() {
        if (this.ccF == null || this.ccF.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.ccF.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.ccF.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.ccF.forum_list[i2].is_like == 0) {
                    this.ccF.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.ccF.forum_list[i2].is_like == 1) {
                this.ccF.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ccO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ccO.getPageContext().getPageActivity()).createNormalCfg(((f) view.getTag()).azp.getText().toString(), null)));
    }
}
