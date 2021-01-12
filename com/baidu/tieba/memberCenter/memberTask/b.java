package com.baidu.tieba.memberCenter.memberTask;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.a.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private View.OnClickListener aCu;
    private List<r> lfR = new ArrayList();
    private MemberTaskCenterActivity lfS;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lfR != null) {
            return this.lfR.size();
        }
        return 0;
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.lfS = memberTaskCenterActivity;
    }

    public void setData(List<r> list) {
        this.lfR.clear();
        if (list != null) {
            this.lfR.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ed */
    public r getItem(int i) {
        if (this.lfR == null || this.lfR.size() <= i) {
            return null;
        }
        return this.lfR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.lfS.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.lfU = (TextView) view.findViewById(R.id.task_intro);
            aVar2.lfT = (TextView) view.findViewById(R.id.task_name);
            aVar2.lfV = (TextView) view.findViewById(R.id.task_status);
            aVar2.lfW = view.findViewById(R.id.divider_line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r item = getItem(i);
        if (item != null) {
            aVar.lfT.setText(item.getTitle());
            aVar.lfU.setText(fM(String.valueOf(item.ddg()), item.getDesc()));
            if (item.getIsFinish()) {
                aVar.lfV.setText(this.lfS.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.lfV.setTextColor(ao.getColor(R.color.CAM_X0110));
                aVar.lfV.setBackgroundDrawable(null);
                aVar.lfV.setOnClickListener(null);
            } else {
                aVar.lfV.setText(this.lfS.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                ao.setViewTextColor(aVar.lfV, R.color.member_center_task_btn_textcolor);
                aVar.lfV.setBackgroundDrawable(ao.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.lfV.setTag(item);
                aVar.lfV.setOnClickListener(this.aCu);
            }
            ao.setViewTextColor(aVar.lfU, R.color.CAM_X0109);
            ao.setViewTextColor(aVar.lfT, R.color.CAM_X0105);
            ao.setBackgroundColor(aVar.lfW, R.color.CAM_X0204);
        }
        view.setTag(aVar);
        return view;
    }

    private SpannableString fM(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    /* loaded from: classes8.dex */
    public class a {
        TextView lfT;
        TextView lfU;
        TextView lfV;
        View lfW;

        public a() {
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.aCu = onClickListener;
    }
}
