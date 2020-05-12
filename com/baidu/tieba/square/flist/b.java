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
    private LikeModel dKs;
    private TbPageContext gNw;
    private int hqi;
    public int kMD = -1;
    private int kME = 0;
    private boolean kMk = true;
    private ForumDetailActivityConfig.FromType kMF = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] kMG = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView cwx;
        BarImageView iQD;
        TextView iQE;
        TextView iQF;
        TextView iQG;
        TextView kMH;
        TextView kMI;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.hqi = 0;
        this.gNw = tbPageContext;
        this.hqi = i;
    }

    public ForumInfoData[] cUO() {
        return this.kMG;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.kMF = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.kMG = forumInfoDataArr;
        if (this.kMG != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dKs = likeModel;
    }

    public void cO(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cUP() {
        for (int i = 0; i < this.kME; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.kMG[i].forum_name);
            if (hasLikeForum == 1) {
                this.kMG[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.kMG[i].is_like = 0;
            }
        }
    }

    public boolean cUQ() {
        if (this.dKs == null) {
            return false;
        }
        return this.dKs.cVK();
    }

    public void Cf(int i) {
        this.kME = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.kMk = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kMG == null) {
            return 0;
        }
        return this.kME <= this.kMG.length ? this.kME : this.kMG.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.kME) {
            return null;
        }
        return this.kMG[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.gNw.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.iQD = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.iQD.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.iQE = (TextView) view.findViewById(R.id.member_count);
            aVar.iQF = (TextView) view.findViewById(R.id.thread_count);
            aVar.iQG = (TextView) view.findViewById(R.id.slogan);
            aVar.kMI = (TextView) view.findViewById(R.id.like);
            aVar.cwx = (TextView) view.findViewById(R.id.rank_badge);
            aVar.kMH = (TextView) view.findViewById(R.id.rise_no);
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
        this.gNw.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gNw.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.kMG[i];
        String str = this.kMG[i].avatar;
        aVar2.iQD.setTag(str);
        aVar2.iQD.invalidate();
        aVar2.iQD.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.kMI.setTag(forumInfoData.forum_name);
        aVar2.iQE.setText(this.gNw.getString(R.string.attention) + " " + yr(forumInfoData.member_count));
        aVar2.iQF.setText(this.gNw.getString(R.string.text_post) + " " + yr(forumInfoData.thread_count));
        aVar2.iQG.setText(forumInfoData.slogan);
        if (this.hqi == 0) {
            aVar2.kMH.setVisibility(8);
            if (!this.kMk) {
                aVar2.cwx.setVisibility(8);
            } else {
                aVar2.cwx.setVisibility(0);
                aVar2.cwx.setText((CharSequence) null);
                aVar2.cwx.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.cwx, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.cwx, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.cwx, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cwx.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cwx.setVisibility(8);
            aVar2.kMH.setVisibility(0);
            aVar2.kMH.setText((CharSequence) null);
            aVar2.kMH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.kMH.setText(this.gNw.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.gNw.getString(R.string.number));
        }
        aVar2.kMI.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.gNw.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.gNw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gNw.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.gNw.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.kMF)));
            return;
        }
        TiebaStatic.eventStat(this.gNw.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.gNw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gNw.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String yr(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.gNw.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void tN(boolean z) {
        notifyDataSetChanged();
    }
}
