package com.baidu.tieba.square.view;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.c;
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
    private TbPageContext<?> cVg;
    private CoverFlowView<i> kdt;
    private HashSet<String> kds = new HashSet<>();
    private ArrayList<i> datas = new ArrayList<>();
    private d<i> cWl = new d<i>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void Q(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            i iVar = (i) v.getItem(a.this.datas, i);
            String cJP = iVar != null ? iVar.cJP() : null;
            if (ba.aGE().b(a.this.cVg, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(cJP)) {
                TiebaStatic.eventStat(a.this.cVg.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(cJP), "obj_name", String.valueOf(cJP), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", PraiseDataPassUtil.KEY_FROM_OS, BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.cVg.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, i iVar) {
            if (iVar != null) {
                String cJP = iVar.cJP();
                if (i == 2 && !TextUtils.isEmpty(cJP) && a.this.kds.add(cJP)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(cJP), "obj_name", String.valueOf(cJP), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", PraiseDataPassUtil.KEY_FROM_OS, BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.kdt = null;
        this.cVg = tbPageContext;
        this.kdt = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.kdt.setCoverFlowFactory(new b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e aES() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c aER() {
                c aER = super.aER();
                if (aER != null) {
                    aER.setGravity(85);
                    aER.km(R.dimen.ds20);
                    aER.kn(R.dimen.ds30);
                }
                return aER;
            }
        });
        this.kdt.setCallback(this.cWl);
    }

    public void setData(ArrayList<bg> arrayList) {
        ArrayList<i> arrayList2 = new ArrayList<>();
        Iterator<bg> it = arrayList.iterator();
        while (it.hasNext()) {
            bg next = it.next();
            if (next != null) {
                arrayList2.add(new i(next));
            }
        }
        this.datas = arrayList2;
        this.kdt.setData(arrayList2);
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
        return this.kdt;
    }

    public void onChangeSkinType(int i) {
        if (this.kdt != null) {
            this.kdt.onChangeSkinType();
        }
    }

    public CoverFlowView<i> cJW() {
        return this.kdt;
    }
}
