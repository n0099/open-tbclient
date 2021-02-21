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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private View.OnClickListener aEh;
    private List<r> lok = new ArrayList();
    private MemberTaskCenterActivity lol;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lok != null) {
            return this.lok.size();
        }
        return 0;
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.lol = memberTaskCenterActivity;
    }

    public void setData(List<r> list) {
        this.lok.clear();
        if (list != null) {
            this.lok.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ev */
    public r getItem(int i) {
        if (this.lok == null || this.lok.size() <= i) {
            return null;
        }
        return this.lok.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.lol.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.loo = (TextView) view.findViewById(R.id.task_intro);
            aVar2.lom = (TextView) view.findViewById(R.id.task_name);
            aVar2.lop = (TextView) view.findViewById(R.id.task_status);
            aVar2.loq = view.findViewById(R.id.divider_line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r item = getItem(i);
        if (item != null) {
            aVar.lom.setText(item.getTitle());
            aVar.loo.setText(fM(String.valueOf(item.dfn()), item.getDesc()));
            if (item.getIsFinish()) {
                aVar.lop.setText(this.lol.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.lop.setTextColor(ap.getColor(R.color.CAM_X0110));
                aVar.lop.setBackgroundDrawable(null);
                aVar.lop.setOnClickListener(null);
            } else {
                aVar.lop.setText(this.lol.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                ap.setViewTextColor(aVar.lop, R.color.member_center_task_btn_textcolor);
                aVar.lop.setBackgroundDrawable(ap.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.lop.setTag(item);
                aVar.lop.setOnClickListener(this.aEh);
            }
            ap.setViewTextColor(aVar.loo, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.lom, R.color.CAM_X0105);
            ap.setBackgroundColor(aVar.loq, R.color.CAM_X0204);
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

    /* loaded from: classes9.dex */
    public class a {
        TextView lom;
        TextView loo;
        TextView lop;
        View loq;

        public a() {
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
    }
}
