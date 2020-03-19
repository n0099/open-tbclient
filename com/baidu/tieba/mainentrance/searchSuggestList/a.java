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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String cxh;
    private List<ForumInfo> ihH;
    private ArrayList<Object> ihI;
    private final Context mContext;
    private final boolean igt = true;
    private LikeModel dku = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.ihH = arrayList;
    }

    public void dp(List<ForumInfo> list) {
        this.ihH = list;
        this.ihI = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.ihH.size()) {
                i = 0;
                break;
            } else if (this.ihH.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.ihI.addAll(this.ihH);
        if (i > 0) {
            this.ihI.add(i, "divider");
        }
        if (this.ihH != null) {
            notifyDataSetChanged();
        }
    }

    public void En(String str) {
        this.cxh = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ihI == null || TextUtils.isEmpty(this.cxh)) {
            return 0;
        }
        return this.ihI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ihI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0561a c0561a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0561a = new C0561a();
                c0561a.igw = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0561a.igw.setGifIconSupport(false);
                c0561a.diF = (TextView) view.findViewById(R.id.name);
                c0561a.igx = (TextView) view.findViewById(R.id.forum_member_count);
                c0561a.igy = (TextView) view.findViewById(R.id.forum_thread_count);
                c0561a.arM = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0561a);
            } else {
                c0561a = (C0561a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0561a.igw.setTag(str2);
                c0561a.igw.startLoad(str2, 15, false);
                c0561a.igw.invalidate();
                if (this.igt) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0561a.diF, str);
                c0561a.igw.setTag(forumInfo.avatar);
                c0561a.igx.setText(this.mContext.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + forumInfo.concern_num);
                c0561a.igy.setText(this.mContext.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + forumInfo.post_num);
                am.setViewTextColor(c0561a.igx, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0561a.igy, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0561a.diF, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0561a.arM.setText(R.string.followed);
                    am.setBackgroundResource(c0561a.arM, 0);
                    am.setViewTextColor(c0561a.arM, (int) R.color.cp_cont_d);
                    c0561a.arM.setOnClickListener(null);
                    return view;
                }
                c0561a.arM.setText(R.string.attention);
                am.setBackgroundResource(c0561a.arM, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0561a.arM, (int) R.color.cp_link_tip_a);
                c0561a.arM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").cx("obj_type", "3").X("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.dku.eA(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.dku.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.dku.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0561a.arM.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0561a.arM.setBackgroundDrawable(null);
                                am.setViewTextColor(c0561a.arM, (int) R.color.cp_cont_d);
                                c0561a.arM.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cxh)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cxh.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cxh.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0561a {
        TextView arM;
        TextView diF;
        BarImageView igw;
        TextView igx;
        TextView igy;

        private C0561a() {
        }
    }
}
