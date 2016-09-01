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
    public View aOh;
    public int ait;
    public BdTypeListView bBT;
    public PbActivity ejJ;
    public DealInfoData ejK;
    public View ejN;
    public View ejO;
    public int id;

    public b(int i) {
        this.id = i;
    }

    public void aLC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }
}
