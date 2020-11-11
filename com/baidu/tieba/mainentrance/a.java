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
    private String eel;
    private final boolean kLJ = true;
    private ArrayList<ForumSuggestModel.Forum> kLK;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.kLK = arrayList;
    }

    public void aN(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.kLK = arrayList;
        if (this.kLK != null) {
            notifyDataSetChanged();
        }
    }

    public void NW(String str) {
        this.eel = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kLK == null) {
            return 0;
        }
        return this.kLK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Er */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kLK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0788a c0788a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0788a c0788a2 = new C0788a();
            c0788a2.kLM = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0788a2.kLM.setGifIconSupport(false);
            c0788a2.eWV = (TextView) view.findViewById(R.id.name);
            c0788a2.kLN = (TextView) view.findViewById(R.id.forum_member_count);
            c0788a2.kLO = (TextView) view.findViewById(R.id.forum_thread_count);
            c0788a2.kLP = (TextView) view.findViewById(R.id.slogan);
            c0788a2.kLL = view.findViewById(R.id.offical_icon);
            view.setTag(c0788a2);
            c0788a = c0788a2;
        } else {
            c0788a = (C0788a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0788a.kLM.setTag(str2);
            c0788a.kLM.startLoad(str2, 10, false);
            c0788a.kLM.invalidate();
            if (this.kLJ) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0788a.eWV, str);
            c0788a.kLM.setTag(item.avatar);
            c0788a.kLN.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + Es(item.member_num));
            c0788a.kLO.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + Es(item.thread_num));
            if (this.kLJ || !TextUtils.isEmpty(item.slogan)) {
                c0788a.kLP.setVisibility(0);
                c0788a.kLP.setText(item.slogan);
            } else {
                c0788a.kLP.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0788a.kLL.setVisibility(0);
                ap.setBackgroundResource(c0788a.kLL, R.drawable.icon_search_official);
            } else {
                c0788a.kLL.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String Es(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eel)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eel.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eel.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0788a {
        TextView eWV;
        View kLL;
        BarImageView kLM;
        TextView kLN;
        TextView kLO;
        TextView kLP;

        private C0788a() {
        }
    }
}
