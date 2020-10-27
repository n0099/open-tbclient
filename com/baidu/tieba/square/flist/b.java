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
    private LikeModel eTL;
    private int iVR;
    private TbPageContext iqk;
    public int mLb = -1;
    private int mLc = 0;
    private boolean mKI = true;
    private ForumDetailActivityConfig.FromType mLd = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] mLe = new ForumInfoData[0];

    /* loaded from: classes23.dex */
    class a {
        TextView dww;
        BarImageView kFQ;
        TextView kFR;
        TextView kFS;
        TextView kFT;
        TextView mLf;
        TextView mLg;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.iVR = 0;
        this.iqk = tbPageContext;
        this.iVR = i;
    }

    public ForumInfoData[] dFU() {
        return this.mLe;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.mLd = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.mLe = forumInfoDataArr;
        if (this.mLe != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.eTL = likeModel;
    }

    public void dp(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dFV() {
        for (int i = 0; i < this.mLc; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.mLe[i].forum_name);
            if (hasLikeForum == 1) {
                this.mLe[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.mLe[i].is_like = 0;
            }
        }
    }

    public boolean dFW() {
        if (this.eTL == null) {
            return false;
        }
        return this.eTL.dGR();
    }

    public void Im(int i) {
        this.mLc = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.mKI = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mLe == null) {
            return 0;
        }
        return this.mLc <= this.mLe.length ? this.mLc : this.mLe.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.mLc) {
            return null;
        }
        return this.mLe[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.iqk.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.kFQ = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.kFQ.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.kFR = (TextView) view.findViewById(R.id.member_count);
            aVar.kFS = (TextView) view.findViewById(R.id.thread_count);
            aVar.kFT = (TextView) view.findViewById(R.id.slogan);
            aVar.mLg = (TextView) view.findViewById(R.id.like);
            aVar.dww = (TextView) view.findViewById(R.id.rank_badge);
            aVar.mLf = (TextView) view.findViewById(R.id.rise_no);
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
        this.iqk.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iqk.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.mLe[i];
        String str = this.mLe[i].avatar;
        aVar2.kFQ.setTag(str);
        aVar2.kFQ.invalidate();
        aVar2.kFQ.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.mLg.setTag(forumInfoData.forum_name);
        aVar2.kFR.setText(this.iqk.getString(R.string.attention) + " " + Ef(forumInfoData.member_count));
        aVar2.kFS.setText(this.iqk.getString(R.string.text_post) + " " + Ef(forumInfoData.thread_count));
        aVar2.kFT.setText(forumInfoData.slogan);
        if (this.iVR == 0) {
            aVar2.mLf.setVisibility(8);
            if (!this.mKI) {
                aVar2.dww.setVisibility(8);
            } else {
                aVar2.dww.setVisibility(0);
                aVar2.dww.setText((CharSequence) null);
                aVar2.dww.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dww, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dww, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dww, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dww.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dww.setVisibility(8);
            aVar2.mLf.setVisibility(0);
            aVar2.mLf.setText((CharSequence) null);
            aVar2.mLf.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.mLf.setText(this.iqk.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.iqk.getString(R.string.number));
        }
        aVar2.mLg.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.iqk.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.iqk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iqk.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.iqk.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.mLd)));
            return;
        }
        TiebaStatic.eventStat(this.iqk.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.iqk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iqk.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String Ef(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.iqk.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void xc(boolean z) {
        notifyDataSetChanged();
    }
}
