package com.baidu.tieba.person.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.util.ArrayList;
import java.util.List;
import tbclient.DealWindow;
/* loaded from: classes.dex */
public class e {
    public TbPageContext GM;
    public ArrayList<v> WC;
    public List<com.baidu.adp.widget.ListView.a> bOr;
    public boolean cuz;
    public CustomResponsedMessage<?> eCk;
    public v eCl;
    public int id;
    public UserData mUserData;
    public DealWindow window;

    public e(int i) {
        this.id = i;
    }

    public void aLC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }

    public boolean aSk() {
        return (this.window == null || !EcommSwitchStatic.GL() || y.t(this.window.list)) ? false : true;
    }
}
