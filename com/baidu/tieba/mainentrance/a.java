package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String cWd;
    private final boolean iQw = true;
    private ArrayList<ForumSuggestModel.Forum> iQx;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.iQx = arrayList;
    }

    public void aA(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.iQx = arrayList;
        if (this.iQx != null) {
            notifyDataSetChanged();
        }
    }

    public void FU(String str) {
        this.cWd = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iQx == null) {
            return 0;
        }
        return this.iQx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yq */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.iQx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0597a c0597a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0597a c0597a2 = new C0597a();
            c0597a2.iQz = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0597a2.iQz.setGifIconSupport(false);
            c0597a2.dIy = (TextView) view.findViewById(R.id.name);
            c0597a2.iQA = (TextView) view.findViewById(R.id.forum_member_count);
            c0597a2.iQB = (TextView) view.findViewById(R.id.forum_thread_count);
            c0597a2.iQC = (TextView) view.findViewById(R.id.slogan);
            c0597a2.iQy = view.findViewById(R.id.offical_icon);
            view.setTag(c0597a2);
            c0597a = c0597a2;
        } else {
            c0597a = (C0597a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0597a.iQz.setTag(str2);
            c0597a.iQz.startLoad(str2, 10, false);
            c0597a.iQz.invalidate();
            if (this.iQw) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0597a.dIy, str);
            c0597a.iQz.setTag(item.avatar);
            c0597a.iQA.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + yr(item.member_num));
            c0597a.iQB.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + yr(item.thread_num));
            if (this.iQw || !TextUtils.isEmpty(item.slogan)) {
                c0597a.iQC.setVisibility(0);
                c0597a.iQC.setText(item.slogan);
            } else {
                c0597a.iQC.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0597a.iQy.setVisibility(0);
                am.setBackgroundResource(c0597a.iQy, R.drawable.icon_search_official);
            } else {
                c0597a.iQy.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String yr(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cWd)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cWd.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cWd.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0597a {
        TextView dIy;
        TextView iQA;
        TextView iQB;
        TextView iQC;
        View iQy;
        BarImageView iQz;

        private C0597a() {
        }
    }
}
