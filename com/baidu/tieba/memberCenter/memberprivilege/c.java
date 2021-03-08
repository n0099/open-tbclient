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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private MemberPrivilegeActivity ltH;
    private boolean ltI = false;
    private ArrayList<Object> ltJ = new ArrayList<>();
    private int mMemberType;

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.ltH = memberPrivilegeActivity;
    }

    public void a(com.baidu.tieba.memberCenter.memberprivilege.a aVar) {
        this.ltJ.clear();
        if (aVar != null && aVar.ltq != null && aVar.lts != null) {
            List<a.c> list = aVar.lts;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.ltq);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.mClassName) && cVar.ltx != null && cVar.ltx.size() != 0 && aO(cVar.ltx)) {
                    arrayList.add(cVar.mClassName);
                    Iterator<a.C0802a> it = cVar.ltx.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            }
            this.ltJ.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public boolean aO(ArrayList<a.C0802a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        aP(arrayList);
        return arrayList.size() > 0;
    }

    public void aP(ArrayList<a.C0802a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<a.C0802a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.C0802a next = it.next();
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
        if (this.ltJ == null) {
            return 0;
        }
        return this.ltJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ltJ == null || i < 0 || i >= this.ltJ.size()) {
            return null;
        }
        return this.ltJ.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ltJ == null || i < 0 || i > getCount() || i >= this.ltJ.size()) {
            return 3;
        }
        Object obj = this.ltJ.get(i);
        if (obj instanceof a.e) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        return obj instanceof a.C0802a ? 2 : 3;
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
        C0803c c0803c;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0803c)) {
            view = LayoutInflater.from(this.ltH.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
            c0803c = new C0803c();
            c0803c.ltZ = (TextView) view.findViewById(R.id.title_view);
            view.setTag(c0803c);
        } else {
            c0803c = (C0803c) view.getTag();
        }
        c0803c.ltZ.setText((String) getItem(i));
        this.ltH.getLayoutMode().setNightMode(z);
        this.ltH.getLayoutMode().onModeChanged(view);
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
            view = LayoutInflater.from(this.ltH.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
            aVar = new a();
            aVar.ltK = (HeadImageView) view.findViewById(R.id.head_portrait);
            aVar.ltL = (RelativeLayout) view.findViewById(R.id.nonmember_stamp);
            aVar.ltO = (TextView) view.findViewById(R.id.nonmembername);
            aVar.ltM = (RelativeLayout) view.findViewById(R.id.member_stamp);
            aVar.ltN = (TextView) view.findViewById(R.id.membername);
            aVar.ltP = (TbImageView) view.findViewById(R.id.membericon);
            aVar.ltT = (ImageView) view.findViewById(R.id.vip_bean_icon);
            aVar.ltU = (ImageView) view.findViewById(R.id.nonmember_bean_icon);
            aVar.ltV = (TextView) view.findViewById(R.id.vip_tbean_num);
            aVar.ltW = (TextView) view.findViewById(R.id.nonmember_tbean_num);
            aVar.ltQ = (TextView) view.findViewById(R.id.endtime);
            aVar.ltR = (TextView) view.findViewById(R.id.left_button);
            aVar.ltS = (TextView) view.findViewById(R.id.right_button);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (!TbadkApplication.getInst().appResponseToCmd(1001533)) {
            aVar.ltS.setVisibility(8);
        } else {
            aVar.ltS.setVisibility(0);
        }
        if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar = eVar.ltC) == null || (dVar = eVar.ltD) == null) {
            return null;
        }
        long j = dVar.ltA + dVar.ltB;
        this.mMemberType = (int) bVar.lsr;
        long j2 = bVar.ltu;
        String J = J(j2, bVar.ltv);
        aVar.ltK.startLoad(eVar.mPortrait, 25, false);
        ap.setBackgroundResource(aVar.ltK, R.drawable.memberinfo_bg_shape);
        if (!dVar.isValid()) {
            j = 0;
        }
        if (bVar.isValid() && dVar.isValid()) {
            aVar.ltL.setVisibility(8);
            aVar.ltM.setVisibility(0);
            aVar.ltP.startLoad(eVar.ltC.ltw, 21, false);
            if (this.ltI) {
                aVar.ltQ.setText(Ol(J));
            } else {
                if (1 == this.mMemberType) {
                    string = this.ltH.getPageContext().getString(R.string.member);
                } else {
                    string = this.ltH.getPageContext().getString(R.string.vip_member);
                }
                aVar.ltQ.setText(this.ltH.getResources().getString(R.string.endtiem_memeber_tip, string, au.getDateStringDay(new Date(j2 * 1000))));
                ap.setViewTextColor(aVar.ltQ, R.color.CAM_X0101, 1);
            }
            aVar.ltN.setText(eVar.mName);
            aVar.ltR.setText(this.mMemberType == 1 ? R.string.continue_member : R.string.continue_vip_member);
            aVar.ltR.setOnClickListener(this.ltH);
            aVar.ltV.setText(String.valueOf(j));
            ap.setImageResource(aVar.ltT, R.drawable.icon_vip_dou);
        } else {
            aVar.ltL.setVisibility(0);
            aVar.ltM.setVisibility(8);
            aVar.ltO.setText(eVar.mName);
            aVar.ltR.setText(R.string.dredge_member);
            aVar.ltR.setOnClickListener(this.ltH);
            aVar.ltW.setText(String.valueOf(j));
            ap.setImageResource(aVar.ltU, R.drawable.icon_vip_dou);
        }
        ap.setBackgroundResource(aVar.ltQ, R.drawable.bg_dredge_tips);
        aVar.ltS.setOnClickListener(this.ltH);
        this.ltH.getLayoutMode().setNightMode(z);
        this.ltH.getLayoutMode().onModeChanged(view);
        return view;
    }

    private String J(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.ltI = true;
        if (0 < j3 && j3 <= 86400) {
            return this.ltH.getPageContext().getString(R.string.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return "1";
        }
        if (172800 < j3 && j3 <= 259200) {
            return "2";
        }
        return "3";
    }

    private SpannableString Ol(String str) {
        SpannableString spannableString = new SpannableString(this.ltH.getResources().getString(R.string.endtime_days_tip, str));
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105)), 0, 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0308)), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105)), 5, 16, 33);
        return spannableString;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        b bVar;
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.ltH.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
            bVar = new b();
            bVar.ltX = (HeadImageView) view.findViewById(R.id.item_portrait);
            bVar.mTitle = (TextView) view.findViewById(R.id.title);
            bVar.akM = (TextView) view.findViewById(R.id.description);
            bVar.ltY = (ImageView) view.findViewById(R.id.divide_line_top);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i - 1) == 1) {
            bVar.ltY.setVisibility(8);
        }
        a.C0802a c0802a = (a.C0802a) getItem(i);
        bVar.ltX.startLoad(c0802a.ltt, 10, false);
        bVar.mTitle.setText(c0802a.mTitle);
        bVar.akM.setText(c0802a.mDesc);
        this.ltH.getLayoutMode().setNightMode(z);
        this.ltH.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        public TextView akM;
        public HeadImageView ltX;
        public ImageView ltY;
        public TextView mTitle;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        public HeadImageView ltK;
        public RelativeLayout ltL;
        public RelativeLayout ltM;
        public TextView ltN;
        public TextView ltO;
        public TbImageView ltP;
        public TextView ltQ;
        public TextView ltR;
        public TextView ltS;
        public ImageView ltT;
        public ImageView ltU;
        public TextView ltV;
        public TextView ltW;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.memberCenter.memberprivilege.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0803c {
        public TextView ltZ;

        private C0803c() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
