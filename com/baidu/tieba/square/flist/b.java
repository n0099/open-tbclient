package com.baidu.tieba.square.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.b.d;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private LikeModel crO;
    private int fMa;
    private TbPageContext fjz;
    public int jbP = -1;
    private int jbQ = 0;
    private boolean jbw = true;
    private ForumDetailActivityConfig.FromType jbR = ForumDetailActivityConfig.FromType.BAR_DIR;
    private ForumInfoData[] jbS = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    class a {
        TextView bra;
        BarImageView hlc;
        TextView hld;
        TextView hle;
        TextView hlf;
        TextView jbT;
        TextView jbU;
        TextView mName;

        a() {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.fMa = 0;
        this.fjz = tbPageContext;
        this.fMa = i;
    }

    public ForumInfoData[] cmF() {
        return this.jbS;
    }

    public void a(ForumDetailActivityConfig.FromType fromType) {
        this.jbR = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.jbS = forumInfoDataArr;
        if (this.jbS != null) {
            notifyDataSetChanged();
        }
    }

    public void a(LikeModel likeModel) {
        this.crO = likeModel;
    }

    public void cm(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void cmG() {
        for (int i = 0; i < this.jbQ; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.jbS[i].forum_name);
            if (hasLikeForum == 1) {
                this.jbS[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.jbS[i].is_like = 0;
            }
        }
    }

    public boolean cmH() {
        if (this.crO == null) {
            return false;
        }
        return this.crO.cnE();
    }

    public void yO(int i) {
        this.jbQ = i;
        notifyDataSetChanged();
    }

    public void i(Boolean bool) {
        this.jbw = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbS == null) {
            return 0;
        }
        return this.jbQ <= this.jbS.length ? this.jbQ : this.jbS.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.jbQ) {
            return null;
        }
        return this.jbS[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.fjz.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a();
            aVar.hlc = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.hlc.setGifIconSupport(false);
            aVar.mName = (TextView) view.findViewById(R.id.name);
            aVar.hld = (TextView) view.findViewById(R.id.member_count);
            aVar.hle = (TextView) view.findViewById(R.id.thread_count);
            aVar.hlf = (TextView) view.findViewById(R.id.slogan);
            aVar.jbU = (TextView) view.findViewById(R.id.like);
            aVar.bra = (TextView) view.findViewById(R.id.rank_badge);
            aVar.jbT = (TextView) view.findViewById(R.id.rise_no);
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
        this.fjz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fjz.getLayoutMode().onModeChanged(view);
        ForumInfoData forumInfoData = this.jbS[i];
        String str = this.jbS[i].avatar;
        aVar2.hlc.setTag(str);
        aVar2.hlc.invalidate();
        aVar2.hlc.startLoad(str, 10, false);
        aVar2.mName.setText(forumInfoData.forum_name);
        aVar2.mName.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.jbU.setTag(forumInfoData.forum_name);
        aVar2.hld.setText(this.fjz.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + vw(forumInfoData.member_count));
        aVar2.hle.setText(this.fjz.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + vw(forumInfoData.thread_count));
        aVar2.hlf.setText(forumInfoData.slogan);
        if (this.fMa == 0) {
            aVar2.jbT.setVisibility(8);
            if (!this.jbw) {
                aVar2.bra.setVisibility(8);
            } else {
                aVar2.bra.setVisibility(0);
                aVar2.bra.setText((CharSequence) null);
                aVar2.bra.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        am.setBackgroundResource(aVar2.bra, R.drawable.icon_brief_grade_orange);
                        break;
                    case 1:
                        am.setBackgroundResource(aVar2.bra, R.drawable.icon_brief_grade_blue);
                        break;
                    case 2:
                        am.setBackgroundResource(aVar2.bra, R.drawable.icon_brief_grade_green);
                        break;
                    default:
                        aVar2.bra.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            aVar2.bra.setVisibility(8);
            aVar2.jbT.setVisibility(0);
            aVar2.jbT.setText((CharSequence) null);
            aVar2.jbT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            aVar2.jbT.setText(this.fjz.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.fjz.getString(R.string.number));
        }
        aVar2.jbU.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.fjz.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.fjz.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fjz.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && d.ft().af("bar_detail") == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.fjz.getPageActivity(), String.valueOf(aVar.mName.getTag()), this.jbR)));
            return;
        }
        TiebaStatic.eventStat(this.fjz.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.fjz.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fjz.getPageActivity()).createNormalCfg(aVar.mName.getText().toString(), null)));
    }

    public String vw(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.fjz.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void qH(boolean z) {
        notifyDataSetChanged();
    }
}
