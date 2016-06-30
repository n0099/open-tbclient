package com.baidu.tieba.pb.data;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cr;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public List<com.baidu.adp.widget.ListView.a> bAz;
    public ArrayList<v> brq;
    public PbActivity dLv;
    public DealInfoData dLw;
    public View.OnClickListener dLx;
    public cr dLy;
    public int id;

    public a(int i) {
        this.id = i;
    }

    public void aDA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_ADAPTER, this));
    }
}
