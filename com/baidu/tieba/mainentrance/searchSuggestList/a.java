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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private String erD;
    private List<ForumInfo> llX;
    private ArrayList<Object> llY;
    private final Context mContext;
    private final boolean lkI = true;
    private LikeModel foW = new LikeModel(null);

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.mContext = context;
        this.llX = arrayList;
    }

    public void eN(List<ForumInfo> list) {
        this.llX = list;
        this.llY = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i >= this.llX.size()) {
                i = 0;
                break;
            } else if (this.llX.get(i).has_concerned.intValue() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.llY.addAll(this.llX);
        if (i > 0) {
            this.llY.add(i, "divider");
        }
        if (this.llX != null) {
            notifyDataSetChanged();
        }
    }

    public void NW(String str) {
        this.erD = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.llY == null || TextUtils.isEmpty(this.erD)) {
            return 0;
        }
        return this.llY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.llY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0798a c0798a;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            final ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                c0798a = new C0798a();
                c0798a.lkL = (BarImageView) view.findViewById(R.id.forum_avatar);
                c0798a.lkL.setGifIconSupport(false);
                c0798a.fmq = (TextView) view.findViewById(R.id.name);
                c0798a.lkM = (TextView) view.findViewById(R.id.forum_member_count);
                c0798a.lkN = (TextView) view.findViewById(R.id.forum_thread_count);
                c0798a.bna = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(c0798a);
            } else {
                c0798a = (C0798a) view.getTag();
            }
            if (forumInfo != null) {
                String str2 = forumInfo.avatar;
                c0798a.lkL.setTag(str2);
                c0798a.lkL.startLoad(str2, 15, false);
                c0798a.lkL.invalidate();
                if (this.lkI) {
                    str = this.mContext.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                e(c0798a.fmq, str);
                c0798a.lkL.setTag(forumInfo.avatar);
                c0798a.lkM.setText(this.mContext.getString(R.string.attention) + " " + forumInfo.concern_num);
                c0798a.lkN.setText(this.mContext.getString(R.string.text_post) + " " + forumInfo.post_num);
                ap.setViewTextColor(c0798a.lkM, R.color.CAM_X0109);
                ap.setViewTextColor(c0798a.lkN, R.color.CAM_X0109);
                ap.setViewTextColor(c0798a.fmq, R.color.CAM_X0105);
                if (forumInfo.has_concerned.intValue() > 0) {
                    c0798a.bna.setText(R.string.followed);
                    ap.setBackgroundResource(c0798a.bna, 0);
                    ap.setViewTextColor(c0798a.bna, R.color.CAM_X0109);
                    c0798a.bna.setOnClickListener(null);
                    return view;
                }
                c0798a.bna.setText(R.string.attention);
                ap.setBackgroundResource(c0798a.bna, R.drawable.search_like_btn_bg);
                ap.setViewTextColor(c0798a.bna, R.color.CAM_X0302);
                c0798a.bna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TiebaStatic.log(new ar("c13371").dR("obj_type", "3").aq("fid", forumInfo.forum_id.intValue()).v("uid", TbadkApplication.getCurrentAccountId()));
                        a.this.foW.gy(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                        a.this.foW.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.mainentrance.searchSuggestList.a.1.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if (a.this.foW.getErrorCode() != 0) {
                                    l.showToast(a.this.mContext, R.string.attention_fail);
                                    return;
                                }
                                c0798a.bna.setText(R.string.followed);
                                l.showToast(a.this.mContext, R.string.attention_success);
                                c0798a.bna.setBackgroundDrawable(null);
                                ap.setViewTextColor(c0798a.bna, R.color.CAM_X0109);
                                c0798a.bna.setOnClickListener(null);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.erD)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.erD.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.erD.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.searchSuggestList.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0798a {
        TextView bna;
        TextView fmq;
        BarImageView lkL;
        TextView lkM;
        TextView lkN;

        private C0798a() {
        }
    }
}
