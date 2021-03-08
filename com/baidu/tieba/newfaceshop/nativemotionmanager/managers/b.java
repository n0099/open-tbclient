package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private List<EmotionPackageData> ccu;
    private BdListView lFl;
    private SingleThreadEmotionHorizontalAdater lFw;
    private e lFx;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.lFl = bdListView;
        this.lFx = new e(tbPageContext);
        this.lFx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lFl.addHeaderView(this.lFx.getView());
        this.ccu = new ArrayList();
        this.lFw = new SingleThreadEmotionHorizontalAdater(this.ccu, tbPageContext);
        this.lFl.setAdapter((ListAdapter) this.lFw);
    }

    public void fa(List<EmotionPackageData> list) {
        if (list != null && this.lFx != null && this.lFw != null) {
            this.lFx.t(Integer.valueOf(list.size()));
            this.ccu.clear();
            if (list != null) {
                this.ccu.addAll(list);
            }
            this.lFw.notifyDataSetChanged();
        }
    }
}
