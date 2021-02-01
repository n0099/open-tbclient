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
    private BdListView lCV;
    private SingleThreadEmotionHorizontalAdater lDg;
    private e lDh;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.lCV = bdListView;
        this.lDh = new e(tbPageContext);
        this.lDh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lCV.addHeaderView(this.lDh.getView());
        this.caS = new ArrayList();
        this.lDg = new SingleThreadEmotionHorizontalAdater(this.caS, tbPageContext);
        this.lCV.setAdapter((ListAdapter) this.lDg);
    }

    public void fa(List<EmotionPackageData> list) {
        if (list != null && this.lDh != null && this.lDg != null) {
            this.lDh.t(Integer.valueOf(list.size()));
            this.caS.clear();
            if (list != null) {
                this.caS.addAll(list);
            }
            this.lDg.notifyDataSetChanged();
        }
    }
}
