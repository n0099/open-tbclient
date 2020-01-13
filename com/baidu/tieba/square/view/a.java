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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> cRe;
    private CoverFlowView<i> kcp;
    private HashSet<String> kco = new HashSet<>();
    private ArrayList<i> datas = new ArrayList<>();
    private d<i> cSj = new d<i>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void O(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            i iVar = (i) v.getItem(a.this.datas, i);
            String cIj = iVar != null ? iVar.cIj() : null;
            if (ba.aEt().b(a.this.cRe, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(cIj)) {
                TiebaStatic.eventStat(a.this.cRe.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(cIj), "obj_name", String.valueOf(cIj), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", PraiseDataPassUtil.KEY_FROM_OS, BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.cRe.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, i iVar) {
            if (iVar != null) {
                String cIj = iVar.cIj();
                if (i == 2 && !TextUtils.isEmpty(cIj) && a.this.kco.add(cIj)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(cIj), "obj_name", String.valueOf(cIj), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", PraiseDataPassUtil.KEY_FROM_OS, BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.kcp = null;
        this.cRe = tbPageContext;
        this.kcp = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.kcp.setCoverFlowFactory(new b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e aCI() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c aCH() {
                c aCH = super.aCH();
                if (aCH != null) {
                    aCH.setGravity(85);
                    aCH.jV(R.dimen.ds20);
                    aCH.jW(R.dimen.ds30);
                }
                return aCH;
            }
        });
        this.kcp.setCallback(this.cSj);
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
        this.kcp.setData(arrayList2);
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
        return this.kcp;
    }

    public void onChangeSkinType(int i) {
        if (this.kcp != null) {
            this.kcp.onChangeSkinType();
        }
    }

    public CoverFlowView<i> cIq() {
        return this.kcp;
    }
}
