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
    List<EmotionPackageData> ccu;
    private BdListView lFl;
    private MyEmotionHorizontalAdater lFm;
    private final List<C0820a> lFn;
    private c lFo;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lFp;

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, com.baidu.tieba.newfaceshop.nativemotionmanager.a.a aVar) {
        this.lFl = bdListView;
        this.lFo = new c(tbPageContext);
        this.lFo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lFl.addHeaderView(this.lFo.getView());
        this.ccu = new ArrayList();
        this.lFn = new ArrayList();
        this.lFm = new MyEmotionHorizontalAdater(this.ccu, this.lFn, tbPageContext);
        this.lFp = aVar;
        this.lFl.setAdapter((ListAdapter) this.lFm);
    }

    public void fa(List<EmotionPackageData> list) {
        if (this.lFl != null && this.lFm != null) {
            this.ccu.clear();
            this.ccu.addAll(list);
            djl();
            this.lFm.djo();
            this.lFo.t(Integer.valueOf(this.lFm.djn()));
            this.lFp.cW(0, this.lFm.djn());
            this.lFp.uv(com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().bLg());
            this.lFm.notifyDataSetChanged();
        }
    }

    private void djl() {
        C0820a c0820a;
        ArrayList arrayList = new ArrayList(this.lFn);
        this.lFn.clear();
        for (EmotionPackageData emotionPackageData : this.ccu) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0820a = null;
                    break;
                }
                c0820a = (C0820a) it.next();
                if (c0820a != null && c0820a.id == emotionPackageData.id) {
                    break;
                }
            }
            if (c0820a == null) {
                c0820a = new C0820a();
                c0820a.id = emotionPackageData.id;
            }
            this.lFn.add(c0820a);
        }
    }

    public void cY(int i, int i2) {
        if (i >= 0 && i < this.ccu.size() && i2 >= 0 && i2 < this.ccu.size()) {
            this.ccu.add(i2, this.ccu.remove(i));
            this.lFn.add(i2, this.lFn.remove(i));
            this.lFm.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
        }
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0820a {
        public int id;
        public int lFq;
        public int lFr;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(this.id).append(", ").append("firstVisibleItem: ").append(this.lFq).append(", ").append("padX: ").append(this.lFr);
            return sb.toString();
        }
    }

    public void update() {
        if (this.lFm != null && this.lFl != null && this.ccu != null && this.lFo != null && this.lFp != null) {
            this.lFo.djj();
            this.lFp.cW(0, this.lFm.djn());
            this.lFp.uv(com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().bLg());
            this.lFm.notifyDataSetChanged();
        }
    }
}
