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
    private TbPageContext<SquareForumListActivity> cVg;
    private LikeModel djT;
    private final Map<Long, Integer> kbM = new HashMap();
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.cVg = tbPageContext;
        this.mPageType = i;
        this.djT = new LikeModel(this.cVg);
        this.djT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bb(a.this.djT.getErrorCode(), a.this.djT.getErrorString())) {
                    AntiHelper.bn(a.this.cVg.getPageActivity(), a.this.djT.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.cVg.showToast(R.string.neterror);
                    } else if (bc.checkUpIsLogin(a.this.cVg.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.djT.eC(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new an("c10587").cy("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10566").cy("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVg.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new an("c10586").X("obj_type", 1).cy("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c10565").X("obj_type", 1).cy("fid", valueOf4));
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
        if (this.kbM.containsKey(l)) {
            Integer num = this.kbM.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.kbM.put(l, valueOf);
        } else if (!this.kbM.containsKey(l)) {
            this.kbM.put(l, z ? 1 : -1);
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
    /* renamed from: Ck */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            am.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            am.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0607a)) {
                view = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0607a c0607a = new C0607a();
                c0607a.kbO = (TextView) view.findViewById(R.id.forum_rank);
                c0607a.kbP = (BarImageView) view.findViewById(R.id.forum_image);
                c0607a.kbR = (TextView) view.findViewById(R.id.forum_like);
                c0607a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0607a.eoe = (TextView) view.findViewById(R.id.forum_desc);
                c0607a.kbQ = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.cVg.getPageActivity(), c0607a.kbR, 20, 20, 20, 20);
                c0607a.kbR.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0607a);
            }
            am.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0607a c0607a2 = (C0607a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0607a2.kbO.setText("");
                am.setBackgroundResource(c0607a2.kbO, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0607a2.kbO.setText("");
                am.setBackgroundResource(c0607a2.kbO, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0607a2.kbO.setText("");
                am.setBackgroundResource(c0607a2.kbO, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0607a2.kbO.setText("0" + i);
                c0607a2.kbO.setBackgroundResource(0);
            } else {
                c0607a2.kbO.setText("" + i);
                c0607a2.kbO.setBackgroundResource(0);
            }
            am.setViewTextColor(c0607a2.kbO, (int) R.color.cp_cont_c);
            c0607a2.kbP.startLoad(item.avatar, 10, false);
            c0607a2.mTitle.setText(item.forum_name + this.cVg.getString(R.string.forum));
            am.setViewTextColor(c0607a2.mTitle, (int) R.color.cp_cont_b);
            Integer num = this.kbM.get(item.forum_id);
            c0607a2.eoe.setText(this.cVg.getString(R.string.attention) + ":" + aq.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.cVg.getString(R.string.text_post) + ":" + aq.numberUniformFormat(item.post_num.intValue()));
            am.setViewTextColor(c0607a2.eoe, (int) R.color.cp_cont_d);
            c0607a2.kbQ.setText(item._abstract);
            am.setViewTextColor(c0607a2.kbQ, (int) R.color.cp_cont_d);
            c0607a2.kbR.setTag(R.id.forum_title, item.forum_name);
            c0607a2.kbR.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.kbM.get(item.forum_id) == null ? 0 : this.kbM.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0607a2.kbR.setText(R.string.relate_forum_is_followed);
                c0607a2.kbR.setBackgroundResource(0);
                am.setViewTextColor(c0607a2.kbR, (int) R.color.cp_cont_d);
            } else {
                c0607a2.kbR.setText(R.string.attention);
                c0607a2.kbR.setBackgroundResource(R.drawable.btn_blue_bg);
                am.setViewTextColor(c0607a2.kbR, (int) R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0607a {
        public TextView eoe;
        public TextView kbO;
        public BarImageView kbP;
        public TextView kbQ;
        public TextView kbR;
        public TextView mTitle;

        private C0607a() {
        }
    }
}
