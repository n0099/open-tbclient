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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private String csH;
    private List<ForumInfo> iao;
    private ArrayList<Object> iap;
    private final Context mContext;
    private final boolean hZa = true;
    private LikeModel dfB = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.iao = arrayList;
    }

    public void dt(List<ForumInfo> list) {
        this.iao = list;
        this.iap = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.iao.size()) {
                i = 0;
                break;
            } else if (this.iao.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.iap.addAll(this.iao);
        if (i > 0) {
            this.iap.add(i, "divider");
        }
        if (this.iao != null) {
            notifyDataSetChanged();
        }
    }

    public void DM(String str) {
        this.csH = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iap == null || TextUtils.isEmpty(this.csH)) {
            return 0;
        }
        return this.iap.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.iap.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0548a c0548a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0548a = new C0548a();
                c0548a.hZd = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0548a.hZd.setGifIconSupport(false);
                c0548a.ddN = (TextView) view.findViewById(R.id.name);
                c0548a.hZe = (TextView) view.findViewById(R.id.forum_member_count);
                c0548a.hZf = (TextView) view.findViewById(R.id.forum_thread_count);
                c0548a.anw = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0548a);
            } else {
                c0548a = (C0548a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0548a.hZd.setTag(str2);
                c0548a.hZd.startLoad(str2, 15, false);
                c0548a.hZd.invalidate();
                if (this.hZa) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0548a.ddN, str);
                c0548a.hZd.setTag(forumInfo.avatar);
                c0548a.hZe.setText(this.mContext.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + forumInfo.concern_num);
                c0548a.hZf.setText(this.mContext.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + forumInfo.post_num);
                am.setViewTextColor(c0548a.hZe, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0548a.hZf, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0548a.ddN, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0548a.anw.setText(R.string.followed);
                    am.setBackgroundResource(c0548a.anw, 0);
                    am.setViewTextColor(c0548a.anw, (int) R.color.cp_cont_d);
                    c0548a.anw.setOnClickListener(null);
                    return view;
                }
                c0548a.anw.setText(R.string.attention);
                am.setBackgroundResource(c0548a.anw, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0548a.anw, (int) R.color.cp_link_tip_a);
                c0548a.anw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").cp("obj_type", "3").Z("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.dfB.er(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.dfB.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.dfB.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0548a.anw.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0548a.anw.setBackgroundDrawable(null);
                                am.setViewTextColor(c0548a.anw, (int) R.color.cp_cont_d);
                                c0548a.anw.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.csH)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.csH.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.csH.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0548a {
        TextView anw;
        TextView ddN;
        BarImageView hZd;
        TextView hZe;
        TextView hZf;

        private C0548a() {
        }
    }
}
