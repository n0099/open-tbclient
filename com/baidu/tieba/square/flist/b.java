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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel egK;
    private int hSW;
    private TbPageContext hoE;
    public int lAa = -1;
    private int lAb = 0;
    private boolean lzH = true;
    private ForumDetailActivityConfig.FromType lAc = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] lAd = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView cNj;
        BarImageView jxA;
        TextView jxB;
        TextView jxC;
        TextView jxD;
        TextView lAe;
        TextView lAf;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.hSW = 0;
        this.hoE = tbPageContext;
        this.hSW = i;
    }

    public ForumInfoData[] dgx() {
        return this.lAd;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.lAc = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.lAd = forumInfoDataArr;
        if (this.lAd != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.egK = likeModel;
    }

    public void cZ(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dgy() {
        for (int i = 0; i < this.lAb; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.lAd[i].forum_name);
            if (hasLikeForum == 1) {
                this.lAd[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.lAd[i].is_like = 0;
            }
        }
    }

    public boolean dgz() {
        if (this.egK == null) {
            return false;
        }
        return this.egK.dht();
    }

    public void DT(int i) {
        this.lAb = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.lzH = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lAd == null) {
            return 0;
        }
        return this.lAb <= this.lAd.length ? this.lAb : this.lAd.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.lAb) {
            return null;
        }
        return this.lAd[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.hoE.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.jxA = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.jxA.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.jxB = (TextView) view.findViewById(R.id.member_count);
            aVar.jxC = (TextView) view.findViewById(R.id.thread_count);
            aVar.jxD = (TextView) view.findViewById(R.id.slogan);
            aVar.lAf = (TextView) view.findViewById(R.id.like);
            aVar.cNj = (TextView) view.findViewById(R.id.rank_badge);
            aVar.lAe = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        an.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
        an.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.hoE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hoE.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.lAd[i];
        String str = this.lAd[i].avatar;
        aVar2.jxA.setTag(str);
        aVar2.jxA.invalidate();
        aVar2.jxA.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.lAf.setTag(forumInfoData.forum_name);
        aVar2.jxB.setText(this.hoE.getString(R.string.attention) + " " + zN(forumInfoData.member_count));
        aVar2.jxC.setText(this.hoE.getString(R.string.text_post) + " " + zN(forumInfoData.thread_count));
        aVar2.jxD.setText(forumInfoData.slogan);
        if (this.hSW == 0) {
            aVar2.lAe.setVisibility(8);
            if (!this.lzH) {
                aVar2.cNj.setVisibility(8);
            } else {
                aVar2.cNj.setVisibility(0);
                aVar2.cNj.setText((CharSequence) null);
                aVar2.cNj.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        an.setBackgroundResource(aVar2.cNj, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        an.setBackgroundResource(aVar2.cNj, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        an.setBackgroundResource(aVar2.cNj, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cNj.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cNj.setVisibility(8);
            aVar2.lAe.setVisibility(0);
            aVar2.lAe.setText((CharSequence) null);
            aVar2.lAe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.lAe.setText(this.hoE.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.hoE.getString(R.string.number));
        }
        aVar2.lAf.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.hoE.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.hoE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hoE.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.hoE.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.lAc)));
            return;
        }
        TiebaStatic.eventStat(this.hoE.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.hoE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hoE.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String zN(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.hoE.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void uA(boolean z) {
        notifyDataSetChanged();
    }
}
