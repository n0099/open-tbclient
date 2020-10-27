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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes24.dex */
public class a extends BaseAdapter {
    private String dYu;
    private List<ForumInfo> kHc;
    private ArrayList<Object> kHd;
    private final Context mContext;
    private final boolean kFN = true;
    private LikeModel eTL = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.kHc = arrayList;
    }

    public void ew(List<ForumInfo> list) {
        this.kHc = list;
        this.kHd = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.kHc.size()) {
                i = 0;
                break;
            } else if (this.kHc.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.kHd.addAll(this.kHc);
        if (i > 0) {
            this.kHd.add(i, "divider");
        }
        if (this.kHc != null) {
            notifyDataSetChanged();
        }
    }

    public void NF(String str) {
        this.dYu = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kHd == null || TextUtils.isEmpty(this.dYu)) {
            return 0;
        }
        return this.kHd.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kHd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0775a c0775a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0775a = new C0775a();
                c0775a.kFQ = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0775a.kFQ.setGifIconSupport(false);
                c0775a.eRg = (TextView) view.findViewById(R.id.name);
                c0775a.kFR = (TextView) view.findViewById(R.id.forum_member_count);
                c0775a.kFS = (TextView) view.findViewById(R.id.forum_thread_count);
                c0775a.bhr = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0775a);
            } else {
                c0775a = (C0775a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0775a.kFQ.setTag(str2);
                c0775a.kFQ.startLoad(str2, 15, false);
                c0775a.kFQ.invalidate();
                if (this.kFN) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                d(c0775a.eRg, str);
                c0775a.kFQ.setTag(forumInfo.avatar);
                c0775a.kFR.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0775a.kFS.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0775a.kFR, R.color.cp_cont_d);
                ap.setViewTextColor(c0775a.kFS, R.color.cp_cont_d);
                ap.setViewTextColor(c0775a.eRg, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0775a.bhr.setText(R.string.followed);
                    ap.setBackgroundResource(c0775a.bhr, 0);
                    ap.setViewTextColor(c0775a.bhr, R.color.cp_cont_d);
                    c0775a.bhr.setOnClickListener(null);
                    return view;
                }
                c0775a.bhr.setText(R.string.attention);
                ap.setBackgroundResource(c0775a.bhr, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0775a.bhr, R.color.cp_link_tip_a);
                c0775a.bhr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new aq("c13371").dR("obj_type", "3").aj("fid", forumInfo.forum_id.intValue()).w("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.eTL.gp(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.eTL.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.eTL.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0775a.bhr.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0775a.bhr.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0775a.bhr, R.color.cp_cont_d);
                                c0775a.bhr.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            ap.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.cp_bg_line_c);
            return inflate;
        } else {
            return view;
        }
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dYu)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dYu.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dYu.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0775a {
        TextView bhr;
        TextView eRg;
        BarImageView kFQ;
        TextView kFR;
        TextView kFS;

        private C0775a() {
        }
    }
}
