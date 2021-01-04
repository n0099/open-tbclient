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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private String esI;
    private final boolean leW = true;
    private ArrayList<ForumSuggestModel.Forum> leX;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.leX = arrayList;
    }

    public void aQ(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.leX = arrayList;
        if (this.leX != null) {
            notifyDataSetChanged();
        }
    }

    public void Oj(String str) {
        this.esI = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.leX == null) {
            return 0;
        }
        return this.leX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Fy */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.leX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0791a c0791a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0791a c0791a2 = new C0791a();
            c0791a2.leZ = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0791a2.leZ.setGifIconSupport(false);
            c0791a2.fni = (TextView) view.findViewById(R.id.name);
            c0791a2.lfa = (TextView) view.findViewById(R.id.forum_member_count);
            c0791a2.lfb = (TextView) view.findViewById(R.id.forum_thread_count);
            c0791a2.lfc = (TextView) view.findViewById(R.id.slogan);
            c0791a2.leY = view.findViewById(R.id.offical_icon);
            view.setTag(c0791a2);
            c0791a = c0791a2;
        } else {
            c0791a = (C0791a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0791a.leZ.setTag(str2);
            c0791a.leZ.startLoad(str2, 10, false);
            c0791a.leZ.invalidate();
            if (this.leW) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            e(c0791a.fni, str);
            c0791a.leZ.setTag(item.avatar);
            c0791a.lfa.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + Fz(item.member_num));
            c0791a.lfb.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + Fz(item.thread_num));
            if (this.leW || !TextUtils.isEmpty(item.slogan)) {
                c0791a.lfc.setVisibility(0);
                c0791a.lfc.setText(item.slogan);
            } else {
                c0791a.lfc.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0791a.leY.setVisibility(0);
                ao.setBackgroundResource(c0791a.leY, R.drawable.icon_search_official);
            } else {
                c0791a.leY.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String Fz(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.esI)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.esI.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.esI.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0791a {
        TextView fni;
        View leY;
        BarImageView leZ;
        TextView lfa;
        TextView lfb;
        TextView lfc;

        private C0791a() {
        }
    }
}
