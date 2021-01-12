package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.util.Pair;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    List<EmotionPackageData> bWQ;
    private BdListView luR;
    private MyEmotionHorizontalAdater luS;
    private final List<C0812a> luT;
    private c luU;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a luV;

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, com.baidu.tieba.newfaceshop.nativemotionmanager.a.a aVar) {
        this.luR = bdListView;
        this.luU = new c(tbPageContext);
        this.luU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.luR.addHeaderView(this.luU.getView());
        this.bWQ = new ArrayList();
        this.luT = new ArrayList();
        this.luS = new MyEmotionHorizontalAdater(this.bWQ, this.luT, tbPageContext);
        this.luV = aVar;
        this.luR.setAdapter((ListAdapter) this.luS);
    }

    public void fc(List<EmotionPackageData> list) {
        if (this.luR != null && this.luS != null) {
            this.bWQ.clear();
            this.bWQ.addAll(list);
            dgU();
            this.luS.dgX();
            this.luU.s(Integer.valueOf(this.luS.dgW()));
            this.luV.cY(0, this.luS.dgW());
            this.luV.ui(com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD());
            this.luS.notifyDataSetChanged();
        }
    }

    private void dgU() {
        C0812a c0812a;
        ArrayList arrayList = new ArrayList(this.luT);
        this.luT.clear();
        for (EmotionPackageData emotionPackageData : this.bWQ) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0812a = null;
                    break;
                }
                c0812a = (C0812a) it.next();
                if (c0812a != null && c0812a.id == emotionPackageData.id) {
                    break;
                }
            }
            if (c0812a == null) {
                c0812a = new C0812a();
                c0812a.id = emotionPackageData.id;
            }
            this.luT.add(c0812a);
        }
    }

    public void da(int i, int i2) {
        if (i >= 0 && i < this.bWQ.size() && i2 >= 0 && i2 < this.bWQ.size()) {
            this.bWQ.add(i2, this.bWQ.remove(i));
            this.luT.add(i2, this.luT.remove(i));
            this.luS.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
        }
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0812a {
        public int id;
        public int luW;
        public int luX;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(this.id).append(", ").append("firstVisibleItem: ").append(this.luW).append(", ").append("padX: ").append(this.luX);
            return sb.toString();
        }
    }

    public void update() {
        if (this.luS != null && this.luR != null && this.bWQ != null && this.luU != null && this.luV != null) {
            this.luU.dgS();
            this.luV.cY(0, this.luS.dgW());
            this.luV.ui(com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD());
            this.luS.notifyDataSetChanged();
        }
    }
}
