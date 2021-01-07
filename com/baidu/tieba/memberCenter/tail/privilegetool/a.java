package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.editortools.view.a {
    private LinkedList<h> fDI;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fDI = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher sw(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.fDI.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.fDI != null) {
            return this.fDI.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        sI(2);
        setHorizontalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        setPaddingLeft(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        setPaddingRight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        a(new a.InterfaceC0595a() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.a.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0595a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher sw = a.this.sw(i);
                if (sw.getLayoutParams() == null) {
                    sw.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return sw;
            }
        });
        bGa().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        this.fDI.clear();
        this.fDI = null;
    }
}
