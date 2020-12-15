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
/* loaded from: classes23.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel fgf;
    private TbPageContext iHQ;
    private int jqf;
    public int nfY = -1;
    private int nfZ = 0;
    private boolean nfF = true;
    private ForumDetailActivityConfig.FromType nga = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] ngb = new ForumInfoData[0];

    /* loaded from: classes23.dex */
    class a {
        TextView dHF;
        BarImageView kZu;
        TextView kZv;
        TextView kZw;
        TextView kZx;
        TextView mName;
        TextView ngc;
        TextView ngd;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jqf = 0;
        this.iHQ = tbPageContext;
        this.jqf = i;
    }

    public ForumInfoData[] dNE() {
        return this.ngb;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.nga = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.ngb = forumInfoDataArr;
        if (this.ngb != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.fgf = likeModel;
    }

    public void dx(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dNF() {
        for (int i = 0; i < this.nfZ; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.ngb[i].forum_name);
            if (hasLikeForum == 1) {
                this.ngb[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.ngb[i].is_like = 0;
            }
        }
    }

    public boolean dNG() {
        if (this.fgf == null) {
            return false;
        }
        return this.fgf.dOC();
    }

    public void JR(int i) {
        this.nfZ = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.nfF = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ngb == null) {
            return 0;
        }
        return this.nfZ <= this.ngb.length ? this.nfZ : this.ngb.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.nfZ) {
            return null;
        }
        return this.ngb[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iHQ.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.kZu = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.kZu.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.kZv = (TextView) view.findViewById(R.id.member_count);
            aVar.kZw = (TextView) view.findViewById(R.id.thread_count);
            aVar.kZx = (TextView) view.findViewById(R.id.slogan);
            aVar.ngd = (TextView) view.findViewById(R.id.like);
            aVar.dHF = (TextView) view.findViewById(R.id.rank_badge);
            aVar.ngc = (TextView) view.findViewById(R.id.rise_no);
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
        this.iHQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iHQ.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.ngb[i];
        String str = this.ngb[i].avatar;
        aVar2.kZu.setTag(str);
        aVar2.kZu.invalidate();
        aVar2.kZu.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.ngd.setTag(forumInfoData.forum_name);
        aVar2.kZv.setText(this.iHQ.getString(R.string.attention) + " " + FF(forumInfoData.member_count));
        aVar2.kZw.setText(this.iHQ.getString(R.string.text_post) + " " + FF(forumInfoData.thread_count));
        aVar2.kZx.setText(forumInfoData.slogan);
        if (this.jqf == 0) {
            aVar2.ngc.setVisibility(8);
            if (!this.nfF) {
                aVar2.dHF.setVisibility(8);
            } else {
                aVar2.dHF.setVisibility(0);
                aVar2.dHF.setText((CharSequence) null);
                aVar2.dHF.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dHF, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dHF, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dHF, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dHF.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dHF.setVisibility(8);
            aVar2.ngc.setVisibility(0);
            aVar2.ngc.setText((CharSequence) null);
            aVar2.ngc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.ngc.setText(this.iHQ.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iHQ.getString(R.string.number));
        }
        aVar2.ngd.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iHQ.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iHQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iHQ.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iHQ.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.nga)));
            return;
        }
        TiebaStatic.eventStat(this.iHQ.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iHQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iHQ.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String FF(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iHQ.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xT(boolean z) {
        notifyDataSetChanged();
    }
}
