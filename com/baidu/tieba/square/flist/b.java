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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel exb;
    private TbPageContext hHM;
    private int inl;
    public int lZm = -1;
    private int lZn = 0;
    private boolean lYT = true;
    private ForumDetailActivityConfig.FromType lZo = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] lZp = new ForumInfoData[0];

    /* loaded from: classes17.dex */
    class a {
        TextView cZK;
        BarImageView jVD;
        TextView jVE;
        TextView jVF;
        TextView jVG;
        TextView lZq;
        TextView lZr;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.inl = 0;
        this.hHM = tbPageContext;
        this.inl = i;
    }

    public ForumInfoData[] dvi() {
        return this.lZp;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.lZo = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.lZp = forumInfoDataArr;
        if (this.lZp != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.exb = likeModel;
    }

    public void dj(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dvj() {
        for (int i = 0; i < this.lZn; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.lZp[i].forum_name);
            if (hasLikeForum == 1) {
                this.lZp[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.lZp[i].is_like = 0;
            }
        }
    }

    public boolean dvk() {
        if (this.exb == null) {
            return false;
        }
        return this.exb.dwe();
    }

    public void GM(int i) {
        this.lZn = i;
        notifyDataSetChanged();
    }

    public void q(Boolean bool) {
        this.lYT = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lZp == null) {
            return 0;
        }
        return this.lZn <= this.lZp.length ? this.lZn : this.lZp.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.lZn) {
            return null;
        }
        return this.lZp[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.hHM.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.jVD = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.jVD.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.jVE = (TextView) view.findViewById(R.id.member_count);
            aVar.jVF = (TextView) view.findViewById(R.id.thread_count);
            aVar.jVG = (TextView) view.findViewById(R.id.slogan);
            aVar.lZr = (TextView) view.findViewById(R.id.like);
            aVar.cZK = (TextView) view.findViewById(R.id.rank_badge);
            aVar.lZq = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        ap.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
        ap.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.hHM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hHM.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.lZp[i];
        String str = this.lZp[i].avatar;
        aVar2.jVD.setTag(str);
        aVar2.jVD.invalidate();
        aVar2.jVD.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.lZr.setTag(forumInfoData.forum_name);
        aVar2.jVE.setText(this.hHM.getString(R.string.attention) + " " + CF(forumInfoData.member_count));
        aVar2.jVF.setText(this.hHM.getString(R.string.text_post) + " " + CF(forumInfoData.thread_count));
        aVar2.jVG.setText(forumInfoData.slogan);
        if (this.inl == 0) {
            aVar2.lZq.setVisibility(8);
            if (!this.lYT) {
                aVar2.cZK.setVisibility(8);
            } else {
                aVar2.cZK.setVisibility(0);
                aVar2.cZK.setText((CharSequence) null);
                aVar2.cZK.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.cZK, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.cZK, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.cZK, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cZK.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cZK.setVisibility(8);
            aVar2.lZq.setVisibility(0);
            aVar2.lZq.setText((CharSequence) null);
            aVar2.lZq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.lZq.setText(this.hHM.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.hHM.getString(R.string.number));
        }
        aVar2.lZr.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.hHM.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.hHM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hHM.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.hHM.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.lZo)));
            return;
        }
        TiebaStatic.eventStat(this.hHM.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.hHM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hHM.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String CF(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.hHM.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void vV(boolean z) {
        notifyDataSetChanged();
    }
}
