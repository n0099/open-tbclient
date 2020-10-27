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
    private TbPageContext<SquareForumListActivity> eCn;
    private LikeModel eTL;
    private View.OnClickListener mClickListener;
    private final Map<Long, Integer> mLU = new HashMap();
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.eCn = tbPageContext;
        this.mPageType = i;
        this.eTL = new LikeModel(this.eCn);
        this.eTL.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bN(a.this.eTL.getErrorCode(), a.this.eTL.getErrorString())) {
                    AntiHelper.bm(a.this.eCn.getPageActivity(), a.this.eTL.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.eCn.showToast(R.string.neterror);
                    } else if (bg.checkUpIsLogin(a.this.eCn.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.eTL.gp(valueOf, valueOf2);
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
                    a.this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eCn.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new aq("c10586").aj("obj_type", 1).dR("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new aq("c10565").aj("obj_type", 1).dR("fid", valueOf4));
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
        if (this.mLU.containsKey(l)) {
            Integer num = this.mLU.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.mLU.put(l, valueOf);
        } else if (!this.mLU.containsKey(l)) {
            this.mLU.put(l, z ? 1 : -1);
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
    /* renamed from: Jc */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ap.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ap.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0833a)) {
                view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0833a c0833a = new C0833a();
                c0833a.mLW = (TextView) view.findViewById(R.id.forum_rank);
                c0833a.mLX = (BarImageView) view.findViewById(R.id.forum_image);
                c0833a.mLZ = (TextView) view.findViewById(R.id.forum_like);
                c0833a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0833a.ggD = (TextView) view.findViewById(R.id.forum_desc);
                c0833a.mLY = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.eCn.getPageActivity(), c0833a.mLZ, 20, 20, 20, 20);
                c0833a.mLZ.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0833a);
            }
            ap.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0833a c0833a2 = (C0833a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0833a2.mLW.setText("");
                ap.setBackgroundResource(c0833a2.mLW, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0833a2.mLW.setText("");
                ap.setBackgroundResource(c0833a2.mLW, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0833a2.mLW.setText("");
                ap.setBackgroundResource(c0833a2.mLW, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0833a2.mLW.setText("0" + i);
                c0833a2.mLW.setBackgroundResource(0);
            } else {
                c0833a2.mLW.setText("" + i);
                c0833a2.mLW.setBackgroundResource(0);
            }
            ap.setViewTextColor(c0833a2.mLW, R.color.cp_cont_c);
            c0833a2.mLX.startLoad(item.avatar, 10, false);
            c0833a2.mTitle.setText(item.forum_name + this.eCn.getString(R.string.forum));
            ap.setViewTextColor(c0833a2.mTitle, R.color.cp_cont_b);
            Integer num = this.mLU.get(item.forum_id);
            c0833a2.ggD.setText(this.eCn.getString(R.string.attention) + ":" + at.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.eCn.getString(R.string.text_post) + ":" + at.numberUniformFormat(item.post_num.intValue()));
            ap.setViewTextColor(c0833a2.ggD, R.color.cp_cont_d);
            c0833a2.mLY.setText(item._abstract);
            ap.setViewTextColor(c0833a2.mLY, R.color.cp_cont_d);
            c0833a2.mLZ.setTag(R.id.forum_title, item.forum_name);
            c0833a2.mLZ.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.mLU.get(item.forum_id) == null ? 0 : this.mLU.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0833a2.mLZ.setText(R.string.relate_forum_is_followed);
                c0833a2.mLZ.setBackgroundResource(0);
                ap.setViewTextColor(c0833a2.mLZ, R.color.cp_cont_d);
            } else {
                c0833a2.mLZ.setText(R.string.attention);
                c0833a2.mLZ.setBackgroundResource(R.drawable.btn_blue_bg);
                ap.setViewTextColor(c0833a2.mLZ, R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0833a {
        public TextView ggD;
        public TextView mLW;
        public BarImageView mLX;
        public TextView mLY;
        public TextView mLZ;
        public TextView mTitle;

        private C0833a() {
        }
    }
}
