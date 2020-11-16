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
    private LikeModel eYI;
    private TbPageContext iwW;
    private int jcA;
    public int mRS = -1;
    private int mRT = 0;
    private boolean mRz = true;
    private ForumDetailActivityConfig.FromType mRU = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] mRV = new ForumInfoData[0];

    /* loaded from: classes22.dex */
    class a {
        TextView dAH;
        BarImageView kMb;
        TextView kMc;
        TextView kMd;
        TextView kMe;
        TextView mName;
        TextView mRW;
        TextView mRX;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jcA = 0;
        this.iwW = tbPageContext;
        this.jcA = i;
    }

    public ForumInfoData[] dIn() {
        return this.mRV;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.mRU = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.mRV = forumInfoDataArr;
        if (this.mRV != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.eYI = likeModel;
    }

    public void ds(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dIo() {
        for (int i = 0; i < this.mRT; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.mRV[i].forum_name);
            if (hasLikeForum == 1) {
                this.mRV[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.mRV[i].is_like = 0;
            }
        }
    }

    public boolean dIp() {
        if (this.eYI == null) {
            return false;
        }
        return this.eYI.dJk();
    }

    public void Ja(int i) {
        this.mRT = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.mRz = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mRV == null) {
            return 0;
        }
        return this.mRT <= this.mRV.length ? this.mRT : this.mRV.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.mRT) {
            return null;
        }
        return this.mRV[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iwW.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.kMb = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.kMb.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.kMc = (TextView) view.findViewById(R.id.member_count);
            aVar.kMd = (TextView) view.findViewById(R.id.thread_count);
            aVar.kMe = (TextView) view.findViewById(R.id.slogan);
            aVar.mRX = (TextView) view.findViewById(R.id.like);
            aVar.dAH = (TextView) view.findViewById(R.id.rank_badge);
            aVar.mRW = (TextView) view.findViewById(R.id.rise_no);
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
        this.iwW.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iwW.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.mRV[i];
        String str = this.mRV[i].avatar;
        aVar2.kMb.setTag(str);
        aVar2.kMb.invalidate();
        aVar2.kMb.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.mRX.setTag(forumInfoData.forum_name);
        aVar2.kMc.setText(this.iwW.getString(R.string.attention) + " " + EQ(forumInfoData.member_count));
        aVar2.kMd.setText(this.iwW.getString(R.string.text_post) + " " + EQ(forumInfoData.thread_count));
        aVar2.kMe.setText(forumInfoData.slogan);
        if (this.jcA == 0) {
            aVar2.mRW.setVisibility(8);
            if (!this.mRz) {
                aVar2.dAH.setVisibility(8);
            } else {
                aVar2.dAH.setVisibility(0);
                aVar2.dAH.setText((CharSequence) null);
                aVar2.dAH.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dAH, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dAH, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dAH, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dAH.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dAH.setVisibility(8);
            aVar2.mRW.setVisibility(0);
            aVar2.mRW.setText((CharSequence) null);
            aVar2.mRW.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.mRW.setText(this.iwW.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iwW.getString(R.string.number));
        }
        aVar2.mRX.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iwW.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iwW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iwW.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iwW.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.mRU)));
            return;
        }
        TiebaStatic.eventStat(this.iwW.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iwW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iwW.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String EQ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iwW.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xp(boolean z) {
        notifyDataSetChanged();
    }
}
