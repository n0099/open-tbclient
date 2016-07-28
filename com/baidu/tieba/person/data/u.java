package com.baidu.tieba.person.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personInfo.bn;
import java.util.ArrayList;
import java.util.List;
import tbclient.DealWindow;
/* loaded from: classes.dex */
public class u {
    public ArrayList<v> TM;
    public BaseFragmentActivity activity;
    public List<com.baidu.adp.widget.ListView.a> bCN;
    public boolean cjo;
    public bn ers;
    public CustomResponsedMessage<?> esB;
    public v esC;
    public int id;
    public UserData mUserData;
    public DealWindow window;

    public u(int i) {
        this.id = i;
    }

    public void aGK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }
}
