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
    List<EmotionPackageData> caS;
    private BdListView lCV;
    private MyEmotionHorizontalAdater lCW;
    private final List<C0813a> lCX;
    private c lCY;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lCZ;

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, com.baidu.tieba.newfaceshop.nativemotionmanager.a.a aVar) {
        this.lCV = bdListView;
        this.lCY = new c(tbPageContext);
        this.lCY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lCV.addHeaderView(this.lCY.getView());
        this.caS = new ArrayList();
        this.lCX = new ArrayList();
        this.lCW = new MyEmotionHorizontalAdater(this.caS, this.lCX, tbPageContext);
        this.lCZ = aVar;
        this.lCV.setAdapter((ListAdapter) this.lCW);
    }

    public void fa(List<EmotionPackageData> list) {
        if (this.lCV != null && this.lCW != null) {
            this.caS.clear();
            this.caS.addAll(list);
            diV();
            this.lCW.diY();
            this.lCY.t(Integer.valueOf(this.lCW.diX()));
            this.lCZ.cV(0, this.lCW.diX());
            this.lCZ.uv(com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().bKX());
            this.lCW.notifyDataSetChanged();
        }
    }

    private void diV() {
        C0813a c0813a;
        ArrayList arrayList = new ArrayList(this.lCX);
        this.lCX.clear();
        for (EmotionPackageData emotionPackageData : this.caS) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0813a = null;
                    break;
                }
                c0813a = (C0813a) it.next();
                if (c0813a != null && c0813a.id == emotionPackageData.id) {
                    break;
                }
            }
            if (c0813a == null) {
                c0813a = new C0813a();
                c0813a.id = emotionPackageData.id;
            }
            this.lCX.add(c0813a);
        }
    }

    public void cX(int i, int i2) {
        if (i >= 0 && i < this.caS.size() && i2 >= 0 && i2 < this.caS.size()) {
            this.caS.add(i2, this.caS.remove(i));
            this.lCX.add(i2, this.lCX.remove(i));
            this.lCW.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
        }
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0813a {
        public int id;
        public int lDa;
        public int lDb;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(this.id).append(", ").append("firstVisibleItem: ").append(this.lDa).append(", ").append("padX: ").append(this.lDb);
            return sb.toString();
        }
    }

    public void update() {
        if (this.lCW != null && this.lCV != null && this.caS != null && this.lCY != null && this.lCZ != null) {
            this.lCY.diT();
            this.lCZ.cV(0, this.lCW.diX());
            this.lCZ.uv(com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().bKX());
            this.lCW.notifyDataSetChanged();
        }
    }
}
