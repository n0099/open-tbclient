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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String bHr;
    private List<ForumInfo> hmo;
    private ArrayList<Object> hmp;
    private final Context mContext;
    private final boolean hkZ = true;
    private LikeModel crO = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.hmo = arrayList;
    }

    public void dE(List<ForumInfo> list) {
        this.hmo = list;
        this.hmp = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.hmo.size()) {
                i = 0;
                break;
            } else if (this.hmo.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.hmp.addAll(this.hmo);
        if (i > 0) {
            this.hmp.add(i, "divider");
        }
        if (this.hmo != null) {
            notifyDataSetChanged();
        }
    }

    public void ze(String str) {
        this.bHr = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmp == null || TextUtils.isEmpty(this.bHr)) {
            return 0;
        }
        return this.hmp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hmp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0467a c0467a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0467a = new C0467a();
                c0467a.hlc = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0467a.hlc.setGifIconSupport(false);
                c0467a.cqt = (TextView) view.findViewById(R.id.name);
                c0467a.hld = (TextView) view.findViewById(R.id.forum_member_count);
                c0467a.hle = (TextView) view.findViewById(R.id.forum_thread_count);
                c0467a.afu = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0467a);
            } else {
                c0467a = (C0467a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0467a.hlc.setTag(str2);
                c0467a.hlc.startLoad(str2, 15, false);
                c0467a.hlc.invalidate();
                if (this.hkZ) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                b(c0467a.cqt, str);
                c0467a.hlc.setTag(forumInfo.avatar);
                c0467a.hld.setText(this.mContext.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + forumInfo.concern_num);
                c0467a.hle.setText(this.mContext.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + forumInfo.post_num);
                am.setViewTextColor(c0467a.hld, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0467a.hle, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0467a.cqt, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0467a.afu.setText(R.string.followed);
                    am.setBackgroundResource(c0467a.afu, 0);
                    am.setViewTextColor(c0467a.afu, (int) R.color.cp_cont_d);
                    c0467a.afu.setOnClickListener(null);
                    return view;
                }
                c0467a.afu.setText(R.string.attention);
                am.setBackgroundResource(c0467a.afu, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0467a.afu, (int) R.color.cp_link_tip_a);
                c0467a.afu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").bS("obj_type", "3").O("fid", forumInfo.forum_id.intValue()).p("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.crO.dY(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.crO.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.crO.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0467a.afu.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0467a.afu.setBackgroundDrawable(null);
                                am.setViewTextColor(c0467a.afu, (int) R.color.cp_cont_d);
                                c0467a.afu.setOnClickListener(null);
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

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bHr)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bHr.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bHr.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0467a {
        TextView afu;
        TextView cqt;
        BarImageView hlc;
        TextView hld;
        TextView hle;

        private C0467a() {
        }
    }
}
