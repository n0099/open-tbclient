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
    private String bIi;
    private List<ForumInfo> hnf;
    private ArrayList<Object> hng;
    private final Context mContext;
    private final boolean hlQ = true;
    private LikeModel csF = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.hnf = arrayList;
    }

    public void dE(List<ForumInfo> list) {
        this.hnf = list;
        this.hng = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.hnf.size()) {
                i = 0;
                break;
            } else if (this.hnf.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.hng.addAll(this.hnf);
        if (i > 0) {
            this.hng.add(i, "divider");
        }
        if (this.hnf != null) {
            notifyDataSetChanged();
        }
    }

    public void ze(String str) {
        this.bIi = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hng == null || TextUtils.isEmpty(this.bIi)) {
            return 0;
        }
        return this.hng.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hng.get(i);
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
                c0467a.hlT = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0467a.hlT.setGifIconSupport(false);
                c0467a.crl = (TextView) view.findViewById(R.id.name);
                c0467a.hlU = (TextView) view.findViewById(R.id.forum_member_count);
                c0467a.hlV = (TextView) view.findViewById(R.id.forum_thread_count);
                c0467a.afM = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0467a);
            } else {
                c0467a = (C0467a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0467a.hlT.setTag(str2);
                c0467a.hlT.startLoad(str2, 15, false);
                c0467a.hlT.invalidate();
                if (this.hlQ) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                b(c0467a.crl, str);
                c0467a.hlT.setTag(forumInfo.avatar);
                c0467a.hlU.setText(this.mContext.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + forumInfo.concern_num);
                c0467a.hlV.setText(this.mContext.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + forumInfo.post_num);
                am.setViewTextColor(c0467a.hlU, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0467a.hlV, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0467a.crl, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0467a.afM.setText(R.string.followed);
                    am.setBackgroundResource(c0467a.afM, 0);
                    am.setViewTextColor(c0467a.afM, (int) R.color.cp_cont_d);
                    c0467a.afM.setOnClickListener(null);
                    return view;
                }
                c0467a.afM.setText(R.string.attention);
                am.setBackgroundResource(c0467a.afM, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0467a.afM, (int) R.color.cp_link_tip_a);
                c0467a.afM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").bS("obj_type", "3").O("fid", forumInfo.forum_id.intValue()).p("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.csF.dY(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.csF.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.csF.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0467a.afM.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0467a.afM.setBackgroundDrawable(null);
                                am.setViewTextColor(c0467a.afM, (int) R.color.cp_cont_d);
                                c0467a.afM.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bIi)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bIi.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bIi.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0467a {
        TextView afM;
        TextView crl;
        BarImageView hlT;
        TextView hlU;
        TextView hlV;

        private C0467a() {
        }
    }
}
