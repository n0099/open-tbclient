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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private View.OnClickListener aHh;
    private List<r> lkw = new ArrayList();
    private MemberTaskCenterActivity lkx;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lkw != null) {
            return this.lkw.size();
        }
        return 0;
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.lkx = memberTaskCenterActivity;
    }

    public void setData(List<r> list) {
        this.lkw.clear();
        if (list != null) {
            this.lkw.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FJ */
    public r getItem(int i) {
        if (this.lkw == null || this.lkw.size() <= i) {
            return null;
        }
        return this.lkw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.lkx.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.lkz = (TextView) view.findViewById(R.id.task_intro);
            aVar2.lky = (TextView) view.findViewById(R.id.task_name);
            aVar2.lkA = (TextView) view.findViewById(R.id.task_status);
            aVar2.lkB = view.findViewById(R.id.divider_line);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        r item = getItem(i);
        if (item != null) {
            aVar.lky.setText(item.getTitle());
            aVar.lkz.setText(fN(String.valueOf(item.dgY()), item.getDesc()));
            if (item.getIsFinish()) {
                aVar.lkA.setText(this.lkx.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.lkA.setTextColor(ao.getColor(R.color.CAM_X0110));
                aVar.lkA.setBackgroundDrawable(null);
                aVar.lkA.setOnClickListener(null);
            } else {
                aVar.lkA.setText(this.lkx.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                ao.setViewTextColor(aVar.lkA, R.color.member_center_task_btn_textcolor);
                aVar.lkA.setBackgroundDrawable(ao.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.lkA.setTag(item);
                aVar.lkA.setOnClickListener(this.aHh);
            }
            ao.setViewTextColor(aVar.lkz, R.color.CAM_X0109);
            ao.setViewTextColor(aVar.lky, R.color.CAM_X0105);
            ao.setBackgroundColor(aVar.lkB, R.color.CAM_X0204);
        }
        view.setTag(aVar);
        return view;
    }

    private SpannableString fN(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    /* loaded from: classes9.dex */
    public class a {
        TextView lkA;
        View lkB;
        TextView lky;
        TextView lkz;

        public a() {
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.aHh = onClickListener;
    }
}
