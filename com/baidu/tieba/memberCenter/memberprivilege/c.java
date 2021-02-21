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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
    private MemberPrivilegeActivity lrE;
    private boolean lrF = false;
    private ArrayList<Object> lrG = new ArrayList<>();
    private int mMemberType;

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.lrE = memberPrivilegeActivity;
    }

    public void a(com.baidu.tieba.memberCenter.memberprivilege.a aVar) {
        this.lrG.clear();
        if (aVar != null && aVar.lro != null && aVar.lrp != null) {
            List<a.c> list = aVar.lrp;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.lro);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.mClassName) && cVar.lru != null && cVar.lru.size() != 0 && aO(cVar.lru)) {
                    arrayList.add(cVar.mClassName);
                    Iterator<a.C0796a> it = cVar.lru.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.lrG.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean aO(ArrayList<a.C0796a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        aP(arrayList);
        return arrayList.size() > 0;
    }

    public void aP(ArrayList<a.C0796a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<a.C0796a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.C0796a next = it.next();
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
        if (this.lrG == null) {
            return 0;
        }
        return this.lrG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lrG == null || i < 0 || i >= this.lrG.size()) {
            return null;
        }
        return this.lrG.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.lrG == null || i < 0 || i > getCount() || i >= this.lrG.size()) {
            return 3;
        }
        Object obj = this.lrG.get(i);
        if (obj instanceof a.e) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        return obj instanceof a.C0796a ? 2 : 3;
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
        C0797c c0797c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0797c)) {
            view = LayoutInflater.from(this.lrE.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            c0797c = new C0797c();
            c0797c.lrW = (TextView) view.findViewById(R.id.title_view);
            view.setTag(c0797c);
        } else {
            c0797c = (C0797c) view.getTag();
        }
        c0797c.lrW.setText((String) getItem(i));
        this.lrE.getLayoutMode().setNightMode(z);
        this.lrE.getLayoutMode().onModeChanged(view);
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
            view = LayoutInflater.from(this.lrE.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            aVar = new a();
            aVar.lrH = (HeadImageView) view.findViewById(R.id.head_portrait);
            aVar.lrI = (RelativeLayout) view.findViewById(R.id.nonmember_stamp);
            aVar.lrL = (TextView) view.findViewById(R.id.nonmembername);
            aVar.lrJ = (RelativeLayout) view.findViewById(R.id.member_stamp);
            aVar.lrK = (TextView) view.findViewById(R.id.membername);
            aVar.lrM = (TbImageView) view.findViewById(R.id.membericon);
            aVar.lrQ = (ImageView) view.findViewById(R.id.vip_bean_icon);
            aVar.lrR = (ImageView) view.findViewById(R.id.nonmember_bean_icon);
            aVar.lrS = (TextView) view.findViewById(R.id.vip_tbean_num);
            aVar.lrT = (TextView) view.findViewById(R.id.nonmember_tbean_num);
            aVar.lrN = (TextView) view.findViewById(R.id.endtime);
            aVar.lrO = (TextView) view.findViewById(R.id.left_button);
            aVar.lrP = (TextView) view.findViewById(R.id.right_button);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (!TbadkApplication.getInst().appResponseToCmd(1001533)) {
            aVar.lrP.setVisibility(8);
        } else {
            aVar.lrP.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar = eVar.lrz) == null || (dVar = eVar.lrA) == null) {
            return null;
        }
        long j = dVar.lrx + dVar.lry;
        this.mMemberType = (int) bVar.lqp;
        long j2 = bVar.lrr;
        String J = J(j2, bVar.lrs);
        aVar.lrH.startLoad(eVar.mPortrait, 25, false);
        ap.setBackgroundResource(aVar.lrH, R.drawable.memberinfo_bg_shape);
        if (!dVar.isValid()) {
            j = 0;
        }
        if (bVar.isValid() && dVar.isValid()) {
            aVar.lrI.setVisibility(8);
            aVar.lrJ.setVisibility(0);
            aVar.lrM.startLoad(eVar.lrz.lrt, 21, false);
            if (this.lrF) {
                aVar.lrN.setText(Of(J));
            } else {
                if (1 == this.mMemberType) {
                    string = this.lrE.getPageContext().getString(R.string.member);
                } else {
                    string = this.lrE.getPageContext().getString(R.string.vip_member);
                }
                aVar.lrN.setText(this.lrE.getResources().getString(R.string.endtiem_memeber_tip, string, au.getDateStringDay(new Date(j2 * 1000))));
                ap.setViewTextColor(aVar.lrN, R.color.CAM_X0101, 1);
            }
            aVar.lrK.setText(eVar.mName);
            aVar.lrO.setText(this.mMemberType == 1 ? R.string.continue_member : R.string.continue_vip_member);
            aVar.lrO.setOnClickListener(this.lrE);
            aVar.lrS.setText(String.valueOf(j));
            ap.setImageResource(aVar.lrQ, R.drawable.icon_vip_dou);
        } else {
            aVar.lrI.setVisibility(0);
            aVar.lrJ.setVisibility(8);
            aVar.lrL.setText(eVar.mName);
            aVar.lrO.setText(R.string.dredge_member);
            aVar.lrO.setOnClickListener(this.lrE);
            aVar.lrT.setText(String.valueOf(j));
            ap.setImageResource(aVar.lrR, R.drawable.icon_vip_dou);
        }
        ap.setBackgroundResource(aVar.lrN, R.drawable.bg_dredge_tips);
        aVar.lrP.setOnClickListener(this.lrE);
        this.lrE.getLayoutMode().setNightMode(z);
        this.lrE.getLayoutMode().onModeChanged(view);
        return view;
    }

    private String J(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.lrF = true;
        if (0 < j3 && j3 <= 86400) {
            return this.lrE.getPageContext().getString(R.string.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return "1";
        }
        if (172800 < j3 && j3 <= 259200) {
            return "2";
        }
        return "3";
    }

    private SpannableString Of(String str) {
        SpannableString spannableString = new SpannableString(this.lrE.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.lrE.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            bVar = new b();
            bVar.lrU = (HeadImageView) view.findViewById(R.id.item_portrait);
            bVar.mTitle = (TextView) view.findViewById(R.id.title);
            bVar.aju = (TextView) view.findViewById(R.id.description);
            bVar.lrV = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            bVar.lrV.setVisibility(8);
        }
        a.C0796a c0796a = (a.C0796a) getItem(i);
        bVar.lrU.startLoad(c0796a.lrq, 10, false);
        bVar.mTitle.setText(c0796a.mTitle);
        bVar.aju.setText(c0796a.mDesc);
        this.lrE.getLayoutMode().setNightMode(z);
        this.lrE.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        public TextView aju;
        public HeadImageView lrU;
        public ImageView lrV;
        public TextView mTitle;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public HeadImageView lrH;
        public RelativeLayout lrI;
        public RelativeLayout lrJ;
        public TextView lrK;
        public TextView lrL;
        public TbImageView lrM;
        public TextView lrN;
        public TextView lrO;
        public TextView lrP;
        public ImageView lrQ;
        public ImageView lrR;
        public TextView lrS;
        public TextView lrT;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0797c {
        public TextView lrW;

        private C0797c() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
