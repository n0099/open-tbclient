package com.baidu.tieba.im.util;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import com.baidu.tieba.im.model.RequestGroupLocModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private RequestGroupLocModel eJH;
    private a eJI;
    private double longitude = 0.0d;
    private double latitude = 0.0d;
    private BdUniqueId unique_id = null;
    private final a.InterfaceC0014a locationCallBack = new a.InterfaceC0014a() { // from class: com.baidu.tieba.im.util.b.1
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            switch (i) {
                case 0:
                    if (address != null) {
                        b.this.latitude = address.getLatitude();
                        b.this.longitude = address.getLongitude();
                        b.this.eJH.setLat(String.valueOf(address.getLatitude()));
                        b.this.eJH.setLng(String.valueOf(address.getLongitude()));
                        b.this.eJH.setGroupId(0L);
                        b.this.eJH.sendMessage();
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    b.this.eJI.aKJ();
                    return;
                case 4:
                case 5:
                    b.this.eJI.aKI();
                    return;
                default:
                    return;
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eJJ = new com.baidu.adp.framework.listener.c(103010) { // from class: com.baidu.tieba.im.util.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
                b.this.eJI.aKI();
            } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
                b.this.eJI.aKI();
            } else {
                ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
                if (responseRequestGroupLocMessage.getError() != 0) {
                    b.this.eJI.aKI();
                    return;
                }
                Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
                ArrayList arrayList = new ArrayList();
                while (iteraotrOfBusinessAreaList.hasNext()) {
                    arrayList.add(iteraotrOfBusinessAreaList.next());
                }
                String position = responseRequestGroupLocMessage.getPosition();
                if ((position == null || position.equals("")) && arrayList.size() < 1) {
                    b.this.eJI.aKI();
                } else {
                    b.this.eJI.a(position, arrayList, b.this.latitude, b.this.longitude);
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, List<String> list, double d, double d2);

        void aKI();

        void aKJ();
    }

    public b(a aVar) {
        this.eJH = null;
        this.eJI = null;
        this.eJH = new RequestGroupLocModel();
        this.eJI = aVar;
        this.eJJ.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.eJJ);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.eJH.setUniqueId(bdUniqueId);
    }

    public void Og() {
        com.baidu.adp.lib.d.a.iH().a(true, this.locationCallBack);
    }

    public void cancelLoad() {
        this.eJH.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eJJ);
    }
}
