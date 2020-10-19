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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private LikeModel eLp;
    private TbPageContext<SquareForumListActivity> etO;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> mzk = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.etO = tbPageContext;
        this.mPageType = i;
        this.eLp = new LikeModel(this.etO);
        this.eLp.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bM(a.this.eLp.getErrorCode(), a.this.eLp.getErrorString())) {
                    AntiHelper.bk(a.this.etO.getPageActivity(), a.this.eLp.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.etO.showToast(R.string.neterror);
                    } else if (bg.checkUpIsLogin(a.this.etO.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.eLp.gk(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new aq("c10587").dK("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10566").dK("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.etO.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new aq("c10586").aj("obj_type", 1).dK("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new aq("c10565").aj("obj_type", 1).dK("fid", valueOf4));
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
        if (this.mzk.containsKey(l)) {
            Integer num = this.mzk.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.mzk.put(l, valueOf);
        } else if (!this.mzk.containsKey(l)) {
            this.mzk.put(l, z ? 1 : -1);
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
    /* renamed from: IK */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ap.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ap.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0818a)) {
                view = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0818a c0818a = new C0818a();
                c0818a.mzm = (TextView) view.findViewById(R.id.forum_rank);
                c0818a.mzn = (BarImageView) view.findViewById(R.id.forum_image);
                c0818a.mzp = (TextView) view.findViewById(R.id.forum_like);
                c0818a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0818a.fWz = (TextView) view.findViewById(R.id.forum_desc);
                c0818a.mzo = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.etO.getPageActivity(), c0818a.mzp, 20, 20, 20, 20);
                c0818a.mzp.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0818a);
            }
            ap.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0818a c0818a2 = (C0818a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0818a2.mzm.setText("");
                ap.setBackgroundResource(c0818a2.mzm, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0818a2.mzm.setText("");
                ap.setBackgroundResource(c0818a2.mzm, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0818a2.mzm.setText("");
                ap.setBackgroundResource(c0818a2.mzm, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0818a2.mzm.setText("0" + i);
                c0818a2.mzm.setBackgroundResource(0);
            } else {
                c0818a2.mzm.setText("" + i);
                c0818a2.mzm.setBackgroundResource(0);
            }
            ap.setViewTextColor(c0818a2.mzm, R.color.cp_cont_c);
            c0818a2.mzn.startLoad(item.avatar, 10, false);
            c0818a2.mTitle.setText(item.forum_name + this.etO.getString(R.string.forum));
            ap.setViewTextColor(c0818a2.mTitle, R.color.cp_cont_b);
            Integer num = this.mzk.get(item.forum_id);
            c0818a2.fWz.setText(this.etO.getString(R.string.attention) + ":" + at.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.etO.getString(R.string.text_post) + ":" + at.numberUniformFormat(item.post_num.intValue()));
            ap.setViewTextColor(c0818a2.fWz, R.color.cp_cont_d);
            c0818a2.mzo.setText(item._abstract);
            ap.setViewTextColor(c0818a2.mzo, R.color.cp_cont_d);
            c0818a2.mzp.setTag(R.id.forum_title, item.forum_name);
            c0818a2.mzp.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.mzk.get(item.forum_id) == null ? 0 : this.mzk.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0818a2.mzp.setText(R.string.relate_forum_is_followed);
                c0818a2.mzp.setBackgroundResource(0);
                ap.setViewTextColor(c0818a2.mzp, R.color.cp_cont_d);
            } else {
                c0818a2.mzp.setText(R.string.attention);
                c0818a2.mzp.setBackgroundResource(R.drawable.btn_blue_bg);
                ap.setViewTextColor(c0818a2.mzp, R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0818a {
        public TextView fWz;
        public TextView mTitle;
        public TextView mzm;
        public BarImageView mzn;
        public TextView mzo;
        public TextView mzp;

        private C0818a() {
        }
    }
}
