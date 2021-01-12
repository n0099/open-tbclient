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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> eSJ;
    private LikeModel fle;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> nhR = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.eSJ = tbPageContext;
        this.mPageType = i;
        this.fle = new LikeModel(this.eSJ);
        this.fle.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (AntiHelper.bQ(a.this.fle.getErrorCode(), a.this.fle.getErrorString())) {
                    AntiHelper.bs(a.this.eSJ.getPageActivity(), a.this.fle.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.eSJ.showToast(R.string.neterror);
                    } else if (bg.checkUpIsLogin(a.this.eSJ.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.fle.gq(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new aq("c10587").dW("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10566").dW("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eSJ.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new aq("c10586").an("obj_type", 1).dW("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new aq("c10565").an("obj_type", 1).dW("fid", valueOf4));
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
        if (this.nhR.containsKey(l)) {
            Integer num = this.nhR.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.nhR.put(l, valueOf);
        } else if (!this.nhR.containsKey(l)) {
            this.nhR.put(l, z ? 1 : -1);
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
    /* renamed from: IV */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ao.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ao.setBackgroundColor(inflate, R.color.CAM_X0201);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0864a)) {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0864a c0864a = new C0864a();
                c0864a.nhT = (TextView) view.findViewById(R.id.forum_rank);
                c0864a.nhU = (BarImageView) view.findViewById(R.id.forum_image);
                c0864a.nhW = (TextView) view.findViewById(R.id.forum_like);
                c0864a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0864a.gAC = (TextView) view.findViewById(R.id.forum_desc);
                c0864a.nhV = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.eSJ.getPageActivity(), c0864a.nhW, 20, 20, 20, 20);
                c0864a.nhW.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0864a);
            }
            ao.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0864a c0864a2 = (C0864a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0864a2.nhT.setText("");
                ao.setBackgroundResource(c0864a2.nhT, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0864a2.nhT.setText("");
                ao.setBackgroundResource(c0864a2.nhT, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0864a2.nhT.setText("");
                ao.setBackgroundResource(c0864a2.nhT, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0864a2.nhT.setText("0" + i);
                c0864a2.nhT.setBackgroundResource(0);
            } else {
                c0864a2.nhT.setText("" + i);
                c0864a2.nhT.setBackgroundResource(0);
            }
            ao.setViewTextColor(c0864a2.nhT, R.color.CAM_X0108);
            c0864a2.nhU.startLoad(item.avatar, 10, false);
            c0864a2.mTitle.setText(item.forum_name + this.eSJ.getString(R.string.forum));
            ao.setViewTextColor(c0864a2.mTitle, R.color.CAM_X0105);
            Integer num = this.nhR.get(item.forum_id);
            c0864a2.gAC.setText(this.eSJ.getString(R.string.attention) + ":" + at.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.eSJ.getString(R.string.text_post) + ":" + at.numberUniformFormat(item.post_num.intValue()));
            ao.setViewTextColor(c0864a2.gAC, R.color.CAM_X0109);
            c0864a2.nhV.setText(item._abstract);
            ao.setViewTextColor(c0864a2.nhV, R.color.CAM_X0109);
            c0864a2.nhW.setTag(R.id.forum_title, item.forum_name);
            c0864a2.nhW.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.nhR.get(item.forum_id) == null ? 0 : this.nhR.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0864a2.nhW.setText(R.string.relate_forum_is_followed);
                c0864a2.nhW.setBackgroundResource(0);
                ao.setViewTextColor(c0864a2.nhW, R.color.CAM_X0109);
            } else {
                c0864a2.nhW.setText(R.string.attention);
                c0864a2.nhW.setBackgroundResource(R.drawable.btn_blue_bg);
                ao.setViewTextColor(c0864a2.nhW, R.color.CAM_X0101);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0864a {
        public TextView gAC;
        public TextView mTitle;
        public TextView nhT;
        public BarImageView nhU;
        public TextView nhV;
        public TextView nhW;

        private C0864a() {
        }
    }
}
