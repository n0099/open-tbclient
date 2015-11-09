package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity dnE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectLocationActivity selectLocationActivity) {
        this.dnE = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        lVar = this.dnE.dnC;
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                lVar2 = this.dnE.dnC;
                Object item = lVar2.getItem(i);
                if (item instanceof a.C0078a) {
                    a.C0078a c0078a = (a.C0078a) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0078a.getName(), c0078a.ayq(), c0078a.ayp()));
                    this.dnE.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            this.dnE.finish();
        }
    }
}
