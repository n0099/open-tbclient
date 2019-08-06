package com.baidu.tieba.mainentrance.searchSuggestList;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String boY;
    private List<ForumInfo> hmx;
    private ArrayList<Object> hmy;
    private final Context mContext;
    private final boolean hlj = true;
    private LikeModel cdy = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.hmx = arrayList;
    }

    public void dr(List<ForumInfo> list) {
        this.hmx = list;
        this.hmy = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.hmx.size()) {
                i = 0;
                break;
            } else if (this.hmx.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.hmy.addAll(this.hmx);
        if (i > 0) {
            this.hmy.add(i, "divider");
        }
        if (this.hmx != null) {
            notifyDataSetChanged();
        }
    }

    public void Al(String str) {
        this.boY = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmy == null || TextUtils.isEmpty(this.boY)) {
            return 0;
        }
        return this.hmy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hmy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0362a c0362a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0362a = new C0362a();
                c0362a.hlm = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0362a.hlm.setGifIconSupport(false);
                c0362a.ccd = (TextView) view.findViewById(R.id.name);
                c0362a.hln = (TextView) view.findViewById(R.id.forum_member_count);
                c0362a.hlo = (TextView) view.findViewById(R.id.forum_thread_count);
                c0362a.mFollowBtn = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0362a);
            } else {
                c0362a = (C0362a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0362a.hlm.setTag(str2);
                c0362a.hlm.startLoad(str2, 15, false);
                c0362a.hlm.invalidate();
                if (this.hlj) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                a(c0362a.ccd, str);
                c0362a.hlm.setTag(forumInfo.avatar);
                c0362a.hln.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0362a.hlo.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                am.j(c0362a.hln, R.color.cp_cont_d);
                am.j(c0362a.hlo, R.color.cp_cont_d);
                am.j(c0362a.ccd, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0362a.mFollowBtn.setText(R.string.followed);
                    am.k(c0362a.mFollowBtn, 0);
                    am.j(c0362a.mFollowBtn, R.color.cp_cont_d);
                    c0362a.mFollowBtn.setOnClickListener(null);
                    return view;
                }
                c0362a.mFollowBtn.setText(R.string.attention);
                am.k(c0362a.mFollowBtn, R.drawable.search_like_btn_bg);
                am.j(c0362a.mFollowBtn, R.color.cp_link_tip_a);
                c0362a.mFollowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").bT("obj_type", "3").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.cdy.el(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.cdy.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if (a.this.cdy.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0362a.mFollowBtn.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0362a.mFollowBtn.setBackgroundDrawable(null);
                                am.j(c0362a.mFollowBtn, R.color.cp_cont_d);
                                c0362a.mFollowBtn.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            am.l(inflate.findViewById(R.id.card_divider_top_margin), R.color.cp_bg_line_c);
            return inflate;
        } else {
            return view;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.boY)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.boY.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.boY.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0362a {
        TextView ccd;
        BarImageView hlm;
        TextView hln;
        TextView hlo;
        TextView mFollowBtn;

        private C0362a() {
        }
    }
}
