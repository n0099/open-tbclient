package com.baidu.tieba.pb.pb.main.a;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class f {
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.a.f.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.jxl != null) {
                f.this.jxl.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private BdTypeRecyclerView jIL;
    private com.baidu.tieba.g.a jxl;
    private com.baidu.tieba.pb.pb.a.c lSW;

    public f(BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.pb.pb.a.c cVar) {
        this.jIL = bdTypeRecyclerView;
        this.lSW = cVar;
        bdTypeRecyclerView.setOnTouchListener(this.fGd);
        this.jxl = new com.baidu.tieba.g.a();
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String str = "";
            if (fVar.getForum() != null) {
                str = fVar.getForum().getFirst_class();
            }
            List<ThreadInfo> dnD = fVar.dnD();
            LinkedList linkedList = new LinkedList();
            c(dnD, linkedList, str);
            this.lSW.cv(linkedList);
        }
    }

    private void c(List<ThreadInfo> list, List<q> list2, String str) {
        String format;
        by byVar;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo != null) {
                by byVar2 = new by();
                byVar2.eFi = i2 + 1;
                byVar2.a(threadInfo);
                if (byVar2.bqF() != null) {
                    byVar2.bqF().eIu = str;
                }
                if ((k.ad(byVar2) || l.ad(byVar2)) && byVar2.getType() != by.eJv) {
                    k aD = aD(byVar2);
                    if (aD != null && (byVar = aD.eCR) != null && byVar.bqF() != null && !StringUtils.isNull(byVar.bqF().forumName)) {
                        aD.tid = byVar2.getTid();
                        aD.position = i;
                        h(aD);
                        list2.add(aD);
                    }
                    int[] imageWidthAndHeight = byVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.b aC = aC(byVar2);
                    if (aC != null) {
                        aC.tid = byVar2.getTid();
                        aC.position = i;
                        if (aC instanceof k) {
                            if (byVar2.bpX() == 1) {
                                b(aC);
                                aC.eIP = imageWidthAndHeight[0];
                                aC.eIQ = imageWidthAndHeight[1];
                            } else if (byVar2.bpX() >= 2) {
                                c(aC);
                            } else {
                                e(aC);
                            }
                        } else if (aC instanceof l) {
                            f(aC);
                        }
                    }
                    if (aC != null && aC.isValid()) {
                        aC.eCR.bor();
                        if (!byVar2.bnz() && byVar2.boP() != null) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), byVar2.boP().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, byVar2.boP().getUserId()) { // from class: com.baidu.tieba.pb.pb.main.a.f.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    ar aj;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aC instanceof k) {
                                        aj = ((k) aC).csI();
                                    } else {
                                        aj = aC instanceof l ? ((l) aC).aj(null) : null;
                                    }
                                    TiebaStatic.log(aj);
                                }
                            }, 0, format.length() - 1, 33);
                            aC.eCR.a(spannableString);
                        }
                        list2.add(aC);
                    }
                    k aD2 = aD(byVar2);
                    if (aD2 != null) {
                        aD2.tid = byVar2.getTid();
                        aD2.position = i;
                        j(aD2);
                    }
                    if (aD2 != null && aD2.isValid()) {
                        list2.add(aD2);
                    }
                }
                i++;
            }
        }
    }

    private k aD(by byVar) {
        k kVar = new k();
        kVar.eCR = byVar;
        kVar.isLinkThread = byVar.isLinkThread();
        if (!byVar.isLinkThread()) {
            kVar.iny = byVar.boS();
        }
        kVar.inz = true;
        return kVar;
    }

    private com.baidu.tieba.card.data.b aC(by byVar) {
        if (byVar == null) {
            return null;
        }
        if (k.ad(byVar)) {
            k kVar = new k();
            kVar.isLinkThread = byVar.isLinkThread();
            kVar.eII = byVar.bpU();
            if (!byVar.isLinkThread() && !byVar.bpU()) {
                kVar.iny = byVar.boS();
            }
            kVar.eCR = byVar;
            kVar.inz = true;
            return kVar;
        } else if (l.ad(byVar)) {
            return new l(byVar);
        } else {
            return null;
        }
    }

    private void b(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).imL = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        bVar.forceNoTest = true;
    }

    private void c(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).eIC = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        bVar.forceNoTest = true;
    }

    private void e(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).eIz = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        bVar.forceNoTest = true;
    }

    private void f(com.baidu.tieba.card.data.b bVar) {
        ((l) bVar).imM = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        bVar.forceNoTest = true;
    }

    private void h(com.baidu.tieba.card.data.b bVar) {
        bVar.eIO = true;
        bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        bVar.forceNoTest = true;
    }

    private void j(com.baidu.tieba.card.data.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).eIE = true;
        } else if (bVar instanceof l) {
            ((l) bVar).eIE = true;
        } else if (bVar instanceof j) {
            ((j) bVar).eIE = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        bVar.forceNoTest = true;
    }
}
