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
    private List<EmotionPackageData> cbD;
    private SingleThreadEmotionHorizontalAdater lzI;
    private e lzJ;
    private BdListView lzx;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.lzx = bdListView;
        this.lzJ = new e(tbPageContext);
        this.lzJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lzx.addHeaderView(this.lzJ.getView());
        this.cbD = new ArrayList();
        this.lzI = new SingleThreadEmotionHorizontalAdater(this.cbD, tbPageContext);
        this.lzx.setAdapter((ListAdapter) this.lzI);
    }

    public void fc(List<EmotionPackageData> list) {
        if (list != null && this.lzJ != null && this.lzI != null) {
            this.lzJ.s(Integer.valueOf(list.size()));
            this.cbD.clear();
            if (list != null) {
                this.cbD.addAll(list);
            }
            this.lzI.notifyDataSetChanged();
        }
    }
}
