package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements at {
    final /* synthetic */ ac ggh;
    private final /* synthetic */ String ggi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ac acVar, String str) {
        this.ggh = acVar;
        this.ggi = str;
    }

    @Override // com.baidu.tieba.write.album.at
    public void onPreLoad() {
    }

    @Override // com.baidu.tieba.write.album.at
    public void a(List<e> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        AlbumActivity albumActivity;
        TextView textView2;
        p pVar;
        p pVar2;
        ArrayList arrayList = new ArrayList();
        if (!com.baidu.tbadk.core.util.z.t(list2)) {
            arrayList.addAll(list2);
        }
        if (!this.ggi.equals("-1")) {
            textView = this.ggh.bWL;
            textView.setText(str);
            this.ggh.bsv();
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.z.t(list)) {
                arrayList2.addAll(list);
            }
            e eVar = new e();
            eVar.sd("-1");
            albumActivity = this.ggh.gex;
            String string = albumActivity.getPageContext().getString(w.l.write_album_all);
            eVar.setName(string);
            eVar.se(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                eVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, eVar);
            textView2 = this.ggh.bWL;
            textView2.setText(string);
            pVar = this.ggh.gei;
            pVar.df(arrayList2);
            pVar2 = this.ggh.gei;
            pVar2.dg(arrayList);
        }
        this.ggh.setData(arrayList);
    }
}
