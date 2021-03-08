package com.baidu.tieba.memberCenter.memberTask;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.a.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private View.OnClickListener aFH;
    private List<r> lqo = new ArrayList();
    private MemberTaskCenterActivity lqp;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lqo != null) {
            return this.lqo.size();
        }
        return 0;
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.lqp = memberTaskCenterActivity;
    }

    public void setData(List<r> list) {
        this.lqo.clear();
        if (list != null) {
            this.lqo.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ey */
    public r getItem(int i) {
        if (this.lqo == null || this.lqo.size() <= i) {
            return null;
        }
        return this.lqo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.lqp.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.lqr = (TextView) view.findViewById(R.id.task_intro);
            aVar2.lqq = (TextView) view.findViewById(R.id.task_name);
            aVar2.lqs = (TextView) view.findViewById(R.id.task_status);
            aVar2.lqt = view.findViewById(R.id.divider_line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r item = getItem(i);
        if (item != null) {
            aVar.lqq.setText(item.getTitle());
            aVar.lqr.setText(fM(String.valueOf(item.dfw()), item.getDesc()));
            if (item.getIsFinish()) {
                aVar.lqs.setText(this.lqp.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.lqs.setTextColor(ap.getColor(R.color.CAM_X0110));
                aVar.lqs.setBackgroundDrawable(null);
                aVar.lqs.setOnClickListener(null);
            } else {
                aVar.lqs.setText(this.lqp.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                ap.setViewTextColor(aVar.lqs, R.color.member_center_task_btn_textcolor);
                aVar.lqs.setBackgroundDrawable(ap.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.lqs.setTag(item);
                aVar.lqs.setOnClickListener(this.aFH);
            }
            ap.setViewTextColor(aVar.lqr, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.lqq, R.color.CAM_X0105);
            ap.setBackgroundColor(aVar.lqt, R.color.CAM_X0204);
        }
        view.setTag(aVar);
        return view;
    }

    private SpannableString fM(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    /* loaded from: classes8.dex */
    public class a {
        TextView lqq;
        TextView lqr;
        TextView lqs;
        View lqt;

        public a() {
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.aFH = onClickListener;
    }
}
