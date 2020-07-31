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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes18.dex */
public class a extends BaseAdapter {
    private String drQ;
    private List<ForumInfo> jHp;
    private ArrayList<Object> jHq;
    private final Context mContext;
    private final boolean jGb = true;
    private LikeModel emT = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.jHp = arrayList;
    }

    public void dU(List<ForumInfo> list) {
        this.jHp = list;
        this.jHq = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.jHp.size()) {
                i = 0;
                break;
            } else if (this.jHp.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.jHq.addAll(this.jHp);
        if (i > 0) {
            this.jHq.add(i, "divider");
        }
        if (this.jHp != null) {
            notifyDataSetChanged();
        }
    }

    public void IX(String str) {
        this.drQ = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jHq == null || TextUtils.isEmpty(this.drQ)) {
            return 0;
        }
        return this.jHq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jHq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0694a c0694a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0694a = new C0694a();
                c0694a.jGe = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0694a.jGe.setGifIconSupport(false);
                c0694a.ekx = (TextView) view.findViewById(R.id.name);
                c0694a.jGf = (TextView) view.findViewById(R.id.forum_member_count);
                c0694a.jGg = (TextView) view.findViewById(R.id.forum_thread_count);
                c0694a.aUC = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0694a);
            } else {
                c0694a = (C0694a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0694a.jGe.setTag(str2);
                c0694a.jGe.startLoad(str2, 15, false);
                c0694a.jGe.invalidate();
                if (this.jGb) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0694a.ekx, str);
                c0694a.jGe.setTag(forumInfo.avatar);
                c0694a.jGf.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0694a.jGg.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ao.setViewTextColor(c0694a.jGf, R.color.cp_cont_d);
                ao.setViewTextColor(c0694a.jGg, R.color.cp_cont_d);
                ao.setViewTextColor(c0694a.ekx, R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0694a.aUC.setText(R.string.followed);
                    ao.setBackgroundResource(c0694a.aUC, 0);
                    ao.setViewTextColor(c0694a.aUC, R.color.cp_cont_d);
                    c0694a.aUC.setOnClickListener(null);
                    return view;
                }
                c0694a.aUC.setText(R.string.attention);
                ao.setBackgroundResource(c0694a.aUC, R.drawable.search_like_btn_bg);
                ao.setViewTextColor(c0694a.aUC, R.color.cp_link_tip_a);
                c0694a.aUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new ap("c13371").dn("obj_type", "3").ah("fid", forumInfo.forum_id.intValue()).t("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.emT.fz(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.emT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.emT.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0694a.aUC.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0694a.aUC.setBackgroundDrawable(null);
                                ao.setViewTextColor(c0694a.aUC, R.color.cp_cont_d);
                                c0694a.aUC.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            ao.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.cp_bg_line_c);
            return inflate;
        } else {
            return view;
        }
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.drQ)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.drQ.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.drQ.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0694a {
        TextView aUC;
        TextView ekx;
        BarImageView jGe;
        TextView jGf;
        TextView jGg;

        private C0694a() {
        }
    }
}
