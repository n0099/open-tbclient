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
    private TbPageContext<SquareForumListActivity> eIc;
    private LikeModel eZA;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> mRS = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.eIc = tbPageContext;
        this.mPageType = i;
        this.eZA = new LikeModel(this.eIc);
        this.eZA.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bR(a.this.eZA.getErrorCode(), a.this.eZA.getErrorString())) {
                    AntiHelper.bm(a.this.eIc.getPageActivity(), a.this.eZA.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.eIc.showToast(R.string.neterror);
                    } else if (bg.checkUpIsLogin(a.this.eIc.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.eZA.gp(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new aq("c10587").dR("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10566").dR("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eIc.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new aq("c10586").al("obj_type", 1).dR("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new aq("c10565").al("obj_type", 1).dR("fid", valueOf4));
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
        if (this.mRS.containsKey(l)) {
            Integer num = this.mRS.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.mRS.put(l, valueOf);
        } else if (!this.mRS.containsKey(l)) {
            this.mRS.put(l, z ? 1 : -1);
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
    /* renamed from: Jp */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ap.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ap.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0848a)) {
                view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0848a c0848a = new C0848a();
                c0848a.mRU = (TextView) view.findViewById(R.id.forum_rank);
                c0848a.mRV = (BarImageView) view.findViewById(R.id.forum_image);
                c0848a.mRX = (TextView) view.findViewById(R.id.forum_like);
                c0848a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0848a.gmr = (TextView) view.findViewById(R.id.forum_desc);
                c0848a.mRW = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.eIc.getPageActivity(), c0848a.mRX, 20, 20, 20, 20);
                c0848a.mRX.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0848a);
            }
            ap.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0848a c0848a2 = (C0848a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0848a2.mRU.setText("");
                ap.setBackgroundResource(c0848a2.mRU, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0848a2.mRU.setText("");
                ap.setBackgroundResource(c0848a2.mRU, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0848a2.mRU.setText("");
                ap.setBackgroundResource(c0848a2.mRU, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0848a2.mRU.setText("0" + i);
                c0848a2.mRU.setBackgroundResource(0);
            } else {
                c0848a2.mRU.setText("" + i);
                c0848a2.mRU.setBackgroundResource(0);
            }
            ap.setViewTextColor(c0848a2.mRU, R.color.cp_cont_c);
            c0848a2.mRV.startLoad(item.avatar, 10, false);
            c0848a2.mTitle.setText(item.forum_name + this.eIc.getString(R.string.forum));
            ap.setViewTextColor(c0848a2.mTitle, R.color.cp_cont_b);
            Integer num = this.mRS.get(item.forum_id);
            c0848a2.gmr.setText(this.eIc.getString(R.string.attention) + ":" + at.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.eIc.getString(R.string.text_post) + ":" + at.numberUniformFormat(item.post_num.intValue()));
            ap.setViewTextColor(c0848a2.gmr, R.color.cp_cont_d);
            c0848a2.mRW.setText(item._abstract);
            ap.setViewTextColor(c0848a2.mRW, R.color.cp_cont_d);
            c0848a2.mRX.setTag(R.id.forum_title, item.forum_name);
            c0848a2.mRX.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.mRS.get(item.forum_id) == null ? 0 : this.mRS.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0848a2.mRX.setText(R.string.relate_forum_is_followed);
                c0848a2.mRX.setBackgroundResource(0);
                ap.setViewTextColor(c0848a2.mRX, R.color.cp_cont_d);
            } else {
                c0848a2.mRX.setText(R.string.attention);
                c0848a2.mRX.setBackgroundResource(R.drawable.btn_blue_bg);
                ap.setViewTextColor(c0848a2.mRX, R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0848a {
        public TextView gmr;
        public TextView mRU;
        public BarImageView mRV;
        public TextView mRW;
        public TextView mRX;
        public TextView mTitle;

        private C0848a() {
        }
    }
}
