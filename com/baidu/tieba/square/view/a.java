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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> ehG;
    private CoverFlowView<i> mlq;
    private HashSet<String> mlp = new HashSet<>();
    private ArrayList<i> datas = new ArrayList<>();
    private d<i> eiV = new d<i>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void e(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            i iVar = (i) y.getItem(a.this.datas, i);
            String dzt = iVar != null ? iVar.dzt() : null;
            if (be.bkp().b(a.this.ehG, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(dzt)) {
                TiebaStatic.eventStat(a.this.ehG.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(dzt), "obj_name", String.valueOf(dzt), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.ehG.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, i iVar) {
            if (iVar != null) {
                String dzt = iVar.dzt();
                if (i == 2 && !TextUtils.isEmpty(dzt) && a.this.mlp.add(dzt)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(dzt), "obj_name", String.valueOf(dzt), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.mlq = null;
        this.ehG = tbPageContext;
        this.mlq = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.mlq.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e uf() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c ug() {
                com.baidu.tbadk.core.flow.a.c ug = super.ug();
                if (ug != null) {
                    ug.setGravity(85);
                    ug.nV(R.dimen.ds20);
                    ug.nW(R.dimen.ds30);
                }
                return ug;
            }
        });
        this.mlq.setCallback(this.eiV);
    }

    public void setData(ArrayList<bt> arrayList) {
        ArrayList<i> arrayList2 = new ArrayList<>();
        Iterator<bt> it = arrayList.iterator();
        while (it.hasNext()) {
            bt next = it.next();
            if (next != null) {
                arrayList2.add(new i(next));
            }
        }
        this.datas = arrayList2;
        this.mlq.setData(arrayList2);
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
        return this.mlq;
    }

    public void onChangeSkinType(int i) {
        if (this.mlq != null) {
            this.mlq.onChangeSkinType();
        }
    }

    public CoverFlowView<i> dzA() {
        return this.mlq;
    }
}
