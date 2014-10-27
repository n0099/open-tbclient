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
    private TRForumListData bPq;
    private TopRecActivity bPz;
    private boolean bPy = false;
    private int bPA = 0;
    private int bPB = 0;
    private int blc = 0;
    private boolean bPC = true;

    public e(TopRecActivity topRecActivity) {
        this.bPz = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bPq = tRForumListData;
        if (this.bPC && this.bPq.forum_list.length >= 20) {
            this.blc = 20;
            this.bPC = false;
        }
        notifyDataSetChanged();
    }

    public void aeq() {
        if (this.bPq != null) {
            if (this.bPq.forum_list.length - this.blc > 20) {
                this.blc += 20;
                this.bPy = false;
            } else {
                this.blc = this.bPq.forum_list.length;
                this.bPy = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean aer() {
        return this.bPy;
    }

    public void H(int i, int i2) {
        this.bPA = i;
        this.bPB = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bPq == null) {
            return 0;
        }
        return this.blc < this.bPq.forum_list.length ? this.blc : this.bPq.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bPq.forum_list.length) {
            return this.bPq.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bPq.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.bPz, w.top_recommended_list_item, null);
            f fVar = new f(this);
            fVar.avW = (BarImageView) view.findViewById(v.forum_avatar);
            fVar.avZ = (TextView) view.findViewById(v.name);
            fVar.awa = (TextView) view.findViewById(v.member_count);
            fVar.awb = (TextView) view.findViewById(v.thread_count);
            fVar.awc = (TextView) view.findViewById(v.slogan);
            fVar.awd = (TextView) view.findViewById(v.like);
            view.setTag(fVar);
            view.setOnClickListener(this);
        }
        f fVar2 = (f) view.getTag();
        int skinType = TbadkApplication.m251getInst().getSkinType();
        aw.c(fVar2.avZ, skinType);
        aw.c(fVar2.awa, skinType);
        aw.c(fVar2.awb, skinType);
        aw.c(fVar2.awc, skinType);
        aw.c(fVar2.awd, skinType);
        if (skinType != 1) {
            fVar2.avZ.setTextColor(-14277082);
            fVar2.awa.setTextColor(-6775644);
            fVar2.awb.setTextColor(-6775644);
            fVar2.awc.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.bPz.getResources().getColor(s.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.bPz.getResources().getColor(s.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bPq.forum_list[i];
        String str = tRForum.avatar;
        fVar2.avW.setTag(str);
        fVar2.avW.a(str, 10, 400, 400, false);
        fVar2.avZ.setText(tRForum.forum_name);
        fVar2.awa.setText(String.valueOf(this.bPz.getString(y.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        fVar2.awb.setText(String.valueOf(this.bPz.getString(y.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        fVar2.awc.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bPB != 0) {
                aw.h((View) fVar2.awd, this.bPB);
            }
            fVar2.awd.setText(y.attention_y);
            fVar2.awd.setGravity(17);
            if (TbadkApplication.m251getInst().getSkinType() == 1) {
                fVar2.awd.setTextColor(this.bPz.getResources().getColor(s.forum_list_already_attention_night));
            } else {
                fVar2.awd.setTextColor(this.bPz.getResources().getColor(s.forum_list_attention));
            }
            fVar2.awd.setPadding(0, 0, 0, m.dip2px(this.bPz, 2.0f));
            fVar2.awd.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.awd.setOnClickListener(this.bPz);
        } else {
            if (this.bPA != 0) {
                aw.h((View) fVar2.awd, this.bPA);
            }
            fVar2.awd.setText(y.attention_n);
            fVar2.awd.setTextColor(this.bPz.getResources().getColor(s.forum_list_attention));
            fVar2.awd.setPadding(m.dip2px(this.bPz, 30.0f), 0, m.dip2px(this.bPz, 10.0f), m.dip2px(this.bPz, 2.0f));
            fVar2.awd.setGravity(16);
            fVar2.awd.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.awd.setOnClickListener(this.bPz);
        }
        return view;
    }

    public int aes() {
        if (this.bPq == null || this.bPq.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bPq.forum_list.length; i2++) {
            int dV = aj.wk().dV(this.bPq.forum_list[i2].forum_name);
            if (dV == 1) {
                if (this.bPq.forum_list[i2].is_like == 0) {
                    this.bPq.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (dV == -1 && this.bPq.forum_list[i2].is_like == 1) {
                this.bPq.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bPz.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bPz).createNormalCfg(((f) view.getTag()).avZ.getText().toString(), null)));
    }
}
