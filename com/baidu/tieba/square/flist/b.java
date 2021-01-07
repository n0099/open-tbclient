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
/* loaded from: classes8.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel fpO;
    private TbPageContext iUb;
    private int jCC;
    public int nlD = -1;
    private int nlE = 0;
    private boolean nlk = true;
    private ForumDetailActivityConfig.FromType nlF = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] nlG = new ForumInfoData[0];

    /* loaded from: classes8.dex */
    class a {
        TextView dQk;
        BarImageView leZ;
        TextView lfa;
        TextView lfb;
        TextView lfc;
        TextView mName;
        TextView nlH;
        TextView nlI;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jCC = 0;
        this.iUb = tbPageContext;
        this.jCC = i;
    }

    public ForumInfoData[] dNx() {
        return this.nlG;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.nlF = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.nlG = forumInfoDataArr;
        if (this.nlG != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.fpO = likeModel;
    }

    public void dt(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dNy() {
        for (int i = 0; i < this.nlE; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.nlG[i].forum_name);
            if (hasLikeForum == 1) {
                this.nlG[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.nlG[i].is_like = 0;
            }
        }
    }

    public boolean dNz() {
        if (this.fpO == null) {
            return false;
        }
        return this.fpO.dOv();
    }

    public void JL(int i) {
        this.nlE = i;
        notifyDataSetChanged();
    }

    public void t(Boolean bool) {
        this.nlk = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nlG == null) {
            return 0;
        }
        return this.nlE <= this.nlG.length ? this.nlE : this.nlG.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.nlE) {
            return null;
        }
        return this.nlG[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iUb.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.leZ = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.leZ.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.lfa = (TextView) view.findViewById(R.id.member_count);
            aVar.lfb = (TextView) view.findViewById(R.id.thread_count);
            aVar.lfc = (TextView) view.findViewById(R.id.slogan);
            aVar.nlI = (TextView) view.findViewById(R.id.like);
            aVar.dQk = (TextView) view.findViewById(R.id.rank_badge);
            aVar.nlH = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        ao.setBackgroundColor(findViewById, R.color.CAM_X0204);
        ao.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.iUb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iUb.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.nlG[i];
        String str = this.nlG[i].avatar;
        aVar2.leZ.setTag(str);
        aVar2.leZ.invalidate();
        aVar2.leZ.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.nlI.setTag(forumInfoData.forum_name);
        aVar2.lfa.setText(this.iUb.getString(R.string.attention) + " " + Fz(forumInfoData.member_count));
        aVar2.lfb.setText(this.iUb.getString(R.string.text_post) + " " + Fz(forumInfoData.thread_count));
        aVar2.lfc.setText(forumInfoData.slogan);
        if (this.jCC == 0) {
            aVar2.nlH.setVisibility(8);
            if (!this.nlk) {
                aVar2.dQk.setVisibility(8);
            } else {
                aVar2.dQk.setVisibility(0);
                aVar2.dQk.setText((CharSequence) null);
                aVar2.dQk.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ao.setBackgroundResource(aVar2.dQk, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ao.setBackgroundResource(aVar2.dQk, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ao.setBackgroundResource(aVar2.dQk, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dQk.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dQk.setVisibility(8);
            aVar2.nlH.setVisibility(0);
            aVar2.nlH.setText((CharSequence) null);
            aVar2.nlH.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.nlH.setText(this.iUb.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iUb.getString(R.string.number));
        }
        aVar2.nlI.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iUb.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iUb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iUb.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iUb.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.nlF)));
            return;
        }
        TiebaStatic.eventStat(this.iUb.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iUb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iUb.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String Fz(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iUb.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xV(boolean z) {
        notifyDataSetChanged();
    }
}
