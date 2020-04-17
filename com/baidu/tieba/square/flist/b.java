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
    private LikeModel dKo;
    private TbPageContext gNq;
    private int hqc;
    public int kMz = -1;
    private int kMA = 0;
    private boolean kMg = true;
    private ForumDetailActivityConfig.FromType kMB = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] kMC = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView cwr;
        TextView iQA;
        TextView iQB;
        TextView iQC;
        BarImageView iQz;
        TextView kMD;
        TextView kME;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.hqc = 0;
        this.gNq = tbPageContext;
        this.hqc = i;
    }

    public ForumInfoData[] cUQ() {
        return this.kMC;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.kMB = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.kMC = forumInfoDataArr;
        if (this.kMC != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dKo = likeModel;
    }

    public void cO(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cUR() {
        for (int i = 0; i < this.kMA; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.kMC[i].forum_name);
            if (hasLikeForum == 1) {
                this.kMC[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.kMC[i].is_like = 0;
            }
        }
    }

    public boolean cUS() {
        if (this.dKo == null) {
            return false;
        }
        return this.dKo.cVM();
    }

    public void Cf(int i) {
        this.kMA = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.kMg = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kMC == null) {
            return 0;
        }
        return this.kMA <= this.kMC.length ? this.kMA : this.kMC.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.kMA) {
            return null;
        }
        return this.kMC[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.gNq.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.iQz = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.iQz.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.iQA = (TextView) view.findViewById(R.id.member_count);
            aVar.iQB = (TextView) view.findViewById(R.id.thread_count);
            aVar.iQC = (TextView) view.findViewById(R.id.slogan);
            aVar.kME = (TextView) view.findViewById(R.id.like);
            aVar.cwr = (TextView) view.findViewById(R.id.rank_badge);
            aVar.kMD = (TextView) view.findViewById(R.id.rise_no);
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
        this.gNq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gNq.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.kMC[i];
        String str = this.kMC[i].avatar;
        aVar2.iQz.setTag(str);
        aVar2.iQz.invalidate();
        aVar2.iQz.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.kME.setTag(forumInfoData.forum_name);
        aVar2.iQA.setText(this.gNq.getString(R.string.attention) + " " + yr(forumInfoData.member_count));
        aVar2.iQB.setText(this.gNq.getString(R.string.text_post) + " " + yr(forumInfoData.thread_count));
        aVar2.iQC.setText(forumInfoData.slogan);
        if (this.hqc == 0) {
            aVar2.kMD.setVisibility(8);
            if (!this.kMg) {
                aVar2.cwr.setVisibility(8);
            } else {
                aVar2.cwr.setVisibility(0);
                aVar2.cwr.setText((CharSequence) null);
                aVar2.cwr.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.cwr, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.cwr, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.cwr, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cwr.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cwr.setVisibility(8);
            aVar2.kMD.setVisibility(0);
            aVar2.kMD.setText((CharSequence) null);
            aVar2.kMD.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.kMD.setText(this.gNq.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.gNq.getString(R.string.number));
        }
        aVar2.kME.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.gNq.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.gNq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gNq.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.gNq.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.kMB)));
            return;
        }
        TiebaStatic.eventStat(this.gNq.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.gNq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gNq.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String yr(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.gNq.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void tN(boolean z) {
        notifyDataSetChanged();
    }
}
