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
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes2.dex */
public class g {
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.a.g.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.jMD != null) {
                g.this.jMD.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private com.baidu.tieba.f.a jMD;
    private BdTypeRecyclerView kbh;
    private com.baidu.tieba.pb.pb.adapter.b meZ;

    public g(BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.pb.pb.adapter.b bVar) {
        this.kbh = bdTypeRecyclerView;
        this.meZ = bVar;
        bdTypeRecyclerView.setOnTouchListener(this.bUt);
        this.jMD = new com.baidu.tieba.f.a();
    }

    public void H(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String str = "";
            if (fVar.getForum() != null) {
                str = fVar.getForum().getFirst_class();
            }
            List<ThreadInfo> dlX = fVar.dlX();
            LinkedList linkedList = new LinkedList();
            c(dlX, linkedList, str);
            this.meZ.cx(linkedList);
        }
    }

    private void c(List<ThreadInfo> list, List<n> list2, String str) {
        String format;
        cb cbVar;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo != null) {
                cb cbVar2 = new cb();
                cbVar2.eOa = i2 + 1;
                cbVar2.a(threadInfo);
                if (cbVar2.bpI() != null) {
                    cbVar2.bpI().eRo = str;
                }
                if ((k.ae(cbVar2) || l.ae(cbVar2)) && cbVar2.getType() != cb.eSq) {
                    k aF = aF(cbVar2);
                    if (aF != null && (cbVar = aF.eLr) != null && cbVar.bpI() != null && !StringUtils.isNull(cbVar.bpI().forumName)) {
                        aF.tid = cbVar2.getTid();
                        aF.position = i;
                        h(aF);
                        list2.add(aF);
                    }
                    int[] imageWidthAndHeight = cbVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.b aE = aE(cbVar2);
                    if (aE != null) {
                        aE.tid = cbVar2.getTid();
                        aE.position = i;
                        if (aE instanceof k) {
                            if (cbVar2.boZ() == 1) {
                                b(aE);
                                aE.eRK = imageWidthAndHeight[0];
                                aE.eRL = imageWidthAndHeight[1];
                            } else if (cbVar2.boZ() >= 2) {
                                c(aE);
                            } else {
                                e(aE);
                            }
                        } else if (aE instanceof l) {
                            f(aE);
                        }
                    }
                    if (aE != null && aE.isValid()) {
                        aE.eLr.bnu();
                        if (!cbVar2.bmB() && cbVar2.bnS() != null) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), cbVar2.bnS().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, cbVar2.bnS().getUserId()) { // from class: com.baidu.tieba.pb.pb.main.a.g.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    ar ak;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aE instanceof k) {
                                        ak = ((k) aE).ctj();
                                    } else {
                                        ak = aE instanceof l ? ((l) aE).ak(null) : null;
                                    }
                                    TiebaStatic.log(ak);
                                }
                            }, 0, format.length() - 1, 33);
                            aE.eLr.a(spannableString);
                        }
                        list2.add(aE);
                    }
                    k aF2 = aF(cbVar2);
                    if (aF2 != null) {
                        aF2.tid = cbVar2.getTid();
                        aF2.position = i;
                        j(aF2);
                    }
                    if (aF2 != null && aF2.isValid()) {
                        list2.add(aF2);
                    }
                }
                i++;
            }
        }
    }

    private k aF(cb cbVar) {
        k kVar = new k();
        kVar.eLr = cbVar;
        kVar.isLinkThread = cbVar.isLinkThread();
        if (!cbVar.isLinkThread()) {
            kVar.iCS = cbVar.bnV();
        }
        kVar.iCT = true;
        return kVar;
    }

    private com.baidu.tieba.card.data.b aE(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        if (k.ae(cbVar)) {
            k kVar = new k();
            kVar.isLinkThread = cbVar.isLinkThread();
            kVar.eRD = cbVar.boW();
            if (!cbVar.isLinkThread() && !cbVar.boW()) {
                kVar.iCS = cbVar.bnV();
            }
            kVar.eLr = cbVar;
            kVar.iCT = true;
            return kVar;
        } else if (l.ae(cbVar)) {
            return new l(cbVar);
        } else {
            return null;
        }
    }

    private void b(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).iCg = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void c(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).eRw = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void e(com.baidu.tieba.card.data.b bVar) {
        ((k) bVar).eRt = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void f(com.baidu.tieba.card.data.b bVar) {
        ((l) bVar).iCh = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    private void h(com.baidu.tieba.card.data.b bVar) {
        bVar.eRJ = true;
        bVar.setSupportType(BaseCardInfo.SupportType.TOP);
    }

    private void j(com.baidu.tieba.card.data.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).eRy = true;
        } else if (bVar instanceof l) {
            ((l) bVar).eRy = true;
        } else if (bVar instanceof j) {
            ((j) bVar).eRy = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
    }
}
