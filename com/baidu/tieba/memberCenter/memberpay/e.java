package com.baidu.tieba.memberCenter.memberpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private List<d> jRv;
    private LayoutInflater layoutInflater;

    public e(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<d> list) {
        this.jRv = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jRv == null) {
            return 0;
        }
        return this.jRv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EB */
    public d getItem(int i) {
        if (this.jRv == null) {
            return null;
        }
        return this.jRv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jRv == null) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.layoutInflater.inflate(R.layout.member_pay_privilege_list_item, (ViewGroup) null);
            view.setTag(new a(view));
        }
        a(getItem(i), (a) view.getTag());
        return view;
    }

    private void a(d dVar, a aVar) {
        if (dVar == null) {
            return;
        }
        aVar.lqb.setText(dVar.name);
        ap.setViewTextColor(aVar.lqb, R.color.CAM_X0106);
        SvgManager.bsR().a(aVar.lqa, dVar.lpZ, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class a {
        private ImageView lqa;
        private TextView lqb;

        public a(View view) {
            this.lqa = (ImageView) view.findViewById(R.id.member_privilege_pic);
            this.lqb = (TextView) view.findViewById(R.id.member_privilege_name);
        }
    }
}
