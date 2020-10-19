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
    private LikeModel eLp;
    private int iJv;
    private TbPageContext idM;
    public int myr = -1;
    private int mys = 0;
    private boolean mxY = true;
    private ForumDetailActivityConfig.FromType myt = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] myu = new ForumInfoData[0];

    /* loaded from: classes23.dex */
    class a {
        TextView dnV;
        BarImageView ktt;
        TextView ktu;
        TextView ktv;
        TextView ktw;
        TextView mName;
        TextView myv;
        TextView myw;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.iJv = 0;
        this.idM = tbPageContext;
        this.iJv = i;
    }

    public ForumInfoData[] dCM() {
        return this.myu;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.myt = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.myu = forumInfoDataArr;
        if (this.myu != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.eLp = likeModel;
    }

    public void dn(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void dCN() {
        for (int i = 0; i < this.mys; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.myu[i].forum_name);
            if (hasLikeForum == 1) {
                this.myu[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.myu[i].is_like = 0;
            }
        }
    }

    public boolean dCO() {
        if (this.eLp == null) {
            return false;
        }
        return this.eLp.dDJ();
    }

    public void HT(int i) {
        this.mys = i;
        notifyDataSetChanged();
    }

    public void s(Boolean bool) {
        this.mxY = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.myu == null) {
            return 0;
        }
        return this.mys <= this.myu.length ? this.mys : this.myu.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.mys) {
            return null;
        }
        return this.myu[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.idM.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.ktt = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.ktt.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.ktu = (TextView) view.findViewById(R.id.member_count);
            aVar.ktv = (TextView) view.findViewById(R.id.thread_count);
            aVar.ktw = (TextView) view.findViewById(R.id.slogan);
            aVar.myw = (TextView) view.findViewById(R.id.like);
            aVar.dnV = (TextView) view.findViewById(R.id.rank_badge);
            aVar.myv = (TextView) view.findViewById(R.id.rise_no);
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
        this.idM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.idM.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.myu[i];
        String str = this.myu[i].avatar;
        aVar2.ktt.setTag(str);
        aVar2.ktt.invalidate();
        aVar2.ktt.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.myw.setTag(forumInfoData.forum_name);
        aVar2.ktu.setText(this.idM.getString(R.string.attention) + " " + DM(forumInfoData.member_count));
        aVar2.ktv.setText(this.idM.getString(R.string.text_post) + " " + DM(forumInfoData.thread_count));
        aVar2.ktw.setText(forumInfoData.slogan);
        if (this.iJv == 0) {
            aVar2.myv.setVisibility(8);
            if (!this.mxY) {
                aVar2.dnV.setVisibility(8);
            } else {
                aVar2.dnV.setVisibility(0);
                aVar2.dnV.setText((CharSequence) null);
                aVar2.dnV.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        ap.setBackgroundResource(aVar2.dnV, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        ap.setBackgroundResource(aVar2.dnV, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        ap.setBackgroundResource(aVar2.dnV, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.dnV.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.dnV.setVisibility(8);
            aVar2.myv.setVisibility(0);
            aVar2.myv.setText((CharSequence) null);
            aVar2.myv.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.myv.setText(this.idM.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.idM.getString(R.string.number));
        }
        aVar2.myw.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.idM.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.idM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.idM.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.idM.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.myt)));
            return;
        }
        TiebaStatic.eventStat(this.idM.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.idM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.idM.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String DM(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.idM.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void wL(boolean z) {
        notifyDataSetChanged();
    }
}
