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
/* loaded from: classes9.dex */
public class a {
    List<EmotionPackageData> cbD;
    private c lzA;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lzB;
    private BdListView lzx;
    private MyEmotionHorizontalAdater lzy;
    private final List<C0829a> lzz;

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, com.baidu.tieba.newfaceshop.nativemotionmanager.a.a aVar) {
        this.lzx = bdListView;
        this.lzA = new c(tbPageContext);
        this.lzA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lzx.addHeaderView(this.lzA.getView());
        this.cbD = new ArrayList();
        this.lzz = new ArrayList();
        this.lzy = new MyEmotionHorizontalAdater(this.cbD, this.lzz, tbPageContext);
        this.lzB = aVar;
        this.lzx.setAdapter((ListAdapter) this.lzy);
    }

    public void fc(List<EmotionPackageData> list) {
        if (this.lzx != null && this.lzy != null) {
            this.cbD.clear();
            this.cbD.addAll(list);
            dkM();
            this.lzy.dkP();
            this.lzA.s(Integer.valueOf(this.lzy.dkO()));
            this.lzB.cY(0, this.lzy.dkO());
            this.lzB.um(com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv());
            this.lzy.notifyDataSetChanged();
        }
    }

    private void dkM() {
        C0829a c0829a;
        ArrayList arrayList = new ArrayList(this.lzz);
        this.lzz.clear();
        for (EmotionPackageData emotionPackageData : this.cbD) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0829a = null;
                    break;
                }
                c0829a = (C0829a) it.next();
                if (c0829a != null && c0829a.id == emotionPackageData.id) {
                    break;
                }
            }
            if (c0829a == null) {
                c0829a = new C0829a();
                c0829a.id = emotionPackageData.id;
            }
            this.lzz.add(c0829a);
        }
    }

    public void da(int i, int i2) {
        if (i >= 0 && i < this.cbD.size() && i2 >= 0 && i2 < this.cbD.size()) {
            this.cbD.add(i2, this.cbD.remove(i));
            this.lzz.add(i2, this.lzz.remove(i));
            this.lzy.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
        }
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0829a {
        public int id;
        public int lzC;
        public int lzD;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(this.id).append(", ").append("firstVisibleItem: ").append(this.lzC).append(", ").append("padX: ").append(this.lzD);
            return sb.toString();
        }
    }

    public void update() {
        if (this.lzy != null && this.lzx != null && this.cbD != null && this.lzA != null && this.lzB != null) {
            this.lzA.dkK();
            this.lzB.cY(0, this.lzy.dkO());
            this.lzB.um(com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv());
            this.lzy.notifyDataSetChanged();
        }
    }
}
