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
    private TbPageContext iVb;
    private int jDB;
    public int nqH = -1;
    private int nqI = 0;
    private boolean nqo = true;
    private ForumDetailActivityConfig.FromType nqJ = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] nqK = new ForumInfoData[0];

    /* loaded from: classes8.dex */
    class a {
        TextView dNC;
        BarImageView liv;
        TextView liw;
        TextView lix;
        TextView liy;
        TextView mName;
        TextView nqL;
        TextView nqM;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jDB = 0;
        this.iVb = tbPageContext;
        this.jDB = i;
    }

    public ForumInfoData[] dLQ() {
        return this.nqK;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.nqJ = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.nqK = forumInfoDataArr;
        if (this.nqK != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.fnw = likeModel;
    }

    public void dq(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dLR() {
        for (int i = 0; i < this.nqI; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.nqK[i].forum_name);
            if (hasLikeForum == 1) {
                this.nqK[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.nqK[i].is_like = 0;
            }
        }
    }

    public boolean dLS() {
        if (this.fnw == null) {
            return false;
        }
        return this.fnw.dMO();
    }

    public void Iy(int i) {
        this.nqI = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.nqo = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nqK == null) {
            return 0;
        }
        return this.nqI <= this.nqK.length ? this.nqI : this.nqK.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.nqI) {
            return null;
        }
        return this.nqK[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iVb.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.liv = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.liv.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.liw = (TextView) view.findViewById(R.id.member_count);
            aVar.lix = (TextView) view.findViewById(R.id.thread_count);
            aVar.liy = (TextView) view.findViewById(R.id.slogan);
            aVar.nqM = (TextView) view.findViewById(R.id.like);
            aVar.dNC = (TextView) view.findViewById(R.id.rank_badge);
            aVar.nqL = (TextView) view.findViewById(R.id.rise_no);
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
        this.iVb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iVb.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.nqK[i];
        String str = this.nqK[i].avatar;
        aVar2.liv.setTag(str);
        aVar2.liv.invalidate();
        aVar2.liv.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.nqM.setTag(forumInfoData.forum_name);
        aVar2.liw.setText(this.iVb.getString(R.string.attention) + " " + El(forumInfoData.member_count));
        aVar2.lix.setText(this.iVb.getString(R.string.text_post) + " " + El(forumInfoData.thread_count));
        aVar2.liy.setText(forumInfoData.slogan);
        if (this.jDB == 0) {
            aVar2.nqL.setVisibility(8);
            if (!this.nqo) {
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
            aVar2.nqL.setVisibility(0);
            aVar2.nqL.setText((CharSequence) null);
            aVar2.nqL.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.nqL.setText(this.iVb.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iVb.getString(R.string.number));
        }
        aVar2.nqM.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iVb.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iVb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iVb.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iVb.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.nqJ)));
            return;
        }
        TiebaStatic.eventStat(this.iVb.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iVb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iVb.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String El(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iVb.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void yk(boolean z) {
        notifyDataSetChanged();
    }
}
