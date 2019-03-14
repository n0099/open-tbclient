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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String bic;
    private List<ForumInfo> gOi;
    private ArrayList<Object> gOj;
    private final Context mContext;
    private final boolean gMT = true;
    private LikeModel bUq = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.gOi = arrayList;
    }

    public void dl(List<ForumInfo> list) {
        this.gOi = list;
        this.gOj = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.gOi.size()) {
                i = 0;
                break;
            } else if (this.gOi.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.gOj.addAll(this.gOi);
        if (i > 0) {
            this.gOj.add(i, "divider");
        }
        if (this.gOi != null) {
            notifyDataSetChanged();
        }
    }

    public void yi(String str) {
        this.bic = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gOj == null || TextUtils.isEmpty(this.bic)) {
            return 0;
        }
        return this.gOj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.gOj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0339a c0339a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.forum_search_sug_item, (ViewGroup) null);
                c0339a = new C0339a();
                c0339a.gMW = (BarImageView) view.findViewById(d.g.forum_avatar);
                c0339a.gMW.setGifIconSupport(false);
                c0339a.bSY = (TextView) view.findViewById(d.g.name);
                c0339a.gMX = (TextView) view.findViewById(d.g.forum_member_count);
                c0339a.gMY = (TextView) view.findViewById(d.g.forum_thread_count);
                c0339a.mFollowBtn = (TextView) view.findViewById(d.g.follow_text_view);
                view.setTag(c0339a);
            } else {
                c0339a = (C0339a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0339a.gMW.setTag(str2);
                c0339a.gMW.startLoad(str2, 15, false);
                c0339a.gMW.invalidate();
                if (this.gMT) {
                    str = this.mContext.getString(d.j.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                a(c0339a.bSY, str);
                c0339a.gMW.setTag(forumInfo.avatar);
                c0339a.gMX.setText(this.mContext.getString(d.j.attention) + " " + forumInfo.concern_num);
                c0339a.gMY.setText(this.mContext.getString(d.j.text_post) + " " + forumInfo.post_num);
                al.j(c0339a.gMX, d.C0277d.cp_cont_d);
                al.j(c0339a.gMY, d.C0277d.cp_cont_d);
                al.j(c0339a.bSY, d.C0277d.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0339a.mFollowBtn.setText(d.j.followed);
                    al.k(c0339a.mFollowBtn, 0);
                    al.j(c0339a.mFollowBtn, d.C0277d.cp_cont_d);
                    c0339a.mFollowBtn.setOnClickListener(null);
                    return view;
                }
                c0339a.mFollowBtn.setText(d.j.attention);
                al.k(c0339a.mFollowBtn, d.f.search_like_btn_bg);
                al.j(c0339a.mFollowBtn, d.C0277d.cp_link_tip_a);
                c0339a.mFollowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new am("c13371").bJ("obj_type", "3").T(ImageViewerConfig.FORUM_ID, forumInfo.forum_id.intValue()).k("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.bUq.dV(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.bUq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if (a.this.bUq.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, d.j.attention_fail);
                                    return;
                                }
                                c0339a.mFollowBtn.setText(d.j.followed);
                                l.showToast(a.this.mContext, d.j.attention_success);
                                c0339a.mFollowBtn.setBackgroundDrawable(null);
                                al.j(c0339a.mFollowBtn, d.C0277d.cp_cont_d);
                                c0339a.mFollowBtn.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.forum_search_divider_view, (ViewGroup) null);
            al.l(inflate.findViewById(d.g.card_divider_top_margin), d.C0277d.cp_bg_line_c);
            return inflate;
        } else {
            return view;
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bic)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bic.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bic.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0339a {
        TextView bSY;
        BarImageView gMW;
        TextView gMX;
        TextView gMY;
        TextView mFollowBtn;

        private C0339a() {
        }
    }
}
