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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> cVv;
    private LikeModel dku;
    private final Map<Long, Integer> kdC = new HashMap();
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.cVv = tbPageContext;
        this.mPageType = i;
        this.dku = new LikeModel(this.cVv);
        this.dku.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bb(a.this.dku.getErrorCode(), a.this.dku.getErrorString())) {
                    AntiHelper.bn(a.this.cVv.getPageActivity(), a.this.dku.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.cVv.showToast(R.string.neterror);
                    } else if (bc.checkUpIsLogin(a.this.cVv.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.dku.eA(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new an("c10587").cx("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10566").cx("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVv.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new an("c10586").X("obj_type", 1).cx("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c10565").X("obj_type", 1).cx("fid", valueOf4));
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
        if (this.kdC.containsKey(l)) {
            Integer num = this.kdC.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.kdC.put(l, valueOf);
        } else if (!this.kdC.containsKey(l)) {
            this.kdC.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.getCount(this.mListData) > 0) {
            return v.getCount(this.mListData) + 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cs */
    public ForumSpaceForumInfo getItem(int i) {
        if (getCount() > 1 && i != 0) {
            return (ForumSpaceForumInfo) v.getItem(this.mListData, i - 1);
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            am.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            am.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0608a)) {
                view = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0608a c0608a = new C0608a();
                c0608a.kdE = (TextView) view.findViewById(R.id.forum_rank);
                c0608a.kdF = (BarImageView) view.findViewById(R.id.forum_image);
                c0608a.kdH = (TextView) view.findViewById(R.id.forum_like);
                c0608a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0608a.eoK = (TextView) view.findViewById(R.id.forum_desc);
                c0608a.kdG = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.cVv.getPageActivity(), c0608a.kdH, 20, 20, 20, 20);
                c0608a.kdH.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0608a);
            }
            am.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0608a c0608a2 = (C0608a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0608a2.kdE.setText("");
                am.setBackgroundResource(c0608a2.kdE, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0608a2.kdE.setText("");
                am.setBackgroundResource(c0608a2.kdE, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0608a2.kdE.setText("");
                am.setBackgroundResource(c0608a2.kdE, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0608a2.kdE.setText("0" + i);
                c0608a2.kdE.setBackgroundResource(0);
            } else {
                c0608a2.kdE.setText("" + i);
                c0608a2.kdE.setBackgroundResource(0);
            }
            am.setViewTextColor(c0608a2.kdE, (int) R.color.cp_cont_c);
            c0608a2.kdF.startLoad(item.avatar, 10, false);
            c0608a2.mTitle.setText(item.forum_name + this.cVv.getString(R.string.forum));
            am.setViewTextColor(c0608a2.mTitle, (int) R.color.cp_cont_b);
            Integer num = this.kdC.get(item.forum_id);
            c0608a2.eoK.setText(this.cVv.getString(R.string.attention) + ":" + aq.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.cVv.getString(R.string.text_post) + ":" + aq.numberUniformFormat(item.post_num.intValue()));
            am.setViewTextColor(c0608a2.eoK, (int) R.color.cp_cont_d);
            c0608a2.kdG.setText(item._abstract);
            am.setViewTextColor(c0608a2.kdG, (int) R.color.cp_cont_d);
            c0608a2.kdH.setTag(R.id.forum_title, item.forum_name);
            c0608a2.kdH.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.kdC.get(item.forum_id) == null ? 0 : this.kdC.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0608a2.kdH.setText(R.string.relate_forum_is_followed);
                c0608a2.kdH.setBackgroundResource(0);
                am.setViewTextColor(c0608a2.kdH, (int) R.color.cp_cont_d);
            } else {
                c0608a2.kdH.setText(R.string.attention);
                c0608a2.kdH.setBackgroundResource(R.drawable.btn_blue_bg);
                am.setViewTextColor(c0608a2.kdH, (int) R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0608a {
        public TextView eoK;
        public TextView kdE;
        public BarImageView kdF;
        public TextView kdG;
        public TextView kdH;
        public TextView mTitle;

        private C0608a() {
        }
    }
}
