package com.baidu.tieba.pb.pb.main.a;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class f {
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.a.f.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.jFc != null) {
                f.this.jFc.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private com.baidu.tieba.f.a jFc;
    private BdTypeRecyclerView jRq;
    private com.baidu.tieba.pb.pb.adapter.b lTD;

    public f(BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.pb.pb.adapter.b bVar) {
        this.jRq = bdTypeRecyclerView;
        this.lTD = bVar;
        bdTypeRecyclerView.setOnTouchListener(this.bPd);
        this.jFc = new com.baidu.tieba.f.a();
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String str = "";
            if (fVar.getForum() != null) {
                str = fVar.getForum().getFirst_class();
            }
            List<ThreadInfo> djv = fVar.djv();
            LinkedList linkedList = new LinkedList();
            c(djv, linkedList, str);
            this.lTD.cC(linkedList);
        }
    }

    private void c(List<ThreadInfo> list, List<n> list2, String str) {
        String format;
        bz bzVar;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo != null) {
                bz bzVar2 = new bz();
                bzVar2.eKn = i2 + 1;
                bzVar2.a(threadInfo);
                if (bzVar2.bpo() != null) {
                    bzVar2.bpo().eNB = str;
                }
                if ((k.ad(bzVar2) || l.ad(bzVar2)) && bzVar2.getType() != bz.eOD) {
                    k aE = aE(bzVar2);
                    if (aE != null && (bzVar = aE.eHK) != null && bzVar.bpo() != null && !StringUtils.isNull(bzVar.bpo().forumName)) {
                        aE.tid = bzVar2.getTid();
                        aE.position = i;
                        h(aE);
                        list2.add(aE);
                    }
                    int[] imageWidthAndHeight = bzVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.b aD = aD(bzVar2);
                    if (aD != null) {
                        aD.tid = bzVar2.getTid();
                        aD.position = i;
                        if (aD instanceof k) {
                            if (bzVar2.boF() == 1) {
                                b(aD);
                                aD.eNX = imageWidthAndHeight[0];
                                aD.eNY = imageWidthAndHeight[1];
                            } else if (bzVar2.boF() >= 2) {
                                c(aD);
                            } else {
                                e(aD);
                            }
                        } else if (aD instanceof l) {
                            f(aD);
                        }
                    }
                    if (aD != null && aD.isValid()) {
                        aD.eHK.bmZ();
                        if (!bzVar2.bmg() && bzVar2.bnx() != null) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bzVar2.bnx().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bzVar2.bnx().getUserId()) { // from class: com.baidu.tieba.pb.pb.main.a.f.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    aq aj;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aD instanceof k) {
                                        aj = ((k) aD).crK();
                                    } else {
                                        aj = aD instanceof l ? ((l) aD).aj(null) : null;
                                    }
                                    TiebaStatic.log(aj);
                                }
                            }, 0, format.length() - 1, 33);
                            aD.eHK.a(spannableString);
                        }
                        list2.add(aD);
                    }
                    k aE2 = aE(bzVar2);
                    if (aE2 != null) {
                        aE2.tid = bzVar2.getTid();
                        aE2.position = i;
                        j(aE2);
                    }
                    if (aE2 != null && aE2.isValid()) {
                        list2.add(aE2);
                    }
                }
                i++;
            }
        }
    }

    private k aE(bz bzVar) {
        k kVar = new k();
        kVar.eHK = bzVar;
        kVar.isLinkThread = bzVar.isLinkThread();
        if (!bzVar.isLinkThread()) {
            kVar.ivl = bzVar.bnA();
        }
        kVar.ivm = true;
        return kVar;
    }

    private com.baidu.tieba.card.data.b aD(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        if (k.ad(bzVar)) {
            k kVar = new k();
            kVar.isLinkThread = bzVar.isLinkThread();
            kVar.eNQ = bzVar.boC();
            if (!bzVar.isLinkThread() && !bzVar.boC()) {
                kVar.ivl = bzVar.bnA();
            }
            kVar.eHK = bzVar;
            kVar.ivm = true;
            return kVar;
        } else if (l.ad(bzVar)) {
            return new l(bzVar);
        } else {
            return null;
        }
    }

    private void b(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).iuz = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void c(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).eNJ = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void e(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).eNG = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void f(com.baidu.tieba.card.data.b bVar) {
        ((l) bVar).iuA = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void h(com.baidu.tieba.card.data.b bVar) {
        bVar.eNW = true;
        bVar.setSupportType(BaseCardInfo.SupportType.TOP);
    }

    private void j(com.baidu.tieba.card.data.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).eNL = true;
        } else if (bVar instanceof l) {
            ((l) bVar).eNL = true;
        } else if (bVar instanceof j) {
            ((j) bVar).eNL = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
    }
}
