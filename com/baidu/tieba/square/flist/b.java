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
    private TbPageContext iHO;
    private int jqd;
    public int nfW = -1;
    private int nfX = 0;
    private boolean nfD = true;
    private ForumDetailActivityConfig.FromType nfY = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] nfZ = new ForumInfoData[0];

    /* loaded from: classes23.dex */
    class a {
        TextView dHF;
        BarImageView kZs;
        TextView kZt;
        TextView kZu;
        TextView kZv;
        TextView mName;
        TextView nga;
        TextView ngb;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jqd = 0;
        this.iHO = tbPageContext;
        this.jqd = i;
    }

    public ForumInfoData[] dND() {
        return this.nfZ;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.nfY = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.nfZ = forumInfoDataArr;
        if (this.nfZ != null) {
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

    public void dNE() {
        for (int i = 0; i < this.nfX; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.nfZ[i].forum_name);
            if (hasLikeForum == 1) {
                this.nfZ[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.nfZ[i].is_like = 0;
            }
        }
    }

    public boolean dNF() {
        if (this.fgf == null) {
            return false;
        }
        return this.fgf.dOB();
    }

    public void JR(int i) {
        this.nfX = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.nfD = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nfZ == null) {
            return 0;
        }
        return this.nfX <= this.nfZ.length ? this.nfX : this.nfZ.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.nfX) {
            return null;
        }
        return this.nfZ[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iHO.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.kZs = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.kZs.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.kZt = (TextView) view.findViewById(R.id.member_count);
            aVar.kZu = (TextView) view.findViewById(R.id.thread_count);
            aVar.kZv = (TextView) view.findViewById(R.id.slogan);
            aVar.ngb = (TextView) view.findViewById(R.id.like);
            aVar.dHF = (TextView) view.findViewById(R.id.rank_badge);
            aVar.nga = (TextView) view.findViewById(R.id.rise_no);
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
        this.iHO.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iHO.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.nfZ[i];
        String str = this.nfZ[i].avatar;
        aVar2.kZs.setTag(str);
        aVar2.kZs.invalidate();
        aVar2.kZs.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.ngb.setTag(forumInfoData.forum_name);
        aVar2.kZt.setText(this.iHO.getString(R.string.attention) + " " + FF(forumInfoData.member_count));
        aVar2.kZu.setText(this.iHO.getString(R.string.text_post) + " " + FF(forumInfoData.thread_count));
        aVar2.kZv.setText(forumInfoData.slogan);
        if (this.jqd == 0) {
            aVar2.nga.setVisibility(8);
            if (!this.nfD) {
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
            aVar2.nga.setVisibility(0);
            aVar2.nga.setText((CharSequence) null);
            aVar2.nga.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.nga.setText(this.iHO.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iHO.getString(R.string.number));
        }
        aVar2.ngb.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iHO.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iHO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iHO.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iHO.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.nfY)));
            return;
        }
        TiebaStatic.eventStat(this.iHO.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iHO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iHO.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String FF(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iHO.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xT(boolean z) {
        notifyDataSetChanged();
    }
}
