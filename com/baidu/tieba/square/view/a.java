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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> dPv;
    private CoverFlowView<i> lCB;
    private HashSet<String> lCA = new HashSet<>();
    private ArrayList<i> datas = new ArrayList<>();
    private d<i> dQJ = new d<i>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            i iVar = (i) w.getItem(a.this.datas, i);
            String dgP = iVar != null ? iVar.dgP() : null;
            if (bc.aWU().b(a.this.dPv, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(dgP)) {
                TiebaStatic.eventStat(a.this.dPv.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(dgP), "obj_name", String.valueOf(dgP), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.dPv.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, i iVar) {
            if (iVar != null) {
                String dgP = iVar.dgP();
                if (i == 2 && !TextUtils.isEmpty(dgP) && a.this.lCA.add(dgP)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(dgP), "obj_name", String.valueOf(dgP), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.lCB = null;
        this.dPv = tbPageContext;
        this.lCB = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.lCB.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e sm() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c sn() {
                com.baidu.tbadk.core.flow.a.c sn = super.sn();
                if (sn != null) {
                    sn.setGravity(85);
                    sn.lj(R.dimen.ds20);
                    sn.lk(R.dimen.ds30);
                }
                return sn;
            }
        });
        this.lCB.setCallback(this.dQJ);
    }

    public void setData(ArrayList<br> arrayList) {
        ArrayList<i> arrayList2 = new ArrayList<>();
        Iterator<br> it = arrayList.iterator();
        while (it.hasNext()) {
            br next = it.next();
            if (next != null) {
                arrayList2.add(new i(next));
            }
        }
        this.datas = arrayList2;
        this.lCB.setData(arrayList2);
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
        return this.lCB;
    }

    public void onChangeSkinType(int i) {
        if (this.lCB != null) {
            this.lCB.onChangeSkinType();
        }
    }

    public CoverFlowView<i> dgW() {
        return this.lCB;
    }
}
