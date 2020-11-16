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
    private String ecD;
    private final boolean kLY = true;
    private ArrayList<ForumSuggestModel.Forum> kLZ;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.kLZ = arrayList;
    }

    public void aO(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.kLZ = arrayList;
        if (this.kLZ != null) {
            notifyDataSetChanged();
        }
    }

    public void Nu(String str) {
        this.ecD = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kLZ == null) {
            return 0;
        }
        return this.kLZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EP */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.kLZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0790a c0790a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0790a c0790a2 = new C0790a();
            c0790a2.kMb = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0790a2.kMb.setGifIconSupport(false);
            c0790a2.eWc = (TextView) view.findViewById(R.id.name);
            c0790a2.kMc = (TextView) view.findViewById(R.id.forum_member_count);
            c0790a2.kMd = (TextView) view.findViewById(R.id.forum_thread_count);
            c0790a2.kMe = (TextView) view.findViewById(R.id.slogan);
            c0790a2.kMa = view.findViewById(R.id.offical_icon);
            view.setTag(c0790a2);
            c0790a = c0790a2;
        } else {
            c0790a = (C0790a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0790a.kMb.setTag(str2);
            c0790a.kMb.startLoad(str2, 10, false);
            c0790a.kMb.invalidate();
            if (this.kLY) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            d(c0790a.eWc, str);
            c0790a.kMb.setTag(item.avatar);
            c0790a.kMc.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + EQ(item.member_num));
            c0790a.kMd.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + EQ(item.thread_num));
            if (this.kLY || !TextUtils.isEmpty(item.slogan)) {
                c0790a.kMe.setVisibility(0);
                c0790a.kMe.setText(item.slogan);
            } else {
                c0790a.kMe.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0790a.kMa.setVisibility(0);
                ap.setBackgroundResource(c0790a.kMa, R.drawable.icon_search_official);
            } else {
                c0790a.kMa.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String EQ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.ecD)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.ecD.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.ecD.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0790a {
        TextView eWc;
        View kMa;
        BarImageView kMb;
        TextView kMc;
        TextView kMd;
        TextView kMe;

        private C0790a() {
        }
    }
}
