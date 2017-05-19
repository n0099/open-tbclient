package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements at {
    final /* synthetic */ ac fNP;
    private final /* synthetic */ String fNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ac acVar, String str) {
        this.fNP = acVar;
        this.fNQ = str;
    }

    @Override // com.baidu.tieba.write.album.at
    public void lm() {
    }

    @Override // com.baidu.tieba.write.album.at
    public void a(List<e> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        AlbumActivity albumActivity;
        TextView textView2;
        p pVar;
        p pVar2;
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.x.r(list2)) {
            arrayList.addAll(list2);
        }
        if (!this.fNQ.equals("-1")) {
            textView = this.fNP.bKb;
            textView.setText(str);
            this.fNP.bmB();
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.r(list)) {
                arrayList2.addAll(list);
            }
            e eVar = new e();
            eVar.qR("-1");
            albumActivity = this.fNP.fMg;
            String string = albumActivity.getPageContext().getString(w.l.write_album_all);
            eVar.setName(string);
            eVar.qS(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                eVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, eVar);
            textView2 = this.fNP.bKb;
            textView2.setText(string);
            pVar = this.fNP.fLQ;
            pVar.cO(arrayList2);
            pVar2 = this.fNP.fLQ;
            pVar2.cP(arrayList);
        }
        this.fNP.setData(arrayList);
    }
}
