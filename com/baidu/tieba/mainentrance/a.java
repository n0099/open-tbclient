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
/* loaded from: classes24.dex */
public class a extends BaseAdapter {
    private String dPX;
    private final boolean ktq = true;
    private ArrayList<ForumSuggestModel.Forum> ktr;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.ktr = arrayList;
    }

    public void aK(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.ktr = arrayList;
        if (this.ktr != null) {
            notifyDataSetChanged();
        }
    }

    public void Nh(String str) {
        this.dPX = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ktr == null) {
            return 0;
        }
        return this.ktr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DL */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ktr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0758a c0758a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0758a c0758a2 = new C0758a();
            c0758a2.ktt = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0758a2.ktt.setGifIconSupport(false);
            c0758a2.eIK = (TextView) view.findViewById(R.id.name);
            c0758a2.ktu = (TextView) view.findViewById(R.id.forum_member_count);
            c0758a2.ktv = (TextView) view.findViewById(R.id.forum_thread_count);
            c0758a2.ktw = (TextView) view.findViewById(R.id.slogan);
            c0758a2.kts = view.findViewById(R.id.offical_icon);
            view.setTag(c0758a2);
            c0758a = c0758a2;
        } else {
            c0758a = (C0758a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0758a.ktt.setTag(str2);
            c0758a.ktt.startLoad(str2, 10, false);
            c0758a.ktt.invalidate();
            if (this.ktq) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0758a.eIK, str);
            c0758a.ktt.setTag(item.avatar);
            c0758a.ktu.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + DM(item.member_num));
            c0758a.ktv.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + DM(item.thread_num));
            if (this.ktq || !TextUtils.isEmpty(item.slogan)) {
                c0758a.ktw.setVisibility(0);
                c0758a.ktw.setText(item.slogan);
            } else {
                c0758a.ktw.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0758a.kts.setVisibility(0);
                ap.setBackgroundResource(c0758a.kts, R.drawable.icon_search_official);
            } else {
                c0758a.kts.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String DM(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dPX)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dPX.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dPX.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0758a {
        TextView eIK;
        View kts;
        BarImageView ktt;
        TextView ktu;
        TextView ktv;
        TextView ktw;

        private C0758a() {
        }
    }
}
