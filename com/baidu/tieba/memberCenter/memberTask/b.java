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
    private List<r> lnU = new ArrayList();
    private MemberTaskCenterActivity lnV;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lnU != null) {
            return this.lnU.size();
        }
        return 0;
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.lnV = memberTaskCenterActivity;
    }

    public void setData(List<r> list) {
        this.lnU.clear();
        if (list != null) {
            this.lnU.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ev */
    public r getItem(int i) {
        if (this.lnU == null || this.lnU.size() <= i) {
            return null;
        }
        return this.lnU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.lnV.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.lnX = (TextView) view.findViewById(R.id.task_intro);
            aVar2.lnW = (TextView) view.findViewById(R.id.task_name);
            aVar2.lnY = (TextView) view.findViewById(R.id.task_status);
            aVar2.lnZ = view.findViewById(R.id.divider_line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r item = getItem(i);
        if (item != null) {
            aVar.lnW.setText(item.getTitle());
            aVar.lnX.setText(fM(String.valueOf(item.dfg()), item.getDesc()));
            if (item.getIsFinish()) {
                aVar.lnY.setText(this.lnV.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.lnY.setTextColor(ap.getColor(R.color.CAM_X0110));
                aVar.lnY.setBackgroundDrawable(null);
                aVar.lnY.setOnClickListener(null);
            } else {
                aVar.lnY.setText(this.lnV.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                ap.setViewTextColor(aVar.lnY, R.color.member_center_task_btn_textcolor);
                aVar.lnY.setBackgroundDrawable(ap.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.lnY.setTag(item);
                aVar.lnY.setOnClickListener(this.aEh);
            }
            ap.setViewTextColor(aVar.lnX, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.lnW, R.color.CAM_X0105);
            ap.setBackgroundColor(aVar.lnZ, R.color.CAM_X0204);
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
        TextView lnW;
        TextView lnX;
        TextView lnY;
        View lnZ;

        public a() {
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
    }
}
