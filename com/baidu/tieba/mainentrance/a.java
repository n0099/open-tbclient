package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private String csH;
    private final boolean hZa = true;
    private ArrayList<ForumSuggestModel.Forum> hZb;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.hZb = arrayList;
    }

    public void ay(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.hZb = arrayList;
        if (this.hZb != null) {
            notifyDataSetChanged();
        }
    }

    public void DM(String str) {
        this.csH = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hZb == null) {
            return 0;
        }
        return this.hZb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xx */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hZb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0546a c0546a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0546a c0546a2 = new C0546a();
            c0546a2.hZd = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0546a2.hZd.setGifIconSupport(false);
            c0546a2.ddN = (TextView) view.findViewById(R.id.name);
            c0546a2.hZe = (TextView) view.findViewById(R.id.forum_member_count);
            c0546a2.hZf = (TextView) view.findViewById(R.id.forum_thread_count);
            c0546a2.hZg = (TextView) view.findViewById(R.id.slogan);
            c0546a2.hZc = view.findViewById(R.id.offical_icon);
            view.setTag(c0546a2);
            c0546a = c0546a2;
        } else {
            c0546a = (C0546a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0546a.hZd.setTag(str2);
            c0546a.hZd.startLoad(str2, 10, false);
            c0546a.hZd.invalidate();
            if (this.hZa) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0546a.ddN, str);
            c0546a.hZd.setTag(item.avatar);
            c0546a.hZe.setText(this.mActivity.getPageContext().getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xy(item.member_num));
            c0546a.hZf.setText(this.mActivity.getPageContext().getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xy(item.thread_num));
            if (this.hZa || !TextUtils.isEmpty(item.slogan)) {
                c0546a.hZg.setVisibility(0);
                c0546a.hZg.setText(item.slogan);
            } else {
                c0546a.hZg.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0546a.hZc.setVisibility(0);
                am.setBackgroundResource(c0546a.hZc, R.drawable.icon_search_official);
            } else {
                c0546a.hZc.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String xy(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.csH)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.csH.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.csH.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0546a {
        TextView ddN;
        View hZc;
        BarImageView hZd;
        TextView hZe;
        TextView hZf;
        TextView hZg;

        private C0546a() {
        }
    }
}
