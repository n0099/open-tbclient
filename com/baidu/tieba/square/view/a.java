package com.baidu.tieba.square.view;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> dIF;
    private CoverFlowView<i> lhx;
    private HashSet<String> lhw = new HashSet<>();
    private ArrayList<i> datas = new ArrayList<>();
    private d<i> dJT = new d<i>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void am(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            i iVar = (i) v.getItem(a.this.datas, i);
            String dck = iVar != null ? iVar.dck() : null;
            if (ba.aUZ().b(a.this.dIF, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(dck)) {
                TiebaStatic.eventStat(a.this.dIF.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(dck), "obj_name", String.valueOf(dck), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.dIF.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, i iVar) {
            if (iVar != null) {
                String dck = iVar.dck();
                if (i == 2 && !TextUtils.isEmpty(dck) && a.this.lhw.add(dck)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(dck), "obj_name", String.valueOf(dck), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.lhx = null;
        this.dIF = tbPageContext;
        this.lhx = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.lhx.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e aTo() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c aTn() {
                com.baidu.tbadk.core.flow.a.c aTn = super.aTn();
                if (aTn != null) {
                    aTn.setGravity(85);
                    aTn.kT(R.dimen.ds20);
                    aTn.kU(R.dimen.ds30);
                }
                return aTn;
            }
        });
        this.lhx.setCallback(this.dJT);
    }

    public void setData(ArrayList<bh> arrayList) {
        ArrayList<i> arrayList2 = new ArrayList<>();
        Iterator<bh> it = arrayList.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                arrayList2.add(new i(next));
            }
        }
        this.datas = arrayList2;
        this.lhx.setData(arrayList2);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.datas != null ? this.datas.size() + 0 : 0) > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.lhx;
    }

    public void onChangeSkinType(int i) {
        if (this.lhx != null) {
            this.lhx.onChangeSkinType();
        }
    }

    public CoverFlowView<i> dcr() {
        return this.lhx;
    }
}
