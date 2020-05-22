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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel dYI;
    private int hEW;
    private TbPageContext hci;
    public int leU = -1;
    private int leV = 0;
    private boolean leB = true;
    private ForumDetailActivityConfig.FromType leW = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] leX = new ForumInfoData[0];

    /* loaded from: classes10.dex */
    class a {
        TextView cIz;
        BarImageView jfE;
        TextView jfF;
        TextView jfG;
        TextView jfH;
        TextView leY;
        TextView leZ;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.hEW = 0;
        this.hci = tbPageContext;
        this.hEW = i;
    }

    public ForumInfoData[] dbS() {
        return this.leX;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.leW = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.leX = forumInfoDataArr;
        if (this.leX != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.dYI = likeModel;
    }

    public void cT(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dbT() {
        for (int i = 0; i < this.leV; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.leX[i].forum_name);
            if (hasLikeForum == 1) {
                this.leX[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.leX[i].is_like = 0;
            }
        }
    }

    public boolean dbU() {
        if (this.dYI == null) {
            return false;
        }
        return this.dYI.dcO();
    }

    public void CP(int i) {
        this.leV = i;
        notifyDataSetChanged();
    }

    public void m(Boolean bool) {
        this.leB = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.leX == null) {
            return 0;
        }
        return this.leV <= this.leX.length ? this.leV : this.leX.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.leV) {
            return null;
        }
        return this.leX[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.hci.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.jfE = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.jfE.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.jfF = (TextView) view.findViewById(R.id.member_count);
            aVar.jfG = (TextView) view.findViewById(R.id.thread_count);
            aVar.jfH = (TextView) view.findViewById(R.id.slogan);
            aVar.leZ = (TextView) view.findViewById(R.id.like);
            aVar.cIz = (TextView) view.findViewById(R.id.rank_badge);
            aVar.leY = (TextView) view.findViewById(R.id.rise_no);
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
        this.hci.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hci.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.leX[i];
        String str = this.leX[i].avatar;
        aVar2.jfE.setTag(str);
        aVar2.jfE.invalidate();
        aVar2.jfE.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.leZ.setTag(forumInfoData.forum_name);
        aVar2.jfF.setText(this.hci.getString(R.string.attention) + " " + yZ(forumInfoData.member_count));
        aVar2.jfG.setText(this.hci.getString(R.string.text_post) + " " + yZ(forumInfoData.thread_count));
        aVar2.jfH.setText(forumInfoData.slogan);
        if (this.hEW == 0) {
            aVar2.leY.setVisibility(8);
            if (!this.leB) {
                aVar2.cIz.setVisibility(8);
            } else {
                aVar2.cIz.setVisibility(0);
                aVar2.cIz.setText((CharSequence) null);
                aVar2.cIz.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.cIz, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.cIz, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.cIz, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.cIz.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.cIz.setVisibility(8);
            aVar2.leY.setVisibility(0);
            aVar2.leY.setText((CharSequence) null);
            aVar2.leY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.leY.setText(this.hci.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.hci.getString(R.string.number));
        }
        aVar2.leZ.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.hci.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.hci.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hci.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.hci.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.leW)));
            return;
        }
        TiebaStatic.eventStat(this.hci.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.hci.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hci.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String yZ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.hci.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void ul(boolean z) {
        notifyDataSetChanged();
    }
}
