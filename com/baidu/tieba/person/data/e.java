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
    public ArrayList<v> WM;
    public List<com.baidu.adp.widget.ListView.a> bOo;
    public boolean cuW;
    public CustomResponsedMessage<?> eEn;
    public v eEo;
    public int id;
    public UserData mUserData;
    public DealWindow window;

    public e(int i) {
        this.id = i;
    }

    public void aMe() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.ECOMM_PB_VIEW, this));
    }

    public boolean aSI() {
        return (this.window == null || !EcommSwitchStatic.GK() || y.t(this.window.list)) ? false : true;
    }
}
