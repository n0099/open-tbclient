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
    private String cWd;
    private List<ForumInfo> iRK;
    private ArrayList<Object> iRL;
    private final Context mContext;
    private final boolean iQw = true;
    private LikeModel dKo = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.iRK = arrayList;
    }

    public void dA(List<ForumInfo> list) {
        this.iRK = list;
        this.iRL = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.iRK.size()) {
                i = 0;
                break;
            } else if (this.iRK.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.iRL.addAll(this.iRK);
        if (i > 0) {
            this.iRL.add(i, "divider");
        }
        if (this.iRK != null) {
            notifyDataSetChanged();
        }
    }

    public void FU(String str) {
        this.cWd = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iRL == null || TextUtils.isEmpty(this.cWd)) {
            return 0;
        }
        return this.iRL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.iRL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0599a c0599a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0599a = new C0599a();
                c0599a.iQz = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0599a.iQz.setGifIconSupport(false);
                c0599a.dIy = (TextView) view.findViewById(R.id.name);
                c0599a.iQA = (TextView) view.findViewById(R.id.forum_member_count);
                c0599a.iQB = (TextView) view.findViewById(R.id.forum_thread_count);
                c0599a.aKJ = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0599a);
            } else {
                c0599a = (C0599a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0599a.iQz.setTag(str2);
                c0599a.iQz.startLoad(str2, 15, false);
                c0599a.iQz.invalidate();
                if (this.iQw) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0599a.dIy, str);
                c0599a.iQz.setTag(forumInfo.avatar);
                c0599a.iQA.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0599a.iQB.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                am.setViewTextColor(c0599a.iQA, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0599a.iQB, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0599a.dIy, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0599a.aKJ.setText(R.string.followed);
                    am.setBackgroundResource(c0599a.aKJ, 0);
                    am.setViewTextColor(c0599a.aKJ, (int) R.color.cp_cont_d);
                    c0599a.aKJ.setOnClickListener(null);
                    return view;
                }
                c0599a.aKJ.setText(R.string.attention);
                am.setBackgroundResource(c0599a.aKJ, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0599a.aKJ, (int) R.color.cp_link_tip_a);
                c0599a.aKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").cI("obj_type", "3").af("fid", forumInfo.forum_id.intValue()).t("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.dKo.eP(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.dKo.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.dKo.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0599a.aKJ.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0599a.aKJ.setBackgroundDrawable(null);
                                am.setViewTextColor(c0599a.aKJ, (int) R.color.cp_cont_d);
                                c0599a.aKJ.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cWd)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cWd.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cWd.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0599a {
        TextView aKJ;
        TextView dIy;
        TextView iQA;
        TextView iQB;
        BarImageView iQz;

        private C0599a() {
        }
    }
}
