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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private String dDW;
    private final boolean kec = true;
    private ArrayList<ForumSuggestModel.Forum> ked;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.ked = arrayList;
    }

    public void aK(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.ked = arrayList;
        if (this.ked != null) {
            notifyDataSetChanged();
        }
    }

    public void Ms(String str) {
        this.dDW = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ked == null) {
            return 0;
        }
        return this.ked.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Df */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ked.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0740a c0740a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0740a c0740a2 = new C0740a();
            c0740a2.kef = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0740a2.kef.setGifIconSupport(false);
            c0740a2.ewA = (TextView) view.findViewById(R.id.name);
            c0740a2.keg = (TextView) view.findViewById(R.id.forum_member_count);
            c0740a2.keh = (TextView) view.findViewById(R.id.forum_thread_count);
            c0740a2.kei = (TextView) view.findViewById(R.id.slogan);
            c0740a2.kee = view.findViewById(R.id.offical_icon);
            view.setTag(c0740a2);
            c0740a = c0740a2;
        } else {
            c0740a = (C0740a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0740a.kef.setTag(str2);
            c0740a.kef.startLoad(str2, 10, false);
            c0740a.kef.invalidate();
            if (this.kec) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0740a.ewA, str);
            c0740a.kef.setTag(item.avatar);
            c0740a.keg.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + Dg(item.member_num));
            c0740a.keh.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + Dg(item.thread_num));
            if (this.kec || !TextUtils.isEmpty(item.slogan)) {
                c0740a.kei.setVisibility(0);
                c0740a.kei.setText(item.slogan);
            } else {
                c0740a.kei.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0740a.kee.setVisibility(0);
                ap.setBackgroundResource(c0740a.kee, R.drawable.icon_search_official);
            } else {
                c0740a.kee.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String Dg(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dDW)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dDW.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dDW.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0740a {
        TextView ewA;
        View kee;
        BarImageView kef;
        TextView keg;
        TextView keh;
        TextView kei;

        private C0740a() {
        }
    }
}
