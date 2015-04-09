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
    private TRForumListData bxT;
    private TopRecActivity byc;
    private boolean byb = false;
    private int byd = 0;
    private int bye = 0;
    private int byf = 0;
    private boolean byg = true;

    public e(TopRecActivity topRecActivity) {
        this.byc = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bxT = tRForumListData;
        if (this.byg && this.bxT.forum_list.length >= 20) {
            this.byf = 20;
            this.byg = false;
        }
        notifyDataSetChanged();
    }

    public void WF() {
        if (this.bxT != null) {
            if (this.bxT.forum_list.length - this.byf > 20) {
                this.byf += 20;
                this.byb = false;
            } else {
                this.byf = this.bxT.forum_list.length;
                this.byb = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean WG() {
        return this.byb;
    }

    public void ac(int i, int i2) {
        this.byd = i;
        this.bye = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bxT == null) {
            return 0;
        }
        return this.byf < this.bxT.forum_list.length ? this.byf : this.bxT.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bxT.forum_list.length) {
            return this.bxT.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bxT.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.byc.getPageContext().getPageActivity(), w.top_recommended_list_item, null);
            f fVar = new f(this);
            fVar.byh = (BarImageView) view.findViewById(v.forum_avatar);
            fVar.aYa = (TextView) view.findViewById(v.name);
            fVar.byi = (TextView) view.findViewById(v.member_count);
            fVar.byj = (TextView) view.findViewById(v.thread_count);
            fVar.bwH = (TextView) view.findViewById(v.slogan);
            fVar.byk = (TextView) view.findViewById(v.like);
            view.setTag(fVar);
            view.setOnClickListener(this);
        }
        f fVar2 = (f) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        ba.d(fVar2.aYa, skinType);
        ba.d(fVar2.byi, skinType);
        ba.d(fVar2.byj, skinType);
        ba.d(fVar2.bwH, skinType);
        ba.d(fVar2.byk, skinType);
        if (skinType != 1) {
            fVar2.aYa.setTextColor(-14277082);
            fVar2.byi.setTextColor(-6775644);
            fVar2.byj.setTextColor(-6775644);
            fVar2.bwH.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.byc.getResources().getColor(s.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.byc.getResources().getColor(s.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bxT.forum_list[i];
        String str = tRForum.avatar;
        fVar2.byh.setTag(str);
        fVar2.byh.a(str, 10, 400, 400, false);
        fVar2.aYa.setText(tRForum.forum_name);
        fVar2.byi.setText(String.valueOf(this.byc.getPageContext().getString(y.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        fVar2.byj.setText(String.valueOf(this.byc.getPageContext().getString(y.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        fVar2.bwH.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bye != 0) {
                ba.i((View) fVar2.byk, this.bye);
            }
            fVar2.byk.setText(y.attention_y);
            fVar2.byk.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                fVar2.byk.setTextColor(this.byc.getResources().getColor(s.forum_list_already_attention_night));
            } else {
                fVar2.byk.setTextColor(this.byc.getResources().getColor(s.forum_list_attention));
            }
            fVar2.byk.setPadding(0, 0, 0, n.dip2px(this.byc.getPageContext().getPageActivity(), 2.0f));
            fVar2.byk.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.byk.setOnClickListener(this.byc);
        } else {
            if (this.byd != 0) {
                ba.i((View) fVar2.byk, this.byd);
            }
            fVar2.byk.setText(y.attention_n);
            fVar2.byk.setTextColor(this.byc.getResources().getColor(s.forum_list_attention));
            fVar2.byk.setPadding(n.dip2px(this.byc.getPageContext().getPageActivity(), 30.0f), 0, n.dip2px(this.byc.getPageContext().getPageActivity(), 10.0f), n.dip2px(this.byc.getPageContext().getPageActivity(), 2.0f));
            fVar2.byk.setGravity(16);
            fVar2.byk.setTag(Integer.valueOf(tRForum.forum_id));
            fVar2.byk.setOnClickListener(this.byc);
        }
        return view;
    }

    public int WH() {
        if (this.bxT == null || this.bxT.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bxT.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.bxT.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.bxT.forum_list[i2].is_like == 0) {
                    this.bxT.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.bxT.forum_list[i2].is_like == 1) {
                this.bxT.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.byc.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.byc.getPageContext().getPageActivity()).createNormalCfg(((f) view.getTag()).aYa.getText().toString(), null)));
    }
}
