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
/* loaded from: classes22.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel ezi;
    private TbPageContext hON;
    private int iuC;
    public int miQ = -1;
    private int miR = 0;
    private boolean mix = true;
    private ForumDetailActivityConfig.FromType miS = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] miT = new ForumInfoData[0];

    /* loaded from: classes22.dex */
    class a {
        TextView dbM;
        BarImageView kef;
        TextView keg;
        TextView keh;
        TextView kei;
        TextView mName;
        TextView miU;
        TextView miV;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.iuC = 0;
        this.hON = tbPageContext;
        this.iuC = i;
    }

    public ForumInfoData[] dzb() {
        return this.miT;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.miS = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.miT = forumInfoDataArr;
        if (this.miT != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.ezi = likeModel;
    }

    public void dn(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dzc() {
        for (int i = 0; i < this.miR; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.miT[i].forum_name);
            if (hasLikeForum == 1) {
                this.miT[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.miT[i].is_like = 0;
            }
        }
    }

    public boolean dzd() {
        if (this.ezi == null) {
            return false;
        }
        return this.ezi.dzX();
    }

    public void Hn(int i) {
        this.miR = i;
        notifyDataSetChanged();
    }

    public void r(Boolean bool) {
        this.mix = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.miT == null) {
            return 0;
        }
        return this.miR <= this.miT.length ? this.miR : this.miT.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.miR) {
            return null;
        }
        return this.miT[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.hON.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.kef = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.kef.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.keg = (TextView) view.findViewById(R.id.member_count);
            aVar.keh = (TextView) view.findViewById(R.id.thread_count);
            aVar.kei = (TextView) view.findViewById(R.id.slogan);
            aVar.miV = (TextView) view.findViewById(R.id.like);
            aVar.dbM = (TextView) view.findViewById(R.id.rank_badge);
            aVar.miU = (TextView) view.findViewById(R.id.rise_no);
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
        this.hON.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hON.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.miT[i];
        String str = this.miT[i].avatar;
        aVar2.kef.setTag(str);
        aVar2.kef.invalidate();
        aVar2.kef.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.miV.setTag(forumInfoData.forum_name);
        aVar2.keg.setText(this.hON.getString(R.string.attention) + " " + Dg(forumInfoData.member_count));
        aVar2.keh.setText(this.hON.getString(R.string.text_post) + " " + Dg(forumInfoData.thread_count));
        aVar2.kei.setText(forumInfoData.slogan);
        if (this.iuC == 0) {
            aVar2.miU.setVisibility(8);
            if (!this.mix) {
                aVar2.dbM.setVisibility(8);
            } else {
                aVar2.dbM.setVisibility(0);
                aVar2.dbM.setText((CharSequence) null);
                aVar2.dbM.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dbM, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dbM, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dbM, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dbM.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dbM.setVisibility(8);
            aVar2.miU.setVisibility(0);
            aVar2.miU.setText((CharSequence) null);
            aVar2.miU.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.miU.setText(this.hON.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.hON.getString(R.string.number));
        }
        aVar2.miV.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.hON.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.hON.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hON.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.hON.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.miS)));
            return;
        }
        TiebaStatic.eventStat(this.hON.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.hON.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hON.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String Dg(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.hON.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void we(boolean z) {
        notifyDataSetChanged();
    }
}
