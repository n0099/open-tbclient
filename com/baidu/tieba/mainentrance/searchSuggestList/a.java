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
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private String enU;
    private List<ForumInfo> lbE;
    private ArrayList<Object> lbF;
    private final Context mContext;
    private final boolean lao = true;
    private LikeModel fle = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.lbE = arrayList;
    }

    public void eP(List<ForumInfo> list) {
        this.lbE = list;
        this.lbF = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.lbE.size()) {
                i = 0;
                break;
            } else if (this.lbE.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.lbF.addAll(this.lbE);
        if (i > 0) {
            this.lbF.add(i, "divider");
        }
        if (this.lbE != null) {
            notifyDataSetChanged();
        }
    }

    public void Nb(String str) {
        this.enU = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lbF == null || TextUtils.isEmpty(this.enU)) {
            return 0;
        }
        return this.lbF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.lbF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0789a c0789a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0789a = new C0789a();
                c0789a.lar = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0789a.lar.setGifIconSupport(false);
                c0789a.fiz = (TextView) view.findViewById(R.id.name);
                c0789a.las = (TextView) view.findViewById(R.id.forum_member_count);
                c0789a.lau = (TextView) view.findViewById(R.id.forum_thread_count);
                c0789a.bih = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0789a);
            } else {
                c0789a = (C0789a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0789a.lar.setTag(str2);
                c0789a.lar.startLoad(str2, 15, false);
                c0789a.lar.invalidate();
                if (this.lao) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                e(c0789a.fiz, str);
                c0789a.lar.setTag(forumInfo.avatar);
                c0789a.las.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0789a.lau.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ao.setViewTextColor(c0789a.las, R.color.CAM_X0109);
                ao.setViewTextColor(c0789a.lau, R.color.CAM_X0109);
                ao.setViewTextColor(c0789a.fiz, R.color.CAM_X0105);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0789a.bih.setText(R.string.followed);
                    ao.setBackgroundResource(c0789a.bih, 0);
                    ao.setViewTextColor(c0789a.bih, R.color.CAM_X0109);
                    c0789a.bih.setOnClickListener(null);
                    return view;
                }
                c0789a.bih.setText(R.string.attention);
                ao.setBackgroundResource(c0789a.bih, R.drawable.search_like_btn_bg);
                ao.setViewTextColor(c0789a.bih, R.color.CAM_X0302);
                c0789a.bih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new aq("c13371").dW("obj_type", "3").an("fid", forumInfo.forum_id.intValue()).w("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.fle.gq(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.fle.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if (a.this.fle.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0789a.bih.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0789a.bih.setBackgroundDrawable(null);
                                ao.setViewTextColor(c0789a.bih, R.color.CAM_X0109);
                                c0789a.bih.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            ao.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
            return inflate;
        } else {
            return view;
        }
    }

    public void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.enU)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.enU.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.enU.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0789a {
        TextView bih;
        TextView fiz;
        BarImageView lar;
        TextView las;
        TextView lau;

        private C0789a() {
        }
    }
}
