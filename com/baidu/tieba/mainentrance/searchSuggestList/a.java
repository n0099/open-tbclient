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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String dhj;
    private List<ForumInfo> jhC;
    private ArrayList<Object> jhD;
    private final Context mContext;
    private final boolean jgo = true;
    private LikeModel dYI = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.jhC = arrayList;
    }

    public void dz(List<ForumInfo> list) {
        this.jhC = list;
        this.jhD = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.jhC.size()) {
                i = 0;
                break;
            } else if (this.jhC.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.jhD.addAll(this.jhC);
        if (i > 0) {
            this.jhD.add(i, "divider");
        }
        if (this.jhC != null) {
            notifyDataSetChanged();
        }
    }

    public void HG(String str) {
        this.dhj = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jhD == null || TextUtils.isEmpty(this.dhj)) {
            return 0;
        }
        return this.jhD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jhD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0670a c0670a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0670a = new C0670a();
                c0670a.jgr = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0670a.jgr.setGifIconSupport(false);
                c0670a.dWR = (TextView) view.findViewById(R.id.name);
                c0670a.jgs = (TextView) view.findViewById(R.id.forum_member_count);
                c0670a.jgt = (TextView) view.findViewById(R.id.forum_thread_count);
                c0670a.aQD = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0670a);
            } else {
                c0670a = (C0670a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0670a.jgr.setTag(str2);
                c0670a.jgr.startLoad(str2, 15, false);
                c0670a.jgr.invalidate();
                if (this.jgo) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0670a.dWR, str);
                c0670a.jgr.setTag(forumInfo.avatar);
                c0670a.jgs.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0670a.jgt.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                am.setViewTextColor(c0670a.jgs, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0670a.jgt, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0670a.dWR, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0670a.aQD.setText(R.string.followed);
                    am.setBackgroundResource(c0670a.aQD, 0);
                    am.setViewTextColor(c0670a.aQD, (int) R.color.cp_cont_d);
                    c0670a.aQD.setOnClickListener(null);
                    return view;
                }
                c0670a.aQD.setText(R.string.attention);
                am.setBackgroundResource(c0670a.aQD, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0670a.aQD, (int) R.color.cp_link_tip_a);
                c0670a.aQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").dh("obj_type", "3").ag("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.dYI.fq(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.dYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.dYI.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0670a.aQD.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0670a.aQD.setBackgroundDrawable(null);
                                am.setViewTextColor(c0670a.aQD, (int) R.color.cp_cont_d);
                                c0670a.aQD.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            am.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.cp_bg_line_c);
            return inflate;
        } else {
            return view;
        }
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dhj)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dhj.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dhj.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0670a {
        TextView aQD;
        TextView dWR;
        BarImageView jgr;
        TextView jgs;
        TextView jgt;

        private C0670a() {
        }
    }
}
