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
/* loaded from: classes18.dex */
public class a extends BaseAdapter {
    private String dBR;
    private List<ForumInfo> jWI;
    private ArrayList<Object> jWJ;
    private final Context mContext;
    private final boolean jVu = true;
    private LikeModel ewX = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.jWI = arrayList;
    }

    public void ec(List<ForumInfo> list) {
        this.jWI = list;
        this.jWJ = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.jWI.size()) {
                i = 0;
                break;
            } else if (this.jWI.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.jWJ.addAll(this.jWI);
        if (i > 0) {
            this.jWJ.add(i, "divider");
        }
        if (this.jWI != null) {
            notifyDataSetChanged();
        }
    }

    public void LP(String str) {
        this.dBR = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jWJ == null || TextUtils.isEmpty(this.dBR)) {
            return 0;
        }
        return this.jWJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jWJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0745a c0745a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0745a = new C0745a();
                c0745a.jVx = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0745a.jVx.setGifIconSupport(false);
                c0745a.eus = (TextView) view.findViewById(R.id.name);
                c0745a.jVy = (TextView) view.findViewById(R.id.forum_member_count);
                c0745a.jVz = (TextView) view.findViewById(R.id.forum_thread_count);
                c0745a.aZQ = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0745a);
            } else {
                c0745a = (C0745a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0745a.jVx.setTag(str2);
                c0745a.jVx.startLoad(str2, 15, false);
                c0745a.jVx.invalidate();
                if (this.jVu) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0745a.eus, str);
                c0745a.jVx.setTag(forumInfo.avatar);
                c0745a.jVy.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0745a.jVz.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0745a.jVy, R.color.cp_cont_d);
                ap.setViewTextColor(c0745a.jVz, R.color.cp_cont_d);
                ap.setViewTextColor(c0745a.eus, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0745a.aZQ.setText(R.string.followed);
                    ap.setBackgroundResource(c0745a.aZQ, 0);
                    ap.setViewTextColor(c0745a.aZQ, R.color.cp_cont_d);
                    c0745a.aZQ.setOnClickListener(null);
                    return view;
                }
                c0745a.aZQ.setText(R.string.attention);
                ap.setBackgroundResource(c0745a.aZQ, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0745a.aZQ, R.color.cp_link_tip_a);
                c0745a.aZQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new aq("c13371").dD("obj_type", "3").ai("fid", forumInfo.forum_id.intValue()).u("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.ewX.fQ(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.ewX.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.ewX.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0745a.aZQ.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0745a.aZQ.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0745a.aZQ, R.color.cp_cont_d);
                                c0745a.aZQ.setOnClickListener(null);
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

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dBR)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dBR.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dBR.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0745a {
        TextView aZQ;
        TextView eus;
        BarImageView jVx;
        TextView jVy;
        TextView jVz;

        private C0745a() {
        }
    }
}
