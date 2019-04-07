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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private LikeModel bUs;
    private final Map<Long, Integer> iAX = new HashMap();
    private View.OnClickListener mClickListener;
    private TbPageContext<SquareForumListActivity> mContext;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mPageType = i;
        this.bUs = new LikeModel(this.mContext);
        this.bUs.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (AntiHelper.aD(a.this.bUs.getErrorCode(), a.this.bUs.getErrorString())) {
                    AntiHelper.aU(a.this.mContext.getPageActivity(), a.this.bUs.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.forum_like) {
                    if (!j.kY()) {
                        a.this.mContext.showToast(d.j.neterror);
                    } else if (bc.cZ(a.this.mContext.getPageActivity())) {
                        String valueOf = view.getTag(d.g.forum_title) == null ? "" : String.valueOf(view.getTag(d.g.forum_title));
                        String valueOf2 = view.getTag(d.g.forum_desc) == null ? "" : String.valueOf(view.getTag(d.g.forum_desc));
                        a.this.bUs.dW(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new am("c10587").bJ(ImageViewerConfig.FORUM_ID, valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10566").bJ(ImageViewerConfig.FORUM_ID, valueOf2));
                    }
                } else if (view.getId() != d.g.square_forum_list_image) {
                    String valueOf3 = view.getTag(d.g.forum_title) == null ? "" : String.valueOf(view.getTag(d.g.forum_title));
                    String valueOf4 = view.getTag(d.g.forum_desc) == null ? "" : String.valueOf(view.getTag(d.g.forum_desc));
                    a.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new am("c10586").T("obj_type", 1).bJ(ImageViewerConfig.FORUM_ID, valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new am("c10565").T("obj_type", 1).bJ(ImageViewerConfig.FORUM_ID, valueOf4));
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
        if (this.iAX.containsKey(l)) {
            Integer num = this.iAX.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.iAX.put(l, valueOf);
        } else if (!this.iAX.containsKey(l)) {
            this.iAX.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.S(this.mListData) > 0) {
            return v.S(this.mListData) + 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zc */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_forum_list_header, (ViewGroup) null) : view;
            al.c((TbImageView) inflate, this.mPageType == 1 ? d.f.pic_batuijian_bg_red : d.f.pic_batuijian_bg_yellow);
            al.l(inflate, d.C0277d.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(d.g.forum_rank) instanceof C0386a)) {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_forum_list_item, (ViewGroup) null);
                C0386a c0386a = new C0386a();
                c0386a.iAZ = (TextView) view.findViewById(d.g.forum_rank);
                c0386a.iBa = (BarImageView) view.findViewById(d.g.forum_image);
                c0386a.iBd = (TextView) view.findViewById(d.g.forum_like);
                c0386a.mTitle = (TextView) view.findViewById(d.g.forum_title);
                c0386a.iBb = (TextView) view.findViewById(d.g.forum_desc);
                c0386a.iBc = (TextView) view.findViewById(d.g.forum_value);
                l.b(this.mContext.getPageActivity(), c0386a.iBd, 20, 20, 20, 20);
                c0386a.iBd.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(d.g.forum_rank, c0386a);
            }
            al.k(view, d.f.square_list_item_bg_selector);
            C0386a c0386a2 = (C0386a) view.getTag(d.g.forum_rank);
            if (i == 1) {
                c0386a2.iAZ.setText("");
                al.k(c0386a2.iAZ, d.f.icon_grade_shaitu1);
            } else if (i == 2) {
                c0386a2.iAZ.setText("");
                al.k(c0386a2.iAZ, d.f.icon_grade_shaitu2);
            } else if (i == 3) {
                c0386a2.iAZ.setText("");
                al.k(c0386a2.iAZ, d.f.icon_grade_shaitu3);
            } else if (i < 10) {
                c0386a2.iAZ.setText("0" + i);
                c0386a2.iAZ.setBackgroundResource(0);
            } else {
                c0386a2.iAZ.setText("" + i);
                c0386a2.iAZ.setBackgroundResource(0);
            }
            al.j(c0386a2.iAZ, d.C0277d.cp_cont_c);
            c0386a2.iBa.startLoad(item.avatar, 10, false);
            c0386a2.mTitle.setText(item.forum_name + this.mContext.getString(d.j.forum));
            al.j(c0386a2.mTitle, d.C0277d.cp_cont_b);
            Integer num = this.iAX.get(item.forum_id);
            c0386a2.iBb.setText(this.mContext.getString(d.j.attention) + Config.TRACE_TODAY_VISIT_SPLIT + ap.as((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.mContext.getString(d.j.text_post) + Config.TRACE_TODAY_VISIT_SPLIT + ap.as(item.post_num.intValue()));
            al.j(c0386a2.iBb, d.C0277d.cp_cont_d);
            c0386a2.iBc.setText(item._abstract);
            al.j(c0386a2.iBc, d.C0277d.cp_cont_d);
            c0386a2.iBd.setTag(d.g.forum_title, item.forum_name);
            c0386a2.iBd.setTag(d.g.forum_desc, item.forum_id);
            int intValue = this.iAX.get(item.forum_id) == null ? 0 : this.iAX.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0386a2.iBd.setText(d.j.relate_forum_is_followed);
                c0386a2.iBd.setBackgroundResource(0);
                al.j(c0386a2.iBd, d.C0277d.cp_cont_d);
            } else {
                c0386a2.iBd.setText(d.j.attention);
                c0386a2.iBd.setBackgroundResource(d.f.btn_blue_bg);
                al.j(c0386a2.iBd, d.C0277d.cp_btn_a);
            }
            view.setTag(d.g.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0386a {
        public TextView iAZ;
        public BarImageView iBa;
        public TextView iBb;
        public TextView iBc;
        public TextView iBd;
        public TextView mTitle;

        private C0386a() {
        }
    }
}
