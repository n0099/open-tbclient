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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    private LikeModel ccn;
    private final Map<Long, Integer> iTM = new HashMap();
    private View.OnClickListener mClickListener;
    private TbPageContext<SquareForumListActivity> mContext;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mPageType = i;
        this.ccn = new LikeModel(this.mContext);
        this.ccn.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (AntiHelper.aG(a.this.ccn.getErrorCode(), a.this.ccn.getErrorString())) {
                    AntiHelper.aI(a.this.mContext.getPageActivity(), a.this.ccn.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.jS()) {
                        a.this.mContext.showToast(R.string.neterror);
                    } else if (bc.cE(a.this.mContext.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.ccn.ek(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new am("c10587").bT("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10566").bT("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new am("c10586").P("obj_type", 1).bT("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new am("c10565").P("obj_type", 1).bT("fid", valueOf4));
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
        if (this.iTM.containsKey(l)) {
            Integer num = this.iTM.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.iTM.put(l, valueOf);
        } else if (!this.iTM.containsKey(l)) {
            this.iTM.put(l, z ? 1 : -1);
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
    /* renamed from: Ak */
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
            al.c((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            al.l(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0405a)) {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0405a c0405a = new C0405a();
                c0405a.iTO = (TextView) view.findViewById(R.id.forum_rank);
                c0405a.iTP = (BarImageView) view.findViewById(R.id.forum_image);
                c0405a.iTS = (TextView) view.findViewById(R.id.forum_like);
                c0405a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0405a.iTQ = (TextView) view.findViewById(R.id.forum_desc);
                c0405a.iTR = (TextView) view.findViewById(R.id.forum_value);
                l.b(this.mContext.getPageActivity(), c0405a.iTS, 20, 20, 20, 20);
                c0405a.iTS.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0405a);
            }
            al.k(view, R.drawable.square_list_item_bg_selector);
            C0405a c0405a2 = (C0405a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0405a2.iTO.setText("");
                al.k(c0405a2.iTO, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0405a2.iTO.setText("");
                al.k(c0405a2.iTO, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0405a2.iTO.setText("");
                al.k(c0405a2.iTO, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0405a2.iTO.setText("0" + i);
                c0405a2.iTO.setBackgroundResource(0);
            } else {
                c0405a2.iTO.setText("" + i);
                c0405a2.iTO.setBackgroundResource(0);
            }
            al.j(c0405a2.iTO, R.color.cp_cont_c);
            c0405a2.iTP.startLoad(item.avatar, 10, false);
            c0405a2.mTitle.setText(item.forum_name + this.mContext.getString(R.string.forum));
            al.j(c0405a2.mTitle, R.color.cp_cont_b);
            Integer num = this.iTM.get(item.forum_id);
            c0405a2.iTQ.setText(this.mContext.getString(R.string.attention) + ":" + ap.aG((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.mContext.getString(R.string.text_post) + ":" + ap.aG(item.post_num.intValue()));
            al.j(c0405a2.iTQ, R.color.cp_cont_d);
            c0405a2.iTR.setText(item._abstract);
            al.j(c0405a2.iTR, R.color.cp_cont_d);
            c0405a2.iTS.setTag(R.id.forum_title, item.forum_name);
            c0405a2.iTS.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.iTM.get(item.forum_id) == null ? 0 : this.iTM.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0405a2.iTS.setText(R.string.relate_forum_is_followed);
                c0405a2.iTS.setBackgroundResource(0);
                al.j(c0405a2.iTS, R.color.cp_cont_d);
            } else {
                c0405a2.iTS.setText(R.string.attention);
                c0405a2.iTS.setBackgroundResource(R.drawable.btn_blue_bg);
                al.j(c0405a2.iTS, R.color.cp_btn_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0405a {
        public TextView iTO;
        public BarImageView iTP;
        public TextView iTQ;
        public TextView iTR;
        public TextView iTS;
        public TextView mTitle;

        private C0405a() {
        }
    }
}
