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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> dVN;
    private CoverFlowView<i> lJS;
    private HashSet<String> lJR = new HashSet<>();
    private ArrayList<i> datas = new ArrayList<>();
    private d<i> dXb = new d<i>() { // from class: com.baidu.tieba.square.view.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
            i iVar = (i) x.getItem(a.this.datas, i);
            String djY = iVar != null ? iVar.djY() : null;
            if (bd.baV().b(a.this.dVN, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(djY)) {
                TiebaStatic.eventStat(a.this.dVN.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(djY), "obj_name", String.valueOf(djY), "obj_cpid", 0, TiebaInitialize.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE, "log_ver", "1.1");
            }
            TiebaStatic.eventStat(a.this.dVN.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, i iVar) {
            if (iVar != null) {
                String djY = iVar.djY();
                if (i == 2 && !TextUtils.isEmpty(djY) && a.this.lJR.add(djY)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(djY), "obj_name", String.valueOf(djY), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", "os_version", Build.VERSION.RELEASE);
                }
            }
        }
    };

    public a(final TbPageContext<?> tbPageContext) {
        this.lJS = null;
        this.dVN = tbPageContext;
        this.lJS = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.lJS.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.square.view.a.2
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e so() {
                e eVar = new e();
                eVar.setHeight(tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c sp() {
                com.baidu.tbadk.core.flow.a.c sp = super.sp();
                if (sp != null) {
                    sp.setGravity(85);
                    sp.lD(R.dimen.ds20);
                    sp.lE(R.dimen.ds30);
                }
                return sp;
            }
        });
        this.lJS.setCallback(this.dXb);
    }

    public void setData(ArrayList<bs> arrayList) {
        ArrayList<i> arrayList2 = new ArrayList<>();
        Iterator<bs> it = arrayList.iterator();
        while (it.hasNext()) {
            bs next = it.next();
            if (next != null) {
                arrayList2.add(new i(next));
            }
        }
        this.datas = arrayList2;
        this.lJS.setData(arrayList2);
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
        return this.lJS;
    }

    public void onChangeSkinType(int i) {
        if (this.lJS != null) {
            this.lJS.onChangeSkinType();
        }
    }

    public CoverFlowView<i> dkf() {
        return this.lJS;
    }
}
