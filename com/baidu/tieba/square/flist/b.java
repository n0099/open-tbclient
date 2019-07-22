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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel cdr;
    private int fKV;
    private TbPageContext ffp;
    public int iZq = -1;
    private int iZr = 0;
    private boolean iYX = true;
    private ForumDetailActivityConfig.FromType iZs = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] iZt = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aYs;
        BarImageView hku;
        TextView hkv;
        TextView hkw;
        TextView hkx;
        TextView iZu;
        TextView iZv;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fKV = 0;
        this.ffp = tbPageContext;
        this.fKV = i;
    }

    public ForumInfoData[] cnM() {
        return this.iZt;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.iZs = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.iZt = forumInfoDataArr;
        if (this.iZt != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.cdr = likeModel;
    }

    public void cw(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cnN() {
        for (int i = 0; i < this.iZr; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.iZt[i].forum_name);
            if (hasLikeForum == 1) {
                this.iZt[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.iZt[i].is_like = 0;
            }
        }
    }

    public boolean cnO() {
        if (this.cdr == null) {
            return false;
        }
        return this.cdr.coF();
    }

    public void Ac(int i) {
        this.iZr = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.iYX = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iZt == null) {
            return 0;
        }
        return this.iZr <= this.iZt.length ? this.iZr : this.iZt.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.iZr) {
            return null;
        }
        return this.iZt[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.ffp.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.hku = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.hku.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hkv = (TextView) view.findViewById(R.id.member_count);
            aVar.hkw = (TextView) view.findViewById(R.id.thread_count);
            aVar.hkx = (TextView) view.findViewById(R.id.slogan);
            aVar.iZv = (TextView) view.findViewById(R.id.like);
            aVar.aYs = (TextView) view.findViewById(R.id.rank_badge);
            aVar.iZu = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        am.l(findViewById, R.color.cp_bg_line_b);
        am.l(findViewById2, R.color.cp_bg_line_b);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.ffp.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ffp.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.iZt[i];
        String str = this.iZt[i].avatar;
        aVar2.hku.setTag(str);
        aVar2.hku.invalidate();
        aVar2.hku.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.iZv.setTag(forumInfoData.forum_name);
        aVar2.hkv.setText(this.ffp.getString(R.string.attention) + " " + wL(forumInfoData.member_count));
        aVar2.hkw.setText(this.ffp.getString(R.string.text_post) + " " + wL(forumInfoData.thread_count));
        aVar2.hkx.setText(forumInfoData.slogan);
        if (this.fKV == 0) {
            aVar2.iZu.setVisibility(8);
            if (!this.iYX) {
                aVar2.aYs.setVisibility(8);
            } else {
                aVar2.aYs.setVisibility(0);
                aVar2.aYs.setText((CharSequence) null);
                aVar2.aYs.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.k(aVar2.aYs, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.k(aVar2.aYs, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.k(aVar2.aYs, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.aYs.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.aYs.setVisibility(8);
            aVar2.iZu.setVisibility(0);
            aVar2.iZu.setText((CharSequence) null);
            aVar2.iZu.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.iZu.setText(this.ffp.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.ffp.getString(R.string.number));
        }
        aVar2.iZv.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.ffp.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.ffp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ffp.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && d.hS().az("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.ffp.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.iZs)));
            return;
        }
        TiebaStatic.eventStat(this.ffp.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.ffp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ffp.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String wL(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.ffp.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void qU(boolean z) {
        notifyDataSetChanged();
    }
}
