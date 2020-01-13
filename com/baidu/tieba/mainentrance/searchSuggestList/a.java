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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private String csS;
    private List<ForumInfo> idW;
    private ArrayList<Object> idX;
    private final Context mContext;
    private final boolean icE = true;
    private LikeModel dfN = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.idW = arrayList;
    }

    public void dt(List<ForumInfo> list) {
        this.idW = list;
        this.idX = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.idW.size()) {
                i = 0;
                break;
            } else if (this.idW.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.idX.addAll(this.idW);
        if (i > 0) {
            this.idX.add(i, "divider");
        }
        if (this.idW != null) {
            notifyDataSetChanged();
        }
    }

    public void DW(String str) {
        this.csS = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.idX == null || TextUtils.isEmpty(this.csS)) {
            return 0;
        }
        return this.idX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.idX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0553a c0553a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0553a = new C0553a();
                c0553a.icH = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0553a.icH.setGifIconSupport(false);
                c0553a.ddX = (TextView) view.findViewById(R.id.name);
                c0553a.icI = (TextView) view.findViewById(R.id.forum_member_count);
                c0553a.icJ = (TextView) view.findViewById(R.id.forum_thread_count);
                c0553a.aoj = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0553a);
            } else {
                c0553a = (C0553a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0553a.icH.setTag(str2);
                c0553a.icH.startLoad(str2, 15, false);
                c0553a.icH.invalidate();
                if (this.icE) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(c0553a.ddX, str);
                c0553a.icH.setTag(forumInfo.avatar);
                c0553a.icI.setText(this.mContext.getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + forumInfo.concern_num);
                c0553a.icJ.setText(this.mContext.getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + forumInfo.post_num);
                am.setViewTextColor(c0553a.icI, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0553a.icJ, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0553a.ddX, (int) R.color.cp_cont_b);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0553a.aoj.setText(R.string.followed);
                    am.setBackgroundResource(c0553a.aoj, 0);
                    am.setViewTextColor(c0553a.aoj, (int) R.color.cp_cont_d);
                    c0553a.aoj.setOnClickListener(null);
                    return view;
                }
                c0553a.aoj.setText(R.string.attention);
                am.setBackgroundResource(c0553a.aoj, R.drawable.search_like_btn_bg);
                am.setViewTextColor(c0553a.aoj, (int) R.color.cp_link_tip_a);
                c0553a.aoj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new an("c13371").cp("obj_type", "3").Z("fid", forumInfo.forum_id.intValue()).s("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.dfN.et(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.dfN.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.dfN.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, (int) R.string.attention_fail);
                                    return;
                                }
                                c0553a.aoj.setText(R.string.followed);
                                l.showToast(a.this.mContext, (int) R.string.attention_success);
                                c0553a.aoj.setBackgroundDrawable(null);
                                am.setViewTextColor(c0553a.aoj, (int) R.color.cp_cont_d);
                                c0553a.aoj.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.csS)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.csS.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.csS.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0553a {
        TextView aoj;
        TextView ddX;
        BarImageView icH;
        TextView icI;
        TextView icJ;

        private C0553a() {
        }
    }
}
