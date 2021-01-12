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
/* loaded from: classes7.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel fle;
    private TbPageContext iPu;
    private int jxW;
    public int ngY = -1;
    private int ngZ = 0;
    private boolean ngF = true;
    private ForumDetailActivityConfig.FromType nha = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] nhb = new ForumInfoData[0];

    /* loaded from: classes7.dex */
    class a {
        TextView dLy;
        BarImageView lar;
        TextView las;
        TextView lau;
        TextView lav;
        TextView mName;
        TextView nhc;
        TextView nhd;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jxW = 0;
        this.iPu = tbPageContext;
        this.jxW = i;
    }

    public ForumInfoData[] dJF() {
        return this.nhb;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.nha = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.nhb = forumInfoDataArr;
        if (this.nhb != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.fle = likeModel;
    }

    public void dt(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dJG() {
        for (int i = 0; i < this.ngZ; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.nhb[i].forum_name);
            if (hasLikeForum == 1) {
                this.nhb[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.nhb[i].is_like = 0;
            }
        }
    }

    public boolean dJH() {
        if (this.fle == null) {
            return false;
        }
        return this.fle.dKD();
    }

    public void Ie(int i) {
        this.ngZ = i;
        notifyDataSetChanged();
    }

    public void t(Boolean bool) {
        this.ngF = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nhb == null) {
            return 0;
        }
        return this.ngZ <= this.nhb.length ? this.ngZ : this.nhb.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.ngZ) {
            return null;
        }
        return this.nhb[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iPu.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.lar = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.lar.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.las = (TextView) view.findViewById(R.id.member_count);
            aVar.lau = (TextView) view.findViewById(R.id.thread_count);
            aVar.lav = (TextView) view.findViewById(R.id.slogan);
            aVar.nhd = (TextView) view.findViewById(R.id.like);
            aVar.dLy = (TextView) view.findViewById(R.id.rank_badge);
            aVar.nhc = (TextView) view.findViewById(R.id.rise_no);
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
        this.iPu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iPu.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.nhb[i];
        String str = this.nhb[i].avatar;
        aVar2.lar.setTag(str);
        aVar2.lar.invalidate();
        aVar2.lar.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.nhd.setTag(forumInfoData.forum_name);
        aVar2.las.setText(this.iPu.getString(R.string.attention) + " " + DT(forumInfoData.member_count));
        aVar2.lau.setText(this.iPu.getString(R.string.text_post) + " " + DT(forumInfoData.thread_count));
        aVar2.lav.setText(forumInfoData.slogan);
        if (this.jxW == 0) {
            aVar2.nhc.setVisibility(8);
            if (!this.ngF) {
                aVar2.dLy.setVisibility(8);
            } else {
                aVar2.dLy.setVisibility(0);
                aVar2.dLy.setText((CharSequence) null);
                aVar2.dLy.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ao.setBackgroundResource(aVar2.dLy, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ao.setBackgroundResource(aVar2.dLy, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ao.setBackgroundResource(aVar2.dLy, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dLy.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dLy.setVisibility(8);
            aVar2.nhc.setVisibility(0);
            aVar2.nhc.setText((CharSequence) null);
            aVar2.nhc.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.nhc.setText(this.iPu.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iPu.getString(R.string.number));
        }
        aVar2.nhd.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iPu.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iPu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iPu.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iPu.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.nha)));
            return;
        }
        TiebaStatic.eventStat(this.iPu.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iPu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iPu.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String DT(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iPu.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xR(boolean z) {
        notifyDataSetChanged();
    }
}
