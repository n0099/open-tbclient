package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.b.d;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private LikeModel csF;
    private int fMR;
    private TbPageContext fkq;
    public int jcG = -1;
    private int jcH = 0;
    private boolean jcn = true;
    private ForumDetailActivityConfig.FromType jcI = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] jcJ = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView brR;
        BarImageView hlT;
        TextView hlU;
        TextView hlV;
        TextView hlW;
        TextView jcK;
        TextView jcL;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fMR = 0;
        this.fkq = tbPageContext;
        this.fMR = i;
    }

    public ForumInfoData[] cmH() {
        return this.jcJ;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.jcI = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.jcJ = forumInfoDataArr;
        if (this.jcJ != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.csF = likeModel;
    }

    public void co(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cmI() {
        for (int i = 0; i < this.jcH; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.jcJ[i].forum_name);
            if (hasLikeForum == 1) {
                this.jcJ[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.jcJ[i].is_like = 0;
            }
        }
    }

    public boolean cmJ() {
        if (this.csF == null) {
            return false;
        }
        return this.csF.cnG();
    }

    public void yP(int i) {
        this.jcH = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.jcn = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jcJ == null) {
            return 0;
        }
        return this.jcH <= this.jcJ.length ? this.jcH : this.jcJ.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.jcH) {
            return null;
        }
        return this.jcJ[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.fkq.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.hlT = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.hlT.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hlU = (TextView) view.findViewById(R.id.member_count);
            aVar.hlV = (TextView) view.findViewById(R.id.thread_count);
            aVar.hlW = (TextView) view.findViewById(R.id.slogan);
            aVar.jcL = (TextView) view.findViewById(R.id.like);
            aVar.brR = (TextView) view.findViewById(R.id.rank_badge);
            aVar.jcK = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
        am.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.fkq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fkq.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.jcJ[i];
        String str = this.jcJ[i].avatar;
        aVar2.hlT.setTag(str);
        aVar2.hlT.invalidate();
        aVar2.hlT.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.jcL.setTag(forumInfoData.forum_name);
        aVar2.hlU.setText(this.fkq.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + vx(forumInfoData.member_count));
        aVar2.hlV.setText(this.fkq.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + vx(forumInfoData.thread_count));
        aVar2.hlW.setText(forumInfoData.slogan);
        if (this.fMR == 0) {
            aVar2.jcK.setVisibility(8);
            if (!this.jcn) {
                aVar2.brR.setVisibility(8);
            } else {
                aVar2.brR.setVisibility(0);
                aVar2.brR.setText((CharSequence) null);
                aVar2.brR.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.brR, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.brR, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.brR, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.brR.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.brR.setVisibility(8);
            aVar2.jcK.setVisibility(0);
            aVar2.jcK.setText((CharSequence) null);
            aVar2.jcK.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.jcK.setText(this.fkq.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.fkq.getString(R.string.number));
        }
        aVar2.jcL.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.fkq.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.fkq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fkq.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && d.ft().af("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.fkq.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.jcI)));
            return;
        }
        TiebaStatic.eventStat(this.fkq.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.fkq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fkq.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String vx(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.fkq.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void qH(boolean z) {
        notifyDataSetChanged();
    }
}
