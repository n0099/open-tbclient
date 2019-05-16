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
    private LikeModel ccn;
    private int fFW;
    private TbPageContext fan;
    public int iST = -1;
    private int iSU = 0;
    private boolean iSA = true;
    private ForumDetailActivityConfig.FromType iSV = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] iSW = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aXI;
        BarImageView hed;
        TextView hee;
        TextView hef;
        TextView heg;
        TextView iSX;
        TextView iSY;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fFW = 0;
        this.fan = tbPageContext;
        this.fFW = i;
    }

    public ForumInfoData[] ckR() {
        return this.iSW;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.iSV = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.iSW = forumInfoDataArr;
        if (this.iSW != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.ccn = likeModel;
    }

    public void cr(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void ckS() {
        for (int i = 0; i < this.iSU; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.iSW[i].forum_name);
            if (hasLikeForum == 1) {
                this.iSW[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.iSW[i].is_like = 0;
            }
        }
    }

    public boolean ckT() {
        if (this.ccn == null) {
            return false;
        }
        return this.ccn.clK();
    }

    public void zw(int i) {
        this.iSU = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.iSA = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iSW == null) {
            return 0;
        }
        return this.iSU <= this.iSW.length ? this.iSU : this.iSW.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.iSU) {
            return null;
        }
        return this.iSW[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.fan.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.hed = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.hed.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hee = (TextView) view.findViewById(R.id.member_count);
            aVar.hef = (TextView) view.findViewById(R.id.thread_count);
            aVar.heg = (TextView) view.findViewById(R.id.slogan);
            aVar.iSY = (TextView) view.findViewById(R.id.like);
            aVar.aXI = (TextView) view.findViewById(R.id.rank_badge);
            aVar.iSX = (TextView) view.findViewById(R.id.rise_no);
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
        this.fan.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fan.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.iSW[i];
        String str = this.iSW[i].avatar;
        aVar2.hed.setTag(str);
        aVar2.hed.invalidate();
        aVar2.hed.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.iSY.setTag(forumInfoData.forum_name);
        aVar2.hee.setText(this.fan.getString(R.string.attention) + " " + wi(forumInfoData.member_count));
        aVar2.hef.setText(this.fan.getString(R.string.text_post) + " " + wi(forumInfoData.thread_count));
        aVar2.heg.setText(forumInfoData.slogan);
        if (this.fFW == 0) {
            aVar2.iSX.setVisibility(8);
            if (!this.iSA) {
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
            aVar2.iSX.setVisibility(0);
            aVar2.iSX.setText((CharSequence) null);
            aVar2.iSX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.iSX.setText(this.fan.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.fan.getString(R.string.number));
        }
        aVar2.iSY.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.fan.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.fan.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fan.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && d.hI().ay("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.fan.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.iSV)));
            return;
        }
        TiebaStatic.eventStat(this.fan.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.fan.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fan.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String wi(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.fan.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void qE(boolean z) {
        notifyDataSetChanged();
    }
}
