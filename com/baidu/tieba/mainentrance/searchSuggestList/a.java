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
    private String dPX;
    private List<ForumInfo> kuF;
    private ArrayList<Object> kuG;
    private final Context mContext;
    private final boolean ktq = true;
    private LikeModel eLp = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.kuF = arrayList;
    }

    public void en(List<ForumInfo> list) {
        this.kuF = list;
        this.kuG = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.kuF.size()) {
                i = 0;
                break;
            } else if (this.kuF.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.kuG.addAll(this.kuF);
        if (i > 0) {
            this.kuG.add(i, "divider");
        }
        if (this.kuF != null) {
            notifyDataSetChanged();
        }
    }

    public void Nh(String str) {
        this.dPX = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kuG == null || TextUtils.isEmpty(this.dPX)) {
            return 0;
        }
        return this.kuG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kuG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0760a c0760a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0760a = new C0760a();
                c0760a.ktt = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0760a.ktt.setGifIconSupport(false);
                c0760a.eIK = (TextView) view.findViewById(R.id.name);
                c0760a.ktu = (TextView) view.findViewById(R.id.forum_member_count);
                c0760a.ktv = (TextView) view.findViewById(R.id.forum_thread_count);
                c0760a.bgc = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0760a);
            } else {
                c0760a = (C0760a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0760a.ktt.setTag(str2);
                c0760a.ktt.startLoad(str2, 15, false);
                c0760a.ktt.invalidate();
                if (this.ktq) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                d(c0760a.eIK, str);
                c0760a.ktt.setTag(forumInfo.avatar);
                c0760a.ktu.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0760a.ktv.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0760a.ktu, R.color.cp_cont_d);
                ap.setViewTextColor(c0760a.ktv, R.color.cp_cont_d);
                ap.setViewTextColor(c0760a.eIK, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0760a.bgc.setText(R.string.followed);
                    ap.setBackgroundResource(c0760a.bgc, 0);
                    ap.setViewTextColor(c0760a.bgc, R.color.cp_cont_d);
                    c0760a.bgc.setOnClickListener(null);
                    return view;
                }
                c0760a.bgc.setText(R.string.attention);
                ap.setBackgroundResource(c0760a.bgc, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0760a.bgc, R.color.cp_link_tip_a);
                c0760a.bgc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new aq("c13371").dK("obj_type", "3").aj("fid", forumInfo.forum_id.intValue()).u("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.eLp.gk(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.eLp.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.eLp.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0760a.bgc.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0760a.bgc.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0760a.bgc, R.color.cp_cont_d);
                                c0760a.bgc.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dPX)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dPX.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dPX.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0760a {
        TextView bgc;
        TextView eIK;
        BarImageView ktt;
        TextView ktu;
        TextView ktv;

        private C0760a() {
        }
    }
}
