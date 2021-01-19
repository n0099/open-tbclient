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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private MemberPrivilegeActivity ljk;
    private boolean ljl = false;
    private ArrayList<Object> ljm = new ArrayList<>();
    private int mMemberType;

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.ljk = memberPrivilegeActivity;
    }

    public void a(com.baidu.tieba.memberCenter.memberprivilege.a aVar) {
        this.ljm.clear();
        if (aVar != null && aVar.liT != null && aVar.liU != null) {
            List<a.c> list = aVar.liU;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.liT);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.mClassName) && cVar.liZ != null && cVar.liZ.size() != 0 && aP(cVar.liZ)) {
                    arrayList.add(cVar.mClassName);
                    Iterator<a.C0793a> it = cVar.liZ.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.ljm.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean aP(ArrayList<a.C0793a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        aQ(arrayList);
        return arrayList.size() > 0;
    }

    public void aQ(ArrayList<a.C0793a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<a.C0793a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.C0793a next = it.next();
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
        if (this.ljm == null) {
            return 0;
        }
        return this.ljm.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ljm == null || i < 0 || i >= this.ljm.size()) {
            return null;
        }
        return this.ljm.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ljm == null || i < 0 || i > getCount() || i >= this.ljm.size()) {
            return 3;
        }
        Object obj = this.ljm.get(i);
        if (obj instanceof a.e) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        return obj instanceof a.C0793a ? 2 : 3;
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
        C0794c c0794c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0794c)) {
            view = LayoutInflater.from(this.ljk.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            c0794c = new C0794c();
            c0794c.ljC = (TextView) view.findViewById(R.id.title_view);
            view.setTag(c0794c);
        } else {
            c0794c = (C0794c) view.getTag();
        }
        c0794c.ljC.setText((String) getItem(i));
        this.ljk.getLayoutMode().setNightMode(z);
        this.ljk.getLayoutMode().onModeChanged(view);
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
            view = LayoutInflater.from(this.ljk.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            aVar = new a();
            aVar.ljn = (HeadImageView) view.findViewById(R.id.head_portrait);
            aVar.ljo = (RelativeLayout) view.findViewById(R.id.nonmember_stamp);
            aVar.ljr = (TextView) view.findViewById(R.id.nonmembername);
            aVar.ljp = (RelativeLayout) view.findViewById(R.id.member_stamp);
            aVar.ljq = (TextView) view.findViewById(R.id.membername);
            aVar.ljs = (TbImageView) view.findViewById(R.id.membericon);
            aVar.ljw = (ImageView) view.findViewById(R.id.vip_bean_icon);
            aVar.ljx = (ImageView) view.findViewById(R.id.nonmember_bean_icon);
            aVar.ljy = (TextView) view.findViewById(R.id.vip_tbean_num);
            aVar.ljz = (TextView) view.findViewById(R.id.nonmember_tbean_num);
            aVar.ljt = (TextView) view.findViewById(R.id.endtime);
            aVar.lju = (TextView) view.findViewById(R.id.left_button);
            aVar.ljv = (TextView) view.findViewById(R.id.right_button);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (!TbadkApplication.getInst().appResponseToCmd(1001533)) {
            aVar.ljv.setVisibility(8);
        } else {
            aVar.ljv.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar = eVar.ljf) == null || (dVar = eVar.ljg) == null) {
            return null;
        }
        long j = dVar.ljc + dVar.ljd;
        this.mMemberType = (int) bVar.lhU;
        long j2 = bVar.liW;
        String F = F(j2, bVar.liX);
        aVar.ljn.startLoad(eVar.mPortrait, 25, false);
        ao.setBackgroundResource(aVar.ljn, R.drawable.memberinfo_bg_shape);
        if (!dVar.isValid()) {
            j = 0;
        }
        if (bVar.isValid() && dVar.isValid()) {
            aVar.ljo.setVisibility(8);
            aVar.ljp.setVisibility(0);
            aVar.ljs.startLoad(eVar.ljf.liY, 21, false);
            if (this.ljl) {
                aVar.ljt.setText(Nq(F));
            } else {
                if (1 == this.mMemberType) {
                    string = this.ljk.getPageContext().getString(R.string.member);
                } else {
                    string = this.ljk.getPageContext().getString(R.string.vip_member);
                }
                aVar.ljt.setText(this.ljk.getResources().getString(R.string.endtiem_memeber_tip, string, at.getDateStringDay(new Date(j2 * 1000))));
                ao.setViewTextColor(aVar.ljt, R.color.CAM_X0101, 1);
            }
            aVar.ljq.setText(eVar.mName);
            aVar.lju.setText(this.mMemberType == 1 ? R.string.continue_member : R.string.continue_vip_member);
            aVar.lju.setOnClickListener(this.ljk);
            aVar.ljy.setText(String.valueOf(j));
            ao.setImageResource(aVar.ljw, R.drawable.icon_vip_dou);
        } else {
            aVar.ljo.setVisibility(0);
            aVar.ljp.setVisibility(8);
            aVar.ljr.setText(eVar.mName);
            aVar.lju.setText(R.string.dredge_member);
            aVar.lju.setOnClickListener(this.ljk);
            aVar.ljz.setText(String.valueOf(j));
            ao.setImageResource(aVar.ljx, R.drawable.icon_vip_dou);
        }
        ao.setBackgroundResource(aVar.ljt, R.drawable.bg_dredge_tips);
        aVar.ljv.setOnClickListener(this.ljk);
        this.ljk.getLayoutMode().setNightMode(z);
        this.ljk.getLayoutMode().onModeChanged(view);
        return view;
    }

    private String F(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.ljl = true;
        if (0 < j3 && j3 <= 86400) {
            return this.ljk.getPageContext().getString(R.string.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return "1";
        }
        if (172800 < j3 && j3 <= 259200) {
            return "2";
        }
        return "3";
    }

    private SpannableString Nq(String str) {
        SpannableString spannableString = new SpannableString(this.ljk.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.ljk.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            bVar = new b();
            bVar.ljA = (HeadImageView) view.findViewById(R.id.item_portrait);
            bVar.mTitle = (TextView) view.findViewById(R.id.title);
            bVar.ajF = (TextView) view.findViewById(R.id.description);
            bVar.ljB = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            bVar.ljB.setVisibility(8);
        }
        a.C0793a c0793a = (a.C0793a) getItem(i);
        bVar.ljA.startLoad(c0793a.liV, 10, false);
        bVar.mTitle.setText(c0793a.mTitle);
        bVar.ajF.setText(c0793a.mDesc);
        this.ljk.getLayoutMode().setNightMode(z);
        this.ljk.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        public TextView ajF;
        public HeadImageView ljA;
        public ImageView ljB;
        public TextView mTitle;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        public HeadImageView ljn;
        public RelativeLayout ljo;
        public RelativeLayout ljp;
        public TextView ljq;
        public TextView ljr;
        public TbImageView ljs;
        public TextView ljt;
        public TextView lju;
        public TextView ljv;
        public ImageView ljw;
        public ImageView ljx;
        public TextView ljy;
        public TextView ljz;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0794c {
        public TextView ljC;

        private C0794c() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
