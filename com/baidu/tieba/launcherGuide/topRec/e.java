package com.baidu.tieba.launcherGuide.topRec;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {
    private TRForumListData bxD;
    private TopRecActivity bxM;
    private boolean bxL = false;
    private int bxN = 0;
    private int bxO = 0;
    private int bxP = 0;
    private boolean bxQ = true;

    public e(TopRecActivity topRecActivity) {
        this.bxM = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bxD = tRForumListData;
        if (this.bxQ && this.bxD.forum_list.length >= 20) {
            this.bxP = 20;
            this.bxQ = false;
        }
        notifyDataSetChanged();
    }

    public void Ws() {
        if (this.bxD != null) {
            if (this.bxD.forum_list.length - this.bxP > 20) {
                this.bxP += 20;
                this.bxL = false;
            } else {
                this.bxP = this.bxD.forum_list.length;
                this.bxL = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean Wt() {
        return this.bxL;
    }

    public void ac(int i, int i2) {
        this.bxN = i;
        this.bxO = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bxD == null) {
            return 0;
        }
        return this.bxP < this.bxD.forum_list.length ? this.bxP : this.bxD.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bxD.forum_list.length) {
            return this.bxD.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bxD.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.bxM.getPageContext().getPageActivity(), w.top_recommended_list_item, null);
            f fVar = new f(this);
            fVar.bxR = (BarImageView) view.findViewById(v.forum_avatar);
            fVar.aXK = (TextView) view.findViewById(v.name);
            fVar.bxS = (TextView) view.findViewById(v.member_count);
            fVar.bxT = (TextView) view.findViewById(v.thread_count);
            fVar.bwr = (TextView) view.findViewById(v.slogan);
            fVar.bxU = (TextView) view.findViewById(v.like);
            view.setTag(fVar);
            view.setOnClickListener(this);
        }
        f fVar2 = (f) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        ba.d(fVar2.aXK, skinType);
        ba.d(fVar2.bxS, skinType);
        ba.d(fVar2.bxT, skinType);
        ba.d(fVar2.bwr, skinType);
        ba.d(fVar2.bxU, skinType);
        if (skinType != 1) {
            fVar2.aXK.setTextColor(-14277082);
            fVar2.bxS.setTextColor(-6775644);
            fVar2.bxT.setTextColor(-6775644);
            fVar2.bwr.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.bxM.getResources().getColor(s.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.bxM.getResources().getColor(s.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bxD.forum_list[i];
        String str = tRForum.avatar;
        fVar2.bxR.setTag(str);
        fVar2.bxR.a(str, 10, 400, 400, false);
        fVar2.aXK.setText(tRForum.forum_name);
        fVar2.bxS.setText(String.valueOf(this.bxM.getPageContext().getString(y.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        fVar2.bxT.setText(String.valueOf(this.bxM.getPageContext().getString(y.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        fVar2.bwr.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bxO != 0) {
                ba.i((View) fVar2.bxU, this.bxO);
            }
            fVar2.bxU.setText(y.attention_y);
            fVar2.bxU.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                fVar2.bxU.setTextColor(this.bxM.getResources().getColor(s.forum_list_already_attention_night));
            } else {
                fVar2.bxU.setTextColor(this.bxM.getResources().getColor(s.forum_list_attention));
            }
            fVar2.bxU.setPadding(0, 0, 0, n.dip2px(this.bxM.getPageContext().getPageActivity(), 2.0f));
            fVar2.bxU.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.bxU.setOnClickListener(this.bxM);
        } else {
            if (this.bxN != 0) {
                ba.i((View) fVar2.bxU, this.bxN);
            }
            fVar2.bxU.setText(y.attention_n);
            fVar2.bxU.setTextColor(this.bxM.getResources().getColor(s.forum_list_attention));
            fVar2.bxU.setPadding(n.dip2px(this.bxM.getPageContext().getPageActivity(), 30.0f), 0, n.dip2px(this.bxM.getPageContext().getPageActivity(), 10.0f), n.dip2px(this.bxM.getPageContext().getPageActivity(), 2.0f));
            fVar2.bxU.setGravity(16);
            fVar2.bxU.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.bxU.setOnClickListener(this.bxM);
        }
        return view;
    }

    public int Wu() {
        if (this.bxD == null || this.bxD.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bxD.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.bxD.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.bxD.forum_list[i2].is_like == 0) {
                    this.bxD.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.bxD.forum_list[i2].is_like == 1) {
                this.bxD.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bxM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bxM.getPageContext().getPageActivity()).createNormalCfg(((f) view.getTag()).aXK.getText().toString(), null)));
    }
}
