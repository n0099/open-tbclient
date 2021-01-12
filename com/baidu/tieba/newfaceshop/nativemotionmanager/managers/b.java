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
    private List<EmotionPackageData> bWQ;
    private BdListView luR;
    private SingleThreadEmotionHorizontalAdater lvc;
    private e lvd;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.luR = bdListView;
        this.lvd = new e(tbPageContext);
        this.lvd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.luR.addHeaderView(this.lvd.getView());
        this.bWQ = new ArrayList();
        this.lvc = new SingleThreadEmotionHorizontalAdater(this.bWQ, tbPageContext);
        this.luR.setAdapter((ListAdapter) this.lvc);
    }

    public void fc(List<EmotionPackageData> list) {
        if (list != null && this.lvd != null && this.lvc != null) {
            this.lvd.s(Integer.valueOf(list.size()));
            this.bWQ.clear();
            if (list != null) {
                this.bWQ.addAll(list);
            }
            this.lvc.notifyDataSetChanged();
        }
    }
}
