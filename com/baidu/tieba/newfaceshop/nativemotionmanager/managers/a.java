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
    private BdListView lDj;
    private MyEmotionHorizontalAdater lDk;
    private final List<C0814a> lDl;
    private c lDm;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lDn;

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, com.baidu.tieba.newfaceshop.nativemotionmanager.a.a aVar) {
        this.lDj = bdListView;
        this.lDm = new c(tbPageContext);
        this.lDm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lDj.addHeaderView(this.lDm.getView());
        this.caS = new ArrayList();
        this.lDl = new ArrayList();
        this.lDk = new MyEmotionHorizontalAdater(this.caS, this.lDl, tbPageContext);
        this.lDn = aVar;
        this.lDj.setAdapter((ListAdapter) this.lDk);
    }

    public void fa(List<EmotionPackageData> list) {
        if (this.lDj != null && this.lDk != null) {
            this.caS.clear();
            this.caS.addAll(list);
            djc();
            this.lDk.djf();
            this.lDm.t(Integer.valueOf(this.lDk.dje()));
            this.lDn.cW(0, this.lDk.dje());
            this.lDn.uv(com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().bLc());
            this.lDk.notifyDataSetChanged();
        }
    }

    private void djc() {
        C0814a c0814a;
        ArrayList arrayList = new ArrayList(this.lDl);
        this.lDl.clear();
        for (EmotionPackageData emotionPackageData : this.caS) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0814a = null;
                    break;
                }
                c0814a = (C0814a) it.next();
                if (c0814a != null && c0814a.id == emotionPackageData.id) {
                    break;
                }
            }
            if (c0814a == null) {
                c0814a = new C0814a();
                c0814a.id = emotionPackageData.id;
            }
            this.lDl.add(c0814a);
        }
    }

    public void cY(int i, int i2) {
        if (i >= 0 && i < this.caS.size() && i2 >= 0 && i2 < this.caS.size()) {
            this.caS.add(i2, this.caS.remove(i));
            this.lDl.add(i2, this.lDl.remove(i));
            this.lDk.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SWAP_MY_EMOTION_PACKAGE, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
        }
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0814a {
        public int id;
        public int lDo;
        public int lDp;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ").append(this.id).append(", ").append("firstVisibleItem: ").append(this.lDo).append(", ").append("padX: ").append(this.lDp);
            return sb.toString();
        }
    }

    public void update() {
        if (this.lDk != null && this.lDj != null && this.caS != null && this.lDm != null && this.lDn != null) {
            this.lDm.dja();
            this.lDn.cW(0, this.lDk.dje());
            this.lDn.uv(com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().bLc());
            this.lDk.notifyDataSetChanged();
        }
    }
}
