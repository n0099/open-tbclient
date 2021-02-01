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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private String eqb;
    private List<ForumInfo> ljH;
    private ArrayList<Object> ljI;
    private final Context mContext;
    private final boolean lis = true;
    private LikeModel fnw = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.ljH = arrayList;
    }

    public void eN(List<ForumInfo> list) {
        this.ljH = list;
        this.ljI = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.ljH.size()) {
                i = 0;
                break;
            } else if (this.ljH.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.ljI.addAll(this.ljH);
        if (i > 0) {
            this.ljI.add(i, "divider");
        }
        if (this.ljH != null) {
            notifyDataSetChanged();
        }
    }

    public void NP(String str) {
        this.eqb = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ljI == null || TextUtils.isEmpty(this.eqb)) {
            return 0;
        }
        return this.ljI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ljI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0791a c0791a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0791a = new C0791a();
                c0791a.liv = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0791a.liv.setGifIconSupport(false);
                c0791a.fkQ = (TextView) view.findViewById(R.id.name);
                c0791a.liw = (TextView) view.findViewById(R.id.forum_member_count);
                c0791a.lix = (TextView) view.findViewById(R.id.forum_thread_count);
                c0791a.blz = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0791a);
            } else {
                c0791a = (C0791a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0791a.liv.setTag(str2);
                c0791a.liv.startLoad(str2, 15, false);
                c0791a.liv.invalidate();
                if (this.lis) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                e(c0791a.fkQ, str);
                c0791a.liv.setTag(forumInfo.avatar);
                c0791a.liw.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0791a.lix.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0791a.liw, R.color.CAM_X0109);
                ap.setViewTextColor(c0791a.lix, R.color.CAM_X0109);
                ap.setViewTextColor(c0791a.fkQ, R.color.CAM_X0105);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0791a.blz.setText(R.string.followed);
                    ap.setBackgroundResource(c0791a.blz, 0);
                    ap.setViewTextColor(c0791a.blz, R.color.CAM_X0109);
                    c0791a.blz.setOnClickListener(null);
                    return view;
                }
                c0791a.blz.setText(R.string.attention);
                ap.setBackgroundResource(c0791a.blz, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0791a.blz, R.color.CAM_X0302);
                c0791a.blz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new ar("c13371").dR("obj_type", "3").ap("fid", forumInfo.forum_id.intValue()).v("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.fnw.gw(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.fnw.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if (a.this.fnw.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0791a.blz.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0791a.blz.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0791a.blz, R.color.CAM_X0109);
                                c0791a.blz.setOnClickListener(null);
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

    public void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eqb)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eqb.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eqb.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0791a {
        TextView blz;
        TextView fkQ;
        BarImageView liv;
        TextView liw;
        TextView lix;

        private C0791a() {
        }
    }
}
