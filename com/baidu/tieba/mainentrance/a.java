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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private String eqb;
    private final boolean liG = true;
    private ArrayList<ForumSuggestModel.Forum> liH;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.liH = arrayList;
    }

    public void aK(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.liH = arrayList;
        if (this.liH != null) {
            notifyDataSetChanged();
        }
    }

    public void NQ(String str) {
        this.eqb = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.liH == null) {
            return 0;
        }
        return this.liH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ek */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.liH.get(i);
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
            c0790a2.liJ = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0790a2.liJ.setGifIconSupport(false);
            c0790a2.fkQ = (TextView) view.findViewById(R.id.name);
            c0790a2.liK = (TextView) view.findViewById(R.id.forum_member_count);
            c0790a2.liL = (TextView) view.findViewById(R.id.forum_thread_count);
            c0790a2.liM = (TextView) view.findViewById(R.id.slogan);
            c0790a2.liI = view.findViewById(R.id.offical_icon);
            view.setTag(c0790a2);
            c0790a = c0790a2;
        } else {
            c0790a = (C0790a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0790a.liJ.setTag(str2);
            c0790a.liJ.startLoad(str2, 10, false);
            c0790a.liJ.invalidate();
            if (this.liG) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            e(c0790a.fkQ, str);
            c0790a.liJ.setTag(item.avatar);
            c0790a.liK.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + El(item.member_num));
            c0790a.liL.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + El(item.thread_num));
            if (this.liG || !TextUtils.isEmpty(item.slogan)) {
                c0790a.liM.setVisibility(0);
                c0790a.liM.setText(item.slogan);
            } else {
                c0790a.liM.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0790a.liI.setVisibility(0);
                ap.setBackgroundResource(c0790a.liI, R.drawable.icon_search_official);
            } else {
                c0790a.liI.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String El(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eqb)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eqb.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eqb.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0790a {
        TextView fkQ;
        View liI;
        BarImageView liJ;
        TextView liK;
        TextView liL;
        TextView liM;

        private C0790a() {
        }
    }
}
