package com.baidu.tieba.person.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personInfo.bp;
import java.util.ArrayList;
import java.util.List;
import tbclient.DealWindow;
/* loaded from: classes.dex */
public class v {
    public ArrayList<com.baidu.adp.widget.ListView.v> Te;
    public BaseFragmentActivity activity;
    public List<com.baidu.adp.widget.ListView.a> bAz;
    public boolean chd;
    public bp eht;
    public CustomResponsedMessage<?> eix;
    public com.baidu.adp.widget.ListView.v eiy;
    public int id;
    public UserData mUserData;
    public DealWindow window;

    public v(int i) {
        this.id = i;
    }

    public void aDA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }
}
