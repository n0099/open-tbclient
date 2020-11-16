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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private String ecD;
    private List<ForumInfo> kNn;
    private ArrayList<Object> kNo;
    private final Context mContext;
    private final boolean kLY = true;
    private LikeModel eYI = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.kNn = arrayList;
    }

    public void eE(List<ForumInfo> list) {
        this.kNn = list;
        this.kNo = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.kNn.size()) {
                i = 0;
                break;
            } else if (this.kNn.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.kNo.addAll(this.kNn);
        if (i > 0) {
            this.kNo.add(i, "divider");
        }
        if (this.kNn != null) {
            notifyDataSetChanged();
        }
    }

    public void Nu(String str) {
        this.ecD = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kNo == null || TextUtils.isEmpty(this.ecD)) {
            return 0;
        }
        return this.kNo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kNo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0792a c0792a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0792a = new C0792a();
                c0792a.kMb = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0792a.kMb.setGifIconSupport(false);
                c0792a.eWc = (TextView) view.findViewById(R.id.name);
                c0792a.kMc = (TextView) view.findViewById(R.id.forum_member_count);
                c0792a.kMd = (TextView) view.findViewById(R.id.forum_thread_count);
                c0792a.bgZ = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0792a);
            } else {
                c0792a = (C0792a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0792a.kMb.setTag(str2);
                c0792a.kMb.startLoad(str2, 15, false);
                c0792a.kMb.invalidate();
                if (this.kLY) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                d(c0792a.eWc, str);
                c0792a.kMb.setTag(forumInfo.avatar);
                c0792a.kMc.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0792a.kMd.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0792a.kMc, R.color.CAM_X0109);
                ap.setViewTextColor(c0792a.kMd, R.color.CAM_X0109);
                ap.setViewTextColor(c0792a.eWc, R.color.CAM_X0105);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0792a.bgZ.setText(R.string.followed);
                    ap.setBackgroundResource(c0792a.bgZ, 0);
                    ap.setViewTextColor(c0792a.bgZ, R.color.CAM_X0109);
                    c0792a.bgZ.setOnClickListener(null);
                    return view;
                }
                c0792a.bgZ.setText(R.string.attention);
                ap.setBackgroundResource(c0792a.bgZ, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0792a.bgZ, R.color.CAM_X0302);
                c0792a.bgZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new ar("c13371").dR("obj_type", "3").ak("fid", forumInfo.forum_id.intValue()).w("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.eYI.gp(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.eYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if (a.this.eYI.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0792a.bgZ.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0792a.bgZ.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0792a.bgZ, R.color.CAM_X0109);
                                c0792a.bgZ.setOnClickListener(null);
                            }
                        });
                    }
                });
                return view;
            }
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            ap.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
            return inflate;
        } else {
            return view;
        }
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.ecD)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.ecD.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.ecD.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0792a {
        TextView bgZ;
        TextView eWc;
        BarImageView kMb;
        TextView kMc;
        TextView kMd;

        private C0792a() {
        }
    }
}
