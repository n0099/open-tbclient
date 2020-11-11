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
    private String eel;
    private List<ForumInfo> kMY;
    private ArrayList<Object> kMZ;
    private final Context mContext;
    private final boolean kLJ = true;
    private LikeModel eZA = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.kMY = arrayList;
    }

    public void eE(List<ForumInfo> list) {
        this.kMY = list;
        this.kMZ = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.kMY.size()) {
                i = 0;
                break;
            } else if (this.kMY.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.kMZ.addAll(this.kMY);
        if (i > 0) {
            this.kMZ.add(i, "divider");
        }
        if (this.kMY != null) {
            notifyDataSetChanged();
        }
    }

    public void NW(String str) {
        this.eel = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kMZ == null || TextUtils.isEmpty(this.eel)) {
            return 0;
        }
        return this.kMZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kMZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0790a c0790a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0790a = new C0790a();
                c0790a.kLM = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0790a.kLM.setGifIconSupport(false);
                c0790a.eWV = (TextView) view.findViewById(R.id.name);
                c0790a.kLN = (TextView) view.findViewById(R.id.forum_member_count);
                c0790a.kLO = (TextView) view.findViewById(R.id.forum_thread_count);
                c0790a.biN = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0790a);
            } else {
                c0790a = (C0790a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0790a.kLM.setTag(str2);
                c0790a.kLM.startLoad(str2, 15, false);
                c0790a.kLM.invalidate();
                if (this.kLJ) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                d(c0790a.eWV, str);
                c0790a.kLM.setTag(forumInfo.avatar);
                c0790a.kLN.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0790a.kLO.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0790a.kLN, R.color.cp_cont_d);
                ap.setViewTextColor(c0790a.kLO, R.color.cp_cont_d);
                ap.setViewTextColor(c0790a.eWV, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0790a.biN.setText(R.string.followed);
                    ap.setBackgroundResource(c0790a.biN, 0);
                    ap.setViewTextColor(c0790a.biN, R.color.cp_cont_d);
                    c0790a.biN.setOnClickListener(null);
                    return view;
                }
                c0790a.biN.setText(R.string.attention);
                ap.setBackgroundResource(c0790a.biN, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0790a.biN, R.color.cp_link_tip_a);
                c0790a.biN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new aq("c13371").dR("obj_type", "3").al("fid", forumInfo.forum_id.intValue()).w("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.eZA.gp(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.eZA.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.eZA.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0790a.biN.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0790a.biN.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0790a.biN, R.color.cp_cont_d);
                                c0790a.biN.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eel)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eel.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eel.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0790a {
        TextView biN;
        TextView eWV;
        BarImageView kLM;
        TextView kLN;
        TextView kLO;

        private C0790a() {
        }
    }
}
