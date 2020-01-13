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
/* loaded from: classes8.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel dfN;
    private TbPageContext gbi;
    private int mCurrentTab;
    public int jZO = -1;
    private int jZP = 0;
    private boolean jZv = true;
    private ForumDetailActivityConfig.FromType jZQ = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] jZR = new ForumInfoData[0];

    /* loaded from: classes8.dex */
    class a {
        TextView bTj;
        BarImageView icH;
        TextView icI;
        TextView icJ;
        TextView icK;
        TextView jZS;
        TextView jZT;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.mCurrentTab = 0;
        this.gbi = tbPageContext;
        this.mCurrentTab = i;
    }

    public ForumInfoData[] cHS() {
        return this.jZR;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.jZQ = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.jZR = forumInfoDataArr;
        if (this.jZR != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dfN = likeModel;
    }

    public void cF(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cHT() {
        for (int i = 0; i < this.jZP; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.jZR[i].forum_name);
            if (hasLikeForum == 1) {
                this.jZR[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.jZR[i].is_like = 0;
            }
        }
    }

    public boolean cHU() {
        if (this.dfN == null) {
            return false;
        }
        return this.dfN.cIN();
    }

    public void Bo(int i) {
        this.jZP = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.jZv = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jZR == null) {
            return 0;
        }
        return this.jZP <= this.jZR.length ? this.jZP : this.jZR.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.jZP) {
            return null;
        }
        return this.jZR[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.gbi.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.icH = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.icH.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.icI = (TextView) view.findViewById(R.id.member_count);
            aVar.icJ = (TextView) view.findViewById(R.id.thread_count);
            aVar.icK = (TextView) view.findViewById(R.id.slogan);
            aVar.jZT = (TextView) view.findViewById(R.id.like);
            aVar.bTj = (TextView) view.findViewById(R.id.rank_badge);
            aVar.jZS = (TextView) view.findViewById(R.id.rise_no);
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
        this.gbi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gbi.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.jZR[i];
        String str = this.jZR[i].avatar;
        aVar2.icH.setTag(str);
        aVar2.icH.invalidate();
        aVar2.icH.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.jZT.setTag(forumInfoData.forum_name);
        aVar2.icI.setText(this.gbi.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xD(forumInfoData.member_count));
        aVar2.icJ.setText(this.gbi.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xD(forumInfoData.thread_count));
        aVar2.icK.setText(forumInfoData.slogan);
        if (this.mCurrentTab == 0) {
            aVar2.jZS.setVisibility(8);
            if (!this.jZv) {
                aVar2.bTj.setVisibility(8);
            } else {
                aVar2.bTj.setVisibility(0);
                aVar2.bTj.setText((CharSequence) null);
                aVar2.bTj.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.bTj, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.bTj, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.bTj, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.bTj.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.bTj.setVisibility(8);
            aVar2.jZS.setVisibility(0);
            aVar2.jZS.setText((CharSequence) null);
            aVar2.jZS.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.jZS.setText(this.gbi.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.gbi.getString(R.string.number));
        }
        aVar2.jZT.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.gbi.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.gbi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gbi.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.gbi.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.jZQ)));
            return;
        }
        TiebaStatic.eventStat(this.gbi.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.gbi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gbi.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String xD(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.gbi.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void sB(boolean z) {
        notifyDataSetChanged();
    }
}
