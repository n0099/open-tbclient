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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> cRe;
    private LikeModel dfN;
    private final Map<Long, Integer> kaN = new HashMap();
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.cRe = tbPageContext;
        this.mPageType = i;
        this.dfN = new LikeModel(this.cRe);
        this.dfN.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bc(a.this.dfN.getErrorCode(), a.this.dfN.getErrorString())) {
                    AntiHelper.bn(a.this.cRe.getPageActivity(), a.this.dfN.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.cRe.showToast(R.string.neterror);
                    } else if (bc.checkUpIsLogin(a.this.cRe.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.dfN.et(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new an("c10587").cp("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new an("c10566").cp("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cRe.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new an("c10586").Z("obj_type", 1).cp("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c10565").Z("obj_type", 1).cp("fid", valueOf4));
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
        if (this.kaN.containsKey(l)) {
            Integer num = this.kaN.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.kaN.put(l, valueOf);
        } else if (!this.kaN.containsKey(l)) {
            this.kaN.put(l, z ? 1 : -1);
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
    /* renamed from: Cd */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            am.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            am.setBackgroundColor(inflate, R.color.cp_bg_line_d);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0600a)) {
                view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0600a c0600a = new C0600a();
                c0600a.kaP = (TextView) view.findViewById(R.id.forum_rank);
                c0600a.kaQ = (BarImageView) view.findViewById(R.id.forum_image);
                c0600a.kaS = (TextView) view.findViewById(R.id.forum_like);
                c0600a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0600a.ejU = (TextView) view.findViewById(R.id.forum_desc);
                c0600a.kaR = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.cRe.getPageActivity(), c0600a.kaS, 20, 20, 20, 20);
                c0600a.kaS.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0600a);
            }
            am.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0600a c0600a2 = (C0600a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0600a2.kaP.setText("");
                am.setBackgroundResource(c0600a2.kaP, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0600a2.kaP.setText("");
                am.setBackgroundResource(c0600a2.kaP, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0600a2.kaP.setText("");
                am.setBackgroundResource(c0600a2.kaP, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0600a2.kaP.setText("0" + i);
                c0600a2.kaP.setBackgroundResource(0);
            } else {
                c0600a2.kaP.setText("" + i);
                c0600a2.kaP.setBackgroundResource(0);
            }
            am.setViewTextColor(c0600a2.kaP, (int) R.color.cp_cont_c);
            c0600a2.kaQ.startLoad(item.avatar, 10, false);
            c0600a2.mTitle.setText(item.forum_name + this.cRe.getString(R.string.forum));
            am.setViewTextColor(c0600a2.mTitle, (int) R.color.cp_cont_b);
            Integer num = this.kaN.get(item.forum_id);
            c0600a2.ejU.setText(this.cRe.getString(R.string.attention) + ":" + aq.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.cRe.getString(R.string.text_post) + ":" + aq.numberUniformFormat(item.post_num.intValue()));
            am.setViewTextColor(c0600a2.ejU, (int) R.color.cp_cont_d);
            c0600a2.kaR.setText(item._abstract);
            am.setViewTextColor(c0600a2.kaR, (int) R.color.cp_cont_d);
            c0600a2.kaS.setTag(R.id.forum_title, item.forum_name);
            c0600a2.kaS.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.kaN.get(item.forum_id) == null ? 0 : this.kaN.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0600a2.kaS.setText(R.string.relate_forum_is_followed);
                c0600a2.kaS.setBackgroundResource(0);
                am.setViewTextColor(c0600a2.kaS, (int) R.color.cp_cont_d);
            } else {
                c0600a2.kaS.setText(R.string.attention);
                c0600a2.kaS.setBackgroundResource(R.drawable.btn_blue_bg);
                am.setViewTextColor(c0600a2.kaS, (int) R.color.cp_cont_a);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0600a {
        public TextView ejU;
        public TextView kaP;
        public BarImageView kaQ;
        public TextView kaR;
        public TextView kaS;
        public TextView mTitle;

        private C0600a() {
        }
    }
}
