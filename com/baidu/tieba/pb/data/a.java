package com.baidu.tieba.pb.data;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ct;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public ArrayList<v> bHW;
    public List<com.baidu.adp.widget.ListView.a> bRh;
    public PbActivity erE;
    public DealInfoData erF;
    public View.OnClickListener erG;
    public ct erH;
    public int id;

    public a(int i) {
        this.id = i;
    }

    public void aNX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_ADAPTER, this));
    }
}
