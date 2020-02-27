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
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel djT;
    private TbPageContext gdj;
    private int mCurrentTab;
    public int kaT = -1;
    private int kaU = 0;
    private boolean kaA = true;
    private ForumDetailActivityConfig.FromType kaV = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] kaW = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView bXn;
        BarImageView ieI;
        TextView ieJ;
        TextView ieK;
        TextView ieL;
        TextView kaX;
        TextView kaY;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.mCurrentTab = 0;
        this.gdj = tbPageContext;
        this.mCurrentTab = i;
    }

    public ForumInfoData[] cJy() {
        return this.kaW;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.kaV = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.kaW = forumInfoDataArr;
        if (this.kaW != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.djT = likeModel;
    }

    public void cI(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cJz() {
        for (int i = 0; i < this.kaU; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.kaW[i].forum_name);
            if (hasLikeForum == 1) {
                this.kaW[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.kaW[i].is_like = 0;
            }
        }
    }

    public boolean cJA() {
        if (this.djT == null) {
            return false;
        }
        return this.djT.cKt();
    }

    public void Bx(int i) {
        this.kaU = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.kaA = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kaW == null) {
            return 0;
        }
        return this.kaU <= this.kaW.length ? this.kaU : this.kaW.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.kaU) {
            return null;
        }
        return this.kaW[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.gdj.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.ieI = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.ieI.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.ieJ = (TextView) view.findViewById(R.id.member_count);
            aVar.ieK = (TextView) view.findViewById(R.id.thread_count);
            aVar.ieL = (TextView) view.findViewById(R.id.slogan);
            aVar.kaY = (TextView) view.findViewById(R.id.like);
            aVar.bXn = (TextView) view.findViewById(R.id.rank_badge);
            aVar.kaX = (TextView) view.findViewById(R.id.rise_no);
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
        this.gdj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gdj.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.kaW[i];
        String str = this.kaW[i].avatar;
        aVar2.ieI.setTag(str);
        aVar2.ieI.invalidate();
        aVar2.ieI.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.kaY.setTag(forumInfoData.forum_name);
        aVar2.ieJ.setText(this.gdj.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xJ(forumInfoData.member_count));
        aVar2.ieK.setText(this.gdj.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xJ(forumInfoData.thread_count));
        aVar2.ieL.setText(forumInfoData.slogan);
        if (this.mCurrentTab == 0) {
            aVar2.kaX.setVisibility(8);
            if (!this.kaA) {
                aVar2.bXn.setVisibility(8);
            } else {
                aVar2.bXn.setVisibility(0);
                aVar2.bXn.setText((CharSequence) null);
                aVar2.bXn.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.bXn, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.bXn, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.bXn, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.bXn.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.bXn.setVisibility(8);
            aVar2.kaX.setVisibility(0);
            aVar2.kaX.setText((CharSequence) null);
            aVar2.kaX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.kaX.setText(this.gdj.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.gdj.getString(R.string.number));
        }
        aVar2.kaY.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.gdj.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.gdj.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gdj.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.gdj.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.kaV)));
            return;
        }
        TiebaStatic.eventStat(this.gdj.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.gdj.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gdj.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String xJ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.gdj.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void sF(boolean z) {
        notifyDataSetChanged();
    }
}
