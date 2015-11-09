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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
/* loaded from: classes.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private TRForumListData bTk;
    private TopRecActivity bTt;
    private boolean bTs = false;
    private int bTu = 0;
    private int bTv = 0;
    private int bTw = 0;
    private boolean bTx = true;

    public d(TopRecActivity topRecActivity) {
        this.bTt = topRecActivity;
    }

    public void a(TRForumListData tRForumListData) {
        this.bTk = tRForumListData;
        if (this.bTx && this.bTk.forum_list.length >= 20) {
            this.bTw = 20;
            this.bTx = false;
        }
        notifyDataSetChanged();
    }

    public void abi() {
        if (this.bTk != null) {
            if (this.bTk.forum_list.length - this.bTw > 20) {
                this.bTw += 20;
                this.bTs = false;
            } else {
                this.bTw = this.bTk.forum_list.length;
                this.bTs = true;
            }
            notifyDataSetChanged();
        }
    }

    public boolean abj() {
        return this.bTs;
    }

    public void au(int i, int i2) {
        this.bTu = i;
        this.bTv = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bTk == null) {
            return 0;
        }
        return this.bTw < this.bTk.forum_list.length ? this.bTw : this.bTk.forum_list.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.bTk.forum_list.length) {
            return this.bTk.forum_list[i];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.bTk.forum_list.length) {
            return i;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.bTt.getPageContext().getPageActivity(), i.g.top_recommended_list_item, null);
            a aVar = new a();
            aVar.bTy = (BarImageView) view.findViewById(i.f.forum_avatar);
            aVar.bsQ = (TextView) view.findViewById(i.f.name);
            aVar.bTz = (TextView) view.findViewById(i.f.member_count);
            aVar.bTA = (TextView) view.findViewById(i.f.thread_count);
            aVar.bRV = (TextView) view.findViewById(i.f.slogan);
            aVar.bTB = (TextView) view.findViewById(i.f.like);
            view.setTag(aVar);
            view.setOnClickListener(this);
        }
        a aVar2 = (a) view.getTag();
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        an.d(aVar2.bsQ, skinType);
        an.d(aVar2.bTz, skinType);
        an.d(aVar2.bTA, skinType);
        an.d(aVar2.bRV, skinType);
        an.d(aVar2.bTB, skinType);
        if (skinType != 1) {
            aVar2.bsQ.setTextColor(-14277082);
            aVar2.bTz.setTextColor(-6775644);
            aVar2.bTA.setTextColor(-6775644);
            aVar2.bRV.setTextColor(-6842215);
        }
        if (skinType == 1) {
            view.setBackgroundColor(this.bTt.getResources().getColor(i.c.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.bTt.getResources().getColor(i.c.flist_item_color_even_day));
        }
        TRForumListData.TRForum tRForum = this.bTk.forum_list[i];
        String str = tRForum.avatar;
        aVar2.bTy.setTag(str);
        aVar2.bTy.a(str, 10, 400, 400, false);
        aVar2.bsQ.setText(tRForum.forum_name);
        aVar2.bTz.setText(String.valueOf(this.bTt.getPageContext().getString(i.h.forum_list_attention_tv)) + " " + String.valueOf(tRForum.member_count));
        aVar2.bTA.setText(String.valueOf(this.bTt.getPageContext().getString(i.h.forum_list_thread_tv)) + " " + String.valueOf(tRForum.thread_count));
        aVar2.bRV.setText(tRForum.slogan);
        if (tRForum.is_like == 1) {
            if (this.bTv != 0) {
                an.i((View) aVar2.bTB, this.bTv);
            }
            aVar2.bTB.setText(i.h.attention_y);
            aVar2.bTB.setGravity(17);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                aVar2.bTB.setTextColor(this.bTt.getResources().getColor(i.c.forum_list_already_attention_night));
            } else {
                aVar2.bTB.setTextColor(this.bTt.getResources().getColor(i.c.forum_list_attention));
            }
            aVar2.bTB.setPadding(0, 0, 0, k.dip2px(this.bTt.getPageContext().getPageActivity(), 2.0f));
            aVar2.bTB.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.bTB.setOnClickListener(this.bTt);
        } else {
            if (this.bTu != 0) {
                an.i((View) aVar2.bTB, this.bTu);
            }
            aVar2.bTB.setText(i.h.attention_n);
            aVar2.bTB.setTextColor(this.bTt.getResources().getColor(i.c.forum_list_attention));
            aVar2.bTB.setPadding(k.dip2px(this.bTt.getPageContext().getPageActivity(), 30.0f), 0, k.dip2px(this.bTt.getPageContext().getPageActivity(), 10.0f), k.dip2px(this.bTt.getPageContext().getPageActivity(), 2.0f));
            aVar2.bTB.setGravity(16);
            aVar2.bTB.setTag(Integer.valueOf(tRForum.forum_id));
            aVar2.bTB.setOnClickListener(this.bTt);
        }
        return view;
    }

    /* loaded from: classes.dex */
    class a {
        TextView bRV;
        TextView bTA;
        TextView bTB;
        BarImageView bTy;
        TextView bTz;
        TextView bsQ;

        a() {
        }
    }

    public int abk() {
        if (this.bTk == null || this.bTk.forum_list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bTk.forum_list.length; i2++) {
            int hasLikeForum = TbadkApplication.getInst().hasLikeForum(this.bTk.forum_list[i2].forum_name);
            if (hasLikeForum == 1) {
                if (this.bTk.forum_list[i2].is_like == 0) {
                    this.bTk.forum_list[i2].is_like = 1;
                    i++;
                }
            } else if (hasLikeForum == -1 && this.bTk.forum_list[i2].is_like == 1) {
                this.bTk.forum_list[i2].is_like = 0;
                i--;
            }
        }
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTt.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bTt.getPageContext().getPageActivity()).createNormalCfg(((a) view.getTag()).bsQ.getText().toString(), null)));
    }
}
