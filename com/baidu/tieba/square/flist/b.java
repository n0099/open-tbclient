package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel cco;
    private int fFX;
    private TbPageContext fao;
    public int iSZ = -1;
    private int iTa = 0;
    private boolean iSG = true;
    private ForumDetailActivityConfig.FromType iTb = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] iTc = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aXI;
        BarImageView heh;
        TextView hei;
        TextView hej;
        TextView hek;
        TextView iTd;
        TextView iTe;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fFX = 0;
        this.fao = tbPageContext;
        this.fFX = i;
    }

    public ForumInfoData[] ckU() {
        return this.iTc;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.iTb = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.iTc = forumInfoDataArr;
        if (this.iTc != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.cco = likeModel;
    }

    public void cr(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void ckV() {
        for (int i = 0; i < this.iTa; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.iTc[i].forum_name);
            if (hasLikeForum == 1) {
                this.iTc[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.iTc[i].is_like = 0;
            }
        }
    }

    public boolean ckW() {
        if (this.cco == null) {
            return false;
        }
        return this.cco.clN();
    }

    public void zw(int i) {
        this.iTa = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.iSG = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iTc == null) {
            return 0;
        }
        return this.iTa <= this.iTc.length ? this.iTa : this.iTc.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.iTa) {
            return null;
        }
        return this.iTc[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.fao.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.heh = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.heh.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hei = (TextView) view.findViewById(R.id.member_count);
            aVar.hej = (TextView) view.findViewById(R.id.thread_count);
            aVar.hek = (TextView) view.findViewById(R.id.slogan);
            aVar.iTe = (TextView) view.findViewById(R.id.like);
            aVar.aXI = (TextView) view.findViewById(R.id.rank_badge);
            aVar.iTd = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        al.l(findViewById, R.color.cp_bg_line_b);
        al.l(findViewById2, R.color.cp_bg_line_b);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.fao.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fao.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.iTc[i];
        String str = this.iTc[i].avatar;
        aVar2.heh.setTag(str);
        aVar2.heh.invalidate();
        aVar2.heh.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.iTe.setTag(forumInfoData.forum_name);
        aVar2.hei.setText(this.fao.getString(R.string.attention) + " " + wi(forumInfoData.member_count));
        aVar2.hej.setText(this.fao.getString(R.string.text_post) + " " + wi(forumInfoData.thread_count));
        aVar2.hek.setText(forumInfoData.slogan);
        if (this.fFX == 0) {
            aVar2.iTd.setVisibility(8);
            if (!this.iSG) {
                aVar2.aXI.setVisibility(8);
            } else {
                aVar2.aXI.setVisibility(0);
                aVar2.aXI.setText((CharSequence) null);
                aVar2.aXI.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        al.k(aVar2.aXI, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        al.k(aVar2.aXI, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        al.k(aVar2.aXI, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.aXI.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.aXI.setVisibility(8);
            aVar2.iTd.setVisibility(0);
            aVar2.iTd.setText((CharSequence) null);
            aVar2.iTd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.iTd.setText(this.fao.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.fao.getString(R.string.number));
        }
        aVar2.iTe.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.fao.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.fao.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fao.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && d.hI().ay("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.fao.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.iTb)));
            return;
        }
        TiebaStatic.eventStat(this.fao.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.fao.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fao.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String wi(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.fao.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void qF(boolean z) {
        notifyDataSetChanged();
    }
}
