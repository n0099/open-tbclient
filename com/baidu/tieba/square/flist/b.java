package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel dkh;
    private TbPageContext gdy;
    private int mCurrentTab;
    public int kbh = -1;
    private int kbi = 0;
    private boolean kaO = true;
    private ForumDetailActivityConfig.FromType kbj = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] kbk = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView bXp;
        BarImageView ieW;
        TextView ieX;
        TextView ieY;
        TextView ieZ;
        TextView kbl;
        TextView kbm;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.mCurrentTab = 0;
        this.gdy = tbPageContext;
        this.mCurrentTab = i;
    }

    public ForumInfoData[] cJB() {
        return this.kbk;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.kbj = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.kbk = forumInfoDataArr;
        if (this.kbk != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dkh = likeModel;
    }

    public void cI(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cJC() {
        for (int i = 0; i < this.kbi; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.kbk[i].forum_name);
            if (hasLikeForum == 1) {
                this.kbk[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.kbk[i].is_like = 0;
            }
        }
    }

    public boolean cJD() {
        if (this.dkh == null) {
            return false;
        }
        return this.dkh.cKw();
    }

    public void Bx(int i) {
        this.kbi = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.kaO = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kbk == null) {
            return 0;
        }
        return this.kbi <= this.kbk.length ? this.kbi : this.kbk.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.kbi) {
            return null;
        }
        return this.kbk[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.gdy.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.ieW = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.ieW.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.ieX = (TextView) view.findViewById(R.id.member_count);
            aVar.ieY = (TextView) view.findViewById(R.id.thread_count);
            aVar.ieZ = (TextView) view.findViewById(R.id.slogan);
            aVar.kbm = (TextView) view.findViewById(R.id.like);
            aVar.bXp = (TextView) view.findViewById(R.id.rank_badge);
            aVar.kbl = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
        am.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.gdy.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gdy.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.kbk[i];
        String str = this.kbk[i].avatar;
        aVar2.ieW.setTag(str);
        aVar2.ieW.invalidate();
        aVar2.ieW.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.kbm.setTag(forumInfoData.forum_name);
        aVar2.ieX.setText(this.gdy.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xJ(forumInfoData.member_count));
        aVar2.ieY.setText(this.gdy.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xJ(forumInfoData.thread_count));
        aVar2.ieZ.setText(forumInfoData.slogan);
        if (this.mCurrentTab == 0) {
            aVar2.kbl.setVisibility(8);
            if (!this.kaO) {
                aVar2.bXp.setVisibility(8);
            } else {
                aVar2.bXp.setVisibility(0);
                aVar2.bXp.setText((CharSequence) null);
                aVar2.bXp.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.bXp, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.bXp, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.bXp, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.bXp.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.bXp.setVisibility(8);
            aVar2.kbl.setVisibility(0);
            aVar2.kbl.setText((CharSequence) null);
            aVar2.kbl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.kbl.setText(this.gdy.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.gdy.getString(R.string.number));
        }
        aVar2.kbm.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.gdy.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.gdy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gdy.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.gdy.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.kbj)));
            return;
        }
        TiebaStatic.eventStat(this.gdy.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.gdy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gdy.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String xJ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.gdy.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void sF(boolean z) {
        notifyDataSetChanged();
    }
}
