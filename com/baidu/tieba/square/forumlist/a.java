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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private LikeModel cdr;
    private final Map<Long, Integer> jaj = new HashMap();
    private View.OnClickListener mClickListener;
    private TbPageContext<SquareForumListActivity> mContext;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mPageType = i;
        this.cdr = new LikeModel(this.mContext);
        this.cdr.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (AntiHelper.aG(a.this.cdr.getErrorCode(), a.this.cdr.getErrorString())) {
                    AntiHelper.aJ(a.this.mContext.getPageActivity(), a.this.cdr.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.kc()) {
                        a.this.mContext.showToast(R.string.neterror);
                    } else if (bd.cF(a.this.mContext.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.cdr.el(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new an("c10587").bT("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10566").bT("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new an("c10586").P("obj_type", 1).bT("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c10565").P("obj_type", 1).bT("fid", valueOf4));
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
        if (this.jaj.containsKey(l)) {
            Integer num = this.jaj.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.jaj.put(l, valueOf);
        } else if (!this.jaj.containsKey(l)) {
            this.jaj.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.Z(this.mListData) > 0) {
            return v.Z(this.mListData) + 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: AQ */
    public ForumSpaceForumInfo getItem(int i) {
        if (getCount() > 1 && i != 0) {
            return (ForumSpaceForumInfo) v.c(this.mListData, i - 1);
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            am.c((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            am.l(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0410a)) {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0410a c0410a = new C0410a();
                c0410a.jal = (TextView) view.findViewById(R.id.forum_rank);
                c0410a.jam = (BarImageView) view.findViewById(R.id.forum_image);
                c0410a.jao = (TextView) view.findViewById(R.id.forum_like);
                c0410a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0410a.dpT = (TextView) view.findViewById(R.id.forum_desc);
                c0410a.jan = (TextView) view.findViewById(R.id.forum_value);
                l.b(this.mContext.getPageActivity(), c0410a.jao, 20, 20, 20, 20);
                c0410a.jao.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0410a);
            }
            am.k(view, R.drawable.square_list_item_bg_selector);
            C0410a c0410a2 = (C0410a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0410a2.jal.setText("");
                am.k(c0410a2.jal, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0410a2.jal.setText("");
                am.k(c0410a2.jal, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0410a2.jal.setText("");
                am.k(c0410a2.jal, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0410a2.jal.setText("0" + i);
                c0410a2.jal.setBackgroundResource(0);
            } else {
                c0410a2.jal.setText("" + i);
                c0410a2.jal.setBackgroundResource(0);
            }
            am.j(c0410a2.jal, R.color.cp_cont_c);
            c0410a2.jam.startLoad(item.avatar, 10, false);
            c0410a2.mTitle.setText(item.forum_name + this.mContext.getString(R.string.forum));
            am.j(c0410a2.mTitle, R.color.cp_cont_b);
            Integer num = this.jaj.get(item.forum_id);
            c0410a2.dpT.setText(this.mContext.getString(R.string.attention) + ":" + aq.aH((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.mContext.getString(R.string.text_post) + ":" + aq.aH(item.post_num.intValue()));
            am.j(c0410a2.dpT, R.color.cp_cont_d);
            c0410a2.jan.setText(item._abstract);
            am.j(c0410a2.jan, R.color.cp_cont_d);
            c0410a2.jao.setTag(R.id.forum_title, item.forum_name);
            c0410a2.jao.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.jaj.get(item.forum_id) == null ? 0 : this.jaj.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0410a2.jao.setText(R.string.relate_forum_is_followed);
                c0410a2.jao.setBackgroundResource(0);
                am.j(c0410a2.jao, R.color.cp_cont_d);
            } else {
                c0410a2.jao.setText(R.string.attention);
                c0410a2.jao.setBackgroundResource(R.drawable.btn_blue_bg);
                am.j(c0410a2.jao, R.color.cp_btn_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0410a {
        public TextView dpT;
        public TextView jal;
        public BarImageView jam;
        public TextView jan;
        public TextView jao;
        public TextView mTitle;

        private C0410a() {
        }
    }
}
