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
    private String cWi;
    private final boolean iQA = true;
    private ArrayList<ForumSuggestModel.Forum> iQB;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.iQB = arrayList;
    }

    public void aA(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.iQB = arrayList;
        if (this.iQB != null) {
            notifyDataSetChanged();
        }
    }

    public void FX(String str) {
        this.cWi = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iQB == null) {
            return 0;
        }
        return this.iQB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yq */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.iQB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0618a c0618a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0618a c0618a2 = new C0618a();
            c0618a2.iQD = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0618a2.iQD.setGifIconSupport(false);
            c0618a2.dIC = (TextView) view.findViewById(R.id.name);
            c0618a2.iQE = (TextView) view.findViewById(R.id.forum_member_count);
            c0618a2.iQF = (TextView) view.findViewById(R.id.forum_thread_count);
            c0618a2.iQG = (TextView) view.findViewById(R.id.slogan);
            c0618a2.iQC = view.findViewById(R.id.offical_icon);
            view.setTag(c0618a2);
            c0618a = c0618a2;
        } else {
            c0618a = (C0618a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0618a.iQD.setTag(str2);
            c0618a.iQD.startLoad(str2, 10, false);
            c0618a.iQD.invalidate();
            if (this.iQA) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0618a.dIC, str);
            c0618a.iQD.setTag(item.avatar);
            c0618a.iQE.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + yr(item.member_num));
            c0618a.iQF.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + yr(item.thread_num));
            if (this.iQA || !TextUtils.isEmpty(item.slogan)) {
                c0618a.iQG.setVisibility(0);
                c0618a.iQG.setText(item.slogan);
            } else {
                c0618a.iQG.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0618a.iQC.setVisibility(0);
                am.setBackgroundResource(c0618a.iQC, R.drawable.icon_search_official);
            } else {
                c0618a.iQC.setVisibility(8);
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
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cWi)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cWi.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cWi.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0618a {
        TextView dIC;
        View iQC;
        BarImageView iQD;
        TextView iQE;
        TextView iQF;
        TextView iQG;

        private C0618a() {
        }
    }
}
