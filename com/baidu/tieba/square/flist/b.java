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
/* loaded from: classes17.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel ewX;
    private TbPageContext hHG;
    private int inf;
    public int lYX = -1;
    private int lYY = 0;
    private boolean lYE = true;
    private ForumDetailActivityConfig.FromType lYZ = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] lZa = new ForumInfoData[0];

    /* loaded from: classes17.dex */
    class a {
        TextView cZG;
        TextView jVA;
        BarImageView jVx;
        TextView jVy;
        TextView jVz;
        TextView lZb;
        TextView lZc;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.inf = 0;
        this.hHG = tbPageContext;
        this.inf = i;
    }

    public ForumInfoData[] dvd() {
        return this.lZa;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.lYZ = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.lZa = forumInfoDataArr;
        if (this.lZa != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.ewX = likeModel;
    }

    public void dj(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dve() {
        for (int i = 0; i < this.lYY; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.lZa[i].forum_name);
            if (hasLikeForum == 1) {
                this.lZa[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.lZa[i].is_like = 0;
            }
        }
    }

    public boolean dvf() {
        if (this.ewX == null) {
            return false;
        }
        return this.ewX.dvZ();
    }

    public void GM(int i) {
        this.lYY = i;
        notifyDataSetChanged();
    }

    public void q(Boolean bool) {
        this.lYE = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lZa == null) {
            return 0;
        }
        return this.lYY <= this.lZa.length ? this.lYY : this.lZa.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.lYY) {
            return null;
        }
        return this.lZa[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.hHG.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.jVx = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.jVx.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.jVy = (TextView) view.findViewById(R.id.member_count);
            aVar.jVz = (TextView) view.findViewById(R.id.thread_count);
            aVar.jVA = (TextView) view.findViewById(R.id.slogan);
            aVar.lZc = (TextView) view.findViewById(R.id.like);
            aVar.cZG = (TextView) view.findViewById(R.id.rank_badge);
            aVar.lZb = (TextView) view.findViewById(R.id.rise_no);
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
        this.hHG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hHG.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.lZa[i];
        String str = this.lZa[i].avatar;
        aVar2.jVx.setTag(str);
        aVar2.jVx.invalidate();
        aVar2.jVx.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.lZc.setTag(forumInfoData.forum_name);
        aVar2.jVy.setText(this.hHG.getString(R.string.attention) + " " + CF(forumInfoData.member_count));
        aVar2.jVz.setText(this.hHG.getString(R.string.text_post) + " " + CF(forumInfoData.thread_count));
        aVar2.jVA.setText(forumInfoData.slogan);
        if (this.inf == 0) {
            aVar2.lZb.setVisibility(8);
            if (!this.lYE) {
                aVar2.cZG.setVisibility(8);
            } else {
                aVar2.cZG.setVisibility(0);
                aVar2.cZG.setText((CharSequence) null);
                aVar2.cZG.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.cZG, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.cZG, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.cZG, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cZG.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cZG.setVisibility(8);
            aVar2.lZb.setVisibility(0);
            aVar2.lZb.setText((CharSequence) null);
            aVar2.lZb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.lZb.setText(this.hHG.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.hHG.getString(R.string.number));
        }
        aVar2.lZc.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.hHG.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.hHG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hHG.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.hHG.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.lYZ)));
            return;
        }
        TiebaStatic.eventStat(this.hHG.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.hHG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hHG.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String CF(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.hHG.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void vT(boolean z) {
        notifyDataSetChanged();
    }
}
