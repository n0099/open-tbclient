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
    private String ejE;
    private final boolean kZp = true;
    private ArrayList<ForumSuggestModel.Forum> kZq;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.kZq = arrayList;
    }

    public void aQ(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.kZq = arrayList;
        if (this.kZq != null) {
            notifyDataSetChanged();
        }
    }

    public void OB(String str) {
        this.ejE = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kZq == null) {
            return 0;
        }
        return this.kZq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FE */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kZq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0806a c0806a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0806a c0806a2 = new C0806a();
            c0806a2.kZs = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0806a2.kZs.setGifIconSupport(false);
            c0806a2.fdz = (TextView) view.findViewById(R.id.name);
            c0806a2.kZt = (TextView) view.findViewById(R.id.forum_member_count);
            c0806a2.kZu = (TextView) view.findViewById(R.id.forum_thread_count);
            c0806a2.kZv = (TextView) view.findViewById(R.id.slogan);
            c0806a2.kZr = view.findViewById(R.id.offical_icon);
            view.setTag(c0806a2);
            c0806a = c0806a2;
        } else {
            c0806a = (C0806a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0806a.kZs.setTag(str2);
            c0806a.kZs.startLoad(str2, 10, false);
            c0806a.kZs.invalidate();
            if (this.kZp) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0806a.fdz, str);
            c0806a.kZs.setTag(item.avatar);
            c0806a.kZt.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + FF(item.member_num));
            c0806a.kZu.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + FF(item.thread_num));
            if (this.kZp || !TextUtils.isEmpty(item.slogan)) {
                c0806a.kZv.setVisibility(0);
                c0806a.kZv.setText(item.slogan);
            } else {
                c0806a.kZv.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0806a.kZr.setVisibility(0);
                ap.setBackgroundResource(c0806a.kZr, R.drawable.icon_search_official);
            } else {
                c0806a.kZr.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String FF(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.ejE)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.ejE.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.ejE.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0806a {
        TextView fdz;
        View kZr;
        BarImageView kZs;
        TextView kZt;
        TextView kZu;
        TextView kZv;

        private C0806a() {
        }
    }
}
