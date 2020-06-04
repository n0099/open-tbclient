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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel dYI;
    private int hFJ;
    private TbPageContext hct;
    public int lgd = -1;
    private int lge = 0;
    private boolean lfK = true;
    private ForumDetailActivityConfig.FromType lgf = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] lgg = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView cIz;
        BarImageView jgr;
        TextView jgs;
        TextView jgt;
        TextView jgu;
        TextView lgh;
        TextView lgi;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.hFJ = 0;
        this.hct = tbPageContext;
        this.hFJ = i;
    }

    public ForumInfoData[] dch() {
        return this.lgg;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.lgf = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.lgg = forumInfoDataArr;
        if (this.lgg != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dYI = likeModel;
    }

    public void cT(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dci() {
        for (int i = 0; i < this.lge; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.lgg[i].forum_name);
            if (hasLikeForum == 1) {
                this.lgg[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.lgg[i].is_like = 0;
            }
        }
    }

    public boolean dcj() {
        if (this.dYI == null) {
            return false;
        }
        return this.dYI.ddd();
    }

    public void CR(int i) {
        this.lge = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.lfK = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lgg == null) {
            return 0;
        }
        return this.lge <= this.lgg.length ? this.lge : this.lgg.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.lge) {
            return null;
        }
        return this.lgg[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.hct.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.jgr = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.jgr.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.jgs = (TextView) view.findViewById(R.id.member_count);
            aVar.jgt = (TextView) view.findViewById(R.id.thread_count);
            aVar.jgu = (TextView) view.findViewById(R.id.slogan);
            aVar.lgi = (TextView) view.findViewById(R.id.like);
            aVar.cIz = (TextView) view.findViewById(R.id.rank_badge);
            aVar.lgh = (TextView) view.findViewById(R.id.rise_no);
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
        this.hct.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hct.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.lgg[i];
        String str = this.lgg[i].avatar;
        aVar2.jgr.setTag(str);
        aVar2.jgr.invalidate();
        aVar2.jgr.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.lgi.setTag(forumInfoData.forum_name);
        aVar2.jgs.setText(this.hct.getString(R.string.attention) + " " + zb(forumInfoData.member_count));
        aVar2.jgt.setText(this.hct.getString(R.string.text_post) + " " + zb(forumInfoData.thread_count));
        aVar2.jgu.setText(forumInfoData.slogan);
        if (this.hFJ == 0) {
            aVar2.lgh.setVisibility(8);
            if (!this.lfK) {
                aVar2.cIz.setVisibility(8);
            } else {
                aVar2.cIz.setVisibility(0);
                aVar2.cIz.setText((CharSequence) null);
                aVar2.cIz.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.cIz, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.cIz, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.cIz, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cIz.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cIz.setVisibility(8);
            aVar2.lgh.setVisibility(0);
            aVar2.lgh.setText((CharSequence) null);
            aVar2.lgh.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.lgh.setText(this.hct.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.hct.getString(R.string.number));
        }
        aVar2.lgi.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.hct.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.hct.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hct.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.hct.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.lgf)));
            return;
        }
        TiebaStatic.eventStat(this.hct.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.hct.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hct.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String zb(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.hct.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void ul(boolean z) {
        notifyDataSetChanged();
    }
}
