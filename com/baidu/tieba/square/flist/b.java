package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel bUs;
    private TbPageContext eKd;
    private int fpA;
    public int iAe = -1;
    private int iAf = 0;
    private boolean izL = true;
    private ForumDetailActivityConfig.FromType iAg = ForumDetailActivityConfig.FromType.BAR_DIR;
    private boolean isNight = false;
    private ForumInfoData[] iAh = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aUL;
        BarImageView gMJ;
        TextView gMK;
        TextView gML;
        TextView gMM;
        TextView iAi;
        TextView iAj;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fpA = 0;
        this.eKd = tbPageContext;
        this.fpA = i;
    }

    public ForumInfoData[] ccN() {
        return this.iAh;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.iAg = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.iAh = forumInfoDataArr;
        if (this.iAh != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.bUs = likeModel;
    }

    public void ck(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void ccO() {
        for (int i = 0; i < this.iAf; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.iAh[i].forum_name);
            if (hasLikeForum == 1) {
                this.iAh[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.iAh[i].is_like = 0;
            }
        }
    }

    public boolean ccP() {
        if (this.bUs == null) {
            return false;
        }
        return this.bUs.cdF();
    }

    public void yp(int i) {
        this.iAf = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.izL = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iAh == null) {
            return 0;
        }
        return this.iAf <= this.iAh.length ? this.iAf : this.iAh.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.iAf) {
            return null;
        }
        return this.iAh[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.eKd.getContext(), d.h.forum_list_forum_item, null);
            a aVar = new a();
            aVar.gMJ = (BarImageView) view.findViewById(d.g.forum_avatar);
            aVar.gMJ.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(d.g.name);
            aVar.gMK = (TextView) view.findViewById(d.g.member_count);
            aVar.gML = (TextView) view.findViewById(d.g.thread_count);
            aVar.gMM = (TextView) view.findViewById(d.g.slogan);
            aVar.iAj = (TextView) view.findViewById(d.g.like);
            aVar.aUL = (TextView) view.findViewById(d.g.rank_badge);
            aVar.iAi = (TextView) view.findViewById(d.g.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(d.g.bd_list_top_divider);
        View findViewById2 = view.findViewById(d.g.bd_list_bottom_divider);
        al.l(findViewById, d.C0277d.cp_bg_line_b);
        al.l(findViewById2, d.C0277d.cp_bg_line_b);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.eKd.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eKd.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.iAh[i];
        String str = this.iAh[i].avatar;
        aVar2.gMJ.setTag(str);
        aVar2.gMJ.invalidate();
        aVar2.gMJ.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.iAj.setTag(forumInfoData.forum_name);
        aVar2.gMK.setText(this.eKd.getString(d.j.attention) + " " + vb(forumInfoData.member_count));
        aVar2.gML.setText(this.eKd.getString(d.j.text_post) + " " + vb(forumInfoData.thread_count));
        aVar2.gMM.setText(forumInfoData.slogan);
        if (this.fpA == 0) {
            aVar2.iAi.setVisibility(8);
            if (!this.izL) {
                aVar2.aUL.setVisibility(8);
            } else {
                aVar2.aUL.setVisibility(0);
                aVar2.aUL.setText((CharSequence) null);
                aVar2.aUL.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        al.k(aVar2.aUL, d.f.icon_brief_grade_orange);
                        break;
                    case 1:
                        al.k(aVar2.aUL, d.f.icon_brief_grade_blue);
                        break;
                    case 2:
                        al.k(aVar2.aUL, d.f.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.aUL.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.aUL.setVisibility(8);
            aVar2.iAi.setVisibility(0);
            aVar2.iAi.setText((CharSequence) null);
            aVar2.iAi.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.iAi.setText(this.eKd.getString(d.j.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.eKd.getString(d.j.number));
        }
        aVar2.iAj.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.like) {
            TiebaStatic.eventStat(this.eKd.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.eKd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.eKd.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && com.baidu.adp.lib.b.d.iQ().aO("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.eKd.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.iAg)));
            return;
        }
        TiebaStatic.eventStat(this.eKd.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.eKd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.eKd.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String vb(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.eKd.getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void pP(boolean z) {
        this.isNight = z;
        notifyDataSetChanged();
    }
}
