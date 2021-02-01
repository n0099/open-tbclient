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
    private MemberPrivilegeActivity lrq;
    private boolean lrr = false;
    private ArrayList<Object> lrs = new ArrayList<>();
    private int mMemberType;

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.lrq = memberPrivilegeActivity;
    }

    public void a(com.baidu.tieba.memberCenter.memberprivilege.a aVar) {
        this.lrs.clear();
        if (aVar != null && aVar.lra != null && aVar.lrb != null) {
            List<a.c> list = aVar.lrb;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.lra);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.mClassName) && cVar.lrg != null && cVar.lrg.size() != 0 && aO(cVar.lrg)) {
                    arrayList.add(cVar.mClassName);
                    Iterator<a.C0795a> it = cVar.lrg.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.lrs.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean aO(ArrayList<a.C0795a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        aP(arrayList);
        return arrayList.size() > 0;
    }

    public void aP(ArrayList<a.C0795a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<a.C0795a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.C0795a next = it.next();
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
        if (this.lrs == null) {
            return 0;
        }
        return this.lrs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lrs == null || i < 0 || i >= this.lrs.size()) {
            return null;
        }
        return this.lrs.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.lrs == null || i < 0 || i > getCount() || i >= this.lrs.size()) {
            return 3;
        }
        Object obj = this.lrs.get(i);
        if (obj instanceof a.e) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        return obj instanceof a.C0795a ? 2 : 3;
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
        C0796c c0796c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0796c)) {
            view = LayoutInflater.from(this.lrq.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            c0796c = new C0796c();
            c0796c.lrI = (TextView) view.findViewById(R.id.title_view);
            view.setTag(c0796c);
        } else {
            c0796c = (C0796c) view.getTag();
        }
        c0796c.lrI.setText((String) getItem(i));
        this.lrq.getLayoutMode().setNightMode(z);
        this.lrq.getLayoutMode().onModeChanged(view);
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
            view = LayoutInflater.from(this.lrq.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            aVar = new a();
            aVar.lrt = (HeadImageView) view.findViewById(R.id.head_portrait);
            aVar.lru = (RelativeLayout) view.findViewById(R.id.nonmember_stamp);
            aVar.lrx = (TextView) view.findViewById(R.id.nonmembername);
            aVar.lrv = (RelativeLayout) view.findViewById(R.id.member_stamp);
            aVar.lrw = (TextView) view.findViewById(R.id.membername);
            aVar.lry = (TbImageView) view.findViewById(R.id.membericon);
            aVar.lrC = (ImageView) view.findViewById(R.id.vip_bean_icon);
            aVar.lrD = (ImageView) view.findViewById(R.id.nonmember_bean_icon);
            aVar.lrE = (TextView) view.findViewById(R.id.vip_tbean_num);
            aVar.lrF = (TextView) view.findViewById(R.id.nonmember_tbean_num);
            aVar.lrz = (TextView) view.findViewById(R.id.endtime);
            aVar.lrA = (TextView) view.findViewById(R.id.left_button);
            aVar.lrB = (TextView) view.findViewById(R.id.right_button);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (!TbadkApplication.getInst().appResponseToCmd(1001533)) {
            aVar.lrB.setVisibility(8);
        } else {
            aVar.lrB.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar = eVar.lrl) == null || (dVar = eVar.lrm) == null) {
            return null;
        }
        long j = dVar.lrj + dVar.lrk;
        this.mMemberType = (int) bVar.lqb;
        long j2 = bVar.lrd;
        String J = J(j2, bVar.lre);
        aVar.lrt.startLoad(eVar.mPortrait, 25, false);
        ap.setBackgroundResource(aVar.lrt, R.drawable.memberinfo_bg_shape);
        if (!dVar.isValid()) {
            j = 0;
        }
        if (bVar.isValid() && dVar.isValid()) {
            aVar.lru.setVisibility(8);
            aVar.lrv.setVisibility(0);
            aVar.lry.startLoad(eVar.lrl.lrf, 21, false);
            if (this.lrr) {
                aVar.lrz.setText(Oe(J));
            } else {
                if (1 == this.mMemberType) {
                    string = this.lrq.getPageContext().getString(R.string.member);
                } else {
                    string = this.lrq.getPageContext().getString(R.string.vip_member);
                }
                aVar.lrz.setText(this.lrq.getResources().getString(R.string.endtiem_memeber_tip, string, au.getDateStringDay(new Date(j2 * 1000))));
                ap.setViewTextColor(aVar.lrz, R.color.CAM_X0101, 1);
            }
            aVar.lrw.setText(eVar.mName);
            aVar.lrA.setText(this.mMemberType == 1 ? R.string.continue_member : R.string.continue_vip_member);
            aVar.lrA.setOnClickListener(this.lrq);
            aVar.lrE.setText(String.valueOf(j));
            ap.setImageResource(aVar.lrC, R.drawable.icon_vip_dou);
        } else {
            aVar.lru.setVisibility(0);
            aVar.lrv.setVisibility(8);
            aVar.lrx.setText(eVar.mName);
            aVar.lrA.setText(R.string.dredge_member);
            aVar.lrA.setOnClickListener(this.lrq);
            aVar.lrF.setText(String.valueOf(j));
            ap.setImageResource(aVar.lrD, R.drawable.icon_vip_dou);
        }
        ap.setBackgroundResource(aVar.lrz, R.drawable.bg_dredge_tips);
        aVar.lrB.setOnClickListener(this.lrq);
        this.lrq.getLayoutMode().setNightMode(z);
        this.lrq.getLayoutMode().onModeChanged(view);
        return view;
    }

    private String J(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.lrr = true;
        if (0 < j3 && j3 <= 86400) {
            return this.lrq.getPageContext().getString(R.string.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return "1";
        }
        if (172800 < j3 && j3 <= 259200) {
            return "2";
        }
        return "3";
    }

    private SpannableString Oe(String str) {
        SpannableString spannableString = new SpannableString(this.lrq.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.lrq.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            bVar = new b();
            bVar.lrG = (HeadImageView) view.findViewById(R.id.item_portrait);
            bVar.mTitle = (TextView) view.findViewById(R.id.title);
            bVar.aju = (TextView) view.findViewById(R.id.description);
            bVar.lrH = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            bVar.lrH.setVisibility(8);
        }
        a.C0795a c0795a = (a.C0795a) getItem(i);
        bVar.lrG.startLoad(c0795a.lrc, 10, false);
        bVar.mTitle.setText(c0795a.mTitle);
        bVar.aju.setText(c0795a.mDesc);
        this.lrq.getLayoutMode().setNightMode(z);
        this.lrq.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        public TextView aju;
        public HeadImageView lrG;
        public ImageView lrH;
        public TextView mTitle;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public TextView lrA;
        public TextView lrB;
        public ImageView lrC;
        public ImageView lrD;
        public TextView lrE;
        public TextView lrF;
        public HeadImageView lrt;
        public RelativeLayout lru;
        public RelativeLayout lrv;
        public TextView lrw;
        public TextView lrx;
        public TbImageView lry;
        public TextView lrz;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0796c {
        public TextView lrI;

        private C0796c() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
