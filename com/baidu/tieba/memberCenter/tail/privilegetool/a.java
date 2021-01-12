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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.editortools.view.a {
    private LinkedList<h> fza;

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(LinkedList<h> linkedList) {
        this.fza = linkedList;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DLauncher qQ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (DLauncher) this.fza.get(i);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public int getCount() {
        if (this.fza != null) {
            return this.fza.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void init(Context context) {
        setColumn(4);
        rc(2);
        setHorizontalSpacing(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        setPaddingLeft(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        setPaddingRight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        a(new a.InterfaceC0578a() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.a.1
            @Override // com.baidu.tbadk.editortools.view.a.InterfaceC0578a
            public View getView(int i, View view, ViewGroup viewGroup) {
                DLauncher qQ = a.this.qQ(i);
                if (qQ.getLayoutParams() == null) {
                    qQ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return qQ;
            }
        });
        bCh().c(this);
    }

    @Override // com.baidu.tbadk.editortools.view.a
    public void exit() {
        this.fza.clear();
        this.fza = null;
    }
}
