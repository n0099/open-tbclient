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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
    private TbPageContext<SquareForumListActivity> dPv;
    private LikeModel egK;
    private final Map<Long, Integer> lAT = new HashMap();
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.dPv = tbPageContext;
        this.mPageType = i;
        this.egK = new LikeModel(this.dPv);
        this.egK.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bA(a.this.egK.getErrorCode(), a.this.egK.getErrorString())) {
                    AntiHelper.aX(a.this.dPv.getPageActivity(), a.this.egK.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.dPv.showToast(R.string.neterror);
                    } else if (be.checkUpIsLogin(a.this.dPv.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.egK.fx(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new ao("c10587").dk("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ao("c10566").dk("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dPv.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new ao("c10586").ag("obj_type", 1).dk("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new ao("c10565").ag("obj_type", 1).dk("fid", valueOf4));
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
        if (this.lAT.containsKey(l)) {
            Integer num = this.lAT.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.lAT.put(l, valueOf);
        } else if (!this.lAT.containsKey(l)) {
            this.lAT.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.getCount(this.mListData) > 0) {
            return w.getCount(this.mListData) + 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EI */
    public ForumSpaceForumInfo getItem(int i) {
        if (getCount() > 1 && i != 0) {
            return (ForumSpaceForumInfo) w.getItem(this.mListData, i - 1);
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            an.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            an.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0740a)) {
                view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0740a c0740a = new C0740a();
                c0740a.lAV = (TextView) view.findViewById(R.id.forum_rank);
                c0740a.lAW = (BarImageView) view.findViewById(R.id.forum_image);
                c0740a.lAY = (TextView) view.findViewById(R.id.forum_like);
                c0740a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0740a.fqq = (TextView) view.findViewById(R.id.forum_desc);
                c0740a.lAX = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.dPv.getPageActivity(), c0740a.lAY, 20, 20, 20, 20);
                c0740a.lAY.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0740a);
            }
            an.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0740a c0740a2 = (C0740a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0740a2.lAV.setText("");
                an.setBackgroundResource(c0740a2.lAV, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0740a2.lAV.setText("");
                an.setBackgroundResource(c0740a2.lAV, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0740a2.lAV.setText("");
                an.setBackgroundResource(c0740a2.lAV, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0740a2.lAV.setText("0" + i);
                c0740a2.lAV.setBackgroundResource(0);
            } else {
                c0740a2.lAV.setText("" + i);
                c0740a2.lAV.setBackgroundResource(0);
            }
            an.setViewTextColor(c0740a2.lAV, (int) R.color.cp_cont_c);
            c0740a2.lAW.startLoad(item.avatar, 10, false);
            c0740a2.mTitle.setText(item.forum_name + this.dPv.getString(R.string.forum));
            an.setViewTextColor(c0740a2.mTitle, (int) R.color.cp_cont_b);
            Integer num = this.lAT.get(item.forum_id);
            c0740a2.fqq.setText(this.dPv.getString(R.string.attention) + ":" + ar.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.dPv.getString(R.string.text_post) + ":" + ar.numberUniformFormat(item.post_num.intValue()));
            an.setViewTextColor(c0740a2.fqq, (int) R.color.cp_cont_d);
            c0740a2.lAX.setText(item._abstract);
            an.setViewTextColor(c0740a2.lAX, (int) R.color.cp_cont_d);
            c0740a2.lAY.setTag(R.id.forum_title, item.forum_name);
            c0740a2.lAY.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.lAT.get(item.forum_id) == null ? 0 : this.lAT.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0740a2.lAY.setText(R.string.relate_forum_is_followed);
                c0740a2.lAY.setBackgroundResource(0);
                an.setViewTextColor(c0740a2.lAY, (int) R.color.cp_cont_d);
            } else {
                c0740a2.lAY.setText(R.string.attention);
                c0740a2.lAY.setBackgroundResource(R.drawable.btn_blue_bg);
                an.setViewTextColor(c0740a2.lAY, (int) R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0740a {
        public TextView fqq;
        public TextView lAV;
        public BarImageView lAW;
        public TextView lAX;
        public TextView lAY;
        public TextView mTitle;

        private C0740a() {
        }
    }
}
