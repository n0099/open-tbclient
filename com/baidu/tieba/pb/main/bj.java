package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends CustomMessageListener {
    final /* synthetic */ bi bBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bi biVar, int i) {
        super(i);
        this.bBt = biVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.tbadkCore.b.i iVar;
        List<DownloadData> data;
        com.baidu.tieba.tbadkCore.b.i iVar2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (customResponsedMessage != null) {
            iVar = this.bBt.bBg;
            if (iVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                iVar2 = this.bBt.bBg;
                ArrayList<com.baidu.tieba.tbadkCore.b.j> ahn = iVar2.ahn();
                if (ahn != null && ahn.size() != 0) {
                    Iterator<com.baidu.tieba.tbadkCore.b.j> it = ahn.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.b.j next = it.next();
                        if (next != null && next.aho() != null && !TextUtils.isEmpty(next.aho().apk_name)) {
                            com.baidu.tieba.tbadkCore.b.a aho = next.aho();
                            Iterator<DownloadData> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                DownloadData next2 = it2.next();
                                if (next2 != null && aho.apk_name.equals(next2.getId())) {
                                    int status = next2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.hJ(2);
                                        tbPageContext = this.bBt.mContext;
                                        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "down_success", null, 1, "app_name", next.ahu().Ds, next.ahu().Dr);
                                        com.baidu.tbadk.distribute.a.uU().a(next.ahu(), next.bYG, next.threadId, "PB", "down_success");
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.bf.isEmpty(next2.getStatusMsg())) {
                                            tbPageContext2 = this.bBt.mContext;
                                            com.baidu.adp.lib.util.l.showToast(tbPageContext2.getContext(), next2.getStatusMsg());
                                        }
                                        next.hJ(0);
                                    } else if (status == 1) {
                                        next.hJ(1);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bBt.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
