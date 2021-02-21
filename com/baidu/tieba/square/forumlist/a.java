package com.baidu.tieba.square.forumlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> eUY;
    private LikeModel fnw;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> nsa = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.eUY = tbPageContext;
        this.mPageType = i;
        this.fnw = new LikeModel(this.eUY);
        this.fnw.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (AntiHelper.bX(a.this.fnw.getErrorCode(), a.this.fnw.getErrorString())) {
                    AntiHelper.bq(a.this.eUY.getPageActivity(), a.this.fnw.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.eUY.showToast(R.string.neterror);
                    } else if (bh.checkUpIsLogin(a.this.eUY.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.fnw.gy(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new ar("c10587").dR("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ar("c10566").dR("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eUY.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new ar("c10586").ap("obj_type", 1).dR("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new ar("c10565").ap("obj_type", 1).dR("fid", valueOf4));
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
        if (this.nsa.containsKey(l)) {
            Integer num = this.nsa.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.nsa.put(l, valueOf);
        } else if (!this.nsa.containsKey(l)) {
            this.nsa.put(l, z ? 1 : -1);
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ap.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ap.setBackgroundColor(inflate, R.color.CAM_X0201);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0869a)) {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0869a c0869a = new C0869a();
                c0869a.nsc = (TextView) view.findViewById(R.id.forum_rank);
                c0869a.nsd = (BarImageView) view.findViewById(R.id.forum_image);
                c0869a.nsf = (TextView) view.findViewById(R.id.forum_like);
                c0869a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0869a.gDA = (TextView) view.findViewById(R.id.forum_desc);
                c0869a.nse = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.eUY.getPageActivity(), c0869a.nsf, 20, 20, 20, 20);
                c0869a.nsf.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0869a);
            }
            ap.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0869a c0869a2 = (C0869a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0869a2.nsc.setText("");
                ap.setBackgroundResource(c0869a2.nsc, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0869a2.nsc.setText("");
                ap.setBackgroundResource(c0869a2.nsc, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0869a2.nsc.setText("");
                ap.setBackgroundResource(c0869a2.nsc, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0869a2.nsc.setText("0" + i);
                c0869a2.nsc.setBackgroundResource(0);
            } else {
                c0869a2.nsc.setText("" + i);
                c0869a2.nsc.setBackgroundResource(0);
            }
            ap.setViewTextColor(c0869a2.nsc, R.color.CAM_X0108);
            c0869a2.nsd.startLoad(item.avatar, 10, false);
            c0869a2.mTitle.setText(item.forum_name + this.eUY.getString(R.string.forum));
            ap.setViewTextColor(c0869a2.mTitle, R.color.CAM_X0105);
            Integer num = this.nsa.get(item.forum_id);
            c0869a2.gDA.setText(this.eUY.getString(R.string.attention) + ":" + au.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.eUY.getString(R.string.text_post) + ":" + au.numberUniformFormat(item.post_num.intValue()));
            ap.setViewTextColor(c0869a2.gDA, R.color.CAM_X0109);
            c0869a2.nse.setText(item._abstract);
            ap.setViewTextColor(c0869a2.nse, R.color.CAM_X0109);
            c0869a2.nsf.setTag(R.id.forum_title, item.forum_name);
            c0869a2.nsf.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.nsa.get(item.forum_id) == null ? 0 : this.nsa.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0869a2.nsf.setText(R.string.relate_forum_is_followed);
                c0869a2.nsf.setBackgroundResource(0);
                ap.setViewTextColor(c0869a2.nsf, R.color.CAM_X0109);
            } else {
                c0869a2.nsf.setText(R.string.attention);
                c0869a2.nsf.setBackgroundResource(R.drawable.btn_blue_bg);
                ap.setViewTextColor(c0869a2.nsf, R.color.CAM_X0101);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0869a {
        public TextView gDA;
        public TextView mTitle;
        public TextView nsc;
        public BarImageView nsd;
        public TextView nse;
        public TextView nsf;

        private C0869a() {
        }
    }
}
