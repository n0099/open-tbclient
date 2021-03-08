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
/* loaded from: classes7.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel foW;
    private TbPageContext iWY;
    private int jFy;
    public int ntl = -1;
    private int ntm = 0;
    private boolean nsS = true;
    private ForumDetailActivityConfig.FromType ntn = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] nto = new ForumInfoData[0];

    /* loaded from: classes7.dex */
    class a {
        TextView dPd;
        BarImageView lkL;
        TextView lkM;
        TextView lkN;
        TextView lkO;
        TextView mName;
        TextView ntp;
        TextView ntq;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.jFy = 0;
        this.iWY = tbPageContext;
        this.jFy = i;
    }

    public ForumInfoData[] dMg() {
        return this.nto;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.ntn = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.nto = forumInfoDataArr;
        if (this.nto != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.foW = likeModel;
    }

    public void dr(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dMh() {
        for (int i = 0; i < this.ntm; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.nto[i].forum_name);
            if (hasLikeForum == 1) {
                this.nto[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.nto[i].is_like = 0;
            }
        }
    }

    public boolean dMi() {
        if (this.foW == null) {
            return false;
        }
        return this.foW.dNe();
    }

    public void IC(int i) {
        this.ntm = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.nsS = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nto == null) {
            return 0;
        }
        return this.ntm <= this.nto.length ? this.ntm : this.nto.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.ntm) {
            return null;
        }
        return this.nto[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iWY.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.lkL = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.lkL.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.lkM = (TextView) view.findViewById(R.id.member_count);
            aVar.lkN = (TextView) view.findViewById(R.id.thread_count);
            aVar.lkO = (TextView) view.findViewById(R.id.slogan);
            aVar.ntq = (TextView) view.findViewById(R.id.like);
            aVar.dPd = (TextView) view.findViewById(R.id.rank_badge);
            aVar.ntp = (TextView) view.findViewById(R.id.rise_no);
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
        this.iWY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iWY.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.nto[i];
        String str = this.nto[i].avatar;
        aVar2.lkL.setTag(str);
        aVar2.lkL.invalidate();
        aVar2.lkL.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.ntq.setTag(forumInfoData.forum_name);
        aVar2.lkM.setText(this.iWY.getString(R.string.attention) + " " + Eo(forumInfoData.member_count));
        aVar2.lkN.setText(this.iWY.getString(R.string.text_post) + " " + Eo(forumInfoData.thread_count));
        aVar2.lkO.setText(forumInfoData.slogan);
        if (this.jFy == 0) {
            aVar2.ntp.setVisibility(8);
            if (!this.nsS) {
                aVar2.dPd.setVisibility(8);
            } else {
                aVar2.dPd.setVisibility(0);
                aVar2.dPd.setText((CharSequence) null);
                aVar2.dPd.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dPd, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dPd, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dPd, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dPd.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dPd.setVisibility(8);
            aVar2.ntp.setVisibility(0);
            aVar2.ntp.setText((CharSequence) null);
            aVar2.ntp.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.ntp.setText(this.iWY.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iWY.getString(R.string.number));
        }
        aVar2.ntq.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iWY.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iWY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iWY.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iWY.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.ntn)));
            return;
        }
        TiebaStatic.eventStat(this.iWY.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iWY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iWY.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String Eo(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iWY.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void yk(boolean z) {
        notifyDataSetChanged();
    }
}
