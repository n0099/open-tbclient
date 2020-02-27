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
    private String cwU;
    private List<ForumInfo> ifT;
    private ArrayList<Object> ifU;
    private final Context mContext;
    private final boolean ieF = true;
    private LikeModel djT = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.ifT = arrayList;
    }

    public void dp(List<ForumInfo> list) {
        this.ifT = list;
        this.ifU = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.ifT.size()) {
                i = 0;
                break;
            } else if (this.ifT.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.ifU.addAll(this.ifT);
        if (i > 0) {
            this.ifU.add(i, "divider");
        }
        if (this.ifT != null) {
            notifyDataSetChanged();
        }
    }

    public void Em(String str) {
        this.cwU = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ifU == null || TextUtils.isEmpty(this.cwU)) {
            return 0;
        }
        return this.ifU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ifU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0560a c0560a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0560a = new C0560a();
                c0560a.ieI = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0560a.ieI.setGifIconSupport(false);
                c0560a.dib = (TextView) view.findViewById(R.id.name);
                c0560a.ieJ = (TextView) view.findViewById(R.id.forum_member_count);
                c0560a.ieK = (TextView) view.findViewById(R.id.forum_thread_count);
                c0560a.arB = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0560a);
            } else {
                c0560a = (C0560a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0560a.ieI.setTag(str2);
                c0560a.ieI.startLoad(str2, 15, false);
                c0560a.ieI.invalidate();
                if (this.ieF) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0560a.dib, str);
                c0560a.ieI.setTag(forumInfo.avatar);
                c0560a.ieJ.setText(this.mContext.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + forumInfo.concern_num);
                c0560a.ieK.setText(this.mContext.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + forumInfo.post_num);
                am.setViewTextColor(c0560a.ieJ, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0560a.ieK, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0560a.dib, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0560a.arB.setText(R.string.followed);
                    am.setBackgroundResource(c0560a.arB, 0);
                    am.setViewTextColor(c0560a.arB, (int) R.color.cp_cont_d);
                    c0560a.arB.setOnClickListener(null);
                    return view;
                }
                c0560a.arB.setText(R.string.attention);
                am.setBackgroundResource(c0560a.arB, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0560a.arB, (int) R.color.cp_link_tip_a);
                c0560a.arB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").cy("obj_type", "3").X("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.djT.eC(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.djT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.djT.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0560a.arB.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0560a.arB.setBackgroundDrawable(null);
                                am.setViewTextColor(c0560a.arB, (int) R.color.cp_cont_d);
                                c0560a.arB.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cwU)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cwU.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cwU.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0560a {
        TextView arB;
        TextView dib;
        BarImageView ieI;
        TextView ieJ;
        TextView ieK;

        private C0560a() {
        }
    }
}
