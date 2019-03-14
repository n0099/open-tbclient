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
    private LikeModel bUq;
    private TbPageContext eKr;
    private int fpO;
    public int iAu = -1;
    private int iAv = 0;
    private boolean iAb = true;
    private ForumDetailActivityConfig.FromType iAw = ForumDetailActivityConfig.FromType.BAR_DIR;
    private boolean isNight = false;
    private ForumInfoData[] iAx = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aUI;
        BarImageView gMW;
        TextView gMX;
        TextView gMY;
        TextView gMZ;
        TextView iAy;
        TextView iAz;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fpO = 0;
        this.eKr = tbPageContext;
        this.fpO = i;
    }

    public ForumInfoData[] ccR() {
        return this.iAx;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.iAw = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.iAx = forumInfoDataArr;
        if (this.iAx != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.bUq = likeModel;
    }

    public void ck(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void ccS() {
        for (int i = 0; i < this.iAv; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.iAx[i].forum_name);
            if (hasLikeForum == 1) {
                this.iAx[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.iAx[i].is_like = 0;
            }
        }
    }

    public boolean ccT() {
        if (this.bUq == null) {
            return false;
        }
        return this.bUq.cdJ();
    }

    public void yt(int i) {
        this.iAv = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.iAb = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iAx == null) {
            return 0;
        }
        return this.iAv <= this.iAx.length ? this.iAv : this.iAx.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.iAv) {
            return null;
        }
        return this.iAx[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.eKr.getContext(), d.h.forum_list_forum_item, null);
            a aVar = new a();
            aVar.gMW = (BarImageView) view.findViewById(d.g.forum_avatar);
            aVar.gMW.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(d.g.name);
            aVar.gMX = (TextView) view.findViewById(d.g.member_count);
            aVar.gMY = (TextView) view.findViewById(d.g.thread_count);
            aVar.gMZ = (TextView) view.findViewById(d.g.slogan);
            aVar.iAz = (TextView) view.findViewById(d.g.like);
            aVar.aUI = (TextView) view.findViewById(d.g.rank_badge);
            aVar.iAy = (TextView) view.findViewById(d.g.rise_no);
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
        this.eKr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eKr.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.iAx[i];
        String str = this.iAx[i].avatar;
        aVar2.gMW.setTag(str);
        aVar2.gMW.invalidate();
        aVar2.gMW.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.iAz.setTag(forumInfoData.forum_name);
        aVar2.gMX.setText(this.eKr.getString(d.j.attention) + " " + vf(forumInfoData.member_count));
        aVar2.gMY.setText(this.eKr.getString(d.j.text_post) + " " + vf(forumInfoData.thread_count));
        aVar2.gMZ.setText(forumInfoData.slogan);
        if (this.fpO == 0) {
            aVar2.iAy.setVisibility(8);
            if (!this.iAb) {
                aVar2.aUI.setVisibility(8);
            } else {
                aVar2.aUI.setVisibility(0);
                aVar2.aUI.setText((CharSequence) null);
                aVar2.aUI.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        al.k(aVar2.aUI, d.f.icon_brief_grade_orange);
                        break;
                    case 1:
                        al.k(aVar2.aUI, d.f.icon_brief_grade_blue);
                        break;
                    case 2:
                        al.k(aVar2.aUI, d.f.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.aUI.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.aUI.setVisibility(8);
            aVar2.iAy.setVisibility(0);
            aVar2.iAy.setText((CharSequence) null);
            aVar2.iAy.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.iAy.setText(this.eKr.getString(d.j.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.eKr.getString(d.j.number));
        }
        aVar2.iAz.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.like) {
            TiebaStatic.eventStat(this.eKr.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.eKr.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.eKr.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && com.baidu.adp.lib.b.d.iQ().aO("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.eKr.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.iAw)));
            return;
        }
        TiebaStatic.eventStat(this.eKr.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.eKr.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.eKr.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String vf(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.eKr.getString(d.j.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void pP(boolean z) {
        this.isNight = z;
        notifyDataSetChanged();
    }
}
