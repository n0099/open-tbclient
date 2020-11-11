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
    private LikeModel eZA;
    private TbPageContext iwh;
    private int jbO;
    public int mQY = -1;
    private int mQZ = 0;
    private boolean mQF = true;
    private ForumDetailActivityConfig.FromType mRa = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] mRb = new ForumInfoData[0];

    /* loaded from: classes23.dex */
    class a {
        TextView dCo;
        BarImageView kLM;
        TextView kLN;
        TextView kLO;
        TextView kLP;
        TextView mName;
        TextView mRd;
        TextView mRe;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jbO = 0;
        this.iwh = tbPageContext;
        this.jbO = i;
    }

    public ForumInfoData[] dIw() {
        return this.mRb;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.mRa = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.mRb = forumInfoDataArr;
        if (this.mRb != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.eZA = likeModel;
    }

    public void dr(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dIx() {
        for (int i = 0; i < this.mQZ; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.mRb[i].forum_name);
            if (hasLikeForum == 1) {
                this.mRb[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.mRb[i].is_like = 0;
            }
        }
    }

    public boolean dIy() {
        if (this.eZA == null) {
            return false;
        }
        return this.eZA.dJt();
    }

    public void Iz(int i) {
        this.mQZ = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.mQF = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mRb == null) {
            return 0;
        }
        return this.mQZ <= this.mRb.length ? this.mQZ : this.mRb.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.mQZ) {
            return null;
        }
        return this.mRb[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iwh.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.kLM = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.kLM.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.kLN = (TextView) view.findViewById(R.id.member_count);
            aVar.kLO = (TextView) view.findViewById(R.id.thread_count);
            aVar.kLP = (TextView) view.findViewById(R.id.slogan);
            aVar.mRe = (TextView) view.findViewById(R.id.like);
            aVar.dCo = (TextView) view.findViewById(R.id.rank_badge);
            aVar.mRd = (TextView) view.findViewById(R.id.rise_no);
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
        this.iwh.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iwh.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.mRb[i];
        String str = this.mRb[i].avatar;
        aVar2.kLM.setTag(str);
        aVar2.kLM.invalidate();
        aVar2.kLM.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.mRe.setTag(forumInfoData.forum_name);
        aVar2.kLN.setText(this.iwh.getString(R.string.attention) + " " + Es(forumInfoData.member_count));
        aVar2.kLO.setText(this.iwh.getString(R.string.text_post) + " " + Es(forumInfoData.thread_count));
        aVar2.kLP.setText(forumInfoData.slogan);
        if (this.jbO == 0) {
            aVar2.mRd.setVisibility(8);
            if (!this.mQF) {
                aVar2.dCo.setVisibility(8);
            } else {
                aVar2.dCo.setVisibility(0);
                aVar2.dCo.setText((CharSequence) null);
                aVar2.dCo.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dCo, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dCo, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dCo, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dCo.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dCo.setVisibility(8);
            aVar2.mRd.setVisibility(0);
            aVar2.mRd.setText((CharSequence) null);
            aVar2.mRd.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.mRd.setText(this.iwh.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iwh.getString(R.string.number));
        }
        aVar2.mRe.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iwh.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iwh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iwh.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iwh.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.mRa)));
            return;
        }
        TiebaStatic.eventStat(this.iwh.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iwh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iwh.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String Es(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iwh.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xl(boolean z) {
        notifyDataSetChanged();
    }
}
