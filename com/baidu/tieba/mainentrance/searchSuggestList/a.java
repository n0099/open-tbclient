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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String bol;
    private List<ForumInfo> hfo;
    private ArrayList<Object> hfp;
    private final Context mContext;
    private final boolean hea = true;
    private LikeModel ccn = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.hfo = arrayList;
    }

    public void dq(List<ForumInfo> list) {
        this.hfo = list;
        this.hfp = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.hfo.size()) {
                i = 0;
                break;
            } else if (this.hfo.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.hfp.addAll(this.hfo);
        if (i > 0) {
            this.hfp.add(i, "divider");
        }
        if (this.hfo != null) {
            notifyDataSetChanged();
        }
    }

    public void zx(String str) {
        this.bol = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hfp == null || TextUtils.isEmpty(this.bol)) {
            return 0;
        }
        return this.hfp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hfp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0357a c0357a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0357a = new C0357a();
                c0357a.hed = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0357a.hed.setGifIconSupport(false);
                c0357a.caT = (TextView) view.findViewById(R.id.name);
                c0357a.hee = (TextView) view.findViewById(R.id.forum_member_count);
                c0357a.hef = (TextView) view.findViewById(R.id.forum_thread_count);
                c0357a.mFollowBtn = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0357a);
            } else {
                c0357a = (C0357a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0357a.hed.setTag(str2);
                c0357a.hed.startLoad(str2, 15, false);
                c0357a.hed.invalidate();
                if (this.hea) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                a(c0357a.caT, str);
                c0357a.hed.setTag(forumInfo.avatar);
                c0357a.hee.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0357a.hef.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                al.j(c0357a.hee, R.color.cp_cont_d);
                al.j(c0357a.hef, R.color.cp_cont_d);
                al.j(c0357a.caT, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0357a.mFollowBtn.setText(R.string.followed);
                    al.k(c0357a.mFollowBtn, 0);
                    al.j(c0357a.mFollowBtn, R.color.cp_cont_d);
                    c0357a.mFollowBtn.setOnClickListener(null);
                    return view;
                }
                c0357a.mFollowBtn.setText(R.string.attention);
                al.k(c0357a.mFollowBtn, R.drawable.search_like_btn_bg);
                al.j(c0357a.mFollowBtn, R.color.cp_link_tip_a);
                c0357a.mFollowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new am("c13371").bT("obj_type", "3").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.ccn.ek(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.ccn.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if (a.this.ccn.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0357a.mFollowBtn.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0357a.mFollowBtn.setBackgroundDrawable(null);
                                al.j(c0357a.mFollowBtn, R.color.cp_cont_d);
                                c0357a.mFollowBtn.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            al.l(inflate.findViewById(R.id.card_divider_top_margin), R.color.cp_bg_line_c);
            return inflate;
        } else {
            return view;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bol)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bol.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bol.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0357a {
        TextView caT;
        BarImageView hed;
        TextView hee;
        TextView hef;
        TextView mFollowBtn;

        private C0357a() {
        }
    }
}
