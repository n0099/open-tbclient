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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> dVN;
    private LikeModel emT;
    private final Map<Long, Integer> lIk = new HashMap();
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.dVN = tbPageContext;
        this.mPageType = i;
        this.emT = new LikeModel(this.dVN);
        this.emT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bB(a.this.emT.getErrorCode(), a.this.emT.getErrorString())) {
                    AntiHelper.aW(a.this.dVN.getPageActivity(), a.this.emT.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.dVN.showToast(R.string.neterror);
                    } else if (bf.checkUpIsLogin(a.this.dVN.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.emT.fz(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new ap("c10587").dn("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ap("c10566").dn("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dVN.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new ap("c10586").ah("obj_type", 1).dn("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new ap("c10565").ah("obj_type", 1).dn("fid", valueOf4));
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
        if (this.lIk.containsKey(l)) {
            Integer num = this.lIk.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.lIk.put(l, valueOf);
        } else if (!this.lIk.containsKey(l)) {
            this.lIk.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.getCount(this.mListData) > 0) {
            return x.getCount(this.mListData) + 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Fe */
    public ForumSpaceForumInfo getItem(int i) {
        if (getCount() > 1 && i != 0) {
            return (ForumSpaceForumInfo) x.getItem(this.mListData, i - 1);
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ao.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ao.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0750a)) {
                view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0750a c0750a = new C0750a();
                c0750a.lIm = (TextView) view.findViewById(R.id.forum_rank);
                c0750a.lIn = (BarImageView) view.findViewById(R.id.forum_image);
                c0750a.lIp = (TextView) view.findViewById(R.id.forum_like);
                c0750a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0750a.fvA = (TextView) view.findViewById(R.id.forum_desc);
                c0750a.lIo = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.dVN.getPageActivity(), c0750a.lIp, 20, 20, 20, 20);
                c0750a.lIp.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0750a);
            }
            ao.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0750a c0750a2 = (C0750a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0750a2.lIm.setText("");
                ao.setBackgroundResource(c0750a2.lIm, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0750a2.lIm.setText("");
                ao.setBackgroundResource(c0750a2.lIm, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0750a2.lIm.setText("");
                ao.setBackgroundResource(c0750a2.lIm, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0750a2.lIm.setText("0" + i);
                c0750a2.lIm.setBackgroundResource(0);
            } else {
                c0750a2.lIm.setText("" + i);
                c0750a2.lIm.setBackgroundResource(0);
            }
            ao.setViewTextColor(c0750a2.lIm, R.color.cp_cont_c);
            c0750a2.lIn.startLoad(item.avatar, 10, false);
            c0750a2.mTitle.setText(item.forum_name + this.dVN.getString(R.string.forum));
            ao.setViewTextColor(c0750a2.mTitle, R.color.cp_cont_b);
            Integer num = this.lIk.get(item.forum_id);
            c0750a2.fvA.setText(this.dVN.getString(R.string.attention) + ":" + as.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.dVN.getString(R.string.text_post) + ":" + as.numberUniformFormat(item.post_num.intValue()));
            ao.setViewTextColor(c0750a2.fvA, R.color.cp_cont_d);
            c0750a2.lIo.setText(item._abstract);
            ao.setViewTextColor(c0750a2.lIo, R.color.cp_cont_d);
            c0750a2.lIp.setTag(R.id.forum_title, item.forum_name);
            c0750a2.lIp.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.lIk.get(item.forum_id) == null ? 0 : this.lIk.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0750a2.lIp.setText(R.string.relate_forum_is_followed);
                c0750a2.lIp.setBackgroundResource(0);
                ao.setViewTextColor(c0750a2.lIp, R.color.cp_cont_d);
            } else {
                c0750a2.lIp.setText(R.string.attention);
                c0750a2.lIp.setBackgroundResource(R.drawable.btn_blue_bg);
                ao.setViewTextColor(c0750a2.lIp, R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private class C0750a {
        public TextView fvA;
        public TextView lIm;
        public BarImageView lIn;
        public TextView lIo;
        public TextView lIp;
        public TextView mTitle;

        private C0750a() {
        }
    }
}
