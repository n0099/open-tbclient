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
    private String bpw;
    private List<ForumInfo> hor;
    private ArrayList<Object> hos;
    private final Context mContext;
    private final boolean hnd = true;
    private LikeModel cer = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.hor = arrayList;
    }

    public void dr(List<ForumInfo> list) {
        this.hor = list;
        this.hos = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.hor.size()) {
                i = 0;
                break;
            } else if (this.hor.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.hos.addAll(this.hor);
        if (i > 0) {
            this.hos.add(i, "divider");
        }
        if (this.hor != null) {
            notifyDataSetChanged();
        }
    }

    public void AK(String str) {
        this.bpw = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hos == null || TextUtils.isEmpty(this.bpw)) {
            return 0;
        }
        return this.hos.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hos.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0373a c0373a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0373a = new C0373a();
                c0373a.hng = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0373a.hng.setGifIconSupport(false);
                c0373a.ccX = (TextView) view.findViewById(R.id.name);
                c0373a.hnh = (TextView) view.findViewById(R.id.forum_member_count);
                c0373a.hni = (TextView) view.findViewById(R.id.forum_thread_count);
                c0373a.mFollowBtn = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0373a);
            } else {
                c0373a = (C0373a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0373a.hng.setTag(str2);
                c0373a.hng.startLoad(str2, 15, false);
                c0373a.hng.invalidate();
                if (this.hnd) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                a(c0373a.ccX, str);
                c0373a.hng.setTag(forumInfo.avatar);
                c0373a.hnh.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0373a.hni.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                am.j(c0373a.hnh, R.color.cp_cont_d);
                am.j(c0373a.hni, R.color.cp_cont_d);
                am.j(c0373a.ccX, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0373a.mFollowBtn.setText(R.string.followed);
                    am.k(c0373a.mFollowBtn, 0);
                    am.j(c0373a.mFollowBtn, R.color.cp_cont_d);
                    c0373a.mFollowBtn.setOnClickListener(null);
                    return view;
                }
                c0373a.mFollowBtn.setText(R.string.attention);
                am.k(c0373a.mFollowBtn, R.drawable.search_like_btn_bg);
                am.j(c0373a.mFollowBtn, R.color.cp_link_tip_a);
                c0373a.mFollowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").bT("obj_type", "3").P("fid", forumInfo.forum_id.intValue()).n("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.cer.em(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.cer.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if (a.this.cer.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0373a.mFollowBtn.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0373a.mFollowBtn.setBackgroundDrawable(null);
                                am.j(c0373a.mFollowBtn, R.color.cp_cont_d);
                                c0373a.mFollowBtn.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bpw)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bpw.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bpw.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0373a {
        TextView ccX;
        BarImageView hng;
        TextView hnh;
        TextView hni;
        TextView mFollowBtn;

        private C0373a() {
        }
    }
}
