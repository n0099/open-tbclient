package com.baidu.tieba.square.view;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.c;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> ceu;
    private CoverFlowView<g> jeA;
    private HashSet<String> jez = new HashSet<>();
    private ArrayList<g> datas = new ArrayList<>();
    private d<g> cfA = new d<g>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void E(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            g gVar = (g) v.getItem(a.this.datas, i);
            String cmZ = gVar != null ? gVar.cmZ() : null;
            if (ba.amO().b(a.this.ceu, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(cmZ)) {
                TiebaStatic.eventStat(a.this.ceu.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(cmZ), "obj_name", String.valueOf(cmZ), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.ceu.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, g gVar) {
            if (gVar != null) {
                String cmZ = gVar.cmZ();
                if (i == 2 && !TextUtils.isEmpty(cmZ) && a.this.jez.add(cmZ)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(cmZ), "obj_name", String.valueOf(cmZ), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.jeA = null;
        this.ceu = tbPageContext;
        this.jeA = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.jeA.setCoverFlowFactory(new b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e alf() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c ale() {
                c ale = super.ale();
                if (ale != null) {
                    ale.setGravity(85);
                    ale.ij(R.dimen.ds20);
                    ale.ik(R.dimen.ds30);
                }
                return ale;
            }
        });
        this.jeA.setCallback(this.cfA);
    }

    public void setData(ArrayList<be> arrayList) {
        ArrayList<g> arrayList2 = new ArrayList<>();
        Iterator<be> it = arrayList.iterator();
        while (it.hasNext()) {
            be next = it.next();
            if (next != null) {
                arrayList2.add(new g(next));
            }
        }
        this.datas = arrayList2;
        this.jeA.setData(arrayList2);
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
        return this.jeA;
    }

    public void onChangeSkinType(int i) {
        if (this.jeA != null) {
            this.jeA.onChangeSkinType();
        }
    }

    public CoverFlowView<g> cng() {
        return this.jeA;
    }
}
