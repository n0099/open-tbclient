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
    private LikeModel cer;
    private int fNy;
    private TbPageContext fhC;
    public int jcP = -1;
    private int jcQ = 0;
    private boolean jcw = true;
    private ForumDetailActivityConfig.FromType jcR = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] jcS = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView aYQ;
        BarImageView hng;
        TextView hnh;
        TextView hni;
        TextView hnj;
        TextView jcT;
        TextView jcU;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fNy = 0;
        this.fhC = tbPageContext;
        this.fNy = i;
    }

    public ForumInfoData[] coR() {
        return this.jcS;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.jcR = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.jcS = forumInfoDataArr;
        if (this.jcS != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.cer = likeModel;
    }

    public void cv(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void coS() {
        for (int i = 0; i < this.jcQ; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.jcS[i].forum_name);
            if (hasLikeForum == 1) {
                this.jcS[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.jcS[i].is_like = 0;
            }
        }
    }

    public boolean coT() {
        if (this.cer == null) {
            return false;
        }
        return this.cer.cpP();
    }

    public void Ah(int i) {
        this.jcQ = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.jcw = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jcS == null) {
            return 0;
        }
        return this.jcQ <= this.jcS.length ? this.jcQ : this.jcS.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.jcQ) {
            return null;
        }
        return this.jcS[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.fhC.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.hng = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.hng.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hnh = (TextView) view.findViewById(R.id.member_count);
            aVar.hni = (TextView) view.findViewById(R.id.thread_count);
            aVar.hnj = (TextView) view.findViewById(R.id.slogan);
            aVar.jcU = (TextView) view.findViewById(R.id.like);
            aVar.aYQ = (TextView) view.findViewById(R.id.rank_badge);
            aVar.jcT = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        am.l(findViewById, R.color.cp_bg_line_c);
        am.l(findViewById2, R.color.cp_bg_line_c);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.fhC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fhC.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.jcS[i];
        String str = this.jcS[i].avatar;
        aVar2.hng.setTag(str);
        aVar2.hng.invalidate();
        aVar2.hng.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.jcU.setTag(forumInfoData.forum_name);
        aVar2.hnh.setText(this.fhC.getString(R.string.attention) + " " + wQ(forumInfoData.member_count));
        aVar2.hni.setText(this.fhC.getString(R.string.text_post) + " " + wQ(forumInfoData.thread_count));
        aVar2.hnj.setText(forumInfoData.slogan);
        if (this.fNy == 0) {
            aVar2.jcT.setVisibility(8);
            if (!this.jcw) {
                aVar2.aYQ.setVisibility(8);
            } else {
                aVar2.aYQ.setVisibility(0);
                aVar2.aYQ.setText((CharSequence) null);
                aVar2.aYQ.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.k(aVar2.aYQ, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.k(aVar2.aYQ, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.k(aVar2.aYQ, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.aYQ.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.aYQ.setVisibility(8);
            aVar2.jcT.setVisibility(0);
            aVar2.jcT.setText((CharSequence) null);
            aVar2.jcT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.jcT.setText(this.fhC.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.fhC.getString(R.string.number));
        }
        aVar2.jcU.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.fhC.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.fhC.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fhC.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && d.hS().az("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.fhC.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.jcR)));
            return;
        }
        TiebaStatic.eventStat(this.fhC.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.fhC.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fhC.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String wQ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.fhC.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void qY(boolean z) {
        notifyDataSetChanged();
    }
}
