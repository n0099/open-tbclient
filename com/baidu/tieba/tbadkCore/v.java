package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LegoRequestConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v {
    public static Object nO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LegoRequestConfig legoRequestConfig = new LegoRequestConfig();
        legoRequestConfig.setRequestType(1);
        legoRequestConfig.setCard(str);
        CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_REQUEST);
        if (customMessageTask == null || customMessageTask.getRunnable() == null) {
            return null;
        }
        CustomMessage<?> customMessage = new CustomMessage<>(CmdConfigCustom.CMD_LEGO_REQUEST);
        customMessage.setData(legoRequestConfig);
        CustomResponsedMessage<?> run = customMessageTask.getRunnable().run(customMessage);
        if (run == null || run.getData() == null) {
            return null;
        }
        return ((com.baidu.tbadk.core.d.a) run.getData()).cardInfo;
    }

    public static int a(com.baidu.tbadk.core.data.x xVar) {
        if (xVar == null) {
            return 0;
        }
        LegoRequestConfig legoRequestConfig = new LegoRequestConfig();
        legoRequestConfig.setCardInfo(xVar.getCardInfo());
        legoRequestConfig.setRequestType(5);
        CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_REQUEST);
        if (customMessageTask == null || customMessageTask.getRunnable() == null) {
            return 0;
        }
        CustomMessage<?> customMessage = new CustomMessage<>(CmdConfigCustom.CMD_LEGO_REQUEST);
        customMessage.setData(legoRequestConfig);
        CustomResponsedMessage<?> run = customMessageTask.getRunnable().run(customMessage);
        if (run != null) {
            return ((com.baidu.tbadk.core.d.a) run.getData()).cardType;
        }
        return 0;
    }

    public static View a(TbPageContext tbPageContext, com.baidu.tbadk.core.data.x xVar) {
        if (xVar == null || tbPageContext == null) {
            return null;
        }
        LegoRequestConfig legoRequestConfig = new LegoRequestConfig();
        legoRequestConfig.setBusinessType(1);
        legoRequestConfig.setCardInfo(xVar.getCardInfo());
        legoRequestConfig.setTbPageContext(tbPageContext);
        legoRequestConfig.setRequestType(3);
        CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_REQUEST);
        if (customMessageTask == null || customMessageTask.getRunnable() == null) {
            return null;
        }
        CustomMessage<?> customMessage = new CustomMessage<>(CmdConfigCustom.CMD_LEGO_REQUEST);
        customMessage.setData(legoRequestConfig);
        CustomResponsedMessage<?> run = customMessageTask.getRunnable().run(customMessage);
        if (run == null || run.getData() == null) {
            return null;
        }
        return (View) ((com.baidu.tbadk.core.d.a) run.getData()).cardView;
    }

    public static void c(View view, Object obj) {
        if (view != null && obj != null) {
            LegoRequestConfig legoRequestConfig = new LegoRequestConfig();
            legoRequestConfig.setBusinessType(1);
            legoRequestConfig.setCardInfo(obj);
            legoRequestConfig.setCardView(view);
            legoRequestConfig.setRequestType(4);
            CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_REQUEST);
            if (customMessageTask != null && customMessageTask.getRunnable() != null) {
                CustomMessage<?> customMessage = new CustomMessage<>(CmdConfigCustom.CMD_LEGO_REQUEST);
                customMessage.setData(legoRequestConfig);
                customMessageTask.getRunnable().run(customMessage);
            }
        }
    }

    public static ArrayList<com.baidu.tbadk.core.data.x> b(com.baidu.tbadk.core.data.x xVar) {
        if (xVar == null) {
            return null;
        }
        LegoRequestConfig legoRequestConfig = new LegoRequestConfig();
        legoRequestConfig.setRequestType(2);
        legoRequestConfig.setBusinessType(1);
        legoRequestConfig.setCardInfo(xVar.getCardInfo());
        CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_REQUEST);
        if (customMessageTask == null || customMessageTask.getRunnable() == null) {
            return null;
        }
        CustomMessage<?> customMessage = new CustomMessage<>(CmdConfigCustom.CMD_LEGO_REQUEST);
        customMessage.setData(legoRequestConfig);
        CustomResponsedMessage<?> run = customMessageTask.getRunnable().run(customMessage);
        if (run == null || run.getData() == null) {
            return null;
        }
        ArrayList<Object> arrayList = ((com.baidu.tbadk.core.d.a) run.getData()).Uc;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.data.x> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            arrayList2.add((com.baidu.tbadk.core.data.x) arrayList.get(i2));
            i = i2 + 1;
        }
    }

    public static void ao(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i2 = 0;
            while (i2 < arrayList.size()) {
                if (arrayList.get(i2) instanceof com.baidu.tbadk.core.data.x) {
                    if (z2) {
                        if (!((com.baidu.tbadk.core.data.x) arrayList.get(i2)).isValid()) {
                            ((com.baidu.tbadk.core.data.x) arrayList.get(i2)).py();
                        }
                        if (((com.baidu.tbadk.core.data.x) arrayList.get(i2)).isValid()) {
                            ArrayList<com.baidu.tbadk.core.data.x> b = b((com.baidu.tbadk.core.data.x) arrayList.get(i2));
                            if (b == null || b.size() == 0) {
                                z = true;
                                i = 1;
                            } else {
                                arrayList.remove(i2);
                                arrayList.addAll(i2, b);
                                i = b.size();
                                z = false;
                            }
                        } else {
                            z = true;
                            i = 1;
                        }
                    } else {
                        z = true;
                        i = 1;
                    }
                    if (z) {
                        arrayList.remove(i2);
                        i = 0;
                    }
                } else {
                    i = 1;
                }
                i2 = i + i2;
            }
        }
    }
}
