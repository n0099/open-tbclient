package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes7.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel dfB;
    private TbPageContext fXZ;
    private int mCurrentTab;
    public int jWm = -1;
    private int jWn = 0;
    private boolean jVT = true;
    private ForumDetailActivityConfig.FromType jWo = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] jWp = new ForumInfoData[0];

    /* loaded from: classes7.dex */
    class a {
        TextView bSX;
        BarImageView hZd;
        TextView hZe;
        TextView hZf;
        TextView hZg;
        TextView jWq;
        TextView jWr;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.mCurrentTab = 0;
        this.fXZ = tbPageContext;
        this.mCurrentTab = i;
    }

    public ForumInfoData[] cGO() {
        return this.jWp;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.jWo = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.jWp = forumInfoDataArr;
        if (this.jWp != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dfB = likeModel;
    }

    public void cG(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cGP() {
        for (int i = 0; i < this.jWn; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.jWp[i].forum_name);
            if (hasLikeForum == 1) {
                this.jWp[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.jWp[i].is_like = 0;
            }
        }
    }

    public boolean cGQ() {
        if (this.dfB == null) {
            return false;
        }
        return this.dfB.cHJ();
    }

    public void Bj(int i) {
        this.jWn = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.jVT = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jWp == null) {
            return 0;
        }
        return this.jWn <= this.jWp.length ? this.jWn : this.jWp.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.jWn) {
            return null;
        }
        return this.jWp[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.fXZ.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.hZd = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.hZd.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hZe = (TextView) view.findViewById(R.id.member_count);
            aVar.hZf = (TextView) view.findViewById(R.id.thread_count);
            aVar.hZg = (TextView) view.findViewById(R.id.slogan);
            aVar.jWr = (TextView) view.findViewById(R.id.like);
            aVar.bSX = (TextView) view.findViewById(R.id.rank_badge);
            aVar.jWq = (TextView) view.findViewById(R.id.rise_no);
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
        this.fXZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fXZ.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.jWp[i];
        String str = this.jWp[i].avatar;
        aVar2.hZd.setTag(str);
        aVar2.hZd.invalidate();
        aVar2.hZd.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.jWr.setTag(forumInfoData.forum_name);
        aVar2.hZe.setText(this.fXZ.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xy(forumInfoData.member_count));
        aVar2.hZf.setText(this.fXZ.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xy(forumInfoData.thread_count));
        aVar2.hZg.setText(forumInfoData.slogan);
        if (this.mCurrentTab == 0) {
            aVar2.jWq.setVisibility(8);
            if (!this.jVT) {
                aVar2.bSX.setVisibility(8);
            } else {
                aVar2.bSX.setVisibility(0);
                aVar2.bSX.setText((CharSequence) null);
                aVar2.bSX.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.bSX, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.bSX, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.bSX, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.bSX.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.bSX.setVisibility(8);
            aVar2.jWq.setVisibility(0);
            aVar2.jWq.setText((CharSequence) null);
            aVar2.jWq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.jWq.setText(this.fXZ.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.fXZ.getString(R.string.number));
        }
        aVar2.jWr.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.fXZ.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.fXZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fXZ.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.fXZ.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.jWo)));
            return;
        }
        TiebaStatic.eventStat(this.fXZ.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.fXZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fXZ.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String xy(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.fXZ.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void sp(boolean z) {
        notifyDataSetChanged();
    }
}
