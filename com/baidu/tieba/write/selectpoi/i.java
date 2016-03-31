package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity eIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectLocationActivity selectLocationActivity) {
        this.eIK = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        lVar = this.eIK.eII;
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                lVar2 = this.eIK.eII;
                Object item = lVar2.getItem(i);
                if (item instanceof a.C0085a) {
                    a.C0085a c0085a = (a.C0085a) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0085a.getName(), c0085a.aUc(), c0085a.aUb()));
                    this.eIK.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            this.eIK.finish();
        }
    }
}
