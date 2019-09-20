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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private LikeModel cer;
    private final Map<Long, Integer> jdI = new HashMap();
    private View.OnClickListener mClickListener;
    private TbPageContext<SquareForumListActivity> mContext;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mPageType = i;
        this.cer = new LikeModel(this.mContext);
        this.cer.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (AntiHelper.aG(a.this.cer.getErrorCode(), a.this.cer.getErrorString())) {
                    AntiHelper.aQ(a.this.mContext.getPageActivity(), a.this.cer.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.kc()) {
                        a.this.mContext.showToast(R.string.neterror);
                    } else if (bc.cF(a.this.mContext.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.cer.em(valueOf, valueOf2);
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
        if (this.jdI.containsKey(l)) {
            Integer num = this.jdI.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.jdI.put(l, valueOf);
        } else if (!this.jdI.containsKey(l)) {
            this.jdI.put(l, z ? 1 : -1);
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
    /* renamed from: AV */
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
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0421a)) {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0421a c0421a = new C0421a();
                c0421a.jdK = (TextView) view.findViewById(R.id.forum_rank);
                c0421a.jdL = (BarImageView) view.findViewById(R.id.forum_image);
                c0421a.jdN = (TextView) view.findViewById(R.id.forum_like);
                c0421a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0421a.drL = (TextView) view.findViewById(R.id.forum_desc);
                c0421a.jdM = (TextView) view.findViewById(R.id.forum_value);
                l.b(this.mContext.getPageActivity(), c0421a.jdN, 20, 20, 20, 20);
                c0421a.jdN.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0421a);
            }
            am.k(view, R.drawable.square_list_item_bg_selector);
            C0421a c0421a2 = (C0421a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0421a2.jdK.setText("");
                am.k(c0421a2.jdK, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0421a2.jdK.setText("");
                am.k(c0421a2.jdK, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0421a2.jdK.setText("");
                am.k(c0421a2.jdK, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0421a2.jdK.setText("0" + i);
                c0421a2.jdK.setBackgroundResource(0);
            } else {
                c0421a2.jdK.setText("" + i);
                c0421a2.jdK.setBackgroundResource(0);
            }
            am.j(c0421a2.jdK, R.color.cp_cont_c);
            c0421a2.jdL.startLoad(item.avatar, 10, false);
            c0421a2.mTitle.setText(item.forum_name + this.mContext.getString(R.string.forum));
            am.j(c0421a2.mTitle, R.color.cp_cont_b);
            Integer num = this.jdI.get(item.forum_id);
            c0421a2.drL.setText(this.mContext.getString(R.string.attention) + ":" + aq.aH((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.mContext.getString(R.string.text_post) + ":" + aq.aH(item.post_num.intValue()));
            am.j(c0421a2.drL, R.color.cp_cont_d);
            c0421a2.jdM.setText(item._abstract);
            am.j(c0421a2.jdM, R.color.cp_cont_d);
            c0421a2.jdN.setTag(R.id.forum_title, item.forum_name);
            c0421a2.jdN.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.jdI.get(item.forum_id) == null ? 0 : this.jdI.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0421a2.jdN.setText(R.string.relate_forum_is_followed);
                c0421a2.jdN.setBackgroundResource(0);
                am.j(c0421a2.jdN, R.color.cp_cont_d);
            } else {
                c0421a2.jdN.setText(R.string.attention);
                c0421a2.jdN.setBackgroundResource(R.drawable.btn_blue_bg);
                am.j(c0421a2.jdN, R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0421a {
        public TextView drL;
        public TextView jdK;
        public BarImageView jdL;
        public TextView jdM;
        public TextView jdN;
        public TextView mTitle;

        private C0421a() {
        }
    }
}
