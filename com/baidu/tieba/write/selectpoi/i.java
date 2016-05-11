package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity eZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectLocationActivity selectLocationActivity) {
        this.eZB = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        lVar = this.eZB.eZz;
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                lVar2 = this.eZB.eZz;
                Object item = lVar2.getItem(i);
                if (item instanceof a.C0077a) {
                    a.C0077a c0077a = (a.C0077a) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0077a.getName(), c0077a.getAddr(), c0077a.getSn()));
                    this.eZB.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            this.eZB.finish();
        }
    }
}
