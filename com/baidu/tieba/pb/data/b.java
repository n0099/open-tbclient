package com.baidu.tieba.pb.data;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b {
    public View aJF;
    public int afy;
    public BdTypeListView bqG;
    public PbActivity dXE;
    public DealInfoData dXF;
    public View dXI;
    public View dXJ;
    public int id;

    public b(int i) {
        this.id = i;
    }

    public void aGK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }
}
