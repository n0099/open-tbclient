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
    private LikeModel bUt;
    private TbPageContext eKe;
    private int fpA;
    public int iAf = -1;
    private int iAg = 0;
    private boolean izM = true;
    private ForumDetailActivityConfig.FromType iAh = ForumDetailActivityConfig.FromType.BAR_DIR;
    private boolean isNight = false;
    private ForumInfoData[] iAi = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aUM;
        BarImageView gMK;
        TextView gML;
        TextView gMM;
        TextView gMN;
        TextView iAj;
        TextView iAk;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fpA = 0;
        this.eKe = tbPageContext;
        this.fpA = i;
    }

    public ForumInfoData[] ccN() {
        return this.iAi;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.iAh = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.iAi = forumInfoDataArr;
        if (this.iAi != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.bUt = likeModel;
    }

    public void ck(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void ccO() {
        for (int i = 0; i < this.iAg; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.iAi[i].forum_name);
            if (hasLikeForum == 1) {
                this.iAi[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.iAi[i].is_like = 0;
            }
        }
    }

    public boolean ccP() {
        if (this.bUt == null) {
            return false;
        }
        return this.bUt.cdF();
    }

    public void yp(int i) {
        this.iAg = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.izM = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iAi == null) {
            return 0;
        }
        return this.iAg <= this.iAi.length ? this.iAg : this.iAi.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.iAg) {
            return null;
        }
        return this.iAi[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.eKe.getContext(), d.h.forum_list_forum_item, null);
            a aVar = new a();
            aVar.gMK = (BarImageView) view.findViewById(d.g.forum_avatar);
            aVar.gMK.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(d.g.name);
            aVar.gML = (TextView) view.findViewById(d.g.member_count);
            aVar.gMM = (TextView) view.findViewById(d.g.thread_count);
            aVar.gMN = (TextView) view.findViewById(d.g.slogan);
            aVar.iAk = (TextView) view.findViewById(d.g.like);
            aVar.aUM = (TextView) view.findViewById(d.g.rank_badge);
            aVar.iAj = (TextView) view.findViewById(d.g.rise_no);
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
        this.eKe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eKe.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.iAi[i];
        String str = this.iAi[i].avatar;
        aVar2.gMK.setTag(str);
        aVar2.gMK.invalidate();
        aVar2.gMK.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.iAk.setTag(forumInfoData.forum_name);
        aVar2.gML.setText(this.eKe.getString(d.j.attention) + " " + vb(forumInfoData.member_count));
        aVar2.gMM.setText(this.eKe.getString(d.j.text_post) + " " + vb(forumInfoData.thread_count));
        aVar2.gMN.setText(forumInfoData.slogan);
        if (this.fpA == 0) {
            aVar2.iAj.setVisibility(8);
            if (!this.izM) {
                aVar2.aUM.setVisibility(8);
            } else {
                aVar2.aUM.setVisibility(0);
                aVar2.aUM.setText((CharSequence) null);
                aVar2.aUM.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        al.k(aVar2.aUM, d.f.icon_brief_grade_orange);
                        break;
                    case 1:
                        al.k(aVar2.aUM, d.f.icon_brief_grade_blue);
                        break;
                    case 2:
                        al.k(aVar2.aUM, d.f.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.aUM.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.aUM.setVisibility(8);
            aVar2.iAj.setVisibility(0);
            aVar2.iAj.setText((CharSequence) null);
            aVar2.iAj.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.iAj.setText(this.eKe.getString(d.j.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.eKe.getString(d.j.number));
        }
        aVar2.iAk.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.like) {
            TiebaStatic.eventStat(this.eKe.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.eKe.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.eKe.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && com.baidu.adp.lib.b.d.iQ().aO("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.eKe.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.iAh)));
            return;
        }
        TiebaStatic.eventStat(this.eKe.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.eKe.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.eKe.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String vb(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.eKe.getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void pP(boolean z) {
        this.isNight = z;
        notifyDataSetChanged();
    }
}
