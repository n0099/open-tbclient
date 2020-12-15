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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private TbPageContext<SquareForumListActivity> eNx;
    private LikeModel fgf;
    private View.OnClickListener mClickListener;
    private List<ForumSpaceForumInfo> mListData;
    private int mPageType;
    private final Map<Long, Integer> ngR = new HashMap();

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.eNx = tbPageContext;
        this.mPageType = i;
        this.fgf = new LikeModel(this.eNx);
        this.fgf.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.forumlist.a.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (AntiHelper.bP(a.this.fgf.getErrorCode(), a.this.fgf.getErrorString())) {
                    AntiHelper.bn(a.this.eNx.getPageActivity(), a.this.fgf.getErrorString());
                }
            }
        });
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.forumlist.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.forum_like) {
                    if (!j.isNetWorkAvailable()) {
                        a.this.eNx.showToast(R.string.neterror);
                    } else if (bh.checkUpIsLogin(a.this.eNx.getPageActivity())) {
                        String valueOf = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                        String valueOf2 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                        a.this.fgf.gu(valueOf, valueOf2);
                        if (a.this.mPageType != 1) {
                            if (a.this.mPageType == 2) {
                                TiebaStatic.log(new ar("c10587").dY("fid", valueOf2));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ar("c10566").dY("fid", valueOf2));
                    }
                } else if (view.getId() != R.id.square_forum_list_image) {
                    String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    String valueOf4 = view.getTag(R.id.forum_desc) == null ? "" : String.valueOf(view.getTag(R.id.forum_desc));
                    a.this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eNx.getContext()).createNormalCfg(valueOf3, null)));
                    if (a.this.mPageType != 1) {
                        if (a.this.mPageType == 2) {
                            TiebaStatic.log(new ar("c10586").al("obj_type", 1).dY("fid", valueOf4));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new ar("c10565").al("obj_type", 1).dY("fid", valueOf4));
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
        if (this.ngR.containsKey(l)) {
            Integer num = this.ngR.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.ngR.put(l, valueOf);
        } else if (!this.ngR.containsKey(l)) {
            this.ngR.put(l, z ? 1 : -1);
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
    /* renamed from: KH */
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
            View inflate = (view == null || !(view instanceof TbImageView)) ? LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null) : view;
            ap.setImageResource((TbImageView) inflate, this.mPageType == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            ap.setBackgroundColor(inflate, R.color.CAM_X0201);
            return inflate;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag(R.id.forum_rank) instanceof C0866a)) {
                view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
                C0866a c0866a = new C0866a();
                c0866a.ngT = (TextView) view.findViewById(R.id.forum_rank);
                c0866a.ngU = (BarImageView) view.findViewById(R.id.forum_image);
                c0866a.ngW = (TextView) view.findViewById(R.id.forum_like);
                c0866a.mTitle = (TextView) view.findViewById(R.id.forum_title);
                c0866a.guj = (TextView) view.findViewById(R.id.forum_desc);
                c0866a.ngV = (TextView) view.findViewById(R.id.forum_value);
                l.addToParentArea(this.eNx.getPageActivity(), c0866a.ngW, 20, 20, 20, 20);
                c0866a.ngW.setOnClickListener(this.mClickListener);
                view.setOnClickListener(this.mClickListener);
                view.setTag(R.id.forum_rank, c0866a);
            }
            ap.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
            C0866a c0866a2 = (C0866a) view.getTag(R.id.forum_rank);
            if (i == 1) {
                c0866a2.ngT.setText("");
                ap.setBackgroundResource(c0866a2.ngT, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                c0866a2.ngT.setText("");
                ap.setBackgroundResource(c0866a2.ngT, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                c0866a2.ngT.setText("");
                ap.setBackgroundResource(c0866a2.ngT, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                c0866a2.ngT.setText("0" + i);
                c0866a2.ngT.setBackgroundResource(0);
            } else {
                c0866a2.ngT.setText("" + i);
                c0866a2.ngT.setBackgroundResource(0);
            }
            ap.setViewTextColor(c0866a2.ngT, R.color.CAM_X0108);
            c0866a2.ngU.startLoad(item.avatar, 10, false);
            c0866a2.mTitle.setText(item.forum_name + this.eNx.getString(R.string.forum));
            ap.setViewTextColor(c0866a2.mTitle, R.color.CAM_X0105);
            Integer num = this.ngR.get(item.forum_id);
            c0866a2.guj.setText(this.eNx.getString(R.string.attention) + ":" + au.numberUniformFormat((num == null ? 0 : num.intValue()) + item.like_num.intValue()) + "  " + this.eNx.getString(R.string.text_post) + ":" + au.numberUniformFormat(item.post_num.intValue()));
            ap.setViewTextColor(c0866a2.guj, R.color.CAM_X0109);
            c0866a2.ngV.setText(item._abstract);
            ap.setViewTextColor(c0866a2.ngV, R.color.CAM_X0109);
            c0866a2.ngW.setTag(R.id.forum_title, item.forum_name);
            c0866a2.ngW.setTag(R.id.forum_desc, item.forum_id);
            int intValue = this.ngR.get(item.forum_id) == null ? 0 : this.ngR.get(item.forum_id).intValue();
            if ((item.is_like.intValue() == 0 && intValue > 0) || (item.is_like.intValue() == 1 && intValue >= 0)) {
                c0866a2.ngW.setText(R.string.relate_forum_is_followed);
                c0866a2.ngW.setBackgroundResource(0);
                ap.setViewTextColor(c0866a2.ngW, R.color.CAM_X0109);
            } else {
                c0866a2.ngW.setText(R.string.attention);
                c0866a2.ngW.setBackgroundResource(R.drawable.btn_blue_bg);
                ap.setViewTextColor(c0866a2.ngW, R.color.CAM_X0101);
            }
            view.setTag(R.id.forum_title, item.forum_name);
            return view;
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.square.forumlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0866a {
        public TextView guj;
        public TextView mTitle;
        public TextView ngT;
        public BarImageView ngU;
        public TextView ngV;
        public TextView ngW;

        private C0866a() {
        }
    }
}
