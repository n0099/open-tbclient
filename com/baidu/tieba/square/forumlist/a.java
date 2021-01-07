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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> eXu;
    private LikeModel fpO;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> nmw = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.eXu = tbPageContext;
        this.mPageType = i;
        this.fpO = new LikeModel(this.eXu);
        this.fpO.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (AntiHelper.bP(a.this.fpO.getErrorCode(), a.this.fpO.getErrorString())) {
                    AntiHelper.bs(a.this.eXu.getPageActivity(), a.this.fpO.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.eXu.showToast(R.string.neterror);
                    } else if (bg.checkUpIsLogin(a.this.eXu.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.fpO.gr(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new aq("c10587").dX("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10566").dX("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eXu.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new aq("c10586").an("obj_type", 1).dX("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new aq("c10565").an("obj_type", 1).dX("fid", valueOf4));
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
        if (this.nmw.containsKey(l)) {
            Integer num = this.nmw.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.nmw.put(l, valueOf);
        } else if (!this.nmw.containsKey(l)) {
            this.nmw.put(l, z ? 1 : -1);
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
    /* renamed from: KC */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ao.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ao.setBackgroundColor(inflate, R.color.CAM_X0201);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0881a)) {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0881a c0881a = new C0881a();
                c0881a.nmy = (TextView) view.findViewById(R.id.forum_rank);
                c0881a.nmz = (BarImageView) view.findViewById(R.id.forum_image);
                c0881a.nmB = (TextView) view.findViewById(R.id.forum_like);
                c0881a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0881a.gFi = (TextView) view.findViewById(R.id.forum_desc);
                c0881a.nmA = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.eXu.getPageActivity(), c0881a.nmB, 20, 20, 20, 20);
                c0881a.nmB.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0881a);
            }
            ao.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0881a c0881a2 = (C0881a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0881a2.nmy.setText("");
                ao.setBackgroundResource(c0881a2.nmy, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0881a2.nmy.setText("");
                ao.setBackgroundResource(c0881a2.nmy, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0881a2.nmy.setText("");
                ao.setBackgroundResource(c0881a2.nmy, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0881a2.nmy.setText("0" + i);
                c0881a2.nmy.setBackgroundResource(0);
            } else {
                c0881a2.nmy.setText("" + i);
                c0881a2.nmy.setBackgroundResource(0);
            }
            ao.setViewTextColor(c0881a2.nmy, R.color.CAM_X0108);
            c0881a2.nmz.startLoad(item.avatar, 10, false);
            c0881a2.mTitle.setText(item.forum_name + this.eXu.getString(R.string.forum));
            ao.setViewTextColor(c0881a2.mTitle, R.color.CAM_X0105);
            Integer num = this.nmw.get(item.forum_id);
            c0881a2.gFi.setText(this.eXu.getString(R.string.attention) + ":" + at.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.eXu.getString(R.string.text_post) + ":" + at.numberUniformFormat(item.post_num.intValue()));
            ao.setViewTextColor(c0881a2.gFi, R.color.CAM_X0109);
            c0881a2.nmA.setText(item._abstract);
            ao.setViewTextColor(c0881a2.nmA, R.color.CAM_X0109);
            c0881a2.nmB.setTag(R.id.forum_title, item.forum_name);
            c0881a2.nmB.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.nmw.get(item.forum_id) == null ? 0 : this.nmw.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0881a2.nmB.setText(R.string.relate_forum_is_followed);
                c0881a2.nmB.setBackgroundResource(0);
                ao.setViewTextColor(c0881a2.nmB, R.color.CAM_X0109);
            } else {
                c0881a2.nmB.setText(R.string.attention);
                c0881a2.nmB.setBackgroundResource(R.drawable.btn_blue_bg);
                ao.setViewTextColor(c0881a2.nmB, R.color.CAM_X0101);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0881a {
        public TextView gFi;
        public TextView mTitle;
        public TextView nmA;
        public TextView nmB;
        public TextView nmy;
        public BarImageView nmz;

        private C0881a() {
        }
    }
}
