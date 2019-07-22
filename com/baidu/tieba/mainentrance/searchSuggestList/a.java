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
    private List<ForumInfo> hlF;
    private ArrayList<Object> hlG;
    private final Context mContext;
    private final boolean hkr = true;
    private LikeModel cdr = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.hlF = arrayList;
    }

    public void ds(List<ForumInfo> list) {
        this.hlF = list;
        this.hlG = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.hlF.size()) {
                i = 0;
                break;
            } else if (this.hlF.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.hlG.addAll(this.hlF);
        if (i > 0) {
            this.hlG.add(i, "divider");
        }
        if (this.hlF != null) {
            notifyDataSetChanged();
        }
    }

    public void Ak(String str) {
        this.boY = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlG == null || TextUtils.isEmpty(this.boY)) {
            return 0;
        }
        return this.hlG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hlG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0356a c0356a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0356a = new C0356a();
                c0356a.hku = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0356a.hku.setGifIconSupport(false);
                c0356a.cbW = (TextView) view.findViewById(R.id.name);
                c0356a.hkv = (TextView) view.findViewById(R.id.forum_member_count);
                c0356a.hkw = (TextView) view.findViewById(R.id.forum_thread_count);
                c0356a.mFollowBtn = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0356a);
            } else {
                c0356a = (C0356a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0356a.hku.setTag(str2);
                c0356a.hku.startLoad(str2, 15, false);
                c0356a.hku.invalidate();
                if (this.hkr) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                a(c0356a.cbW, str);
                c0356a.hku.setTag(forumInfo.avatar);
                c0356a.hkv.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0356a.hkw.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                am.j(c0356a.hkv, R.color.cp_cont_d);
                am.j(c0356a.hkw, R.color.cp_cont_d);
                am.j(c0356a.cbW, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0356a.mFollowBtn.setText(R.string.followed);
                    am.k(c0356a.mFollowBtn, 0);
                    am.j(c0356a.mFollowBtn, R.color.cp_cont_d);
                    c0356a.mFollowBtn.setOnClickListener(null);
                    return view;
                }
                c0356a.mFollowBtn.setText(R.string.attention);
                am.k(c0356a.mFollowBtn, R.drawable.search_like_btn_bg);
                am.j(c0356a.mFollowBtn, R.color.cp_link_tip_a);
                c0356a.mFollowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").bT("obj_type", "3").P("fid", forumInfo.forum_id.intValue()).l("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.cdr.el(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.cdr.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if (a.this.cdr.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0356a.mFollowBtn.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0356a.mFollowBtn.setBackgroundDrawable(null);
                                am.j(c0356a.mFollowBtn, R.color.cp_cont_d);
                                c0356a.mFollowBtn.setOnClickListener(null);
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
    private class C0356a {
        TextView cbW;
        BarImageView hku;
        TextView hkv;
        TextView hkw;
        TextView mFollowBtn;

        private C0356a() {
        }
    }
}
