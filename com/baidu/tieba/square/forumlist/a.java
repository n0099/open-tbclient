package com.baidu.tieba.square.forumlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> ehG;
    private LikeModel ezi;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> mjJ = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.ehG = tbPageContext;
        this.mPageType = i;
        this.ezi = new LikeModel(this.ehG);
        this.ezi.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bC(a.this.ezi.getErrorCode(), a.this.ezi.getErrorString())) {
                    AntiHelper.bh(a.this.ehG.getPageActivity(), a.this.ezi.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.ehG.showToast(R.string.neterror);
                    } else if (bg.checkUpIsLogin(a.this.ehG.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.ezi.gd(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new aq("c10587").dF("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10566").dF("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ehG.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new aq("c10586").ai("obj_type", 1).dF("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new aq("c10565").ai("obj_type", 1).dF("fid", valueOf4));
                }
            }
        };
    }

    public void setData(List<ForumSpaceForumInfo> list) {
        this.mListData = list;
        notifyDataSetChanged();
    }

    public void a(Long l, boolean z) {
        Integer valueOf;
        if (this.mjJ.containsKey(l)) {
            Integer num = this.mjJ.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.mjJ.put(l, valueOf);
        } else if (!this.mjJ.containsKey(l)) {
            this.mjJ.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.getCount(this.mListData) > 0) {
            return y.getCount(this.mListData) + 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ie */
    public ForumSpaceForumInfo getItem(int i) {
        if (getCount() > 1 && i != 0) {
            return (ForumSpaceForumInfo) y.getItem(this.mListData, i - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ap.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ap.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0800a)) {
                view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0800a c0800a = new C0800a();
                c0800a.mjL = (TextView) view.findViewById(R.id.forum_rank);
                c0800a.mjM = (BarImageView) view.findViewById(R.id.forum_image);
                c0800a.mjO = (TextView) view.findViewById(R.id.forum_like);
                c0800a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0800a.fKi = (TextView) view.findViewById(R.id.forum_desc);
                c0800a.mjN = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.ehG.getPageActivity(), c0800a.mjO, 20, 20, 20, 20);
                c0800a.mjO.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0800a);
            }
            ap.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0800a c0800a2 = (C0800a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0800a2.mjL.setText("");
                ap.setBackgroundResource(c0800a2.mjL, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0800a2.mjL.setText("");
                ap.setBackgroundResource(c0800a2.mjL, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0800a2.mjL.setText("");
                ap.setBackgroundResource(c0800a2.mjL, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0800a2.mjL.setText("0" + i);
                c0800a2.mjL.setBackgroundResource(0);
            } else {
                c0800a2.mjL.setText("" + i);
                c0800a2.mjL.setBackgroundResource(0);
            }
            ap.setViewTextColor(c0800a2.mjL, R.color.cp_cont_c);
            c0800a2.mjM.startLoad(item.avatar, 10, false);
            c0800a2.mTitle.setText(item.forum_name + this.ehG.getString(R.string.forum));
            ap.setViewTextColor(c0800a2.mTitle, R.color.cp_cont_b);
            Integer num = this.mjJ.get(item.forum_id);
            c0800a2.fKi.setText(this.ehG.getString(R.string.attention) + ":" + at.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.ehG.getString(R.string.text_post) + ":" + at.numberUniformFormat(item.post_num.intValue()));
            ap.setViewTextColor(c0800a2.fKi, R.color.cp_cont_d);
            c0800a2.mjN.setText(item._abstract);
            ap.setViewTextColor(c0800a2.mjN, R.color.cp_cont_d);
            c0800a2.mjO.setTag(R.id.forum_title, item.forum_name);
            c0800a2.mjO.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.mjJ.get(item.forum_id) == null ? 0 : this.mjJ.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0800a2.mjO.setText(R.string.relate_forum_is_followed);
                c0800a2.mjO.setBackgroundResource(0);
                ap.setViewTextColor(c0800a2.mjO, R.color.cp_cont_d);
            } else {
                c0800a2.mjO.setText(R.string.attention);
                c0800a2.mjO.setBackgroundResource(R.drawable.btn_blue_bg);
                ap.setViewTextColor(c0800a2.mjO, R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0800a {
        public TextView fKi;
        public TextView mTitle;
        public TextView mjL;
        public BarImageView mjM;
        public TextView mjN;
        public TextView mjO;

        private C0800a() {
        }
    }
}
