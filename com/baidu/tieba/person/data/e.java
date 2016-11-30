package com.baidu.tieba.person.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.util.ArrayList;
import java.util.List;
import tbclient.DealWindow;
/* loaded from: classes.dex */
public class e {
    public TbPageContext GO;
    public ArrayList<v> Xk;
    public List<com.baidu.adp.widget.ListView.a> bRh;
    public boolean cAf;
    public CustomResponsedMessage<?> eKM;
    public v eKN;
    public int id;
    public UserData mUserData;
    public DealWindow window;

    public e(int i) {
        this.id = i;
    }

    public void aNX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }

    public boolean aUP() {
        return (this.window == null || !EcommSwitchStatic.GN() || x.t(this.window.list)) ? false : true;
    }
}
