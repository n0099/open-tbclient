package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel emT;
    private int hYX;
    private TbPageContext huq;
    public int lHr = -1;
    private int lHs = 0;
    private boolean lGY = true;
    private ForumDetailActivityConfig.FromType lHt = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] lHu = new ForumInfoData[0];

    /* loaded from: classes17.dex */
    class a {
        TextView cQE;
        BarImageView jGg;
        TextView jGh;
        TextView jGi;
        TextView jGj;
        TextView lHv;
        TextView lHw;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.hYX = 0;
        this.huq = tbPageContext;
        this.hYX = i;
    }

    public ForumInfoData[] djG() {
        return this.lHu;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.lHt = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.lHu = forumInfoDataArr;
        if (this.lHu != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.emT = likeModel;
    }

    public void db(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void djH() {
        for (int i = 0; i < this.lHs; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.lHu[i].forum_name);
            if (hasLikeForum == 1) {
                this.lHu[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.lHu[i].is_like = 0;
            }
        }
    }

    public boolean djI() {
        if (this.emT == null) {
            return false;
        }
        return this.emT.dkC();
    }

    public void Ep(int i) {
        this.lHs = i;
        notifyDataSetChanged();
    }

    public void o(Boolean bool) {
        this.lGY = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lHu == null) {
            return 0;
        }
        return this.lHs <= this.lHu.length ? this.lHs : this.lHu.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.lHs) {
            return null;
        }
        return this.lHu[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.huq.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.jGg = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.jGg.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.jGh = (TextView) view.findViewById(R.id.member_count);
            aVar.jGi = (TextView) view.findViewById(R.id.thread_count);
            aVar.jGj = (TextView) view.findViewById(R.id.slogan);
            aVar.lHw = (TextView) view.findViewById(R.id.like);
            aVar.cQE = (TextView) view.findViewById(R.id.rank_badge);
            aVar.lHv = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        ao.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
        ao.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.huq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.huq.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.lHu[i];
        String str = this.lHu[i].avatar;
        aVar2.jGg.setTag(str);
        aVar2.jGg.invalidate();
        aVar2.jGg.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.lHw.setTag(forumInfoData.forum_name);
        aVar2.jGh.setText(this.huq.getString(R.string.attention) + " " + Am(forumInfoData.member_count));
        aVar2.jGi.setText(this.huq.getString(R.string.text_post) + " " + Am(forumInfoData.thread_count));
        aVar2.jGj.setText(forumInfoData.slogan);
        if (this.hYX == 0) {
            aVar2.lHv.setVisibility(8);
            if (!this.lGY) {
                aVar2.cQE.setVisibility(8);
            } else {
                aVar2.cQE.setVisibility(0);
                aVar2.cQE.setText((CharSequence) null);
                aVar2.cQE.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ao.setBackgroundResource(aVar2.cQE, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ao.setBackgroundResource(aVar2.cQE, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ao.setBackgroundResource(aVar2.cQE, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cQE.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cQE.setVisibility(8);
            aVar2.lHv.setVisibility(0);
            aVar2.lHv.setText((CharSequence) null);
            aVar2.lHv.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.lHv.setText(this.huq.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.huq.getString(R.string.number));
        }
        aVar2.lHw.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.huq.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.huq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.huq.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.huq.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.lHt)));
            return;
        }
        TiebaStatic.eventStat(this.huq.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.huq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.huq.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String Am(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.huq.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void ve(boolean z) {
        notifyDataSetChanged();
    }
}
