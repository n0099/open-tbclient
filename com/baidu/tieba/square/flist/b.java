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
/* loaded from: classes8.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel fnw;
    private TbPageContext iVp;
    private int jDP;
    public int nrh = -1;
    private int nri = 0;
    private boolean nqO = true;
    private ForumDetailActivityConfig.FromType nrj = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] nrk = new ForumInfoData[0];

    /* loaded from: classes8.dex */
    class a {
        TextView dNC;
        BarImageView liJ;
        TextView liK;
        TextView liL;
        TextView liM;
        TextView mName;
        TextView nrl;
        TextView nrm;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jDP = 0;
        this.iVp = tbPageContext;
        this.jDP = i;
    }

    public ForumInfoData[] dLY() {
        return this.nrk;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.nrj = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.nrk = forumInfoDataArr;
        if (this.nrk != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.fnw = likeModel;
    }

    public void dr(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dLZ() {
        for (int i = 0; i < this.nri; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.nrk[i].forum_name);
            if (hasLikeForum == 1) {
                this.nrk[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.nrk[i].is_like = 0;
            }
        }
    }

    public boolean dMa() {
        if (this.fnw == null) {
            return false;
        }
        return this.fnw.dMW();
    }

    public void Iy(int i) {
        this.nri = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.nqO = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nrk == null) {
            return 0;
        }
        return this.nri <= this.nrk.length ? this.nri : this.nrk.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.nri) {
            return null;
        }
        return this.nrk[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iVp.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.liJ = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.liJ.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.liK = (TextView) view.findViewById(R.id.member_count);
            aVar.liL = (TextView) view.findViewById(R.id.thread_count);
            aVar.liM = (TextView) view.findViewById(R.id.slogan);
            aVar.nrm = (TextView) view.findViewById(R.id.like);
            aVar.dNC = (TextView) view.findViewById(R.id.rank_badge);
            aVar.nrl = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        ap.setBackgroundColor(findViewById, R.color.CAM_X0204);
        ap.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.iVp.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iVp.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.nrk[i];
        String str = this.nrk[i].avatar;
        aVar2.liJ.setTag(str);
        aVar2.liJ.invalidate();
        aVar2.liJ.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.nrm.setTag(forumInfoData.forum_name);
        aVar2.liK.setText(this.iVp.getString(R.string.attention) + " " + El(forumInfoData.member_count));
        aVar2.liL.setText(this.iVp.getString(R.string.text_post) + " " + El(forumInfoData.thread_count));
        aVar2.liM.setText(forumInfoData.slogan);
        if (this.jDP == 0) {
            aVar2.nrl.setVisibility(8);
            if (!this.nqO) {
                aVar2.dNC.setVisibility(8);
            } else {
                aVar2.dNC.setVisibility(0);
                aVar2.dNC.setText((CharSequence) null);
                aVar2.dNC.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dNC, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dNC, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dNC, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dNC.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dNC.setVisibility(8);
            aVar2.nrl.setVisibility(0);
            aVar2.nrl.setText((CharSequence) null);
            aVar2.nrl.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.nrl.setText(this.iVp.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iVp.getString(R.string.number));
        }
        aVar2.nrm.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iVp.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iVp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iVp.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iVp.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.nrj)));
            return;
        }
        TiebaStatic.eventStat(this.iVp.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iVp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iVp.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String El(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iVp.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void yk(boolean z) {
        notifyDataSetChanged();
    }
}
