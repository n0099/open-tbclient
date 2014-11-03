package com.baidu.tieba.topRec;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.aj;
import com.baidu.tieba.s;
import com.baidu.tieba.topRec.TRForumListData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {
    private TRForumListData bPF;
    private TopRecActivity bPO;
    private boolean bPN = false;
    private int bPP = 0;
    private int bPQ = 0;
    private int blq = 0;
    private boolean bPR = true;

    public e(TopRecActivity topRecActivity) {
        this.bPO = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bPF = tRForumListData;
        if (this.bPR && this.bPF.forum_list.length >= 20) {
            this.blq = 20;
            this.bPR = false;
        }
        notifyDataSetChanged();
    }

    public void aet() {
        if (this.bPF != null) {
            if (this.bPF.forum_list.length - this.blq > 20) {
                this.blq += 20;
                this.bPN = false;
            } else {
                this.blq = this.bPF.forum_list.length;
                this.bPN = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aeu() {
        return this.bPN;
    }

    public void H(int i, int i2) {
        this.bPP = i;
        this.bPQ = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bPF == null) {
            return 0;
        }
        return this.blq < this.bPF.forum_list.length ? this.blq : this.bPF.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bPF.forum_list.length) {
            return this.bPF.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bPF.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.bPO, w.top_recommended_list_item, null);
            f fVar = new f(this);
            fVar.awf = (BarImageView) view.findViewById(v.forum_avatar);
            fVar.awi = (TextView) view.findViewById(v.name);
            fVar.awj = (TextView) view.findViewById(v.member_count);
            fVar.awk = (TextView) view.findViewById(v.thread_count);
            fVar.awl = (TextView) view.findViewById(v.slogan);
            fVar.awm = (TextView) view.findViewById(v.like);
            view.setTag(fVar);
            view.setOnClickListener(this);
        }
        f fVar2 = (f) view.getTag();
        int skinType = TbadkApplication.m251getInst().getSkinType();
        aw.c(fVar2.awi, skinType);
        aw.c(fVar2.awj, skinType);
        aw.c(fVar2.awk, skinType);
        aw.c(fVar2.awl, skinType);
        aw.c(fVar2.awm, skinType);
        if (skinType != 1) {
            fVar2.awi.setTextColor(-14277082);
            fVar2.awj.setTextColor(-6775644);
            fVar2.awk.setTextColor(-6775644);
            fVar2.awl.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.bPO.getResources().getColor(s.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.bPO.getResources().getColor(s.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bPF.forum_list[i];
        String str = tRForum.avatar;
        fVar2.awf.setTag(str);
        fVar2.awf.a(str, 10, 400, 400, false);
        fVar2.awi.setText(tRForum.forum_name);
        fVar2.awj.setText(String.valueOf(this.bPO.getString(y.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        fVar2.awk.setText(String.valueOf(this.bPO.getString(y.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        fVar2.awl.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bPQ != 0) {
                aw.h((View) fVar2.awm, this.bPQ);
            }
            fVar2.awm.setText(y.attention_y);
            fVar2.awm.setGravity(17);
            if (TbadkApplication.m251getInst().getSkinType() == 1) {
                fVar2.awm.setTextColor(this.bPO.getResources().getColor(s.forum_list_already_attention_night));
            } else {
                fVar2.awm.setTextColor(this.bPO.getResources().getColor(s.forum_list_attention));
            }
            fVar2.awm.setPadding(0, 0, 0, m.dip2px(this.bPO, 2.0f));
            fVar2.awm.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.awm.setOnClickListener(this.bPO);
        } else {
            if (this.bPP != 0) {
                aw.h((View) fVar2.awm, this.bPP);
            }
            fVar2.awm.setText(y.attention_n);
            fVar2.awm.setTextColor(this.bPO.getResources().getColor(s.forum_list_attention));
            fVar2.awm.setPadding(m.dip2px(this.bPO, 30.0f), 0, m.dip2px(this.bPO, 10.0f), m.dip2px(this.bPO, 2.0f));
            fVar2.awm.setGravity(16);
            fVar2.awm.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.awm.setOnClickListener(this.bPO);
        }
        return view;
    }

    public int aev() {
        if (this.bPF == null || this.bPF.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bPF.forum_list.length; i2++) {
            int dV = aj.wm().dV(this.bPF.forum_list[i2].forum_name);
            if (dV == 1) {
                if (this.bPF.forum_list[i2].is_like == 0) {
                    this.bPF.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (dV == -1 && this.bPF.forum_list[i2].is_like == 1) {
                this.bPF.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bPO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bPO).createNormalCfg(((f) view.getTag()).awi.getText().toString(), null)));
    }
}
