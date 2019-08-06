package com.baidu.tieba.square.view;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.c;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private CoverFlowView<g> jdf;
    private TbPageContext<?> mContext;
    private HashSet<String> jde = new HashSet<>();
    private ArrayList<g> datas = new ArrayList<>();
    private d<g> bON = new d<g>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void B(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            g gVar = (g) v.c(a.this.datas, i);
            String cox = gVar != null ? gVar.cox() : null;
            if (bb.ajE().c(a.this.mContext, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(cox)) {
                TiebaStatic.eventStat(a.this.mContext.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "CLICK", "task", "tbanner", VideoPlayActivityConfig.OBJ_ID, String.valueOf(cox), "obj_name", String.valueOf(cox), "obj_cpid", 0, "obj_url", str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), IXAdRequestInfo.OS, "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.mContext.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, g gVar) {
            if (gVar != null) {
                String cox = gVar.cox();
                if (i == 2 && !TextUtils.isEmpty(cox) && a.this.jde.add(cox)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "VIEW_TRUE", "task", "tbanner", VideoPlayActivityConfig.OBJ_ID, String.valueOf(cox), "obj_name", String.valueOf(cox), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), IXAdRequestInfo.OS, "android", "os_version", Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.jdf = null;
        this.mContext = tbPageContext;
        this.jdf = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.jdf.setCoverFlowFactory(new b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e ahg() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c ahf() {
                c ahf = super.ahf();
                if (ahf != null) {
                    ahf.setGravity(85);
                    ahf.hP(R.dimen.ds20);
                    ahf.hQ(R.dimen.ds30);
                }
                return ahf;
            }
        });
        this.jdf.setCallback(this.bON);
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
        this.jdf.setData(arrayList2);
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
        return this.jdf;
    }

    public void onChangeSkinType(int i) {
        if (this.jdf != null) {
            this.jdf.onChangeSkinType();
        }
    }

    public CoverFlowView<g> coE() {
        return this.jdf;
    }
}
