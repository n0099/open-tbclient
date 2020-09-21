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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private String dDW;
    private List<ForumInfo> kfs;
    private ArrayList<Object> kft;
    private final Context mContext;
    private final boolean kec = true;
    private LikeModel ezi = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.kfs = arrayList;
    }

    public void ek(List<ForumInfo> list) {
        this.kfs = list;
        this.kft = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.kfs.size()) {
                i = 0;
                break;
            } else if (this.kfs.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.kft.addAll(this.kfs);
        if (i > 0) {
            this.kft.add(i, "divider");
        }
        if (this.kfs != null) {
            notifyDataSetChanged();
        }
    }

    public void Ms(String str) {
        this.dDW = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kft == null || TextUtils.isEmpty(this.dDW)) {
            return 0;
        }
        return this.kft.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kft.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0742a c0742a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0742a = new C0742a();
                c0742a.kef = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0742a.kef.setGifIconSupport(false);
                c0742a.ewA = (TextView) view.findViewById(R.id.name);
                c0742a.keg = (TextView) view.findViewById(R.id.forum_member_count);
                c0742a.keh = (TextView) view.findViewById(R.id.forum_thread_count);
                c0742a.bcq = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0742a);
            } else {
                c0742a = (C0742a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0742a.kef.setTag(str2);
                c0742a.kef.startLoad(str2, 15, false);
                c0742a.kef.invalidate();
                if (this.kec) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                d(c0742a.ewA, str);
                c0742a.kef.setTag(forumInfo.avatar);
                c0742a.keg.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0742a.keh.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0742a.keg, R.color.cp_cont_d);
                ap.setViewTextColor(c0742a.keh, R.color.cp_cont_d);
                ap.setViewTextColor(c0742a.ewA, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0742a.bcq.setText(R.string.followed);
                    ap.setBackgroundResource(c0742a.bcq, 0);
                    ap.setViewTextColor(c0742a.bcq, R.color.cp_cont_d);
                    c0742a.bcq.setOnClickListener(null);
                    return view;
                }
                c0742a.bcq.setText(R.string.attention);
                ap.setBackgroundResource(c0742a.bcq, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0742a.bcq, R.color.cp_link_tip_a);
                c0742a.bcq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new aq("c13371").dF("obj_type", "3").ai("fid", forumInfo.forum_id.intValue()).u("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.ezi.gd(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.ezi.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.ezi.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0742a.bcq.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0742a.bcq.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0742a.bcq, R.color.cp_cont_d);
                                c0742a.bcq.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dDW)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dDW.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dDW.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0742a {
        TextView bcq;
        TextView ewA;
        BarImageView kef;
        TextView keg;
        TextView keh;

        private C0742a() {
        }
    }
}
