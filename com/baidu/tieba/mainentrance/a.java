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
    private String dYu;
    private final boolean kFN = true;
    private ArrayList<ForumSuggestModel.Forum> kFO;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.kFO = arrayList;
    }

    public void aN(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.kFO = arrayList;
        if (this.kFO != null) {
            notifyDataSetChanged();
        }
    }

    public void NF(String str) {
        this.dYu = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kFO == null) {
            return 0;
        }
        return this.kFO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ee */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kFO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0773a c0773a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0773a c0773a2 = new C0773a();
            c0773a2.kFQ = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0773a2.kFQ.setGifIconSupport(false);
            c0773a2.eRg = (TextView) view.findViewById(R.id.name);
            c0773a2.kFR = (TextView) view.findViewById(R.id.forum_member_count);
            c0773a2.kFS = (TextView) view.findViewById(R.id.forum_thread_count);
            c0773a2.kFT = (TextView) view.findViewById(R.id.slogan);
            c0773a2.kFP = view.findViewById(R.id.offical_icon);
            view.setTag(c0773a2);
            c0773a = c0773a2;
        } else {
            c0773a = (C0773a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0773a.kFQ.setTag(str2);
            c0773a.kFQ.startLoad(str2, 10, false);
            c0773a.kFQ.invalidate();
            if (this.kFN) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0773a.eRg, str);
            c0773a.kFQ.setTag(item.avatar);
            c0773a.kFR.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + Ef(item.member_num));
            c0773a.kFS.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + Ef(item.thread_num));
            if (this.kFN || !TextUtils.isEmpty(item.slogan)) {
                c0773a.kFT.setVisibility(0);
                c0773a.kFT.setText(item.slogan);
            } else {
                c0773a.kFT.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0773a.kFP.setVisibility(0);
                ap.setBackgroundResource(c0773a.kFP, R.drawable.icon_search_official);
            } else {
                c0773a.kFP.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String Ef(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dYu)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dYu.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dYu.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0773a {
        TextView eRg;
        View kFP;
        BarImageView kFQ;
        TextView kFR;
        TextView kFS;
        TextView kFT;

        private C0773a() {
        }
    }
}
