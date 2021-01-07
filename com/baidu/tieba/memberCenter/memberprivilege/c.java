package com.baidu.tieba.memberCenter.memberprivilege;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    private MemberPrivilegeActivity lnQ;
    private boolean lnR = false;
    private ArrayList<Object> lnS = new ArrayList<>();
    private int mMemberType;

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.lnQ = memberPrivilegeActivity;
    }

    public void a(com.baidu.tieba.memberCenter.memberprivilege.a aVar) {
        this.lnS.clear();
        if (aVar != null && aVar.lnz != null && aVar.lnA != null) {
            List<a.c> list = aVar.lnA;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.lnz);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.mClassName) && cVar.lnF != null && cVar.lnF.size() != 0 && aU(cVar.lnF)) {
                    arrayList.add(cVar.mClassName);
                    Iterator<a.C0810a> it = cVar.lnF.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.lnS.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean aU(ArrayList<a.C0810a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        aV(arrayList);
        return arrayList.size() > 0;
    }

    public void aV(ArrayList<a.C0810a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<a.C0810a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.C0810a next = it.next();
                if (next != null && !TextUtils.isEmpty(next.mLink) && TextUtils.getTrimmedLength(next.mLink) > 0) {
                    arrayList2.add(next);
                }
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lnS == null) {
            return 0;
        }
        return this.lnS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lnS == null || i < 0 || i >= this.lnS.size()) {
            return null;
        }
        return this.lnS.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.lnS == null || i < 0 || i > getCount() || i >= this.lnS.size()) {
            return 3;
        }
        Object obj = this.lnS.get(i);
        if (obj instanceof a.e) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        return obj instanceof a.C0810a ? 2 : 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return f(i, view, viewGroup);
        }
        if (itemViewType == 1) {
            return e(i, view, viewGroup);
        }
        if (itemViewType == 2) {
            return b(i, view, viewGroup);
        }
        if (itemViewType == 3) {
        }
        return null;
    }

    private View e(int i, View view, ViewGroup viewGroup) {
        C0811c c0811c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0811c)) {
            view = LayoutInflater.from(this.lnQ.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            c0811c = new C0811c();
            c0811c.lok = (TextView) view.findViewById(R.id.title_view);
            view.setTag(c0811c);
        } else {
            c0811c = (C0811c) view.getTag();
        }
        c0811c.lok.setText((String) getItem(i));
        this.lnQ.getLayoutMode().setNightMode(z);
        this.lnQ.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View f(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a.e eVar;
        a.b bVar;
        a.d dVar;
        String string;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.lnQ.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            aVar = new a();
            aVar.lnT = (HeadImageView) view.findViewById(R.id.head_portrait);
            aVar.lnU = (RelativeLayout) view.findViewById(R.id.nonmember_stamp);
            aVar.lnX = (TextView) view.findViewById(R.id.nonmembername);
            aVar.lnV = (RelativeLayout) view.findViewById(R.id.member_stamp);
            aVar.lnW = (TextView) view.findViewById(R.id.membername);
            aVar.lnY = (TbImageView) view.findViewById(R.id.membericon);
            aVar.lod = (ImageView) view.findViewById(R.id.vip_bean_icon);
            aVar.loe = (ImageView) view.findViewById(R.id.nonmember_bean_icon);
            aVar.lof = (TextView) view.findViewById(R.id.vip_tbean_num);
            aVar.loh = (TextView) view.findViewById(R.id.nonmember_tbean_num);
            aVar.lnZ = (TextView) view.findViewById(R.id.endtime);
            aVar.loa = (TextView) view.findViewById(R.id.left_button);
            aVar.lob = (TextView) view.findViewById(R.id.right_button);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (!TbadkApplication.getInst().appResponseToCmd(1001533)) {
            aVar.lob.setVisibility(8);
        } else {
            aVar.lob.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar = eVar.lnL) == null || (dVar = eVar.lnM) == null) {
            return null;
        }
        long j = dVar.lnI + dVar.lnJ;
        this.mMemberType = (int) bVar.lmz;
        long j2 = bVar.lnC;
        String F = F(j2, bVar.lnD);
        aVar.lnT.startLoad(eVar.mPortrait, 25, false);
        ao.setBackgroundResource(aVar.lnT, R.drawable.memberinfo_bg_shape);
        if (!dVar.isValid()) {
            j = 0;
        }
        if (bVar.isValid() && dVar.isValid()) {
            aVar.lnU.setVisibility(8);
            aVar.lnV.setVisibility(0);
            aVar.lnY.startLoad(eVar.lnL.lnE, 21, false);
            if (this.lnR) {
                aVar.lnZ.setText(Ox(F));
            } else {
                if (1 == this.mMemberType) {
                    string = this.lnQ.getPageContext().getString(R.string.member);
                } else {
                    string = this.lnQ.getPageContext().getString(R.string.vip_member);
                }
                aVar.lnZ.setText(this.lnQ.getResources().getString(R.string.endtiem_memeber_tip, string, at.getDateStringDay(new Date(j2 * 1000))));
                ao.setViewTextColor(aVar.lnZ, R.color.CAM_X0101, 1);
            }
            aVar.lnW.setText(eVar.mName);
            aVar.loa.setText(this.mMemberType == 1 ? R.string.continue_member : R.string.continue_vip_member);
            aVar.loa.setOnClickListener(this.lnQ);
            aVar.lof.setText(String.valueOf(j));
            ao.setImageResource(aVar.lod, R.drawable.icon_vip_dou);
        } else {
            aVar.lnU.setVisibility(0);
            aVar.lnV.setVisibility(8);
            aVar.lnX.setText(eVar.mName);
            aVar.loa.setText(R.string.dredge_member);
            aVar.loa.setOnClickListener(this.lnQ);
            aVar.loh.setText(String.valueOf(j));
            ao.setImageResource(aVar.loe, R.drawable.icon_vip_dou);
        }
        ao.setBackgroundResource(aVar.lnZ, R.drawable.bg_dredge_tips);
        aVar.lob.setOnClickListener(this.lnQ);
        this.lnQ.getLayoutMode().setNightMode(z);
        this.lnQ.getLayoutMode().onModeChanged(view);
        return view;
    }

    private String F(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.lnR = true;
        if (0 < j3 && j3 <= 86400) {
            return this.lnQ.getPageContext().getString(R.string.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return "1";
        }
        if (172800 < j3 && j3 <= 259200) {
            return "2";
        }
        return "3";
    }

    private SpannableString Ox(String str) {
        SpannableString spannableString = new SpannableString(this.lnQ.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.lnQ.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            bVar = new b();
            bVar.loi = (HeadImageView) view.findViewById(R.id.item_portrait);
            bVar.mTitle = (TextView) view.findViewById(R.id.title);
            bVar.akw = (TextView) view.findViewById(R.id.description);
            bVar.loj = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            bVar.loj.setVisibility(8);
        }
        a.C0810a c0810a = (a.C0810a) getItem(i);
        bVar.loi.startLoad(c0810a.lnB, 10, false);
        bVar.mTitle.setText(c0810a.mTitle);
        bVar.akw.setText(c0810a.mDesc);
        this.lnQ.getLayoutMode().setNightMode(z);
        this.lnQ.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        public TextView akw;
        public HeadImageView loi;
        public ImageView loj;
        public TextView mTitle;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public HeadImageView lnT;
        public RelativeLayout lnU;
        public RelativeLayout lnV;
        public TextView lnW;
        public TextView lnX;
        public TbImageView lnY;
        public TextView lnZ;
        public TextView loa;
        public TextView lob;
        public ImageView lod;
        public ImageView loe;
        public TextView lof;
        public TextView loh;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0811c {
        public TextView lok;

        private C0811c() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
