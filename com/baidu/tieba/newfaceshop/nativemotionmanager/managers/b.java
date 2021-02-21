package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<EmotionPackageData> caS;
    private BdListView lDj;
    private SingleThreadEmotionHorizontalAdater lDu;
    private e lDv;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.lDj = bdListView;
        this.lDv = new e(tbPageContext);
        this.lDv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lDj.addHeaderView(this.lDv.getView());
        this.caS = new ArrayList();
        this.lDu = new SingleThreadEmotionHorizontalAdater(this.caS, tbPageContext);
        this.lDj.setAdapter((ListAdapter) this.lDu);
    }

    public void fa(List<EmotionPackageData> list) {
        if (list != null && this.lDv != null && this.lDu != null) {
            this.lDv.t(Integer.valueOf(list.size()));
            this.caS.clear();
            if (list != null) {
                this.caS.addAll(list);
            }
            this.lDu.notifyDataSetChanged();
        }
    }
}
