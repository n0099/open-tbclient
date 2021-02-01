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
    private List<d> jRh;
    private LayoutInflater layoutInflater;

    public e(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<d> list) {
        this.jRh = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jRh == null) {
            return 0;
        }
        return this.jRh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EB */
    public d getItem(int i) {
        if (this.jRh == null) {
            return null;
        }
        return this.jRh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jRh == null) {
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
        aVar.lpN.setText(dVar.name);
        ap.setViewTextColor(aVar.lpN, R.color.CAM_X0106);
        SvgManager.bsR().a(aVar.lpM, dVar.lpL, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class a {
        private ImageView lpM;
        private TextView lpN;

        public a(View view) {
            this.lpM = (ImageView) view.findViewById(R.id.member_privilege_pic);
            this.lpN = (TextView) view.findViewById(R.id.member_privilege_name);
        }
    }
}
