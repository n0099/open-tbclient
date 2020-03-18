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
    private LikeModel dku;
    private TbPageContext geg;
    private int mCurrentTab;
    public int kcJ = -1;
    private int kcK = 0;
    private boolean kcq = true;
    private ForumDetailActivityConfig.FromType kcL = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] kcM = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView bXA;
        BarImageView igw;
        TextView igx;
        TextView igy;
        TextView igz;
        TextView kcN;
        TextView kcO;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.mCurrentTab = 0;
        this.geg = tbPageContext;
        this.mCurrentTab = i;
    }

    public ForumInfoData[] cJV() {
        return this.kcM;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.kcL = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.kcM = forumInfoDataArr;
        if (this.kcM != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dku = likeModel;
    }

    public void cJ(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cJW() {
        for (int i = 0; i < this.kcK; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.kcM[i].forum_name);
            if (hasLikeForum == 1) {
                this.kcM[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.kcM[i].is_like = 0;
            }
        }
    }

    public boolean cJX() {
        if (this.dku == null) {
            return false;
        }
        return this.dku.cKQ();
    }

    public void BF(int i) {
        this.kcK = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.kcq = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kcM == null) {
            return 0;
        }
        return this.kcK <= this.kcM.length ? this.kcK : this.kcM.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.kcK) {
            return null;
        }
        return this.kcM[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.geg.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.igw = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.igw.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.igx = (TextView) view.findViewById(R.id.member_count);
            aVar.igy = (TextView) view.findViewById(R.id.thread_count);
            aVar.igz = (TextView) view.findViewById(R.id.slogan);
            aVar.kcO = (TextView) view.findViewById(R.id.like);
            aVar.bXA = (TextView) view.findViewById(R.id.rank_badge);
            aVar.kcN = (TextView) view.findViewById(R.id.rise_no);
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
        this.geg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.geg.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.kcM[i];
        String str = this.kcM[i].avatar;
        aVar2.igw.setTag(str);
        aVar2.igw.invalidate();
        aVar2.igw.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.kcO.setTag(forumInfoData.forum_name);
        aVar2.igx.setText(this.geg.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xR(forumInfoData.member_count));
        aVar2.igy.setText(this.geg.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xR(forumInfoData.thread_count));
        aVar2.igz.setText(forumInfoData.slogan);
        if (this.mCurrentTab == 0) {
            aVar2.kcN.setVisibility(8);
            if (!this.kcq) {
                aVar2.bXA.setVisibility(8);
            } else {
                aVar2.bXA.setVisibility(0);
                aVar2.bXA.setText((CharSequence) null);
                aVar2.bXA.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.bXA, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.bXA, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.bXA, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.bXA.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.bXA.setVisibility(8);
            aVar2.kcN.setVisibility(0);
            aVar2.kcN.setText((CharSequence) null);
            aVar2.kcN.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.kcN.setText(this.geg.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.geg.getString(R.string.number));
        }
        aVar2.kcO.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.geg.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.geg.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.geg.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.geg.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.kcL)));
            return;
        }
        TiebaStatic.eventStat(this.geg.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.geg.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.geg.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String xR(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.geg.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void sL(boolean z) {
        notifyDataSetChanged();
    }
}
